package com.baidu.tieba.card;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class k extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private int Ek;
    private String La;
    private Animation aGA;
    private View bZT;
    private TbPageContext<?> cQU;
    public FrameLayout dHG;
    private TextView dHH;
    private TbImageView dHI;
    private ImageView dHJ;
    private TextView dHK;
    private View dHL;
    private com.baidu.tieba.play.w dHM;
    private View dHN;
    private TextView dHO;
    private int dHP;
    private TbImageView.a dHQ;
    private g.b dHR;
    private Runnable dHT;
    private Runnable dHU;
    private QuickVideoView.b dHV;
    private g.a dQN;
    private g.f dQO;
    private g.e dQQ;
    private final View.OnClickListener ddt;
    public ThreadSourceShareAndPraiseLayout eIU;
    private RelativeLayout eIf;
    public ThreadUserInfoLayout eIg;
    public ThreadCommentAndPraiseInfoLayout eIh;
    private NEGFeedBackView eIt;
    protected LinearLayout ect;
    private com.baidu.tieba.play.j egJ;
    private com.baidu.tieba.play.n egK;
    private com.baidu.afd.videopaster.d fDE;
    public ThreadGodReplyLayout fDF;
    private HeadPendantClickableView fDG;
    private com.baidu.tieba.play.a.a fDH;
    private LinearLayout fDI;
    private com.baidu.tieba.card.data.l fDJ;
    private int fDK;
    private boolean fDL;
    private boolean fDM;
    private boolean fDN;
    private TextView fDO;
    private boolean fDP;
    private TextView fDQ;
    private Handler fDR;
    private VideoLoadingProgressView.a fDS;
    private CustomMessageListener fDT;
    private final View.OnClickListener fDU;
    private final View.OnClickListener fDV;
    private CustomMessageListener fDW;
    private j.a fDX;
    private Animation.AnimationListener fDY;
    private View fDz;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bsf() {
        if (this.fDH != null && this.fDL) {
            try {
                this.fDH.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int GF = com.baidu.tieba.play.x.cwN().GF(this.mVideoUrl);
            if (GF <= 100 || this.fDH.getDuration() <= GF) {
                GF = 100;
            }
            this.Ek = GF;
            this.fDR.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsg() {
        if (this.fDJ != null && this.fDJ.cMR != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.fDJ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.OC = this.fDJ.cMR.getTid();
            yVar.fGQ = this.fDJ.cMR.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.fDJ.cMR.mRecomSource;
            yVar.mAbTag = this.fDJ.cMR.mRecomAbTag;
            yVar.jsi = this.fDJ.cMR.mRecomAbTag;
            yVar.jsj = this.fDJ.cMR.mRecomWeight;
            yVar.jsk = "";
            yVar.cKC = this.fDJ.getExtra();
            if (this.fDJ.cMR.azV() != null) {
                yVar.jsl = this.fDJ.cMR.azV().video_md5;
            }
            com.baidu.tieba.play.l.a(this.fDJ.cMR.azV().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eIt = null;
        this.mSkinType = 3;
        this.fDK = 0;
        this.dHP = 1;
        this.fDL = false;
        this.fDM = true;
        this.fDN = false;
        this.Ek = 100;
        this.fDP = false;
        this.isNewPlayer = false;
        this.fDR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.bsk();
                        return;
                    case 203:
                        k.this.bsl();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.fDH != null) {
                    k.this.fDH.setVolume(0.0f, 0.0f);
                }
                k.this.bsf();
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.n(false, 3);
                }
                return false;
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.fDE.a(false, false, "NEWINDEX")) {
                    k.this.fDH.start();
                }
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.n(true, 4);
                k.this.fDL = false;
                return true;
            }
        };
        this.fDS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.bsf();
            }
        };
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.dHI != null) {
                    k.this.dHI.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dHT = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.fDH != null && !k.this.fDH.isPlaying()) {
                    k.this.n(true, 1);
                }
            }
        };
        this.dHU = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.n(true, 4);
            }
        };
        this.fDT = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.fDJ != null && k.this.fDJ.cMR != null && videoId.equals(k.this.fDJ.cMR.getId())) {
                        k.this.fDE.a(k.this.a(k.this.fDJ, bVar));
                    }
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.fDU = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fDJ == null) {
                    if (k.this.brY() != null) {
                        k.this.brY().a(view, k.this.fDJ);
                        return;
                    }
                    return;
                }
                if (view == k.this.eIg.getUserName()) {
                    k.this.fDJ.objType = 3;
                } else if (view == k.this.eIg.getHeaderImg()) {
                    k.this.fDJ.objType = 4;
                } else {
                    k.this.fDJ.objType = 1;
                }
                if (k.this.brY() != null) {
                    k.this.brY().a(view, k.this.fDJ);
                }
            }
        };
        this.fDV = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fDJ != null) {
                    k.this.fDJ.objType = 4;
                }
                if (k.this.brY() != null) {
                    k.this.brY().a(view, k.this.fDJ);
                }
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.fDN = false;
                }
            }
        };
        this.ddt = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fDJ != null) {
                    if (k.this.brY() != null) {
                        k.this.brY().a(view, k.this.fDJ);
                    }
                    if (k.this.fDJ.cMR != null && view != k.this.eIU.ddE) {
                        l.zs(k.this.fDJ.cMR.getId());
                        if (!k.this.bsj()) {
                            l.a(k.this.mTextTitle, k.this.fDJ.cMR.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.fDF.getGodReplyContent(), k.this.fDJ.axx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.fDX = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void lg() {
                if (k.this.fDJ != null && k.this.fDJ.cMR != null && k.this.fDJ.cMR.azV() != null) {
                    k.this.bsg();
                }
            }
        };
        this.fDY = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.dHI != null) {
                    k.this.dHI.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.cQU = tbPageContext;
        View view = getView();
        this.eIf = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fDG = (HeadPendantClickableView) this.eIf.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fDG.getHeadView() != null) {
            this.fDG.getHeadView().setIsRound(true);
            this.fDG.getHeadView().setDrawBorder(false);
            this.fDG.getHeadView().setDefaultResource(17170445);
            this.fDG.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDG.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.ds70));
            this.fDG.getHeadView().setPlaceHolder(1);
        }
        this.fDG.setHasPendantStyle();
        if (this.fDG.getPendantView() != null) {
            this.fDG.getPendantView().setIsRound(true);
            this.fDG.getPendantView().setDrawBorder(false);
        }
        this.dHM = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dHM.setLoadingAnimationListener(this.fDS);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eIg = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eIt = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.eIt.a(this.eIf, dimens, 0);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eIh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIh.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eIh.setLayoutParams(layoutParams);
        }
        this.eIh.setOnClickListener(this);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setShareVisible(true);
        this.eIh.setShareReportFrom(3);
        this.eIh.setForumAfterClickListener(this.ddt);
        this.eIh.setFrom(1);
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eIU.dep.setOnClickListener(this);
        this.eIU.setFrom(1);
        this.eIU.setShareReportFrom(3);
        this.eIU.setForumAfterClickListener(this.ddt);
        this.fDz = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dHG = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dHG.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cQU.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dHG.setLayoutParams(layoutParams2);
        this.dHI = (TbImageView) view.findViewById(R.id.image_video);
        this.dHI.setDefaultErrorResource(0);
        this.dHI.setPlaceHolder(3);
        this.dHI.setGifIconSupport(false);
        this.dHI.setEvent(this.dHQ);
        this.dHI.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dHI;
        TbImageView tbImageView2 = this.dHI;
        tbImageView.setConrers(15);
        this.dHI.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dHI.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dHI.setBorderSurroundContent(true);
        this.dHI.setDrawBorder(true);
        this.dHJ = (ImageView) view.findViewById(R.id.image_video_play);
        this.eIf.setOnClickListener(this);
        this.egK = new com.baidu.tieba.play.n(this.cQU.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.rp("cyber_player_test");
        this.fDH = com.baidu.tieba.play.a.b.E(this.cQU.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.dHG.addView(this.fDH.getView(), 0);
        this.fDH.getView().setLayoutParams(layoutParams3);
        this.fDH.setContinuePlayEnable(true);
        this.fDH.setBusiness(this.egK);
        this.fDH.setOnPreparedListener(this.dQO);
        this.fDH.setOnOutInfoListener(this.dQQ);
        this.fDH.setOnCompletionListener(this.dQN);
        this.fDH.setOnErrorListener(this.dHR);
        this.fDH.setOnSurfaceDestroyedListener(this.dHV);
        this.egJ = new com.baidu.tieba.play.j();
        this.egJ.setPlayer(this.fDH);
        this.egJ.a(this.fDX);
        this.dHH = (TextView) view.findViewById(R.id.text_video_duration);
        this.fDI = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dHO = (TextView) view.findViewById(R.id.text_video_play_count);
        this.dHN = view.findViewById(R.id.auto_video_black_mask);
        this.dHK = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dHL = view.findViewById(R.id.auto_video_error_background);
        this.ect = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.aGA = AnimationUtils.loadAnimation(this.cQU.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.aGA.setAnimationListener(this.fDY);
        this.fDF = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fDF.setOnClickListener(this);
        this.bZT = view.findViewById(R.id.divider_line);
        this.fDO = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.fDH.getView().setOnClickListener(this);
        this.fDQ = (TextView) view.findViewById(R.id.nani_video_icon);
        this.fDH.setPageTypeForPerfStat("homepage");
        this.fDE = new com.baidu.afd.videopaster.d(getContext(), this.dHG);
        this.fDE.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void kV() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kU() {
                if (!k.this.fDP) {
                    k.this.fDH.start();
                } else {
                    k.this.startPlay();
                }
                k.this.fDP = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kT() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean kW() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.cPB > 0) {
            if (brY() != null) {
                brY().a(view, this.fDJ);
            }
            this.cQU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.cQU.getPageActivity(), this.fDJ.cMR.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.azq(), this.fDJ.axA())));
            return;
        }
        if (view == this.eIf || view == this.fDF) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.fDH.getView()) {
            if (this.fDJ != null) {
                this.fDJ.objType = 5;
            }
            if (this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.azV() != null) {
                z = this.fDJ.cMR.azV().is_vertical.intValue() == 1;
            }
            if (z) {
                bA(this.fDH.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bB(this.fDH.getView());
                } else {
                    bC(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bB(this.fDH.getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bA(View view) {
        if (brY() != null) {
            brY().a(view, this.fDJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cQU.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bsh();
        }
    }

    private void bB(View view) {
        if (brY() != null) {
            brY().a(view, this.fDJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cQU.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bsi();
        }
    }

    private void bsh() {
        if (this.fDJ != null && this.fDJ.cMR != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fDJ.cMR);
            videoItemData.mRecomExtra = this.fDJ.getExtra();
            videoItemData.mRecomAbTag = this.fDJ.bsJ();
            videoItemData.mRecomSource = this.fDJ.getSource();
            videoItemData.mRecomWeight = this.fDJ.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.fDJ.axA(), "index");
            if (this.fDJ.cMR.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fDJ.cMR.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bsi() {
        if (this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fDJ.cMR);
            videoSerializeVideoThreadInfo.source = this.fDJ.getSource();
            videoSerializeVideoThreadInfo.extra = this.fDJ.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.fDJ.bsJ();
            videoSerializeVideoThreadInfo.weight = this.fDJ.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.ect.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.ect.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cQU.getPageActivity(), str, this.fDJ.cMR.getTid(), l.azq(), this.fDJ.axA(), videoSerializeVideoThreadInfo);
            if (this.fDJ.axx() != null && this.fDJ.axx().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fDJ.axx().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bC(View view) {
        if (this.fDJ != null) {
            this.fDJ.objType = 1;
        }
        if (brY() != null) {
            brY().a(view, this.fDJ);
        }
        if (this.fDJ != null && this.fDJ.cMR != null) {
            if (!bsj()) {
                l.zs(this.fDJ.cMR.getId());
                l.a(this.mTextTitle, this.fDJ.cMR.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cQU.getPageActivity()).createFromThreadCfg(this.fDJ.cMR, null, l.azq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fDJ.axA());
            addLocateParam.setVideo_source(this.fDJ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.fDJ.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.fDJ.cMR.getFid()));
            addLocateParam.setForumName(this.fDJ.cMR.azJ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fDF) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cQU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsj() {
        return this.fDJ.fHF && !this.fDJ.fHM;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.fDJ = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        this.fDR.removeMessages(202);
        if (this.fDH.getCurrentPosition() > this.Ek) {
            n(false, 3);
            this.fDR.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fDR.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsl() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fDR.removeMessages(203);
        int currentPosition = this.fDH.getCurrentPosition();
        if (currentPosition != this.fDK) {
            this.fDK = currentPosition;
            n(false, 3);
        } else {
            n(false, 2);
        }
        this.fDR.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, int i) {
        if (this.dHJ != null && this.dHI != null && this.dHN != null && this.dHM != null && this.dHL != null && this.dHK != null) {
            if (z || this.dHP != i) {
                this.dHP = i;
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHU);
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHT);
                if (i == 2) {
                    this.dHJ.setVisibility(8);
                    this.aGA.cancel();
                    this.dHI.clearAnimation();
                    this.dHI.setVisibility(0);
                    this.dHN.setVisibility(0);
                    this.fDI.setVisibility(0);
                    this.fDO.setVisibility(8);
                    this.dHM.startLoading();
                    this.dHL.setVisibility(8);
                    this.dHK.setVisibility(8);
                    com.baidu.adp.lib.f.e.gy().postDelayed(this.dHU, 60000L);
                } else if (i == 3) {
                    this.dHJ.setVisibility(8);
                    this.dHI.startAnimation(this.aGA);
                    this.dHN.setVisibility(8);
                    this.fDI.setVisibility(8);
                    if (this.fDJ != null && this.fDJ.axx() != null && this.fDJ.axx().cPB > 0) {
                        this.fDO.setVisibility(0);
                    }
                    this.dHM.cwJ();
                    this.dHL.setVisibility(8);
                    this.dHK.setVisibility(8);
                    if (this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.azV() != null) {
                        this.fDJ.cMR.azV().video_length.intValue();
                        this.fDJ.cMR.azV().video_duration.intValue();
                        this.fDJ.cMR.getTid();
                    }
                } else if (i == 4) {
                    this.dHJ.setVisibility(8);
                    this.dHI.startAnimation(this.aGA);
                    this.dHN.setVisibility(8);
                    this.dHM.cwK();
                    this.dHL.setVisibility(0);
                    this.dHK.setVisibility(0);
                    com.baidu.adp.lib.f.e.gy().postDelayed(this.dHT, 2000L);
                } else {
                    this.dHJ.setVisibility(0);
                    this.aGA.cancel();
                    this.dHI.clearAnimation();
                    this.dHI.setVisibility(0);
                    this.dHN.setVisibility(0);
                    this.fDI.setVisibility(0);
                    this.dHM.cwK();
                    this.dHL.setVisibility(8);
                    this.dHK.setVisibility(8);
                }
                if (this.fDJ != null && this.fDJ.axx() != null && this.fDJ.axx().cPB > 0) {
                    this.fDI.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.fDJ == null || this.fDJ.cMR == null || this.fDJ.cMR.azE() == null) {
            this.eIf.setVisibility(8);
            return;
        }
        this.eIf.setVisibility(0);
        bsn();
        if (!bsj() && l.zt(this.fDJ.cMR.getId())) {
            l.a(this.mTextTitle, this.fDJ.cMR.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.fDF.getGodReplyContent(), this.fDJ.axx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fDJ.axx().aAA();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.fDJ.axx().aAl());
        if (this.fDJ.axx().aAr() && !StringUtils.isNull(this.fDJ.axx().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fDJ.axx().getTid();
            spannableStringBuilder.append((CharSequence) this.fDJ.axx().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cp("obj_source", "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.eIg.setData(this.fDJ.axx());
        this.eIg.setUserAfterClickListener(this.fDU);
        if (this.eIg.getHeaderImg() != null) {
            this.eIg.getHeaderImg().setAfterClickListener(this.fDV);
            if (this.eIg.getIsSimpleThread()) {
                this.eIg.getHeaderImg().setVisibility(8);
                this.fDG.setVisibility(8);
            } else if (this.fDJ.axx() == null || this.fDJ.axx().azE() == null || this.fDJ.axx().azE().getPendantData() == null || StringUtils.isNull(this.fDJ.axx().azE().getPendantData().axX())) {
                this.fDG.setVisibility(8);
                this.eIg.getHeaderImg().setVisibility(0);
                if (this.fDJ.axx().cPB > 0 && this.fDJ.axx().cPC == 0) {
                    this.fDJ.axx().azE().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.eIg.getHeaderImg().setData(this.fDJ.axx(), false);
                } else {
                    this.eIg.getHeaderImg().setData(this.fDJ.axx());
                    this.eIg.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.eIg.getHeaderImg().setVisibility(4);
                this.fDG.setVisibility(0);
                this.fDG.setData(this.fDJ.axx());
            }
        }
        this.dHH.setText(aq.stringForVideoTime(this.fDJ.cMR.azV().video_duration.intValue() * 1000));
        this.dHO.setText(String.format(this.cQU.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fDJ.cMR.azV().play_count.intValue())));
        if (this.eIt != null && this.fDJ.axx() != null) {
            al alVar = new al();
            alVar.setTid(this.fDJ.axx().getTid());
            alVar.setFid(this.fDJ.axx().getFid());
            alVar.setFeedBackReasonMap(this.fDJ.feedBackReasonMap);
            this.eIt.setData(alVar);
            this.eIt.setFirstRowSingleColumn(true);
            this.eIt.setVisibility(this.fDM ? 0 : 8);
        }
        this.fDF.setData(this.fDJ.axx().aBe());
        pp(nL(1));
        onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
        if (l.zt(this.fDJ.cMR.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.fDJ == null || this.fDJ.cMR == null || this.fDJ.cMR.azV() == null) {
            z = false;
        } else {
            z = this.fDJ.cMR.azV().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fDQ.setVisibility(0);
            if (bso()) {
                this.fDQ.setText(String.format("%s | %s", this.cQU.getResources().getString(R.string.nani_video), this.cQU.getResources().getString(R.string.video_preview)));
            } else {
                this.fDQ.setText(this.cQU.getString(R.string.nani_video));
            }
        } else if (bso()) {
            this.fDQ.setVisibility(0);
            this.fDQ.setText(this.cQU.getString(R.string.video_preview));
        } else {
            this.fDQ.setVisibility(8);
        }
    }

    private void bsm() {
        this.fDR.removeMessages(202);
        this.fDR.removeMessages(203);
    }

    private void aQQ() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHT);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHU);
    }

    private void bsn() {
        aQQ();
        bsm();
        if (this.dHI != null && this.dHG != null && this.fDH != null) {
            if (com.baidu.tbadk.core.i.axf().isShowImages() && this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.azV() != null) {
                this.dHI.setPlaceHolder(3);
                this.dHI.startLoad(this.fDJ.cMR.azV().thumbnail_url, 10, false);
                this.dHG.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.fDJ.cMR.azV().video_url;
                if (bso()) {
                    this.mVideoUrl = this.fDJ.cMR.azW().video_url;
                }
                if (StringUtils.isNull(this.fDJ.cMR.azV().video_url)) {
                    n(true, 4);
                }
                if (this.egK != null && this.egK.cwu() != null) {
                    this.egK.cwu().ah(this.fDJ.cMR);
                }
            } else {
                this.dHG.setVisibility(8);
            }
            this.fDE.reset();
            this.egJ.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fDE.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fDJ);
                    }
                }
            });
            this.egK.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fDE.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fDJ);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cMR != null) {
            bj bjVar = lVar.cMR;
            if (bjVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bjVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.cMR == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.cMR;
        int la = bVar.la();
        int lb = bVar.lb();
        int kZ = bVar.kZ();
        if (kZ != -1) {
            i = la != -1 ? (kZ - la) - 1 : -1;
            if (lb != -1) {
                i4 = (lb - kZ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo azV = bjVar.azV();
        if (azV != null) {
            i3 = azV.video_width.intValue();
            i2 = azV.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.azJ());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", kZ + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eIf, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHJ, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dHK, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fDO, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dHL, R.color.common_color_10014);
            am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c);
            if (this.fDQ != null) {
                am.setViewTextColor(this.fDQ, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fDQ, R.drawable.video_play_count_bg);
            }
            if (this.dHK != null) {
                this.dHK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.fDF.onChangeSkinType();
            if (this.eIt != null) {
                this.eIt.onChangeSkinType();
            }
            this.eIg.onChangeSkinType();
            this.eIh.onChangeSkinType();
            this.eIU.onChangeSkinType();
            this.dHI.setPlaceHolder(3);
            this.fDG.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fDW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fDW);
            this.fDT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fDT);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eIg != null) {
            this.eIg.setPageUniqueId(bdUniqueId);
        }
        if (this.dHI != null) {
            this.dHI.setPageId(bdUniqueId);
        }
        if (this.eIt != null) {
            this.eIt.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.fDL;
    }

    public boolean isPlaying() {
        if (this.fDH == null) {
            return false;
        }
        return this.fDH.isPlaying();
    }

    public void startPlay() {
        if (!this.fDL && this.fDJ != null && this.fDJ.cMR != null && this.fDJ.cMR.azV() != null && this.fDH != null) {
            if (this.fDE.kE()) {
                this.fDE.resume();
                this.fDP = true;
                return;
            }
            this.fDP = false;
            this.fDH.stopPlayback();
            if (af.U(1, this.mVideoUrl)) {
                n(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cp("obj_locate", "index").cp("tid", this.fDJ.tid));
                    this.mVideoUrl = this.fDJ.cMR.azV().video_url;
                }
                this.fDL = true;
                this.fDH.setVideoPath(this.mVideoUrl, this.fDJ.tid);
                if (this.egJ != null) {
                    this.egJ.start();
                }
                bsg();
            }
        }
    }

    public void stopPlay() {
        this.fDP = false;
        aQQ();
        bsm();
        n(true, 1);
        if (this.fDH != null) {
            this.fDH.stopPlayback();
            if (this.egJ != null) {
                this.egJ.stop();
            }
        }
        this.fDL = false;
        this.fDE.stop();
    }

    public View getVideoContainer() {
        return this.dHG;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.fDH == null) {
            return 0;
        }
        return this.fDH.getCurrentPosition();
    }

    public void jV(boolean z) {
        this.fDM = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pp(int i) {
        if (this.fDJ != null && this.fDJ.cMR != null) {
            if (i == 1) {
                if (this.fDJ.cMR.cPB > 0) {
                    this.eIU.dep.setShowPraiseNum(false);
                    this.eIU.dep.setShareVisible(false);
                    this.fDO.setText(aq.numFormatOverWan(this.fDJ.cMR.cPB));
                    this.fDO.setVisibility(0);
                } else {
                    this.eIU.dep.setShowPraiseNum(true);
                    this.eIU.dep.setShareVisible(true);
                    this.fDO.setVisibility(8);
                }
                this.eIU.setData(this.fDJ.cMR);
                this.eIh.setVisibility(8);
                this.eIg.fF(false);
                return;
            }
            this.eIU.setVisibility(8);
            this.eIg.fF(true);
            if (this.fDJ.cMR.cPB > 0) {
                this.eIh.setShowPraiseNum(false);
                this.eIh.setShareVisible(false);
                this.fDO.setText(aq.numFormatOverWan(this.fDJ.cMR.cPB));
                this.fDO.setVisibility(0);
            } else {
                this.eIh.setShowPraiseNum(true);
                this.eIh.setShareVisible(true);
                this.fDO.setVisibility(8);
            }
            if (this.eIh.setData(this.fDJ.cMR)) {
                this.fDz.setVisibility(8);
            } else {
                this.fDz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dHI.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dHI.setOnDrawListener(null);
        }
    }

    private boolean bso() {
        return (this.fDJ == null || this.fDJ.cMR == null || this.fDJ.cMR.azW() == null || TextUtils.isEmpty(this.fDJ.cMR.azW().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.fDE.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.fDE.stop();
    }

    public void onResume() {
        if (this.fDE.kE()) {
            this.fDE.resume();
        }
    }
}
