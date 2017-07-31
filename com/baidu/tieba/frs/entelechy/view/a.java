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
    private f.d aUM;
    private f.b aUN;
    private View aVB;
    private TbPageContext<?> acp;
    private bl akj;
    private final View.OnClickListener aoG;
    private View.OnClickListener aoM;
    private final View.OnClickListener aoW;
    public FrameLayout bDZ;
    private TbImageView bEa;
    private ImageView bEb;
    private TbImageView.a bEd;
    private HeadPendantClickableView bFM;
    private ThreadGodReplyLayout bFN;
    private QuickVideoView bGM;
    private TextView bGO;
    private TextView bGP;
    private View bGQ;
    private AudioAnimationView bGR;
    private ProgressBar bGS;
    private ImageView bGT;
    private View bGV;
    private int bGW;
    private int bGX;
    private boolean bGY;
    private com.baidu.tieba.play.i bHa;
    private Animation bHb;
    private Handler bHc;
    private Runnable bHd;
    private Runnable bHe;
    private QuickVideoView.b bHf;
    private i.a bHj;
    private Animation.AnimationListener bHk;
    private m bJd;
    private View bhj;
    private RelativeLayout bkM;
    public ThreadUserInfoLayout bkV;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    public View bla;
    public LinearLayout bld;
    public ThreadSkinView ble;
    public TextView coF;
    public LinearLayout coG;
    private com.baidu.tieba.frs.g.g coH;
    private ViewTreeObserver.OnGlobalLayoutListener coI;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGW = 0;
        this.bGX = 1;
        this.bGY = false;
        this.bHc = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.Wm();
                        return;
                    case 203:
                        a.this.Wn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUM = new f.d() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bHc.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aUN = new f.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                a.this.Wo();
                a.this.f(true, 4);
                return true;
            }
        };
        this.bEd = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && a.this.bEa != null) {
                    a.this.bEa.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.coI = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bDZ != null && a.this.bDZ.getLayoutParams() != null && a.this.bDZ.getVisibility() != 8) {
                    a.this.bDZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bDZ.getLayoutParams();
                    if (a.this.bDZ.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bDZ.getWidth() * 0.5625d);
                        a.this.bDZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bHd = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bGM != null && !a.this.bGM.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.bHe = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.Wo();
                a.this.f(true, 4);
            }
        };
        this.bHf = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akj != null && !StringUtils.isNull(a.this.akj.rK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.acp.getPageActivity()).createNormalCfg(a.this.akj.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aoG != null) {
                        a.this.aoG.onClick(view);
                    }
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We() != null) {
                    a.this.We().a(view, a.this.akj);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akj != null && a.this.We() != null) {
                    a.this.We().a(view, a.this.akj);
                }
            }
        };
        this.bHj = new i.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.i.a
            public void Wr() {
                a.this.WE();
            }
        };
        this.bHk = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bGX == 3 && a.this.bEa != null) {
                    a.this.bEa.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.acp = tbPageContext;
        View view = getView();
        this.aVB = view.findViewById(d.h.divider_line);
        this.bkM = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.coG = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bkM.setOnClickListener(this);
        this.bFM = (HeadPendantClickableView) this.bkM.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.acp.getPageActivity(), d.f.ds70));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.coF = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.coF.setVisibility(8);
        this.coF.setOnClickListener(this.aoM);
        this.bGS = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bGT = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bkV = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bkV.setFrom(3);
        this.bla = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setIsBarViewVisible(false);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bDZ = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bDZ.setOnClickListener(this);
        this.bDZ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bDZ != null) {
                    a.this.bDZ.getViewTreeObserver().addOnGlobalLayoutListener(a.this.coI);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bDZ != null) {
                    a.this.bDZ.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.coI);
                }
            }
        });
        this.bEa = (TbImageView) view.findViewById(d.h.image_video);
        this.bEa.setPageId(getTag());
        this.bEa.setDefaultErrorResource(0);
        this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEa.setEvent(this.bEd);
        this.bEa.setGifIconSupport(false);
        this.bEb = (ImageView) view.findViewById(d.h.image_video_play);
        this.bGR = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bGR.setCertainColumnCount(4);
        this.bGR.setColumnColor(d.e.cp_cont_i);
        this.bGM = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bJd = new m(this.acp.getPageActivity());
        this.bGM.setBusiness(this.bJd);
        this.bGM.setOnPreparedListener(this.aUM);
        this.bGM.setOnErrorListener(this.aUN);
        this.bGM.setOnSurfaceDestroyedListener(this.bHf);
        this.bHa = new com.baidu.tieba.play.i();
        this.bHa.setPlayer(this.bGM);
        this.bHa.a(this.bHj);
        this.bGV = view.findViewById(d.h.auto_video_black_mask);
        this.bGP = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bGQ = view.findViewById(d.h.auto_video_error_background);
        this.bld = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.ble = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bHb = AnimationUtils.loadAnimation(this.acp.getPageActivity(), d.a.fade_out_video_cover);
        this.bHb.setAnimationListener(this.bHk);
        this.bGO = (TextView) view.findViewById(d.h.text_video_duration);
        this.coH = new com.baidu.tieba.frs.g.g(tbPageContext, this.bkV);
        this.coH.setUniqueId(getTag());
        this.bhj = view.findViewById(d.h.divider_line);
        this.bFN = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bFN.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkM || view == this.bkZ.getCommentNumView() || view == this.coG) {
            X(this.bkM);
        } else if (view == this.bDZ) {
            X(this.bDZ);
        } else if (view == this.bFN) {
            X(this.bFN);
        }
        if (this.akj != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.akj));
        }
    }

    private void X(View view) {
        if (this.akj != null) {
            if (this.akj.sz()) {
                TiebaStatic.log(new aj("c10242").aa("fid", String.valueOf(this.akj.getFid())).r("obj_type", 2));
            } else {
                aj ajVar = new aj("c11100");
                ajVar.aa("tid", this.akj.getId());
                ajVar.aa("fid", this.akj.getFid() + "");
                TiebaStatic.log(ajVar);
            }
            if (this.akj.getAuthor() != null && this.akj.getAuthor().getGodUserData() != null && this.akj.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", this.akj.getId()));
            }
        }
        if (We() != null) {
            We().a(view, this.akj);
        }
        if (this.akj != null) {
            com.baidu.tieba.card.m.jd(this.akj.getId());
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            s.gS(this.akj.getId());
            if (this.akj.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.btw()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.acp.getPageActivity()).createHistoryCfg(this.akj.getTid(), String.valueOf(this.akj.sb()), false, true, com.baidu.tieba.card.m.rw());
                createHistoryCfg.setVideo_source(this.akj.sz() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.akj.sI());
                createHistoryCfg.setSmartFrsPosition(this.akj.sP());
                createHistoryCfg.setForumId(String.valueOf(this.akj.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bFN) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.acp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.acp.getPageActivity()).createFromThreadCfg(this.akj, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.akj.sz() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.akj.sI());
            createFromThreadCfg.setSmartFrsPosition(this.akj.sP());
            createFromThreadCfg.setForumId(String.valueOf(this.akj.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bFN) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.acp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
        this.akj = blVar;
        Oy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wm() {
        this.bHc.removeMessages(202);
        if (this.bGM.getCurrentPosition() > 0) {
            f(true, 3);
            this.bHc.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bHc.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bHc.removeMessages(203);
        int currentPosition = this.bGM.getCurrentPosition();
        if (currentPosition != this.bGW) {
            this.bGW = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bHc.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bEb != null && this.bEa != null && this.bGV != null && this.bGR != null && this.bGS != null && this.bGT != null && this.bGQ != null && this.bGP != null) {
            if (z || this.bGX != i) {
                this.bGX = i;
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHe);
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHd);
                if (i == 2) {
                    this.bEb.setVisibility(8);
                    this.bHb.cancel();
                    this.bEa.clearAnimation();
                    this.bEa.setVisibility(0);
                    this.bGV.setVisibility(0);
                    this.bGO.setVisibility(0);
                    this.bGS.setVisibility(0);
                    this.bGT.setVisibility(0);
                    this.bGQ.setVisibility(8);
                    this.bGP.setVisibility(8);
                    this.bGR.setVisibility(8);
                    this.bGR.bwC();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHe, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bEb.setVisibility(8);
                    this.bEa.startAnimation(this.bHb);
                    this.bGV.setVisibility(8);
                    this.bGO.setVisibility(8);
                    this.bGS.setVisibility(8);
                    this.bGT.setVisibility(8);
                    this.bGQ.setVisibility(8);
                    this.bGP.setVisibility(8);
                    this.bGR.setVisibility(0);
                    this.bGR.start();
                } else if (i == 4) {
                    this.bEb.setVisibility(8);
                    this.bEa.startAnimation(this.bHb);
                    this.bGV.setVisibility(8);
                    this.bGS.setVisibility(8);
                    this.bGT.setVisibility(8);
                    this.bGQ.setVisibility(0);
                    this.bGP.setVisibility(0);
                    this.bGR.setVisibility(8);
                    this.bGR.bwC();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHd, 2000L);
                } else {
                    this.bEb.setVisibility(0);
                    this.bGO.setVisibility(0);
                    this.bHb.cancel();
                    this.bEa.clearAnimation();
                    this.bEa.setVisibility(0);
                    this.bGV.setVisibility(0);
                    this.bGS.setVisibility(8);
                    this.bGT.setVisibility(8);
                    this.bGQ.setVisibility(8);
                    this.bGP.setVisibility(8);
                    this.bGR.setVisibility(8);
                    this.bGR.bwC();
                }
            }
        }
    }

    private void Oy() {
        if (this.akj == null || this.akj.getAuthor() == null) {
            this.bkM.setVisibility(8);
            return;
        }
        this.bkM.setVisibility(0);
        Wq();
        this.akj.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.akj.sf()));
        this.mTextTitle.setText(this.akj.sf());
        this.coH.P(this.akj);
        this.bkV.a(this.akj);
        if (this.bkV.getHeaderImg() != null) {
            if (this.bkV.getIsSimpleThread()) {
                this.bkV.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (this.akj.getAuthor() == null || this.akj.getAuthor().getPendantData() == null || StringUtils.isNull(this.akj.getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.bkV.getHeaderImg().setVisibility(0);
                this.bkV.getHeaderImg().setData(this.akj);
            } else {
                this.bkV.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(this.akj);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bkZ.setLayoutParams(layoutParams);
        this.bkV.setUserAfterClickListener(this.aoW);
        if (this.bkZ.a(this.akj)) {
            this.bla.setVisibility(8);
        } else {
            this.bla.setVisibility(0);
        }
        this.bGO.setText(al.cZ(this.akj.rW().video_duration.intValue() * 1000));
        this.bkZ.setCommentNumClickListener(this);
        this.bFN.setData(this.akj.sU());
        this.bFN.onChangeSkinType();
        if (this.bFN.getVisibility() == 0) {
            this.bla.setVisibility(0);
        }
        if (com.baidu.tieba.card.m.je(this.akj.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.bFN.getGodReplyContent(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            com.baidu.tieba.card.m.a(this.bFN.getPraiseNum(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.acp, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wo() {
        this.bHc.removeMessages(202);
        this.bHc.removeMessages(203);
    }

    private void Wp() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHd);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHe);
    }

    private void Wq() {
        Wp();
        Wo();
        if (this.bEa != null && this.bDZ != null && this.bGM != null) {
            if (com.baidu.tbadk.core.h.oX().pd() && this.akj != null && this.akj.rW() != null) {
                this.bDZ.setVisibility(0);
                this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEa.c(this.akj.rW().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.akj.rW().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.bJd != null && this.bJd.bfO() != null) {
                    this.bJd.bfO().d(this.akj.rW());
                    return;
                }
                return;
            }
            this.bDZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkM, d.g.addresslist_item_bg);
            ai.c(this.bEb, d.g.btn_icon_play_video_n);
            ai.i(this.bGP, d.e.cp_cont_i);
            ai.i(this.bGO, d.e.cp_cont_g);
            ai.k(this.bGQ, d.e.common_color_10014);
            ai.k(this.aVB, d.e.cp_bg_line_c);
            if (this.bGP != null) {
                this.bGP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bkZ.onChangeSkinType();
            this.mSkinType = i;
            this.bkV.onChangeSkinType();
            this.coH.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bGY;
    }

    public boolean isPlaying() {
        if (this.bGM == null) {
            return false;
        }
        return this.bGM.isPlaying();
    }

    public void startPlay() {
        if (!this.bGY && this.akj != null && this.akj.rW() != null && this.bGM != null && x.r(2, this.mVideoUrl)) {
            f(true, 2);
            this.bGM.setVideoPath(this.mVideoUrl);
            this.bGM.start();
            this.bGM.setLooping(true);
            if (this.bHa != null) {
                this.bHa.start();
            }
            this.bGY = true;
            WE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        if (this.akj != null && this.akj.rW() != null) {
            String str = this.akj.sz() ? "floor5" : "frs";
            w wVar = new w();
            wVar.mLocate = str;
            wVar.bDd = this.akj.getTid();
            wVar.aAB = this.akj.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.akj.aaA;
            wVar.fAx = this.akj.aaC;
            wVar.fAy = this.akj.aaB;
            wVar.fAz = "";
            if (this.akj.sJ() != null && this.akj.sJ().channelId > 0) {
                wVar.WI = this.akj.sJ().channelId + "";
            } else {
                wVar.WI = "0";
            }
            com.baidu.tieba.play.k.a(this.akj.rW().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        Wp();
        Wo();
        f(true, 1);
        if (this.bGM != null) {
            this.bGM.stopPlayback();
            if (this.bHa != null) {
                this.bHa.stop();
            }
        }
        this.bGY = false;
    }

    public View getVideoContainer() {
        return this.bDZ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bGM == null) {
            return 0;
        }
        return this.bGM.getCurrentPosition();
    }

    public void setVideoStatsData(w wVar) {
        if (this.bJd != null) {
            this.bJd.setVideoStatsData(wVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkZ != null && this.bkV != null) {
            this.bkV.setPageUniqueId(bdUniqueId);
        }
    }
}
