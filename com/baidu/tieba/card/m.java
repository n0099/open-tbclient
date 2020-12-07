package com.baidu.tieba.card;

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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes21.dex */
public class m extends b<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView aaZ;
    private int abg;
    private String aiw;
    private Animation cbR;
    private TbPageContext<?> eNx;
    private CyberPlayerManager.OnCompletionListener etA;
    private CyberPlayerManager.OnInfoListener etB;
    private CyberPlayerManager.OnPreparedListener ety;
    private CyberPlayerManager.OnErrorListener etz;
    public FrameLayout fMI;
    private TextView fMJ;
    private TbImageView fMK;
    private ImageView fML;
    private TextView fMM;
    private View fMN;
    private com.baidu.tieba.play.m fMO;
    private View fMP;
    private TextView fMQ;
    private int fMR;
    private TbImageView.a fMS;
    private Runnable fMU;
    private Runnable fMV;
    private TbCyberVideoView.a fMW;
    private View fYd;
    private final View.OnClickListener fdj;
    protected LinearLayout gfN;
    private com.baidu.tieba.play.f gqU;
    private RelativeLayout hbJ;
    public ThreadUserInfoLayout hbK;
    public ThreadCommentAndPraiseInfoLayout hbL;
    private NEGFeedBackView hbW;
    public ThreadSourceShareAndPraiseLayout hcx;
    private com.baidu.afd.videopaster.d ijb;
    private View ijc;
    public ThreadGodReplyLayout ijd;
    private HeadPendantClickableView ije;
    private LinearLayout ijf;
    private com.baidu.tieba.card.data.l ijg;
    private int ijh;
    private boolean iji;
    private boolean ijj;
    private boolean ijk;
    private TextView ijl;
    private boolean ijm;
    private TextView ijn;
    private Handler ijo;
    private VideoLoadingProgressView.a ijp;
    private CustomMessageListener ijq;
    private final View.OnClickListener ijr;
    private final View.OnClickListener ijs;
    private CustomMessageListener ijt;
    private f.a iju;
    private Animation.AnimationListener ijv;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void crN() {
        if (this.aaZ != null && this.iji) {
            try {
                this.aaZ.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Ro = com.baidu.tieba.play.n.dBZ().Ro(this.mVideoUrl);
            if (Ro <= 100 || this.aaZ.getDuration() <= Ro) {
                Ro = 100;
            }
            this.abg = Ro;
            this.ijo.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        if (this.ijg != null && this.ijg.eCR != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.ijg.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.amY = this.ijg.eCR.getTid();
            oVar.fFV = this.ijg.eCR.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.ijg.eCR.mRecomSource;
            oVar.mys = this.ijg.eCR.mRecomAbTag;
            oVar.myo = this.ijg.eCR.mRecomAbTag;
            oVar.myp = this.ijg.eCR.mRecomWeight;
            oVar.myq = "";
            oVar.eGn = this.ijg.getExtra();
            if (this.ijg.eCR.bph() != null) {
                oVar.myt = this.ijg.eCR.bph().video_md5;
            }
            com.baidu.tieba.play.h.a(this.ijg.eCR.bph().video_md5, "", "1", oVar, this.aaZ.getPcdnState());
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hbW = null;
        this.mSkinType = 3;
        this.ijh = 0;
        this.fMR = 1;
        this.iji = false;
        this.ijj = true;
        this.ijk = false;
        this.abg = 100;
        this.ijm = false;
        this.ijo = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.crS();
                        return;
                    case 203:
                        m.this.crT();
                        return;
                    default:
                        return;
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (m.this.aaZ != null) {
                    m.this.aaZ.setVolume(0.0f, 0.0f);
                }
                m.this.crN();
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.m.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    m.this.w(false, 3);
                }
                return false;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.m.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!m.this.ijb.a(false, false, "NEWINDEX")) {
                    m.this.aaZ.start();
                }
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                m.this.w(true, 4);
                m.this.iji = false;
                return true;
            }
        };
        this.ijp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.crN();
            }
        };
        this.fMS = new TbImageView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && m.this.fMK != null) {
                    m.this.fMK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.aaZ != null && !m.this.aaZ.isPlaying()) {
                    m.this.w(true, 1);
                }
            }
        };
        this.fMV = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.w(true, 4);
            }
        };
        this.ijq = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.ijg != null && m.this.ijg.eCR != null && videoId.equals(m.this.ijg.eCR.getId())) {
                        m.this.ijb.a(m.this.a(m.this.ijg, bVar));
                    }
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.m.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.ijr = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ijg == null) {
                    if (m.this.crI() != null) {
                        m.this.crI().a(view, m.this.ijg);
                        return;
                    }
                    return;
                }
                if (view == m.this.hbK.getUserName()) {
                    m.this.ijg.objType = 3;
                } else if (view == m.this.hbK.getHeaderImg()) {
                    m.this.ijg.objType = 4;
                } else {
                    m.this.ijg.objType = 1;
                }
                if (m.this.crI() != null) {
                    m.this.crI().a(view, m.this.ijg);
                }
            }
        };
        this.ijs = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ijg != null) {
                    m.this.ijg.objType = 4;
                }
                if (m.this.crI() != null) {
                    m.this.crI().a(view, m.this.ijg);
                }
            }
        };
        this.ijt = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.m.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.ijk = false;
                }
            }
        };
        this.fdj = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ijg != null) {
                    if (m.this.crI() != null) {
                        m.this.crI().a(view, m.this.ijg);
                    }
                    if (m.this.ijg.eCR != null && view != m.this.hcx.fdq) {
                        n.Jq(m.this.ijg.eCR.getId());
                        if (!m.this.crR()) {
                            n.a(m.this.mTextTitle, m.this.ijg.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                            n.a(m.this.ijd.getGodReplyContent(), m.this.ijg.bmn().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                        }
                    }
                }
            }
        };
        this.iju = new f.a() { // from class: com.baidu.tieba.card.m.11
            @Override // com.baidu.tieba.play.f.a
            public void se() {
                if (m.this.ijg != null && m.this.ijg.eCR != null && m.this.ijg.eCR.bph() != null) {
                    m.this.crO();
                }
            }
        };
        this.ijv = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.fMK != null) {
                    m.this.fMK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eNx = tbPageContext;
        View view = getView();
        this.hbJ = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ije = (HeadPendantClickableView) this.hbJ.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.ije.getHeadView() != null) {
            this.ije.getHeadView().setIsRound(true);
            this.ije.getHeadView().setDrawBorder(false);
            this.ije.getHeadView().setDefaultResource(17170445);
            this.ije.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ije.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.ds70));
            this.ije.getHeadView().setPlaceHolder(1);
        }
        this.ije.setHasPendantStyle();
        if (this.ije.getPendantView() != null) {
            this.ije.getPendantView().setIsRound(true);
            this.ije.getPendantView().setDrawBorder(false);
        }
        this.fMO = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fMO.setLoadingAnimationListener(this.ijp);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hbK = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hbW = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.hbW.a(this.hbJ, dimens, 0);
        this.hbL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.hbL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hbL.setLayoutParams(layoutParams);
        }
        this.hbL.setOnClickListener(this);
        this.hbL.setReplyTimeVisible(false);
        this.hbL.setShowPraiseNum(true);
        this.hbL.setNeedAddPraiseIcon(true);
        this.hbL.setNeedAddReplyIcon(true);
        this.hbL.setShareVisible(true);
        this.hbL.setShareReportFrom(3);
        this.hbL.setForumAfterClickListener(this.fdj);
        this.hbL.setFrom(1);
        this.hcx = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hcx.feb.setOnClickListener(this);
        this.hcx.setFrom(1);
        this.hcx.setShareReportFrom(3);
        this.hcx.setForumAfterClickListener(this.fdj);
        this.ijc = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fMI = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fMI.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eNx.getPageActivity()) - (com.baidu.tbadk.a.d.bkA() ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2 : (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fMI.setLayoutParams(layoutParams2);
        this.fMK = (TbImageView) view.findViewById(R.id.image_video);
        this.fMK.setDefaultErrorResource(0);
        this.fMK.setPlaceHolder(3);
        this.fMK.setGifIconSupport(false);
        this.fMK.setEvent(this.fMS);
        this.fMK.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fMK;
        TbImageView tbImageView2 = this.fMK;
        tbImageView.setConrers(15);
        this.fMK.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fMK.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fMK.setBorderSurroundContent(true);
        this.fMK.setDrawBorder(true);
        this.fML = (ImageView) view.findViewById(R.id.image_video_play);
        this.hbJ.setOnClickListener(this);
        this.aaZ = new TbCyberVideoView(getContext());
        this.aaZ.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fMI.addView(this.aaZ.getView(), 0);
        this.aaZ.getView().setLayoutParams(layoutParams3);
        this.aaZ.setContinuePlayEnable(true);
        this.aaZ.setOnPreparedListener(this.ety);
        this.aaZ.setOnInfoListener(this.etB);
        this.aaZ.setOnCompletionListener(this.etA);
        this.aaZ.setOnErrorListener(this.etz);
        this.aaZ.setOnSurfaceDestroyedListener(this.fMW);
        this.gqU = new com.baidu.tieba.play.f();
        this.gqU.setPlayer(this.aaZ);
        this.gqU.a(this.iju);
        this.fMJ = (TextView) view.findViewById(R.id.text_video_duration);
        this.ijf = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fMQ = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fMP = view.findViewById(R.id.auto_video_black_mask);
        this.fMM = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fMN = view.findViewById(R.id.auto_video_error_background);
        this.gfN = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.cbR = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.cbR.setAnimationListener(this.ijv);
        this.ijd = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.ijd.setOnClickListener(this);
        this.fYd = view.findViewById(R.id.divider_line);
        this.ijl = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.aaZ.getView().setOnClickListener(this);
        this.ijn = (TextView) view.findViewById(R.id.nani_video_icon);
        this.ijb = new com.baidu.afd.videopaster.d(getContext(), this.fMI);
        this.ijb.a(new d.a() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rT() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rS() {
                if (!m.this.ijm) {
                    m.this.aaZ.start();
                } else {
                    m.this.startPlay();
                }
                m.this.ijm = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rU() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.ijg != null && this.ijg.eCR != null && this.ijg.eCR.eLF > 0) {
            if (crI() != null) {
                crI().a(view, this.ijg);
            }
            this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eNx.getPageActivity(), this.ijg.eCR.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.boB(), this.ijg.bmq())));
            return;
        }
        if (view == this.hbJ || view == this.ijd) {
            cE(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.aaZ.getView()) {
            if (this.ijg != null) {
                this.ijg.objType = 5;
            }
            if (this.ijg != null && this.ijg.eCR != null && this.ijg.eCR.bph() != null) {
                z = this.ijg.eCR.bph().is_vertical.intValue() == 1;
            }
            if (z) {
                cC(this.aaZ.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cD(this.aaZ.getView());
            } else {
                cE(getView());
            }
        }
    }

    private void cC(View view) {
        if (crI() != null) {
            crI().a(view, this.ijg);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eNx.getPageActivity(), R.string.no_network_guide);
        } else {
            crP();
        }
    }

    private void cD(View view) {
        if (crI() != null) {
            crI().a(view, this.ijg);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eNx.getPageActivity(), R.string.no_network_guide);
        } else {
            crQ();
        }
    }

    private void crP() {
        if (this.ijg != null && this.ijg.eCR != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ijg.eCR);
            videoItemData.mRecomExtra = this.ijg.getExtra();
            videoItemData.mRecomAbTag = this.ijg.cst();
            videoItemData.mRecomSource = this.ijg.getSource();
            videoItemData.mRecomWeight = this.ijg.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.ijg.bmq(), "index");
            if (this.ijg.eCR.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.ijg.eCR.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void crQ() {
        if (this.ijg != null && this.ijg.eCR != null && this.ijg.eCR.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ijg.eCR);
            videoSerializeVideoThreadInfo.source = this.ijg.getSource();
            videoSerializeVideoThreadInfo.extra = this.ijg.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.ijg.cst();
            videoSerializeVideoThreadInfo.weight = this.ijg.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.gfN.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.gfN.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!au.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eNx.getPageActivity(), str, this.ijg.eCR.getTid(), n.boB(), this.ijg.bmq(), videoSerializeVideoThreadInfo);
            if (this.ijg.bmn() != null && this.ijg.bmn().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.ijg.bmn().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cE(View view) {
        if (this.ijg != null) {
            this.ijg.objType = 1;
        }
        if (crI() != null) {
            crI().a(view, this.ijg);
        }
        if (this.ijg != null && this.ijg.eCR != null) {
            if (!crR()) {
                n.Jq(this.ijg.eCR.getId());
                n.a(this.mTextTitle, this.ijg.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eNx.getPageActivity()).createFromThreadCfg(this.ijg.eCR, null, n.boB(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.ijg.bmq());
            addLocateParam.setVideo_source(this.ijg.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.ijg.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.ijg.eCR.getFid()));
            addLocateParam.setForumName(this.ijg.eCR.boT());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.ijd) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crR() {
        return this.ijg.iny && !this.ijg.inD;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.ijg = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crS() {
        this.ijo.removeMessages(202);
        if (this.aaZ.getCurrentPositionSync() > this.abg) {
            w(false, 3);
            this.ijo.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.ijo.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crT() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ijo.removeMessages(203);
        int currentPositionSync = this.aaZ.getCurrentPositionSync();
        if (currentPositionSync != this.ijh) {
            this.ijh = currentPositionSync;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.ijo.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fML != null && this.fMK != null && this.fMP != null && this.fMO != null && this.fMN != null && this.fMM != null) {
            if (z || this.fMR != i) {
                this.fMR = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMV);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
                if (i == 2) {
                    this.fML.setVisibility(8);
                    this.cbR.cancel();
                    this.fMK.clearAnimation();
                    this.fMK.setVisibility(0);
                    this.fMP.setVisibility(0);
                    this.ijf.setVisibility(0);
                    this.ijl.setVisibility(8);
                    this.fMO.startLoading();
                    this.fMN.setVisibility(8);
                    this.fMM.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fMV, 60000L);
                } else if (i == 3) {
                    this.fML.setVisibility(8);
                    this.fMK.startAnimation(this.cbR);
                    this.fMP.setVisibility(8);
                    this.ijf.setVisibility(8);
                    if (this.ijg != null && this.ijg.bmn() != null && this.ijg.bmn().eLF > 0) {
                        this.ijl.setVisibility(0);
                    }
                    this.fMO.dBU();
                    this.fMN.setVisibility(8);
                    this.fMM.setVisibility(8);
                    if (this.ijg != null && this.ijg.eCR != null && this.ijg.eCR.bph() != null) {
                        this.ijg.eCR.bph().video_length.intValue();
                        this.ijg.eCR.bph().video_duration.intValue();
                        this.ijg.eCR.getTid();
                    }
                } else if (i == 4) {
                    this.fML.setVisibility(8);
                    this.fMK.startAnimation(this.cbR);
                    this.fMP.setVisibility(8);
                    this.fMO.dBV();
                    this.fMN.setVisibility(0);
                    this.fMM.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fMU, 2000L);
                } else {
                    this.fML.setVisibility(0);
                    this.cbR.cancel();
                    this.fMK.clearAnimation();
                    this.fMK.setVisibility(0);
                    this.fMP.setVisibility(0);
                    this.ijf.setVisibility(0);
                    this.fMO.dBV();
                    this.fMN.setVisibility(8);
                    this.fMM.setVisibility(8);
                }
                if (this.ijg != null && this.ijg.bmn() != null && this.ijg.bmn().eLF > 0) {
                    this.ijf.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ijg == null || this.ijg.eCR == null || this.ijg.eCR.boP() == null) {
            this.hbJ.setVisibility(8);
            return;
        }
        this.hbJ.setVisibility(0);
        crV();
        if (!crR() && n.Jr(this.ijg.eCR.getId())) {
            n.a(this.mTextTitle, this.ijg.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.ijd.getGodReplyContent(), this.ijg.bmn().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        this.ijg.bmn().bpP();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ijg.bmn().bpz());
        if (this.ijg.bmn().bpF() && !StringUtils.isNull(this.ijg.bmn().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ijg.bmn().getTid();
            spannableStringBuilder.append((CharSequence) this.ijg.bmn().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.m.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ar("c12841").dY("obj_source", "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.hbK.setData(this.ijg.bmn());
        this.hbK.setUserAfterClickListener(this.ijr);
        if (this.hbK.getHeaderImg() != null) {
            this.hbK.getHeaderImg().setAfterClickListener(this.ijs);
            if (this.hbK.getIsSimpleThread()) {
                this.hbK.getHeaderImg().setVisibility(8);
                this.ije.setVisibility(8);
            } else if (this.ijg.bmn() == null || this.ijg.bmn().boP() == null || this.ijg.bmn().boP().getPendantData() == null || StringUtils.isNull(this.ijg.bmn().boP().getPendantData().bmL())) {
                this.ije.setVisibility(8);
                this.hbK.getHeaderImg().setVisibility(0);
                if (this.ijg.bmn().eLF > 0 && this.ijg.bmn().eLG == 0) {
                    this.ijg.bmn().boP().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.hbK.getHeaderImg().setData(this.ijg.bmn(), false);
                } else {
                    this.hbK.getHeaderImg().setData(this.ijg.bmn());
                    this.hbK.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.hbK.getHeaderImg().setVisibility(4);
                this.ije.setVisibility(0);
                this.ije.setData(this.ijg.bmn());
            }
        }
        this.fMJ.setText(au.stringForVideoTime(this.ijg.eCR.bph().video_duration.intValue() * 1000));
        this.fMQ.setText(String.format(this.eNx.getResources().getString(R.string.play_count), au.numFormatOverWan(this.ijg.eCR.bph().play_count.intValue())));
        if (this.hbW != null && this.ijg.bmn() != null) {
            at atVar = new at();
            atVar.setTid(this.ijg.bmn().getTid());
            atVar.setFid(this.ijg.bmn().getFid());
            atVar.setNid(this.ijg.bmn().getNid());
            atVar.setFeedBackReasonMap(this.ijg.feedBackReasonMap);
            this.hbW.setData(atVar);
            this.hbW.setFirstRowSingleColumn(true);
            this.hbW.setVisibility(this.ijj ? 0 : 8);
        }
        this.ijd.setData(this.ijg.bmn().bqu());
        wk(ul(1));
        onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        if (n.Jr(this.ijg.eCR.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.ijg == null || this.ijg.eCR == null || this.ijg.eCR.bph() == null) {
            z = false;
        } else {
            z = this.ijg.eCR.bph().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ijn.setVisibility(0);
            if (crW()) {
                this.ijn.setText(String.format("%s | %s", this.eNx.getResources().getString(R.string.nani_video), this.eNx.getResources().getString(R.string.video_preview)));
            } else {
                this.ijn.setText(this.eNx.getString(R.string.nani_video));
            }
        } else if (crW()) {
            this.ijn.setVisibility(0);
            this.ijn.setText(this.eNx.getString(R.string.video_preview));
        } else {
            this.ijn.setVisibility(8);
        }
    }

    private void crU() {
        this.ijo.removeMessages(202);
        this.ijo.removeMessages(203);
    }

    private void bIm() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMV);
    }

    private void crV() {
        bIm();
        crU();
        if (this.fMK != null && this.fMI != null && this.aaZ != null) {
            if (com.baidu.tbadk.core.k.blV().isShowImages() && this.ijg != null && this.ijg.eCR != null && this.ijg.eCR.bph() != null) {
                this.fMK.setPlaceHolder(3);
                this.fMK.startLoad(this.ijg.eCR.bph().thumbnail_url, 10, false);
                this.fMI.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.ijg.eCR.bph().video_url;
                if (crW()) {
                    this.mVideoUrl = this.ijg.eCR.bpi().video_url;
                }
                if (StringUtils.isNull(this.ijg.eCR.bph().video_url)) {
                    w(true, 4);
                }
                this.aaZ.setThreadDataForStatistic(this.ijg.eCR);
            } else {
                this.fMI.setVisibility(8);
            }
            this.ijb.reset();
            this.gqU.a(new f.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.f.b
                public void ci(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.ijb.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.ijg);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.eCR != null) {
            by byVar = lVar.eCR;
            if (byVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, byVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.eCR == null || bVar == null) {
            return null;
        }
        by byVar = lVar.eCR;
        int rY = bVar.rY();
        int rZ = bVar.rZ();
        int rX = bVar.rX();
        if (rX != -1) {
            i = rY != -1 ? (rX - rY) - 1 : -1;
            if (rZ != -1) {
                i4 = (rZ - rX) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo bph = byVar.bph();
        if (bph != null) {
            i3 = bph.video_width.intValue();
            i2 = bph.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", byVar.getId());
        hashMap.put("video_title", byVar.getTitle());
        hashMap.put("forum_id", String.valueOf(byVar.getFid()));
        hashMap.put("forum_name", byVar.boT());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rX + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hbJ, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fML, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fMM, R.color.CAM_X0101);
            ap.setViewTextColor(this.fMJ, R.color.CAM_X0101);
            ap.setViewTextColor(this.fMQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.ijl, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fMN, R.color.common_color_10014);
            ap.setBackgroundColor(this.fYd, R.color.CAM_X0204);
            if (this.ijn != null) {
                ap.setViewTextColor(this.ijn, R.color.CAM_X0101);
                ap.setBackgroundResource(this.ijn, R.drawable.video_play_count_bg);
            }
            if (this.fMM != null) {
                this.fMM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.ijd.onChangeSkinType();
            if (this.hbW != null) {
                this.hbW.onChangeSkinType();
            }
            this.hbK.onChangeSkinType();
            this.hbL.onChangeSkinType();
            this.hcx.onChangeSkinType();
            this.fMK.setPlaceHolder(3);
            this.ije.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ijt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ijt);
            this.ijq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ijq);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hbK != null) {
            this.hbK.setPageUniqueId(bdUniqueId);
        }
        if (this.fMK != null) {
            this.fMK.setPageId(bdUniqueId);
        }
        if (this.hbW != null) {
            this.hbW.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.iji;
    }

    public boolean isPlaying() {
        if (this.aaZ == null) {
            return false;
        }
        return this.aaZ.isPlaying();
    }

    public void startPlay() {
        if (!this.iji && this.ijg != null && this.ijg.eCR != null && this.ijg.eCR.bph() != null && this.aaZ != null) {
            if (this.ijb.rC()) {
                this.ijb.resume();
                this.ijm = true;
                return;
            }
            this.ijm = false;
            this.aaZ.stopPlayback();
            if (ai.aI(1, this.mVideoUrl)) {
                w(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new ar("c12619").dY("obj_locate", "index").dY("tid", this.ijg.tid));
                    this.mVideoUrl = this.ijg.eCR.bph().video_url;
                }
                this.iji = true;
                this.aaZ.setVideoPath(this.mVideoUrl, this.ijg.tid);
                if (this.gqU != null) {
                    this.gqU.start();
                }
                crO();
            }
        }
    }

    public void stopPlay() {
        this.ijm = false;
        bIm();
        crU();
        w(true, 1);
        if (this.aaZ != null) {
            this.aaZ.stopPlayback();
            if (this.gqU != null) {
                this.gqU.stop();
            }
        }
        this.iji = false;
        this.ijb.stop();
    }

    public View getVideoContainer() {
        return this.fMI;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.aaZ == null) {
            return 0;
        }
        return this.aaZ.getCurrentPosition();
    }

    public void oQ(boolean z) {
        this.ijj = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void wk(int i) {
        if (this.ijg != null && this.ijg.eCR != null) {
            if (i == 1) {
                if (this.ijg.eCR.eLF > 0) {
                    this.hcx.feb.setShowPraiseNum(false);
                    this.hcx.feb.setShareVisible(false);
                    this.ijl.setText(au.numFormatOverWan(this.ijg.eCR.eLF));
                    this.ijl.setVisibility(0);
                } else {
                    this.hcx.feb.setShowPraiseNum(true);
                    this.hcx.feb.setShareVisible(true);
                    this.ijl.setVisibility(8);
                }
                this.hcx.setData(this.ijg.eCR);
                this.hbL.setVisibility(8);
                this.hbK.jK(false);
                return;
            }
            this.hcx.setVisibility(8);
            this.hbK.jK(true);
            if (this.ijg.eCR.eLF > 0) {
                this.hbL.setShowPraiseNum(false);
                this.hbL.setShareVisible(false);
                this.ijl.setText(au.numFormatOverWan(this.ijg.eCR.eLF));
                this.ijl.setVisibility(0);
            } else {
                this.hbL.setShowPraiseNum(true);
                this.hbL.setShareVisible(true);
                this.ijl.setVisibility(8);
            }
            if (this.hbL.setData(this.ijg.eCR)) {
                this.ijc.setVisibility(8);
            } else {
                this.ijc.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLT().ax(this.aiw, i);
    }

    private boolean crW() {
        return (this.ijg == null || this.ijg.eCR == null || this.ijg.eCR.bpi() == null || TextUtils.isEmpty(this.ijg.eCR.bpi().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.ijb.onDestroy();
    }
}
