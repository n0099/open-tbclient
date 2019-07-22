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
    private String bWb;
    public FrameLayout cJH;
    private TextView cJI;
    private TbImageView cJJ;
    private ImageView cJK;
    private TextView cJL;
    private View cJM;
    private com.baidu.tieba.play.x cJN;
    private View cJO;
    private TextView cJP;
    private int cJQ;
    private TbImageView.a cJR;
    private g.b cJS;
    private Runnable cJU;
    private Runnable cJV;
    private QuickVideoView.b cJW;
    private g.a cTp;
    private g.f cTq;
    private g.e cTs;
    private View cUw;
    private final View.OnClickListener caw;
    public ThreadUserInfoLayout dEA;
    public ThreadCommentAndPraiseInfoLayout dEB;
    private NEGFeedBackView dEM;
    private RelativeLayout dEz;
    public ThreadSourceShareAndPraiseLayout dFo;
    protected LinearLayout dFz;
    private com.baidu.tieba.play.g dgg;
    private com.baidu.tieba.play.j dnv;
    private com.baidu.tieba.play.n dnw;
    private CustomMessageListener eCA;
    private j.a eCB;
    private Animation.AnimationListener eCC;
    private View eCe;
    private com.baidu.afd.videopaster.d eCi;
    public ThreadGodReplyLayout eCj;
    private HeadPendantClickableView eCk;
    private LinearLayout eCl;
    private com.baidu.tieba.j.k eCm;
    private com.baidu.tieba.card.data.l eCn;
    private int eCo;
    private boolean eCp;
    private boolean eCq;
    private boolean eCr;
    private TextView eCs;
    private boolean eCt;
    private TextView eCu;
    private Handler eCv;
    private VideoLoadingProgressView.a eCw;
    private CustomMessageListener eCx;
    private final View.OnClickListener eCy;
    private final View.OnClickListener eCz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aZu() {
        if (this.dgg != null && this.eCp) {
            try {
                this.RG.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.dgg.isPlayerReuse()) {
                int CZ = com.baidu.tieba.play.y.ceM().CZ(this.bWb);
                if (CZ <= 100 || this.dgg.getDuration() <= CZ) {
                    CZ = 100;
                }
                this.SL = CZ;
            } else {
                this.SL = 100;
            }
            this.eCv.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZv() {
        if (this.eCn != null && this.eCn.threadData != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.eCn.sourceType == 0 ? "index" : "hot_juhe";
            zVar.bWO = this.eCn.threadData.getTid();
            zVar.eFy = this.eCn.threadData.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.eCn.threadData.mRecomSource;
            zVar.ixy = this.eCn.threadData.mRecomAbTag;
            zVar.ixz = this.eCn.threadData.mRecomWeight;
            zVar.ixA = "";
            zVar.bGR = this.eCn.baa();
            if (this.eCn.threadData.aeO() != null) {
                zVar.ixC = this.eCn.threadData.aeO().video_md5;
            }
            com.baidu.tieba.play.l.a(this.eCn.threadData.aeO().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dEM = null;
        this.mSkinType = 3;
        this.eCo = 0;
        this.cJQ = 1;
        this.eCp = false;
        this.eCq = true;
        this.eCr = false;
        this.SL = 100;
        this.eCt = false;
        this.eCv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.aZz();
                        return;
                    case 203:
                        m.this.aZA();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                m.this.dgg = gVar;
                if (m.this.dgg != null) {
                    m.this.dgg.setVolume(0.0f, 0.0f);
                }
                m.this.eCm.bOV();
                m.this.aZu();
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.eCi.a(false, false, "NEWINDEX")) {
                    m.this.RG.start();
                }
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.eCp = false;
                return true;
            }
        };
        this.eCw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aZu();
            }
        };
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && m.this.cJJ != null) {
                    m.this.cJJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cJU = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.RG != null && !m.this.RG.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cJV = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.eCx = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.eCn != null && m.this.eCn.threadData != null && videoId.equals(m.this.eCn.threadData.getId())) {
                        m.this.eCi.a(m.this.a(m.this.eCn, bVar));
                    }
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.eCy = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eCn == null) {
                    if (m.this.aZo() != null) {
                        m.this.aZo().a(view, m.this.eCn);
                        return;
                    }
                    return;
                }
                if (view == m.this.dEA.getUserName()) {
                    m.this.eCn.objType = 3;
                } else if (view == m.this.dEA.getHeaderImg()) {
                    m.this.eCn.objType = 4;
                } else {
                    m.this.eCn.objType = 1;
                }
                if (m.this.aZo() != null) {
                    m.this.aZo().a(view, m.this.eCn);
                }
            }
        };
        this.eCz = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eCn != null) {
                    m.this.eCn.objType = 4;
                }
                if (m.this.aZo() != null) {
                    m.this.aZo().a(view, m.this.eCn);
                }
            }
        };
        this.eCA = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.eCr = false;
                }
            }
        };
        this.caw = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eCn != null) {
                    if (m.this.aZo() != null) {
                        m.this.aZo().a(view, m.this.eCn);
                    }
                    if (m.this.eCn.threadData != null && view != m.this.dFo.cbO) {
                        n.vw(m.this.eCn.threadData.getId());
                        if (!m.this.aZy()) {
                            n.a(m.this.mTextTitle, m.this.eCn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            n.a(m.this.eCj.getGodReplyContent(), m.this.eCn.acx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.eCB = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void pU() {
                if (m.this.eCn != null && m.this.eCn.threadData != null && m.this.eCn.threadData.aeO() != null) {
                    m.this.aZv();
                }
            }
        };
        this.eCC = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cJJ != null) {
                    m.this.cJJ.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dEz = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eCk = (HeadPendantClickableView) this.dEz.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eCk.getHeadView() != null) {
            this.eCk.getHeadView().setIsRound(true);
            this.eCk.getHeadView().setDrawBorder(false);
            this.eCk.getHeadView().setDefaultResource(17170445);
            this.eCk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCk.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCk.setHasPendantStyle();
        if (this.eCk.getPendantView() != null) {
            this.eCk.getPendantView().setIsRound(true);
            this.eCk.getPendantView().setDrawBorder(false);
        }
        this.cJN = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cJN.setLoadingAnimationListener(this.eCw);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dEA = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dEM = new NEGFeedBackView(getTbPageContext());
        int g = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16);
        this.dEM.a(this.dEz, g, 0);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dEB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEB.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEB.setLayoutParams(layoutParams);
        }
        this.dEB.setOnClickListener(this);
        this.dEB.setReplyTimeVisible(false);
        this.dEB.setShowPraiseNum(true);
        this.dEB.setNeedAddPraiseIcon(true);
        this.dEB.setNeedAddReplyIcon(true);
        this.dEB.setShareVisible(true);
        this.dEB.setShareReportFrom(3);
        this.dEB.setForumAfterClickListener(this.caw);
        this.dEB.setFrom(1);
        this.dFo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dFo.ccA.setOnClickListener(this);
        this.dFo.setFrom(1);
        this.dFo.setShareReportFrom(3);
        this.dFo.setForumAfterClickListener(this.caw);
        this.eCe = view.findViewById(R.id.divider_below_reply_number_layout);
        this.cJH = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cJH.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cJH.setLayoutParams(layoutParams2);
        this.cJJ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJJ.setDefaultErrorResource(0);
        this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.cJJ.setGifIconSupport(false);
        this.cJJ.setEvent(this.cJR);
        this.cJJ.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cJJ;
        TbImageView tbImageView2 = this.cJJ;
        tbImageView.setConrers(15);
        this.cJJ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cJJ.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cJJ.setBorderSurroundContent(true);
        this.cJJ.setDrawBorder(true);
        this.cJK = (ImageView) view.findViewById(R.id.image_video_play);
        this.dEz.setOnClickListener(this);
        this.RG = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.dnw = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.RG.setPlayerReuseEnable(true);
        this.RG.setContinuePlayEnable(true);
        this.RG.setBusiness(this.dnw);
        this.RG.setOnPreparedListener(this.cTq);
        this.RG.setOnOutInfoListener(this.cTs);
        this.RG.setOnCompletionListener(this.cTp);
        this.RG.setOnErrorListener(this.cJS);
        this.RG.setOnSurfaceDestroyedListener(this.cJW);
        this.dnv = new com.baidu.tieba.play.j();
        this.dnv.setPlayer(this.RG);
        this.dnv.a(this.eCB);
        this.cJI = (TextView) view.findViewById(R.id.text_video_duration);
        this.eCl = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cJP = (TextView) view.findViewById(R.id.text_video_play_count);
        this.cJO = view.findViewById(R.id.auto_video_black_mask);
        this.cJL = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cJM = view.findViewById(R.id.auto_video_error_background);
        this.dFz = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.afI = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.afI.setAnimationListener(this.eCC);
        this.eCj = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eCj.setOnClickListener(this);
        this.cUw = view.findViewById(R.id.divider_line);
        this.eCs = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.RG.setOnClickListener(this);
        this.eCu = (TextView) view.findViewById(R.id.nani_video_icon);
        this.eCm = new com.baidu.tieba.j.k();
        this.eCi = new com.baidu.afd.videopaster.d(getContext(), this.cJH);
        this.eCi.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void pI() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pH() {
                if (!m.this.eCt) {
                    m.this.RG.start();
                } else {
                    m.this.startPlay();
                }
                m.this.eCt = false;
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
        if (this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.bLO > 0) {
            if (aZo() != null) {
                aZo().a(view, this.eCn);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.eCn.threadData.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.aek(), this.eCn.acA())));
            return;
        }
        if (view == this.dEz || view == this.eCj) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.RG) {
            if (this.eCn != null) {
                this.eCn.objType = 5;
            }
            if (this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.aeO() != null) {
                z = this.eCn.threadData.aeO().is_vertical.intValue() == 1;
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
        if (aZo() != null) {
            aZo().a(view, this.eCn);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZw();
        }
    }

    private void bH(View view) {
        if (aZo() != null) {
            aZo().a(view, this.eCn);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZx();
        }
    }

    private void aZw() {
        if (this.eCn != null && this.eCn.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eCn.threadData);
            videoItemData.mRecomExtra = this.eCn.baa();
            videoItemData.mRecomAbTag = this.eCn.aZY();
            videoItemData.mRecomSource = this.eCn.getSource();
            videoItemData.mRecomWeight = this.eCn.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.eCn.acA(), "index")));
        }
    }

    private void aZx() {
        if (this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eCn.threadData);
            videoSerializeVideoThreadInfo.source = this.eCn.getSource();
            videoSerializeVideoThreadInfo.extra = this.eCn.baa();
            videoSerializeVideoThreadInfo.ab_tag = this.eCn.aZY();
            videoSerializeVideoThreadInfo.weight = this.eCn.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dFz.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dFz.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.eCn.threadData.getTid(), n.aek(), this.eCn.acA(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bI(View view) {
        if (this.eCn != null) {
            this.eCn.objType = 1;
        }
        if (aZo() != null) {
            aZo().a(view, this.eCn);
        }
        if (this.eCn != null && this.eCn.threadData != null) {
            if (!aZy()) {
                n.vw(this.eCn.threadData.getId());
                n.a(this.mTextTitle, this.eCn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.eCn.threadData, null, n.aek(), 18003, true, false, false).addLocateParam(this.eCn.acA());
            addLocateParam.setVideo_source(this.eCn.sourceType == 0 ? "index" : "hot_juhe");
            if (this.eCn.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.eCn.threadData.getFid()));
            addLocateParam.setForumName(this.eCn.threadData.aeC());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eCj) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZy() {
        return this.eCn.eGg && !this.eCn.eGn;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.eCn = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZz() {
        this.eCv.removeMessages(202);
        if (this.RG.getCurrentPosition() > this.SL) {
            i(false, 3);
            this.eCv.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eCv.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZA() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eCv.removeMessages(203);
        int currentPosition = this.RG.getCurrentPosition();
        if (currentPosition != this.eCo) {
            this.eCo = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eCv.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cJK != null && this.cJJ != null && this.cJO != null && this.cJN != null && this.cJM != null && this.cJL != null) {
            if (z || this.cJQ != i) {
                this.cJQ = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJV);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJU);
                if (i == 2) {
                    this.cJK.setVisibility(8);
                    this.afI.cancel();
                    this.cJJ.clearAnimation();
                    this.cJJ.setVisibility(0);
                    this.cJO.setVisibility(0);
                    this.eCl.setVisibility(0);
                    this.eCs.setVisibility(8);
                    this.cJN.startLoading();
                    this.cJM.setVisibility(8);
                    this.cJL.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cJV, 60000L);
                } else if (i == 3) {
                    this.cJK.setVisibility(8);
                    this.cJJ.startAnimation(this.afI);
                    this.cJO.setVisibility(8);
                    this.eCl.setVisibility(8);
                    if (this.eCn != null && this.eCn.acx() != null && this.eCn.acx().bLO > 0) {
                        this.eCs.setVisibility(0);
                    }
                    this.cJN.ceH();
                    this.cJM.setVisibility(8);
                    this.cJL.setVisibility(8);
                    if (this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.aeO() != null) {
                        this.eCm.a(this.eCn.threadData.getTid(), this.eCn.threadData.aeO().video_length.intValue(), this.eCn.threadData.aeO().video_duration.intValue(), "homepage", this.RG);
                    }
                } else if (i == 4) {
                    this.cJK.setVisibility(8);
                    this.cJJ.startAnimation(this.afI);
                    this.cJO.setVisibility(8);
                    this.cJN.ceI();
                    this.cJM.setVisibility(0);
                    this.cJL.setVisibility(0);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cJU, 2000L);
                } else {
                    this.cJK.setVisibility(0);
                    this.afI.cancel();
                    this.cJJ.clearAnimation();
                    this.cJJ.setVisibility(0);
                    this.cJO.setVisibility(0);
                    this.eCl.setVisibility(0);
                    this.cJN.ceI();
                    this.cJM.setVisibility(8);
                    this.cJL.setVisibility(8);
                }
                if (this.eCn != null && this.eCn.acx() != null && this.eCn.acx().bLO > 0) {
                    this.eCl.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.eCn == null || this.eCn.threadData == null || this.eCn.threadData.aex() == null) {
            this.dEz.setVisibility(8);
            return;
        }
        this.dEz.setVisibility(0);
        aZC();
        if (!aZy() && n.vx(this.eCn.threadData.getId())) {
            n.a(this.mTextTitle, this.eCn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eCj.getGodReplyContent(), this.eCn.acx().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eCn.acx().afn();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eCn.acx().afd());
        if (this.eCn.acx().afk() && !StringUtils.isNull(this.eCn.acx().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eCn.acx().getTid();
            spannableStringBuilder.append((CharSequence) this.eCn.acx().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
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
        this.dEA.setData(this.eCn.acx());
        this.dEA.setUserAfterClickListener(this.eCy);
        if (this.dEA.getHeaderImg() != null) {
            this.dEA.getHeaderImg().setAfterClickListener(this.eCz);
            if (this.dEA.getIsSimpleThread()) {
                this.dEA.getHeaderImg().setVisibility(8);
                this.eCk.setVisibility(8);
            } else if (this.eCn.acx() == null || this.eCn.acx().aex() == null || this.eCn.acx().aex().getPendantData() == null || StringUtils.isNull(this.eCn.acx().aex().getPendantData().acU())) {
                this.eCk.setVisibility(8);
                this.dEA.getHeaderImg().setVisibility(0);
                if (this.eCn.acx().bLO > 0 && this.eCn.acx().bLP == 0) {
                    this.eCn.acx().aex().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dEA.getHeaderImg().setData(this.eCn.acx(), false);
                } else {
                    this.dEA.getHeaderImg().setData(this.eCn.acx());
                    this.dEA.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dEA.getHeaderImg().setVisibility(4);
                this.eCk.setVisibility(0);
                this.eCk.setData(this.eCn.acx());
            }
        }
        this.cJI.setText(aq.is(this.eCn.threadData.aeO().video_duration.intValue() * 1000));
        this.cJP.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.eCn.threadData.aeO().play_count.intValue())));
        if (this.dEM != null && this.eCn.acx() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eCn.acx().getTid());
            ajVar.setFid(this.eCn.acx().getFid());
            ajVar.b(this.eCn.bHL);
            this.dEM.setData(ajVar);
            this.dEM.setFirstRowSingleColumn(true);
            this.dEM.setVisibility(this.eCq ? 0 : 8);
        }
        this.eCj.setData(this.eCn.acx().afV());
        nE(mo(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.vx(this.eCn.threadData.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.eCn == null || this.eCn.threadData == null || this.eCn.threadData.aeO() == null) {
            z = false;
        } else {
            z = this.eCn.threadData.aeO().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eCu.setVisibility(0);
            if (aZD()) {
                this.eCu.setText(String.format("%s | %s", this.mContext.getResources().getString(R.string.nani_video), this.mContext.getResources().getString(R.string.video_preview)));
            } else {
                this.eCu.setText(this.mContext.getString(R.string.nani_video));
            }
        } else if (aZD()) {
            this.eCu.setVisibility(0);
            this.eCu.setText(this.mContext.getString(R.string.video_preview));
        } else {
            this.eCu.setVisibility(8);
        }
    }

    private void aZB() {
        this.eCv.removeMessages(202);
        this.eCv.removeMessages(203);
    }

    private void ays() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJU);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJV);
    }

    private void aZC() {
        ays();
        aZB();
        if (this.cJJ != null && this.cJH != null && this.RG != null) {
            if (com.baidu.tbadk.core.i.aca().ace() && this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.aeO() != null) {
                this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
                this.cJJ.startLoad(this.eCn.threadData.aeO().thumbnail_url, 10, false);
                this.cJH.setVisibility(0);
                stopPlay();
                this.bWb = this.eCn.threadData.aeO().video_url;
                if (aZD()) {
                    this.bWb = this.eCn.threadData.aeP().video_url;
                }
                if (StringUtils.isNull(this.eCn.threadData.aeO().video_url)) {
                    i(true, 4);
                }
                if (this.dnw != null && this.dnw.ceq() != null) {
                    this.dnw.ceq().g(this.eCn.threadData.aeO());
                }
                this.RG.dS(this.bWb, this.eCn.tid);
            } else {
                this.cJH.setVisibility(8);
            }
            this.eCi.reset();
            this.dnv.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eCi.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eCn);
                    }
                }
            });
            this.dnw.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eCi.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eCn);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.threadData != null) {
            bg bgVar = lVar.threadData;
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
        if (lVar == null || lVar.threadData == null || bVar == null) {
            return null;
        }
        bg bgVar = lVar.threadData;
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
        VideoInfo aeO = bgVar.aeO();
        if (aeO != null) {
            i3 = aeO.video_width.intValue();
            i2 = aeO.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.aeC());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pM + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dEz, R.drawable.addresslist_item_bg);
            am.c(this.cJK, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cJL, R.color.cp_btn_a);
            am.j(this.cJI, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            am.j(this.eCs, R.color.cp_btn_a);
            am.l(this.cJM, R.color.common_color_10014);
            am.l(this.cUw, R.color.cp_bg_line_e);
            if (this.eCu != null) {
                am.j(this.eCu, R.color.cp_btn_a);
                am.k(this.eCu, R.drawable.video_play_count_bg);
            }
            if (this.cJL != null) {
                this.cJL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.eCj.onChangeSkinType();
            if (this.dEM != null) {
                this.dEM.onChangeSkinType();
            }
            this.dEA.onChangeSkinType();
            this.dEB.onChangeSkinType();
            this.dFo.onChangeSkinType();
            this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.eCk.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.mSkinType = i;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eCA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eCA);
            this.eCx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eCx);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dEA != null) {
            this.dEA.setPageUniqueId(bdUniqueId);
        }
        if (this.cJJ != null) {
            this.cJJ.setPageId(bdUniqueId);
        }
        if (this.dEM != null) {
            this.dEM.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.eCp;
    }

    public boolean isPlaying() {
        if (this.RG == null) {
            return false;
        }
        return this.RG.isPlaying();
    }

    public void startPlay() {
        if (!this.eCp && this.eCn != null && this.eCn.threadData != null && this.eCn.threadData.aeO() != null && this.RG != null) {
            if (this.eCi.pr()) {
                this.eCi.resume();
                this.eCt = true;
                return;
            }
            this.eCt = false;
            this.RG.ceg();
            if (ad.K(1, this.bWb)) {
                this.eCm.bOU();
                i(true, 2);
                if (StringUtils.isNull(this.bWb)) {
                    TiebaStatic.log(new an("c12619").bT("obj_locate", "index").bT("tid", this.eCn.tid));
                    this.bWb = this.eCn.threadData.aeO().video_url;
                }
                this.eCp = true;
                this.RG.setVideoPath(this.bWb, this.eCn.tid);
                if (this.dnv != null) {
                    this.dnv.start();
                }
                aZv();
            }
        }
    }

    public void stopPlay() {
        this.eCt = false;
        ays();
        aZB();
        i(true, 1);
        if (this.RG != null) {
            this.RG.ceg();
            if (this.dnv != null) {
                this.dnv.stop();
            }
        }
        this.eCp = false;
        this.eCi.stop();
    }

    public View getVideoContainer() {
        return this.cJH;
    }

    public String getPlayUrl() {
        return this.bWb;
    }

    public int getCurrentPosition() {
        if (this.RG == null) {
            return 0;
        }
        return this.RG.getCurrentPosition();
    }

    public void iy(boolean z) {
        this.eCq = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void nE(int i) {
        if (this.eCn != null && this.eCn.threadData != null) {
            if (i == 1) {
                if (this.eCn.threadData.bLO > 0) {
                    this.dFo.ccA.setShowPraiseNum(false);
                    this.dFo.ccA.setShareVisible(false);
                    this.eCs.setText(aq.aO(this.eCn.threadData.bLO));
                    this.eCs.setVisibility(0);
                } else {
                    this.dFo.ccA.setShowPraiseNum(true);
                    this.dFo.ccA.setShareVisible(true);
                    this.eCs.setVisibility(8);
                }
                this.dFo.setData(this.eCn.threadData);
                this.dEB.setVisibility(8);
                this.dEA.en(false);
                return;
            }
            this.dFo.setVisibility(8);
            this.dEA.en(true);
            if (this.eCn.threadData.bLO > 0) {
                this.dEB.setShowPraiseNum(false);
                this.dEB.setShareVisible(false);
                this.eCs.setText(aq.aO(this.eCn.threadData.bLO));
                this.eCs.setVisibility(0);
            } else {
                this.dEB.setShowPraiseNum(true);
                this.dEB.setShareVisible(true);
                this.eCs.setVisibility(8);
            }
            if (this.dEB.setData(this.eCn.threadData)) {
                this.eCe.setVisibility(8);
            } else {
                this.eCe.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mo(int i) {
        return com.baidu.tieba.a.d.aCF().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cJJ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cJJ.setOnDrawListener(null);
        }
    }

    private boolean aZD() {
        return (this.eCn == null || this.eCn.threadData == null || this.eCn.threadData.aeP() == null || TextUtils.isEmpty(this.eCn.threadData.aeP().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.eCi.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.eCi.stop();
    }

    public void onResume() {
        if (this.eCi.pr()) {
            this.eCi.resume();
        }
    }
}
