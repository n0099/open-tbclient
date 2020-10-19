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
public class l extends b<com.baidu.tieba.card.data.m> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView ZX;
    private int aae;
    private String aht;
    private Animation bKh;
    private CyberPlayerManager.OnPreparedListener dZP;
    private CyberPlayerManager.OnErrorListener dZQ;
    private CyberPlayerManager.OnCompletionListener dZR;
    private CyberPlayerManager.OnInfoListener dZS;
    private final View.OnClickListener eIr;
    private TbPageContext<?> etO;
    private View fCa;
    protected LinearLayout fJK;
    private com.baidu.tieba.play.f fTl;
    public FrameLayout frg;
    private TextView frh;
    private TbImageView fri;
    private ImageView frj;
    private TextView frk;
    private View frl;
    private com.baidu.tieba.play.m frm;
    private View frn;
    private TextView fro;
    private int frp;
    private TbImageView.a frq;
    private Runnable frt;
    private Runnable fru;
    private TbCyberVideoView.a frv;
    private RelativeLayout gAC;
    public ThreadUserInfoLayout gAD;
    public ThreadCommentAndPraiseInfoLayout gAE;
    private NEGFeedBackView gAP;
    public ThreadSourceShareAndPraiseLayout gBq;
    private final View.OnClickListener hFA;
    private final View.OnClickListener hFB;
    private CustomMessageListener hFC;
    private f.a hFD;
    private Animation.AnimationListener hFE;
    private com.baidu.afd.videopaster.d hFk;
    private View hFl;
    public ThreadGodReplyLayout hFm;
    private HeadPendantClickableView hFn;
    private LinearLayout hFo;
    private com.baidu.tieba.card.data.m hFp;
    private int hFq;
    private boolean hFr;
    private boolean hFs;
    private boolean hFt;
    private TextView hFu;
    private boolean hFv;
    private TextView hFw;
    private Handler hFx;
    private VideoLoadingProgressView.a hFy;
    private CustomMessageListener hFz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void ciq() {
        if (this.ZX != null && this.hFr) {
            try {
                this.ZX.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int PV = com.baidu.tieba.play.n.dry().PV(this.mVideoUrl);
            if (PV <= 100 || this.ZX.getDuration() <= PV) {
                PV = 100;
            }
            this.aae = PV;
            this.hFx.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cir() {
        if (this.hFp != null && this.hFp.eji != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.hFp.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.alS = this.hFp.eji.getTid();
            oVar.fkA = this.hFp.eji.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.hFp.eji.mRecomSource;
            oVar.lRy = this.hFp.eji.mRecomAbTag;
            oVar.lRu = this.hFp.eji.mRecomAbTag;
            oVar.lRv = this.hFp.eji.mRecomWeight;
            oVar.lRw = "";
            oVar.emE = this.hFp.getExtra();
            if (this.hFp.eji.biz() != null) {
                oVar.lRz = this.hFp.eji.biz().video_md5;
            }
            com.baidu.tieba.play.h.a(this.hFp.eji.biz().video_md5, "", "1", oVar, this.ZX.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gAP = null;
        this.mSkinType = 3;
        this.hFq = 0;
        this.frp = 1;
        this.hFr = false;
        this.hFs = true;
        this.hFt = false;
        this.aae = 100;
        this.hFv = false;
        this.hFx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.civ();
                        return;
                    case 203:
                        l.this.ciw();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.ZX != null) {
                    l.this.ZX.setVolume(0.0f, 0.0f);
                }
                l.this.ciq();
            }
        };
        this.dZS = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.w(false, 3);
                }
                return false;
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.hFk.a(false, false, "NEWINDEX")) {
                    l.this.ZX.start();
                }
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.w(true, 4);
                l.this.hFr = false;
                return true;
            }
        };
        this.hFy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.ciq();
            }
        };
        this.frq = new TbImageView.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.fri != null) {
                    l.this.fri.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.frt = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.ZX != null && !l.this.ZX.isPlaying()) {
                    l.this.w(true, 1);
                }
            }
        };
        this.fru = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.w(true, 4);
            }
        };
        this.hFz = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.hFp != null && l.this.hFp.eji != null && videoId.equals(l.this.hFp.eji.getId())) {
                        l.this.hFk.a(l.this.a(l.this.hFp, bVar));
                    }
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.hFA = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hFp == null) {
                    if (l.this.cil() != null) {
                        l.this.cil().a(view, l.this.hFp);
                        return;
                    }
                    return;
                }
                if (view == l.this.gAD.getUserName()) {
                    l.this.hFp.objType = 3;
                } else if (view == l.this.gAD.getHeaderImg()) {
                    l.this.hFp.objType = 4;
                } else {
                    l.this.hFp.objType = 1;
                }
                if (l.this.cil() != null) {
                    l.this.cil().a(view, l.this.hFp);
                }
            }
        };
        this.hFB = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hFp != null) {
                    l.this.hFp.objType = 4;
                }
                if (l.this.cil() != null) {
                    l.this.cil().a(view, l.this.hFp);
                }
            }
        };
        this.hFC = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.hFt = false;
                }
            }
        };
        this.eIr = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hFp != null) {
                    if (l.this.cil() != null) {
                        l.this.cil().a(view, l.this.hFp);
                    }
                    if (l.this.hFp.eji != null && view != l.this.gBq.eIB) {
                        m.Ij(l.this.hFp.eji.getId());
                        if (!l.this.ciu()) {
                            m.a(l.this.mTextTitle, l.this.hFp.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                            m.a(l.this.hFm.getGodReplyContent(), l.this.hFp.bfG().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.hFD = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                if (l.this.hFp != null && l.this.hFp.eji != null && l.this.hFp.eji.biz() != null) {
                    l.this.cir();
                }
            }
        };
        this.hFE = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.fri != null) {
                    l.this.fri.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.etO = tbPageContext;
        View view = getView();
        this.gAC = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hFn = (HeadPendantClickableView) this.gAC.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hFn.getHeadView() != null) {
            this.hFn.getHeadView().setIsRound(true);
            this.hFn.getHeadView().setDrawBorder(false);
            this.hFn.getHeadView().setDefaultResource(17170445);
            this.hFn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hFn.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.ds70));
            this.hFn.getHeadView().setPlaceHolder(1);
        }
        this.hFn.setHasPendantStyle();
        if (this.hFn.getPendantView() != null) {
            this.hFn.getPendantView().setIsRound(true);
            this.hFn.getPendantView().setDrawBorder(false);
        }
        this.frm = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.frm.setLoadingAnimationListener(this.hFy);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gAD = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gAP = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.gAP.a(this.gAC, dimens, 0);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.gAE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gAE.setLayoutParams(layoutParams);
        }
        this.gAE.setOnClickListener(this);
        this.gAE.setReplyTimeVisible(false);
        this.gAE.setShowPraiseNum(true);
        this.gAE.setNeedAddPraiseIcon(true);
        this.gAE.setNeedAddReplyIcon(true);
        this.gAE.setShareVisible(true);
        this.gAE.setShareReportFrom(3);
        this.gAE.setForumAfterClickListener(this.eIr);
        this.gAE.setFrom(1);
        this.gBq = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gBq.eJm.setOnClickListener(this);
        this.gBq.setFrom(1);
        this.gBq.setShareReportFrom(3);
        this.gBq.setForumAfterClickListener(this.eIr);
        this.hFl = view.findViewById(R.id.divider_below_reply_number_layout);
        this.frg = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.frg.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.etO.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.frg.setLayoutParams(layoutParams2);
        this.fri = (TbImageView) view.findViewById(R.id.image_video);
        this.fri.setDefaultErrorResource(0);
        this.fri.setPlaceHolder(3);
        this.fri.setGifIconSupport(false);
        this.fri.setEvent(this.frq);
        this.fri.setRadius(com.baidu.adp.lib.util.l.getDimens(this.etO.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fri;
        TbImageView tbImageView2 = this.fri;
        tbImageView.setConrers(15);
        this.fri.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fri.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fri.setBorderSurroundContent(true);
        this.fri.setDrawBorder(true);
        this.frj = (ImageView) view.findViewById(R.id.image_video_play);
        this.gAC.setOnClickListener(this);
        this.ZX = new TbCyberVideoView(getContext());
        this.ZX.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.frg.addView(this.ZX.getView(), 0);
        this.ZX.getView().setLayoutParams(layoutParams3);
        this.ZX.setContinuePlayEnable(true);
        this.ZX.setOnPreparedListener(this.dZP);
        this.ZX.setOnInfoListener(this.dZS);
        this.ZX.setOnCompletionListener(this.dZR);
        this.ZX.setOnErrorListener(this.dZQ);
        this.ZX.setOnSurfaceDestroyedListener(this.frv);
        this.fTl = new com.baidu.tieba.play.f();
        this.fTl.setPlayer(this.ZX);
        this.fTl.a(this.hFD);
        this.frh = (TextView) view.findViewById(R.id.text_video_duration);
        this.hFo = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fro = (TextView) view.findViewById(R.id.text_video_play_count);
        this.frn = view.findViewById(R.id.auto_video_black_mask);
        this.frk = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.frl = view.findViewById(R.id.auto_video_error_background);
        this.fJK = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bKh = AnimationUtils.loadAnimation(this.etO.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bKh.setAnimationListener(this.hFE);
        this.hFm = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hFm.setOnClickListener(this);
        this.fCa = view.findViewById(R.id.divider_line);
        this.hFu = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.ZX.getView().setOnClickListener(this);
        this.hFw = (TextView) view.findViewById(R.id.nani_video_icon);
        this.hFk = new com.baidu.afd.videopaster.d(getContext(), this.frg);
        this.hFk.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rQ() {
                if (!l.this.hFv) {
                    l.this.ZX.start();
                } else {
                    l.this.startPlay();
                }
                l.this.hFv = false;
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
        if (this.hFp != null && this.hFp.eji != null && this.hFp.eji.erW > 0) {
            if (cil() != null) {
                cil().a(view, this.hFp);
            }
            this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.etO.getPageActivity(), this.hFp.eji.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.bhT(), this.hFp.bfJ())));
            return;
        }
        if (view == this.gAC || view == this.hFm) {
            ck(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.ZX.getView()) {
            if (this.hFp != null) {
                this.hFp.objType = 5;
            }
            if (this.hFp != null && this.hFp.eji != null && this.hFp.eji.biz() != null) {
                z = this.hFp.eji.biz().is_vertical.intValue() == 1;
            }
            if (z) {
                ci(this.ZX.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cj(this.ZX.getView());
            } else {
                ck(getView());
            }
        }
    }

    private void ci(View view) {
        if (cil() != null) {
            cil().a(view, this.hFp);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.etO.getPageActivity(), R.string.no_network_guide);
        } else {
            cis();
        }
    }

    private void cj(View view) {
        if (cil() != null) {
            cil().a(view, this.hFp);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.etO.getPageActivity(), R.string.no_network_guide);
        } else {
            cit();
        }
    }

    private void cis() {
        if (this.hFp != null && this.hFp.eji != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.hFp.eji);
            videoItemData.mRecomExtra = this.hFp.getExtra();
            videoItemData.mRecomAbTag = this.hFp.ciW();
            videoItemData.mRecomSource = this.hFp.getSource();
            videoItemData.mRecomWeight = this.hFp.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.hFp.bfJ(), "index");
            if (this.hFp.eji.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.hFp.eji.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cit() {
        if (this.hFp != null && this.hFp.eji != null && this.hFp.eji.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.hFp.eji);
            videoSerializeVideoThreadInfo.source = this.hFp.getSource();
            videoSerializeVideoThreadInfo.extra = this.hFp.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.hFp.ciW();
            videoSerializeVideoThreadInfo.weight = this.hFp.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fJK.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fJK.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.etO.getPageActivity(), str, this.hFp.eji.getTid(), m.bhT(), this.hFp.bfJ(), videoSerializeVideoThreadInfo);
            if (this.hFp.bfG() != null && this.hFp.bfG().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.hFp.bfG().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void ck(View view) {
        if (this.hFp != null) {
            this.hFp.objType = 1;
        }
        if (cil() != null) {
            cil().a(view, this.hFp);
        }
        if (this.hFp != null && this.hFp.eji != null) {
            if (!ciu()) {
                m.Ij(this.hFp.eji.getId());
                m.a(this.mTextTitle, this.hFp.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.etO.getPageActivity()).createFromThreadCfg(this.hFp.eji, null, m.bhT(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hFp.bfJ());
            addLocateParam.setVideo_source(this.hFp.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.hFp.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.hFp.eji.getFid()));
            addLocateParam.setForumName(this.hFp.eji.bil());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.hFm) {
                addLocateParam.setJumpGodReply(true);
            }
            this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciu() {
        return this.hFp.hJr && !this.hFp.hJw;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.hFp = mVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void civ() {
        this.hFx.removeMessages(202);
        if (this.ZX.getCurrentPositionSync() > this.aae) {
            w(false, 3);
            this.hFx.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hFx.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciw() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hFx.removeMessages(203);
        int currentPositionSync = this.ZX.getCurrentPositionSync();
        if (currentPositionSync != this.hFq) {
            this.hFq = currentPositionSync;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hFx.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.frj != null && this.fri != null && this.frn != null && this.frm != null && this.frl != null && this.frk != null) {
            if (z || this.frp != i) {
                this.frp = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fru);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.frt);
                if (i == 2) {
                    this.frj.setVisibility(8);
                    this.bKh.cancel();
                    this.fri.clearAnimation();
                    this.fri.setVisibility(0);
                    this.frn.setVisibility(0);
                    this.hFo.setVisibility(0);
                    this.hFu.setVisibility(8);
                    this.frm.startLoading();
                    this.frl.setVisibility(8);
                    this.frk.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fru, 60000L);
                } else if (i == 3) {
                    this.frj.setVisibility(8);
                    this.fri.startAnimation(this.bKh);
                    this.frn.setVisibility(8);
                    this.hFo.setVisibility(8);
                    if (this.hFp != null && this.hFp.bfG() != null && this.hFp.bfG().erW > 0) {
                        this.hFu.setVisibility(0);
                    }
                    this.frm.drt();
                    this.frl.setVisibility(8);
                    this.frk.setVisibility(8);
                    if (this.hFp != null && this.hFp.eji != null && this.hFp.eji.biz() != null) {
                        this.hFp.eji.biz().video_length.intValue();
                        this.hFp.eji.biz().video_duration.intValue();
                        this.hFp.eji.getTid();
                    }
                } else if (i == 4) {
                    this.frj.setVisibility(8);
                    this.fri.startAnimation(this.bKh);
                    this.frn.setVisibility(8);
                    this.frm.dru();
                    this.frl.setVisibility(0);
                    this.frk.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.frt, 2000L);
                } else {
                    this.frj.setVisibility(0);
                    this.bKh.cancel();
                    this.fri.clearAnimation();
                    this.fri.setVisibility(0);
                    this.frn.setVisibility(0);
                    this.hFo.setVisibility(0);
                    this.frm.dru();
                    this.frl.setVisibility(8);
                    this.frk.setVisibility(8);
                }
                if (this.hFp != null && this.hFp.bfG() != null && this.hFp.bfG().erW > 0) {
                    this.hFo.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.hFp == null || this.hFp.eji == null || this.hFp.eji.bih() == null) {
            this.gAC.setVisibility(8);
            return;
        }
        this.gAC.setVisibility(0);
        ciy();
        if (!ciu() && m.Ik(this.hFp.eji.getId())) {
            m.a(this.mTextTitle, this.hFp.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hFm.getGodReplyContent(), this.hFp.bfG().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        this.hFp.bfG().bjf();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hFp.bfG().biR());
        if (this.hFp.bfG().biX() && !StringUtils.isNull(this.hFp.bfG().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.blO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.hFp.bfG().getTid();
            spannableStringBuilder.append((CharSequence) this.hFp.bfG().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dK("obj_source", "0"));
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
        this.gAD.setData(this.hFp.bfG());
        this.gAD.setUserAfterClickListener(this.hFA);
        if (this.gAD.getHeaderImg() != null) {
            this.gAD.getHeaderImg().setAfterClickListener(this.hFB);
            if (this.gAD.getIsSimpleThread()) {
                this.gAD.getHeaderImg().setVisibility(8);
                this.hFn.setVisibility(8);
            } else if (this.hFp.bfG() == null || this.hFp.bfG().bih() == null || this.hFp.bfG().bih().getPendantData() == null || StringUtils.isNull(this.hFp.bfG().bih().getPendantData().bgd())) {
                this.hFn.setVisibility(8);
                this.gAD.getHeaderImg().setVisibility(0);
                if (this.hFp.bfG().erW > 0 && this.hFp.bfG().erX == 0) {
                    this.hFp.bfG().bih().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.gAD.getHeaderImg().setData(this.hFp.bfG(), false);
                } else {
                    this.gAD.getHeaderImg().setData(this.hFp.bfG());
                    this.gAD.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.gAD.getHeaderImg().setVisibility(4);
                this.hFn.setVisibility(0);
                this.hFn.setData(this.hFp.bfG());
            }
        }
        this.frh.setText(at.stringForVideoTime(this.hFp.eji.biz().video_duration.intValue() * 1000));
        this.fro.setText(String.format(this.etO.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hFp.eji.biz().play_count.intValue())));
        if (this.gAP != null && this.hFp.bfG() != null) {
            ar arVar = new ar();
            arVar.setTid(this.hFp.bfG().getTid());
            arVar.setFid(this.hFp.bfG().getFid());
            arVar.setNid(this.hFp.bfG().getNid());
            arVar.setFeedBackReasonMap(this.hFp.feedBackReasonMap);
            this.gAP.setData(arVar);
            this.gAP.setFirstRowSingleColumn(true);
            this.gAP.setVisibility(this.hFs ? 0 : 8);
        }
        this.hFm.setData(this.hFp.bfG().bjK());
        uz(sO(1));
        onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
        if (m.Ik(this.hFp.eji.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.hFp == null || this.hFp.eji == null || this.hFp.eji.biz() == null) {
            z = false;
        } else {
            z = this.hFp.eji.biz().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hFw.setVisibility(0);
            if (ciz()) {
                this.hFw.setText(String.format("%s | %s", this.etO.getResources().getString(R.string.nani_video), this.etO.getResources().getString(R.string.video_preview)));
            } else {
                this.hFw.setText(this.etO.getString(R.string.nani_video));
            }
        } else if (ciz()) {
            this.hFw.setVisibility(0);
            this.hFw.setText(this.etO.getString(R.string.video_preview));
        } else {
            this.hFw.setVisibility(8);
        }
    }

    private void cix() {
        this.hFx.removeMessages(202);
        this.hFx.removeMessages(203);
    }

    private void bBa() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.frt);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fru);
    }

    private void ciy() {
        bBa();
        cix();
        if (this.fri != null && this.frg != null && this.ZX != null) {
            if (com.baidu.tbadk.core.k.bfo().isShowImages() && this.hFp != null && this.hFp.eji != null && this.hFp.eji.biz() != null) {
                this.fri.setPlaceHolder(3);
                this.fri.startLoad(this.hFp.eji.biz().thumbnail_url, 10, false);
                this.frg.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.hFp.eji.biz().video_url;
                if (ciz()) {
                    this.mVideoUrl = this.hFp.eji.biA().video_url;
                }
                if (StringUtils.isNull(this.hFp.eji.biz().video_url)) {
                    w(true, 4);
                }
                this.ZX.setThreadDataForStatistic(this.hFp.eji);
            } else {
                this.frg.setVisibility(8);
            }
            this.hFk.reset();
            this.fTl.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void ca(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.hFk.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.hFp);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.m mVar) {
        if (mVar != null && mVar.eji != null) {
            bw bwVar = mVar.eji;
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
        if (mVar == null || mVar.eji == null || bVar == null) {
            return null;
        }
        bw bwVar = mVar.eji;
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
        VideoInfo biz = bwVar.biz();
        if (biz != null) {
            i3 = biz.video_width.intValue();
            i2 = biz.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.bil());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gAC, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.frj, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.frk, R.color.cp_cont_a);
            ap.setViewTextColor(this.frh, R.color.cp_cont_a);
            ap.setViewTextColor(this.fro, R.color.cp_cont_a);
            ap.setViewTextColor(this.hFu, R.color.cp_cont_a);
            ap.setBackgroundColor(this.frl, R.color.common_color_10014);
            ap.setBackgroundColor(this.fCa, R.color.cp_bg_line_c);
            if (this.hFw != null) {
                ap.setViewTextColor(this.hFw, R.color.cp_cont_a);
                ap.setBackgroundResource(this.hFw, R.drawable.video_play_count_bg);
            }
            if (this.frk != null) {
                this.frk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.hFm.onChangeSkinType();
            if (this.gAP != null) {
                this.gAP.onChangeSkinType();
            }
            this.gAD.onChangeSkinType();
            this.gAE.onChangeSkinType();
            this.gBq.onChangeSkinType();
            this.fri.setPlaceHolder(3);
            this.hFn.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hFC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hFC);
            this.hFz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hFz);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gAD != null) {
            this.gAD.setPageUniqueId(bdUniqueId);
        }
        if (this.fri != null) {
            this.fri.setPageId(bdUniqueId);
        }
        if (this.gAP != null) {
            this.gAP.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.hFr;
    }

    public boolean isPlaying() {
        if (this.ZX == null) {
            return false;
        }
        return this.ZX.isPlaying();
    }

    public void startPlay() {
        if (!this.hFr && this.hFp != null && this.hFp.eji != null && this.hFp.eji.biz() != null && this.ZX != null) {
            if (this.hFk.rA()) {
                this.hFk.resume();
                this.hFv = true;
                return;
            }
            this.hFv = false;
            this.ZX.stopPlayback();
            if (ai.aE(1, this.mVideoUrl)) {
                w(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dK("obj_locate", "index").dK("tid", this.hFp.tid));
                    this.mVideoUrl = this.hFp.eji.biz().video_url;
                }
                this.hFr = true;
                this.ZX.setVideoPath(this.mVideoUrl, this.hFp.tid);
                if (this.fTl != null) {
                    this.fTl.start();
                }
                cir();
            }
        }
    }

    public void stopPlay() {
        this.hFv = false;
        bBa();
        cix();
        w(true, 1);
        if (this.ZX != null) {
            this.ZX.stopPlayback();
            if (this.fTl != null) {
                this.fTl.stop();
            }
        }
        this.hFr = false;
        this.hFk.stop();
    }

    public View getVideoContainer() {
        return this.frg;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZX == null) {
            return 0;
        }
        return this.ZX.getCurrentPosition();
    }

    public void nQ(boolean z) {
        this.hFs = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void uz(int i) {
        if (this.hFp != null && this.hFp.eji != null) {
            if (i == 1) {
                if (this.hFp.eji.erW > 0) {
                    this.gBq.eJm.setShowPraiseNum(false);
                    this.gBq.eJm.setShareVisible(false);
                    this.hFu.setText(at.numFormatOverWan(this.hFp.eji.erW));
                    this.hFu.setVisibility(0);
                } else {
                    this.gBq.eJm.setShowPraiseNum(true);
                    this.gBq.eJm.setShareVisible(true);
                    this.hFu.setVisibility(8);
                }
                this.gBq.setData(this.hFp.eji);
                this.gAE.setVisibility(8);
                this.gAD.iX(false);
                return;
            }
            this.gBq.setVisibility(8);
            this.gAD.iX(true);
            if (this.hFp.eji.erW > 0) {
                this.gAE.setShowPraiseNum(false);
                this.gAE.setShareVisible(false);
                this.hFu.setText(at.numFormatOverWan(this.hFp.eji.erW));
                this.hFu.setVisibility(0);
            } else {
                this.gAE.setShowPraiseNum(true);
                this.gAE.setShareVisible(true);
                this.hFu.setVisibility(8);
            }
            if (this.gAE.setData(this.hFp.eji)) {
                this.hFl.setVisibility(8);
            } else {
                this.hFl.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public int sO(int i) {
        return com.baidu.tieba.a.d.bEz().av(this.aht, i);
    }

    private boolean ciz() {
        return (this.hFp == null || this.hFp.eji == null || this.hFp.eji.biA() == null || TextUtils.isEmpty(this.hFp.eji.biA().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.hFk.onDestroy();
    }
}
