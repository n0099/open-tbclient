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
    private Animation afe;
    private String bNn;
    private final View.OnClickListener bRB;
    public FrameLayout cAd;
    private TextView cAe;
    private TbImageView cAf;
    private ImageView cAg;
    private TextView cAh;
    private View cAi;
    private com.baidu.tieba.play.x cAj;
    private View cAk;
    private TextView cAl;
    private int cAm;
    private TbImageView.a cAn;
    private g.b cAo;
    private Runnable cAq;
    private Runnable cAr;
    private QuickVideoView.b cAs;
    private g.a cJH;
    private g.f cJI;
    private g.e cJK;
    private View cKM;
    private com.baidu.tieba.play.j dbg;
    private com.baidu.tieba.play.n dbh;
    private NEGFeedBackView dqJ;
    private RelativeLayout dqw;
    public ThreadUserInfoLayout dqx;
    public ThreadCommentAndPraiseInfoLayout dqy;
    public ThreadSourceShareAndPraiseLayout drn;
    protected LinearLayout dry;
    private com.baidu.tieba.card.data.l ehA;
    private int ehB;
    private boolean ehC;
    private boolean ehD;
    private boolean ehE;
    private TextView ehF;
    private boolean ehG;
    private TextView ehH;
    private Handler ehI;
    private VideoLoadingProgressView.a ehJ;
    private CustomMessageListener ehK;
    private final View.OnClickListener ehL;
    private final View.OnClickListener ehM;
    private CustomMessageListener ehN;
    private j.a ehO;
    private Animation.AnimationListener ehP;
    private View ehq;
    private com.baidu.afd.videopaster.d ehu;
    public ThreadGodReplyLayout ehv;
    private HeadPendantClickableView ehw;
    private com.baidu.tieba.play.g ehx;
    private LinearLayout ehy;
    private com.baidu.tieba.j.k ehz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        if (this.ehx != null && this.ehC) {
            try {
                this.TD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.ehx.isPlayerReuse()) {
                int AS = com.baidu.tieba.play.y.bTR().AS(this.bNn);
                if (AS <= 100 || this.ehx.getDuration() <= AS) {
                    AS = 100;
                }
                this.UH = AS;
            } else {
                this.UH = 100;
            }
            this.ehI.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.ehA != null && this.ehA.cZC != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.ehA.sourceType == 0 ? "index" : "hot_juhe";
            zVar.ctw = this.ehA.cZC.getTid();
            zVar.ekM = this.ehA.cZC.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.ehA.cZC.mRecomSource;
            zVar.hYx = this.ehA.cZC.mRecomAbTag;
            zVar.hYy = this.ehA.cZC.mRecomWeight;
            zVar.hYz = "";
            zVar.byD = this.ehA.getExtra();
            if (this.ehA.cZC.Zf() != null) {
                zVar.hYB = this.ehA.cZC.Zf().video_md5;
            }
            com.baidu.tieba.play.l.a(this.ehA.cZC.Zf().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqJ = null;
        this.mSkinType = 3;
        this.ehB = 0;
        this.cAm = 1;
        this.ehC = false;
        this.ehD = true;
        this.ehE = false;
        this.UH = 100;
        this.ehG = false;
        this.ehI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.aQq();
                        return;
                    case 203:
                        m.this.aQr();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                m.this.ehx = gVar;
                if (m.this.ehx != null) {
                    m.this.ehx.setVolume(0.0f, 0.0f);
                }
                m.this.ehz.bEy();
                m.this.aQl();
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.ehu.a(false, false, "NEWINDEX")) {
                    m.this.TD.start();
                }
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.ehC = false;
                return true;
            }
        };
        this.ehJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aQl();
            }
        };
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && m.this.cAf != null) {
                    m.this.cAf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAq = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.TD != null && !m.this.TD.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.ehK = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.ehA != null && m.this.ehA.cZC != null && videoId.equals(m.this.ehA.cZC.getId())) {
                        m.this.ehu.a(m.this.a(m.this.ehA, bVar));
                    }
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.ehL = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehA == null) {
                    if (m.this.aQf() != null) {
                        m.this.aQf().a(view, m.this.ehA);
                        return;
                    }
                    return;
                }
                if (view == m.this.dqx.getUserName()) {
                    m.this.ehA.objType = 3;
                } else if (view == m.this.dqx.getHeaderImg()) {
                    m.this.ehA.objType = 4;
                } else {
                    m.this.ehA.objType = 1;
                }
                if (m.this.aQf() != null) {
                    m.this.aQf().a(view, m.this.ehA);
                }
            }
        };
        this.ehM = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehA != null) {
                    m.this.ehA.objType = 4;
                }
                if (m.this.aQf() != null) {
                    m.this.aQf().a(view, m.this.ehA);
                }
            }
        };
        this.ehN = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.ehE = false;
                }
            }
        };
        this.bRB = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehA != null) {
                    if (m.this.aQf() != null) {
                        m.this.aQf().a(view, m.this.ehA);
                    }
                    if (m.this.ehA.cZC != null && view != m.this.drn.bSS) {
                        n.tz(m.this.ehA.cZC.getId());
                        if (!m.this.aQp()) {
                            n.a(m.this.mTextTitle, m.this.ehA.cZC.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                            n.a(m.this.ehv.getGodReplyContent(), m.this.ehA.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.ehO = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                if (m.this.ehA != null && m.this.ehA.cZC != null && m.this.ehA.cZC.Zf() != null) {
                    m.this.aQm();
                }
            }
        };
        this.ehP = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cAf != null) {
                    m.this.cAf.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dqw = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ehw = (HeadPendantClickableView) this.dqw.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehw.getHeadView() != null) {
            this.ehw.getHeadView().setIsRound(true);
            this.ehw.getHeadView().setDrawBorder(false);
            this.ehw.getHeadView().setDefaultResource(17170445);
            this.ehw.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehw.setHasPendantStyle();
        if (this.ehw.getPendantView() != null) {
            this.ehw.getPendantView().setIsRound(true);
            this.ehw.getPendantView().setDrawBorder(false);
        }
        this.cAj = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAj.setLoadingAnimationListener(this.ehJ);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dqx = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.dqJ = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16);
        this.dqJ.a(this.dqw, h, 0);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.dqy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqy.setLayoutParams(layoutParams);
        }
        this.dqy.setOnClickListener(this);
        this.dqy.setReplyTimeVisible(false);
        this.dqy.setShowPraiseNum(true);
        this.dqy.setNeedAddPraiseIcon(true);
        this.dqy.setNeedAddReplyIcon(true);
        this.dqy.setShareVisible(true);
        this.dqy.setShareReportFrom(3);
        this.dqy.setForumAfterClickListener(this.bRB);
        this.dqy.setFrom(1);
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.drn.bTB.setOnClickListener(this);
        this.drn.setFrom(1);
        this.drn.setShareReportFrom(3);
        this.drn.setForumAfterClickListener(this.bRB);
        this.ehq = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cAd = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAd.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cAd.setLayoutParams(layoutParams2);
        this.cAf = (TbImageView) view.findViewById(d.g.image_video);
        this.cAf.setDefaultErrorResource(0);
        this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAf.setGifIconSupport(false);
        this.cAf.setEvent(this.cAn);
        this.cAf.setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds20));
        TbImageView tbImageView = this.cAf;
        TbImageView tbImageView2 = this.cAf;
        tbImageView.setConrers(15);
        this.cAf.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAf.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAf.setBorderSurroundContent(true);
        this.cAf.setDrawBorder(true);
        this.cAg = (ImageView) view.findViewById(d.g.image_video_play);
        this.dqw.setOnClickListener(this);
        this.TD = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.dbh = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.TD.setPlayerReuseEnable(true);
        this.TD.setContinuePlayEnable(true);
        this.TD.setBusiness(this.dbh);
        this.TD.setOnPreparedListener(this.cJI);
        this.TD.setOnOutInfoListener(this.cJK);
        this.TD.setOnCompletionListener(this.cJH);
        this.TD.setOnErrorListener(this.cAo);
        this.TD.setOnSurfaceDestroyedListener(this.cAs);
        this.dbg = new com.baidu.tieba.play.j();
        this.dbg.setPlayer(this.TD);
        this.dbg.a(this.ehO);
        this.cAe = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehy = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAl = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cAk = view.findViewById(d.g.auto_video_black_mask);
        this.cAh = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAi = view.findViewById(d.g.auto_video_error_background);
        this.dry = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.afe = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.afe.setAnimationListener(this.ehP);
        this.ehv = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehv.setOnClickListener(this);
        this.cKM = view.findViewById(d.g.divider_line);
        this.ehF = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.TD.setOnClickListener(this);
        this.ehH = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehz = new com.baidu.tieba.j.k();
        this.ehu = new com.baidu.afd.videopaster.d(getContext(), this.cAd);
        this.ehu.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void qs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qr() {
                if (!m.this.ehG) {
                    m.this.TD.start();
                } else {
                    m.this.startPlay();
                }
                m.this.ehG = false;
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
        if (this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.bDw > 0) {
            if (aQf() != null) {
                aQf().a(view, this.ehA);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.ehA.cZC.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.YB(), this.ehA.WR())));
            return;
        }
        if (view == this.dqw || view == this.ehv) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.TD) {
            if (this.ehA != null) {
                this.ehA.objType = 5;
            }
            if (this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.Zf() != null) {
                z = this.ehA.cZC.Zf().is_vertical.intValue() == 1;
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
        if (aQf() != null) {
            aQf().a(view, this.ehA);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void by(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehA);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQo();
        }
    }

    private void aQn() {
        if (this.ehA != null && this.ehA.cZC != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehA.cZC);
            videoItemData.mRecomExtra = this.ehA.getExtra();
            videoItemData.mRecomAbTag = this.ehA.aQO();
            videoItemData.mRecomSource = this.ehA.getSource();
            videoItemData.mRecomWeight = this.ehA.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.ehA.WR(), "index")));
        }
    }

    private void aQo() {
        if (this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehA.cZC);
            videoSerializeVideoThreadInfo.source = this.ehA.getSource();
            videoSerializeVideoThreadInfo.extra = this.ehA.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.ehA.aQO();
            videoSerializeVideoThreadInfo.weight = this.ehA.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dry.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dry.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ap.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.ehA.cZC.getTid(), n.YB(), this.ehA.WR(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bz(View view) {
        if (this.ehA != null) {
            this.ehA.objType = 1;
        }
        if (aQf() != null) {
            aQf().a(view, this.ehA);
        }
        if (this.ehA != null && this.ehA.cZC != null) {
            if (!aQp()) {
                n.tz(this.ehA.cZC.getId());
                n.a(this.mTextTitle, this.ehA.cZC.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehA.cZC, null, n.YB(), 18003, true, false, false).addLocateParam(this.ehA.WR());
            addLocateParam.setVideo_source(this.ehA.sourceType == 0 ? "index" : "hot_juhe");
            if (this.ehA.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.ehA.cZC.getFid()));
            addLocateParam.setForumName(this.ehA.cZC.YT());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehv) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQp() {
        return this.ehA.elu && !this.ehA.elC;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.ehA = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        this.ehI.removeMessages(202);
        if (this.TD.getCurrentPosition() > this.UH) {
            i(false, 3);
            this.ehI.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.ehI.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQr() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ehI.removeMessages(203);
        int currentPosition = this.TD.getCurrentPosition();
        if (currentPosition != this.ehB) {
            this.ehB = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.ehI.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cAg != null && this.cAf != null && this.cAk != null && this.cAj != null && this.cAi != null && this.cAh != null) {
            if (z || this.cAm != i) {
                this.cAm = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAq);
                if (i == 2) {
                    this.cAg.setVisibility(8);
                    this.afe.cancel();
                    this.cAf.clearAnimation();
                    this.cAf.setVisibility(0);
                    this.cAk.setVisibility(0);
                    this.ehy.setVisibility(0);
                    this.ehF.setVisibility(8);
                    this.cAj.startLoading();
                    this.cAi.setVisibility(8);
                    this.cAh.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAr, 60000L);
                } else if (i == 3) {
                    this.cAg.setVisibility(8);
                    this.cAf.startAnimation(this.afe);
                    this.cAk.setVisibility(8);
                    this.ehy.setVisibility(8);
                    if (this.ehA != null && this.ehA.WO() != null && this.ehA.WO().bDw > 0) {
                        this.ehF.setVisibility(0);
                    }
                    this.cAj.bTM();
                    this.cAi.setVisibility(8);
                    this.cAh.setVisibility(8);
                    if (this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.Zf() != null) {
                        this.ehz.a(this.ehA.cZC.getTid(), this.ehA.cZC.Zf().video_length.intValue(), this.ehA.cZC.Zf().video_duration.intValue(), "homepage", this.TD);
                    }
                } else if (i == 4) {
                    this.cAg.setVisibility(8);
                    this.cAf.startAnimation(this.afe);
                    this.cAk.setVisibility(8);
                    this.cAj.bTN();
                    this.cAi.setVisibility(0);
                    this.cAh.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAq, 2000L);
                } else {
                    this.cAg.setVisibility(0);
                    this.afe.cancel();
                    this.cAf.clearAnimation();
                    this.cAf.setVisibility(0);
                    this.cAk.setVisibility(0);
                    this.ehy.setVisibility(0);
                    this.cAj.bTN();
                    this.cAi.setVisibility(8);
                    this.cAh.setVisibility(8);
                }
                if (this.ehA != null && this.ehA.WO() != null && this.ehA.WO().bDw > 0) {
                    this.ehy.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ehA == null || this.ehA.cZC == null || this.ehA.cZC.YO() == null) {
            this.dqw.setVisibility(8);
            return;
        }
        this.dqw.setVisibility(0);
        aQt();
        if (!aQp() && n.tA(this.ehA.cZC.getId())) {
            n.a(this.mTextTitle, this.ehA.cZC.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehv.getGodReplyContent(), this.ehA.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        this.ehA.WO().ZE();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ehA.WO().Zu());
        if (this.ehA.WO().ZB() && !StringUtils.isNull(this.ehA.WO().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehA.WO().getTid();
            spannableStringBuilder.append((CharSequence) this.ehA.WO().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
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
        this.dqx.setData(this.ehA.WO());
        this.dqx.setUserAfterClickListener(this.ehL);
        if (this.dqx.getHeaderImg() != null) {
            this.dqx.getHeaderImg().setAfterClickListener(this.ehM);
            if (this.dqx.getIsSimpleThread()) {
                this.dqx.getHeaderImg().setVisibility(8);
                this.ehw.setVisibility(8);
            } else if (this.ehA.WO() == null || this.ehA.WO().YO() == null || this.ehA.WO().YO().getPendantData() == null || StringUtils.isNull(this.ehA.WO().YO().getPendantData().Xk())) {
                this.ehw.setVisibility(8);
                this.dqx.getHeaderImg().setVisibility(0);
                if (this.ehA.WO().bDw > 0 && this.ehA.WO().bDx == 0) {
                    this.ehA.WO().YO().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dqx.getHeaderImg().setData(this.ehA.WO(), false);
                } else {
                    this.dqx.getHeaderImg().setData(this.ehA.WO());
                    this.dqx.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dqx.getHeaderImg().setVisibility(4);
                this.ehw.setVisibility(0);
                this.ehw.setData(this.ehA.WO());
            }
        }
        this.cAe.setText(ap.hy(this.ehA.cZC.Zf().video_duration.intValue() * 1000));
        this.cAl.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehA.cZC.Zf().play_count.intValue())));
        if (this.dqJ != null && this.ehA.WO() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehA.WO().getTid());
            ajVar.setFid(this.ehA.WO().getFid());
            ajVar.b(this.ehA.bzx);
            this.dqJ.setData(ajVar);
            this.dqJ.setFirstRowSingleColumn(true);
            this.dqJ.setVisibility(this.ehD ? 0 : 8);
        }
        this.ehv.setData(this.ehA.WO().aam());
        mE(ls(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehA.cZC.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        if (this.ehA == null || this.ehA.cZC == null || this.ehA.cZC.Zf() == null) {
            z = false;
        } else {
            z = this.ehA.cZC.Zf().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehH.setVisibility(0);
            if (aQu()) {
                this.ehH.setText(String.format("%s | %s", this.mContext.getResources().getString(d.j.nani_video), this.mContext.getResources().getString(d.j.video_preview)));
            } else {
                this.ehH.setText(this.mContext.getString(d.j.nani_video));
            }
        } else if (aQu()) {
            this.ehH.setVisibility(0);
            this.ehH.setText(this.mContext.getString(d.j.video_preview));
        } else {
            this.ehH.setVisibility(8);
        }
    }

    private void aQs() {
        this.ehI.removeMessages(202);
        this.ehI.removeMessages(203);
    }

    private void asa() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAq);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
    }

    private void aQt() {
        asa();
        aQs();
        if (this.cAf != null && this.cAd != null && this.TD != null) {
            if (com.baidu.tbadk.core.i.Wv().Wz() && this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.Zf() != null) {
                this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAf.startLoad(this.ehA.cZC.Zf().thumbnail_url, 10, false);
                this.cAd.setVisibility(0);
                stopPlay();
                this.bNn = this.ehA.cZC.Zf().video_url;
                if (aQu()) {
                    this.bNn = this.ehA.cZC.Zg().video_url;
                }
                if (StringUtils.isNull(this.ehA.cZC.Zf().video_url)) {
                    i(true, 4);
                }
                if (this.dbh != null && this.dbh.bTv() != null) {
                    this.dbh.bTv().g(this.ehA.cZC.Zf());
                }
                this.TD.dF(this.bNn, this.ehA.tid);
            } else {
                this.cAd.setVisibility(8);
            }
            this.ehu.reset();
            this.dbg.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehu.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehA);
                    }
                }
            });
            this.dbh.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehu.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehA);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cZC != null) {
            bg bgVar = lVar.cZC;
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
        if (lVar == null || lVar.cZC == null || bVar == null) {
            return null;
        }
        bg bgVar = lVar.cZC;
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
        VideoInfo Zf = bgVar.Zf();
        if (Zf != null) {
            i3 = Zf.video_width.intValue();
            i2 = Zf.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.YT());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qw + 1, i3, i2);
        a.l(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqw, d.f.addresslist_item_bg);
            al.c(this.cAg, d.f.btn_icon_play_video_n);
            al.j(this.cAh, d.C0277d.cp_btn_a);
            al.j(this.cAe, d.C0277d.cp_btn_a);
            al.j(this.cAl, d.C0277d.cp_btn_a);
            al.j(this.ehF, d.C0277d.cp_btn_a);
            al.l(this.cAi, d.C0277d.common_color_10014);
            al.l(this.cKM, d.C0277d.cp_bg_line_e);
            if (this.ehH != null) {
                al.j(this.ehH, d.C0277d.cp_btn_a);
                al.k(this.ehH, d.f.video_play_count_bg);
            }
            if (this.cAh != null) {
                this.cAh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ehv.onChangeSkinType();
            if (this.dqJ != null) {
                this.dqJ.onChangeSkinType();
            }
            this.dqx.onChangeSkinType();
            this.dqy.onChangeSkinType();
            this.drn.onChangeSkinType();
            this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ehw.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ehN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ehN);
            this.ehK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ehK);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqx != null) {
            this.dqx.setPageUniqueId(bdUniqueId);
        }
        if (this.cAf != null) {
            this.cAf.setPageId(bdUniqueId);
        }
        if (this.dqJ != null) {
            this.dqJ.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.ehC;
    }

    public boolean isPlaying() {
        if (this.TD == null) {
            return false;
        }
        return this.TD.isPlaying();
    }

    public void startPlay() {
        if (!this.ehC && this.ehA != null && this.ehA.cZC != null && this.ehA.cZC.Zf() != null && this.TD != null) {
            if (this.ehu.qb()) {
                this.ehu.resume();
                this.ehG = true;
                return;
            }
            this.ehG = false;
            this.TD.stopPlayback();
            if (ad.H(1, this.bNn)) {
                this.ehz.bEx();
                i(true, 2);
                if (StringUtils.isNull(this.bNn)) {
                    TiebaStatic.log(new am("c12619").bJ("obj_locate", "index").bJ("tid", this.ehA.tid));
                    this.bNn = this.ehA.cZC.Zf().video_url;
                }
                this.ehC = true;
                this.TD.setVideoPath(this.bNn, this.ehA.tid);
                if (this.dbg != null) {
                    this.dbg.start();
                }
                aQm();
            }
        }
    }

    public void stopPlay() {
        this.ehG = false;
        asa();
        aQs();
        i(true, 1);
        if (this.TD != null) {
            this.TD.stopPlayback();
            if (this.dbg != null) {
                this.dbg.stop();
            }
        }
        this.ehC = false;
        this.ehu.stop();
    }

    public View getVideoContainer() {
        return this.cAd;
    }

    public String getPlayUrl() {
        return this.bNn;
    }

    public int getCurrentPosition() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.getCurrentPosition();
    }

    public void hK(boolean z) {
        this.ehD = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void mE(int i) {
        if (this.ehA != null && this.ehA.cZC != null) {
            if (i == 1) {
                if (this.ehA.cZC.bDw > 0) {
                    this.drn.bTB.setShowPraiseNum(false);
                    this.drn.bTB.setShareVisible(false);
                    this.ehF.setText(ap.az(this.ehA.cZC.bDw));
                    this.ehF.setVisibility(0);
                } else {
                    this.drn.bTB.setShowPraiseNum(true);
                    this.drn.bTB.setShareVisible(true);
                    this.ehF.setVisibility(8);
                }
                this.drn.setData(this.ehA.cZC);
                this.dqy.setVisibility(8);
                this.dqx.dN(false);
                return;
            }
            this.drn.setVisibility(8);
            this.dqx.dN(true);
            if (this.ehA.cZC.bDw > 0) {
                this.dqy.setShowPraiseNum(false);
                this.dqy.setShareVisible(false);
                this.ehF.setText(ap.az(this.ehA.cZC.bDw));
                this.ehF.setVisibility(0);
            } else {
                this.dqy.setShowPraiseNum(true);
                this.dqy.setShareVisible(true);
                this.ehF.setVisibility(8);
            }
            if (this.dqy.setData(this.ehA.cZC)) {
                this.ehq.setVisibility(8);
            } else {
                this.ehq.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAf.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAf.setOnDrawListener(null);
        }
    }

    private boolean aQu() {
        return (this.ehA == null || this.ehA.cZC == null || this.ehA.cZC.Zg() == null || TextUtils.isEmpty(this.ehA.cZC.Zg().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.ehu.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.ehu.stop();
    }

    public void onResume() {
        if (this.ehu.qb()) {
            this.ehu.resume();
        }
    }
}
