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
    private TbCyberVideoView acZ;
    private int adg;
    private String ajx;
    private Animation cjy;
    private CyberPlayerManager.OnPreparedListener eCb;
    private CyberPlayerManager.OnErrorListener eCc;
    private CyberPlayerManager.OnCompletionListener eCd;
    private CyberPlayerManager.OnInfoListener eCe;
    private TbPageContext<?> eWx;
    private com.baidu.tieba.play.m fVA;
    private View fVB;
    private TextView fVC;
    private int fVD;
    private TbImageView.b fVE;
    private Runnable fVG;
    private Runnable fVH;
    private TbCyberVideoView.a fVI;
    public FrameLayout fVu;
    private TextView fVv;
    private TbImageView fVw;
    private ImageView fVx;
    private TextView fVy;
    private View fVz;
    private final View.OnClickListener flY;
    private com.baidu.tieba.play.f gBV;
    private View ghb;
    protected LinearLayout gpQ;
    public ThreadSourceShareAndPraiseLayout hpQ;
    private RelativeLayout hpc;
    public ThreadUserInfoLayout hpd;
    public ThreadCommentAndPraiseInfoLayout hpe;
    private NEGFeedBackView hpp;
    private boolean iyA;
    private boolean iyB;
    private TextView iyC;
    private boolean iyD;
    private TextView iyE;
    private Handler iyF;
    private VideoLoadingProgressView.a iyG;
    private CustomMessageListener iyH;
    private final View.OnClickListener iyI;
    private final View.OnClickListener iyJ;
    private CustomMessageListener iyK;
    private f.a iyL;
    private Animation.AnimationListener iyM;
    private com.baidu.afd.videopaster.d iys;
    private View iyt;
    public ThreadGodReplyLayout iyu;
    private HeadPendantClickableView iyv;
    private LinearLayout iyw;
    private com.baidu.tieba.card.data.l iyx;
    private int iyy;
    private boolean iyz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        if (this.acZ != null && this.iyz) {
            try {
                this.acZ.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int QK = com.baidu.tieba.play.n.dAv().QK(this.mVideoUrl);
            if (QK <= 100 || this.acZ.getDuration() <= QK) {
                QK = 100;
            }
            this.adg = QK;
            this.iyF.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        if (this.iyx != null && this.iyx.eLr != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.iyx.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.anU = this.iyx.eLr.getTid();
            oVar.fOD = this.iyx.eLr.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.iyx.eLr.mRecomSource;
            oVar.mKD = this.iyx.eLr.mRecomAbTag;
            oVar.mKz = this.iyx.eLr.mRecomAbTag;
            oVar.mKA = this.iyx.eLr.mRecomWeight;
            oVar.mKB = "";
            oVar.ePf = this.iyx.getExtra();
            if (this.iyx.eLr.boj() != null) {
                oVar.mKE = this.iyx.eLr.boj().video_md5;
            }
            com.baidu.tieba.play.h.a(this.iyx.eLr.boj().video_md5, "", "1", oVar, this.acZ.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hpp = null;
        this.mSkinType = 3;
        this.iyy = 0;
        this.fVD = 1;
        this.iyz = false;
        this.iyA = true;
        this.iyB = false;
        this.adg = 100;
        this.iyD = false;
        this.iyF = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.css();
                        return;
                    case 203:
                        l.this.cst();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.acZ != null) {
                    l.this.acZ.setVolume(0.0f, 0.0f);
                }
                l.this.csn();
            }
        };
        this.eCe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.iys.b(false, false, "NEWINDEX")) {
                    l.this.acZ.start();
                }
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.iyz = false;
                return true;
            }
        };
        this.iyG = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.csn();
            }
        };
        this.fVE = new TbImageView.b() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && l.this.fVw != null) {
                    l.this.fVw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fVG = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.acZ != null && !l.this.acZ.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.fVH = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.iyH = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.iyx != null && l.this.iyx.eLr != null && videoId.equals(l.this.iyx.eLr.getId())) {
                        l.this.iys.a(l.this.a(l.this.iyx, bVar));
                    }
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.iyI = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iyx == null) {
                    if (l.this.csi() != null) {
                        l.this.csi().a(view, l.this.iyx);
                        return;
                    }
                    return;
                }
                if (view == l.this.hpd.getUserName()) {
                    l.this.iyx.objType = 3;
                } else if (view == l.this.hpd.getHeaderImg()) {
                    l.this.iyx.objType = 4;
                } else {
                    l.this.iyx.objType = 1;
                }
                if (l.this.csi() != null) {
                    l.this.csi().a(view, l.this.iyx);
                }
            }
        };
        this.iyJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iyx != null) {
                    l.this.iyx.objType = 4;
                }
                if (l.this.csi() != null) {
                    l.this.csi().a(view, l.this.iyx);
                }
            }
        };
        this.iyK = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.iyB = false;
                }
            }
        };
        this.flY = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iyx != null) {
                    if (l.this.csi() != null) {
                        l.this.csi().a(view, l.this.iyx);
                    }
                    if (l.this.iyx.eLr != null && view != l.this.hpQ.fmg) {
                        m.IW(l.this.iyx.eLr.getId());
                        if (!l.this.csr()) {
                            m.a(l.this.mTextTitle, l.this.iyx.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                            m.a(l.this.iyu.getGodReplyContent(), l.this.iyx.blp().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                        }
                    }
                }
            }
        };
        this.iyL = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void rD() {
                if (l.this.iyx != null && l.this.iyx.eLr != null && l.this.iyx.eLr.boj() != null) {
                    l.this.cso();
                }
            }
        };
        this.iyM = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.fVw != null) {
                    l.this.fVw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eWx = tbPageContext;
        View view = getView();
        this.hpc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.iyv = (HeadPendantClickableView) this.hpc.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.iyv.getHeadView() != null) {
            this.iyv.getHeadView().setIsRound(true);
            this.iyv.getHeadView().setDrawBorder(false);
            this.iyv.getHeadView().setDefaultResource(17170445);
            this.iyv.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.ds70));
            this.iyv.getHeadView().setPlaceHolder(1);
        }
        this.iyv.setHasPendantStyle();
        if (this.iyv.getPendantView() != null) {
            this.iyv.getPendantView().setIsRound(true);
            this.iyv.getPendantView().setDrawBorder(false);
        }
        this.fVA = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fVA.setLoadingAnimationListener(this.iyG);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hpd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hpp = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.hpp.a(this.hpc, dimens, 0);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.hpe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hpe.setLayoutParams(layoutParams);
        }
        this.hpe.setOnClickListener(this);
        this.hpe.setReplyTimeVisible(false);
        this.hpe.setShowPraiseNum(true);
        this.hpe.setNeedAddPraiseIcon(true);
        this.hpe.setNeedAddReplyIcon(true);
        this.hpe.setShareVisible(true);
        this.hpe.setShareReportFrom(3);
        this.hpe.setForumAfterClickListener(this.flY);
        this.hpe.setFrom(1);
        this.hpQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hpQ.fmS.setOnClickListener(this);
        this.hpQ.setFrom(1);
        this.hpQ.setShareReportFrom(3);
        this.hpQ.setForumAfterClickListener(this.flY);
        this.iyt = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fVu = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fVu.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eWx.getPageActivity()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fVu.setLayoutParams(layoutParams2);
        this.fVw = (TbImageView) view.findViewById(R.id.image_video);
        this.fVw.setPlaceHolder(3);
        this.fVw.setGifIconSupport(false);
        this.fVw.setEvent(this.fVE);
        this.fVw.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fVw;
        TbImageView tbImageView2 = this.fVw;
        tbImageView.setConrers(15);
        this.fVw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fVw.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fVw.setBorderSurroundContent(true);
        this.fVw.setDrawBorder(true);
        this.fVx = (ImageView) view.findViewById(R.id.image_video_play);
        this.hpc.setOnClickListener(this);
        this.acZ = new TbCyberVideoView(getContext());
        this.acZ.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fVu.addView(this.acZ.getView(), 0);
        this.acZ.getView().setLayoutParams(layoutParams3);
        this.acZ.setContinuePlayEnable(true);
        this.acZ.setOnPreparedListener(this.eCb);
        this.acZ.setOnInfoListener(this.eCe);
        this.acZ.setOnCompletionListener(this.eCd);
        this.acZ.setOnErrorListener(this.eCc);
        this.acZ.setOnSurfaceDestroyedListener(this.fVI);
        this.gBV = new com.baidu.tieba.play.f();
        this.gBV.setPlayer(this.acZ);
        this.gBV.a(this.iyL);
        this.fVv = (TextView) view.findViewById(R.id.text_video_duration);
        this.iyw = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fVC = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fVB = view.findViewById(R.id.auto_video_black_mask);
        this.fVy = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fVz = view.findViewById(R.id.auto_video_error_background);
        this.gpQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.cjy = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.cjy.setAnimationListener(this.iyM);
        this.iyu = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.iyu.setOnClickListener(this);
        this.ghb = view.findViewById(R.id.divider_line);
        this.iyC = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.acZ.getView().setOnClickListener(this);
        this.iyE = (TextView) view.findViewById(R.id.nani_video_icon);
        this.iys = new com.baidu.afd.videopaster.d(getContext(), this.fVu);
        this.iys.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rr() {
                if (!l.this.iyD) {
                    l.this.acZ.start();
                } else {
                    l.this.startPlay();
                }
                l.this.iyD = false;
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
        if (this.iyx != null && this.iyx.eLr != null && this.iyx.eLr.eUB > 0) {
            if (csi() != null) {
                csi().a(view, this.iyx);
            }
            this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eWx.getPageActivity(), this.iyx.eLr.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.bnE(), this.iyx.bls())));
            return;
        }
        if (view == this.hpc || view == this.iyu) {
            cM(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.acZ.getView()) {
            if (this.iyx != null) {
                this.iyx.objType = 5;
            }
            if (this.iyx != null && this.iyx.eLr != null && this.iyx.eLr.boj() != null) {
                z = this.iyx.eLr.boj().is_vertical.intValue() == 1;
            }
            if (z) {
                cK(this.acZ.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cL(this.acZ.getView());
            } else {
                cM(getView());
            }
        }
    }

    private void cK(View view) {
        if (csi() != null) {
            csi().a(view, this.iyx);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eWx.getPageActivity(), R.string.no_network_guide);
        } else {
            csp();
        }
    }

    private void cL(View view) {
        if (csi() != null) {
            csi().a(view, this.iyx);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eWx.getPageActivity(), R.string.no_network_guide);
        } else {
            csq();
        }
    }

    private void csp() {
        if (this.iyx != null && this.iyx.eLr != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.iyx.eLr);
            videoItemData.mRecomExtra = this.iyx.getExtra();
            videoItemData.mRecomAbTag = this.iyx.csV();
            videoItemData.mRecomSource = this.iyx.getSource();
            videoItemData.mRecomWeight = this.iyx.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.iyx.bls(), "index");
            if (this.iyx.eLr.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.iyx.eLr.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void csq() {
        if (this.iyx != null && this.iyx.eLr != null && this.iyx.eLr.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.iyx.eLr);
            videoSerializeVideoThreadInfo.source = this.iyx.getSource();
            videoSerializeVideoThreadInfo.extra = this.iyx.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.iyx.csV();
            videoSerializeVideoThreadInfo.weight = this.iyx.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.gpQ.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.gpQ.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!au.isEmpty(this.mFrom) && this.mFrom.equals("hottopic")) {
                str = "hottopic";
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eWx.getPageActivity(), str, this.iyx.eLr.getTid(), m.bnE(), this.iyx.bls(), videoSerializeVideoThreadInfo);
            if (this.iyx.blp() != null && this.iyx.blp().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.iyx.blp().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cM(View view) {
        if (this.iyx != null) {
            this.iyx.objType = 1;
        }
        if (csi() != null) {
            csi().a(view, this.iyx);
        }
        if (this.iyx != null && this.iyx.eLr != null) {
            if (!csr()) {
                m.IW(this.iyx.eLr.getId());
                m.a(this.mTextTitle, this.iyx.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eWx.getPageActivity()).createFromThreadCfg(this.iyx.eLr, null, m.bnE(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.iyx.bls());
            addLocateParam.setVideo_source(this.iyx.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.iyx.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.iyx.eLr.getFid()));
            addLocateParam.setForumName(this.iyx.eLr.bnW());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.iyu) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csr() {
        return this.iyx.iCU && !this.iyx.iCZ;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.iyx = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void css() {
        this.iyF.removeMessages(202);
        if (this.acZ.getCurrentPositionSync() > this.adg) {
            v(false, 3);
            this.iyF.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.iyF.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cst() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.iyF.removeMessages(203);
        int currentPositionSync = this.acZ.getCurrentPositionSync();
        if (currentPositionSync != this.iyy) {
            this.iyy = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.iyF.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fVx != null && this.fVw != null && this.fVB != null && this.fVA != null && this.fVz != null && this.fVy != null) {
            if (z || this.fVD != i) {
                this.fVD = i;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVH);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVG);
                if (i == 2) {
                    this.fVx.setVisibility(8);
                    this.cjy.cancel();
                    this.fVw.clearAnimation();
                    this.fVw.setVisibility(0);
                    this.fVB.setVisibility(0);
                    this.iyw.setVisibility(0);
                    this.iyC.setVisibility(8);
                    this.fVA.startLoading();
                    this.fVz.setVisibility(8);
                    this.fVy.setVisibility(8);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fVH, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fVx.setVisibility(8);
                    this.fVw.startAnimation(this.cjy);
                    this.fVB.setVisibility(8);
                    this.iyw.setVisibility(8);
                    if (this.iyx != null && this.iyx.blp() != null && this.iyx.blp().eUB > 0) {
                        this.iyC.setVisibility(0);
                    }
                    this.fVA.dAq();
                    this.fVz.setVisibility(8);
                    this.fVy.setVisibility(8);
                    if (this.iyx != null && this.iyx.eLr != null && this.iyx.eLr.boj() != null) {
                        this.iyx.eLr.boj().video_length.intValue();
                        this.iyx.eLr.boj().video_duration.intValue();
                        this.iyx.eLr.getTid();
                    }
                } else if (i == 4) {
                    this.fVx.setVisibility(8);
                    this.fVw.startAnimation(this.cjy);
                    this.fVB.setVisibility(8);
                    this.fVA.dAr();
                    this.fVz.setVisibility(0);
                    this.fVy.setVisibility(0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fVG, 2000L);
                } else {
                    this.fVx.setVisibility(0);
                    this.cjy.cancel();
                    this.fVw.clearAnimation();
                    this.fVw.setVisibility(0);
                    this.fVB.setVisibility(0);
                    this.iyw.setVisibility(0);
                    this.fVA.dAr();
                    this.fVz.setVisibility(8);
                    this.fVy.setVisibility(8);
                }
                if (this.iyx != null && this.iyx.blp() != null && this.iyx.blp().eUB > 0) {
                    this.iyw.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.iyx == null || this.iyx.eLr == null || this.iyx.eLr.bnS() == null) {
            this.hpc.setVisibility(8);
            return;
        }
        this.hpc.setVisibility(0);
        csv();
        if (!csr() && m.IX(this.iyx.eLr.getId())) {
            m.a(this.mTextTitle, this.iyx.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iyu.getGodReplyContent(), this.iyx.blp().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        this.iyx.blp().boR();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.iyx.blp().boB());
        if (this.iyx.blp().boH() && !StringUtils.isNull(this.iyx.blp().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.brR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.iyx.blp().getTid();
            spannableStringBuilder.append((CharSequence) this.iyx.blp().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
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
        this.hpd.setData(this.iyx.blp());
        this.hpd.setUserAfterClickListener(this.iyI);
        if (this.hpd.getHeaderImg() != null) {
            this.hpd.getHeaderImg().setAfterClickListener(this.iyJ);
            if (this.hpd.getIsSimpleThread()) {
                this.hpd.getHeaderImg().setVisibility(8);
                this.iyv.setVisibility(8);
            } else if (this.iyx.blp() == null || this.iyx.blp().bnS() == null || this.iyx.blp().bnS().getPendantData() == null || StringUtils.isNull(this.iyx.blp().bnS().getPendantData().getImgUrl())) {
                this.iyv.setVisibility(8);
                this.hpd.getHeaderImg().setVisibility(0);
                if (this.iyx.blp().eUB > 0 && this.iyx.blp().eUC == 0) {
                    this.iyx.blp().bnS().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.hpd.getHeaderImg().setData(this.iyx.blp(), false);
                } else {
                    this.hpd.getHeaderImg().setData(this.iyx.blp());
                    this.hpd.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.hpd.getHeaderImg().setVisibility(4);
                this.iyv.setVisibility(0);
                this.iyv.setData(this.iyx.blp());
            }
        }
        this.fVv.setText(au.stringForVideoTime(this.iyx.eLr.boj().video_duration.intValue() * 1000));
        this.fVC.setText(String.format(this.eWx.getResources().getString(R.string.play_count), au.numFormatOverWan(this.iyx.eLr.boj().play_count.intValue())));
        if (this.hpp != null && this.iyx.blp() != null) {
            av avVar = new av();
            avVar.setTid(this.iyx.blp().getTid());
            avVar.setFid(this.iyx.blp().getFid());
            avVar.setNid(this.iyx.blp().bmq());
            avVar.setFeedBackReasonMap(this.iyx.feedBackReasonMap);
            this.hpp.setData(avVar);
            this.hpp.setFirstRowSingleColumn(true);
            this.hpp.setVisibility(this.iyA ? 0 : 8);
        }
        this.iyu.setData(this.iyx.blp().bpx());
        vb(sY(1));
        onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        if (m.IX(this.iyx.eLr.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.iyx == null || this.iyx.eLr == null || this.iyx.eLr.boj() == null) {
            z = false;
        } else {
            z = this.iyx.eLr.boj().is_vertical.intValue() == 1;
        }
        if (z) {
            this.iyE.setVisibility(0);
            if (csw()) {
                this.iyE.setText(String.format("%s | %s", this.eWx.getResources().getString(R.string.nani_video), this.eWx.getResources().getString(R.string.video_preview)));
            } else {
                this.iyE.setText(this.eWx.getString(R.string.nani_video));
            }
        } else if (csw()) {
            this.iyE.setVisibility(0);
            this.iyE.setText(this.eWx.getString(R.string.video_preview));
        } else {
            this.iyE.setVisibility(8);
        }
    }

    private void csu() {
        this.iyF.removeMessages(202);
        this.iyF.removeMessages(203);
    }

    private void bHn() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVG);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVH);
    }

    private void csv() {
        bHn();
        csu();
        if (this.fVw != null && this.fVu != null && this.acZ != null) {
            if (com.baidu.tbadk.core.k.bkV().isShowImages() && this.iyx != null && this.iyx.eLr != null && this.iyx.eLr.boj() != null) {
                this.fVw.setPlaceHolder(3);
                this.fVw.startLoad(this.iyx.eLr.boj().thumbnail_url, 10, false);
                this.fVu.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.iyx.eLr.boj().video_url;
                if (csw()) {
                    this.mVideoUrl = this.iyx.eLr.bok().video_url;
                }
                if (StringUtils.isNull(this.iyx.eLr.boj().video_url)) {
                    v(true, 4);
                }
                this.acZ.setThreadDataForStatistic(this.iyx.eLr);
            } else {
                this.fVu.setVisibility(8);
            }
            this.iys.reset();
            this.gBV.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void cf(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.iys.b(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.iyx);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.eLr != null) {
            cb cbVar = lVar.eLr;
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
        if (lVar == null || lVar.eLr == null || bVar == null) {
            return null;
        }
        cb cbVar = lVar.eLr;
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
        VideoInfo boj = cbVar.boj();
        if (boj != null) {
            i4 = boj.video_width.intValue();
            i3 = boj.video_height.intValue();
        } else {
            i3 = 0;
            i4 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", cbVar.getId());
        hashMap.put("video_title", cbVar.getTitle());
        hashMap.put("forum_id", String.valueOf(cbVar.getFid()));
        hashMap.put("forum_name", cbVar.bnW());
        hashMap.put("up_distance", String.valueOf(i2));
        hashMap.put("down_distance", String.valueOf(i));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rw + 1, i4, i3);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hpc, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fVx, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fVy, R.color.CAM_X0101);
            ap.setViewTextColor(this.fVv, R.color.CAM_X0101);
            ap.setViewTextColor(this.fVC, R.color.CAM_X0101);
            ap.setViewTextColor(this.iyC, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fVz, R.color.common_color_10014);
            ap.setBackgroundColor(this.ghb, R.color.CAM_X0204);
            if (this.iyE != null) {
                ap.setViewTextColor(this.iyE, R.color.CAM_X0101);
                ap.setBackgroundResource(this.iyE, R.drawable.video_play_count_bg);
            }
            if (this.fVy != null) {
                this.fVy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.iyu.onChangeSkinType();
            if (this.hpp != null) {
                this.hpp.onChangeSkinType();
            }
            this.hpd.onChangeSkinType();
            this.hpe.onChangeSkinType();
            this.hpQ.onChangeSkinType();
            this.fVw.setPlaceHolder(3);
            this.iyv.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.iyK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iyK);
            this.iyH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iyH);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hpd != null) {
            this.hpd.setPageUniqueId(bdUniqueId);
        }
        if (this.fVw != null) {
            this.fVw.setPageId(bdUniqueId);
        }
        if (this.hpp != null) {
            this.hpp.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.iyz;
    }

    public boolean isPlaying() {
        if (this.acZ == null) {
            return false;
        }
        return this.acZ.isPlaying();
    }

    public void startPlay() {
        if (!this.iyz && this.iyx != null && this.iyx.eLr != null && this.iyx.eLr.boj() != null && this.acZ != null) {
            if (this.iys.rc()) {
                this.iys.resume();
                this.iyD = true;
                return;
            }
            this.iyD = false;
            this.acZ.stopPlayback();
            if (ak.aP(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new ar("c12619").dR("obj_locate", "index").dR("tid", this.iyx.tid));
                    this.mVideoUrl = this.iyx.eLr.boj().video_url;
                }
                this.iyz = true;
                this.acZ.setVideoPath(this.mVideoUrl, this.iyx.tid);
                if (this.gBV != null) {
                    this.gBV.start();
                }
                cso();
            }
        }
    }

    public void stopPlay() {
        this.iyD = false;
        bHn();
        csu();
        v(true, 1);
        if (this.acZ != null) {
            this.acZ.stopPlayback();
            if (this.gBV != null) {
                this.gBV.stop();
            }
        }
        this.iyz = false;
        this.iys.stop();
    }

    public View getVideoContainer() {
        return this.fVu;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.acZ == null) {
            return 0;
        }
        return this.acZ.getCurrentPosition();
    }

    public void pu(boolean z) {
        this.iyA = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void vb(int i) {
        if (this.iyx != null && this.iyx.eLr != null) {
            if (i == 1) {
                if (this.iyx.eLr.eUB > 0) {
                    this.hpQ.fmS.setShowPraiseNum(false);
                    this.hpQ.fmS.setShareVisible(false);
                    this.iyC.setText(au.numFormatOverWan(this.iyx.eLr.eUB));
                    this.iyC.setVisibility(0);
                } else {
                    this.hpQ.fmS.setShowPraiseNum(true);
                    this.hpQ.fmS.setShareVisible(true);
                    this.iyC.setVisibility(8);
                }
                this.hpQ.setData(this.iyx.eLr);
                this.hpe.setVisibility(8);
                this.hpd.kf(false);
                return;
            }
            this.hpQ.setVisibility(8);
            this.hpd.kf(true);
            if (this.iyx.eLr.eUB > 0) {
                this.hpe.setShowPraiseNum(false);
                this.hpe.setShareVisible(false);
                this.iyC.setText(au.numFormatOverWan(this.iyx.eLr.eUB));
                this.iyC.setVisibility(0);
            } else {
                this.hpe.setShowPraiseNum(true);
                this.hpe.setShareVisible(true);
                this.iyC.setVisibility(8);
            }
            if (this.hpe.setData(this.iyx.eLr)) {
                this.iyt.setVisibility(8);
            } else {
                this.iyt.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public int sY(int i) {
        return com.baidu.tieba.a.d.bKY().aB(this.ajx, i);
    }

    private boolean csw() {
        return (this.iyx == null || this.iyx.eLr == null || this.iyx.eLr.bok() == null || TextUtils.isEmpty(this.iyx.eLr.bok().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.iys.onDestroy();
    }
}
