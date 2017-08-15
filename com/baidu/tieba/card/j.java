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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
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
    private f.d aUN;
    private f.b aUO;
    private TbPageContext<?> acr;
    private final View.OnClickListener aoH;
    public FrameLayout bEI;
    private TbImageView bEJ;
    private ImageView bEK;
    private TbImageView.a bEM;
    private HeadPendantClickableView bGv;
    private ThreadGodReplyLayout bGw;
    private View bGx;
    private com.baidu.tbadk.core.view.h bGy;
    private AudioAnimationView bHA;
    private ProgressBar bHB;
    private ImageView bHC;
    private com.baidu.tieba.card.data.n bHD;
    private View bHE;
    private int bHF;
    private int bHG;
    private boolean bHH;
    private boolean bHI;
    private com.baidu.tieba.play.i bHJ;
    private Animation bHK;
    private Handler bHL;
    private Runnable bHM;
    private Runnable bHN;
    private QuickVideoView.b bHO;
    private final View.OnClickListener bHP;
    private final View.OnClickListener bHQ;
    private CustomMessageListener bHR;
    private i.a bHS;
    private Animation.AnimationListener bHT;
    private QuickVideoView bHv;
    private com.baidu.tieba.play.m bHw;
    private TextView bHx;
    private TextView bHy;
    private View bHz;
    private View bhj;
    private RelativeLayout bkQ;
    public ThreadUserInfoLayout bkZ;
    public ThreadCommentAndPraiseInfoLayout bld;
    protected LinearLayout blh;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGy = null;
        this.mSkinType = 3;
        this.bHF = 0;
        this.bHG = 1;
        this.bHH = false;
        this.bHI = false;
        this.bHL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.WI();
                        return;
                    case 203:
                        j.this.WJ();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUN = new f.d() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bHL.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aUO = new f.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.bEM = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && j.this.bEJ != null) {
                    j.this.bEJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bHM = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bHv != null && !j.this.bHv.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.bHN = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.bHO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bHP = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.WA() != null) {
                    j.this.WA().a(view, j.this.bHD);
                }
            }
        };
        this.bHQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.WA() != null) {
                    j.this.WA().a(view, j.this.bHD);
                }
            }
        };
        this.bHR = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bHI = false;
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bHD != null && j.this.WA() != null) {
                    j.this.WA().a(view, j.this.bHD);
                }
            }
        };
        this.bHS = new i.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.i.a
            public void WN() {
                if (j.this.bHD != null && j.this.bHD.bcM != null && j.this.bHD.bcM.rW() != null) {
                    com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
                    wVar.mLocate = j.this.bHD.sourceType == 0 ? "index" : "hot_juhe";
                    wVar.bDM = j.this.bHD.bcM.getTid();
                    wVar.aAC = j.this.bHD.bcM.getFid() + "";
                    wVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    wVar.mSource = j.this.bHD.bcM.aaC;
                    wVar.fCq = j.this.bHD.bcM.aaE;
                    wVar.fCr = j.this.bHD.bcM.aaD;
                    wVar.fCs = "";
                    if (j.this.bHD.bcM.sJ() != null && j.this.bHD.bcM.sJ().channelId > 0) {
                        wVar.WK = j.this.bHD.bcM.sJ().channelId + "";
                    } else {
                        wVar.WK = "0";
                    }
                    com.baidu.tieba.play.k.a(j.this.bHD.bcM.rW().video_md5, "", "1", wVar);
                }
            }
        };
        this.bHT = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bEJ != null) {
                    j.this.bEJ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.acr = tbPageContext;
        View view = getView();
        this.bkQ = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bGv = (HeadPendantClickableView) this.bkQ.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds70));
        }
        this.bGv.wD();
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.bHB = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bHC = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bkZ = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bGy = new com.baidu.tbadk.core.view.h(this.acr);
        this.bGy.wK();
        this.bGy.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bkZ.addView(this.bGy);
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bld.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bld.setLayoutParams(layoutParams);
        }
        this.bld.setOnClickListener(this);
        this.bld.setReplyTimeVisible(false);
        this.bld.setShowPraiseNum(true);
        this.bld.setNeedAddPraiseIcon(true);
        this.bld.setNeedAddReplyIcon(true);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bld.setForumAfterClickListener(this.aoH);
        this.bld.setFrom(1);
        this.bGx = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bEI = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bEI.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.ag(this.acr.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bEI.setLayoutParams(layoutParams2);
        this.bEJ = (TbImageView) view.findViewById(d.h.image_video);
        this.bEJ.setDefaultErrorResource(0);
        this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEJ.setGifIconSupport(false);
        this.bEJ.setEvent(this.bEM);
        this.bEK = (ImageView) view.findViewById(d.h.image_video_play);
        this.bHA = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bHA.setCertainColumnCount(4);
        this.bHA.setColumnColor(d.e.cp_cont_i);
        this.bkQ.setOnClickListener(this);
        this.bHv = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bHw = new com.baidu.tieba.play.m(this.acr.getPageActivity());
        this.bHv.setBusiness(this.bHw);
        this.bHv.setOnPreparedListener(this.aUN);
        this.bHv.setOnErrorListener(this.aUO);
        this.bHv.setOnSurfaceDestroyedListener(this.bHO);
        this.bHJ = new com.baidu.tieba.play.i();
        this.bHJ.setPlayer(this.bHv);
        this.bHJ.a(this.bHS);
        this.bHx = (TextView) view.findViewById(d.h.text_video_duration);
        this.bHE = view.findViewById(d.h.auto_video_black_mask);
        this.bHy = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bHz = view.findViewById(d.h.auto_video_error_background);
        this.blh = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bHK = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bHK.setAnimationListener(this.bHT);
        this.bhj = view.findViewById(d.h.divider_line);
        this.bGw = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bGw.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkQ || view == this.bGw) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void X(View view) {
        if (WA() != null) {
            WA().a(view, this.bHD);
        }
        if (this.bHD != null && this.bHD.bcM != null) {
            if (!WE()) {
                m.je(this.bHD.bcM.getId());
                m.a(this.mTextTitle, this.bHD.bcM.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acr.getPageActivity()).createFromThreadCfg(this.bHD.bcM, null, m.rw(), 18003, true, false, false).addLocateParam(this.bHD.Xc());
            addLocateParam.setVideo_source(this.bHD.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bHD.bcM.getFid()));
            addLocateParam.setForumName(this.bHD.bcM.rK());
            if (this.bHD.bJZ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bHD.bJZ);
            }
            if (view == this.bGw) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WE() {
        return this.bHD.bKr && !this.bHD.bKF;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bHD = nVar;
        Oy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WI() {
        this.bHL.removeMessages(202);
        if (this.bHv.getCurrentPosition() > 0) {
            f(true, 3);
            this.bHL.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bHL.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WJ() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bHL.removeMessages(203);
        int currentPosition = this.bHv.getCurrentPosition();
        if (currentPosition != this.bHF) {
            this.bHF = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bHL.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bEK != null && this.bEJ != null && this.bHE != null && this.bHA != null && this.bHB != null && this.bHC != null && this.bHz != null && this.bHy != null) {
            if (z || this.bHG != i) {
                this.bHG = i;
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHM);
                if (i == 2) {
                    this.bEK.setVisibility(8);
                    this.bHK.cancel();
                    this.bEJ.clearAnimation();
                    this.bEJ.setVisibility(0);
                    this.bHE.setVisibility(0);
                    this.bHx.setVisibility(0);
                    this.bHB.setVisibility(0);
                    this.bHC.setVisibility(0);
                    this.bHz.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHA.bxk();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHN, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bEK.setVisibility(8);
                    this.bEJ.startAnimation(this.bHK);
                    this.bHE.setVisibility(8);
                    this.bHx.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHA.setVisibility(0);
                    this.bHA.start();
                } else if (i == 4) {
                    this.bEK.setVisibility(8);
                    this.bEJ.startAnimation(this.bHK);
                    this.bHE.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHz.setVisibility(0);
                    this.bHy.setVisibility(0);
                    this.bHA.setVisibility(8);
                    this.bHA.bxk();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHM, 2000L);
                } else {
                    this.bEK.setVisibility(0);
                    this.bHK.cancel();
                    this.bEJ.clearAnimation();
                    this.bEJ.setVisibility(0);
                    this.bHE.setVisibility(0);
                    this.bHx.setVisibility(0);
                    this.bHB.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHA.bxk();
                }
            }
        }
    }

    private void Oy() {
        String string;
        if (this.bHD == null || this.bHD.bcM == null || this.bHD.bcM.getAuthor() == null) {
            this.bkQ.setVisibility(8);
            return;
        }
        this.bkQ.setVisibility(0);
        WM();
        if (!WE() && m.jf(this.bHD.bcM.getId())) {
            m.a(this.mTextTitle, this.bHD.bcM.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGw.getGodReplyContent(), this.bHD.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGw.getPraiseNum(), this.bHD.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bHD.MF().sn();
        if (this.bHD.bcM.sJ() != null && this.bHD.bcM.sJ().channelId > 0) {
            string = this.acr.getResources().getString(d.l.channel_title_prefix);
        } else if (this.bHD.bcM.getThreadType() == 50) {
            string = this.acr.getResources().getString(d.l.ala_record_title_prefix);
        } else {
            string = this.acr.getResources().getString(d.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bHD.MF().sf()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.bkZ.a(this.bHD.MF());
        this.bkZ.setUserAfterClickListener(this.bHP);
        if (this.bkZ.getHeaderImg() != null) {
            this.bkZ.getHeaderImg().setAfterClickListener(this.bHQ);
            if (this.bkZ.getIsSimpleThread()) {
                this.bkZ.getHeaderImg().setVisibility(8);
                this.bGv.setVisibility(8);
            } else if (this.bHD.MF() == null || this.bHD.MF().getAuthor() == null || this.bHD.MF().getAuthor().getPendantData() == null || StringUtils.isNull(this.bHD.MF().getAuthor().getPendantData().pV())) {
                this.bGv.setVisibility(8);
                this.bkZ.getHeaderImg().setVisibility(0);
                this.bkZ.getHeaderImg().setData(this.bHD.MF());
            } else {
                this.bkZ.getHeaderImg().setVisibility(4);
                this.bGv.setVisibility(0);
                this.bGv.setData(this.bHD.MF());
            }
        }
        if (this.bld.a(this.bHD.bcM)) {
            this.bGx.setVisibility(8);
        } else {
            this.bGx.setVisibility(0);
        }
        this.bHx.setText(al.cZ(this.bHD.bcM.rW().video_duration.intValue() * 1000));
        if (this.bGy != null && this.bHD.MF() != null) {
            an anVar = new an();
            anVar.cF(this.bHD.MF().getTid());
            anVar.setFid(this.bHD.MF().getFid());
            anVar.a(this.bHD.XV);
            this.bGy.setData(anVar);
            this.bGy.setFirstRowSingleColumn(true);
        }
        this.bGw.setData(this.bHD.MF().sU());
        this.bGw.onChangeSkinType();
        if (this.bGw.getVisibility() == 0) {
            this.bGx.setVisibility(0);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
        if (m.jf(this.bHD.bcM.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void WK() {
        this.bHL.removeMessages(202);
        this.bHL.removeMessages(203);
    }

    private void WL() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHM);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
    }

    private void WM() {
        WL();
        WK();
        if (this.bEJ != null && this.bEI != null && this.bHv != null) {
            if (com.baidu.tbadk.core.h.oX().pd() && this.bHD != null && this.bHD.bcM != null && this.bHD.bcM.rW() != null) {
                this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEJ.c(this.bHD.bcM.rW().thumbnail_url, 10, false);
                this.bEI.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bHD.bcM.rW().video_url;
                if (StringUtils.isNull(this.bHD.bcM.rW().video_url)) {
                    f(true, 4);
                }
                if (this.bHw != null && this.bHw.bgu() != null) {
                    this.bHw.bgu().d(this.bHD.bcM.rW());
                    return;
                }
                return;
            }
            this.bEI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkQ, d.g.addresslist_item_bg);
            ai.c(this.bEK, d.g.home_ic_video);
            ai.i(this.bHy, d.e.cp_cont_i);
            ai.i(this.bHx, d.e.cp_cont_i);
            ai.k(this.bHz, d.e.common_color_10014);
            if (this.bHy != null) {
                this.bHy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            ai.j(this.bhj, d.e.cp_bg_line_c);
            if (this.bGy != null) {
                this.bGy.onChangeSkinType();
            }
            this.bkZ.onChangeSkinType();
            this.bld.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bHR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHR);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bkZ != null) {
            this.bkZ.setPageUniqueId(bdUniqueId);
        }
        if (this.bEJ != null) {
            this.bEJ.setPageId(bdUniqueId);
        }
        if (this.bGy != null) {
            this.bGy.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bHH;
    }

    public boolean isPlaying() {
        if (this.bHv == null) {
            return false;
        }
        return this.bHv.isPlaying();
    }

    public void startPlay() {
        if (!this.bHH && this.bHD != null && this.bHD.bcM != null && this.bHD.bcM.rW() != null && this.bHv != null && com.baidu.tbadk.util.x.r(1, this.mVideoUrl)) {
            f(true, 2);
            this.bHv.setVideoPath(this.mVideoUrl);
            this.bHv.start();
            this.bHv.setLooping(true);
            if (this.bHJ != null) {
                this.bHJ.start();
            }
            this.bHH = true;
            com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
            wVar.mLocate = this.bHD.sourceType == 0 ? "index" : "hot_juhe";
            wVar.bDM = this.bHD.bcM.getTid();
            wVar.aAC = this.bHD.bcM.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.bHD.bcM.aaC;
            wVar.fCq = this.bHD.bcM.aaE;
            wVar.fCr = this.bHD.bcM.aaD;
            wVar.fCs = "";
            if (this.bHD.bcM.sJ() != null && this.bHD.bcM.sJ().channelId > 0) {
                wVar.WK = this.bHD.bcM.sJ().channelId + "";
            } else {
                wVar.WK = "0";
            }
            com.baidu.tieba.play.k.a(this.bHD.bcM.rW().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        WL();
        WK();
        f(true, 1);
        if (this.bHv != null) {
            this.bHv.stopPlayback();
            if (this.bHJ != null) {
                this.bHJ.stop();
            }
        }
        this.bHH = false;
    }

    public View getVideoContainer() {
        return this.bEI;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bHv == null) {
            return 0;
        }
        return this.bHv.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.w wVar) {
        if (this.bHw != null) {
            this.bHw.setVideoStatsData(wVar);
        }
    }

    public void a(h.a aVar) {
        if (this.bGy != null) {
            this.bGy.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bkZ != null) {
            return this.bkZ.aoS;
        }
        return null;
    }

    public View WD() {
        if (this.bkZ != null) {
            return this.bkZ.aoT;
        }
        return null;
    }
}
