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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class l extends b<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView abI;
    private int abO;
    private String air;
    private Animation cdP;
    private TbPageContext<?> eSJ;
    private CyberPlayerManager.OnPreparedListener eyt;
    private CyberPlayerManager.OnErrorListener eyu;
    private CyberPlayerManager.OnCompletionListener eyv;
    private CyberPlayerManager.OnInfoListener eyw;
    public FrameLayout fRF;
    private TextView fRG;
    private TbImageView fRH;
    private ImageView fRI;
    private TextView fRJ;
    private View fRK;
    private com.baidu.tieba.play.m fRL;
    private View fRM;
    private TextView fRN;
    private int fRO;
    private TbImageView.b fRP;
    private Runnable fRR;
    private Runnable fRS;
    private TbCyberVideoView.a fRT;
    private final View.OnClickListener fih;
    private View gde;
    protected LinearLayout gln;
    private com.baidu.tieba.play.f gxo;
    private RelativeLayout hiR;
    public ThreadUserInfoLayout hiS;
    public ThreadCommentAndPraiseInfoLayout hiT;
    public ThreadSourceShareAndPraiseLayout hjF;
    private NEGFeedBackView hje;
    private com.baidu.afd.videopaster.d iqR;
    private View iqS;
    public ThreadGodReplyLayout iqT;
    private HeadPendantClickableView iqU;
    private LinearLayout iqV;
    private com.baidu.tieba.card.data.l iqW;
    private int iqX;
    private boolean iqY;
    private boolean iqZ;
    private boolean ira;
    private TextView irb;
    private boolean irc;
    private TextView ird;
    private Handler ire;
    private VideoLoadingProgressView.a irf;
    private CustomMessageListener irg;
    private final View.OnClickListener irh;
    private final View.OnClickListener iri;
    private CustomMessageListener irj;
    private f.a irk;
    private Animation.AnimationListener irl;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cqQ() {
        if (this.abI != null && this.iqY) {
            try {
                this.abI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int PM = com.baidu.tieba.play.n.dxY().PM(this.mVideoUrl);
            if (PM <= 100 || this.abI.getDuration() <= PM) {
                PM = 100;
            }
            this.abO = PM;
            this.ire.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        if (this.iqW != null && this.iqW.eHK != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.iqW.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.amM = this.iqW.eHK.getTid();
            oVar.fKR = this.iqW.eHK.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.iqW.eHK.mRecomSource;
            oVar.mzb = this.iqW.eHK.mRecomAbTag;
            oVar.myX = this.iqW.eHK.mRecomAbTag;
            oVar.myY = this.iqW.eHK.mRecomWeight;
            oVar.myZ = "";
            oVar.eLs = this.iqW.getExtra();
            if (this.iqW.eHK.bnO() != null) {
                oVar.mzc = this.iqW.eHK.bnO().video_md5;
            }
            com.baidu.tieba.play.h.a(this.iqW.eHK.bnO().video_md5, "", "1", oVar, this.abI.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hje = null;
        this.mSkinType = 3;
        this.iqX = 0;
        this.fRO = 1;
        this.iqY = false;
        this.iqZ = true;
        this.ira = false;
        this.abO = 100;
        this.irc = false;
        this.ire = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.cqV();
                        return;
                    case 203:
                        l.this.cqW();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.abI != null) {
                    l.this.abI.setVolume(0.0f, 0.0f);
                }
                l.this.cqQ();
            }
        };
        this.eyw = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.iqR.d(false, false, "NEWINDEX")) {
                    l.this.abI.start();
                }
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.iqY = false;
                return true;
            }
        };
        this.irf = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.cqQ();
            }
        };
        this.fRP = new TbImageView.b() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && l.this.fRH != null) {
                    l.this.fRH.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fRR = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.abI != null && !l.this.abI.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.fRS = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.irg = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.iqW != null && l.this.iqW.eHK != null && videoId.equals(l.this.iqW.eHK.getId())) {
                        l.this.iqR.a(l.this.a(l.this.iqW, bVar));
                    }
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.irh = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iqW == null) {
                    if (l.this.cqL() != null) {
                        l.this.cqL().a(view, l.this.iqW);
                        return;
                    }
                    return;
                }
                if (view == l.this.hiS.getUserName()) {
                    l.this.iqW.objType = 3;
                } else if (view == l.this.hiS.getHeaderImg()) {
                    l.this.iqW.objType = 4;
                } else {
                    l.this.iqW.objType = 1;
                }
                if (l.this.cqL() != null) {
                    l.this.cqL().a(view, l.this.iqW);
                }
            }
        };
        this.iri = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iqW != null) {
                    l.this.iqW.objType = 4;
                }
                if (l.this.cqL() != null) {
                    l.this.cqL().a(view, l.this.iqW);
                }
            }
        };
        this.irj = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.ira = false;
                }
            }
        };
        this.fih = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.iqW != null) {
                    if (l.this.cqL() != null) {
                        l.this.cqL().a(view, l.this.iqW);
                    }
                    if (l.this.iqW.eHK != null && view != l.this.hjF.fio) {
                        m.Ic(l.this.iqW.eHK.getId());
                        if (!l.this.cqU()) {
                            m.a(l.this.mTextTitle, l.this.iqW.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                            m.a(l.this.iqT.getGodReplyContent(), l.this.iqW.bkV().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
                        }
                    }
                }
            }
        };
        this.irk = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void rF() {
                if (l.this.iqW != null && l.this.iqW.eHK != null && l.this.iqW.eHK.bnO() != null) {
                    l.this.cqR();
                }
            }
        };
        this.irl = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.fRH != null) {
                    l.this.fRH.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.eSJ = tbPageContext;
        View view = getView();
        this.hiR = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.iqU = (HeadPendantClickableView) this.hiR.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.iqU.getHeadView() != null) {
            this.iqU.getHeadView().setIsRound(true);
            this.iqU.getHeadView().setDrawBorder(false);
            this.iqU.getHeadView().setDefaultResource(17170445);
            this.iqU.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds70));
            this.iqU.getHeadView().setPlaceHolder(1);
        }
        this.iqU.setHasPendantStyle();
        if (this.iqU.getPendantView() != null) {
            this.iqU.getPendantView().setIsRound(true);
            this.iqU.getPendantView().setDrawBorder(false);
        }
        this.fRL = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fRL.setLoadingAnimationListener(this.irf);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hiS = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hje = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.hje.a(this.hiR, dimens, 0);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.hiT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hiT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hiT.setLayoutParams(layoutParams);
        }
        this.hiT.setOnClickListener(this);
        this.hiT.setReplyTimeVisible(false);
        this.hiT.setShowPraiseNum(true);
        this.hiT.setNeedAddPraiseIcon(true);
        this.hiT.setNeedAddReplyIcon(true);
        this.hiT.setShareVisible(true);
        this.hiT.setShareReportFrom(3);
        this.hiT.setForumAfterClickListener(this.fih);
        this.hiT.setFrom(1);
        this.hjF = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hjF.fjb.setOnClickListener(this);
        this.hjF.setFrom(1);
        this.hjF.setShareReportFrom(3);
        this.hjF.setForumAfterClickListener(this.fih);
        this.iqS = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fRF = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fRF.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.eSJ.getPageActivity()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fRF.setLayoutParams(layoutParams2);
        this.fRH = (TbImageView) view.findViewById(R.id.image_video);
        this.fRH.setPlaceHolder(3);
        this.fRH.setGifIconSupport(false);
        this.fRH.setEvent(this.fRP);
        this.fRH.setRadius(com.baidu.adp.lib.util.l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fRH;
        TbImageView tbImageView2 = this.fRH;
        tbImageView.setConrers(15);
        this.fRH.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fRH.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.fRH.setBorderSurroundContent(true);
        this.fRH.setDrawBorder(true);
        this.fRI = (ImageView) view.findViewById(R.id.image_video_play);
        this.hiR.setOnClickListener(this);
        this.abI = new TbCyberVideoView(getContext());
        this.abI.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fRF.addView(this.abI.getView(), 0);
        this.abI.getView().setLayoutParams(layoutParams3);
        this.abI.setContinuePlayEnable(true);
        this.abI.setOnPreparedListener(this.eyt);
        this.abI.setOnInfoListener(this.eyw);
        this.abI.setOnCompletionListener(this.eyv);
        this.abI.setOnErrorListener(this.eyu);
        this.abI.setOnSurfaceDestroyedListener(this.fRT);
        this.gxo = new com.baidu.tieba.play.f();
        this.gxo.setPlayer(this.abI);
        this.gxo.a(this.irk);
        this.fRG = (TextView) view.findViewById(R.id.text_video_duration);
        this.iqV = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fRN = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fRM = view.findViewById(R.id.auto_video_black_mask);
        this.fRJ = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fRK = view.findViewById(R.id.auto_video_error_background);
        this.gln = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.cdP = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.cdP.setAnimationListener(this.irl);
        this.iqT = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.iqT.setOnClickListener(this);
        this.gde = view.findViewById(R.id.divider_line);
        this.irb = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.abI.getView().setOnClickListener(this);
        this.ird = (TextView) view.findViewById(R.id.nani_video_icon);
        this.iqR = new com.baidu.afd.videopaster.d(getContext(), this.fRF);
        this.iqR.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void ru() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rt() {
                if (!l.this.irc) {
                    l.this.abI.start();
                } else {
                    l.this.startPlay();
                }
                l.this.irc = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rv() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.iqW != null && this.iqW.eHK != null && this.iqW.eHK.eQO > 0) {
            if (cqL() != null) {
                cqL().a(view, this.iqW);
            }
            this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.eSJ.getPageActivity(), this.iqW.eHK.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.bnj(), this.iqW.bkY())));
            return;
        }
        if (view == this.hiR || view == this.iqT) {
            cO(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.abI.getView()) {
            if (this.iqW != null) {
                this.iqW.objType = 5;
            }
            if (this.iqW != null && this.iqW.eHK != null && this.iqW.eHK.bnO() != null) {
                z = this.iqW.eHK.bnO().is_vertical.intValue() == 1;
            }
            if (z) {
                cM(this.abI.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cN(this.abI.getView());
            } else {
                cO(getView());
            }
        }
    }

    private void cM(View view) {
        if (cqL() != null) {
            cqL().a(view, this.iqW);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eSJ.getPageActivity(), R.string.no_network_guide);
        } else {
            cqS();
        }
    }

    private void cN(View view) {
        if (cqL() != null) {
            cqL().a(view, this.iqW);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.eSJ.getPageActivity(), R.string.no_network_guide);
        } else {
            cqT();
        }
    }

    private void cqS() {
        if (this.iqW != null && this.iqW.eHK != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.iqW.eHK);
            videoItemData.mRecomExtra = this.iqW.getExtra();
            videoItemData.mRecomAbTag = this.iqW.crw();
            videoItemData.mRecomSource = this.iqW.getSource();
            videoItemData.mRecomWeight = this.iqW.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.iqW.bkY(), "index");
            if (this.iqW.eHK.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.iqW.eHK.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cqT() {
        if (this.iqW != null && this.iqW.eHK != null && this.iqW.eHK.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.iqW.eHK);
            videoSerializeVideoThreadInfo.source = this.iqW.getSource();
            videoSerializeVideoThreadInfo.extra = this.iqW.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.iqW.crw();
            videoSerializeVideoThreadInfo.weight = this.iqW.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.gln.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.gln.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eSJ.getPageActivity(), str, this.iqW.eHK.getTid(), m.bnj(), this.iqW.bkY(), videoSerializeVideoThreadInfo);
            if (this.iqW.bkV() != null && this.iqW.bkV().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.iqW.bkV().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void cO(View view) {
        if (this.iqW != null) {
            this.iqW.objType = 1;
        }
        if (cqL() != null) {
            cqL().a(view, this.iqW);
        }
        if (this.iqW != null && this.iqW.eHK != null) {
            if (!cqU()) {
                m.Ic(this.iqW.eHK.getId());
                m.a(this.mTextTitle, this.iqW.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eSJ.getPageActivity()).createFromThreadCfg(this.iqW.eHK, null, m.bnj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.iqW.bkY());
            addLocateParam.setVideo_source(this.iqW.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.iqW.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.iqW.eHK.getFid()));
            addLocateParam.setForumName(this.iqW.eHK.bnB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.iqT) {
                addLocateParam.setJumpGodReply(true);
            }
            this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqU() {
        return this.iqW.ivn && !this.iqW.ivs;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.iqW = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqV() {
        this.ire.removeMessages(202);
        if (this.abI.getCurrentPositionSync() > this.abO) {
            v(false, 3);
            this.ire.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.ire.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqW() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ire.removeMessages(203);
        int currentPositionSync = this.abI.getCurrentPositionSync();
        if (currentPositionSync != this.iqX) {
            this.iqX = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.ire.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fRI != null && this.fRH != null && this.fRM != null && this.fRL != null && this.fRK != null && this.fRJ != null) {
            if (z || this.fRO != i) {
                this.fRO = i;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRS);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRR);
                if (i == 2) {
                    this.fRI.setVisibility(8);
                    this.cdP.cancel();
                    this.fRH.clearAnimation();
                    this.fRH.setVisibility(0);
                    this.fRM.setVisibility(0);
                    this.iqV.setVisibility(0);
                    this.irb.setVisibility(8);
                    this.fRL.startLoading();
                    this.fRK.setVisibility(8);
                    this.fRJ.setVisibility(8);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fRS, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fRI.setVisibility(8);
                    this.fRH.startAnimation(this.cdP);
                    this.fRM.setVisibility(8);
                    this.iqV.setVisibility(8);
                    if (this.iqW != null && this.iqW.bkV() != null && this.iqW.bkV().eQO > 0) {
                        this.irb.setVisibility(0);
                    }
                    this.fRL.dxT();
                    this.fRK.setVisibility(8);
                    this.fRJ.setVisibility(8);
                    if (this.iqW != null && this.iqW.eHK != null && this.iqW.eHK.bnO() != null) {
                        this.iqW.eHK.bnO().video_length.intValue();
                        this.iqW.eHK.bnO().video_duration.intValue();
                        this.iqW.eHK.getTid();
                    }
                } else if (i == 4) {
                    this.fRI.setVisibility(8);
                    this.fRH.startAnimation(this.cdP);
                    this.fRM.setVisibility(8);
                    this.fRL.dxU();
                    this.fRK.setVisibility(0);
                    this.fRJ.setVisibility(0);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fRR, 2000L);
                } else {
                    this.fRI.setVisibility(0);
                    this.cdP.cancel();
                    this.fRH.clearAnimation();
                    this.fRH.setVisibility(0);
                    this.fRM.setVisibility(0);
                    this.iqV.setVisibility(0);
                    this.fRL.dxU();
                    this.fRK.setVisibility(8);
                    this.fRJ.setVisibility(8);
                }
                if (this.iqW != null && this.iqW.bkV() != null && this.iqW.bkV().eQO > 0) {
                    this.iqV.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.iqW == null || this.iqW.eHK == null || this.iqW.eHK.bnx() == null) {
            this.hiR.setVisibility(8);
            return;
        }
        this.hiR.setVisibility(0);
        cqY();
        if (!cqU() && m.Id(this.iqW.eHK.getId())) {
            m.a(this.mTextTitle, this.iqW.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iqT.getGodReplyContent(), this.iqW.bkV().getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        this.iqW.bkV().box();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.iqW.bkV().bog());
        if (this.iqW.bkV().bon() && !StringUtils.isNull(this.iqW.bkV().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.brx().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.iqW.bkV().getTid();
            spannableStringBuilder.append((CharSequence) this.iqW.bkV().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dW("obj_source", "0"));
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
        this.hiS.setData(this.iqW.bkV());
        this.hiS.setUserAfterClickListener(this.irh);
        if (this.hiS.getHeaderImg() != null) {
            this.hiS.getHeaderImg().setAfterClickListener(this.iri);
            if (this.hiS.getIsSimpleThread()) {
                this.hiS.getHeaderImg().setVisibility(8);
                this.iqU.setVisibility(8);
            } else if (this.iqW.bkV() == null || this.iqW.bkV().bnx() == null || this.iqW.bkV().bnx().getPendantData() == null || StringUtils.isNull(this.iqW.bkV().bnx().getPendantData().getImgUrl())) {
                this.iqU.setVisibility(8);
                this.hiS.getHeaderImg().setVisibility(0);
                if (this.iqW.bkV().eQO > 0 && this.iqW.bkV().eQP == 0) {
                    this.iqW.bkV().bnx().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.hiS.getHeaderImg().setData(this.iqW.bkV(), false);
                } else {
                    this.hiS.getHeaderImg().setData(this.iqW.bkV());
                    this.hiS.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.hiS.getHeaderImg().setVisibility(4);
                this.iqU.setVisibility(0);
                this.iqU.setData(this.iqW.bkV());
            }
        }
        this.fRG.setText(at.stringForVideoTime(this.iqW.eHK.bnO().video_duration.intValue() * 1000));
        this.fRN.setText(String.format(this.eSJ.getResources().getString(R.string.play_count), at.numFormatOverWan(this.iqW.eHK.bnO().play_count.intValue())));
        if (this.hje != null && this.iqW.bkV() != null) {
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setTid(this.iqW.bkV().getTid());
            atVar.setFid(this.iqW.bkV().getFid());
            atVar.setNid(this.iqW.bkV().blV());
            atVar.setFeedBackReasonMap(this.iqW.feedBackReasonMap);
            this.hje.setData(atVar);
            this.hje.setFirstRowSingleColumn(true);
            this.hje.setVisibility(this.iqZ ? 0 : 8);
        }
        this.iqT.setData(this.iqW.bkV().bpd());
        uP(sR(1));
        onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        if (m.Id(this.iqW.eHK.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.iqW == null || this.iqW.eHK == null || this.iqW.eHK.bnO() == null) {
            z = false;
        } else {
            z = this.iqW.eHK.bnO().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ird.setVisibility(0);
            if (cqZ()) {
                this.ird.setText(String.format("%s | %s", this.eSJ.getResources().getString(R.string.nani_video), this.eSJ.getResources().getString(R.string.video_preview)));
            } else {
                this.ird.setText(this.eSJ.getString(R.string.nani_video));
            }
        } else if (cqZ()) {
            this.ird.setVisibility(0);
            this.ird.setText(this.eSJ.getString(R.string.video_preview));
        } else {
            this.ird.setVisibility(8);
        }
    }

    private void cqX() {
        this.ire.removeMessages(202);
        this.ire.removeMessages(203);
    }

    private void bGP() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRR);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRS);
    }

    private void cqY() {
        bGP();
        cqX();
        if (this.fRH != null && this.fRF != null && this.abI != null) {
            if (com.baidu.tbadk.core.k.bkB().isShowImages() && this.iqW != null && this.iqW.eHK != null && this.iqW.eHK.bnO() != null) {
                this.fRH.setPlaceHolder(3);
                this.fRH.startLoad(this.iqW.eHK.bnO().thumbnail_url, 10, false);
                this.fRF.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.iqW.eHK.bnO().video_url;
                if (cqZ()) {
                    this.mVideoUrl = this.iqW.eHK.bnP().video_url;
                }
                if (StringUtils.isNull(this.iqW.eHK.bnO().video_url)) {
                    v(true, 4);
                }
                this.abI.setThreadDataForStatistic(this.iqW.eHK);
            } else {
                this.fRF.setVisibility(8);
            }
            this.iqR.reset();
            this.gxo.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void ch(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.iqR.d(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.iqW);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.eHK != null) {
            bz bzVar = lVar.eHK;
            if (bzVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bzVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (lVar == null || lVar.eHK == null || bVar == null) {
            return null;
        }
        bz bzVar = lVar.eHK;
        int rz = bVar.rz();
        int rA = bVar.rA();
        int ry = bVar.ry();
        if (ry != -1) {
            i2 = rz != -1 ? (ry - rz) - 1 : -1;
            i = rA != -1 ? (rA - ry) - 1 : -1;
        } else {
            i = -1;
            i2 = -1;
        }
        VideoInfo bnO = bzVar.bnO();
        if (bnO != null) {
            i4 = bnO.video_width.intValue();
            i3 = bnO.video_height.intValue();
        } else {
            i3 = 0;
            i4 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bzVar.getId());
        hashMap.put("video_title", bzVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bzVar.getFid()));
        hashMap.put("forum_name", bzVar.bnB());
        hashMap.put("up_distance", String.valueOf(i2));
        hashMap.put("down_distance", String.valueOf(i));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", ry + 1, i4, i3);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hiR, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.fRI, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.fRJ, R.color.CAM_X0101);
            ao.setViewTextColor(this.fRG, R.color.CAM_X0101);
            ao.setViewTextColor(this.fRN, R.color.CAM_X0101);
            ao.setViewTextColor(this.irb, R.color.CAM_X0101);
            ao.setBackgroundColor(this.fRK, R.color.common_color_10014);
            ao.setBackgroundColor(this.gde, R.color.CAM_X0204);
            if (this.ird != null) {
                ao.setViewTextColor(this.ird, R.color.CAM_X0101);
                ao.setBackgroundResource(this.ird, R.drawable.video_play_count_bg);
            }
            if (this.fRJ != null) {
                this.fRJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.iqT.onChangeSkinType();
            if (this.hje != null) {
                this.hje.onChangeSkinType();
            }
            this.hiS.onChangeSkinType();
            this.hiT.onChangeSkinType();
            this.hjF.onChangeSkinType();
            this.fRH.setPlaceHolder(3);
            this.iqU.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.irj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.irj);
            this.irg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.irg);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hiS != null) {
            this.hiS.setPageUniqueId(bdUniqueId);
        }
        if (this.fRH != null) {
            this.fRH.setPageId(bdUniqueId);
        }
        if (this.hje != null) {
            this.hje.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.iqY;
    }

    public boolean isPlaying() {
        if (this.abI == null) {
            return false;
        }
        return this.abI.isPlaying();
    }

    public void startPlay() {
        if (!this.iqY && this.iqW != null && this.iqW.eHK != null && this.iqW.eHK.bnO() != null && this.abI != null) {
            if (this.iqR.re()) {
                this.iqR.resume();
                this.irc = true;
                return;
            }
            this.irc = false;
            this.abI.stopPlayback();
            if (ah.aL(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dW("obj_locate", "index").dW("tid", this.iqW.tid));
                    this.mVideoUrl = this.iqW.eHK.bnO().video_url;
                }
                this.iqY = true;
                this.abI.setVideoPath(this.mVideoUrl, this.iqW.tid);
                if (this.gxo != null) {
                    this.gxo.start();
                }
                cqR();
            }
        }
    }

    public void stopPlay() {
        this.irc = false;
        bGP();
        cqX();
        v(true, 1);
        if (this.abI != null) {
            this.abI.stopPlayback();
            if (this.gxo != null) {
                this.gxo.stop();
            }
        }
        this.iqY = false;
        this.iqR.stop();
    }

    public View getVideoContainer() {
        return this.fRF;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abI == null) {
            return 0;
        }
        return this.abI.getCurrentPosition();
    }

    public void pk(boolean z) {
        this.iqZ = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void uP(int i) {
        if (this.iqW != null && this.iqW.eHK != null) {
            if (i == 1) {
                if (this.iqW.eHK.eQO > 0) {
                    this.hjF.fjb.setShowPraiseNum(false);
                    this.hjF.fjb.setShareVisible(false);
                    this.irb.setText(at.numFormatOverWan(this.iqW.eHK.eQO));
                    this.irb.setVisibility(0);
                } else {
                    this.hjF.fjb.setShowPraiseNum(true);
                    this.hjF.fjb.setShareVisible(true);
                    this.irb.setVisibility(8);
                }
                this.hjF.setData(this.iqW.eHK);
                this.hiT.setVisibility(8);
                this.hiS.kc(false);
                return;
            }
            this.hjF.setVisibility(8);
            this.hiS.kc(true);
            if (this.iqW.eHK.eQO > 0) {
                this.hiT.setShowPraiseNum(false);
                this.hiT.setShareVisible(false);
                this.irb.setText(at.numFormatOverWan(this.iqW.eHK.eQO));
                this.irb.setVisibility(0);
            } else {
                this.hiT.setShowPraiseNum(true);
                this.hiT.setShareVisible(true);
                this.irb.setVisibility(8);
            }
            if (this.hiT.setData(this.iqW.eHK)) {
                this.iqS.setVisibility(8);
            } else {
                this.iqS.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public int sR(int i) {
        return com.baidu.tieba.a.d.bKv().az(this.air, i);
    }

    private boolean cqZ() {
        return (this.iqW == null || this.iqW.eHK == null || this.iqW.eHK.bnP() == null || TextUtils.isEmpty(this.iqW.eHK.bnP().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.iqR.onDestroy();
    }
}
