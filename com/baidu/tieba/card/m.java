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
    private int Ce;
    private String GC;
    private Animation azg;
    public FrameLayout cUe;
    private TextView cUf;
    private TbImageView cUg;
    private ImageView cUh;
    private TextView cUi;
    private View cUj;
    private com.baidu.tieba.play.x cUk;
    private View cUl;
    private TextView cUm;
    private int cUn;
    private TbImageView.a cUo;
    private g.b cUp;
    private Runnable cUr;
    private Runnable cUs;
    private QuickVideoView.b cUt;
    private TbPageContext<?> cfl;
    private String cmf;
    private final View.OnClickListener cpN;
    private NEGFeedBackView dTD;
    private RelativeLayout dTp;
    public ThreadUserInfoLayout dTq;
    public ThreadCommentAndPraiseInfoLayout dTr;
    public ThreadSourceShareAndPraiseLayout dUf;
    protected LinearLayout dUq;
    private g.a ddK;
    private g.f ddL;
    private g.e ddN;
    private View deR;
    private com.baidu.tieba.play.j dwy;
    private com.baidu.tieba.play.n dwz;
    private View eMB;
    private com.baidu.afd.videopaster.d eMF;
    public ThreadGodReplyLayout eMG;
    private HeadPendantClickableView eMH;
    private com.baidu.tieba.play.a.a eMI;
    private LinearLayout eMJ;
    private com.baidu.tieba.card.data.l eMK;
    private int eML;
    private boolean eMM;
    private boolean eMN;
    private boolean eMO;
    private TextView eMP;
    private boolean eMQ;
    private TextView eMR;
    private Handler eMS;
    private VideoLoadingProgressView.a eMT;
    private CustomMessageListener eMU;
    private final View.OnClickListener eMV;
    private final View.OnClickListener eMW;
    private CustomMessageListener eMX;
    private j.a eMY;
    private Animation.AnimationListener eMZ;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        if (this.eMI != null && this.eMM) {
            try {
                this.eMI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int BS = com.baidu.tieba.play.y.ccT().BS(this.cmf);
            if (BS <= 100 || this.eMI.getDuration() <= BS) {
                BS = 100;
            }
            this.Ce = BS;
            this.eMS.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        if (this.eMK != null && this.eMK.cbq != null) {
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = this.eMK.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            zVar.cmS = this.eMK.cbq.getTid();
            zVar.ePT = this.eMK.cbq.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.eMK.cbq.mRecomSource;
            zVar.iza = this.eMK.cbq.mRecomAbTag;
            zVar.izb = this.eMK.cbq.mRecomWeight;
            zVar.izc = "";
            zVar.bZb = this.eMK.getExtra();
            if (this.eMK.cbq.aiX() != null) {
                zVar.ize = this.eMK.cbq.aiX().video_md5;
            }
            com.baidu.tieba.play.l.a(this.eMK.cbq.aiX().video_md5, "", "1", zVar);
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dTD = null;
        this.mSkinType = 3;
        this.eML = 0;
        this.cUn = 1;
        this.eMM = false;
        this.eMN = true;
        this.eMO = false;
        this.Ce = 100;
        this.eMQ = false;
        this.isNewPlayer = false;
        this.eMS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.bai();
                        return;
                    case 203:
                        m.this.baj();
                        return;
                    default:
                        return;
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (m.this.eMI != null) {
                    m.this.eMI.setVolume(0.0f, 0.0f);
                }
                m.this.bad();
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    m.this.j(false, 3);
                }
                return false;
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!m.this.eMF.a(false, false, "NEWINDEX")) {
                    m.this.eMI.start();
                }
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                m.this.j(true, 4);
                m.this.eMM = false;
                return true;
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.bad();
            }
        };
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.card.m.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && m.this.cUg != null) {
                    m.this.cUg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cUr = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.eMI != null && !m.this.eMI.isPlaying()) {
                    m.this.j(true, 1);
                }
            }
        };
        this.cUs = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.j(true, 4);
            }
        };
        this.eMU = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.eMK != null && m.this.eMK.cbq != null && videoId.equals(m.this.eMK.cbq.getId())) {
                        m.this.eMF.a(m.this.a(m.this.eMK, bVar));
                    }
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.m.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.eMV = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eMK == null) {
                    if (m.this.aZX() != null) {
                        m.this.aZX().a(view, m.this.eMK);
                        return;
                    }
                    return;
                }
                if (view == m.this.dTq.getUserName()) {
                    m.this.eMK.objType = 3;
                } else if (view == m.this.dTq.getHeaderImg()) {
                    m.this.eMK.objType = 4;
                } else {
                    m.this.eMK.objType = 1;
                }
                if (m.this.aZX() != null) {
                    m.this.aZX().a(view, m.this.eMK);
                }
            }
        };
        this.eMW = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eMK != null) {
                    m.this.eMK.objType = 4;
                }
                if (m.this.aZX() != null) {
                    m.this.aZX().a(view, m.this.eMK);
                }
            }
        };
        this.eMX = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.m.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.eMO = false;
                }
            }
        };
        this.cpN = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eMK != null) {
                    if (m.this.aZX() != null) {
                        m.this.aZX().a(view, m.this.eMK);
                    }
                    if (m.this.eMK.cbq != null && view != m.this.dUf.crd) {
                        n.uz(m.this.eMK.cbq.getId());
                        if (!m.this.bah()) {
                            n.a(m.this.mTextTitle, m.this.eMK.cbq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            n.a(m.this.eMG.getGodReplyContent(), m.this.eMK.agI().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.eMY = new j.a() { // from class: com.baidu.tieba.card.m.13
            @Override // com.baidu.tieba.play.j.a
            public void kP() {
                if (m.this.eMK != null && m.this.eMK.cbq != null && m.this.eMK.cbq.aiX() != null) {
                    m.this.bae();
                }
            }
        };
        this.eMZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.cUg != null) {
                    m.this.cUg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.cfl = tbPageContext;
        View view = getView();
        this.dTp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eMH = (HeadPendantClickableView) this.dTp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eMH.getHeadView() != null) {
            this.eMH.getHeadView().setIsRound(true);
            this.eMH.getHeadView().setDrawBorder(false);
            this.eMH.getHeadView().setDefaultResource(17170445);
            this.eMH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eMH.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.ds70));
        }
        this.eMH.setHasPendantStyle();
        if (this.eMH.getPendantView() != null) {
            this.eMH.getPendantView().setIsRound(true);
            this.eMH.getPendantView().setDrawBorder(false);
        }
        this.cUk = new com.baidu.tieba.play.x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cUk.setLoadingAnimationListener(this.eMT);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dTq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dTD = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.dTD.a(this.dTp, dimens, 0);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.dTr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dTr.setLayoutParams(layoutParams);
        }
        this.dTr.setOnClickListener(this);
        this.dTr.setReplyTimeVisible(false);
        this.dTr.setShowPraiseNum(true);
        this.dTr.setNeedAddPraiseIcon(true);
        this.dTr.setNeedAddReplyIcon(true);
        this.dTr.setShareVisible(true);
        this.dTr.setShareReportFrom(3);
        this.dTr.setForumAfterClickListener(this.cpN);
        this.dTr.setFrom(1);
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dUf.crO.setOnClickListener(this);
        this.dUf.setFrom(1);
        this.dUf.setShareReportFrom(3);
        this.dUf.setForumAfterClickListener(this.cpN);
        this.eMB = view.findViewById(R.id.divider_below_reply_number_layout);
        this.cUe = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cUe.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cfl.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cUe.setLayoutParams(layoutParams2);
        this.cUg = (TbImageView) view.findViewById(R.id.image_video);
        this.cUg.setDefaultErrorResource(0);
        this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
        this.cUg.setGifIconSupport(false);
        this.cUg.setEvent(this.cUo);
        this.cUg.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds20));
        TbImageView tbImageView = this.cUg;
        TbImageView tbImageView2 = this.cUg;
        tbImageView.setConrers(15);
        this.cUg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.cUg.setBorderColor(am.getColor(R.color.black_alpha8));
        this.cUg.setBorderSurroundContent(true);
        this.cUg.setDrawBorder(true);
        this.cUh = (ImageView) view.findViewById(R.id.image_video_play);
        this.dTp.setOnClickListener(this);
        this.dwz = new com.baidu.tieba.play.n(this.cfl.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.mb("cyber_player_test");
        this.eMI = com.baidu.tieba.play.a.b.x(this.cfl.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.cUe.addView(this.eMI.getView(), 0);
        this.eMI.getView().setLayoutParams(layoutParams3);
        this.eMI.setContinuePlayEnable(true);
        this.eMI.setBusiness(this.dwz);
        this.eMI.setOnPreparedListener(this.ddL);
        this.eMI.setOnOutInfoListener(this.ddN);
        this.eMI.setOnCompletionListener(this.ddK);
        this.eMI.setOnErrorListener(this.cUp);
        this.eMI.setOnSurfaceDestroyedListener(this.cUt);
        this.dwy = new com.baidu.tieba.play.j();
        this.dwy.setPlayer(this.eMI);
        this.dwy.a(this.eMY);
        this.cUf = (TextView) view.findViewById(R.id.text_video_duration);
        this.eMJ = (LinearLayout) view.findViewById(R.id.duration_container);
        this.cUm = (TextView) view.findViewById(R.id.text_video_play_count);
        this.cUl = view.findViewById(R.id.auto_video_black_mask);
        this.cUi = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cUj = view.findViewById(R.id.auto_video_error_background);
        this.dUq = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.azg = AnimationUtils.loadAnimation(this.cfl.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.azg.setAnimationListener(this.eMZ);
        this.eMG = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eMG.setOnClickListener(this);
        this.deR = view.findViewById(R.id.divider_line);
        this.eMP = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.eMI.getView().setOnClickListener(this);
        this.eMR = (TextView) view.findViewById(R.id.nani_video_icon);
        this.eMI.setPageTypeForPerfStat("homepage");
        this.eMF = new com.baidu.afd.videopaster.d(getContext(), this.cUe);
        this.eMF.a(new d.a() { // from class: com.baidu.tieba.card.m.20
            @Override // com.baidu.afd.videopaster.d.a
            public void kE() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kD() {
                if (!m.this.eMQ) {
                    m.this.eMI.start();
                } else {
                    m.this.startPlay();
                }
                m.this.eMQ = false;
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
        if (this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.cea > 0) {
            if (aZX() != null) {
                aZX().a(view, this.eMK);
            }
            this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.cfl.getPageActivity(), this.eMK.cbq.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.ait(), this.eMK.agL())));
            return;
        }
        if (view == this.dTp || view == this.eMG) {
            bF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.eMI.getView()) {
            if (this.eMK != null) {
                this.eMK.objType = 5;
            }
            if (this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.aiX() != null) {
                z = this.eMK.cbq.aiX().is_vertical.intValue() == 1;
            }
            if (z) {
                bD(this.eMI.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bE(this.eMI.getView());
            } else {
                bF(getView());
            }
        }
    }

    private void bD(View view) {
        if (aZX() != null) {
            aZX().a(view, this.eMK);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cfl.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            baf();
        }
    }

    private void bE(View view) {
        if (aZX() != null) {
            aZX().a(view, this.eMK);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cfl.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bag();
        }
    }

    private void baf() {
        if (this.eMK != null && this.eMK.cbq != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.eMK.cbq);
            videoItemData.mRecomExtra = this.eMK.getExtra();
            videoItemData.mRecomAbTag = this.eMK.baH();
            videoItemData.mRecomSource = this.eMK.getSource();
            videoItemData.mRecomWeight = this.eMK.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.eMK.agL(), "index")));
        }
    }

    private void bag() {
        if (this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.eMK.cbq);
            videoSerializeVideoThreadInfo.source = this.eMK.getSource();
            videoSerializeVideoThreadInfo.extra = this.eMK.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.eMK.baH();
            videoSerializeVideoThreadInfo.weight = this.eMK.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.dUq.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.dUq.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.cfl.getPageActivity(), str, this.eMK.cbq.getTid(), n.ait(), this.eMK.agL(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bF(View view) {
        if (this.eMK != null) {
            this.eMK.objType = 1;
        }
        if (aZX() != null) {
            aZX().a(view, this.eMK);
        }
        if (this.eMK != null && this.eMK.cbq != null) {
            if (!bah()) {
                n.uz(this.eMK.cbq.getId());
                n.a(this.mTextTitle, this.eMK.cbq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cfl.getPageActivity()).createFromThreadCfg(this.eMK.cbq, null, n.ait(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.eMK.agL());
            addLocateParam.setVideo_source(this.eMK.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.eMK.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.eMK.cbq.getFid()));
            addLocateParam.setForumName(this.eMK.cbq.aiL());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.eMG) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bah() {
        return this.eMK.eQB && !this.eMK.eQI;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.eMK = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        this.eMS.removeMessages(202);
        if (this.eMI.getCurrentPosition() > this.Ce) {
            j(false, 3);
            this.eMS.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eMS.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baj() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eMS.removeMessages(203);
        int currentPosition = this.eMI.getCurrentPosition();
        if (currentPosition != this.eML) {
            this.eML = currentPosition;
            j(false, 3);
        } else {
            j(false, 2);
        }
        this.eMS.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.cUh != null && this.cUg != null && this.cUl != null && this.cUk != null && this.cUj != null && this.cUi != null) {
            if (z || this.cUn != i) {
                this.cUn = i;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUs);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUr);
                if (i == 2) {
                    this.cUh.setVisibility(8);
                    this.azg.cancel();
                    this.cUg.clearAnimation();
                    this.cUg.setVisibility(0);
                    this.cUl.setVisibility(0);
                    this.eMJ.setVisibility(0);
                    this.eMP.setVisibility(8);
                    this.cUk.startLoading();
                    this.cUj.setVisibility(8);
                    this.cUi.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cUs, 60000L);
                } else if (i == 3) {
                    this.cUh.setVisibility(8);
                    this.cUg.startAnimation(this.azg);
                    this.cUl.setVisibility(8);
                    this.eMJ.setVisibility(8);
                    if (this.eMK != null && this.eMK.agI() != null && this.eMK.agI().cea > 0) {
                        this.eMP.setVisibility(0);
                    }
                    this.cUk.ccO();
                    this.cUj.setVisibility(8);
                    this.cUi.setVisibility(8);
                    if (this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.aiX() != null) {
                        this.eMK.cbq.aiX().video_length.intValue();
                        this.eMK.cbq.aiX().video_duration.intValue();
                        this.eMK.cbq.getTid();
                    }
                } else if (i == 4) {
                    this.cUh.setVisibility(8);
                    this.cUg.startAnimation(this.azg);
                    this.cUl.setVisibility(8);
                    this.cUk.ccP();
                    this.cUj.setVisibility(0);
                    this.cUi.setVisibility(0);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cUr, 2000L);
                } else {
                    this.cUh.setVisibility(0);
                    this.azg.cancel();
                    this.cUg.clearAnimation();
                    this.cUg.setVisibility(0);
                    this.cUl.setVisibility(0);
                    this.eMJ.setVisibility(0);
                    this.cUk.ccP();
                    this.cUj.setVisibility(8);
                    this.cUi.setVisibility(8);
                }
                if (this.eMK != null && this.eMK.agI() != null && this.eMK.agI().cea > 0) {
                    this.eMJ.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.eMK == null || this.eMK.cbq == null || this.eMK.cbq.aiG() == null) {
            this.dTp.setVisibility(8);
            return;
        }
        this.dTp.setVisibility(0);
        bal();
        if (!bah() && n.uA(this.eMK.cbq.getId())) {
            n.a(this.mTextTitle, this.eMK.cbq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.eMG.getGodReplyContent(), this.eMK.agI().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.eMK.agI().ajw();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eMK.agI().ajm());
        if (this.eMK.agI().ajt() && !StringUtils.isNull(this.eMK.agI().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.eMK.agI().getTid();
            spannableStringBuilder.append((CharSequence) this.eMK.agI().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.m.22
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
        this.dTq.setData(this.eMK.agI());
        this.dTq.setUserAfterClickListener(this.eMV);
        if (this.dTq.getHeaderImg() != null) {
            this.dTq.getHeaderImg().setAfterClickListener(this.eMW);
            if (this.dTq.getIsSimpleThread()) {
                this.dTq.getHeaderImg().setVisibility(8);
                this.eMH.setVisibility(8);
            } else if (this.eMK.agI() == null || this.eMK.agI().aiG() == null || this.eMK.agI().aiG().getPendantData() == null || StringUtils.isNull(this.eMK.agI().aiG().getPendantData().ahf())) {
                this.eMH.setVisibility(8);
                this.dTq.getHeaderImg().setVisibility(0);
                if (this.eMK.agI().cea > 0 && this.eMK.agI().ceb == 0) {
                    this.eMK.agI().aiG().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.dTq.getHeaderImg().setData(this.eMK.agI(), false);
                } else {
                    this.dTq.getHeaderImg().setData(this.eMK.agI());
                    this.dTq.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.dTq.getHeaderImg().setVisibility(4);
                this.eMH.setVisibility(0);
                this.eMH.setData(this.eMK.agI());
            }
        }
        this.cUf.setText(aq.stringForVideoTime(this.eMK.cbq.aiX().video_duration.intValue() * 1000));
        this.cUm.setText(String.format(this.cfl.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.eMK.cbq.aiX().play_count.intValue())));
        if (this.dTD != null && this.eMK.agI() != null) {
            aj ajVar = new aj();
            ajVar.setTid(this.eMK.agI().getTid());
            ajVar.setFid(this.eMK.agI().getFid());
            ajVar.setFeedBackReasonMap(this.eMK.feedBackReasonMap);
            this.dTD.setData(ajVar);
            this.dTD.setFirstRowSingleColumn(true);
            this.dTD.setVisibility(this.eMN ? 0 : 8);
        }
        this.eMG.setData(this.eMK.agI().akd());
        mZ(ly(1));
        onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
        if (n.uA(this.eMK.cbq.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.eMK == null || this.eMK.cbq == null || this.eMK.cbq.aiX() == null) {
            z = false;
        } else {
            z = this.eMK.cbq.aiX().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eMR.setVisibility(0);
            if (bam()) {
                this.eMR.setText(String.format("%s | %s", this.cfl.getResources().getString(R.string.nani_video), this.cfl.getResources().getString(R.string.video_preview)));
            } else {
                this.eMR.setText(this.cfl.getString(R.string.nani_video));
            }
        } else if (bam()) {
            this.eMR.setVisibility(0);
            this.eMR.setText(this.cfl.getString(R.string.video_preview));
        } else {
            this.eMR.setVisibility(8);
        }
    }

    private void bak() {
        this.eMS.removeMessages(202);
        this.eMS.removeMessages(203);
    }

    private void ayS() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUr);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUs);
    }

    private void bal() {
        ayS();
        bak();
        if (this.cUg != null && this.cUe != null && this.eMI != null) {
            if (com.baidu.tbadk.core.i.agq().isShowImages() && this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.aiX() != null) {
                this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
                this.cUg.startLoad(this.eMK.cbq.aiX().thumbnail_url, 10, false);
                this.cUe.setVisibility(0);
                stopPlay();
                this.cmf = this.eMK.cbq.aiX().video_url;
                if (bam()) {
                    this.cmf = this.eMK.cbq.aiY().video_url;
                }
                if (StringUtils.isNull(this.eMK.cbq.aiX().video_url)) {
                    j(true, 4);
                }
                if (this.dwz != null && this.dwz.ccy() != null) {
                    this.dwz.ccy().g(this.eMK.cbq.aiX());
                }
            } else {
                this.cUe.setVisibility(8);
            }
            this.eMF.reset();
            this.dwy.a(new j.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.j.b
                public void bj(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eMF.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eMK);
                    }
                }
            });
            this.dwz.a(new j.b() { // from class: com.baidu.tieba.card.m.5
                @Override // com.baidu.tieba.play.j.b
                public void bj(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.eMF.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.eMK);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cbq != null) {
            bh bhVar = lVar.cbq;
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
        if (lVar == null || lVar.cbq == null || bVar == null) {
            return null;
        }
        bh bhVar = lVar.cbq;
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
        VideoInfo aiX = bhVar.aiX();
        if (aiX != null) {
            i3 = aiX.video_width.intValue();
            i2 = aiX.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aiL());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", kI + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cUh, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.cUi, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUf, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUm, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eMP, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.cUj, R.color.common_color_10014);
            am.setBackgroundColor(this.deR, R.color.cp_bg_line_c);
            if (this.eMR != null) {
                am.setViewTextColor(this.eMR, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.eMR, R.drawable.video_play_count_bg);
            }
            if (this.cUi != null) {
                this.cUi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.eMG.onChangeSkinType();
            if (this.dTD != null) {
                this.dTD.onChangeSkinType();
            }
            this.dTq.onChangeSkinType();
            this.dTr.onChangeSkinType();
            this.dUf.onChangeSkinType();
            this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.eMH.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.mSkinType = i;
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eMX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eMX);
            this.eMU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eMU);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dTq != null) {
            this.dTq.setPageUniqueId(bdUniqueId);
        }
        if (this.cUg != null) {
            this.cUg.setPageId(bdUniqueId);
        }
        if (this.dTD != null) {
            this.dTD.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.eMM;
    }

    public boolean isPlaying() {
        if (this.eMI == null) {
            return false;
        }
        return this.eMI.isPlaying();
    }

    public void startPlay() {
        if (!this.eMM && this.eMK != null && this.eMK.cbq != null && this.eMK.cbq.aiX() != null && this.eMI != null) {
            if (this.eMF.kn()) {
                this.eMF.resume();
                this.eMQ = true;
                return;
            }
            this.eMQ = false;
            this.eMI.stopPlayback();
            if (com.baidu.tbadk.util.ac.N(1, this.cmf)) {
                j(true, 2);
                if (StringUtils.isNull(this.cmf)) {
                    TiebaStatic.log(new an("c12619").bS("obj_locate", "index").bS("tid", this.eMK.tid));
                    this.cmf = this.eMK.cbq.aiX().video_url;
                }
                this.eMM = true;
                this.eMI.setVideoPath(this.cmf, this.eMK.tid);
                if (this.dwy != null) {
                    this.dwy.start();
                }
                bae();
            }
        }
    }

    public void stopPlay() {
        this.eMQ = false;
        ayS();
        bak();
        j(true, 1);
        if (this.eMI != null) {
            this.eMI.stopPlayback();
            if (this.dwy != null) {
                this.dwy.stop();
            }
        }
        this.eMM = false;
        this.eMF.stop();
    }

    public View getVideoContainer() {
        return this.cUe;
    }

    public String getPlayUrl() {
        return this.cmf;
    }

    public int getCurrentPosition() {
        if (this.eMI == null) {
            return 0;
        }
        return this.eMI.getCurrentPosition();
    }

    public void iE(boolean z) {
        this.eMN = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void mZ(int i) {
        if (this.eMK != null && this.eMK.cbq != null) {
            if (i == 1) {
                if (this.eMK.cbq.cea > 0) {
                    this.dUf.crO.setShowPraiseNum(false);
                    this.dUf.crO.setShareVisible(false);
                    this.eMP.setText(aq.numFormatOverWan(this.eMK.cbq.cea));
                    this.eMP.setVisibility(0);
                } else {
                    this.dUf.crO.setShowPraiseNum(true);
                    this.dUf.crO.setShareVisible(true);
                    this.eMP.setVisibility(8);
                }
                this.dUf.setData(this.eMK.cbq);
                this.dTr.setVisibility(8);
                this.dTq.et(false);
                return;
            }
            this.dUf.setVisibility(8);
            this.dTq.et(true);
            if (this.eMK.cbq.cea > 0) {
                this.dTr.setShowPraiseNum(false);
                this.dTr.setShareVisible(false);
                this.eMP.setText(aq.numFormatOverWan(this.eMK.cbq.cea));
                this.eMP.setVisibility(0);
            } else {
                this.dTr.setShowPraiseNum(true);
                this.dTr.setShareVisible(true);
                this.eMP.setVisibility(8);
            }
            if (this.dTr.setData(this.eMK.cbq)) {
                this.eMB.setVisibility(8);
            } else {
                this.eMB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cUg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.card.m.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cUg.setOnDrawListener(null);
        }
    }

    private boolean bam() {
        return (this.eMK == null || this.eMK.cbq == null || this.eMK.cbq.aiY() == null || TextUtils.isEmpty(this.eMK.cbq.aiY().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.eMF.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.eMF.stop();
    }

    public void onResume() {
        if (this.eMF.kn()) {
            this.eMF.resume();
        }
    }
}
