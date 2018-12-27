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
    private String aEO;
    private final View.OnClickListener aIy;
    private Animation bOg;
    private com.baidu.tieba.play.j bOr;
    private com.baidu.tieba.play.n bOs;
    public FrameLayout boN;
    private TextView boO;
    private TbImageView boP;
    private ImageView boQ;
    private QuickVideoView boR;
    private TextView boS;
    private View boT;
    private com.baidu.tieba.play.x boU;
    private View boV;
    private TextView boW;
    private int boX;
    private TbImageView.a boY;
    private g.b boZ;
    private Runnable bpb;
    private Runnable bpc;
    private QuickVideoView.b bpd;
    private g.a bxL;
    private g.f bxM;
    private g.e bxO;
    private View byS;
    public ThreadGodReplyLayout cVg;
    private VideoLoadingProgressView.a cXA;
    private final View.OnClickListener cXB;
    private final View.OnClickListener cXC;
    private CustomMessageListener cXD;
    private j.a cXE;
    private Animation.AnimationListener cXF;
    private View cXj;
    private com.baidu.tieba.play.g cXo;
    private LinearLayout cXp;
    private com.baidu.tieba.j.k cXq;
    private com.baidu.tieba.card.data.l cXr;
    private int cXs;
    private boolean cXt;
    private boolean cXu;
    private boolean cXv;
    private int cXw;
    private TextView cXx;
    private TextView cXy;
    private Handler cXz;
    private RelativeLayout caK;
    public ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    private NEGFeedBackView caX;
    private String caz;
    protected LinearLayout cbK;
    private HeadPendantClickableView cbw;
    public ThreadSourceShareAndPraiseLayout cbz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aqa() {
        if (this.cXo != null && this.cXt) {
            try {
                this.boR.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.cXo.isPlayerReuse()) {
                int tZ = com.baidu.tieba.play.y.bsO().tZ(this.aEO);
                if (tZ <= 100 || this.cXo.getDuration() <= tZ) {
                    tZ = 100;
                }
                this.cXw = tZ;
            } else {
                this.cXw = 100;
            }
            this.cXz.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqb() {
        if (this.cXr != null && this.cXr.bMM != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.cXr.sourceType == 0 ? "index" : "hot_juhe";
            zVar.biz = this.cXr.bMM.getTid();
            zVar.daG = this.cXr.bMM.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.cXr.bMM.mRecomSource;
            zVar.gHE = this.cXr.bMM.mRecomAbTag;
            zVar.gHF = this.cXr.bMM.mRecomWeight;
            zVar.gHG = "";
            zVar.arh = this.cXr.getExtra();
            if (this.cXr.bMM.zY() != null) {
                zVar.gHI = this.cXr.bMM.zY().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cXr.bMM.zY().video_md5, "", "1", zVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caX = null;
        this.mSkinType = 3;
        this.cXs = 0;
        this.boX = 1;
        this.cXt = false;
        this.cXu = true;
        this.cXv = false;
        this.cXw = 100;
        this.cXz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aqe();
                        return;
                    case 203:
                        n.this.aqf();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cXo = gVar;
                if (n.this.cXo != null) {
                    n.this.cXo.setVolume(0.0f, 0.0f);
                }
                n.this.cXq.bdy();
                n.this.aqa();
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    n.this.e(false, 3);
                }
                return false;
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                n.this.boR.start();
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                n.this.cXt = false;
                return true;
            }
        };
        this.cXA = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aqa();
            }
        };
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && n.this.boP != null) {
                    n.this.boP.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpb = new Runnable() { // from class: com.baidu.tieba.card.n.18
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.boR != null && !n.this.boR.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.bpc = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cXB = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cXr == null) {
                    if (n.this.apS() != null) {
                        n.this.apS().a(view, n.this.cXr);
                        return;
                    }
                    return;
                }
                if (view == n.this.caL.getUserName()) {
                    n.this.cXr.aFq = 3;
                } else if (view == n.this.caL.getHeaderImg()) {
                    n.this.cXr.aFq = 4;
                } else {
                    n.this.cXr.aFq = 1;
                }
                if (n.this.apS() != null) {
                    n.this.apS().a(view, n.this.cXr);
                }
            }
        };
        this.cXC = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cXr != null) {
                    n.this.cXr.aFq = 4;
                }
                if (n.this.apS() != null) {
                    n.this.apS().a(view, n.this.cXr);
                }
            }
        };
        this.cXD = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cXv = false;
                }
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cXr != null) {
                    if (n.this.apS() != null) {
                        n.this.apS().a(view, n.this.cXr);
                    }
                    if (n.this.cXr.bMM != null && view != n.this.cbz.aKj) {
                        o.mG(n.this.cXr.bMM.getId());
                        if (!n.this.apW()) {
                            o.a(n.this.mTextTitle, n.this.cXr.bMM.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                            o.a(n.this.cVg.getGodReplyContent(), n.this.cXr.ZT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cXE = new j.a() { // from class: com.baidu.tieba.card.n.8
            @Override // com.baidu.tieba.play.j.a
            public void aqi() {
                if (n.this.cXr != null && n.this.cXr.bMM != null && n.this.cXr.bMM.zY() != null) {
                    n.this.aqb();
                }
            }
        };
        this.cXF = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.boP != null) {
                    n.this.boP.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.caK = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cbw = (HeadPendantClickableView) this.caK.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.boU = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.boU.setLoadingAnimationListener(this.cXA);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.caX = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16);
        this.caX.a(this.caK, h, 0);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.setShareReportFrom(3);
        this.caM.setForumAfterClickListener(this.aIy);
        this.caM.setFrom(1);
        this.caM.setDisPraiseFrom(1);
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.cbz.aKk.setOnClickListener(this);
        this.cbz.setFrom(1);
        this.cbz.setShareReportFrom(3);
        this.cbz.setForumAfterClickListener(this.aIy);
        this.cXj = view.findViewById(e.g.divider_below_reply_number_layout);
        this.boN = (FrameLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.boN.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.boN.setLayoutParams(layoutParams2);
        this.boP = (TbImageView) view.findViewById(e.g.image_video);
        this.boP.setDefaultErrorResource(0);
        this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boP.setGifIconSupport(false);
        this.boP.setEvent(this.boY);
        this.boQ = (ImageView) view.findViewById(e.g.image_video_play);
        this.caK.setOnClickListener(this);
        this.boR = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.bOs = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.boR.setPlayerReuseEnable(true);
        this.boR.setContinuePlayEnable(true);
        this.boR.setBusiness(this.bOs);
        this.boR.setOnPreparedListener(this.bxM);
        this.boR.setOnOutInfoListener(this.bxO);
        this.boR.setOnCompletionListener(this.bxL);
        this.boR.setOnErrorListener(this.boZ);
        this.boR.setOnSurfaceDestroyedListener(this.bpd);
        this.bOr = new com.baidu.tieba.play.j();
        this.bOr.setPlayer(this.boR);
        this.bOr.a(this.cXE);
        this.boO = (TextView) view.findViewById(e.g.text_video_duration);
        this.cXp = (LinearLayout) view.findViewById(e.g.duration_container);
        this.boW = (TextView) view.findViewById(e.g.text_video_play_count);
        this.boV = view.findViewById(e.g.auto_video_black_mask);
        this.boS = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.boT = view.findViewById(e.g.auto_video_error_background);
        this.cbK = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bOg = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bOg.setAnimationListener(this.cXF);
        this.cVg = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVg.setOnClickListener(this);
        this.byS = view.findViewById(e.g.divider_line);
        this.cXx = (TextView) view.findViewById(e.g.txt_video_num_during_playing);
        this.boR.setOnClickListener(this);
        this.cXy = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cXq = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.avr > 0) {
            if (apS() != null) {
                apS().a(view, this.cXr);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cXr.bMM.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.zu(), this.cXr.aqD())));
            return;
        }
        if (view == this.caK || view == this.cVg) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.boR) {
            if (this.cXr != null) {
                this.cXr.aFq = 5;
            }
            if (this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.zY() != null) {
                z = this.cXr.bMM.zY().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(this.boR);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aE(this.boR);
            } else {
                aF(getView());
            }
        }
    }

    private void aD(View view) {
        if (apS() != null) {
            apS().a(view, this.cXr);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqc();
        }
    }

    private void aE(View view) {
        if (apS() != null) {
            apS().a(view, this.cXr);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqd();
        }
    }

    private void aqc() {
        if (this.cXr != null && this.cXr.bMM != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cXr.bMM);
            videoItemData.mRecomExtra = this.cXr.getExtra();
            videoItemData.mRecomAbTag = this.cXr.aqE();
            videoItemData.mRecomSource = this.cXr.getSource();
            videoItemData.mRecomWeight = this.cXr.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cXr.aqD(), "index")));
        }
    }

    private void aqd() {
        if (this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cXr.bMM);
            videoSerializeVideoThreadInfo.source = this.cXr.getSource();
            videoSerializeVideoThreadInfo.extra = this.cXr.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.cXr.aqE();
            videoSerializeVideoThreadInfo.weight = this.cXr.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.cbK.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cbK.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ao.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cXr.bMM.getTid(), o.zu(), this.cXr.aqD(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aF(View view) {
        if (this.cXr != null) {
            this.cXr.aFq = 1;
        }
        if (apS() != null) {
            apS().a(view, this.cXr);
        }
        if (this.cXr != null && this.cXr.bMM != null) {
            if (!apW()) {
                o.mG(this.cXr.bMM.getId());
                o.a(this.mTextTitle, this.cXr.bMM.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cXr.bMM, null, o.zu(), 18003, true, false, false).addLocateParam(this.cXr.aqD());
            addLocateParam.setVideo_source(this.cXr.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cXr.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cXr.bMM.getFid()));
            addLocateParam.setForumName(this.cXr.bMM.zM());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVg) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apW() {
        return this.cXr.daY && !this.cXr.dbh;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cXr = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        this.cXz.removeMessages(202);
        if (this.boR.getCurrentPosition() > this.cXw) {
            e(false, 3);
            this.cXz.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cXz.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqf() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cXz.removeMessages(203);
        int currentPosition = this.boR.getCurrentPosition();
        if (currentPosition != this.cXs) {
            this.cXs = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cXz.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.boQ != null && this.boP != null && this.boV != null && this.boU != null && this.boT != null && this.boS != null) {
            if (z || this.boX != i) {
                this.boX = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpc);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpb);
                if (i == 2) {
                    this.boQ.setVisibility(8);
                    this.bOg.cancel();
                    this.boP.clearAnimation();
                    this.boP.setVisibility(0);
                    this.boV.setVisibility(0);
                    this.cXp.setVisibility(0);
                    this.cXx.setVisibility(8);
                    this.boU.startLoading();
                    this.boT.setVisibility(8);
                    this.boS.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpc, 60000L);
                } else if (i == 3) {
                    this.boQ.setVisibility(8);
                    this.boP.startAnimation(this.bOg);
                    this.boV.setVisibility(8);
                    this.cXp.setVisibility(8);
                    if (this.cXr != null && this.cXr.ZT() != null && this.cXr.ZT().avr > 0) {
                        this.cXx.setVisibility(0);
                    }
                    this.boU.bsJ();
                    this.boT.setVisibility(8);
                    this.boS.setVisibility(8);
                    if (this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.zY() != null) {
                        this.cXq.a(this.cXr.bMM.getTid(), this.cXr.bMM.zY().video_length.intValue(), this.cXr.bMM.zY().video_duration.intValue(), "homepage", this.boR);
                    }
                } else if (i == 4) {
                    this.boQ.setVisibility(8);
                    this.boP.startAnimation(this.bOg);
                    this.boV.setVisibility(8);
                    this.boU.bsK();
                    this.boT.setVisibility(0);
                    this.boS.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpb, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.boQ.setVisibility(0);
                    this.bOg.cancel();
                    this.boP.clearAnimation();
                    this.boP.setVisibility(0);
                    this.boV.setVisibility(0);
                    this.cXp.setVisibility(0);
                    this.boU.bsK();
                    this.boT.setVisibility(8);
                    this.boS.setVisibility(8);
                }
                if (this.cXr != null && this.cXr.ZT() != null && this.cXr.ZT().avr > 0) {
                    this.cXp.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cXr == null || this.cXr.bMM == null || this.cXr.bMM.zG() == null) {
            this.caK.setVisibility(8);
            return;
        }
        this.caK.setVisibility(0);
        aqg();
        if (!apW() && o.mH(this.cXr.bMM.getId())) {
            o.a(this.mTextTitle, this.cXr.bMM.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cVg.getGodReplyContent(), this.cXr.ZT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cXr.ZT().Aq();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cXr.ZT().Ag());
        if (this.cXr.ZT().An() && !StringUtils.isNull(this.cXr.ZT().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cXr.ZT().getTid();
            spannableStringBuilder.append((CharSequence) this.cXr.ZT().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.17
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
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
        this.caL.setData(this.cXr.ZT());
        this.caL.setUserAfterClickListener(this.cXB);
        if (this.caL.getHeaderImg() != null) {
            this.caL.getHeaderImg().setAfterClickListener(this.cXC);
            if (this.caL.getIsSimpleThread()) {
                this.caL.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (this.cXr.ZT() == null || this.cXr.ZT().zG() == null || this.cXr.ZT().zG().getPendantData() == null || StringUtils.isNull(this.cXr.ZT().zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.caL.getHeaderImg().setVisibility(0);
                if (this.cXr.ZT().avr > 0 && this.cXr.ZT().avs == 0) {
                    this.cXr.ZT().zG().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.caL.getHeaderImg().setData(this.cXr.ZT(), false);
                } else {
                    this.caL.getHeaderImg().setData(this.cXr.ZT());
                    this.caL.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.caL.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(this.cXr.ZT());
            }
        }
        this.boO.setText(ao.dV(this.cXr.bMM.zY().video_duration.intValue() * 1000));
        this.boW.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.cXr.bMM.zY().play_count.intValue())));
        if (this.caX != null && this.cXr.ZT() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cXr.ZT().getTid());
            ahVar.setFid(this.cXr.ZT().getFid());
            ahVar.a(this.cXr.asc);
            this.caX.setData(ahVar);
            this.caX.setFirstRowSingleColumn(true);
            this.caX.setVisibility(this.cXu ? 0 : 8);
        }
        this.cVg.setData(this.cXr.ZT().AX());
        iM(hD(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mH(this.cXr.bMM.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.cXr == null || this.cXr.bMM == null || this.cXr.bMM.zY() == null) {
            z = false;
        } else {
            z = this.cXr.bMM.zY().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cXy.setVisibility(0);
            if (aqh()) {
                this.cXy.setText(String.format("%s | %s", this.mContext.getResources().getString(e.j.nani_video), this.mContext.getResources().getString(e.j.video_preview)));
            } else {
                this.cXy.setText(this.mContext.getString(e.j.nani_video));
            }
        } else if (aqh()) {
            this.cXy.setVisibility(0);
            this.cXy.setText(this.mContext.getString(e.j.video_preview));
        } else {
            this.cXy.setVisibility(8);
        }
    }

    private void apu() {
        this.cXz.removeMessages(202);
        this.cXz.removeMessages(203);
    }

    private void RM() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpb);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpc);
    }

    private void aqg() {
        RM();
        apu();
        if (this.boP != null && this.boN != null && this.boR != null) {
            if (com.baidu.tbadk.core.i.xE().xI() && this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.zY() != null) {
                this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boP.startLoad(this.cXr.bMM.zY().thumbnail_url, 10, false);
                this.boN.setVisibility(0);
                stopPlay();
                this.aEO = this.cXr.bMM.zY().video_url;
                if (aqh()) {
                    this.aEO = this.cXr.bMM.zZ().video_url;
                }
                if (StringUtils.isNull(this.cXr.bMM.zY().video_url)) {
                    e(true, 4);
                }
                if (this.bOs != null && this.bOs.bss() != null) {
                    this.bOs.bss().g(this.cXr.bMM.zY());
                }
                this.boR.ct(this.aEO, this.cXr.tid);
                return;
            }
            this.boN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.caK, e.f.addresslist_item_bg);
            al.c(this.boQ, e.f.btn_icon_play_video_n);
            al.h(this.boS, e.d.cp_cont_i);
            al.h(this.boO, e.d.cp_cont_i);
            al.h(this.boW, e.d.cp_cont_i);
            al.h(this.cXx, e.d.cp_cont_i);
            al.j(this.boT, e.d.common_color_10014);
            al.j(this.byS, e.d.cp_bg_line_e);
            if (this.cXy != null) {
                al.h(this.cXy, e.d.cp_cont_i);
                al.i(this.cXy, e.f.video_play_count_bg);
            }
            if (this.boS != null) {
                this.boS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cVg.onChangeSkinType();
            if (this.caX != null) {
                this.caX.onChangeSkinType();
            }
            this.caL.onChangeSkinType();
            this.caM.onChangeSkinType();
            this.cbz.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cXD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cXD);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
        if (this.boP != null) {
            this.boP.setPageId(bdUniqueId);
        }
        if (this.caX != null) {
            this.caX.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cXt;
    }

    public boolean isPlaying() {
        if (this.boR == null) {
            return false;
        }
        return this.boR.isPlaying();
    }

    public void startPlay() {
        if (!this.cXt && this.cXr != null && this.cXr.bMM != null && this.cXr.bMM.zY() != null && this.boR != null) {
            this.boR.stopPlayback();
            if (com.baidu.tbadk.util.aa.p(1, this.aEO)) {
                this.cXq.bdx();
                e(true, 2);
                if (StringUtils.isNull(this.aEO)) {
                    TiebaStatic.log(new am("c12619").aA("obj_locate", "index").aA("tid", this.cXr.tid));
                    this.aEO = this.cXr.bMM.zY().video_url;
                }
                this.cXt = true;
                this.boR.setVideoPath(this.aEO, this.cXr.tid);
                if (this.bOr != null) {
                    this.bOr.start();
                }
                aqb();
            }
        }
    }

    public void stopPlay() {
        RM();
        apu();
        e(true, 1);
        if (this.boR != null) {
            this.boR.stopPlayback();
            if (this.bOr != null) {
                this.bOr.stop();
            }
        }
        this.cXt = false;
    }

    public View getVideoContainer() {
        return this.boN;
    }

    public String getPlayUrl() {
        return this.aEO;
    }

    public int getCurrentPosition() {
        if (this.boR == null) {
            return 0;
        }
        return this.boR.getCurrentPosition();
    }

    public QuickVideoView getVideoView() {
        return this.boR;
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.bOs != null) {
            this.bOs.setVideoStatsData(zVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caX != null) {
            this.caX.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caL != null) {
            return this.caL.aKp;
        }
        return null;
    }

    public View apV() {
        if (this.caL != null) {
            return this.caL.aKr;
        }
        return null;
    }

    public void fq(boolean z) {
        this.cXu = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void iM(int i) {
        if (this.cXr != null && this.cXr.bMM != null) {
            if (i == 1) {
                if (this.cXr.bMM.avr > 0) {
                    this.cbz.aKk.setShowPraiseNum(false);
                    this.cbz.aKk.setShareVisible(false);
                    this.cXx.setText(ao.X(this.cXr.bMM.avr));
                    this.cXx.setVisibility(0);
                } else {
                    this.cbz.aKk.setShowPraiseNum(true);
                    this.cbz.aKk.setShareVisible(true);
                    this.cXx.setVisibility(8);
                }
                this.cbz.setData(this.cXr.bMM);
                this.caM.setVisibility(8);
                this.caL.showForumNameView(false);
                return;
            }
            this.cbz.setVisibility(8);
            this.caL.showForumNameView(true);
            if (this.cXr.bMM.avr > 0) {
                this.caM.setShowPraiseNum(false);
                this.caM.setShareVisible(false);
                this.cXx.setText(ao.X(this.cXr.bMM.avr));
                this.cXx.setVisibility(0);
            } else {
                this.caM.setShowPraiseNum(true);
                this.caM.setShareVisible(true);
                this.cXx.setVisibility(8);
            }
            if (this.caM.setData(this.cXr.bMM)) {
                this.cXj.setVisibility(8);
            } else {
                this.cXj.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.boP.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.n.10
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.boP.setOnDrawListener(null);
        }
    }

    private boolean aqh() {
        return (this.cXr == null || this.cXr.bMM == null || this.cXr.bMM.zZ() == null || TextUtils.isEmpty(this.cXr.bMM.zZ().video_url)) ? false : true;
    }

    public void kL(int i) {
        if (this.caM != null) {
            this.caM.aJD = String.valueOf(i);
        }
    }
}
