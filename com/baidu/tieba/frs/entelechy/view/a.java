package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.be;
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
public class a extends com.baidu.tieba.card.a<be> implements u {
    private TbPageContext<?> aQq;
    private be aXV;
    private g.f bNf;
    private g.b bNg;
    private View bOc;
    private String bOw;
    private com.baidu.tieba.play.j bYB;
    private QuickVideoView.b bYH;
    private ImageView bYm;
    private Animation bYq;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private ThreadGodReplyLayout cNP;
    private TbImageView cOK;
    private TextView cOL;
    private View.OnClickListener cOP;
    public FrameLayout cOR;
    private QuickVideoView cOS;
    private com.baidu.tieba.play.g cOT;
    private TextView cOU;
    private TextView cOW;
    private View cOX;
    private y cOY;
    private View cPa;
    private int cPb;
    private int cPc;
    private boolean cPd;
    private Handler cPh;
    private VideoLoadingProgressView.a cPi;
    private TbImageView.a cPj;
    private Runnable cPk;
    private Runnable cPl;
    private j.a cPp;
    private Animation.AnimationListener cPq;
    private LinearLayout cQO;
    private n cRT;
    private RelativeLayout ciC;
    public ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    public View ciF;
    public LinearLayout cjA;
    public ThreadSkinView cjB;
    public TextView dDK;
    public LinearLayout dDL;
    private com.baidu.tieba.frs.f.g dDM;
    private ViewTreeObserver.OnGlobalLayoutListener dDN;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void ajg() {
        if (this.cOT != null) {
            try {
                this.cOS.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cPb = 0;
        this.cPc = 1;
        this.cPd = false;
        this.cPh = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case HttpStatus.SC_ACCEPTED /* 202 */:
                        a.this.ajj();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.ajk();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bNf = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cOT = gVar;
                a.this.cOT.setVolume(0.0f, 0.0f);
                a.this.cOY.bri();
            }
        };
        this.bNg = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ajl();
                a.this.i(true, 4);
                return true;
            }
        };
        this.cPi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.ajg();
            }
        };
        this.cPj = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && a.this.cOK != null) {
                    a.this.cOK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dDN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cOR != null && a.this.cOR.getLayoutParams() != null && a.this.cOR.getVisibility() != 8) {
                    a.this.cOR.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cOR.getLayoutParams();
                    if (a.this.cOR.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cOR.getWidth() * 0.5625d);
                        a.this.cOR.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cPk = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cOS != null && !a.this.cOS.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cPl = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.ajl();
                a.this.i(true, 4);
            }
        };
        this.bYH = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cOP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXV != null && !StringUtils.isNull(a.this.aXV.zd())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.aQq.getPageActivity()).createNormalCfg(a.this.aXV.zd(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bbR != null) {
                        a.this.bbR.onClick(view);
                    }
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiY() != null) {
                    a.this.aiY().a(view, a.this.aXV);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXV != null && a.this.aiY() != null) {
                    a.this.aiY().a(view, a.this.aXV);
                }
            }
        };
        this.cPp = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.j.a
            public void ajo() {
                a.this.ajh();
            }
        };
        this.cPq = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cPc == 3 && a.this.cOK != null) {
                    a.this.cOK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.aQq = tbPageContext;
        View view = getView();
        this.bOc = view.findViewById(d.g.divider_line);
        this.ciC = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.dDL = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.ciC.setOnClickListener(this);
        this.cNO = (HeadPendantClickableView) this.ciC.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.ds70));
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.dDK = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.dDK.setVisibility(8);
        this.dDK.setOnClickListener(this.cOP);
        this.cOY = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cOY.setLoadingAnimationListener(this.cPi);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.ciE.setForumAfterClickListener(this.bbR);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.ciD.setFrom(3);
        this.ciF = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setShareVisible(true);
        this.ciE.setShareReportFrom(1);
        this.ciE.setStType("frs_page");
        this.ciE.setFrom(2);
        this.ciE.bbP = 3;
        this.cOR = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cOR.setOnClickListener(this);
        this.cOR.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cOR != null) {
                    a.this.cOR.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dDN);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cOR != null) {
                    a.this.cOR.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dDN);
                }
            }
        });
        this.cOK = (TbImageView) view.findViewById(d.g.image_video);
        this.cOK.setPageId(getTag());
        this.cOK.setDefaultErrorResource(0);
        this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cOK.setEvent(this.cPj);
        this.cOK.setGifIconSupport(false);
        this.bYm = (ImageView) view.findViewById(d.g.image_video_play);
        this.cOS = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cRT = new n(this.aQq.getPageActivity());
        this.cOS.setBusiness(this.cRT);
        this.cOS.setOnPreparedListener(this.bNf);
        this.cOS.setOnErrorListener(this.bNg);
        this.cOS.setOnSurfaceDestroyedListener(this.bYH);
        this.bYB = new com.baidu.tieba.play.j();
        this.bYB.setPlayer(this.cOS);
        this.bYB.a(this.cPp);
        this.cPa = view.findViewById(d.g.auto_video_black_mask);
        this.cOW = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cOX = view.findViewById(d.g.auto_video_error_background);
        this.cjA = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cjB = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bYq = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.fade_out_video_cover);
        this.bYq.setAnimationListener(this.cPq);
        this.cOU = (TextView) view.findViewById(d.g.text_video_duration);
        this.cOL = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cQO = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dDM = new com.baidu.tieba.frs.f.g(tbPageContext, this.ciC);
        this.dDM.setUniqueId(getTag());
        this.cNP = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cNP.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ciC || view == this.ciE.getCommentNumView() || view == this.dDL) {
            bB(this.ciC);
        } else if (view == this.cOR) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bM(this.cOR);
            } else {
                bB(this.cOR);
            }
        } else if (view == this.cNP) {
            bB(this.cNP);
        }
        if (this.aXV != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aXV));
        }
    }

    private void bM(View view) {
        if (this.aXV != null) {
            ak akVar = new ak("c11100");
            akVar.ab("tid", this.aXV.getId());
            akVar.ab(ImageViewerConfig.FORUM_ID, this.aXV.getFid() + "");
            TiebaStatic.log(akVar);
        }
        if (aiY() != null) {
            aiY().a(view, this.aXV);
        }
        if (view == this.cOR) {
            if (!com.baidu.adp.lib.util.j.oI()) {
                com.baidu.adp.lib.util.l.showToast(this.aQq.getPageActivity(), d.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQq.getPageActivity());
                aVar.cZ(this.aQq.getString(d.j.enter_video_center_page_no_wifi_tip));
                aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.aji();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.aV(true);
                aVar.b(this.mTbPageContext).AI();
            } else {
                aji();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aji() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQq.getPageActivity(), "frs", this.aXV.getTid(), com.baidu.tieba.card.k.yN(), "")));
    }

    private void bB(View view) {
        if (this.aXV != null) {
            if (this.aXV.zS()) {
                TiebaStatic.log(new ak("c10242").ab(ImageViewerConfig.FORUM_ID, String.valueOf(this.aXV.getFid())).s("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ab("tid", this.aXV.getId());
                akVar.ab(ImageViewerConfig.FORUM_ID, this.aXV.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.aXV.yX() != null && this.aXV.yX().getGodUserData() != null && this.aXV.yX().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", this.aXV.getId()));
            }
        }
        if (aiY() != null) {
            aiY().a(view, this.aXV);
        }
        if (this.aXV != null) {
            com.baidu.tieba.card.k.jT(this.aXV.getId());
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
            t.gZ(this.aXV.getId());
            if (this.aXV.zu() > 0 && com.baidu.tieba.tbadkCore.util.f.bDl()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aQq.getPageActivity()).createHistoryCfg(this.aXV.getTid(), String.valueOf(this.aXV.zu()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.aXV.zS() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aXV.Ab());
                createHistoryCfg.setSmartFrsPosition(this.aXV.Ai());
                createHistoryCfg.setForumId(String.valueOf(this.aXV.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cNP) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aQq.getPageActivity()).createFromThreadCfg(this.aXV, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aXV.zS() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aXV.Ab());
            createFromThreadCfg.setSmartFrsPosition(this.aXV.Ai());
            createFromThreadCfg.setForumId(String.valueOf(this.aXV.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cNP) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(be beVar) {
        this.aXV = beVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajj() {
        this.cPh.removeMessages(HttpStatus.SC_ACCEPTED);
        if (this.cOS.getCurrentPosition() > 0) {
            i(true, 3);
            this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajk() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cPh.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cOS.getCurrentPosition();
        if (currentPosition != this.cPb) {
            this.cPb = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bYm != null && this.cOK != null && this.cPa != null && this.cOY != null && this.cOX != null && this.cOW != null) {
            if (z || this.cPc != i) {
                this.cPc = i;
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPl);
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPk);
                if (i == 2) {
                    this.bYm.setVisibility(8);
                    this.bYq.cancel();
                    this.cOK.clearAnimation();
                    this.cOK.setVisibility(0);
                    this.cPa.setVisibility(0);
                    this.cQO.setVisibility(0);
                    this.cOY.startLoading();
                    this.cOX.setVisibility(8);
                    this.cOW.setVisibility(8);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cPl, 60000L);
                } else if (i == 3) {
                    this.bYm.setVisibility(8);
                    this.cOK.startAnimation(this.bYq);
                    this.cPa.setVisibility(8);
                    this.cQO.setVisibility(8);
                    this.cOY.brj();
                    this.cOX.setVisibility(8);
                    this.cOW.setVisibility(8);
                } else if (i == 4) {
                    this.bYm.setVisibility(8);
                    this.cOK.startAnimation(this.bYq);
                    this.cPa.setVisibility(8);
                    this.cOY.brk();
                    this.cOX.setVisibility(0);
                    this.cOW.setVisibility(0);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cPk, 2000L);
                } else {
                    this.bYm.setVisibility(0);
                    this.cQO.setVisibility(0);
                    this.bYq.cancel();
                    this.cOK.clearAnimation();
                    this.cOK.setVisibility(0);
                    this.cPa.setVisibility(0);
                    this.cOY.brk();
                    this.cOX.setVisibility(8);
                    this.cOW.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.aXV == null || this.aXV.yX() == null) {
            this.ciC.setVisibility(8);
            return;
        }
        this.ciC.setVisibility(0);
        ajn();
        this.aXV.h(false, true);
        this.mTextTitle.setOnTouchListener(new m(this.aXV.zx()));
        this.mTextTitle.setText(this.aXV.zx());
        this.dDM.T(this.aXV);
        this.ciD.setData(this.aXV);
        if (this.ciD.getHeaderImg() != null) {
            if (this.ciD.getIsSimpleThread()) {
                this.ciD.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (this.aXV.yX() == null || this.aXV.yX().getPendantData() == null || StringUtils.isNull(this.aXV.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.ciD.getHeaderImg().setVisibility(0);
                this.ciD.getHeaderImg().setData(this.aXV);
            } else {
                this.ciD.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(this.aXV);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.ciE.setLayoutParams(layoutParams);
        this.ciD.setUserAfterClickListener(this.bce);
        if (this.ciE.setData(this.aXV)) {
            this.ciF.setVisibility(8);
        } else {
            this.ciF.setVisibility(0);
        }
        this.cOU.setText(am.fX(this.aXV.zp().video_duration.intValue() * 1000));
        this.cOL.setText(String.format(this.aQq.getResources().getString(d.j.play_count), am.I(this.aXV.zp().play_count.intValue())));
        this.cNP.setData(this.aXV.Ao());
        this.cNP.onChangeSkinType();
        if (com.baidu.tieba.card.k.jU(this.aXV.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
            com.baidu.tieba.card.k.a(this.cNP.getGodReplyContent(), this.aXV.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
        d(this.aQq, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajl() {
        this.cPh.removeMessages(HttpStatus.SC_ACCEPTED);
        this.cPh.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void ajm() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPk);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPl);
    }

    private void ajn() {
        ajm();
        ajl();
        if (this.cOK != null && this.cOR != null && this.cOS != null) {
            if (com.baidu.tbadk.core.i.wB().wH() && this.aXV != null && this.aXV.zp() != null) {
                this.cOR.setVisibility(0);
                this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cOK.startLoad(this.aXV.zp().thumbnail_url, 10, false);
                stopPlay();
                this.bOw = this.aXV.zp().video_url;
                if (StringUtils.isNull(this.bOw)) {
                    i(true, 4);
                    TiebaStatic.log(new ak("c12026").ab("tid", this.aXV.getId()));
                }
                if (this.cRT != null && this.cRT.bqS() != null) {
                    this.cRT.bqS().d(this.aXV.zp());
                    return;
                }
                return;
            }
            this.cOR.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciC, d.f.addresslist_item_bg);
            aj.c(this.bYm, d.f.btn_icon_play_video_n);
            aj.r(this.cOW, d.C0108d.cp_cont_i);
            aj.r(this.cOU, d.C0108d.cp_cont_i);
            aj.r(this.cOL, d.C0108d.cp_cont_i);
            aj.t(this.cOX, d.C0108d.common_color_10014);
            aj.t(this.bOc, d.C0108d.cp_bg_line_e);
            if (this.cOW != null) {
                this.cOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ciE.onChangeSkinType();
            this.mSkinType = i;
            this.ciD.onChangeSkinType();
            this.dDM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cPd;
    }

    public boolean isPlaying() {
        if (this.cOS == null) {
            return false;
        }
        return this.cOS.isPlaying();
    }

    public void startPlay() {
        if (!this.cPd && this.aXV != null && this.aXV.zp() != null && this.cOS != null && com.baidu.tbadk.util.y.p(2, this.bOw)) {
            i(true, 2);
            if (StringUtils.isNull(this.bOw)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "frs").ab("tid", this.aXV.getId()));
                this.bOw = this.aXV.zp().video_url;
            }
            this.cOS.bS(this.bOw, this.aXV.getId());
            this.cOS.setLooping(true);
            if (this.bYB != null) {
                this.bYB.start();
            }
            this.cPd = true;
            ajh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        if (this.aXV != null && this.aXV.zp() != null) {
            String str = this.aXV.zS() ? "floor5" : "frs";
            aa aaVar = new aa();
            aaVar.mLocate = str;
            aaVar.bAK = this.aXV.getTid();
            aaVar.cSk = this.aXV.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.aXV.mRecomSource;
            aaVar.gEO = this.aXV.mRecomAbTag;
            aaVar.gEP = this.aXV.mRecomWeight;
            aaVar.gEQ = "";
            aaVar.gES = this.aXV.zp().video_md5;
            com.baidu.tieba.play.l.a(this.aXV.zp().video_md5, "", "1", aaVar);
        }
    }

    public void stopPlay() {
        ajm();
        ajl();
        i(true, 1);
        if (this.cOS != null) {
            this.cOS.stopPlayback();
            if (this.bYB != null) {
                this.bYB.stop();
            }
        }
        this.cPd = false;
    }

    public ThreadCommentAndPraiseInfoLayout ajD() {
        return this.ciE;
    }

    public View getVideoContainer() {
        return this.cOR;
    }

    public String getPlayUrl() {
        return this.bOw;
    }

    public int getCurrentPosition() {
        if (this.cOS == null) {
            return 0;
        }
        return this.cOS.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cRT != null) {
            this.cRT.setVideoStatsData(aaVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciE != null && this.ciD != null) {
            this.ciD.setPageUniqueId(bdUniqueId);
        }
    }
}
