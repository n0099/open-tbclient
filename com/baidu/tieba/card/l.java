package com.baidu.tieba.card;

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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class l extends b<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView abK;
    private int abQ;
    private String aji;
    private Animation ciC;
    private CyberPlayerManager.OnPreparedListener eDf;
    private CyberPlayerManager.OnErrorListener eDg;
    private CyberPlayerManager.OnCompletionListener eDh;
    private CyberPlayerManager.OnInfoListener eDi;
    private TbPageContext<?> eXu;
    private TbCyberVideoView.a fWA;
    public FrameLayout fWm;
    private TextView fWn;
    private TbImageView fWo;
    private ImageView fWp;
    private TextView fWq;
    private View fWr;
    private com.baidu.tieba.play.m fWs;
    private View fWt;
    private TextView fWu;
    private int fWv;
    private TbImageView.b fWw;
    private Runnable fWy;
    private Runnable fWz;
    private final View.OnClickListener fmS;
    private com.baidu.tieba.play.f gBV;
    private View ghM;
    protected LinearLayout gpU;
    private NEGFeedBackView hnK;
    private RelativeLayout hnx;
    public ThreadUserInfoLayout hny;
    public ThreadCommentAndPraiseInfoLayout hnz;
    public ThreadSourceShareAndPraiseLayout hol;
    public ThreadGodReplyLayout ivA;
    private HeadPendantClickableView ivB;
    private LinearLayout ivC;
    private com.baidu.tieba.card.data.l ivD;
    private int ivE;
    private boolean ivF;
    private boolean ivG;
    private boolean ivH;
    private TextView ivI;
    private boolean ivJ;
    private TextView ivK;
    private Handler ivL;
    private VideoLoadingProgressView.a ivM;
    private CustomMessageListener ivN;
    private final View.OnClickListener ivO;
    private final View.OnClickListener ivP;
    private CustomMessageListener ivQ;
    private f.a ivR;
    private Animation.AnimationListener ivS;
    private com.baidu.afd.videopaster.d ivy;
    private View ivz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cuI() {
        if (this.abK != null && this.ivF) {
            try {
                this.abK.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int QT = com.baidu.tieba.play.n.dBQ().QT(this.mVideoUrl);
            if (QT <= 100 || this.abK.getDuration() <= QT) {
                QT = 100;
            }
            this.abQ = QT;
            this.ivL.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuJ() {
        if (this.ivD != null && this.ivD.eMv != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.ivD.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.anD = this.ivD.eMv.getTid();
            oVar.fPy = this.ivD.eMv.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.ivD.eMv.mRecomSource;
            oVar.mDK = this.ivD.eMv.mRecomAbTag;
            oVar.mDG = this.ivD.eMv.mRecomAbTag;
            oVar.mDH = this.ivD.eMv.mRecomWeight;
            oVar.mDI = "";
            oVar.eQd = this.ivD.getExtra();
            if (this.ivD.eMv.brI() != null) {
                oVar.mDL = this.ivD.eMv.brI().video_md5;
            }
            com.baidu.tieba.play.h.a(this.ivD.eMv.brI().video_md5, "", "1", oVar, this.abK.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnK = null;
        this.mSkinType = 3;
        this.ivE = 0;
        this.fWv = 1;
        this.ivF = false;
        this.ivG = true;
        this.ivH = false;
        this.abQ = 100;
        this.ivJ = false;
        this.ivL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.cuN();
                        return;
                    case 203:
                        l.this.cuO();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.abK != null) {
                    l.this.abK.setVolume(0.0f, 0.0f);
                }
                l.this.cuI();
            }
        };
        this.eDi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.ivy.d(false, false, "NEWINDEX")) {
                    l.this.abK.start();
                }
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.ivF = false;
                return true;
            }
        };
        this.ivM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.cuI();
            }
        };
        this.fWw = new TbImageView.b() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && l.this.fWo != null) {
                    l.this.fWo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fWy = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.abK != null && !l.this.abK.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.fWz = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.ivN = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.ivD != null && l.this.ivD.eMv != null && videoId.equals(l.this.ivD.eMv.getId())) {
                        l.this.ivy.a(l.this.a(l.this.ivD, bVar));
                    }
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.ivO = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ivD == null) {
                    if (l.this.cuD() != null) {
                        l.this.cuD().a(view, l.this.ivD);
                        return;
                    }
                    return;
                }
                if (view == l.this.hny.getUserName()) {
                    l.this.ivD.objType = 3;
                } else if (view == l.this.hny.getHeaderImg()) {
                    l.this.ivD.objType = 4;
                } else {
                    l.this.ivD.objType = 1;
                }
                if (l.this.cuD() != null) {
                    l.this.cuD().a(view, l.this.ivD);
                }
            }
        };
        this.ivP = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ivD != null) {
                    l.this.ivD.objType = 4;
                }
                if (l.this.cuD() != null) {
                    l.this.cuD().a(view, l.this.ivD);
                }
            }
        };
        this.ivQ = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.ivH = false;
                }
            }
        };
        this.fmS = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ivD != null) {
                    if (l.this.cuD() != null) {
                        l.this.cuD().a(view, l.this.ivD);
                    }
                    if (l.this.ivD.eMv != null && view != l.this.hol.fmZ) {
                        m.Jn(l.this.ivD.eMv.getId());
                        if (!l.this.cuM()) {
                            m.a(l.this.mTextTitle, l.this.ivD.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                            m.a(l.this.ivA.getGodReplyContent(), l.this.ivD.boP().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                        }
                    }
                }
            }
        };
        this.ivR = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void rF() {
                if (l.this.ivD != null && l.this.ivD.eMv != null && l.this.ivD.eMv.brI() != null) {
                    l.this.cuJ();
                }
            }
        };
        this.ivS = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.fWo != null) {
                    l.this.fWo.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eXu = tbPageContext;
        View view = getView();
        this.hnx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ivB = (HeadPendantClickableView) this.hnx.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.ivB.getHeadView() != null) {
            this.ivB.getHeadView().setIsRound(true);
            this.ivB.getHeadView().setDrawBorder(false);
            this.ivB.getHeadView().setDefaultResource(17170445);
            this.ivB.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.ds70));
            this.ivB.getHeadView().setPlaceHolder(1);
        }
        this.ivB.setHasPendantStyle();
        if (this.ivB.getPendantView() != null) {
            this.ivB.getPendantView().setIsRound(true);
            this.ivB.getPendantView().setDrawBorder(false);
        }
        this.fWs = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fWs.setLoadingAnimationListener(this.ivM);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hny = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hnK = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.hnK.a(this.hnx, dimens, 0);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.hnz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnz.setLayoutParams(layoutParams);
        }
        this.hnz.setOnClickListener(this);
        this.hnz.setReplyTimeVisible(false);
        this.hnz.setShowPraiseNum(true);
        this.hnz.setNeedAddPraiseIcon(true);
        this.hnz.setNeedAddReplyIcon(true);
        this.hnz.setShareVisible(true);
        this.hnz.setShareReportFrom(3);
        this.hnz.setForumAfterClickListener(this.fmS);
        this.hnz.setFrom(1);
        this.hol = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hol.fnK.setOnClickListener(this);
        this.hol.setFrom(1);
        this.hol.setShareReportFrom(3);
        this.hol.setForumAfterClickListener(this.fmS);
        this.ivz = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fWm = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fWm.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eXu.getPageActivity()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fWm.setLayoutParams(layoutParams2);
        this.fWo = (TbImageView) view.findViewById(R.id.image_video);
        this.fWo.setPlaceHolder(3);
        this.fWo.setGifIconSupport(false);
        this.fWo.setEvent(this.fWw);
        this.fWo.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fWo;
        TbImageView tbImageView2 = this.fWo;
        tbImageView.setConrers(15);
        this.fWo.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fWo.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.fWo.setBorderSurroundContent(true);
        this.fWo.setDrawBorder(true);
        this.fWp = (ImageView) view.findViewById(R.id.image_video_play);
        this.hnx.setOnClickListener(this);
        this.abK = new TbCyberVideoView(getContext());
        this.abK.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fWm.addView(this.abK.getView(), 0);
        this.abK.getView().setLayoutParams(layoutParams3);
        this.abK.setContinuePlayEnable(true);
        this.abK.setOnPreparedListener(this.eDf);
        this.abK.setOnInfoListener(this.eDi);
        this.abK.setOnCompletionListener(this.eDh);
        this.abK.setOnErrorListener(this.eDg);
        this.abK.setOnSurfaceDestroyedListener(this.fWA);
        this.gBV = new com.baidu.tieba.play.f();
        this.gBV.setPlayer(this.abK);
        this.gBV.a(this.ivR);
        this.fWn = (TextView) view.findViewById(R.id.text_video_duration);
        this.ivC = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fWu = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fWt = view.findViewById(R.id.auto_video_black_mask);
        this.fWq = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fWr = view.findViewById(R.id.auto_video_error_background);
        this.gpU = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.ciC = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.ciC.setAnimationListener(this.ivS);
        this.ivA = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.ivA.setOnClickListener(this);
        this.ghM = view.findViewById(R.id.divider_line);
        this.ivI = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.abK.getView().setOnClickListener(this);
        this.ivK = (TextView) view.findViewById(R.id.nani_video_icon);
        this.ivy = new com.baidu.afd.videopaster.d(getContext(), this.fWm);
        this.ivy.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void ru() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rt() {
                if (!l.this.ivJ) {
                    l.this.abK.start();
                } else {
                    l.this.startPlay();
                }
                l.this.ivJ = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rv() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.ivD != null && this.ivD.eMv != null && this.ivD.eMv.eVz > 0) {
            if (cuD() != null) {
                cuD().a(view, this.ivD);
            }
            this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eXu.getPageActivity(), this.ivD.eMv.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.brd(), this.ivD.boS())));
            return;
        }
        if (view == this.hnx || view == this.ivA) {
            cO(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.abK.getView()) {
            if (this.ivD != null) {
                this.ivD.objType = 5;
            }
            if (this.ivD != null && this.ivD.eMv != null && this.ivD.eMv.brI() != null) {
                z = this.ivD.eMv.brI().is_vertical.intValue() == 1;
            }
            if (z) {
                cM(this.abK.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cN(this.abK.getView());
            } else {
                cO(getView());
            }
        }
    }

    private void cM(View view) {
        if (cuD() != null) {
            cuD().a(view, this.ivD);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eXu.getPageActivity(), R.string.no_network_guide);
        } else {
            cuK();
        }
    }

    private void cN(View view) {
        if (cuD() != null) {
            cuD().a(view, this.ivD);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eXu.getPageActivity(), R.string.no_network_guide);
        } else {
            cuL();
        }
    }

    private void cuK() {
        if (this.ivD != null && this.ivD.eMv != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ivD.eMv);
            videoItemData.mRecomExtra = this.ivD.getExtra();
            videoItemData.mRecomAbTag = this.ivD.cvo();
            videoItemData.mRecomSource = this.ivD.getSource();
            videoItemData.mRecomWeight = this.ivD.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.ivD.boS(), "index");
            if (this.ivD.eMv.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.ivD.eMv.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cuL() {
        if (this.ivD != null && this.ivD.eMv != null && this.ivD.eMv.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ivD.eMv);
            videoSerializeVideoThreadInfo.source = this.ivD.getSource();
            videoSerializeVideoThreadInfo.extra = this.ivD.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.ivD.cvo();
            videoSerializeVideoThreadInfo.weight = this.ivD.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.gpU.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.gpU.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eXu.getPageActivity(), str, this.ivD.eMv.getTid(), m.brd(), this.ivD.boS(), videoSerializeVideoThreadInfo);
            if (this.ivD.boP() != null && this.ivD.boP().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.ivD.boP().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cO(View view) {
        if (this.ivD != null) {
            this.ivD.objType = 1;
        }
        if (cuD() != null) {
            cuD().a(view, this.ivD);
        }
        if (this.ivD != null && this.ivD.eMv != null) {
            if (!cuM()) {
                m.Jn(this.ivD.eMv.getId());
                m.a(this.mTextTitle, this.ivD.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eXu.getPageActivity()).createFromThreadCfg(this.ivD.eMv, null, m.brd(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.ivD.boS());
            addLocateParam.setVideo_source(this.ivD.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.ivD.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.ivD.eMv.getFid()));
            addLocateParam.setForumName(this.ivD.eMv.brv());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ivA) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuM() {
        return this.ivD.izU && !this.ivD.izZ;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.ivD = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuN() {
        this.ivL.removeMessages(202);
        if (this.abK.getCurrentPositionSync() > this.abQ) {
            v(false, 3);
            this.ivL.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.ivL.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuO() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ivL.removeMessages(203);
        int currentPositionSync = this.abK.getCurrentPositionSync();
        if (currentPositionSync != this.ivE) {
            this.ivE = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.ivL.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fWp != null && this.fWo != null && this.fWt != null && this.fWs != null && this.fWr != null && this.fWq != null) {
            if (z || this.fWv != i) {
                this.fWv = i;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWz);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWy);
                if (i == 2) {
                    this.fWp.setVisibility(8);
                    this.ciC.cancel();
                    this.fWo.clearAnimation();
                    this.fWo.setVisibility(0);
                    this.fWt.setVisibility(0);
                    this.ivC.setVisibility(0);
                    this.ivI.setVisibility(8);
                    this.fWs.startLoading();
                    this.fWr.setVisibility(8);
                    this.fWq.setVisibility(8);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fWz, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fWp.setVisibility(8);
                    this.fWo.startAnimation(this.ciC);
                    this.fWt.setVisibility(8);
                    this.ivC.setVisibility(8);
                    if (this.ivD != null && this.ivD.boP() != null && this.ivD.boP().eVz > 0) {
                        this.ivI.setVisibility(0);
                    }
                    this.fWs.dBL();
                    this.fWr.setVisibility(8);
                    this.fWq.setVisibility(8);
                    if (this.ivD != null && this.ivD.eMv != null && this.ivD.eMv.brI() != null) {
                        this.ivD.eMv.brI().video_length.intValue();
                        this.ivD.eMv.brI().video_duration.intValue();
                        this.ivD.eMv.getTid();
                    }
                } else if (i == 4) {
                    this.fWp.setVisibility(8);
                    this.fWo.startAnimation(this.ciC);
                    this.fWt.setVisibility(8);
                    this.fWs.dBM();
                    this.fWr.setVisibility(0);
                    this.fWq.setVisibility(0);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fWy, 2000L);
                } else {
                    this.fWp.setVisibility(0);
                    this.ciC.cancel();
                    this.fWo.clearAnimation();
                    this.fWo.setVisibility(0);
                    this.fWt.setVisibility(0);
                    this.ivC.setVisibility(0);
                    this.fWs.dBM();
                    this.fWr.setVisibility(8);
                    this.fWq.setVisibility(8);
                }
                if (this.ivD != null && this.ivD.boP() != null && this.ivD.boP().eVz > 0) {
                    this.ivC.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ivD == null || this.ivD.eMv == null || this.ivD.eMv.brr() == null) {
            this.hnx.setVisibility(8);
            return;
        }
        this.hnx.setVisibility(0);
        cuQ();
        if (!cuM() && m.Jo(this.ivD.eMv.getId())) {
            m.a(this.mTextTitle, this.ivD.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.ivA.getGodReplyContent(), this.ivD.boP().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        this.ivD.boP().bsr();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ivD.boP().bsa());
        if (this.ivD.boP().bsh() && !StringUtils.isNull(this.ivD.boP().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bvr().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ivD.boP().getTid();
            spannableStringBuilder.append((CharSequence) this.ivD.boP().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dX("obj_source", "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.hny.setData(this.ivD.boP());
        this.hny.setUserAfterClickListener(this.ivO);
        if (this.hny.getHeaderImg() != null) {
            this.hny.getHeaderImg().setAfterClickListener(this.ivP);
            if (this.hny.getIsSimpleThread()) {
                this.hny.getHeaderImg().setVisibility(8);
                this.ivB.setVisibility(8);
            } else if (this.ivD.boP() == null || this.ivD.boP().brr() == null || this.ivD.boP().brr().getPendantData() == null || StringUtils.isNull(this.ivD.boP().brr().getPendantData().getImgUrl())) {
                this.ivB.setVisibility(8);
                this.hny.getHeaderImg().setVisibility(0);
                if (this.ivD.boP().eVz > 0 && this.ivD.boP().eVA == 0) {
                    this.ivD.boP().brr().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.hny.getHeaderImg().setData(this.ivD.boP(), false);
                } else {
                    this.hny.getHeaderImg().setData(this.ivD.boP());
                    this.hny.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.hny.getHeaderImg().setVisibility(4);
                this.ivB.setVisibility(0);
                this.ivB.setData(this.ivD.boP());
            }
        }
        this.fWn.setText(at.stringForVideoTime(this.ivD.eMv.brI().video_duration.intValue() * 1000));
        this.fWu.setText(String.format(this.eXu.getResources().getString(R.string.play_count), at.numFormatOverWan(this.ivD.eMv.brI().play_count.intValue())));
        if (this.hnK != null && this.ivD.boP() != null) {
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setTid(this.ivD.boP().getTid());
            atVar.setFid(this.ivD.boP().getFid());
            atVar.setNid(this.ivD.boP().bpP());
            atVar.setFeedBackReasonMap(this.ivD.feedBackReasonMap);
            this.hnK.setData(atVar);
            this.hnK.setFirstRowSingleColumn(true);
            this.hnK.setVisibility(this.ivG ? 0 : 8);
        }
        this.ivA.setData(this.ivD.boP().bsX());
        wv(ux(1));
        onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        if (m.Jo(this.ivD.eMv.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.ivD == null || this.ivD.eMv == null || this.ivD.eMv.brI() == null) {
            z = false;
        } else {
            z = this.ivD.eMv.brI().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ivK.setVisibility(0);
            if (cuR()) {
                this.ivK.setText(String.format("%s | %s", this.eXu.getResources().getString(R.string.nani_video), this.eXu.getResources().getString(R.string.video_preview)));
            } else {
                this.ivK.setText(this.eXu.getString(R.string.nani_video));
            }
        } else if (cuR()) {
            this.ivK.setVisibility(0);
            this.ivK.setText(this.eXu.getString(R.string.video_preview));
        } else {
            this.ivK.setVisibility(8);
        }
    }

    private void cuP() {
        this.ivL.removeMessages(202);
        this.ivL.removeMessages(203);
    }

    private void bKH() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWy);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWz);
    }

    private void cuQ() {
        bKH();
        cuP();
        if (this.fWo != null && this.fWm != null && this.abK != null) {
            if (com.baidu.tbadk.core.k.bov().isShowImages() && this.ivD != null && this.ivD.eMv != null && this.ivD.eMv.brI() != null) {
                this.fWo.setPlaceHolder(3);
                this.fWo.startLoad(this.ivD.eMv.brI().thumbnail_url, 10, false);
                this.fWm.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.ivD.eMv.brI().video_url;
                if (cuR()) {
                    this.mVideoUrl = this.ivD.eMv.brJ().video_url;
                }
                if (StringUtils.isNull(this.ivD.eMv.brI().video_url)) {
                    v(true, 4);
                }
                this.abK.setThreadDataForStatistic(this.ivD.eMv);
            } else {
                this.fWm.setVisibility(8);
            }
            this.ivy.reset();
            this.gBV.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void ch(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.ivy.d(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.ivD);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.eMv != null) {
            bz bzVar = lVar.eMv;
            if (bzVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bzVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (lVar == null || lVar.eMv == null || bVar == null) {
            return null;
        }
        bz bzVar = lVar.eMv;
        int rz = bVar.rz();
        int rA = bVar.rA();
        int ry = bVar.ry();
        if (ry != -1) {
            i2 = rz != -1 ? (ry - rz) - 1 : -1;
            i = rA != -1 ? (rA - ry) - 1 : -1;
        } else {
            i = -1;
            i2 = -1;
        }
        VideoInfo brI = bzVar.brI();
        if (brI != null) {
            i4 = brI.video_width.intValue();
            i3 = brI.video_height.intValue();
        } else {
            i3 = 0;
            i4 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bzVar.getId());
        hashMap.put("video_title", bzVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bzVar.getFid()));
        hashMap.put("forum_name", bzVar.brv());
        hashMap.put("up_distance", String.valueOf(i2));
        hashMap.put("down_distance", String.valueOf(i));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", ry + 1, i4, i3);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hnx, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.fWp, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.fWq, R.color.CAM_X0101);
            ao.setViewTextColor(this.fWn, R.color.CAM_X0101);
            ao.setViewTextColor(this.fWu, R.color.CAM_X0101);
            ao.setViewTextColor(this.ivI, R.color.CAM_X0101);
            ao.setBackgroundColor(this.fWr, R.color.common_color_10014);
            ao.setBackgroundColor(this.ghM, R.color.CAM_X0204);
            if (this.ivK != null) {
                ao.setViewTextColor(this.ivK, R.color.CAM_X0101);
                ao.setBackgroundResource(this.ivK, R.drawable.video_play_count_bg);
            }
            if (this.fWq != null) {
                this.fWq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ivA.onChangeSkinType();
            if (this.hnK != null) {
                this.hnK.onChangeSkinType();
            }
            this.hny.onChangeSkinType();
            this.hnz.onChangeSkinType();
            this.hol.onChangeSkinType();
            this.fWo.setPlaceHolder(3);
            this.ivB.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ivQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ivQ);
            this.ivN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ivN);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hny != null) {
            this.hny.setPageUniqueId(bdUniqueId);
        }
        if (this.fWo != null) {
            this.fWo.setPageId(bdUniqueId);
        }
        if (this.hnK != null) {
            this.hnK.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.ivF;
    }

    public boolean isPlaying() {
        if (this.abK == null) {
            return false;
        }
        return this.abK.isPlaying();
    }

    public void startPlay() {
        if (!this.ivF && this.ivD != null && this.ivD.eMv != null && this.ivD.eMv.brI() != null && this.abK != null) {
            if (this.ivy.re()) {
                this.ivy.resume();
                this.ivJ = true;
                return;
            }
            this.ivJ = false;
            this.abK.stopPlayback();
            if (ah.aK(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dX("obj_locate", "index").dX("tid", this.ivD.tid));
                    this.mVideoUrl = this.ivD.eMv.brI().video_url;
                }
                this.ivF = true;
                this.abK.setVideoPath(this.mVideoUrl, this.ivD.tid);
                if (this.gBV != null) {
                    this.gBV.start();
                }
                cuJ();
            }
        }
    }

    public void stopPlay() {
        this.ivJ = false;
        bKH();
        cuP();
        v(true, 1);
        if (this.abK != null) {
            this.abK.stopPlayback();
            if (this.gBV != null) {
                this.gBV.stop();
            }
        }
        this.ivF = false;
        this.ivy.stop();
    }

    public View getVideoContainer() {
        return this.fWm;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abK == null) {
            return 0;
        }
        return this.abK.getCurrentPosition();
    }

    public void po(boolean z) {
        this.ivG = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void wv(int i) {
        if (this.ivD != null && this.ivD.eMv != null) {
            if (i == 1) {
                if (this.ivD.eMv.eVz > 0) {
                    this.hol.fnK.setShowPraiseNum(false);
                    this.hol.fnK.setShareVisible(false);
                    this.ivI.setText(at.numFormatOverWan(this.ivD.eMv.eVz));
                    this.ivI.setVisibility(0);
                } else {
                    this.hol.fnK.setShowPraiseNum(true);
                    this.hol.fnK.setShareVisible(true);
                    this.ivI.setVisibility(8);
                }
                this.hol.setData(this.ivD.eMv);
                this.hnz.setVisibility(8);
                this.hny.kg(false);
                return;
            }
            this.hol.setVisibility(8);
            this.hny.kg(true);
            if (this.ivD.eMv.eVz > 0) {
                this.hnz.setShowPraiseNum(false);
                this.hnz.setShareVisible(false);
                this.ivI.setText(at.numFormatOverWan(this.ivD.eMv.eVz));
                this.ivI.setVisibility(0);
            } else {
                this.hnz.setShowPraiseNum(true);
                this.hnz.setShareVisible(true);
                this.ivI.setVisibility(8);
            }
            if (this.hnz.setData(this.ivD.eMv)) {
                this.ivz.setVisibility(8);
            } else {
                this.ivz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public int ux(int i) {
        return com.baidu.tieba.a.d.bOn().az(this.aji, i);
    }

    private boolean cuR() {
        return (this.ivD == null || this.ivD.eMv == null || this.ivD.eMv.brJ() == null || TextUtils.isEmpty(this.ivD.eMv.brJ().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.ivy.onDestroy();
    }
}
