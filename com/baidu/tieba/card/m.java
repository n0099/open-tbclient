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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
public class m extends b<com.baidu.tieba.card.data.m> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView ZY;
    private int aaf;
    private String ahu;
    private Animation bSC;
    private TbPageContext<?> eCn;
    private final View.OnClickListener eQN;
    private CyberPlayerManager.OnPreparedListener eim;
    private CyberPlayerManager.OnErrorListener ein;
    private CyberPlayerManager.OnCompletionListener eio;
    private CyberPlayerManager.OnInfoListener eip;
    private View fKv;
    protected LinearLayout fSf;
    public FrameLayout fzE;
    private TextView fzF;
    private TbImageView fzG;
    private ImageView fzH;
    private TextView fzI;
    private View fzJ;
    private com.baidu.tieba.play.m fzK;
    private View fzL;
    private TextView fzM;
    private int fzN;
    private TbImageView.a fzO;
    private Runnable fzQ;
    private Runnable fzR;
    private TbCyberVideoView.a fzS;
    private NEGFeedBackView gMD;
    private RelativeLayout gMq;
    public ThreadUserInfoLayout gMr;
    public ThreadCommentAndPraiseInfoLayout gMs;
    public ThreadSourceShareAndPraiseLayout gNe;
    private com.baidu.tieba.play.f gdo;
    private com.baidu.afd.videopaster.d hRH;
    private View hRI;
    public ThreadGodReplyLayout hRJ;
    private HeadPendantClickableView hRK;
    private LinearLayout hRL;
    private com.baidu.tieba.card.data.m hRM;
    private int hRN;
    private boolean hRO;
    private boolean hRP;
    private boolean hRQ;
    private TextView hRR;
    private boolean hRS;
    private TextView hRT;
    private Handler hRU;
    private VideoLoadingProgressView.a hRV;
    private CustomMessageListener hRW;
    private final View.OnClickListener hRX;
    private final View.OnClickListener hRY;
    private CustomMessageListener hRZ;
    private f.a hSa;
    private Animation.AnimationListener hSb;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        if (this.ZY != null && this.hRO) {
            try {
                this.ZY.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Qt = com.baidu.tieba.play.n.duF().Qt(this.mVideoUrl);
            if (Qt <= 100 || this.ZY.getDuration() <= Qt) {
                Qt = 100;
            }
            this.aaf = Qt;
            this.hRU.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        if (this.hRM != null && this.hRM.erH != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.hRM.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.alT = this.hRM.erH.getTid();
            oVar.fsZ = this.hRM.erH.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.hRM.erH.mRecomSource;
            oVar.mdW = this.hRM.erH.mRecomAbTag;
            oVar.mdS = this.hRM.erH.mRecomAbTag;
            oVar.mdT = this.hRM.erH.mRecomWeight;
            oVar.mdU = "";
            oVar.eve = this.hRM.getExtra();
            if (this.hRM.erH.bks() != null) {
                oVar.mdX = this.hRM.erH.bks().video_md5;
            }
            com.baidu.tieba.play.h.a(this.hRM.erH.bks().video_md5, "", "1", oVar, this.ZY.getPcdnState());
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gMD = null;
        this.mSkinType = 3;
        this.hRN = 0;
        this.fzN = 1;
        this.hRO = false;
        this.hRP = true;
        this.hRQ = false;
        this.aaf = 100;
        this.hRS = false;
        this.hRU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.clC();
                        return;
                    case 203:
                        m.this.clD();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (m.this.ZY != null) {
                    m.this.ZY.setVolume(0.0f, 0.0f);
                }
                m.this.clx();
            }
        };
        this.eip = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.m.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    m.this.w(false, 3);
                }
                return false;
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.m.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!m.this.hRH.a(false, false, "NEWINDEX")) {
                    m.this.ZY.start();
                }
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                m.this.w(true, 4);
                m.this.hRO = false;
                return true;
            }
        };
        this.hRV = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.clx();
            }
        };
        this.fzO = new TbImageView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && m.this.fzG != null) {
                    m.this.fzG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fzQ = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.ZY != null && !m.this.ZY.isPlaying()) {
                    m.this.w(true, 1);
                }
            }
        };
        this.fzR = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.w(true, 4);
            }
        };
        this.hRW = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.hRM != null && m.this.hRM.erH != null && videoId.equals(m.this.hRM.erH.getId())) {
                        m.this.hRH.a(m.this.a(m.this.hRM, bVar));
                    }
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.m.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.hRX = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hRM == null) {
                    if (m.this.cls() != null) {
                        m.this.cls().a(view, m.this.hRM);
                        return;
                    }
                    return;
                }
                if (view == m.this.gMr.getUserName()) {
                    m.this.hRM.objType = 3;
                } else if (view == m.this.gMr.getHeaderImg()) {
                    m.this.hRM.objType = 4;
                } else {
                    m.this.hRM.objType = 1;
                }
                if (m.this.cls() != null) {
                    m.this.cls().a(view, m.this.hRM);
                }
            }
        };
        this.hRY = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hRM != null) {
                    m.this.hRM.objType = 4;
                }
                if (m.this.cls() != null) {
                    m.this.cls().a(view, m.this.hRM);
                }
            }
        };
        this.hRZ = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.m.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.hRQ = false;
                }
            }
        };
        this.eQN = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hRM != null) {
                    if (m.this.cls() != null) {
                        m.this.cls().a(view, m.this.hRM);
                    }
                    if (m.this.hRM.erH != null && view != m.this.gNe.eQX) {
                        n.II(m.this.hRM.erH.getId());
                        if (!m.this.clB()) {
                            n.a(m.this.mTextTitle, m.this.hRM.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                            n.a(m.this.hRJ.getGodReplyContent(), m.this.hRM.bhz().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.hSa = new f.a() { // from class: com.baidu.tieba.card.m.11
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                if (m.this.hRM != null && m.this.hRM.erH != null && m.this.hRM.erH.bks() != null) {
                    m.this.cly();
                }
            }
        };
        this.hSb = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.fzG != null) {
                    m.this.fzG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eCn = tbPageContext;
        View view = getView();
        this.gMq = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hRK = (HeadPendantClickableView) this.gMq.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hRK.getHeadView() != null) {
            this.hRK.getHeadView().setIsRound(true);
            this.hRK.getHeadView().setDrawBorder(false);
            this.hRK.getHeadView().setDefaultResource(17170445);
            this.hRK.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hRK.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.ds70));
            this.hRK.getHeadView().setPlaceHolder(1);
        }
        this.hRK.setHasPendantStyle();
        if (this.hRK.getPendantView() != null) {
            this.hRK.getPendantView().setIsRound(true);
            this.hRK.getPendantView().setDrawBorder(false);
        }
        this.fzK = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fzK.setLoadingAnimationListener(this.hRV);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gMr = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gMD = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.gMD.a(this.gMq, dimens, 0);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.gMs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMs.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gMs.setLayoutParams(layoutParams);
        }
        this.gMs.setOnClickListener(this);
        this.gMs.setReplyTimeVisible(false);
        this.gMs.setShowPraiseNum(true);
        this.gMs.setNeedAddPraiseIcon(true);
        this.gMs.setNeedAddReplyIcon(true);
        this.gMs.setShareVisible(true);
        this.gMs.setShareReportFrom(3);
        this.gMs.setForumAfterClickListener(this.eQN);
        this.gMs.setFrom(1);
        this.gNe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gNe.eRI.setOnClickListener(this);
        this.gNe.setFrom(1);
        this.gNe.setShareReportFrom(3);
        this.gNe.setForumAfterClickListener(this.eQN);
        this.hRI = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fzE = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fzE.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eCn.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fzE.setLayoutParams(layoutParams2);
        this.fzG = (TbImageView) view.findViewById(R.id.image_video);
        this.fzG.setDefaultErrorResource(0);
        this.fzG.setPlaceHolder(3);
        this.fzG.setGifIconSupport(false);
        this.fzG.setEvent(this.fzO);
        this.fzG.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fzG;
        TbImageView tbImageView2 = this.fzG;
        tbImageView.setConrers(15);
        this.fzG.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fzG.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fzG.setBorderSurroundContent(true);
        this.fzG.setDrawBorder(true);
        this.fzH = (ImageView) view.findViewById(R.id.image_video_play);
        this.gMq.setOnClickListener(this);
        this.ZY = new TbCyberVideoView(getContext());
        this.ZY.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fzE.addView(this.ZY.getView(), 0);
        this.ZY.getView().setLayoutParams(layoutParams3);
        this.ZY.setContinuePlayEnable(true);
        this.ZY.setOnPreparedListener(this.eim);
        this.ZY.setOnInfoListener(this.eip);
        this.ZY.setOnCompletionListener(this.eio);
        this.ZY.setOnErrorListener(this.ein);
        this.ZY.setOnSurfaceDestroyedListener(this.fzS);
        this.gdo = new com.baidu.tieba.play.f();
        this.gdo.setPlayer(this.ZY);
        this.gdo.a(this.hSa);
        this.fzF = (TextView) view.findViewById(R.id.text_video_duration);
        this.hRL = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fzM = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fzL = view.findViewById(R.id.auto_video_black_mask);
        this.fzI = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fzJ = view.findViewById(R.id.auto_video_error_background);
        this.fSf = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bSC = AnimationUtils.loadAnimation(this.eCn.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bSC.setAnimationListener(this.hSb);
        this.hRJ = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hRJ.setOnClickListener(this);
        this.fKv = view.findViewById(R.id.divider_line);
        this.hRR = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.ZY.getView().setOnClickListener(this);
        this.hRT = (TextView) view.findViewById(R.id.nani_video_icon);
        this.hRH = new com.baidu.afd.videopaster.d(getContext(), this.fzE);
        this.hRH.a(new d.a() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rQ() {
                if (!m.this.hRS) {
                    m.this.ZY.start();
                } else {
                    m.this.startPlay();
                }
                m.this.hRS = false;
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
        if (this.hRM != null && this.hRM.erH != null && this.hRM.erH.eAw > 0) {
            if (cls() != null) {
                cls().a(view, this.hRM);
            }
            this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eCn.getPageActivity(), this.hRM.erH.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.bjM(), this.hRM.bhC())));
            return;
        }
        if (view == this.gMq || view == this.hRJ) {
            co(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.ZY.getView()) {
            if (this.hRM != null) {
                this.hRM.objType = 5;
            }
            if (this.hRM != null && this.hRM.erH != null && this.hRM.erH.bks() != null) {
                z = this.hRM.erH.bks().is_vertical.intValue() == 1;
            }
            if (z) {
                cm(this.ZY.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cn(this.ZY.getView());
            } else {
                co(getView());
            }
        }
    }

    private void cm(View view) {
        if (cls() != null) {
            cls().a(view, this.hRM);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eCn.getPageActivity(), R.string.no_network_guide);
        } else {
            clz();
        }
    }

    private void cn(View view) {
        if (cls() != null) {
            cls().a(view, this.hRM);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eCn.getPageActivity(), R.string.no_network_guide);
        } else {
            clA();
        }
    }

    private void clz() {
        if (this.hRM != null && this.hRM.erH != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.hRM.erH);
            videoItemData.mRecomExtra = this.hRM.getExtra();
            videoItemData.mRecomAbTag = this.hRM.cmd();
            videoItemData.mRecomSource = this.hRM.getSource();
            videoItemData.mRecomWeight = this.hRM.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.hRM.bhC(), "index");
            if (this.hRM.erH.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.hRM.erH.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void clA() {
        if (this.hRM != null && this.hRM.erH != null && this.hRM.erH.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.hRM.erH);
            videoSerializeVideoThreadInfo.source = this.hRM.getSource();
            videoSerializeVideoThreadInfo.extra = this.hRM.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.hRM.cmd();
            videoSerializeVideoThreadInfo.weight = this.hRM.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fSf.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fSf.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eCn.getPageActivity(), str, this.hRM.erH.getTid(), n.bjM(), this.hRM.bhC(), videoSerializeVideoThreadInfo);
            if (this.hRM.bhz() != null && this.hRM.bhz().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.hRM.bhz().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void co(View view) {
        if (this.hRM != null) {
            this.hRM.objType = 1;
        }
        if (cls() != null) {
            cls().a(view, this.hRM);
        }
        if (this.hRM != null && this.hRM.erH != null) {
            if (!clB()) {
                n.II(this.hRM.erH.getId());
                n.a(this.mTextTitle, this.hRM.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eCn.getPageActivity()).createFromThreadCfg(this.hRM.erH, null, n.bjM(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hRM.bhC());
            addLocateParam.setVideo_source(this.hRM.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.hRM.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.hRM.erH.getFid()));
            addLocateParam.setForumName(this.hRM.erH.bke());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.hRJ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clB() {
        return this.hRM.hVO && !this.hRM.hVT;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.hRM = mVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clC() {
        this.hRU.removeMessages(202);
        if (this.ZY.getCurrentPositionSync() > this.aaf) {
            w(false, 3);
            this.hRU.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hRU.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clD() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hRU.removeMessages(203);
        int currentPositionSync = this.ZY.getCurrentPositionSync();
        if (currentPositionSync != this.hRN) {
            this.hRN = currentPositionSync;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hRU.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fzH != null && this.fzG != null && this.fzL != null && this.fzK != null && this.fzJ != null && this.fzI != null) {
            if (z || this.fzN != i) {
                this.fzN = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzR);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzQ);
                if (i == 2) {
                    this.fzH.setVisibility(8);
                    this.bSC.cancel();
                    this.fzG.clearAnimation();
                    this.fzG.setVisibility(0);
                    this.fzL.setVisibility(0);
                    this.hRL.setVisibility(0);
                    this.hRR.setVisibility(8);
                    this.fzK.startLoading();
                    this.fzJ.setVisibility(8);
                    this.fzI.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fzR, 60000L);
                } else if (i == 3) {
                    this.fzH.setVisibility(8);
                    this.fzG.startAnimation(this.bSC);
                    this.fzL.setVisibility(8);
                    this.hRL.setVisibility(8);
                    if (this.hRM != null && this.hRM.bhz() != null && this.hRM.bhz().eAw > 0) {
                        this.hRR.setVisibility(0);
                    }
                    this.fzK.duA();
                    this.fzJ.setVisibility(8);
                    this.fzI.setVisibility(8);
                    if (this.hRM != null && this.hRM.erH != null && this.hRM.erH.bks() != null) {
                        this.hRM.erH.bks().video_length.intValue();
                        this.hRM.erH.bks().video_duration.intValue();
                        this.hRM.erH.getTid();
                    }
                } else if (i == 4) {
                    this.fzH.setVisibility(8);
                    this.fzG.startAnimation(this.bSC);
                    this.fzL.setVisibility(8);
                    this.fzK.duB();
                    this.fzJ.setVisibility(0);
                    this.fzI.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fzQ, 2000L);
                } else {
                    this.fzH.setVisibility(0);
                    this.bSC.cancel();
                    this.fzG.clearAnimation();
                    this.fzG.setVisibility(0);
                    this.fzL.setVisibility(0);
                    this.hRL.setVisibility(0);
                    this.fzK.duB();
                    this.fzJ.setVisibility(8);
                    this.fzI.setVisibility(8);
                }
                if (this.hRM != null && this.hRM.bhz() != null && this.hRM.bhz().eAw > 0) {
                    this.hRL.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.hRM == null || this.hRM.erH == null || this.hRM.erH.bka() == null) {
            this.gMq.setVisibility(8);
            return;
        }
        this.gMq.setVisibility(0);
        clF();
        if (!clB() && n.IJ(this.hRM.erH.getId())) {
            n.a(this.mTextTitle, this.hRM.erH.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.hRJ.getGodReplyContent(), this.hRM.bhz().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        this.hRM.bhz().bkY();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hRM.bhz().bkK());
        if (this.hRM.bhz().bkQ() && !StringUtils.isNull(this.hRM.bhz().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bnH().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.hRM.bhz().getTid();
            spannableStringBuilder.append((CharSequence) this.hRM.bhz().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.m.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dR("obj_source", "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.gMr.setData(this.hRM.bhz());
        this.gMr.setUserAfterClickListener(this.hRX);
        if (this.gMr.getHeaderImg() != null) {
            this.gMr.getHeaderImg().setAfterClickListener(this.hRY);
            if (this.gMr.getIsSimpleThread()) {
                this.gMr.getHeaderImg().setVisibility(8);
                this.hRK.setVisibility(8);
            } else if (this.hRM.bhz() == null || this.hRM.bhz().bka() == null || this.hRM.bhz().bka().getPendantData() == null || StringUtils.isNull(this.hRM.bhz().bka().getPendantData().bhW())) {
                this.hRK.setVisibility(8);
                this.gMr.getHeaderImg().setVisibility(0);
                if (this.hRM.bhz().eAw > 0 && this.hRM.bhz().eAx == 0) {
                    this.hRM.bhz().bka().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.gMr.getHeaderImg().setData(this.hRM.bhz(), false);
                } else {
                    this.gMr.getHeaderImg().setData(this.hRM.bhz());
                    this.gMr.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.gMr.getHeaderImg().setVisibility(4);
                this.hRK.setVisibility(0);
                this.hRK.setData(this.hRM.bhz());
            }
        }
        this.fzF.setText(at.stringForVideoTime(this.hRM.erH.bks().video_duration.intValue() * 1000));
        this.fzM.setText(String.format(this.eCn.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hRM.erH.bks().play_count.intValue())));
        if (this.gMD != null && this.hRM.bhz() != null) {
            ar arVar = new ar();
            arVar.setTid(this.hRM.bhz().getTid());
            arVar.setFid(this.hRM.bhz().getFid());
            arVar.setNid(this.hRM.bhz().getNid());
            arVar.setFeedBackReasonMap(this.hRM.feedBackReasonMap);
            this.gMD.setData(arVar);
            this.gMD.setFirstRowSingleColumn(true);
            this.gMD.setVisibility(this.hRP ? 0 : 8);
        }
        this.hRJ.setData(this.hRM.bhz().blD());
        uS(sZ(1));
        onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
        if (n.IJ(this.hRM.erH.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.hRM == null || this.hRM.erH == null || this.hRM.erH.bks() == null) {
            z = false;
        } else {
            z = this.hRM.erH.bks().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hRT.setVisibility(0);
            if (clG()) {
                this.hRT.setText(String.format("%s | %s", this.eCn.getResources().getString(R.string.nani_video), this.eCn.getResources().getString(R.string.video_preview)));
            } else {
                this.hRT.setText(this.eCn.getString(R.string.nani_video));
            }
        } else if (clG()) {
            this.hRT.setVisibility(0);
            this.hRT.setText(this.eCn.getString(R.string.video_preview));
        } else {
            this.hRT.setVisibility(8);
        }
    }

    private void clE() {
        this.hRU.removeMessages(202);
        this.hRU.removeMessages(203);
    }

    private void bCT() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzQ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzR);
    }

    private void clF() {
        bCT();
        clE();
        if (this.fzG != null && this.fzE != null && this.ZY != null) {
            if (com.baidu.tbadk.core.k.bhh().isShowImages() && this.hRM != null && this.hRM.erH != null && this.hRM.erH.bks() != null) {
                this.fzG.setPlaceHolder(3);
                this.fzG.startLoad(this.hRM.erH.bks().thumbnail_url, 10, false);
                this.fzE.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.hRM.erH.bks().video_url;
                if (clG()) {
                    this.mVideoUrl = this.hRM.erH.bkt().video_url;
                }
                if (StringUtils.isNull(this.hRM.erH.bks().video_url)) {
                    w(true, 4);
                }
                this.ZY.setThreadDataForStatistic(this.hRM.erH);
            } else {
                this.fzE.setVisibility(8);
            }
            this.hRH.reset();
            this.gdo.a(new f.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.f.b
                public void cc(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.hRH.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.hRM);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.m mVar) {
        if (mVar != null && mVar.erH != null) {
            bw bwVar = mVar.erH;
            if (bwVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bwVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.m mVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (mVar == null || mVar.erH == null || bVar == null) {
            return null;
        }
        bw bwVar = mVar.erH;
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
        VideoInfo bks = bwVar.bks();
        if (bks != null) {
            i3 = bks.video_width.intValue();
            i2 = bks.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.bke());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gMq, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fzH, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fzI, R.color.cp_cont_a);
            ap.setViewTextColor(this.fzF, R.color.cp_cont_a);
            ap.setViewTextColor(this.fzM, R.color.cp_cont_a);
            ap.setViewTextColor(this.hRR, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fzJ, R.color.common_color_10014);
            ap.setBackgroundColor(this.fKv, R.color.cp_bg_line_c);
            if (this.hRT != null) {
                ap.setViewTextColor(this.hRT, R.color.cp_cont_a);
                ap.setBackgroundResource(this.hRT, R.drawable.video_play_count_bg);
            }
            if (this.fzI != null) {
                this.fzI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.hRJ.onChangeSkinType();
            if (this.gMD != null) {
                this.gMD.onChangeSkinType();
            }
            this.gMr.onChangeSkinType();
            this.gMs.onChangeSkinType();
            this.gNe.onChangeSkinType();
            this.fzG.setPlaceHolder(3);
            this.hRK.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hRZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hRZ);
            this.hRW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hRW);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gMr != null) {
            this.gMr.setPageUniqueId(bdUniqueId);
        }
        if (this.fzG != null) {
            this.fzG.setPageId(bdUniqueId);
        }
        if (this.gMD != null) {
            this.gMD.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.hRO;
    }

    public boolean isPlaying() {
        if (this.ZY == null) {
            return false;
        }
        return this.ZY.isPlaying();
    }

    public void startPlay() {
        if (!this.hRO && this.hRM != null && this.hRM.erH != null && this.hRM.erH.bks() != null && this.ZY != null) {
            if (this.hRH.rA()) {
                this.hRH.resume();
                this.hRS = true;
                return;
            }
            this.hRS = false;
            this.ZY.stopPlayback();
            if (ai.aG(1, this.mVideoUrl)) {
                w(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dR("obj_locate", "index").dR("tid", this.hRM.tid));
                    this.mVideoUrl = this.hRM.erH.bks().video_url;
                }
                this.hRO = true;
                this.ZY.setVideoPath(this.mVideoUrl, this.hRM.tid);
                if (this.gdo != null) {
                    this.gdo.start();
                }
                cly();
            }
        }
    }

    public void stopPlay() {
        this.hRS = false;
        bCT();
        clE();
        w(true, 1);
        if (this.ZY != null) {
            this.ZY.stopPlayback();
            if (this.gdo != null) {
                this.gdo.stop();
            }
        }
        this.hRO = false;
        this.hRH.stop();
    }

    public View getVideoContainer() {
        return this.fzE;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZY == null) {
            return 0;
        }
        return this.ZY.getCurrentPosition();
    }

    public void oi(boolean z) {
        this.hRP = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void uS(int i) {
        if (this.hRM != null && this.hRM.erH != null) {
            if (i == 1) {
                if (this.hRM.erH.eAw > 0) {
                    this.gNe.eRI.setShowPraiseNum(false);
                    this.gNe.eRI.setShareVisible(false);
                    this.hRR.setText(at.numFormatOverWan(this.hRM.erH.eAw));
                    this.hRR.setVisibility(0);
                } else {
                    this.gNe.eRI.setShowPraiseNum(true);
                    this.gNe.eRI.setShareVisible(true);
                    this.hRR.setVisibility(8);
                }
                this.gNe.setData(this.hRM.erH);
                this.gMs.setVisibility(8);
                this.gMr.jk(false);
                return;
            }
            this.gNe.setVisibility(8);
            this.gMr.jk(true);
            if (this.hRM.erH.eAw > 0) {
                this.gMs.setShowPraiseNum(false);
                this.gMs.setShareVisible(false);
                this.hRR.setText(at.numFormatOverWan(this.hRM.erH.eAw));
                this.hRR.setVisibility(0);
            } else {
                this.gMs.setShowPraiseNum(true);
                this.gMs.setShareVisible(true);
                this.hRR.setVisibility(8);
            }
            if (this.gMs.setData(this.hRM.erH)) {
                this.hRI.setVisibility(8);
            } else {
                this.hRI.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int sZ(int i) {
        return com.baidu.tieba.a.d.bGs().av(this.ahu, i);
    }

    private boolean clG() {
        return (this.hRM == null || this.hRM.erH == null || this.hRM.erH.bkt() == null || TextUtils.isEmpty(this.hRM.erH.bkt().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.hRH.onDestroy();
    }
}
