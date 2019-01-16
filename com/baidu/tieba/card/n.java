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
    private String aFq;
    private final View.OnClickListener aJa;
    private Animation bOS;
    private com.baidu.tieba.play.j bPc;
    private com.baidu.tieba.play.n bPd;
    public FrameLayout bpB;
    private TextView bpC;
    private TbImageView bpD;
    private ImageView bpE;
    private QuickVideoView bpF;
    private TextView bpG;
    private View bpH;
    private com.baidu.tieba.play.x bpI;
    private View bpJ;
    private TextView bpK;
    private int bpL;
    private TbImageView.a bpM;
    private g.b bpN;
    private Runnable bpP;
    private Runnable bpQ;
    private QuickVideoView.b bpR;
    private g.f byA;
    private g.e byC;
    private g.a byz;
    private View bzG;
    public ThreadGodReplyLayout cVR;
    private View cXU;
    private com.baidu.tieba.play.g cXZ;
    private LinearLayout cYa;
    private com.baidu.tieba.j.k cYb;
    private com.baidu.tieba.card.data.l cYc;
    private int cYd;
    private boolean cYe;
    private boolean cYf;
    private boolean cYg;
    private int cYh;
    private TextView cYi;
    private TextView cYj;
    private Handler cYk;
    private VideoLoadingProgressView.a cYl;
    private final View.OnClickListener cYm;
    private final View.OnClickListener cYn;
    private CustomMessageListener cYo;
    private j.a cYp;
    private Animation.AnimationListener cYq;
    private NEGFeedBackView cbI;
    private String cbk;
    private RelativeLayout cbv;
    public ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    public ThreadSourceShareAndPraiseLayout cck;
    protected LinearLayout ccw;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        if (this.cXZ != null && this.cYe) {
            try {
                this.bpF.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.cXZ.isPlayerReuse()) {
                int up = com.baidu.tieba.play.y.btx().up(this.aFq);
                if (up <= 100 || this.cXZ.getDuration() <= up) {
                    up = 100;
                }
                this.cYh = up;
            } else {
                this.cYh = 100;
            }
            this.cYk.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.cYc != null && this.cYc.bNz != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.cYc.sourceType == 0 ? "index" : "hot_juhe";
            zVar.bjm = this.cYc.bNz.getTid();
            zVar.dbr = this.cYc.bNz.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.cYc.bNz.mRecomSource;
            zVar.gII = this.cYc.bNz.mRecomAbTag;
            zVar.gIJ = this.cYc.bNz.mRecomWeight;
            zVar.gIK = "";
            zVar.arJ = this.cYc.getExtra();
            if (this.cYc.bNz.Al() != null) {
                zVar.gIM = this.cYc.bNz.Al().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cYc.bNz.Al().video_md5, "", "1", zVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbI = null;
        this.mSkinType = 3;
        this.cYd = 0;
        this.bpL = 1;
        this.cYe = false;
        this.cYf = true;
        this.cYg = false;
        this.cYh = 100;
        this.cYk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
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
        this.byA = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cXZ = gVar;
                if (n.this.cXZ != null) {
                    n.this.cXZ.setVolume(0.0f, 0.0f);
                }
                n.this.cYb.bdY();
                n.this.aqx();
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    n.this.e(false, 3);
                }
                return false;
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                n.this.bpF.start();
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                n.this.cYe = false;
                return true;
            }
        };
        this.cYl = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aqx();
            }
        };
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && n.this.bpD != null) {
                    n.this.bpD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpP = new Runnable() { // from class: com.baidu.tieba.card.n.18
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.bpF != null && !n.this.bpF.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cYm = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cYc == null) {
                    if (n.this.aqp() != null) {
                        n.this.aqp().a(view, n.this.cYc);
                        return;
                    }
                    return;
                }
                if (view == n.this.cbw.getUserName()) {
                    n.this.cYc.aFS = 3;
                } else if (view == n.this.cbw.getHeaderImg()) {
                    n.this.cYc.aFS = 4;
                } else {
                    n.this.cYc.aFS = 1;
                }
                if (n.this.aqp() != null) {
                    n.this.aqp().a(view, n.this.cYc);
                }
            }
        };
        this.cYn = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cYc != null) {
                    n.this.cYc.aFS = 4;
                }
                if (n.this.aqp() != null) {
                    n.this.aqp().a(view, n.this.cYc);
                }
            }
        };
        this.cYo = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cYg = false;
                }
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cYc != null) {
                    if (n.this.aqp() != null) {
                        n.this.aqp().a(view, n.this.cYc);
                    }
                    if (n.this.cYc.bNz != null && view != n.this.cck.aKL) {
                        o.mW(n.this.cYc.bNz.getId());
                        if (!n.this.aqt()) {
                            o.a(n.this.mTextTitle, n.this.cYc.bNz.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                            o.a(n.this.cVR.getGodReplyContent(), n.this.cYc.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cYp = new j.a() { // from class: com.baidu.tieba.card.n.8
            @Override // com.baidu.tieba.play.j.a
            public void aqF() {
                if (n.this.cYc != null && n.this.cYc.bNz != null && n.this.cYc.bNz.Al() != null) {
                    n.this.aqy();
                }
            }
        };
        this.cYq = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.bpD != null) {
                    n.this.bpD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.cbv = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cch = (HeadPendantClickableView) this.cbv.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.bpI = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bpI.setLoadingAnimationListener(this.cYl);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.cbI = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16);
        this.cbI.a(this.cbv, h, 0);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.setShareReportFrom(3);
        this.cbx.setForumAfterClickListener(this.aJa);
        this.cbx.setFrom(1);
        this.cbx.setDisPraiseFrom(1);
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.cck.aKM.setOnClickListener(this);
        this.cck.setFrom(1);
        this.cck.setShareReportFrom(3);
        this.cck.setForumAfterClickListener(this.aJa);
        this.cXU = view.findViewById(e.g.divider_below_reply_number_layout);
        this.bpB = (FrameLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bpB.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bpB.setLayoutParams(layoutParams2);
        this.bpD = (TbImageView) view.findViewById(e.g.image_video);
        this.bpD.setDefaultErrorResource(0);
        this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpD.setGifIconSupport(false);
        this.bpD.setEvent(this.bpM);
        this.bpE = (ImageView) view.findViewById(e.g.image_video_play);
        this.cbv.setOnClickListener(this);
        this.bpF = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.bPd = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.bpF.setPlayerReuseEnable(true);
        this.bpF.setContinuePlayEnable(true);
        this.bpF.setBusiness(this.bPd);
        this.bpF.setOnPreparedListener(this.byA);
        this.bpF.setOnOutInfoListener(this.byC);
        this.bpF.setOnCompletionListener(this.byz);
        this.bpF.setOnErrorListener(this.bpN);
        this.bpF.setOnSurfaceDestroyedListener(this.bpR);
        this.bPc = new com.baidu.tieba.play.j();
        this.bPc.setPlayer(this.bpF);
        this.bPc.a(this.cYp);
        this.bpC = (TextView) view.findViewById(e.g.text_video_duration);
        this.cYa = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bpK = (TextView) view.findViewById(e.g.text_video_play_count);
        this.bpJ = view.findViewById(e.g.auto_video_black_mask);
        this.bpG = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bpH = view.findViewById(e.g.auto_video_error_background);
        this.ccw = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bOS = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bOS.setAnimationListener(this.cYq);
        this.cVR = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVR.setOnClickListener(this);
        this.bzG = view.findViewById(e.g.divider_line);
        this.cYi = (TextView) view.findViewById(e.g.txt_video_num_during_playing);
        this.bpF.setOnClickListener(this);
        this.cYj = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cYb = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.avT > 0) {
            if (aqp() != null) {
                aqp().a(view, this.cYc);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cYc.bNz.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.zH(), this.cYc.ara())));
            return;
        }
        if (view == this.cbv || view == this.cVR) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bpF) {
            if (this.cYc != null) {
                this.cYc.aFS = 5;
            }
            if (this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.Al() != null) {
                z = this.cYc.bNz.Al().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(this.bpF);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aE(this.bpF);
            } else {
                aF(getView());
            }
        }
    }

    private void aD(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYc);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aE(View view) {
        if (aqp() != null) {
            aqp().a(view, this.cYc);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqA();
        }
    }

    private void aqz() {
        if (this.cYc != null && this.cYc.bNz != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cYc.bNz);
            videoItemData.mRecomExtra = this.cYc.getExtra();
            videoItemData.mRecomAbTag = this.cYc.arb();
            videoItemData.mRecomSource = this.cYc.getSource();
            videoItemData.mRecomWeight = this.cYc.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cYc.ara(), "index")));
        }
    }

    private void aqA() {
        if (this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cYc.bNz);
            videoSerializeVideoThreadInfo.source = this.cYc.getSource();
            videoSerializeVideoThreadInfo.extra = this.cYc.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.cYc.arb();
            videoSerializeVideoThreadInfo.weight = this.cYc.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.ccw.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.ccw.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ao.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cYc.bNz.getTid(), o.zH(), this.cYc.ara(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aF(View view) {
        if (this.cYc != null) {
            this.cYc.aFS = 1;
        }
        if (aqp() != null) {
            aqp().a(view, this.cYc);
        }
        if (this.cYc != null && this.cYc.bNz != null) {
            if (!aqt()) {
                o.mW(this.cYc.bNz.getId());
                o.a(this.mTextTitle, this.cYc.bNz.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cYc.bNz, null, o.zH(), 18003, true, false, false).addLocateParam(this.cYc.ara());
            addLocateParam.setVideo_source(this.cYc.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cYc.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cYc.bNz.getFid()));
            addLocateParam.setForumName(this.cYc.bNz.zZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVR) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqt() {
        return this.cYc.dbJ && !this.cYc.dbT;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cYc = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqB() {
        this.cYk.removeMessages(202);
        if (this.bpF.getCurrentPosition() > this.cYh) {
            e(false, 3);
            this.cYk.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cYk.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqC() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cYk.removeMessages(203);
        int currentPosition = this.bpF.getCurrentPosition();
        if (currentPosition != this.cYd) {
            this.cYd = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cYk.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bpE != null && this.bpD != null && this.bpJ != null && this.bpI != null && this.bpH != null && this.bpG != null) {
            if (z || this.bpL != i) {
                this.bpL = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpP);
                if (i == 2) {
                    this.bpE.setVisibility(8);
                    this.bOS.cancel();
                    this.bpD.clearAnimation();
                    this.bpD.setVisibility(0);
                    this.bpJ.setVisibility(0);
                    this.cYa.setVisibility(0);
                    this.cYi.setVisibility(8);
                    this.bpI.startLoading();
                    this.bpH.setVisibility(8);
                    this.bpG.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpQ, 60000L);
                } else if (i == 3) {
                    this.bpE.setVisibility(8);
                    this.bpD.startAnimation(this.bOS);
                    this.bpJ.setVisibility(8);
                    this.cYa.setVisibility(8);
                    if (this.cYc != null && this.cYc.aaq() != null && this.cYc.aaq().avT > 0) {
                        this.cYi.setVisibility(0);
                    }
                    this.bpI.bts();
                    this.bpH.setVisibility(8);
                    this.bpG.setVisibility(8);
                    if (this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.Al() != null) {
                        this.cYb.a(this.cYc.bNz.getTid(), this.cYc.bNz.Al().video_length.intValue(), this.cYc.bNz.Al().video_duration.intValue(), "homepage", this.bpF);
                    }
                } else if (i == 4) {
                    this.bpE.setVisibility(8);
                    this.bpD.startAnimation(this.bOS);
                    this.bpJ.setVisibility(8);
                    this.bpI.btt();
                    this.bpH.setVisibility(0);
                    this.bpG.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpP, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.bpE.setVisibility(0);
                    this.bOS.cancel();
                    this.bpD.clearAnimation();
                    this.bpD.setVisibility(0);
                    this.bpJ.setVisibility(0);
                    this.cYa.setVisibility(0);
                    this.bpI.btt();
                    this.bpH.setVisibility(8);
                    this.bpG.setVisibility(8);
                }
                if (this.cYc != null && this.cYc.aaq() != null && this.cYc.aaq().avT > 0) {
                    this.cYa.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cYc == null || this.cYc.bNz == null || this.cYc.bNz.zT() == null) {
            this.cbv.setVisibility(8);
            return;
        }
        this.cbv.setVisibility(0);
        aqD();
        if (!aqt() && o.mX(this.cYc.bNz.getId())) {
            o.a(this.mTextTitle, this.cYc.bNz.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVR.getGodReplyContent(), this.cYc.aaq().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cYc.aaq().AD();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cYc.aaq().At());
        if (this.cYc.aaq().AA() && !StringUtils.isNull(this.cYc.aaq().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cYc.aaq().getTid();
            spannableStringBuilder.append((CharSequence) this.cYc.aaq().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.17
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
        this.cbw.setData(this.cYc.aaq());
        this.cbw.setUserAfterClickListener(this.cYm);
        if (this.cbw.getHeaderImg() != null) {
            this.cbw.getHeaderImg().setAfterClickListener(this.cYn);
            if (this.cbw.getIsSimpleThread()) {
                this.cbw.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (this.cYc.aaq() == null || this.cYc.aaq().zT() == null || this.cYc.aaq().zT().getPendantData() == null || StringUtils.isNull(this.cYc.aaq().zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.cbw.getHeaderImg().setVisibility(0);
                if (this.cYc.aaq().avT > 0 && this.cYc.aaq().avU == 0) {
                    this.cYc.aaq().zT().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.cbw.getHeaderImg().setData(this.cYc.aaq(), false);
                } else {
                    this.cbw.getHeaderImg().setData(this.cYc.aaq());
                    this.cbw.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(this.cYc.aaq());
            }
        }
        this.bpC.setText(ao.dV(this.cYc.bNz.Al().video_duration.intValue() * 1000));
        this.bpK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cYc.bNz.Al().play_count.intValue())));
        if (this.cbI != null && this.cYc.aaq() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cYc.aaq().getTid());
            ahVar.setFid(this.cYc.aaq().getFid());
            ahVar.a(this.cYc.asE);
            this.cbI.setData(ahVar);
            this.cbI.setFirstRowSingleColumn(true);
            this.cbI.setVisibility(this.cYf ? 0 : 8);
        }
        this.cVR.setData(this.cYc.aaq().Bk());
        iM(hD(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mX(this.cYc.bNz.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.cYc == null || this.cYc.bNz == null || this.cYc.bNz.Al() == null) {
            z = false;
        } else {
            z = this.cYc.bNz.Al().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cYj.setVisibility(0);
            if (aqE()) {
                this.cYj.setText(String.format("%s | %s", this.mContext.getResources().getString(e.j.nani_video), this.mContext.getResources().getString(e.j.video_preview)));
            } else {
                this.cYj.setText(this.mContext.getString(e.j.nani_video));
            }
        } else if (aqE()) {
            this.cYj.setVisibility(0);
            this.cYj.setText(this.mContext.getString(e.j.video_preview));
        } else {
            this.cYj.setVisibility(8);
        }
    }

    private void apR() {
        this.cYk.removeMessages(202);
        this.cYk.removeMessages(203);
    }

    private void Si() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpP);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
    }

    private void aqD() {
        Si();
        apR();
        if (this.bpD != null && this.bpB != null && this.bpF != null) {
            if (com.baidu.tbadk.core.i.xR().xV() && this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.Al() != null) {
                this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpD.startLoad(this.cYc.bNz.Al().thumbnail_url, 10, false);
                this.bpB.setVisibility(0);
                stopPlay();
                this.aFq = this.cYc.bNz.Al().video_url;
                if (aqE()) {
                    this.aFq = this.cYc.bNz.Am().video_url;
                }
                if (StringUtils.isNull(this.cYc.bNz.Al().video_url)) {
                    e(true, 4);
                }
                if (this.bPd != null && this.bPd.btb() != null) {
                    this.bPd.btb().g(this.cYc.bNz.Al());
                }
                this.bpF.cu(this.aFq, this.cYc.tid);
                return;
            }
            this.bpB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cbv, e.f.addresslist_item_bg);
            al.c(this.bpE, e.f.btn_icon_play_video_n);
            al.h(this.bpG, e.d.cp_cont_i);
            al.h(this.bpC, e.d.cp_cont_i);
            al.h(this.bpK, e.d.cp_cont_i);
            al.h(this.cYi, e.d.cp_cont_i);
            al.j(this.bpH, e.d.common_color_10014);
            al.j(this.bzG, e.d.cp_bg_line_e);
            if (this.cYj != null) {
                al.h(this.cYj, e.d.cp_cont_i);
                al.i(this.cYj, e.f.video_play_count_bg);
            }
            if (this.bpG != null) {
                this.bpG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cVR.onChangeSkinType();
            if (this.cbI != null) {
                this.cbI.onChangeSkinType();
            }
            this.cbw.onChangeSkinType();
            this.cbx.onChangeSkinType();
            this.cck.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cYo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cYo);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbw != null) {
            this.cbw.setPageUniqueId(bdUniqueId);
        }
        if (this.bpD != null) {
            this.bpD.setPageId(bdUniqueId);
        }
        if (this.cbI != null) {
            this.cbI.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cYe;
    }

    public boolean isPlaying() {
        if (this.bpF == null) {
            return false;
        }
        return this.bpF.isPlaying();
    }

    public void startPlay() {
        if (!this.cYe && this.cYc != null && this.cYc.bNz != null && this.cYc.bNz.Al() != null && this.bpF != null) {
            this.bpF.stopPlayback();
            if (com.baidu.tbadk.util.ab.r(1, this.aFq)) {
                this.cYb.bdX();
                e(true, 2);
                if (StringUtils.isNull(this.aFq)) {
                    TiebaStatic.log(new am("c12619").aB("obj_locate", "index").aB("tid", this.cYc.tid));
                    this.aFq = this.cYc.bNz.Al().video_url;
                }
                this.cYe = true;
                this.bpF.setVideoPath(this.aFq, this.cYc.tid);
                if (this.bPc != null) {
                    this.bPc.start();
                }
                aqy();
            }
        }
    }

    public void stopPlay() {
        Si();
        apR();
        e(true, 1);
        if (this.bpF != null) {
            this.bpF.stopPlayback();
            if (this.bPc != null) {
                this.bPc.stop();
            }
        }
        this.cYe = false;
    }

    public View getVideoContainer() {
        return this.bpB;
    }

    public String getPlayUrl() {
        return this.aFq;
    }

    public int getCurrentPosition() {
        if (this.bpF == null) {
            return 0;
        }
        return this.bpF.getCurrentPosition();
    }

    public QuickVideoView getVideoView() {
        return this.bpF;
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.bPd != null) {
            this.bPd.setVideoStatsData(zVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbI != null) {
            this.cbI.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbw != null) {
            return this.cbw.aKR;
        }
        return null;
    }

    public View aqs() {
        if (this.cbw != null) {
            return this.cbw.aKT;
        }
        return null;
    }

    public void ft(boolean z) {
        this.cYf = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void iM(int i) {
        if (this.cYc != null && this.cYc.bNz != null) {
            if (i == 1) {
                if (this.cYc.bNz.avT > 0) {
                    this.cck.aKM.setShowPraiseNum(false);
                    this.cck.aKM.setShareVisible(false);
                    this.cYi.setText(ao.X(this.cYc.bNz.avT));
                    this.cYi.setVisibility(0);
                } else {
                    this.cck.aKM.setShowPraiseNum(true);
                    this.cck.aKM.setShareVisible(true);
                    this.cYi.setVisibility(8);
                }
                this.cck.setData(this.cYc.bNz);
                this.cbx.setVisibility(8);
                this.cbw.showForumNameView(false);
                return;
            }
            this.cck.setVisibility(8);
            this.cbw.showForumNameView(true);
            if (this.cYc.bNz.avT > 0) {
                this.cbx.setShowPraiseNum(false);
                this.cbx.setShareVisible(false);
                this.cYi.setText(ao.X(this.cYc.bNz.avT));
                this.cYi.setVisibility(0);
            } else {
                this.cbx.setShowPraiseNum(true);
                this.cbx.setShareVisible(true);
                this.cYi.setVisibility(8);
            }
            if (this.cbx.setData(this.cYc.bNz)) {
                this.cXU.setVisibility(8);
            } else {
                this.cXU.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bpD.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.n.10
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bpD.setOnDrawListener(null);
        }
    }

    private boolean aqE() {
        return (this.cYc == null || this.cYc.bNz == null || this.cYc.bNz.Am() == null || TextUtils.isEmpty(this.cYc.bNz.Am().video_url)) ? false : true;
    }

    public void kL(int i) {
        if (this.cbx != null) {
            this.cbx.aKf = String.valueOf(i);
        }
    }
}
