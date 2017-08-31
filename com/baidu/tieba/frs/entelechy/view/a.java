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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.i;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.w;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bj> implements v {
    private f.e aUw;
    private f.b aUx;
    private String aVG;
    private View aVm;
    private TbPageContext<?> aby;
    private bj ajF;
    private final View.OnClickListener aoe;
    private final View.OnClickListener aow;
    public FrameLayout bHD;
    private TbImageView bHE;
    private ImageView bHF;
    private TbImageView.a bHH;
    private HeadPendantClickableView bJq;
    private ThreadGodReplyLayout bJr;
    private int bKA;
    private int bKB;
    private boolean bKC;
    private com.baidu.tieba.play.i bKE;
    private Animation bKF;
    private Handler bKG;
    private Runnable bKH;
    private Runnable bKI;
    private QuickVideoView.b bKJ;
    private i.a bKN;
    private Animation.AnimationListener bKO;
    private View.OnClickListener bKo;
    private QuickVideoView bKq;
    private TextView bKs;
    private TextView bKt;
    private View bKu;
    private AudioAnimationView bKv;
    private ProgressBar bKw;
    private ImageView bKx;
    private View bKz;
    private m bMF;
    private View bhp;
    public View blA;
    public LinearLayout blD;
    public ThreadSkinView blE;
    private RelativeLayout blm;
    public ThreadUserInfoLayout blv;
    public ThreadCommentAndPraiseInfoLayout blz;
    public TextView cvT;
    public LinearLayout cvU;
    private com.baidu.tieba.frs.h.g cvV;
    private ViewTreeObserver.OnGlobalLayoutListener cvW;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bKA = 0;
        this.bKB = 1;
        this.bKC = false;
        this.bKG = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.XJ();
                        return;
                    case 203:
                        a.this.XK();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUw = new f.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bKG.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aUx = new f.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                a.this.XL();
                a.this.g(true, 4);
                return true;
            }
        };
        this.bHH = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && a.this.bHE != null) {
                    a.this.bHE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cvW = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bHD != null && a.this.bHD.getLayoutParams() != null && a.this.bHD.getVisibility() != 8) {
                    a.this.bHD.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bHD.getLayoutParams();
                    if (a.this.bHD.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bHD.getWidth() * 0.5625d);
                        a.this.bHD.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bKH = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bKq != null && !a.this.bKq.isPlaying()) {
                    a.this.g(true, 1);
                }
            }
        };
        this.bKI = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.XL();
                a.this.g(true, 4);
            }
        };
        this.bKJ = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.bKo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajF != null && !StringUtils.isNull(a.this.ajF.rG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.aby.getPageActivity()).createNormalCfg(a.this.ajF.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aoe != null) {
                        a.this.aoe.onClick(view);
                    }
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XA() != null) {
                    a.this.XA().a(view, a.this.ajF);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajF != null && a.this.XA() != null) {
                    a.this.XA().a(view, a.this.ajF);
                }
            }
        };
        this.bKN = new i.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.i.a
            public void XO() {
                a.this.XI();
            }
        };
        this.bKO = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bKB == 3 && a.this.bHE != null) {
                    a.this.bHE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.aby = tbPageContext;
        View view = getView();
        this.aVm = view.findViewById(d.h.divider_line);
        this.blm = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.cvU = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.blm.setOnClickListener(this);
        this.bJq = (HeadPendantClickableView) this.blm.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aby.getPageActivity(), d.f.ds70));
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.cvT = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.cvT.setVisibility(8);
        this.cvT.setOnClickListener(this.bKo);
        this.bKw = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bKx = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.blv = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.blv.setFrom(3);
        this.blA = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this);
        this.blz.setReplyTimeVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setIsBarViewVisible(false);
        this.blz.setShareVisible(true);
        this.blz.setShareReportFrom(1);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setFrom(2);
        this.bHD = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bHD.setOnClickListener(this);
        this.bHD.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bHD != null) {
                    a.this.bHD.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cvW);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bHD != null) {
                    a.this.bHD.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cvW);
                }
            }
        });
        this.bHE = (TbImageView) view.findViewById(d.h.image_video);
        this.bHE.setPageId(getTag());
        this.bHE.setDefaultErrorResource(0);
        this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bHE.setEvent(this.bHH);
        this.bHE.setGifIconSupport(false);
        this.bHF = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKv = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bKv.setCertainColumnCount(4);
        this.bKv.setColumnColor(d.e.cp_cont_i);
        this.bKq = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bMF = new m(this.aby.getPageActivity());
        this.bKq.setBusiness(this.bMF);
        this.bKq.setOnPreparedListener(this.aUw);
        this.bKq.setOnErrorListener(this.aUx);
        this.bKq.setOnSurfaceDestroyedListener(this.bKJ);
        this.bKE = new com.baidu.tieba.play.i();
        this.bKE.setPlayer(this.bKq);
        this.bKE.a(this.bKN);
        this.bKz = view.findViewById(d.h.auto_video_black_mask);
        this.bKt = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bKu = view.findViewById(d.h.auto_video_error_background);
        this.blD = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.blE = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bKF = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.fade_out_video_cover);
        this.bKF.setAnimationListener(this.bKO);
        this.bKs = (TextView) view.findViewById(d.h.text_video_duration);
        this.cvV = new com.baidu.tieba.frs.h.g(tbPageContext, this.blv);
        this.cvV.setUniqueId(getTag());
        this.bhp = view.findViewById(d.h.divider_line);
        this.bJr = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJr.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.blm || view == this.blz.getCommentNumView() || view == this.cvU) {
            ae(this.blm);
        } else if (view == this.bHD) {
            ae(this.bHD);
        } else if (view == this.bJr) {
            ae(this.bJr);
        }
        if (this.ajF != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajF));
        }
    }

    private void ae(View view) {
        if (this.ajF != null) {
            if (this.ajF.sv()) {
                TiebaStatic.log(new ak("c10242").ad("fid", String.valueOf(this.ajF.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ad("tid", this.ajF.getId());
                akVar.ad("fid", this.ajF.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.ajF.getAuthor() != null && this.ajF.getAuthor().getGodUserData() != null && this.ajF.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", this.ajF.getId()));
            }
        }
        if (XA() != null) {
            XA().a(view, this.ajF);
        }
        if (this.ajF != null) {
            com.baidu.tieba.card.m.js(this.ajF.getId());
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            s.gR(this.ajF.getId());
            if (this.ajF.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btm()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aby.getPageActivity()).createHistoryCfg(this.ajF.getTid(), String.valueOf(this.ajF.rX()), false, true, com.baidu.tieba.card.m.rs());
                createHistoryCfg.setVideo_source(this.ajF.sv() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajF.sE());
                createHistoryCfg.setSmartFrsPosition(this.ajF.sL());
                createHistoryCfg.setForumId(String.valueOf(this.ajF.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bJr) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aby.getPageActivity()).createFromThreadCfg(this.ajF, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ajF.sv() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ajF.sE());
            createFromThreadCfg.setSmartFrsPosition(this.ajF.sL());
            createFromThreadCfg.setForumId(String.valueOf(this.ajF.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bJr) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        this.ajF = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        this.bKG.removeMessages(202);
        if (this.bKq.getCurrentPosition() > 0) {
            g(true, 3);
            this.bKG.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bKG.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XK() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bKG.removeMessages(203);
        int currentPosition = this.bKq.getCurrentPosition();
        if (currentPosition != this.bKA) {
            this.bKA = currentPosition;
            g(false, 3);
        } else {
            g(false, 2);
        }
        this.bKG.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bHF != null && this.bHE != null && this.bKz != null && this.bKv != null && this.bKw != null && this.bKx != null && this.bKu != null && this.bKt != null) {
            if (z || this.bKB != i) {
                this.bKB = i;
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKI);
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKH);
                if (i == 2) {
                    this.bHF.setVisibility(8);
                    this.bKF.cancel();
                    this.bHE.clearAnimation();
                    this.bHE.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bKs.setVisibility(0);
                    this.bKw.setVisibility(0);
                    this.bKx.setVisibility(0);
                    this.bKu.setVisibility(8);
                    this.bKt.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKv.bwt();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bKI, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bHF.setVisibility(8);
                    this.bHE.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bKs.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKu.setVisibility(8);
                    this.bKt.setVisibility(8);
                    this.bKv.setVisibility(0);
                    this.bKv.start();
                } else if (i == 4) {
                    this.bHF.setVisibility(8);
                    this.bHE.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKu.setVisibility(0);
                    this.bKt.setVisibility(0);
                    this.bKv.setVisibility(8);
                    this.bKv.bwt();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bKH, 2000L);
                } else {
                    this.bHF.setVisibility(0);
                    this.bKs.setVisibility(0);
                    this.bKF.cancel();
                    this.bHE.clearAnimation();
                    this.bHE.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKu.setVisibility(8);
                    this.bKt.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKv.bwt();
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajF == null || this.ajF.getAuthor() == null) {
            this.blm.setVisibility(8);
            return;
        }
        this.blm.setVisibility(0);
        XN();
        this.ajF.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(this.ajF.sb()));
        this.mTextTitle.setText(this.ajF.sb());
        this.cvV.T(this.ajF);
        this.blv.c(this.ajF);
        if (this.blv.getHeaderImg() != null) {
            if (this.blv.getIsSimpleThread()) {
                this.blv.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (this.ajF.getAuthor() == null || this.ajF.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajF.getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.blv.getHeaderImg().setVisibility(0);
                this.blv.getHeaderImg().setData(this.ajF);
            } else {
                this.blv.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(this.ajF);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.blz.setLayoutParams(layoutParams);
        this.blv.setUserAfterClickListener(this.aow);
        if (this.blz.c(this.ajF)) {
            this.blA.setVisibility(8);
        } else {
            this.blA.setVisibility(0);
        }
        this.bKs.setText(am.da(this.ajF.rS().video_duration.intValue() * 1000));
        this.blz.setCommentNumClickListener(this);
        this.bJr.setData(this.ajF.sR());
        this.bJr.onChangeSkinType();
        if (this.bJr.getVisibility() == 0) {
            this.blA.setVisibility(0);
        }
        if (com.baidu.tieba.card.m.jt(this.ajF.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.bJr.getGodReplyContent(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            com.baidu.tieba.card.m.a(this.bJr.getPraiseNum(), this.ajF.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XL() {
        this.bKG.removeMessages(202);
        this.bKG.removeMessages(203);
    }

    private void XM() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKH);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKI);
    }

    private void XN() {
        XM();
        XL();
        if (this.bHE != null && this.bHD != null && this.bKq != null) {
            if (com.baidu.tbadk.core.h.oS().oY() && this.ajF != null && this.ajF.rS() != null) {
                this.bHD.setVisibility(0);
                this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bHE.c(this.ajF.rS().thumbnail_url, 10, false);
                stopPlay();
                this.aVG = this.ajF.rS().video_url;
                if (StringUtils.isNull(this.aVG)) {
                    g(true, 4);
                }
                if (this.bMF != null && this.bMF.bfF() != null) {
                    this.bMF.bfF().d(this.ajF.rS());
                    return;
                }
                return;
            }
            this.bHD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.blm, d.g.addresslist_item_bg);
            aj.c(this.bHF, d.g.btn_icon_play_video_n);
            aj.i(this.bKt, d.e.cp_cont_i);
            aj.i(this.bKs, d.e.cp_cont_g);
            aj.k(this.bKu, d.e.common_color_10014);
            aj.k(this.aVm, d.e.cp_bg_line_c);
            if (this.bKt != null) {
                this.bKt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.blz.onChangeSkinType();
            this.mSkinType = i;
            this.blv.onChangeSkinType();
            this.cvV.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bKC;
    }

    public boolean isPlaying() {
        if (this.bKq == null) {
            return false;
        }
        return this.bKq.isPlaying();
    }

    public void startPlay() {
        if (!this.bKC && this.ajF != null && this.ajF.rS() != null && this.bKq != null && x.q(2, this.aVG)) {
            g(true, 2);
            this.bKq.setVideoPath(this.aVG);
            this.bKq.start();
            this.bKq.setLooping(true);
            if (this.bKE != null) {
                this.bKE.start();
            }
            this.bKC = true;
            XI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XI() {
        if (this.ajF != null && this.ajF.rS() != null) {
            String str = this.ajF.sv() ? "floor5" : "frs";
            w wVar = new w();
            wVar.mLocate = str;
            wVar.bGH = this.ajF.getTid();
            wVar.azO = this.ajF.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.ajF.ZH;
            wVar.fAU = this.ajF.ZJ;
            wVar.fAV = this.ajF.ZI;
            wVar.fAW = "";
            wVar.fAY = this.ajF.rS().video_md5;
            if (this.ajF.sF() != null && this.ajF.sF().channelId > 0) {
                wVar.VU = this.ajF.sF().channelId + "";
            } else {
                wVar.VU = "0";
            }
            com.baidu.tieba.play.k.a(this.ajF.rS().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        XM();
        XL();
        g(true, 1);
        if (this.bKq != null) {
            this.bKq.stopPlayback();
            if (this.bKE != null) {
                this.bKE.stop();
            }
        }
        this.bKC = false;
    }

    public View getVideoContainer() {
        return this.bHD;
    }

    public String getPlayUrl() {
        return this.aVG;
    }

    public int getCurrentPosition() {
        if (this.bKq == null) {
            return 0;
        }
        return this.bKq.getCurrentPosition();
    }

    public void setVideoStatsData(w wVar) {
        if (this.bMF != null) {
            this.bMF.setVideoStatsData(wVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.blz != null && this.blv != null) {
            this.blv.setPageUniqueId(bdUniqueId);
        }
    }
}
