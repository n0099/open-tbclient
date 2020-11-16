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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
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
import com.baidu.tbadk.util.ah;
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
/* loaded from: classes20.dex */
public class m extends b<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView aae;
    private int aak;
    private String ahw;
    private Animation bWC;
    private TbPageContext<?> eGu;
    private final View.OnClickListener eVM;
    private CyberPlayerManager.OnPreparedListener emw;
    private CyberPlayerManager.OnErrorListener emx;
    private CyberPlayerManager.OnCompletionListener emy;
    private CyberPlayerManager.OnInfoListener emz;
    public FrameLayout fEW;
    private TextView fEX;
    private TbImageView fEY;
    private ImageView fEZ;
    private TextView fFa;
    private View fFb;
    private com.baidu.tieba.play.m fFc;
    private View fFd;
    private TextView fFe;
    private int fFf;
    private TbImageView.a fFg;
    private Runnable fFi;
    private Runnable fFj;
    private TbCyberVideoView.a fFk;
    private View fPU;
    protected LinearLayout fXC;
    private NEGFeedBackView gSJ;
    private RelativeLayout gSw;
    public ThreadUserInfoLayout gSx;
    public ThreadCommentAndPraiseInfoLayout gSy;
    public ThreadSourceShareAndPraiseLayout gTk;
    private com.baidu.tieba.play.f giL;
    private com.baidu.afd.videopaster.d hYe;
    private View hYf;
    public ThreadGodReplyLayout hYg;
    private HeadPendantClickableView hYh;
    private LinearLayout hYi;
    private com.baidu.tieba.card.data.l hYj;
    private int hYk;
    private boolean hYl;
    private boolean hYm;
    private boolean hYn;
    private TextView hYo;
    private boolean hYp;
    private TextView hYq;
    private Handler hYr;
    private VideoLoadingProgressView.a hYs;
    private CustomMessageListener hYt;
    private final View.OnClickListener hYu;
    private final View.OnClickListener hYv;
    private CustomMessageListener hYw;
    private f.a hYx;
    private Animation.AnimationListener hYy;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnA() {
        if (this.aae != null && this.hYl) {
            try {
                this.aae.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Qf = com.baidu.tieba.play.n.dwH().Qf(this.mVideoUrl);
            if (Qf <= 100 || this.aae.getDuration() <= Qf) {
                Qf = 100;
            }
            this.aak = Qf;
            this.hYr.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnB() {
        if (this.hYj != null && this.hYj.evQ != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.hYj.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.alZ = this.hYj.evQ.getTid();
            oVar.fyg = this.hYj.evQ.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.hYj.evQ.mRecomSource;
            oVar.mko = this.hYj.evQ.mRecomAbTag;
            oVar.mkk = this.hYj.evQ.mRecomAbTag;
            oVar.mkl = this.hYj.evQ.mRecomWeight;
            oVar.mkm = "";
            oVar.ezo = this.hYj.getExtra();
            if (this.hYj.evQ.blU() != null) {
                oVar.mkp = this.hYj.evQ.blU().video_md5;
            }
            com.baidu.tieba.play.h.a(this.hYj.evQ.blU().video_md5, "", "1", oVar, this.aae.getPcdnState());
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gSJ = null;
        this.mSkinType = 3;
        this.hYk = 0;
        this.fFf = 1;
        this.hYl = false;
        this.hYm = true;
        this.hYn = false;
        this.aak = 100;
        this.hYp = false;
        this.hYr = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.cnF();
                        return;
                    case 203:
                        m.this.cnG();
                        return;
                    default:
                        return;
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (m.this.aae != null) {
                    m.this.aae.setVolume(0.0f, 0.0f);
                }
                m.this.cnA();
            }
        };
        this.emz = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.m.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    m.this.w(false, 3);
                }
                return false;
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.m.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!m.this.hYe.a(false, false, "NEWINDEX")) {
                    m.this.aae.start();
                }
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                m.this.w(true, 4);
                m.this.hYl = false;
                return true;
            }
        };
        this.hYs = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.cnA();
            }
        };
        this.fFg = new TbImageView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && m.this.fEY != null) {
                    m.this.fEY.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fFi = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.aae != null && !m.this.aae.isPlaying()) {
                    m.this.w(true, 1);
                }
            }
        };
        this.fFj = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.w(true, 4);
            }
        };
        this.hYt = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.hYj != null && m.this.hYj.evQ != null && videoId.equals(m.this.hYj.evQ.getId())) {
                        m.this.hYe.a(m.this.a(m.this.hYj, bVar));
                    }
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.m.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.hYu = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hYj == null) {
                    if (m.this.cnv() != null) {
                        m.this.cnv().a(view, m.this.hYj);
                        return;
                    }
                    return;
                }
                if (view == m.this.gSx.getUserName()) {
                    m.this.hYj.objType = 3;
                } else if (view == m.this.gSx.getHeaderImg()) {
                    m.this.hYj.objType = 4;
                } else {
                    m.this.hYj.objType = 1;
                }
                if (m.this.cnv() != null) {
                    m.this.cnv().a(view, m.this.hYj);
                }
            }
        };
        this.hYv = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hYj != null) {
                    m.this.hYj.objType = 4;
                }
                if (m.this.cnv() != null) {
                    m.this.cnv().a(view, m.this.hYj);
                }
            }
        };
        this.hYw = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.m.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.hYn = false;
                }
            }
        };
        this.eVM = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hYj != null) {
                    if (m.this.cnv() != null) {
                        m.this.cnv().a(view, m.this.hYj);
                    }
                    if (m.this.hYj.evQ != null && view != m.this.gTk.eVT) {
                        n.IA(m.this.hYj.evQ.getId());
                        if (!m.this.cnE()) {
                            n.a(m.this.mTextTitle, m.this.hYj.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                            n.a(m.this.hYg.getGodReplyContent(), m.this.hYj.bjd().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                        }
                    }
                }
            }
        };
        this.hYx = new f.a() { // from class: com.baidu.tieba.card.m.11
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                if (m.this.hYj != null && m.this.hYj.evQ != null && m.this.hYj.evQ.blU() != null) {
                    m.this.cnB();
                }
            }
        };
        this.hYy = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.fEY != null) {
                    m.this.fEY.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eGu = tbPageContext;
        View view = getView();
        this.gSw = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hYh = (HeadPendantClickableView) this.gSw.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hYh.getHeadView() != null) {
            this.hYh.getHeadView().setIsRound(true);
            this.hYh.getHeadView().setDrawBorder(false);
            this.hYh.getHeadView().setDefaultResource(17170445);
            this.hYh.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hYh.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.ds70));
            this.hYh.getHeadView().setPlaceHolder(1);
        }
        this.hYh.setHasPendantStyle();
        if (this.hYh.getPendantView() != null) {
            this.hYh.getPendantView().setIsRound(true);
            this.hYh.getPendantView().setDrawBorder(false);
        }
        this.fFc = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fFc.setLoadingAnimationListener(this.hYs);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gSx = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gSJ = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.gSJ.a(this.gSw, dimens, 0);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.gSy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSy.setLayoutParams(layoutParams);
        }
        this.gSy.setOnClickListener(this);
        this.gSy.setReplyTimeVisible(false);
        this.gSy.setShowPraiseNum(true);
        this.gSy.setNeedAddPraiseIcon(true);
        this.gSy.setNeedAddReplyIcon(true);
        this.gSy.setShareVisible(true);
        this.gSy.setShareReportFrom(3);
        this.gSy.setForumAfterClickListener(this.eVM);
        this.gSy.setFrom(1);
        this.gTk = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gTk.eWE.setOnClickListener(this);
        this.gTk.setFrom(1);
        this.gTk.setShareReportFrom(3);
        this.gTk.setForumAfterClickListener(this.eVM);
        this.hYf = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fEW = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fEW.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eGu.getPageActivity()) - (com.baidu.tbadk.a.d.bhw() ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2 : (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fEW.setLayoutParams(layoutParams2);
        this.fEY = (TbImageView) view.findViewById(R.id.image_video);
        this.fEY.setDefaultErrorResource(0);
        this.fEY.setPlaceHolder(3);
        this.fEY.setGifIconSupport(false);
        this.fEY.setEvent(this.fFg);
        this.fEY.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fEY;
        TbImageView tbImageView2 = this.fEY;
        tbImageView.setConrers(15);
        this.fEY.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fEY.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fEY.setBorderSurroundContent(true);
        this.fEY.setDrawBorder(true);
        this.fEZ = (ImageView) view.findViewById(R.id.image_video_play);
        this.gSw.setOnClickListener(this);
        this.aae = new TbCyberVideoView(getContext());
        this.aae.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fEW.addView(this.aae.getView(), 0);
        this.aae.getView().setLayoutParams(layoutParams3);
        this.aae.setContinuePlayEnable(true);
        this.aae.setOnPreparedListener(this.emw);
        this.aae.setOnInfoListener(this.emz);
        this.aae.setOnCompletionListener(this.emy);
        this.aae.setOnErrorListener(this.emx);
        this.aae.setOnSurfaceDestroyedListener(this.fFk);
        this.giL = new com.baidu.tieba.play.f();
        this.giL.setPlayer(this.aae);
        this.giL.a(this.hYx);
        this.fEX = (TextView) view.findViewById(R.id.text_video_duration);
        this.hYi = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fFe = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fFd = view.findViewById(R.id.auto_video_black_mask);
        this.fFa = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fFb = view.findViewById(R.id.auto_video_error_background);
        this.fXC = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bWC = AnimationUtils.loadAnimation(this.eGu.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bWC.setAnimationListener(this.hYy);
        this.hYg = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hYg.setOnClickListener(this);
        this.fPU = view.findViewById(R.id.divider_line);
        this.hYo = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.aae.getView().setOnClickListener(this);
        this.hYq = (TextView) view.findViewById(R.id.nani_video_icon);
        this.hYe = new com.baidu.afd.videopaster.d(getContext(), this.fEW);
        this.hYe.a(new d.a() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rQ() {
                if (!m.this.hYp) {
                    m.this.aae.start();
                } else {
                    m.this.startPlay();
                }
                m.this.hYp = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rP() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rS() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.hYj != null && this.hYj.evQ != null && this.hYj.evQ.eED > 0) {
            if (cnv() != null) {
                cnv().a(view, this.hYj);
            }
            this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eGu.getPageActivity(), this.hYj.evQ.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.blo(), this.hYj.bjg())));
            return;
        }
        if (view == this.gSw || view == this.hYg) {
            cx(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.aae.getView()) {
            if (this.hYj != null) {
                this.hYj.objType = 5;
            }
            if (this.hYj != null && this.hYj.evQ != null && this.hYj.evQ.blU() != null) {
                z = this.hYj.evQ.blU().is_vertical.intValue() == 1;
            }
            if (z) {
                cv(this.aae.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cw(this.aae.getView());
            } else {
                cx(getView());
            }
        }
    }

    private void cv(View view) {
        if (cnv() != null) {
            cnv().a(view, this.hYj);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eGu.getPageActivity(), R.string.no_network_guide);
        } else {
            cnC();
        }
    }

    private void cw(View view) {
        if (cnv() != null) {
            cnv().a(view, this.hYj);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eGu.getPageActivity(), R.string.no_network_guide);
        } else {
            cnD();
        }
    }

    private void cnC() {
        if (this.hYj != null && this.hYj.evQ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.hYj.evQ);
            videoItemData.mRecomExtra = this.hYj.getExtra();
            videoItemData.mRecomAbTag = this.hYj.cog();
            videoItemData.mRecomSource = this.hYj.getSource();
            videoItemData.mRecomWeight = this.hYj.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.hYj.bjg(), "index");
            if (this.hYj.evQ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.hYj.evQ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cnD() {
        if (this.hYj != null && this.hYj.evQ != null && this.hYj.evQ.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.hYj.evQ);
            videoSerializeVideoThreadInfo.source = this.hYj.getSource();
            videoSerializeVideoThreadInfo.extra = this.hYj.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.hYj.cog();
            videoSerializeVideoThreadInfo.weight = this.hYj.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fXC.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fXC.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!au.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eGu.getPageActivity(), str, this.hYj.evQ.getTid(), n.blo(), this.hYj.bjg(), videoSerializeVideoThreadInfo);
            if (this.hYj.bjd() != null && this.hYj.bjd().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.hYj.bjd().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cx(View view) {
        if (this.hYj != null) {
            this.hYj.objType = 1;
        }
        if (cnv() != null) {
            cnv().a(view, this.hYj);
        }
        if (this.hYj != null && this.hYj.evQ != null) {
            if (!cnE()) {
                n.IA(this.hYj.evQ.getId());
                n.a(this.mTextTitle, this.hYj.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eGu.getPageActivity()).createFromThreadCfg(this.hYj.evQ, null, n.blo(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hYj.bjg());
            addLocateParam.setVideo_source(this.hYj.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.hYj.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.hYj.evQ.getFid()));
            addLocateParam.setForumName(this.hYj.evQ.blG());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.hYg) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnE() {
        return this.hYj.icA && !this.hYj.icF;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.hYj = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnF() {
        this.hYr.removeMessages(202);
        if (this.aae.getCurrentPositionSync() > this.aak) {
            w(false, 3);
            this.hYr.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hYr.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnG() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hYr.removeMessages(203);
        int currentPositionSync = this.aae.getCurrentPositionSync();
        if (currentPositionSync != this.hYk) {
            this.hYk = currentPositionSync;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hYr.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fEZ != null && this.fEY != null && this.fFd != null && this.fFc != null && this.fFb != null && this.fFa != null) {
            if (z || this.fFf != i) {
                this.fFf = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFj);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFi);
                if (i == 2) {
                    this.fEZ.setVisibility(8);
                    this.bWC.cancel();
                    this.fEY.clearAnimation();
                    this.fEY.setVisibility(0);
                    this.fFd.setVisibility(0);
                    this.hYi.setVisibility(0);
                    this.hYo.setVisibility(8);
                    this.fFc.startLoading();
                    this.fFb.setVisibility(8);
                    this.fFa.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFj, 60000L);
                } else if (i == 3) {
                    this.fEZ.setVisibility(8);
                    this.fEY.startAnimation(this.bWC);
                    this.fFd.setVisibility(8);
                    this.hYi.setVisibility(8);
                    if (this.hYj != null && this.hYj.bjd() != null && this.hYj.bjd().eED > 0) {
                        this.hYo.setVisibility(0);
                    }
                    this.fFc.dwC();
                    this.fFb.setVisibility(8);
                    this.fFa.setVisibility(8);
                    if (this.hYj != null && this.hYj.evQ != null && this.hYj.evQ.blU() != null) {
                        this.hYj.evQ.blU().video_length.intValue();
                        this.hYj.evQ.blU().video_duration.intValue();
                        this.hYj.evQ.getTid();
                    }
                } else if (i == 4) {
                    this.fEZ.setVisibility(8);
                    this.fEY.startAnimation(this.bWC);
                    this.fFd.setVisibility(8);
                    this.fFc.dwD();
                    this.fFb.setVisibility(0);
                    this.fFa.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFi, 2000L);
                } else {
                    this.fEZ.setVisibility(0);
                    this.bWC.cancel();
                    this.fEY.clearAnimation();
                    this.fEY.setVisibility(0);
                    this.fFd.setVisibility(0);
                    this.hYi.setVisibility(0);
                    this.fFc.dwD();
                    this.fFb.setVisibility(8);
                    this.fFa.setVisibility(8);
                }
                if (this.hYj != null && this.hYj.bjd() != null && this.hYj.bjd().eED > 0) {
                    this.hYi.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.hYj == null || this.hYj.evQ == null || this.hYj.evQ.blC() == null) {
            this.gSw.setVisibility(8);
            return;
        }
        this.gSw.setVisibility(0);
        cnI();
        if (!cnE() && n.IB(this.hYj.evQ.getId())) {
            n.a(this.mTextTitle, this.hYj.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.hYg.getGodReplyContent(), this.hYj.bjd().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        this.hYj.bjd().bmC();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hYj.bjd().bmm());
        if (this.hYj.bjd().bms() && !StringUtils.isNull(this.hYj.bjd().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bpu().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.hYj.bjd().getTid();
            spannableStringBuilder.append((CharSequence) this.hYj.bjd().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.m.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ar("c12841").dR("obj_source", "0"));
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
        this.gSx.setData(this.hYj.bjd());
        this.gSx.setUserAfterClickListener(this.hYu);
        if (this.gSx.getHeaderImg() != null) {
            this.gSx.getHeaderImg().setAfterClickListener(this.hYv);
            if (this.gSx.getIsSimpleThread()) {
                this.gSx.getHeaderImg().setVisibility(8);
                this.hYh.setVisibility(8);
            } else if (this.hYj.bjd() == null || this.hYj.bjd().blC() == null || this.hYj.bjd().blC().getPendantData() == null || StringUtils.isNull(this.hYj.bjd().blC().getPendantData().bjy())) {
                this.hYh.setVisibility(8);
                this.gSx.getHeaderImg().setVisibility(0);
                if (this.hYj.bjd().eED > 0 && this.hYj.bjd().eEE == 0) {
                    this.hYj.bjd().blC().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.gSx.getHeaderImg().setData(this.hYj.bjd(), false);
                } else {
                    this.gSx.getHeaderImg().setData(this.hYj.bjd());
                    this.gSx.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.gSx.getHeaderImg().setVisibility(4);
                this.hYh.setVisibility(0);
                this.hYh.setData(this.hYj.bjd());
            }
        }
        this.fEX.setText(au.stringForVideoTime(this.hYj.evQ.blU().video_duration.intValue() * 1000));
        this.fFe.setText(String.format(this.eGu.getResources().getString(R.string.play_count), au.numFormatOverWan(this.hYj.evQ.blU().play_count.intValue())));
        if (this.gSJ != null && this.hYj.bjd() != null) {
            as asVar = new as();
            asVar.setTid(this.hYj.bjd().getTid());
            asVar.setFid(this.hYj.bjd().getFid());
            asVar.setNid(this.hYj.bjd().getNid());
            asVar.setFeedBackReasonMap(this.hYj.feedBackReasonMap);
            this.gSJ.setData(asVar);
            this.gSJ.setFirstRowSingleColumn(true);
            this.gSJ.setVisibility(this.hYm ? 0 : 8);
        }
        this.hYg.setData(this.hYj.bjd().bnh());
        vD(tH(1));
        onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
        if (n.IB(this.hYj.evQ.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.hYj == null || this.hYj.evQ == null || this.hYj.evQ.blU() == null) {
            z = false;
        } else {
            z = this.hYj.evQ.blU().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hYq.setVisibility(0);
            if (cnJ()) {
                this.hYq.setText(String.format("%s | %s", this.eGu.getResources().getString(R.string.nani_video), this.eGu.getResources().getString(R.string.video_preview)));
            } else {
                this.hYq.setText(this.eGu.getString(R.string.nani_video));
            }
        } else if (cnJ()) {
            this.hYq.setVisibility(0);
            this.hYq.setText(this.eGu.getString(R.string.video_preview));
        } else {
            this.hYq.setVisibility(8);
        }
    }

    private void cnH() {
        this.hYr.removeMessages(202);
        this.hYr.removeMessages(203);
    }

    private void bEL() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFi);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFj);
    }

    private void cnI() {
        bEL();
        cnH();
        if (this.fEY != null && this.fEW != null && this.aae != null) {
            if (com.baidu.tbadk.core.k.biL().isShowImages() && this.hYj != null && this.hYj.evQ != null && this.hYj.evQ.blU() != null) {
                this.fEY.setPlaceHolder(3);
                this.fEY.startLoad(this.hYj.evQ.blU().thumbnail_url, 10, false);
                this.fEW.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.hYj.evQ.blU().video_url;
                if (cnJ()) {
                    this.mVideoUrl = this.hYj.evQ.blV().video_url;
                }
                if (StringUtils.isNull(this.hYj.evQ.blU().video_url)) {
                    w(true, 4);
                }
                this.aae.setThreadDataForStatistic(this.hYj.evQ);
            } else {
                this.fEW.setVisibility(8);
            }
            this.hYe.reset();
            this.giL.a(new f.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.f.b
                public void ce(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.hYe.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.hYj);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.evQ != null) {
            bx bxVar = lVar.evQ;
            if (bxVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bxVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.evQ == null || bVar == null) {
            return null;
        }
        bx bxVar = lVar.evQ;
        int rW = bVar.rW();
        int rX = bVar.rX();
        int rV = bVar.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo blU = bxVar.blU();
        if (blU != null) {
            i3 = blU.video_width.intValue();
            i2 = blU.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bxVar.getId());
        hashMap.put("video_title", bxVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bxVar.getFid()));
        hashMap.put("forum_name", bxVar.blG());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gSw, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fEZ, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fFa, R.color.CAM_X0101);
            ap.setViewTextColor(this.fEX, R.color.CAM_X0101);
            ap.setViewTextColor(this.fFe, R.color.CAM_X0101);
            ap.setViewTextColor(this.hYo, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fFb, R.color.common_color_10014);
            ap.setBackgroundColor(this.fPU, R.color.CAM_X0204);
            if (this.hYq != null) {
                ap.setViewTextColor(this.hYq, R.color.CAM_X0101);
                ap.setBackgroundResource(this.hYq, R.drawable.video_play_count_bg);
            }
            if (this.fFa != null) {
                this.fFa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.hYg.onChangeSkinType();
            if (this.gSJ != null) {
                this.gSJ.onChangeSkinType();
            }
            this.gSx.onChangeSkinType();
            this.gSy.onChangeSkinType();
            this.gTk.onChangeSkinType();
            this.fEY.setPlaceHolder(3);
            this.hYh.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hYw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hYw);
            this.hYt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hYt);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gSx != null) {
            this.gSx.setPageUniqueId(bdUniqueId);
        }
        if (this.fEY != null) {
            this.fEY.setPageId(bdUniqueId);
        }
        if (this.gSJ != null) {
            this.gSJ.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.hYl;
    }

    public boolean isPlaying() {
        if (this.aae == null) {
            return false;
        }
        return this.aae.isPlaying();
    }

    public void startPlay() {
        if (!this.hYl && this.hYj != null && this.hYj.evQ != null && this.hYj.evQ.blU() != null && this.aae != null) {
            if (this.hYe.rA()) {
                this.hYe.resume();
                this.hYp = true;
                return;
            }
            this.hYp = false;
            this.aae.stopPlayback();
            if (ah.aI(1, this.mVideoUrl)) {
                w(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new ar("c12619").dR("obj_locate", "index").dR("tid", this.hYj.tid));
                    this.mVideoUrl = this.hYj.evQ.blU().video_url;
                }
                this.hYl = true;
                this.aae.setVideoPath(this.mVideoUrl, this.hYj.tid);
                if (this.giL != null) {
                    this.giL.start();
                }
                cnB();
            }
        }
    }

    public void stopPlay() {
        this.hYp = false;
        bEL();
        cnH();
        w(true, 1);
        if (this.aae != null) {
            this.aae.stopPlayback();
            if (this.giL != null) {
                this.giL.stop();
            }
        }
        this.hYl = false;
        this.hYe.stop();
    }

    public View getVideoContainer() {
        return this.fEW;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.aae == null) {
            return 0;
        }
        return this.aae.getCurrentPosition();
    }

    public void ou(boolean z) {
        this.hYm = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void vD(int i) {
        if (this.hYj != null && this.hYj.evQ != null) {
            if (i == 1) {
                if (this.hYj.evQ.eED > 0) {
                    this.gTk.eWE.setShowPraiseNum(false);
                    this.gTk.eWE.setShareVisible(false);
                    this.hYo.setText(au.numFormatOverWan(this.hYj.evQ.eED));
                    this.hYo.setVisibility(0);
                } else {
                    this.gTk.eWE.setShowPraiseNum(true);
                    this.gTk.eWE.setShareVisible(true);
                    this.hYo.setVisibility(8);
                }
                this.gTk.setData(this.hYj.evQ);
                this.gSy.setVisibility(8);
                this.gSx.ju(false);
                return;
            }
            this.gTk.setVisibility(8);
            this.gSx.ju(true);
            if (this.hYj.evQ.eED > 0) {
                this.gSy.setShowPraiseNum(false);
                this.gSy.setShareVisible(false);
                this.hYo.setText(au.numFormatOverWan(this.hYj.evQ.eED));
                this.hYo.setVisibility(0);
            } else {
                this.gSy.setShowPraiseNum(true);
                this.gSy.setShareVisible(true);
                this.hYo.setVisibility(8);
            }
            if (this.gSy.setData(this.hYj.evQ)) {
                this.hYf.setVisibility(8);
            } else {
                this.hYf.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    public int tH(int i) {
        return com.baidu.tieba.a.d.bIl().aw(this.ahw, i);
    }

    private boolean cnJ() {
        return (this.hYj == null || this.hYj.evQ == null || this.hYj.evQ.blV() == null || TextUtils.isEmpty(this.hYj.evQ.blV().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.hYe.onDestroy();
    }
}
