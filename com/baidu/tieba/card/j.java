package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.view.View;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class j extends a<n> implements View.OnClickListener {
    private g.f aZp;
    private g.b aZq;
    private TbPageContext<?> abX;
    private final View.OnClickListener anQ;
    private HeadPendantClickableView bZe;
    public ThreadGodReplyLayout bZf;
    private com.baidu.tieba.NEGFeedBack.c bZg;
    private String baI;
    private View ban;
    private ImageView bkX;
    private Animation blb;
    private com.baidu.tieba.play.j blm;
    private com.baidu.tieba.play.n bln;
    private QuickVideoView.b bls;
    public ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    protected LinearLayout bvL;
    private RelativeLayout bvv;
    private Runnable caA;
    private Runnable caB;
    private final View.OnClickListener caC;
    private final View.OnClickListener caD;
    private CustomMessageListener caE;
    private j.a caF;
    private Animation.AnimationListener caG;
    private TbImageView cab;
    private TextView cac;
    private View cad;
    public FrameLayout cai;
    private QuickVideoView caj;
    private TextView cak;
    private LinearLayout cal;
    private TextView cam;
    private View can;
    private ProgressBar cao;
    private ImageView cap;
    private n caq;
    private View car;
    private int cas;
    private int cat;
    private boolean cau;
    private boolean cav;
    private boolean caw;
    private TextView cax;
    private Handler cay;
    private TbImageView.a caz;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        if (this.caq != null && this.caq.bjE != null) {
            y yVar = new y();
            yVar.mLocate = this.caq.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aMU = this.caq.bjE.getTid();
            yVar.aAs = this.caq.bjE.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.caq.bjE.aad;
            yVar.fRi = this.caq.bjE.aaf;
            yVar.fRj = this.caq.bjE.aae;
            yVar.fRk = "";
            yVar.WF = this.caq.getExtra();
            if (this.caq.bjE.rN() != null) {
                yVar.fRm = this.caq.bjE.rN().video_md5;
            }
            com.baidu.tieba.play.l.a(this.caq.bjE.rN().video_md5, "", "1", yVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZg = null;
        this.mSkinType = 3;
        this.cas = 0;
        this.cat = 1;
        this.cau = false;
        this.cav = true;
        this.caw = false;
        this.cay = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.abE();
                        return;
                    case 203:
                        j.this.abF();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.cay.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.j.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.caz = new TbImageView.a() { // from class: com.baidu.tieba.card.j.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && j.this.cab != null) {
                    j.this.cab.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.caA = new Runnable() { // from class: com.baidu.tieba.card.j.13
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.caj != null && !j.this.caj.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.caB = new Runnable() { // from class: com.baidu.tieba.card.j.14
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.bls = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.15
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.caq);
                }
            }
        };
        this.caD = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.caq);
                }
            }
        };
        this.caE = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.caw = false;
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.caq != null && j.this.abt() != null) {
                    j.this.abt().a(view, j.this.caq);
                }
            }
        };
        this.caF = new j.a() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.j.a
            public void abJ() {
                if (j.this.caq != null && j.this.caq.bjE != null && j.this.caq.bjE.rN() != null) {
                    j.this.abB();
                }
            }
        };
        this.caG = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.cab != null) {
                    j.this.cab.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.abX = tbPageContext;
        View view = getView();
        this.bvv = (RelativeLayout) view.findViewById(d.g.layout_root);
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
        this.cao = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.cap = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bZg = new com.baidu.tieba.NEGFeedBack.c(abs());
        int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16);
        this.bZg.a(this.bvv, f, 0);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
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
        this.bvI.setShareVisible(true);
        this.bvI.setShareReportFrom(3);
        this.bvI.setForumAfterClickListener(this.anQ);
        this.bvI.setFrom(1);
        this.cad = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cai = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cai.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ac(this.abX.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abX.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cai.setLayoutParams(layoutParams2);
        this.cab = (TbImageView) view.findViewById(d.g.image_video);
        this.cab.setDefaultErrorResource(0);
        this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cab.setGifIconSupport(false);
        this.cab.setEvent(this.caz);
        this.bkX = (ImageView) view.findViewById(d.g.image_video_play);
        this.bvv.setOnClickListener(this);
        this.caj = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bln = new com.baidu.tieba.play.n(this.abX.getPageActivity());
        this.caj.setBusiness(this.bln);
        this.caj.setOnPreparedListener(this.aZp);
        this.caj.setOnErrorListener(this.aZq);
        this.caj.setOnSurfaceDestroyedListener(this.bls);
        this.blm = new com.baidu.tieba.play.j();
        this.blm.setPlayer(this.caj);
        this.blm.a(this.caF);
        this.cak = (TextView) view.findViewById(d.g.text_video_duration);
        this.cal = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cac = (TextView) view.findViewById(d.g.text_video_play_count);
        this.car = view.findViewById(d.g.auto_video_black_mask);
        this.cam = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.can = view.findViewById(d.g.auto_video_error_background);
        this.bvL = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.blb = AnimationUtils.loadAnimation(this.abX.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.blb.setAnimationListener(this.caG);
        this.bZf = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZf.setOnClickListener(this);
        this.ban = view.findViewById(d.g.divider_line);
        this.cax = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.caj.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.caq != null && this.caq.bjE != null && this.caq.bjE.aaA > 0) {
            if (abt() != null) {
                abt().a(view, this.caq);
            }
            this.abX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.abX.getPageActivity(), this.caq.bjE.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, k.rl(), this.caq.acg())));
            return;
        }
        if (view == this.bvv || view == this.bZf) {
            ai(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.caj) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                abC();
            } else {
                ai(view);
            }
        }
    }

    private void abC() {
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.showToast(this.abX.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.hi()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abX.getPageActivity());
            aVar.cS(this.abX.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.j.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    j.this.abD();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.j.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ao(true);
            aVar.b(this.mTbPageContext).th();
        } else {
            abD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        if (this.caq != null && this.caq.bjE != null && this.caq.bjE.getId() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.abX.getPageActivity(), "index", this.caq.bjE.getTid(), k.rl(), this.caq.acg())));
        }
    }

    private void ai(View view) {
        if (abt() != null) {
            abt().a(view, this.caq);
        }
        if (this.caq != null && this.caq.bjE != null) {
            if (!abx()) {
                k.jO(this.caq.bjE.getId());
                k.a(this.mTextTitle, this.caq.bjE.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abX.getPageActivity()).createFromThreadCfg(this.caq.bjE, null, k.rl(), 18003, true, false, false).addLocateParam(this.caq.acg());
            addLocateParam.setVideo_source(this.caq.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.caq.bjE.getFid()));
            addLocateParam.setForumName(this.caq.bjE.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.bZf) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abx() {
        return this.caq.cdT && !this.caq.ceh;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.caq = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abE() {
        this.cay.removeMessages(202);
        if (this.caj.getCurrentPosition() > 0) {
            f(true, 3);
            this.cay.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cay.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abF() {
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
                    this.cal.setVisibility(0);
                    this.cax.setVisibility(8);
                    this.cao.setVisibility(0);
                    this.cap.setVisibility(0);
                    this.can.setVisibility(8);
                    this.cam.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.caB, 60000L);
                } else if (i == 3) {
                    this.bkX.setVisibility(8);
                    this.cab.startAnimation(this.blb);
                    this.car.setVisibility(8);
                    this.cal.setVisibility(8);
                    if (this.caq != null && this.caq.Ox() != null && this.caq.Ox().aaA > 0) {
                        this.cax.setVisibility(0);
                    }
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
                    this.blb.cancel();
                    this.cab.clearAnimation();
                    this.cab.setVisibility(0);
                    this.car.setVisibility(0);
                    this.cal.setVisibility(0);
                    this.cao.setVisibility(8);
                    this.cap.setVisibility(8);
                    this.can.setVisibility(8);
                    this.cam.setVisibility(8);
                }
                if (this.caq != null && this.caq.Ox() != null && this.caq.Ox().aaA > 0) {
                    this.cal.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.caq == null || this.caq.bjE == null || this.caq.bjE.rv() == null) {
            this.bvv.setVisibility(8);
            return;
        }
        this.bvv.setVisibility(0);
        abI();
        if (!abx() && k.jP(this.caq.bjE.getId())) {
            k.a(this.mTextTitle, this.caq.bjE.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            k.a(this.bZf.getGodReplyContent(), this.caq.Ox().getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
        }
        this.caq.Ox().sd();
        this.mTextTitle.setText(new SpannableStringBuilder(this.caq.Ox().rV()));
        this.bvE.setData(this.caq.Ox());
        this.bvE.setUserAfterClickListener(this.caC);
        if (this.bvE.getHeaderImg() != null) {
            this.bvE.getHeaderImg().setAfterClickListener(this.caD);
            if (this.bvE.getIsSimpleThread()) {
                this.bvE.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (this.caq.Ox() == null || this.caq.Ox().rv() == null || this.caq.Ox().rv().getPendantData() == null || StringUtils.isNull(this.caq.Ox().rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.bvE.getHeaderImg().setVisibility(0);
                if (this.caq.Ox().aaA > 0 && this.caq.Ox().aaB == 0) {
                    this.caq.Ox().rv().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bvE.getHeaderImg().a(this.caq.Ox(), false);
                } else {
                    this.bvE.getHeaderImg().setData(this.caq.Ox());
                    this.bvE.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bvE.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(this.caq.Ox());
            }
        }
        if (this.caq.bjE.aaA > 0) {
            this.bvI.setShowPraiseNum(false);
            this.bvI.setShareVisible(false);
            this.cax.setText(am.A(this.caq.bjE.aaA));
            this.cax.setVisibility(0);
        } else {
            this.bvI.setShowPraiseNum(true);
            this.bvI.setShareVisible(true);
            this.cax.setVisibility(8);
        }
        if (this.bvI.setData(this.caq.bjE)) {
            this.cad.setVisibility(8);
        } else {
            this.cad.setVisibility(0);
        }
        this.cak.setText(am.cY(this.caq.bjE.rN().video_duration.intValue() * 1000));
        this.cac.setText(String.format(this.abX.getResources().getString(d.j.play_count), am.A(this.caq.bjE.rN().play_count.intValue())));
        if (this.bZg != null && this.caq.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.caq.Ox().getTid());
            ahVar.setFid(this.caq.Ox().getFid());
            ahVar.a(this.caq.Xy);
            this.bZg.setData(ahVar);
            this.bZg.setFirstRowSingleColumn(true);
            this.bZg.setVisibility(this.cav ? 0 : 8);
        }
        this.bZf.setData(this.caq.Ox().sM());
        this.bZf.onChangeSkinType();
        d(this.abX, TbadkCoreApplication.getInst().getSkinType());
        if (k.jP(this.caq.bjE.getId())) {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_b, 1);
        }
    }

    private void abG() {
        this.cay.removeMessages(202);
        this.cay.removeMessages(203);
    }

    private void abH() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caA);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.caB);
    }

    private void abI() {
        abH();
        abG();
        if (this.cab != null && this.cai != null && this.caj != null) {
            if (com.baidu.tbadk.core.h.oY().pe() && this.caq != null && this.caq.bjE != null && this.caq.bjE.rN() != null) {
                this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cab.startLoad(this.caq.bjE.rN().thumbnail_url, 10, false);
                this.cai.setVisibility(0);
                stopPlay();
                this.baI = this.caq.bjE.rN().video_url;
                if (StringUtils.isNull(this.caq.bjE.rN().video_url)) {
                    f(true, 4);
                }
                if (this.bln != null && this.bln.bjy() != null) {
                    this.bln.bjy().d(this.caq.bjE.rN());
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
            aj.i(this.cax, d.C0096d.cp_cont_i);
            aj.k(this.can, d.C0096d.common_color_10014);
            aj.k(this.ban, d.C0096d.cp_bg_line_e);
            if (this.cam != null) {
                this.cam.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bZg != null) {
                this.bZg.onChangeSkinType();
            }
            this.bvE.onChangeSkinType();
            this.bvI.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.caE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caE);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvE != null) {
            this.bvE.setPageUniqueId(bdUniqueId);
        }
        if (this.cab != null) {
            this.cab.setPageId(bdUniqueId);
        }
        if (this.bZg != null) {
            this.bZg.setUniqueId(bdUniqueId);
        }
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
        if (!this.cau && this.caq != null && this.caq.bjE != null && this.caq.bjE.rN() != null && this.caj != null && com.baidu.tbadk.util.y.q(1, this.baI)) {
            f(true, 2);
            if (StringUtils.isNull(this.baI)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "index").ac("tid", this.caq.tid));
                this.baI = this.caq.bjE.rN().video_url;
            }
            this.caj.bR(this.baI, this.caq.tid);
            this.caj.start();
            this.caj.setLooping(true);
            if (this.blm != null) {
                this.blm.start();
            }
            this.cau = true;
            abB();
        }
    }

    public void stopPlay() {
        abH();
        abG();
        f(true, 1);
        if (this.caj != null) {
            this.caj.stopPlayback();
            if (this.blm != null) {
                this.blm.stop();
            }
        }
        this.cau = false;
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

    public void setVideoStatsData(y yVar) {
        if (this.bln != null) {
            this.bln.setVideoStatsData(yVar);
        }
    }

    public void a(c.a aVar) {
        if (this.bZg != null) {
            this.bZg.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvE != null) {
            return this.bvE.anY;
        }
        return null;
    }

    public View abw() {
        if (this.bvE != null) {
            return this.bvE.anZ;
        }
        return null;
    }

    public void dP(boolean z) {
        this.cav = z;
    }
}
