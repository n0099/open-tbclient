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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
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
    private g.f aZn;
    private g.b aZo;
    private TbPageContext<?> acd;
    private final View.OnClickListener anO;
    private TbImageView bZX;
    private TextView bZY;
    private View bZZ;
    private HeadPendantClickableView bZa;
    public ThreadGodReplyLayout bZb;
    private com.baidu.tieba.NEGFeedBack.c bZc;
    private String baH;
    private View bam;
    private ImageView bkW;
    private Animation bla;
    private com.baidu.tieba.play.j bll;
    private com.baidu.tieba.play.n blm;
    private QuickVideoView.b blr;
    public ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    protected LinearLayout bvK;
    private RelativeLayout bvu;
    private CustomMessageListener caA;
    private j.a caB;
    private Animation.AnimationListener caC;
    public FrameLayout cae;
    private QuickVideoView caf;
    private TextView cag;
    private LinearLayout cah;
    private TextView cai;
    private View caj;
    private ProgressBar cak;
    private ImageView cal;
    private n cam;
    private View can;
    private int cao;
    private int cap;
    private boolean caq;
    private boolean car;
    private boolean cas;
    private TextView cat;
    private Handler cau;
    private TbImageView.a cav;
    private Runnable caw;
    private Runnable cax;
    private final View.OnClickListener cay;
    private final View.OnClickListener caz;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void abA() {
        if (this.cam != null && this.cam.bjD != null) {
            y yVar = new y();
            yVar.mLocate = this.cam.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aMR = this.cam.bjD.getTid();
            yVar.aAn = this.cam.bjD.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cam.bjD.aaj;
            yVar.fQp = this.cam.bjD.aal;
            yVar.fQq = this.cam.bjD.aak;
            yVar.fQr = "";
            yVar.WL = this.cam.getExtra();
            if (this.cam.bjD.rP() != null) {
                yVar.fQt = this.cam.bjD.rP().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cam.bjD.rP().video_md5, "", "1", yVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZc = null;
        this.mSkinType = 3;
        this.cao = 0;
        this.cap = 1;
        this.caq = false;
        this.car = true;
        this.cas = false;
        this.cau = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.abB();
                        return;
                    case 203:
                        j.this.abC();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZn = new g.f() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.cau.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aZo = new g.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.cav = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && j.this.bZX != null) {
                    j.this.bZX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.caw = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.caf != null && !j.this.caf.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.cax = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.blr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.cay = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abs() != null) {
                    j.this.abs().a(view, j.this.cam);
                }
            }
        };
        this.caz = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.abs() != null) {
                    j.this.abs().a(view, j.this.cam);
                }
            }
        };
        this.caA = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.cas = false;
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cam != null && j.this.abs() != null) {
                    j.this.abs().a(view, j.this.cam);
                }
            }
        };
        this.caB = new j.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.j.a
            public void abG() {
                if (j.this.cam != null && j.this.cam.bjD != null && j.this.cam.bjD.rP() != null) {
                    j.this.abA();
                }
            }
        };
        this.caC = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bZX != null) {
                    j.this.bZX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.acd = tbPageContext;
        View view = getView();
        this.bvu = (RelativeLayout) view.findViewById(d.g.layout_root);
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
        this.cak = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.cal = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bZc = new com.baidu.tieba.NEGFeedBack.c(abr());
        int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16);
        this.bZc.a(this.bvu, f, 0);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
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
        this.bvH.setShareVisible(true);
        this.bvH.setShareReportFrom(3);
        this.bvH.setForumAfterClickListener(this.anO);
        this.bvH.setFrom(1);
        this.bZZ = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cae = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cae.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ac(this.acd.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.acd.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cae.setLayoutParams(layoutParams2);
        this.bZX = (TbImageView) view.findViewById(d.g.image_video);
        this.bZX.setDefaultErrorResource(0);
        this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bZX.setGifIconSupport(false);
        this.bZX.setEvent(this.cav);
        this.bkW = (ImageView) view.findViewById(d.g.image_video_play);
        this.bvu.setOnClickListener(this);
        this.caf = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.blm = new com.baidu.tieba.play.n(this.acd.getPageActivity());
        this.caf.setBusiness(this.blm);
        this.caf.setOnPreparedListener(this.aZn);
        this.caf.setOnErrorListener(this.aZo);
        this.caf.setOnSurfaceDestroyedListener(this.blr);
        this.bll = new com.baidu.tieba.play.j();
        this.bll.setPlayer(this.caf);
        this.bll.a(this.caB);
        this.cag = (TextView) view.findViewById(d.g.text_video_duration);
        this.cah = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bZY = (TextView) view.findViewById(d.g.text_video_play_count);
        this.can = view.findViewById(d.g.auto_video_black_mask);
        this.cai = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.caj = view.findViewById(d.g.auto_video_error_background);
        this.bvK = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bla = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bla.setAnimationListener(this.caC);
        this.bZb = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZb.setOnClickListener(this);
        this.bam = view.findViewById(d.g.divider_line);
        this.cat = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cam != null && this.cam.bjD != null && this.cam.bjD.aaG > 0) {
            if (abs() != null) {
                abs().a(view, this.cam);
            }
            this.acd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.acd.getPageActivity(), this.cam.bjD.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, k.rn(), this.cam.abW())));
        } else if (view == this.bvu || view == this.bZb) {
            ah(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void ah(View view) {
        if (abs() != null) {
            abs().a(view, this.cam);
        }
        if (this.cam != null && this.cam.bjD != null) {
            if (!abw()) {
                k.jQ(this.cam.bjD.getId());
                k.a(this.mTextTitle, this.cam.bjD.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acd.getPageActivity()).createFromThreadCfg(this.cam.bjD, null, k.rn(), 18003, true, false, false).addLocateParam(this.cam.abW());
            addLocateParam.setVideo_source(this.cam.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cam.bjD.getFid()));
            addLocateParam.setForumName(this.cam.bjD.rD());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.bZb) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abw() {
        return this.cam.cdF && !this.cam.cdT;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.cam = nVar;
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
        this.cau.sendEmptyMessageDelayed(202, 300L);
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
                    this.cah.setVisibility(0);
                    this.cat.setVisibility(8);
                    this.cak.setVisibility(0);
                    this.cal.setVisibility(0);
                    this.caj.setVisibility(8);
                    this.cai.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.cax, 60000L);
                } else if (i == 3) {
                    this.bkW.setVisibility(8);
                    this.bZX.startAnimation(this.bla);
                    this.can.setVisibility(8);
                    this.cah.setVisibility(8);
                    if (this.cam != null && this.cam.Ox() != null && this.cam.Ox().aaG > 0) {
                        this.cat.setVisibility(0);
                    }
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
                    this.bla.cancel();
                    this.bZX.clearAnimation();
                    this.bZX.setVisibility(0);
                    this.can.setVisibility(0);
                    this.cah.setVisibility(0);
                    this.cak.setVisibility(8);
                    this.cal.setVisibility(8);
                    this.caj.setVisibility(8);
                    this.cai.setVisibility(8);
                }
                if (this.cam != null && this.cam.Ox() != null && this.cam.Ox().aaG > 0) {
                    this.cah.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cam == null || this.cam.bjD == null || this.cam.bjD.rx() == null) {
            this.bvu.setVisibility(8);
            return;
        }
        this.bvu.setVisibility(0);
        abF();
        if (!abw() && k.jR(this.cam.bjD.getId())) {
            k.a(this.mTextTitle, this.cam.bjD.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            k.a(this.bZb.getGodReplyContent(), this.cam.Ox().getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
        }
        this.cam.Ox().sf();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cam.Ox().rX()));
        this.bvD.setData(this.cam.Ox());
        this.bvD.setUserAfterClickListener(this.cay);
        if (this.bvD.getHeaderImg() != null) {
            this.bvD.getHeaderImg().setAfterClickListener(this.caz);
            if (this.bvD.getIsSimpleThread()) {
                this.bvD.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (this.cam.Ox() == null || this.cam.Ox().rx() == null || this.cam.Ox().rx().getPendantData() == null || StringUtils.isNull(this.cam.Ox().rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.bvD.getHeaderImg().setVisibility(0);
                if (this.cam.Ox().aaG > 0 && this.cam.Ox().aaH == 0) {
                    this.cam.Ox().rx().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bvD.getHeaderImg().a(this.cam.Ox(), false);
                } else {
                    this.bvD.getHeaderImg().setData(this.cam.Ox());
                    this.bvD.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bvD.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(this.cam.Ox());
            }
        }
        if (this.cam.bjD.aaG > 0) {
            this.bvH.setShowPraiseNum(false);
            this.bvH.setShareVisible(false);
            this.cat.setText(am.A(this.cam.bjD.aaG));
            this.cat.setVisibility(0);
        } else {
            this.bvH.setShowPraiseNum(true);
            this.bvH.setShareVisible(true);
            this.cat.setVisibility(8);
        }
        if (this.bvH.setData(this.cam.bjD)) {
            this.bZZ.setVisibility(8);
        } else {
            this.bZZ.setVisibility(0);
        }
        this.cag.setText(am.cY(this.cam.bjD.rP().video_duration.intValue() * 1000));
        this.bZY.setText(String.format(this.acd.getResources().getString(d.j.play_count), am.A(this.cam.bjD.rP().play_count.intValue())));
        if (this.bZc != null && this.cam.Ox() != null) {
            ah ahVar = new ah();
            ahVar.cD(this.cam.Ox().getTid());
            ahVar.setFid(this.cam.Ox().getFid());
            ahVar.a(this.cam.XE);
            this.bZc.setData(ahVar);
            this.bZc.setFirstRowSingleColumn(true);
            this.bZc.setVisibility(this.car ? 0 : 8);
        }
        this.bZb.setData(this.cam.Ox().sO());
        this.bZb.onChangeSkinType();
        d(this.acd, TbadkCoreApplication.getInst().getSkinType());
        if (k.jR(this.cam.bjD.getId())) {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0082d.cp_cont_b, 1);
        }
    }

    private void abD() {
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
            if (com.baidu.tbadk.core.h.pa().pg() && this.cam != null && this.cam.bjD != null && this.cam.bjD.rP() != null) {
                this.bZX.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bZX.startLoad(this.cam.bjD.rP().thumbnail_url, 10, false);
                this.cae.setVisibility(0);
                stopPlay();
                this.baH = this.cam.bjD.rP().video_url;
                if (StringUtils.isNull(this.cam.bjD.rP().video_url)) {
                    f(true, 4);
                }
                if (this.blm != null && this.blm.bjq() != null) {
                    this.blm.bjq().d(this.cam.bjD.rP());
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
            aj.i(this.cat, d.C0082d.cp_cont_i);
            aj.k(this.caj, d.C0082d.common_color_10014);
            aj.k(this.bam, d.C0082d.cp_bg_line_e);
            if (this.cai != null) {
                this.cai.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bZc != null) {
                this.bZc.onChangeSkinType();
            }
            this.bvD.onChangeSkinType();
            this.bvH.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.caA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caA);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvD != null) {
            this.bvD.setPageUniqueId(bdUniqueId);
        }
        if (this.bZX != null) {
            this.bZX.setPageId(bdUniqueId);
        }
        if (this.bZc != null) {
            this.bZc.setUniqueId(bdUniqueId);
        }
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
        if (!this.caq && this.cam != null && this.cam.bjD != null && this.cam.bjD.rP() != null && this.caf != null && com.baidu.tbadk.util.y.q(1, this.baH)) {
            f(true, 2);
            if (StringUtils.isNull(this.baH)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "index").ac("tid", this.cam.tid));
                this.baH = this.cam.bjD.rP().video_url;
            }
            this.caf.bQ(this.baH, this.cam.tid);
            this.caf.start();
            this.caf.setLooping(true);
            if (this.bll != null) {
                this.bll.start();
            }
            this.caq = true;
            abA();
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

    public void setVideoStatsData(y yVar) {
        if (this.blm != null) {
            this.blm.setVideoStatsData(yVar);
        }
    }

    public void a(c.a aVar) {
        if (this.bZc != null) {
            this.bZc.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvD != null) {
            return this.bvD.anW;
        }
        return null;
    }

    public View abv() {
        if (this.bvD != null) {
            return this.bvD.anX;
        }
        return null;
    }

    public void dO(boolean z) {
        this.car = z;
    }
}
