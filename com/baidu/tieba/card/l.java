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
    private View gft;
    protected LinearLayout gnT;
    private com.baidu.tieba.play.f gzY;
    public ThreadSourceShareAndPraiseLayout hnS;
    private RelativeLayout hne;
    public ThreadUserInfoLayout hnf;
    public ThreadCommentAndPraiseInfoLayout hng;
    private NEGFeedBackView hnr;
    private com.baidu.tieba.card.data.l iwA;
    private int iwB;
    private boolean iwC;
    private boolean iwD;
    private boolean iwE;
    private TextView iwF;
    private boolean iwG;
    private TextView iwH;
    private Handler iwI;
    private VideoLoadingProgressView.a iwJ;
    private CustomMessageListener iwK;
    private final View.OnClickListener iwL;
    private final View.OnClickListener iwM;
    private CustomMessageListener iwN;
    private f.a iwO;
    private Animation.AnimationListener iwP;
    private com.baidu.afd.videopaster.d iwv;
    private View iww;
    public ThreadGodReplyLayout iwx;
    private HeadPendantClickableView iwy;
    private LinearLayout iwz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void csa() {
        if (this.abD != null && this.iwC) {
            try {
                this.abD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int QD = com.baidu.tieba.play.n.dAg().QD(this.mVideoUrl);
            if (QD <= 100 || this.abD.getDuration() <= QD) {
                QD = 100;
            }
            this.abJ = QD;
            this.iwI.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csb() {
        if (this.iwA != null && this.iwA.eJQ != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.iwA.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.amC = this.iwA.eJQ.getTid();
            oVar.fNd = this.iwA.eJQ.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.iwA.eJQ.mRecomSource;
            oVar.mIi = this.iwA.eJQ.mRecomAbTag;
            oVar.mIe = this.iwA.eJQ.mRecomAbTag;
            oVar.mIf = this.iwA.eJQ.mRecomWeight;
            oVar.mIg = "";
            oVar.eNE = this.iwA.getExtra();
            if (this.iwA.eJQ.boh() != null) {
                oVar.mIj = this.iwA.eJQ.boh().video_md5;
            }
            com.baidu.tieba.play.h.a(this.iwA.eJQ.boh().video_md5, "", "1", oVar, this.abD.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnr = null;
        this.mSkinType = 3;
        this.iwB = 0;
        this.fUd = 1;
        this.iwC = false;
        this.iwD = true;
        this.iwE = false;
        this.abJ = 100;
        this.iwG = false;
        this.iwI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.csf();
                        return;
                    case 203:
                        l.this.csg();
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
                l.this.csa();
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
                if (!l.this.iwv.d(false, false, "NEWINDEX")) {
                    l.this.abD.start();
                }
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.iwC = false;
                return true;
            }
        };
        this.iwJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.csa();
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
        this.iwK = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.iwA != null && l.this.iwA.eJQ != null && videoId.equals(l.this.iwA.eJQ.getId())) {
                        l.this.iwv.a(l.this.a(l.this.iwA, bVar));
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
        this.iwL = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iwA == null) {
                    if (l.this.crV() != null) {
                        l.this.crV().a(view, l.this.iwA);
                        return;
                    }
                    return;
                }
                if (view == l.this.hnf.getUserName()) {
                    l.this.iwA.objType = 3;
                } else if (view == l.this.hnf.getHeaderImg()) {
                    l.this.iwA.objType = 4;
                } else {
                    l.this.iwA.objType = 1;
                }
                if (l.this.crV() != null) {
                    l.this.crV().a(view, l.this.iwA);
                }
            }
        };
        this.iwM = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iwA != null) {
                    l.this.iwA.objType = 4;
                }
                if (l.this.crV() != null) {
                    l.this.crV().a(view, l.this.iwA);
                }
            }
        };
        this.iwN = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.iwE = false;
                }
            }
        };
        this.fkz = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iwA != null) {
                    if (l.this.crV() != null) {
                        l.this.crV().a(view, l.this.iwA);
                    }
                    if (l.this.iwA.eJQ != null && view != l.this.hnS.fkH) {
                        m.IM(l.this.iwA.eJQ.getId());
                        if (!l.this.cse()) {
                            m.a(l.this.mTextTitle, l.this.iwA.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                            m.a(l.this.iwx.getGodReplyContent(), l.this.iwA.bln().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                        }
                    }
                }
            }
        };
        this.iwO = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void rD() {
                if (l.this.iwA != null && l.this.iwA.eJQ != null && l.this.iwA.eJQ.boh() != null) {
                    l.this.csb();
                }
            }
        };
        this.iwP = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
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
        this.hne = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.iwy = (HeadPendantClickableView) this.hne.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.iwy.getHeadView() != null) {
            this.iwy.getHeadView().setIsRound(true);
            this.iwy.getHeadView().setDrawBorder(false);
            this.iwy.getHeadView().setDefaultResource(17170445);
            this.iwy.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eUY.getPageActivity(), R.dimen.ds70));
            this.iwy.getHeadView().setPlaceHolder(1);
        }
        this.iwy.setHasPendantStyle();
        if (this.iwy.getPendantView() != null) {
            this.iwy.getPendantView().setIsRound(true);
            this.iwy.getPendantView().setDrawBorder(false);
        }
        this.fUa = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fUa.setLoadingAnimationListener(this.iwJ);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hnf = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hnr = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.hnr.a(this.hne, dimens, 0);
        this.hng = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.hng.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hng.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hng.setLayoutParams(layoutParams);
        }
        this.hng.setOnClickListener(this);
        this.hng.setReplyTimeVisible(false);
        this.hng.setShowPraiseNum(true);
        this.hng.setNeedAddPraiseIcon(true);
        this.hng.setNeedAddReplyIcon(true);
        this.hng.setShareVisible(true);
        this.hng.setShareReportFrom(3);
        this.hng.setForumAfterClickListener(this.fkz);
        this.hng.setFrom(1);
        this.hnS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hnS.fls.setOnClickListener(this);
        this.hnS.setFrom(1);
        this.hnS.setShareReportFrom(3);
        this.hnS.setForumAfterClickListener(this.fkz);
        this.iww = view.findViewById(R.id.divider_below_reply_number_layout);
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
        this.hne.setOnClickListener(this);
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
        this.gzY = new com.baidu.tieba.play.f();
        this.gzY.setPlayer(this.abD);
        this.gzY.a(this.iwO);
        this.fTV = (TextView) view.findViewById(R.id.text_video_duration);
        this.iwz = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fUc = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fUb = view.findViewById(R.id.auto_video_black_mask);
        this.fTY = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fTZ = view.findViewById(R.id.auto_video_error_background);
        this.gnT = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.chX = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.chX.setAnimationListener(this.iwP);
        this.iwx = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.iwx.setOnClickListener(this);
        this.gft = view.findViewById(R.id.divider_line);
        this.iwF = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.abD.getView().setOnClickListener(this);
        this.iwH = (TextView) view.findViewById(R.id.nani_video_icon);
        this.iwv = new com.baidu.afd.videopaster.d(getContext(), this.fTU);
        this.iwv.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rr() {
                if (!l.this.iwG) {
                    l.this.abD.start();
                } else {
                    l.this.startPlay();
                }
                l.this.iwG = false;
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
        if (this.iwA != null && this.iwA.eJQ != null && this.iwA.eJQ.eTa > 0) {
            if (crV() != null) {
                crV().a(view, this.iwA);
            }
            this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eUY.getPageActivity(), this.iwA.eJQ.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.bnC(), this.iwA.blq())));
            return;
        }
        if (view == this.hne || view == this.iwx) {
            cM(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.abD.getView()) {
            if (this.iwA != null) {
                this.iwA.objType = 5;
            }
            if (this.iwA != null && this.iwA.eJQ != null && this.iwA.eJQ.boh() != null) {
                z = this.iwA.eJQ.boh().is_vertical.intValue() == 1;
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
        if (crV() != null) {
            crV().a(view, this.iwA);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.no_network_guide);
        } else {
            csc();
        }
    }

    private void cL(View view) {
        if (crV() != null) {
            crV().a(view, this.iwA);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eUY.getPageActivity(), R.string.no_network_guide);
        } else {
            csd();
        }
    }

    private void csc() {
        if (this.iwA != null && this.iwA.eJQ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.iwA.eJQ);
            videoItemData.mRecomExtra = this.iwA.getExtra();
            videoItemData.mRecomAbTag = this.iwA.csI();
            videoItemData.mRecomSource = this.iwA.getSource();
            videoItemData.mRecomWeight = this.iwA.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.iwA.blq(), "index");
            if (this.iwA.eJQ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.iwA.eJQ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void csd() {
        if (this.iwA != null && this.iwA.eJQ != null && this.iwA.eJQ.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.iwA.eJQ);
            videoSerializeVideoThreadInfo.source = this.iwA.getSource();
            videoSerializeVideoThreadInfo.extra = this.iwA.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.iwA.csI();
            videoSerializeVideoThreadInfo.weight = this.iwA.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.gnT.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.gnT.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!au.isEmpty(this.mFrom) && this.mFrom.equals("hottopic")) {
                str = "hottopic";
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eUY.getPageActivity(), str, this.iwA.eJQ.getTid(), m.bnC(), this.iwA.blq(), videoSerializeVideoThreadInfo);
            if (this.iwA.bln() != null && this.iwA.bln().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.iwA.bln().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cM(View view) {
        if (this.iwA != null) {
            this.iwA.objType = 1;
        }
        if (crV() != null) {
            crV().a(view, this.iwA);
        }
        if (this.iwA != null && this.iwA.eJQ != null) {
            if (!cse()) {
                m.IM(this.iwA.eJQ.getId());
                m.a(this.mTextTitle, this.iwA.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eUY.getPageActivity()).createFromThreadCfg(this.iwA.eJQ, null, m.bnC(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.iwA.blq());
            addLocateParam.setVideo_source(this.iwA.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.iwA.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.iwA.eJQ.getFid()));
            addLocateParam.setForumName(this.iwA.eJQ.bnU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.iwx) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cse() {
        return this.iwA.iAX && !this.iwA.iBc;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.iwA = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csf() {
        this.iwI.removeMessages(202);
        if (this.abD.getCurrentPositionSync() > this.abJ) {
            v(false, 3);
            this.iwI.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.iwI.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csg() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.iwI.removeMessages(203);
        int currentPositionSync = this.abD.getCurrentPositionSync();
        if (currentPositionSync != this.iwB) {
            this.iwB = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.iwI.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
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
                    this.iwz.setVisibility(0);
                    this.iwF.setVisibility(8);
                    this.fUa.startLoading();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fUh, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fTX.setVisibility(8);
                    this.fTW.startAnimation(this.chX);
                    this.fUb.setVisibility(8);
                    this.iwz.setVisibility(8);
                    if (this.iwA != null && this.iwA.bln() != null && this.iwA.bln().eTa > 0) {
                        this.iwF.setVisibility(0);
                    }
                    this.fUa.dAb();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                    if (this.iwA != null && this.iwA.eJQ != null && this.iwA.eJQ.boh() != null) {
                        this.iwA.eJQ.boh().video_length.intValue();
                        this.iwA.eJQ.boh().video_duration.intValue();
                        this.iwA.eJQ.getTid();
                    }
                } else if (i == 4) {
                    this.fTX.setVisibility(8);
                    this.fTW.startAnimation(this.chX);
                    this.fUb.setVisibility(8);
                    this.fUa.dAc();
                    this.fTZ.setVisibility(0);
                    this.fTY.setVisibility(0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fUg, 2000L);
                } else {
                    this.fTX.setVisibility(0);
                    this.chX.cancel();
                    this.fTW.clearAnimation();
                    this.fTW.setVisibility(0);
                    this.fUb.setVisibility(0);
                    this.iwz.setVisibility(0);
                    this.fUa.dAc();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                }
                if (this.iwA != null && this.iwA.bln() != null && this.iwA.bln().eTa > 0) {
                    this.iwz.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.iwA == null || this.iwA.eJQ == null || this.iwA.eJQ.bnQ() == null) {
            this.hne.setVisibility(8);
            return;
        }
        this.hne.setVisibility(0);
        csi();
        if (!cse() && m.IN(this.iwA.eJQ.getId())) {
            m.a(this.mTextTitle, this.iwA.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iwx.getGodReplyContent(), this.iwA.bln().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        this.iwA.bln().boP();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.iwA.bln().boz());
        if (this.iwA.bln().boF() && !StringUtils.isNull(this.iwA.bln().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.iwA.bln().getTid();
            spannableStringBuilder.append((CharSequence) this.iwA.bln().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
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
        this.hnf.setData(this.iwA.bln());
        this.hnf.setUserAfterClickListener(this.iwL);
        if (this.hnf.getHeaderImg() != null) {
            this.hnf.getHeaderImg().setAfterClickListener(this.iwM);
            if (this.hnf.getIsSimpleThread()) {
                this.hnf.getHeaderImg().setVisibility(8);
                this.iwy.setVisibility(8);
            } else if (this.iwA.bln() == null || this.iwA.bln().bnQ() == null || this.iwA.bln().bnQ().getPendantData() == null || StringUtils.isNull(this.iwA.bln().bnQ().getPendantData().getImgUrl())) {
                this.iwy.setVisibility(8);
                this.hnf.getHeaderImg().setVisibility(0);
                if (this.iwA.bln().eTa > 0 && this.iwA.bln().eTb == 0) {
                    this.iwA.bln().bnQ().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.hnf.getHeaderImg().setData(this.iwA.bln(), false);
                } else {
                    this.hnf.getHeaderImg().setData(this.iwA.bln());
                    this.hnf.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.hnf.getHeaderImg().setVisibility(4);
                this.iwy.setVisibility(0);
                this.iwy.setData(this.iwA.bln());
            }
        }
        this.fTV.setText(au.stringForVideoTime(this.iwA.eJQ.boh().video_duration.intValue() * 1000));
        this.fUc.setText(String.format(this.eUY.getResources().getString(R.string.play_count), au.numFormatOverWan(this.iwA.eJQ.boh().play_count.intValue())));
        if (this.hnr != null && this.iwA.bln() != null) {
            av avVar = new av();
            avVar.setTid(this.iwA.bln().getTid());
            avVar.setFid(this.iwA.bln().getFid());
            avVar.setNid(this.iwA.bln().bmo());
            avVar.setFeedBackReasonMap(this.iwA.feedBackReasonMap);
            this.hnr.setData(avVar);
            this.hnr.setFirstRowSingleColumn(true);
            this.hnr.setVisibility(this.iwD ? 0 : 8);
        }
        this.iwx.setData(this.iwA.bln().bpv());
        uZ(sW(1));
        onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        if (m.IN(this.iwA.eJQ.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.iwA == null || this.iwA.eJQ == null || this.iwA.eJQ.boh() == null) {
            z = false;
        } else {
            z = this.iwA.eJQ.boh().is_vertical.intValue() == 1;
        }
        if (z) {
            this.iwH.setVisibility(0);
            if (csj()) {
                this.iwH.setText(String.format("%s | %s", this.eUY.getResources().getString(R.string.nani_video), this.eUY.getResources().getString(R.string.video_preview)));
            } else {
                this.iwH.setText(this.eUY.getString(R.string.nani_video));
            }
        } else if (csj()) {
            this.iwH.setVisibility(0);
            this.iwH.setText(this.eUY.getString(R.string.video_preview));
        } else {
            this.iwH.setVisibility(8);
        }
    }

    private void csh() {
        this.iwI.removeMessages(202);
        this.iwI.removeMessages(203);
    }

    private void bHj() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUg);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUh);
    }

    private void csi() {
        bHj();
        csh();
        if (this.fTW != null && this.fTU != null && this.abD != null) {
            if (com.baidu.tbadk.core.k.bkT().isShowImages() && this.iwA != null && this.iwA.eJQ != null && this.iwA.eJQ.boh() != null) {
                this.fTW.setPlaceHolder(3);
                this.fTW.startLoad(this.iwA.eJQ.boh().thumbnail_url, 10, false);
                this.fTU.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.iwA.eJQ.boh().video_url;
                if (csj()) {
                    this.mVideoUrl = this.iwA.eJQ.boi().video_url;
                }
                if (StringUtils.isNull(this.iwA.eJQ.boh().video_url)) {
                    v(true, 4);
                }
                this.abD.setThreadDataForStatistic(this.iwA.eJQ);
            } else {
                this.fTU.setVisibility(8);
            }
            this.iwv.reset();
            this.gzY.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void ce(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.iwv.d(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.iwA);
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
            ap.setBackgroundResource(this.hne, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fTX, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fTY, R.color.CAM_X0101);
            ap.setViewTextColor(this.fTV, R.color.CAM_X0101);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
            ap.setViewTextColor(this.iwF, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fTZ, R.color.common_color_10014);
            ap.setBackgroundColor(this.gft, R.color.CAM_X0204);
            if (this.iwH != null) {
                ap.setViewTextColor(this.iwH, R.color.CAM_X0101);
                ap.setBackgroundResource(this.iwH, R.drawable.video_play_count_bg);
            }
            if (this.fTY != null) {
                this.fTY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.iwx.onChangeSkinType();
            if (this.hnr != null) {
                this.hnr.onChangeSkinType();
            }
            this.hnf.onChangeSkinType();
            this.hng.onChangeSkinType();
            this.hnS.onChangeSkinType();
            this.fTW.setPlaceHolder(3);
            this.iwy.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iwN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iwN);
            this.iwK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iwK);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hnf != null) {
            this.hnf.setPageUniqueId(bdUniqueId);
        }
        if (this.fTW != null) {
            this.fTW.setPageId(bdUniqueId);
        }
        if (this.hnr != null) {
            this.hnr.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.iwC;
    }

    public boolean isPlaying() {
        if (this.abD == null) {
            return false;
        }
        return this.abD.isPlaying();
    }

    public void startPlay() {
        if (!this.iwC && this.iwA != null && this.iwA.eJQ != null && this.iwA.eJQ.boh() != null && this.abD != null) {
            if (this.iwv.rc()) {
                this.iwv.resume();
                this.iwG = true;
                return;
            }
            this.iwG = false;
            this.abD.stopPlayback();
            if (ak.aP(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new ar("c12619").dR("obj_locate", "index").dR("tid", this.iwA.tid));
                    this.mVideoUrl = this.iwA.eJQ.boh().video_url;
                }
                this.iwC = true;
                this.abD.setVideoPath(this.mVideoUrl, this.iwA.tid);
                if (this.gzY != null) {
                    this.gzY.start();
                }
                csb();
            }
        }
    }

    public void stopPlay() {
        this.iwG = false;
        bHj();
        csh();
        v(true, 1);
        if (this.abD != null) {
            this.abD.stopPlayback();
            if (this.gzY != null) {
                this.gzY.stop();
            }
        }
        this.iwC = false;
        this.iwv.stop();
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
        this.iwD = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void uZ(int i) {
        if (this.iwA != null && this.iwA.eJQ != null) {
            if (i == 1) {
                if (this.iwA.eJQ.eTa > 0) {
                    this.hnS.fls.setShowPraiseNum(false);
                    this.hnS.fls.setShareVisible(false);
                    this.iwF.setText(au.numFormatOverWan(this.iwA.eJQ.eTa));
                    this.iwF.setVisibility(0);
                } else {
                    this.hnS.fls.setShowPraiseNum(true);
                    this.hnS.fls.setShareVisible(true);
                    this.iwF.setVisibility(8);
                }
                this.hnS.setData(this.iwA.eJQ);
                this.hng.setVisibility(8);
                this.hnf.kf(false);
                return;
            }
            this.hnS.setVisibility(8);
            this.hnf.kf(true);
            if (this.iwA.eJQ.eTa > 0) {
                this.hng.setShowPraiseNum(false);
                this.hng.setShareVisible(false);
                this.iwF.setText(au.numFormatOverWan(this.iwA.eJQ.eTa));
                this.iwF.setVisibility(0);
            } else {
                this.hng.setShowPraiseNum(true);
                this.hng.setShareVisible(true);
                this.iwF.setVisibility(8);
            }
            if (this.hng.setData(this.iwA.eJQ)) {
                this.iww.setVisibility(8);
            } else {
                this.iww.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKP().aB(this.aif, i);
    }

    private boolean csj() {
        return (this.iwA == null || this.iwA.eJQ == null || this.iwA.eJQ.boi() == null || TextUtils.isEmpty(this.iwA.eJQ.boi().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.iwv.onDestroy();
    }
}
