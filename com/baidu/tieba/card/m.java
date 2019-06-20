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
    private QuickVideoView Ro;
    private int Ss;
    private String Ws;
    private Animation afl;
    private String bVa;
    private final View.OnClickListener bZu;
    private Runnable cIA;
    private Runnable cIB;
    private QuickVideoView.b cIC;
    public FrameLayout cIn;
    private TextView cIo;
    private TbImageView cIp;
    private ImageView cIq;
    private TextView cIr;
    private View cIs;
    private com.baidu.tieba.play.x cIt;
    private View cIu;
    private TextView cIv;
    private int cIw;
    private TbImageView.a cIx;
    private g.b cIy;
    private g.a cRT;
    private g.f cRU;
    private g.e cRW;
    private View cTa;
    public ThreadSourceShareAndPraiseLayout dBT;
    private RelativeLayout dBd;
    public ThreadUserInfoLayout dBe;
    public ThreadCommentAndPraiseInfoLayout dBf;
    private NEGFeedBackView dBq;
    protected LinearLayout dCe;
    private com.baidu.tieba.play.g deD;
    private com.baidu.tieba.play.j dlN;
    private com.baidu.tieba.play.n dlO;
    private final View.OnClickListener exA;
    private final View.OnClickListener exB;
    private CustomMessageListener exC;
    private j.a exD;
    private Animation.AnimationListener exE;
    private View exf;
    private com.baidu.afd.videopaster.d exj;
    public ThreadGodReplyLayout exk;
    private HeadPendantClickableView exl;
    private LinearLayout exm;
    private com.baidu.tieba.j.k exn;
    private com.baidu.tieba.card.data.l exo;
    private int exp;
    private boolean exq;
    private boolean exr;
    private boolean exs;
    private TextView exu;
    private boolean exv;
    private TextView exw;
    private Handler exx;
    private VideoLoadingProgressView.a exy;
    private CustomMessageListener exz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.deD != null && this.exq) {
            try {
                this.Ro.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.deD.isPlayerReuse()) {
                int Cm = com.baidu.tieba.play.y.cbW().Cm(this.bVa);
                if (Cm <= 100 || this.deD.getDuration() <= Cm) {
                    Cm = 100;
                }
                this.Ss = Cm;
            } else {
                this.Ss = 100;
            }
            this.exx.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.exo != null && this.exo.threadData != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.exo.sourceType == 0 ? "index" : "hot_juhe";
            zVar.bVM = this.exo.threadData.getTid();
            zVar.eAC = this.exo.threadData.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.exo.threadData.mRecomSource;
            zVar.iri = this.exo.threadData.mRecomAbTag;
            zVar.irj = this.exo.threadData.mRecomWeight;
            zVar.irk = "";
            zVar.bFQ = this.exo.getExtra();
            if (this.exo.threadData.adM() != null) {
                zVar.irm = this.exo.threadData.adM().video_md5;
            }
            com.baidu.tieba.play.l.a(this.exo.threadData.adM().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dBq = null;
        this.mSkinType = 3;
        this.exp = 0;
        this.cIw = 1;
        this.exq = false;
        this.exr = true;
        this.exs = false;
        this.Ss = 100;
        this.exv = false;
        this.exx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.aXC();
                        return;
                    case 203:
                        m.this.aXD();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cRU = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                m.this.deD = gVar;
                if (m.this.deD != null) {
                    m.this.deD.setVolume(0.0f, 0.0f);
                }
                m.this.exn.bMn();
                m.this.aXx();
            }
        };
        this.cRW = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cRT = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.exj.a(false, false, "NEWINDEX")) {
                    m.this.Ro.start();
                }
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.exq = false;
                return true;
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aXx();
            }
        };
        this.cIx = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && m.this.cIp != null) {
                    m.this.cIp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cIA = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.Ro != null && !m.this.Ro.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cIB = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.exz = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.exo != null && m.this.exo.threadData != null && videoId.equals(m.this.exo.threadData.getId())) {
                        m.this.exj.a(m.this.a(m.this.exo, bVar));
                    }
                }
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.exA = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.exo == null) {
                    if (m.this.aXr() != null) {
                        m.this.aXr().a(view, m.this.exo);
                        return;
                    }
                    return;
                }
                if (view == m.this.dBe.getUserName()) {
                    m.this.exo.objType = 3;
                } else if (view == m.this.dBe.getHeaderImg()) {
                    m.this.exo.objType = 4;
                } else {
                    m.this.exo.objType = 1;
                }
                if (m.this.aXr() != null) {
                    m.this.aXr().a(view, m.this.exo);
                }
            }
        };
        this.exB = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.exo != null) {
                    m.this.exo.objType = 4;
                }
                if (m.this.aXr() != null) {
                    m.this.aXr().a(view, m.this.exo);
                }
            }
        };
        this.exC = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.exs = false;
                }
            }
        };
        this.bZu = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.exo != null) {
                    if (m.this.aXr() != null) {
                        m.this.aXr().a(view, m.this.exo);
                    }
                    if (m.this.exo.threadData != null && view != m.this.dBT.caM) {
                        n.uR(m.this.exo.threadData.getId());
                        if (!m.this.aXB()) {
                            n.a(m.this.mTextTitle, m.this.exo.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            n.a(m.this.exk.getGodReplyContent(), m.this.exo.abv().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.exD = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void pz() {
                if (m.this.exo != null && m.this.exo.threadData != null && m.this.exo.threadData.adM() != null) {
                    m.this.aXy();
                }
            }
        };
        this.exE = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cIp != null) {
                    m.this.cIp.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dBd = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.exl = (HeadPendantClickableView) this.dBd.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.exl.getHeadView() != null) {
            this.exl.getHeadView().setIsRound(true);
            this.exl.getHeadView().setDrawBorder(false);
            this.exl.getHeadView().setDefaultResource(17170445);
            this.exl.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exl.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.exl.setHasPendantStyle();
        if (this.exl.getPendantView() != null) {
            this.exl.getPendantView().setIsRound(true);
            this.exl.getPendantView().setDrawBorder(false);
        }
        this.cIt = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cIt.setLoadingAnimationListener(this.exy);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dBe = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dBq = new NEGFeedBackView(getTbPageContext());
        int g = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16);
        this.dBq.a(this.dBd, g, 0);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dBf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBf.setLayoutParams(layoutParams);
        }
        this.dBf.setOnClickListener(this);
        this.dBf.setReplyTimeVisible(false);
        this.dBf.setShowPraiseNum(true);
        this.dBf.setNeedAddPraiseIcon(true);
        this.dBf.setNeedAddReplyIcon(true);
        this.dBf.setShareVisible(true);
        this.dBf.setShareReportFrom(3);
        this.dBf.setForumAfterClickListener(this.bZu);
        this.dBf.setFrom(1);
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dBT.cbx.setOnClickListener(this);
        this.dBT.setFrom(1);
        this.dBT.setShareReportFrom(3);
        this.dBT.setForumAfterClickListener(this.bZu);
        this.exf = view.findViewById(R.id.divider_below_reply_number_layout);
        this.cIn = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cIn.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cIn.setLayoutParams(layoutParams2);
        this.cIp = (TbImageView) view.findViewById(R.id.image_video);
        this.cIp.setDefaultErrorResource(0);
        this.cIp.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cIp.setGifIconSupport(false);
        this.cIp.setEvent(this.cIx);
        this.cIp.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cIp;
        TbImageView tbImageView2 = this.cIp;
        tbImageView.setConrers(15);
        this.cIp.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cIp.setBorderColor(al.getColor(R.color.black_alpha8));
        this.cIp.setBorderSurroundContent(true);
        this.cIp.setDrawBorder(true);
        this.cIq = (ImageView) view.findViewById(R.id.image_video_play);
        this.dBd.setOnClickListener(this);
        this.Ro = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.dlO = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.Ro.setPlayerReuseEnable(true);
        this.Ro.setContinuePlayEnable(true);
        this.Ro.setBusiness(this.dlO);
        this.Ro.setOnPreparedListener(this.cRU);
        this.Ro.setOnOutInfoListener(this.cRW);
        this.Ro.setOnCompletionListener(this.cRT);
        this.Ro.setOnErrorListener(this.cIy);
        this.Ro.setOnSurfaceDestroyedListener(this.cIC);
        this.dlN = new com.baidu.tieba.play.j();
        this.dlN.setPlayer(this.Ro);
        this.dlN.a(this.exD);
        this.cIo = (TextView) view.findViewById(R.id.text_video_duration);
        this.exm = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cIv = (TextView) view.findViewById(R.id.text_video_play_count);
        this.cIu = view.findViewById(R.id.auto_video_black_mask);
        this.cIr = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cIs = view.findViewById(R.id.auto_video_error_background);
        this.dCe = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.afl = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.afl.setAnimationListener(this.exE);
        this.exk = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.exk.setOnClickListener(this);
        this.cTa = view.findViewById(R.id.divider_line);
        this.exu = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.Ro.setOnClickListener(this);
        this.exw = (TextView) view.findViewById(R.id.nani_video_icon);
        this.exn = new com.baidu.tieba.j.k();
        this.exj = new com.baidu.afd.videopaster.d(getContext(), this.cIn);
        this.exj.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void pn() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pm() {
                if (!m.this.exv) {
                    m.this.Ro.start();
                } else {
                    m.this.startPlay();
                }
                m.this.exv = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pl() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean po() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.exo != null && this.exo.threadData != null && this.exo.threadData.bKO > 0) {
            if (aXr() != null) {
                aXr().a(view, this.exo);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.exo.threadData.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.adi(), this.exo.aby())));
            return;
        }
        if (view == this.dBd || view == this.exk) {
            bG(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.Ro) {
            if (this.exo != null) {
                this.exo.objType = 5;
            }
            if (this.exo != null && this.exo.threadData != null && this.exo.threadData.adM() != null) {
                z = this.exo.threadData.adM().is_vertical.intValue() == 1;
            }
            if (z) {
                bE(this.Ro);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bF(this.Ro);
            } else {
                bG(getView());
            }
        }
    }

    private void bE(View view) {
        if (aXr() != null) {
            aXr().a(view, this.exo);
        }
        if (!com.baidu.adp.lib.util.j.jS()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXz();
        }
    }

    private void bF(View view) {
        if (aXr() != null) {
            aXr().a(view, this.exo);
        }
        if (!com.baidu.adp.lib.util.j.jS()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXA();
        }
    }

    private void aXz() {
        if (this.exo != null && this.exo.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.exo.threadData);
            videoItemData.mRecomExtra = this.exo.getExtra();
            videoItemData.mRecomAbTag = this.exo.aYa();
            videoItemData.mRecomSource = this.exo.getSource();
            videoItemData.mRecomWeight = this.exo.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.exo.aby(), "index")));
        }
    }

    private void aXA() {
        if (this.exo != null && this.exo.threadData != null && this.exo.threadData.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.exo.threadData);
            videoSerializeVideoThreadInfo.source = this.exo.getSource();
            videoSerializeVideoThreadInfo.extra = this.exo.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.exo.aYa();
            videoSerializeVideoThreadInfo.weight = this.exo.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dCe.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dCe.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ap.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.exo.threadData.getTid(), n.adi(), this.exo.aby(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bG(View view) {
        if (this.exo != null) {
            this.exo.objType = 1;
        }
        if (aXr() != null) {
            aXr().a(view, this.exo);
        }
        if (this.exo != null && this.exo.threadData != null) {
            if (!aXB()) {
                n.uR(this.exo.threadData.getId());
                n.a(this.mTextTitle, this.exo.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.exo.threadData, null, n.adi(), 18003, true, false, false).addLocateParam(this.exo.aby());
            addLocateParam.setVideo_source(this.exo.sourceType == 0 ? "index" : "hot_juhe");
            if (this.exo.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.exo.threadData.getFid()));
            addLocateParam.setForumName(this.exo.threadData.adA());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.exk) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXB() {
        return this.exo.eBk && !this.exo.eBr;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.exo = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXC() {
        this.exx.removeMessages(202);
        if (this.Ro.getCurrentPosition() > this.Ss) {
            i(false, 3);
            this.exx.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.exx.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXD() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.exx.removeMessages(203);
        int currentPosition = this.Ro.getCurrentPosition();
        if (currentPosition != this.exp) {
            this.exp = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.exx.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cIq != null && this.cIp != null && this.cIu != null && this.cIt != null && this.cIs != null && this.cIr != null) {
            if (z || this.cIw != i) {
                this.cIw = i;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIB);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
                if (i == 2) {
                    this.cIq.setVisibility(8);
                    this.afl.cancel();
                    this.cIp.clearAnimation();
                    this.cIp.setVisibility(0);
                    this.cIu.setVisibility(0);
                    this.exm.setVisibility(0);
                    this.exu.setVisibility(8);
                    this.cIt.startLoading();
                    this.cIs.setVisibility(8);
                    this.cIr.setVisibility(8);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.cIB, 60000L);
                } else if (i == 3) {
                    this.cIq.setVisibility(8);
                    this.cIp.startAnimation(this.afl);
                    this.cIu.setVisibility(8);
                    this.exm.setVisibility(8);
                    if (this.exo != null && this.exo.abv() != null && this.exo.abv().bKO > 0) {
                        this.exu.setVisibility(0);
                    }
                    this.cIt.cbR();
                    this.cIs.setVisibility(8);
                    this.cIr.setVisibility(8);
                    if (this.exo != null && this.exo.threadData != null && this.exo.threadData.adM() != null) {
                        this.exn.a(this.exo.threadData.getTid(), this.exo.threadData.adM().video_length.intValue(), this.exo.threadData.adM().video_duration.intValue(), "homepage", this.Ro);
                    }
                } else if (i == 4) {
                    this.cIq.setVisibility(8);
                    this.cIp.startAnimation(this.afl);
                    this.cIu.setVisibility(8);
                    this.cIt.cbS();
                    this.cIs.setVisibility(0);
                    this.cIr.setVisibility(0);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.cIA, 2000L);
                } else {
                    this.cIq.setVisibility(0);
                    this.afl.cancel();
                    this.cIp.clearAnimation();
                    this.cIp.setVisibility(0);
                    this.cIu.setVisibility(0);
                    this.exm.setVisibility(0);
                    this.cIt.cbS();
                    this.cIs.setVisibility(8);
                    this.cIr.setVisibility(8);
                }
                if (this.exo != null && this.exo.abv() != null && this.exo.abv().bKO > 0) {
                    this.exm.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.exo == null || this.exo.threadData == null || this.exo.threadData.adv() == null) {
            this.dBd.setVisibility(8);
            return;
        }
        this.dBd.setVisibility(0);
        aXF();
        if (!aXB() && n.uS(this.exo.threadData.getId())) {
            n.a(this.mTextTitle, this.exo.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.exk.getGodReplyContent(), this.exo.abv().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.exo.abv().ael();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.exo.abv().aeb());
        if (this.exo.abv().aei() && !StringUtils.isNull(this.exo.abv().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.exo.abv().getTid();
            spannableStringBuilder.append((CharSequence) this.exo.abv().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
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
        this.dBe.setData(this.exo.abv());
        this.dBe.setUserAfterClickListener(this.exA);
        if (this.dBe.getHeaderImg() != null) {
            this.dBe.getHeaderImg().setAfterClickListener(this.exB);
            if (this.dBe.getIsSimpleThread()) {
                this.dBe.getHeaderImg().setVisibility(8);
                this.exl.setVisibility(8);
            } else if (this.exo.abv() == null || this.exo.abv().adv() == null || this.exo.abv().adv().getPendantData() == null || StringUtils.isNull(this.exo.abv().adv().getPendantData().abS())) {
                this.exl.setVisibility(8);
                this.dBe.getHeaderImg().setVisibility(0);
                if (this.exo.abv().bKO > 0 && this.exo.abv().bKP == 0) {
                    this.exo.abv().adv().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dBe.getHeaderImg().setData(this.exo.abv(), false);
                } else {
                    this.dBe.getHeaderImg().setData(this.exo.abv());
                    this.dBe.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dBe.getHeaderImg().setVisibility(4);
                this.exl.setVisibility(0);
                this.exl.setData(this.exo.abv());
            }
        }
        this.cIo.setText(ap.im(this.exo.threadData.adM().video_duration.intValue() * 1000));
        this.cIv.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.exo.threadData.adM().play_count.intValue())));
        if (this.dBq != null && this.exo.abv() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.exo.abv().getTid());
            ajVar.setFid(this.exo.abv().getFid());
            ajVar.b(this.exo.bGL);
            this.dBq.setData(ajVar);
            this.dBq.setFirstRowSingleColumn(true);
            this.dBq.setVisibility(this.exr ? 0 : 8);
        }
        this.exk.setData(this.exo.abv().aeT());
        nv(mh(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.uS(this.exo.threadData.getId())) {
            al.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            al.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.exo == null || this.exo.threadData == null || this.exo.threadData.adM() == null) {
            z = false;
        } else {
            z = this.exo.threadData.adM().is_vertical.intValue() == 1;
        }
        if (z) {
            this.exw.setVisibility(0);
            if (aXG()) {
                this.exw.setText(String.format("%s | %s", this.mContext.getResources().getString(R.string.nani_video), this.mContext.getResources().getString(R.string.video_preview)));
            } else {
                this.exw.setText(this.mContext.getString(R.string.nani_video));
            }
        } else if (aXG()) {
            this.exw.setVisibility(0);
            this.exw.setText(this.mContext.getString(R.string.video_preview));
        } else {
            this.exw.setVisibility(8);
        }
    }

    private void aXE() {
        this.exx.removeMessages(202);
        this.exx.removeMessages(203);
    }

    private void axg() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIB);
    }

    private void aXF() {
        axg();
        aXE();
        if (this.cIp != null && this.cIn != null && this.Ro != null) {
            if (com.baidu.tbadk.core.i.abb().abf() && this.exo != null && this.exo.threadData != null && this.exo.threadData.adM() != null) {
                this.cIp.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cIp.startLoad(this.exo.threadData.adM().thumbnail_url, 10, false);
                this.cIn.setVisibility(0);
                stopPlay();
                this.bVa = this.exo.threadData.adM().video_url;
                if (aXG()) {
                    this.bVa = this.exo.threadData.adN().video_url;
                }
                if (StringUtils.isNull(this.exo.threadData.adM().video_url)) {
                    i(true, 4);
                }
                if (this.dlO != null && this.dlO.cbA() != null) {
                    this.dlO.cbA().g(this.exo.threadData.adM());
                }
                this.Ro.dR(this.bVa, this.exo.tid);
            } else {
                this.cIn.setVisibility(8);
            }
            this.exj.reset();
            this.dlN.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.exj.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.exo);
                    }
                }
            });
            this.dlO.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.exj.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.exo);
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
        int ps = bVar.ps();
        int pt = bVar.pt();
        int pr = bVar.pr();
        if (pr != -1) {
            i = ps != -1 ? (pr - ps) - 1 : -1;
            if (pt != -1) {
                i4 = (pt - pr) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo adM = bgVar.adM();
        if (adM != null) {
            i3 = adM.video_width.intValue();
            i2 = adM.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.adA());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pr + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dBd, R.drawable.addresslist_item_bg);
            al.c(this.cIq, (int) R.drawable.btn_icon_play_video_n);
            al.j(this.cIr, R.color.cp_btn_a);
            al.j(this.cIo, R.color.cp_btn_a);
            al.j(this.cIv, R.color.cp_btn_a);
            al.j(this.exu, R.color.cp_btn_a);
            al.l(this.cIs, R.color.common_color_10014);
            al.l(this.cTa, R.color.cp_bg_line_e);
            if (this.exw != null) {
                al.j(this.exw, R.color.cp_btn_a);
                al.k(this.exw, R.drawable.video_play_count_bg);
            }
            if (this.cIr != null) {
                this.cIr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.exk.onChangeSkinType();
            if (this.dBq != null) {
                this.dBq.onChangeSkinType();
            }
            this.dBe.onChangeSkinType();
            this.dBf.onChangeSkinType();
            this.dBT.onChangeSkinType();
            this.cIp.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.exl.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.exC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.exC);
            this.exz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.exz);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dBe != null) {
            this.dBe.setPageUniqueId(bdUniqueId);
        }
        if (this.cIp != null) {
            this.cIp.setPageId(bdUniqueId);
        }
        if (this.dBq != null) {
            this.dBq.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.exq;
    }

    public boolean isPlaying() {
        if (this.Ro == null) {
            return false;
        }
        return this.Ro.isPlaying();
    }

    public void startPlay() {
        if (!this.exq && this.exo != null && this.exo.threadData != null && this.exo.threadData.adM() != null && this.Ro != null) {
            if (this.exj.oW()) {
                this.exj.resume();
                this.exv = true;
                return;
            }
            this.exv = false;
            this.Ro.stopPlayback();
            if (ad.K(1, this.bVa)) {
                this.exn.bMm();
                i(true, 2);
                if (StringUtils.isNull(this.bVa)) {
                    TiebaStatic.log(new am("c12619").bT("obj_locate", "index").bT("tid", this.exo.tid));
                    this.bVa = this.exo.threadData.adM().video_url;
                }
                this.exq = true;
                this.Ro.setVideoPath(this.bVa, this.exo.tid);
                if (this.dlN != null) {
                    this.dlN.start();
                }
                aXy();
            }
        }
    }

    public void stopPlay() {
        this.exv = false;
        axg();
        aXE();
        i(true, 1);
        if (this.Ro != null) {
            this.Ro.stopPlayback();
            if (this.dlN != null) {
                this.dlN.stop();
            }
        }
        this.exq = false;
        this.exj.stop();
    }

    public View getVideoContainer() {
        return this.cIn;
    }

    public String getPlayUrl() {
        return this.bVa;
    }

    public int getCurrentPosition() {
        if (this.Ro == null) {
            return 0;
        }
        return this.Ro.getCurrentPosition();
    }

    public void ip(boolean z) {
        this.exr = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void nv(int i) {
        if (this.exo != null && this.exo.threadData != null) {
            if (i == 1) {
                if (this.exo.threadData.bKO > 0) {
                    this.dBT.cbx.setShowPraiseNum(false);
                    this.dBT.cbx.setShareVisible(false);
                    this.exu.setText(ap.aN(this.exo.threadData.bKO));
                    this.exu.setVisibility(0);
                } else {
                    this.dBT.cbx.setShowPraiseNum(true);
                    this.dBT.cbx.setShareVisible(true);
                    this.exu.setVisibility(8);
                }
                this.dBT.setData(this.exo.threadData);
                this.dBf.setVisibility(8);
                this.dBe.ej(false);
                return;
            }
            this.dBT.setVisibility(8);
            this.dBe.ej(true);
            if (this.exo.threadData.bKO > 0) {
                this.dBf.setShowPraiseNum(false);
                this.dBf.setShareVisible(false);
                this.exu.setText(ap.aN(this.exo.threadData.bKO));
                this.exu.setVisibility(0);
            } else {
                this.dBf.setShowPraiseNum(true);
                this.dBf.setShareVisible(true);
                this.exu.setVisibility(8);
            }
            if (this.dBf.setData(this.exo.threadData)) {
                this.exf.setVisibility(8);
            } else {
                this.exf.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Ws = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Ws, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cIp.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cIp.setOnDrawListener(null);
        }
    }

    private boolean aXG() {
        return (this.exo == null || this.exo.threadData == null || this.exo.threadData.adN() == null || TextUtils.isEmpty(this.exo.threadData.adN().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.exj.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.exj.stop();
    }

    public void onResume() {
        if (this.exj.oW()) {
            this.exj.resume();
        }
    }
}
