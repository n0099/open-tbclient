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
import android.widget.ProgressBar;
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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bh> implements v {
    private g.InterfaceC0121g aWb;
    private g.b aWc;
    private View aXa;
    private String aXu;
    private TbPageContext<?> abI;
    private bh ajq;
    private final View.OnClickListener anA;
    private final View.OnClickListener anS;
    private HeadPendantClickableView bQP;
    private ThreadGodReplyLayout bQQ;
    private TbImageView bRN;
    private ImageView bRO;
    private TextView bRP;
    private View.OnClickListener bRT;
    public FrameLayout bRV;
    private QuickVideoView bRW;
    private TextView bRY;
    private TextView bSa;
    private View bSb;
    private ProgressBar bSc;
    private ImageView bSd;
    private View bSf;
    private int bSg;
    private int bSh;
    private boolean bSi;
    private com.baidu.tieba.play.j bSk;
    private Animation bSl;
    private Handler bSn;
    private TbImageView.a bSo;
    private Runnable bSp;
    private Runnable bSq;
    private QuickVideoView.b bSr;
    private j.a bSv;
    private Animation.AnimationListener bSw;
    private LinearLayout bTM;
    private n bUr;
    public ThreadCommentAndPraiseInfoLayout boD;
    public View boE;
    public LinearLayout boH;
    public ThreadSkinView boI;
    private RelativeLayout boq;
    public ThreadUserInfoLayout boz;
    public TextView cFg;
    public LinearLayout cFh;
    private com.baidu.tieba.frs.g.g cFi;
    private ViewTreeObserver.OnGlobalLayoutListener cFj;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bSg = 0;
        this.bSh = 1;
        this.bSi = false;
        this.bSn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.ZG();
                        return;
                    case 203:
                        a.this.ZH();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aWb = new g.InterfaceC0121g() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bSn.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aWc = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ZI();
                a.this.f(true, 4);
                return true;
            }
        };
        this.bSo = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && a.this.bRN != null) {
                    a.this.bRN.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cFj = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bRV != null && a.this.bRV.getLayoutParams() != null && a.this.bRV.getVisibility() != 8) {
                    a.this.bRV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bRV.getLayoutParams();
                    if (a.this.bRV.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bRV.getWidth() * 0.5625d);
                        a.this.bRV.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bSp = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bRW != null && !a.this.bRW.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.bSq = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.ZI();
                a.this.f(true, 4);
            }
        };
        this.bSr = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.bRT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajq != null && !StringUtils.isNull(a.this.ajq.rz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.abI.getPageActivity()).createNormalCfg(a.this.ajq.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.anA != null) {
                        a.this.anA.onClick(view);
                    }
                }
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Zx() != null) {
                    a.this.Zx().a(view, a.this.ajq);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajq != null && a.this.Zx() != null) {
                    a.this.Zx().a(view, a.this.ajq);
                }
            }
        };
        this.bSv = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.j.a
            public void ZL() {
                a.this.ZF();
            }
        };
        this.bSw = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bSh == 3 && a.this.bRN != null) {
                    a.this.bRN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.abI = tbPageContext;
        View view = getView();
        this.aXa = view.findViewById(d.g.divider_line);
        this.boq = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cFh = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.boq.setOnClickListener(this);
        this.bQP = (HeadPendantClickableView) this.boq.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds70));
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.cFg = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cFg.setVisibility(8);
        this.cFg.setOnClickListener(this.bRT);
        this.bSc = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.bSd = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.boD.setForumAfterClickListener(this.anA);
        this.boz = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.boz.setFrom(3);
        this.boE = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setIsBarViewVisible(false);
        this.boD.setShareVisible(true);
        this.boD.setShareReportFrom(1);
        this.boD.setStType("frs_page");
        this.boD.setFrom(2);
        this.bRV = (FrameLayout) view.findViewById(d.g.frame_video);
        this.bRV.setOnClickListener(this);
        this.bRV.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bRV != null) {
                    a.this.bRV.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cFj);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bRV != null) {
                    a.this.bRV.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cFj);
                }
            }
        });
        this.bRN = (TbImageView) view.findViewById(d.g.image_video);
        this.bRN.setPageId(getTag());
        this.bRN.setDefaultErrorResource(0);
        this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bRN.setEvent(this.bSo);
        this.bRN.setGifIconSupport(false);
        this.bRO = (ImageView) view.findViewById(d.g.image_video_play);
        this.bRW = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bUr = new n(this.abI.getPageActivity());
        this.bRW.setBusiness(this.bUr);
        this.bRW.setOnPreparedListener(this.aWb);
        this.bRW.setOnErrorListener(this.aWc);
        this.bRW.setOnSurfaceDestroyedListener(this.bSr);
        this.bSk = new com.baidu.tieba.play.j();
        this.bSk.setPlayer(this.bRW);
        this.bSk.a(this.bSv);
        this.bSf = view.findViewById(d.g.auto_video_black_mask);
        this.bSa = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bSb = view.findViewById(d.g.auto_video_error_background);
        this.boH = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.boI = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bSl = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.fade_out_video_cover);
        this.bSl.setAnimationListener(this.bSw);
        this.bRY = (TextView) view.findViewById(d.g.text_video_duration);
        this.bRP = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bTM = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cFi = new com.baidu.tieba.frs.g.g(tbPageContext, this.boz);
        this.cFi.setUniqueId(getTag());
        this.bQQ = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bQQ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boq || view == this.boD.getCommentNumView() || view == this.cFh) {
            ag(this.boq);
        } else if (view == this.bRV) {
            ag(this.bRV);
        } else if (view == this.bQQ) {
            ag(this.bQQ);
        }
        if (this.ajq != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajq));
        }
    }

    private void ag(View view) {
        if (this.ajq != null) {
            if (this.ajq.sp()) {
                TiebaStatic.log(new ak("c10242").ac(ImageViewerConfig.FORUM_ID, String.valueOf(this.ajq.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ac("tid", this.ajq.getId());
                akVar.ac(ImageViewerConfig.FORUM_ID, this.ajq.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.ajq.rt() != null && this.ajq.rt().getGodUserData() != null && this.ajq.rt().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", this.ajq.getId()));
            }
        }
        if (Zx() != null) {
            Zx().a(view, this.ajq);
        }
        if (this.ajq != null) {
            m.jK(this.ajq.getId());
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
            t.gU(this.ajq.getId());
            if (this.ajq.rQ() > 0 && com.baidu.tieba.tbadkCore.util.f.bvs()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.abI.getPageActivity()).createHistoryCfg(this.ajq.getTid(), String.valueOf(this.ajq.rQ()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.ajq.sp() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajq.sy());
                createHistoryCfg.setSmartFrsPosition(this.ajq.sF());
                createHistoryCfg.setForumId(String.valueOf(this.ajq.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bQQ) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.abI.getPageActivity()).createFromThreadCfg(this.ajq, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ajq.sp() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ajq.sy());
            createFromThreadCfg.setSmartFrsPosition(this.ajq.sF());
            createFromThreadCfg.setForumId(String.valueOf(this.ajq.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bQQ) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        this.ajq = bhVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZG() {
        this.bSn.removeMessages(202);
        if (this.bRW.getCurrentPosition() > 0) {
            f(true, 3);
            this.bSn.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bSn.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZH() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bSn.removeMessages(203);
        int currentPosition = this.bRW.getCurrentPosition();
        if (currentPosition != this.bSg) {
            this.bSg = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bSn.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bRO != null && this.bRN != null && this.bSf != null && this.bSc != null && this.bSd != null && this.bSb != null && this.bSa != null) {
            if (z || this.bSh != i) {
                this.bSh = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSq);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSp);
                if (i == 2) {
                    this.bRO.setVisibility(8);
                    this.bSl.cancel();
                    this.bRN.clearAnimation();
                    this.bRN.setVisibility(0);
                    this.bSf.setVisibility(0);
                    this.bTM.setVisibility(0);
                    this.bSc.setVisibility(0);
                    this.bSd.setVisibility(0);
                    this.bSb.setVisibility(8);
                    this.bSa.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSq, 60000L);
                } else if (i == 3) {
                    this.bRO.setVisibility(8);
                    this.bRN.startAnimation(this.bSl);
                    this.bSf.setVisibility(8);
                    this.bTM.setVisibility(8);
                    this.bSc.setVisibility(8);
                    this.bSd.setVisibility(8);
                    this.bSb.setVisibility(8);
                    this.bSa.setVisibility(8);
                } else if (i == 4) {
                    this.bRO.setVisibility(8);
                    this.bRN.startAnimation(this.bSl);
                    this.bSf.setVisibility(8);
                    this.bSc.setVisibility(8);
                    this.bSd.setVisibility(8);
                    this.bSb.setVisibility(0);
                    this.bSa.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSp, 2000L);
                } else {
                    this.bRO.setVisibility(0);
                    this.bTM.setVisibility(0);
                    this.bSl.cancel();
                    this.bRN.clearAnimation();
                    this.bRN.setVisibility(0);
                    this.bSf.setVisibility(0);
                    this.bSc.setVisibility(8);
                    this.bSd.setVisibility(8);
                    this.bSb.setVisibility(8);
                    this.bSa.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajq == null || this.ajq.rt() == null) {
            this.boq.setVisibility(8);
            return;
        }
        this.boq.setVisibility(0);
        ZK();
        this.ajq.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.ajq.rU()));
        this.mTextTitle.setText(this.ajq.rU());
        this.cFi.Q(this.ajq);
        this.boz.setData(this.ajq);
        if (this.boz.getHeaderImg() != null) {
            if (this.boz.getIsSimpleThread()) {
                this.boz.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (this.ajq.rt() == null || this.ajq.rt().getPendantData() == null || StringUtils.isNull(this.ajq.rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.boz.getHeaderImg().setVisibility(0);
                this.boz.getHeaderImg().setData(this.ajq);
            } else {
                this.boz.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(this.ajq);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.boD.setLayoutParams(layoutParams);
        this.boz.setUserAfterClickListener(this.anS);
        if (this.boD.setData(this.ajq)) {
            this.boE.setVisibility(8);
        } else {
            this.boE.setVisibility(0);
        }
        this.bRY.setText(am.cY(this.ajq.rL().video_duration.intValue() * 1000));
        this.bRP.setText(String.format(this.abI.getResources().getString(d.j.play_count), am.A(this.ajq.rL().play_count.intValue())));
        this.boD.setCommentNumClickListener(this);
        this.bQQ.setData(this.ajq.sL());
        this.bQQ.onChangeSkinType();
        if (m.jL(this.ajq.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
            m.a(this.bQQ.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZI() {
        this.bSn.removeMessages(202);
        this.bSn.removeMessages(203);
    }

    private void ZJ() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSp);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSq);
    }

    private void ZK() {
        ZJ();
        ZI();
        if (this.bRN != null && this.bRV != null && this.bRW != null) {
            if (com.baidu.tbadk.core.h.oT().oZ() && this.ajq != null && this.ajq.rL() != null) {
                this.bRV.setVisibility(0);
                this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bRN.startLoad(this.ajq.rL().thumbnail_url, 10, false);
                stopPlay();
                this.aXu = this.ajq.rL().video_url;
                if (StringUtils.isNull(this.aXu)) {
                    f(true, 4);
                    TiebaStatic.log(new ak("c12026").ac("tid", this.ajq.getId()));
                }
                if (this.bUr != null && this.bUr.bhy() != null) {
                    this.bUr.bhy().d(this.ajq.rL());
                    return;
                }
                return;
            }
            this.bRV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.boq, d.f.addresslist_item_bg);
            aj.c(this.bRO, d.f.btn_icon_play_video_n);
            aj.i(this.bSa, d.C0080d.cp_cont_i);
            aj.i(this.bRY, d.C0080d.cp_cont_i);
            aj.i(this.bRP, d.C0080d.cp_cont_i);
            aj.k(this.bSb, d.C0080d.common_color_10014);
            aj.k(this.aXa, d.C0080d.cp_bg_line_e);
            if (this.bSa != null) {
                this.bSa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.boD.onChangeSkinType();
            this.mSkinType = i;
            this.boz.onChangeSkinType();
            this.cFi.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bSi;
    }

    public boolean isPlaying() {
        if (this.bRW == null) {
            return false;
        }
        return this.bRW.isPlaying();
    }

    public void startPlay() {
        if (!this.bSi && this.ajq != null && this.ajq.rL() != null && this.bRW != null && y.q(2, this.aXu)) {
            f(true, 2);
            this.bRW.bL(this.aXu, this.ajq.getId());
            this.bRW.start();
            this.bRW.setLooping(true);
            if (this.bSk != null) {
                this.bSk.start();
            }
            this.bSi = true;
            ZF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZF() {
        if (this.ajq != null && this.ajq.rL() != null) {
            String str = this.ajq.sp() ? "floor5" : "frs";
            x xVar = new x();
            xVar.mLocate = str;
            xVar.aMi = this.ajq.getTid();
            xVar.azE = this.ajq.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.ajq.ZQ;
            xVar.fGE = this.ajq.ZS;
            xVar.fGF = this.ajq.ZR;
            xVar.fGG = "";
            xVar.fGI = this.ajq.rL().video_md5;
            com.baidu.tieba.play.l.a(this.ajq.rL().video_md5, "", "1", xVar);
        }
    }

    public void stopPlay() {
        ZJ();
        ZI();
        f(true, 1);
        if (this.bRW != null) {
            this.bRW.stopPlayback();
            if (this.bSk != null) {
                this.bSk.stop();
            }
        }
        this.bSi = false;
    }

    public View getVideoContainer() {
        return this.bRV;
    }

    public String getPlayUrl() {
        return this.aXu;
    }

    public int getCurrentPosition() {
        if (this.bRW == null) {
            return 0;
        }
        return this.bRW.getCurrentPosition();
    }

    public void setVideoStatsData(x xVar) {
        if (this.bUr != null) {
            this.bUr.setVideoStatsData(xVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boD != null && this.boz != null) {
            this.boz.setPageUniqueId(bdUniqueId);
        }
    }
}
