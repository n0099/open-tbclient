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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.util.af;
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
/* loaded from: classes6.dex */
public class k extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private int Ep;
    private String Lg;
    private Animation aHs;
    private TbPageContext<?> cRe;
    private View caf;
    public FrameLayout dHP;
    private TextView dHQ;
    private TbImageView dHR;
    private ImageView dHS;
    private TextView dHT;
    private View dHU;
    private com.baidu.tieba.play.w dHV;
    private View dHW;
    private TextView dHX;
    private int dHY;
    private TbImageView.a dHZ;
    private g.b dIa;
    private Runnable dIc;
    private Runnable dId;
    private QuickVideoView.b dIe;
    private g.a dQW;
    private g.f dQX;
    private g.e dQZ;
    private final View.OnClickListener ddE;
    private NEGFeedBackView eJD;
    private RelativeLayout eJp;
    public ThreadUserInfoLayout eJq;
    public ThreadCommentAndPraiseInfoLayout eJr;
    public ThreadSourceShareAndPraiseLayout eKe;
    protected LinearLayout ecC;
    private com.baidu.tieba.play.j egT;
    private com.baidu.tieba.play.n egU;
    private View fGJ;
    private com.baidu.afd.videopaster.d fGO;
    public ThreadGodReplyLayout fGP;
    private HeadPendantClickableView fGQ;
    private com.baidu.tieba.play.a.a fGR;
    private LinearLayout fGS;
    private com.baidu.tieba.card.data.l fGT;
    private int fGU;
    private boolean fGV;
    private boolean fGW;
    private boolean fGX;
    private TextView fGY;
    private boolean fGZ;
    private TextView fHa;
    private Handler fHb;
    private VideoLoadingProgressView.a fHc;
    private CustomMessageListener fHd;
    private final View.OnClickListener fHe;
    private final View.OnClickListener fHf;
    private CustomMessageListener fHg;
    private j.a fHh;
    private Animation.AnimationListener fHi;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bth() {
        if (this.fGR != null && this.fGV) {
            try {
                this.fGR.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int GP = com.baidu.tieba.play.x.cxW().GP(this.mVideoUrl);
            if (GP <= 100 || this.fGR.getDuration() <= GP) {
                GP = 100;
            }
            this.Ep = GP;
            this.fHb.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        if (this.fGT != null && this.fGT.cNb != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.fGT.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.OG = this.fGT.cNb.getTid();
            yVar.fKa = this.fGT.cNb.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.fGT.cNb.mRecomSource;
            yVar.mAbTag = this.fGT.cNb.mRecomAbTag;
            yVar.jvO = this.fGT.cNb.mRecomAbTag;
            yVar.jvP = this.fGT.cNb.mRecomWeight;
            yVar.jvQ = "";
            yVar.cKN = this.fGT.getExtra();
            if (this.fGT.cNb.aAo() != null) {
                yVar.jvS = this.fGT.cNb.aAo().video_md5;
            }
            com.baidu.tieba.play.l.a(this.fGT.cNb.aAo().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eJD = null;
        this.mSkinType = 3;
        this.fGU = 0;
        this.dHY = 1;
        this.fGV = false;
        this.fGW = true;
        this.fGX = false;
        this.Ep = 100;
        this.fGZ = false;
        this.isNewPlayer = false;
        this.fHb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.btm();
                        return;
                    case 203:
                        k.this.btn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.fGR != null) {
                    k.this.fGR.setVolume(0.0f, 0.0f);
                }
                k.this.bth();
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.o(false, 3);
                }
                return false;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.fGO.a(false, false, "NEWINDEX")) {
                    k.this.fGR.start();
                }
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.o(true, 4);
                k.this.fGV = false;
                return true;
            }
        };
        this.fHc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.bth();
            }
        };
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.dHR != null) {
                    k.this.dHR.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dIc = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.fGR != null && !k.this.fGR.isPlaying()) {
                    k.this.o(true, 1);
                }
            }
        };
        this.dId = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.o(true, 4);
            }
        };
        this.fHd = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.fGT != null && k.this.fGT.cNb != null && videoId.equals(k.this.fGT.cNb.getId())) {
                        k.this.fGO.a(k.this.a(k.this.fGT, bVar));
                    }
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.fHe = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fGT == null) {
                    if (k.this.bta() != null) {
                        k.this.bta().a(view, k.this.fGT);
                        return;
                    }
                    return;
                }
                if (view == k.this.eJq.getUserName()) {
                    k.this.fGT.objType = 3;
                } else if (view == k.this.eJq.getHeaderImg()) {
                    k.this.fGT.objType = 4;
                } else {
                    k.this.fGT.objType = 1;
                }
                if (k.this.bta() != null) {
                    k.this.bta().a(view, k.this.fGT);
                }
            }
        };
        this.fHf = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fGT != null) {
                    k.this.fGT.objType = 4;
                }
                if (k.this.bta() != null) {
                    k.this.bta().a(view, k.this.fGT);
                }
            }
        };
        this.fHg = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.fGX = false;
                }
            }
        };
        this.ddE = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fGT != null) {
                    if (k.this.bta() != null) {
                        k.this.bta().a(view, k.this.fGT);
                    }
                    if (k.this.fGT.cNb != null && view != k.this.eKe.ddO) {
                        l.zC(k.this.fGT.cNb.getId());
                        if (!k.this.btl()) {
                            l.a(k.this.mTextTitle, k.this.fGT.cNb.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.fGP.getGodReplyContent(), k.this.fGT.axQ().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.fHh = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void lh() {
                if (k.this.fGT != null && k.this.fGT.cNb != null && k.this.fGT.cNb.aAo() != null) {
                    k.this.bti();
                }
            }
        };
        this.fHi = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.dHR != null) {
                    k.this.dHR.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.cRe = tbPageContext;
        View view = getView();
        this.eJp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fGQ = (HeadPendantClickableView) this.eJp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fGQ.getHeadView() != null) {
            this.fGQ.getHeadView().setIsRound(true);
            this.fGQ.getHeadView().setDrawBorder(false);
            this.fGQ.getHeadView().setDefaultResource(17170445);
            this.fGQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fGQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.ds70));
            this.fGQ.getHeadView().setPlaceHolder(1);
        }
        this.fGQ.setHasPendantStyle();
        if (this.fGQ.getPendantView() != null) {
            this.fGQ.getPendantView().setIsRound(true);
            this.fGQ.getPendantView().setDrawBorder(false);
        }
        this.dHV = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dHV.setLoadingAnimationListener(this.fHc);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eJq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eJD = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.eJD.a(this.eJp, dimens, 0);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eJr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eJr.setLayoutParams(layoutParams);
        }
        this.eJr.setOnClickListener(this);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setShareVisible(true);
        this.eJr.setShareReportFrom(3);
        this.eJr.setForumAfterClickListener(this.ddE);
        this.eJr.setFrom(1);
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eKe.deA.setOnClickListener(this);
        this.eKe.setFrom(1);
        this.eKe.setShareReportFrom(3);
        this.eKe.setForumAfterClickListener(this.ddE);
        this.fGJ = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dHP = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dHP.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cRe.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dHP.setLayoutParams(layoutParams2);
        this.dHR = (TbImageView) view.findViewById(R.id.image_video);
        this.dHR.setDefaultErrorResource(0);
        this.dHR.setPlaceHolder(3);
        this.dHR.setGifIconSupport(false);
        this.dHR.setEvent(this.dHZ);
        this.dHR.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dHR;
        TbImageView tbImageView2 = this.dHR;
        tbImageView.setConrers(15);
        this.dHR.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dHR.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dHR.setBorderSurroundContent(true);
        this.dHR.setDrawBorder(true);
        this.dHS = (ImageView) view.findViewById(R.id.image_video_play);
        this.eJp.setOnClickListener(this);
        this.egU = new com.baidu.tieba.play.n(this.cRe.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.rs("cyber_player_test");
        this.fGR = com.baidu.tieba.play.a.b.F(this.cRe.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.dHP.addView(this.fGR.getView(), 0);
        this.fGR.getView().setLayoutParams(layoutParams3);
        this.fGR.setContinuePlayEnable(true);
        this.fGR.setBusiness(this.egU);
        this.fGR.setOnPreparedListener(this.dQX);
        this.fGR.setOnOutInfoListener(this.dQZ);
        this.fGR.setOnCompletionListener(this.dQW);
        this.fGR.setOnErrorListener(this.dIa);
        this.fGR.setOnSurfaceDestroyedListener(this.dIe);
        this.egT = new com.baidu.tieba.play.j();
        this.egT.setPlayer(this.fGR);
        this.egT.a(this.fHh);
        this.dHQ = (TextView) view.findViewById(R.id.text_video_duration);
        this.fGS = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dHX = (TextView) view.findViewById(R.id.text_video_play_count);
        this.dHW = view.findViewById(R.id.auto_video_black_mask);
        this.dHT = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dHU = view.findViewById(R.id.auto_video_error_background);
        this.ecC = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.aHs = AnimationUtils.loadAnimation(this.cRe.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.aHs.setAnimationListener(this.fHi);
        this.fGP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fGP.setOnClickListener(this);
        this.caf = view.findViewById(R.id.divider_line);
        this.fGY = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.fGR.getView().setOnClickListener(this);
        this.fHa = (TextView) view.findViewById(R.id.nani_video_icon);
        this.fGR.setPageTypeForPerfStat("homepage");
        this.fGO = new com.baidu.afd.videopaster.d(getContext(), this.dHP);
        this.fGO.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void kW() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kV() {
                if (!k.this.fGZ) {
                    k.this.fGR.start();
                } else {
                    k.this.startPlay();
                }
                k.this.fGZ = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kU() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean kX() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.cPL > 0) {
            if (bta() != null) {
                bta().a(view, this.fGT);
            }
            this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.cRe.getPageActivity(), this.fGT.cNb.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.azJ(), this.fGT.axT())));
            return;
        }
        if (view == this.eJp || view == this.fGP) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.fGR.getView()) {
            if (this.fGT != null) {
                this.fGT.objType = 5;
            }
            if (this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.aAo() != null) {
                z = this.fGT.cNb.aAo().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(this.fGR.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bG(this.fGR.getView());
                } else {
                    bH(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bG(this.fGR.getView());
            } else {
                bH(getView());
            }
        }
    }

    private void bF(View view) {
        if (bta() != null) {
            bta().a(view, this.fGT);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cRe.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            btj();
        }
    }

    private void bG(View view) {
        if (bta() != null) {
            bta().a(view, this.fGT);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cRe.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            btk();
        }
    }

    private void btj() {
        if (this.fGT != null && this.fGT.cNb != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fGT.cNb);
            videoItemData.mRecomExtra = this.fGT.getExtra();
            videoItemData.mRecomAbTag = this.fGT.btL();
            videoItemData.mRecomSource = this.fGT.getSource();
            videoItemData.mRecomWeight = this.fGT.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.fGT.axT(), "index");
            if (this.fGT.cNb.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fGT.cNb.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void btk() {
        if (this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fGT.cNb);
            videoSerializeVideoThreadInfo.source = this.fGT.getSource();
            videoSerializeVideoThreadInfo.extra = this.fGT.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.fGT.btL();
            videoSerializeVideoThreadInfo.weight = this.fGT.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.ecC.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.ecC.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cRe.getPageActivity(), str, this.fGT.cNb.getTid(), l.azJ(), this.fGT.axT(), videoSerializeVideoThreadInfo);
            if (this.fGT.axQ() != null && this.fGT.axQ().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fGT.axQ().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bH(View view) {
        if (this.fGT != null) {
            this.fGT.objType = 1;
        }
        if (bta() != null) {
            bta().a(view, this.fGT);
        }
        if (this.fGT != null && this.fGT.cNb != null) {
            if (!btl()) {
                l.zC(this.fGT.cNb.getId());
                l.a(this.mTextTitle, this.fGT.cNb.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cRe.getPageActivity()).createFromThreadCfg(this.fGT.cNb, null, l.azJ(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fGT.axT());
            addLocateParam.setVideo_source(this.fGT.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.fGT.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.fGT.cNb.getFid()));
            addLocateParam.setForumName(this.fGT.cNb.aAc());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fGP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btl() {
        return this.fGT.fKP && !this.fGT.fKW;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.fGT = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btm() {
        this.fHb.removeMessages(202);
        if (this.fGR.getCurrentPosition() > this.Ep) {
            o(false, 3);
            this.fHb.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fHb.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fHb.removeMessages(203);
        int currentPosition = this.fGR.getCurrentPosition();
        if (currentPosition != this.fGU) {
            this.fGU = currentPosition;
            o(false, 3);
        } else {
            o(false, 2);
        }
        this.fHb.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dHS != null && this.dHR != null && this.dHW != null && this.dHV != null && this.dHU != null && this.dHT != null) {
            if (z || this.dHY != i) {
                this.dHY = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dId);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dIc);
                if (i == 2) {
                    this.dHS.setVisibility(8);
                    this.aHs.cancel();
                    this.dHR.clearAnimation();
                    this.dHR.setVisibility(0);
                    this.dHW.setVisibility(0);
                    this.fGS.setVisibility(0);
                    this.fGY.setVisibility(8);
                    this.dHV.startLoading();
                    this.dHU.setVisibility(8);
                    this.dHT.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dId, 60000L);
                } else if (i == 3) {
                    this.dHS.setVisibility(8);
                    this.dHR.startAnimation(this.aHs);
                    this.dHW.setVisibility(8);
                    this.fGS.setVisibility(8);
                    if (this.fGT != null && this.fGT.axQ() != null && this.fGT.axQ().cPL > 0) {
                        this.fGY.setVisibility(0);
                    }
                    this.dHV.cxS();
                    this.dHU.setVisibility(8);
                    this.dHT.setVisibility(8);
                    if (this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.aAo() != null) {
                        this.fGT.cNb.aAo().video_length.intValue();
                        this.fGT.cNb.aAo().video_duration.intValue();
                        this.fGT.cNb.getTid();
                    }
                } else if (i == 4) {
                    this.dHS.setVisibility(8);
                    this.dHR.startAnimation(this.aHs);
                    this.dHW.setVisibility(8);
                    this.dHV.cxT();
                    this.dHU.setVisibility(0);
                    this.dHT.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dIc, 2000L);
                } else {
                    this.dHS.setVisibility(0);
                    this.aHs.cancel();
                    this.dHR.clearAnimation();
                    this.dHR.setVisibility(0);
                    this.dHW.setVisibility(0);
                    this.fGS.setVisibility(0);
                    this.dHV.cxT();
                    this.dHU.setVisibility(8);
                    this.dHT.setVisibility(8);
                }
                if (this.fGT != null && this.fGT.axQ() != null && this.fGT.axQ().cPL > 0) {
                    this.fGS.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.fGT == null || this.fGT.cNb == null || this.fGT.cNb.azX() == null) {
            this.eJp.setVisibility(8);
            return;
        }
        this.eJp.setVisibility(0);
        btp();
        if (!btl() && l.zD(this.fGT.cNb.getId())) {
            l.a(this.mTextTitle, this.fGT.cNb.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.fGP.getGodReplyContent(), this.fGT.axQ().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fGT.axQ().aAT();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.fGT.axQ().aAE());
        if (this.fGT.axQ().aAK() && !StringUtils.isNull(this.fGT.axQ().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fGT.axQ().getTid();
            spannableStringBuilder.append((CharSequence) this.fGT.axQ().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cp("obj_source", "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.eJq.setData(this.fGT.axQ());
        this.eJq.setUserAfterClickListener(this.fHe);
        if (this.eJq.getHeaderImg() != null) {
            this.eJq.getHeaderImg().setAfterClickListener(this.fHf);
            if (this.eJq.getIsSimpleThread()) {
                this.eJq.getHeaderImg().setVisibility(8);
                this.fGQ.setVisibility(8);
            } else if (this.fGT.axQ() == null || this.fGT.axQ().azX() == null || this.fGT.axQ().azX().getPendantData() == null || StringUtils.isNull(this.fGT.axQ().azX().getPendantData().ayq())) {
                this.fGQ.setVisibility(8);
                this.eJq.getHeaderImg().setVisibility(0);
                if (this.fGT.axQ().cPL > 0 && this.fGT.axQ().cPM == 0) {
                    this.fGT.axQ().azX().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.eJq.getHeaderImg().setData(this.fGT.axQ(), false);
                } else {
                    this.eJq.getHeaderImg().setData(this.fGT.axQ());
                    this.eJq.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.eJq.getHeaderImg().setVisibility(4);
                this.fGQ.setVisibility(0);
                this.fGQ.setData(this.fGT.axQ());
            }
        }
        this.dHQ.setText(aq.stringForVideoTime(this.fGT.cNb.aAo().video_duration.intValue() * 1000));
        this.dHX.setText(String.format(this.cRe.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fGT.cNb.aAo().play_count.intValue())));
        if (this.eJD != null && this.fGT.axQ() != null) {
            al alVar = new al();
            alVar.setTid(this.fGT.axQ().getTid());
            alVar.setFid(this.fGT.axQ().getFid());
            alVar.setFeedBackReasonMap(this.fGT.feedBackReasonMap);
            this.eJD.setData(alVar);
            this.eJD.setFirstRowSingleColumn(true);
            this.eJD.setVisibility(this.fGW ? 0 : 8);
        }
        this.fGP.setData(this.fGT.axQ().aBx());
        pq(nL(1));
        onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
        if (l.zD(this.fGT.cNb.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.fGT == null || this.fGT.cNb == null || this.fGT.cNb.aAo() == null) {
            z = false;
        } else {
            z = this.fGT.cNb.aAo().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fHa.setVisibility(0);
            if (btq()) {
                this.fHa.setText(String.format("%s | %s", this.cRe.getResources().getString(R.string.nani_video), this.cRe.getResources().getString(R.string.video_preview)));
            } else {
                this.fHa.setText(this.cRe.getString(R.string.nani_video));
            }
        } else if (btq()) {
            this.fHa.setVisibility(0);
            this.fHa.setText(this.cRe.getString(R.string.video_preview));
        } else {
            this.fHa.setVisibility(8);
        }
    }

    private void bto() {
        this.fHb.removeMessages(202);
        this.fHb.removeMessages(203);
    }

    private void aRj() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dIc);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dId);
    }

    private void btp() {
        aRj();
        bto();
        if (this.dHR != null && this.dHP != null && this.fGR != null) {
            if (com.baidu.tbadk.core.i.axy().isShowImages() && this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.aAo() != null) {
                this.dHR.setPlaceHolder(3);
                this.dHR.startLoad(this.fGT.cNb.aAo().thumbnail_url, 10, false);
                this.dHP.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.fGT.cNb.aAo().video_url;
                if (btq()) {
                    this.mVideoUrl = this.fGT.cNb.aAp().video_url;
                }
                if (StringUtils.isNull(this.fGT.cNb.aAo().video_url)) {
                    o(true, 4);
                }
                if (this.egU != null && this.egU.cxD() != null) {
                    this.egU.cxD().ai(this.fGT.cNb);
                }
            } else {
                this.dHP.setVisibility(8);
            }
            this.fGO.reset();
            this.egT.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void bx(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fGO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fGT);
                    }
                }
            });
            this.egU.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void bx(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fGO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fGT);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cNb != null) {
            bj bjVar = lVar.cNb;
            if (bjVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bjVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.cNb == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.cNb;
        int lb = bVar.lb();
        int lc = bVar.lc();
        int la = bVar.la();
        if (la != -1) {
            i = lb != -1 ? (la - lb) - 1 : -1;
            if (lc != -1) {
                i4 = (lc - la) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aAo = bjVar.aAo();
        if (aAo != null) {
            i3 = aAo.video_width.intValue();
            i2 = aAo.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aAc());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", la + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eJp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHS, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dHT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHQ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHX, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fGY, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dHU, R.color.common_color_10014);
            am.setBackgroundColor(this.caf, R.color.cp_bg_line_c);
            if (this.fHa != null) {
                am.setViewTextColor(this.fHa, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fHa, R.drawable.video_play_count_bg);
            }
            if (this.dHT != null) {
                this.dHT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.fGP.onChangeSkinType();
            if (this.eJD != null) {
                this.eJD.onChangeSkinType();
            }
            this.eJq.onChangeSkinType();
            this.eJr.onChangeSkinType();
            this.eKe.onChangeSkinType();
            this.dHR.setPlaceHolder(3);
            this.fGQ.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fHg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fHg);
            this.fHd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fHd);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eJq != null) {
            this.eJq.setPageUniqueId(bdUniqueId);
        }
        if (this.dHR != null) {
            this.dHR.setPageId(bdUniqueId);
        }
        if (this.eJD != null) {
            this.eJD.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.fGV;
    }

    public boolean isPlaying() {
        if (this.fGR == null) {
            return false;
        }
        return this.fGR.isPlaying();
    }

    public void startPlay() {
        if (!this.fGV && this.fGT != null && this.fGT.cNb != null && this.fGT.cNb.aAo() != null && this.fGR != null) {
            if (this.fGO.kF()) {
                this.fGO.resume();
                this.fGZ = true;
                return;
            }
            this.fGZ = false;
            this.fGR.stopPlayback();
            if (af.W(1, this.mVideoUrl)) {
                o(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cp("obj_locate", "index").cp("tid", this.fGT.tid));
                    this.mVideoUrl = this.fGT.cNb.aAo().video_url;
                }
                this.fGV = true;
                this.fGR.setVideoPath(this.mVideoUrl, this.fGT.tid);
                if (this.egT != null) {
                    this.egT.start();
                }
                bti();
            }
        }
    }

    public void stopPlay() {
        this.fGZ = false;
        aRj();
        bto();
        o(true, 1);
        if (this.fGR != null) {
            this.fGR.stopPlayback();
            if (this.egT != null) {
                this.egT.stop();
            }
        }
        this.fGV = false;
        this.fGO.stop();
    }

    public View getVideoContainer() {
        return this.dHP;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.fGR == null) {
            return 0;
        }
        return this.fGR.getCurrentPosition();
    }

    public void kg(boolean z) {
        this.fGW = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pq(int i) {
        if (this.fGT != null && this.fGT.cNb != null) {
            if (i == 1) {
                if (this.fGT.cNb.cPL > 0) {
                    this.eKe.deA.setShowPraiseNum(false);
                    this.eKe.deA.setShareVisible(false);
                    this.fGY.setText(aq.numFormatOverWan(this.fGT.cNb.cPL));
                    this.fGY.setVisibility(0);
                } else {
                    this.eKe.deA.setShowPraiseNum(true);
                    this.eKe.deA.setShareVisible(true);
                    this.fGY.setVisibility(8);
                }
                this.eKe.setData(this.fGT.cNb);
                this.eJr.setVisibility(8);
                this.eJq.fK(false);
                return;
            }
            this.eKe.setVisibility(8);
            this.eJq.fK(true);
            if (this.fGT.cNb.cPL > 0) {
                this.eJr.setShowPraiseNum(false);
                this.eJr.setShareVisible(false);
                this.fGY.setText(aq.numFormatOverWan(this.fGT.cNb.cPL));
                this.fGY.setVisibility(0);
            } else {
                this.eJr.setShowPraiseNum(true);
                this.eJr.setShareVisible(true);
                this.fGY.setVisibility(8);
            }
            if (this.eJr.setData(this.fGT.cNb)) {
                this.fGJ.setVisibility(8);
            } else {
                this.fGJ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dHR.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dHR.setOnDrawListener(null);
        }
    }

    private boolean btq() {
        return (this.fGT == null || this.fGT.cNb == null || this.fGT.cNb.aAp() == null || TextUtils.isEmpty(this.fGT.cNb.aAp().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.fGO.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.fGO.stop();
    }

    public void onResume() {
        if (this.fGO.kF()) {
            this.fGO.resume();
        }
    }
}
