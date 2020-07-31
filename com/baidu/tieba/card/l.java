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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes15.dex */
public class l extends b<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView YH;
    private int YN;
    private String afx;
    private Animation buu;
    private CyberPlayerManager.OnInfoListener dCA;
    private CyberPlayerManager.OnPreparedListener dCx;
    private CyberPlayerManager.OnErrorListener dCy;
    private CyberPlayerManager.OnCompletionListener dCz;
    private TbPageContext<?> dVN;
    private Runnable eRB;
    private Runnable eRC;
    private TbCyberVideoView.a eRD;
    public FrameLayout eRp;
    private TextView eRq;
    private TbImageView eRr;
    private ImageView eRs;
    private TextView eRt;
    private View eRu;
    private com.baidu.tieba.play.m eRv;
    private View eRw;
    private TextView eRx;
    private int eRy;
    private TbImageView.a eRz;
    private final View.OnClickListener eke;
    private RelativeLayout fWZ;
    public ThreadSourceShareAndPraiseLayout fXN;
    public ThreadUserInfoLayout fXa;
    public ThreadCommentAndPraiseInfoLayout fXb;
    private NEGFeedBackView fXm;
    private View fbk;
    protected LinearLayout fiQ;
    private com.baidu.tieba.play.f fss;
    private TextView gWA;
    private boolean gWB;
    private TextView gWC;
    private Handler gWD;
    private VideoLoadingProgressView.a gWE;
    private CustomMessageListener gWF;
    private final View.OnClickListener gWG;
    private final View.OnClickListener gWH;
    private CustomMessageListener gWI;
    private f.a gWJ;
    private Animation.AnimationListener gWK;
    private com.baidu.afd.videopaster.d gWq;
    private View gWr;
    public ThreadGodReplyLayout gWs;
    private HeadPendantClickableView gWt;
    private LinearLayout gWu;
    private com.baidu.tieba.card.data.l gWv;
    private int gWw;
    private boolean gWx;
    private boolean gWy;
    private boolean gWz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bRs() {
        if (this.YH != null && this.gWx) {
            try {
                this.YH.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int LL = com.baidu.tieba.play.n.cZa().LL(this.mVideoUrl);
            if (LL <= 100 || this.YH.getDuration() <= LL) {
                LL = 100;
            }
            this.YN = LL;
            this.gWD.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRt() {
        if (this.gWv != null && this.gWv.dLK != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.gWv.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.ajJ = this.gWv.dLK.getTid();
            oVar.eKO = this.gWv.dLK.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.gWv.dLK.mRecomSource;
            oVar.lcL = this.gWv.dLK.mRecomAbTag;
            oVar.lcH = this.gWv.dLK.mRecomAbTag;
            oVar.lcI = this.gWv.dLK.mRecomWeight;
            oVar.lcJ = "";
            oVar.dOV = this.gWv.getExtra();
            if (this.gWv.dLK.aWD() != null) {
                oVar.lcM = this.gWv.dLK.aWD().video_md5;
            }
            com.baidu.tieba.play.h.a(this.gWv.dLK.aWD().video_md5, "", "1", oVar, this.YH.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fXm = null;
        this.mSkinType = 3;
        this.gWw = 0;
        this.eRy = 1;
        this.gWx = false;
        this.gWy = true;
        this.gWz = false;
        this.YN = 100;
        this.gWB = false;
        this.gWD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.bRx();
                        return;
                    case 203:
                        l.this.bRy();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.YH != null) {
                    l.this.YH.setVolume(0.0f, 0.0f);
                }
                l.this.bRs();
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.gWq.a(false, false, "NEWINDEX")) {
                    l.this.YH.start();
                }
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.gWx = false;
                return true;
            }
        };
        this.gWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.bRs();
            }
        };
        this.eRz = new TbImageView.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.eRr != null) {
                    l.this.eRr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eRB = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.YH != null && !l.this.YH.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.eRC = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.gWF = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.gWv != null && l.this.gWv.dLK != null && videoId.equals(l.this.gWv.dLK.getId())) {
                        l.this.gWq.a(l.this.a(l.this.gWv, bVar));
                    }
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.gWG = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gWv == null) {
                    if (l.this.bRn() != null) {
                        l.this.bRn().a(view, l.this.gWv);
                        return;
                    }
                    return;
                }
                if (view == l.this.fXa.getUserName()) {
                    l.this.gWv.objType = 3;
                } else if (view == l.this.fXa.getHeaderImg()) {
                    l.this.gWv.objType = 4;
                } else {
                    l.this.gWv.objType = 1;
                }
                if (l.this.bRn() != null) {
                    l.this.bRn().a(view, l.this.gWv);
                }
            }
        };
        this.gWH = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gWv != null) {
                    l.this.gWv.objType = 4;
                }
                if (l.this.bRn() != null) {
                    l.this.bRn().a(view, l.this.gWv);
                }
            }
        };
        this.gWI = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.gWz = false;
                }
            }
        };
        this.eke = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gWv != null) {
                    if (l.this.bRn() != null) {
                        l.this.bRn().a(view, l.this.gWv);
                    }
                    if (l.this.gWv.dLK != null && view != l.this.fXN.eko) {
                        m.Ez(l.this.gWv.dLK.getId());
                        if (!l.this.bRw()) {
                            m.a(l.this.mTextTitle, l.this.gWv.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                            m.a(l.this.gWs.getGodReplyContent(), l.this.gWv.aTN().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.gWJ = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void qy() {
                if (l.this.gWv != null && l.this.gWv.dLK != null && l.this.gWv.dLK.aWD() != null) {
                    l.this.bRt();
                }
            }
        };
        this.gWK = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.eRr != null) {
                    l.this.eRr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dVN = tbPageContext;
        View view = getView();
        this.fWZ = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gWt = (HeadPendantClickableView) this.fWZ.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gWt.getHeadView() != null) {
            this.gWt.getHeadView().setIsRound(true);
            this.gWt.getHeadView().setDrawBorder(false);
            this.gWt.getHeadView().setDefaultResource(17170445);
            this.gWt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gWt.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.ds70));
            this.gWt.getHeadView().setPlaceHolder(1);
        }
        this.gWt.setHasPendantStyle();
        if (this.gWt.getPendantView() != null) {
            this.gWt.getPendantView().setIsRound(true);
            this.gWt.getPendantView().setDrawBorder(false);
        }
        this.eRv = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eRv.setLoadingAnimationListener(this.gWE);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fXa = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fXm = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.fXm.a(this.fWZ, dimens, 0);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fXb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fXb.setLayoutParams(layoutParams);
        }
        this.fXb.setOnClickListener(this);
        this.fXb.setReplyTimeVisible(false);
        this.fXb.setShowPraiseNum(true);
        this.fXb.setNeedAddPraiseIcon(true);
        this.fXb.setNeedAddReplyIcon(true);
        this.fXb.setShareVisible(true);
        this.fXb.setShareReportFrom(3);
        this.fXb.setForumAfterClickListener(this.eke);
        this.fXb.setFrom(1);
        this.fXN = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fXN.ekZ.setOnClickListener(this);
        this.fXN.setFrom(1);
        this.fXN.setShareReportFrom(3);
        this.fXN.setForumAfterClickListener(this.eke);
        this.gWr = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eRp = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eRp.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dVN.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.eRp.setLayoutParams(layoutParams2);
        this.eRr = (TbImageView) view.findViewById(R.id.image_video);
        this.eRr.setDefaultErrorResource(0);
        this.eRr.setPlaceHolder(3);
        this.eRr.setGifIconSupport(false);
        this.eRr.setEvent(this.eRz);
        this.eRr.setRadius(com.baidu.adp.lib.util.l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.eRr;
        TbImageView tbImageView2 = this.eRr;
        tbImageView.setConrers(15);
        this.eRr.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eRr.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.eRr.setBorderSurroundContent(true);
        this.eRr.setDrawBorder(true);
        this.eRs = (ImageView) view.findViewById(R.id.image_video_play);
        this.fWZ.setOnClickListener(this);
        this.YH = new TbCyberVideoView(getContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.eRp.addView(this.YH.getView(), 0);
        this.YH.getView().setLayoutParams(layoutParams3);
        this.YH.setContinuePlayEnable(true);
        this.YH.setOnPreparedListener(this.dCx);
        this.YH.setOnInfoListener(this.dCA);
        this.YH.setOnCompletionListener(this.dCz);
        this.YH.setOnErrorListener(this.dCy);
        this.YH.setOnSurfaceDestroyedListener(this.eRD);
        this.fss = new com.baidu.tieba.play.f();
        this.fss.setPlayer(this.YH);
        this.fss.a(this.gWJ);
        this.eRq = (TextView) view.findViewById(R.id.text_video_duration);
        this.gWu = (LinearLayout) view.findViewById(R.id.duration_container);
        this.eRx = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eRw = view.findViewById(R.id.auto_video_black_mask);
        this.eRt = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eRu = view.findViewById(R.id.auto_video_error_background);
        this.fiQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.buu = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.buu.setAnimationListener(this.gWK);
        this.gWs = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gWs.setOnClickListener(this);
        this.fbk = view.findViewById(R.id.divider_line);
        this.gWA = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.YH.getView().setOnClickListener(this);
        this.gWC = (TextView) view.findViewById(R.id.nani_video_icon);
        this.gWq = new com.baidu.afd.videopaster.d(getContext(), this.eRp);
        this.gWq.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void qn() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qm() {
                if (!l.this.gWB) {
                    l.this.YH.start();
                } else {
                    l.this.startPlay();
                }
                l.this.gWB = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void ql() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean qo() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.gWv != null && this.gWv.dLK != null && this.gWv.dLK.dUg > 0) {
            if (bRn() != null) {
                bRn().a(view, this.gWv);
            }
            this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.dVN.getPageActivity(), this.gWv.dLK.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.aVX(), this.gWv.aTQ())));
            return;
        }
        if (view == this.fWZ || view == this.gWs) {
            bV(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.YH.getView()) {
            if (this.gWv != null) {
                this.gWv.objType = 5;
            }
            if (this.gWv != null && this.gWv.dLK != null && this.gWv.dLK.aWD() != null) {
                z = this.gWv.dLK.aWD().is_vertical.intValue() == 1;
            }
            if (z) {
                bT(this.YH.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bU(this.YH.getView());
            } else {
                bV(getView());
            }
        }
    }

    private void bT(View view) {
        if (bRn() != null) {
            bRn().a(view, this.gWv);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dVN.getPageActivity(), R.string.no_network_guide);
        } else {
            bRu();
        }
    }

    private void bU(View view) {
        if (bRn() != null) {
            bRn().a(view, this.gWv);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dVN.getPageActivity(), R.string.no_network_guide);
        } else {
            bRv();
        }
    }

    private void bRu() {
        if (this.gWv != null && this.gWv.dLK != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.gWv.dLK);
            videoItemData.mRecomExtra = this.gWv.getExtra();
            videoItemData.mRecomAbTag = this.gWv.bRY();
            videoItemData.mRecomSource = this.gWv.getSource();
            videoItemData.mRecomWeight = this.gWv.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.gWv.aTQ(), "index");
            if (this.gWv.dLK.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.gWv.dLK.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bRv() {
        if (this.gWv != null && this.gWv.dLK != null && this.gWv.dLK.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.gWv.dLK);
            videoSerializeVideoThreadInfo.source = this.gWv.getSource();
            videoSerializeVideoThreadInfo.extra = this.gWv.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.gWv.bRY();
            videoSerializeVideoThreadInfo.weight = this.gWv.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fiQ.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fiQ.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!as.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.dVN.getPageActivity(), str, this.gWv.dLK.getTid(), m.aVX(), this.gWv.aTQ(), videoSerializeVideoThreadInfo);
            if (this.gWv.aTN() != null && this.gWv.aTN().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.gWv.aTN().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bV(View view) {
        if (this.gWv != null) {
            this.gWv.objType = 1;
        }
        if (bRn() != null) {
            bRn().a(view, this.gWv);
        }
        if (this.gWv != null && this.gWv.dLK != null) {
            if (!bRw()) {
                m.Ez(this.gWv.dLK.getId());
                m.a(this.mTextTitle, this.gWv.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dVN.getPageActivity()).createFromThreadCfg(this.gWv.dLK, null, m.aVX(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.gWv.aTQ());
            addLocateParam.setVideo_source(this.gWv.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.gWv.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.gWv.dLK.getFid()));
            addLocateParam.setForumName(this.gWv.dLK.aWp());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.gWs) {
                addLocateParam.setJumpGodReply(true);
            }
            this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRw() {
        return this.gWv.hax && !this.gWv.haC;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.gWv = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        this.gWD.removeMessages(202);
        if (this.YH.getCurrentPositionSync() > this.YN) {
            v(false, 3);
            this.gWD.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gWD.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gWD.removeMessages(203);
        int currentPositionSync = this.YH.getCurrentPositionSync();
        if (currentPositionSync != this.gWw) {
            this.gWw = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.gWD.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.eRs != null && this.eRr != null && this.eRw != null && this.eRv != null && this.eRu != null && this.eRt != null) {
            if (z || this.eRy != i) {
                this.eRy = i;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRC);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRB);
                if (i == 2) {
                    this.eRs.setVisibility(8);
                    this.buu.cancel();
                    this.eRr.clearAnimation();
                    this.eRr.setVisibility(0);
                    this.eRw.setVisibility(0);
                    this.gWu.setVisibility(0);
                    this.gWA.setVisibility(8);
                    this.eRv.startLoading();
                    this.eRu.setVisibility(8);
                    this.eRt.setVisibility(8);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eRC, 60000L);
                } else if (i == 3) {
                    this.eRs.setVisibility(8);
                    this.eRr.startAnimation(this.buu);
                    this.eRw.setVisibility(8);
                    this.gWu.setVisibility(8);
                    if (this.gWv != null && this.gWv.aTN() != null && this.gWv.aTN().dUg > 0) {
                        this.gWA.setVisibility(0);
                    }
                    this.eRv.cYW();
                    this.eRu.setVisibility(8);
                    this.eRt.setVisibility(8);
                    if (this.gWv != null && this.gWv.dLK != null && this.gWv.dLK.aWD() != null) {
                        this.gWv.dLK.aWD().video_length.intValue();
                        this.gWv.dLK.aWD().video_duration.intValue();
                        this.gWv.dLK.getTid();
                    }
                } else if (i == 4) {
                    this.eRs.setVisibility(8);
                    this.eRr.startAnimation(this.buu);
                    this.eRw.setVisibility(8);
                    this.eRv.cYX();
                    this.eRu.setVisibility(0);
                    this.eRt.setVisibility(0);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eRB, 2000L);
                } else {
                    this.eRs.setVisibility(0);
                    this.buu.cancel();
                    this.eRr.clearAnimation();
                    this.eRr.setVisibility(0);
                    this.eRw.setVisibility(0);
                    this.gWu.setVisibility(0);
                    this.eRv.cYX();
                    this.eRu.setVisibility(8);
                    this.eRt.setVisibility(8);
                }
                if (this.gWv != null && this.gWv.aTN() != null && this.gWv.aTN().dUg > 0) {
                    this.gWu.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.gWv == null || this.gWv.dLK == null || this.gWv.dLK.aWl() == null) {
            this.fWZ.setVisibility(8);
            return;
        }
        this.fWZ.setVisibility(0);
        bRA();
        if (!bRw() && m.EA(this.gWv.dLK.getId())) {
            m.a(this.mTextTitle, this.gWv.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.gWs.getGodReplyContent(), this.gWv.aTN().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        this.gWv.aTN().aXj();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gWv.aTN().aWV());
        if (this.gWv.aTN().aXb() && !StringUtils.isNull(this.gWv.aTN().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.gWv.aTN().getTid();
            spannableStringBuilder.append((CharSequence) this.gWv.aTN().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ap("c12841").dn("obj_source", "0"));
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
        this.fXa.setData(this.gWv.aTN());
        this.fXa.setUserAfterClickListener(this.gWG);
        if (this.fXa.getHeaderImg() != null) {
            this.fXa.getHeaderImg().setAfterClickListener(this.gWH);
            if (this.fXa.getIsSimpleThread()) {
                this.fXa.getHeaderImg().setVisibility(8);
                this.gWt.setVisibility(8);
            } else if (this.gWv.aTN() == null || this.gWv.aTN().aWl() == null || this.gWv.aTN().aWl().getPendantData() == null || StringUtils.isNull(this.gWv.aTN().aWl().getPendantData().aUh())) {
                this.gWt.setVisibility(8);
                this.fXa.getHeaderImg().setVisibility(0);
                if (this.gWv.aTN().dUg > 0 && this.gWv.aTN().dUh == 0) {
                    this.gWv.aTN().aWl().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.fXa.getHeaderImg().setData(this.gWv.aTN(), false);
                } else {
                    this.fXa.getHeaderImg().setData(this.gWv.aTN());
                    this.fXa.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.fXa.getHeaderImg().setVisibility(4);
                this.gWt.setVisibility(0);
                this.gWt.setData(this.gWv.aTN());
            }
        }
        this.eRq.setText(as.stringForVideoTime(this.gWv.dLK.aWD().video_duration.intValue() * 1000));
        this.eRx.setText(String.format(this.dVN.getResources().getString(R.string.play_count), as.numFormatOverWan(this.gWv.dLK.aWD().play_count.intValue())));
        if (this.fXm != null && this.gWv.aTN() != null) {
            aq aqVar = new aq();
            aqVar.setTid(this.gWv.aTN().getTid());
            aqVar.setFid(this.gWv.aTN().getFid());
            aqVar.setNid(this.gWv.aTN().getNid());
            aqVar.setFeedBackReasonMap(this.gWv.feedBackReasonMap);
            this.fXm.setData(aqVar);
            this.fXm.setFirstRowSingleColumn(true);
            this.fXm.setVisibility(this.gWy ? 0 : 8);
        }
        this.gWs.setData(this.gWv.aTN().aXO());
        rp(pM(1));
        onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
        if (m.EA(this.gWv.dLK.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.gWv == null || this.gWv.dLK == null || this.gWv.dLK.aWD() == null) {
            z = false;
        } else {
            z = this.gWv.dLK.aWD().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gWC.setVisibility(0);
            if (bRB()) {
                this.gWC.setText(String.format("%s | %s", this.dVN.getResources().getString(R.string.nani_video), this.dVN.getResources().getString(R.string.video_preview)));
            } else {
                this.gWC.setText(this.dVN.getString(R.string.nani_video));
            }
        } else if (bRB()) {
            this.gWC.setVisibility(0);
            this.gWC.setText(this.dVN.getString(R.string.video_preview));
        } else {
            this.gWC.setVisibility(8);
        }
    }

    private void bRz() {
        this.gWD.removeMessages(202);
        this.gWD.removeMessages(203);
    }

    private void bot() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRB);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRC);
    }

    private void bRA() {
        bot();
        bRz();
        if (this.eRr != null && this.eRp != null && this.YH != null) {
            if (com.baidu.tbadk.core.k.aTv().isShowImages() && this.gWv != null && this.gWv.dLK != null && this.gWv.dLK.aWD() != null) {
                this.eRr.setPlaceHolder(3);
                this.eRr.startLoad(this.gWv.dLK.aWD().thumbnail_url, 10, false);
                this.eRp.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.gWv.dLK.aWD().video_url;
                if (bRB()) {
                    this.mVideoUrl = this.gWv.dLK.aWE().video_url;
                }
                if (StringUtils.isNull(this.gWv.dLK.aWD().video_url)) {
                    v(true, 4);
                }
                this.YH.setThreadDataForStatistic(this.gWv.dLK);
            } else {
                this.eRp.setVisibility(8);
            }
            this.gWq.reset();
            this.fss.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void bP(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.gWq.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.gWv);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.dLK != null) {
            bv bvVar = lVar.dLK;
            if (bvVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bvVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.dLK == null || bVar == null) {
            return null;
        }
        bv bvVar = lVar.dLK;
        int qs = bVar.qs();
        int qt = bVar.qt();
        int qr = bVar.qr();
        if (qr != -1) {
            i = qs != -1 ? (qr - qs) - 1 : -1;
            if (qt != -1) {
                i4 = (qt - qr) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aWD = bvVar.aWD();
        if (aWD != null) {
            i3 = aWD.video_width.intValue();
            i2 = aWD.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bvVar.getId());
        hashMap.put("video_title", bvVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bvVar.getFid()));
        hashMap.put("forum_name", bvVar.aWp());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qr + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fWZ, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.eRs, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.eRt, R.color.cp_cont_a);
            ao.setViewTextColor(this.eRq, R.color.cp_cont_a);
            ao.setViewTextColor(this.eRx, R.color.cp_cont_a);
            ao.setViewTextColor(this.gWA, R.color.cp_cont_a);
            ao.setBackgroundColor(this.eRu, R.color.common_color_10014);
            ao.setBackgroundColor(this.fbk, R.color.cp_bg_line_c);
            if (this.gWC != null) {
                ao.setViewTextColor(this.gWC, R.color.cp_cont_a);
                ao.setBackgroundResource(this.gWC, R.drawable.video_play_count_bg);
            }
            if (this.eRt != null) {
                this.eRt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.gWs.onChangeSkinType();
            if (this.fXm != null) {
                this.fXm.onChangeSkinType();
            }
            this.fXa.onChangeSkinType();
            this.fXb.onChangeSkinType();
            this.fXN.onChangeSkinType();
            this.eRr.setPlaceHolder(3);
            this.gWt.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gWI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWI);
            this.gWF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWF);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fXa != null) {
            this.fXa.setPageUniqueId(bdUniqueId);
        }
        if (this.eRr != null) {
            this.eRr.setPageId(bdUniqueId);
        }
        if (this.fXm != null) {
            this.fXm.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.gWx;
    }

    public boolean isPlaying() {
        if (this.YH == null) {
            return false;
        }
        return this.YH.isPlaying();
    }

    public void startPlay() {
        if (!this.gWx && this.gWv != null && this.gWv.dLK != null && this.gWv.dLK.aWD() != null && this.YH != null) {
            if (this.gWq.pW()) {
                this.gWq.resume();
                this.gWB = true;
                return;
            }
            this.gWB = false;
            this.YH.stopPlayback();
            if (ag.au(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new ap("c12619").dn("obj_locate", "index").dn("tid", this.gWv.tid));
                    this.mVideoUrl = this.gWv.dLK.aWD().video_url;
                }
                this.gWx = true;
                this.YH.setVideoPath(this.mVideoUrl, this.gWv.tid);
                if (this.fss != null) {
                    this.fss.start();
                }
                bRt();
            }
        }
    }

    public void stopPlay() {
        this.gWB = false;
        bot();
        bRz();
        v(true, 1);
        if (this.YH != null) {
            this.YH.stopPlayback();
            if (this.fss != null) {
                this.fss.stop();
            }
        }
        this.gWx = false;
        this.gWq.stop();
    }

    public View getVideoContainer() {
        return this.eRp;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.YH == null) {
            return 0;
        }
        return this.YH.getCurrentPosition();
    }

    public void mA(boolean z) {
        this.gWy = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void rp(int i) {
        if (this.gWv != null && this.gWv.dLK != null) {
            if (i == 1) {
                if (this.gWv.dLK.dUg > 0) {
                    this.fXN.ekZ.setShowPraiseNum(false);
                    this.fXN.ekZ.setShareVisible(false);
                    this.gWA.setText(as.numFormatOverWan(this.gWv.dLK.dUg));
                    this.gWA.setVisibility(0);
                } else {
                    this.fXN.ekZ.setShowPraiseNum(true);
                    this.fXN.ekZ.setShareVisible(true);
                    this.gWA.setVisibility(8);
                }
                this.fXN.setData(this.gWv.dLK);
                this.fXb.setVisibility(8);
                this.fXa.ie(false);
                return;
            }
            this.fXN.setVisibility(8);
            this.fXa.ie(true);
            if (this.gWv.dLK.dUg > 0) {
                this.fXb.setShowPraiseNum(false);
                this.fXb.setShareVisible(false);
                this.gWA.setText(as.numFormatOverWan(this.gWv.dLK.dUg));
                this.gWA.setVisibility(0);
            } else {
                this.fXb.setShowPraiseNum(true);
                this.fXb.setShareVisible(true);
                this.gWA.setVisibility(8);
            }
            if (this.fXb.setData(this.gWv.dLK)) {
                this.gWr.setVisibility(8);
            } else {
                this.gWr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public int pM(int i) {
        return com.baidu.tieba.a.d.brD().ar(this.afx, i);
    }

    private boolean bRB() {
        return (this.gWv == null || this.gWv.dLK == null || this.gWv.dLK.aWE() == null || TextUtils.isEmpty(this.gWv.dLK.aWE().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.gWq.onDestroy();
    }
}
