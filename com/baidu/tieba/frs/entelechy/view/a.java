package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.w;
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
    private View aWX;
    private g.f aWe;
    private g.b aWf;
    private String aXr;
    private TbPageContext<?> abz;
    private bh ajg;
    private final View.OnClickListener anJ;
    private final View.OnClickListener anr;
    private HeadPendantClickableView bJv;
    private ThreadGodReplyLayout bJw;
    public FrameLayout bKB;
    private QuickVideoView bKC;
    private TextView bKE;
    private TextView bKG;
    private View bKH;
    private ProgressBar bKI;
    private ImageView bKJ;
    private View bKL;
    private int bKM;
    private int bKN;
    private boolean bKO;
    private com.baidu.tieba.play.j bKQ;
    private Animation bKR;
    private Handler bKS;
    private TbImageView.a bKT;
    private Runnable bKU;
    private Runnable bKV;
    private QuickVideoView.b bKW;
    private TbImageView bKt;
    private ImageView bKu;
    private TextView bKv;
    private View.OnClickListener bKz;
    private j.a bLa;
    private Animation.AnimationListener bLb;
    private n bMZ;
    private LinearLayout bMu;
    private RelativeLayout bmW;
    public ThreadUserInfoLayout bnf;
    public ThreadCommentAndPraiseInfoLayout bnj;
    public View bnk;
    public LinearLayout bnn;
    public ThreadSkinView bno;
    public TextView cxB;
    public LinearLayout cxC;
    private com.baidu.tieba.frs.h.g cxD;
    private ViewTreeObserver.OnGlobalLayoutListener cxE;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bKM = 0;
        this.bKN = 1;
        this.bKO = false;
        this.bKS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.XA();
                        return;
                    case 203:
                        a.this.XB();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aWe = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bKS.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aWf = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.XC();
                a.this.g(true, 4);
                return true;
            }
        };
        this.bKT = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && a.this.bKt != null) {
                    a.this.bKt.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cxE = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bKB != null && a.this.bKB.getLayoutParams() != null && a.this.bKB.getVisibility() != 8) {
                    a.this.bKB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bKB.getLayoutParams();
                    if (a.this.bKB.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bKB.getWidth() * 0.5625d);
                        a.this.bKB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bKU = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bKC != null && !a.this.bKC.isPlaying()) {
                    a.this.g(true, 1);
                }
            }
        };
        this.bKV = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.XC();
                a.this.g(true, 4);
            }
        };
        this.bKW = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.bKz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajg != null && !StringUtils.isNull(a.this.ajg.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.abz.getPageActivity()).createNormalCfg(a.this.ajg.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.anr != null) {
                        a.this.anr.onClick(view);
                    }
                }
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xr() != null) {
                    a.this.Xr().a(view, a.this.ajg);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajg != null && a.this.Xr() != null) {
                    a.this.Xr().a(view, a.this.ajg);
                }
            }
        };
        this.bLa = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.j.a
            public void XF() {
                a.this.Xz();
            }
        };
        this.bLb = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bKN == 3 && a.this.bKt != null) {
                    a.this.bKt.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.abz = tbPageContext;
        View view = getView();
        this.aWX = view.findViewById(d.h.divider_line);
        this.bmW = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.cxC = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bmW.setOnClickListener(this);
        this.bJv = (HeadPendantClickableView) this.bmW.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abz.getPageActivity(), d.f.ds70));
        }
        this.bJv.wg();
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.cxB = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.cxB.setVisibility(8);
        this.cxB.setOnClickListener(this.bKz);
        this.bKI = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bKJ = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bnf = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bnf.setFrom(3);
        this.bnk = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setIsBarViewVisible(false);
        this.bnj.setShareVisible(true);
        this.bnj.setShareReportFrom(1);
        this.bnj.setFrom(2);
        this.bKB = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bKB.setOnClickListener(this);
        this.bKB.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bKB != null) {
                    a.this.bKB.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cxE);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bKB != null) {
                    a.this.bKB.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cxE);
                }
            }
        });
        this.bKt = (TbImageView) view.findViewById(d.h.image_video);
        this.bKt.setPageId(getTag());
        this.bKt.setDefaultErrorResource(0);
        this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKt.setEvent(this.bKT);
        this.bKt.setGifIconSupport(false);
        this.bKu = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKC = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bMZ = new n(this.abz.getPageActivity());
        this.bKC.setBusiness(this.bMZ);
        this.bKC.setOnPreparedListener(this.aWe);
        this.bKC.setOnErrorListener(this.aWf);
        this.bKC.setOnSurfaceDestroyedListener(this.bKW);
        this.bKQ = new com.baidu.tieba.play.j();
        this.bKQ.setPlayer(this.bKC);
        this.bKQ.a(this.bLa);
        this.bKL = view.findViewById(d.h.auto_video_black_mask);
        this.bKG = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bKH = view.findViewById(d.h.auto_video_error_background);
        this.bnn = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bno = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bKR = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.fade_out_video_cover);
        this.bKR.setAnimationListener(this.bLb);
        this.bKE = (TextView) view.findViewById(d.h.text_video_duration);
        this.bKv = (TextView) view.findViewById(d.h.text_video_play_count);
        this.bMu = (LinearLayout) view.findViewById(d.h.duration_container);
        this.cxD = new com.baidu.tieba.frs.h.g(tbPageContext, this.bnf);
        this.cxD.setUniqueId(getTag());
        this.bJw = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJw.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmW || view == this.bnj.getCommentNumView() || view == this.cxC) {
            ad(this.bmW);
        } else if (view == this.bKB) {
            ad(this.bKB);
        } else if (view == this.bJw) {
            ad(this.bJw);
        }
        if (this.ajg != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajg));
        }
    }

    private void ad(View view) {
        if (this.ajg != null) {
            if (this.ajg.sp()) {
                TiebaStatic.log(new ak("c10242").ad("fid", String.valueOf(this.ajg.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ad("tid", this.ajg.getId());
                akVar.ad("fid", this.ajg.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.ajg.getAuthor() != null && this.ajg.getAuthor().getGodUserData() != null && this.ajg.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", this.ajg.getId()));
            }
        }
        if (Xr() != null) {
            Xr().a(view, this.ajg);
        }
        if (this.ajg != null) {
            m.jm(this.ajg.getId());
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            r.gO(this.ajg.getId());
            if (this.ajg.rR() > 0 && com.baidu.tieba.tbadkCore.util.f.bsv()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.abz.getPageActivity()).createHistoryCfg(this.ajg.getTid(), String.valueOf(this.ajg.rR()), false, true, m.rm());
                createHistoryCfg.setVideo_source(this.ajg.sp() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajg.sy());
                createHistoryCfg.setSmartFrsPosition(this.ajg.sF());
                createHistoryCfg.setForumId(String.valueOf(this.ajg.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bJw) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.abz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.abz.getPageActivity()).createFromThreadCfg(this.ajg, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ajg.sp() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ajg.sy());
            createFromThreadCfg.setSmartFrsPosition(this.ajg.sF());
            createFromThreadCfg.setForumId(String.valueOf(this.ajg.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bJw) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.abz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        this.ajg = bhVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XA() {
        this.bKS.removeMessages(202);
        if (this.bKC.getCurrentPosition() > 0) {
            g(true, 3);
            this.bKS.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bKS.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XB() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bKS.removeMessages(203);
        int currentPosition = this.bKC.getCurrentPosition();
        if (currentPosition != this.bKM) {
            this.bKM = currentPosition;
            g(false, 3);
        } else {
            g(false, 2);
        }
        this.bKS.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bKu != null && this.bKt != null && this.bKL != null && this.bKI != null && this.bKJ != null && this.bKH != null && this.bKG != null) {
            if (z || this.bKN != i) {
                this.bKN = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKV);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKU);
                if (i == 2) {
                    this.bKu.setVisibility(8);
                    this.bKR.cancel();
                    this.bKt.clearAnimation();
                    this.bKt.setVisibility(0);
                    this.bKL.setVisibility(0);
                    this.bMu.setVisibility(0);
                    this.bKI.setVisibility(0);
                    this.bKJ.setVisibility(0);
                    this.bKH.setVisibility(8);
                    this.bKG.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKV, 60000L);
                } else if (i == 3) {
                    this.bKu.setVisibility(8);
                    this.bKt.startAnimation(this.bKR);
                    this.bKL.setVisibility(8);
                    this.bMu.setVisibility(8);
                    this.bKI.setVisibility(8);
                    this.bKJ.setVisibility(8);
                    this.bKH.setVisibility(8);
                    this.bKG.setVisibility(8);
                } else if (i == 4) {
                    this.bKu.setVisibility(8);
                    this.bKt.startAnimation(this.bKR);
                    this.bKL.setVisibility(8);
                    this.bKI.setVisibility(8);
                    this.bKJ.setVisibility(8);
                    this.bKH.setVisibility(0);
                    this.bKG.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKU, 2000L);
                } else {
                    this.bKu.setVisibility(0);
                    this.bMu.setVisibility(0);
                    this.bKR.cancel();
                    this.bKt.clearAnimation();
                    this.bKt.setVisibility(0);
                    this.bKL.setVisibility(0);
                    this.bKI.setVisibility(8);
                    this.bKJ.setVisibility(8);
                    this.bKH.setVisibility(8);
                    this.bKG.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajg == null || this.ajg.getAuthor() == null) {
            this.bmW.setVisibility(8);
            return;
        }
        this.bmW.setVisibility(0);
        XE();
        this.ajg.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(this.ajg.rV()));
        this.mTextTitle.setText(this.ajg.rV());
        this.cxD.O(this.ajg);
        this.bnf.setData(this.ajg);
        if (this.bnf.getHeaderImg() != null) {
            if (this.bnf.getIsSimpleThread()) {
                this.bnf.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (this.ajg.getAuthor() == null || this.ajg.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajg.getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.bnf.getHeaderImg().setVisibility(0);
                this.bnf.getHeaderImg().setData(this.ajg);
            } else {
                this.bnf.getHeaderImg().setVisibility(4);
                this.bJv.setVisibility(0);
                this.bJv.setData(this.ajg);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bnj.setLayoutParams(layoutParams);
        this.bnf.setUserAfterClickListener(this.anJ);
        if (this.bnj.setData(this.ajg)) {
            this.bnk.setVisibility(8);
        } else {
            this.bnk.setVisibility(0);
        }
        this.bKE.setText(am.cY(this.ajg.rM().video_duration.intValue() * 1000));
        this.bKv.setText(String.format(this.abz.getResources().getString(d.l.play_count), am.z(this.ajg.rM().play_count.intValue())));
        this.bnj.setCommentNumClickListener(this);
        this.bJw.setData(this.ajg.sL());
        this.bJw.onChangeSkinType();
        if (m.jn(this.ajg.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            m.a(this.bJw.getGodReplyContent(), this.ajg.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.abz, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XC() {
        this.bKS.removeMessages(202);
        this.bKS.removeMessages(203);
    }

    private void XD() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKV);
    }

    private void XE() {
        XD();
        XC();
        if (this.bKt != null && this.bKB != null && this.bKC != null) {
            if (com.baidu.tbadk.core.h.oT().oZ() && this.ajg != null && this.ajg.rM() != null) {
                this.bKB.setVisibility(0);
                this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bKt.c(this.ajg.rM().thumbnail_url, 10, false);
                stopPlay();
                this.aXr = this.ajg.rM().video_url;
                if (StringUtils.isNull(this.aXr)) {
                    g(true, 4);
                    TiebaStatic.log(new ak("c12026").ad("tid", this.ajg.getId()));
                }
                if (this.bMZ != null && this.bMZ.bes() != null) {
                    this.bMZ.bes().d(this.ajg.rM());
                    return;
                }
                return;
            }
            this.bKB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bmW, d.g.addresslist_item_bg);
            aj.c(this.bKu, d.g.btn_icon_play_video_n);
            aj.i(this.bKG, d.e.cp_cont_i);
            aj.i(this.bKE, d.e.cp_cont_i);
            aj.i(this.bKv, d.e.cp_cont_i);
            aj.k(this.bKH, d.e.common_color_10014);
            aj.k(this.aWX, d.e.cp_bg_line_e);
            if (this.bKG != null) {
                this.bKG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bnj.onChangeSkinType();
            this.mSkinType = i;
            this.bnf.onChangeSkinType();
            this.cxD.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bKO;
    }

    public boolean isPlaying() {
        if (this.bKC == null) {
            return false;
        }
        return this.bKC.isPlaying();
    }

    public void startPlay() {
        if (!this.bKO && this.ajg != null && this.ajg.rM() != null && this.bKC != null && w.q(2, this.aXr)) {
            g(true, 2);
            if (TextUtils.isEmpty(this.aXr)) {
                TiebaStatic.log(new ak("c12026").ad("tid", this.ajg.getTid()));
            }
            this.bKC.setVideoPath(this.aXr);
            this.bKC.start();
            this.bKC.setLooping(true);
            if (this.bKQ != null) {
                this.bKQ.start();
            }
            this.bKO = true;
            Xz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xz() {
        if (this.ajg != null && this.ajg.rM() != null) {
            String str = this.ajg.sp() ? "floor5" : "frs";
            x xVar = new x();
            xVar.mLocate = str;
            xVar.cyX = this.ajg.getTid();
            xVar.azf = this.ajg.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.ajg.ZH;
            xVar.fyb = this.ajg.ZJ;
            xVar.fyc = this.ajg.ZI;
            xVar.fyd = "";
            xVar.fyf = this.ajg.rM().video_md5;
            com.baidu.tieba.play.l.a(this.ajg.rM().video_md5, "", "1", xVar);
        }
    }

    public void stopPlay() {
        XD();
        XC();
        g(true, 1);
        if (this.bKC != null) {
            this.bKC.stopPlayback();
            if (this.bKQ != null) {
                this.bKQ.stop();
            }
        }
        this.bKO = false;
    }

    public View getVideoContainer() {
        return this.bKB;
    }

    public String getPlayUrl() {
        return this.aXr;
    }

    public int getCurrentPosition() {
        if (this.bKC == null) {
            return 0;
        }
        return this.bKC.getCurrentPosition();
    }

    public void setVideoStatsData(x xVar) {
        if (this.bMZ != null) {
            this.bMZ.setVideoStatsData(xVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bnj != null && this.bnf != null) {
            this.bnf.setPageUniqueId(bdUniqueId);
        }
    }
}
