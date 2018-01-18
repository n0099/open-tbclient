package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.m;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bd> implements u {
    private TbPageContext<?> aQp;
    private bd aXU;
    private g.f bNn;
    private g.b bNo;
    private String bOE;
    private View bOk;
    private com.baidu.tieba.play.j bYI;
    private QuickVideoView.b bYO;
    private ImageView bYt;
    private Animation bYx;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private ThreadGodReplyLayout cSp;
    private View cTB;
    private int cTC;
    private int cTD;
    private boolean cTE;
    private Handler cTI;
    private VideoLoadingProgressView.a cTJ;
    private TbImageView.a cTK;
    private Runnable cTL;
    private Runnable cTM;
    private j.a cTQ;
    private Animation.AnimationListener cTR;
    private TbImageView cTl;
    private TextView cTm;
    private View.OnClickListener cTq;
    public FrameLayout cTs;
    private QuickVideoView cTt;
    private com.baidu.tieba.play.g cTu;
    private TextView cTv;
    private TextView cTx;
    private View cTy;
    private y cTz;
    private LinearLayout cVq;
    private n cWv;
    private RelativeLayout ciJ;
    public ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    public View ciM;
    public LinearLayout cjI;
    public ThreadSkinView cjJ;
    private HeadPendantClickableView cju;
    public TextView dIl;
    public LinearLayout dIm;
    private com.baidu.tieba.frs.f.g dIn;
    private ViewTreeObserver.OnGlobalLayoutListener dIo;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        if (this.cTu != null) {
            try {
                this.cTt.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cTC = 0;
        this.cTD = 1;
        this.cTE = false;
        this.cTI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case HttpStatus.SC_ACCEPTED /* 202 */:
                        a.this.akm();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.akn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bNn = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cTu = gVar;
                a.this.cTu.setVolume(0.0f, 0.0f);
                a.this.cTz.bkB();
            }
        };
        this.bNo = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ako();
                a.this.i(true, 4);
                return true;
            }
        };
        this.cTJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.akj();
            }
        };
        this.cTK = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && a.this.cTl != null) {
                    a.this.cTl.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dIo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cTs != null && a.this.cTs.getLayoutParams() != null && a.this.cTs.getVisibility() != 8) {
                    a.this.cTs.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cTs.getLayoutParams();
                    if (a.this.cTs.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cTs.getWidth() * 0.5625d);
                        a.this.cTs.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cTL = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cTt != null && !a.this.cTt.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cTM = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.ako();
                a.this.i(true, 4);
            }
        };
        this.bYO = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cTq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXU != null && !StringUtils.isNull(a.this.aXU.yY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.aQp.getPageActivity()).createNormalCfg(a.this.aXU.yY(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bbR != null) {
                        a.this.bbR.onClick(view);
                    }
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akb() != null) {
                    a.this.akb().a(view, a.this.aXU);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXU != null && a.this.akb() != null) {
                    a.this.akb().a(view, a.this.aXU);
                }
            }
        };
        this.cTQ = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // com.baidu.tieba.play.j.a
            public void akr() {
                a.this.akk();
            }
        };
        this.cTR = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cTD == 3 && a.this.cTl != null) {
                    a.this.cTl.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.aQp = tbPageContext;
        View view = getView();
        this.bOk = view.findViewById(d.g.divider_line);
        this.ciJ = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.dIm = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.ciJ.setOnClickListener(this);
        this.cju = (HeadPendantClickableView) this.ciJ.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.ds70));
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.dIl = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.dIl.setVisibility(8);
        this.dIl.setOnClickListener(this.cTq);
        this.cTz = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cTz.setLoadingAnimationListener(this.cTJ);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.ciL.setForumAfterClickListener(this.bbR);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.ciK.setFrom(3);
        this.ciM = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setShareVisible(true);
        this.ciL.setShareReportFrom(1);
        this.ciL.setStType("frs_page");
        this.ciL.setFrom(2);
        this.ciL.bbP = 3;
        this.cTs = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cTs.setOnClickListener(this);
        this.cTs.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cTs != null) {
                    a.this.cTs.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dIo);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cTs != null) {
                    a.this.cTs.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dIo);
                }
            }
        });
        this.cTl = (TbImageView) view.findViewById(d.g.image_video);
        this.cTl.setPageId(getTag());
        this.cTl.setDefaultErrorResource(0);
        this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTl.setEvent(this.cTK);
        this.cTl.setGifIconSupport(false);
        this.bYt = (ImageView) view.findViewById(d.g.image_video_play);
        this.cTt = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cWv = new n(this.aQp.getPageActivity());
        this.cTt.setBusiness(this.cWv);
        this.cTt.setOnPreparedListener(this.bNn);
        this.cTt.setOnErrorListener(this.bNo);
        this.cTt.setOnSurfaceDestroyedListener(this.bYO);
        this.bYI = new com.baidu.tieba.play.j();
        this.bYI.setPlayer(this.cTt);
        this.bYI.a(this.cTQ);
        this.cTB = view.findViewById(d.g.auto_video_black_mask);
        this.cTx = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cTy = view.findViewById(d.g.auto_video_error_background);
        this.cjI = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cjJ = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bYx = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.fade_out_video_cover);
        this.bYx.setAnimationListener(this.cTR);
        this.cTv = (TextView) view.findViewById(d.g.text_video_duration);
        this.cTm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cVq = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dIn = new com.baidu.tieba.frs.f.g(tbPageContext, this.ciJ);
        this.dIn.setUniqueId(getTag());
        this.cSp = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cSp.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ciJ || view == this.ciL.getCommentNumView() || view == this.dIm) {
            bD(this.ciJ);
        } else if (view == this.cTs) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bO(this.cTs);
            } else {
                bD(this.cTs);
            }
        } else if (view == this.cSp) {
            bD(this.cSp);
        }
        if (this.aXU != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aXU));
        }
    }

    private void bO(View view) {
        if (this.aXU != null) {
            ak akVar = new ak("c11100");
            akVar.ab("tid", this.aXU.getId());
            akVar.ab(ImageViewerConfig.FORUM_ID, this.aXU.getFid() + "");
            TiebaStatic.log(akVar);
        }
        if (akb() != null) {
            akb().a(view, this.aXU);
        }
        if (view == this.cTs) {
            if (!com.baidu.adp.lib.util.j.oI()) {
                com.baidu.adp.lib.util.l.showToast(this.aQp.getPageActivity(), d.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQp.getPageActivity());
                aVar.cZ(this.aQp.getString(d.j.enter_video_center_page_no_wifi_tip));
                aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.akl();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.aV(true);
                aVar.b(this.mTbPageContext).AA();
            } else {
                akl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQp.getPageActivity(), "frs", this.aXU.getTid(), com.baidu.tieba.card.k.yI(), "")));
    }

    private void bD(View view) {
        if (this.aXU != null) {
            if (this.aXU.zK()) {
                TiebaStatic.log(new ak("c10242").ab(ImageViewerConfig.FORUM_ID, String.valueOf(this.aXU.getFid())).s("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ab("tid", this.aXU.getId());
                akVar.ab(ImageViewerConfig.FORUM_ID, this.aXU.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.aXU.yS() != null && this.aXU.yS().getGodUserData() != null && this.aXU.yS().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", this.aXU.getId()));
            }
        }
        if (akb() != null) {
            akb().a(view, this.aXU);
        }
        if (this.aXU != null) {
            com.baidu.tieba.card.k.kc(this.aXU.getId());
            aj.e(this.mTextTitle, d.C0107d.cp_cont_d, 1);
            t.ha(this.aXU.getId());
            if (this.aXU.zp() > 0 && com.baidu.tieba.tbadkCore.util.f.bwI()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aQp.getPageActivity()).createHistoryCfg(this.aXU.getTid(), String.valueOf(this.aXU.zp()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.aXU.zK() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aXU.zT());
                createHistoryCfg.setSmartFrsPosition(this.aXU.Aa());
                createHistoryCfg.setForumId(String.valueOf(this.aXU.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cSp) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aQp.getPageActivity()).createFromThreadCfg(this.aXU, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aXU.zK() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aXU.zT());
            createFromThreadCfg.setSmartFrsPosition(this.aXU.Aa());
            createFromThreadCfg.setForumId(String.valueOf(this.aXU.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cSp) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aQp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        this.aXU = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akm() {
        this.cTI.removeMessages(HttpStatus.SC_ACCEPTED);
        if (this.cTt.getCurrentPosition() > 0) {
            i(true, 3);
            this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cTI.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cTt.getCurrentPosition();
        if (currentPosition != this.cTC) {
            this.cTC = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cTI.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bYt != null && this.cTl != null && this.cTB != null && this.cTz != null && this.cTy != null && this.cTx != null) {
            if (z || this.cTD != i) {
                this.cTD = i;
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTM);
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTL);
                if (i == 2) {
                    this.bYt.setVisibility(8);
                    this.bYx.cancel();
                    this.cTl.clearAnimation();
                    this.cTl.setVisibility(0);
                    this.cTB.setVisibility(0);
                    this.cVq.setVisibility(0);
                    this.cTz.startLoading();
                    this.cTy.setVisibility(8);
                    this.cTx.setVisibility(8);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cTM, 60000L);
                } else if (i == 3) {
                    this.bYt.setVisibility(8);
                    this.cTl.startAnimation(this.bYx);
                    this.cTB.setVisibility(8);
                    this.cVq.setVisibility(8);
                    this.cTz.bkC();
                    this.cTy.setVisibility(8);
                    this.cTx.setVisibility(8);
                } else if (i == 4) {
                    this.bYt.setVisibility(8);
                    this.cTl.startAnimation(this.bYx);
                    this.cTB.setVisibility(8);
                    this.cTz.bkD();
                    this.cTy.setVisibility(0);
                    this.cTx.setVisibility(0);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cTL, 2000L);
                } else {
                    this.bYt.setVisibility(0);
                    this.cVq.setVisibility(0);
                    this.bYx.cancel();
                    this.cTl.clearAnimation();
                    this.cTl.setVisibility(0);
                    this.cTB.setVisibility(0);
                    this.cTz.bkD();
                    this.cTy.setVisibility(8);
                    this.cTx.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.aXU == null || this.aXU.yS() == null) {
            this.ciJ.setVisibility(8);
            return;
        }
        this.ciJ.setVisibility(0);
        akq();
        this.aXU.h(false, true);
        SpannableStringBuilder zs = this.aXU.zs();
        if (this.aXU.zy() && !StringUtils.isNull(this.aXU.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aXU.getTid();
            zs.append((CharSequence) this.aXU.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0107d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new m(zs));
        this.mTextTitle.setText(zs);
        this.dIn.T(this.aXU);
        this.ciK.setData(this.aXU);
        if (this.ciK.getHeaderImg() != null) {
            if (this.ciK.getIsSimpleThread()) {
                this.ciK.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (this.aXU.yS() == null || this.aXU.yS().getPendantData() == null || StringUtils.isNull(this.aXU.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ciK.getHeaderImg().setVisibility(0);
                this.ciK.getHeaderImg().setData(this.aXU);
            } else {
                this.ciK.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(this.aXU);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.ciL.setLayoutParams(layoutParams);
        this.ciK.setUserAfterClickListener(this.bce);
        if (this.ciL.setData(this.aXU)) {
            this.ciM.setVisibility(8);
        } else {
            this.ciM.setVisibility(0);
        }
        this.cTv.setText(am.fV(this.aXU.zk().video_duration.intValue() * 1000));
        this.cTm.setText(String.format(this.aQp.getResources().getString(d.j.play_count), am.J(this.aXU.zk().play_count.intValue())));
        this.cSp.setData(this.aXU.Ag());
        this.cSp.onChangeSkinType();
        if (com.baidu.tieba.card.k.kd(this.aXU.getId())) {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_d, 1);
            com.baidu.tieba.card.k.a(this.cSp.getGodReplyContent(), this.aXU.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
        } else {
            aj.e(this.mTextTitle, d.C0107d.cp_cont_b, 1);
        }
        d(this.aQp, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ako() {
        this.cTI.removeMessages(HttpStatus.SC_ACCEPTED);
        this.cTI.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void akp() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTL);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cTM);
    }

    private void akq() {
        akp();
        ako();
        if (this.cTl != null && this.cTs != null && this.cTt != null) {
            if (com.baidu.tbadk.core.i.wA().wG() && this.aXU != null && this.aXU.zk() != null) {
                this.cTs.setVisibility(0);
                this.cTl.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cTl.startLoad(this.aXU.zk().thumbnail_url, 10, false);
                stopPlay();
                this.bOE = this.aXU.zk().video_url;
                if (StringUtils.isNull(this.bOE)) {
                    i(true, 4);
                    TiebaStatic.log(new ak("c12026").ab("tid", this.aXU.getId()));
                }
                if (this.cWv != null && this.cWv.bkl() != null) {
                    this.cWv.bkl().d(this.aXU.zk());
                    return;
                }
                return;
            }
            this.cTs.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciJ, d.f.addresslist_item_bg);
            aj.c(this.bYt, d.f.btn_icon_play_video_n);
            aj.r(this.cTx, d.C0107d.cp_cont_i);
            aj.r(this.cTv, d.C0107d.cp_cont_i);
            aj.r(this.cTm, d.C0107d.cp_cont_i);
            aj.t(this.cTy, d.C0107d.common_color_10014);
            aj.t(this.bOk, d.C0107d.cp_bg_line_e);
            if (this.cTx != null) {
                this.cTx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ciL.onChangeSkinType();
            this.mSkinType = i;
            this.ciK.onChangeSkinType();
            this.dIn.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cTE;
    }

    public boolean isPlaying() {
        if (this.cTt == null) {
            return false;
        }
        return this.cTt.isPlaying();
    }

    public void startPlay() {
        if (!this.cTE && this.aXU != null && this.aXU.zk() != null && this.cTt != null && com.baidu.tbadk.util.y.p(2, this.bOE)) {
            i(true, 2);
            if (StringUtils.isNull(this.bOE)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "frs").ab("tid", this.aXU.getId()));
                this.bOE = this.aXU.zk().video_url;
            }
            this.cTt.bO(this.bOE, this.aXU.getId());
            this.cTt.setLooping(true);
            if (this.bYI != null) {
                this.bYI.start();
            }
            this.cTE = true;
            akk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akk() {
        if (this.aXU != null && this.aXU.zk() != null) {
            String str = this.aXU.zK() ? "floor5" : "frs";
            aa aaVar = new aa();
            aaVar.mLocate = str;
            aaVar.bAT = this.aXU.getTid();
            aaVar.cWM = this.aXU.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.aXU.mRecomSource;
            aaVar.gtV = this.aXU.mRecomAbTag;
            aaVar.gtW = this.aXU.mRecomWeight;
            aaVar.gtX = "";
            aaVar.gtZ = this.aXU.zk().video_md5;
            com.baidu.tieba.play.l.a(this.aXU.zk().video_md5, "", "1", aaVar);
        }
    }

    public void stopPlay() {
        akp();
        ako();
        i(true, 1);
        if (this.cTt != null) {
            this.cTt.stopPlayback();
            if (this.bYI != null) {
                this.bYI.stop();
            }
        }
        this.cTE = false;
    }

    public ThreadCommentAndPraiseInfoLayout akG() {
        return this.ciL;
    }

    public View getVideoContainer() {
        return this.cTs;
    }

    public String getPlayUrl() {
        return this.bOE;
    }

    public int getCurrentPosition() {
        if (this.cTt == null) {
            return 0;
        }
        return this.cTt.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cWv != null) {
            this.cWv.setVideoStatsData(aaVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciL != null && this.ciK != null) {
            this.ciK.setPageUniqueId(bdUniqueId);
        }
    }
}
