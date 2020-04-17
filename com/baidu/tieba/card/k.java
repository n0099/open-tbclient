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
/* loaded from: classes8.dex */
public class k extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private int XZ;
    private String aey;
    private Animation bhu;
    private View cDw;
    private final View.OnClickListener dIf;
    private TbPageContext<?> duG;
    protected LinearLayout eGZ;
    private com.baidu.tieba.play.j ePb;
    private com.baidu.tieba.play.n ePc;
    private g.b emA;
    private Runnable emC;
    private Runnable emD;
    private QuickVideoView.b emE;
    public FrameLayout emp;
    private TextView emq;
    private TbImageView emr;
    private ImageView ems;
    private TextView emt;
    private View emu;
    private com.baidu.tieba.play.w emv;
    private View emw;
    private TextView emx;
    private int emy;
    private TbImageView.a emz;
    private g.a evE;
    private g.f evF;
    private g.e evH;
    private NEGFeedBackView fsC;
    private RelativeLayout fsp;
    public ThreadUserInfoLayout fsq;
    public ThreadCommentAndPraiseInfoLayout fsr;
    public ThreadSourceShareAndPraiseLayout ftd;
    private View goJ;
    private com.baidu.afd.videopaster.d goO;
    public ThreadGodReplyLayout goP;
    private HeadPendantClickableView goQ;
    private com.baidu.tieba.play.a.a goR;
    private LinearLayout goS;
    private com.baidu.tieba.card.data.l goT;
    private int goU;
    private boolean goV;
    private boolean goW;
    private boolean goX;
    private TextView goY;
    private boolean goZ;
    private TextView gpa;
    private Handler gpb;
    private VideoLoadingProgressView.a gpc;
    private CustomMessageListener gpd;
    private final View.OnClickListener gpe;
    private final View.OnClickListener gpf;
    private CustomMessageListener gpg;
    private j.a gph;
    private Animation.AnimationListener gpi;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.goR != null && this.goV) {
            try {
                this.goR.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int IL = com.baidu.tieba.play.x.cKr().IL(this.mVideoUrl);
            if (IL <= 100 || this.goR.getDuration() <= IL) {
                IL = 100;
            }
            this.XZ = IL;
            this.gpb.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.goT != null && this.goT.dqA != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.goT.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.ahL = this.goT.dqA.getTid();
            yVar.eQf = this.goT.dqA.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.goT.dqA.mRecomSource;
            yVar.kir = this.goT.dqA.mRecomAbTag;
            yVar.kin = this.goT.dqA.mRecomAbTag;
            yVar.kio = this.goT.dqA.mRecomWeight;
            yVar.kip = "";
            yVar.dol = this.goT.getExtra();
            if (this.goT.dqA.aKV() != null) {
                yVar.kis = this.goT.dqA.aKV().video_md5;
            }
            com.baidu.tieba.play.l.a(this.goT.dqA.aKV().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fsC = null;
        this.mSkinType = 3;
        this.goU = 0;
        this.emy = 1;
        this.goV = false;
        this.goW = true;
        this.goX = false;
        this.XZ = 100;
        this.goZ = false;
        this.isNewPlayer = false;
        this.gpb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.bEK();
                        return;
                    case 203:
                        k.this.bEL();
                        return;
                    default:
                        return;
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.goR != null) {
                    k.this.goR.setVolume(0.0f, 0.0f);
                }
                k.this.bEF();
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.q(false, 3);
                }
                return false;
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.goO.a(false, false, "NEWINDEX")) {
                    k.this.goR.start();
                }
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.q(true, 4);
                k.this.goV = false;
                return true;
            }
        };
        this.gpc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.bEF();
            }
        };
        this.emz = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.emr != null) {
                    k.this.emr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.emC = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.goR != null && !k.this.goR.isPlaying()) {
                    k.this.q(true, 1);
                }
            }
        };
        this.emD = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.q(true, 4);
            }
        };
        this.gpd = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.goT != null && k.this.goT.dqA != null && videoId.equals(k.this.goT.dqA.getId())) {
                        k.this.goO.a(k.this.a(k.this.goT, bVar));
                    }
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.gpe = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.goT == null) {
                    if (k.this.bEy() != null) {
                        k.this.bEy().a(view, k.this.goT);
                        return;
                    }
                    return;
                }
                if (view == k.this.fsq.getUserName()) {
                    k.this.goT.objType = 3;
                } else if (view == k.this.fsq.getHeaderImg()) {
                    k.this.goT.objType = 4;
                } else {
                    k.this.goT.objType = 1;
                }
                if (k.this.bEy() != null) {
                    k.this.bEy().a(view, k.this.goT);
                }
            }
        };
        this.gpf = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.goT != null) {
                    k.this.goT.objType = 4;
                }
                if (k.this.bEy() != null) {
                    k.this.bEy().a(view, k.this.goT);
                }
            }
        };
        this.gpg = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.goX = false;
                }
            }
        };
        this.dIf = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.goT != null) {
                    if (k.this.bEy() != null) {
                        k.this.bEy().a(view, k.this.goT);
                    }
                    if (k.this.goT.dqA != null && view != k.this.ftd.dIp) {
                        l.BB(k.this.goT.dqA.getId());
                        if (!k.this.bEJ()) {
                            l.a(k.this.mTextTitle, k.this.goT.dqA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.goP.getGodReplyContent(), k.this.goT.aIw().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.gph = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void qa() {
                if (k.this.goT != null && k.this.goT.dqA != null && k.this.goT.dqA.aKV() != null) {
                    k.this.bEG();
                }
            }
        };
        this.gpi = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.emr != null) {
                    k.this.emr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.duG = tbPageContext;
        View view = getView();
        this.fsp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.goQ = (HeadPendantClickableView) this.fsp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.goQ.getHeadView() != null) {
            this.goQ.getHeadView().setIsRound(true);
            this.goQ.getHeadView().setDrawBorder(false);
            this.goQ.getHeadView().setDefaultResource(17170445);
            this.goQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.ds70));
            this.goQ.getHeadView().setPlaceHolder(1);
        }
        this.goQ.setHasPendantStyle();
        if (this.goQ.getPendantView() != null) {
            this.goQ.getPendantView().setIsRound(true);
            this.goQ.getPendantView().setDrawBorder(false);
        }
        this.emv = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.emv.setLoadingAnimationListener(this.gpc);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fsq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fsC = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.fsC.a(this.fsp, dimens, 0);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fsr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsr.setLayoutParams(layoutParams);
        }
        this.fsr.setOnClickListener(this);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setShareVisible(true);
        this.fsr.setShareReportFrom(3);
        this.fsr.setForumAfterClickListener(this.dIf);
        this.fsr.setFrom(1);
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.ftd.dJa.setOnClickListener(this);
        this.ftd.setFrom(1);
        this.ftd.setShareReportFrom(3);
        this.ftd.setForumAfterClickListener(this.dIf);
        this.goJ = view.findViewById(R.id.divider_below_reply_number_layout);
        this.emp = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.emp.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duG.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.emp.setLayoutParams(layoutParams2);
        this.emr = (TbImageView) view.findViewById(R.id.image_video);
        this.emr.setDefaultErrorResource(0);
        this.emr.setPlaceHolder(3);
        this.emr.setGifIconSupport(false);
        this.emr.setEvent(this.emz);
        this.emr.setRadius(com.baidu.adp.lib.util.l.getDimens(this.duG.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.emr;
        TbImageView tbImageView2 = this.emr;
        tbImageView.setConrers(15);
        this.emr.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.emr.setBorderColor(am.getColor(R.color.cp_border_a));
        this.emr.setBorderSurroundContent(true);
        this.emr.setDrawBorder(true);
        this.ems = (ImageView) view.findViewById(R.id.image_video_play);
        this.fsp.setOnClickListener(this);
        this.ePc = new com.baidu.tieba.play.n(this.duG.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.sV("cyber_player_test") || com.baidu.tbadk.a.b.sU("cyber_player_test");
        this.goR = com.baidu.tieba.play.a.b.A(this.duG.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.emp.addView(this.goR.getView(), 0);
        this.goR.getView().setLayoutParams(layoutParams3);
        this.goR.setContinuePlayEnable(true);
        this.goR.setBusiness(this.ePc);
        this.goR.setOnPreparedListener(this.evF);
        this.goR.setOnOutInfoListener(this.evH);
        this.goR.setOnCompletionListener(this.evE);
        this.goR.setOnErrorListener(this.emA);
        this.goR.setOnSurfaceDestroyedListener(this.emE);
        this.ePb = new com.baidu.tieba.play.j();
        this.ePb.setPlayer(this.goR);
        this.ePb.a(this.gph);
        this.emq = (TextView) view.findViewById(R.id.text_video_duration);
        this.goS = (LinearLayout) view.findViewById(R.id.duration_container);
        this.emx = (TextView) view.findViewById(R.id.text_video_play_count);
        this.emw = view.findViewById(R.id.auto_video_black_mask);
        this.emt = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.emu = view.findViewById(R.id.auto_video_error_background);
        this.eGZ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bhu = AnimationUtils.loadAnimation(this.duG.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bhu.setAnimationListener(this.gpi);
        this.goP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.goP.setOnClickListener(this);
        this.cDw = view.findViewById(R.id.divider_line);
        this.goY = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.goR.getView().setOnClickListener(this);
        this.gpa = (TextView) view.findViewById(R.id.nani_video_icon);
        this.goO = new com.baidu.afd.videopaster.d(getContext(), this.emp);
        this.goO.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void pP() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pO() {
                if (!k.this.goZ) {
                    k.this.goR.start();
                } else {
                    k.this.startPlay();
                }
                k.this.goZ = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pN() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pQ() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.goT != null && this.goT.dqA != null && this.goT.dqA.dtm > 0) {
            if (bEy() != null) {
                bEy().a(view, this.goT);
            }
            this.duG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.duG.getPageActivity(), this.goT.dqA.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.aKq(), this.goT.aIz())));
            return;
        }
        if (view == this.fsp || view == this.goP) {
            bM(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.goR.getView()) {
            if (this.goT != null) {
                this.goT.objType = 5;
            }
            if (this.goT != null && this.goT.dqA != null && this.goT.dqA.aKV() != null) {
                z = this.goT.dqA.aKV().is_vertical.intValue() == 1;
            }
            if (z) {
                bK(this.goR.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bL(this.goR.getView());
                } else {
                    bM(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bL(this.goR.getView());
            } else {
                bM(getView());
            }
        }
    }

    private void bK(View view) {
        if (bEy() != null) {
            bEy().a(view, this.goT);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duG.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEH();
        }
    }

    private void bL(View view) {
        if (bEy() != null) {
            bEy().a(view, this.goT);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duG.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEI();
        }
    }

    private void bEH() {
        if (this.goT != null && this.goT.dqA != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.goT.dqA);
            videoItemData.mRecomExtra = this.goT.getExtra();
            videoItemData.mRecomAbTag = this.goT.bFi();
            videoItemData.mRecomSource = this.goT.getSource();
            videoItemData.mRecomWeight = this.goT.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.goT.aIz(), "index");
            if (this.goT.dqA.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.goT.dqA.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bEI() {
        if (this.goT != null && this.goT.dqA != null && this.goT.dqA.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.goT.dqA);
            videoSerializeVideoThreadInfo.source = this.goT.getSource();
            videoSerializeVideoThreadInfo.extra = this.goT.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.goT.bFi();
            videoSerializeVideoThreadInfo.weight = this.goT.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.eGZ.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.eGZ.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.duG.getPageActivity(), str, this.goT.dqA.getTid(), l.aKq(), this.goT.aIz(), videoSerializeVideoThreadInfo);
            if (this.goT.aIw() != null && this.goT.aIw().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.goT.aIw().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bM(View view) {
        if (this.goT != null) {
            this.goT.objType = 1;
        }
        if (bEy() != null) {
            bEy().a(view, this.goT);
        }
        if (this.goT != null && this.goT.dqA != null) {
            if (!bEJ()) {
                l.BB(this.goT.dqA.getId());
                l.a(this.mTextTitle, this.goT.dqA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.duG.getPageActivity()).createFromThreadCfg(this.goT.dqA, null, l.aKq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.goT.aIz());
            addLocateParam.setVideo_source(this.goT.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.goT.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.goT.dqA.getFid()));
            addLocateParam.setForumName(this.goT.dqA.aKJ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.goP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.duG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEJ() {
        return this.goT.gsP && !this.goT.gsW;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.goT = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEK() {
        this.gpb.removeMessages(202);
        if (this.goR.getCurrentPosition() > this.XZ) {
            q(false, 3);
            this.gpb.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gpb.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEL() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gpb.removeMessages(203);
        int currentPosition = this.goR.getCurrentPosition();
        if (currentPosition != this.goU) {
            this.goU = currentPosition;
            q(false, 3);
        } else {
            q(false, 2);
        }
        this.gpb.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, int i) {
        if (this.ems != null && this.emr != null && this.emw != null && this.emv != null && this.emu != null && this.emt != null) {
            if (z || this.emy != i) {
                this.emy = i;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emD);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emC);
                if (i == 2) {
                    this.ems.setVisibility(8);
                    this.bhu.cancel();
                    this.emr.clearAnimation();
                    this.emr.setVisibility(0);
                    this.emw.setVisibility(0);
                    this.goS.setVisibility(0);
                    this.goY.setVisibility(8);
                    this.emv.startLoading();
                    this.emu.setVisibility(8);
                    this.emt.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emD, 60000L);
                } else if (i == 3) {
                    this.ems.setVisibility(8);
                    this.emr.startAnimation(this.bhu);
                    this.emw.setVisibility(8);
                    this.goS.setVisibility(8);
                    if (this.goT != null && this.goT.aIw() != null && this.goT.aIw().dtm > 0) {
                        this.goY.setVisibility(0);
                    }
                    this.emv.cKn();
                    this.emu.setVisibility(8);
                    this.emt.setVisibility(8);
                    if (this.goT != null && this.goT.dqA != null && this.goT.dqA.aKV() != null) {
                        this.goT.dqA.aKV().video_length.intValue();
                        this.goT.dqA.aKV().video_duration.intValue();
                        this.goT.dqA.getTid();
                    }
                } else if (i == 4) {
                    this.ems.setVisibility(8);
                    this.emr.startAnimation(this.bhu);
                    this.emw.setVisibility(8);
                    this.emv.cKo();
                    this.emu.setVisibility(0);
                    this.emt.setVisibility(0);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emC, 2000L);
                } else {
                    this.ems.setVisibility(0);
                    this.bhu.cancel();
                    this.emr.clearAnimation();
                    this.emr.setVisibility(0);
                    this.emw.setVisibility(0);
                    this.goS.setVisibility(0);
                    this.emv.cKo();
                    this.emu.setVisibility(8);
                    this.emt.setVisibility(8);
                }
                if (this.goT != null && this.goT.aIw() != null && this.goT.aIw().dtm > 0) {
                    this.goS.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.goT == null || this.goT.dqA == null || this.goT.dqA.aKE() == null) {
            this.fsp.setVisibility(8);
            return;
        }
        this.fsp.setVisibility(0);
        bEN();
        if (!bEJ() && l.BC(this.goT.dqA.getId())) {
            l.a(this.mTextTitle, this.goT.dqA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.goP.getGodReplyContent(), this.goT.aIw().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.goT.aIw().aLz();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.goT.aIw().aLl());
        if (this.goT.aIw().aLr() && !StringUtils.isNull(this.goT.aIw().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.goT.aIw().getTid();
            spannableStringBuilder.append((CharSequence) this.goT.aIw().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cI("obj_source", "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.fsq.setData(this.goT.aIw());
        this.fsq.setUserAfterClickListener(this.gpe);
        if (this.fsq.getHeaderImg() != null) {
            this.fsq.getHeaderImg().setAfterClickListener(this.gpf);
            if (this.fsq.getIsSimpleThread()) {
                this.fsq.getHeaderImg().setVisibility(8);
                this.goQ.setVisibility(8);
            } else if (this.goT.aIw() == null || this.goT.aIw().aKE() == null || this.goT.aIw().aKE().getPendantData() == null || StringUtils.isNull(this.goT.aIw().aKE().getPendantData().aIW())) {
                this.goQ.setVisibility(8);
                this.fsq.getHeaderImg().setVisibility(0);
                if (this.goT.aIw().dtm > 0 && this.goT.aIw().dtn == 0) {
                    this.goT.aIw().aKE().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.fsq.getHeaderImg().setData(this.goT.aIw(), false);
                } else {
                    this.fsq.getHeaderImg().setData(this.goT.aIw());
                    this.fsq.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.fsq.getHeaderImg().setVisibility(4);
                this.goQ.setVisibility(0);
                this.goQ.setData(this.goT.aIw());
            }
        }
        this.emq.setText(aq.stringForVideoTime(this.goT.dqA.aKV().video_duration.intValue() * 1000));
        this.emx.setText(String.format(this.duG.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.goT.dqA.aKV().play_count.intValue())));
        if (this.fsC != null && this.goT.aIw() != null) {
            al alVar = new al();
            alVar.setTid(this.goT.aIw().getTid());
            alVar.setFid(this.goT.aIw().getFid());
            alVar.setFeedBackReasonMap(this.goT.feedBackReasonMap);
            this.fsC.setData(alVar);
            this.fsC.setFirstRowSingleColumn(true);
            this.fsC.setVisibility(this.goW ? 0 : 8);
        }
        this.goP.setData(this.goT.aIw().aMe());
        pX(or(1));
        onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
        if (l.BC(this.goT.dqA.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.goT == null || this.goT.dqA == null || this.goT.dqA.aKV() == null) {
            z = false;
        } else {
            z = this.goT.dqA.aKV().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gpa.setVisibility(0);
            if (bEO()) {
                this.gpa.setText(String.format("%s | %s", this.duG.getResources().getString(R.string.nani_video), this.duG.getResources().getString(R.string.video_preview)));
            } else {
                this.gpa.setText(this.duG.getString(R.string.nani_video));
            }
        } else if (bEO()) {
            this.gpa.setVisibility(0);
            this.gpa.setText(this.duG.getString(R.string.video_preview));
        } else {
            this.gpa.setVisibility(8);
        }
    }

    private void bEM() {
        this.gpb.removeMessages(202);
        this.gpb.removeMessages(203);
    }

    private void bbR() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emC);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emD);
    }

    private void bEN() {
        bbR();
        bEM();
        if (this.emr != null && this.emp != null && this.goR != null) {
            if (com.baidu.tbadk.core.i.aIe().isShowImages() && this.goT != null && this.goT.dqA != null && this.goT.dqA.aKV() != null) {
                this.emr.setPlaceHolder(3);
                this.emr.startLoad(this.goT.dqA.aKV().thumbnail_url, 10, false);
                this.emp.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.goT.dqA.aKV().video_url;
                if (bEO()) {
                    this.mVideoUrl = this.goT.dqA.aKW().video_url;
                }
                if (StringUtils.isNull(this.goT.dqA.aKV().video_url)) {
                    q(true, 4);
                }
                if (this.ePc != null && this.ePc.cJY() != null) {
                    this.ePc.cJY().am(this.goT.dqA);
                }
            } else {
                this.emp.setVisibility(8);
            }
            this.goO.reset();
            this.ePb.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.goO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.goT);
                    }
                }
            });
            this.ePc.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.goO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.goT);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.dqA != null) {
            bj bjVar = lVar.dqA;
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
        if (lVar == null || lVar.dqA == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.dqA;
        int pU = bVar.pU();
        int pV = bVar.pV();
        int pT = bVar.pT();
        if (pT != -1) {
            i = pU != -1 ? (pT - pU) - 1 : -1;
            if (pV != -1) {
                i4 = (pV - pT) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aKV = bjVar.aKV();
        if (aKV != null) {
            i3 = aKV.video_width.intValue();
            i2 = aKV.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aKJ());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pT + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.ems, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.emt, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emx, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.goY, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.emu, R.color.common_color_10014);
            am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c);
            if (this.gpa != null) {
                am.setViewTextColor(this.gpa, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gpa, R.drawable.video_play_count_bg);
            }
            if (this.emt != null) {
                this.emt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.goP.onChangeSkinType();
            if (this.fsC != null) {
                this.fsC.onChangeSkinType();
            }
            this.fsq.onChangeSkinType();
            this.fsr.onChangeSkinType();
            this.ftd.onChangeSkinType();
            this.emr.setPlaceHolder(3);
            this.goQ.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gpg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gpg);
            this.gpd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gpd);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fsq != null) {
            this.fsq.setPageUniqueId(bdUniqueId);
        }
        if (this.emr != null) {
            this.emr.setPageId(bdUniqueId);
        }
        if (this.fsC != null) {
            this.fsC.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.goV;
    }

    public boolean isPlaying() {
        if (this.goR == null) {
            return false;
        }
        return this.goR.isPlaying();
    }

    public void startPlay() {
        if (!this.goV && this.goT != null && this.goT.dqA != null && this.goT.dqA.aKV() != null && this.goR != null) {
            if (this.goO.py()) {
                this.goO.resume();
                this.goZ = true;
                return;
            }
            this.goZ = false;
            this.goR.stopPlayback();
            if (af.am(1, this.mVideoUrl)) {
                q(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cI("obj_locate", "index").cI("tid", this.goT.tid));
                    this.mVideoUrl = this.goT.dqA.aKV().video_url;
                }
                this.goV = true;
                this.goR.setVideoPath(this.mVideoUrl, this.goT.tid);
                if (this.ePb != null) {
                    this.ePb.start();
                }
                bEG();
            }
        }
    }

    public void stopPlay() {
        this.goZ = false;
        bbR();
        bEM();
        q(true, 1);
        if (this.goR != null) {
            this.goR.stopPlayback();
            if (this.ePb != null) {
                this.ePb.stop();
            }
        }
        this.goV = false;
        this.goO.stop();
    }

    public View getVideoContainer() {
        return this.emp;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.goR == null) {
            return 0;
        }
        return this.goR.getCurrentPosition();
    }

    public void lq(boolean z) {
        this.goW = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pX(int i) {
        if (this.goT != null && this.goT.dqA != null) {
            if (i == 1) {
                if (this.goT.dqA.dtm > 0) {
                    this.ftd.dJa.setShowPraiseNum(false);
                    this.ftd.dJa.setShareVisible(false);
                    this.goY.setText(aq.numFormatOverWan(this.goT.dqA.dtm));
                    this.goY.setVisibility(0);
                } else {
                    this.ftd.dJa.setShowPraiseNum(true);
                    this.ftd.dJa.setShareVisible(true);
                    this.goY.setVisibility(8);
                }
                this.ftd.setData(this.goT.dqA);
                this.fsr.setVisibility(8);
                this.fsq.gQ(false);
                return;
            }
            this.ftd.setVisibility(8);
            this.fsq.gQ(true);
            if (this.goT.dqA.dtm > 0) {
                this.fsr.setShowPraiseNum(false);
                this.fsr.setShareVisible(false);
                this.goY.setText(aq.numFormatOverWan(this.goT.dqA.dtm));
                this.goY.setVisibility(0);
            } else {
                this.fsr.setShowPraiseNum(true);
                this.fsr.setShareVisible(true);
                this.goY.setVisibility(8);
            }
            if (this.fsr.setData(this.goT.dqA)) {
                this.goJ.setVisibility(8);
            } else {
                this.goJ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.emr.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.i(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.emr.setOnDrawListener(null);
        }
    }

    private boolean bEO() {
        return (this.goT == null || this.goT.dqA == null || this.goT.dqA.aKW() == null || TextUtils.isEmpty(this.goT.dqA.aKW().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.goO.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.goO.stop();
    }

    public void onResume() {
        if (this.goO.py()) {
            this.goO.resume();
        }
    }
}
