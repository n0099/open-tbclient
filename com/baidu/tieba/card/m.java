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
import com.baidu.tbadk.util.ad;
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
    private QuickVideoView RG;
    private int SL;
    private String WN;
    private Animation afI;
    private String bWh;
    public FrameLayout cJO;
    private TextView cJP;
    private TbImageView cJQ;
    private ImageView cJR;
    private TextView cJS;
    private View cJT;
    private com.baidu.tieba.play.x cJU;
    private View cJV;
    private TextView cJW;
    private int cJX;
    private TbImageView.a cJY;
    private g.b cJZ;
    private Runnable cKb;
    private Runnable cKc;
    private QuickVideoView.b cKd;
    private g.a cTw;
    private g.f cTx;
    private g.e cTz;
    private View cUD;
    private final View.OnClickListener caC;
    private RelativeLayout dEG;
    public ThreadUserInfoLayout dEH;
    public ThreadCommentAndPraiseInfoLayout dEI;
    private NEGFeedBackView dET;
    protected LinearLayout dFG;
    public ThreadSourceShareAndPraiseLayout dFv;
    private com.baidu.tieba.play.g dgn;
    private com.baidu.tieba.play.j dnC;
    private com.baidu.tieba.play.n dnD;
    private boolean eCA;
    private TextView eCB;
    private Handler eCC;
    private VideoLoadingProgressView.a eCD;
    private CustomMessageListener eCE;
    private final View.OnClickListener eCF;
    private final View.OnClickListener eCG;
    private CustomMessageListener eCH;
    private j.a eCI;
    private Animation.AnimationListener eCJ;
    private View eCl;
    private com.baidu.afd.videopaster.d eCp;
    public ThreadGodReplyLayout eCq;
    private HeadPendantClickableView eCr;
    private LinearLayout eCs;
    private com.baidu.tieba.j.k eCt;
    private com.baidu.tieba.card.data.l eCu;
    private int eCv;
    private boolean eCw;
    private boolean eCx;
    private boolean eCy;
    private TextView eCz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        if (this.dgn != null && this.eCw) {
            try {
                this.RG.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.dgn.isPlayerReuse()) {
                int Da = com.baidu.tieba.play.y.cfe().Da(this.bWh);
                if (Da <= 100 || this.dgn.getDuration() <= Da) {
                    Da = 100;
                }
                this.SL = Da;
            } else {
                this.SL = 100;
            }
            this.eCC.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZx() {
        if (this.eCu != null && this.eCu.threadData != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.eCu.sourceType == 0 ? "index" : "hot_juhe";
            zVar.bWU = this.eCu.threadData.getTid();
            zVar.eFF = this.eCu.threadData.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.eCu.threadData.mRecomSource;
            zVar.iyB = this.eCu.threadData.mRecomAbTag;
            zVar.iyC = this.eCu.threadData.mRecomWeight;
            zVar.iyD = "";
            zVar.bGS = this.eCu.bac();
            if (this.eCu.threadData.aeP() != null) {
                zVar.iyF = this.eCu.threadData.aeP().video_md5;
            }
            com.baidu.tieba.play.l.a(this.eCu.threadData.aeP().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dET = null;
        this.mSkinType = 3;
        this.eCv = 0;
        this.cJX = 1;
        this.eCw = false;
        this.eCx = true;
        this.eCy = false;
        this.SL = 100;
        this.eCA = false;
        this.eCC = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.aZB();
                        return;
                    case 203:
                        m.this.aZC();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                m.this.dgn = gVar;
                if (m.this.dgn != null) {
                    m.this.dgn.setVolume(0.0f, 0.0f);
                }
                m.this.eCt.bPj();
                m.this.aZw();
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.eCp.a(false, false, "NEWINDEX")) {
                    m.this.RG.start();
                }
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.eCw = false;
                return true;
            }
        };
        this.eCD = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aZw();
            }
        };
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && m.this.cJQ != null) {
                    m.this.cJQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cKb = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.RG != null && !m.this.RG.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cKc = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.eCE = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.eCu != null && m.this.eCu.threadData != null && videoId.equals(m.this.eCu.threadData.getId())) {
                        m.this.eCp.a(m.this.a(m.this.eCu, bVar));
                    }
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.eCF = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eCu == null) {
                    if (m.this.aZq() != null) {
                        m.this.aZq().a(view, m.this.eCu);
                        return;
                    }
                    return;
                }
                if (view == m.this.dEH.getUserName()) {
                    m.this.eCu.objType = 3;
                } else if (view == m.this.dEH.getHeaderImg()) {
                    m.this.eCu.objType = 4;
                } else {
                    m.this.eCu.objType = 1;
                }
                if (m.this.aZq() != null) {
                    m.this.aZq().a(view, m.this.eCu);
                }
            }
        };
        this.eCG = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eCu != null) {
                    m.this.eCu.objType = 4;
                }
                if (m.this.aZq() != null) {
                    m.this.aZq().a(view, m.this.eCu);
                }
            }
        };
        this.eCH = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.eCy = false;
                }
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eCu != null) {
                    if (m.this.aZq() != null) {
                        m.this.aZq().a(view, m.this.eCu);
                    }
                    if (m.this.eCu.threadData != null && view != m.this.dFv.cbV) {
                        n.vx(m.this.eCu.threadData.getId());
                        if (!m.this.aZA()) {
                            n.a(m.this.mTextTitle, m.this.eCu.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            n.a(m.this.eCq.getGodReplyContent(), m.this.eCu.acy().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.eCI = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void pU() {
                if (m.this.eCu != null && m.this.eCu.threadData != null && m.this.eCu.threadData.aeP() != null) {
                    m.this.aZx();
                }
            }
        };
        this.eCJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cJQ != null) {
                    m.this.cJQ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dEG = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eCr = (HeadPendantClickableView) this.dEG.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eCr.getHeadView() != null) {
            this.eCr.getHeadView().setIsRound(true);
            this.eCr.getHeadView().setDrawBorder(false);
            this.eCr.getHeadView().setDefaultResource(17170445);
            this.eCr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCr.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCr.setHasPendantStyle();
        if (this.eCr.getPendantView() != null) {
            this.eCr.getPendantView().setIsRound(true);
            this.eCr.getPendantView().setDrawBorder(false);
        }
        this.cJU = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cJU.setLoadingAnimationListener(this.eCD);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dEH = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dET = new NEGFeedBackView(getTbPageContext());
        int g = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16);
        this.dET.a(this.dEG, g, 0);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dEI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEI.setLayoutParams(layoutParams);
        }
        this.dEI.setOnClickListener(this);
        this.dEI.setReplyTimeVisible(false);
        this.dEI.setShowPraiseNum(true);
        this.dEI.setNeedAddPraiseIcon(true);
        this.dEI.setNeedAddReplyIcon(true);
        this.dEI.setShareVisible(true);
        this.dEI.setShareReportFrom(3);
        this.dEI.setForumAfterClickListener(this.caC);
        this.dEI.setFrom(1);
        this.dFv = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dFv.ccH.setOnClickListener(this);
        this.dFv.setFrom(1);
        this.dFv.setShareReportFrom(3);
        this.dFv.setForumAfterClickListener(this.caC);
        this.eCl = view.findViewById(R.id.divider_below_reply_number_layout);
        this.cJO = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cJO.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cJO.setLayoutParams(layoutParams2);
        this.cJQ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJQ.setDefaultErrorResource(0);
        this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.cJQ.setGifIconSupport(false);
        this.cJQ.setEvent(this.cJY);
        this.cJQ.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cJQ;
        TbImageView tbImageView2 = this.cJQ;
        tbImageView.setConrers(15);
        this.cJQ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cJQ.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cJQ.setBorderSurroundContent(true);
        this.cJQ.setDrawBorder(true);
        this.cJR = (ImageView) view.findViewById(R.id.image_video_play);
        this.dEG.setOnClickListener(this);
        this.RG = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.dnD = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.RG.setPlayerReuseEnable(true);
        this.RG.setContinuePlayEnable(true);
        this.RG.setBusiness(this.dnD);
        this.RG.setOnPreparedListener(this.cTx);
        this.RG.setOnOutInfoListener(this.cTz);
        this.RG.setOnCompletionListener(this.cTw);
        this.RG.setOnErrorListener(this.cJZ);
        this.RG.setOnSurfaceDestroyedListener(this.cKd);
        this.dnC = new com.baidu.tieba.play.j();
        this.dnC.setPlayer(this.RG);
        this.dnC.a(this.eCI);
        this.cJP = (TextView) view.findViewById(R.id.text_video_duration);
        this.eCs = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cJW = (TextView) view.findViewById(R.id.text_video_play_count);
        this.cJV = view.findViewById(R.id.auto_video_black_mask);
        this.cJS = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cJT = view.findViewById(R.id.auto_video_error_background);
        this.dFG = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.afI = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.afI.setAnimationListener(this.eCJ);
        this.eCq = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eCq.setOnClickListener(this);
        this.cUD = view.findViewById(R.id.divider_line);
        this.eCz = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.RG.setOnClickListener(this);
        this.eCB = (TextView) view.findViewById(R.id.nani_video_icon);
        this.eCt = new com.baidu.tieba.j.k();
        this.eCp = new com.baidu.afd.videopaster.d(getContext(), this.cJO);
        this.eCp.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void pI() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pH() {
                if (!m.this.eCA) {
                    m.this.RG.start();
                } else {
                    m.this.startPlay();
                }
                m.this.eCA = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pG() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pJ() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.bLT > 0) {
            if (aZq() != null) {
                aZq().a(view, this.eCu);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.eCu.threadData.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.ael(), this.eCu.acB())));
            return;
        }
        if (view == this.dEG || view == this.eCq) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.RG) {
            if (this.eCu != null) {
                this.eCu.objType = 5;
            }
            if (this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.aeP() != null) {
                z = this.eCu.threadData.aeP().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(this.RG);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bH(this.RG);
            } else {
                bI(getView());
            }
        }
    }

    private void bG(View view) {
        if (aZq() != null) {
            aZq().a(view, this.eCu);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZy();
        }
    }

    private void bH(View view) {
        if (aZq() != null) {
            aZq().a(view, this.eCu);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZz();
        }
    }

    private void aZy() {
        if (this.eCu != null && this.eCu.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eCu.threadData);
            videoItemData.mRecomExtra = this.eCu.bac();
            videoItemData.mRecomAbTag = this.eCu.baa();
            videoItemData.mRecomSource = this.eCu.getSource();
            videoItemData.mRecomWeight = this.eCu.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.eCu.acB(), "index")));
        }
    }

    private void aZz() {
        if (this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eCu.threadData);
            videoSerializeVideoThreadInfo.source = this.eCu.getSource();
            videoSerializeVideoThreadInfo.extra = this.eCu.bac();
            videoSerializeVideoThreadInfo.ab_tag = this.eCu.baa();
            videoSerializeVideoThreadInfo.weight = this.eCu.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dFG.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dFG.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.eCu.threadData.getTid(), n.ael(), this.eCu.acB(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bI(View view) {
        if (this.eCu != null) {
            this.eCu.objType = 1;
        }
        if (aZq() != null) {
            aZq().a(view, this.eCu);
        }
        if (this.eCu != null && this.eCu.threadData != null) {
            if (!aZA()) {
                n.vx(this.eCu.threadData.getId());
                n.a(this.mTextTitle, this.eCu.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.eCu.threadData, null, n.ael(), 18003, true, false, false).addLocateParam(this.eCu.acB());
            addLocateParam.setVideo_source(this.eCu.sourceType == 0 ? "index" : "hot_juhe");
            if (this.eCu.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.eCu.threadData.getFid()));
            addLocateParam.setForumName(this.eCu.threadData.aeD());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eCq) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZA() {
        return this.eCu.eGn && !this.eCu.eGu;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.eCu = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZB() {
        this.eCC.removeMessages(202);
        if (this.RG.getCurrentPosition() > this.SL) {
            i(false, 3);
            this.eCC.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eCC.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZC() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eCC.removeMessages(203);
        int currentPosition = this.RG.getCurrentPosition();
        if (currentPosition != this.eCv) {
            this.eCv = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eCC.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cJR != null && this.cJQ != null && this.cJV != null && this.cJU != null && this.cJT != null && this.cJS != null) {
            if (z || this.cJX != i) {
                this.cJX = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKc);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKb);
                if (i == 2) {
                    this.cJR.setVisibility(8);
                    this.afI.cancel();
                    this.cJQ.clearAnimation();
                    this.cJQ.setVisibility(0);
                    this.cJV.setVisibility(0);
                    this.eCs.setVisibility(0);
                    this.eCz.setVisibility(8);
                    this.cJU.startLoading();
                    this.cJT.setVisibility(8);
                    this.cJS.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKc, 60000L);
                } else if (i == 3) {
                    this.cJR.setVisibility(8);
                    this.cJQ.startAnimation(this.afI);
                    this.cJV.setVisibility(8);
                    this.eCs.setVisibility(8);
                    if (this.eCu != null && this.eCu.acy() != null && this.eCu.acy().bLT > 0) {
                        this.eCz.setVisibility(0);
                    }
                    this.cJU.ceZ();
                    this.cJT.setVisibility(8);
                    this.cJS.setVisibility(8);
                    if (this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.aeP() != null) {
                        this.eCt.a(this.eCu.threadData.getTid(), this.eCu.threadData.aeP().video_length.intValue(), this.eCu.threadData.aeP().video_duration.intValue(), "homepage", this.RG);
                    }
                } else if (i == 4) {
                    this.cJR.setVisibility(8);
                    this.cJQ.startAnimation(this.afI);
                    this.cJV.setVisibility(8);
                    this.cJU.cfa();
                    this.cJT.setVisibility(0);
                    this.cJS.setVisibility(0);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKb, 2000L);
                } else {
                    this.cJR.setVisibility(0);
                    this.afI.cancel();
                    this.cJQ.clearAnimation();
                    this.cJQ.setVisibility(0);
                    this.cJV.setVisibility(0);
                    this.eCs.setVisibility(0);
                    this.cJU.cfa();
                    this.cJT.setVisibility(8);
                    this.cJS.setVisibility(8);
                }
                if (this.eCu != null && this.eCu.acy() != null && this.eCu.acy().bLT > 0) {
                    this.eCs.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.eCu == null || this.eCu.threadData == null || this.eCu.threadData.aey() == null) {
            this.dEG.setVisibility(8);
            return;
        }
        this.dEG.setVisibility(0);
        aZE();
        if (!aZA() && n.vy(this.eCu.threadData.getId())) {
            n.a(this.mTextTitle, this.eCu.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eCq.getGodReplyContent(), this.eCu.acy().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eCu.acy().afo();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eCu.acy().afe());
        if (this.eCu.acy().afl() && !StringUtils.isNull(this.eCu.acy().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eCu.acy().getTid();
            spannableStringBuilder.append((CharSequence) this.eCu.acy().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
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
        this.dEH.setData(this.eCu.acy());
        this.dEH.setUserAfterClickListener(this.eCF);
        if (this.dEH.getHeaderImg() != null) {
            this.dEH.getHeaderImg().setAfterClickListener(this.eCG);
            if (this.dEH.getIsSimpleThread()) {
                this.dEH.getHeaderImg().setVisibility(8);
                this.eCr.setVisibility(8);
            } else if (this.eCu.acy() == null || this.eCu.acy().aey() == null || this.eCu.acy().aey().getPendantData() == null || StringUtils.isNull(this.eCu.acy().aey().getPendantData().acV())) {
                this.eCr.setVisibility(8);
                this.dEH.getHeaderImg().setVisibility(0);
                if (this.eCu.acy().bLT > 0 && this.eCu.acy().bLU == 0) {
                    this.eCu.acy().aey().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dEH.getHeaderImg().setData(this.eCu.acy(), false);
                } else {
                    this.dEH.getHeaderImg().setData(this.eCu.acy());
                    this.dEH.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dEH.getHeaderImg().setVisibility(4);
                this.eCr.setVisibility(0);
                this.eCr.setData(this.eCu.acy());
            }
        }
        this.cJP.setText(aq.is(this.eCu.threadData.aeP().video_duration.intValue() * 1000));
        this.cJW.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eCu.threadData.aeP().play_count.intValue())));
        if (this.dET != null && this.eCu.acy() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eCu.acy().getTid());
            ajVar.setFid(this.eCu.acy().getFid());
            ajVar.b(this.eCu.bHM);
            this.dET.setData(ajVar);
            this.dET.setFirstRowSingleColumn(true);
            this.dET.setVisibility(this.eCx ? 0 : 8);
        }
        this.eCq.setData(this.eCu.acy().afW());
        nF(mp(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vy(this.eCu.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.eCu == null || this.eCu.threadData == null || this.eCu.threadData.aeP() == null) {
            z = false;
        } else {
            z = this.eCu.threadData.aeP().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eCB.setVisibility(0);
            if (aZF()) {
                this.eCB.setText(String.format("%s | %s", this.mContext.getResources().getString(R.string.nani_video), this.mContext.getResources().getString(R.string.video_preview)));
            } else {
                this.eCB.setText(this.mContext.getString(R.string.nani_video));
            }
        } else if (aZF()) {
            this.eCB.setVisibility(0);
            this.eCB.setText(this.mContext.getString(R.string.video_preview));
        } else {
            this.eCB.setVisibility(8);
        }
    }

    private void aZD() {
        this.eCC.removeMessages(202);
        this.eCC.removeMessages(203);
    }

    private void ayu() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKb);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKc);
    }

    private void aZE() {
        ayu();
        aZD();
        if (this.cJQ != null && this.cJO != null && this.RG != null) {
            if (com.baidu.tbadk.core.i.aca().ace() && this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.aeP() != null) {
                this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
                this.cJQ.startLoad(this.eCu.threadData.aeP().thumbnail_url, 10, false);
                this.cJO.setVisibility(0);
                stopPlay();
                this.bWh = this.eCu.threadData.aeP().video_url;
                if (aZF()) {
                    this.bWh = this.eCu.threadData.aeQ().video_url;
                }
                if (StringUtils.isNull(this.eCu.threadData.aeP().video_url)) {
                    i(true, 4);
                }
                if (this.dnD != null && this.dnD.ceI() != null) {
                    this.dnD.ceI().g(this.eCu.threadData.aeP());
                }
                this.RG.dS(this.bWh, this.eCu.tid);
            } else {
                this.cJO.setVisibility(8);
            }
            this.eCp.reset();
            this.dnC.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eCp.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eCu);
                    }
                }
            });
            this.dnD.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eCp.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eCu);
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
        int pN = bVar.pN();
        int pO = bVar.pO();
        int pM = bVar.pM();
        if (pM != -1) {
            i = pN != -1 ? (pM - pN) - 1 : -1;
            if (pO != -1) {
                i4 = (pO - pM) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aeP = bhVar.aeP();
        if (aeP != null) {
            i3 = aeP.video_width.intValue();
            i2 = aeP.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aeD());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pM + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dEG, R.drawable.addresslist_item_bg);
            am.c(this.cJR, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cJS, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            am.j(this.cJW, R.color.cp_btn_a);
            am.j(this.eCz, R.color.cp_btn_a);
            am.l(this.cJT, R.color.common_color_10014);
            am.l(this.cUD, R.color.cp_bg_line_e);
            if (this.eCB != null) {
                am.j(this.eCB, R.color.cp_btn_a);
                am.k(this.eCB, R.drawable.video_play_count_bg);
            }
            if (this.cJS != null) {
                this.cJS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.eCq.onChangeSkinType();
            if (this.dET != null) {
                this.dET.onChangeSkinType();
            }
            this.dEH.onChangeSkinType();
            this.dEI.onChangeSkinType();
            this.dFv.onChangeSkinType();
            this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.eCr.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.mSkinType = i;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eCH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eCH);
            this.eCE.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eCE);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dEH != null) {
            this.dEH.setPageUniqueId(bdUniqueId);
        }
        if (this.cJQ != null) {
            this.cJQ.setPageId(bdUniqueId);
        }
        if (this.dET != null) {
            this.dET.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.eCw;
    }

    public boolean isPlaying() {
        if (this.RG == null) {
            return false;
        }
        return this.RG.isPlaying();
    }

    public void startPlay() {
        if (!this.eCw && this.eCu != null && this.eCu.threadData != null && this.eCu.threadData.aeP() != null && this.RG != null) {
            if (this.eCp.pr()) {
                this.eCp.resume();
                this.eCA = true;
                return;
            }
            this.eCA = false;
            this.RG.cey();
            if (ad.K(1, this.bWh)) {
                this.eCt.bPi();
                i(true, 2);
                if (StringUtils.isNull(this.bWh)) {
                    TiebaStatic.log(new an("c12619").bT("obj_locate", "index").bT("tid", this.eCu.tid));
                    this.bWh = this.eCu.threadData.aeP().video_url;
                }
                this.eCw = true;
                this.RG.setVideoPath(this.bWh, this.eCu.tid);
                if (this.dnC != null) {
                    this.dnC.start();
                }
                aZx();
            }
        }
    }

    public void stopPlay() {
        this.eCA = false;
        ayu();
        aZD();
        i(true, 1);
        if (this.RG != null) {
            this.RG.cey();
            if (this.dnC != null) {
                this.dnC.stop();
            }
        }
        this.eCw = false;
        this.eCp.stop();
    }

    public View getVideoContainer() {
        return this.cJO;
    }

    public String getPlayUrl() {
        return this.bWh;
    }

    public int getCurrentPosition() {
        if (this.RG == null) {
            return 0;
        }
        return this.RG.getCurrentPosition();
    }

    public void iy(boolean z) {
        this.eCx = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void nF(int i) {
        if (this.eCu != null && this.eCu.threadData != null) {
            if (i == 1) {
                if (this.eCu.threadData.bLT > 0) {
                    this.dFv.ccH.setShowPraiseNum(false);
                    this.dFv.ccH.setShareVisible(false);
                    this.eCz.setText(aq.aO(this.eCu.threadData.bLT));
                    this.eCz.setVisibility(0);
                } else {
                    this.dFv.ccH.setShowPraiseNum(true);
                    this.dFv.ccH.setShareVisible(true);
                    this.eCz.setVisibility(8);
                }
                this.dFv.setData(this.eCu.threadData);
                this.dEI.setVisibility(8);
                this.dEH.en(false);
                return;
            }
            this.dFv.setVisibility(8);
            this.dEH.en(true);
            if (this.eCu.threadData.bLT > 0) {
                this.dEI.setShowPraiseNum(false);
                this.dEI.setShareVisible(false);
                this.eCz.setText(aq.aO(this.eCu.threadData.bLT));
                this.eCz.setVisibility(0);
            } else {
                this.dEI.setShowPraiseNum(true);
                this.dEI.setShareVisible(true);
                this.eCz.setVisibility(8);
            }
            if (this.dEI.setData(this.eCu.threadData)) {
                this.eCl.setVisibility(8);
            } else {
                this.eCl.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mp(int i) {
        return com.baidu.tieba.a.d.aCH().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cJQ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cJQ.setOnDrawListener(null);
        }
    }

    private boolean aZF() {
        return (this.eCu == null || this.eCu.threadData == null || this.eCu.threadData.aeQ() == null || TextUtils.isEmpty(this.eCu.threadData.aeQ().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.eCp.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.eCp.stop();
    }

    public void onResume() {
        if (this.eCp.pr()) {
            this.eCp.resume();
        }
    }
}
