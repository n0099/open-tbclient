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
    private g.InterfaceC0124g aWj;
    private g.b aWk;
    private String aXD;
    private View aXj;
    private TbPageContext<?> abI;
    private bh ajq;
    private final View.OnClickListener anR;
    private final View.OnClickListener anz;
    private HeadPendantClickableView bRc;
    private ThreadGodReplyLayout bRd;
    private Handler bSA;
    private TbImageView.a bSB;
    private Runnable bSC;
    private Runnable bSD;
    private QuickVideoView.b bSE;
    private j.a bSI;
    private Animation.AnimationListener bSJ;
    private TbImageView bSa;
    private ImageView bSb;
    private TextView bSc;
    private View.OnClickListener bSg;
    public FrameLayout bSi;
    private QuickVideoView bSj;
    private TextView bSl;
    private TextView bSn;
    private View bSo;
    private ProgressBar bSp;
    private ImageView bSq;
    private View bSs;
    private int bSt;
    private int bSu;
    private boolean bSv;
    private com.baidu.tieba.play.j bSx;
    private Animation bSy;
    private LinearLayout bTZ;
    private n bUE;
    public ThreadUserInfoLayout boI;
    public ThreadCommentAndPraiseInfoLayout boM;
    public View boN;
    public LinearLayout boQ;
    public ThreadSkinView boR;
    private RelativeLayout boz;
    public LinearLayout cFA;
    private com.baidu.tieba.frs.g.g cFB;
    private ViewTreeObserver.OnGlobalLayoutListener cFC;
    public TextView cFz;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bSt = 0;
        this.bSu = 1;
        this.bSv = false;
        this.bSA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.ZS();
                        return;
                    case 203:
                        a.this.ZT();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aWj = new g.InterfaceC0124g() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bSA.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aWk = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ZU();
                a.this.f(true, 4);
                return true;
            }
        };
        this.bSB = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && a.this.bSa != null) {
                    a.this.bSa.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cFC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bSi != null && a.this.bSi.getLayoutParams() != null && a.this.bSi.getVisibility() != 8) {
                    a.this.bSi.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bSi.getLayoutParams();
                    if (a.this.bSi.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bSi.getWidth() * 0.5625d);
                        a.this.bSi.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bSC = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bSj != null && !a.this.bSj.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.bSD = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.ZU();
                a.this.f(true, 4);
            }
        };
        this.bSE = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.bSg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajq != null && !StringUtils.isNull(a.this.ajq.rz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.abI.getPageActivity()).createNormalCfg(a.this.ajq.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.anz != null) {
                        a.this.anz.onClick(view);
                    }
                }
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ZJ() != null) {
                    a.this.ZJ().a(view, a.this.ajq);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajq != null && a.this.ZJ() != null) {
                    a.this.ZJ().a(view, a.this.ajq);
                }
            }
        };
        this.bSI = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.j.a
            public void ZX() {
                a.this.ZR();
            }
        };
        this.bSJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bSu == 3 && a.this.bSa != null) {
                    a.this.bSa.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.abI = tbPageContext;
        View view = getView();
        this.aXj = view.findViewById(d.g.divider_line);
        this.boz = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cFA = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.boz.setOnClickListener(this);
        this.bRc = (HeadPendantClickableView) this.boz.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds70));
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.cFz = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cFz.setVisibility(8);
        this.cFz.setOnClickListener(this.bSg);
        this.bSp = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.bSq = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.boM.setForumAfterClickListener(this.anz);
        this.boI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.boI.setFrom(3);
        this.boN = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setIsBarViewVisible(false);
        this.boM.setShareVisible(true);
        this.boM.setShareReportFrom(1);
        this.boM.setStType("frs_page");
        this.boM.setFrom(2);
        this.bSi = (FrameLayout) view.findViewById(d.g.frame_video);
        this.bSi.setOnClickListener(this);
        this.bSi.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bSi != null) {
                    a.this.bSi.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cFC);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bSi != null) {
                    a.this.bSi.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cFC);
                }
            }
        });
        this.bSa = (TbImageView) view.findViewById(d.g.image_video);
        this.bSa.setPageId(getTag());
        this.bSa.setDefaultErrorResource(0);
        this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bSa.setEvent(this.bSB);
        this.bSa.setGifIconSupport(false);
        this.bSb = (ImageView) view.findViewById(d.g.image_video_play);
        this.bSj = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bUE = new n(this.abI.getPageActivity());
        this.bSj.setBusiness(this.bUE);
        this.bSj.setOnPreparedListener(this.aWj);
        this.bSj.setOnErrorListener(this.aWk);
        this.bSj.setOnSurfaceDestroyedListener(this.bSE);
        this.bSx = new com.baidu.tieba.play.j();
        this.bSx.setPlayer(this.bSj);
        this.bSx.a(this.bSI);
        this.bSs = view.findViewById(d.g.auto_video_black_mask);
        this.bSn = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bSo = view.findViewById(d.g.auto_video_error_background);
        this.boQ = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.boR = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bSy = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.fade_out_video_cover);
        this.bSy.setAnimationListener(this.bSJ);
        this.bSl = (TextView) view.findViewById(d.g.text_video_duration);
        this.bSc = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bTZ = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cFB = new com.baidu.tieba.frs.g.g(tbPageContext, this.boI);
        this.cFB.setUniqueId(getTag());
        this.bRd = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bRd.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boz || view == this.boM.getCommentNumView() || view == this.cFA) {
            ag(this.boz);
        } else if (view == this.bSi) {
            ag(this.bSi);
        } else if (view == this.bRd) {
            ag(this.bRd);
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
        if (ZJ() != null) {
            ZJ().a(view, this.ajq);
        }
        if (this.ajq != null) {
            m.jL(this.ajq.getId());
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
            t.gV(this.ajq.getId());
            if (this.ajq.rQ() > 0 && com.baidu.tieba.tbadkCore.util.f.bvE()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.abI.getPageActivity()).createHistoryCfg(this.ajq.getTid(), String.valueOf(this.ajq.rQ()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.ajq.sp() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajq.sy());
                createHistoryCfg.setSmartFrsPosition(this.ajq.sF());
                createHistoryCfg.setForumId(String.valueOf(this.ajq.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bRd) {
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
            if (view == this.bRd) {
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
    public void ZS() {
        this.bSA.removeMessages(202);
        if (this.bSj.getCurrentPosition() > 0) {
            f(true, 3);
            this.bSA.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bSA.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZT() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bSA.removeMessages(203);
        int currentPosition = this.bSj.getCurrentPosition();
        if (currentPosition != this.bSt) {
            this.bSt = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bSA.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bSb != null && this.bSa != null && this.bSs != null && this.bSp != null && this.bSq != null && this.bSo != null && this.bSn != null) {
            if (z || this.bSu != i) {
                this.bSu = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSD);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSC);
                if (i == 2) {
                    this.bSb.setVisibility(8);
                    this.bSy.cancel();
                    this.bSa.clearAnimation();
                    this.bSa.setVisibility(0);
                    this.bSs.setVisibility(0);
                    this.bTZ.setVisibility(0);
                    this.bSp.setVisibility(0);
                    this.bSq.setVisibility(0);
                    this.bSo.setVisibility(8);
                    this.bSn.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSD, 60000L);
                } else if (i == 3) {
                    this.bSb.setVisibility(8);
                    this.bSa.startAnimation(this.bSy);
                    this.bSs.setVisibility(8);
                    this.bTZ.setVisibility(8);
                    this.bSp.setVisibility(8);
                    this.bSq.setVisibility(8);
                    this.bSo.setVisibility(8);
                    this.bSn.setVisibility(8);
                } else if (i == 4) {
                    this.bSb.setVisibility(8);
                    this.bSa.startAnimation(this.bSy);
                    this.bSs.setVisibility(8);
                    this.bSp.setVisibility(8);
                    this.bSq.setVisibility(8);
                    this.bSo.setVisibility(0);
                    this.bSn.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSC, 2000L);
                } else {
                    this.bSb.setVisibility(0);
                    this.bTZ.setVisibility(0);
                    this.bSy.cancel();
                    this.bSa.clearAnimation();
                    this.bSa.setVisibility(0);
                    this.bSs.setVisibility(0);
                    this.bSp.setVisibility(8);
                    this.bSq.setVisibility(8);
                    this.bSo.setVisibility(8);
                    this.bSn.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajq == null || this.ajq.rt() == null) {
            this.boz.setVisibility(8);
            return;
        }
        this.boz.setVisibility(0);
        ZW();
        this.ajq.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.ajq.rU()));
        this.mTextTitle.setText(this.ajq.rU());
        this.cFB.Q(this.ajq);
        this.boI.setData(this.ajq);
        if (this.boI.getHeaderImg() != null) {
            if (this.boI.getIsSimpleThread()) {
                this.boI.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (this.ajq.rt() == null || this.ajq.rt().getPendantData() == null || StringUtils.isNull(this.ajq.rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.boI.getHeaderImg().setVisibility(0);
                this.boI.getHeaderImg().setData(this.ajq);
            } else {
                this.boI.getHeaderImg().setVisibility(4);
                this.bRc.setVisibility(0);
                this.bRc.setData(this.ajq);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.boM.setLayoutParams(layoutParams);
        this.boI.setUserAfterClickListener(this.anR);
        if (this.boM.setData(this.ajq)) {
            this.boN.setVisibility(8);
        } else {
            this.boN.setVisibility(0);
        }
        this.bSl.setText(am.cX(this.ajq.rL().video_duration.intValue() * 1000));
        this.bSc.setText(String.format(this.abI.getResources().getString(d.j.play_count), am.A(this.ajq.rL().play_count.intValue())));
        this.boM.setCommentNumClickListener(this);
        this.bRd.setData(this.ajq.sL());
        this.bRd.onChangeSkinType();
        if (m.jM(this.ajq.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
            m.a(this.bRd.getGodReplyContent(), this.ajq.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZU() {
        this.bSA.removeMessages(202);
        this.bSA.removeMessages(203);
    }

    private void ZV() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSC);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSD);
    }

    private void ZW() {
        ZV();
        ZU();
        if (this.bSa != null && this.bSi != null && this.bSj != null) {
            if (com.baidu.tbadk.core.h.oT().oZ() && this.ajq != null && this.ajq.rL() != null) {
                this.bSi.setVisibility(0);
                this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bSa.startLoad(this.ajq.rL().thumbnail_url, 10, false);
                stopPlay();
                this.aXD = this.ajq.rL().video_url;
                if (StringUtils.isNull(this.aXD)) {
                    f(true, 4);
                    TiebaStatic.log(new ak("c12026").ac("tid", this.ajq.getId()));
                }
                if (this.bUE != null && this.bUE.bhG() != null) {
                    this.bUE.bhG().d(this.ajq.rL());
                    return;
                }
                return;
            }
            this.bSi.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.boz, d.f.addresslist_item_bg);
            aj.c(this.bSb, d.f.btn_icon_play_video_n);
            aj.i(this.bSn, d.C0080d.cp_cont_i);
            aj.i(this.bSl, d.C0080d.cp_cont_i);
            aj.i(this.bSc, d.C0080d.cp_cont_i);
            aj.k(this.bSo, d.C0080d.common_color_10014);
            aj.k(this.aXj, d.C0080d.cp_bg_line_e);
            if (this.bSn != null) {
                this.bSn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.boM.onChangeSkinType();
            this.mSkinType = i;
            this.boI.onChangeSkinType();
            this.cFB.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bSv;
    }

    public boolean isPlaying() {
        if (this.bSj == null) {
            return false;
        }
        return this.bSj.isPlaying();
    }

    public void startPlay() {
        if (!this.bSv && this.ajq != null && this.ajq.rL() != null && this.bSj != null && y.q(2, this.aXD)) {
            f(true, 2);
            if (StringUtils.isNull(this.aXD)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "frs").ac("tid", this.ajq.getId()));
                this.aXD = this.ajq.rL().video_url;
            }
            this.bSj.bM(this.aXD, this.ajq.getId());
            this.bSj.start();
            this.bSj.setLooping(true);
            if (this.bSx != null) {
                this.bSx.start();
            }
            this.bSv = true;
            ZR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZR() {
        if (this.ajq != null && this.ajq.rL() != null) {
            String str = this.ajq.sp() ? "floor5" : "frs";
            x xVar = new x();
            xVar.mLocate = str;
            xVar.aMq = this.ajq.getTid();
            xVar.azM = this.ajq.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.ajq.ZQ;
            xVar.fHj = this.ajq.ZS;
            xVar.fHk = this.ajq.ZR;
            xVar.fHl = "";
            xVar.fHn = this.ajq.rL().video_md5;
            com.baidu.tieba.play.l.a(this.ajq.rL().video_md5, "", "1", xVar);
        }
    }

    public void stopPlay() {
        ZV();
        ZU();
        f(true, 1);
        if (this.bSj != null) {
            this.bSj.stopPlayback();
            if (this.bSx != null) {
                this.bSx.stop();
            }
        }
        this.bSv = false;
    }

    public View getVideoContainer() {
        return this.bSi;
    }

    public String getPlayUrl() {
        return this.aXD;
    }

    public int getCurrentPosition() {
        if (this.bSj == null) {
            return 0;
        }
        return this.bSj.getCurrentPosition();
    }

    public void setVideoStatsData(x xVar) {
        if (this.bUE != null) {
            this.bUE.setVideoStatsData(xVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.boM != null && this.boI != null) {
            this.boI.setPageUniqueId(bdUniqueId);
        }
    }
}
