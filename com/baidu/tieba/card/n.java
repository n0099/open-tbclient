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
    private String aAy;
    private final View.OnClickListener aEh;
    private Animation bJD;
    private com.baidu.tieba.play.j bJO;
    private com.baidu.tieba.play.n bJP;
    private String bVS;
    private HeadPendantClickableView bWP;
    public ThreadSourceShareAndPraiseLayout bWS;
    private RelativeLayout bWd;
    public ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    private NEGFeedBackView bWq;
    protected LinearLayout bXd;
    public FrameLayout bkB;
    private TextView bkC;
    private TbImageView bkD;
    private ImageView bkE;
    private QuickVideoView bkF;
    private TextView bkG;
    private View bkH;
    private com.baidu.tieba.play.x bkI;
    private View bkJ;
    private TextView bkK;
    private int bkL;
    private TbImageView.a bkM;
    private g.b bkN;
    private Runnable bkP;
    private Runnable bkQ;
    private QuickVideoView.b bkR;
    private g.e btB;
    private g.a bty;
    private g.f btz;
    private View buH;
    public ThreadGodReplyLayout cKD;
    private View cMG;
    private com.baidu.tieba.play.g cML;
    private LinearLayout cMM;
    private com.baidu.tieba.j.k cMN;
    private com.baidu.tieba.card.data.l cMO;
    private int cMP;
    private boolean cMQ;
    private boolean cMR;
    private boolean cMS;
    private int cMT;
    private TextView cMU;
    private TextView cMV;
    private Handler cMW;
    private VideoLoadingProgressView.a cMX;
    private final View.OnClickListener cMY;
    private final View.OnClickListener cMZ;
    private CustomMessageListener cNa;
    private j.a cNb;
    private Animation.AnimationListener cNc;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void anW() {
        if (this.cML != null && this.cMQ) {
            try {
                this.bkF.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.cML.isPlayerReuse()) {
                int tp = com.baidu.tieba.play.y.bqO().tp(this.aAy);
                if (tp <= 100 || this.cML.getDuration() <= tp) {
                    tp = 100;
                }
                this.cMT = tp;
            } else {
                this.cMT = 100;
            }
            this.cMW.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anX() {
        if (this.cMO != null && this.cMO.bIj != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.cMO.sourceType == 0 ? "index" : "hot_juhe";
            zVar.beh = this.cMO.bIj.getTid();
            zVar.cQb = this.cMO.bIj.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.cMO.bIj.mRecomSource;
            zVar.gwv = this.cMO.bIj.mRecomAbTag;
            zVar.gww = this.cMO.bIj.mRecomWeight;
            zVar.gwx = "";
            zVar.amT = this.cMO.getExtra();
            if (this.cMO.bIj.yN() != null) {
                zVar.gwz = this.cMO.bIj.yN().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cMO.bIj.yN().video_md5, "", "1", zVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bWq = null;
        this.mSkinType = 3;
        this.cMP = 0;
        this.bkL = 1;
        this.cMQ = false;
        this.cMR = true;
        this.cMS = false;
        this.cMT = 100;
        this.cMW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aoa();
                        return;
                    case 203:
                        n.this.aob();
                        return;
                    default:
                        return;
                }
            }
        };
        this.btz = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cML = gVar;
                if (n.this.cML != null) {
                    n.this.cML.setVolume(0.0f, 0.0f);
                }
                n.this.cMN.bbv();
                n.this.anW();
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    n.this.e(false, 3);
                }
                return false;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                com.baidu.tieba.play.y.bqO().remove(n.this.aAy);
                n.this.bkF.start();
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                n.this.cMQ = false;
                return true;
            }
        };
        this.cMX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.anW();
            }
        };
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && n.this.bkD != null) {
                    n.this.bkD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bkP = new Runnable() { // from class: com.baidu.tieba.card.n.18
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.bkF != null && !n.this.bkF.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.bkQ = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cMY = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cMO == null) {
                    if (n.this.anO() != null) {
                        n.this.anO().a(view, n.this.cMO);
                        return;
                    }
                    return;
                }
                if (view == n.this.bWe.getUserName()) {
                    n.this.cMO.aBa = 3;
                } else if (view == n.this.bWe.getHeaderImg()) {
                    n.this.cMO.aBa = 4;
                } else {
                    n.this.cMO.aBa = 1;
                }
                if (n.this.anO() != null) {
                    n.this.anO().a(view, n.this.cMO);
                }
            }
        };
        this.cMZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cMO != null) {
                    n.this.cMO.aBa = 4;
                }
                if (n.this.anO() != null) {
                    n.this.anO().a(view, n.this.cMO);
                }
            }
        };
        this.cNa = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cMS = false;
                }
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cMO != null) {
                    if (n.this.anO() != null) {
                        n.this.anO().a(view, n.this.cMO);
                    }
                    if (n.this.cMO.bIj != null && view != n.this.bWS.aFR) {
                        o.md(n.this.cMO.bIj.getId());
                        if (!n.this.anS()) {
                            o.a(n.this.mTextTitle, n.this.cMO.bIj.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                            o.a(n.this.cKD.getGodReplyContent(), n.this.cMO.YA().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cNb = new j.a() { // from class: com.baidu.tieba.card.n.8
            @Override // com.baidu.tieba.play.j.a
            public void aoe() {
                if (n.this.cMO != null && n.this.cMO.bIj != null && n.this.cMO.bIj.yN() != null) {
                    n.this.anX();
                }
            }
        };
        this.cNc = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.bkD != null) {
                    n.this.bkD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.bWd = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.bWP = (HeadPendantClickableView) this.bWd.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.ds70));
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.bkI = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bkI.setLoadingAnimationListener(this.cMX);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.bWq = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.tbds16);
        this.bWq.a(this.bWd, h, 0);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.setShareReportFrom(3);
        this.bWf.setForumAfterClickListener(this.aEh);
        this.bWf.setFrom(1);
        this.bWf.setDisPraiseFrom(1);
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.bWS.aFS.setOnClickListener(this);
        this.bWS.setFrom(1);
        this.bWS.setShareReportFrom(3);
        this.bWS.setForumAfterClickListener(this.aEh);
        this.cMG = view.findViewById(e.g.divider_below_reply_number_layout);
        this.bkB = (FrameLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bkB.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bkB.setLayoutParams(layoutParams2);
        this.bkD = (TbImageView) view.findViewById(e.g.image_video);
        this.bkD.setDefaultErrorResource(0);
        this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bkD.setGifIconSupport(false);
        this.bkD.setEvent(this.bkM);
        this.bkE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bWd.setOnClickListener(this);
        this.bkF = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.bJP = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.bkF.setPlayerReuseEnable(true);
        this.bkF.setContinuePlayEnable(true);
        this.bkF.setBusiness(this.bJP);
        this.bkF.setOnPreparedListener(this.btz);
        this.bkF.setOnOutInfoListener(this.btB);
        this.bkF.setOnCompletionListener(this.bty);
        this.bkF.setOnErrorListener(this.bkN);
        this.bkF.setOnSurfaceDestroyedListener(this.bkR);
        this.bJO = new com.baidu.tieba.play.j();
        this.bJO.setPlayer(this.bkF);
        this.bJO.a(this.cNb);
        this.bkC = (TextView) view.findViewById(e.g.text_video_duration);
        this.cMM = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bkK = (TextView) view.findViewById(e.g.text_video_play_count);
        this.bkJ = view.findViewById(e.g.auto_video_black_mask);
        this.bkG = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bkH = view.findViewById(e.g.auto_video_error_background);
        this.bXd = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bJD = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bJD.setAnimationListener(this.cNc);
        this.cKD = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cKD.setOnClickListener(this);
        this.buH = view.findViewById(e.g.divider_line);
        this.cMU = (TextView) view.findViewById(e.g.txt_video_num_during_playing);
        this.bkF.setOnClickListener(this);
        this.cMV = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cMN = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.are > 0) {
            if (anO() != null) {
                anO().a(view, this.cMO);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cMO.bIj.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.yj(), this.cMO.aoz())));
            return;
        }
        if (view == this.bWd || view == this.cKD) {
            aA(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bkF) {
            if (this.cMO != null) {
                this.cMO.aBa = 5;
            }
            if (this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.yN() != null) {
                z = this.cMO.bIj.yN().is_vertical.intValue() == 1;
            }
            if (z) {
                ay(getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                az(getView());
            } else {
                aA(getView());
            }
        }
    }

    private void ay(View view) {
        if (anO() != null) {
            anO().a(view, this.cMO);
        }
        if (!com.baidu.adp.lib.util.j.kX()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anY();
        }
    }

    private void az(View view) {
        if (anO() != null) {
            anO().a(view, this.cMO);
        }
        if (!com.baidu.adp.lib.util.j.kX()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anZ();
        }
    }

    private void anY() {
        if (this.cMO != null && this.cMO.bIj != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cMO.bIj);
            videoItemData.mRecomExtra = this.cMO.getExtra();
            videoItemData.mRecomAbTag = this.cMO.aoA();
            videoItemData.mRecomSource = this.cMO.getSource();
            videoItemData.mRecomWeight = this.cMO.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cMO.aoz(), "index")));
        }
    }

    private void anZ() {
        if (this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cMO.bIj);
            videoSerializeVideoThreadInfo.source = this.cMO.getSource();
            videoSerializeVideoThreadInfo.extra = this.cMO.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.cMO.aoA();
            videoSerializeVideoThreadInfo.weight = this.cMO.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.bXd.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bXd.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ao.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cMO.bIj.getTid(), o.yj(), this.cMO.aoz(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aA(View view) {
        if (this.cMO != null) {
            this.cMO.aBa = 1;
        }
        if (anO() != null) {
            anO().a(view, this.cMO);
        }
        if (this.cMO != null && this.cMO.bIj != null) {
            if (!anS()) {
                o.md(this.cMO.bIj.getId());
                o.a(this.mTextTitle, this.cMO.bIj.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cMO.bIj, null, o.yj(), 18003, true, false, false).addLocateParam(this.cMO.aoz());
            addLocateParam.setVideo_source(this.cMO.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cMO.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cMO.bIj.getFid()));
            addLocateParam.setForumName(this.cMO.bIj.yB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cKD) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anS() {
        return this.cMO.cQt && !this.cMO.cQC;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cMO = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoa() {
        this.cMW.removeMessages(202);
        if (this.bkF.getCurrentPosition() > this.cMT) {
            e(false, 3);
            this.cMW.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cMW.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aob() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cMW.removeMessages(203);
        int currentPosition = this.bkF.getCurrentPosition();
        if (currentPosition != this.cMP) {
            this.cMP = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cMW.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bkE != null && this.bkD != null && this.bkJ != null && this.bkI != null && this.bkH != null && this.bkG != null) {
            if (z || this.bkL != i) {
                this.bkL = i;
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkQ);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkP);
                if (i == 2) {
                    this.bkE.setVisibility(8);
                    this.bJD.cancel();
                    this.bkD.clearAnimation();
                    this.bkD.setVisibility(0);
                    this.bkJ.setVisibility(0);
                    this.cMM.setVisibility(0);
                    this.cMU.setVisibility(8);
                    this.bkI.startLoading();
                    this.bkH.setVisibility(8);
                    this.bkG.setVisibility(8);
                    com.baidu.adp.lib.g.e.jI().postDelayed(this.bkQ, 60000L);
                } else if (i == 3) {
                    this.bkE.setVisibility(8);
                    this.bkD.startAnimation(this.bJD);
                    this.bkJ.setVisibility(8);
                    this.cMM.setVisibility(8);
                    if (this.cMO != null && this.cMO.YA() != null && this.cMO.YA().are > 0) {
                        this.cMU.setVisibility(0);
                    }
                    this.bkI.bqJ();
                    this.bkH.setVisibility(8);
                    this.bkG.setVisibility(8);
                    if (this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.yN() != null) {
                        this.cMN.a(this.cMO.bIj.getTid(), this.cMO.bIj.yN().video_length.intValue(), this.cMO.bIj.yN().video_duration.intValue(), "homepage");
                    }
                } else if (i == 4) {
                    this.bkE.setVisibility(8);
                    this.bkD.startAnimation(this.bJD);
                    this.bkJ.setVisibility(8);
                    this.bkI.bqK();
                    this.bkH.setVisibility(0);
                    this.bkG.setVisibility(0);
                    com.baidu.adp.lib.g.e.jI().postDelayed(this.bkP, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.bkE.setVisibility(0);
                    this.bJD.cancel();
                    this.bkD.clearAnimation();
                    this.bkD.setVisibility(0);
                    this.bkJ.setVisibility(0);
                    this.cMM.setVisibility(0);
                    this.bkI.bqK();
                    this.bkH.setVisibility(8);
                    this.bkG.setVisibility(8);
                }
                if (this.cMO != null && this.cMO.YA() != null && this.cMO.YA().are > 0) {
                    this.cMM.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cMO == null || this.cMO.bIj == null || this.cMO.bIj.yv() == null) {
            this.bWd.setVisibility(8);
            return;
        }
        this.bWd.setVisibility(0);
        aoc();
        if (!anS() && o.me(this.cMO.bIj.getId())) {
            o.a(this.mTextTitle, this.cMO.bIj.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cKD.getGodReplyContent(), this.cMO.YA().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cMO.YA().zf();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cMO.YA().yV());
        if (this.cMO.YA().zc() && !StringUtils.isNull(this.cMO.YA().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cMO.YA().getTid();
            spannableStringBuilder.append((CharSequence) this.cMO.YA().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.17
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
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
        this.bWe.setData(this.cMO.YA());
        this.bWe.setUserAfterClickListener(this.cMY);
        if (this.bWe.getHeaderImg() != null) {
            this.bWe.getHeaderImg().setAfterClickListener(this.cMZ);
            if (this.bWe.getIsSimpleThread()) {
                this.bWe.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (this.cMO.YA() == null || this.cMO.YA().yv() == null || this.cMO.YA().yv().getPendantData() == null || StringUtils.isNull(this.cMO.YA().yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.bWe.getHeaderImg().setVisibility(0);
                if (this.cMO.YA().are > 0 && this.cMO.YA().arf == 0) {
                    this.cMO.YA().yv().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bWe.getHeaderImg().setData(this.cMO.YA(), false);
                } else {
                    this.bWe.getHeaderImg().setData(this.cMO.YA());
                    this.bWe.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(this.cMO.YA());
            }
        }
        this.bkC.setText(ao.dt(this.cMO.bIj.yN().video_duration.intValue() * 1000));
        this.bkK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.N(this.cMO.bIj.yN().play_count.intValue())));
        if (this.bWq != null && this.cMO.YA() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cMO.YA().getTid());
            ahVar.setFid(this.cMO.YA().getFid());
            ahVar.a(this.cMO.anO);
            this.bWq.setData(ahVar);
            this.bWq.setFirstRowSingleColumn(true);
            this.bWq.setVisibility(this.cMR ? 0 : 8);
        }
        this.cKD.setData(this.cMO.YA().zM());
        ik(hb(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.me(this.cMO.bIj.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.cMO == null || this.cMO.bIj == null || this.cMO.bIj.yN() == null) {
            z = false;
        } else {
            z = this.cMO.bIj.yN().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cMV.setVisibility(0);
            if (aod()) {
                this.cMV.setText(String.format("%s | %s", this.mContext.getResources().getString(e.j.nani_video), this.mContext.getResources().getString(e.j.video_preview)));
            } else {
                this.cMV.setText(this.mContext.getString(e.j.nani_video));
            }
        } else if (aod()) {
            this.cMV.setVisibility(0);
            this.cMV.setText(this.mContext.getString(e.j.video_preview));
        } else {
            this.cMV.setVisibility(8);
        }
    }

    private void anr() {
        this.cMW.removeMessages(202);
        this.cMW.removeMessages(203);
    }

    private void Qv() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkP);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkQ);
    }

    private void aoc() {
        Qv();
        anr();
        if (this.bkD != null && this.bkB != null && this.bkF != null) {
            if (com.baidu.tbadk.core.i.ws().ww() && this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.yN() != null) {
                this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bkD.startLoad(this.cMO.bIj.yN().thumbnail_url, 10, false);
                this.bkB.setVisibility(0);
                stopPlay();
                this.aAy = this.cMO.bIj.yN().video_url;
                if (aod()) {
                    this.aAy = this.cMO.bIj.yO().video_url;
                }
                if (StringUtils.isNull(this.cMO.bIj.yN().video_url)) {
                    e(true, 4);
                }
                if (this.bJP != null && this.bJP.bqs() != null) {
                    this.bJP.bqs().g(this.cMO.bIj.yN());
                }
                this.bkF.co(this.aAy, this.cMO.tid);
                return;
            }
            this.bkB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bWd, e.f.addresslist_item_bg);
            al.c(this.bkE, e.f.btn_icon_play_video_n);
            al.h(this.bkG, e.d.cp_cont_i);
            al.h(this.bkC, e.d.cp_cont_i);
            al.h(this.bkK, e.d.cp_cont_i);
            al.h(this.cMU, e.d.cp_cont_i);
            al.j(this.bkH, e.d.common_color_10014);
            al.j(this.buH, e.d.cp_bg_line_e);
            if (this.cMV != null) {
                al.h(this.cMV, e.d.cp_cont_i);
                al.i(this.cMV, e.f.video_play_count_bg);
            }
            if (this.bkG != null) {
                this.bkG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cKD.onChangeSkinType();
            if (this.bWq != null) {
                this.bWq.onChangeSkinType();
            }
            this.bWe.onChangeSkinType();
            this.bWf.onChangeSkinType();
            this.bWS.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cNa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cNa);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bWe != null) {
            this.bWe.setPageUniqueId(bdUniqueId);
        }
        if (this.bkD != null) {
            this.bkD.setPageId(bdUniqueId);
        }
        if (this.bWq != null) {
            this.bWq.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cMQ;
    }

    public boolean isPlaying() {
        if (this.bkF == null) {
            return false;
        }
        return this.bkF.isPlaying();
    }

    public void startPlay() {
        if (!this.cMQ && this.cMO != null && this.cMO.bIj != null && this.cMO.bIj.yN() != null && this.bkF != null) {
            this.bkF.stopPlayback();
            if (com.baidu.tbadk.util.aa.q(1, this.aAy)) {
                this.cMN.bbu();
                e(true, 2);
                if (StringUtils.isNull(this.aAy)) {
                    TiebaStatic.log(new am("c12619").ax("obj_locate", "index").ax("tid", this.cMO.tid));
                    this.aAy = this.cMO.bIj.yN().video_url;
                }
                this.cMQ = true;
                this.bkF.setVideoPath(this.aAy, this.cMO.tid);
                if (this.bJO != null) {
                    this.bJO.start();
                }
                anX();
            }
        }
    }

    public void stopPlay() {
        Qv();
        anr();
        e(true, 1);
        if (this.bkF != null) {
            this.bkF.stopPlayback();
            if (this.bJO != null) {
                this.bJO.stop();
            }
        }
        this.cMQ = false;
    }

    public View getVideoContainer() {
        return this.bkB;
    }

    public String getPlayUrl() {
        return this.aAy;
    }

    public int getCurrentPosition() {
        if (this.bkF == null) {
            return 0;
        }
        return this.bkF.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.bJP != null) {
            this.bJP.setVideoStatsData(zVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bWq != null) {
            this.bWq.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWe != null) {
            return this.bWe.aFX;
        }
        return null;
    }

    public View anR() {
        if (this.bWe != null) {
            return this.bWe.aFZ;
        }
        return null;
    }

    public void fc(boolean z) {
        this.cMR = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void ik(int i) {
        if (this.cMO != null && this.cMO.bIj != null) {
            if (i == 1) {
                if (this.cMO.bIj.are > 0) {
                    this.bWS.aFS.setShowPraiseNum(false);
                    this.bWS.aFS.setShareVisible(false);
                    this.cMU.setText(ao.N(this.cMO.bIj.are));
                    this.cMU.setVisibility(0);
                } else {
                    this.bWS.aFS.setShowPraiseNum(true);
                    this.bWS.aFS.setShareVisible(true);
                    this.cMU.setVisibility(8);
                }
                this.bWS.setData(this.cMO.bIj);
                this.bWf.setVisibility(8);
                this.bWe.showForumNameView(false);
                return;
            }
            this.bWS.setVisibility(8);
            this.bWe.showForumNameView(true);
            if (this.cMO.bIj.are > 0) {
                this.bWf.setShowPraiseNum(false);
                this.bWf.setShareVisible(false);
                this.cMU.setText(ao.N(this.cMO.bIj.are));
                this.cMU.setVisibility(0);
            } else {
                this.bWf.setShowPraiseNum(true);
                this.bWf.setShareVisible(true);
                this.cMU.setVisibility(8);
            }
            if (this.bWf.setData(this.cMO.bIj)) {
                this.cMG.setVisibility(8);
            } else {
                this.cMG.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bkD.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.n.10
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bkD.setOnDrawListener(null);
        }
    }

    private boolean aod() {
        return (this.cMO == null || this.cMO.bIj == null || this.cMO.bIj.yO() == null || TextUtils.isEmpty(this.cMO.bIj.yO().video_url)) ? false : true;
    }
}
