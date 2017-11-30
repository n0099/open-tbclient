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
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bd> implements u {
    private g.f aZn;
    private g.b aZo;
    private TbPageContext<?> acd;
    private bd ajM;
    private final View.OnClickListener anO;
    private final View.OnClickListener aob;
    private TbImageView bZX;
    private TextView bZY;
    private HeadPendantClickableView bZa;
    private ThreadGodReplyLayout bZb;
    private String baH;
    private View bam;
    private ImageView bkW;
    private Animation bla;
    private com.baidu.tieba.play.j bll;
    private QuickVideoView.b blr;
    public ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    public View bvI;
    public LinearLayout bvK;
    public ThreadSkinView bvL;
    private RelativeLayout bvu;
    public TextView cOF;
    public LinearLayout cOG;
    private com.baidu.tieba.frs.g.g cOH;
    private ViewTreeObserver.OnGlobalLayoutListener cOI;
    private j.a caB;
    private Animation.AnimationListener caC;
    private View.OnClickListener cac;
    public FrameLayout cae;
    private QuickVideoView caf;
    private TextView cag;
    private TextView cai;
    private View caj;
    private ProgressBar cak;
    private ImageView cal;
    private View can;
    private int cao;
    private int cap;
    private boolean caq;
    private Handler cau;
    private TbImageView.a cav;
    private Runnable caw;
    private Runnable cax;
    private n ccY;
    private LinearLayout ccc;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cao = 0;
        this.cap = 1;
        this.caq = false;
        this.cau = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.abB();
                        return;
                    case 203:
                        a.this.abC();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZn = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.cau.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aZo = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.abD();
                a.this.f(true, 4);
                return true;
            }
        };
        this.cav = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && a.this.bZX != null) {
                    a.this.bZX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cOI = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cae != null && a.this.cae.getLayoutParams() != null && a.this.cae.getVisibility() != 8) {
                    a.this.cae.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cae.getLayoutParams();
                    if (a.this.cae.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cae.getWidth() * 0.5625d);
                        a.this.cae.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.caw = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.caf != null && !a.this.caf.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.cax = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.abD();
                a.this.f(true, 4);
            }
        };
        this.blr = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cac = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajM != null && !StringUtils.isNull(a.this.ajM.rD())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.acd.getPageActivity()).createNormalCfg(a.this.ajM.rD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.anO != null) {
                        a.this.anO.onClick(view);
                    }
                }
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abs() != null) {
                    a.this.abs().a(view, a.this.ajM);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajM != null && a.this.abs() != null) {
                    a.this.abs().a(view, a.this.ajM);
                }
            }
        };
        this.caB = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.j.a
            public void abG() {
                a.this.abA();
            }
        };
        this.caC = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cap == 3 && a.this.bZX != null) {
                    a.this.bZX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.acd = tbPageContext;
        View view = getView();
        this.bam = view.findViewById(d.g.divider_line);
        this.bvu = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cOG = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bvu.setOnClickListener(this);
        this.bZa = (HeadPendantClickableView) this.bvu.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.acd.getPageActivity(), d.e.ds70));
        }
        this.bZa.wk();
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.cOF = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cOF.setVisibility(8);
        this.cOF.setOnClickListener(this.cac);
        this.cak = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.cal = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bvH.setForumAfterClickListener(this.anO);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bvD.setFrom(3);
        this.bvI = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bvH.setOnClickListener(this);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setShareVisible(true);
        this.bvH.setShareReportFrom(1);
        this.bvH.setStType("frs_page");
        this.bvH.setFrom(2);
        this.bvH.anM = 3;
        this.cae = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cae.setOnClickListener(this);
        this.cae.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cae != null) {
                    a.this.cae.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cOI);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cae != null) {
                    a.this.cae.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cOI);
                }
            }
        });
        this.bZX = (TbImageView) view.findViewById(d.g.image_video);
        this.bZX.setPageId(getTag());
        this.bZX.setDefaultErrorResource(0);
        this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bZX.setEvent(this.cav);
        this.bZX.setGifIconSupport(false);
        this.bkW = (ImageView) view.findViewById(d.g.image_video_play);
        this.caf = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.ccY = new n(this.acd.getPageActivity());
        this.caf.setBusiness(this.ccY);
        this.caf.setOnPreparedListener(this.aZn);
        this.caf.setOnErrorListener(this.aZo);
        this.caf.setOnSurfaceDestroyedListener(this.blr);
        this.bll = new com.baidu.tieba.play.j();
        this.bll.setPlayer(this.caf);
        this.bll.a(this.caB);
        this.can = view.findViewById(d.g.auto_video_black_mask);
        this.cai = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.caj = view.findViewById(d.g.auto_video_error_background);
        this.bvK = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bvL = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bla = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.fade_out_video_cover);
        this.bla.setAnimationListener(this.caC);
        this.cag = (TextView) view.findViewById(d.g.text_video_duration);
        this.bZY = (TextView) view.findViewById(d.g.text_video_play_count);
        this.ccc = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cOH = new com.baidu.tieba.frs.g.g(tbPageContext, this.bvu);
        this.cOH.setUniqueId(getTag());
        this.bZb = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZb.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvu || view == this.bvH.getCommentNumView() || view == this.cOG) {
            ah(this.bvu);
        } else if (view == this.cae) {
            ah(this.cae);
        } else if (view == this.bZb) {
            ah(this.bZb);
        }
        if (this.ajM != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajM));
        }
    }

    private void ah(View view) {
        if (this.ajM != null) {
            if (this.ajM.ss()) {
                TiebaStatic.log(new ak("c10242").ac(ImageViewerConfig.FORUM_ID, String.valueOf(this.ajM.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ac("tid", this.ajM.getId());
                akVar.ac(ImageViewerConfig.FORUM_ID, this.ajM.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.ajM.rx() != null && this.ajM.rx().getGodUserData() != null && this.ajM.rx().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", this.ajM.getId()));
            }
        }
        if (abs() != null) {
            abs().a(view, this.ajM);
        }
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jQ(this.ajM.getId());
            aj.c(this.mTextTitle, d.C0082d.cp_cont_d, 1);
            t.gY(this.ajM.getId());
            if (this.ajM.rU() > 0 && com.baidu.tieba.tbadkCore.util.f.bxo()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.acd.getPageActivity()).createHistoryCfg(this.ajM.getTid(), String.valueOf(this.ajM.rU()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.ajM.ss() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajM.sB());
                createHistoryCfg.setSmartFrsPosition(this.ajM.sI());
                createHistoryCfg.setForumId(String.valueOf(this.ajM.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.bZb) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.acd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.acd.getPageActivity()).createFromThreadCfg(this.ajM, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ajM.ss() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ajM.sB());
            createFromThreadCfg.setSmartFrsPosition(this.ajM.sI());
            createFromThreadCfg.setForumId(String.valueOf(this.ajM.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.bZb) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.acd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: y */
    public void a(bd bdVar) {
        this.ajM = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        this.cau.removeMessages(202);
        if (this.caf.getCurrentPosition() > 0) {
            f(true, 3);
            this.cau.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cau.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cau.removeMessages(203);
        int currentPosition = this.caf.getCurrentPosition();
        if (currentPosition != this.cao) {
            this.cao = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.cau.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bkW != null && this.bZX != null && this.can != null && this.cak != null && this.cal != null && this.caj != null && this.cai != null) {
            if (z || this.cap != i) {
                this.cap = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cax);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caw);
                if (i == 2) {
                    this.bkW.setVisibility(8);
                    this.bla.cancel();
                    this.bZX.clearAnimation();
                    this.bZX.setVisibility(0);
                    this.can.setVisibility(0);
                    this.ccc.setVisibility(0);
                    this.cak.setVisibility(0);
                    this.cal.setVisibility(0);
                    this.caj.setVisibility(8);
                    this.cai.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.cax, 60000L);
                } else if (i == 3) {
                    this.bkW.setVisibility(8);
                    this.bZX.startAnimation(this.bla);
                    this.can.setVisibility(8);
                    this.ccc.setVisibility(8);
                    this.cak.setVisibility(8);
                    this.cal.setVisibility(8);
                    this.caj.setVisibility(8);
                    this.cai.setVisibility(8);
                } else if (i == 4) {
                    this.bkW.setVisibility(8);
                    this.bZX.startAnimation(this.bla);
                    this.can.setVisibility(8);
                    this.cak.setVisibility(8);
                    this.cal.setVisibility(8);
                    this.caj.setVisibility(0);
                    this.cai.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.caw, 2000L);
                } else {
                    this.bkW.setVisibility(0);
                    this.ccc.setVisibility(0);
                    this.bla.cancel();
                    this.bZX.clearAnimation();
                    this.bZX.setVisibility(0);
                    this.can.setVisibility(0);
                    this.cak.setVisibility(8);
                    this.cal.setVisibility(8);
                    this.caj.setVisibility(8);
                    this.cai.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajM == null || this.ajM.rx() == null) {
            this.bvu.setVisibility(8);
            return;
        }
        this.bvu.setVisibility(0);
        abF();
        this.ajM.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.ajM.rX()));
        this.mTextTitle.setText(this.ajM.rX());
        this.cOH.S(this.ajM);
        this.bvD.setData(this.ajM);
        if (this.bvD.getHeaderImg() != null) {
            if (this.bvD.getIsSimpleThread()) {
                this.bvD.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (this.ajM.rx() == null || this.ajM.rx().getPendantData() == null || StringUtils.isNull(this.ajM.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.bvD.getHeaderImg().setVisibility(0);
                this.bvD.getHeaderImg().setData(this.ajM);
            } else {
                this.bvD.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(this.ajM);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bvH.setLayoutParams(layoutParams);
        this.bvD.setUserAfterClickListener(this.aob);
        if (this.bvH.setData(this.ajM)) {
            this.bvI.setVisibility(8);
        } else {
            this.bvI.setVisibility(0);
        }
        this.cag.setText(am.cY(this.ajM.rP().video_duration.intValue() * 1000));
        this.bZY.setText(String.format(this.acd.getResources().getString(d.j.play_count), am.A(this.ajM.rP().play_count.intValue())));
        this.bZb.setData(this.ajM.sO());
        this.bZb.onChangeSkinType();
        if (com.baidu.tieba.card.k.jR(this.ajM.getId())) {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_d, 1);
            com.baidu.tieba.card.k.a(this.bZb.getGodReplyContent(), this.ajM.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_b, 1);
        }
        d(this.acd, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        this.cau.removeMessages(202);
        this.cau.removeMessages(203);
    }

    private void abE() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caw);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cax);
    }

    private void abF() {
        abE();
        abD();
        if (this.bZX != null && this.cae != null && this.caf != null) {
            if (com.baidu.tbadk.core.h.pa().pg() && this.ajM != null && this.ajM.rP() != null) {
                this.cae.setVisibility(0);
                this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bZX.startLoad(this.ajM.rP().thumbnail_url, 10, false);
                stopPlay();
                this.baH = this.ajM.rP().video_url;
                if (StringUtils.isNull(this.baH)) {
                    f(true, 4);
                    TiebaStatic.log(new ak("c12026").ac("tid", this.ajM.getId()));
                }
                if (this.ccY != null && this.ccY.bjq() != null) {
                    this.ccY.bjq().d(this.ajM.rP());
                    return;
                }
                return;
            }
            this.cae.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bvu, d.f.addresslist_item_bg);
            aj.c(this.bkW, d.f.btn_icon_play_video_n);
            aj.i(this.cai, d.C0082d.cp_cont_i);
            aj.i(this.cag, d.C0082d.cp_cont_i);
            aj.i(this.bZY, d.C0082d.cp_cont_i);
            aj.k(this.caj, d.C0082d.common_color_10014);
            aj.k(this.bam, d.C0082d.cp_bg_line_e);
            if (this.cai != null) {
                this.cai.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bvH.onChangeSkinType();
            this.mSkinType = i;
            this.bvD.onChangeSkinType();
            this.cOH.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.caq;
    }

    public boolean isPlaying() {
        if (this.caf == null) {
            return false;
        }
        return this.caf.isPlaying();
    }

    public void startPlay() {
        if (!this.caq && this.ajM != null && this.ajM.rP() != null && this.caf != null && y.q(2, this.baH)) {
            f(true, 2);
            if (StringUtils.isNull(this.baH)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "frs").ac("tid", this.ajM.getId()));
                this.baH = this.ajM.rP().video_url;
            }
            this.caf.bQ(this.baH, this.ajM.getId());
            this.caf.start();
            this.caf.setLooping(true);
            if (this.bll != null) {
                this.bll.start();
            }
            this.caq = true;
            abA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abA() {
        if (this.ajM != null && this.ajM.rP() != null) {
            String str = this.ajM.ss() ? "floor5" : "frs";
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.aMR = this.ajM.getTid();
            yVar.aAn = this.ajM.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.ajM.aaj;
            yVar.fQp = this.ajM.aal;
            yVar.fQq = this.ajM.aak;
            yVar.fQr = "";
            yVar.fQt = this.ajM.rP().video_md5;
            com.baidu.tieba.play.l.a(this.ajM.rP().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        abE();
        abD();
        f(true, 1);
        if (this.caf != null) {
            this.caf.stopPlayback();
            if (this.bll != null) {
                this.bll.stop();
            }
        }
        this.caq = false;
    }

    public View getVideoContainer() {
        return this.cae;
    }

    public String getPlayUrl() {
        return this.baH;
    }

    public int getCurrentPosition() {
        if (this.caf == null) {
            return 0;
        }
        return this.caf.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.ccY != null) {
            this.ccY.setVideoStatsData(yVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvH != null && this.bvD != null) {
            this.bvD.setPageUniqueId(bdUniqueId);
        }
    }
}
