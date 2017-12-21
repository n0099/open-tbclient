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
    private g.f aZt;
    private g.b aZu;
    private TbPageContext<?> aca;
    private final View.OnClickListener anT;
    private HeadPendantClickableView bZi;
    public ThreadGodReplyLayout bZj;
    private com.baidu.tieba.NEGFeedBack.c bZk;
    private String baM;
    private View bas;
    private ImageView blb;
    private Animation blf;
    private com.baidu.tieba.play.j blq;
    private com.baidu.tieba.play.n blr;
    private QuickVideoView.b blw;
    public ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    protected LinearLayout bvP;
    private RelativeLayout bvz;
    private boolean caA;
    private TextView caB;
    private Handler caC;
    private TbImageView.a caD;
    private Runnable caE;
    private Runnable caF;
    private final View.OnClickListener caG;
    private final View.OnClickListener caH;
    private CustomMessageListener caI;
    private j.a caJ;
    private Animation.AnimationListener caK;
    private TbImageView caf;
    private TextView cag;
    private View cah;
    public FrameLayout cam;
    private QuickVideoView can;
    private TextView cao;
    private LinearLayout cap;
    private TextView caq;
    private View car;
    private ProgressBar cas;
    private ImageView cat;
    private n cau;
    private View cav;
    private int caw;
    private int cax;
    private boolean cay;
    private boolean caz;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        if (this.cau != null && this.cau.bjI != null) {
            y yVar = new y();
            yVar.mLocate = this.cau.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aMX = this.cau.bjI.getTid();
            yVar.aAv = this.cau.bjI.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cau.bjI.aag;
            yVar.fRn = this.cau.bjI.aai;
            yVar.fRo = this.cau.bjI.aah;
            yVar.fRp = "";
            yVar.WI = this.cau.getExtra();
            if (this.cau.bjI.rN() != null) {
                yVar.fRr = this.cau.bjI.rN().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cau.bjI.rN().video_md5, "", "1", yVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZk = null;
        this.mSkinType = 3;
        this.caw = 0;
        this.cax = 1;
        this.cay = false;
        this.caz = true;
        this.caA = false;
        this.caC = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.abD();
                        return;
                    case 203:
                        j.this.abE();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZt = new g.f() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.caC.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aZu = new g.b() { // from class: com.baidu.tieba.card.j.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.caD = new TbImageView.a() { // from class: com.baidu.tieba.card.j.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && j.this.caf != null) {
                    j.this.caf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.caE = new Runnable() { // from class: com.baidu.tieba.card.j.13
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.can != null && !j.this.can.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.caF = new Runnable() { // from class: com.baidu.tieba.card.j.14
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.blw = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.15
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.caG = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.cau);
                }
            }
        };
        this.caH = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abt() != null) {
                    j.this.abt().a(view, j.this.cau);
                }
            }
        };
        this.caI = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.caA = false;
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cau != null && j.this.abt() != null) {
                    j.this.abt().a(view, j.this.cau);
                }
            }
        };
        this.caJ = new j.a() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.j.a
            public void abI() {
                if (j.this.cau != null && j.this.cau.bjI != null && j.this.cau.bjI.rN() != null) {
                    j.this.abB();
                }
            }
        };
        this.caK = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.caf != null) {
                    j.this.caf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aca = tbPageContext;
        View view = getView();
        this.bvz = (RelativeLayout) view.findViewById(d.g.layout_root);
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
        this.cas = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.cat = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bZk = new com.baidu.tieba.NEGFeedBack.c(abs());
        int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16);
        this.bZk.a(this.bvz, f, 0);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
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
        this.bvM.setShareVisible(true);
        this.bvM.setShareReportFrom(3);
        this.bvM.setForumAfterClickListener(this.anT);
        this.bvM.setFrom(1);
        this.cah = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cam = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cam.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ac(this.aca.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.aca.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cam.setLayoutParams(layoutParams2);
        this.caf = (TbImageView) view.findViewById(d.g.image_video);
        this.caf.setDefaultErrorResource(0);
        this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.caf.setGifIconSupport(false);
        this.caf.setEvent(this.caD);
        this.blb = (ImageView) view.findViewById(d.g.image_video_play);
        this.bvz.setOnClickListener(this);
        this.can = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.blr = new com.baidu.tieba.play.n(this.aca.getPageActivity());
        this.can.setBusiness(this.blr);
        this.can.setOnPreparedListener(this.aZt);
        this.can.setOnErrorListener(this.aZu);
        this.can.setOnSurfaceDestroyedListener(this.blw);
        this.blq = new com.baidu.tieba.play.j();
        this.blq.setPlayer(this.can);
        this.blq.a(this.caJ);
        this.cao = (TextView) view.findViewById(d.g.text_video_duration);
        this.cap = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cag = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cav = view.findViewById(d.g.auto_video_black_mask);
        this.caq = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.car = view.findViewById(d.g.auto_video_error_background);
        this.bvP = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.blf = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.blf.setAnimationListener(this.caK);
        this.bZj = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZj.setOnClickListener(this);
        this.bas = view.findViewById(d.g.divider_line);
        this.caB = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.can.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cau != null && this.cau.bjI != null && this.cau.bjI.aaD > 0) {
            if (abt() != null) {
                abt().a(view, this.cau);
            }
            this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.aca.getPageActivity(), this.cau.bjI.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, k.rl(), this.cau.acf())));
            return;
        }
        if (view == this.bvz || view == this.bZj) {
            aj(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.can) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                ai(getView());
            } else {
                aj(getView());
            }
        }
    }

    private void ai(View view) {
        if (abt() != null) {
            abt().a(view, this.cau);
        }
        if (!com.baidu.adp.lib.util.j.hh()) {
            com.baidu.adp.lib.util.l.showToast(this.aca.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.hi()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aca.getPageActivity());
            aVar.cS(this.aca.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.j.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    j.this.abC();
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
            abC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        if (this.cau != null && this.cau.bjI != null && this.cau.bjI.getId() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aca.getPageActivity(), "index", this.cau.bjI.getTid(), k.rl(), this.cau.acf())));
        }
    }

    private void aj(View view) {
        if (abt() != null) {
            abt().a(view, this.cau);
        }
        if (this.cau != null && this.cau.bjI != null) {
            if (!abx()) {
                k.jO(this.cau.bjI.getId());
                k.a(this.mTextTitle, this.cau.bjI.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aca.getPageActivity()).createFromThreadCfg(this.cau.bjI, null, k.rl(), 18003, true, false, false).addLocateParam(this.cau.acf());
            addLocateParam.setVideo_source(this.cau.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cau.bjI.getFid()));
            addLocateParam.setForumName(this.cau.bjI.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.bZj) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abx() {
        return this.cau.cdX && !this.cau.cel;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.cau = nVar;
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
        this.caC.sendEmptyMessageDelayed(202, 300L);
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
                    this.cap.setVisibility(0);
                    this.caB.setVisibility(8);
                    this.cas.setVisibility(0);
                    this.cat.setVisibility(0);
                    this.car.setVisibility(8);
                    this.caq.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.caF, 60000L);
                } else if (i == 3) {
                    this.blb.setVisibility(8);
                    this.caf.startAnimation(this.blf);
                    this.cav.setVisibility(8);
                    this.cap.setVisibility(8);
                    if (this.cau != null && this.cau.Ox() != null && this.cau.Ox().aaD > 0) {
                        this.caB.setVisibility(0);
                    }
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
                    this.blf.cancel();
                    this.caf.clearAnimation();
                    this.caf.setVisibility(0);
                    this.cav.setVisibility(0);
                    this.cap.setVisibility(0);
                    this.cas.setVisibility(8);
                    this.cat.setVisibility(8);
                    this.car.setVisibility(8);
                    this.caq.setVisibility(8);
                }
                if (this.cau != null && this.cau.Ox() != null && this.cau.Ox().aaD > 0) {
                    this.cap.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cau == null || this.cau.bjI == null || this.cau.bjI.rv() == null) {
            this.bvz.setVisibility(8);
            return;
        }
        this.bvz.setVisibility(0);
        abH();
        if (!abx() && k.jP(this.cau.bjI.getId())) {
            k.a(this.mTextTitle, this.cau.bjI.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            k.a(this.bZj.getGodReplyContent(), this.cau.Ox().getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
        }
        this.cau.Ox().sd();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cau.Ox().rV()));
        this.bvI.setData(this.cau.Ox());
        this.bvI.setUserAfterClickListener(this.caG);
        if (this.bvI.getHeaderImg() != null) {
            this.bvI.getHeaderImg().setAfterClickListener(this.caH);
            if (this.bvI.getIsSimpleThread()) {
                this.bvI.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (this.cau.Ox() == null || this.cau.Ox().rv() == null || this.cau.Ox().rv().getPendantData() == null || StringUtils.isNull(this.cau.Ox().rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.bvI.getHeaderImg().setVisibility(0);
                if (this.cau.Ox().aaD > 0 && this.cau.Ox().aaE == 0) {
                    this.cau.Ox().rv().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bvI.getHeaderImg().a(this.cau.Ox(), false);
                } else {
                    this.bvI.getHeaderImg().setData(this.cau.Ox());
                    this.bvI.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bvI.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(this.cau.Ox());
            }
        }
        if (this.cau.bjI.aaD > 0) {
            this.bvM.setShowPraiseNum(false);
            this.bvM.setShareVisible(false);
            this.caB.setText(am.A(this.cau.bjI.aaD));
            this.caB.setVisibility(0);
        } else {
            this.bvM.setShowPraiseNum(true);
            this.bvM.setShareVisible(true);
            this.caB.setVisibility(8);
        }
        if (this.bvM.setData(this.cau.bjI)) {
            this.cah.setVisibility(8);
        } else {
            this.cah.setVisibility(0);
        }
        this.cao.setText(am.cY(this.cau.bjI.rN().video_duration.intValue() * 1000));
        this.cag.setText(String.format(this.aca.getResources().getString(d.j.play_count), am.A(this.cau.bjI.rN().play_count.intValue())));
        if (this.bZk != null && this.cau.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.cau.Ox().getTid());
            ahVar.setFid(this.cau.Ox().getFid());
            ahVar.a(this.cau.XB);
            this.bZk.setData(ahVar);
            this.bZk.setFirstRowSingleColumn(true);
            this.bZk.setVisibility(this.caz ? 0 : 8);
        }
        this.bZj.setData(this.cau.Ox().sM());
        this.bZj.onChangeSkinType();
        d(this.aca, TbadkCoreApplication.getInst().getSkinType());
        if (k.jP(this.cau.bjI.getId())) {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_b, 1);
        }
    }

    private void abF() {
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
            if (com.baidu.tbadk.core.h.oY().pe() && this.cau != null && this.cau.bjI != null && this.cau.bjI.rN() != null) {
                this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.caf.startLoad(this.cau.bjI.rN().thumbnail_url, 10, false);
                this.cam.setVisibility(0);
                stopPlay();
                this.baM = this.cau.bjI.rN().video_url;
                if (StringUtils.isNull(this.cau.bjI.rN().video_url)) {
                    f(true, 4);
                }
                if (this.blr != null && this.blr.bjy() != null) {
                    this.blr.bjy().d(this.cau.bjI.rN());
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
            aj.i(this.caB, d.C0095d.cp_cont_i);
            aj.k(this.car, d.C0095d.common_color_10014);
            aj.k(this.bas, d.C0095d.cp_bg_line_e);
            if (this.caq != null) {
                this.caq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bZk != null) {
                this.bZk.onChangeSkinType();
            }
            this.bvI.onChangeSkinType();
            this.bvM.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.caI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caI);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvI != null) {
            this.bvI.setPageUniqueId(bdUniqueId);
        }
        if (this.caf != null) {
            this.caf.setPageId(bdUniqueId);
        }
        if (this.bZk != null) {
            this.bZk.setUniqueId(bdUniqueId);
        }
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
        if (!this.cay && this.cau != null && this.cau.bjI != null && this.cau.bjI.rN() != null && this.can != null && com.baidu.tbadk.util.y.q(1, this.baM)) {
            f(true, 2);
            if (StringUtils.isNull(this.baM)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "index").ac("tid", this.cau.tid));
                this.baM = this.cau.bjI.rN().video_url;
            }
            this.can.bR(this.baM, this.cau.tid);
            this.can.start();
            this.can.setLooping(true);
            if (this.blq != null) {
                this.blq.start();
            }
            this.cay = true;
            abB();
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

    public void setVideoStatsData(y yVar) {
        if (this.blr != null) {
            this.blr.setVideoStatsData(yVar);
        }
    }

    public void a(c.a aVar) {
        if (this.bZk != null) {
            this.bZk.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvI != null) {
            return this.bvI.aob;
        }
        return null;
    }

    public View abw() {
        if (this.bvI != null) {
            return this.bvI.aoc;
        }
        return null;
    }

    public void dP(boolean z) {
        this.caz = z;
    }
}
