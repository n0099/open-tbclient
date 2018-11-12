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
    private String aBn;
    private final View.OnClickListener aEX;
    private com.baidu.tieba.play.n bKA;
    private Animation bKo;
    private com.baidu.tieba.play.j bKz;
    private String bWE;
    private RelativeLayout bWP;
    public ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    public ThreadSourceShareAndPraiseLayout bXE;
    protected LinearLayout bXP;
    private NEGFeedBackView bXc;
    private Runnable blA;
    private Runnable blB;
    private QuickVideoView.b blC;
    public FrameLayout blm;
    private TextView bln;
    private TbImageView blo;
    private ImageView blp;
    private QuickVideoView blq;
    private TextView blr;
    private View bls;
    private com.baidu.tieba.play.x blt;
    private View blu;
    private TextView blv;
    private int blw;
    private TbImageView.a blx;
    private g.b bly;
    private g.a bul;
    private g.f bum;
    private g.e buo;
    private View bvs;
    public ThreadGodReplyLayout cLJ;
    private View cNM;
    private com.baidu.tieba.play.g cNR;
    private LinearLayout cNS;
    private com.baidu.tieba.j.k cNT;
    private com.baidu.tieba.card.data.l cNU;
    private int cNV;
    private boolean cNW;
    private boolean cNX;
    private boolean cNY;
    private int cNZ;
    private TextView cOa;
    private TextView cOb;
    private Handler cOc;
    private VideoLoadingProgressView.a cOd;
    private final View.OnClickListener cOe;
    private final View.OnClickListener cOf;
    private CustomMessageListener cOg;
    private j.a cOh;
    private Animation.AnimationListener cOi;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void any() {
        if (this.cNR != null && this.cNW) {
            try {
                this.blq.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.cNR.isPlayerReuse()) {
                int tu = com.baidu.tieba.play.y.bqk().tu(this.aBn);
                if (tu <= 100 || this.cNR.getDuration() <= tu) {
                    tu = 100;
                }
                this.cNZ = tu;
            } else {
                this.cNZ = 100;
            }
            this.cOc.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anz() {
        if (this.cNU != null && this.cNU.bIU != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.cNU.sourceType == 0 ? "index" : "hot_juhe";
            zVar.beV = this.cNU.bIU.getTid();
            zVar.cRh = this.cNU.bIU.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.cNU.bIU.mRecomSource;
            zVar.gxX = this.cNU.bIU.mRecomAbTag;
            zVar.gxY = this.cNU.bIU.mRecomWeight;
            zVar.gxZ = "";
            zVar.anG = this.cNU.getExtra();
            if (this.cNU.bIU.yU() != null) {
                zVar.gyb = this.cNU.bIU.yU().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cNU.bIU.yU().video_md5, "", "1", zVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bXc = null;
        this.mSkinType = 3;
        this.cNV = 0;
        this.blw = 1;
        this.cNW = false;
        this.cNX = true;
        this.cNY = false;
        this.cNZ = 100;
        this.cOc = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.anC();
                        return;
                    case 203:
                        n.this.anD();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bum = new g.f() { // from class: com.baidu.tieba.card.n.11
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cNR = gVar;
                if (n.this.cNR != null) {
                    n.this.cNR.setVolume(0.0f, 0.0f);
                }
                n.this.cNT.baU();
                n.this.any();
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    n.this.e(false, 3);
                }
                return false;
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                com.baidu.tieba.play.y.bqk().remove(n.this.aBn);
                n.this.blq.start();
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                n.this.cNW = false;
                return true;
            }
        };
        this.cOd = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.any();
            }
        };
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && n.this.blo != null) {
                    n.this.blo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.blA = new Runnable() { // from class: com.baidu.tieba.card.n.18
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.blq != null && !n.this.blq.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.blB = new Runnable() { // from class: com.baidu.tieba.card.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cOe = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cNU == null) {
                    if (n.this.anq() != null) {
                        n.this.anq().a(view, n.this.cNU);
                        return;
                    }
                    return;
                }
                if (view == n.this.bWQ.getUserName()) {
                    n.this.cNU.aBP = 3;
                } else if (view == n.this.bWQ.getHeaderImg()) {
                    n.this.cNU.aBP = 4;
                } else {
                    n.this.cNU.aBP = 1;
                }
                if (n.this.anq() != null) {
                    n.this.anq().a(view, n.this.cNU);
                }
            }
        };
        this.cOf = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cNU != null) {
                    n.this.cNU.aBP = 4;
                }
                if (n.this.anq() != null) {
                    n.this.anq().a(view, n.this.cNU);
                }
            }
        };
        this.cOg = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cNY = false;
                }
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cNU != null) {
                    if (n.this.anq() != null) {
                        n.this.anq().a(view, n.this.cNU);
                    }
                    if (n.this.cNU.bIU != null && view != n.this.bXE.aGH) {
                        o.me(n.this.cNU.bIU.getId());
                        if (!n.this.anu()) {
                            o.a(n.this.mTextTitle, n.this.cNU.bIU.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                            o.a(n.this.cLJ.getGodReplyContent(), n.this.cNU.YL().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cOh = new j.a() { // from class: com.baidu.tieba.card.n.8
            @Override // com.baidu.tieba.play.j.a
            public void anG() {
                if (n.this.cNU != null && n.this.cNU.bIU != null && n.this.cNU.bIU.yU() != null) {
                    n.this.anz();
                }
            }
        };
        this.cOi = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.blo != null) {
                    n.this.blo.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.bWP = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.bXB = (HeadPendantClickableView) this.bWP.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0200e.ds70));
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.blt = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.blt.setLoadingAnimationListener(this.cOd);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.bXc = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds16);
        this.bXc.a(this.bWP, h, 0);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.setShareReportFrom(3);
        this.bWR.setForumAfterClickListener(this.aEX);
        this.bWR.setFrom(1);
        this.bWR.setDisPraiseFrom(1);
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.bXE.aGI.setOnClickListener(this);
        this.bXE.setFrom(1);
        this.bXE.setShareReportFrom(3);
        this.bXE.setForumAfterClickListener(this.aEX);
        this.cNM = view.findViewById(e.g.divider_below_reply_number_layout);
        this.blm = (FrameLayout) view.findViewById(e.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.blm.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0200e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.blm.setLayoutParams(layoutParams2);
        this.blo = (TbImageView) view.findViewById(e.g.image_video);
        this.blo.setDefaultErrorResource(0);
        this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.blo.setGifIconSupport(false);
        this.blo.setEvent(this.blx);
        this.blp = (ImageView) view.findViewById(e.g.image_video_play);
        this.bWP.setOnClickListener(this);
        this.blq = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.bKA = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.blq.setPlayerReuseEnable(true);
        this.blq.setContinuePlayEnable(true);
        this.blq.setBusiness(this.bKA);
        this.blq.setOnPreparedListener(this.bum);
        this.blq.setOnOutInfoListener(this.buo);
        this.blq.setOnCompletionListener(this.bul);
        this.blq.setOnErrorListener(this.bly);
        this.blq.setOnSurfaceDestroyedListener(this.blC);
        this.bKz = new com.baidu.tieba.play.j();
        this.bKz.setPlayer(this.blq);
        this.bKz.a(this.cOh);
        this.bln = (TextView) view.findViewById(e.g.text_video_duration);
        this.cNS = (LinearLayout) view.findViewById(e.g.duration_container);
        this.blv = (TextView) view.findViewById(e.g.text_video_play_count);
        this.blu = view.findViewById(e.g.auto_video_black_mask);
        this.blr = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bls = view.findViewById(e.g.auto_video_error_background);
        this.bXP = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bKo = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bKo.setAnimationListener(this.cOi);
        this.cLJ = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cLJ.setOnClickListener(this);
        this.bvs = view.findViewById(e.g.divider_line);
        this.cOa = (TextView) view.findViewById(e.g.txt_video_num_during_playing);
        this.blq.setOnClickListener(this);
        this.cOb = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cNT = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.arR > 0) {
            if (anq() != null) {
                anq().a(view, this.cNU);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cNU.bIU.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.yq(), this.cNU.aob())));
            return;
        }
        if (view == this.bWP || view == this.cLJ) {
            aC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.blq) {
            if (this.cNU != null) {
                this.cNU.aBP = 5;
            }
            if (this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.yU() != null) {
                z = this.cNU.bIU.yU().is_vertical.intValue() == 1;
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
        if (anq() != null) {
            anq().a(view, this.cNU);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anA();
        }
    }

    private void aB(View view) {
        if (anq() != null) {
            anq().a(view, this.cNU);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anB();
        }
    }

    private void anA() {
        if (this.cNU != null && this.cNU.bIU != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cNU.bIU);
            videoItemData.mRecomExtra = this.cNU.getExtra();
            videoItemData.mRecomAbTag = this.cNU.aoc();
            videoItemData.mRecomSource = this.cNU.getSource();
            videoItemData.mRecomWeight = this.cNU.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cNU.aob(), "index")));
        }
    }

    private void anB() {
        if (this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cNU.bIU);
            videoSerializeVideoThreadInfo.source = this.cNU.getSource();
            videoSerializeVideoThreadInfo.extra = this.cNU.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.cNU.aoc();
            videoSerializeVideoThreadInfo.weight = this.cNU.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.bXP.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bXP.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ao.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cNU.bIU.getTid(), o.yq(), this.cNU.aob(), videoSerializeVideoThreadInfo)));
        }
    }

    private void aC(View view) {
        if (this.cNU != null) {
            this.cNU.aBP = 1;
        }
        if (anq() != null) {
            anq().a(view, this.cNU);
        }
        if (this.cNU != null && this.cNU.bIU != null) {
            if (!anu()) {
                o.me(this.cNU.bIU.getId());
                o.a(this.mTextTitle, this.cNU.bIU.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cNU.bIU, null, o.yq(), 18003, true, false, false).addLocateParam(this.cNU.aob());
            addLocateParam.setVideo_source(this.cNU.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cNU.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cNU.bIU.getFid()));
            addLocateParam.setForumName(this.cNU.bIU.yI());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cLJ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anu() {
        return this.cNU.cRz && !this.cNU.cRI;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cNU = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anC() {
        this.cOc.removeMessages(202);
        if (this.blq.getCurrentPosition() > this.cNZ) {
            e(false, 3);
            this.cOc.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cOc.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cOc.removeMessages(203);
        int currentPosition = this.blq.getCurrentPosition();
        if (currentPosition != this.cNV) {
            this.cNV = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cOc.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.blp != null && this.blo != null && this.blu != null && this.blt != null && this.bls != null && this.blr != null) {
            if (z || this.blw != i) {
                this.blw = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blB);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blA);
                if (i == 2) {
                    this.blp.setVisibility(8);
                    this.bKo.cancel();
                    this.blo.clearAnimation();
                    this.blo.setVisibility(0);
                    this.blu.setVisibility(0);
                    this.cNS.setVisibility(0);
                    this.cOa.setVisibility(8);
                    this.blt.startLoading();
                    this.bls.setVisibility(8);
                    this.blr.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.blB, 60000L);
                } else if (i == 3) {
                    this.blp.setVisibility(8);
                    this.blo.startAnimation(this.bKo);
                    this.blu.setVisibility(8);
                    this.cNS.setVisibility(8);
                    if (this.cNU != null && this.cNU.YL() != null && this.cNU.YL().arR > 0) {
                        this.cOa.setVisibility(0);
                    }
                    this.blt.bqf();
                    this.bls.setVisibility(8);
                    this.blr.setVisibility(8);
                    if (this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.yU() != null) {
                        this.cNT.a(this.cNU.bIU.getTid(), this.cNU.bIU.yU().video_length.intValue(), this.cNU.bIU.yU().video_duration.intValue(), "homepage", this.blq);
                    }
                } else if (i == 4) {
                    this.blp.setVisibility(8);
                    this.blo.startAnimation(this.bKo);
                    this.blu.setVisibility(8);
                    this.blt.bqg();
                    this.bls.setVisibility(0);
                    this.blr.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.blA, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.blp.setVisibility(0);
                    this.bKo.cancel();
                    this.blo.clearAnimation();
                    this.blo.setVisibility(0);
                    this.blu.setVisibility(0);
                    this.cNS.setVisibility(0);
                    this.blt.bqg();
                    this.bls.setVisibility(8);
                    this.blr.setVisibility(8);
                }
                if (this.cNU != null && this.cNU.YL() != null && this.cNU.YL().arR > 0) {
                    this.cNS.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cNU == null || this.cNU.bIU == null || this.cNU.bIU.yC() == null) {
            this.bWP.setVisibility(8);
            return;
        }
        this.bWP.setVisibility(0);
        anE();
        if (!anu() && o.mf(this.cNU.bIU.getId())) {
            o.a(this.mTextTitle, this.cNU.bIU.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cLJ.getGodReplyContent(), this.cNU.YL().getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cNU.YL().zm();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cNU.YL().zc());
        if (this.cNU.YL().zj() && !StringUtils.isNull(this.cNU.YL().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cNU.YL().getTid();
            spannableStringBuilder.append((CharSequence) this.cNU.YL().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.17
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
        this.bWQ.setData(this.cNU.YL());
        this.bWQ.setUserAfterClickListener(this.cOe);
        if (this.bWQ.getHeaderImg() != null) {
            this.bWQ.getHeaderImg().setAfterClickListener(this.cOf);
            if (this.bWQ.getIsSimpleThread()) {
                this.bWQ.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (this.cNU.YL() == null || this.cNU.YL().yC() == null || this.cNU.YL().yC().getPendantData() == null || StringUtils.isNull(this.cNU.YL().yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.bWQ.getHeaderImg().setVisibility(0);
                if (this.cNU.YL().arR > 0 && this.cNU.YL().arS == 0) {
                    this.cNU.YL().yC().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bWQ.getHeaderImg().setData(this.cNU.YL(), false);
                } else {
                    this.bWQ.getHeaderImg().setData(this.cNU.YL());
                    this.bWQ.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bWQ.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(this.cNU.YL());
            }
        }
        this.bln.setText(ao.dH(this.cNU.bIU.yU().video_duration.intValue() * 1000));
        this.blv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.P(this.cNU.bIU.yU().play_count.intValue())));
        if (this.bXc != null && this.cNU.YL() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cNU.YL().getTid());
            ahVar.setFid(this.cNU.YL().getFid());
            ahVar.a(this.cNU.aoB);
            this.bXc.setData(ahVar);
            this.bXc.setFirstRowSingleColumn(true);
            this.bXc.setVisibility(this.cNX ? 0 : 8);
        }
        this.cLJ.setData(this.cNU.YL().zT());
        ix(ho(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.mf(this.cNU.bIU.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.cNU == null || this.cNU.bIU == null || this.cNU.bIU.yU() == null) {
            z = false;
        } else {
            z = this.cNU.bIU.yU().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cOb.setVisibility(0);
            if (anF()) {
                this.cOb.setText(String.format("%s | %s", this.mContext.getResources().getString(e.j.nani_video), this.mContext.getResources().getString(e.j.video_preview)));
            } else {
                this.cOb.setText(this.mContext.getString(e.j.nani_video));
            }
        } else if (anF()) {
            this.cOb.setVisibility(0);
            this.cOb.setText(this.mContext.getString(e.j.video_preview));
        } else {
            this.cOb.setVisibility(8);
        }
    }

    private void amS() {
        this.cOc.removeMessages(202);
        this.cOc.removeMessages(203);
    }

    private void QE() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blA);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blB);
    }

    private void anE() {
        QE();
        amS();
        if (this.blo != null && this.blm != null && this.blq != null) {
            if (com.baidu.tbadk.core.i.wA().wE() && this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.yU() != null) {
                this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.blo.startLoad(this.cNU.bIU.yU().thumbnail_url, 10, false);
                this.blm.setVisibility(0);
                stopPlay();
                this.aBn = this.cNU.bIU.yU().video_url;
                if (anF()) {
                    this.aBn = this.cNU.bIU.yV().video_url;
                }
                if (StringUtils.isNull(this.cNU.bIU.yU().video_url)) {
                    e(true, 4);
                }
                if (this.bKA != null && this.bKA.bpO() != null) {
                    this.bKA.bpO().g(this.cNU.bIU.yU());
                }
                this.blq.co(this.aBn, this.cNU.tid);
                return;
            }
            this.blm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bWP, e.f.addresslist_item_bg);
            al.c(this.blp, e.f.btn_icon_play_video_n);
            al.h(this.blr, e.d.cp_cont_i);
            al.h(this.bln, e.d.cp_cont_i);
            al.h(this.blv, e.d.cp_cont_i);
            al.h(this.cOa, e.d.cp_cont_i);
            al.j(this.bls, e.d.common_color_10014);
            al.j(this.bvs, e.d.cp_bg_line_e);
            if (this.cOb != null) {
                al.h(this.cOb, e.d.cp_cont_i);
                al.i(this.cOb, e.f.video_play_count_bg);
            }
            if (this.blr != null) {
                this.blr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cLJ.onChangeSkinType();
            if (this.bXc != null) {
                this.bXc.onChangeSkinType();
            }
            this.bWQ.onChangeSkinType();
            this.bWR.onChangeSkinType();
            this.bXE.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cOg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOg);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bWQ != null) {
            this.bWQ.setPageUniqueId(bdUniqueId);
        }
        if (this.blo != null) {
            this.blo.setPageId(bdUniqueId);
        }
        if (this.bXc != null) {
            this.bXc.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cNW;
    }

    public boolean isPlaying() {
        if (this.blq == null) {
            return false;
        }
        return this.blq.isPlaying();
    }

    public void startPlay() {
        if (!this.cNW && this.cNU != null && this.cNU.bIU != null && this.cNU.bIU.yU() != null && this.blq != null) {
            this.blq.stopPlayback();
            if (com.baidu.tbadk.util.aa.p(1, this.aBn)) {
                this.cNT.baT();
                e(true, 2);
                if (StringUtils.isNull(this.aBn)) {
                    TiebaStatic.log(new am("c12619").ax("obj_locate", "index").ax("tid", this.cNU.tid));
                    this.aBn = this.cNU.bIU.yU().video_url;
                }
                this.cNW = true;
                this.blq.setVideoPath(this.aBn, this.cNU.tid);
                if (this.bKz != null) {
                    this.bKz.start();
                }
                anz();
            }
        }
    }

    public void stopPlay() {
        QE();
        amS();
        e(true, 1);
        if (this.blq != null) {
            this.blq.stopPlayback();
            if (this.bKz != null) {
                this.bKz.stop();
            }
        }
        this.cNW = false;
    }

    public View getVideoContainer() {
        return this.blm;
    }

    public String getPlayUrl() {
        return this.aBn;
    }

    public int getCurrentPosition() {
        if (this.blq == null) {
            return 0;
        }
        return this.blq.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.bKA != null) {
            this.bKA.setVideoStatsData(zVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bXc != null) {
            this.bXc.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWQ != null) {
            return this.bWQ.aGN;
        }
        return null;
    }

    public View ant() {
        if (this.bWQ != null) {
            return this.bWQ.aGP;
        }
        return null;
    }

    public void fn(boolean z) {
        this.cNX = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void ix(int i) {
        if (this.cNU != null && this.cNU.bIU != null) {
            if (i == 1) {
                if (this.cNU.bIU.arR > 0) {
                    this.bXE.aGI.setShowPraiseNum(false);
                    this.bXE.aGI.setShareVisible(false);
                    this.cOa.setText(ao.P(this.cNU.bIU.arR));
                    this.cOa.setVisibility(0);
                } else {
                    this.bXE.aGI.setShowPraiseNum(true);
                    this.bXE.aGI.setShareVisible(true);
                    this.cOa.setVisibility(8);
                }
                this.bXE.setData(this.cNU.bIU);
                this.bWR.setVisibility(8);
                this.bWQ.showForumNameView(false);
                return;
            }
            this.bXE.setVisibility(8);
            this.bWQ.showForumNameView(true);
            if (this.cNU.bIU.arR > 0) {
                this.bWR.setShowPraiseNum(false);
                this.bWR.setShareVisible(false);
                this.cOa.setText(ao.P(this.cNU.bIU.arR));
                this.cOa.setVisibility(0);
            } else {
                this.bWR.setShowPraiseNum(true);
                this.bWR.setShareVisible(true);
                this.cOa.setVisibility(8);
            }
            if (this.bWR.setData(this.cNU.bIU)) {
                this.cNM.setVisibility(8);
            } else {
                this.cNM.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.blo.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.n.10
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.blo.setOnDrawListener(null);
        }
    }

    private boolean anF() {
        return (this.cNU == null || this.cNU.bIU == null || this.cNU.bIU.yV() == null || TextUtils.isEmpty(this.cNU.bIU.yV().video_url)) ? false : true;
    }
}
