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
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class l extends b<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private int Ys;
    private String aeX;
    private Animation boX;
    private TbPageContext<?> dIF;
    private final View.OnClickListener dWy;
    public FrameLayout eAZ;
    private TextView eBa;
    private TbImageView eBb;
    private ImageView eBc;
    private TextView eBd;
    private View eBe;
    private com.baidu.tieba.play.w eBf;
    private View eBg;
    private TextView eBh;
    private int eBi;
    private TbImageView.a eBj;
    private g.b eBk;
    private Runnable eBm;
    private Runnable eBn;
    private QuickVideoView.b eBo;
    private g.a eKl;
    private g.f eKm;
    private g.e eKo;
    private View eLg;
    protected LinearLayout eTB;
    private RelativeLayout fGm;
    public ThreadUserInfoLayout fGn;
    public ThreadCommentAndPraiseInfoLayout fGo;
    private NEGFeedBackView fGz;
    public ThreadSourceShareAndPraiseLayout fHa;
    private com.baidu.tieba.play.j fbN;
    private n fbO;
    private com.baidu.afd.videopaster.d gDJ;
    private View gDK;
    public ThreadGodReplyLayout gDL;
    private HeadPendantClickableView gDM;
    private com.baidu.tieba.play.a.a gDN;
    private LinearLayout gDO;
    private com.baidu.tieba.card.data.l gDP;
    private int gDQ;
    private boolean gDR;
    private boolean gDS;
    private boolean gDT;
    private TextView gDU;
    private boolean gDV;
    private TextView gDW;
    private Handler gDX;
    private VideoLoadingProgressView.a gDY;
    private CustomMessageListener gDZ;
    private final View.OnClickListener gEa;
    private final View.OnClickListener gEb;
    private CustomMessageListener gEc;
    private j.a gEd;
    private Animation.AnimationListener gEe;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bKX() {
        if (this.gDN != null && this.gDR) {
            try {
                this.gDN.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int KA = com.baidu.tieba.play.x.cRo().KA(this.mVideoUrl);
            if (KA <= 100 || this.gDN.getDuration() <= KA) {
                KA = 100;
            }
            this.Ys = KA;
            this.gDX.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKY() {
        if (this.gDP != null && this.gDP.dEA != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.gDP.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.ais = this.gDP.dEA.getTid();
            yVar.evm = this.gDP.dEA.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.gDP.dEA.mRecomSource;
            yVar.kAp = this.gDP.dEA.mRecomAbTag;
            yVar.kAl = this.gDP.dEA.mRecomAbTag;
            yVar.kAm = this.gDP.dEA.mRecomWeight;
            yVar.kAn = "";
            yVar.dCp = this.gDP.getExtra();
            if (this.gDP.dEA.aQQ() != null) {
                yVar.kAq = this.gDP.dEA.aQQ().video_md5;
            }
            com.baidu.tieba.play.l.a(this.gDP.dEA.aQQ().video_md5, "", "1", yVar);
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fGz = null;
        this.mSkinType = 3;
        this.gDQ = 0;
        this.eBi = 1;
        this.gDR = false;
        this.gDS = true;
        this.gDT = false;
        this.Ys = 100;
        this.gDV = false;
        this.isNewPlayer = false;
        this.gDX = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.bLc();
                        return;
                    case 203:
                        l.this.bLd();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (l.this.gDN != null) {
                    l.this.gDN.setVolume(0.0f, 0.0f);
                }
                l.this.bKX();
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    l.this.t(false, 3);
                }
                return false;
            }
        };
        this.eKl = new g.a() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!l.this.gDJ.a(false, false, "NEWINDEX")) {
                    l.this.gDN.start();
                }
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                l.this.t(true, 4);
                l.this.gDR = false;
                return true;
            }
        };
        this.gDY = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.bKX();
            }
        };
        this.eBj = new TbImageView.a() { // from class: com.baidu.tieba.card.l.20
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.eBb != null) {
                    l.this.eBb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eBm = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.gDN != null && !l.this.gDN.isPlaying()) {
                    l.this.t(true, 1);
                }
            }
        };
        this.eBn = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.t(true, 4);
            }
        };
        this.gDZ = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.gDP != null && l.this.gDP.dEA != null && videoId.equals(l.this.gDP.dEA.getId())) {
                        l.this.gDJ.a(l.this.a(l.this.gDP, bVar));
                    }
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.card.l.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.gEa = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gDP == null) {
                    if (l.this.bKS() != null) {
                        l.this.bKS().a(view, l.this.gDP);
                        return;
                    }
                    return;
                }
                if (view == l.this.fGn.getUserName()) {
                    l.this.gDP.objType = 3;
                } else if (view == l.this.fGn.getHeaderImg()) {
                    l.this.gDP.objType = 4;
                } else {
                    l.this.gDP.objType = 1;
                }
                if (l.this.bKS() != null) {
                    l.this.bKS().a(view, l.this.gDP);
                }
            }
        };
        this.gEb = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gDP != null) {
                    l.this.gDP.objType = 4;
                }
                if (l.this.bKS() != null) {
                    l.this.bKS().a(view, l.this.gDP);
                }
            }
        };
        this.gEc = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.gDT = false;
                }
            }
        };
        this.dWy = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gDP != null) {
                    if (l.this.bKS() != null) {
                        l.this.bKS().a(view, l.this.gDP);
                    }
                    if (l.this.gDP.dEA != null && view != l.this.fHa.dWI) {
                        m.Dn(l.this.gDP.dEA.getId());
                        if (!l.this.bLb()) {
                            m.a(l.this.mTextTitle, l.this.gDP.dEA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            m.a(l.this.gDL.getGodReplyContent(), l.this.gDP.aOi().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.gEd = new j.a() { // from class: com.baidu.tieba.card.l.13
            @Override // com.baidu.tieba.play.j.a
            public void qg() {
                if (l.this.gDP != null && l.this.gDP.dEA != null && l.this.gDP.dEA.aQQ() != null) {
                    l.this.bKY();
                }
            }
        };
        this.gEe = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.eBb != null) {
                    l.this.eBb.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dIF = tbPageContext;
        View view = getView();
        this.fGm = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gDM = (HeadPendantClickableView) this.fGm.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gDM.getHeadView() != null) {
            this.gDM.getHeadView().setIsRound(true);
            this.gDM.getHeadView().setDrawBorder(false);
            this.gDM.getHeadView().setDefaultResource(17170445);
            this.gDM.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDM.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.ds70));
            this.gDM.getHeadView().setPlaceHolder(1);
        }
        this.gDM.setHasPendantStyle();
        if (this.gDM.getPendantView() != null) {
            this.gDM.getPendantView().setIsRound(true);
            this.gDM.getPendantView().setDrawBorder(false);
        }
        this.eBf = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eBf.setLoadingAnimationListener(this.gDY);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fGn = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fGz = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.fGz.a(this.fGm, dimens, 0);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fGo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGo.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGo.setLayoutParams(layoutParams);
        }
        this.fGo.setOnClickListener(this);
        this.fGo.setReplyTimeVisible(false);
        this.fGo.setShowPraiseNum(true);
        this.fGo.setNeedAddPraiseIcon(true);
        this.fGo.setNeedAddReplyIcon(true);
        this.fGo.setShareVisible(true);
        this.fGo.setShareReportFrom(3);
        this.fGo.setForumAfterClickListener(this.dWy);
        this.fGo.setFrom(1);
        this.fHa = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fHa.dXt.setOnClickListener(this);
        this.fHa.setFrom(1);
        this.fHa.setShareReportFrom(3);
        this.fHa.setForumAfterClickListener(this.dWy);
        this.gDK = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eAZ = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAZ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dIF.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.eAZ.setLayoutParams(layoutParams2);
        this.eBb = (TbImageView) view.findViewById(R.id.image_video);
        this.eBb.setDefaultErrorResource(0);
        this.eBb.setPlaceHolder(3);
        this.eBb.setGifIconSupport(false);
        this.eBb.setEvent(this.eBj);
        this.eBb.setRadius(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.eBb;
        TbImageView tbImageView2 = this.eBb;
        tbImageView.setConrers(15);
        this.eBb.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eBb.setBorderColor(am.getColor(R.color.cp_border_a));
        this.eBb.setBorderSurroundContent(true);
        this.eBb.setDrawBorder(true);
        this.eBc = (ImageView) view.findViewById(R.id.image_video_play);
        this.fGm.setOnClickListener(this);
        this.fbO = new n(this.dIF.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
        this.gDN = com.baidu.tieba.play.a.b.A(this.dIF.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.eAZ.addView(this.gDN.getView(), 0);
        this.gDN.getView().setLayoutParams(layoutParams3);
        this.gDN.setContinuePlayEnable(true);
        this.gDN.setBusiness(this.fbO);
        this.gDN.setOnPreparedListener(this.eKm);
        this.gDN.setOnOutInfoListener(this.eKo);
        this.gDN.setOnCompletionListener(this.eKl);
        this.gDN.setOnErrorListener(this.eBk);
        this.gDN.setOnSurfaceDestroyedListener(this.eBo);
        this.fbN = new com.baidu.tieba.play.j();
        this.fbN.setPlayer(this.gDN);
        this.fbN.a(this.gEd);
        this.eBa = (TextView) view.findViewById(R.id.text_video_duration);
        this.gDO = (LinearLayout) view.findViewById(R.id.duration_container);
        this.eBh = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eBg = view.findViewById(R.id.auto_video_black_mask);
        this.eBd = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eBe = view.findViewById(R.id.auto_video_error_background);
        this.eTB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.boX = AnimationUtils.loadAnimation(this.dIF.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.boX.setAnimationListener(this.gEe);
        this.gDL = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gDL.setOnClickListener(this);
        this.eLg = view.findViewById(R.id.divider_line);
        this.gDU = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.gDN.getView().setOnClickListener(this);
        this.gDW = (TextView) view.findViewById(R.id.nani_video_icon);
        this.gDJ = new com.baidu.afd.videopaster.d(getContext(), this.eAZ);
        this.gDJ.a(new d.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.afd.videopaster.d.a
            public void pV() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pU() {
                if (!l.this.gDV) {
                    l.this.gDN.start();
                } else {
                    l.this.startPlay();
                }
                l.this.gDV = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pT() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pW() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.gDP != null && this.gDP.dEA != null && this.gDP.dEA.dHk > 0) {
            if (bKS() != null) {
                bKS().a(view, this.gDP);
            }
            this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.dIF.getPageActivity(), this.gDP.dEA.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.aQj(), this.gDP.aOl())));
            return;
        }
        if (view == this.fGm || view == this.gDL) {
            bL(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.gDN.getView()) {
            if (this.gDP != null) {
                this.gDP.objType = 5;
            }
            if (this.gDP != null && this.gDP.dEA != null && this.gDP.dEA.aQQ() != null) {
                z = this.gDP.dEA.aQQ().is_vertical.intValue() == 1;
            }
            if (z) {
                bJ(this.gDN.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bK(this.gDN.getView());
                } else {
                    bL(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bK(this.gDN.getView());
            } else {
                bL(getView());
            }
        }
    }

    private void bJ(View view) {
        if (bKS() != null) {
            bKS().a(view, this.gDP);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bKZ();
        }
    }

    private void bK(View view) {
        if (bKS() != null) {
            bKS().a(view, this.gDP);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bLa();
        }
    }

    private void bKZ() {
        if (this.gDP != null && this.gDP.dEA != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.gDP.dEA);
            videoItemData.mRecomExtra = this.gDP.getExtra();
            videoItemData.mRecomAbTag = this.gDP.bLA();
            videoItemData.mRecomSource = this.gDP.getSource();
            videoItemData.mRecomWeight = this.gDP.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.gDP.aOl(), "index");
            if (this.gDP.dEA.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.gDP.dEA.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bLa() {
        if (this.gDP != null && this.gDP.dEA != null && this.gDP.dEA.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.gDP.dEA);
            videoSerializeVideoThreadInfo.source = this.gDP.getSource();
            videoSerializeVideoThreadInfo.extra = this.gDP.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.gDP.bLA();
            videoSerializeVideoThreadInfo.weight = this.gDP.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.eTB.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.eTB.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.dIF.getPageActivity(), str, this.gDP.dEA.getTid(), m.aQj(), this.gDP.aOl(), videoSerializeVideoThreadInfo);
            if (this.gDP.aOi() != null && this.gDP.aOi().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.gDP.aOi().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bL(View view) {
        if (this.gDP != null) {
            this.gDP.objType = 1;
        }
        if (bKS() != null) {
            bKS().a(view, this.gDP);
        }
        if (this.gDP != null && this.gDP.dEA != null) {
            if (!bLb()) {
                m.Dn(this.gDP.dEA.getId());
                m.a(this.mTextTitle, this.gDP.dEA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dIF.getPageActivity()).createFromThreadCfg(this.gDP.dEA, null, m.aQj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.gDP.aOl());
            addLocateParam.setVideo_source(this.gDP.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.gDP.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.gDP.dEA.getFid()));
            addLocateParam.setForumName(this.gDP.dEA.aQC());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.gDL) {
                addLocateParam.setJumpGodReply(true);
            }
            this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLb() {
        return this.gDP.gHI && !this.gDP.gHN;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.gDP = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLc() {
        this.gDX.removeMessages(202);
        if (this.gDN.getCurrentPosition() > this.Ys) {
            t(false, 3);
            this.gDX.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gDX.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLd() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gDX.removeMessages(203);
        int currentPosition = this.gDN.getCurrentPosition();
        if (currentPosition != this.gDQ) {
            this.gDQ = currentPosition;
            t(false, 3);
        } else {
            t(false, 2);
        }
        this.gDX.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, int i) {
        if (this.eBc != null && this.eBb != null && this.eBg != null && this.eBf != null && this.eBe != null && this.eBd != null) {
            if (z || this.eBi != i) {
                this.eBi = i;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBn);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBm);
                if (i == 2) {
                    this.eBc.setVisibility(8);
                    this.boX.cancel();
                    this.eBb.clearAnimation();
                    this.eBb.setVisibility(0);
                    this.eBg.setVisibility(0);
                    this.gDO.setVisibility(0);
                    this.gDU.setVisibility(8);
                    this.eBf.startLoading();
                    this.eBe.setVisibility(8);
                    this.eBd.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBn, 60000L);
                } else if (i == 3) {
                    this.eBc.setVisibility(8);
                    this.eBb.startAnimation(this.boX);
                    this.eBg.setVisibility(8);
                    this.gDO.setVisibility(8);
                    if (this.gDP != null && this.gDP.aOi() != null && this.gDP.aOi().dHk > 0) {
                        this.gDU.setVisibility(0);
                    }
                    this.eBf.cRk();
                    this.eBe.setVisibility(8);
                    this.eBd.setVisibility(8);
                    if (this.gDP != null && this.gDP.dEA != null && this.gDP.dEA.aQQ() != null) {
                        this.gDP.dEA.aQQ().video_length.intValue();
                        this.gDP.dEA.aQQ().video_duration.intValue();
                        this.gDP.dEA.getTid();
                    }
                } else if (i == 4) {
                    this.eBc.setVisibility(8);
                    this.eBb.startAnimation(this.boX);
                    this.eBg.setVisibility(8);
                    this.eBf.cRl();
                    this.eBe.setVisibility(0);
                    this.eBd.setVisibility(0);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBm, 2000L);
                } else {
                    this.eBc.setVisibility(0);
                    this.boX.cancel();
                    this.eBb.clearAnimation();
                    this.eBb.setVisibility(0);
                    this.eBg.setVisibility(0);
                    this.gDO.setVisibility(0);
                    this.eBf.cRl();
                    this.eBe.setVisibility(8);
                    this.eBd.setVisibility(8);
                }
                if (this.gDP != null && this.gDP.aOi() != null && this.gDP.aOi().dHk > 0) {
                    this.gDO.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.gDP == null || this.gDP.dEA == null || this.gDP.dEA.aQx() == null) {
            this.fGm.setVisibility(8);
            return;
        }
        this.fGm.setVisibility(0);
        bLf();
        if (!bLb() && m.Do(this.gDP.dEA.getId())) {
            m.a(this.mTextTitle, this.gDP.dEA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.gDL.getGodReplyContent(), this.gDP.aOi().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.gDP.aOi().aRw();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gDP.aOi().aRi());
        if (this.gDP.aOi().aRo() && !StringUtils.isNull(this.gDP.aOi().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.gDP.aOi().getTid();
            spannableStringBuilder.append((CharSequence) this.gDP.aOi().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.21
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").dh("obj_source", "0"));
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
        this.fGn.setData(this.gDP.aOi());
        this.fGn.setUserAfterClickListener(this.gEa);
        if (this.fGn.getHeaderImg() != null) {
            this.fGn.getHeaderImg().setAfterClickListener(this.gEb);
            if (this.fGn.getIsSimpleThread()) {
                this.fGn.getHeaderImg().setVisibility(8);
                this.gDM.setVisibility(8);
            } else if (this.gDP.aOi() == null || this.gDP.aOi().aQx() == null || this.gDP.aOi().aQx().getPendantData() == null || StringUtils.isNull(this.gDP.aOi().aQx().getPendantData().aOP())) {
                this.gDM.setVisibility(8);
                this.fGn.getHeaderImg().setVisibility(0);
                if (this.gDP.aOi().dHk > 0 && this.gDP.aOi().dHl == 0) {
                    this.gDP.aOi().aQx().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.fGn.getHeaderImg().setData(this.gDP.aOi(), false);
                } else {
                    this.fGn.getHeaderImg().setData(this.gDP.aOi());
                    this.fGn.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.fGn.getHeaderImg().setVisibility(4);
                this.gDM.setVisibility(0);
                this.gDM.setData(this.gDP.aOi());
            }
        }
        this.eBa.setText(aq.stringForVideoTime(this.gDP.dEA.aQQ().video_duration.intValue() * 1000));
        this.eBh.setText(String.format(this.dIF.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.gDP.dEA.aQQ().play_count.intValue())));
        if (this.fGz != null && this.gDP.aOi() != null) {
            ak akVar = new ak();
            akVar.setTid(this.gDP.aOi().getTid());
            akVar.setFid(this.gDP.aOi().getFid());
            akVar.setNid(this.gDP.aOi().getNid());
            akVar.setFeedBackReasonMap(this.gDP.feedBackReasonMap);
            this.fGz.setData(akVar);
            this.fGz.setFirstRowSingleColumn(true);
            this.fGz.setVisibility(this.gDS ? 0 : 8);
        }
        this.gDL.setData(this.gDP.aOi().aSb());
        qy(oY(1));
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        if (m.Do(this.gDP.dEA.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.gDP == null || this.gDP.dEA == null || this.gDP.dEA.aQQ() == null) {
            z = false;
        } else {
            z = this.gDP.dEA.aQQ().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gDW.setVisibility(0);
            if (bLg()) {
                this.gDW.setText(String.format("%s | %s", this.dIF.getResources().getString(R.string.nani_video), this.dIF.getResources().getString(R.string.video_preview)));
            } else {
                this.gDW.setText(this.dIF.getString(R.string.nani_video));
            }
        } else if (bLg()) {
            this.gDW.setVisibility(0);
            this.gDW.setText(this.dIF.getString(R.string.video_preview));
        } else {
            this.gDW.setVisibility(8);
        }
    }

    private void bLe() {
        this.gDX.removeMessages(202);
        this.gDX.removeMessages(203);
    }

    private void bia() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBm);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBn);
    }

    private void bLf() {
        bia();
        bLe();
        if (this.eBb != null && this.eAZ != null && this.gDN != null) {
            if (com.baidu.tbadk.core.k.aNQ().isShowImages() && this.gDP != null && this.gDP.dEA != null && this.gDP.dEA.aQQ() != null) {
                this.eBb.setPlaceHolder(3);
                this.eBb.startLoad(this.gDP.dEA.aQQ().thumbnail_url, 10, false);
                this.eAZ.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.gDP.dEA.aQQ().video_url;
                if (bLg()) {
                    this.mVideoUrl = this.gDP.dEA.aQR().video_url;
                }
                if (StringUtils.isNull(this.gDP.dEA.aQQ().video_url)) {
                    t(true, 4);
                }
                if (this.fbO != null && this.fbO.cQV() != null) {
                    this.fbO.cQV().an(this.gDP.dEA);
                }
            } else {
                this.eAZ.setVisibility(8);
            }
            this.gDJ.reset();
            this.fbN.a(new j.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.gDJ.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.gDP);
                    }
                }
            });
            this.fbO.a(new j.b() { // from class: com.baidu.tieba.card.l.5
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.gDJ.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.gDP);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.dEA != null) {
            bk bkVar = lVar.dEA;
            if (bkVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bkVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.dEA == null || bVar == null) {
            return null;
        }
        bk bkVar = lVar.dEA;
        int qa = bVar.qa();
        int qb = bVar.qb();
        int pZ = bVar.pZ();
        if (pZ != -1) {
            i = qa != -1 ? (pZ - qa) - 1 : -1;
            if (qb != -1) {
                i4 = (qb - pZ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aQQ = bkVar.aQQ();
        if (aQQ != null) {
            i3 = aQQ.video_width.intValue();
            i2 = aQQ.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bkVar.getId());
        hashMap.put("video_title", bkVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bkVar.getFid()));
        hashMap.put("forum_name", bkVar.aQC());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pZ + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGm, R.drawable.addresslist_item_bg);
            am.setImageResource(this.eBc, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.eBd, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBa, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBh, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.gDU, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eBe, R.color.common_color_10014);
            am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c);
            if (this.gDW != null) {
                am.setViewTextColor(this.gDW, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gDW, R.drawable.video_play_count_bg);
            }
            if (this.eBd != null) {
                this.eBd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.gDL.onChangeSkinType();
            if (this.fGz != null) {
                this.fGz.onChangeSkinType();
            }
            this.fGn.onChangeSkinType();
            this.fGo.onChangeSkinType();
            this.fHa.onChangeSkinType();
            this.eBb.setPlaceHolder(3);
            this.gDM.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gEc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gEc);
            this.gDZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gDZ);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fGn != null) {
            this.fGn.setPageUniqueId(bdUniqueId);
        }
        if (this.eBb != null) {
            this.eBb.setPageId(bdUniqueId);
        }
        if (this.fGz != null) {
            this.fGz.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.gDR;
    }

    public boolean isPlaying() {
        if (this.gDN == null) {
            return false;
        }
        return this.gDN.isPlaying();
    }

    public void startPlay() {
        if (!this.gDR && this.gDP != null && this.gDP.dEA != null && this.gDP.dEA.aQQ() != null && this.gDN != null) {
            if (this.gDJ.pE()) {
                this.gDJ.resume();
                this.gDV = true;
                return;
            }
            this.gDV = false;
            this.gDN.stopPlayback();
            if (ag.ar(1, this.mVideoUrl)) {
                t(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").dh("obj_locate", "index").dh("tid", this.gDP.tid));
                    this.mVideoUrl = this.gDP.dEA.aQQ().video_url;
                }
                this.gDR = true;
                this.gDN.setVideoPath(this.mVideoUrl, this.gDP.tid);
                if (this.fbN != null) {
                    this.fbN.start();
                }
                bKY();
            }
        }
    }

    public void stopPlay() {
        this.gDV = false;
        bia();
        bLe();
        t(true, 1);
        if (this.gDN != null) {
            this.gDN.stopPlayback();
            if (this.fbN != null) {
                this.fbN.stop();
            }
        }
        this.gDR = false;
        this.gDJ.stop();
    }

    public View getVideoContainer() {
        return this.eAZ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.gDN == null) {
            return 0;
        }
        return this.gDN.getCurrentPosition();
    }

    public void lM(boolean z) {
        this.gDS = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void qy(int i) {
        if (this.gDP != null && this.gDP.dEA != null) {
            if (i == 1) {
                if (this.gDP.dEA.dHk > 0) {
                    this.fHa.dXt.setShowPraiseNum(false);
                    this.fHa.dXt.setShareVisible(false);
                    this.gDU.setText(aq.numFormatOverWan(this.gDP.dEA.dHk));
                    this.gDU.setVisibility(0);
                } else {
                    this.fHa.dXt.setShowPraiseNum(true);
                    this.fHa.dXt.setShareVisible(true);
                    this.gDU.setVisibility(8);
                }
                this.fHa.setData(this.gDP.dEA);
                this.fGo.setVisibility(8);
                this.fGn.hq(false);
                return;
            }
            this.fHa.setVisibility(8);
            this.fGn.hq(true);
            if (this.gDP.dEA.dHk > 0) {
                this.fGo.setShowPraiseNum(false);
                this.fGo.setShareVisible(false);
                this.gDU.setText(aq.numFormatOverWan(this.gDP.dEA.dHk));
                this.gDU.setVisibility(0);
            } else {
                this.fGo.setShowPraiseNum(true);
                this.fGo.setShareVisible(true);
                this.gDU.setVisibility(8);
            }
            if (this.fGo.setData(this.gDP.dEA)) {
                this.gDK.setVisibility(8);
            } else {
                this.gDK.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int oY(int i) {
        return com.baidu.tieba.a.d.blZ().as(this.aeX, i);
    }

    private boolean bLg() {
        return (this.gDP == null || this.gDP.dEA == null || this.gDP.dEA.aQR() == null || TextUtils.isEmpty(this.gDP.dEA.aQR().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.gDJ.onDestroy();
    }
}
