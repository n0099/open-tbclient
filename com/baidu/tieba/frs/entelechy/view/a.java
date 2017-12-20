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
    private g.f aZp;
    private g.b aZq;
    private TbPageContext<?> abX;
    private bd ajJ;
    private final View.OnClickListener anQ;
    private final View.OnClickListener aod;
    private HeadPendantClickableView bZe;
    private ThreadGodReplyLayout bZf;
    private String baI;
    private View ban;
    private ImageView bkX;
    private Animation blb;
    private com.baidu.tieba.play.j blm;
    private QuickVideoView.b bls;
    public ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    public View bvJ;
    public LinearLayout bvL;
    public ThreadSkinView bvM;
    private RelativeLayout bvv;
    public TextView cOQ;
    public LinearLayout cOR;
    private com.baidu.tieba.frs.g.g cOS;
    private ViewTreeObserver.OnGlobalLayoutListener cOT;
    private Runnable caA;
    private Runnable caB;
    private j.a caF;
    private Animation.AnimationListener caG;
    private TbImageView cab;
    private TextView cac;
    private View.OnClickListener cag;
    public FrameLayout cai;
    private QuickVideoView caj;
    private TextView cak;
    private TextView cam;
    private View can;
    private ProgressBar cao;
    private ImageView cap;
    private View car;
    private int cas;
    private int cat;
    private boolean cau;
    private Handler cay;
    private TbImageView.a caz;
    private LinearLayout ccg;
    private n cdm;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cas = 0;
        this.cat = 1;
        this.cau = false;
        this.cay = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
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
        this.aZp = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.cay.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.abF();
                a.this.f(true, 4);
                return true;
            }
        };
        this.caz = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && a.this.cab != null) {
                    a.this.cab.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cOT = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cai != null && a.this.cai.getLayoutParams() != null && a.this.cai.getVisibility() != 8) {
                    a.this.cai.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cai.getLayoutParams();
                    if (a.this.cai.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cai.getWidth() * 0.5625d);
                        a.this.cai.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.caA = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.caj != null && !a.this.caj.isPlaying()) {
                    a.this.f(true, 1);
                }
            }
        };
        this.caB = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.abF();
                a.this.f(true, 4);
            }
        };
        this.bls = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cag = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajJ != null && !StringUtils.isNull(a.this.ajJ.rB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.abX.getPageActivity()).createNormalCfg(a.this.ajJ.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.anQ != null) {
                        a.this.anQ.onClick(view);
                    }
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.abt() != null) {
                    a.this.abt().a(view, a.this.ajJ);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajJ != null && a.this.abt() != null) {
                    a.this.abt().a(view, a.this.ajJ);
                }
            }
        };
        this.caF = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.j.a
            public void abI() {
                a.this.abB();
            }
        };
        this.caG = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cat == 3 && a.this.cab != null) {
                    a.this.cab.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.abX = tbPageContext;
        View view = getView();
        this.ban = view.findViewById(d.g.divider_line);
        this.bvv = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cOR = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bvv.setOnClickListener(this);
        this.bZe = (HeadPendantClickableView) this.bvv.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abX.getPageActivity(), d.e.ds70));
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.cOQ = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.cOQ.setVisibility(8);
        this.cOQ.setOnClickListener(this.cag);
        this.cao = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.cap = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bvI.setForumAfterClickListener(this.anQ);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bvE.setFrom(3);
        this.bvJ = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bvI.setOnClickListener(this);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setShareVisible(true);
        this.bvI.setShareReportFrom(1);
        this.bvI.setStType("frs_page");
        this.bvI.setFrom(2);
        this.bvI.anO = 3;
        this.cai = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cai.setOnClickListener(this);
        this.cai.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cai != null) {
                    a.this.cai.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cOT);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cai != null) {
                    a.this.cai.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cOT);
                }
            }
        });
        this.cab = (TbImageView) view.findViewById(d.g.image_video);
        this.cab.setPageId(getTag());
        this.cab.setDefaultErrorResource(0);
        this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cab.setEvent(this.caz);
        this.cab.setGifIconSupport(false);
        this.bkX = (ImageView) view.findViewById(d.g.image_video_play);
        this.caj = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cdm = new n(this.abX.getPageActivity());
        this.caj.setBusiness(this.cdm);
        this.caj.setOnPreparedListener(this.aZp);
        this.caj.setOnErrorListener(this.aZq);
        this.caj.setOnSurfaceDestroyedListener(this.bls);
        this.blm = new com.baidu.tieba.play.j();
        this.blm.setPlayer(this.caj);
        this.blm.a(this.caF);
        this.car = view.findViewById(d.g.auto_video_black_mask);
        this.cam = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.can = view.findViewById(d.g.auto_video_error_background);
        this.bvL = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bvM = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.blb = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.fade_out_video_cover);
        this.blb.setAnimationListener(this.caG);
        this.cak = (TextView) view.findViewById(d.g.text_video_duration);
        this.cac = (TextView) view.findViewById(d.g.text_video_play_count);
        this.ccg = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cOS = new com.baidu.tieba.frs.g.g(tbPageContext, this.bvv);
        this.cOS.setUniqueId(getTag());
        this.bZf = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZf.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvv || view == this.bvI.getCommentNumView() || view == this.cOR) {
            aj(this.bvv);
        } else if (view == this.cai) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                aA(this.cai);
            } else {
                aj(this.cai);
            }
        } else if (view == this.bZf) {
            aj(this.bZf);
        }
        if (this.ajJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajJ));
        }
    }

    private void aA(View view) {
        if (this.ajJ != null) {
            ak akVar = new ak("c11100");
            akVar.ac("tid", this.ajJ.getId());
            akVar.ac(ImageViewerConfig.FORUM_ID, this.ajJ.getFid() + "");
            TiebaStatic.log(akVar);
            if (this.ajJ.rv() != null && this.ajJ.rv().getGodUserData() != null && this.ajJ.rv().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", this.ajJ.getId()));
            }
        }
        if (abt() != null) {
            abt().a(view, this.ajJ);
        }
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.showToast(this.abX.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.hi()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abX.getPageActivity());
            aVar.cS(this.abX.getString(d.j.enter_video_center_page_no_wifi_tip));
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.abX.getPageActivity(), "frs", this.ajJ.getTid(), com.baidu.tieba.card.k.rl(), "")));
    }

    private void aj(View view) {
        if (this.ajJ != null) {
            if (this.ajJ.sq()) {
                TiebaStatic.log(new ak("c10242").ac(ImageViewerConfig.FORUM_ID, String.valueOf(this.ajJ.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ac("tid", this.ajJ.getId());
                akVar.ac(ImageViewerConfig.FORUM_ID, this.ajJ.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.ajJ.rv() != null && this.ajJ.rv().getGodUserData() != null && this.ajJ.rv().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", this.ajJ.getId()));
            }
        }
        if (abt() != null) {
            abt().a(view, this.ajJ);
        }
        if (this.ajJ != null) {
            com.baidu.tieba.card.k.jO(this.ajJ.getId());
            aj.c(this.mTextTitle, d.C0096d.cp_cont_d, 1);
            t.gW(this.ajJ.getId());
            if (this.ajJ.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxU()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.abX.getPageActivity()).createHistoryCfg(this.ajJ.getTid(), String.valueOf(this.ajJ.rS()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.ajJ.sq() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajJ.sz());
                createHistoryCfg.setSmartFrsPosition(this.ajJ.sG());
                createHistoryCfg.setForumId(String.valueOf(this.ajJ.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.bZf) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.abX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.abX.getPageActivity()).createFromThreadCfg(this.ajJ, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ajJ.sq() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ajJ.sz());
            createFromThreadCfg.setSmartFrsPosition(this.ajJ.sG());
            createFromThreadCfg.setForumId(String.valueOf(this.ajJ.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.bZf) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.abX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
        this.ajJ = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        this.cay.removeMessages(202);
        if (this.caj.getCurrentPosition() > 0) {
            f(true, 3);
            this.cay.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cay.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abE() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cay.removeMessages(203);
        int currentPosition = this.caj.getCurrentPosition();
        if (currentPosition != this.cas) {
            this.cas = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.cay.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bkX != null && this.cab != null && this.car != null && this.cao != null && this.cap != null && this.can != null && this.cam != null) {
            if (z || this.cat != i) {
                this.cat = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caB);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caA);
                if (i == 2) {
                    this.bkX.setVisibility(8);
                    this.blb.cancel();
                    this.cab.clearAnimation();
                    this.cab.setVisibility(0);
                    this.car.setVisibility(0);
                    this.ccg.setVisibility(0);
                    this.cao.setVisibility(0);
                    this.cap.setVisibility(0);
                    this.can.setVisibility(8);
                    this.cam.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.caB, 60000L);
                } else if (i == 3) {
                    this.bkX.setVisibility(8);
                    this.cab.startAnimation(this.blb);
                    this.car.setVisibility(8);
                    this.ccg.setVisibility(8);
                    this.cao.setVisibility(8);
                    this.cap.setVisibility(8);
                    this.can.setVisibility(8);
                    this.cam.setVisibility(8);
                } else if (i == 4) {
                    this.bkX.setVisibility(8);
                    this.cab.startAnimation(this.blb);
                    this.car.setVisibility(8);
                    this.cao.setVisibility(8);
                    this.cap.setVisibility(8);
                    this.can.setVisibility(0);
                    this.cam.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.caA, 2000L);
                } else {
                    this.bkX.setVisibility(0);
                    this.ccg.setVisibility(0);
                    this.blb.cancel();
                    this.cab.clearAnimation();
                    this.cab.setVisibility(0);
                    this.car.setVisibility(0);
                    this.cao.setVisibility(8);
                    this.cap.setVisibility(8);
                    this.can.setVisibility(8);
                    this.cam.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajJ == null || this.ajJ.rv() == null) {
            this.bvv.setVisibility(8);
            return;
        }
        this.bvv.setVisibility(0);
        abH();
        this.ajJ.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.l(this.ajJ.rV()));
        this.mTextTitle.setText(this.ajJ.rV());
        this.cOS.U(this.ajJ);
        this.bvE.setData(this.ajJ);
        if (this.bvE.getHeaderImg() != null) {
            if (this.bvE.getIsSimpleThread()) {
                this.bvE.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (this.ajJ.rv() == null || this.ajJ.rv().getPendantData() == null || StringUtils.isNull(this.ajJ.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.bvE.getHeaderImg().setVisibility(0);
                this.bvE.getHeaderImg().setData(this.ajJ);
            } else {
                this.bvE.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(this.ajJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bvI.setLayoutParams(layoutParams);
        this.bvE.setUserAfterClickListener(this.aod);
        if (this.bvI.setData(this.ajJ)) {
            this.bvJ.setVisibility(8);
        } else {
            this.bvJ.setVisibility(0);
        }
        this.cak.setText(am.cY(this.ajJ.rN().video_duration.intValue() * 1000));
        this.cac.setText(String.format(this.abX.getResources().getString(d.j.play_count), am.A(this.ajJ.rN().play_count.intValue())));
        this.bZf.setData(this.ajJ.sM());
        this.bZf.onChangeSkinType();
        if (com.baidu.tieba.card.k.jP(this.ajJ.getId())) {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_d, 1);
            com.baidu.tieba.card.k.a(this.bZf.getGodReplyContent(), this.ajJ.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_b, 1);
        }
        d(this.abX, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abF() {
        this.cay.removeMessages(202);
        this.cay.removeMessages(203);
    }

    private void abG() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caA);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caB);
    }

    private void abH() {
        abG();
        abF();
        if (this.cab != null && this.cai != null && this.caj != null) {
            if (com.baidu.tbadk.core.h.oY().pe() && this.ajJ != null && this.ajJ.rN() != null) {
                this.cai.setVisibility(0);
                this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cab.startLoad(this.ajJ.rN().thumbnail_url, 10, false);
                stopPlay();
                this.baI = this.ajJ.rN().video_url;
                if (StringUtils.isNull(this.baI)) {
                    f(true, 4);
                    TiebaStatic.log(new ak("c12026").ac("tid", this.ajJ.getId()));
                }
                if (this.cdm != null && this.cdm.bjx() != null) {
                    this.cdm.bjx().d(this.ajJ.rN());
                    return;
                }
                return;
            }
            this.cai.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bvv, d.f.addresslist_item_bg);
            aj.c(this.bkX, d.f.btn_icon_play_video_n);
            aj.i(this.cam, d.C0096d.cp_cont_i);
            aj.i(this.cak, d.C0096d.cp_cont_i);
            aj.i(this.cac, d.C0096d.cp_cont_i);
            aj.k(this.can, d.C0096d.common_color_10014);
            aj.k(this.ban, d.C0096d.cp_bg_line_e);
            if (this.cam != null) {
                this.cam.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bvI.onChangeSkinType();
            this.mSkinType = i;
            this.bvE.onChangeSkinType();
            this.cOS.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cau;
    }

    public boolean isPlaying() {
        if (this.caj == null) {
            return false;
        }
        return this.caj.isPlaying();
    }

    public void startPlay() {
        if (!this.cau && this.ajJ != null && this.ajJ.rN() != null && this.caj != null && y.q(2, this.baI)) {
            f(true, 2);
            if (StringUtils.isNull(this.baI)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "frs").ac("tid", this.ajJ.getId()));
                this.baI = this.ajJ.rN().video_url;
            }
            this.caj.bR(this.baI, this.ajJ.getId());
            this.caj.start();
            this.caj.setLooping(true);
            if (this.blm != null) {
                this.blm.start();
            }
            this.cau = true;
            abB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        if (this.ajJ != null && this.ajJ.rN() != null) {
            String str = this.ajJ.sq() ? "floor5" : "frs";
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.aMU = this.ajJ.getTid();
            yVar.aAs = this.ajJ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.ajJ.aad;
            yVar.fRi = this.ajJ.aaf;
            yVar.fRj = this.ajJ.aae;
            yVar.fRk = "";
            yVar.fRm = this.ajJ.rN().video_md5;
            com.baidu.tieba.play.l.a(this.ajJ.rN().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        abG();
        abF();
        f(true, 1);
        if (this.caj != null) {
            this.caj.stopPlayback();
            if (this.blm != null) {
                this.blm.stop();
            }
        }
        this.cau = false;
    }

    public ThreadCommentAndPraiseInfoLayout abX() {
        return this.bvI;
    }

    public View getVideoContainer() {
        return this.cai;
    }

    public String getPlayUrl() {
        return this.baI;
    }

    public int getCurrentPosition() {
        if (this.caj == null) {
            return 0;
        }
        return this.caj.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.cdm != null) {
            this.cdm.setVideoStatsData(yVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvI != null && this.bvE != null) {
            this.bvE.setPageUniqueId(bdUniqueId);
        }
    }
}
