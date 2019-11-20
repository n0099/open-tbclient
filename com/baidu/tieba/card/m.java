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
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private int BE;
    private String Gc;
    private Animation ayO;
    private Runnable cTA;
    private Runnable cTB;
    private QuickVideoView.b cTC;
    public FrameLayout cTn;
    private TextView cTo;
    private TbImageView cTp;
    private ImageView cTq;
    private TextView cTr;
    private View cTs;
    private com.baidu.tieba.play.x cTt;
    private View cTu;
    private TextView cTv;
    private int cTw;
    private TbImageView.a cTx;
    private g.b cTy;
    private TbPageContext<?> ceu;
    private String cln;
    private final View.OnClickListener coV;
    public ThreadCommentAndPraiseInfoLayout dSA;
    private NEGFeedBackView dSM;
    private RelativeLayout dSy;
    public ThreadUserInfoLayout dSz;
    public ThreadSourceShareAndPraiseLayout dTo;
    protected LinearLayout dTz;
    private g.a dcS;
    private g.f dcT;
    private g.e dcV;
    private View ddZ;
    private com.baidu.tieba.play.j dvH;
    private com.baidu.tieba.play.n dvI;
    private View eLK;
    private com.baidu.afd.videopaster.d eLO;
    public ThreadGodReplyLayout eLP;
    private HeadPendantClickableView eLQ;
    private com.baidu.tieba.play.a.a eLR;
    private LinearLayout eLS;
    private com.baidu.tieba.card.data.l eLT;
    private int eLU;
    private boolean eLV;
    private boolean eLW;
    private boolean eLX;
    private TextView eLY;
    private boolean eLZ;
    private TextView eMa;
    private Handler eMb;
    private VideoLoadingProgressView.a eMc;
    private CustomMessageListener eMd;
    private final View.OnClickListener eMe;
    private final View.OnClickListener eMf;
    private CustomMessageListener eMg;
    private j.a eMh;
    private Animation.AnimationListener eMi;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.eLR != null && this.eLV) {
            try {
                this.eLR.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int BS = com.baidu.tieba.play.y.ccR().BS(this.cln);
            if (BS <= 100 || this.eLR.getDuration() <= BS) {
                BS = 100;
            }
            this.BE = BS;
            this.eMb.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bac() {
        if (this.eLT != null && this.eLT.caz != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.eLT.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            zVar.cma = this.eLT.caz.getTid();
            zVar.ePc = this.eLT.caz.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.eLT.caz.mRecomSource;
            zVar.iyj = this.eLT.caz.mRecomAbTag;
            zVar.iyk = this.eLT.caz.mRecomWeight;
            zVar.iyl = "";
            zVar.bYk = this.eLT.getExtra();
            if (this.eLT.caz.aiV() != null) {
                zVar.iyn = this.eLT.caz.aiV().video_md5;
            }
            com.baidu.tieba.play.l.a(this.eLT.caz.aiV().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dSM = null;
        this.mSkinType = 3;
        this.eLU = 0;
        this.cTw = 1;
        this.eLV = false;
        this.eLW = true;
        this.eLX = false;
        this.BE = 100;
        this.eLZ = false;
        this.isNewPlayer = false;
        this.eMb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.bag();
                        return;
                    case 203:
                        m.this.bah();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (m.this.eLR != null) {
                    m.this.eLR.setVolume(0.0f, 0.0f);
                }
                m.this.bab();
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    m.this.j(false, 3);
                }
                return false;
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.eLO.a(false, false, "NEWINDEX")) {
                    m.this.eLR.start();
                }
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.j(true, 4);
                m.this.eLV = false;
                return true;
            }
        };
        this.eMc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.bab();
            }
        };
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && m.this.cTp != null) {
                    m.this.cTp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cTA = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.eLR != null && !m.this.eLR.isPlaying()) {
                    m.this.j(true, 1);
                }
            }
        };
        this.cTB = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.j(true, 4);
            }
        };
        this.eMd = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.eLT != null && m.this.eLT.caz != null && videoId.equals(m.this.eLT.caz.getId())) {
                        m.this.eLO.a(m.this.a(m.this.eLT, bVar));
                    }
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.eMe = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eLT == null) {
                    if (m.this.aZV() != null) {
                        m.this.aZV().a(view, m.this.eLT);
                        return;
                    }
                    return;
                }
                if (view == m.this.dSz.getUserName()) {
                    m.this.eLT.objType = 3;
                } else if (view == m.this.dSz.getHeaderImg()) {
                    m.this.eLT.objType = 4;
                } else {
                    m.this.eLT.objType = 1;
                }
                if (m.this.aZV() != null) {
                    m.this.aZV().a(view, m.this.eLT);
                }
            }
        };
        this.eMf = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eLT != null) {
                    m.this.eLT.objType = 4;
                }
                if (m.this.aZV() != null) {
                    m.this.aZV().a(view, m.this.eLT);
                }
            }
        };
        this.eMg = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.eLX = false;
                }
            }
        };
        this.coV = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eLT != null) {
                    if (m.this.aZV() != null) {
                        m.this.aZV().a(view, m.this.eLT);
                    }
                    if (m.this.eLT.caz != null && view != m.this.dTo.cql) {
                        n.uz(m.this.eLT.caz.getId());
                        if (!m.this.baf()) {
                            n.a(m.this.mTextTitle, m.this.eLT.caz.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            n.a(m.this.eLP.getGodReplyContent(), m.this.eLT.agG().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.eMh = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void kP() {
                if (m.this.eLT != null && m.this.eLT.caz != null && m.this.eLT.caz.aiV() != null) {
                    m.this.bac();
                }
            }
        };
        this.eMi = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cTp != null) {
                    m.this.cTp.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ceu = tbPageContext;
        View view = getView();
        this.dSy = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eLQ = (HeadPendantClickableView) this.dSy.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eLQ.getHeadView() != null) {
            this.eLQ.getHeadView().setIsRound(true);
            this.eLQ.getHeadView().setDrawBorder(false);
            this.eLQ.getHeadView().setDefaultResource(17170445);
            this.eLQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eLQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.ds70));
        }
        this.eLQ.setHasPendantStyle();
        if (this.eLQ.getPendantView() != null) {
            this.eLQ.getPendantView().setIsRound(true);
            this.eLQ.getPendantView().setDrawBorder(false);
        }
        this.cTt = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cTt.setLoadingAnimationListener(this.eMc);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dSz = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dSM = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.dSM.a(this.dSy, dimens, 0);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dSA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dSA.setLayoutParams(layoutParams);
        }
        this.dSA.setOnClickListener(this);
        this.dSA.setReplyTimeVisible(false);
        this.dSA.setShowPraiseNum(true);
        this.dSA.setNeedAddPraiseIcon(true);
        this.dSA.setNeedAddReplyIcon(true);
        this.dSA.setShareVisible(true);
        this.dSA.setShareReportFrom(3);
        this.dSA.setForumAfterClickListener(this.coV);
        this.dSA.setFrom(1);
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dTo.cqW.setOnClickListener(this);
        this.dTo.setFrom(1);
        this.dTo.setShareReportFrom(3);
        this.dTo.setForumAfterClickListener(this.coV);
        this.eLK = view.findViewById(R.id.divider_below_reply_number_layout);
        this.cTn = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cTn.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ceu.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cTn.setLayoutParams(layoutParams2);
        this.cTp = (TbImageView) view.findViewById(R.id.image_video);
        this.cTp.setDefaultErrorResource(0);
        this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        this.cTp.setGifIconSupport(false);
        this.cTp.setEvent(this.cTx);
        this.cTp.setRadius(com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cTp;
        TbImageView tbImageView2 = this.cTp;
        tbImageView.setConrers(15);
        this.cTp.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cTp.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cTp.setBorderSurroundContent(true);
        this.cTp.setDrawBorder(true);
        this.cTq = (ImageView) view.findViewById(R.id.image_video_play);
        this.dSy.setOnClickListener(this);
        this.dvI = new com.baidu.tieba.play.n(this.ceu.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.mb("cyber_player_test");
        this.eLR = com.baidu.tieba.play.a.b.x(this.ceu.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.cTn.addView(this.eLR.getView(), 0);
        this.eLR.getView().setLayoutParams(layoutParams3);
        this.eLR.setContinuePlayEnable(true);
        this.eLR.setBusiness(this.dvI);
        this.eLR.setOnPreparedListener(this.dcT);
        this.eLR.setOnOutInfoListener(this.dcV);
        this.eLR.setOnCompletionListener(this.dcS);
        this.eLR.setOnErrorListener(this.cTy);
        this.eLR.setOnSurfaceDestroyedListener(this.cTC);
        this.dvH = new com.baidu.tieba.play.j();
        this.dvH.setPlayer(this.eLR);
        this.dvH.a(this.eMh);
        this.cTo = (TextView) view.findViewById(R.id.text_video_duration);
        this.eLS = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cTv = (TextView) view.findViewById(R.id.text_video_play_count);
        this.cTu = view.findViewById(R.id.auto_video_black_mask);
        this.cTr = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cTs = view.findViewById(R.id.auto_video_error_background);
        this.dTz = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.ayO = AnimationUtils.loadAnimation(this.ceu.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.ayO.setAnimationListener(this.eMi);
        this.eLP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eLP.setOnClickListener(this);
        this.ddZ = view.findViewById(R.id.divider_line);
        this.eLY = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.eLR.getView().setOnClickListener(this);
        this.eMa = (TextView) view.findViewById(R.id.nani_video_icon);
        this.eLR.setPageTypeForPerfStat("homepage");
        this.eLO = new com.baidu.afd.videopaster.d(getContext(), this.cTn);
        this.eLO.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void kE() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kD() {
                if (!m.this.eLZ) {
                    m.this.eLR.start();
                } else {
                    m.this.startPlay();
                }
                m.this.eLZ = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kC() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean kF() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.eLT != null && this.eLT.caz != null && this.eLT.caz.cdj > 0) {
            if (aZV() != null) {
                aZV().a(view, this.eLT);
            }
            this.ceu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.ceu.getPageActivity(), this.eLT.caz.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.air(), this.eLT.agJ())));
            return;
        }
        if (view == this.dSy || view == this.eLP) {
            bF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.eLR.getView()) {
            if (this.eLT != null) {
                this.eLT.objType = 5;
            }
            if (this.eLT != null && this.eLT.caz != null && this.eLT.caz.aiV() != null) {
                z = this.eLT.caz.aiV().is_vertical.intValue() == 1;
            }
            if (z) {
                bD(this.eLR.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bE(this.eLR.getView());
            } else {
                bF(getView());
            }
        }
    }

    private void bD(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eLT);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.ceu.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bad();
        }
    }

    private void bE(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eLT);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.ceu.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bae();
        }
    }

    private void bad() {
        if (this.eLT != null && this.eLT.caz != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eLT.caz);
            videoItemData.mRecomExtra = this.eLT.getExtra();
            videoItemData.mRecomAbTag = this.eLT.baF();
            videoItemData.mRecomSource = this.eLT.getSource();
            videoItemData.mRecomWeight = this.eLT.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.eLT.agJ(), "index")));
        }
    }

    private void bae() {
        if (this.eLT != null && this.eLT.caz != null && this.eLT.caz.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eLT.caz);
            videoSerializeVideoThreadInfo.source = this.eLT.getSource();
            videoSerializeVideoThreadInfo.extra = this.eLT.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.eLT.baF();
            videoSerializeVideoThreadInfo.weight = this.eLT.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dTz.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dTz.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.ceu.getPageActivity(), str, this.eLT.caz.getTid(), n.air(), this.eLT.agJ(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bF(View view) {
        if (this.eLT != null) {
            this.eLT.objType = 1;
        }
        if (aZV() != null) {
            aZV().a(view, this.eLT);
        }
        if (this.eLT != null && this.eLT.caz != null) {
            if (!baf()) {
                n.uz(this.eLT.caz.getId());
                n.a(this.mTextTitle, this.eLT.caz.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ceu.getPageActivity()).createFromThreadCfg(this.eLT.caz, null, n.air(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.eLT.agJ());
            addLocateParam.setVideo_source(this.eLT.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.eLT.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.eLT.caz.getFid()));
            addLocateParam.setForumName(this.eLT.caz.aiJ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eLP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ceu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baf() {
        return this.eLT.ePK && !this.eLT.ePR;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.eLT = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bag() {
        this.eMb.removeMessages(202);
        if (this.eLR.getCurrentPosition() > this.BE) {
            j(false, 3);
            this.eMb.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eMb.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bah() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eMb.removeMessages(203);
        int currentPosition = this.eLR.getCurrentPosition();
        if (currentPosition != this.eLU) {
            this.eLU = currentPosition;
            j(false, 3);
        } else {
            j(false, 2);
        }
        this.eMb.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.cTq != null && this.cTp != null && this.cTu != null && this.cTt != null && this.cTs != null && this.cTr != null) {
            if (z || this.cTw != i) {
                this.cTw = i;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTB);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTA);
                if (i == 2) {
                    this.cTq.setVisibility(8);
                    this.ayO.cancel();
                    this.cTp.clearAnimation();
                    this.cTp.setVisibility(0);
                    this.cTu.setVisibility(0);
                    this.eLS.setVisibility(0);
                    this.eLY.setVisibility(8);
                    this.cTt.startLoading();
                    this.cTs.setVisibility(8);
                    this.cTr.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cTB, 60000L);
                } else if (i == 3) {
                    this.cTq.setVisibility(8);
                    this.cTp.startAnimation(this.ayO);
                    this.cTu.setVisibility(8);
                    this.eLS.setVisibility(8);
                    if (this.eLT != null && this.eLT.agG() != null && this.eLT.agG().cdj > 0) {
                        this.eLY.setVisibility(0);
                    }
                    this.cTt.ccM();
                    this.cTs.setVisibility(8);
                    this.cTr.setVisibility(8);
                    if (this.eLT != null && this.eLT.caz != null && this.eLT.caz.aiV() != null) {
                        this.eLT.caz.aiV().video_length.intValue();
                        this.eLT.caz.aiV().video_duration.intValue();
                        this.eLT.caz.getTid();
                    }
                } else if (i == 4) {
                    this.cTq.setVisibility(8);
                    this.cTp.startAnimation(this.ayO);
                    this.cTu.setVisibility(8);
                    this.cTt.ccN();
                    this.cTs.setVisibility(0);
                    this.cTr.setVisibility(0);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cTA, 2000L);
                } else {
                    this.cTq.setVisibility(0);
                    this.ayO.cancel();
                    this.cTp.clearAnimation();
                    this.cTp.setVisibility(0);
                    this.cTu.setVisibility(0);
                    this.eLS.setVisibility(0);
                    this.cTt.ccN();
                    this.cTs.setVisibility(8);
                    this.cTr.setVisibility(8);
                }
                if (this.eLT != null && this.eLT.agG() != null && this.eLT.agG().cdj > 0) {
                    this.eLS.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.eLT == null || this.eLT.caz == null || this.eLT.caz.aiE() == null) {
            this.dSy.setVisibility(8);
            return;
        }
        this.dSy.setVisibility(0);
        baj();
        if (!baf() && n.uA(this.eLT.caz.getId())) {
            n.a(this.mTextTitle, this.eLT.caz.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eLP.getGodReplyContent(), this.eLT.agG().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eLT.agG().aju();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eLT.agG().ajk());
        if (this.eLT.agG().ajr() && !StringUtils.isNull(this.eLT.agG().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eLT.agG().getTid();
            spannableStringBuilder.append((CharSequence) this.eLT.agG().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bS("obj_source", "0"));
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
        this.dSz.setData(this.eLT.agG());
        this.dSz.setUserAfterClickListener(this.eMe);
        if (this.dSz.getHeaderImg() != null) {
            this.dSz.getHeaderImg().setAfterClickListener(this.eMf);
            if (this.dSz.getIsSimpleThread()) {
                this.dSz.getHeaderImg().setVisibility(8);
                this.eLQ.setVisibility(8);
            } else if (this.eLT.agG() == null || this.eLT.agG().aiE() == null || this.eLT.agG().aiE().getPendantData() == null || StringUtils.isNull(this.eLT.agG().aiE().getPendantData().ahd())) {
                this.eLQ.setVisibility(8);
                this.dSz.getHeaderImg().setVisibility(0);
                if (this.eLT.agG().cdj > 0 && this.eLT.agG().cdk == 0) {
                    this.eLT.agG().aiE().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dSz.getHeaderImg().setData(this.eLT.agG(), false);
                } else {
                    this.dSz.getHeaderImg().setData(this.eLT.agG());
                    this.dSz.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dSz.getHeaderImg().setVisibility(4);
                this.eLQ.setVisibility(0);
                this.eLQ.setData(this.eLT.agG());
            }
        }
        this.cTo.setText(aq.stringForVideoTime(this.eLT.caz.aiV().video_duration.intValue() * 1000));
        this.cTv.setText(String.format(this.ceu.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.eLT.caz.aiV().play_count.intValue())));
        if (this.dSM != null && this.eLT.agG() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eLT.agG().getTid());
            ajVar.setFid(this.eLT.agG().getFid());
            ajVar.setFeedBackReasonMap(this.eLT.feedBackReasonMap);
            this.dSM.setData(ajVar);
            this.dSM.setFirstRowSingleColumn(true);
            this.dSM.setVisibility(this.eLW ? 0 : 8);
        }
        this.eLP.setData(this.eLT.agG().akb());
        mY(lx(1));
        onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
        if (n.uA(this.eLT.caz.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.eLT == null || this.eLT.caz == null || this.eLT.caz.aiV() == null) {
            z = false;
        } else {
            z = this.eLT.caz.aiV().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eMa.setVisibility(0);
            if (bak()) {
                this.eMa.setText(String.format("%s | %s", this.ceu.getResources().getString(R.string.nani_video), this.ceu.getResources().getString(R.string.video_preview)));
            } else {
                this.eMa.setText(this.ceu.getString(R.string.nani_video));
            }
        } else if (bak()) {
            this.eMa.setVisibility(0);
            this.eMa.setText(this.ceu.getString(R.string.video_preview));
        } else {
            this.eMa.setVisibility(8);
        }
    }

    private void bai() {
        this.eMb.removeMessages(202);
        this.eMb.removeMessages(203);
    }

    private void ayQ() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTA);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTB);
    }

    private void baj() {
        ayQ();
        bai();
        if (this.cTp != null && this.cTn != null && this.eLR != null) {
            if (com.baidu.tbadk.core.i.ago().isShowImages() && this.eLT != null && this.eLT.caz != null && this.eLT.caz.aiV() != null) {
                this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
                this.cTp.startLoad(this.eLT.caz.aiV().thumbnail_url, 10, false);
                this.cTn.setVisibility(0);
                stopPlay();
                this.cln = this.eLT.caz.aiV().video_url;
                if (bak()) {
                    this.cln = this.eLT.caz.aiW().video_url;
                }
                if (StringUtils.isNull(this.eLT.caz.aiV().video_url)) {
                    j(true, 4);
                }
                if (this.dvI != null && this.dvI.ccw() != null) {
                    this.dvI.ccw().g(this.eLT.caz.aiV());
                }
            } else {
                this.cTn.setVisibility(8);
            }
            this.eLO.reset();
            this.dvH.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eLO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eLT);
                    }
                }
            });
            this.dvI.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void bh(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eLO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eLT);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.caz != null) {
            bh bhVar = lVar.caz;
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
        if (lVar == null || lVar.caz == null || bVar == null) {
            return null;
        }
        bh bhVar = lVar.caz;
        int kJ = bVar.kJ();
        int kK = bVar.kK();
        int kI = bVar.kI();
        if (kI != -1) {
            i = kJ != -1 ? (kI - kJ) - 1 : -1;
            if (kK != -1) {
                i4 = (kK - kI) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aiV = bhVar.aiV();
        if (aiV != null) {
            i3 = aiV.video_width.intValue();
            i2 = aiV.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aiJ());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", kI + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dSy, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cTq, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.cTr, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eLY, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.cTs, R.color.common_color_10014);
            am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c);
            if (this.eMa != null) {
                am.setViewTextColor(this.eMa, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.eMa, R.drawable.video_play_count_bg);
            }
            if (this.cTr != null) {
                this.cTr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.eLP.onChangeSkinType();
            if (this.dSM != null) {
                this.dSM.onChangeSkinType();
            }
            this.dSz.onChangeSkinType();
            this.dSA.onChangeSkinType();
            this.dTo.onChangeSkinType();
            this.cTp.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.eLQ.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.mSkinType = i;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eMg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eMg);
            this.eMd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eMd);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dSz != null) {
            this.dSz.setPageUniqueId(bdUniqueId);
        }
        if (this.cTp != null) {
            this.cTp.setPageId(bdUniqueId);
        }
        if (this.dSM != null) {
            this.dSM.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.eLV;
    }

    public boolean isPlaying() {
        if (this.eLR == null) {
            return false;
        }
        return this.eLR.isPlaying();
    }

    public void startPlay() {
        if (!this.eLV && this.eLT != null && this.eLT.caz != null && this.eLT.caz.aiV() != null && this.eLR != null) {
            if (this.eLO.kn()) {
                this.eLO.resume();
                this.eLZ = true;
                return;
            }
            this.eLZ = false;
            this.eLR.stopPlayback();
            if (com.baidu.tbadk.util.ac.M(1, this.cln)) {
                j(true, 2);
                if (StringUtils.isNull(this.cln)) {
                    TiebaStatic.log(new an("c12619").bS("obj_locate", "index").bS("tid", this.eLT.tid));
                    this.cln = this.eLT.caz.aiV().video_url;
                }
                this.eLV = true;
                this.eLR.setVideoPath(this.cln, this.eLT.tid);
                if (this.dvH != null) {
                    this.dvH.start();
                }
                bac();
            }
        }
    }

    public void stopPlay() {
        this.eLZ = false;
        ayQ();
        bai();
        j(true, 1);
        if (this.eLR != null) {
            this.eLR.stopPlayback();
            if (this.dvH != null) {
                this.dvH.stop();
            }
        }
        this.eLV = false;
        this.eLO.stop();
    }

    public View getVideoContainer() {
        return this.cTn;
    }

    public String getPlayUrl() {
        return this.cln;
    }

    public int getCurrentPosition() {
        if (this.eLR == null) {
            return 0;
        }
        return this.eLR.getCurrentPosition();
    }

    public void iE(boolean z) {
        this.eLW = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void mY(int i) {
        if (this.eLT != null && this.eLT.caz != null) {
            if (i == 1) {
                if (this.eLT.caz.cdj > 0) {
                    this.dTo.cqW.setShowPraiseNum(false);
                    this.dTo.cqW.setShareVisible(false);
                    this.eLY.setText(aq.numFormatOverWan(this.eLT.caz.cdj));
                    this.eLY.setVisibility(0);
                } else {
                    this.dTo.cqW.setShowPraiseNum(true);
                    this.dTo.cqW.setShareVisible(true);
                    this.eLY.setVisibility(8);
                }
                this.dTo.setData(this.eLT.caz);
                this.dSA.setVisibility(8);
                this.dSz.et(false);
                return;
            }
            this.dTo.setVisibility(8);
            this.dSz.et(true);
            if (this.eLT.caz.cdj > 0) {
                this.dSA.setShowPraiseNum(false);
                this.dSA.setShareVisible(false);
                this.eLY.setText(aq.numFormatOverWan(this.eLT.caz.cdj));
                this.eLY.setVisibility(0);
            } else {
                this.dSA.setShowPraiseNum(true);
                this.dSA.setShareVisible(true);
                this.eLY.setVisibility(8);
            }
            if (this.dSA.setData(this.eLT.caz)) {
                this.eLK.setVisibility(8);
            } else {
                this.eLK.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cTp.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cTp.setOnDrawListener(null);
        }
    }

    private boolean bak() {
        return (this.eLT == null || this.eLT.caz == null || this.eLT.caz.aiW() == null || TextUtils.isEmpty(this.eLT.caz.aiW().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.eLO.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.eLO.stop();
    }

    public void onResume() {
        if (this.eLO.kn()) {
            this.eLO.resume();
        }
    }
}
