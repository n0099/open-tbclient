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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class n extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private String aFr;
    private final View.OnClickListener aJb;
    private Animation bOT;
    private com.baidu.tieba.play.j bPd;
    private com.baidu.tieba.play.n bPe;
    public FrameLayout bpC;
    private TextView bpD;
    private TbImageView bpE;
    private ImageView bpF;
    private QuickVideoView bpG;
    private TextView bpH;
    private View bpI;
    private com.baidu.tieba.play.x bpJ;
    private View bpK;
    private TextView bpL;
    private int bpM;
    private TbImageView.a bpN;
    private g.b bpO;
    private Runnable bpQ;
    private Runnable bpR;
    private QuickVideoView.b bpS;
    private g.a byA;
    private g.f byB;
    private g.e byD;
    private View bzH;
    public ThreadGodReplyLayout cVS;
    private View cXV;
    private com.baidu.tieba.play.g cYa;
    private LinearLayout cYb;
    private com.baidu.tieba.j.k cYc;
    private com.baidu.tieba.card.data.l cYd;
    private int cYe;
    private boolean cYf;
    private boolean cYg;
    private boolean cYh;
    private int cYi;
    private TextView cYj;
    private TextView cYk;
    private Handler cYl;
    private VideoLoadingProgressView.a cYm;
    private final View.OnClickListener cYn;
    private final View.OnClickListener cYo;
    private CustomMessageListener cYp;
    private j.a cYq;
    private Animation.AnimationListener cYr;
    private NEGFeedBackView cbJ;
    private String cbl;
    private RelativeLayout cbw;
    public ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    public ThreadSourceShareAndPraiseLayout ccl;
    protected LinearLayout ccx;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        if (this.cYa != null && this.cYf) {
            try {
                this.bpG.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.cYa.isPlayerReuse()) {
                int up = com.baidu.tieba.play.y.btx().up(this.aFr);
                if (up <= 100 || this.cYa.getDuration() <= up) {
                    up = 100;
                }
                this.cYi = up;
            } else {
                this.cYi = 100;
            }
            this.cYl.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.cYd != null && this.cYd.bNA != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.cYd.sourceType == 0 ? "index" : "hot_juhe";
            zVar.bjn = this.cYd.bNA.getTid();
            zVar.dbs = this.cYd.bNA.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.cYd.bNA.mRecomSource;
            zVar.gIJ = this.cYd.bNA.mRecomAbTag;
            zVar.gIK = this.cYd.bNA.mRecomWeight;
            zVar.gIL = "";
            zVar.arK = this.cYd.getExtra();
            if (this.cYd.bNA.Al() != null) {
                zVar.gIN = this.cYd.bNA.Al().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cYd.bNA.Al().video_md5, "", "1", zVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbJ = null;
        this.mSkinType = 3;
        this.cYe = 0;
        this.bpM = 1;
        this.cYf = false;
        this.cYg = true;
        this.cYh = false;
        this.cYi = 100;
        this.cYl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aqB();
                        return;
                    case 203:
                        n.this.aqC();
                        return;
                    default:
                        return;
                }
            }
        };
        this.byB = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cYa = gVar;
                if (n.this.cYa != null) {
                    n.this.cYa.setVolume(0.0f, 0.0f);
                }
                n.this.cYc.bdY();
                n.this.aqx();
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    n.this.e(false, 3);
                }
                return false;
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                n.this.bpG.start();
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                n.this.cYf = false;
                return true;
            }
        };
        this.cYm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aqx();
            }
        };
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && n.this.bpE != null) {
                    n.this.bpE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tieba.card.n.18
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.bpG != null && !n.this.bpG.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.bpR = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cYn = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cYd == null) {
                    if (n.this.aqp() != null) {
                        n.this.aqp().a(view, n.this.cYd);
                        return;
                    }
                    return;
                }
                if (view == n.this.cbx.getUserName()) {
                    n.this.cYd.aFT = 3;
                } else if (view == n.this.cbx.getHeaderImg()) {
                    n.this.cYd.aFT = 4;
                } else {
                    n.this.cYd.aFT = 1;
                }
                if (n.this.aqp() != null) {
                    n.this.aqp().a(view, n.this.cYd);
                }
            }
        };
        this.cYo = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cYd != null) {
                    n.this.cYd.aFT = 4;
                }
                if (n.this.aqp() != null) {
                    n.this.aqp().a(view, n.this.cYd);
                }
            }
        };
        this.cYp = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cYh = false;
                }
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cYd != null) {
                    if (n.this.aqp() != null) {
                        n.this.aqp().a(view, n.this.cYd);
                    }
                    if (n.this.cYd.bNA != null && view != n.this.ccl.aKM) {
                        o.mW(n.this.cYd.bNA.getId());
                        if (!n.this.aqt()) {
                            o.a(n.this.mTextTitle, n.this.cYd.bNA.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                            o.a(n.this.cVS.getGodReplyContent(), n.this.cYd.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cYq = new j.a() { // from class: com.baidu.tieba.card.n.8
            @Override // com.baidu.tieba.play.j.a
            public void aqF() {
                if (n.this.cYd != null && n.this.cYd.bNA != null && n.this.cYd.bNA.Al() != null) {
                    n.this.aqy();
                }
            }
        };
        this.cYr = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.bpE != null) {
                    n.this.bpE.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.cbw = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cci = (HeadPendantClickableView) this.cbw.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.bpJ = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bpJ.setLoadingAnimationListener(this.cYm);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.cbJ = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16);
        this.cbJ.a(this.cbw, h, 0);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.setShareReportFrom(3);
        this.cby.setForumAfterClickListener(this.aJb);
        this.cby.setFrom(1);
        this.cby.setDisPraiseFrom(1);
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.ccl.aKN.setOnClickListener(this);
        this.ccl.setFrom(1);
        this.ccl.setShareReportFrom(3);
        this.ccl.setForumAfterClickListener(this.aJb);
        this.cXV = view.findViewById(e.g.divider_below_reply_number_layout);
        this.bpC = (FrameLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bpC.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bpC.setLayoutParams(layoutParams2);
        this.bpE = (TbImageView) view.findViewById(e.g.image_video);
        this.bpE.setDefaultErrorResource(0);
        this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpE.setGifIconSupport(false);
        this.bpE.setEvent(this.bpN);
        this.bpF = (ImageView) view.findViewById(e.g.image_video_play);
        this.cbw.setOnClickListener(this);
        this.bpG = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.bPe = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.bpG.setPlayerReuseEnable(true);
        this.bpG.setContinuePlayEnable(true);
        this.bpG.setBusiness(this.bPe);
        this.bpG.setOnPreparedListener(this.byB);
        this.bpG.setOnOutInfoListener(this.byD);
        this.bpG.setOnCompletionListener(this.byA);
        this.bpG.setOnErrorListener(this.bpO);
        this.bpG.setOnSurfaceDestroyedListener(this.bpS);
        this.bPd = new com.baidu.tieba.play.j();
        this.bPd.setPlayer(this.bpG);
        this.bPd.a(this.cYq);
        this.bpD = (TextView) view.findViewById(e.g.text_video_duration);
        this.cYb = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bpL = (TextView) view.findViewById(e.g.text_video_play_count);
        this.bpK = view.findViewById(e.g.auto_video_black_mask);
        this.bpH = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bpI = view.findViewById(e.g.auto_video_error_background);
        this.ccx = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bOT = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bOT.setAnimationListener(this.cYr);
        this.cVS = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVS.setOnClickListener(this);
        this.bzH = view.findViewById(e.g.divider_line);
        this.cYj = (TextView) view.findViewById(e.g.txt_video_num_during_playing);
        this.bpG.setOnClickListener(this);
        this.cYk = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cYc = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.avU > 0) {
            if (aqp() != null) {
                aqp().a(view, this.cYd);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cYd.bNA.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.zH(), this.cYd.ara())));
            return;
        }
        if (view == this.cbw || view == this.cVS) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bpG) {
            if (this.cYd != null) {
                this.cYd.aFT = 5;
            }
            if (this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.Al() != null) {
                z = this.cYd.bNA.Al().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(this.bpG);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aE(this.bpG);
            } else {
                aF(getView());
            }
        }
    }

    private void aD(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYd);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aE(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYd);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqA();
        }
    }

    private void aqz() {
        if (this.cYd != null && this.cYd.bNA != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cYd.bNA);
            videoItemData.mRecomExtra = this.cYd.getExtra();
            videoItemData.mRecomAbTag = this.cYd.arb();
            videoItemData.mRecomSource = this.cYd.getSource();
            videoItemData.mRecomWeight = this.cYd.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cYd.ara(), "index")));
        }
    }

    private void aqA() {
        if (this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cYd.bNA);
            videoSerializeVideoThreadInfo.source = this.cYd.getSource();
            videoSerializeVideoThreadInfo.extra = this.cYd.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.cYd.arb();
            videoSerializeVideoThreadInfo.weight = this.cYd.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.ccx.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.ccx.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ao.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cYd.bNA.getTid(), o.zH(), this.cYd.ara(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aF(View view) {
        if (this.cYd != null) {
            this.cYd.aFT = 1;
        }
        if (aqp() != null) {
            aqp().a(view, this.cYd);
        }
        if (this.cYd != null && this.cYd.bNA != null) {
            if (!aqt()) {
                o.mW(this.cYd.bNA.getId());
                o.a(this.mTextTitle, this.cYd.bNA.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cYd.bNA, null, o.zH(), 18003, true, false, false).addLocateParam(this.cYd.ara());
            addLocateParam.setVideo_source(this.cYd.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cYd.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cYd.bNA.getFid()));
            addLocateParam.setForumName(this.cYd.bNA.zZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVS) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqt() {
        return this.cYd.dbK && !this.cYd.dbU;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cYd = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqB() {
        this.cYl.removeMessages(202);
        if (this.bpG.getCurrentPosition() > this.cYi) {
            e(false, 3);
            this.cYl.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cYl.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqC() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cYl.removeMessages(203);
        int currentPosition = this.bpG.getCurrentPosition();
        if (currentPosition != this.cYe) {
            this.cYe = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cYl.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bpF != null && this.bpE != null && this.bpK != null && this.bpJ != null && this.bpI != null && this.bpH != null) {
            if (z || this.bpM != i) {
                this.bpM = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpR);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
                if (i == 2) {
                    this.bpF.setVisibility(8);
                    this.bOT.cancel();
                    this.bpE.clearAnimation();
                    this.bpE.setVisibility(0);
                    this.bpK.setVisibility(0);
                    this.cYb.setVisibility(0);
                    this.cYj.setVisibility(8);
                    this.bpJ.startLoading();
                    this.bpI.setVisibility(8);
                    this.bpH.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpR, 60000L);
                } else if (i == 3) {
                    this.bpF.setVisibility(8);
                    this.bpE.startAnimation(this.bOT);
                    this.bpK.setVisibility(8);
                    this.cYb.setVisibility(8);
                    if (this.cYd != null && this.cYd.aaq() != null && this.cYd.aaq().avU > 0) {
                        this.cYj.setVisibility(0);
                    }
                    this.bpJ.bts();
                    this.bpI.setVisibility(8);
                    this.bpH.setVisibility(8);
                    if (this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.Al() != null) {
                        this.cYc.a(this.cYd.bNA.getTid(), this.cYd.bNA.Al().video_length.intValue(), this.cYd.bNA.Al().video_duration.intValue(), "homepage", this.bpG);
                    }
                } else if (i == 4) {
                    this.bpF.setVisibility(8);
                    this.bpE.startAnimation(this.bOT);
                    this.bpK.setVisibility(8);
                    this.bpJ.btt();
                    this.bpI.setVisibility(0);
                    this.bpH.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpQ, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.bpF.setVisibility(0);
                    this.bOT.cancel();
                    this.bpE.clearAnimation();
                    this.bpE.setVisibility(0);
                    this.bpK.setVisibility(0);
                    this.cYb.setVisibility(0);
                    this.bpJ.btt();
                    this.bpI.setVisibility(8);
                    this.bpH.setVisibility(8);
                }
                if (this.cYd != null && this.cYd.aaq() != null && this.cYd.aaq().avU > 0) {
                    this.cYb.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cYd == null || this.cYd.bNA == null || this.cYd.bNA.zT() == null) {
            this.cbw.setVisibility(8);
            return;
        }
        this.cbw.setVisibility(0);
        aqD();
        if (!aqt() && o.mX(this.cYd.bNA.getId())) {
            o.a(this.mTextTitle, this.cYd.bNA.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVS.getGodReplyContent(), this.cYd.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cYd.aaq().AD();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cYd.aaq().At());
        if (this.cYd.aaq().AA() && !StringUtils.isNull(this.cYd.aaq().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cYd.aaq().getTid();
            spannableStringBuilder.append((CharSequence) this.cYd.aaq().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.17
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.cbx.setData(this.cYd.aaq());
        this.cbx.setUserAfterClickListener(this.cYn);
        if (this.cbx.getHeaderImg() != null) {
            this.cbx.getHeaderImg().setAfterClickListener(this.cYo);
            if (this.cbx.getIsSimpleThread()) {
                this.cbx.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (this.cYd.aaq() == null || this.cYd.aaq().zT() == null || this.cYd.aaq().zT().getPendantData() == null || StringUtils.isNull(this.cYd.aaq().zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.cbx.getHeaderImg().setVisibility(0);
                if (this.cYd.aaq().avU > 0 && this.cYd.aaq().avV == 0) {
                    this.cYd.aaq().zT().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.cbx.getHeaderImg().setData(this.cYd.aaq(), false);
                } else {
                    this.cbx.getHeaderImg().setData(this.cYd.aaq());
                    this.cbx.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(this.cYd.aaq());
            }
        }
        this.bpD.setText(ao.dV(this.cYd.bNA.Al().video_duration.intValue() * 1000));
        this.bpL.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cYd.bNA.Al().play_count.intValue())));
        if (this.cbJ != null && this.cYd.aaq() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cYd.aaq().getTid());
            ahVar.setFid(this.cYd.aaq().getFid());
            ahVar.a(this.cYd.asF);
            this.cbJ.setData(ahVar);
            this.cbJ.setFirstRowSingleColumn(true);
            this.cbJ.setVisibility(this.cYg ? 0 : 8);
        }
        this.cVS.setData(this.cYd.aaq().Bk());
        iM(hD(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cYd.bNA.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.cYd == null || this.cYd.bNA == null || this.cYd.bNA.Al() == null) {
            z = false;
        } else {
            z = this.cYd.bNA.Al().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cYk.setVisibility(0);
            if (aqE()) {
                this.cYk.setText(String.format("%s | %s", this.mContext.getResources().getString(e.j.nani_video), this.mContext.getResources().getString(e.j.video_preview)));
            } else {
                this.cYk.setText(this.mContext.getString(e.j.nani_video));
            }
        } else if (aqE()) {
            this.cYk.setVisibility(0);
            this.cYk.setText(this.mContext.getString(e.j.video_preview));
        } else {
            this.cYk.setVisibility(8);
        }
    }

    private void apR() {
        this.cYl.removeMessages(202);
        this.cYl.removeMessages(203);
    }

    private void Si() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpR);
    }

    private void aqD() {
        Si();
        apR();
        if (this.bpE != null && this.bpC != null && this.bpG != null) {
            if (com.baidu.tbadk.core.i.xR().xV() && this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.Al() != null) {
                this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpE.startLoad(this.cYd.bNA.Al().thumbnail_url, 10, false);
                this.bpC.setVisibility(0);
                stopPlay();
                this.aFr = this.cYd.bNA.Al().video_url;
                if (aqE()) {
                    this.aFr = this.cYd.bNA.Am().video_url;
                }
                if (StringUtils.isNull(this.cYd.bNA.Al().video_url)) {
                    e(true, 4);
                }
                if (this.bPe != null && this.bPe.btb() != null) {
                    this.bPe.btb().g(this.cYd.bNA.Al());
                }
                this.bpG.cu(this.aFr, this.cYd.tid);
                return;
            }
            this.bpC.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cbw, e.f.addresslist_item_bg);
            al.c(this.bpF, e.f.btn_icon_play_video_n);
            al.h(this.bpH, e.d.cp_cont_i);
            al.h(this.bpD, e.d.cp_cont_i);
            al.h(this.bpL, e.d.cp_cont_i);
            al.h(this.cYj, e.d.cp_cont_i);
            al.j(this.bpI, e.d.common_color_10014);
            al.j(this.bzH, e.d.cp_bg_line_e);
            if (this.cYk != null) {
                al.h(this.cYk, e.d.cp_cont_i);
                al.i(this.cYk, e.f.video_play_count_bg);
            }
            if (this.bpH != null) {
                this.bpH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cVS.onChangeSkinType();
            if (this.cbJ != null) {
                this.cbJ.onChangeSkinType();
            }
            this.cbx.onChangeSkinType();
            this.cby.onChangeSkinType();
            this.ccl.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cYp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYp);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbx != null) {
            this.cbx.setPageUniqueId(bdUniqueId);
        }
        if (this.bpE != null) {
            this.bpE.setPageId(bdUniqueId);
        }
        if (this.cbJ != null) {
            this.cbJ.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cYf;
    }

    public boolean isPlaying() {
        if (this.bpG == null) {
            return false;
        }
        return this.bpG.isPlaying();
    }

    public void startPlay() {
        if (!this.cYf && this.cYd != null && this.cYd.bNA != null && this.cYd.bNA.Al() != null && this.bpG != null) {
            this.bpG.stopPlayback();
            if (com.baidu.tbadk.util.ab.r(1, this.aFr)) {
                this.cYc.bdX();
                e(true, 2);
                if (StringUtils.isNull(this.aFr)) {
                    TiebaStatic.log(new am("c12619").aB("obj_locate", "index").aB("tid", this.cYd.tid));
                    this.aFr = this.cYd.bNA.Al().video_url;
                }
                this.cYf = true;
                this.bpG.setVideoPath(this.aFr, this.cYd.tid);
                if (this.bPd != null) {
                    this.bPd.start();
                }
                aqy();
            }
        }
    }

    public void stopPlay() {
        Si();
        apR();
        e(true, 1);
        if (this.bpG != null) {
            this.bpG.stopPlayback();
            if (this.bPd != null) {
                this.bPd.stop();
            }
        }
        this.cYf = false;
    }

    public View getVideoContainer() {
        return this.bpC;
    }

    public String getPlayUrl() {
        return this.aFr;
    }

    public int getCurrentPosition() {
        if (this.bpG == null) {
            return 0;
        }
        return this.bpG.getCurrentPosition();
    }

    public QuickVideoView getVideoView() {
        return this.bpG;
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.bPe != null) {
            this.bPe.setVideoStatsData(zVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbJ != null) {
            this.cbJ.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbx != null) {
            return this.cbx.aKS;
        }
        return null;
    }

    public View aqs() {
        if (this.cbx != null) {
            return this.cbx.aKU;
        }
        return null;
    }

    public void ft(boolean z) {
        this.cYg = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void iM(int i) {
        if (this.cYd != null && this.cYd.bNA != null) {
            if (i == 1) {
                if (this.cYd.bNA.avU > 0) {
                    this.ccl.aKN.setShowPraiseNum(false);
                    this.ccl.aKN.setShareVisible(false);
                    this.cYj.setText(ao.X(this.cYd.bNA.avU));
                    this.cYj.setVisibility(0);
                } else {
                    this.ccl.aKN.setShowPraiseNum(true);
                    this.ccl.aKN.setShareVisible(true);
                    this.cYj.setVisibility(8);
                }
                this.ccl.setData(this.cYd.bNA);
                this.cby.setVisibility(8);
                this.cbx.showForumNameView(false);
                return;
            }
            this.ccl.setVisibility(8);
            this.cbx.showForumNameView(true);
            if (this.cYd.bNA.avU > 0) {
                this.cby.setShowPraiseNum(false);
                this.cby.setShareVisible(false);
                this.cYj.setText(ao.X(this.cYd.bNA.avU));
                this.cYj.setVisibility(0);
            } else {
                this.cby.setShowPraiseNum(true);
                this.cby.setShareVisible(true);
                this.cYj.setVisibility(8);
            }
            if (this.cby.setData(this.cYd.bNA)) {
                this.cXV.setVisibility(8);
            } else {
                this.cXV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bpE.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.n.10
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bpE.setOnDrawListener(null);
        }
    }

    private boolean aqE() {
        return (this.cYd == null || this.cYd.bNA == null || this.cYd.bNA.Am() == null || TextUtils.isEmpty(this.cYd.bNA.Am().video_url)) ? false : true;
    }

    public void kL(int i) {
        if (this.cby != null) {
            this.cby.aKg = String.valueOf(i);
        }
    }
}
