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
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class n extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private String avN;
    private final View.OnClickListener azz;
    private Animation bAV;
    private com.baidu.tieba.play.j bBh;
    private com.baidu.tieba.play.n bBi;
    private RelativeLayout bNB;
    public ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    private NEGFeedBackView bNP;
    private String bNq;
    protected LinearLayout bOC;
    private HeadPendantClickableView bOo;
    public ThreadSourceShareAndPraiseLayout bOr;
    private Runnable bgA;
    private Runnable bgB;
    private QuickVideoView.b bgC;
    public FrameLayout bgl;
    private TextView bgm;
    private TbImageView bgn;
    private ImageView bgo;
    private QuickVideoView bgp;
    private TextView bgq;
    private View bgr;
    private com.baidu.tieba.play.w bgt;
    private View bgu;
    private TextView bgv;
    private int bgw;
    private TbImageView.a bgx;
    private g.b bgy;
    private g.e bpA;
    private g.a bpx;
    private g.f bpy;
    private View bqy;
    public ThreadGodReplyLayout cCi;
    private TextView cEA;
    private TextView cEB;
    private Handler cEC;
    private VideoLoadingProgressView.a cED;
    private final View.OnClickListener cEE;
    private final View.OnClickListener cEF;
    private CustomMessageListener cEG;
    private j.a cEH;
    private Animation.AnimationListener cEI;
    private View cEm;
    private com.baidu.tieba.play.g cEr;
    private LinearLayout cEs;
    private com.baidu.tieba.j.k cEt;
    private com.baidu.tieba.card.data.l cEu;
    private int cEv;
    private boolean cEw;
    private boolean cEx;
    private boolean cEy;
    private int cEz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aku() {
        if (this.cEr != null && this.cEw) {
            try {
                this.bgp.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.cEr.isPlayerReuse()) {
                int sP = com.baidu.tieba.play.x.bnz().sP(this.avN);
                if (sP <= 100 || this.cEr.getDuration() <= sP) {
                    sP = 100;
                }
                this.cEz = sP;
            } else {
                this.cEz = 100;
            }
            this.cEC.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.cEu != null && this.cEu.bzB != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.cEu.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aZG = this.cEu.bzB.getTid();
            yVar.cHI = this.cEu.bzB.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cEu.bzB.mRecomSource;
            yVar.goU = this.cEu.bzB.mRecomAbTag;
            yVar.goV = this.cEu.bzB.mRecomWeight;
            yVar.goW = "";
            yVar.ahY = this.cEu.getExtra();
            if (this.cEu.bzB.wE() != null) {
                yVar.goY = this.cEu.bzB.wE().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cEu.bzB.wE().video_md5, "", "1", yVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bNP = null;
        this.mSkinType = 3;
        this.cEv = 0;
        this.bgw = 1;
        this.cEw = false;
        this.cEx = true;
        this.cEy = false;
        this.cEz = 100;
        this.cEC = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aky();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        n.this.akz();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bpy = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cEr = gVar;
                if (n.this.cEr != null) {
                    n.this.cEr.setVolume(0.0f, 0.0f);
                }
                n.this.cEt.aYj();
                n.this.aku();
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    n.this.e(false, 3);
                }
                return false;
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                com.baidu.tieba.play.x.bnz().remove(n.this.avN);
                n.this.bgp.start();
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                n.this.cEw = false;
                return true;
            }
        };
        this.cED = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aku();
            }
        };
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && n.this.bgn != null) {
                    n.this.bgn.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bgA = new Runnable() { // from class: com.baidu.tieba.card.n.18
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.bgp != null && !n.this.bgp.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.bgB = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cEE = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cEu == null) {
                    if (n.this.akm() != null) {
                        n.this.akm().a(view, n.this.cEu);
                        return;
                    }
                    return;
                }
                if (view == n.this.bNC.getUserName()) {
                    n.this.cEu.awp = 3;
                } else if (view == n.this.bNC.getHeaderImg()) {
                    n.this.cEu.awp = 4;
                } else {
                    n.this.cEu.awp = 1;
                }
                if (n.this.akm() != null) {
                    n.this.akm().a(view, n.this.cEu);
                }
            }
        };
        this.cEF = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cEu != null) {
                    n.this.cEu.awp = 4;
                }
                if (n.this.akm() != null) {
                    n.this.akm().a(view, n.this.cEu);
                }
            }
        };
        this.cEG = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cEy = false;
                }
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cEu != null) {
                    if (n.this.akm() != null) {
                        n.this.akm().a(view, n.this.cEu);
                    }
                    if (n.this.cEu.bzB != null && view != n.this.bOr.aBk) {
                        o.lA(n.this.cEu.bzB.getId());
                        if (!n.this.akq()) {
                            o.a(n.this.mTextTitle, n.this.cEu.bzB.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                            o.a(n.this.cCi.getGodReplyContent(), n.this.cEu.UT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cEH = new j.a() { // from class: com.baidu.tieba.card.n.8
            @Override // com.baidu.tieba.play.j.a
            public void akC() {
                if (n.this.cEu != null && n.this.cEu.bzB != null && n.this.cEu.bzB.wE() != null) {
                    n.this.akv();
                }
            }
        };
        this.cEI = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.bgn != null) {
                    n.this.bgn.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.bNB = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.bOo = (HeadPendantClickableView) this.bNB.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.ds70));
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.bgt = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bgt.setLoadingAnimationListener(this.cED);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.bNP = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds16);
        this.bNP.a(this.bNB, h, 0);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.setShareReportFrom(3);
        this.bND.setForumAfterClickListener(this.azz);
        this.bND.setFrom(1);
        this.bND.setDisPraiseFrom(1);
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.bOr.aBl.setOnClickListener(this);
        this.bOr.setFrom(1);
        this.bOr.setShareReportFrom(3);
        this.bOr.setForumAfterClickListener(this.azz);
        this.cEm = view.findViewById(e.g.divider_below_reply_number_layout);
        this.bgl = (FrameLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgl.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bgl.setLayoutParams(layoutParams2);
        this.bgn = (TbImageView) view.findViewById(e.g.image_video);
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bgn.setGifIconSupport(false);
        this.bgn.setEvent(this.bgx);
        this.bgo = (ImageView) view.findViewById(e.g.image_video_play);
        this.bNB.setOnClickListener(this);
        this.bgp = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.bBi = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.bgp.setPlayerReuseEnable(true);
        this.bgp.setContinuePlayEnable(true);
        this.bgp.setBusiness(this.bBi);
        this.bgp.setOnPreparedListener(this.bpy);
        this.bgp.setOnOutInfoListener(this.bpA);
        this.bgp.setOnCompletionListener(this.bpx);
        this.bgp.setOnErrorListener(this.bgy);
        this.bgp.setOnSurfaceDestroyedListener(this.bgC);
        this.bBh = new com.baidu.tieba.play.j();
        this.bBh.setPlayer(this.bgp);
        this.bBh.a(this.cEH);
        this.bgm = (TextView) view.findViewById(e.g.text_video_duration);
        this.cEs = (LinearLayout) view.findViewById(e.g.duration_container);
        this.bgv = (TextView) view.findViewById(e.g.text_video_play_count);
        this.bgu = view.findViewById(e.g.auto_video_black_mask);
        this.bgq = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bgr = view.findViewById(e.g.auto_video_error_background);
        this.bOC = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bAV = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bAV.setAnimationListener(this.cEI);
        this.cCi = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cCi.setOnClickListener(this);
        this.bqy = view.findViewById(e.g.divider_line);
        this.cEA = (TextView) view.findViewById(e.g.txt_video_num_during_playing);
        this.bgp.setOnClickListener(this);
        this.cEB = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cEt = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.amj > 0) {
            if (akm() != null) {
                akm().a(view, this.cEu);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cEu.bzB.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.wa(), this.cEu.akX())));
            return;
        }
        if (view == this.bNB || view == this.cCi) {
            aA(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bgp) {
            if (this.cEu != null) {
                this.cEu.awp = 5;
            }
            if (this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.wE() != null) {
                z = this.cEu.bzB.wE().is_vertical.intValue() == 1;
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
        if (akm() != null) {
            akm().a(view, this.cEu);
        }
        if (!com.baidu.adp.lib.util.j.kK()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            akw();
        }
    }

    private void az(View view) {
        if (akm() != null) {
            akm().a(view, this.cEu);
        }
        if (!com.baidu.adp.lib.util.j.kK()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            akx();
        }
    }

    private void akw() {
        if (this.cEu != null && this.cEu.bzB != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cEu.bzB);
            videoItemData.mRecomExtra = this.cEu.getExtra();
            videoItemData.mRecomAbTag = this.cEu.akY();
            videoItemData.mRecomSource = this.cEu.getSource();
            videoItemData.mRecomWeight = this.cEu.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cEu.akX(), "index")));
        }
    }

    private void akx() {
        if (this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cEu.bzB);
            videoSerializeVideoThreadInfo.source = this.cEu.getSource();
            videoSerializeVideoThreadInfo.extra = this.cEu.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.cEu.akY();
            videoSerializeVideoThreadInfo.weight = this.cEu.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.bOC.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bOC.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ao.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cEu.bzB.getTid(), o.wa(), this.cEu.akX(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aA(View view) {
        if (this.cEu != null) {
            this.cEu.awp = 1;
        }
        if (akm() != null) {
            akm().a(view, this.cEu);
        }
        if (this.cEu != null && this.cEu.bzB != null) {
            if (!akq()) {
                o.lA(this.cEu.bzB.getId());
                o.a(this.mTextTitle, this.cEu.bzB.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cEu.bzB, null, o.wa(), 18003, true, false, false).addLocateParam(this.cEu.akX());
            addLocateParam.setVideo_source(this.cEu.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cEu.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cEu.bzB.getFid()));
            addLocateParam.setForumName(this.cEu.bzB.ws());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cCi) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akq() {
        return this.cEu.cIa && !this.cEu.cIj;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cEu = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        this.cEC.removeMessages(202);
        if (this.bgp.getCurrentPosition() > this.cEz) {
            e(false, 3);
            this.cEC.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cEC.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akz() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cEC.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bgp.getCurrentPosition();
        if (currentPosition != this.cEv) {
            this.cEv = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cEC.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bgo != null && this.bgn != null && this.bgu != null && this.bgt != null && this.bgr != null && this.bgq != null) {
            if (z || this.bgw != i) {
                this.bgw = i;
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgB);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgA);
                if (i == 2) {
                    this.bgo.setVisibility(8);
                    this.bAV.cancel();
                    this.bgn.clearAnimation();
                    this.bgn.setVisibility(0);
                    this.bgu.setVisibility(0);
                    this.cEs.setVisibility(0);
                    this.cEA.setVisibility(8);
                    this.bgt.startLoading();
                    this.bgr.setVisibility(8);
                    this.bgq.setVisibility(8);
                    com.baidu.adp.lib.g.e.jt().postDelayed(this.bgB, 60000L);
                } else if (i == 3) {
                    this.bgo.setVisibility(8);
                    this.bgn.startAnimation(this.bAV);
                    this.bgu.setVisibility(8);
                    this.cEs.setVisibility(8);
                    if (this.cEu != null && this.cEu.UT() != null && this.cEu.UT().amj > 0) {
                        this.cEA.setVisibility(0);
                    }
                    this.bgt.bnu();
                    this.bgr.setVisibility(8);
                    this.bgq.setVisibility(8);
                    if (this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.wE() != null) {
                        this.cEt.a(this.cEu.bzB.getTid(), this.cEu.bzB.wE().video_length.intValue(), this.cEu.bzB.wE().video_duration.intValue(), "homepage");
                    }
                } else if (i == 4) {
                    this.bgo.setVisibility(8);
                    this.bgn.startAnimation(this.bAV);
                    this.bgu.setVisibility(8);
                    this.bgt.bnv();
                    this.bgr.setVisibility(0);
                    this.bgq.setVisibility(0);
                    com.baidu.adp.lib.g.e.jt().postDelayed(this.bgA, 2000L);
                } else {
                    this.bgo.setVisibility(0);
                    this.bAV.cancel();
                    this.bgn.clearAnimation();
                    this.bgn.setVisibility(0);
                    this.bgu.setVisibility(0);
                    this.cEs.setVisibility(0);
                    this.bgt.bnv();
                    this.bgr.setVisibility(8);
                    this.bgq.setVisibility(8);
                }
                if (this.cEu != null && this.cEu.UT() != null && this.cEu.UT().amj > 0) {
                    this.cEs.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cEu == null || this.cEu.bzB == null || this.cEu.bzB.wm() == null) {
            this.bNB.setVisibility(8);
            return;
        }
        this.bNB.setVisibility(0);
        akA();
        if (!akq() && o.lB(this.cEu.bzB.getId())) {
            o.a(this.mTextTitle, this.cEu.bzB.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cCi.getGodReplyContent(), this.cEu.UT().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cEu.UT().wW();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cEu.UT().wM());
        if (this.cEu.UT().wT() && !StringUtils.isNull(this.cEu.UT().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cEu.UT().getTid();
            spannableStringBuilder.append((CharSequence) this.cEu.UT().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.17
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
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
        this.bNC.setData(this.cEu.UT());
        this.bNC.setUserAfterClickListener(this.cEE);
        if (this.bNC.getHeaderImg() != null) {
            this.bNC.getHeaderImg().setAfterClickListener(this.cEF);
            if (this.bNC.getIsSimpleThread()) {
                this.bNC.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (this.cEu.UT() == null || this.cEu.UT().wm() == null || this.cEu.UT().wm().getPendantData() == null || StringUtils.isNull(this.cEu.UT().wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.bNC.getHeaderImg().setVisibility(0);
                if (this.cEu.UT().amj > 0 && this.cEu.UT().amk == 0) {
                    this.cEu.UT().wm().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bNC.getHeaderImg().setData(this.cEu.UT(), false);
                } else {
                    this.bNC.getHeaderImg().setData(this.cEu.UT());
                    this.bNC.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(this.cEu.UT());
            }
        }
        this.bgm.setText(ao.dj(this.cEu.bzB.wE().video_duration.intValue() * 1000));
        this.bgv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.L(this.cEu.bzB.wE().play_count.intValue())));
        if (this.bNP != null && this.cEu.UT() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cEu.UT().getTid());
            ahVar.setFid(this.cEu.UT().getFid());
            ahVar.a(this.cEu.aiT);
            this.bNP.setData(ahVar);
            this.bNP.setFirstRowSingleColumn(true);
            this.bNP.setVisibility(this.cEx ? 0 : 8);
        }
        this.cCi.setData(this.cEu.UT().xD());
        hM(gT(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.lB(this.cEu.bzB.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.cEu == null || this.cEu.bzB == null || this.cEu.bzB.wE() == null) {
            z = false;
        } else {
            z = this.cEu.bzB.wE().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cEB.setVisibility(0);
            if (akB()) {
                this.cEB.setText(String.format("%s | %s", this.mContext.getResources().getString(e.j.nani_video), this.mContext.getResources().getString(e.j.video_preview)));
            } else {
                this.cEB.setText(this.mContext.getString(e.j.nani_video));
            }
        } else if (akB()) {
            this.cEB.setVisibility(0);
            this.cEB.setText(this.mContext.getString(e.j.video_preview));
        } else {
            this.cEB.setVisibility(8);
        }
    }

    private void ajN() {
        this.cEC.removeMessages(202);
        this.cEC.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Oz() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgA);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgB);
    }

    private void akA() {
        Oz();
        ajN();
        if (this.bgn != null && this.bgl != null && this.bgp != null) {
            if (com.baidu.tbadk.core.i.uj().un() && this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.wE() != null) {
                this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bgn.startLoad(this.cEu.bzB.wE().thumbnail_url, 10, false);
                this.bgl.setVisibility(0);
                stopPlay();
                this.avN = this.cEu.bzB.wE().video_url;
                if (akB()) {
                    this.avN = this.cEu.bzB.wF().video_url;
                }
                if (StringUtils.isNull(this.cEu.bzB.wE().video_url)) {
                    e(true, 4);
                }
                if (this.bBi != null && this.bBi.bnd() != null) {
                    this.bBi.bnd().g(this.cEu.bzB.wE());
                }
                this.bgp.cd(this.avN, this.cEu.tid);
                return;
            }
            this.bgl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bNB, e.f.addresslist_item_bg);
            al.c(this.bgo, e.f.btn_icon_play_video_n);
            al.h(this.bgq, e.d.cp_cont_i);
            al.h(this.bgm, e.d.cp_cont_i);
            al.h(this.bgv, e.d.cp_cont_i);
            al.h(this.cEA, e.d.cp_cont_i);
            al.j(this.bgr, e.d.common_color_10014);
            al.j(this.bqy, e.d.cp_bg_line_e);
            if (this.cEB != null) {
                al.h(this.cEB, e.d.cp_cont_i);
                al.i(this.cEB, e.f.video_play_count_bg);
            }
            if (this.bgq != null) {
                this.bgq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cCi.onChangeSkinType();
            if (this.bNP != null) {
                this.bNP.onChangeSkinType();
            }
            this.bNC.onChangeSkinType();
            this.bND.onChangeSkinType();
            this.bOr.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cEG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cEG);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bNC != null) {
            this.bNC.setPageUniqueId(bdUniqueId);
        }
        if (this.bgn != null) {
            this.bgn.setPageId(bdUniqueId);
        }
        if (this.bNP != null) {
            this.bNP.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cEw;
    }

    public boolean isPlaying() {
        if (this.bgp == null) {
            return false;
        }
        return this.bgp.isPlaying();
    }

    public void startPlay() {
        if (!this.cEw && this.cEu != null && this.cEu.bzB != null && this.cEu.bzB.wE() != null && this.bgp != null) {
            this.bgp.stopPlayback();
            if (com.baidu.tbadk.util.aa.q(1, this.avN)) {
                this.cEt.aYi();
                e(true, 2);
                if (StringUtils.isNull(this.avN)) {
                    TiebaStatic.log(new am("c12619").al("obj_locate", "index").al("tid", this.cEu.tid));
                    this.avN = this.cEu.bzB.wE().video_url;
                }
                this.cEw = true;
                this.bgp.setVideoPath(this.avN, this.cEu.tid);
                if (this.bBh != null) {
                    this.bBh.start();
                }
                akv();
            }
        }
    }

    public void stopPlay() {
        Oz();
        ajN();
        e(true, 1);
        if (this.bgp != null) {
            this.bgp.stopPlayback();
            if (this.bBh != null) {
                this.bBh.stop();
            }
        }
        this.cEw = false;
    }

    public View getVideoContainer() {
        return this.bgl;
    }

    public String getPlayUrl() {
        return this.avN;
    }

    public int getCurrentPosition() {
        if (this.bgp == null) {
            return 0;
        }
        return this.bgp.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.bBi != null) {
            this.bBi.setVideoStatsData(yVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bNP != null) {
            this.bNP.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bNC != null) {
            return this.bNC.aBr;
        }
        return null;
    }

    public View akp() {
        if (this.bNC != null) {
            return this.bNC.aBt;
        }
        return null;
    }

    public void eK(boolean z) {
        this.cEx = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void hM(int i) {
        if (this.cEu != null && this.cEu.bzB != null) {
            if (i == 1) {
                if (this.cEu.bzB.amj > 0) {
                    this.bOr.aBl.setShowPraiseNum(false);
                    this.bOr.aBl.setShareVisible(false);
                    this.cEA.setText(ao.L(this.cEu.bzB.amj));
                    this.cEA.setVisibility(0);
                } else {
                    this.bOr.aBl.setShowPraiseNum(true);
                    this.bOr.aBl.setShareVisible(true);
                    this.cEA.setVisibility(8);
                }
                this.bOr.setData(this.cEu.bzB);
                this.bND.setVisibility(8);
                this.bNC.showForumNameView(false);
                return;
            }
            this.bOr.setVisibility(8);
            this.bNC.showForumNameView(true);
            if (this.cEu.bzB.amj > 0) {
                this.bND.setShowPraiseNum(false);
                this.bND.setShareVisible(false);
                this.cEA.setText(ao.L(this.cEu.bzB.amj));
                this.cEA.setVisibility(0);
            } else {
                this.bND.setShowPraiseNum(true);
                this.bND.setShareVisible(true);
                this.cEA.setVisibility(8);
            }
            if (this.bND.setData(this.cEu.bzB)) {
                this.cEm.setVisibility(8);
            } else {
                this.cEm.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bgn.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.n.10
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bgn.setOnDrawListener(null);
        }
    }

    private boolean akB() {
        return (this.cEu == null || this.cEu.bzB == null || this.cEu.bzB.wF() == null || TextUtils.isEmpty(this.cEu.bzB.wF().video_url)) ? false : true;
    }
}
