package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.al;
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
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.n> {
    private g.f aVR;
    private g.b aVS;
    private View aWK;
    private String aXe;
    private TbPageContext<?> abm;
    private final View.OnClickListener anf;
    private HeadPendantClickableView bJj;
    private ThreadGodReplyLayout bJk;
    private com.baidu.tieba.NEGFeedBack.c bJl;
    private int bKA;
    private int bKB;
    private boolean bKC;
    private boolean bKD;
    private com.baidu.tieba.play.j bKE;
    private Animation bKF;
    private Handler bKG;
    private TbImageView.a bKH;
    private Runnable bKI;
    private Runnable bKJ;
    private QuickVideoView.b bKK;
    private final View.OnClickListener bKL;
    private final View.OnClickListener bKM;
    private CustomMessageListener bKN;
    private j.a bKO;
    private Animation.AnimationListener bKP;
    private TbImageView bKh;
    private ImageView bKi;
    private TextView bKj;
    private View bKk;
    public FrameLayout bKp;
    private QuickVideoView bKq;
    private com.baidu.tieba.play.n bKr;
    private TextView bKs;
    private LinearLayout bKt;
    private TextView bKu;
    private View bKv;
    private ProgressBar bKw;
    private ImageView bKx;
    private com.baidu.tieba.card.data.n bKy;
    private View bKz;
    private RelativeLayout bmI;
    public ThreadUserInfoLayout bmR;
    public ThreadCommentAndPraiseInfoLayout bmV;
    protected LinearLayout bmZ;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void Xv() {
        if (this.bKy != null && this.bKy.bee != null) {
            com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = this.bKy.sourceType == 0 ? "index" : "hot_juhe";
            xVar.cyL = this.bKy.bee.getTid();
            xVar.ayT = this.bKy.bee.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.bKy.bee.Zv;
            xVar.fxN = this.bKy.bee.Zx;
            xVar.fxO = this.bKy.bee.Zw;
            xVar.fxP = "";
            xVar.VW = this.bKy.getExtra();
            if (this.bKy.bee.rF() != null) {
                xVar.fxR = this.bKy.bee.rF().video_md5;
            }
            com.baidu.tieba.play.l.a(this.bKy.bee.rF().video_md5, "", "1", xVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJl = null;
        this.mSkinType = 3;
        this.bKA = 0;
        this.bKB = 1;
        this.bKC = false;
        this.bKD = false;
        this.bKG = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.Xw();
                        return;
                    case 203:
                        j.this.Xx();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aVR = new g.f() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bKG.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aVS = new g.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.g(true, 4);
                return true;
            }
        };
        this.bKH = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && j.this.bKh != null) {
                    j.this.bKh.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bKI = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bKq != null && !j.this.bKq.isPlaying()) {
                    j.this.g(true, 1);
                }
            }
        };
        this.bKJ = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.g(true, 4);
            }
        };
        this.bKK = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bKL = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xn() != null) {
                    j.this.Xn().a(view, j.this.bKy);
                }
            }
        };
        this.bKM = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xn() != null) {
                    j.this.Xn().a(view, j.this.bKy);
                }
            }
        };
        this.bKN = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bKD = false;
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bKy != null && j.this.Xn() != null) {
                    j.this.Xn().a(view, j.this.bKy);
                }
            }
        };
        this.bKO = new j.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.j.a
            public void XB() {
                if (j.this.bKy != null && j.this.bKy.bee != null && j.this.bKy.bee.rF() != null) {
                    j.this.Xv();
                }
            }
        };
        this.bKP = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bKh != null) {
                    j.this.bKh.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.abm = tbPageContext;
        View view = getView();
        this.bmI = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bJj = (HeadPendantClickableView) this.bmI.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abm.getPageActivity(), d.f.ds70));
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.bKw = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bKx = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bmR = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bJl = new com.baidu.tieba.NEGFeedBack.c(this.abm);
        this.bJl.Kl();
        this.bJl.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bmR.addView(this.bJl);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setShareVisible(true);
        this.bmV.setShareReportFrom(3);
        this.bmV.setForumAfterClickListener(this.anf);
        this.bmV.setFrom(1);
        this.bKk = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bKp = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bKp.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ad(this.abm.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abm.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bKp.setLayoutParams(layoutParams2);
        this.bKh = (TbImageView) view.findViewById(d.h.image_video);
        this.bKh.setDefaultErrorResource(0);
        this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKh.setGifIconSupport(false);
        this.bKh.setEvent(this.bKH);
        this.bKi = (ImageView) view.findViewById(d.h.image_video_play);
        this.bmI.setOnClickListener(this);
        this.bKq = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bKr = new com.baidu.tieba.play.n(this.abm.getPageActivity());
        this.bKq.setBusiness(this.bKr);
        this.bKq.setOnPreparedListener(this.aVR);
        this.bKq.setOnErrorListener(this.aVS);
        this.bKq.setOnSurfaceDestroyedListener(this.bKK);
        this.bKE = new com.baidu.tieba.play.j();
        this.bKE.setPlayer(this.bKq);
        this.bKE.a(this.bKO);
        this.bKs = (TextView) view.findViewById(d.h.text_video_duration);
        this.bKt = (LinearLayout) view.findViewById(d.h.duration_container);
        this.bKj = (TextView) view.findViewById(d.h.text_video_play_count);
        this.bKz = view.findViewById(d.h.auto_video_black_mask);
        this.bKu = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bKv = view.findViewById(d.h.auto_video_error_background);
        this.bmZ = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bKF = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bKF.setAnimationListener(this.bKP);
        this.bJk = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJk.setOnClickListener(this);
        this.aWK = view.findViewById(d.h.divider_line);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmI || view == this.bJk) {
            ad(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void ad(View view) {
        if (Xn() != null) {
            Xn().a(view, this.bKy);
        }
        if (this.bKy != null && this.bKy.bee != null) {
            if (!Xr()) {
                m.jl(this.bKy.bee.getId());
                m.a(this.mTextTitle, this.bKy.bee.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abm.getPageActivity()).createFromThreadCfg(this.bKy.bee, null, m.rf(), 18003, true, false, false).addLocateParam(this.bKy.XR());
            addLocateParam.setVideo_source(this.bKy.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bKy.bee.getFid()));
            addLocateParam.setForumName(this.bKy.bee.rt());
            if (this.bKy.bNb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKy.bNb);
            }
            if (view == this.bJk) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xr() {
        return this.bKy.bNu && !this.bKy.bNI;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bKy = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xw() {
        this.bKG.removeMessages(202);
        if (this.bKq.getCurrentPosition() > 0) {
            g(true, 3);
            this.bKG.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bKG.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xx() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bKG.removeMessages(203);
        int currentPosition = this.bKq.getCurrentPosition();
        if (currentPosition != this.bKA) {
            this.bKA = currentPosition;
            g(false, 3);
        } else {
            g(false, 2);
        }
        this.bKG.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bKi != null && this.bKh != null && this.bKz != null && this.bKw != null && this.bKx != null && this.bKv != null && this.bKu != null) {
            if (z || this.bKB != i) {
                this.bKB = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKJ);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKI);
                if (i == 2) {
                    this.bKi.setVisibility(8);
                    this.bKF.cancel();
                    this.bKh.clearAnimation();
                    this.bKh.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bKt.setVisibility(0);
                    this.bKw.setVisibility(0);
                    this.bKx.setVisibility(0);
                    this.bKv.setVisibility(8);
                    this.bKu.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKJ, 60000L);
                } else if (i == 3) {
                    this.bKi.setVisibility(8);
                    this.bKh.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bKt.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKu.setVisibility(8);
                } else if (i == 4) {
                    this.bKi.setVisibility(8);
                    this.bKh.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKv.setVisibility(0);
                    this.bKu.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKI, 2000L);
                } else {
                    this.bKi.setVisibility(0);
                    this.bKF.cancel();
                    this.bKh.clearAnimation();
                    this.bKh.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bKt.setVisibility(0);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKu.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.bKy == null || this.bKy.bee == null || this.bKy.bee.getAuthor() == null) {
            this.bmI.setVisibility(8);
            return;
        }
        this.bmI.setVisibility(0);
        XA();
        if (!Xr() && m.jm(this.bKy.bee.getId())) {
            m.a(this.mTextTitle, this.bKy.bee.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bJk.getGodReplyContent(), this.bKy.Nd().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bKy.Nd().rW();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bKy.Nd().rO()));
        this.bmR.setData(this.bKy.Nd());
        this.bmR.setUserAfterClickListener(this.bKL);
        if (this.bmR.getHeaderImg() != null) {
            this.bmR.getHeaderImg().setAfterClickListener(this.bKM);
            if (this.bmR.getIsSimpleThread()) {
                this.bmR.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (this.bKy.Nd() == null || this.bKy.Nd().getAuthor() == null || this.bKy.Nd().getAuthor().getPendantData() == null || StringUtils.isNull(this.bKy.Nd().getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.bmR.getHeaderImg().setVisibility(0);
                this.bmR.getHeaderImg().setData(this.bKy.Nd());
            } else {
                this.bmR.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(this.bKy.Nd());
            }
        }
        if (this.bmV.setData(this.bKy.bee)) {
            this.bKk.setVisibility(8);
        } else {
            this.bKk.setVisibility(0);
        }
        this.bKs.setText(am.cX(this.bKy.bee.rF().video_duration.intValue() * 1000));
        this.bKj.setText(String.format(this.abm.getResources().getString(d.l.play_count), am.A(this.bKy.bee.rF().play_count.intValue())));
        if (this.bJl != null && this.bKy.Nd() != null) {
            al alVar = new al();
            alVar.cx(this.bKy.Nd().getTid());
            alVar.setFid(this.bKy.Nd().getFid());
            alVar.a(this.bKy.WU);
            this.bJl.setData(alVar);
            this.bJl.setFirstRowSingleColumn(true);
        }
        this.bJk.setData(this.bKy.Nd().sE());
        this.bJk.onChangeSkinType();
        d(this.abm, TbadkCoreApplication.getInst().getSkinType());
        if (m.jm(this.bKy.bee.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void Xy() {
        this.bKG.removeMessages(202);
        this.bKG.removeMessages(203);
    }

    private void Xz() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKI);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKJ);
    }

    private void XA() {
        Xz();
        Xy();
        if (this.bKh != null && this.bKp != null && this.bKq != null) {
            if (com.baidu.tbadk.core.h.oM().oS() && this.bKy != null && this.bKy.bee != null && this.bKy.bee.rF() != null) {
                this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bKh.c(this.bKy.bee.rF().thumbnail_url, 10, false);
                this.bKp.setVisibility(0);
                stopPlay();
                this.aXe = this.bKy.bee.rF().video_url;
                if (StringUtils.isNull(this.bKy.bee.rF().video_url)) {
                    g(true, 4);
                }
                if (this.bKr != null && this.bKr.ben() != null) {
                    this.bKr.ben().d(this.bKy.bee.rF());
                    return;
                }
                return;
            }
            this.bKp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bmI, d.g.addresslist_item_bg);
            aj.c(this.bKi, d.g.btn_icon_play_video_n);
            aj.i(this.bKu, d.e.cp_cont_i);
            aj.i(this.bKs, d.e.cp_cont_i);
            aj.i(this.bKj, d.e.cp_cont_i);
            aj.k(this.bKv, d.e.common_color_10014);
            aj.k(this.aWK, d.e.cp_bg_line_e);
            if (this.bKu != null) {
                this.bKu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bJl != null) {
                this.bJl.onChangeSkinType();
            }
            this.bmR.onChangeSkinType();
            this.bmV.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bKN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKN);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bmR != null) {
            this.bmR.setPageUniqueId(bdUniqueId);
        }
        if (this.bKh != null) {
            this.bKh.setPageId(bdUniqueId);
        }
        if (this.bJl != null) {
            this.bJl.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bKC;
    }

    public boolean isPlaying() {
        if (this.bKq == null) {
            return false;
        }
        return this.bKq.isPlaying();
    }

    public void startPlay() {
        if (!this.bKC && this.bKy != null && this.bKy.bee != null && this.bKy.bee.rF() != null && this.bKq != null && com.baidu.tbadk.util.w.q(1, this.aXe)) {
            g(true, 2);
            if (TextUtils.isEmpty(this.aXe)) {
                TiebaStatic.log(new ak("c12026").ac("tid", this.bKy.WT));
            }
            this.bKq.setVideoPath(this.aXe);
            this.bKq.start();
            this.bKq.setLooping(true);
            if (this.bKE != null) {
                this.bKE.start();
            }
            this.bKC = true;
            Xv();
        }
    }

    public void stopPlay() {
        Xz();
        Xy();
        g(true, 1);
        if (this.bKq != null) {
            this.bKq.stopPlayback();
            if (this.bKE != null) {
                this.bKE.stop();
            }
        }
        this.bKC = false;
    }

    public View getVideoContainer() {
        return this.bKp;
    }

    public String getPlayUrl() {
        return this.aXe;
    }

    public int getCurrentPosition() {
        if (this.bKq == null) {
            return 0;
        }
        return this.bKq.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.x xVar) {
        if (this.bKr != null) {
            this.bKr.setVideoStatsData(xVar);
        }
    }

    public void a(c.a aVar) {
        if (this.bJl != null) {
            this.bJl.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bmR != null) {
            return this.bmR.ans;
        }
        return null;
    }

    public View Xq() {
        if (this.bmR != null) {
            return this.bmR.ant;
        }
        return null;
    }
}
