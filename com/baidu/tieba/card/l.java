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
    public FrameLayout eBk;
    private TextView eBl;
    private TbImageView eBm;
    private ImageView eBn;
    private TextView eBo;
    private View eBp;
    private com.baidu.tieba.play.w eBq;
    private View eBr;
    private TextView eBs;
    private int eBt;
    private TbImageView.a eBu;
    private g.b eBv;
    private Runnable eBx;
    private Runnable eBy;
    private QuickVideoView.b eBz;
    private g.a eKw;
    private g.f eKx;
    private g.e eKz;
    private View eLr;
    protected LinearLayout eTM;
    private NEGFeedBackView fGK;
    private RelativeLayout fGx;
    public ThreadUserInfoLayout fGy;
    public ThreadCommentAndPraiseInfoLayout fGz;
    public ThreadSourceShareAndPraiseLayout fHl;
    private com.baidu.tieba.play.j fbY;
    private n fbZ;
    private com.baidu.afd.videopaster.d gDU;
    private View gDV;
    public ThreadGodReplyLayout gDW;
    private HeadPendantClickableView gDX;
    private com.baidu.tieba.play.a.a gDY;
    private LinearLayout gDZ;
    private com.baidu.tieba.card.data.l gEa;
    private int gEb;
    private boolean gEc;
    private boolean gEd;
    private boolean gEe;
    private TextView gEf;
    private boolean gEg;
    private TextView gEh;
    private Handler gEi;
    private VideoLoadingProgressView.a gEj;
    private CustomMessageListener gEk;
    private final View.OnClickListener gEl;
    private final View.OnClickListener gEm;
    private CustomMessageListener gEn;
    private j.a gEo;
    private Animation.AnimationListener gEp;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bKZ() {
        if (this.gDY != null && this.gEc) {
            try {
                this.gDY.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int KB = com.baidu.tieba.play.x.cRE().KB(this.mVideoUrl);
            if (KB <= 100 || this.gDY.getDuration() <= KB) {
                KB = 100;
            }
            this.Ys = KB;
            this.gEi.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLa() {
        if (this.gEa != null && this.gEa.dEA != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.gEa.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.ais = this.gEa.dEA.getTid();
            yVar.evm = this.gEa.dEA.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.gEa.dEA.mRecomSource;
            yVar.kBv = this.gEa.dEA.mRecomAbTag;
            yVar.kBr = this.gEa.dEA.mRecomAbTag;
            yVar.kBs = this.gEa.dEA.mRecomWeight;
            yVar.kBt = "";
            yVar.dCp = this.gEa.getExtra();
            if (this.gEa.dEA.aQQ() != null) {
                yVar.kBw = this.gEa.dEA.aQQ().video_md5;
            }
            com.baidu.tieba.play.l.a(this.gEa.dEA.aQQ().video_md5, "", "1", yVar, this.gDY.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fGK = null;
        this.mSkinType = 3;
        this.gEb = 0;
        this.eBt = 1;
        this.gEc = false;
        this.gEd = true;
        this.gEe = false;
        this.Ys = 100;
        this.gEg = false;
        this.isNewPlayer = false;
        this.gEi = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.bLe();
                        return;
                    case 203:
                        l.this.bLf();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (l.this.gDY != null) {
                    l.this.gDY.setVolume(0.0f, 0.0f);
                }
                l.this.bKZ();
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    l.this.t(false, 3);
                }
                return false;
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!l.this.gDU.a(false, false, "NEWINDEX")) {
                    l.this.gDY.start();
                }
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                l.this.t(true, 4);
                l.this.gEc = false;
                return true;
            }
        };
        this.gEj = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.bKZ();
            }
        };
        this.eBu = new TbImageView.a() { // from class: com.baidu.tieba.card.l.20
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.eBm != null) {
                    l.this.eBm.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eBx = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.gDY != null && !l.this.gDY.isPlaying()) {
                    l.this.t(true, 1);
                }
            }
        };
        this.eBy = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.t(true, 4);
            }
        };
        this.gEk = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.gEa != null && l.this.gEa.dEA != null && videoId.equals(l.this.gEa.dEA.getId())) {
                        l.this.gDU.a(l.this.a(l.this.gEa, bVar));
                    }
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.card.l.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.gEl = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gEa == null) {
                    if (l.this.bKU() != null) {
                        l.this.bKU().a(view, l.this.gEa);
                        return;
                    }
                    return;
                }
                if (view == l.this.fGy.getUserName()) {
                    l.this.gEa.objType = 3;
                } else if (view == l.this.fGy.getHeaderImg()) {
                    l.this.gEa.objType = 4;
                } else {
                    l.this.gEa.objType = 1;
                }
                if (l.this.bKU() != null) {
                    l.this.bKU().a(view, l.this.gEa);
                }
            }
        };
        this.gEm = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gEa != null) {
                    l.this.gEa.objType = 4;
                }
                if (l.this.bKU() != null) {
                    l.this.bKU().a(view, l.this.gEa);
                }
            }
        };
        this.gEn = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.gEe = false;
                }
            }
        };
        this.dWy = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gEa != null) {
                    if (l.this.bKU() != null) {
                        l.this.bKU().a(view, l.this.gEa);
                    }
                    if (l.this.gEa.dEA != null && view != l.this.fHl.dWI) {
                        m.Dn(l.this.gEa.dEA.getId());
                        if (!l.this.bLd()) {
                            m.a(l.this.mTextTitle, l.this.gEa.dEA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            m.a(l.this.gDW.getGodReplyContent(), l.this.gEa.aOi().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.gEo = new j.a() { // from class: com.baidu.tieba.card.l.13
            @Override // com.baidu.tieba.play.j.a
            public void qg() {
                if (l.this.gEa != null && l.this.gEa.dEA != null && l.this.gEa.dEA.aQQ() != null) {
                    l.this.bLa();
                }
            }
        };
        this.gEp = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.eBm != null) {
                    l.this.eBm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dIF = tbPageContext;
        View view = getView();
        this.fGx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gDX = (HeadPendantClickableView) this.fGx.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gDX.getHeadView() != null) {
            this.gDX.getHeadView().setIsRound(true);
            this.gDX.getHeadView().setDrawBorder(false);
            this.gDX.getHeadView().setDefaultResource(17170445);
            this.gDX.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDX.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.ds70));
            this.gDX.getHeadView().setPlaceHolder(1);
        }
        this.gDX.setHasPendantStyle();
        if (this.gDX.getPendantView() != null) {
            this.gDX.getPendantView().setIsRound(true);
            this.gDX.getPendantView().setDrawBorder(false);
        }
        this.eBq = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eBq.setLoadingAnimationListener(this.gEj);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fGy = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fGK = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.fGK.a(this.fGx, dimens, 0);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fGz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGz.setLayoutParams(layoutParams);
        }
        this.fGz.setOnClickListener(this);
        this.fGz.setReplyTimeVisible(false);
        this.fGz.setShowPraiseNum(true);
        this.fGz.setNeedAddPraiseIcon(true);
        this.fGz.setNeedAddReplyIcon(true);
        this.fGz.setShareVisible(true);
        this.fGz.setShareReportFrom(3);
        this.fGz.setForumAfterClickListener(this.dWy);
        this.fGz.setFrom(1);
        this.fHl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fHl.dXt.setOnClickListener(this);
        this.fHl.setFrom(1);
        this.fHl.setShareReportFrom(3);
        this.fHl.setForumAfterClickListener(this.dWy);
        this.gDV = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eBk = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eBk.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dIF.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.eBk.setLayoutParams(layoutParams2);
        this.eBm = (TbImageView) view.findViewById(R.id.image_video);
        this.eBm.setDefaultErrorResource(0);
        this.eBm.setPlaceHolder(3);
        this.eBm.setGifIconSupport(false);
        this.eBm.setEvent(this.eBu);
        this.eBm.setRadius(com.baidu.adp.lib.util.l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.eBm;
        TbImageView tbImageView2 = this.eBm;
        tbImageView.setConrers(15);
        this.eBm.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eBm.setBorderColor(am.getColor(R.color.cp_border_a));
        this.eBm.setBorderSurroundContent(true);
        this.eBm.setDrawBorder(true);
        this.eBn = (ImageView) view.findViewById(R.id.image_video_play);
        this.fGx.setOnClickListener(this);
        this.fbZ = new n(this.dIF.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
        this.gDY = com.baidu.tieba.play.a.b.A(this.dIF.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.eBk.addView(this.gDY.getView(), 0);
        this.gDY.getView().setLayoutParams(layoutParams3);
        this.gDY.setContinuePlayEnable(true);
        this.gDY.setBusiness(this.fbZ);
        this.gDY.setOnPreparedListener(this.eKx);
        this.gDY.setOnOutInfoListener(this.eKz);
        this.gDY.setOnCompletionListener(this.eKw);
        this.gDY.setOnErrorListener(this.eBv);
        this.gDY.setOnSurfaceDestroyedListener(this.eBz);
        this.fbY = new com.baidu.tieba.play.j();
        this.fbY.setPlayer(this.gDY);
        this.fbY.a(this.gEo);
        this.eBl = (TextView) view.findViewById(R.id.text_video_duration);
        this.gDZ = (LinearLayout) view.findViewById(R.id.duration_container);
        this.eBs = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eBr = view.findViewById(R.id.auto_video_black_mask);
        this.eBo = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eBp = view.findViewById(R.id.auto_video_error_background);
        this.eTM = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.boX = AnimationUtils.loadAnimation(this.dIF.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.boX.setAnimationListener(this.gEp);
        this.gDW = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gDW.setOnClickListener(this);
        this.eLr = view.findViewById(R.id.divider_line);
        this.gEf = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.gDY.getView().setOnClickListener(this);
        this.gEh = (TextView) view.findViewById(R.id.nani_video_icon);
        this.gDU = new com.baidu.afd.videopaster.d(getContext(), this.eBk);
        this.gDU.a(new d.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.afd.videopaster.d.a
            public void pV() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pU() {
                if (!l.this.gEg) {
                    l.this.gDY.start();
                } else {
                    l.this.startPlay();
                }
                l.this.gEg = false;
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
        if (this.gEa != null && this.gEa.dEA != null && this.gEa.dEA.dHk > 0) {
            if (bKU() != null) {
                bKU().a(view, this.gEa);
            }
            this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.dIF.getPageActivity(), this.gEa.dEA.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.aQj(), this.gEa.aOl())));
            return;
        }
        if (view == this.fGx || view == this.gDW) {
            bL(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.gDY.getView()) {
            if (this.gEa != null) {
                this.gEa.objType = 5;
            }
            if (this.gEa != null && this.gEa.dEA != null && this.gEa.dEA.aQQ() != null) {
                z = this.gEa.dEA.aQQ().is_vertical.intValue() == 1;
            }
            if (z) {
                bJ(this.gDY.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bK(this.gDY.getView());
                } else {
                    bL(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bK(this.gDY.getView());
            } else {
                bL(getView());
            }
        }
    }

    private void bJ(View view) {
        if (bKU() != null) {
            bKU().a(view, this.gEa);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bLb();
        }
    }

    private void bK(View view) {
        if (bKU() != null) {
            bKU().a(view, this.gEa);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bLc();
        }
    }

    private void bLb() {
        if (this.gEa != null && this.gEa.dEA != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.gEa.dEA);
            videoItemData.mRecomExtra = this.gEa.getExtra();
            videoItemData.mRecomAbTag = this.gEa.bLC();
            videoItemData.mRecomSource = this.gEa.getSource();
            videoItemData.mRecomWeight = this.gEa.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.gEa.aOl(), "index");
            if (this.gEa.dEA.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.gEa.dEA.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bLc() {
        if (this.gEa != null && this.gEa.dEA != null && this.gEa.dEA.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.gEa.dEA);
            videoSerializeVideoThreadInfo.source = this.gEa.getSource();
            videoSerializeVideoThreadInfo.extra = this.gEa.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.gEa.bLC();
            videoSerializeVideoThreadInfo.weight = this.gEa.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.eTM.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.eTM.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.dIF.getPageActivity(), str, this.gEa.dEA.getTid(), m.aQj(), this.gEa.aOl(), videoSerializeVideoThreadInfo);
            if (this.gEa.aOi() != null && this.gEa.aOi().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.gEa.aOi().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bL(View view) {
        if (this.gEa != null) {
            this.gEa.objType = 1;
        }
        if (bKU() != null) {
            bKU().a(view, this.gEa);
        }
        if (this.gEa != null && this.gEa.dEA != null) {
            if (!bLd()) {
                m.Dn(this.gEa.dEA.getId());
                m.a(this.mTextTitle, this.gEa.dEA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dIF.getPageActivity()).createFromThreadCfg(this.gEa.dEA, null, m.aQj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.gEa.aOl());
            addLocateParam.setVideo_source(this.gEa.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.gEa.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.gEa.dEA.getFid()));
            addLocateParam.setForumName(this.gEa.dEA.aQC());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.gDW) {
                addLocateParam.setJumpGodReply(true);
            }
            this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLd() {
        return this.gEa.gHT && !this.gEa.gHY;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.gEa = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLe() {
        this.gEi.removeMessages(202);
        if (this.gDY.getCurrentPosition() > this.Ys) {
            t(false, 3);
            this.gEi.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gEi.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLf() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gEi.removeMessages(203);
        int currentPosition = this.gDY.getCurrentPosition();
        if (currentPosition != this.gEb) {
            this.gEb = currentPosition;
            t(false, 3);
        } else {
            t(false, 2);
        }
        this.gEi.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, int i) {
        if (this.eBn != null && this.eBm != null && this.eBr != null && this.eBq != null && this.eBp != null && this.eBo != null) {
            if (z || this.eBt != i) {
                this.eBt = i;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBy);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBx);
                if (i == 2) {
                    this.eBn.setVisibility(8);
                    this.boX.cancel();
                    this.eBm.clearAnimation();
                    this.eBm.setVisibility(0);
                    this.eBr.setVisibility(0);
                    this.gDZ.setVisibility(0);
                    this.gEf.setVisibility(8);
                    this.eBq.startLoading();
                    this.eBp.setVisibility(8);
                    this.eBo.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBy, 60000L);
                } else if (i == 3) {
                    this.eBn.setVisibility(8);
                    this.eBm.startAnimation(this.boX);
                    this.eBr.setVisibility(8);
                    this.gDZ.setVisibility(8);
                    if (this.gEa != null && this.gEa.aOi() != null && this.gEa.aOi().dHk > 0) {
                        this.gEf.setVisibility(0);
                    }
                    this.eBq.cRA();
                    this.eBp.setVisibility(8);
                    this.eBo.setVisibility(8);
                    if (this.gEa != null && this.gEa.dEA != null && this.gEa.dEA.aQQ() != null) {
                        this.gEa.dEA.aQQ().video_length.intValue();
                        this.gEa.dEA.aQQ().video_duration.intValue();
                        this.gEa.dEA.getTid();
                    }
                } else if (i == 4) {
                    this.eBn.setVisibility(8);
                    this.eBm.startAnimation(this.boX);
                    this.eBr.setVisibility(8);
                    this.eBq.cRB();
                    this.eBp.setVisibility(0);
                    this.eBo.setVisibility(0);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBx, 2000L);
                } else {
                    this.eBn.setVisibility(0);
                    this.boX.cancel();
                    this.eBm.clearAnimation();
                    this.eBm.setVisibility(0);
                    this.eBr.setVisibility(0);
                    this.gDZ.setVisibility(0);
                    this.eBq.cRB();
                    this.eBp.setVisibility(8);
                    this.eBo.setVisibility(8);
                }
                if (this.gEa != null && this.gEa.aOi() != null && this.gEa.aOi().dHk > 0) {
                    this.gDZ.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.gEa == null || this.gEa.dEA == null || this.gEa.dEA.aQx() == null) {
            this.fGx.setVisibility(8);
            return;
        }
        this.fGx.setVisibility(0);
        bLh();
        if (!bLd() && m.Do(this.gEa.dEA.getId())) {
            m.a(this.mTextTitle, this.gEa.dEA.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.gDW.getGodReplyContent(), this.gEa.aOi().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.gEa.aOi().aRw();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gEa.aOi().aRi());
        if (this.gEa.aOi().aRo() && !StringUtils.isNull(this.gEa.aOi().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.gEa.aOi().getTid();
            spannableStringBuilder.append((CharSequence) this.gEa.aOi().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.21
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
        this.fGy.setData(this.gEa.aOi());
        this.fGy.setUserAfterClickListener(this.gEl);
        if (this.fGy.getHeaderImg() != null) {
            this.fGy.getHeaderImg().setAfterClickListener(this.gEm);
            if (this.fGy.getIsSimpleThread()) {
                this.fGy.getHeaderImg().setVisibility(8);
                this.gDX.setVisibility(8);
            } else if (this.gEa.aOi() == null || this.gEa.aOi().aQx() == null || this.gEa.aOi().aQx().getPendantData() == null || StringUtils.isNull(this.gEa.aOi().aQx().getPendantData().aOP())) {
                this.gDX.setVisibility(8);
                this.fGy.getHeaderImg().setVisibility(0);
                if (this.gEa.aOi().dHk > 0 && this.gEa.aOi().dHl == 0) {
                    this.gEa.aOi().aQx().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.fGy.getHeaderImg().setData(this.gEa.aOi(), false);
                } else {
                    this.fGy.getHeaderImg().setData(this.gEa.aOi());
                    this.fGy.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.fGy.getHeaderImg().setVisibility(4);
                this.gDX.setVisibility(0);
                this.gDX.setData(this.gEa.aOi());
            }
        }
        this.eBl.setText(aq.stringForVideoTime(this.gEa.dEA.aQQ().video_duration.intValue() * 1000));
        this.eBs.setText(String.format(this.dIF.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.gEa.dEA.aQQ().play_count.intValue())));
        if (this.fGK != null && this.gEa.aOi() != null) {
            ak akVar = new ak();
            akVar.setTid(this.gEa.aOi().getTid());
            akVar.setFid(this.gEa.aOi().getFid());
            akVar.setNid(this.gEa.aOi().getNid());
            akVar.setFeedBackReasonMap(this.gEa.feedBackReasonMap);
            this.fGK.setData(akVar);
            this.fGK.setFirstRowSingleColumn(true);
            this.fGK.setVisibility(this.gEd ? 0 : 8);
        }
        this.gDW.setData(this.gEa.aOi().aSb());
        qA(pa(1));
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        if (m.Do(this.gEa.dEA.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.gEa == null || this.gEa.dEA == null || this.gEa.dEA.aQQ() == null) {
            z = false;
        } else {
            z = this.gEa.dEA.aQQ().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gEh.setVisibility(0);
            if (bLi()) {
                this.gEh.setText(String.format("%s | %s", this.dIF.getResources().getString(R.string.nani_video), this.dIF.getResources().getString(R.string.video_preview)));
            } else {
                this.gEh.setText(this.dIF.getString(R.string.nani_video));
            }
        } else if (bLi()) {
            this.gEh.setVisibility(0);
            this.gEh.setText(this.dIF.getString(R.string.video_preview));
        } else {
            this.gEh.setVisibility(8);
        }
    }

    private void bLg() {
        this.gEi.removeMessages(202);
        this.gEi.removeMessages(203);
    }

    private void bic() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBx);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBy);
    }

    private void bLh() {
        bic();
        bLg();
        if (this.eBm != null && this.eBk != null && this.gDY != null) {
            if (com.baidu.tbadk.core.k.aNQ().isShowImages() && this.gEa != null && this.gEa.dEA != null && this.gEa.dEA.aQQ() != null) {
                this.eBm.setPlaceHolder(3);
                this.eBm.startLoad(this.gEa.dEA.aQQ().thumbnail_url, 10, false);
                this.eBk.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.gEa.dEA.aQQ().video_url;
                if (bLi()) {
                    this.mVideoUrl = this.gEa.dEA.aQR().video_url;
                }
                if (StringUtils.isNull(this.gEa.dEA.aQQ().video_url)) {
                    t(true, 4);
                }
                if (this.fbZ != null && this.fbZ.cRl() != null) {
                    this.fbZ.cRl().an(this.gEa.dEA);
                }
            } else {
                this.eBk.setVisibility(8);
            }
            this.gDU.reset();
            this.fbY.a(new j.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.gDU.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.gEa);
                    }
                }
            });
            this.fbZ.a(new j.b() { // from class: com.baidu.tieba.card.l.5
                @Override // com.baidu.tieba.play.j.b
                public void bI(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.gDU.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.gEa);
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
            am.setBackgroundResource(this.fGx, R.drawable.addresslist_item_bg);
            am.setImageResource(this.eBn, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.eBo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBl, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBs, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.gEf, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eBp, R.color.common_color_10014);
            am.setBackgroundColor(this.eLr, R.color.cp_bg_line_c);
            if (this.gEh != null) {
                am.setViewTextColor(this.gEh, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gEh, R.drawable.video_play_count_bg);
            }
            if (this.eBo != null) {
                this.eBo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.gDW.onChangeSkinType();
            if (this.fGK != null) {
                this.fGK.onChangeSkinType();
            }
            this.fGy.onChangeSkinType();
            this.fGz.onChangeSkinType();
            this.fHl.onChangeSkinType();
            this.eBm.setPlaceHolder(3);
            this.gDX.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gEn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gEn);
            this.gEk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gEk);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fGy != null) {
            this.fGy.setPageUniqueId(bdUniqueId);
        }
        if (this.eBm != null) {
            this.eBm.setPageId(bdUniqueId);
        }
        if (this.fGK != null) {
            this.fGK.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.gEc;
    }

    public boolean isPlaying() {
        if (this.gDY == null) {
            return false;
        }
        return this.gDY.isPlaying();
    }

    public void startPlay() {
        if (!this.gEc && this.gEa != null && this.gEa.dEA != null && this.gEa.dEA.aQQ() != null && this.gDY != null) {
            if (this.gDU.pE()) {
                this.gDU.resume();
                this.gEg = true;
                return;
            }
            this.gEg = false;
            this.gDY.stopPlayback();
            if (ag.ar(1, this.mVideoUrl)) {
                t(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").dh("obj_locate", "index").dh("tid", this.gEa.tid));
                    this.mVideoUrl = this.gEa.dEA.aQQ().video_url;
                }
                this.gEc = true;
                this.gDY.setVideoPath(this.mVideoUrl, this.gEa.tid);
                if (this.fbY != null) {
                    this.fbY.start();
                }
                bLa();
            }
        }
    }

    public void stopPlay() {
        this.gEg = false;
        bic();
        bLg();
        t(true, 1);
        if (this.gDY != null) {
            this.gDY.stopPlayback();
            if (this.fbY != null) {
                this.fbY.stop();
            }
        }
        this.gEc = false;
        this.gDU.stop();
    }

    public View getVideoContainer() {
        return this.eBk;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.gDY == null) {
            return 0;
        }
        return this.gDY.getCurrentPosition();
    }

    public void lM(boolean z) {
        this.gEd = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void qA(int i) {
        if (this.gEa != null && this.gEa.dEA != null) {
            if (i == 1) {
                if (this.gEa.dEA.dHk > 0) {
                    this.fHl.dXt.setShowPraiseNum(false);
                    this.fHl.dXt.setShareVisible(false);
                    this.gEf.setText(aq.numFormatOverWan(this.gEa.dEA.dHk));
                    this.gEf.setVisibility(0);
                } else {
                    this.fHl.dXt.setShowPraiseNum(true);
                    this.fHl.dXt.setShareVisible(true);
                    this.gEf.setVisibility(8);
                }
                this.fHl.setData(this.gEa.dEA);
                this.fGz.setVisibility(8);
                this.fGy.hq(false);
                return;
            }
            this.fHl.setVisibility(8);
            this.fGy.hq(true);
            if (this.gEa.dEA.dHk > 0) {
                this.fGz.setShowPraiseNum(false);
                this.fGz.setShareVisible(false);
                this.gEf.setText(aq.numFormatOverWan(this.gEa.dEA.dHk));
                this.gEf.setVisibility(0);
            } else {
                this.fGz.setShowPraiseNum(true);
                this.fGz.setShareVisible(true);
                this.gEf.setVisibility(8);
            }
            if (this.fGz.setData(this.gEa.dEA)) {
                this.gDV.setVisibility(8);
            } else {
                this.gDV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int pa(int i) {
        return com.baidu.tieba.a.d.bmb().as(this.aeX, i);
    }

    private boolean bLi() {
        return (this.gEa == null || this.gEa.dEA == null || this.gEa.dEA.aQR() == null || TextUtils.isEmpty(this.gEa.dEA.aQR().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.gDU.onDestroy();
    }
}
