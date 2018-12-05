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
    private String aEN;
    private final View.OnClickListener aIx;
    private Animation bOd;
    private com.baidu.tieba.play.j bOo;
    private com.baidu.tieba.play.n bOp;
    public FrameLayout boK;
    private TextView boL;
    private TbImageView boM;
    private ImageView boN;
    private QuickVideoView boO;
    private TextView boP;
    private View boQ;
    private com.baidu.tieba.play.x boR;
    private View boS;
    private TextView boT;
    private int boU;
    private TbImageView.a boV;
    private g.b boW;
    private Runnable boY;
    private Runnable boZ;
    private QuickVideoView.b bpa;
    private g.a bxI;
    private g.f bxJ;
    private g.e bxL;
    private View byP;
    public ThreadGodReplyLayout cSq;
    private com.baidu.tieba.j.k cUA;
    private com.baidu.tieba.card.data.l cUB;
    private int cUC;
    private boolean cUD;
    private boolean cUE;
    private boolean cUF;
    private int cUG;
    private TextView cUH;
    private TextView cUI;
    private Handler cUJ;
    private VideoLoadingProgressView.a cUK;
    private final View.OnClickListener cUL;
    private final View.OnClickListener cUM;
    private CustomMessageListener cUN;
    private j.a cUO;
    private Animation.AnimationListener cUP;
    private View cUt;
    private com.baidu.tieba.play.g cUy;
    private LinearLayout cUz;
    private RelativeLayout caH;
    public ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private NEGFeedBackView caU;
    private String caw;
    protected LinearLayout cbH;
    private HeadPendantClickableView cbt;
    public ThreadSourceShareAndPraiseLayout cbw;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void apl() {
        if (this.cUy != null && this.cUD) {
            try {
                this.boO.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.cUy.isPlayerReuse()) {
                int tW = com.baidu.tieba.play.y.bsd().tW(this.aEN);
                if (tW <= 100 || this.cUy.getDuration() <= tW) {
                    tW = 100;
                }
                this.cUG = tW;
            } else {
                this.cUG = 100;
            }
            this.cUJ.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apm() {
        if (this.cUB != null && this.cUB.bMJ != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.cUB.sourceType == 0 ? "index" : "hot_juhe";
            zVar.biw = this.cUB.bMJ.getTid();
            zVar.cXO = this.cUB.bMJ.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.cUB.bMJ.mRecomSource;
            zVar.gEN = this.cUB.bMJ.mRecomAbTag;
            zVar.gEO = this.cUB.bMJ.mRecomWeight;
            zVar.gEP = "";
            zVar.arh = this.cUB.getExtra();
            if (this.cUB.bMJ.zY() != null) {
                zVar.gER = this.cUB.bMJ.zY().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cUB.bMJ.zY().video_md5, "", "1", zVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caU = null;
        this.mSkinType = 3;
        this.cUC = 0;
        this.boU = 1;
        this.cUD = false;
        this.cUE = true;
        this.cUF = false;
        this.cUG = 100;
        this.cUJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.app();
                        return;
                    case 203:
                        n.this.apq();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxJ = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cUy = gVar;
                if (n.this.cUy != null) {
                    n.this.cUy.setVolume(0.0f, 0.0f);
                }
                n.this.cUA.bcL();
                n.this.apl();
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    n.this.e(false, 3);
                }
                return false;
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                n.this.boO.start();
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                n.this.cUD = false;
                return true;
            }
        };
        this.cUK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.apl();
            }
        };
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && n.this.boM != null) {
                    n.this.boM.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.boY = new Runnable() { // from class: com.baidu.tieba.card.n.18
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.boO != null && !n.this.boO.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.boZ = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cUL = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cUB == null) {
                    if (n.this.apc() != null) {
                        n.this.apc().a(view, n.this.cUB);
                        return;
                    }
                    return;
                }
                if (view == n.this.caI.getUserName()) {
                    n.this.cUB.aFp = 3;
                } else if (view == n.this.caI.getHeaderImg()) {
                    n.this.cUB.aFp = 4;
                } else {
                    n.this.cUB.aFp = 1;
                }
                if (n.this.apc() != null) {
                    n.this.apc().a(view, n.this.cUB);
                }
            }
        };
        this.cUM = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cUB != null) {
                    n.this.cUB.aFp = 4;
                }
                if (n.this.apc() != null) {
                    n.this.apc().a(view, n.this.cUB);
                }
            }
        };
        this.cUN = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cUF = false;
                }
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cUB != null) {
                    if (n.this.apc() != null) {
                        n.this.apc().a(view, n.this.cUB);
                    }
                    if (n.this.cUB.bMJ != null && view != n.this.cbw.aKh) {
                        o.mD(n.this.cUB.bMJ.getId());
                        if (!n.this.apg()) {
                            o.a(n.this.mTextTitle, n.this.cUB.bMJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                            o.a(n.this.cSq.getGodReplyContent(), n.this.cUB.ZR().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cUO = new j.a() { // from class: com.baidu.tieba.card.n.8
            @Override // com.baidu.tieba.play.j.a
            public void apt() {
                if (n.this.cUB != null && n.this.cUB.bMJ != null && n.this.cUB.bMJ.zY() != null) {
                    n.this.apm();
                }
            }
        };
        this.cUP = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.boM != null) {
                    n.this.boM.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.caH = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cbt = (HeadPendantClickableView) this.caH.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.boR = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.boR.setLoadingAnimationListener(this.cUK);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.caU = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16);
        this.caU.a(this.caH, h, 0);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.setShareReportFrom(3);
        this.caJ.setForumAfterClickListener(this.aIx);
        this.caJ.setFrom(1);
        this.caJ.setDisPraiseFrom(1);
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.cbw.aKi.setOnClickListener(this);
        this.cbw.setFrom(1);
        this.cbw.setShareReportFrom(3);
        this.cbw.setForumAfterClickListener(this.aIx);
        this.cUt = view.findViewById(e.g.divider_below_reply_number_layout);
        this.boK = (FrameLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.boK.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.boK.setLayoutParams(layoutParams2);
        this.boM = (TbImageView) view.findViewById(e.g.image_video);
        this.boM.setDefaultErrorResource(0);
        this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boM.setGifIconSupport(false);
        this.boM.setEvent(this.boV);
        this.boN = (ImageView) view.findViewById(e.g.image_video_play);
        this.caH.setOnClickListener(this);
        this.boO = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.bOp = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.boO.setPlayerReuseEnable(true);
        this.boO.setContinuePlayEnable(true);
        this.boO.setBusiness(this.bOp);
        this.boO.setOnPreparedListener(this.bxJ);
        this.boO.setOnOutInfoListener(this.bxL);
        this.boO.setOnCompletionListener(this.bxI);
        this.boO.setOnErrorListener(this.boW);
        this.boO.setOnSurfaceDestroyedListener(this.bpa);
        this.bOo = new com.baidu.tieba.play.j();
        this.bOo.setPlayer(this.boO);
        this.bOo.a(this.cUO);
        this.boL = (TextView) view.findViewById(e.g.text_video_duration);
        this.cUz = (LinearLayout) view.findViewById(e.g.duration_container);
        this.boT = (TextView) view.findViewById(e.g.text_video_play_count);
        this.boS = view.findViewById(e.g.auto_video_black_mask);
        this.boP = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.boQ = view.findViewById(e.g.auto_video_error_background);
        this.cbH = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bOd = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bOd.setAnimationListener(this.cUP);
        this.cSq = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cSq.setOnClickListener(this);
        this.byP = view.findViewById(e.g.divider_line);
        this.cUH = (TextView) view.findViewById(e.g.txt_video_num_during_playing);
        this.boO.setOnClickListener(this);
        this.cUI = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cUA = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.avr > 0) {
            if (apc() != null) {
                apc().a(view, this.cUB);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cUB.bMJ.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.zu(), this.cUB.apO())));
            return;
        }
        if (view == this.caH || view == this.cSq) {
            aC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.boO) {
            if (this.cUB != null) {
                this.cUB.aFp = 5;
            }
            if (this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.zY() != null) {
                z = this.cUB.bMJ.zY().is_vertical.intValue() == 1;
            }
            if (z) {
                aA(getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aB(getView());
            } else {
                aC(getView());
            }
        }
    }

    private void aA(View view) {
        if (apc() != null) {
            apc().a(view, this.cUB);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            apn();
        }
    }

    private void aB(View view) {
        if (apc() != null) {
            apc().a(view, this.cUB);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            apo();
        }
    }

    private void apn() {
        if (this.cUB != null && this.cUB.bMJ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cUB.bMJ);
            videoItemData.mRecomExtra = this.cUB.getExtra();
            videoItemData.mRecomAbTag = this.cUB.apP();
            videoItemData.mRecomSource = this.cUB.getSource();
            videoItemData.mRecomWeight = this.cUB.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cUB.apO(), "index")));
        }
    }

    private void apo() {
        if (this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cUB.bMJ);
            videoSerializeVideoThreadInfo.source = this.cUB.getSource();
            videoSerializeVideoThreadInfo.extra = this.cUB.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.cUB.apP();
            videoSerializeVideoThreadInfo.weight = this.cUB.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.cbH.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cbH.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ao.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cUB.bMJ.getTid(), o.zu(), this.cUB.apO(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aC(View view) {
        if (this.cUB != null) {
            this.cUB.aFp = 1;
        }
        if (apc() != null) {
            apc().a(view, this.cUB);
        }
        if (this.cUB != null && this.cUB.bMJ != null) {
            if (!apg()) {
                o.mD(this.cUB.bMJ.getId());
                o.a(this.mTextTitle, this.cUB.bMJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cUB.bMJ, null, o.zu(), 18003, true, false, false).addLocateParam(this.cUB.apO());
            addLocateParam.setVideo_source(this.cUB.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cUB.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cUB.bMJ.getFid()));
            addLocateParam.setForumName(this.cUB.bMJ.zM());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cSq) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apg() {
        return this.cUB.cYg && !this.cUB.cYp;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cUB = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void app() {
        this.cUJ.removeMessages(202);
        if (this.boO.getCurrentPosition() > this.cUG) {
            e(false, 3);
            this.cUJ.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cUJ.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cUJ.removeMessages(203);
        int currentPosition = this.boO.getCurrentPosition();
        if (currentPosition != this.cUC) {
            this.cUC = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cUJ.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.boN != null && this.boM != null && this.boS != null && this.boR != null && this.boQ != null && this.boP != null) {
            if (z || this.boU != i) {
                this.boU = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boZ);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boY);
                if (i == 2) {
                    this.boN.setVisibility(8);
                    this.bOd.cancel();
                    this.boM.clearAnimation();
                    this.boM.setVisibility(0);
                    this.boS.setVisibility(0);
                    this.cUz.setVisibility(0);
                    this.cUH.setVisibility(8);
                    this.boR.startLoading();
                    this.boQ.setVisibility(8);
                    this.boP.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.boZ, 60000L);
                } else if (i == 3) {
                    this.boN.setVisibility(8);
                    this.boM.startAnimation(this.bOd);
                    this.boS.setVisibility(8);
                    this.cUz.setVisibility(8);
                    if (this.cUB != null && this.cUB.ZR() != null && this.cUB.ZR().avr > 0) {
                        this.cUH.setVisibility(0);
                    }
                    this.boR.brY();
                    this.boQ.setVisibility(8);
                    this.boP.setVisibility(8);
                    if (this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.zY() != null) {
                        this.cUA.a(this.cUB.bMJ.getTid(), this.cUB.bMJ.zY().video_length.intValue(), this.cUB.bMJ.zY().video_duration.intValue(), "homepage", this.boO);
                    }
                } else if (i == 4) {
                    this.boN.setVisibility(8);
                    this.boM.startAnimation(this.bOd);
                    this.boS.setVisibility(8);
                    this.boR.brZ();
                    this.boQ.setVisibility(0);
                    this.boP.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.boY, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.boN.setVisibility(0);
                    this.bOd.cancel();
                    this.boM.clearAnimation();
                    this.boM.setVisibility(0);
                    this.boS.setVisibility(0);
                    this.cUz.setVisibility(0);
                    this.boR.brZ();
                    this.boQ.setVisibility(8);
                    this.boP.setVisibility(8);
                }
                if (this.cUB != null && this.cUB.ZR() != null && this.cUB.ZR().avr > 0) {
                    this.cUz.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cUB == null || this.cUB.bMJ == null || this.cUB.bMJ.zG() == null) {
            this.caH.setVisibility(8);
            return;
        }
        this.caH.setVisibility(0);
        apr();
        if (!apg() && o.mE(this.cUB.bMJ.getId())) {
            o.a(this.mTextTitle, this.cUB.bMJ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cSq.getGodReplyContent(), this.cUB.ZR().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cUB.ZR().Aq();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cUB.ZR().Ag());
        if (this.cUB.ZR().An() && !StringUtils.isNull(this.cUB.ZR().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cUB.ZR().getTid();
            spannableStringBuilder.append((CharSequence) this.cUB.ZR().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.17
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
        this.caI.setData(this.cUB.ZR());
        this.caI.setUserAfterClickListener(this.cUL);
        if (this.caI.getHeaderImg() != null) {
            this.caI.getHeaderImg().setAfterClickListener(this.cUM);
            if (this.caI.getIsSimpleThread()) {
                this.caI.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (this.cUB.ZR() == null || this.cUB.ZR().zG() == null || this.cUB.ZR().zG().getPendantData() == null || StringUtils.isNull(this.cUB.ZR().zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.caI.getHeaderImg().setVisibility(0);
                if (this.cUB.ZR().avr > 0 && this.cUB.ZR().avs == 0) {
                    this.cUB.ZR().zG().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.caI.getHeaderImg().setData(this.cUB.ZR(), false);
                } else {
                    this.caI.getHeaderImg().setData(this.cUB.ZR());
                    this.caI.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.caI.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(this.cUB.ZR());
            }
        }
        this.boL.setText(ao.dV(this.cUB.bMJ.zY().video_duration.intValue() * 1000));
        this.boT.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.W(this.cUB.bMJ.zY().play_count.intValue())));
        if (this.caU != null && this.cUB.ZR() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cUB.ZR().getTid());
            ahVar.setFid(this.cUB.ZR().getFid());
            ahVar.a(this.cUB.asc);
            this.caU.setData(ahVar);
            this.caU.setFirstRowSingleColumn(true);
            this.caU.setVisibility(this.cUE ? 0 : 8);
        }
        this.cSq.setData(this.cUB.ZR().AX());
        iL(hC(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mE(this.cUB.bMJ.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.cUB == null || this.cUB.bMJ == null || this.cUB.bMJ.zY() == null) {
            z = false;
        } else {
            z = this.cUB.bMJ.zY().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cUI.setVisibility(0);
            if (aps()) {
                this.cUI.setText(String.format("%s | %s", this.mContext.getResources().getString(e.j.nani_video), this.mContext.getResources().getString(e.j.video_preview)));
            } else {
                this.cUI.setText(this.mContext.getString(e.j.nani_video));
            }
        } else if (aps()) {
            this.cUI.setVisibility(0);
            this.cUI.setText(this.mContext.getString(e.j.video_preview));
        } else {
            this.cUI.setVisibility(8);
        }
    }

    private void aoE() {
        this.cUJ.removeMessages(202);
        this.cUJ.removeMessages(203);
    }

    private void RK() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boY);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boZ);
    }

    private void apr() {
        RK();
        aoE();
        if (this.boM != null && this.boK != null && this.boO != null) {
            if (com.baidu.tbadk.core.i.xE().xI() && this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.zY() != null) {
                this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boM.startLoad(this.cUB.bMJ.zY().thumbnail_url, 10, false);
                this.boK.setVisibility(0);
                stopPlay();
                this.aEN = this.cUB.bMJ.zY().video_url;
                if (aps()) {
                    this.aEN = this.cUB.bMJ.zZ().video_url;
                }
                if (StringUtils.isNull(this.cUB.bMJ.zY().video_url)) {
                    e(true, 4);
                }
                if (this.bOp != null && this.bOp.brH() != null) {
                    this.bOp.brH().g(this.cUB.bMJ.zY());
                }
                this.boO.ct(this.aEN, this.cUB.tid);
                return;
            }
            this.boK.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.caH, e.f.addresslist_item_bg);
            al.c(this.boN, e.f.btn_icon_play_video_n);
            al.h(this.boP, e.d.cp_cont_i);
            al.h(this.boL, e.d.cp_cont_i);
            al.h(this.boT, e.d.cp_cont_i);
            al.h(this.cUH, e.d.cp_cont_i);
            al.j(this.boQ, e.d.common_color_10014);
            al.j(this.byP, e.d.cp_bg_line_e);
            if (this.cUI != null) {
                al.h(this.cUI, e.d.cp_cont_i);
                al.i(this.cUI, e.f.video_play_count_bg);
            }
            if (this.boP != null) {
                this.boP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cSq.onChangeSkinType();
            if (this.caU != null) {
                this.caU.onChangeSkinType();
            }
            this.caI.onChangeSkinType();
            this.caJ.onChangeSkinType();
            this.cbw.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cUN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cUN);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caI != null) {
            this.caI.setPageUniqueId(bdUniqueId);
        }
        if (this.boM != null) {
            this.boM.setPageId(bdUniqueId);
        }
        if (this.caU != null) {
            this.caU.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cUD;
    }

    public boolean isPlaying() {
        if (this.boO == null) {
            return false;
        }
        return this.boO.isPlaying();
    }

    public void startPlay() {
        if (!this.cUD && this.cUB != null && this.cUB.bMJ != null && this.cUB.bMJ.zY() != null && this.boO != null) {
            this.boO.stopPlayback();
            if (com.baidu.tbadk.util.aa.p(1, this.aEN)) {
                this.cUA.bcK();
                e(true, 2);
                if (StringUtils.isNull(this.aEN)) {
                    TiebaStatic.log(new am("c12619").aA("obj_locate", "index").aA("tid", this.cUB.tid));
                    this.aEN = this.cUB.bMJ.zY().video_url;
                }
                this.cUD = true;
                this.boO.setVideoPath(this.aEN, this.cUB.tid);
                if (this.bOo != null) {
                    this.bOo.start();
                }
                apm();
            }
        }
    }

    public void stopPlay() {
        RK();
        aoE();
        e(true, 1);
        if (this.boO != null) {
            this.boO.stopPlayback();
            if (this.bOo != null) {
                this.bOo.stop();
            }
        }
        this.cUD = false;
    }

    public View getVideoContainer() {
        return this.boK;
    }

    public String getPlayUrl() {
        return this.aEN;
    }

    public int getCurrentPosition() {
        if (this.boO == null) {
            return 0;
        }
        return this.boO.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.bOp != null) {
            this.bOp.setVideoStatsData(zVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caU != null) {
            this.caU.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caI != null) {
            return this.caI.aKn;
        }
        return null;
    }

    public View apf() {
        if (this.caI != null) {
            return this.caI.aKp;
        }
        return null;
    }

    public void fo(boolean z) {
        this.cUE = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void iL(int i) {
        if (this.cUB != null && this.cUB.bMJ != null) {
            if (i == 1) {
                if (this.cUB.bMJ.avr > 0) {
                    this.cbw.aKi.setShowPraiseNum(false);
                    this.cbw.aKi.setShareVisible(false);
                    this.cUH.setText(ao.W(this.cUB.bMJ.avr));
                    this.cUH.setVisibility(0);
                } else {
                    this.cbw.aKi.setShowPraiseNum(true);
                    this.cbw.aKi.setShareVisible(true);
                    this.cUH.setVisibility(8);
                }
                this.cbw.setData(this.cUB.bMJ);
                this.caJ.setVisibility(8);
                this.caI.showForumNameView(false);
                return;
            }
            this.cbw.setVisibility(8);
            this.caI.showForumNameView(true);
            if (this.cUB.bMJ.avr > 0) {
                this.caJ.setShowPraiseNum(false);
                this.caJ.setShareVisible(false);
                this.cUH.setText(ao.W(this.cUB.bMJ.avr));
                this.cUH.setVisibility(0);
            } else {
                this.caJ.setShowPraiseNum(true);
                this.caJ.setShareVisible(true);
                this.cUH.setVisibility(8);
            }
            if (this.caJ.setData(this.cUB.bMJ)) {
                this.cUt.setVisibility(8);
            } else {
                this.cUt.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.boM.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.n.10
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.boM.setOnDrawListener(null);
        }
    }

    private boolean aps() {
        return (this.cUB == null || this.cUB.bMJ == null || this.cUB.bMJ.zZ() == null || TextUtils.isEmpty(this.cUB.bMJ.zZ().video_url)) ? false : true;
    }
}
