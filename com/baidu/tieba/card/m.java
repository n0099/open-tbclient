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
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class m extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private QuickVideoView TD;
    private int UH;
    private String YA;
    private Animation aeZ;
    private String bNl;
    private final View.OnClickListener bRz;
    public FrameLayout cAb;
    private TextView cAc;
    private TbImageView cAd;
    private ImageView cAe;
    private TextView cAf;
    private View cAg;
    private com.baidu.tieba.play.x cAh;
    private View cAi;
    private TextView cAj;
    private int cAk;
    private TbImageView.a cAl;
    private g.b cAm;
    private Runnable cAo;
    private Runnable cAp;
    private QuickVideoView.b cAq;
    private g.a cJF;
    private g.f cJG;
    private g.e cJI;
    private View cKK;
    private com.baidu.tieba.play.j dbd;
    private com.baidu.tieba.play.n dbe;
    private NEGFeedBackView dqG;
    private RelativeLayout dqt;
    public ThreadUserInfoLayout dqu;
    public ThreadCommentAndPraiseInfoLayout dqv;
    public ThreadSourceShareAndPraiseLayout drk;
    protected LinearLayout drv;
    private View ehE;
    private com.baidu.afd.videopaster.d ehI;
    public ThreadGodReplyLayout ehJ;
    private HeadPendantClickableView ehK;
    private com.baidu.tieba.play.g ehL;
    private LinearLayout ehM;
    private com.baidu.tieba.j.k ehN;
    private com.baidu.tieba.card.data.l ehO;
    private int ehP;
    private boolean ehQ;
    private boolean ehR;
    private boolean ehS;
    private TextView ehT;
    private boolean ehU;
    private TextView ehV;
    private Handler ehW;
    private VideoLoadingProgressView.a ehX;
    private CustomMessageListener ehY;
    private final View.OnClickListener ehZ;
    private final View.OnClickListener eia;
    private CustomMessageListener eib;
    private j.a eic;
    private Animation.AnimationListener eid;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aQn() {
        if (this.ehL != null && this.ehQ) {
            try {
                this.TD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.ehL.isPlayerReuse()) {
                int AT = com.baidu.tieba.play.y.bTV().AT(this.bNl);
                if (AT <= 100 || this.ehL.getDuration() <= AT) {
                    AT = 100;
                }
                this.UH = AT;
            } else {
                this.UH = 100;
            }
            this.ehW.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.ehO != null && this.ehO.cZz != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.ehO.sourceType == 0 ? "index" : "hot_juhe";
            zVar.ctu = this.ehO.cZz.getTid();
            zVar.ela = this.ehO.cZz.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.ehO.cZz.mRecomSource;
            zVar.hYL = this.ehO.cZz.mRecomAbTag;
            zVar.hYM = this.ehO.cZz.mRecomWeight;
            zVar.hYN = "";
            zVar.byA = this.ehO.getExtra();
            if (this.ehO.cZz.Zi() != null) {
                zVar.hYP = this.ehO.cZz.Zi().video_md5;
            }
            com.baidu.tieba.play.l.a(this.ehO.cZz.Zi().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqG = null;
        this.mSkinType = 3;
        this.ehP = 0;
        this.cAk = 1;
        this.ehQ = false;
        this.ehR = true;
        this.ehS = false;
        this.UH = 100;
        this.ehU = false;
        this.ehW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.aQs();
                        return;
                    case 203:
                        m.this.aQt();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJG = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                m.this.ehL = gVar;
                if (m.this.ehL != null) {
                    m.this.ehL.setVolume(0.0f, 0.0f);
                }
                m.this.ehN.bEB();
                m.this.aQn();
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.ehI.a(false, false, "NEWINDEX")) {
                    m.this.TD.start();
                }
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.ehQ = false;
                return true;
            }
        };
        this.ehX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aQn();
            }
        };
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && m.this.cAd != null) {
                    m.this.cAd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAo = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.TD != null && !m.this.TD.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cAp = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.ehY = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.ehO != null && m.this.ehO.cZz != null && videoId.equals(m.this.ehO.cZz.getId())) {
                        m.this.ehI.a(m.this.a(m.this.ehO, bVar));
                    }
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehO == null) {
                    if (m.this.aQh() != null) {
                        m.this.aQh().a(view, m.this.ehO);
                        return;
                    }
                    return;
                }
                if (view == m.this.dqu.getUserName()) {
                    m.this.ehO.objType = 3;
                } else if (view == m.this.dqu.getHeaderImg()) {
                    m.this.ehO.objType = 4;
                } else {
                    m.this.ehO.objType = 1;
                }
                if (m.this.aQh() != null) {
                    m.this.aQh().a(view, m.this.ehO);
                }
            }
        };
        this.eia = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehO != null) {
                    m.this.ehO.objType = 4;
                }
                if (m.this.aQh() != null) {
                    m.this.aQh().a(view, m.this.ehO);
                }
            }
        };
        this.eib = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.ehS = false;
                }
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehO != null) {
                    if (m.this.aQh() != null) {
                        m.this.aQh().a(view, m.this.ehO);
                    }
                    if (m.this.ehO.cZz != null && view != m.this.drk.bSQ) {
                        n.tA(m.this.ehO.cZz.getId());
                        if (!m.this.aQr()) {
                            n.a(m.this.mTextTitle, m.this.ehO.cZz.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                            n.a(m.this.ehJ.getGodReplyContent(), m.this.ehO.WR().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.eic = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                if (m.this.ehO != null && m.this.ehO.cZz != null && m.this.ehO.cZz.Zi() != null) {
                    m.this.aQo();
                }
            }
        };
        this.eid = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cAd != null) {
                    m.this.cAd.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dqt = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ehK = (HeadPendantClickableView) this.dqt.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehK.getHeadView() != null) {
            this.ehK.getHeadView().setIsRound(true);
            this.ehK.getHeadView().setDrawBorder(false);
            this.ehK.getHeadView().setDefaultResource(17170445);
            this.ehK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehK.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehK.setHasPendantStyle();
        if (this.ehK.getPendantView() != null) {
            this.ehK.getPendantView().setIsRound(true);
            this.ehK.getPendantView().setDrawBorder(false);
        }
        this.cAh = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAh.setLoadingAnimationListener(this.ehX);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dqu = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.dqG = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16);
        this.dqG.a(this.dqt, h, 0);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.dqv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqv.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqv.setLayoutParams(layoutParams);
        }
        this.dqv.setOnClickListener(this);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setShareVisible(true);
        this.dqv.setShareReportFrom(3);
        this.dqv.setForumAfterClickListener(this.bRz);
        this.dqv.setFrom(1);
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.drk.bTz.setOnClickListener(this);
        this.drk.setFrom(1);
        this.drk.setShareReportFrom(3);
        this.drk.setForumAfterClickListener(this.bRz);
        this.ehE = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cAb = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAb.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cAb.setLayoutParams(layoutParams2);
        this.cAd = (TbImageView) view.findViewById(d.g.image_video);
        this.cAd.setDefaultErrorResource(0);
        this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAd.setGifIconSupport(false);
        this.cAd.setEvent(this.cAl);
        this.cAd.setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds20));
        TbImageView tbImageView = this.cAd;
        TbImageView tbImageView2 = this.cAd;
        tbImageView.setConrers(15);
        this.cAd.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAd.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAd.setBorderSurroundContent(true);
        this.cAd.setDrawBorder(true);
        this.cAe = (ImageView) view.findViewById(d.g.image_video_play);
        this.dqt.setOnClickListener(this);
        this.TD = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.dbe = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.TD.setPlayerReuseEnable(true);
        this.TD.setContinuePlayEnable(true);
        this.TD.setBusiness(this.dbe);
        this.TD.setOnPreparedListener(this.cJG);
        this.TD.setOnOutInfoListener(this.cJI);
        this.TD.setOnCompletionListener(this.cJF);
        this.TD.setOnErrorListener(this.cAm);
        this.TD.setOnSurfaceDestroyedListener(this.cAq);
        this.dbd = new com.baidu.tieba.play.j();
        this.dbd.setPlayer(this.TD);
        this.dbd.a(this.eic);
        this.cAc = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehM = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAj = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cAi = view.findViewById(d.g.auto_video_black_mask);
        this.cAf = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAg = view.findViewById(d.g.auto_video_error_background);
        this.drv = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.aeZ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.aeZ.setAnimationListener(this.eid);
        this.ehJ = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehJ.setOnClickListener(this);
        this.cKK = view.findViewById(d.g.divider_line);
        this.ehT = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.TD.setOnClickListener(this);
        this.ehV = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehN = new com.baidu.tieba.j.k();
        this.ehI = new com.baidu.afd.videopaster.d(getContext(), this.cAb);
        this.ehI.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void qs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qr() {
                if (!m.this.ehU) {
                    m.this.TD.start();
                } else {
                    m.this.startPlay();
                }
                m.this.ehU = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qq() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean qt() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.bDt > 0) {
            if (aQh() != null) {
                aQh().a(view, this.ehO);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.ehO.cZz.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.YE(), this.ehO.WU())));
            return;
        }
        if (view == this.dqt || view == this.ehJ) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.TD) {
            if (this.ehO != null) {
                this.ehO.objType = 5;
            }
            if (this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.Zi() != null) {
                z = this.ehO.cZz.Zi().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(this.TD);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                by(this.TD);
            } else {
                bz(getView());
            }
        }
    }

    private void bx(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehO);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQp();
        }
    }

    private void by(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehO);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQq();
        }
    }

    private void aQp() {
        if (this.ehO != null && this.ehO.cZz != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehO.cZz);
            videoItemData.mRecomExtra = this.ehO.getExtra();
            videoItemData.mRecomAbTag = this.ehO.aQQ();
            videoItemData.mRecomSource = this.ehO.getSource();
            videoItemData.mRecomWeight = this.ehO.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.ehO.WU(), "index")));
        }
    }

    private void aQq() {
        if (this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehO.cZz);
            videoSerializeVideoThreadInfo.source = this.ehO.getSource();
            videoSerializeVideoThreadInfo.extra = this.ehO.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.ehO.aQQ();
            videoSerializeVideoThreadInfo.weight = this.ehO.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.drv.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.drv.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ap.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.ehO.cZz.getTid(), n.YE(), this.ehO.WU(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bz(View view) {
        if (this.ehO != null) {
            this.ehO.objType = 1;
        }
        if (aQh() != null) {
            aQh().a(view, this.ehO);
        }
        if (this.ehO != null && this.ehO.cZz != null) {
            if (!aQr()) {
                n.tA(this.ehO.cZz.getId());
                n.a(this.mTextTitle, this.ehO.cZz.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehO.cZz, null, n.YE(), 18003, true, false, false).addLocateParam(this.ehO.WU());
            addLocateParam.setVideo_source(this.ehO.sourceType == 0 ? "index" : "hot_juhe");
            if (this.ehO.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.ehO.cZz.getFid()));
            addLocateParam.setForumName(this.ehO.cZz.YW());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehJ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQr() {
        return this.ehO.elI && !this.ehO.elQ;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.ehO = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
        this.ehW.removeMessages(202);
        if (this.TD.getCurrentPosition() > this.UH) {
            i(false, 3);
            this.ehW.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.ehW.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ehW.removeMessages(203);
        int currentPosition = this.TD.getCurrentPosition();
        if (currentPosition != this.ehP) {
            this.ehP = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.ehW.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cAe != null && this.cAd != null && this.cAi != null && this.cAh != null && this.cAg != null && this.cAf != null) {
            if (z || this.cAk != i) {
                this.cAk = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAp);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAo);
                if (i == 2) {
                    this.cAe.setVisibility(8);
                    this.aeZ.cancel();
                    this.cAd.clearAnimation();
                    this.cAd.setVisibility(0);
                    this.cAi.setVisibility(0);
                    this.ehM.setVisibility(0);
                    this.ehT.setVisibility(8);
                    this.cAh.startLoading();
                    this.cAg.setVisibility(8);
                    this.cAf.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAp, 60000L);
                } else if (i == 3) {
                    this.cAe.setVisibility(8);
                    this.cAd.startAnimation(this.aeZ);
                    this.cAi.setVisibility(8);
                    this.ehM.setVisibility(8);
                    if (this.ehO != null && this.ehO.WR() != null && this.ehO.WR().bDt > 0) {
                        this.ehT.setVisibility(0);
                    }
                    this.cAh.bTQ();
                    this.cAg.setVisibility(8);
                    this.cAf.setVisibility(8);
                    if (this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.Zi() != null) {
                        this.ehN.a(this.ehO.cZz.getTid(), this.ehO.cZz.Zi().video_length.intValue(), this.ehO.cZz.Zi().video_duration.intValue(), "homepage", this.TD);
                    }
                } else if (i == 4) {
                    this.cAe.setVisibility(8);
                    this.cAd.startAnimation(this.aeZ);
                    this.cAi.setVisibility(8);
                    this.cAh.bTR();
                    this.cAg.setVisibility(0);
                    this.cAf.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAo, 2000L);
                } else {
                    this.cAe.setVisibility(0);
                    this.aeZ.cancel();
                    this.cAd.clearAnimation();
                    this.cAd.setVisibility(0);
                    this.cAi.setVisibility(0);
                    this.ehM.setVisibility(0);
                    this.cAh.bTR();
                    this.cAg.setVisibility(8);
                    this.cAf.setVisibility(8);
                }
                if (this.ehO != null && this.ehO.WR() != null && this.ehO.WR().bDt > 0) {
                    this.ehM.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ehO == null || this.ehO.cZz == null || this.ehO.cZz.YR() == null) {
            this.dqt.setVisibility(8);
            return;
        }
        this.dqt.setVisibility(0);
        aQv();
        if (!aQr() && n.tB(this.ehO.cZz.getId())) {
            n.a(this.mTextTitle, this.ehO.cZz.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehJ.getGodReplyContent(), this.ehO.WR().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        this.ehO.WR().ZH();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ehO.WR().Zx());
        if (this.ehO.WR().ZE() && !StringUtils.isNull(this.ehO.WR().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehO.WR().getTid();
            spannableStringBuilder.append((CharSequence) this.ehO.WR().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.dqu.setData(this.ehO.WR());
        this.dqu.setUserAfterClickListener(this.ehZ);
        if (this.dqu.getHeaderImg() != null) {
            this.dqu.getHeaderImg().setAfterClickListener(this.eia);
            if (this.dqu.getIsSimpleThread()) {
                this.dqu.getHeaderImg().setVisibility(8);
                this.ehK.setVisibility(8);
            } else if (this.ehO.WR() == null || this.ehO.WR().YR() == null || this.ehO.WR().YR().getPendantData() == null || StringUtils.isNull(this.ehO.WR().YR().getPendantData().Xn())) {
                this.ehK.setVisibility(8);
                this.dqu.getHeaderImg().setVisibility(0);
                if (this.ehO.WR().bDt > 0 && this.ehO.WR().bDu == 0) {
                    this.ehO.WR().YR().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dqu.getHeaderImg().setData(this.ehO.WR(), false);
                } else {
                    this.dqu.getHeaderImg().setData(this.ehO.WR());
                    this.dqu.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dqu.getHeaderImg().setVisibility(4);
                this.ehK.setVisibility(0);
                this.ehK.setData(this.ehO.WR());
            }
        }
        this.cAc.setText(ap.hz(this.ehO.cZz.Zi().video_duration.intValue() * 1000));
        this.cAj.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehO.cZz.Zi().play_count.intValue())));
        if (this.dqG != null && this.ehO.WR() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehO.WR().getTid());
            ajVar.setFid(this.ehO.WR().getFid());
            ajVar.b(this.ehO.bzu);
            this.dqG.setData(ajVar);
            this.dqG.setFirstRowSingleColumn(true);
            this.dqG.setVisibility(this.ehR ? 0 : 8);
        }
        this.ehJ.setData(this.ehO.WR().aap());
        mF(lt(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tB(this.ehO.cZz.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        if (this.ehO == null || this.ehO.cZz == null || this.ehO.cZz.Zi() == null) {
            z = false;
        } else {
            z = this.ehO.cZz.Zi().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehV.setVisibility(0);
            if (aQw()) {
                this.ehV.setText(String.format("%s | %s", this.mContext.getResources().getString(d.j.nani_video), this.mContext.getResources().getString(d.j.video_preview)));
            } else {
                this.ehV.setText(this.mContext.getString(d.j.nani_video));
            }
        } else if (aQw()) {
            this.ehV.setVisibility(0);
            this.ehV.setText(this.mContext.getString(d.j.video_preview));
        } else {
            this.ehV.setVisibility(8);
        }
    }

    private void aQu() {
        this.ehW.removeMessages(202);
        this.ehW.removeMessages(203);
    }

    private void asd() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAo);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAp);
    }

    private void aQv() {
        asd();
        aQu();
        if (this.cAd != null && this.cAb != null && this.TD != null) {
            if (com.baidu.tbadk.core.i.Wy().WC() && this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.Zi() != null) {
                this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAd.startLoad(this.ehO.cZz.Zi().thumbnail_url, 10, false);
                this.cAb.setVisibility(0);
                stopPlay();
                this.bNl = this.ehO.cZz.Zi().video_url;
                if (aQw()) {
                    this.bNl = this.ehO.cZz.Zj().video_url;
                }
                if (StringUtils.isNull(this.ehO.cZz.Zi().video_url)) {
                    i(true, 4);
                }
                if (this.dbe != null && this.dbe.bTz() != null) {
                    this.dbe.bTz().g(this.ehO.cZz.Zi());
                }
                this.TD.dE(this.bNl, this.ehO.tid);
            } else {
                this.cAb.setVisibility(8);
            }
            this.ehI.reset();
            this.dbd.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehI.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehO);
                    }
                }
            });
            this.dbe.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehI.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehO);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cZz != null) {
            bg bgVar = lVar.cZz;
            if (bgVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bgVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.cZz == null || bVar == null) {
            return null;
        }
        bg bgVar = lVar.cZz;
        int qx = bVar.qx();
        int qy = bVar.qy();
        int qw = bVar.qw();
        if (qw != -1) {
            i = qx != -1 ? (qw - qx) - 1 : -1;
            if (qy != -1) {
                i4 = (qy - qw) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo Zi = bgVar.Zi();
        if (Zi != null) {
            i3 = Zi.video_width.intValue();
            i2 = Zi.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.YW());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qw + 1, i3, i2);
        a.l(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqt, d.f.addresslist_item_bg);
            al.c(this.cAe, d.f.btn_icon_play_video_n);
            al.j(this.cAf, d.C0277d.cp_btn_a);
            al.j(this.cAc, d.C0277d.cp_btn_a);
            al.j(this.cAj, d.C0277d.cp_btn_a);
            al.j(this.ehT, d.C0277d.cp_btn_a);
            al.l(this.cAg, d.C0277d.common_color_10014);
            al.l(this.cKK, d.C0277d.cp_bg_line_e);
            if (this.ehV != null) {
                al.j(this.ehV, d.C0277d.cp_btn_a);
                al.k(this.ehV, d.f.video_play_count_bg);
            }
            if (this.cAf != null) {
                this.cAf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ehJ.onChangeSkinType();
            if (this.dqG != null) {
                this.dqG.onChangeSkinType();
            }
            this.dqu.onChangeSkinType();
            this.dqv.onChangeSkinType();
            this.drk.onChangeSkinType();
            this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ehK.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eib.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eib);
            this.ehY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ehY);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqu != null) {
            this.dqu.setPageUniqueId(bdUniqueId);
        }
        if (this.cAd != null) {
            this.cAd.setPageId(bdUniqueId);
        }
        if (this.dqG != null) {
            this.dqG.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.ehQ;
    }

    public boolean isPlaying() {
        if (this.TD == null) {
            return false;
        }
        return this.TD.isPlaying();
    }

    public void startPlay() {
        if (!this.ehQ && this.ehO != null && this.ehO.cZz != null && this.ehO.cZz.Zi() != null && this.TD != null) {
            if (this.ehI.qb()) {
                this.ehI.resume();
                this.ehU = true;
                return;
            }
            this.ehU = false;
            this.TD.stopPlayback();
            if (ad.H(1, this.bNl)) {
                this.ehN.bEA();
                i(true, 2);
                if (StringUtils.isNull(this.bNl)) {
                    TiebaStatic.log(new am("c12619").bJ("obj_locate", "index").bJ("tid", this.ehO.tid));
                    this.bNl = this.ehO.cZz.Zi().video_url;
                }
                this.ehQ = true;
                this.TD.setVideoPath(this.bNl, this.ehO.tid);
                if (this.dbd != null) {
                    this.dbd.start();
                }
                aQo();
            }
        }
    }

    public void stopPlay() {
        this.ehU = false;
        asd();
        aQu();
        i(true, 1);
        if (this.TD != null) {
            this.TD.stopPlayback();
            if (this.dbd != null) {
                this.dbd.stop();
            }
        }
        this.ehQ = false;
        this.ehI.stop();
    }

    public View getVideoContainer() {
        return this.cAb;
    }

    public String getPlayUrl() {
        return this.bNl;
    }

    public int getCurrentPosition() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.getCurrentPosition();
    }

    public void hK(boolean z) {
        this.ehR = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void mF(int i) {
        if (this.ehO != null && this.ehO.cZz != null) {
            if (i == 1) {
                if (this.ehO.cZz.bDt > 0) {
                    this.drk.bTz.setShowPraiseNum(false);
                    this.drk.bTz.setShareVisible(false);
                    this.ehT.setText(ap.az(this.ehO.cZz.bDt));
                    this.ehT.setVisibility(0);
                } else {
                    this.drk.bTz.setShowPraiseNum(true);
                    this.drk.bTz.setShareVisible(true);
                    this.ehT.setVisibility(8);
                }
                this.drk.setData(this.ehO.cZz);
                this.dqv.setVisibility(8);
                this.dqu.dN(false);
                return;
            }
            this.drk.setVisibility(8);
            this.dqu.dN(true);
            if (this.ehO.cZz.bDt > 0) {
                this.dqv.setShowPraiseNum(false);
                this.dqv.setShareVisible(false);
                this.ehT.setText(ap.az(this.ehO.cZz.bDt));
                this.ehT.setVisibility(0);
            } else {
                this.dqv.setShowPraiseNum(true);
                this.dqv.setShareVisible(true);
                this.ehT.setVisibility(8);
            }
            if (this.dqv.setData(this.ehO.cZz)) {
                this.ehE.setVisibility(8);
            } else {
                this.ehE.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAd.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAd.setOnDrawListener(null);
        }
    }

    private boolean aQw() {
        return (this.ehO == null || this.ehO.cZz == null || this.ehO.cZz.Zj() == null || TextUtils.isEmpty(this.ehO.cZz.Zj().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.ehI.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.ehI.stop();
    }

    public void onResume() {
        if (this.ehI.qb()) {
            this.ehI.resume();
        }
    }
}
