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
    private g.f aZt;
    private g.b aZu;
    private TbPageContext<?> aca;
    private bd ajM;
    private final View.OnClickListener anT;
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private ThreadGodReplyLayout bZj;
    private String baM;
    private View bas;
    private ImageView blb;
    private Animation blf;
    private com.baidu.tieba.play.j blq;
    private QuickVideoView.b blw;
    public ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    public View bvN;
    public LinearLayout bvP;
    public ThreadSkinView bvQ;
    private RelativeLayout bvz;
    public TextView cOU;
    public LinearLayout cOV;
    private com.baidu.tieba.frs.g.g cOW;
    private ViewTreeObserver.OnGlobalLayoutListener cOX;
    private Handler caC;
    private TbImageView.a caD;
    private Runnable caE;
    private Runnable caF;
    private j.a caJ;
    private Animation.AnimationListener caK;
    private TbImageView caf;
    private TextView cag;
    private View.OnClickListener cak;
    public FrameLayout cam;
    private QuickVideoView can;
    private TextView cao;
    private TextView caq;
    private View car;
    private ProgressBar cas;
    private ImageView cat;
    private View cav;
    private int caw;
    private int cax;
    private boolean cay;
    private LinearLayout cck;
    private n cdq;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.caw = 0;
        this.cax = 1;
        this.cay = false;
        this.caC = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.abD();
                        return;
                    case 203:
                        a.this.abE();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZt = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.caC.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aZu = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.abF();
                a.this.f(true, 4);
                return true;
            }
        };
        this.caD = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && a.this.caf != null) {
                    a.this.caf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cOX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cam != null && a.this.cam.getLayoutParams() != null && a.this.cam.getVisibility() != 8) {
                    a.this.cam.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cam.getLayoutParams();
                    if (a.this.cam.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cam.getWidth() * 0.5625d);
                        a.this.cam.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.caE = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.can != null && !a.this.can.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.caF = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.abF();
                a.this.f(true, 4);
            }
        };
        this.blw = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cak = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajM != null && !StringUtils.isNull(a.this.ajM.rB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.aca.getPageActivity()).createNormalCfg(a.this.ajM.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.anT != null) {
                        a.this.anT.onClick(view);
                    }
                }
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.ajM);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajM != null && a.this.abt() != null) {
                    a.this.abt().a(view, a.this.ajM);
                }
            }
        };
        this.caJ = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.j.a
            public void abI() {
                a.this.abB();
            }
        };
        this.caK = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cax == 3 && a.this.caf != null) {
                    a.this.caf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.aca = tbPageContext;
        View view = getView();
        this.bas = view.findViewById(d.g.divider_line);
        this.bvz = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cOV = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bvz.setOnClickListener(this);
        this.bZi = (HeadPendantClickableView) this.bvz.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.aca.getPageActivity(), d.e.ds70));
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.cOU = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cOU.setVisibility(8);
        this.cOU.setOnClickListener(this.cak);
        this.cas = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.cat = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bvM.setForumAfterClickListener(this.anT);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bvI.setFrom(3);
        this.bvN = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bvM.setOnClickListener(this);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setShareVisible(true);
        this.bvM.setShareReportFrom(1);
        this.bvM.setStType("frs_page");
        this.bvM.setFrom(2);
        this.bvM.anR = 3;
        this.cam = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cam.setOnClickListener(this);
        this.cam.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cam != null) {
                    a.this.cam.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cOX);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cam != null) {
                    a.this.cam.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cOX);
                }
            }
        });
        this.caf = (TbImageView) view.findViewById(d.g.image_video);
        this.caf.setPageId(getTag());
        this.caf.setDefaultErrorResource(0);
        this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.caf.setEvent(this.caD);
        this.caf.setGifIconSupport(false);
        this.blb = (ImageView) view.findViewById(d.g.image_video_play);
        this.can = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cdq = new n(this.aca.getPageActivity());
        this.can.setBusiness(this.cdq);
        this.can.setOnPreparedListener(this.aZt);
        this.can.setOnErrorListener(this.aZu);
        this.can.setOnSurfaceDestroyedListener(this.blw);
        this.blq = new com.baidu.tieba.play.j();
        this.blq.setPlayer(this.can);
        this.blq.a(this.caJ);
        this.cav = view.findViewById(d.g.auto_video_black_mask);
        this.caq = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.car = view.findViewById(d.g.auto_video_error_background);
        this.bvP = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bvQ = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.blf = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.fade_out_video_cover);
        this.blf.setAnimationListener(this.caK);
        this.cao = (TextView) view.findViewById(d.g.text_video_duration);
        this.cag = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cck = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cOW = new com.baidu.tieba.frs.g.g(tbPageContext, this.bvz);
        this.cOW.setUniqueId(getTag());
        this.bZj = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZj.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvz || view == this.bvM.getCommentNumView() || view == this.cOV) {
            aj(this.bvz);
        } else if (view == this.cam) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                aA(this.cam);
            } else {
                aj(this.cam);
            }
        } else if (view == this.bZj) {
            aj(this.bZj);
        }
        if (this.ajM != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajM));
        }
    }

    private void aA(View view) {
        if (this.ajM != null) {
            ak akVar = new ak("c11100");
            akVar.ac("tid", this.ajM.getId());
            akVar.ac(ImageViewerConfig.FORUM_ID, this.ajM.getFid() + "");
            TiebaStatic.log(akVar);
            if (this.ajM.rv() != null && this.ajM.rv().getGodUserData() != null && this.ajM.rv().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", this.ajM.getId()));
            }
        }
        if (abt() != null) {
            abt().a(view, this.ajM);
        }
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.showToast(this.aca.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.hi()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aca.getPageActivity());
            aVar.cS(this.aca.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    a.this.abC();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ao(true);
            aVar.b(this.mTbPageContext).th();
        } else {
            abC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aca.getPageActivity(), "frs", this.ajM.getTid(), com.baidu.tieba.card.k.rl(), "")));
    }

    private void aj(View view) {
        if (this.ajM != null) {
            if (this.ajM.sq()) {
                TiebaStatic.log(new ak("c10242").ac(ImageViewerConfig.FORUM_ID, String.valueOf(this.ajM.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ac("tid", this.ajM.getId());
                akVar.ac(ImageViewerConfig.FORUM_ID, this.ajM.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.ajM.rv() != null && this.ajM.rv().getGodUserData() != null && this.ajM.rv().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", this.ajM.getId()));
            }
        }
        if (abt() != null) {
            abt().a(view, this.ajM);
        }
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jO(this.ajM.getId());
            aj.c(this.mTextTitle, d.C0095d.cp_cont_d, 1);
            t.gW(this.ajM.getId());
            if (this.ajM.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxV()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aca.getPageActivity()).createHistoryCfg(this.ajM.getTid(), String.valueOf(this.ajM.rS()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.ajM.sq() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajM.sz());
                createHistoryCfg.setSmartFrsPosition(this.ajM.sG());
                createHistoryCfg.setForumId(String.valueOf(this.ajM.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.bZj) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aca.getPageActivity()).createFromThreadCfg(this.ajM, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ajM.sq() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ajM.sz());
            createFromThreadCfg.setSmartFrsPosition(this.ajM.sG());
            createFromThreadCfg.setForumId(String.valueOf(this.ajM.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.bZj) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        this.ajM = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        this.caC.removeMessages(202);
        if (this.can.getCurrentPosition() > 0) {
            f(true, 3);
            this.caC.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.caC.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abE() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.caC.removeMessages(203);
        int currentPosition = this.can.getCurrentPosition();
        if (currentPosition != this.caw) {
            this.caw = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.caC.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.blb != null && this.caf != null && this.cav != null && this.cas != null && this.cat != null && this.car != null && this.caq != null) {
            if (z || this.cax != i) {
                this.cax = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caF);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caE);
                if (i == 2) {
                    this.blb.setVisibility(8);
                    this.blf.cancel();
                    this.caf.clearAnimation();
                    this.caf.setVisibility(0);
                    this.cav.setVisibility(0);
                    this.cck.setVisibility(0);
                    this.cas.setVisibility(0);
                    this.cat.setVisibility(0);
                    this.car.setVisibility(8);
                    this.caq.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.caF, 60000L);
                } else if (i == 3) {
                    this.blb.setVisibility(8);
                    this.caf.startAnimation(this.blf);
                    this.cav.setVisibility(8);
                    this.cck.setVisibility(8);
                    this.cas.setVisibility(8);
                    this.cat.setVisibility(8);
                    this.car.setVisibility(8);
                    this.caq.setVisibility(8);
                } else if (i == 4) {
                    this.blb.setVisibility(8);
                    this.caf.startAnimation(this.blf);
                    this.cav.setVisibility(8);
                    this.cas.setVisibility(8);
                    this.cat.setVisibility(8);
                    this.car.setVisibility(0);
                    this.caq.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.caE, 2000L);
                } else {
                    this.blb.setVisibility(0);
                    this.cck.setVisibility(0);
                    this.blf.cancel();
                    this.caf.clearAnimation();
                    this.caf.setVisibility(0);
                    this.cav.setVisibility(0);
                    this.cas.setVisibility(8);
                    this.cat.setVisibility(8);
                    this.car.setVisibility(8);
                    this.caq.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajM == null || this.ajM.rv() == null) {
            this.bvz.setVisibility(8);
            return;
        }
        this.bvz.setVisibility(0);
        abH();
        this.ajM.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.ajM.rV()));
        this.mTextTitle.setText(this.ajM.rV());
        this.cOW.U(this.ajM);
        this.bvI.setData(this.ajM);
        if (this.bvI.getHeaderImg() != null) {
            if (this.bvI.getIsSimpleThread()) {
                this.bvI.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (this.ajM.rv() == null || this.ajM.rv().getPendantData() == null || StringUtils.isNull(this.ajM.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.bvI.getHeaderImg().setVisibility(0);
                this.bvI.getHeaderImg().setData(this.ajM);
            } else {
                this.bvI.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(this.ajM);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bvM.setLayoutParams(layoutParams);
        this.bvI.setUserAfterClickListener(this.aog);
        if (this.bvM.setData(this.ajM)) {
            this.bvN.setVisibility(8);
        } else {
            this.bvN.setVisibility(0);
        }
        this.cao.setText(am.cY(this.ajM.rN().video_duration.intValue() * 1000));
        this.cag.setText(String.format(this.aca.getResources().getString(d.j.play_count), am.A(this.ajM.rN().play_count.intValue())));
        this.bZj.setData(this.ajM.sM());
        this.bZj.onChangeSkinType();
        if (com.baidu.tieba.card.k.jP(this.ajM.getId())) {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_d, 1);
            com.baidu.tieba.card.k.a(this.bZj.getGodReplyContent(), this.ajM.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_b, 1);
        }
        d(this.aca, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abF() {
        this.caC.removeMessages(202);
        this.caC.removeMessages(203);
    }

    private void abG() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caE);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caF);
    }

    private void abH() {
        abG();
        abF();
        if (this.caf != null && this.cam != null && this.can != null) {
            if (com.baidu.tbadk.core.h.oY().pe() && this.ajM != null && this.ajM.rN() != null) {
                this.cam.setVisibility(0);
                this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.caf.startLoad(this.ajM.rN().thumbnail_url, 10, false);
                stopPlay();
                this.baM = this.ajM.rN().video_url;
                if (StringUtils.isNull(this.baM)) {
                    f(true, 4);
                    TiebaStatic.log(new ak("c12026").ac("tid", this.ajM.getId()));
                }
                if (this.cdq != null && this.cdq.bjy() != null) {
                    this.cdq.bjy().d(this.ajM.rN());
                    return;
                }
                return;
            }
            this.cam.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bvz, d.f.addresslist_item_bg);
            aj.c(this.blb, d.f.btn_icon_play_video_n);
            aj.i(this.caq, d.C0095d.cp_cont_i);
            aj.i(this.cao, d.C0095d.cp_cont_i);
            aj.i(this.cag, d.C0095d.cp_cont_i);
            aj.k(this.car, d.C0095d.common_color_10014);
            aj.k(this.bas, d.C0095d.cp_bg_line_e);
            if (this.caq != null) {
                this.caq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bvM.onChangeSkinType();
            this.mSkinType = i;
            this.bvI.onChangeSkinType();
            this.cOW.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cay;
    }

    public boolean isPlaying() {
        if (this.can == null) {
            return false;
        }
        return this.can.isPlaying();
    }

    public void startPlay() {
        if (!this.cay && this.ajM != null && this.ajM.rN() != null && this.can != null && y.q(2, this.baM)) {
            f(true, 2);
            if (StringUtils.isNull(this.baM)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "frs").ac("tid", this.ajM.getId()));
                this.baM = this.ajM.rN().video_url;
            }
            this.can.bR(this.baM, this.ajM.getId());
            this.can.start();
            this.can.setLooping(true);
            if (this.blq != null) {
                this.blq.start();
            }
            this.cay = true;
            abB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        if (this.ajM != null && this.ajM.rN() != null) {
            String str = this.ajM.sq() ? "floor5" : "frs";
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.aMX = this.ajM.getTid();
            yVar.aAv = this.ajM.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.ajM.aag;
            yVar.fRn = this.ajM.aai;
            yVar.fRo = this.ajM.aah;
            yVar.fRp = "";
            yVar.fRr = this.ajM.rN().video_md5;
            com.baidu.tieba.play.l.a(this.ajM.rN().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        abG();
        abF();
        f(true, 1);
        if (this.can != null) {
            this.can.stopPlayback();
            if (this.blq != null) {
                this.blq.stop();
            }
        }
        this.cay = false;
    }

    public ThreadCommentAndPraiseInfoLayout abX() {
        return this.bvM;
    }

    public View getVideoContainer() {
        return this.cam;
    }

    public String getPlayUrl() {
        return this.baM;
    }

    public int getCurrentPosition() {
        if (this.can == null) {
            return 0;
        }
        return this.can.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.cdq != null) {
            this.cdq.setVideoStatsData(yVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvM != null && this.bvI != null) {
            this.bvI.setPageUniqueId(bdUniqueId);
        }
    }
}
