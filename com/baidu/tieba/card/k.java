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
    private int Yc;
    private String aeB;
    private Animation bhz;
    private View cDC;
    private final View.OnClickListener dIj;
    private TbPageContext<?> duK;
    protected LinearLayout eHe;
    private com.baidu.tieba.play.j ePg;
    private com.baidu.tieba.play.n ePh;
    private com.baidu.tieba.play.w emA;
    private View emB;
    private TextView emC;
    private int emD;
    private TbImageView.a emE;
    private g.b emF;
    private Runnable emH;
    private Runnable emI;
    private QuickVideoView.b emJ;
    public FrameLayout emu;
    private TextView emv;
    private TbImageView emw;
    private ImageView emx;
    private TextView emy;
    private View emz;
    private g.a evJ;
    private g.f evK;
    private g.e evM;
    private NEGFeedBackView fsH;
    private RelativeLayout fsu;
    public ThreadUserInfoLayout fsv;
    public ThreadCommentAndPraiseInfoLayout fsw;
    public ThreadSourceShareAndPraiseLayout fti;
    private View goP;
    private com.baidu.afd.videopaster.d goU;
    public ThreadGodReplyLayout goV;
    private HeadPendantClickableView goW;
    private com.baidu.tieba.play.a.a goX;
    private LinearLayout goY;
    private com.baidu.tieba.card.data.l goZ;
    private int gpa;
    private boolean gpb;
    private boolean gpc;
    private boolean gpd;
    private TextView gpe;
    private boolean gpf;
    private TextView gpg;
    private Handler gph;
    private VideoLoadingProgressView.a gpi;
    private CustomMessageListener gpj;
    private final View.OnClickListener gpk;
    private final View.OnClickListener gpl;
    private CustomMessageListener gpm;
    private j.a gpn;
    private Animation.AnimationListener gpo;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bEE() {
        if (this.goX != null && this.gpb) {
            try {
                this.goX.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int IO = com.baidu.tieba.play.x.cKp().IO(this.mVideoUrl);
            if (IO <= 100 || this.goX.getDuration() <= IO) {
                IO = 100;
            }
            this.Yc = IO;
            this.gph.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.goZ != null && this.goZ.dqE != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.goZ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.ahO = this.goZ.dqE.getTid();
            yVar.eQk = this.goZ.dqE.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.goZ.dqE.mRecomSource;
            yVar.kiv = this.goZ.dqE.mRecomAbTag;
            yVar.kir = this.goZ.dqE.mRecomAbTag;
            yVar.kis = this.goZ.dqE.mRecomWeight;
            yVar.kit = "";
            yVar.dop = this.goZ.getExtra();
            if (this.goZ.dqE.aKT() != null) {
                yVar.kiw = this.goZ.dqE.aKT().video_md5;
            }
            com.baidu.tieba.play.l.a(this.goZ.dqE.aKT().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fsH = null;
        this.mSkinType = 3;
        this.gpa = 0;
        this.emD = 1;
        this.gpb = false;
        this.gpc = true;
        this.gpd = false;
        this.Yc = 100;
        this.gpf = false;
        this.isNewPlayer = false;
        this.gph = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.bEJ();
                        return;
                    case 203:
                        k.this.bEK();
                        return;
                    default:
                        return;
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.goX != null) {
                    k.this.goX.setVolume(0.0f, 0.0f);
                }
                k.this.bEE();
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.q(false, 3);
                }
                return false;
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.goU.a(false, false, "NEWINDEX")) {
                    k.this.goX.start();
                }
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.q(true, 4);
                k.this.gpb = false;
                return true;
            }
        };
        this.gpi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.bEE();
            }
        };
        this.emE = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.emw != null) {
                    k.this.emw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.emH = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.goX != null && !k.this.goX.isPlaying()) {
                    k.this.q(true, 1);
                }
            }
        };
        this.emI = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.q(true, 4);
            }
        };
        this.gpj = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.goZ != null && k.this.goZ.dqE != null && videoId.equals(k.this.goZ.dqE.getId())) {
                        k.this.goU.a(k.this.a(k.this.goZ, bVar));
                    }
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.gpk = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.goZ == null) {
                    if (k.this.bEx() != null) {
                        k.this.bEx().a(view, k.this.goZ);
                        return;
                    }
                    return;
                }
                if (view == k.this.fsv.getUserName()) {
                    k.this.goZ.objType = 3;
                } else if (view == k.this.fsv.getHeaderImg()) {
                    k.this.goZ.objType = 4;
                } else {
                    k.this.goZ.objType = 1;
                }
                if (k.this.bEx() != null) {
                    k.this.bEx().a(view, k.this.goZ);
                }
            }
        };
        this.gpl = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.goZ != null) {
                    k.this.goZ.objType = 4;
                }
                if (k.this.bEx() != null) {
                    k.this.bEx().a(view, k.this.goZ);
                }
            }
        };
        this.gpm = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.gpd = false;
                }
            }
        };
        this.dIj = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.goZ != null) {
                    if (k.this.bEx() != null) {
                        k.this.bEx().a(view, k.this.goZ);
                    }
                    if (k.this.goZ.dqE != null && view != k.this.fti.dIt) {
                        l.BE(k.this.goZ.dqE.getId());
                        if (!k.this.bEI()) {
                            l.a(k.this.mTextTitle, k.this.goZ.dqE.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.goV.getGodReplyContent(), k.this.goZ.aIu().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.gpn = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void qa() {
                if (k.this.goZ != null && k.this.goZ.dqE != null && k.this.goZ.dqE.aKT() != null) {
                    k.this.bEF();
                }
            }
        };
        this.gpo = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.emw != null) {
                    k.this.emw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.duK = tbPageContext;
        View view = getView();
        this.fsu = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.goW = (HeadPendantClickableView) this.fsu.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.goW.getHeadView() != null) {
            this.goW.getHeadView().setIsRound(true);
            this.goW.getHeadView().setDrawBorder(false);
            this.goW.getHeadView().setDefaultResource(17170445);
            this.goW.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goW.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.ds70));
            this.goW.getHeadView().setPlaceHolder(1);
        }
        this.goW.setHasPendantStyle();
        if (this.goW.getPendantView() != null) {
            this.goW.getPendantView().setIsRound(true);
            this.goW.getPendantView().setDrawBorder(false);
        }
        this.emA = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.emA.setLoadingAnimationListener(this.gpi);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fsv = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fsH = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.fsH.a(this.fsu, dimens, 0);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fsw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsw.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsw.setLayoutParams(layoutParams);
        }
        this.fsw.setOnClickListener(this);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setShareVisible(true);
        this.fsw.setShareReportFrom(3);
        this.fsw.setForumAfterClickListener(this.dIj);
        this.fsw.setFrom(1);
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fti.dJe.setOnClickListener(this);
        this.fti.setFrom(1);
        this.fti.setShareReportFrom(3);
        this.fti.setForumAfterClickListener(this.dIj);
        this.goP = view.findViewById(R.id.divider_below_reply_number_layout);
        this.emu = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.emu.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.duK.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.emu.setLayoutParams(layoutParams2);
        this.emw = (TbImageView) view.findViewById(R.id.image_video);
        this.emw.setDefaultErrorResource(0);
        this.emw.setPlaceHolder(3);
        this.emw.setGifIconSupport(false);
        this.emw.setEvent(this.emE);
        this.emw.setRadius(com.baidu.adp.lib.util.l.getDimens(this.duK.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.emw;
        TbImageView tbImageView2 = this.emw;
        tbImageView.setConrers(15);
        this.emw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.emw.setBorderColor(am.getColor(R.color.cp_border_a));
        this.emw.setBorderSurroundContent(true);
        this.emw.setDrawBorder(true);
        this.emx = (ImageView) view.findViewById(R.id.image_video_play);
        this.fsu.setOnClickListener(this);
        this.ePh = new com.baidu.tieba.play.n(this.duK.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.sY("cyber_player_test") || com.baidu.tbadk.a.b.sX("cyber_player_test");
        this.goX = com.baidu.tieba.play.a.b.A(this.duK.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.emu.addView(this.goX.getView(), 0);
        this.goX.getView().setLayoutParams(layoutParams3);
        this.goX.setContinuePlayEnable(true);
        this.goX.setBusiness(this.ePh);
        this.goX.setOnPreparedListener(this.evK);
        this.goX.setOnOutInfoListener(this.evM);
        this.goX.setOnCompletionListener(this.evJ);
        this.goX.setOnErrorListener(this.emF);
        this.goX.setOnSurfaceDestroyedListener(this.emJ);
        this.ePg = new com.baidu.tieba.play.j();
        this.ePg.setPlayer(this.goX);
        this.ePg.a(this.gpn);
        this.emv = (TextView) view.findViewById(R.id.text_video_duration);
        this.goY = (LinearLayout) view.findViewById(R.id.duration_container);
        this.emC = (TextView) view.findViewById(R.id.text_video_play_count);
        this.emB = view.findViewById(R.id.auto_video_black_mask);
        this.emy = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.emz = view.findViewById(R.id.auto_video_error_background);
        this.eHe = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bhz = AnimationUtils.loadAnimation(this.duK.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bhz.setAnimationListener(this.gpo);
        this.goV = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.goV.setOnClickListener(this);
        this.cDC = view.findViewById(R.id.divider_line);
        this.gpe = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.goX.getView().setOnClickListener(this);
        this.gpg = (TextView) view.findViewById(R.id.nani_video_icon);
        this.goU = new com.baidu.afd.videopaster.d(getContext(), this.emu);
        this.goU.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void pP() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pO() {
                if (!k.this.gpf) {
                    k.this.goX.start();
                } else {
                    k.this.startPlay();
                }
                k.this.gpf = false;
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
        if (this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.dtq > 0) {
            if (bEx() != null) {
                bEx().a(view, this.goZ);
            }
            this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.duK.getPageActivity(), this.goZ.dqE.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.aKo(), this.goZ.aIx())));
            return;
        }
        if (view == this.fsu || view == this.goV) {
            bM(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.goX.getView()) {
            if (this.goZ != null) {
                this.goZ.objType = 5;
            }
            if (this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.aKT() != null) {
                z = this.goZ.dqE.aKT().is_vertical.intValue() == 1;
            }
            if (z) {
                bK(this.goX.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bL(this.goX.getView());
                } else {
                    bM(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bL(this.goX.getView());
            } else {
                bM(getView());
            }
        }
    }

    private void bK(View view) {
        if (bEx() != null) {
            bEx().a(view, this.goZ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duK.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEG();
        }
    }

    private void bL(View view) {
        if (bEx() != null) {
            bEx().a(view, this.goZ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.duK.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEH();
        }
    }

    private void bEG() {
        if (this.goZ != null && this.goZ.dqE != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.goZ.dqE);
            videoItemData.mRecomExtra = this.goZ.getExtra();
            videoItemData.mRecomAbTag = this.goZ.bFh();
            videoItemData.mRecomSource = this.goZ.getSource();
            videoItemData.mRecomWeight = this.goZ.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.goZ.aIx(), "index");
            if (this.goZ.dqE.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.goZ.dqE.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bEH() {
        if (this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.goZ.dqE);
            videoSerializeVideoThreadInfo.source = this.goZ.getSource();
            videoSerializeVideoThreadInfo.extra = this.goZ.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.goZ.bFh();
            videoSerializeVideoThreadInfo.weight = this.goZ.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.eHe.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.eHe.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.duK.getPageActivity(), str, this.goZ.dqE.getTid(), l.aKo(), this.goZ.aIx(), videoSerializeVideoThreadInfo);
            if (this.goZ.aIu() != null && this.goZ.aIu().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.goZ.aIu().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bM(View view) {
        if (this.goZ != null) {
            this.goZ.objType = 1;
        }
        if (bEx() != null) {
            bEx().a(view, this.goZ);
        }
        if (this.goZ != null && this.goZ.dqE != null) {
            if (!bEI()) {
                l.BE(this.goZ.dqE.getId());
                l.a(this.mTextTitle, this.goZ.dqE.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.duK.getPageActivity()).createFromThreadCfg(this.goZ.dqE, null, l.aKo(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.goZ.aIx());
            addLocateParam.setVideo_source(this.goZ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.goZ.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.goZ.dqE.getFid()));
            addLocateParam.setForumName(this.goZ.dqE.aKH());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.goV) {
                addLocateParam.setJumpGodReply(true);
            }
            this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEI() {
        return this.goZ.gsV && !this.goZ.gtc;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.goZ = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEJ() {
        this.gph.removeMessages(202);
        if (this.goX.getCurrentPosition() > this.Yc) {
            q(false, 3);
            this.gph.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gph.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEK() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gph.removeMessages(203);
        int currentPosition = this.goX.getCurrentPosition();
        if (currentPosition != this.gpa) {
            this.gpa = currentPosition;
            q(false, 3);
        } else {
            q(false, 2);
        }
        this.gph.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, int i) {
        if (this.emx != null && this.emw != null && this.emB != null && this.emA != null && this.emz != null && this.emy != null) {
            if (z || this.emD != i) {
                this.emD = i;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emI);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emH);
                if (i == 2) {
                    this.emx.setVisibility(8);
                    this.bhz.cancel();
                    this.emw.clearAnimation();
                    this.emw.setVisibility(0);
                    this.emB.setVisibility(0);
                    this.goY.setVisibility(0);
                    this.gpe.setVisibility(8);
                    this.emA.startLoading();
                    this.emz.setVisibility(8);
                    this.emy.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emI, 60000L);
                } else if (i == 3) {
                    this.emx.setVisibility(8);
                    this.emw.startAnimation(this.bhz);
                    this.emB.setVisibility(8);
                    this.goY.setVisibility(8);
                    if (this.goZ != null && this.goZ.aIu() != null && this.goZ.aIu().dtq > 0) {
                        this.gpe.setVisibility(0);
                    }
                    this.emA.cKl();
                    this.emz.setVisibility(8);
                    this.emy.setVisibility(8);
                    if (this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.aKT() != null) {
                        this.goZ.dqE.aKT().video_length.intValue();
                        this.goZ.dqE.aKT().video_duration.intValue();
                        this.goZ.dqE.getTid();
                    }
                } else if (i == 4) {
                    this.emx.setVisibility(8);
                    this.emw.startAnimation(this.bhz);
                    this.emB.setVisibility(8);
                    this.emA.cKm();
                    this.emz.setVisibility(0);
                    this.emy.setVisibility(0);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emH, 2000L);
                } else {
                    this.emx.setVisibility(0);
                    this.bhz.cancel();
                    this.emw.clearAnimation();
                    this.emw.setVisibility(0);
                    this.emB.setVisibility(0);
                    this.goY.setVisibility(0);
                    this.emA.cKm();
                    this.emz.setVisibility(8);
                    this.emy.setVisibility(8);
                }
                if (this.goZ != null && this.goZ.aIu() != null && this.goZ.aIu().dtq > 0) {
                    this.goY.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.goZ == null || this.goZ.dqE == null || this.goZ.dqE.aKC() == null) {
            this.fsu.setVisibility(8);
            return;
        }
        this.fsu.setVisibility(0);
        bEM();
        if (!bEI() && l.BF(this.goZ.dqE.getId())) {
            l.a(this.mTextTitle, this.goZ.dqE.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.goV.getGodReplyContent(), this.goZ.aIu().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.goZ.aIu().aLx();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.goZ.aIu().aLj());
        if (this.goZ.aIu().aLp() && !StringUtils.isNull(this.goZ.aIu().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.goZ.aIu().getTid();
            spannableStringBuilder.append((CharSequence) this.goZ.aIu().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
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
        this.fsv.setData(this.goZ.aIu());
        this.fsv.setUserAfterClickListener(this.gpk);
        if (this.fsv.getHeaderImg() != null) {
            this.fsv.getHeaderImg().setAfterClickListener(this.gpl);
            if (this.fsv.getIsSimpleThread()) {
                this.fsv.getHeaderImg().setVisibility(8);
                this.goW.setVisibility(8);
            } else if (this.goZ.aIu() == null || this.goZ.aIu().aKC() == null || this.goZ.aIu().aKC().getPendantData() == null || StringUtils.isNull(this.goZ.aIu().aKC().getPendantData().aIU())) {
                this.goW.setVisibility(8);
                this.fsv.getHeaderImg().setVisibility(0);
                if (this.goZ.aIu().dtq > 0 && this.goZ.aIu().dtr == 0) {
                    this.goZ.aIu().aKC().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.fsv.getHeaderImg().setData(this.goZ.aIu(), false);
                } else {
                    this.fsv.getHeaderImg().setData(this.goZ.aIu());
                    this.fsv.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.fsv.getHeaderImg().setVisibility(4);
                this.goW.setVisibility(0);
                this.goW.setData(this.goZ.aIu());
            }
        }
        this.emv.setText(aq.stringForVideoTime(this.goZ.dqE.aKT().video_duration.intValue() * 1000));
        this.emC.setText(String.format(this.duK.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.goZ.dqE.aKT().play_count.intValue())));
        if (this.fsH != null && this.goZ.aIu() != null) {
            al alVar = new al();
            alVar.setTid(this.goZ.aIu().getTid());
            alVar.setFid(this.goZ.aIu().getFid());
            alVar.setFeedBackReasonMap(this.goZ.feedBackReasonMap);
            this.fsH.setData(alVar);
            this.fsH.setFirstRowSingleColumn(true);
            this.fsH.setVisibility(this.gpc ? 0 : 8);
        }
        this.goV.setData(this.goZ.aIu().aMc());
        pX(or(1));
        onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
        if (l.BF(this.goZ.dqE.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.goZ == null || this.goZ.dqE == null || this.goZ.dqE.aKT() == null) {
            z = false;
        } else {
            z = this.goZ.dqE.aKT().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gpg.setVisibility(0);
            if (bEN()) {
                this.gpg.setText(String.format("%s | %s", this.duK.getResources().getString(R.string.nani_video), this.duK.getResources().getString(R.string.video_preview)));
            } else {
                this.gpg.setText(this.duK.getString(R.string.nani_video));
            }
        } else if (bEN()) {
            this.gpg.setVisibility(0);
            this.gpg.setText(this.duK.getString(R.string.video_preview));
        } else {
            this.gpg.setVisibility(8);
        }
    }

    private void bEL() {
        this.gph.removeMessages(202);
        this.gph.removeMessages(203);
    }

    private void bbP() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emH);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emI);
    }

    private void bEM() {
        bbP();
        bEL();
        if (this.emw != null && this.emu != null && this.goX != null) {
            if (com.baidu.tbadk.core.i.aIc().isShowImages() && this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.aKT() != null) {
                this.emw.setPlaceHolder(3);
                this.emw.startLoad(this.goZ.dqE.aKT().thumbnail_url, 10, false);
                this.emu.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.goZ.dqE.aKT().video_url;
                if (bEN()) {
                    this.mVideoUrl = this.goZ.dqE.aKU().video_url;
                }
                if (StringUtils.isNull(this.goZ.dqE.aKT().video_url)) {
                    q(true, 4);
                }
                if (this.ePh != null && this.ePh.cJW() != null) {
                    this.ePh.cJW().am(this.goZ.dqE);
                }
            } else {
                this.emu.setVisibility(8);
            }
            this.goU.reset();
            this.ePg.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.goU.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.goZ);
                    }
                }
            });
            this.ePh.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void bE(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.goU.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.goZ);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.dqE != null) {
            bj bjVar = lVar.dqE;
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
        if (lVar == null || lVar.dqE == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.dqE;
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
        VideoInfo aKT = bjVar.aKT();
        if (aKT != null) {
            i3 = aKT.video_width.intValue();
            i2 = aKT.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aKH());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pT + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsu, R.drawable.addresslist_item_bg);
            am.setImageResource(this.emx, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.emy, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.gpe, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.emz, R.color.common_color_10014);
            am.setBackgroundColor(this.cDC, R.color.cp_bg_line_c);
            if (this.gpg != null) {
                am.setViewTextColor(this.gpg, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gpg, R.drawable.video_play_count_bg);
            }
            if (this.emy != null) {
                this.emy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.goV.onChangeSkinType();
            if (this.fsH != null) {
                this.fsH.onChangeSkinType();
            }
            this.fsv.onChangeSkinType();
            this.fsw.onChangeSkinType();
            this.fti.onChangeSkinType();
            this.emw.setPlaceHolder(3);
            this.goW.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gpm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gpm);
            this.gpj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gpj);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fsv != null) {
            this.fsv.setPageUniqueId(bdUniqueId);
        }
        if (this.emw != null) {
            this.emw.setPageId(bdUniqueId);
        }
        if (this.fsH != null) {
            this.fsH.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.gpb;
    }

    public boolean isPlaying() {
        if (this.goX == null) {
            return false;
        }
        return this.goX.isPlaying();
    }

    public void startPlay() {
        if (!this.gpb && this.goZ != null && this.goZ.dqE != null && this.goZ.dqE.aKT() != null && this.goX != null) {
            if (this.goU.py()) {
                this.goU.resume();
                this.gpf = true;
                return;
            }
            this.gpf = false;
            this.goX.stopPlayback();
            if (af.am(1, this.mVideoUrl)) {
                q(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cI("obj_locate", "index").cI("tid", this.goZ.tid));
                    this.mVideoUrl = this.goZ.dqE.aKT().video_url;
                }
                this.gpb = true;
                this.goX.setVideoPath(this.mVideoUrl, this.goZ.tid);
                if (this.ePg != null) {
                    this.ePg.start();
                }
                bEF();
            }
        }
    }

    public void stopPlay() {
        this.gpf = false;
        bbP();
        bEL();
        q(true, 1);
        if (this.goX != null) {
            this.goX.stopPlayback();
            if (this.ePg != null) {
                this.ePg.stop();
            }
        }
        this.gpb = false;
        this.goU.stop();
    }

    public View getVideoContainer() {
        return this.emu;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.goX == null) {
            return 0;
        }
        return this.goX.getCurrentPosition();
    }

    public void lq(boolean z) {
        this.gpc = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pX(int i) {
        if (this.goZ != null && this.goZ.dqE != null) {
            if (i == 1) {
                if (this.goZ.dqE.dtq > 0) {
                    this.fti.dJe.setShowPraiseNum(false);
                    this.fti.dJe.setShareVisible(false);
                    this.gpe.setText(aq.numFormatOverWan(this.goZ.dqE.dtq));
                    this.gpe.setVisibility(0);
                } else {
                    this.fti.dJe.setShowPraiseNum(true);
                    this.fti.dJe.setShareVisible(true);
                    this.gpe.setVisibility(8);
                }
                this.fti.setData(this.goZ.dqE);
                this.fsw.setVisibility(8);
                this.fsv.gQ(false);
                return;
            }
            this.fti.setVisibility(8);
            this.fsv.gQ(true);
            if (this.goZ.dqE.dtq > 0) {
                this.fsw.setShowPraiseNum(false);
                this.fsw.setShareVisible(false);
                this.gpe.setText(aq.numFormatOverWan(this.goZ.dqE.dtq));
                this.gpe.setVisibility(0);
            } else {
                this.fsw.setShowPraiseNum(true);
                this.fsw.setShareVisible(true);
                this.gpe.setVisibility(8);
            }
            if (this.fsw.setData(this.goZ.dqE)) {
                this.goP.setVisibility(8);
            } else {
                this.goP.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.emw.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.i(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.emw.setOnDrawListener(null);
        }
    }

    private boolean bEN() {
        return (this.goZ == null || this.goZ.dqE == null || this.goZ.dqE.aKU() == null || TextUtils.isEmpty(this.goZ.dqE.aKU().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.goU.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.goU.stop();
    }

    public void onResume() {
        if (this.goU.py()) {
            this.goU.resume();
        }
    }
}
