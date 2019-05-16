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
    private QuickVideoView Rp;
    private int St;
    private String Wt;
    private Animation afl;
    private String bUZ;
    private final View.OnClickListener bZt;
    private Runnable cIA;
    private QuickVideoView.b cIB;
    public FrameLayout cIm;
    private TextView cIn;
    private TbImageView cIo;
    private ImageView cIp;
    private TextView cIq;
    private View cIr;
    private com.baidu.tieba.play.x cIs;
    private View cIt;
    private TextView cIu;
    private int cIv;
    private TbImageView.a cIw;
    private g.b cIx;
    private Runnable cIz;
    private g.a cRR;
    private g.f cRS;
    private g.e cRU;
    private View cSY;
    public ThreadSourceShareAndPraiseLayout dBS;
    private RelativeLayout dBc;
    public ThreadUserInfoLayout dBd;
    public ThreadCommentAndPraiseInfoLayout dBe;
    private NEGFeedBackView dBp;
    protected LinearLayout dCd;
    private com.baidu.tieba.play.g deB;
    private com.baidu.tieba.play.j dlM;
    private com.baidu.tieba.play.n dlN;
    private final View.OnClickListener exA;
    private CustomMessageListener exB;
    private j.a exC;
    private Animation.AnimationListener exD;
    private View exe;
    private com.baidu.afd.videopaster.d exi;
    public ThreadGodReplyLayout exj;
    private HeadPendantClickableView exk;
    private LinearLayout exl;
    private com.baidu.tieba.j.k exm;
    private com.baidu.tieba.card.data.l exn;
    private int exo;
    private boolean exp;
    private boolean exq;
    private boolean exr;
    private TextView exs;
    private boolean exu;
    private TextView exv;
    private Handler exw;
    private VideoLoadingProgressView.a exx;
    private CustomMessageListener exy;
    private final View.OnClickListener exz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aXu() {
        if (this.deB != null && this.exp) {
            try {
                this.Rp.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.deB.isPlayerReuse()) {
                int Ck = com.baidu.tieba.play.y.cbS().Ck(this.bUZ);
                if (Ck <= 100 || this.deB.getDuration() <= Ck) {
                    Ck = 100;
                }
                this.St = Ck;
            } else {
                this.St = 100;
            }
            this.exw.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        if (this.exn != null && this.exn.threadData != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.exn.sourceType == 0 ? "index" : "hot_juhe";
            zVar.bVL = this.exn.threadData.getTid();
            zVar.eAB = this.exn.threadData.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.exn.threadData.mRecomSource;
            zVar.ire = this.exn.threadData.mRecomAbTag;
            zVar.irf = this.exn.threadData.mRecomWeight;
            zVar.irg = "";
            zVar.bFP = this.exn.getExtra();
            if (this.exn.threadData.adM() != null) {
                zVar.iri = this.exn.threadData.adM().video_md5;
            }
            com.baidu.tieba.play.l.a(this.exn.threadData.adM().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dBp = null;
        this.mSkinType = 3;
        this.exo = 0;
        this.cIv = 1;
        this.exp = false;
        this.exq = true;
        this.exr = false;
        this.St = 100;
        this.exu = false;
        this.exw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.aXz();
                        return;
                    case 203:
                        m.this.aXA();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cRS = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                m.this.deB = gVar;
                if (m.this.deB != null) {
                    m.this.deB.setVolume(0.0f, 0.0f);
                }
                m.this.exm.bMj();
                m.this.aXu();
            }
        };
        this.cRU = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cRR = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.exi.a(false, false, "NEWINDEX")) {
                    m.this.Rp.start();
                }
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.exp = false;
                return true;
            }
        };
        this.exx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aXu();
            }
        };
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && m.this.cIo != null) {
                    m.this.cIo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.Rp != null && !m.this.Rp.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cIA = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.exy = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.exn != null && m.this.exn.threadData != null && videoId.equals(m.this.exn.threadData.getId())) {
                        m.this.exi.a(m.this.a(m.this.exn, bVar));
                    }
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.exz = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.exn == null) {
                    if (m.this.aXo() != null) {
                        m.this.aXo().a(view, m.this.exn);
                        return;
                    }
                    return;
                }
                if (view == m.this.dBd.getUserName()) {
                    m.this.exn.objType = 3;
                } else if (view == m.this.dBd.getHeaderImg()) {
                    m.this.exn.objType = 4;
                } else {
                    m.this.exn.objType = 1;
                }
                if (m.this.aXo() != null) {
                    m.this.aXo().a(view, m.this.exn);
                }
            }
        };
        this.exA = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.exn != null) {
                    m.this.exn.objType = 4;
                }
                if (m.this.aXo() != null) {
                    m.this.aXo().a(view, m.this.exn);
                }
            }
        };
        this.exB = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.exr = false;
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.exn != null) {
                    if (m.this.aXo() != null) {
                        m.this.aXo().a(view, m.this.exn);
                    }
                    if (m.this.exn.threadData != null && view != m.this.dBS.caL) {
                        n.uS(m.this.exn.threadData.getId());
                        if (!m.this.aXy()) {
                            n.a(m.this.mTextTitle, m.this.exn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            n.a(m.this.exj.getGodReplyContent(), m.this.exn.abv().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.exC = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void pz() {
                if (m.this.exn != null && m.this.exn.threadData != null && m.this.exn.threadData.adM() != null) {
                    m.this.aXv();
                }
            }
        };
        this.exD = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cIo != null) {
                    m.this.cIo.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dBc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.exk = (HeadPendantClickableView) this.dBc.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.exk.getHeadView() != null) {
            this.exk.getHeadView().setIsRound(true);
            this.exk.getHeadView().setDrawBorder(false);
            this.exk.getHeadView().setDefaultResource(17170445);
            this.exk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exk.getHeadView().setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.exk.setHasPendantStyle();
        if (this.exk.getPendantView() != null) {
            this.exk.getPendantView().setIsRound(true);
            this.exk.getPendantView().setDrawBorder(false);
        }
        this.cIs = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cIs.setLoadingAnimationListener(this.exx);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dBd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dBp = new NEGFeedBackView(getTbPageContext());
        int g = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16);
        this.dBp.a(this.dBc, g, 0);
        this.dBe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dBe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBe.setLayoutParams(layoutParams);
        }
        this.dBe.setOnClickListener(this);
        this.dBe.setReplyTimeVisible(false);
        this.dBe.setShowPraiseNum(true);
        this.dBe.setNeedAddPraiseIcon(true);
        this.dBe.setNeedAddReplyIcon(true);
        this.dBe.setShareVisible(true);
        this.dBe.setShareReportFrom(3);
        this.dBe.setForumAfterClickListener(this.bZt);
        this.dBe.setFrom(1);
        this.dBS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dBS.cbw.setOnClickListener(this);
        this.dBS.setFrom(1);
        this.dBS.setShareReportFrom(3);
        this.dBS.setForumAfterClickListener(this.bZt);
        this.exe = view.findViewById(R.id.divider_below_reply_number_layout);
        this.cIm = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cIm.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cIm.setLayoutParams(layoutParams2);
        this.cIo = (TbImageView) view.findViewById(R.id.image_video);
        this.cIo.setDefaultErrorResource(0);
        this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cIo.setGifIconSupport(false);
        this.cIo.setEvent(this.cIw);
        this.cIo.setRadius(com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cIo;
        TbImageView tbImageView2 = this.cIo;
        tbImageView.setConrers(15);
        this.cIo.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cIo.setBorderColor(al.getColor(R.color.black_alpha8));
        this.cIo.setBorderSurroundContent(true);
        this.cIo.setDrawBorder(true);
        this.cIp = (ImageView) view.findViewById(R.id.image_video_play);
        this.dBc.setOnClickListener(this);
        this.Rp = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.dlN = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.Rp.setPlayerReuseEnable(true);
        this.Rp.setContinuePlayEnable(true);
        this.Rp.setBusiness(this.dlN);
        this.Rp.setOnPreparedListener(this.cRS);
        this.Rp.setOnOutInfoListener(this.cRU);
        this.Rp.setOnCompletionListener(this.cRR);
        this.Rp.setOnErrorListener(this.cIx);
        this.Rp.setOnSurfaceDestroyedListener(this.cIB);
        this.dlM = new com.baidu.tieba.play.j();
        this.dlM.setPlayer(this.Rp);
        this.dlM.a(this.exC);
        this.cIn = (TextView) view.findViewById(R.id.text_video_duration);
        this.exl = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cIu = (TextView) view.findViewById(R.id.text_video_play_count);
        this.cIt = view.findViewById(R.id.auto_video_black_mask);
        this.cIq = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cIr = view.findViewById(R.id.auto_video_error_background);
        this.dCd = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.afl = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.afl.setAnimationListener(this.exD);
        this.exj = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.exj.setOnClickListener(this);
        this.cSY = view.findViewById(R.id.divider_line);
        this.exs = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.Rp.setOnClickListener(this);
        this.exv = (TextView) view.findViewById(R.id.nani_video_icon);
        this.exm = new com.baidu.tieba.j.k();
        this.exi = new com.baidu.afd.videopaster.d(getContext(), this.cIm);
        this.exi.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void pn() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pm() {
                if (!m.this.exu) {
                    m.this.Rp.start();
                } else {
                    m.this.startPlay();
                }
                m.this.exu = false;
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
        if (this.exn != null && this.exn.threadData != null && this.exn.threadData.bKN > 0) {
            if (aXo() != null) {
                aXo().a(view, this.exn);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.exn.threadData.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.adi(), this.exn.aby())));
            return;
        }
        if (view == this.dBc || view == this.exj) {
            bG(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.Rp) {
            if (this.exn != null) {
                this.exn.objType = 5;
            }
            if (this.exn != null && this.exn.threadData != null && this.exn.threadData.adM() != null) {
                z = this.exn.threadData.adM().is_vertical.intValue() == 1;
            }
            if (z) {
                bE(this.Rp);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bF(this.Rp);
            } else {
                bG(getView());
            }
        }
    }

    private void bE(View view) {
        if (aXo() != null) {
            aXo().a(view, this.exn);
        }
        if (!com.baidu.adp.lib.util.j.jS()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXw();
        }
    }

    private void bF(View view) {
        if (aXo() != null) {
            aXo().a(view, this.exn);
        }
        if (!com.baidu.adp.lib.util.j.jS()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXx();
        }
    }

    private void aXw() {
        if (this.exn != null && this.exn.threadData != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.exn.threadData);
            videoItemData.mRecomExtra = this.exn.getExtra();
            videoItemData.mRecomAbTag = this.exn.aXX();
            videoItemData.mRecomSource = this.exn.getSource();
            videoItemData.mRecomWeight = this.exn.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.exn.aby(), "index")));
        }
    }

    private void aXx() {
        if (this.exn != null && this.exn.threadData != null && this.exn.threadData.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.exn.threadData);
            videoSerializeVideoThreadInfo.source = this.exn.getSource();
            videoSerializeVideoThreadInfo.extra = this.exn.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.exn.aXX();
            videoSerializeVideoThreadInfo.weight = this.exn.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dCd.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dCd.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ap.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.exn.threadData.getTid(), n.adi(), this.exn.aby(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bG(View view) {
        if (this.exn != null) {
            this.exn.objType = 1;
        }
        if (aXo() != null) {
            aXo().a(view, this.exn);
        }
        if (this.exn != null && this.exn.threadData != null) {
            if (!aXy()) {
                n.uS(this.exn.threadData.getId());
                n.a(this.mTextTitle, this.exn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.exn.threadData, null, n.adi(), 18003, true, false, false).addLocateParam(this.exn.aby());
            addLocateParam.setVideo_source(this.exn.sourceType == 0 ? "index" : "hot_juhe");
            if (this.exn.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.exn.threadData.getFid()));
            addLocateParam.setForumName(this.exn.threadData.adA());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.exj) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXy() {
        return this.exn.eBj && !this.exn.eBq;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.exn = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        this.exw.removeMessages(202);
        if (this.Rp.getCurrentPosition() > this.St) {
            i(false, 3);
            this.exw.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.exw.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXA() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.exw.removeMessages(203);
        int currentPosition = this.Rp.getCurrentPosition();
        if (currentPosition != this.exo) {
            this.exo = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.exw.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cIp != null && this.cIo != null && this.cIt != null && this.cIs != null && this.cIr != null && this.cIq != null) {
            if (z || this.cIv != i) {
                this.cIv = i;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIz);
                if (i == 2) {
                    this.cIp.setVisibility(8);
                    this.afl.cancel();
                    this.cIo.clearAnimation();
                    this.cIo.setVisibility(0);
                    this.cIt.setVisibility(0);
                    this.exl.setVisibility(0);
                    this.exs.setVisibility(8);
                    this.cIs.startLoading();
                    this.cIr.setVisibility(8);
                    this.cIq.setVisibility(8);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.cIA, 60000L);
                } else if (i == 3) {
                    this.cIp.setVisibility(8);
                    this.cIo.startAnimation(this.afl);
                    this.cIt.setVisibility(8);
                    this.exl.setVisibility(8);
                    if (this.exn != null && this.exn.abv() != null && this.exn.abv().bKN > 0) {
                        this.exs.setVisibility(0);
                    }
                    this.cIs.cbN();
                    this.cIr.setVisibility(8);
                    this.cIq.setVisibility(8);
                    if (this.exn != null && this.exn.threadData != null && this.exn.threadData.adM() != null) {
                        this.exm.a(this.exn.threadData.getTid(), this.exn.threadData.adM().video_length.intValue(), this.exn.threadData.adM().video_duration.intValue(), "homepage", this.Rp);
                    }
                } else if (i == 4) {
                    this.cIp.setVisibility(8);
                    this.cIo.startAnimation(this.afl);
                    this.cIt.setVisibility(8);
                    this.cIs.cbO();
                    this.cIr.setVisibility(0);
                    this.cIq.setVisibility(0);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.cIz, 2000L);
                } else {
                    this.cIp.setVisibility(0);
                    this.afl.cancel();
                    this.cIo.clearAnimation();
                    this.cIo.setVisibility(0);
                    this.cIt.setVisibility(0);
                    this.exl.setVisibility(0);
                    this.cIs.cbO();
                    this.cIr.setVisibility(8);
                    this.cIq.setVisibility(8);
                }
                if (this.exn != null && this.exn.abv() != null && this.exn.abv().bKN > 0) {
                    this.exl.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.exn == null || this.exn.threadData == null || this.exn.threadData.adv() == null) {
            this.dBc.setVisibility(8);
            return;
        }
        this.dBc.setVisibility(0);
        aXC();
        if (!aXy() && n.uT(this.exn.threadData.getId())) {
            n.a(this.mTextTitle, this.exn.threadData.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.exj.getGodReplyContent(), this.exn.abv().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.exn.abv().ael();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.exn.abv().aeb());
        if (this.exn.abv().aei() && !StringUtils.isNull(this.exn.abv().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.exn.abv().getTid();
            spannableStringBuilder.append((CharSequence) this.exn.abv().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
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
        this.dBd.setData(this.exn.abv());
        this.dBd.setUserAfterClickListener(this.exz);
        if (this.dBd.getHeaderImg() != null) {
            this.dBd.getHeaderImg().setAfterClickListener(this.exA);
            if (this.dBd.getIsSimpleThread()) {
                this.dBd.getHeaderImg().setVisibility(8);
                this.exk.setVisibility(8);
            } else if (this.exn.abv() == null || this.exn.abv().adv() == null || this.exn.abv().adv().getPendantData() == null || StringUtils.isNull(this.exn.abv().adv().getPendantData().abS())) {
                this.exk.setVisibility(8);
                this.dBd.getHeaderImg().setVisibility(0);
                if (this.exn.abv().bKN > 0 && this.exn.abv().bKO == 0) {
                    this.exn.abv().adv().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dBd.getHeaderImg().setData(this.exn.abv(), false);
                } else {
                    this.dBd.getHeaderImg().setData(this.exn.abv());
                    this.dBd.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dBd.getHeaderImg().setVisibility(4);
                this.exk.setVisibility(0);
                this.exk.setData(this.exn.abv());
            }
        }
        this.cIn.setText(ap.im(this.exn.threadData.adM().video_duration.intValue() * 1000));
        this.cIu.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.exn.threadData.adM().play_count.intValue())));
        if (this.dBp != null && this.exn.abv() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.exn.abv().getTid());
            ajVar.setFid(this.exn.abv().getFid());
            ajVar.b(this.exn.bGK);
            this.dBp.setData(ajVar);
            this.dBp.setFirstRowSingleColumn(true);
            this.dBp.setVisibility(this.exq ? 0 : 8);
        }
        this.exj.setData(this.exn.abv().aeT());
        nv(mh(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.uT(this.exn.threadData.getId())) {
            al.f(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            al.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.exn == null || this.exn.threadData == null || this.exn.threadData.adM() == null) {
            z = false;
        } else {
            z = this.exn.threadData.adM().is_vertical.intValue() == 1;
        }
        if (z) {
            this.exv.setVisibility(0);
            if (aXD()) {
                this.exv.setText(String.format("%s | %s", this.mContext.getResources().getString(R.string.nani_video), this.mContext.getResources().getString(R.string.video_preview)));
            } else {
                this.exv.setText(this.mContext.getString(R.string.nani_video));
            }
        } else if (aXD()) {
            this.exv.setVisibility(0);
            this.exv.setText(this.mContext.getString(R.string.video_preview));
        } else {
            this.exv.setVisibility(8);
        }
    }

    private void aXB() {
        this.exw.removeMessages(202);
        this.exw.removeMessages(203);
    }

    private void axf() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIz);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
    }

    private void aXC() {
        axf();
        aXB();
        if (this.cIo != null && this.cIm != null && this.Rp != null) {
            if (com.baidu.tbadk.core.i.abb().abf() && this.exn != null && this.exn.threadData != null && this.exn.threadData.adM() != null) {
                this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cIo.startLoad(this.exn.threadData.adM().thumbnail_url, 10, false);
                this.cIm.setVisibility(0);
                stopPlay();
                this.bUZ = this.exn.threadData.adM().video_url;
                if (aXD()) {
                    this.bUZ = this.exn.threadData.adN().video_url;
                }
                if (StringUtils.isNull(this.exn.threadData.adM().video_url)) {
                    i(true, 4);
                }
                if (this.dlN != null && this.dlN.cbw() != null) {
                    this.dlN.cbw().g(this.exn.threadData.adM());
                }
                this.Rp.dR(this.bUZ, this.exn.tid);
            } else {
                this.cIm.setVisibility(8);
            }
            this.exi.reset();
            this.dlM.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.exi.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.exn);
                    }
                }
            });
            this.dlN.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void bc(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.exi.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.exn);
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
            al.k(this.dBc, R.drawable.addresslist_item_bg);
            al.c(this.cIp, (int) R.drawable.btn_icon_play_video_n);
            al.j(this.cIq, R.color.cp_btn_a);
            al.j(this.cIn, R.color.cp_btn_a);
            al.j(this.cIu, R.color.cp_btn_a);
            al.j(this.exs, R.color.cp_btn_a);
            al.l(this.cIr, R.color.common_color_10014);
            al.l(this.cSY, R.color.cp_bg_line_e);
            if (this.exv != null) {
                al.j(this.exv, R.color.cp_btn_a);
                al.k(this.exv, R.drawable.video_play_count_bg);
            }
            if (this.cIq != null) {
                this.cIq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.exj.onChangeSkinType();
            if (this.dBp != null) {
                this.dBp.onChangeSkinType();
            }
            this.dBd.onChangeSkinType();
            this.dBe.onChangeSkinType();
            this.dBS.onChangeSkinType();
            this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.exk.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.exB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.exB);
            this.exy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.exy);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dBd != null) {
            this.dBd.setPageUniqueId(bdUniqueId);
        }
        if (this.cIo != null) {
            this.cIo.setPageId(bdUniqueId);
        }
        if (this.dBp != null) {
            this.dBp.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.exp;
    }

    public boolean isPlaying() {
        if (this.Rp == null) {
            return false;
        }
        return this.Rp.isPlaying();
    }

    public void startPlay() {
        if (!this.exp && this.exn != null && this.exn.threadData != null && this.exn.threadData.adM() != null && this.Rp != null) {
            if (this.exi.oW()) {
                this.exi.resume();
                this.exu = true;
                return;
            }
            this.exu = false;
            this.Rp.stopPlayback();
            if (ad.K(1, this.bUZ)) {
                this.exm.bMi();
                i(true, 2);
                if (StringUtils.isNull(this.bUZ)) {
                    TiebaStatic.log(new am("c12619").bT("obj_locate", "index").bT("tid", this.exn.tid));
                    this.bUZ = this.exn.threadData.adM().video_url;
                }
                this.exp = true;
                this.Rp.setVideoPath(this.bUZ, this.exn.tid);
                if (this.dlM != null) {
                    this.dlM.start();
                }
                aXv();
            }
        }
    }

    public void stopPlay() {
        this.exu = false;
        axf();
        aXB();
        i(true, 1);
        if (this.Rp != null) {
            this.Rp.stopPlayback();
            if (this.dlM != null) {
                this.dlM.stop();
            }
        }
        this.exp = false;
        this.exi.stop();
    }

    public View getVideoContainer() {
        return this.cIm;
    }

    public String getPlayUrl() {
        return this.bUZ;
    }

    public int getCurrentPosition() {
        if (this.Rp == null) {
            return 0;
        }
        return this.Rp.getCurrentPosition();
    }

    public void ip(boolean z) {
        this.exq = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void nv(int i) {
        if (this.exn != null && this.exn.threadData != null) {
            if (i == 1) {
                if (this.exn.threadData.bKN > 0) {
                    this.dBS.cbw.setShowPraiseNum(false);
                    this.dBS.cbw.setShareVisible(false);
                    this.exs.setText(ap.aN(this.exn.threadData.bKN));
                    this.exs.setVisibility(0);
                } else {
                    this.dBS.cbw.setShowPraiseNum(true);
                    this.dBS.cbw.setShareVisible(true);
                    this.exs.setVisibility(8);
                }
                this.dBS.setData(this.exn.threadData);
                this.dBe.setVisibility(8);
                this.dBd.ej(false);
                return;
            }
            this.dBS.setVisibility(8);
            this.dBd.ej(true);
            if (this.exn.threadData.bKN > 0) {
                this.dBe.setShowPraiseNum(false);
                this.dBe.setShareVisible(false);
                this.exs.setText(ap.aN(this.exn.threadData.bKN));
                this.exs.setVisibility(0);
            } else {
                this.dBe.setShowPraiseNum(true);
                this.dBe.setShareVisible(true);
                this.exs.setVisibility(8);
            }
            if (this.dBe.setData(this.exn.threadData)) {
                this.exe.setVisibility(8);
            } else {
                this.exe.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBn().ag(this.Wt, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cIo.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cIo.setOnDrawListener(null);
        }
    }

    private boolean aXD() {
        return (this.exn == null || this.exn.threadData == null || this.exn.threadData.adN() == null || TextUtils.isEmpty(this.exn.threadData.adN().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.exi.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.exi.stop();
    }

    public void onResume() {
        if (this.exi.oW()) {
            this.exi.resume();
        }
    }
}
