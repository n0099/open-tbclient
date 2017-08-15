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
    private f.d aUN;
    private f.b aUO;
    private View aVC;
    private TbPageContext<?> acr;
    private bl akl;
    private final View.OnClickListener aoH;
    private View.OnClickListener aoN;
    private final View.OnClickListener aoX;
    public FrameLayout bEI;
    private TbImageView bEJ;
    private ImageView bEK;
    private TbImageView.a bEM;
    private HeadPendantClickableView bGv;
    private ThreadGodReplyLayout bGw;
    private AudioAnimationView bHA;
    private ProgressBar bHB;
    private ImageView bHC;
    private View bHE;
    private int bHF;
    private int bHG;
    private boolean bHH;
    private com.baidu.tieba.play.i bHJ;
    private Animation bHK;
    private Handler bHL;
    private Runnable bHM;
    private Runnable bHN;
    private QuickVideoView.b bHO;
    private i.a bHS;
    private Animation.AnimationListener bHT;
    private QuickVideoView bHv;
    private TextView bHx;
    private TextView bHy;
    private View bHz;
    private m bJM;
    private View bhj;
    private RelativeLayout bkQ;
    public ThreadUserInfoLayout bkZ;
    public ThreadCommentAndPraiseInfoLayout bld;
    public View ble;
    public LinearLayout blh;
    public ThreadSkinView bli;
    public TextView cpn;
    public LinearLayout cpo;
    private com.baidu.tieba.frs.g.g cpp;
    private ViewTreeObserver.OnGlobalLayoutListener cpq;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bHF = 0;
        this.bHG = 1;
        this.bHH = false;
        this.bHL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.WI();
                        return;
                    case 203:
                        a.this.WJ();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUN = new f.d() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bHL.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aUO = new f.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                a.this.WK();
                a.this.f(true, 4);
                return true;
            }
        };
        this.bEM = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && a.this.bEJ != null) {
                    a.this.bEJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cpq = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bEI != null && a.this.bEI.getLayoutParams() != null && a.this.bEI.getVisibility() != 8) {
                    a.this.bEI.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bEI.getLayoutParams();
                    if (a.this.bEI.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bEI.getWidth() * 0.5625d);
                        a.this.bEI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bHM = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bHv != null && !a.this.bHv.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.bHN = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.WK();
                a.this.f(true, 4);
            }
        };
        this.bHO = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akl != null && !StringUtils.isNull(a.this.akl.rK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.acr.getPageActivity()).createNormalCfg(a.this.akl.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aoH != null) {
                        a.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.WA() != null) {
                    a.this.WA().a(view, a.this.akl);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akl != null && a.this.WA() != null) {
                    a.this.WA().a(view, a.this.akl);
                }
            }
        };
        this.bHS = new i.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.i.a
            public void WN() {
                a.this.Xa();
            }
        };
        this.bHT = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bHG == 3 && a.this.bEJ != null) {
                    a.this.bEJ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.acr = tbPageContext;
        View view = getView();
        this.aVC = view.findViewById(d.h.divider_line);
        this.bkQ = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.cpo = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bkQ.setOnClickListener(this);
        this.bGv = (HeadPendantClickableView) this.bkQ.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds70));
        }
        this.bGv.wD();
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.cpn = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.cpn.setVisibility(8);
        this.cpn.setOnClickListener(this.aoN);
        this.bHB = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bHC = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bkZ = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bkZ.setFrom(3);
        this.ble = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bld.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bld.setLayoutParams(layoutParams);
        }
        this.bld.setOnClickListener(this);
        this.bld.setReplyTimeVisible(false);
        this.bld.setShowPraiseNum(true);
        this.bld.setNeedAddPraiseIcon(true);
        this.bld.setNeedAddReplyIcon(true);
        this.bld.setIsBarViewVisible(false);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bEI = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bEI.setOnClickListener(this);
        this.bEI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bEI != null) {
                    a.this.bEI.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cpq);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bEI != null) {
                    a.this.bEI.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cpq);
                }
            }
        });
        this.bEJ = (TbImageView) view.findViewById(d.h.image_video);
        this.bEJ.setPageId(getTag());
        this.bEJ.setDefaultErrorResource(0);
        this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEJ.setEvent(this.bEM);
        this.bEJ.setGifIconSupport(false);
        this.bEK = (ImageView) view.findViewById(d.h.image_video_play);
        this.bHA = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bHA.setCertainColumnCount(4);
        this.bHA.setColumnColor(d.e.cp_cont_i);
        this.bHv = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bJM = new m(this.acr.getPageActivity());
        this.bHv.setBusiness(this.bJM);
        this.bHv.setOnPreparedListener(this.aUN);
        this.bHv.setOnErrorListener(this.aUO);
        this.bHv.setOnSurfaceDestroyedListener(this.bHO);
        this.bHJ = new com.baidu.tieba.play.i();
        this.bHJ.setPlayer(this.bHv);
        this.bHJ.a(this.bHS);
        this.bHE = view.findViewById(d.h.auto_video_black_mask);
        this.bHy = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bHz = view.findViewById(d.h.auto_video_error_background);
        this.blh = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bli = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bHK = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.fade_out_video_cover);
        this.bHK.setAnimationListener(this.bHT);
        this.bHx = (TextView) view.findViewById(d.h.text_video_duration);
        this.cpp = new com.baidu.tieba.frs.g.g(tbPageContext, this.bkZ);
        this.cpp.setUniqueId(getTag());
        this.bhj = view.findViewById(d.h.divider_line);
        this.bGw = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bGw.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkQ || view == this.bld.getCommentNumView() || view == this.cpo) {
            X(this.bkQ);
        } else if (view == this.bEI) {
            X(this.bEI);
        } else if (view == this.bGw) {
            X(this.bGw);
        }
        if (this.akl != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.akl));
        }
    }

    private void X(View view) {
        if (this.akl != null) {
            if (this.akl.sz()) {
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
        if (WA() != null) {
            WA().a(view, this.akl);
        }
        if (this.akl != null) {
            com.baidu.tieba.card.m.je(this.akl.getId());
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            s.gS(this.akl.getId());
            if (this.akl.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.bue()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.acr.getPageActivity()).createHistoryCfg(this.akl.getTid(), String.valueOf(this.akl.sb()), false, true, com.baidu.tieba.card.m.rw());
                createHistoryCfg.setVideo_source(this.akl.sz() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.akl.sI());
                createHistoryCfg.setSmartFrsPosition(this.akl.sP());
                createHistoryCfg.setForumId(String.valueOf(this.akl.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bGw) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.acr.getPageActivity()).createFromThreadCfg(this.akl, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.akl.sz() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.akl.sI());
            createFromThreadCfg.setSmartFrsPosition(this.akl.sP());
            createFromThreadCfg.setForumId(String.valueOf(this.akl.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bGw) {
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
        Oy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WI() {
        this.bHL.removeMessages(202);
        if (this.bHv.getCurrentPosition() > 0) {
            f(true, 3);
            this.bHL.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bHL.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WJ() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bHL.removeMessages(203);
        int currentPosition = this.bHv.getCurrentPosition();
        if (currentPosition != this.bHF) {
            this.bHF = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bHL.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bEK != null && this.bEJ != null && this.bHE != null && this.bHA != null && this.bHB != null && this.bHC != null && this.bHz != null && this.bHy != null) {
            if (z || this.bHG != i) {
                this.bHG = i;
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHM);
                if (i == 2) {
                    this.bEK.setVisibility(8);
                    this.bHK.cancel();
                    this.bEJ.clearAnimation();
                    this.bEJ.setVisibility(0);
                    this.bHE.setVisibility(0);
                    this.bHx.setVisibility(0);
                    this.bHB.setVisibility(0);
                    this.bHC.setVisibility(0);
                    this.bHz.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHA.bxk();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHN, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bEK.setVisibility(8);
                    this.bEJ.startAnimation(this.bHK);
                    this.bHE.setVisibility(8);
                    this.bHx.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHA.setVisibility(0);
                    this.bHA.start();
                } else if (i == 4) {
                    this.bEK.setVisibility(8);
                    this.bEJ.startAnimation(this.bHK);
                    this.bHE.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHz.setVisibility(0);
                    this.bHy.setVisibility(0);
                    this.bHA.setVisibility(8);
                    this.bHA.bxk();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHM, 2000L);
                } else {
                    this.bEK.setVisibility(0);
                    this.bHx.setVisibility(0);
                    this.bHK.cancel();
                    this.bEJ.clearAnimation();
                    this.bEJ.setVisibility(0);
                    this.bHE.setVisibility(0);
                    this.bHB.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHA.bxk();
                }
            }
        }
    }

    private void Oy() {
        if (this.akl == null || this.akl.getAuthor() == null) {
            this.bkQ.setVisibility(8);
            return;
        }
        this.bkQ.setVisibility(0);
        WM();
        this.akl.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.akl.sf()));
        this.mTextTitle.setText(this.akl.sf());
        this.cpp.P(this.akl);
        this.bkZ.a(this.akl);
        if (this.bkZ.getHeaderImg() != null) {
            if (this.bkZ.getIsSimpleThread()) {
                this.bkZ.getHeaderImg().setVisibility(8);
                this.bGv.setVisibility(8);
            } else if (this.akl.getAuthor() == null || this.akl.getAuthor().getPendantData() == null || StringUtils.isNull(this.akl.getAuthor().getPendantData().pV())) {
                this.bGv.setVisibility(8);
                this.bkZ.getHeaderImg().setVisibility(0);
                this.bkZ.getHeaderImg().setData(this.akl);
            } else {
                this.bkZ.getHeaderImg().setVisibility(4);
                this.bGv.setVisibility(0);
                this.bGv.setData(this.akl);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bld.setLayoutParams(layoutParams);
        this.bkZ.setUserAfterClickListener(this.aoX);
        if (this.bld.a(this.akl)) {
            this.ble.setVisibility(8);
        } else {
            this.ble.setVisibility(0);
        }
        this.bHx.setText(al.cZ(this.akl.rW().video_duration.intValue() * 1000));
        this.bld.setCommentNumClickListener(this);
        this.bGw.setData(this.akl.sU());
        this.bGw.onChangeSkinType();
        if (this.bGw.getVisibility() == 0) {
            this.ble.setVisibility(0);
        }
        if (com.baidu.tieba.card.m.jf(this.akl.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.bGw.getGodReplyContent(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            com.baidu.tieba.card.m.a(this.bGw.getPraiseNum(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WK() {
        this.bHL.removeMessages(202);
        this.bHL.removeMessages(203);
    }

    private void WL() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHM);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
    }

    private void WM() {
        WL();
        WK();
        if (this.bEJ != null && this.bEI != null && this.bHv != null) {
            if (com.baidu.tbadk.core.h.oX().pd() && this.akl != null && this.akl.rW() != null) {
                this.bEI.setVisibility(0);
                this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEJ.c(this.akl.rW().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.akl.rW().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.bJM != null && this.bJM.bgu() != null) {
                    this.bJM.bgu().d(this.akl.rW());
                    return;
                }
                return;
            }
            this.bEI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkQ, d.g.addresslist_item_bg);
            ai.c(this.bEK, d.g.btn_icon_play_video_n);
            ai.i(this.bHy, d.e.cp_cont_i);
            ai.i(this.bHx, d.e.cp_cont_g);
            ai.k(this.bHz, d.e.common_color_10014);
            ai.k(this.aVC, d.e.cp_bg_line_c);
            if (this.bHy != null) {
                this.bHy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bld.onChangeSkinType();
            this.mSkinType = i;
            this.bkZ.onChangeSkinType();
            this.cpp.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bHH;
    }

    public boolean isPlaying() {
        if (this.bHv == null) {
            return false;
        }
        return this.bHv.isPlaying();
    }

    public void startPlay() {
        if (!this.bHH && this.akl != null && this.akl.rW() != null && this.bHv != null && x.r(2, this.mVideoUrl)) {
            f(true, 2);
            this.bHv.setVideoPath(this.mVideoUrl);
            this.bHv.start();
            this.bHv.setLooping(true);
            if (this.bHJ != null) {
                this.bHJ.start();
            }
            this.bHH = true;
            Xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        if (this.akl != null && this.akl.rW() != null) {
            String str = this.akl.sz() ? "floor5" : "frs";
            w wVar = new w();
            wVar.mLocate = str;
            wVar.bDM = this.akl.getTid();
            wVar.aAC = this.akl.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.akl.aaC;
            wVar.fCq = this.akl.aaE;
            wVar.fCr = this.akl.aaD;
            wVar.fCs = "";
            if (this.akl.sJ() != null && this.akl.sJ().channelId > 0) {
                wVar.WK = this.akl.sJ().channelId + "";
            } else {
                wVar.WK = "0";
            }
            com.baidu.tieba.play.k.a(this.akl.rW().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        WL();
        WK();
        f(true, 1);
        if (this.bHv != null) {
            this.bHv.stopPlayback();
            if (this.bHJ != null) {
                this.bHJ.stop();
            }
        }
        this.bHH = false;
    }

    public View getVideoContainer() {
        return this.bEI;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bHv == null) {
            return 0;
        }
        return this.bHv.getCurrentPosition();
    }

    public void setVideoStatsData(w wVar) {
        if (this.bJM != null) {
            this.bJM.setVideoStatsData(wVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bld != null && this.bkZ != null) {
            this.bkZ.setPageUniqueId(bdUniqueId);
        }
    }
}
