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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ak;
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
    private TbCyberVideoView abD;
    private int abJ;
    private String aif;
    private Animation chX;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnErrorListener eAB;
    private CyberPlayerManager.OnCompletionListener eAC;
    private CyberPlayerManager.OnInfoListener eAD;
    private TbPageContext<?> eUY;
    public FrameLayout fTU;
    private TextView fTV;
    private TbImageView fTW;
    private ImageView fTX;
    private TextView fTY;
    private View fTZ;
    private com.baidu.tieba.play.m fUa;
    private View fUb;
    private TextView fUc;
    private int fUd;
    private TbImageView.b fUe;
    private Runnable fUg;
    private Runnable fUh;
    private TbCyberVideoView.a fUi;
    private final View.OnClickListener fkz;
    private com.baidu.tieba.play.f gAm;
    private View gfy;
    protected LinearLayout goh;
    private NEGFeedBackView hnF;
    private RelativeLayout hns;
    public ThreadUserInfoLayout hnt;
    public ThreadCommentAndPraiseInfoLayout hnu;
    public ThreadSourceShareAndPraiseLayout hog;
    private com.baidu.afd.videopaster.d iwJ;
    private View iwK;
    public ThreadGodReplyLayout iwL;
    private HeadPendantClickableView iwM;
    private LinearLayout iwN;
    private com.baidu.tieba.card.data.l iwO;
    private int iwP;
    private boolean iwQ;
    private boolean iwR;
    private boolean iwS;
    private TextView iwT;
    private boolean iwU;
    private TextView iwV;
    private Handler iwW;
    private VideoLoadingProgressView.a iwX;
    private CustomMessageListener iwY;
    private final View.OnClickListener iwZ;
    private final View.OnClickListener ixa;
    private CustomMessageListener ixb;
    private f.a ixc;
    private Animation.AnimationListener ixd;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void csh() {
        if (this.abD != null && this.iwQ) {
            try {
                this.abD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int QE = com.baidu.tieba.play.n.dAn().QE(this.mVideoUrl);
            if (QE <= 100 || this.abD.getDuration() <= QE) {
                QE = 100;
            }
            this.abJ = QE;
            this.iwW.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csi() {
        if (this.iwO != null && this.iwO.eJQ != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.iwO.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.amC = this.iwO.eJQ.getTid();
            oVar.fNd = this.iwO.eJQ.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.iwO.eJQ.mRecomSource;
            oVar.mIz = this.iwO.eJQ.mRecomAbTag;
            oVar.mIv = this.iwO.eJQ.mRecomAbTag;
            oVar.mIw = this.iwO.eJQ.mRecomWeight;
            oVar.mIx = "";
            oVar.eNE = this.iwO.getExtra();
            if (this.iwO.eJQ.boh() != null) {
                oVar.mIA = this.iwO.eJQ.boh().video_md5;
            }
            com.baidu.tieba.play.h.a(this.iwO.eJQ.boh().video_md5, "", "1", oVar, this.abD.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnF = null;
        this.mSkinType = 3;
        this.iwP = 0;
        this.fUd = 1;
        this.iwQ = false;
        this.iwR = true;
        this.iwS = false;
        this.abJ = 100;
        this.iwU = false;
        this.iwW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.csm();
                        return;
                    case 203:
                        l.this.csn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.abD != null) {
                    l.this.abD.setVolume(0.0f, 0.0f);
                }
                l.this.csh();
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.iwJ.d(false, false, "NEWINDEX")) {
                    l.this.abD.start();
                }
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.iwQ = false;
                return true;
            }
        };
        this.iwX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.csh();
            }
        };
        this.fUe = new TbImageView.b() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && l.this.fTW != null) {
                    l.this.fTW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.abD != null && !l.this.abD.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.fUh = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.iwY = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.iwO != null && l.this.iwO.eJQ != null && videoId.equals(l.this.iwO.eJQ.getId())) {
                        l.this.iwJ.a(l.this.a(l.this.iwO, bVar));
                    }
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.iwZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iwO == null) {
                    if (l.this.csc() != null) {
                        l.this.csc().a(view, l.this.iwO);
                        return;
                    }
                    return;
                }
                if (view == l.this.hnt.getUserName()) {
                    l.this.iwO.objType = 3;
                } else if (view == l.this.hnt.getHeaderImg()) {
                    l.this.iwO.objType = 4;
                } else {
                    l.this.iwO.objType = 1;
                }
                if (l.this.csc() != null) {
                    l.this.csc().a(view, l.this.iwO);
                }
            }
        };
        this.ixa = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iwO != null) {
                    l.this.iwO.objType = 4;
                }
                if (l.this.csc() != null) {
                    l.this.csc().a(view, l.this.iwO);
                }
            }
        };
        this.ixb = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.iwS = false;
                }
            }
        };
        this.fkz = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iwO != null) {
                    if (l.this.csc() != null) {
                        l.this.csc().a(view, l.this.iwO);
                    }
                    if (l.this.iwO.eJQ != null && view != l.this.hog.fkH) {
                        m.IN(l.this.iwO.eJQ.getId());
                        if (!l.this.csl()) {
                            m.a(l.this.mTextTitle, l.this.iwO.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                            m.a(l.this.iwL.getGodReplyContent(), l.this.iwO.bln().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                        }
                    }
                }
            }
        };
        this.ixc = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void rD() {
                if (l.this.iwO != null && l.this.iwO.eJQ != null && l.this.iwO.eJQ.boh() != null) {
                    l.this.csi();
                }
            }
        };
        this.ixd = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.fTW != null) {
                    l.this.fTW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eUY = tbPageContext;
        View view = getView();
        this.hns = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.iwM = (HeadPendantClickableView) this.hns.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.iwM.getHeadView() != null) {
            this.iwM.getHeadView().setIsRound(true);
            this.iwM.getHeadView().setDrawBorder(false);
            this.iwM.getHeadView().setDefaultResource(17170445);
            this.iwM.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.ds70));
            this.iwM.getHeadView().setPlaceHolder(1);
        }
        this.iwM.setHasPendantStyle();
        if (this.iwM.getPendantView() != null) {
            this.iwM.getPendantView().setIsRound(true);
            this.iwM.getPendantView().setDrawBorder(false);
        }
        this.fUa = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fUa.setLoadingAnimationListener(this.iwX);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hnt = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hnF = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.hnF.a(this.hns, dimens, 0);
        this.hnu = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.hnu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnu.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnu.setLayoutParams(layoutParams);
        }
        this.hnu.setOnClickListener(this);
        this.hnu.setReplyTimeVisible(false);
        this.hnu.setShowPraiseNum(true);
        this.hnu.setNeedAddPraiseIcon(true);
        this.hnu.setNeedAddReplyIcon(true);
        this.hnu.setShareVisible(true);
        this.hnu.setShareReportFrom(3);
        this.hnu.setForumAfterClickListener(this.fkz);
        this.hnu.setFrom(1);
        this.hog = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hog.fls.setOnClickListener(this);
        this.hog.setFrom(1);
        this.hog.setShareReportFrom(3);
        this.hog.setForumAfterClickListener(this.fkz);
        this.iwK = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fTU = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fTU.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eUY.getPageActivity()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fTU.setLayoutParams(layoutParams2);
        this.fTW = (TbImageView) view.findViewById(R.id.image_video);
        this.fTW.setPlaceHolder(3);
        this.fTW.setGifIconSupport(false);
        this.fTW.setEvent(this.fUe);
        this.fTW.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fTW;
        TbImageView tbImageView2 = this.fTW;
        tbImageView.setConrers(15);
        this.fTW.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fTW.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fTW.setBorderSurroundContent(true);
        this.fTW.setDrawBorder(true);
        this.fTX = (ImageView) view.findViewById(R.id.image_video_play);
        this.hns.setOnClickListener(this);
        this.abD = new TbCyberVideoView(getContext());
        this.abD.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fTU.addView(this.abD.getView(), 0);
        this.abD.getView().setLayoutParams(layoutParams3);
        this.abD.setContinuePlayEnable(true);
        this.abD.setOnPreparedListener(this.eAA);
        this.abD.setOnInfoListener(this.eAD);
        this.abD.setOnCompletionListener(this.eAC);
        this.abD.setOnErrorListener(this.eAB);
        this.abD.setOnSurfaceDestroyedListener(this.fUi);
        this.gAm = new com.baidu.tieba.play.f();
        this.gAm.setPlayer(this.abD);
        this.gAm.a(this.ixc);
        this.fTV = (TextView) view.findViewById(R.id.text_video_duration);
        this.iwN = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fUc = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fUb = view.findViewById(R.id.auto_video_black_mask);
        this.fTY = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fTZ = view.findViewById(R.id.auto_video_error_background);
        this.goh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.chX = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.chX.setAnimationListener(this.ixd);
        this.iwL = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.iwL.setOnClickListener(this);
        this.gfy = view.findViewById(R.id.divider_line);
        this.iwT = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.abD.getView().setOnClickListener(this);
        this.iwV = (TextView) view.findViewById(R.id.nani_video_icon);
        this.iwJ = new com.baidu.afd.videopaster.d(getContext(), this.fTU);
        this.iwJ.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rr() {
                if (!l.this.iwU) {
                    l.this.abD.start();
                } else {
                    l.this.startPlay();
                }
                l.this.iwU = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rq() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rt() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.iwO != null && this.iwO.eJQ != null && this.iwO.eJQ.eTa > 0) {
            if (csc() != null) {
                csc().a(view, this.iwO);
            }
            this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eUY.getPageActivity(), this.iwO.eJQ.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.bnC(), this.iwO.blq())));
            return;
        }
        if (view == this.hns || view == this.iwL) {
            cM(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.abD.getView()) {
            if (this.iwO != null) {
                this.iwO.objType = 5;
            }
            if (this.iwO != null && this.iwO.eJQ != null && this.iwO.eJQ.boh() != null) {
                z = this.iwO.eJQ.boh().is_vertical.intValue() == 1;
            }
            if (z) {
                cK(this.abD.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cL(this.abD.getView());
            } else {
                cM(getView());
            }
        }
    }

    private void cK(View view) {
        if (csc() != null) {
            csc().a(view, this.iwO);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.no_network_guide);
        } else {
            csj();
        }
    }

    private void cL(View view) {
        if (csc() != null) {
            csc().a(view, this.iwO);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.no_network_guide);
        } else {
            csk();
        }
    }

    private void csj() {
        if (this.iwO != null && this.iwO.eJQ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.iwO.eJQ);
            videoItemData.mRecomExtra = this.iwO.getExtra();
            videoItemData.mRecomAbTag = this.iwO.csP();
            videoItemData.mRecomSource = this.iwO.getSource();
            videoItemData.mRecomWeight = this.iwO.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.iwO.blq(), "index");
            if (this.iwO.eJQ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.iwO.eJQ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void csk() {
        if (this.iwO != null && this.iwO.eJQ != null && this.iwO.eJQ.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.iwO.eJQ);
            videoSerializeVideoThreadInfo.source = this.iwO.getSource();
            videoSerializeVideoThreadInfo.extra = this.iwO.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.iwO.csP();
            videoSerializeVideoThreadInfo.weight = this.iwO.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.goh.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.goh.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!au.isEmpty(this.mFrom) && this.mFrom.equals("hottopic")) {
                str = "hottopic";
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eUY.getPageActivity(), str, this.iwO.eJQ.getTid(), m.bnC(), this.iwO.blq(), videoSerializeVideoThreadInfo);
            if (this.iwO.bln() != null && this.iwO.bln().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.iwO.bln().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cM(View view) {
        if (this.iwO != null) {
            this.iwO.objType = 1;
        }
        if (csc() != null) {
            csc().a(view, this.iwO);
        }
        if (this.iwO != null && this.iwO.eJQ != null) {
            if (!csl()) {
                m.IN(this.iwO.eJQ.getId());
                m.a(this.mTextTitle, this.iwO.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eUY.getPageActivity()).createFromThreadCfg(this.iwO.eJQ, null, m.bnC(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.iwO.blq());
            addLocateParam.setVideo_source(this.iwO.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.iwO.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.iwO.eJQ.getFid()));
            addLocateParam.setForumName(this.iwO.eJQ.bnU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.iwL) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csl() {
        return this.iwO.iBl && !this.iwO.iBq;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.iwO = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csm() {
        this.iwW.removeMessages(202);
        if (this.abD.getCurrentPositionSync() > this.abJ) {
            v(false, 3);
            this.iwW.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.iwW.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.iwW.removeMessages(203);
        int currentPositionSync = this.abD.getCurrentPositionSync();
        if (currentPositionSync != this.iwP) {
            this.iwP = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.iwW.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fTX != null && this.fTW != null && this.fUb != null && this.fUa != null && this.fTZ != null && this.fTY != null) {
            if (z || this.fUd != i) {
                this.fUd = i;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUh);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUg);
                if (i == 2) {
                    this.fTX.setVisibility(8);
                    this.chX.cancel();
                    this.fTW.clearAnimation();
                    this.fTW.setVisibility(0);
                    this.fUb.setVisibility(0);
                    this.iwN.setVisibility(0);
                    this.iwT.setVisibility(8);
                    this.fUa.startLoading();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fUh, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fTX.setVisibility(8);
                    this.fTW.startAnimation(this.chX);
                    this.fUb.setVisibility(8);
                    this.iwN.setVisibility(8);
                    if (this.iwO != null && this.iwO.bln() != null && this.iwO.bln().eTa > 0) {
                        this.iwT.setVisibility(0);
                    }
                    this.fUa.dAi();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                    if (this.iwO != null && this.iwO.eJQ != null && this.iwO.eJQ.boh() != null) {
                        this.iwO.eJQ.boh().video_length.intValue();
                        this.iwO.eJQ.boh().video_duration.intValue();
                        this.iwO.eJQ.getTid();
                    }
                } else if (i == 4) {
                    this.fTX.setVisibility(8);
                    this.fTW.startAnimation(this.chX);
                    this.fUb.setVisibility(8);
                    this.fUa.dAj();
                    this.fTZ.setVisibility(0);
                    this.fTY.setVisibility(0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fUg, 2000L);
                } else {
                    this.fTX.setVisibility(0);
                    this.chX.cancel();
                    this.fTW.clearAnimation();
                    this.fTW.setVisibility(0);
                    this.fUb.setVisibility(0);
                    this.iwN.setVisibility(0);
                    this.fUa.dAj();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                }
                if (this.iwO != null && this.iwO.bln() != null && this.iwO.bln().eTa > 0) {
                    this.iwN.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.iwO == null || this.iwO.eJQ == null || this.iwO.eJQ.bnQ() == null) {
            this.hns.setVisibility(8);
            return;
        }
        this.hns.setVisibility(0);
        csp();
        if (!csl() && m.IO(this.iwO.eJQ.getId())) {
            m.a(this.mTextTitle, this.iwO.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iwL.getGodReplyContent(), this.iwO.bln().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        this.iwO.bln().boP();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.iwO.bln().boz());
        if (this.iwO.bln().boF() && !StringUtils.isNull(this.iwO.bln().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.iwO.bln().getTid();
            spannableStringBuilder.append((CharSequence) this.iwO.bln().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ar("c12841").dR("obj_source", "0"));
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
        this.hnt.setData(this.iwO.bln());
        this.hnt.setUserAfterClickListener(this.iwZ);
        if (this.hnt.getHeaderImg() != null) {
            this.hnt.getHeaderImg().setAfterClickListener(this.ixa);
            if (this.hnt.getIsSimpleThread()) {
                this.hnt.getHeaderImg().setVisibility(8);
                this.iwM.setVisibility(8);
            } else if (this.iwO.bln() == null || this.iwO.bln().bnQ() == null || this.iwO.bln().bnQ().getPendantData() == null || StringUtils.isNull(this.iwO.bln().bnQ().getPendantData().getImgUrl())) {
                this.iwM.setVisibility(8);
                this.hnt.getHeaderImg().setVisibility(0);
                if (this.iwO.bln().eTa > 0 && this.iwO.bln().eTb == 0) {
                    this.iwO.bln().bnQ().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.hnt.getHeaderImg().setData(this.iwO.bln(), false);
                } else {
                    this.hnt.getHeaderImg().setData(this.iwO.bln());
                    this.hnt.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.hnt.getHeaderImg().setVisibility(4);
                this.iwM.setVisibility(0);
                this.iwM.setData(this.iwO.bln());
            }
        }
        this.fTV.setText(au.stringForVideoTime(this.iwO.eJQ.boh().video_duration.intValue() * 1000));
        this.fUc.setText(String.format(this.eUY.getResources().getString(R.string.play_count), au.numFormatOverWan(this.iwO.eJQ.boh().play_count.intValue())));
        if (this.hnF != null && this.iwO.bln() != null) {
            av avVar = new av();
            avVar.setTid(this.iwO.bln().getTid());
            avVar.setFid(this.iwO.bln().getFid());
            avVar.setNid(this.iwO.bln().bmo());
            avVar.setFeedBackReasonMap(this.iwO.feedBackReasonMap);
            this.hnF.setData(avVar);
            this.hnF.setFirstRowSingleColumn(true);
            this.hnF.setVisibility(this.iwR ? 0 : 8);
        }
        this.iwL.setData(this.iwO.bln().bpv());
        uZ(sW(1));
        onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        if (m.IO(this.iwO.eJQ.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.iwO == null || this.iwO.eJQ == null || this.iwO.eJQ.boh() == null) {
            z = false;
        } else {
            z = this.iwO.eJQ.boh().is_vertical.intValue() == 1;
        }
        if (z) {
            this.iwV.setVisibility(0);
            if (csq()) {
                this.iwV.setText(String.format("%s | %s", this.eUY.getResources().getString(R.string.nani_video), this.eUY.getResources().getString(R.string.video_preview)));
            } else {
                this.iwV.setText(this.eUY.getString(R.string.nani_video));
            }
        } else if (csq()) {
            this.iwV.setVisibility(0);
            this.iwV.setText(this.eUY.getString(R.string.video_preview));
        } else {
            this.iwV.setVisibility(8);
        }
    }

    private void cso() {
        this.iwW.removeMessages(202);
        this.iwW.removeMessages(203);
    }

    private void bHj() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUg);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUh);
    }

    private void csp() {
        bHj();
        cso();
        if (this.fTW != null && this.fTU != null && this.abD != null) {
            if (com.baidu.tbadk.core.k.bkT().isShowImages() && this.iwO != null && this.iwO.eJQ != null && this.iwO.eJQ.boh() != null) {
                this.fTW.setPlaceHolder(3);
                this.fTW.startLoad(this.iwO.eJQ.boh().thumbnail_url, 10, false);
                this.fTU.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.iwO.eJQ.boh().video_url;
                if (csq()) {
                    this.mVideoUrl = this.iwO.eJQ.boi().video_url;
                }
                if (StringUtils.isNull(this.iwO.eJQ.boh().video_url)) {
                    v(true, 4);
                }
                this.abD.setThreadDataForStatistic(this.iwO.eJQ);
            } else {
                this.fTU.setVisibility(8);
            }
            this.iwJ.reset();
            this.gAm.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void cf(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.iwJ.d(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.iwO);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.eJQ != null) {
            cb cbVar = lVar.eJQ;
            if (cbVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, cbVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (lVar == null || lVar.eJQ == null || bVar == null) {
            return null;
        }
        cb cbVar = lVar.eJQ;
        int rx2 = bVar.rx();
        int ry = bVar.ry();
        int rw = bVar.rw();
        if (rw != -1) {
            i2 = rx2 != -1 ? (rw - rx2) - 1 : -1;
            i = ry != -1 ? (ry - rw) - 1 : -1;
        } else {
            i = -1;
            i2 = -1;
        }
        VideoInfo boh = cbVar.boh();
        if (boh != null) {
            i4 = boh.video_width.intValue();
            i3 = boh.video_height.intValue();
        } else {
            i3 = 0;
            i4 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", cbVar.getId());
        hashMap.put("video_title", cbVar.getTitle());
        hashMap.put("forum_id", String.valueOf(cbVar.getFid()));
        hashMap.put("forum_name", cbVar.bnU());
        hashMap.put("up_distance", String.valueOf(i2));
        hashMap.put("down_distance", String.valueOf(i));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rw + 1, i4, i3);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hns, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fTX, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fTY, R.color.CAM_X0101);
            ap.setViewTextColor(this.fTV, R.color.CAM_X0101);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
            ap.setViewTextColor(this.iwT, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fTZ, R.color.common_color_10014);
            ap.setBackgroundColor(this.gfy, R.color.CAM_X0204);
            if (this.iwV != null) {
                ap.setViewTextColor(this.iwV, R.color.CAM_X0101);
                ap.setBackgroundResource(this.iwV, R.drawable.video_play_count_bg);
            }
            if (this.fTY != null) {
                this.fTY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.iwL.onChangeSkinType();
            if (this.hnF != null) {
                this.hnF.onChangeSkinType();
            }
            this.hnt.onChangeSkinType();
            this.hnu.onChangeSkinType();
            this.hog.onChangeSkinType();
            this.fTW.setPlaceHolder(3);
            this.iwM.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ixb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ixb);
            this.iwY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iwY);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hnt != null) {
            this.hnt.setPageUniqueId(bdUniqueId);
        }
        if (this.fTW != null) {
            this.fTW.setPageId(bdUniqueId);
        }
        if (this.hnF != null) {
            this.hnF.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.iwQ;
    }

    public boolean isPlaying() {
        if (this.abD == null) {
            return false;
        }
        return this.abD.isPlaying();
    }

    public void startPlay() {
        if (!this.iwQ && this.iwO != null && this.iwO.eJQ != null && this.iwO.eJQ.boh() != null && this.abD != null) {
            if (this.iwJ.rc()) {
                this.iwJ.resume();
                this.iwU = true;
                return;
            }
            this.iwU = false;
            this.abD.stopPlayback();
            if (ak.aP(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new ar("c12619").dR("obj_locate", "index").dR("tid", this.iwO.tid));
                    this.mVideoUrl = this.iwO.eJQ.boh().video_url;
                }
                this.iwQ = true;
                this.abD.setVideoPath(this.mVideoUrl, this.iwO.tid);
                if (this.gAm != null) {
                    this.gAm.start();
                }
                csi();
            }
        }
    }

    public void stopPlay() {
        this.iwU = false;
        bHj();
        cso();
        v(true, 1);
        if (this.abD != null) {
            this.abD.stopPlayback();
            if (this.gAm != null) {
                this.gAm.stop();
            }
        }
        this.iwQ = false;
        this.iwJ.stop();
    }

    public View getVideoContainer() {
        return this.fTU;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abD == null) {
            return 0;
        }
        return this.abD.getCurrentPosition();
    }

    public void pu(boolean z) {
        this.iwR = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void uZ(int i) {
        if (this.iwO != null && this.iwO.eJQ != null) {
            if (i == 1) {
                if (this.iwO.eJQ.eTa > 0) {
                    this.hog.fls.setShowPraiseNum(false);
                    this.hog.fls.setShareVisible(false);
                    this.iwT.setText(au.numFormatOverWan(this.iwO.eJQ.eTa));
                    this.iwT.setVisibility(0);
                } else {
                    this.hog.fls.setShowPraiseNum(true);
                    this.hog.fls.setShareVisible(true);
                    this.iwT.setVisibility(8);
                }
                this.hog.setData(this.iwO.eJQ);
                this.hnu.setVisibility(8);
                this.hnt.kf(false);
                return;
            }
            this.hog.setVisibility(8);
            this.hnt.kf(true);
            if (this.iwO.eJQ.eTa > 0) {
                this.hnu.setShowPraiseNum(false);
                this.hnu.setShareVisible(false);
                this.iwT.setText(au.numFormatOverWan(this.iwO.eJQ.eTa));
                this.iwT.setVisibility(0);
            } else {
                this.hnu.setShowPraiseNum(true);
                this.hnu.setShareVisible(true);
                this.iwT.setVisibility(8);
            }
            if (this.hnu.setData(this.iwO.eJQ)) {
                this.iwK.setVisibility(8);
            } else {
                this.iwK.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKU().aB(this.aif, i);
    }

    private boolean csq() {
        return (this.iwO == null || this.iwO.eJQ == null || this.iwO.eJQ.boi() == null || TextUtils.isEmpty(this.iwO.eJQ.boi().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.iwJ.onDestroy();
    }
}
