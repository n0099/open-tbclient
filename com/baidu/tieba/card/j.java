package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.i;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.n> {
    private f.a aUv;
    private f.e aUw;
    private f.b aUx;
    private String aVG;
    private TbPageContext<?> aby;
    private final View.OnClickListener aoe;
    public FrameLayout bHD;
    private TbImageView bHE;
    private ImageView bHF;
    private TbImageView.a bHH;
    private HeadPendantClickableView bJq;
    private ThreadGodReplyLayout bJr;
    private View bJs;
    private com.baidu.tbadk.core.view.h bJt;
    private int bKA;
    private int bKB;
    private boolean bKC;
    private boolean bKD;
    private com.baidu.tieba.play.i bKE;
    private Animation bKF;
    private Handler bKG;
    private Runnable bKH;
    private Runnable bKI;
    private QuickVideoView.b bKJ;
    private final View.OnClickListener bKK;
    private final View.OnClickListener bKL;
    private CustomMessageListener bKM;
    private i.a bKN;
    private Animation.AnimationListener bKO;
    private QuickVideoView bKq;
    private com.baidu.tieba.play.m bKr;
    private TextView bKs;
    private TextView bKt;
    private View bKu;
    private AudioAnimationView bKv;
    private ProgressBar bKw;
    private ImageView bKx;
    private com.baidu.tieba.card.data.n bKy;
    private View bKz;
    private View bhp;
    protected LinearLayout blD;
    private RelativeLayout blm;
    public ThreadUserInfoLayout blv;
    public ThreadCommentAndPraiseInfoLayout blz;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void XI() {
        if (this.bKy != null && this.bKy.bcJ != null) {
            com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
            wVar.mLocate = this.bKy.sourceType == 0 ? "index" : "hot_juhe";
            wVar.bGH = this.bKy.bcJ.getTid();
            wVar.azO = this.bKy.bcJ.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.bKy.bcJ.ZH;
            wVar.fAU = this.bKy.bcJ.ZJ;
            wVar.fAV = this.bKy.bcJ.ZI;
            wVar.fAW = "";
            if (this.bKy.bcJ.sF() != null && this.bKy.bcJ.sF().channelId > 0) {
                wVar.VU = this.bKy.bcJ.sF().channelId + "";
            } else {
                wVar.VU = "0";
            }
            if (this.bKy.bcJ.rS() != null) {
                wVar.fAY = this.bKy.bcJ.rS().video_md5;
            }
            com.baidu.tieba.play.k.a(this.bKy.bcJ.rS().video_md5, "", "1", wVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJt = null;
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
                        j.this.XJ();
                        return;
                    case 203:
                        j.this.XK();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUw = new f.e() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bKG.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aUx = new f.b() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                j.this.g(true, 4);
                return true;
            }
        };
        this.aUv = new f.a() { // from class: com.baidu.tieba.card.j.9
            @Override // com.baidu.tieba.play.f.a
            public void onCompletion(com.baidu.tieba.play.f fVar) {
                if (fVar != null && fVar.isLooping()) {
                    j.this.XI();
                }
            }
        };
        this.bHH = new TbImageView.a() { // from class: com.baidu.tieba.card.j.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && j.this.bHE != null) {
                    j.this.bHE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bKH = new Runnable() { // from class: com.baidu.tieba.card.j.11
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bKq != null && !j.this.bKq.isPlaying()) {
                    j.this.g(true, 1);
                }
            }
        };
        this.bKI = new Runnable() { // from class: com.baidu.tieba.card.j.12
            @Override // java.lang.Runnable
            public void run() {
                j.this.g(true, 4);
            }
        };
        this.bKJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bKK = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XA() != null) {
                    j.this.XA().a(view, j.this.bKy);
                }
            }
        };
        this.bKL = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.XA() != null) {
                    j.this.XA().a(view, j.this.bKy);
                }
            }
        };
        this.bKM = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bKD = false;
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bKy != null && j.this.XA() != null) {
                    j.this.XA().a(view, j.this.bKy);
                }
            }
        };
        this.bKN = new i.a() { // from class: com.baidu.tieba.card.j.5
            @Override // com.baidu.tieba.play.i.a
            public void XO() {
                if (j.this.bKy != null && j.this.bKy.bcJ != null && j.this.bKy.bcJ.rS() != null) {
                    j.this.XI();
                }
            }
        };
        this.bKO = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bHE != null) {
                    j.this.bHE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aby = tbPageContext;
        View view = getView();
        this.blm = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bJq = (HeadPendantClickableView) this.blm.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJq.getHeadView() != null) {
            this.bJq.getHeadView().setIsRound(true);
            this.bJq.getHeadView().setDrawBorder(false);
            this.bJq.getHeadView().setDefaultResource(17170445);
            this.bJq.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJq.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJq.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aby.getPageActivity(), d.f.ds70));
        }
        this.bJq.wB();
        if (this.bJq.getPendantView() != null) {
            this.bJq.getPendantView().setIsRound(true);
            this.bJq.getPendantView().setDrawBorder(false);
        }
        this.bKw = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bKx = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.blv = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bJt = new com.baidu.tbadk.core.view.h(this.aby);
        this.bJt.wI();
        this.bJt.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blv.addView(this.bJt);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this);
        this.blz.setReplyTimeVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setShareVisible(true);
        this.blz.setShareReportFrom(3);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setForumAfterClickListener(this.aoe);
        this.blz.setFrom(1);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bHD = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bHD.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.ad(this.aby.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aby.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bHD.setLayoutParams(layoutParams2);
        this.bHE = (TbImageView) view.findViewById(d.h.image_video);
        this.bHE.setDefaultErrorResource(0);
        this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bHE.setGifIconSupport(false);
        this.bHE.setEvent(this.bHH);
        this.bHF = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKv = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bKv.setCertainColumnCount(4);
        this.bKv.setColumnColor(d.e.cp_cont_i);
        this.blm.setOnClickListener(this);
        this.bKq = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bKr = new com.baidu.tieba.play.m(this.aby.getPageActivity());
        this.bKq.setBusiness(this.bKr);
        this.bKq.setOnPreparedListener(this.aUw);
        this.bKq.setOnErrorListener(this.aUx);
        this.bKq.setOnSurfaceDestroyedListener(this.bKJ);
        this.bKq.setOnCompletionListener(this.aUv);
        this.bKE = new com.baidu.tieba.play.i();
        this.bKE.setPlayer(this.bKq);
        this.bKE.a(this.bKN);
        this.bKs = (TextView) view.findViewById(d.h.text_video_duration);
        this.bKz = view.findViewById(d.h.auto_video_black_mask);
        this.bKt = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bKu = view.findViewById(d.h.auto_video_error_background);
        this.blD = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bKF = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bKF.setAnimationListener(this.bKO);
        this.bhp = view.findViewById(d.h.divider_line);
        this.bJr = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJr.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.blm || view == this.bJr) {
            ae(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void ae(View view) {
        if (XA() != null) {
            XA().a(view, this.bKy);
        }
        if (this.bKy != null && this.bKy.bcJ != null) {
            if (!XE()) {
                m.js(this.bKy.bcJ.getId());
                m.a(this.mTextTitle, this.bKy.bcJ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aby.getPageActivity()).createFromThreadCfg(this.bKy.bcJ, null, m.rs(), 18003, true, false, false).addLocateParam(this.bKy.Yc());
            addLocateParam.setVideo_source(this.bKy.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bKy.bcJ.getFid()));
            addLocateParam.setForumName(this.bKy.bcJ.rG());
            if (this.bKy.bMS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKy.bMS);
            }
            if (view == this.bJr) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XE() {
        return this.bKy.bNk && !this.bKy.bNy;
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
    public void XJ() {
        this.bKG.removeMessages(202);
        if (this.bKq.getCurrentPosition() > 0) {
            g(true, 3);
            this.bKG.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bKG.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XK() {
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
        if (this.bHF != null && this.bHE != null && this.bKz != null && this.bKv != null && this.bKw != null && this.bKx != null && this.bKu != null && this.bKt != null) {
            if (z || this.bKB != i) {
                this.bKB = i;
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKI);
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKH);
                if (i == 2) {
                    this.bHF.setVisibility(8);
                    this.bKF.cancel();
                    this.bHE.clearAnimation();
                    this.bHE.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bKs.setVisibility(0);
                    this.bKw.setVisibility(0);
                    this.bKx.setVisibility(0);
                    this.bKu.setVisibility(8);
                    this.bKt.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKv.bwt();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bKI, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bHF.setVisibility(8);
                    this.bHE.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bKs.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKu.setVisibility(8);
                    this.bKt.setVisibility(8);
                    this.bKv.setVisibility(0);
                    this.bKv.start();
                } else if (i == 4) {
                    this.bHF.setVisibility(8);
                    this.bHE.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKu.setVisibility(0);
                    this.bKt.setVisibility(0);
                    this.bKv.setVisibility(8);
                    this.bKv.bwt();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bKH, 2000L);
                } else {
                    this.bHF.setVisibility(0);
                    this.bKF.cancel();
                    this.bHE.clearAnimation();
                    this.bHE.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bKs.setVisibility(0);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKu.setVisibility(8);
                    this.bKt.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKv.bwt();
                }
            }
        }
    }

    private void refreshView() {
        String string;
        if (this.bKy == null || this.bKy.bcJ == null || this.bKy.bcJ.getAuthor() == null) {
            this.blm.setVisibility(8);
            return;
        }
        this.blm.setVisibility(0);
        XN();
        if (!XE() && m.jt(this.bKy.bcJ.getId())) {
            m.a(this.mTextTitle, this.bKy.bcJ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bJr.getGodReplyContent(), this.bKy.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJr.getPraiseNum(), this.bKy.MR().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bKy.MR().sj();
        if (this.bKy.bcJ.sF() != null && this.bKy.bcJ.sF().channelId > 0) {
            string = this.aby.getResources().getString(d.l.channel_title_prefix);
        } else if (this.bKy.bcJ.getThreadType() == 50) {
            string = this.aby.getResources().getString(d.l.ala_record_title_prefix);
        } else {
            string = this.aby.getResources().getString(d.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bKy.MR().sb()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.blv.c(this.bKy.MR());
        this.blv.setUserAfterClickListener(this.bKK);
        if (this.blv.getHeaderImg() != null) {
            this.blv.getHeaderImg().setAfterClickListener(this.bKL);
            if (this.blv.getIsSimpleThread()) {
                this.blv.getHeaderImg().setVisibility(8);
                this.bJq.setVisibility(8);
            } else if (this.bKy.MR() == null || this.bKy.MR().getAuthor() == null || this.bKy.MR().getAuthor().getPendantData() == null || StringUtils.isNull(this.bKy.MR().getAuthor().getPendantData().pR())) {
                this.bJq.setVisibility(8);
                this.blv.getHeaderImg().setVisibility(0);
                this.blv.getHeaderImg().setData(this.bKy.MR());
            } else {
                this.blv.getHeaderImg().setVisibility(4);
                this.bJq.setVisibility(0);
                this.bJq.setData(this.bKy.MR());
            }
        }
        if (this.blz.c(this.bKy.bcJ)) {
            this.bJs.setVisibility(8);
        } else {
            this.bJs.setVisibility(0);
        }
        this.bKs.setText(am.da(this.bKy.bcJ.rS().video_duration.intValue() * 1000));
        if (this.bJt != null && this.bKy.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bKy.MR().getTid());
            anVar.setFid(this.bKy.MR().getFid());
            anVar.a(this.bKy.Xf);
            this.bJt.setData(anVar);
            this.bJt.setFirstRowSingleColumn(true);
        }
        this.bJr.setData(this.bKy.MR().sR());
        this.bJr.onChangeSkinType();
        if (this.bJr.getVisibility() == 0) {
            this.bJs.setVisibility(0);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
        if (m.jt(this.bKy.bcJ.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void XL() {
        this.bKG.removeMessages(202);
        this.bKG.removeMessages(203);
    }

    private void XM() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKH);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bKI);
    }

    private void XN() {
        XM();
        XL();
        if (this.bHE != null && this.bHD != null && this.bKq != null) {
            if (com.baidu.tbadk.core.h.oS().oY() && this.bKy != null && this.bKy.bcJ != null && this.bKy.bcJ.rS() != null) {
                this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bHE.c(this.bKy.bcJ.rS().thumbnail_url, 10, false);
                this.bHD.setVisibility(0);
                stopPlay();
                this.aVG = this.bKy.bcJ.rS().video_url;
                if (StringUtils.isNull(this.bKy.bcJ.rS().video_url)) {
                    g(true, 4);
                }
                if (this.bKr != null && this.bKr.bfF() != null) {
                    this.bKr.bfF().d(this.bKy.bcJ.rS());
                    return;
                }
                return;
            }
            this.bHD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.blm, d.g.addresslist_item_bg);
            aj.c(this.bHF, d.g.home_ic_video);
            aj.i(this.bKt, d.e.cp_cont_i);
            aj.i(this.bKs, d.e.cp_cont_i);
            aj.k(this.bKu, d.e.common_color_10014);
            if (this.bKt != null) {
                this.bKt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            aj.j(this.bhp, d.e.cp_bg_line_c);
            if (this.bJt != null) {
                this.bJt.onChangeSkinType();
            }
            this.blv.onChangeSkinType();
            this.blz.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bKM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKM);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.blv != null) {
            this.blv.setPageUniqueId(bdUniqueId);
        }
        if (this.bHE != null) {
            this.bHE.setPageId(bdUniqueId);
        }
        if (this.bJt != null) {
            this.bJt.setUniqueId(bdUniqueId);
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
        if (!this.bKC && this.bKy != null && this.bKy.bcJ != null && this.bKy.bcJ.rS() != null && this.bKq != null && com.baidu.tbadk.util.x.q(1, this.aVG)) {
            g(true, 2);
            this.bKq.setVideoPath(this.aVG);
            this.bKq.start();
            this.bKq.setLooping(true);
            if (this.bKE != null) {
                this.bKE.start();
            }
            this.bKC = true;
            XI();
        }
    }

    public void stopPlay() {
        XM();
        XL();
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
        return this.bHD;
    }

    public String getPlayUrl() {
        return this.aVG;
    }

    public int getCurrentPosition() {
        if (this.bKq == null) {
            return 0;
        }
        return this.bKq.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.w wVar) {
        if (this.bKr != null) {
            this.bKr.setVideoStatsData(wVar);
        }
    }

    public void a(h.a aVar) {
        if (this.bJt != null) {
            this.bJt.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.blv != null) {
            return this.blv.aor;
        }
        return null;
    }

    public View XD() {
        if (this.blv != null) {
            return this.blv.aos;
        }
        return null;
    }
}
