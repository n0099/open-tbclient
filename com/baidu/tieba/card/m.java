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
    private QuickVideoView TF;
    private int UI;
    private String YB;
    private Animation aff;
    private String bNo;
    private final View.OnClickListener bRC;
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
    private com.baidu.tieba.j.k ehA;
    private com.baidu.tieba.card.data.l ehB;
    private int ehC;
    private boolean ehD;
    private boolean ehE;
    private boolean ehF;
    private TextView ehG;
    private boolean ehH;
    private TextView ehI;
    private Handler ehJ;
    private VideoLoadingProgressView.a ehK;
    private CustomMessageListener ehL;
    private final View.OnClickListener ehM;
    private final View.OnClickListener ehN;
    private CustomMessageListener ehO;
    private j.a ehP;
    private Animation.AnimationListener ehQ;
    private View ehr;
    private com.baidu.afd.videopaster.d ehv;
    public ThreadGodReplyLayout ehw;
    private HeadPendantClickableView ehx;
    private com.baidu.tieba.play.g ehy;
    private LinearLayout ehz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        if (this.ehy != null && this.ehD) {
            try {
                this.TF.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!this.ehy.isPlayerReuse()) {
                int AS = com.baidu.tieba.play.y.bTR().AS(this.bNo);
                if (AS <= 100 || this.ehy.getDuration() <= AS) {
                    AS = 100;
                }
                this.UI = AS;
            } else {
                this.UI = 100;
            }
            this.ehJ.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.ehB != null && this.ehB.cZD != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.ehB.sourceType == 0 ? "index" : "hot_juhe";
            zVar.ctx = this.ehB.cZD.getTid();
            zVar.ekN = this.ehB.cZD.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.ehB.cZD.mRecomSource;
            zVar.hYy = this.ehB.cZD.mRecomAbTag;
            zVar.hYz = this.ehB.cZD.mRecomWeight;
            zVar.hYA = "";
            zVar.byE = this.ehB.getExtra();
            if (this.ehB.cZD.Zf() != null) {
                zVar.hYC = this.ehB.cZD.Zf().video_md5;
            }
            com.baidu.tieba.play.l.a(this.ehB.cZD.Zf().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dqK = null;
        this.mSkinType = 3;
        this.ehC = 0;
        this.cAn = 1;
        this.ehD = false;
        this.ehE = true;
        this.ehF = false;
        this.UI = 100;
        this.ehH = false;
        this.ehJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                m.this.ehy = gVar;
                if (m.this.ehy != null) {
                    m.this.ehy.setVolume(0.0f, 0.0f);
                }
                m.this.ehA.bEy();
                m.this.aQl();
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    m.this.i(false, 3);
                }
                return false;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.ehv.a(false, false, "NEWINDEX")) {
                    m.this.TF.start();
                }
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.i(true, 4);
                m.this.ehD = false;
                return true;
            }
        };
        this.ehK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.aQl();
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
                if (m.this.TF != null && !m.this.TF.isPlaying()) {
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
        this.ehL = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.ehB != null && m.this.ehB.cZD != null && videoId.equals(m.this.ehB.cZD.getId())) {
                        m.this.ehv.a(m.this.a(m.this.ehB, bVar));
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
        this.ehM = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehB == null) {
                    if (m.this.aQf() != null) {
                        m.this.aQf().a(view, m.this.ehB);
                        return;
                    }
                    return;
                }
                if (view == m.this.dqy.getUserName()) {
                    m.this.ehB.objType = 3;
                } else if (view == m.this.dqy.getHeaderImg()) {
                    m.this.ehB.objType = 4;
                } else {
                    m.this.ehB.objType = 1;
                }
                if (m.this.aQf() != null) {
                    m.this.aQf().a(view, m.this.ehB);
                }
            }
        };
        this.ehN = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehB != null) {
                    m.this.ehB.objType = 4;
                }
                if (m.this.aQf() != null) {
                    m.this.aQf().a(view, m.this.ehB);
                }
            }
        };
        this.ehO = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.ehF = false;
                }
            }
        };
        this.bRC = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ehB != null) {
                    if (m.this.aQf() != null) {
                        m.this.aQf().a(view, m.this.ehB);
                    }
                    if (m.this.ehB.cZD != null && view != m.this.dro.bST) {
                        n.tz(m.this.ehB.cZD.getId());
                        if (!m.this.aQp()) {
                            n.a(m.this.mTextTitle, m.this.ehB.cZD.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                            n.a(m.this.ehw.getGodReplyContent(), m.this.ehB.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.ehP = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                if (m.this.ehB != null && m.this.ehB.cZD != null && m.this.ehB.cZD.Zf() != null) {
                    m.this.aQm();
                }
            }
        };
        this.ehQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
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
        this.ehx = (HeadPendantClickableView) this.dqx.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehx.getHeadView() != null) {
            this.ehx.getHeadView().setIsRound(true);
            this.ehx.getHeadView().setDrawBorder(false);
            this.ehx.getHeadView().setDefaultResource(17170445);
            this.ehx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehx.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehx.setHasPendantStyle();
        if (this.ehx.getPendantView() != null) {
            this.ehx.getPendantView().setIsRound(true);
            this.ehx.getPendantView().setDrawBorder(false);
        }
        this.cAk = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.ehK);
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
        this.dqz.setForumAfterClickListener(this.bRC);
        this.dqz.setFrom(1);
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.dro.bTC.setOnClickListener(this);
        this.dro.setFrom(1);
        this.dro.setShareReportFrom(3);
        this.dro.setForumAfterClickListener(this.bRC);
        this.ehr = view.findViewById(d.g.divider_below_reply_number_layout);
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
        this.cAg.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.cAg.setBorderSurroundContent(true);
        this.cAg.setDrawBorder(true);
        this.cAh = (ImageView) view.findViewById(d.g.image_video_play);
        this.dqx.setOnClickListener(this);
        this.TF = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.dbi = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.TF.setPlayerReuseEnable(true);
        this.TF.setContinuePlayEnable(true);
        this.TF.setBusiness(this.dbi);
        this.TF.setOnPreparedListener(this.cJJ);
        this.TF.setOnOutInfoListener(this.cJL);
        this.TF.setOnCompletionListener(this.cJI);
        this.TF.setOnErrorListener(this.cAp);
        this.TF.setOnSurfaceDestroyedListener(this.cAt);
        this.dbh = new com.baidu.tieba.play.j();
        this.dbh.setPlayer(this.TF);
        this.dbh.a(this.ehP);
        this.cAf = (TextView) view.findViewById(d.g.text_video_duration);
        this.ehz = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cAm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cAl = view.findViewById(d.g.auto_video_black_mask);
        this.cAi = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAj = view.findViewById(d.g.auto_video_error_background);
        this.drz = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.aff = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.aff.setAnimationListener(this.ehQ);
        this.ehw = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehw.setOnClickListener(this);
        this.cKN = view.findViewById(d.g.divider_line);
        this.ehG = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.TF.setOnClickListener(this);
        this.ehI = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehA = new com.baidu.tieba.j.k();
        this.ehv = new com.baidu.afd.videopaster.d(getContext(), this.cAe);
        this.ehv.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void qs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qr() {
                if (!m.this.ehH) {
                    m.this.TF.start();
                } else {
                    m.this.startPlay();
                }
                m.this.ehH = false;
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
        if (this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.bDx > 0) {
            if (aQf() != null) {
                aQf().a(view, this.ehB);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.ehB.cZD.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.YB(), this.ehB.WR())));
            return;
        }
        if (view == this.dqx || view == this.ehw) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.TF) {
            if (this.ehB != null) {
                this.ehB.objType = 5;
            }
            if (this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.Zf() != null) {
                z = this.ehB.cZD.Zf().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(this.TF);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                by(this.TF);
            } else {
                bz(getView());
            }
        }
    }

    private void bx(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehB);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void by(View view) {
        if (aQf() != null) {
            aQf().a(view, this.ehB);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQo();
        }
    }

    private void aQn() {
        if (this.ehB != null && this.ehB.cZD != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ehB.cZD);
            videoItemData.mRecomExtra = this.ehB.getExtra();
            videoItemData.mRecomAbTag = this.ehB.aQO();
            videoItemData.mRecomSource = this.ehB.getSource();
            videoItemData.mRecomWeight = this.ehB.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.ehB.WR(), "index")));
        }
    }

    private void aQo() {
        if (this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ehB.cZD);
            videoSerializeVideoThreadInfo.source = this.ehB.getSource();
            videoSerializeVideoThreadInfo.extra = this.ehB.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.ehB.aQO();
            videoSerializeVideoThreadInfo.weight = this.ehB.getWeight();
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.ehB.cZD.getTid(), n.YB(), this.ehB.WR(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bz(View view) {
        if (this.ehB != null) {
            this.ehB.objType = 1;
        }
        if (aQf() != null) {
            aQf().a(view, this.ehB);
        }
        if (this.ehB != null && this.ehB.cZD != null) {
            if (!aQp()) {
                n.tz(this.ehB.cZD.getId());
                n.a(this.mTextTitle, this.ehB.cZD.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.ehB.cZD, null, n.YB(), 18003, true, false, false).addLocateParam(this.ehB.WR());
            addLocateParam.setVideo_source(this.ehB.sourceType == 0 ? "index" : "hot_juhe");
            if (this.ehB.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.ehB.cZD.getFid()));
            addLocateParam.setForumName(this.ehB.cZD.YT());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ehw) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQp() {
        return this.ehB.elv && !this.ehB.elD;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.ehB = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        this.ehJ.removeMessages(202);
        if (this.TF.getCurrentPosition() > this.UI) {
            i(false, 3);
            this.ehJ.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.ehJ.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQr() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ehJ.removeMessages(203);
        int currentPosition = this.TF.getCurrentPosition();
        if (currentPosition != this.ehC) {
            this.ehC = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.ehJ.sendEmptyMessageDelayed(203, 3000L);
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
                    this.aff.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.ehz.setVisibility(0);
                    this.ehG.setVisibility(8);
                    this.cAk.startLoading();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAs, 60000L);
                } else if (i == 3) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aff);
                    this.cAl.setVisibility(8);
                    this.ehz.setVisibility(8);
                    if (this.ehB != null && this.ehB.WO() != null && this.ehB.WO().bDx > 0) {
                        this.ehG.setVisibility(0);
                    }
                    this.cAk.bTM();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    if (this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.Zf() != null) {
                        this.ehA.a(this.ehB.cZD.getTid(), this.ehB.cZD.Zf().video_length.intValue(), this.ehB.cZD.Zf().video_duration.intValue(), "homepage", this.TF);
                    }
                } else if (i == 4) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aff);
                    this.cAl.setVisibility(8);
                    this.cAk.bTN();
                    this.cAj.setVisibility(0);
                    this.cAi.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAr, 2000L);
                } else {
                    this.cAh.setVisibility(0);
                    this.aff.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.ehz.setVisibility(0);
                    this.cAk.bTN();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                }
                if (this.ehB != null && this.ehB.WO() != null && this.ehB.WO().bDx > 0) {
                    this.ehz.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ehB == null || this.ehB.cZD == null || this.ehB.cZD.YO() == null) {
            this.dqx.setVisibility(8);
            return;
        }
        this.dqx.setVisibility(0);
        aQt();
        if (!aQp() && n.tA(this.ehB.cZD.getId())) {
            n.a(this.mTextTitle, this.ehB.cZD.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.ehw.getGodReplyContent(), this.ehB.WO().getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        this.ehB.WO().ZE();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ehB.WO().Zu());
        if (this.ehB.WO().ZB() && !StringUtils.isNull(this.ehB.WO().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ehB.WO().getTid();
            spannableStringBuilder.append((CharSequence) this.ehB.WO().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
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
        this.dqy.setData(this.ehB.WO());
        this.dqy.setUserAfterClickListener(this.ehM);
        if (this.dqy.getHeaderImg() != null) {
            this.dqy.getHeaderImg().setAfterClickListener(this.ehN);
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehx.setVisibility(8);
            } else if (this.ehB.WO() == null || this.ehB.WO().YO() == null || this.ehB.WO().YO().getPendantData() == null || StringUtils.isNull(this.ehB.WO().YO().getPendantData().Xk())) {
                this.ehx.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                if (this.ehB.WO().bDx > 0 && this.ehB.WO().bDy == 0) {
                    this.ehB.WO().YO().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dqy.getHeaderImg().setData(this.ehB.WO(), false);
                } else {
                    this.dqy.getHeaderImg().setData(this.ehB.WO());
                    this.dqy.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehx.setVisibility(0);
                this.ehx.setData(this.ehB.WO());
            }
        }
        this.cAf.setText(ap.hy(this.ehB.cZD.Zf().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.ehB.cZD.Zf().play_count.intValue())));
        if (this.dqK != null && this.ehB.WO() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.ehB.WO().getTid());
            ajVar.setFid(this.ehB.WO().getFid());
            ajVar.b(this.ehB.bzy);
            this.dqK.setData(ajVar);
            this.dqK.setFirstRowSingleColumn(true);
            this.dqK.setVisibility(this.ehE ? 0 : 8);
        }
        this.ehw.setData(this.ehB.WO().aam());
        mE(ls(1));
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (n.tA(this.ehB.cZD.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        if (this.ehB == null || this.ehB.cZD == null || this.ehB.cZD.Zf() == null) {
            z = false;
        } else {
            z = this.ehB.cZD.Zf().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehI.setVisibility(0);
            if (aQu()) {
                this.ehI.setText(String.format("%s | %s", this.mContext.getResources().getString(d.j.nani_video), this.mContext.getResources().getString(d.j.video_preview)));
            } else {
                this.ehI.setText(this.mContext.getString(d.j.nani_video));
            }
        } else if (aQu()) {
            this.ehI.setVisibility(0);
            this.ehI.setText(this.mContext.getString(d.j.video_preview));
        } else {
            this.ehI.setVisibility(8);
        }
    }

    private void aQs() {
        this.ehJ.removeMessages(202);
        this.ehJ.removeMessages(203);
    }

    private void asa() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
    }

    private void aQt() {
        asa();
        aQs();
        if (this.cAg != null && this.cAe != null && this.TF != null) {
            if (com.baidu.tbadk.core.i.Wv().Wz() && this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.Zf() != null) {
                this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAg.startLoad(this.ehB.cZD.Zf().thumbnail_url, 10, false);
                this.cAe.setVisibility(0);
                stopPlay();
                this.bNo = this.ehB.cZD.Zf().video_url;
                if (aQu()) {
                    this.bNo = this.ehB.cZD.Zg().video_url;
                }
                if (StringUtils.isNull(this.ehB.cZD.Zf().video_url)) {
                    i(true, 4);
                }
                if (this.dbi != null && this.dbi.bTv() != null) {
                    this.dbi.bTv().g(this.ehB.cZD.Zf());
                }
                this.TF.dF(this.bNo, this.ehB.tid);
            } else {
                this.cAe.setVisibility(8);
            }
            this.ehv.reset();
            this.dbh.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehv.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehB);
                    }
                }
            });
            this.dbi.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void aW(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ehv.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ehB);
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
            al.k(this.dqx, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            al.j(this.cAi, d.C0277d.cp_btn_a);
            al.j(this.cAf, d.C0277d.cp_btn_a);
            al.j(this.cAm, d.C0277d.cp_btn_a);
            al.j(this.ehG, d.C0277d.cp_btn_a);
            al.l(this.cAj, d.C0277d.common_color_10014);
            al.l(this.cKN, d.C0277d.cp_bg_line_e);
            if (this.ehI != null) {
                al.j(this.ehI, d.C0277d.cp_btn_a);
                al.k(this.ehI, d.f.video_play_count_bg);
            }
            if (this.cAi != null) {
                this.cAi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ehw.onChangeSkinType();
            if (this.dqK != null) {
                this.dqK.onChangeSkinType();
            }
            this.dqy.onChangeSkinType();
            this.dqz.onChangeSkinType();
            this.dro.onChangeSkinType();
            this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.ehx.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ehO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ehO);
            this.ehL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ehL);
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
        return this.ehD;
    }

    public boolean isPlaying() {
        if (this.TF == null) {
            return false;
        }
        return this.TF.isPlaying();
    }

    public void startPlay() {
        if (!this.ehD && this.ehB != null && this.ehB.cZD != null && this.ehB.cZD.Zf() != null && this.TF != null) {
            if (this.ehv.qb()) {
                this.ehv.resume();
                this.ehH = true;
                return;
            }
            this.ehH = false;
            this.TF.stopPlayback();
            if (ad.H(1, this.bNo)) {
                this.ehA.bEx();
                i(true, 2);
                if (StringUtils.isNull(this.bNo)) {
                    TiebaStatic.log(new am("c12619").bJ("obj_locate", "index").bJ("tid", this.ehB.tid));
                    this.bNo = this.ehB.cZD.Zf().video_url;
                }
                this.ehD = true;
                this.TF.setVideoPath(this.bNo, this.ehB.tid);
                if (this.dbh != null) {
                    this.dbh.start();
                }
                aQm();
            }
        }
    }

    public void stopPlay() {
        this.ehH = false;
        asa();
        aQs();
        i(true, 1);
        if (this.TF != null) {
            this.TF.stopPlayback();
            if (this.dbh != null) {
                this.dbh.stop();
            }
        }
        this.ehD = false;
        this.ehv.stop();
    }

    public View getVideoContainer() {
        return this.cAe;
    }

    public String getPlayUrl() {
        return this.bNo;
    }

    public int getCurrentPosition() {
        if (this.TF == null) {
            return 0;
        }
        return this.TF.getCurrentPosition();
    }

    public void hK(boolean z) {
        this.ehE = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void mE(int i) {
        if (this.ehB != null && this.ehB.cZD != null) {
            if (i == 1) {
                if (this.ehB.cZD.bDx > 0) {
                    this.dro.bTC.setShowPraiseNum(false);
                    this.dro.bTC.setShareVisible(false);
                    this.ehG.setText(ap.az(this.ehB.cZD.bDx));
                    this.ehG.setVisibility(0);
                } else {
                    this.dro.bTC.setShowPraiseNum(true);
                    this.dro.bTC.setShareVisible(true);
                    this.ehG.setVisibility(8);
                }
                this.dro.setData(this.ehB.cZD);
                this.dqz.setVisibility(8);
                this.dqy.dN(false);
                return;
            }
            this.dro.setVisibility(8);
            this.dqy.dN(true);
            if (this.ehB.cZD.bDx > 0) {
                this.dqz.setShowPraiseNum(false);
                this.dqz.setShareVisible(false);
                this.ehG.setText(ap.az(this.ehB.cZD.bDx));
                this.ehG.setVisibility(0);
            } else {
                this.dqz.setShowPraiseNum(true);
                this.dqz.setShareVisible(true);
                this.ehG.setVisibility(8);
            }
            if (this.dqz.setData(this.ehB.cZD)) {
                this.ehr.setVisibility(8);
            } else {
                this.ehr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
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

    private boolean aQu() {
        return (this.ehB == null || this.ehB.cZD == null || this.ehB.cZD.Zg() == null || TextUtils.isEmpty(this.ehB.cZD.Zg().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.ehv.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.ehv.stop();
    }

    public void onResume() {
        if (this.ehv.qb()) {
            this.ehv.resume();
        }
    }
}
