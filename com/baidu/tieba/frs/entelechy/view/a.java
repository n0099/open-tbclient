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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
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
public class a extends com.baidu.tieba.card.a<bl> implements v {
    private f.d aUO;
    private f.b aUP;
    private View aVD;
    private TbPageContext<?> acr;
    private bl akl;
    private final View.OnClickListener aoH;
    private View.OnClickListener aoN;
    private final View.OnClickListener aoX;
    public FrameLayout bEJ;
    private TbImageView bEK;
    private ImageView bEL;
    private TbImageView.a bEN;
    private HeadPendantClickableView bGw;
    private ThreadGodReplyLayout bGx;
    private View bHA;
    private AudioAnimationView bHB;
    private ProgressBar bHC;
    private ImageView bHD;
    private View bHF;
    private int bHG;
    private int bHH;
    private boolean bHI;
    private com.baidu.tieba.play.i bHK;
    private Animation bHL;
    private Handler bHM;
    private Runnable bHN;
    private Runnable bHO;
    private QuickVideoView.b bHP;
    private i.a bHT;
    private Animation.AnimationListener bHU;
    private QuickVideoView bHw;
    private TextView bHy;
    private TextView bHz;
    private m bJN;
    private View bhk;
    private RelativeLayout bkR;
    public ThreadUserInfoLayout bla;
    public ThreadCommentAndPraiseInfoLayout ble;
    public View blf;
    public LinearLayout bli;
    public ThreadSkinView blj;
    public TextView cpo;
    public LinearLayout cpp;
    private com.baidu.tieba.frs.g.g cpq;
    private ViewTreeObserver.OnGlobalLayoutListener cpr;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bHG = 0;
        this.bHH = 1;
        this.bHI = false;
        this.bHM = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.WF();
                        return;
                    case 203:
                        a.this.WG();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUO = new f.d() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bHM.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aUP = new f.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                a.this.WH();
                a.this.f(true, 4);
                return true;
            }
        };
        this.bEN = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && a.this.bEK != null) {
                    a.this.bEK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cpr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bEJ != null && a.this.bEJ.getLayoutParams() != null && a.this.bEJ.getVisibility() != 8) {
                    a.this.bEJ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bEJ.getLayoutParams();
                    if (a.this.bEJ.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bEJ.getWidth() * 0.5625d);
                        a.this.bEJ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bHN = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bHw != null && !a.this.bHw.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.bHO = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.WH();
                a.this.f(true, 4);
            }
        };
        this.bHP = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akl != null && !StringUtils.isNull(a.this.akl.rL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.acr.getPageActivity()).createNormalCfg(a.this.akl.rL(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aoH != null) {
                        a.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Wx() != null) {
                    a.this.Wx().a(view, a.this.akl);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akl != null && a.this.Wx() != null) {
                    a.this.Wx().a(view, a.this.akl);
                }
            }
        };
        this.bHT = new i.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.i.a
            public void WK() {
                a.this.WX();
            }
        };
        this.bHU = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bHH == 3 && a.this.bEK != null) {
                    a.this.bEK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.acr = tbPageContext;
        View view = getView();
        this.aVD = view.findViewById(d.h.divider_line);
        this.bkR = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.cpp = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bkR.setOnClickListener(this);
        this.bGw = (HeadPendantClickableView) this.bkR.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds70));
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.cpo = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.cpo.setVisibility(8);
        this.cpo.setOnClickListener(this.aoN);
        this.bHC = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bHD = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bla = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bla.setFrom(3);
        this.blf = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setIsBarViewVisible(false);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bEJ = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bEJ.setOnClickListener(this);
        this.bEJ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bEJ != null) {
                    a.this.bEJ.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cpr);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bEJ != null) {
                    a.this.bEJ.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cpr);
                }
            }
        });
        this.bEK = (TbImageView) view.findViewById(d.h.image_video);
        this.bEK.setPageId(getTag());
        this.bEK.setDefaultErrorResource(0);
        this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEK.setEvent(this.bEN);
        this.bEK.setGifIconSupport(false);
        this.bEL = (ImageView) view.findViewById(d.h.image_video_play);
        this.bHB = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bHB.setCertainColumnCount(4);
        this.bHB.setColumnColor(d.e.cp_cont_i);
        this.bHw = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bJN = new m(this.acr.getPageActivity());
        this.bHw.setBusiness(this.bJN);
        this.bHw.setOnPreparedListener(this.aUO);
        this.bHw.setOnErrorListener(this.aUP);
        this.bHw.setOnSurfaceDestroyedListener(this.bHP);
        this.bHK = new com.baidu.tieba.play.i();
        this.bHK.setPlayer(this.bHw);
        this.bHK.a(this.bHT);
        this.bHF = view.findViewById(d.h.auto_video_black_mask);
        this.bHz = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bHA = view.findViewById(d.h.auto_video_error_background);
        this.bli = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.blj = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bHL = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.fade_out_video_cover);
        this.bHL.setAnimationListener(this.bHU);
        this.bHy = (TextView) view.findViewById(d.h.text_video_duration);
        this.cpq = new com.baidu.tieba.frs.g.g(tbPageContext, this.bla);
        this.cpq.setUniqueId(getTag());
        this.bhk = view.findViewById(d.h.divider_line);
        this.bGx = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bGx.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkR || view == this.ble.getCommentNumView() || view == this.cpp) {
            W(this.bkR);
        } else if (view == this.bEJ) {
            W(this.bEJ);
        } else if (view == this.bGx) {
            W(this.bGx);
        }
        if (this.akl != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.akl));
        }
    }

    private void W(View view) {
        if (this.akl != null) {
            if (this.akl.sA()) {
                TiebaStatic.log(new aj("c10242").aa("fid", String.valueOf(this.akl.getFid())).r("obj_type", 2));
            } else {
                aj ajVar = new aj("c11100");
                ajVar.aa("tid", this.akl.getId());
                ajVar.aa("fid", this.akl.getFid() + "");
                TiebaStatic.log(ajVar);
            }
            if (this.akl.getAuthor() != null && this.akl.getAuthor().getGodUserData() != null && this.akl.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", this.akl.getId()));
            }
        }
        if (Wx() != null) {
            Wx().a(view, this.akl);
        }
        if (this.akl != null) {
            com.baidu.tieba.card.m.jh(this.akl.getId());
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            s.gV(this.akl.getId());
            if (this.akl.sc() > 0 && com.baidu.tieba.tbadkCore.util.g.btX()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.acr.getPageActivity()).createHistoryCfg(this.akl.getTid(), String.valueOf(this.akl.sc()), false, true, com.baidu.tieba.card.m.rx());
                createHistoryCfg.setVideo_source(this.akl.sA() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.akl.sJ());
                createHistoryCfg.setSmartFrsPosition(this.akl.sQ());
                createHistoryCfg.setForumId(String.valueOf(this.akl.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bGx) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.acr.getPageActivity()).createFromThreadCfg(this.akl, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.akl.sA() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.akl.sJ());
            createFromThreadCfg.setSmartFrsPosition(this.akl.sQ());
            createFromThreadCfg.setForumId(String.valueOf(this.akl.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bGx) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(bl blVar) {
        this.akl = blVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WF() {
        this.bHM.removeMessages(202);
        if (this.bHw.getCurrentPosition() > 0) {
            f(true, 3);
            this.bHM.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bHM.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WG() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bHM.removeMessages(203);
        int currentPosition = this.bHw.getCurrentPosition();
        if (currentPosition != this.bHG) {
            this.bHG = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bHM.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bEL != null && this.bEK != null && this.bHF != null && this.bHB != null && this.bHC != null && this.bHD != null && this.bHA != null && this.bHz != null) {
            if (z || this.bHH != i) {
                this.bHH = i;
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHO);
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
                if (i == 2) {
                    this.bEL.setVisibility(8);
                    this.bHL.cancel();
                    this.bEK.clearAnimation();
                    this.bEK.setVisibility(0);
                    this.bHF.setVisibility(0);
                    this.bHy.setVisibility(0);
                    this.bHC.setVisibility(0);
                    this.bHD.setVisibility(0);
                    this.bHA.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHB.bxd();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHO, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bEL.setVisibility(8);
                    this.bEK.startAnimation(this.bHL);
                    this.bHF.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHD.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHB.setVisibility(0);
                    this.bHB.start();
                } else if (i == 4) {
                    this.bEL.setVisibility(8);
                    this.bEK.startAnimation(this.bHL);
                    this.bHF.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHD.setVisibility(8);
                    this.bHA.setVisibility(0);
                    this.bHz.setVisibility(0);
                    this.bHB.setVisibility(8);
                    this.bHB.bxd();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHN, 2000L);
                } else {
                    this.bEL.setVisibility(0);
                    this.bHy.setVisibility(0);
                    this.bHL.cancel();
                    this.bEK.clearAnimation();
                    this.bEK.setVisibility(0);
                    this.bHF.setVisibility(0);
                    this.bHC.setVisibility(8);
                    this.bHD.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHB.bxd();
                }
            }
        }
    }

    private void refreshView() {
        if (this.akl == null || this.akl.getAuthor() == null) {
            this.bkR.setVisibility(8);
            return;
        }
        this.bkR.setVisibility(0);
        WJ();
        this.akl.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.akl.sg()));
        this.mTextTitle.setText(this.akl.sg());
        this.cpq.P(this.akl);
        this.bla.a(this.akl);
        if (this.bla.getHeaderImg() != null) {
            if (this.bla.getIsSimpleThread()) {
                this.bla.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (this.akl.getAuthor() == null || this.akl.getAuthor().getPendantData() == null || StringUtils.isNull(this.akl.getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.bla.getHeaderImg().setVisibility(0);
                this.bla.getHeaderImg().setData(this.akl);
            } else {
                this.bla.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(this.akl);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.ble.setLayoutParams(layoutParams);
        this.bla.setUserAfterClickListener(this.aoX);
        if (this.ble.a(this.akl)) {
            this.blf.setVisibility(8);
        } else {
            this.blf.setVisibility(0);
        }
        this.bHy.setText(al.cZ(this.akl.rX().video_duration.intValue() * 1000));
        this.ble.setCommentNumClickListener(this);
        this.bGx.setData(this.akl.sV());
        this.bGx.onChangeSkinType();
        if (this.bGx.getVisibility() == 0) {
            this.blf.setVisibility(0);
        }
        if (com.baidu.tieba.card.m.ji(this.akl.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.bGx.getGodReplyContent(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            com.baidu.tieba.card.m.a(this.bGx.getPraiseNum(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WH() {
        this.bHM.removeMessages(202);
        this.bHM.removeMessages(203);
    }

    private void WI() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHO);
    }

    private void WJ() {
        WI();
        WH();
        if (this.bEK != null && this.bEJ != null && this.bHw != null) {
            if (com.baidu.tbadk.core.h.oY().pe() && this.akl != null && this.akl.rX() != null) {
                this.bEJ.setVisibility(0);
                this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEK.c(this.akl.rX().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.akl.rX().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.bJN != null && this.bJN.bgp() != null) {
                    this.bJN.bgp().d(this.akl.rX());
                    return;
                }
                return;
            }
            this.bEJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkR, d.g.addresslist_item_bg);
            ai.c(this.bEL, d.g.btn_icon_play_video_n);
            ai.i(this.bHz, d.e.cp_cont_i);
            ai.i(this.bHy, d.e.cp_cont_g);
            ai.k(this.bHA, d.e.common_color_10014);
            ai.k(this.aVD, d.e.cp_bg_line_c);
            if (this.bHz != null) {
                this.bHz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ble.onChangeSkinType();
            this.mSkinType = i;
            this.bla.onChangeSkinType();
            this.cpq.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bHI;
    }

    public boolean isPlaying() {
        if (this.bHw == null) {
            return false;
        }
        return this.bHw.isPlaying();
    }

    public void startPlay() {
        if (!this.bHI && this.akl != null && this.akl.rX() != null && this.bHw != null && x.r(2, this.mVideoUrl)) {
            f(true, 2);
            this.bHw.setVideoPath(this.mVideoUrl);
            this.bHw.start();
            this.bHw.setLooping(true);
            if (this.bHK != null) {
                this.bHK.start();
            }
            this.bHI = true;
            WX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        if (this.akl != null && this.akl.rX() != null) {
            String str = this.akl.sA() ? "floor5" : "frs";
            w wVar = new w();
            wVar.mLocate = str;
            wVar.bDN = this.akl.getTid();
            wVar.aAD = this.akl.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.akl.aaC;
            wVar.fCs = this.akl.aaE;
            wVar.fCt = this.akl.aaD;
            wVar.fCu = "";
            if (this.akl.sK() != null && this.akl.sK().channelId > 0) {
                wVar.WL = this.akl.sK().channelId + "";
            } else {
                wVar.WL = "0";
            }
            com.baidu.tieba.play.k.a(this.akl.rX().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        WI();
        WH();
        f(true, 1);
        if (this.bHw != null) {
            this.bHw.stopPlayback();
            if (this.bHK != null) {
                this.bHK.stop();
            }
        }
        this.bHI = false;
    }

    public View getVideoContainer() {
        return this.bEJ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bHw == null) {
            return 0;
        }
        return this.bHw.getCurrentPosition();
    }

    public void setVideoStatsData(w wVar) {
        if (this.bJN != null) {
            this.bJN.setVideoStatsData(wVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ble != null && this.bla != null) {
            this.bla.setPageUniqueId(bdUniqueId);
        }
    }
}
