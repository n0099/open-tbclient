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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
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
    private int SK;
    private String WM;
    private Animation afI;
    private String bXa;
    public FrameLayout cKE;
    private TextView cKF;
    private TbImageView cKG;
    private ImageView cKH;
    private TextView cKI;
    private View cKJ;
    private com.baidu.tieba.play.x cKK;
    private View cKL;
    private TextView cKM;
    private int cKN;
    private TbImageView.a cKO;
    private g.b cKP;
    private Runnable cKR;
    private Runnable cKS;
    private QuickVideoView.b cKT;
    private g.a cUp;
    private g.f cUq;
    private g.e cUs;
    private View cVw;
    private final View.OnClickListener cbv;
    private NEGFeedBackView dGE;
    private RelativeLayout dGr;
    public ThreadUserInfoLayout dGs;
    public ThreadCommentAndPraiseInfoLayout dGt;
    public ThreadSourceShareAndPraiseLayout dHg;
    protected LinearLayout dHr;
    private com.baidu.tieba.play.j dpo;
    private com.baidu.tieba.play.n dpp;
    private View eDU;
    private com.baidu.afd.videopaster.d eDY;
    public ThreadGodReplyLayout eDZ;
    private HeadPendantClickableView eEa;
    private com.baidu.tieba.play.a.a eEb;
    private LinearLayout eEc;
    private com.baidu.tieba.card.data.l eEd;
    private int eEe;
    private boolean eEf;
    private boolean eEg;
    private boolean eEh;
    private TextView eEi;
    private boolean eEj;
    private TextView eEk;
    private Handler eEl;
    private VideoLoadingProgressView.a eEm;
    private CustomMessageListener eEn;
    private final View.OnClickListener eEo;
    private final View.OnClickListener eEp;
    private CustomMessageListener eEq;
    private j.a eEr;
    private Animation.AnimationListener eEs;
    private boolean isNewPlayer;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void baa() {
        if (this.eEb != null && this.eEf) {
            try {
                this.eEb.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Dz = com.baidu.tieba.play.y.cfS().Dz(this.bXa);
            if (Dz <= 100 || this.eEb.getDuration() <= Dz) {
                Dz = 100;
            }
            this.SK = Dz;
            this.eEl.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.eEd != null && this.eEd.threadData != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.eEd.sourceType == 0 ? "index" : "hot_juhe";
            zVar.bXN = this.eEd.threadData.getTid();
            zVar.eHo = this.eEd.threadData.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.eEd.threadData.mRecomSource;
            zVar.iAD = this.eEd.threadData.mRecomAbTag;
            zVar.iAE = this.eEd.threadData.mRecomWeight;
            zVar.iAF = "";
            zVar.bHq = this.eEd.baG();
            if (this.eEd.threadData.aeT() != null) {
                zVar.iAH = this.eEd.threadData.aeT().video_md5;
            }
            com.baidu.tieba.play.l.a(this.eEd.threadData.aeT().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dGE = null;
        this.mSkinType = 3;
        this.eEe = 0;
        this.cKN = 1;
        this.eEf = false;
        this.eEg = true;
        this.eEh = false;
        this.SK = 100;
        this.eEj = false;
        this.isNewPlayer = false;
        this.eEl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.baf();
                        return;
                    case 203:
                        m.this.bag();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (m.this.eEb != null) {
                    m.this.eEb.setVolume(0.0f, 0.0f);
                }
                m.this.baa();
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.eDY.a(false, false, "NEWINDEX")) {
                    m.this.eEb.start();
                }
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.eEf = false;
                return true;
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.baa();
            }
        };
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && m.this.cKG != null) {
                    m.this.cKG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cKR = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.eEb != null && !m.this.eEb.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cKS = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.eEn = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.eEd != null && m.this.eEd.threadData != null && videoId.equals(m.this.eEd.threadData.getId())) {
                        m.this.eDY.a(m.this.a(m.this.eEd, bVar));
                    }
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.eEo = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eEd == null) {
                    if (m.this.aZU() != null) {
                        m.this.aZU().a(view, m.this.eEd);
                        return;
                    }
                    return;
                }
                if (view == m.this.dGs.getUserName()) {
                    m.this.eEd.objType = 3;
                } else if (view == m.this.dGs.getHeaderImg()) {
                    m.this.eEd.objType = 4;
                } else {
                    m.this.eEd.objType = 1;
                }
                if (m.this.aZU() != null) {
                    m.this.aZU().a(view, m.this.eEd);
                }
            }
        };
        this.eEp = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eEd != null) {
                    m.this.eEd.objType = 4;
                }
                if (m.this.aZU() != null) {
                    m.this.aZU().a(view, m.this.eEd);
                }
            }
        };
        this.eEq = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.eEh = false;
                }
            }
        };
        this.cbv = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eEd != null) {
                    if (m.this.aZU() != null) {
                        m.this.aZU().a(view, m.this.eEd);
                    }
                    if (m.this.eEd.threadData != null && view != m.this.dHg.ccP) {
                        n.vW(m.this.eEd.threadData.getId());
                        if (!m.this.bae()) {
                            n.a(m.this.mTextTitle, m.this.eEd.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            n.a(m.this.eDZ.getGodReplyContent(), m.this.eEd.acC().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.eEr = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void pV() {
                if (m.this.eEd != null && m.this.eEd.threadData != null && m.this.eEd.threadData.aeT() != null) {
                    m.this.bab();
                }
            }
        };
        this.eEs = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cKG != null) {
                    m.this.cKG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dGr = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eEa = (HeadPendantClickableView) this.dGr.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eEa.getHeadView() != null) {
            this.eEa.getHeadView().setIsRound(true);
            this.eEa.getHeadView().setDrawBorder(false);
            this.eEa.getHeadView().setDefaultResource(17170445);
            this.eEa.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eEa.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.eEa.setHasPendantStyle();
        if (this.eEa.getPendantView() != null) {
            this.eEa.getPendantView().setIsRound(true);
            this.eEa.getPendantView().setDrawBorder(false);
        }
        this.cKK = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cKK.setLoadingAnimationListener(this.eEm);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dGs = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dGE = new NEGFeedBackView(getTbPageContext());
        int g = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16);
        this.dGE.a(this.dGr, g, 0);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dGt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGt.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dGt.setLayoutParams(layoutParams);
        }
        this.dGt.setOnClickListener(this);
        this.dGt.setReplyTimeVisible(false);
        this.dGt.setShowPraiseNum(true);
        this.dGt.setNeedAddPraiseIcon(true);
        this.dGt.setNeedAddReplyIcon(true);
        this.dGt.setShareVisible(true);
        this.dGt.setShareReportFrom(3);
        this.dGt.setForumAfterClickListener(this.cbv);
        this.dGt.setFrom(1);
        this.dHg = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dHg.cdA.setOnClickListener(this);
        this.dHg.setFrom(1);
        this.dHg.setShareReportFrom(3);
        this.dHg.setForumAfterClickListener(this.cbv);
        this.eDU = view.findViewById(R.id.divider_below_reply_number_layout);
        this.cKE = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cKE.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cKE.setLayoutParams(layoutParams2);
        this.cKG = (TbImageView) view.findViewById(R.id.image_video);
        this.cKG.setDefaultErrorResource(0);
        this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        this.cKG.setGifIconSupport(false);
        this.cKG.setEvent(this.cKO);
        this.cKG.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cKG;
        TbImageView tbImageView2 = this.cKG;
        tbImageView.setConrers(15);
        this.cKG.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cKG.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cKG.setBorderSurroundContent(true);
        this.cKG.setDrawBorder(true);
        this.cKH = (ImageView) view.findViewById(R.id.image_video_play);
        this.dGr.setOnClickListener(this);
        this.dpp = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.ly("cyber_player_test");
        this.eEb = com.baidu.tieba.play.a.b.y(this.mContext.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.cKE.addView(this.eEb.getView(), 0);
        this.eEb.getView().setLayoutParams(layoutParams3);
        this.eEb.setContinuePlayEnable(true);
        this.eEb.setBusiness(this.dpp);
        this.eEb.setOnPreparedListener(this.cUq);
        this.eEb.setOnOutInfoListener(this.cUs);
        this.eEb.setOnCompletionListener(this.cUp);
        this.eEb.setOnErrorListener(this.cKP);
        this.eEb.setOnSurfaceDestroyedListener(this.cKT);
        this.dpo = new com.baidu.tieba.play.j();
        this.dpo.setPlayer(this.eEb);
        this.dpo.a(this.eEr);
        this.cKF = (TextView) view.findViewById(R.id.text_video_duration);
        this.eEc = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cKM = (TextView) view.findViewById(R.id.text_video_play_count);
        this.cKL = view.findViewById(R.id.auto_video_black_mask);
        this.cKI = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cKJ = view.findViewById(R.id.auto_video_error_background);
        this.dHr = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.afI = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.afI.setAnimationListener(this.eEs);
        this.eDZ = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eDZ.setOnClickListener(this);
        this.cVw = view.findViewById(R.id.divider_line);
        this.eEi = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.eEb.getView().setOnClickListener(this);
        this.eEk = (TextView) view.findViewById(R.id.nani_video_icon);
        this.eEb.setPageTypeForPerfStat("homepage");
        this.eDY = new com.baidu.afd.videopaster.d(getContext(), this.cKE);
        this.eDY.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void pJ() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pI() {
                if (!m.this.eEj) {
                    m.this.eEb.start();
                } else {
                    m.this.startPlay();
                }
                m.this.eEj = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pH() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pK() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.bMr > 0) {
            if (aZU() != null) {
                aZU().a(view, this.eEd);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.eEd.threadData.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.aep(), this.eEd.acF())));
            return;
        }
        if (view == this.dGr || view == this.eDZ) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.eEb.getView()) {
            if (this.eEd != null) {
                this.eEd.objType = 5;
            }
            if (this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.aeT() != null) {
                z = this.eEd.threadData.aeT().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(this.eEb.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bH(this.eEb.getView());
            } else {
                bI(getView());
            }
        }
    }

    private void bG(View view) {
        if (aZU() != null) {
            aZU().a(view, this.eEd);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bac();
        }
    }

    private void bH(View view) {
        if (aZU() != null) {
            aZU().a(view, this.eEd);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bad();
        }
    }

    private void bac() {
        if (this.eEd != null && this.eEd.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eEd.threadData);
            videoItemData.mRecomExtra = this.eEd.baG();
            videoItemData.mRecomAbTag = this.eEd.baE();
            videoItemData.mRecomSource = this.eEd.getSource();
            videoItemData.mRecomWeight = this.eEd.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.eEd.acF(), "index")));
        }
    }

    private void bad() {
        if (this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eEd.threadData);
            videoSerializeVideoThreadInfo.source = this.eEd.getSource();
            videoSerializeVideoThreadInfo.extra = this.eEd.baG();
            videoSerializeVideoThreadInfo.ab_tag = this.eEd.baE();
            videoSerializeVideoThreadInfo.weight = this.eEd.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dHr.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dHr.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.eEd.threadData.getTid(), n.aep(), this.eEd.acF(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bI(View view) {
        if (this.eEd != null) {
            this.eEd.objType = 1;
        }
        if (aZU() != null) {
            aZU().a(view, this.eEd);
        }
        if (this.eEd != null && this.eEd.threadData != null) {
            if (!bae()) {
                n.vW(this.eEd.threadData.getId());
                n.a(this.mTextTitle, this.eEd.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.eEd.threadData, null, n.aep(), 18003, true, false, false).addLocateParam(this.eEd.acF());
            addLocateParam.setVideo_source(this.eEd.sourceType == 0 ? "index" : "hot_juhe");
            if (this.eEd.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.eEd.threadData.getFid()));
            addLocateParam.setForumName(this.eEd.threadData.aeH());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eDZ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bae() {
        return this.eEd.eHW && !this.eEd.eId;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.eEd = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        this.eEl.removeMessages(202);
        if (this.eEb.getCurrentPosition() > this.SK) {
            i(false, 3);
            this.eEl.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eEl.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bag() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eEl.removeMessages(203);
        int currentPosition = this.eEb.getCurrentPosition();
        if (currentPosition != this.eEe) {
            this.eEe = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eEl.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cKH != null && this.cKG != null && this.cKL != null && this.cKK != null && this.cKJ != null && this.cKI != null) {
            if (z || this.cKN != i) {
                this.cKN = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKS);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKR);
                if (i == 2) {
                    this.cKH.setVisibility(8);
                    this.afI.cancel();
                    this.cKG.clearAnimation();
                    this.cKG.setVisibility(0);
                    this.cKL.setVisibility(0);
                    this.eEc.setVisibility(0);
                    this.eEi.setVisibility(8);
                    this.cKK.startLoading();
                    this.cKJ.setVisibility(8);
                    this.cKI.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKS, 60000L);
                } else if (i == 3) {
                    this.cKH.setVisibility(8);
                    this.cKG.startAnimation(this.afI);
                    this.cKL.setVisibility(8);
                    this.eEc.setVisibility(8);
                    if (this.eEd != null && this.eEd.acC() != null && this.eEd.acC().bMr > 0) {
                        this.eEi.setVisibility(0);
                    }
                    this.cKK.cfN();
                    this.cKJ.setVisibility(8);
                    this.cKI.setVisibility(8);
                    if (this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.aeT() != null) {
                        this.eEd.threadData.aeT().video_length.intValue();
                        this.eEd.threadData.aeT().video_duration.intValue();
                        this.eEd.threadData.getTid();
                    }
                } else if (i == 4) {
                    this.cKH.setVisibility(8);
                    this.cKG.startAnimation(this.afI);
                    this.cKL.setVisibility(8);
                    this.cKK.cfO();
                    this.cKJ.setVisibility(0);
                    this.cKI.setVisibility(0);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKR, 2000L);
                } else {
                    this.cKH.setVisibility(0);
                    this.afI.cancel();
                    this.cKG.clearAnimation();
                    this.cKG.setVisibility(0);
                    this.cKL.setVisibility(0);
                    this.eEc.setVisibility(0);
                    this.cKK.cfO();
                    this.cKJ.setVisibility(8);
                    this.cKI.setVisibility(8);
                }
                if (this.eEd != null && this.eEd.acC() != null && this.eEd.acC().bMr > 0) {
                    this.eEc.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.eEd == null || this.eEd.threadData == null || this.eEd.threadData.aeC() == null) {
            this.dGr.setVisibility(8);
            return;
        }
        this.dGr.setVisibility(0);
        bai();
        if (!bae() && n.vX(this.eEd.threadData.getId())) {
            n.a(this.mTextTitle, this.eEd.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eDZ.getGodReplyContent(), this.eEd.acC().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eEd.acC().afs();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eEd.acC().afi());
        if (this.eEd.acC().afp() && !StringUtils.isNull(this.eEd.acC().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eEd.acC().getTid();
            spannableStringBuilder.append((CharSequence) this.eEd.acC().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.dGs.setData(this.eEd.acC());
        this.dGs.setUserAfterClickListener(this.eEo);
        if (this.dGs.getHeaderImg() != null) {
            this.dGs.getHeaderImg().setAfterClickListener(this.eEp);
            if (this.dGs.getIsSimpleThread()) {
                this.dGs.getHeaderImg().setVisibility(8);
                this.eEa.setVisibility(8);
            } else if (this.eEd.acC() == null || this.eEd.acC().aeC() == null || this.eEd.acC().aeC().getPendantData() == null || StringUtils.isNull(this.eEd.acC().aeC().getPendantData().acZ())) {
                this.eEa.setVisibility(8);
                this.dGs.getHeaderImg().setVisibility(0);
                if (this.eEd.acC().bMr > 0 && this.eEd.acC().bMs == 0) {
                    this.eEd.acC().aeC().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dGs.getHeaderImg().setData(this.eEd.acC(), false);
                } else {
                    this.dGs.getHeaderImg().setData(this.eEd.acC());
                    this.dGs.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dGs.getHeaderImg().setVisibility(4);
                this.eEa.setVisibility(0);
                this.eEa.setData(this.eEd.acC());
            }
        }
        this.cKF.setText(aq.it(this.eEd.threadData.aeT().video_duration.intValue() * 1000));
        this.cKM.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eEd.threadData.aeT().play_count.intValue())));
        if (this.dGE != null && this.eEd.acC() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eEd.acC().getTid());
            ajVar.setFid(this.eEd.acC().getFid());
            ajVar.b(this.eEd.bIk);
            this.dGE.setData(ajVar);
            this.dGE.setFirstRowSingleColumn(true);
            this.dGE.setVisibility(this.eEg ? 0 : 8);
        }
        this.eDZ.setData(this.eEd.acC().aga());
        nJ(mt(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vX(this.eEd.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.eEd == null || this.eEd.threadData == null || this.eEd.threadData.aeT() == null) {
            z = false;
        } else {
            z = this.eEd.threadData.aeT().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eEk.setVisibility(0);
            if (baj()) {
                this.eEk.setText(String.format("%s | %s", this.mContext.getResources().getString(R.string.nani_video), this.mContext.getResources().getString(R.string.video_preview)));
            } else {
                this.eEk.setText(this.mContext.getString(R.string.nani_video));
            }
        } else if (baj()) {
            this.eEk.setVisibility(0);
            this.eEk.setText(this.mContext.getString(R.string.video_preview));
        } else {
            this.eEk.setVisibility(8);
        }
    }

    private void bah() {
        this.eEl.removeMessages(202);
        this.eEl.removeMessages(203);
    }

    private void ayG() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKR);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKS);
    }

    private void bai() {
        ayG();
        bah();
        if (this.cKG != null && this.cKE != null && this.eEb != null) {
            if (com.baidu.tbadk.core.i.ace().aci() && this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.aeT() != null) {
                this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
                this.cKG.startLoad(this.eEd.threadData.aeT().thumbnail_url, 10, false);
                this.cKE.setVisibility(0);
                stopPlay();
                this.bXa = this.eEd.threadData.aeT().video_url;
                if (baj()) {
                    this.bXa = this.eEd.threadData.aeU().video_url;
                }
                if (StringUtils.isNull(this.eEd.threadData.aeT().video_url)) {
                    i(true, 4);
                }
                if (this.dpp != null && this.dpp.cfw() != null) {
                    this.dpp.cfw().g(this.eEd.threadData.aeT());
                }
            } else {
                this.cKE.setVisibility(8);
            }
            this.eDY.reset();
            this.dpo.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eDY.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eEd);
                    }
                }
            });
            this.dpp.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eDY.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eEd);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.threadData != null) {
            bh bhVar = lVar.threadData;
            if (bhVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bhVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.threadData == null || bVar == null) {
            return null;
        }
        bh bhVar = lVar.threadData;
        int pO = bVar.pO();
        int pP = bVar.pP();
        int pN = bVar.pN();
        if (pN != -1) {
            i = pO != -1 ? (pN - pO) - 1 : -1;
            if (pP != -1) {
                i4 = (pP - pN) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aeT = bhVar.aeT();
        if (aeT != null) {
            i3 = aeT.video_width.intValue();
            i2 = aeT.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aeH());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pN + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dGr, R.drawable.addresslist_item_bg);
            am.c(this.cKH, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cKI, R.color.cp_cont_a);
            am.j(this.cKF, R.color.cp_cont_a);
            am.j(this.cKM, R.color.cp_cont_a);
            am.j(this.eEi, R.color.cp_cont_a);
            am.l(this.cKJ, R.color.common_color_10014);
            am.l(this.cVw, R.color.cp_bg_line_c);
            if (this.eEk != null) {
                am.j(this.eEk, R.color.cp_cont_a);
                am.k(this.eEk, R.drawable.video_play_count_bg);
            }
            if (this.cKI != null) {
                this.cKI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.eDZ.onChangeSkinType();
            if (this.dGE != null) {
                this.dGE.onChangeSkinType();
            }
            this.dGs.onChangeSkinType();
            this.dGt.onChangeSkinType();
            this.dHg.onChangeSkinType();
            this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            this.eEa.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            this.mSkinType = i;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eEq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eEq);
            this.eEn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eEn);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dGs != null) {
            this.dGs.setPageUniqueId(bdUniqueId);
        }
        if (this.cKG != null) {
            this.cKG.setPageId(bdUniqueId);
        }
        if (this.dGE != null) {
            this.dGE.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.eEf;
    }

    public boolean isPlaying() {
        if (this.eEb == null) {
            return false;
        }
        return this.eEb.isPlaying();
    }

    public void startPlay() {
        if (!this.eEf && this.eEd != null && this.eEd.threadData != null && this.eEd.threadData.aeT() != null && this.eEb != null) {
            if (this.eDY.ps()) {
                this.eDY.resume();
                this.eEj = true;
                return;
            }
            this.eEj = false;
            this.eEb.stopPlayback();
            if (com.baidu.tbadk.util.ac.K(1, this.bXa)) {
                i(true, 2);
                if (StringUtils.isNull(this.bXa)) {
                    TiebaStatic.log(new an("c12619").bT("obj_locate", "index").bT("tid", this.eEd.tid));
                    this.bXa = this.eEd.threadData.aeT().video_url;
                }
                this.eEf = true;
                this.eEb.setVideoPath(this.bXa, this.eEd.tid);
                if (this.dpo != null) {
                    this.dpo.start();
                }
                bab();
            }
        }
    }

    public void stopPlay() {
        this.eEj = false;
        ayG();
        bah();
        i(true, 1);
        if (this.eEb != null) {
            this.eEb.stopPlayback();
            if (this.dpo != null) {
                this.dpo.stop();
            }
        }
        this.eEf = false;
        this.eDY.stop();
    }

    public View getVideoContainer() {
        return this.cKE;
    }

    public String getPlayUrl() {
        return this.bXa;
    }

    public int getCurrentPosition() {
        if (this.eEb == null) {
            return 0;
        }
        return this.eEb.getCurrentPosition();
    }

    public void iB(boolean z) {
        this.eEg = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void nJ(int i) {
        if (this.eEd != null && this.eEd.threadData != null) {
            if (i == 1) {
                if (this.eEd.threadData.bMr > 0) {
                    this.dHg.cdA.setShowPraiseNum(false);
                    this.dHg.cdA.setShareVisible(false);
                    this.eEi.setText(aq.aO(this.eEd.threadData.bMr));
                    this.eEi.setVisibility(0);
                } else {
                    this.dHg.cdA.setShowPraiseNum(true);
                    this.dHg.cdA.setShareVisible(true);
                    this.eEi.setVisibility(8);
                }
                this.dHg.setData(this.eEd.threadData);
                this.dGt.setVisibility(8);
                this.dGs.eq(false);
                return;
            }
            this.dHg.setVisibility(8);
            this.dGs.eq(true);
            if (this.eEd.threadData.bMr > 0) {
                this.dGt.setShowPraiseNum(false);
                this.dGt.setShareVisible(false);
                this.eEi.setText(aq.aO(this.eEd.threadData.bMr));
                this.eEi.setVisibility(0);
            } else {
                this.dGt.setShowPraiseNum(true);
                this.dGt.setShareVisible(true);
                this.eEi.setVisibility(8);
            }
            if (this.dGt.setData(this.eEd.threadData)) {
                this.eDU.setVisibility(8);
            } else {
                this.eDU.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public int mt(int i) {
        return com.baidu.tieba.a.d.aCV().ag(this.WM, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cKG.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cKG.setOnDrawListener(null);
        }
    }

    private boolean baj() {
        return (this.eEd == null || this.eEd.threadData == null || this.eEd.threadData.aeU() == null || TextUtils.isEmpty(this.eEd.threadData.aeU().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.eDY.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.eDY.stop();
    }

    public void onResume() {
        if (this.eDY.ps()) {
            this.eDY.resume();
        }
    }
}
