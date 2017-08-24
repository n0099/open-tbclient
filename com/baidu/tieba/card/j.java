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
    private f.d aUO;
    private f.b aUP;
    private TbPageContext<?> acr;
    private final View.OnClickListener aoH;
    public FrameLayout bEJ;
    private TbImageView bEK;
    private ImageView bEL;
    private TbImageView.a bEN;
    private HeadPendantClickableView bGw;
    private ThreadGodReplyLayout bGx;
    private View bGy;
    private com.baidu.tbadk.core.view.h bGz;
    private View bHA;
    private AudioAnimationView bHB;
    private ProgressBar bHC;
    private ImageView bHD;
    private com.baidu.tieba.card.data.n bHE;
    private View bHF;
    private int bHG;
    private int bHH;
    private boolean bHI;
    private boolean bHJ;
    private com.baidu.tieba.play.i bHK;
    private Animation bHL;
    private Handler bHM;
    private Runnable bHN;
    private Runnable bHO;
    private QuickVideoView.b bHP;
    private final View.OnClickListener bHQ;
    private final View.OnClickListener bHR;
    private CustomMessageListener bHS;
    private i.a bHT;
    private Animation.AnimationListener bHU;
    private QuickVideoView bHw;
    private com.baidu.tieba.play.m bHx;
    private TextView bHy;
    private TextView bHz;
    private View bhk;
    private RelativeLayout bkR;
    public ThreadUserInfoLayout bla;
    public ThreadCommentAndPraiseInfoLayout ble;
    protected LinearLayout bli;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGz = null;
        this.mSkinType = 3;
        this.bHG = 0;
        this.bHH = 1;
        this.bHI = false;
        this.bHJ = false;
        this.bHM = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.WF();
                        return;
                    case 203:
                        j.this.WG();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUO = new f.d() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bHM.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aUP = new f.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.bEN = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && j.this.bEK != null) {
                    j.this.bEK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bHN = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bHw != null && !j.this.bHw.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.bHO = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.bHP = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bHQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Wx() != null) {
                    j.this.Wx().a(view, j.this.bHE);
                }
            }
        };
        this.bHR = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Wx() != null) {
                    j.this.Wx().a(view, j.this.bHE);
                }
            }
        };
        this.bHS = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bHJ = false;
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bHE != null && j.this.Wx() != null) {
                    j.this.Wx().a(view, j.this.bHE);
                }
            }
        };
        this.bHT = new i.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.i.a
            public void WK() {
                if (j.this.bHE != null && j.this.bHE.bcN != null && j.this.bHE.bcN.rX() != null) {
                    com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
                    wVar.mLocate = j.this.bHE.sourceType == 0 ? "index" : "hot_juhe";
                    wVar.bDN = j.this.bHE.bcN.getTid();
                    wVar.aAD = j.this.bHE.bcN.getFid() + "";
                    wVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    wVar.mSource = j.this.bHE.bcN.aaC;
                    wVar.fCs = j.this.bHE.bcN.aaE;
                    wVar.fCt = j.this.bHE.bcN.aaD;
                    wVar.fCu = "";
                    if (j.this.bHE.bcN.sK() != null && j.this.bHE.bcN.sK().channelId > 0) {
                        wVar.WL = j.this.bHE.bcN.sK().channelId + "";
                    } else {
                        wVar.WL = "0";
                    }
                    com.baidu.tieba.play.k.a(j.this.bHE.bcN.rX().video_md5, "", "1", wVar);
                }
            }
        };
        this.bHU = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bEK != null) {
                    j.this.bEK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.acr = tbPageContext;
        View view = getView();
        this.bkR = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bGw = (HeadPendantClickableView) this.bkR.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds70));
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.bHC = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bHD = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bla = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bGz = new com.baidu.tbadk.core.view.h(this.acr);
        this.bGz.wL();
        this.bGz.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bla.addView(this.bGz);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.ble.setForumAfterClickListener(this.aoH);
        this.ble.setFrom(1);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bEJ = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bEJ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.ag(this.acr.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bEJ.setLayoutParams(layoutParams2);
        this.bEK = (TbImageView) view.findViewById(d.h.image_video);
        this.bEK.setDefaultErrorResource(0);
        this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEK.setGifIconSupport(false);
        this.bEK.setEvent(this.bEN);
        this.bEL = (ImageView) view.findViewById(d.h.image_video_play);
        this.bHB = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bHB.setCertainColumnCount(4);
        this.bHB.setColumnColor(d.e.cp_cont_i);
        this.bkR.setOnClickListener(this);
        this.bHw = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bHx = new com.baidu.tieba.play.m(this.acr.getPageActivity());
        this.bHw.setBusiness(this.bHx);
        this.bHw.setOnPreparedListener(this.aUO);
        this.bHw.setOnErrorListener(this.aUP);
        this.bHw.setOnSurfaceDestroyedListener(this.bHP);
        this.bHK = new com.baidu.tieba.play.i();
        this.bHK.setPlayer(this.bHw);
        this.bHK.a(this.bHT);
        this.bHy = (TextView) view.findViewById(d.h.text_video_duration);
        this.bHF = view.findViewById(d.h.auto_video_black_mask);
        this.bHz = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bHA = view.findViewById(d.h.auto_video_error_background);
        this.bli = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bHL = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bHL.setAnimationListener(this.bHU);
        this.bhk = view.findViewById(d.h.divider_line);
        this.bGx = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bGx.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkR || view == this.bGx) {
            W(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void W(View view) {
        if (Wx() != null) {
            Wx().a(view, this.bHE);
        }
        if (this.bHE != null && this.bHE.bcN != null) {
            if (!WB()) {
                m.jh(this.bHE.bcN.getId());
                m.a(this.mTextTitle, this.bHE.bcN.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acr.getPageActivity()).createFromThreadCfg(this.bHE.bcN, null, m.rx(), 18003, true, false, false).addLocateParam(this.bHE.WZ());
            addLocateParam.setVideo_source(this.bHE.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bHE.bcN.getFid()));
            addLocateParam.setForumName(this.bHE.bcN.rL());
            if (this.bHE.bKa == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bHE.bKa);
            }
            if (view == this.bGx) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WB() {
        return this.bHE.bKs && !this.bHE.bKG;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bHE = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WF() {
        this.bHM.removeMessages(202);
        if (this.bHw.getCurrentPosition() > 0) {
            f(true, 3);
            this.bHM.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bHM.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WG() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bHM.removeMessages(203);
        int currentPosition = this.bHw.getCurrentPosition();
        if (currentPosition != this.bHG) {
            this.bHG = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bHM.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bEL != null && this.bEK != null && this.bHF != null && this.bHB != null && this.bHC != null && this.bHD != null && this.bHA != null && this.bHz != null) {
            if (z || this.bHH != i) {
                this.bHH = i;
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHO);
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
                if (i == 2) {
                    this.bEL.setVisibility(8);
                    this.bHL.cancel();
                    this.bEK.clearAnimation();
                    this.bEK.setVisibility(0);
                    this.bHF.setVisibility(0);
                    this.bHy.setVisibility(0);
                    this.bHC.setVisibility(0);
                    this.bHD.setVisibility(0);
                    this.bHA.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHB.bxd();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHO, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bEL.setVisibility(8);
                    this.bEK.startAnimation(this.bHL);
                    this.bHF.setVisibility(8);
                    this.bHy.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHD.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHB.setVisibility(0);
                    this.bHB.start();
                } else if (i == 4) {
                    this.bEL.setVisibility(8);
                    this.bEK.startAnimation(this.bHL);
                    this.bHF.setVisibility(8);
                    this.bHC.setVisibility(8);
                    this.bHD.setVisibility(8);
                    this.bHA.setVisibility(0);
                    this.bHz.setVisibility(0);
                    this.bHB.setVisibility(8);
                    this.bHB.bxd();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHN, 2000L);
                } else {
                    this.bEL.setVisibility(0);
                    this.bHL.cancel();
                    this.bEK.clearAnimation();
                    this.bEK.setVisibility(0);
                    this.bHF.setVisibility(0);
                    this.bHy.setVisibility(0);
                    this.bHC.setVisibility(8);
                    this.bHD.setVisibility(8);
                    this.bHA.setVisibility(8);
                    this.bHz.setVisibility(8);
                    this.bHB.setVisibility(8);
                    this.bHB.bxd();
                }
            }
        }
    }

    private void refreshView() {
        String string;
        if (this.bHE == null || this.bHE.bcN == null || this.bHE.bcN.getAuthor() == null) {
            this.bkR.setVisibility(8);
            return;
        }
        this.bkR.setVisibility(0);
        WJ();
        if (!WB() && m.ji(this.bHE.bcN.getId())) {
            m.a(this.mTextTitle, this.bHE.bcN.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGx.getGodReplyContent(), this.bHE.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getPraiseNum(), this.bHE.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bHE.MF().so();
        if (this.bHE.bcN.sK() != null && this.bHE.bcN.sK().channelId > 0) {
            string = this.acr.getResources().getString(d.l.channel_title_prefix);
        } else if (this.bHE.bcN.getThreadType() == 50) {
            string = this.acr.getResources().getString(d.l.ala_record_title_prefix);
        } else {
            string = this.acr.getResources().getString(d.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bHE.MF().sg()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.bla.a(this.bHE.MF());
        this.bla.setUserAfterClickListener(this.bHQ);
        if (this.bla.getHeaderImg() != null) {
            this.bla.getHeaderImg().setAfterClickListener(this.bHR);
            if (this.bla.getIsSimpleThread()) {
                this.bla.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (this.bHE.MF() == null || this.bHE.MF().getAuthor() == null || this.bHE.MF().getAuthor().getPendantData() == null || StringUtils.isNull(this.bHE.MF().getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.bla.getHeaderImg().setVisibility(0);
                this.bla.getHeaderImg().setData(this.bHE.MF());
            } else {
                this.bla.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(this.bHE.MF());
            }
        }
        if (this.ble.a(this.bHE.bcN)) {
            this.bGy.setVisibility(8);
        } else {
            this.bGy.setVisibility(0);
        }
        this.bHy.setText(al.cZ(this.bHE.bcN.rX().video_duration.intValue() * 1000));
        if (this.bGz != null && this.bHE.MF() != null) {
            an anVar = new an();
            anVar.cI(this.bHE.MF().getTid());
            anVar.setFid(this.bHE.MF().getFid());
            anVar.a(this.bHE.XW);
            this.bGz.setData(anVar);
            this.bGz.setFirstRowSingleColumn(true);
        }
        this.bGx.setData(this.bHE.MF().sV());
        this.bGx.onChangeSkinType();
        if (this.bGx.getVisibility() == 0) {
            this.bGy.setVisibility(0);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
        if (m.ji(this.bHE.bcN.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void WH() {
        this.bHM.removeMessages(202);
        this.bHM.removeMessages(203);
    }

    private void WI() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHN);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHO);
    }

    private void WJ() {
        WI();
        WH();
        if (this.bEK != null && this.bEJ != null && this.bHw != null) {
            if (com.baidu.tbadk.core.h.oY().pe() && this.bHE != null && this.bHE.bcN != null && this.bHE.bcN.rX() != null) {
                this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEK.c(this.bHE.bcN.rX().thumbnail_url, 10, false);
                this.bEJ.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bHE.bcN.rX().video_url;
                if (StringUtils.isNull(this.bHE.bcN.rX().video_url)) {
                    f(true, 4);
                }
                if (this.bHx != null && this.bHx.bgp() != null) {
                    this.bHx.bgp().d(this.bHE.bcN.rX());
                    return;
                }
                return;
            }
            this.bEJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkR, d.g.addresslist_item_bg);
            ai.c(this.bEL, d.g.home_ic_video);
            ai.i(this.bHz, d.e.cp_cont_i);
            ai.i(this.bHy, d.e.cp_cont_i);
            ai.k(this.bHA, d.e.common_color_10014);
            if (this.bHz != null) {
                this.bHz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            ai.j(this.bhk, d.e.cp_bg_line_c);
            if (this.bGz != null) {
                this.bGz.onChangeSkinType();
            }
            this.bla.onChangeSkinType();
            this.ble.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bHS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHS);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bla != null) {
            this.bla.setPageUniqueId(bdUniqueId);
        }
        if (this.bEK != null) {
            this.bEK.setPageId(bdUniqueId);
        }
        if (this.bGz != null) {
            this.bGz.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bHI;
    }

    public boolean isPlaying() {
        if (this.bHw == null) {
            return false;
        }
        return this.bHw.isPlaying();
    }

    public void startPlay() {
        if (!this.bHI && this.bHE != null && this.bHE.bcN != null && this.bHE.bcN.rX() != null && this.bHw != null && com.baidu.tbadk.util.x.r(1, this.mVideoUrl)) {
            f(true, 2);
            this.bHw.setVideoPath(this.mVideoUrl);
            this.bHw.start();
            this.bHw.setLooping(true);
            if (this.bHK != null) {
                this.bHK.start();
            }
            this.bHI = true;
            com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
            wVar.mLocate = this.bHE.sourceType == 0 ? "index" : "hot_juhe";
            wVar.bDN = this.bHE.bcN.getTid();
            wVar.aAD = this.bHE.bcN.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.bHE.bcN.aaC;
            wVar.fCs = this.bHE.bcN.aaE;
            wVar.fCt = this.bHE.bcN.aaD;
            wVar.fCu = "";
            if (this.bHE.bcN.sK() != null && this.bHE.bcN.sK().channelId > 0) {
                wVar.WL = this.bHE.bcN.sK().channelId + "";
            } else {
                wVar.WL = "0";
            }
            com.baidu.tieba.play.k.a(this.bHE.bcN.rX().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        WI();
        WH();
        f(true, 1);
        if (this.bHw != null) {
            this.bHw.stopPlayback();
            if (this.bHK != null) {
                this.bHK.stop();
            }
        }
        this.bHI = false;
    }

    public View getVideoContainer() {
        return this.bEJ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bHw == null) {
            return 0;
        }
        return this.bHw.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.w wVar) {
        if (this.bHx != null) {
            this.bHx.setVideoStatsData(wVar);
        }
    }

    public void a(h.a aVar) {
        if (this.bGz != null) {
            this.bGz.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bla != null) {
            return this.bla.aoS;
        }
        return null;
    }

    public View WA() {
        if (this.bla != null) {
            return this.bla.aoT;
        }
        return null;
    }
}
