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
import com.baidu.tieba.a.e;
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
public class m extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, e {
    private QuickVideoView TC;
    private int UG;
    private String Yz;
    private Animation aeY;
    private String bNk;
    private final View.OnClickListener bRy;
    public FrameLayout cAe;
    private TextView cAf;
    private TbImageView cAg;
    private ImageView cAh;
    private TextView cAi;
    private View cAj;
    private com.baidu.tieba.play.x cAk;
    private View cAl;
    private TextView cAm;
    private int cAn;
    private TbImageView.a cAo;
    private g.b cAp;
    private Runnable cAr;
    private Runnable cAs;
    private QuickVideoView.b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.e cJL;
    private View cKN;
    private com.baidu.tieba.play.j dbh;
    private com.baidu.tieba.play.n dbi;
    private NEGFeedBackView dqK;
    private RelativeLayout dqx;
    public ThreadUserInfoLayout dqy;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    protected LinearLayout drz;
    private View ehI;
    private d ehM;
    public ThreadGodReplyLayout ehN;
    private HeadPendantClickableView ehO;
    private g ehP;
    private LinearLayout ehQ;
    private com.baidu.tieba.j.k ehR;
    private com.baidu.tieba.card.data.l ehS;
    private int ehT;
    private boolean ehU;
    private boolean ehV;
    private boolean ehW;
    private TextView ehX;
    private boolean ehY;
    private TextView ehZ;
    private Handler eia;
    private VideoLoadingProgressView.a eib;
    private CustomMessageListener eic;
    private final View.OnClickListener eid;
    private final View.OnClickListener eie;
    private CustomMessageListener eif;
    private j.a eig;
    private Animation.AnimationListener eih;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aQn() {
        if (this.ehP != null && this.ehU) {
            try {
                this.TC.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.ehP.isPlayerReuse()) {
                int AU = com.baidu.tieba.play.y.bTS().AU(this.bNk);
                if (AU <= 100 || this.ehP.getDuration() <= AU) {
                    AU = 100;
                }
                this.UG = AU;
            } else {
                this.UG = 100;
            }
            this.eia.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.ehS != null && this.ehS.cZD != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.ehS.sourceType == 0 ? "index" : "hot_juhe";
            zVar.ctx = this.ehS.cZD.getTid();
            zVar.ele = this.ehS.cZD.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.ehS.cZD.mRecomSource;
            zVar.hYQ = this.ehS.cZD.mRecomAbTag;
            zVar.hYR = this.ehS.cZD.mRecomWeight;
            zVar.hYS = "";
            zVar.byy = this.ehS.getExtra();
            if (this.ehS.cZD.Zi() != null) {
                zVar.hYU = this.ehS.cZD.Zi().video_md5;
            }
            com.baidu.tieba.play.l.a(this.ehS.cZD.Zi().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqK = null;
        this.mSkinType = 3;
        this.ehT = 0;
        this.cAn = 1;
        this.ehU = false;
        this.ehV = true;
        this.ehW = false;
        this.UG = 100;
        this.ehY = false;
        this.eia = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                m.this.ehP = gVar;
                if (m.this.ehP != null) {
                    m.this.ehP.setVolume(0.0f, 0.0f);
                }
                m.this.ehR.bEB();
                m.this.aQn();
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                if (!m.this.ehM.a(false, false, "NEWINDEX")) {
                    m.this.TC.start();
                }
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.ehU = false;
                return true;
            }
        };
        this.eib = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aQn();
            }
        };
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && m.this.cAg != null) {
                    m.this.cAg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.TC != null && !m.this.TC.isPlaying()) {
                    m.this.i(true, 1);
                }
            }
        };
        this.cAs = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.i(true, 4);
            }
        };
        this.eic = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.ehS != null && m.this.ehS.cZD != null && videoId.equals(m.this.ehS.cZD.getId())) {
                        m.this.ehM.a(m.this.a(m.this.ehS, bVar));
                    }
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.eid = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehS == null) {
                    if (m.this.aQh() != null) {
                        m.this.aQh().a(view, m.this.ehS);
                        return;
                    }
                    return;
                }
                if (view == m.this.dqy.getUserName()) {
                    m.this.ehS.objType = 3;
                } else if (view == m.this.dqy.getHeaderImg()) {
                    m.this.ehS.objType = 4;
                } else {
                    m.this.ehS.objType = 1;
                }
                if (m.this.aQh() != null) {
                    m.this.aQh().a(view, m.this.ehS);
                }
            }
        };
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehS != null) {
                    m.this.ehS.objType = 4;
                }
                if (m.this.aQh() != null) {
                    m.this.aQh().a(view, m.this.ehS);
                }
            }
        };
        this.eif = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.ehW = false;
                }
            }
        };
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehS != null) {
                    if (m.this.aQh() != null) {
                        m.this.aQh().a(view, m.this.ehS);
                    }
                    if (m.this.ehS.cZD != null && view != m.this.dro.bSP) {
                        n.tB(m.this.ehS.cZD.getId());
                        if (!m.this.aQr()) {
                            n.a(m.this.mTextTitle, m.this.ehS.cZD.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                            n.a(m.this.ehN.getGodReplyContent(), m.this.ehS.WR().getId(), d.C0236d.cp_cont_f, d.C0236d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.eig = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                if (m.this.ehS != null && m.this.ehS.cZD != null && m.this.ehS.cZD.Zi() != null) {
                    m.this.aQo();
                }
            }
        };
        this.eih = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cAg != null) {
                    m.this.cAg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.dqx = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ehO = (HeadPendantClickableView) this.dqx.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehO.getHeadView() != null) {
            this.ehO.getHeadView().setIsRound(true);
            this.ehO.getHeadView().setDrawBorder(false);
            this.ehO.getHeadView().setDefaultResource(17170445);
            this.ehO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehO.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehO.setHasPendantStyle();
        if (this.ehO.getPendantView() != null) {
            this.ehO.getPendantView().setIsRound(true);
            this.ehO.getPendantView().setDrawBorder(false);
        }
        this.cAk = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.eib);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.dqK = new NEGFeedBackView(getTbPageContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16);
        this.dqK.a(this.dqx, h, 0);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.setShareReportFrom(3);
        this.dqz.setForumAfterClickListener(this.bRy);
        this.dqz.setFrom(1);
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.dro.bTy.setOnClickListener(this);
        this.dro.setFrom(1);
        this.dro.setShareReportFrom(3);
        this.dro.setForumAfterClickListener(this.bRy);
        this.ehI = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cAe = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cAe.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.aO(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cAe.setLayoutParams(layoutParams2);
        this.cAg = (TbImageView) view.findViewById(d.g.image_video);
        this.cAg.setDefaultErrorResource(0);
        this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAg.setGifIconSupport(false);
        this.cAg.setEvent(this.cAo);
        this.cAg.setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds20));
        TbImageView tbImageView = this.cAg;
        TbImageView tbImageView2 = this.cAg;
        tbImageView.setConrers(15);
        this.cAg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.cAg.setBorderColor(al.getColor(d.C0236d.black_alpha8));
        this.cAg.setBorderSurroundContent(true);
        this.cAg.setDrawBorder(true);
        this.cAh = (ImageView) view.findViewById(d.g.image_video_play);
        this.dqx.setOnClickListener(this);
        this.TC = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.dbi = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.TC.setPlayerReuseEnable(true);
        this.TC.setContinuePlayEnable(true);
        this.TC.setBusiness(this.dbi);
        this.TC.setOnPreparedListener(this.cJJ);
        this.TC.setOnOutInfoListener(this.cJL);
        this.TC.setOnCompletionListener(this.cJI);
        this.TC.setOnErrorListener(this.cAp);
        this.TC.setOnSurfaceDestroyedListener(this.cAt);
        this.dbh = new com.baidu.tieba.play.j();
        this.dbh.setPlayer(this.TC);
        this.dbh.a(this.eig);
        this.cAf = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehQ = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cAl = view.findViewById(d.g.auto_video_black_mask);
        this.cAi = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAj = view.findViewById(d.g.auto_video_error_background);
        this.drz = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.aeY = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.aeY.setAnimationListener(this.eih);
        this.ehN = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehN.setOnClickListener(this);
        this.cKN = view.findViewById(d.g.divider_line);
        this.ehX = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.TC.setOnClickListener(this);
        this.ehZ = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehR = new com.baidu.tieba.j.k();
        this.ehM = new com.baidu.afd.videopaster.d(getContext(), this.cAe);
        this.ehM.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void qs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qr() {
                if (!m.this.ehY) {
                    m.this.TC.start();
                } else {
                    m.this.startPlay();
                }
                m.this.ehY = false;
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
        if (this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.bDr > 0) {
            if (aQh() != null) {
                aQh().a(view, this.ehS);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.ehS.cZD.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.YE(), this.ehS.WU())));
            return;
        }
        if (view == this.dqx || view == this.ehN) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.TC) {
            if (this.ehS != null) {
                this.ehS.objType = 5;
            }
            if (this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.Zi() != null) {
                z = this.ehS.cZD.Zi().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(this.TC);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                by(this.TC);
            } else {
                bz(getView());
            }
        }
    }

    private void bx(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehS);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQp();
        }
    }

    private void by(View view) {
        if (aQh() != null) {
            aQh().a(view, this.ehS);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQq();
        }
    }

    private void aQp() {
        if (this.ehS != null && this.ehS.cZD != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehS.cZD);
            videoItemData.mRecomExtra = this.ehS.getExtra();
            videoItemData.mRecomAbTag = this.ehS.aQQ();
            videoItemData.mRecomSource = this.ehS.getSource();
            videoItemData.mRecomWeight = this.ehS.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.ehS.WU(), "index")));
        }
    }

    private void aQq() {
        if (this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehS.cZD);
            videoSerializeVideoThreadInfo.source = this.ehS.getSource();
            videoSerializeVideoThreadInfo.extra = this.ehS.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.ehS.aQQ();
            videoSerializeVideoThreadInfo.weight = this.ehS.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.drz.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.drz.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ap.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.ehS.cZD.getTid(), n.YE(), this.ehS.WU(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bz(View view) {
        if (this.ehS != null) {
            this.ehS.objType = 1;
        }
        if (aQh() != null) {
            aQh().a(view, this.ehS);
        }
        if (this.ehS != null && this.ehS.cZD != null) {
            if (!aQr()) {
                n.tB(this.ehS.cZD.getId());
                n.a(this.mTextTitle, this.ehS.cZD.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehS.cZD, null, n.YE(), 18003, true, false, false).addLocateParam(this.ehS.WU());
            addLocateParam.setVideo_source(this.ehS.sourceType == 0 ? "index" : "hot_juhe");
            if (this.ehS.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.ehS.cZD.getFid()));
            addLocateParam.setForumName(this.ehS.cZD.YW());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehN) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQr() {
        return this.ehS.elM && !this.ehS.elU;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.ehS = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
        this.eia.removeMessages(202);
        if (this.TC.getCurrentPosition() > this.UG) {
            i(false, 3);
            this.eia.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eia.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eia.removeMessages(203);
        int currentPosition = this.TC.getCurrentPosition();
        if (currentPosition != this.ehT) {
            this.ehT = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eia.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cAh != null && this.cAg != null && this.cAl != null && this.cAk != null && this.cAj != null && this.cAi != null) {
            if (z || this.cAn != i) {
                this.cAn = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
                if (i == 2) {
                    this.cAh.setVisibility(8);
                    this.aeY.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.ehQ.setVisibility(0);
                    this.ehX.setVisibility(8);
                    this.cAk.startLoading();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAs, 60000L);
                } else if (i == 3) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aeY);
                    this.cAl.setVisibility(8);
                    this.ehQ.setVisibility(8);
                    if (this.ehS != null && this.ehS.WR() != null && this.ehS.WR().bDr > 0) {
                        this.ehX.setVisibility(0);
                    }
                    this.cAk.bTN();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    if (this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.Zi() != null) {
                        this.ehR.a(this.ehS.cZD.getTid(), this.ehS.cZD.Zi().video_length.intValue(), this.ehS.cZD.Zi().video_duration.intValue(), "homepage", this.TC);
                    }
                } else if (i == 4) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aeY);
                    this.cAl.setVisibility(8);
                    this.cAk.bTO();
                    this.cAj.setVisibility(0);
                    this.cAi.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAr, 2000L);
                } else {
                    this.cAh.setVisibility(0);
                    this.aeY.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.ehQ.setVisibility(0);
                    this.cAk.bTO();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                }
                if (this.ehS != null && this.ehS.WR() != null && this.ehS.WR().bDr > 0) {
                    this.ehQ.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ehS == null || this.ehS.cZD == null || this.ehS.cZD.YR() == null) {
            this.dqx.setVisibility(8);
            return;
        }
        this.dqx.setVisibility(0);
        aQv();
        if (!aQr() && n.tC(this.ehS.cZD.getId())) {
            n.a(this.mTextTitle, this.ehS.cZD.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            n.a(this.ehN.getGodReplyContent(), this.ehS.WR().getId(), d.C0236d.cp_cont_f, d.C0236d.cp_cont_d);
        }
        this.ehS.WR().ZH();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ehS.WR().Zx());
        if (this.ehS.WR().ZE() && !StringUtils.isNull(this.ehS.WR().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehS.WR().getTid();
            spannableStringBuilder.append((CharSequence) this.ehS.WR().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0236d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.dqy.setData(this.ehS.WR());
        this.dqy.setUserAfterClickListener(this.eid);
        if (this.dqy.getHeaderImg() != null) {
            this.dqy.getHeaderImg().setAfterClickListener(this.eie);
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehO.setVisibility(8);
            } else if (this.ehS.WR() == null || this.ehS.WR().YR() == null || this.ehS.WR().YR().getPendantData() == null || StringUtils.isNull(this.ehS.WR().YR().getPendantData().Xn())) {
                this.ehO.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                if (this.ehS.WR().bDr > 0 && this.ehS.WR().bDs == 0) {
                    this.ehS.WR().YR().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dqy.getHeaderImg().setData(this.ehS.WR(), false);
                } else {
                    this.dqy.getHeaderImg().setData(this.ehS.WR());
                    this.dqy.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehO.setVisibility(0);
                this.ehO.setData(this.ehS.WR());
            }
        }
        this.cAf.setText(ap.hz(this.ehS.cZD.Zi().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehS.cZD.Zi().play_count.intValue())));
        if (this.dqK != null && this.ehS.WR() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehS.WR().getTid());
            ajVar.setFid(this.ehS.WR().getFid());
            ajVar.b(this.ehS.bzs);
            this.dqK.setData(ajVar);
            this.dqK.setFirstRowSingleColumn(true);
            this.dqK.setVisibility(this.ehV ? 0 : 8);
        }
        this.ehN.setData(this.ehS.WR().aap());
        mF(lt(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tC(this.ehS.cZD.getId())) {
            al.d(this.mTextTitle, d.C0236d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0236d.cp_cont_b, 1);
        }
        if (this.ehS == null || this.ehS.cZD == null || this.ehS.cZD.Zi() == null) {
            z = false;
        } else {
            z = this.ehS.cZD.Zi().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehZ.setVisibility(0);
            if (aQw()) {
                this.ehZ.setText(String.format("%s | %s", this.mContext.getResources().getString(d.j.nani_video), this.mContext.getResources().getString(d.j.video_preview)));
            } else {
                this.ehZ.setText(this.mContext.getString(d.j.nani_video));
            }
        } else if (aQw()) {
            this.ehZ.setVisibility(0);
            this.ehZ.setText(this.mContext.getString(d.j.video_preview));
        } else {
            this.ehZ.setVisibility(8);
        }
    }

    private void aQu() {
        this.eia.removeMessages(202);
        this.eia.removeMessages(203);
    }

    private void asd() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
    }

    private void aQv() {
        asd();
        aQu();
        if (this.cAg != null && this.cAe != null && this.TC != null) {
            if (com.baidu.tbadk.core.i.Wy().WC() && this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.Zi() != null) {
                this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAg.startLoad(this.ehS.cZD.Zi().thumbnail_url, 10, false);
                this.cAe.setVisibility(0);
                stopPlay();
                this.bNk = this.ehS.cZD.Zi().video_url;
                if (aQw()) {
                    this.bNk = this.ehS.cZD.Zj().video_url;
                }
                if (StringUtils.isNull(this.ehS.cZD.Zi().video_url)) {
                    i(true, 4);
                }
                if (this.dbi != null && this.dbi.bTw() != null) {
                    this.dbi.bTw().g(this.ehS.cZD.Zi());
                }
                this.TC.dE(this.bNk, this.ehS.tid);
            } else {
                this.cAe.setVisibility(8);
            }
            this.ehM.reset();
            this.dbh.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehM.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehS);
                    }
                }
            });
            this.dbi.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehM.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehS);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cZD != null) {
            bg bgVar = lVar.cZD;
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
        if (lVar == null || lVar.cZD == null || bVar == null) {
            return null;
        }
        bg bgVar = lVar.cZD;
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
            al.k(this.dqx, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            al.j(this.cAi, d.C0236d.cp_btn_a);
            al.j(this.cAf, d.C0236d.cp_btn_a);
            al.j(this.cAm, d.C0236d.cp_btn_a);
            al.j(this.ehX, d.C0236d.cp_btn_a);
            al.l(this.cAj, d.C0236d.common_color_10014);
            al.l(this.cKN, d.C0236d.cp_bg_line_e);
            if (this.ehZ != null) {
                al.j(this.ehZ, d.C0236d.cp_btn_a);
                al.k(this.ehZ, d.f.video_play_count_bg);
            }
            if (this.cAi != null) {
                this.cAi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ehN.onChangeSkinType();
            if (this.dqK != null) {
                this.dqK.onChangeSkinType();
            }
            this.dqy.onChangeSkinType();
            this.dqz.onChangeSkinType();
            this.dro.onChangeSkinType();
            this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ehO.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eif.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eif);
            this.eic.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eic);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqy != null) {
            this.dqy.setPageUniqueId(bdUniqueId);
        }
        if (this.cAg != null) {
            this.cAg.setPageId(bdUniqueId);
        }
        if (this.dqK != null) {
            this.dqK.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.ehU;
    }

    public boolean isPlaying() {
        if (this.TC == null) {
            return false;
        }
        return this.TC.isPlaying();
    }

    public void startPlay() {
        if (!this.ehU && this.ehS != null && this.ehS.cZD != null && this.ehS.cZD.Zi() != null && this.TC != null) {
            if (this.ehM.qb()) {
                this.ehM.resume();
                this.ehY = true;
                return;
            }
            this.ehY = false;
            this.TC.stopPlayback();
            if (ad.H(1, this.bNk)) {
                this.ehR.bEA();
                i(true, 2);
                if (StringUtils.isNull(this.bNk)) {
                    TiebaStatic.log(new am("c12619").bJ("obj_locate", "index").bJ("tid", this.ehS.tid));
                    this.bNk = this.ehS.cZD.Zi().video_url;
                }
                this.ehU = true;
                this.TC.setVideoPath(this.bNk, this.ehS.tid);
                if (this.dbh != null) {
                    this.dbh.start();
                }
                aQo();
            }
        }
    }

    public void stopPlay() {
        this.ehY = false;
        asd();
        aQu();
        i(true, 1);
        if (this.TC != null) {
            this.TC.stopPlayback();
            if (this.dbh != null) {
                this.dbh.stop();
            }
        }
        this.ehU = false;
        this.ehM.stop();
    }

    public View getVideoContainer() {
        return this.cAe;
    }

    public String getPlayUrl() {
        return this.bNk;
    }

    public int getCurrentPosition() {
        if (this.TC == null) {
            return 0;
        }
        return this.TC.getCurrentPosition();
    }

    public void hK(boolean z) {
        this.ehV = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void mF(int i) {
        if (this.ehS != null && this.ehS.cZD != null) {
            if (i == 1) {
                if (this.ehS.cZD.bDr > 0) {
                    this.dro.bTy.setShowPraiseNum(false);
                    this.dro.bTy.setShareVisible(false);
                    this.ehX.setText(ap.az(this.ehS.cZD.bDr));
                    this.ehX.setVisibility(0);
                } else {
                    this.dro.bTy.setShowPraiseNum(true);
                    this.dro.bTy.setShareVisible(true);
                    this.ehX.setVisibility(8);
                }
                this.dro.setData(this.ehS.cZD);
                this.dqz.setVisibility(8);
                this.dqy.dN(false);
                return;
            }
            this.dro.setVisibility(8);
            this.dqy.dN(true);
            if (this.ehS.cZD.bDr > 0) {
                this.dqz.setShowPraiseNum(false);
                this.dqz.setShareVisible(false);
                this.ehX.setText(ap.az(this.ehS.cZD.bDr));
                this.ehX.setVisibility(0);
            } else {
                this.dqz.setShowPraiseNum(true);
                this.dqz.setShareVisible(true);
                this.ehX.setVisibility(8);
            }
            if (this.dqz.setData(this.ehS.cZD)) {
                this.ehI.setVisibility(8);
            } else {
                this.ehI.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.Yz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAg.setOnDrawListener(null);
        }
    }

    private boolean aQw() {
        return (this.ehS == null || this.ehS.cZD == null || this.ehS.cZD.Zj() == null || TextUtils.isEmpty(this.ehS.cZD.Zj().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.ehM.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.ehM.stop();
    }

    public void onResume() {
        if (this.ehM.qb()) {
            this.ehM.resume();
        }
    }
}
