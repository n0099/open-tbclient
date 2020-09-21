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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ai;
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
/* loaded from: classes20.dex */
public class l extends b<com.baidu.tieba.card.data.m> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView ZH;
    private int ZN;
    private String ahc;
    private Animation bDF;
    private CyberPlayerManager.OnPreparedListener dNO;
    private CyberPlayerManager.OnErrorListener dNP;
    private CyberPlayerManager.OnCompletionListener dNQ;
    private CyberPlayerManager.OnInfoListener dNR;
    private TbPageContext<?> ehG;
    private final View.OnClickListener ewh;
    private com.baidu.tieba.play.f fHc;
    public FrameLayout feS;
    private TextView feT;
    private TbImageView feU;
    private ImageView feV;
    private TextView feW;
    private View feX;
    private com.baidu.tieba.play.m feY;
    private View feZ;
    private TextView ffa;
    private int ffb;
    private TbImageView.a ffc;
    private Runnable ffe;
    private Runnable fff;
    private TbCyberVideoView.a ffg;
    private View fpN;
    protected LinearLayout fxB;
    public ThreadSourceShareAndPraiseLayout gmX;
    private RelativeLayout gmj;
    public ThreadUserInfoLayout gmk;
    public ThreadCommentAndPraiseInfoLayout gml;
    private NEGFeedBackView gmw;
    private TextView hqA;
    private boolean hqB;
    private TextView hqC;
    private Handler hqD;
    private VideoLoadingProgressView.a hqE;
    private CustomMessageListener hqF;
    private final View.OnClickListener hqG;
    private final View.OnClickListener hqH;
    private CustomMessageListener hqI;
    private f.a hqJ;
    private Animation.AnimationListener hqK;
    private com.baidu.afd.videopaster.d hqq;
    private View hqr;
    public ThreadGodReplyLayout hqs;
    private HeadPendantClickableView hqt;
    private LinearLayout hqu;
    private com.baidu.tieba.card.data.m hqv;
    private int hqw;
    private boolean hqx;
    private boolean hqy;
    private boolean hqz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        if (this.ZH != null && this.hqx) {
            try {
                this.ZH.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Pg = com.baidu.tieba.play.n.dnN().Pg(this.mVideoUrl);
            if (Pg <= 100 || this.ZH.getDuration() <= Pg) {
                Pg = 100;
            }
            this.ZN = Pg;
            this.hqD.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceV() {
        if (this.hqv != null && this.hqv.dXg != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.hqv.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.alA = this.hqv.dXg.getTid();
            oVar.eYo = this.hqv.dXg.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.hqv.dXg.mRecomSource;
            oVar.lCj = this.hqv.dXg.mRecomAbTag;
            oVar.lCf = this.hqv.dXg.mRecomAbTag;
            oVar.lCg = this.hqv.dXg.mRecomWeight;
            oVar.lCh = "";
            oVar.eaC = this.hqv.getExtra();
            if (this.hqv.dXg.bfQ() != null) {
                oVar.lCk = this.hqv.dXg.bfQ().video_md5;
            }
            com.baidu.tieba.play.h.a(this.hqv.dXg.bfQ().video_md5, "", "1", oVar, this.ZH.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gmw = null;
        this.mSkinType = 3;
        this.hqw = 0;
        this.ffb = 1;
        this.hqx = false;
        this.hqy = true;
        this.hqz = false;
        this.ZN = 100;
        this.hqB = false;
        this.hqD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.ceZ();
                        return;
                    case 203:
                        l.this.cfa();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.ZH != null) {
                    l.this.ZH.setVolume(0.0f, 0.0f);
                }
                l.this.ceU();
            }
        };
        this.dNR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.hqq.a(false, false, "NEWINDEX")) {
                    l.this.ZH.start();
                }
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.hqx = false;
                return true;
            }
        };
        this.hqE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.ceU();
            }
        };
        this.ffc = new TbImageView.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.feU != null) {
                    l.this.feU.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.ffe = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.ZH != null && !l.this.ZH.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.fff = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.hqF = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.hqv != null && l.this.hqv.dXg != null && videoId.equals(l.this.hqv.dXg.getId())) {
                        l.this.hqq.a(l.this.a(l.this.hqv, bVar));
                    }
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.hqG = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hqv == null) {
                    if (l.this.ceP() != null) {
                        l.this.ceP().a(view, l.this.hqv);
                        return;
                    }
                    return;
                }
                if (view == l.this.gmk.getUserName()) {
                    l.this.hqv.objType = 3;
                } else if (view == l.this.gmk.getHeaderImg()) {
                    l.this.hqv.objType = 4;
                } else {
                    l.this.hqv.objType = 1;
                }
                if (l.this.ceP() != null) {
                    l.this.ceP().a(view, l.this.hqv);
                }
            }
        };
        this.hqH = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hqv != null) {
                    l.this.hqv.objType = 4;
                }
                if (l.this.ceP() != null) {
                    l.this.ceP().a(view, l.this.hqv);
                }
            }
        };
        this.hqI = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.hqz = false;
                }
            }
        };
        this.ewh = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hqv != null) {
                    if (l.this.ceP() != null) {
                        l.this.ceP().a(view, l.this.hqv);
                    }
                    if (l.this.hqv.dXg != null && view != l.this.gmX.ewr) {
                        m.Hw(l.this.hqv.dXg.getId());
                        if (!l.this.ceY()) {
                            m.a(l.this.mTextTitle, l.this.hqv.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                            m.a(l.this.hqs.getGodReplyContent(), l.this.hqv.bcY().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.hqJ = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                if (l.this.hqv != null && l.this.hqv.dXg != null && l.this.hqv.dXg.bfQ() != null) {
                    l.this.ceV();
                }
            }
        };
        this.hqK = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.feU != null) {
                    l.this.feU.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ehG = tbPageContext;
        View view = getView();
        this.gmj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hqt = (HeadPendantClickableView) this.gmj.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hqt.getHeadView() != null) {
            this.hqt.getHeadView().setIsRound(true);
            this.hqt.getHeadView().setDrawBorder(false);
            this.hqt.getHeadView().setDefaultResource(17170445);
            this.hqt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hqt.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.ds70));
            this.hqt.getHeadView().setPlaceHolder(1);
        }
        this.hqt.setHasPendantStyle();
        if (this.hqt.getPendantView() != null) {
            this.hqt.getPendantView().setIsRound(true);
            this.hqt.getPendantView().setDrawBorder(false);
        }
        this.feY = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.feY.setLoadingAnimationListener(this.hqE);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gmk = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gmw = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.gmw.a(this.gmj, dimens, 0);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.gml.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gml.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gml.setLayoutParams(layoutParams);
        }
        this.gml.setOnClickListener(this);
        this.gml.setReplyTimeVisible(false);
        this.gml.setShowPraiseNum(true);
        this.gml.setNeedAddPraiseIcon(true);
        this.gml.setNeedAddReplyIcon(true);
        this.gml.setShareVisible(true);
        this.gml.setShareReportFrom(3);
        this.gml.setForumAfterClickListener(this.ewh);
        this.gml.setFrom(1);
        this.gmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gmX.exc.setOnClickListener(this);
        this.gmX.setFrom(1);
        this.gmX.setShareReportFrom(3);
        this.gmX.setForumAfterClickListener(this.ewh);
        this.hqr = view.findViewById(R.id.divider_below_reply_number_layout);
        this.feS = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.feS.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ehG.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.feS.setLayoutParams(layoutParams2);
        this.feU = (TbImageView) view.findViewById(R.id.image_video);
        this.feU.setDefaultErrorResource(0);
        this.feU.setPlaceHolder(3);
        this.feU.setGifIconSupport(false);
        this.feU.setEvent(this.ffc);
        this.feU.setRadius(com.baidu.adp.lib.util.l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.feU;
        TbImageView tbImageView2 = this.feU;
        tbImageView.setConrers(15);
        this.feU.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.feU.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.feU.setBorderSurroundContent(true);
        this.feU.setDrawBorder(true);
        this.feV = (ImageView) view.findViewById(R.id.image_video_play);
        this.gmj.setOnClickListener(this);
        this.ZH = new TbCyberVideoView(getContext());
        this.ZH.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.feS.addView(this.ZH.getView(), 0);
        this.ZH.getView().setLayoutParams(layoutParams3);
        this.ZH.setContinuePlayEnable(true);
        this.ZH.setOnPreparedListener(this.dNO);
        this.ZH.setOnInfoListener(this.dNR);
        this.ZH.setOnCompletionListener(this.dNQ);
        this.ZH.setOnErrorListener(this.dNP);
        this.ZH.setOnSurfaceDestroyedListener(this.ffg);
        this.fHc = new com.baidu.tieba.play.f();
        this.fHc.setPlayer(this.ZH);
        this.fHc.a(this.hqJ);
        this.feT = (TextView) view.findViewById(R.id.text_video_duration);
        this.hqu = (LinearLayout) view.findViewById(R.id.duration_container);
        this.ffa = (TextView) view.findViewById(R.id.text_video_play_count);
        this.feZ = view.findViewById(R.id.auto_video_black_mask);
        this.feW = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.feX = view.findViewById(R.id.auto_video_error_background);
        this.fxB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bDF = AnimationUtils.loadAnimation(this.ehG.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bDF.setAnimationListener(this.hqK);
        this.hqs = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hqs.setOnClickListener(this);
        this.fpN = view.findViewById(R.id.divider_line);
        this.hqA = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.ZH.getView().setOnClickListener(this);
        this.hqC = (TextView) view.findViewById(R.id.nani_video_icon);
        this.hqq = new com.baidu.afd.videopaster.d(getContext(), this.feS);
        this.hqq.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rQ() {
                if (!l.this.hqB) {
                    l.this.ZH.start();
                } else {
                    l.this.startPlay();
                }
                l.this.hqB = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rP() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rS() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.hqv != null && this.hqv.dXg != null && this.hqv.dXg.efQ > 0) {
            if (ceP() != null) {
                ceP().a(view, this.hqv);
            }
            this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.ehG.getPageActivity(), this.hqv.dXg.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.bfk(), this.hqv.bdb())));
            return;
        }
        if (view == this.gmj || view == this.hqs) {
            cg(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.ZH.getView()) {
            if (this.hqv != null) {
                this.hqv.objType = 5;
            }
            if (this.hqv != null && this.hqv.dXg != null && this.hqv.dXg.bfQ() != null) {
                z = this.hqv.dXg.bfQ().is_vertical.intValue() == 1;
            }
            if (z) {
                ce(this.ZH.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cf(this.ZH.getView());
            } else {
                cg(getView());
            }
        }
    }

    private void ce(View view) {
        if (ceP() != null) {
            ceP().a(view, this.hqv);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.ehG.getPageActivity(), R.string.no_network_guide);
        } else {
            ceW();
        }
    }

    private void cf(View view) {
        if (ceP() != null) {
            ceP().a(view, this.hqv);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.ehG.getPageActivity(), R.string.no_network_guide);
        } else {
            ceX();
        }
    }

    private void ceW() {
        if (this.hqv != null && this.hqv.dXg != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.hqv.dXg);
            videoItemData.mRecomExtra = this.hqv.getExtra();
            videoItemData.mRecomAbTag = this.hqv.cfA();
            videoItemData.mRecomSource = this.hqv.getSource();
            videoItemData.mRecomWeight = this.hqv.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.hqv.bdb(), "index");
            if (this.hqv.dXg.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.hqv.dXg.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void ceX() {
        if (this.hqv != null && this.hqv.dXg != null && this.hqv.dXg.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.hqv.dXg);
            videoSerializeVideoThreadInfo.source = this.hqv.getSource();
            videoSerializeVideoThreadInfo.extra = this.hqv.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.hqv.cfA();
            videoSerializeVideoThreadInfo.weight = this.hqv.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fxB.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fxB.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.ehG.getPageActivity(), str, this.hqv.dXg.getTid(), m.bfk(), this.hqv.bdb(), videoSerializeVideoThreadInfo);
            if (this.hqv.bcY() != null && this.hqv.bcY().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.hqv.bcY().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cg(View view) {
        if (this.hqv != null) {
            this.hqv.objType = 1;
        }
        if (ceP() != null) {
            ceP().a(view, this.hqv);
        }
        if (this.hqv != null && this.hqv.dXg != null) {
            if (!ceY()) {
                m.Hw(this.hqv.dXg.getId());
                m.a(this.mTextTitle, this.hqv.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ehG.getPageActivity()).createFromThreadCfg(this.hqv.dXg, null, m.bfk(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hqv.bdb());
            addLocateParam.setVideo_source(this.hqv.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.hqv.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.hqv.dXg.getFid()));
            addLocateParam.setForumName(this.hqv.dXg.bfC());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.hqs) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceY() {
        return this.hqv.huw && !this.hqv.huB;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.hqv = mVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceZ() {
        this.hqD.removeMessages(202);
        if (this.ZH.getCurrentPositionSync() > this.ZN) {
            v(false, 3);
            this.hqD.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hqD.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hqD.removeMessages(203);
        int currentPositionSync = this.ZH.getCurrentPositionSync();
        if (currentPositionSync != this.hqw) {
            this.hqw = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.hqD.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.feV != null && this.feU != null && this.feZ != null && this.feY != null && this.feX != null && this.feW != null) {
            if (z || this.ffb != i) {
                this.ffb = i;
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fff);
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ffe);
                if (i == 2) {
                    this.feV.setVisibility(8);
                    this.bDF.cancel();
                    this.feU.clearAnimation();
                    this.feU.setVisibility(0);
                    this.feZ.setVisibility(0);
                    this.hqu.setVisibility(0);
                    this.hqA.setVisibility(8);
                    this.feY.startLoading();
                    this.feX.setVisibility(8);
                    this.feW.setVisibility(8);
                    com.baidu.adp.lib.f.e.mX().postDelayed(this.fff, 60000L);
                } else if (i == 3) {
                    this.feV.setVisibility(8);
                    this.feU.startAnimation(this.bDF);
                    this.feZ.setVisibility(8);
                    this.hqu.setVisibility(8);
                    if (this.hqv != null && this.hqv.bcY() != null && this.hqv.bcY().efQ > 0) {
                        this.hqA.setVisibility(0);
                    }
                    this.feY.dnI();
                    this.feX.setVisibility(8);
                    this.feW.setVisibility(8);
                    if (this.hqv != null && this.hqv.dXg != null && this.hqv.dXg.bfQ() != null) {
                        this.hqv.dXg.bfQ().video_length.intValue();
                        this.hqv.dXg.bfQ().video_duration.intValue();
                        this.hqv.dXg.getTid();
                    }
                } else if (i == 4) {
                    this.feV.setVisibility(8);
                    this.feU.startAnimation(this.bDF);
                    this.feZ.setVisibility(8);
                    this.feY.dnJ();
                    this.feX.setVisibility(0);
                    this.feW.setVisibility(0);
                    com.baidu.adp.lib.f.e.mX().postDelayed(this.ffe, 2000L);
                } else {
                    this.feV.setVisibility(0);
                    this.bDF.cancel();
                    this.feU.clearAnimation();
                    this.feU.setVisibility(0);
                    this.feZ.setVisibility(0);
                    this.hqu.setVisibility(0);
                    this.feY.dnJ();
                    this.feX.setVisibility(8);
                    this.feW.setVisibility(8);
                }
                if (this.hqv != null && this.hqv.bcY() != null && this.hqv.bcY().efQ > 0) {
                    this.hqu.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.hqv == null || this.hqv.dXg == null || this.hqv.dXg.bfy() == null) {
            this.gmj.setVisibility(8);
            return;
        }
        this.gmj.setVisibility(0);
        cfc();
        if (!ceY() && m.Hx(this.hqv.dXg.getId())) {
            m.a(this.mTextTitle, this.hqv.dXg.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hqs.getGodReplyContent(), this.hqv.bcY().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        this.hqv.bcY().bgw();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hqv.bcY().bgi());
        if (this.hqv.bcY().bgo() && !StringUtils.isNull(this.hqv.bcY().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bjf().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.hqv.bcY().getTid();
            spannableStringBuilder.append((CharSequence) this.hqv.bcY().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dF("obj_source", "0"));
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
        this.gmk.setData(this.hqv.bcY());
        this.gmk.setUserAfterClickListener(this.hqG);
        if (this.gmk.getHeaderImg() != null) {
            this.gmk.getHeaderImg().setAfterClickListener(this.hqH);
            if (this.gmk.getIsSimpleThread()) {
                this.gmk.getHeaderImg().setVisibility(8);
                this.hqt.setVisibility(8);
            } else if (this.hqv.bcY() == null || this.hqv.bcY().bfy() == null || this.hqv.bcY().bfy().getPendantData() == null || StringUtils.isNull(this.hqv.bcY().bfy().getPendantData().bdu())) {
                this.hqt.setVisibility(8);
                this.gmk.getHeaderImg().setVisibility(0);
                if (this.hqv.bcY().efQ > 0 && this.hqv.bcY().efR == 0) {
                    this.hqv.bcY().bfy().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.gmk.getHeaderImg().setData(this.hqv.bcY(), false);
                } else {
                    this.gmk.getHeaderImg().setData(this.hqv.bcY());
                    this.gmk.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.gmk.getHeaderImg().setVisibility(4);
                this.hqt.setVisibility(0);
                this.hqt.setData(this.hqv.bcY());
            }
        }
        this.feT.setText(at.stringForVideoTime(this.hqv.dXg.bfQ().video_duration.intValue() * 1000));
        this.ffa.setText(String.format(this.ehG.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hqv.dXg.bfQ().play_count.intValue())));
        if (this.gmw != null && this.hqv.bcY() != null) {
            ar arVar = new ar();
            arVar.setTid(this.hqv.bcY().getTid());
            arVar.setFid(this.hqv.bcY().getFid());
            arVar.setNid(this.hqv.bcY().getNid());
            arVar.setFeedBackReasonMap(this.hqv.feedBackReasonMap);
            this.gmw.setData(arVar);
            this.gmw.setFirstRowSingleColumn(true);
            this.gmw.setVisibility(this.hqy ? 0 : 8);
        }
        this.hqs.setData(this.hqv.bcY().bhb());
        tU(sq(1));
        onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
        if (m.Hx(this.hqv.dXg.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.hqv == null || this.hqv.dXg == null || this.hqv.dXg.bfQ() == null) {
            z = false;
        } else {
            z = this.hqv.dXg.bfQ().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hqC.setVisibility(0);
            if (cfd()) {
                this.hqC.setText(String.format("%s | %s", this.ehG.getResources().getString(R.string.nani_video), this.ehG.getResources().getString(R.string.video_preview)));
            } else {
                this.hqC.setText(this.ehG.getString(R.string.nani_video));
            }
        } else if (cfd()) {
            this.hqC.setVisibility(0);
            this.hqC.setText(this.ehG.getString(R.string.video_preview));
        } else {
            this.hqC.setVisibility(8);
        }
    }

    private void cfb() {
        this.hqD.removeMessages(202);
        this.hqD.removeMessages(203);
    }

    private void byq() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ffe);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fff);
    }

    private void cfc() {
        byq();
        cfb();
        if (this.feU != null && this.feS != null && this.ZH != null) {
            if (com.baidu.tbadk.core.k.bcG().isShowImages() && this.hqv != null && this.hqv.dXg != null && this.hqv.dXg.bfQ() != null) {
                this.feU.setPlaceHolder(3);
                this.feU.startLoad(this.hqv.dXg.bfQ().thumbnail_url, 10, false);
                this.feS.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.hqv.dXg.bfQ().video_url;
                if (cfd()) {
                    this.mVideoUrl = this.hqv.dXg.bfR().video_url;
                }
                if (StringUtils.isNull(this.hqv.dXg.bfQ().video_url)) {
                    v(true, 4);
                }
                this.ZH.setThreadDataForStatistic(this.hqv.dXg);
            } else {
                this.feS.setVisibility(8);
            }
            this.hqq.reset();
            this.fHc.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void ca(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.hqq.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.hqv);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.m mVar) {
        if (mVar != null && mVar.dXg != null) {
            bw bwVar = mVar.dXg;
            if (bwVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bwVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.m mVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (mVar == null || mVar.dXg == null || bVar == null) {
            return null;
        }
        bw bwVar = mVar.dXg;
        int rW = bVar.rW();
        int rX = bVar.rX();
        int rV = bVar.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo bfQ = bwVar.bfQ();
        if (bfQ != null) {
            i3 = bfQ.video_width.intValue();
            i2 = bfQ.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.bfC());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a.u(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gmj, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.feV, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.feW, R.color.cp_cont_a);
            ap.setViewTextColor(this.feT, R.color.cp_cont_a);
            ap.setViewTextColor(this.ffa, R.color.cp_cont_a);
            ap.setViewTextColor(this.hqA, R.color.cp_cont_a);
            ap.setBackgroundColor(this.feX, R.color.common_color_10014);
            ap.setBackgroundColor(this.fpN, R.color.cp_bg_line_c);
            if (this.hqC != null) {
                ap.setViewTextColor(this.hqC, R.color.cp_cont_a);
                ap.setBackgroundResource(this.hqC, R.drawable.video_play_count_bg);
            }
            if (this.feW != null) {
                this.feW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.hqs.onChangeSkinType();
            if (this.gmw != null) {
                this.gmw.onChangeSkinType();
            }
            this.gmk.onChangeSkinType();
            this.gml.onChangeSkinType();
            this.gmX.onChangeSkinType();
            this.feU.setPlaceHolder(3);
            this.hqt.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hqI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hqI);
            this.hqF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hqF);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gmk != null) {
            this.gmk.setPageUniqueId(bdUniqueId);
        }
        if (this.feU != null) {
            this.feU.setPageId(bdUniqueId);
        }
        if (this.gmw != null) {
            this.gmw.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.hqx;
    }

    public boolean isPlaying() {
        if (this.ZH == null) {
            return false;
        }
        return this.ZH.isPlaying();
    }

    public void startPlay() {
        if (!this.hqx && this.hqv != null && this.hqv.dXg != null && this.hqv.dXg.bfQ() != null && this.ZH != null) {
            if (this.hqq.rA()) {
                this.hqq.resume();
                this.hqB = true;
                return;
            }
            this.hqB = false;
            this.ZH.stopPlayback();
            if (ai.at(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dF("obj_locate", "index").dF("tid", this.hqv.tid));
                    this.mVideoUrl = this.hqv.dXg.bfQ().video_url;
                }
                this.hqx = true;
                this.ZH.setVideoPath(this.mVideoUrl, this.hqv.tid);
                if (this.fHc != null) {
                    this.fHc.start();
                }
                ceV();
            }
        }
    }

    public void stopPlay() {
        this.hqB = false;
        byq();
        cfb();
        v(true, 1);
        if (this.ZH != null) {
            this.ZH.stopPlayback();
            if (this.fHc != null) {
                this.fHc.stop();
            }
        }
        this.hqx = false;
        this.hqq.stop();
    }

    public View getVideoContainer() {
        return this.feS;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZH == null) {
            return 0;
        }
        return this.ZH.getCurrentPosition();
    }

    public void nl(boolean z) {
        this.hqy = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void tU(int i) {
        if (this.hqv != null && this.hqv.dXg != null) {
            if (i == 1) {
                if (this.hqv.dXg.efQ > 0) {
                    this.gmX.exc.setShowPraiseNum(false);
                    this.gmX.exc.setShareVisible(false);
                    this.hqA.setText(at.numFormatOverWan(this.hqv.dXg.efQ));
                    this.hqA.setVisibility(0);
                } else {
                    this.gmX.exc.setShowPraiseNum(true);
                    this.gmX.exc.setShareVisible(true);
                    this.hqA.setVisibility(8);
                }
                this.gmX.setData(this.hqv.dXg);
                this.gml.setVisibility(8);
                this.gmk.iz(false);
                return;
            }
            this.gmX.setVisibility(8);
            this.gmk.iz(true);
            if (this.hqv.dXg.efQ > 0) {
                this.gml.setShowPraiseNum(false);
                this.gml.setShareVisible(false);
                this.hqA.setText(at.numFormatOverWan(this.hqv.dXg.efQ));
                this.hqA.setVisibility(0);
            } else {
                this.gml.setShowPraiseNum(true);
                this.gml.setShareVisible(true);
                this.hqA.setVisibility(8);
            }
            if (this.gml.setData(this.hqv.dXg)) {
                this.hqr.setVisibility(8);
            } else {
                this.hqr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public int sq(int i) {
        return com.baidu.tieba.a.d.bBN().au(this.ahc, i);
    }

    private boolean cfd() {
        return (this.hqv == null || this.hqv.dXg == null || this.hqv.dXg.bfR() == null || TextUtils.isEmpty(this.hqv.dXg.bfR().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.hqq.onDestroy();
    }
}
