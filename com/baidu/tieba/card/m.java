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
    private Animation bYm;
    private TbPageContext<?> eIc;
    private final View.OnClickListener eWC;
    private CyberPlayerManager.OnPreparedListener eog;
    private CyberPlayerManager.OnErrorListener eoh;
    private CyberPlayerManager.OnCompletionListener eoi;
    private CyberPlayerManager.OnInfoListener eoj;
    private com.baidu.tieba.play.m fFA;
    private View fFB;
    private TextView fFC;
    private int fFD;
    private TbImageView.a fFE;
    private Runnable fFG;
    private Runnable fFH;
    private TbCyberVideoView.a fFI;
    public FrameLayout fFu;
    private TextView fFv;
    private TbImageView fFw;
    private ImageView fFx;
    private TextView fFy;
    private View fFz;
    private View fQl;
    protected LinearLayout fXV;
    private RelativeLayout gSP;
    public ThreadUserInfoLayout gSQ;
    public ThreadCommentAndPraiseInfoLayout gSR;
    public ThreadSourceShareAndPraiseLayout gTD;
    private NEGFeedBackView gTc;
    private com.baidu.tieba.play.f gje;
    private com.baidu.afd.videopaster.d hXE;
    private View hXF;
    public ThreadGodReplyLayout hXG;
    private HeadPendantClickableView hXH;
    private LinearLayout hXI;
    private com.baidu.tieba.card.data.m hXJ;
    private int hXK;
    private boolean hXL;
    private boolean hXM;
    private boolean hXN;
    private TextView hXO;
    private boolean hXP;
    private TextView hXQ;
    private Handler hXR;
    private VideoLoadingProgressView.a hXS;
    private CustomMessageListener hXT;
    private final View.OnClickListener hXU;
    private final View.OnClickListener hXV;
    private CustomMessageListener hXW;
    private f.a hXX;
    private Animation.AnimationListener hXY;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnY() {
        if (this.ZY != null && this.hXL) {
            try {
                this.ZY.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int QK = com.baidu.tieba.play.n.dxh().QK(this.mVideoUrl);
            if (QK <= 100 || this.ZY.getDuration() <= QK) {
                QK = 100;
            }
            this.aaf = QK;
            this.hXR.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnZ() {
        if (this.hXJ != null && this.hXJ.exA != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.hXJ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.alT = this.hXJ.exA.getTid();
            oVar.fyR = this.hXJ.exA.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.hXJ.exA.mRecomSource;
            oVar.mjV = this.hXJ.exA.mRecomAbTag;
            oVar.mjR = this.hXJ.exA.mRecomAbTag;
            oVar.mjS = this.hXJ.exA.mRecomWeight;
            oVar.mjT = "";
            oVar.eAX = this.hXJ.getExtra();
            if (this.hXJ.exA.bmS() != null) {
                oVar.mjW = this.hXJ.exA.bmS().video_md5;
            }
            com.baidu.tieba.play.h.a(this.hXJ.exA.bmS().video_md5, "", "1", oVar, this.ZY.getPcdnState());
        }
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gTc = null;
        this.mSkinType = 3;
        this.hXK = 0;
        this.fFD = 1;
        this.hXL = false;
        this.hXM = true;
        this.hXN = false;
        this.aaf = 100;
        this.hXP = false;
        this.hXR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        m.this.cod();
                        return;
                    case 203:
                        m.this.coe();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.m.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (m.this.ZY != null) {
                    m.this.ZY.setVolume(0.0f, 0.0f);
                }
                m.this.cnY();
            }
        };
        this.eoj = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.m.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    m.this.w(false, 3);
                }
                return false;
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.m.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!m.this.hXE.a(false, false, "NEWINDEX")) {
                    m.this.ZY.start();
                }
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.m.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                m.this.w(true, 4);
                m.this.hXL = false;
                return true;
            }
        };
        this.hXS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.m.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                m.this.cnY();
            }
        };
        this.fFE = new TbImageView.a() { // from class: com.baidu.tieba.card.m.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && m.this.fFw != null) {
                    m.this.fFw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fFG = new Runnable() { // from class: com.baidu.tieba.card.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.ZY != null && !m.this.ZY.isPlaying()) {
                    m.this.w(true, 1);
                }
            }
        };
        this.fFH = new Runnable() { // from class: com.baidu.tieba.card.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.w(true, 4);
            }
        };
        this.hXT = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && m.this.hXJ != null && m.this.hXJ.exA != null && videoId.equals(m.this.hXJ.exA.getId())) {
                        m.this.hXE.a(m.this.a(m.this.hXJ, bVar));
                    }
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.m.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                m.this.stopPlay();
            }
        };
        this.hXU = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hXJ == null) {
                    if (m.this.cnT() != null) {
                        m.this.cnT().a(view, m.this.hXJ);
                        return;
                    }
                    return;
                }
                if (view == m.this.gSQ.getUserName()) {
                    m.this.hXJ.objType = 3;
                } else if (view == m.this.gSQ.getHeaderImg()) {
                    m.this.hXJ.objType = 4;
                } else {
                    m.this.hXJ.objType = 1;
                }
                if (m.this.cnT() != null) {
                    m.this.cnT().a(view, m.this.hXJ);
                }
            }
        };
        this.hXV = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hXJ != null) {
                    m.this.hXJ.objType = 4;
                }
                if (m.this.cnT() != null) {
                    m.this.cnT().a(view, m.this.hXJ);
                }
            }
        };
        this.hXW = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.m.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    m.this.hXN = false;
                }
            }
        };
        this.eWC = new View.OnClickListener() { // from class: com.baidu.tieba.card.m.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hXJ != null) {
                    if (m.this.cnT() != null) {
                        m.this.cnT().a(view, m.this.hXJ);
                    }
                    if (m.this.hXJ.exA != null && view != m.this.gTD.eWM) {
                        n.IZ(m.this.hXJ.exA.getId());
                        if (!m.this.coc()) {
                            n.a(m.this.mTextTitle, m.this.hXJ.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                            n.a(m.this.hXG.getGodReplyContent(), m.this.hXJ.bjZ().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.hXX = new f.a() { // from class: com.baidu.tieba.card.m.11
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                if (m.this.hXJ != null && m.this.hXJ.exA != null && m.this.hXJ.exA.bmS() != null) {
                    m.this.cnZ();
                }
            }
        };
        this.hXY = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.m.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (m.this.fFw != null) {
                    m.this.fFw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eIc = tbPageContext;
        View view = getView();
        this.gSP = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hXH = (HeadPendantClickableView) this.gSP.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hXH.getHeadView() != null) {
            this.hXH.getHeadView().setIsRound(true);
            this.hXH.getHeadView().setDrawBorder(false);
            this.hXH.getHeadView().setDefaultResource(17170445);
            this.hXH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hXH.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.ds70));
            this.hXH.getHeadView().setPlaceHolder(1);
        }
        this.hXH.setHasPendantStyle();
        if (this.hXH.getPendantView() != null) {
            this.hXH.getPendantView().setIsRound(true);
            this.hXH.getPendantView().setDrawBorder(false);
        }
        this.fFA = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fFA.setLoadingAnimationListener(this.hXS);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gSQ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gTc = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.gTc.a(this.gSP, dimens, 0);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.gSR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSR.setLayoutParams(layoutParams);
        }
        this.gSR.setOnClickListener(this);
        this.gSR.setReplyTimeVisible(false);
        this.gSR.setShowPraiseNum(true);
        this.gSR.setNeedAddPraiseIcon(true);
        this.gSR.setNeedAddReplyIcon(true);
        this.gSR.setShareVisible(true);
        this.gSR.setShareReportFrom(3);
        this.gSR.setForumAfterClickListener(this.eWC);
        this.gSR.setFrom(1);
        this.gTD = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gTD.eXx.setOnClickListener(this);
        this.gTD.setFrom(1);
        this.gTD.setShareReportFrom(3);
        this.gTD.setForumAfterClickListener(this.eWC);
        this.hXF = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fFu = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fFu.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eIc.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fFu.setLayoutParams(layoutParams2);
        this.fFw = (TbImageView) view.findViewById(R.id.image_video);
        this.fFw.setDefaultErrorResource(0);
        this.fFw.setPlaceHolder(3);
        this.fFw.setGifIconSupport(false);
        this.fFw.setEvent(this.fFE);
        this.fFw.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fFw;
        TbImageView tbImageView2 = this.fFw;
        tbImageView.setConrers(15);
        this.fFw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fFw.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fFw.setBorderSurroundContent(true);
        this.fFw.setDrawBorder(true);
        this.fFx = (ImageView) view.findViewById(R.id.image_video_play);
        this.gSP.setOnClickListener(this);
        this.ZY = new TbCyberVideoView(getContext());
        this.ZY.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fFu.addView(this.ZY.getView(), 0);
        this.ZY.getView().setLayoutParams(layoutParams3);
        this.ZY.setContinuePlayEnable(true);
        this.ZY.setOnPreparedListener(this.eog);
        this.ZY.setOnInfoListener(this.eoj);
        this.ZY.setOnCompletionListener(this.eoi);
        this.ZY.setOnErrorListener(this.eoh);
        this.ZY.setOnSurfaceDestroyedListener(this.fFI);
        this.gje = new com.baidu.tieba.play.f();
        this.gje.setPlayer(this.ZY);
        this.gje.a(this.hXX);
        this.fFv = (TextView) view.findViewById(R.id.text_video_duration);
        this.hXI = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fFC = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fFB = view.findViewById(R.id.auto_video_black_mask);
        this.fFy = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fFz = view.findViewById(R.id.auto_video_error_background);
        this.fXV = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bYm = AnimationUtils.loadAnimation(this.eIc.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bYm.setAnimationListener(this.hXY);
        this.hXG = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hXG.setOnClickListener(this);
        this.fQl = view.findViewById(R.id.divider_line);
        this.hXO = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.ZY.getView().setOnClickListener(this);
        this.hXQ = (TextView) view.findViewById(R.id.nani_video_icon);
        this.hXE = new com.baidu.afd.videopaster.d(getContext(), this.fFu);
        this.hXE.a(new d.a() { // from class: com.baidu.tieba.card.m.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rQ() {
                if (!m.this.hXP) {
                    m.this.ZY.start();
                } else {
                    m.this.startPlay();
                }
                m.this.hXP = false;
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
        if (this.hXJ != null && this.hXJ.exA != null && this.hXJ.exA.eGl > 0) {
            if (cnT() != null) {
                cnT().a(view, this.hXJ);
            }
            this.eIc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eIc.getPageActivity(), this.hXJ.exA.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, n.bmm(), this.hXJ.bkc())));
            return;
        }
        if (view == this.gSP || view == this.hXG) {
            ct(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.ZY.getView()) {
            if (this.hXJ != null) {
                this.hXJ.objType = 5;
            }
            if (this.hXJ != null && this.hXJ.exA != null && this.hXJ.exA.bmS() != null) {
                z = this.hXJ.exA.bmS().is_vertical.intValue() == 1;
            }
            if (z) {
                cr(this.ZY.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cs(this.ZY.getView());
            } else {
                ct(getView());
            }
        }
    }

    private void cr(View view) {
        if (cnT() != null) {
            cnT().a(view, this.hXJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eIc.getPageActivity(), R.string.no_network_guide);
        } else {
            coa();
        }
    }

    private void cs(View view) {
        if (cnT() != null) {
            cnT().a(view, this.hXJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eIc.getPageActivity(), R.string.no_network_guide);
        } else {
            cob();
        }
    }

    private void coa() {
        if (this.hXJ != null && this.hXJ.exA != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.hXJ.exA);
            videoItemData.mRecomExtra = this.hXJ.getExtra();
            videoItemData.mRecomAbTag = this.hXJ.coE();
            videoItemData.mRecomSource = this.hXJ.getSource();
            videoItemData.mRecomWeight = this.hXJ.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.hXJ.bkc(), "index");
            if (this.hXJ.exA.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.hXJ.exA.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cob() {
        if (this.hXJ != null && this.hXJ.exA != null && this.hXJ.exA.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.hXJ.exA);
            videoSerializeVideoThreadInfo.source = this.hXJ.getSource();
            videoSerializeVideoThreadInfo.extra = this.hXJ.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.hXJ.coE();
            videoSerializeVideoThreadInfo.weight = this.hXJ.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fXV.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fXV.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eIc.getPageActivity(), str, this.hXJ.exA.getTid(), n.bmm(), this.hXJ.bkc(), videoSerializeVideoThreadInfo);
            if (this.hXJ.bjZ() != null && this.hXJ.bjZ().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.hXJ.bjZ().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void ct(View view) {
        if (this.hXJ != null) {
            this.hXJ.objType = 1;
        }
        if (cnT() != null) {
            cnT().a(view, this.hXJ);
        }
        if (this.hXJ != null && this.hXJ.exA != null) {
            if (!coc()) {
                n.IZ(this.hXJ.exA.getId());
                n.a(this.mTextTitle, this.hXJ.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eIc.getPageActivity()).createFromThreadCfg(this.hXJ.exA, null, n.bmm(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hXJ.bkc());
            addLocateParam.setVideo_source(this.hXJ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.hXJ.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.hXJ.exA.getFid()));
            addLocateParam.setForumName(this.hXJ.exA.bmE());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.hXG) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eIc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean coc() {
        return this.hXJ.ibL && !this.hXJ.ibQ;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.hXJ = mVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        this.hXR.removeMessages(202);
        if (this.ZY.getCurrentPositionSync() > this.aaf) {
            w(false, 3);
            this.hXR.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hXR.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coe() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hXR.removeMessages(203);
        int currentPositionSync = this.ZY.getCurrentPositionSync();
        if (currentPositionSync != this.hXK) {
            this.hXK = currentPositionSync;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hXR.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fFx != null && this.fFw != null && this.fFB != null && this.fFA != null && this.fFz != null && this.fFy != null) {
            if (z || this.fFD != i) {
                this.fFD = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFH);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFG);
                if (i == 2) {
                    this.fFx.setVisibility(8);
                    this.bYm.cancel();
                    this.fFw.clearAnimation();
                    this.fFw.setVisibility(0);
                    this.fFB.setVisibility(0);
                    this.hXI.setVisibility(0);
                    this.hXO.setVisibility(8);
                    this.fFA.startLoading();
                    this.fFz.setVisibility(8);
                    this.fFy.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFH, 60000L);
                } else if (i == 3) {
                    this.fFx.setVisibility(8);
                    this.fFw.startAnimation(this.bYm);
                    this.fFB.setVisibility(8);
                    this.hXI.setVisibility(8);
                    if (this.hXJ != null && this.hXJ.bjZ() != null && this.hXJ.bjZ().eGl > 0) {
                        this.hXO.setVisibility(0);
                    }
                    this.fFA.dxc();
                    this.fFz.setVisibility(8);
                    this.fFy.setVisibility(8);
                    if (this.hXJ != null && this.hXJ.exA != null && this.hXJ.exA.bmS() != null) {
                        this.hXJ.exA.bmS().video_length.intValue();
                        this.hXJ.exA.bmS().video_duration.intValue();
                        this.hXJ.exA.getTid();
                    }
                } else if (i == 4) {
                    this.fFx.setVisibility(8);
                    this.fFw.startAnimation(this.bYm);
                    this.fFB.setVisibility(8);
                    this.fFA.dxd();
                    this.fFz.setVisibility(0);
                    this.fFy.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFG, 2000L);
                } else {
                    this.fFx.setVisibility(0);
                    this.bYm.cancel();
                    this.fFw.clearAnimation();
                    this.fFw.setVisibility(0);
                    this.fFB.setVisibility(0);
                    this.hXI.setVisibility(0);
                    this.fFA.dxd();
                    this.fFz.setVisibility(8);
                    this.fFy.setVisibility(8);
                }
                if (this.hXJ != null && this.hXJ.bjZ() != null && this.hXJ.bjZ().eGl > 0) {
                    this.hXI.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.hXJ == null || this.hXJ.exA == null || this.hXJ.exA.bmA() == null) {
            this.gSP.setVisibility(8);
            return;
        }
        this.gSP.setVisibility(0);
        cog();
        if (!coc() && n.Ja(this.hXJ.exA.getId())) {
            n.a(this.mTextTitle, this.hXJ.exA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.hXG.getGodReplyContent(), this.hXJ.bjZ().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        this.hXJ.bjZ().bny();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hXJ.bjZ().bnk());
        if (this.hXJ.bjZ().bnq() && !StringUtils.isNull(this.hXJ.bjZ().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bqh().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.hXJ.bjZ().getTid();
            spannableStringBuilder.append((CharSequence) this.hXJ.bjZ().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.m.20
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
        this.gSQ.setData(this.hXJ.bjZ());
        this.gSQ.setUserAfterClickListener(this.hXU);
        if (this.gSQ.getHeaderImg() != null) {
            this.gSQ.getHeaderImg().setAfterClickListener(this.hXV);
            if (this.gSQ.getIsSimpleThread()) {
                this.gSQ.getHeaderImg().setVisibility(8);
                this.hXH.setVisibility(8);
            } else if (this.hXJ.bjZ() == null || this.hXJ.bjZ().bmA() == null || this.hXJ.bjZ().bmA().getPendantData() == null || StringUtils.isNull(this.hXJ.bjZ().bmA().getPendantData().bkw())) {
                this.hXH.setVisibility(8);
                this.gSQ.getHeaderImg().setVisibility(0);
                if (this.hXJ.bjZ().eGl > 0 && this.hXJ.bjZ().eGm == 0) {
                    this.hXJ.bjZ().bmA().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.gSQ.getHeaderImg().setData(this.hXJ.bjZ(), false);
                } else {
                    this.gSQ.getHeaderImg().setData(this.hXJ.bjZ());
                    this.gSQ.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.gSQ.getHeaderImg().setVisibility(4);
                this.hXH.setVisibility(0);
                this.hXH.setData(this.hXJ.bjZ());
            }
        }
        this.fFv.setText(at.stringForVideoTime(this.hXJ.exA.bmS().video_duration.intValue() * 1000));
        this.fFC.setText(String.format(this.eIc.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hXJ.exA.bmS().play_count.intValue())));
        if (this.gTc != null && this.hXJ.bjZ() != null) {
            ar arVar = new ar();
            arVar.setTid(this.hXJ.bjZ().getTid());
            arVar.setFid(this.hXJ.bjZ().getFid());
            arVar.setNid(this.hXJ.bjZ().getNid());
            arVar.setFeedBackReasonMap(this.hXJ.feedBackReasonMap);
            this.gTc.setData(arVar);
            this.gTc.setFirstRowSingleColumn(true);
            this.gTc.setVisibility(this.hXM ? 0 : 8);
        }
        this.hXG.setData(this.hXJ.bjZ().bod());
        vf(tj(1));
        onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
        if (n.Ja(this.hXJ.exA.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.hXJ == null || this.hXJ.exA == null || this.hXJ.exA.bmS() == null) {
            z = false;
        } else {
            z = this.hXJ.exA.bmS().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hXQ.setVisibility(0);
            if (coh()) {
                this.hXQ.setText(String.format("%s | %s", this.eIc.getResources().getString(R.string.nani_video), this.eIc.getResources().getString(R.string.video_preview)));
            } else {
                this.hXQ.setText(this.eIc.getString(R.string.nani_video));
            }
        } else if (coh()) {
            this.hXQ.setVisibility(0);
            this.hXQ.setText(this.eIc.getString(R.string.video_preview));
        } else {
            this.hXQ.setVisibility(8);
        }
    }

    private void cof() {
        this.hXR.removeMessages(202);
        this.hXR.removeMessages(203);
    }

    private void bFs() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFG);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFH);
    }

    private void cog() {
        bFs();
        cof();
        if (this.fFw != null && this.fFu != null && this.ZY != null) {
            if (com.baidu.tbadk.core.k.bjH().isShowImages() && this.hXJ != null && this.hXJ.exA != null && this.hXJ.exA.bmS() != null) {
                this.fFw.setPlaceHolder(3);
                this.fFw.startLoad(this.hXJ.exA.bmS().thumbnail_url, 10, false);
                this.fFu.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.hXJ.exA.bmS().video_url;
                if (coh()) {
                    this.mVideoUrl = this.hXJ.exA.bmT().video_url;
                }
                if (StringUtils.isNull(this.hXJ.exA.bmS().video_url)) {
                    w(true, 4);
                }
                this.ZY.setThreadDataForStatistic(this.hXJ.exA);
            } else {
                this.fFu.setVisibility(8);
            }
            this.hXE.reset();
            this.gje.a(new f.b() { // from class: com.baidu.tieba.card.m.4
                @Override // com.baidu.tieba.play.f.b
                public void ce(int i, int i2) {
                    if (i2 >= i) {
                        if (m.this.hXE.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        m.this.b(m.this.hXJ);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.m mVar) {
        if (mVar != null && mVar.exA != null) {
            bw bwVar = mVar.exA;
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
        if (mVar == null || mVar.exA == null || bVar == null) {
            return null;
        }
        bw bwVar = mVar.exA;
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
        VideoInfo bmS = bwVar.bmS();
        if (bmS != null) {
            i3 = bmS.video_width.intValue();
            i2 = bmS.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.bmE());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gSP, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fFx, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fFy, R.color.cp_cont_a);
            ap.setViewTextColor(this.fFv, R.color.cp_cont_a);
            ap.setViewTextColor(this.fFC, R.color.cp_cont_a);
            ap.setViewTextColor(this.hXO, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fFz, R.color.common_color_10014);
            ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c);
            if (this.hXQ != null) {
                ap.setViewTextColor(this.hXQ, R.color.cp_cont_a);
                ap.setBackgroundResource(this.hXQ, R.drawable.video_play_count_bg);
            }
            if (this.fFy != null) {
                this.fFy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.hXG.onChangeSkinType();
            if (this.gTc != null) {
                this.gTc.onChangeSkinType();
            }
            this.gSQ.onChangeSkinType();
            this.gSR.onChangeSkinType();
            this.gTD.onChangeSkinType();
            this.fFw.setPlaceHolder(3);
            this.hXH.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hXW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hXW);
            this.hXT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hXT);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gSQ != null) {
            this.gSQ.setPageUniqueId(bdUniqueId);
        }
        if (this.fFw != null) {
            this.fFw.setPageId(bdUniqueId);
        }
        if (this.gTc != null) {
            this.gTc.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.hXL;
    }

    public boolean isPlaying() {
        if (this.ZY == null) {
            return false;
        }
        return this.ZY.isPlaying();
    }

    public void startPlay() {
        if (!this.hXL && this.hXJ != null && this.hXJ.exA != null && this.hXJ.exA.bmS() != null && this.ZY != null) {
            if (this.hXE.rA()) {
                this.hXE.resume();
                this.hXP = true;
                return;
            }
            this.hXP = false;
            this.ZY.stopPlayback();
            if (ai.aK(1, this.mVideoUrl)) {
                w(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dR("obj_locate", "index").dR("tid", this.hXJ.tid));
                    this.mVideoUrl = this.hXJ.exA.bmS().video_url;
                }
                this.hXL = true;
                this.ZY.setVideoPath(this.mVideoUrl, this.hXJ.tid);
                if (this.gje != null) {
                    this.gje.start();
                }
                cnZ();
            }
        }
    }

    public void stopPlay() {
        this.hXP = false;
        bFs();
        cof();
        w(true, 1);
        if (this.ZY != null) {
            this.ZY.stopPlayback();
            if (this.gje != null) {
                this.gje.stop();
            }
        }
        this.hXL = false;
        this.hXE.stop();
    }

    public View getVideoContainer() {
        return this.fFu;
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

    public void or(boolean z) {
        this.hXM = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void vf(int i) {
        if (this.hXJ != null && this.hXJ.exA != null) {
            if (i == 1) {
                if (this.hXJ.exA.eGl > 0) {
                    this.gTD.eXx.setShowPraiseNum(false);
                    this.gTD.eXx.setShareVisible(false);
                    this.hXO.setText(at.numFormatOverWan(this.hXJ.exA.eGl));
                    this.hXO.setVisibility(0);
                } else {
                    this.gTD.eXx.setShowPraiseNum(true);
                    this.gTD.eXx.setShareVisible(true);
                    this.hXO.setVisibility(8);
                }
                this.gTD.setData(this.hXJ.exA);
                this.gSR.setVisibility(8);
                this.gSQ.jt(false);
                return;
            }
            this.gTD.setVisibility(8);
            this.gSQ.jt(true);
            if (this.hXJ.exA.eGl > 0) {
                this.gSR.setShowPraiseNum(false);
                this.gSR.setShareVisible(false);
                this.hXO.setText(at.numFormatOverWan(this.hXJ.exA.eGl));
                this.hXO.setVisibility(0);
            } else {
                this.gSR.setShowPraiseNum(true);
                this.gSR.setShareVisible(true);
                this.hXO.setVisibility(8);
            }
            if (this.gSR.setData(this.hXJ.exA)) {
                this.hXF.setVisibility(8);
            } else {
                this.hXF.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int tj(int i) {
        return com.baidu.tieba.a.d.bIR().ax(this.ahu, i);
    }

    private boolean coh() {
        return (this.hXJ == null || this.hXJ.exA == null || this.hXJ.exA.bmT() == null || TextUtils.isEmpty(this.hXJ.exA.bmT().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.hXE.onDestroy();
    }
}
