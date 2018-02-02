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
    private TbPageContext<?> aQs;
    private bd aYc;
    private g.f bNv;
    private g.b bNw;
    private String bON;
    private View bOs;
    private ImageView bYB;
    private Animation bYF;
    private com.baidu.tieba.play.j bYQ;
    private QuickVideoView.b bYW;
    private final View.OnClickListener bbZ;
    private final View.OnClickListener bcm;
    private ThreadGodReplyLayout cSK;
    private TbImageView cTG;
    private TextView cTH;
    private View.OnClickListener cTL;
    public FrameLayout cTN;
    private QuickVideoView cTO;
    private com.baidu.tieba.play.g cTP;
    private TextView cTQ;
    private TextView cTS;
    private View cTT;
    private y cTU;
    private View cTW;
    private int cTX;
    private int cTY;
    private boolean cTZ;
    private Handler cUd;
    private VideoLoadingProgressView.a cUe;
    private TbImageView.a cUf;
    private Runnable cUg;
    private Runnable cUh;
    private j.a cUl;
    private Animation.AnimationListener cUm;
    private LinearLayout cVL;
    private n cWQ;
    private RelativeLayout ciR;
    public ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    public View ciU;
    private HeadPendantClickableView cjC;
    public LinearLayout cjQ;
    public ThreadSkinView cjR;
    public TextView dIG;
    public LinearLayout dIH;
    private com.baidu.tieba.frs.f.g dII;
    private ViewTreeObserver.OnGlobalLayoutListener dIJ;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void ako() {
        if (this.cTP != null) {
            try {
                this.cTO.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cTX = 0;
        this.cTY = 1;
        this.cTZ = false;
        this.cUd = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case HttpStatus.SC_ACCEPTED /* 202 */:
                        a.this.akr();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.aks();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bNv = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cTP = gVar;
                a.this.cTP.setVolume(0.0f, 0.0f);
                a.this.cTU.bkC();
            }
        };
        this.bNw = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.akt();
                a.this.i(true, 4);
                return true;
            }
        };
        this.cUe = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.ako();
            }
        };
        this.cUf = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && a.this.cTG != null) {
                    a.this.cTG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dIJ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cTN != null && a.this.cTN.getLayoutParams() != null && a.this.cTN.getVisibility() != 8) {
                    a.this.cTN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cTN.getLayoutParams();
                    if (a.this.cTN.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cTN.getWidth() * 0.5625d);
                        a.this.cTN.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cUg = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cTO != null && !a.this.cTO.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cUh = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.akt();
                a.this.i(true, 4);
            }
        };
        this.bYW = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cTL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aYc != null && !StringUtils.isNull(a.this.aYc.yZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.aQs.getPageActivity()).createNormalCfg(a.this.aYc.yZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bbZ != null) {
                        a.this.bbZ.onClick(view);
                    }
                }
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akg() != null) {
                    a.this.akg().a(view, a.this.aYc);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aYc != null && a.this.akg() != null) {
                    a.this.akg().a(view, a.this.aYc);
                }
            }
        };
        this.cUl = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // com.baidu.tieba.play.j.a
            public void akw() {
                a.this.akp();
            }
        };
        this.cUm = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cTY == 3 && a.this.cTG != null) {
                    a.this.cTG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.aQs = tbPageContext;
        View view = getView();
        this.bOs = view.findViewById(d.g.divider_line);
        this.ciR = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.dIH = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.ciR.setOnClickListener(this);
        this.cjC = (HeadPendantClickableView) this.ciR.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.ds70));
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.dIG = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.dIG.setVisibility(8);
        this.dIG.setOnClickListener(this.cTL);
        this.cTU = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cTU.setLoadingAnimationListener(this.cUe);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.ciT.setForumAfterClickListener(this.bbZ);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.ciS.setFrom(3);
        this.ciU = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setShareVisible(true);
        this.ciT.setShareReportFrom(1);
        this.ciT.setStType("frs_page");
        this.ciT.setFrom(2);
        this.ciT.bbX = 3;
        this.cTN = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cTN.setOnClickListener(this);
        this.cTN.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cTN != null) {
                    a.this.cTN.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dIJ);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cTN != null) {
                    a.this.cTN.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dIJ);
                }
            }
        });
        this.cTG = (TbImageView) view.findViewById(d.g.image_video);
        this.cTG.setPageId(getTag());
        this.cTG.setDefaultErrorResource(0);
        this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cTG.setEvent(this.cUf);
        this.cTG.setGifIconSupport(false);
        this.bYB = (ImageView) view.findViewById(d.g.image_video_play);
        this.cTO = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cWQ = new n(this.aQs.getPageActivity());
        this.cTO.setBusiness(this.cWQ);
        this.cTO.setOnPreparedListener(this.bNv);
        this.cTO.setOnErrorListener(this.bNw);
        this.cTO.setOnSurfaceDestroyedListener(this.bYW);
        this.bYQ = new com.baidu.tieba.play.j();
        this.bYQ.setPlayer(this.cTO);
        this.bYQ.a(this.cUl);
        this.cTW = view.findViewById(d.g.auto_video_black_mask);
        this.cTS = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cTT = view.findViewById(d.g.auto_video_error_background);
        this.cjQ = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cjR = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bYF = AnimationUtils.loadAnimation(this.aQs.getPageActivity(), d.a.fade_out_video_cover);
        this.bYF.setAnimationListener(this.cUm);
        this.cTQ = (TextView) view.findViewById(d.g.text_video_duration);
        this.cTH = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cVL = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dII = new com.baidu.tieba.frs.f.g(tbPageContext, this.ciR);
        this.dII.setUniqueId(getTag());
        this.cSK = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cSK.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ciR || view == this.ciT.getCommentNumView() || view == this.dIH) {
            bD(this.ciR);
        } else if (view == this.cTN) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bO(this.cTN);
            } else {
                bD(this.cTN);
            }
        } else if (view == this.cSK) {
            bD(this.cSK);
        }
        if (this.aYc != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aYc));
        }
    }

    private void bO(View view) {
        if (this.aYc != null) {
            ak akVar = new ak("c11100");
            akVar.aa("tid", this.aYc.getId());
            akVar.aa(ImageViewerConfig.FORUM_ID, this.aYc.getFid() + "");
            TiebaStatic.log(akVar);
        }
        if (akg() != null) {
            akg().a(view, this.aYc);
        }
        if (view == this.cTN) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.aQs.getPageActivity(), d.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.oK()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQs.getPageActivity());
                aVar.cZ(this.aQs.getString(d.j.enter_video_center_page_no_wifi_tip));
                aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.akq();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.aW(true);
                aVar.b(this.mTbPageContext).AB();
            } else {
                akq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akq() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQs.getPageActivity(), "frs", this.aYc.getTid(), com.baidu.tieba.card.k.yJ(), "")));
    }

    private void bD(View view) {
        if (this.aYc != null) {
            if (this.aYc.zL()) {
                TiebaStatic.log(new ak("c10242").aa(ImageViewerConfig.FORUM_ID, String.valueOf(this.aYc.getFid())).s("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.aa("tid", this.aYc.getId());
                akVar.aa(ImageViewerConfig.FORUM_ID, this.aYc.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.aYc.yT() != null && this.aYc.yT().getGodUserData() != null && this.aYc.yT().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").s("obj_locate", 3).aa("tid", this.aYc.getId()));
            }
        }
        if (akg() != null) {
            akg().a(view, this.aYc);
        }
        if (this.aYc != null) {
            com.baidu.tieba.card.k.kk(this.aYc.getId());
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
            t.hi(this.aYc.getId());
            if (this.aYc.zq() > 0 && com.baidu.tieba.tbadkCore.util.f.bwK()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aQs.getPageActivity()).createHistoryCfg(this.aYc.getTid(), String.valueOf(this.aYc.zq()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.aYc.zL() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aYc.zU());
                createHistoryCfg.setSmartFrsPosition(this.aYc.Ab());
                createHistoryCfg.setForumId(String.valueOf(this.aYc.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cSK) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aQs.getPageActivity()).createFromThreadCfg(this.aYc, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aYc.zL() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aYc.zU());
            createFromThreadCfg.setSmartFrsPosition(this.aYc.Ab());
            createFromThreadCfg.setForumId(String.valueOf(this.aYc.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cSK) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aQs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
        this.aYc = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        this.cUd.removeMessages(HttpStatus.SC_ACCEPTED);
        if (this.cTO.getCurrentPosition() > 0) {
            i(true, 3);
            this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cUd.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cTO.getCurrentPosition();
        if (currentPosition != this.cTX) {
            this.cTX = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cUd.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bYB != null && this.cTG != null && this.cTW != null && this.cTU != null && this.cTT != null && this.cTS != null) {
            if (z || this.cTY != i) {
                this.cTY = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUh);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUg);
                if (i == 2) {
                    this.bYB.setVisibility(8);
                    this.bYF.cancel();
                    this.cTG.clearAnimation();
                    this.cTG.setVisibility(0);
                    this.cTW.setVisibility(0);
                    this.cVL.setVisibility(0);
                    this.cTU.startLoading();
                    this.cTT.setVisibility(8);
                    this.cTS.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cUh, 60000L);
                } else if (i == 3) {
                    this.bYB.setVisibility(8);
                    this.cTG.startAnimation(this.bYF);
                    this.cTW.setVisibility(8);
                    this.cVL.setVisibility(8);
                    this.cTU.bkD();
                    this.cTT.setVisibility(8);
                    this.cTS.setVisibility(8);
                } else if (i == 4) {
                    this.bYB.setVisibility(8);
                    this.cTG.startAnimation(this.bYF);
                    this.cTW.setVisibility(8);
                    this.cTU.bkE();
                    this.cTT.setVisibility(0);
                    this.cTS.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cUg, 2000L);
                } else {
                    this.bYB.setVisibility(0);
                    this.cVL.setVisibility(0);
                    this.bYF.cancel();
                    this.cTG.clearAnimation();
                    this.cTG.setVisibility(0);
                    this.cTW.setVisibility(0);
                    this.cTU.bkE();
                    this.cTT.setVisibility(8);
                    this.cTS.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.aYc == null || this.aYc.yT() == null) {
            this.ciR.setVisibility(8);
            return;
        }
        this.ciR.setVisibility(0);
        akv();
        this.aYc.h(false, true);
        SpannableStringBuilder zt = this.aYc.zt();
        if (this.aYc.zz() && !StringUtils.isNull(this.aYc.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aYc.getTid();
            zt.append((CharSequence) this.aYc.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0108d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new m(zt));
        this.mTextTitle.setText(zt);
        this.dII.T(this.aYc);
        this.ciS.setData(this.aYc);
        if (this.ciS.getHeaderImg() != null) {
            if (this.ciS.getIsSimpleThread()) {
                this.ciS.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (this.aYc.yT() == null || this.aYc.yT().getPendantData() == null || StringUtils.isNull(this.aYc.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ciS.getHeaderImg().setVisibility(0);
                this.ciS.getHeaderImg().setData(this.aYc);
            } else {
                this.ciS.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(this.aYc);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.ciT.setLayoutParams(layoutParams);
        this.ciS.setUserAfterClickListener(this.bcm);
        if (this.ciT.setData(this.aYc)) {
            this.ciU.setVisibility(8);
        } else {
            this.ciU.setVisibility(0);
        }
        this.cTQ.setText(am.fV(this.aYc.zl().video_duration.intValue() * 1000));
        this.cTH.setText(String.format(this.aQs.getResources().getString(d.j.play_count), am.J(this.aYc.zl().play_count.intValue())));
        this.cSK.setData(this.aYc.Ah());
        this.cSK.onChangeSkinType();
        if (com.baidu.tieba.card.k.kl(this.aYc.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
            com.baidu.tieba.card.k.a(this.cSK.getGodReplyContent(), this.aYc.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
        d(this.aQs, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akt() {
        this.cUd.removeMessages(HttpStatus.SC_ACCEPTED);
        this.cUd.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aku() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUg);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cUh);
    }

    private void akv() {
        aku();
        akt();
        if (this.cTG != null && this.cTN != null && this.cTO != null) {
            if (com.baidu.tbadk.core.i.wB().wH() && this.aYc != null && this.aYc.zl() != null) {
                this.cTN.setVisibility(0);
                this.cTG.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cTG.startLoad(this.aYc.zl().thumbnail_url, 10, false);
                stopPlay();
                this.bON = this.aYc.zl().video_url;
                if (StringUtils.isNull(this.bON)) {
                    i(true, 4);
                    TiebaStatic.log(new ak("c12026").aa("tid", this.aYc.getId()));
                }
                if (this.cWQ != null && this.cWQ.bkm() != null) {
                    this.cWQ.bkm().d(this.aYc.zl());
                    return;
                }
                return;
            }
            this.cTN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciR, d.f.addresslist_item_bg);
            aj.c(this.bYB, d.f.btn_icon_play_video_n);
            aj.r(this.cTS, d.C0108d.cp_cont_i);
            aj.r(this.cTQ, d.C0108d.cp_cont_i);
            aj.r(this.cTH, d.C0108d.cp_cont_i);
            aj.t(this.cTT, d.C0108d.common_color_10014);
            aj.t(this.bOs, d.C0108d.cp_bg_line_e);
            if (this.cTS != null) {
                this.cTS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ciT.onChangeSkinType();
            this.mSkinType = i;
            this.ciS.onChangeSkinType();
            this.dII.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cTZ;
    }

    public boolean isPlaying() {
        if (this.cTO == null) {
            return false;
        }
        return this.cTO.isPlaying();
    }

    public void startPlay() {
        if (!this.cTZ && this.aYc != null && this.aYc.zl() != null && this.cTO != null && com.baidu.tbadk.util.y.p(2, this.bON)) {
            i(true, 2);
            if (StringUtils.isNull(this.bON)) {
                TiebaStatic.log(new ak("c12619").aa("obj_locate", "frs").aa("tid", this.aYc.getId()));
                this.bON = this.aYc.zl().video_url;
            }
            this.cTO.bN(this.bON, this.aYc.getId());
            this.cTO.setLooping(true);
            if (this.bYQ != null) {
                this.bYQ.start();
            }
            this.cTZ = true;
            akp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        if (this.aYc != null && this.aYc.zl() != null) {
            String str = this.aYc.zL() ? "floor5" : "frs";
            aa aaVar = new aa();
            aaVar.mLocate = str;
            aaVar.bBb = this.aYc.getTid();
            aaVar.cXh = this.aYc.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.aYc.mRecomSource;
            aaVar.guq = this.aYc.mRecomAbTag;
            aaVar.gur = this.aYc.mRecomWeight;
            aaVar.gus = "";
            aaVar.guu = this.aYc.zl().video_md5;
            com.baidu.tieba.play.l.a(this.aYc.zl().video_md5, "", "1", aaVar);
        }
    }

    public void stopPlay() {
        aku();
        akt();
        i(true, 1);
        if (this.cTO != null) {
            this.cTO.stopPlayback();
            if (this.bYQ != null) {
                this.bYQ.stop();
            }
        }
        this.cTZ = false;
    }

    public ThreadCommentAndPraiseInfoLayout akL() {
        return this.ciT;
    }

    public View getVideoContainer() {
        return this.cTN;
    }

    public String getPlayUrl() {
        return this.bON;
    }

    public int getCurrentPosition() {
        if (this.cTO == null) {
            return 0;
        }
        return this.cTO.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cWQ != null) {
            this.cWQ.setVideoStatsData(aaVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciT != null && this.ciS != null) {
            this.ciS.setPageUniqueId(bdUniqueId);
        }
    }
}
