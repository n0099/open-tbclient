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
/* loaded from: classes8.dex */
public class k extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private int EJ;
    private String LC;
    private Animation aLN;
    private TbPageContext<?> cVv;
    private View cey;
    private TbImageView dMA;
    private ImageView dMB;
    private TextView dMC;
    private View dMD;
    private com.baidu.tieba.play.w dME;
    private View dMF;
    private TextView dMG;
    private int dMH;
    private TbImageView.a dMI;
    private g.b dMJ;
    private Runnable dML;
    private Runnable dMM;
    private QuickVideoView.b dMN;
    public FrameLayout dMy;
    private TextView dMz;
    private g.a dVF;
    private g.f dVG;
    private g.e dVI;
    private final View.OnClickListener dik;
    private RelativeLayout eNV;
    public ThreadUserInfoLayout eNW;
    public ThreadCommentAndPraiseInfoLayout eNX;
    public ThreadSourceShareAndPraiseLayout eOJ;
    private NEGFeedBackView eOi;
    protected LinearLayout ehj;
    private com.baidu.tieba.play.j elB;
    private com.baidu.tieba.play.n elC;
    private CustomMessageListener fKA;
    private j.a fKB;
    private Animation.AnimationListener fKC;
    private View fKd;
    private com.baidu.afd.videopaster.d fKi;
    public ThreadGodReplyLayout fKj;
    private HeadPendantClickableView fKk;
    private com.baidu.tieba.play.a.a fKl;
    private LinearLayout fKm;
    private com.baidu.tieba.card.data.l fKn;
    private int fKo;
    private boolean fKp;
    private boolean fKq;
    private boolean fKr;
    private TextView fKs;
    private boolean fKt;
    private TextView fKu;
    private Handler fKv;
    private VideoLoadingProgressView.a fKw;
    private CustomMessageListener fKx;
    private final View.OnClickListener fKy;
    private final View.OnClickListener fKz;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        if (this.fKl != null && this.fKp) {
            try {
                this.fKl.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Hd = com.baidu.tieba.play.x.czM().Hd(this.mVideoUrl);
            if (Hd <= 100 || this.fKl.getDuration() <= Hd) {
                Hd = 100;
            }
            this.EJ = Hd;
            this.fKv.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (this.fKn != null && this.fKn.cRt != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.fKn.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.Pk = this.fKn.cRt.getTid();
            yVar.emF = this.fKn.cRt.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.fKn.cRt.mRecomSource;
            yVar.mAbTag = this.fKn.cRt.mRecomAbTag;
            yVar.jyr = this.fKn.cRt.mRecomAbTag;
            yVar.jys = this.fKn.cRt.mRecomWeight;
            yVar.jyt = "";
            yVar.cPf = this.fKn.getExtra();
            if (this.fKn.cRt.aCI() != null) {
                yVar.jyv = this.fKn.cRt.aCI().video_md5;
            }
            com.baidu.tieba.play.l.a(this.fKn.cRt.aCI().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eOi = null;
        this.mSkinType = 3;
        this.fKo = 0;
        this.dMH = 1;
        this.fKp = false;
        this.fKq = true;
        this.fKr = false;
        this.EJ = 100;
        this.fKt = false;
        this.isNewPlayer = false;
        this.fKv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.buY();
                        return;
                    case 203:
                        k.this.buZ();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.fKl != null) {
                    k.this.fKl.setVolume(0.0f, 0.0f);
                }
                k.this.buT();
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.fKi.a(false, false, "NEWINDEX")) {
                    k.this.fKl.start();
                }
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.p(true, 4);
                k.this.fKp = false;
                return true;
            }
        };
        this.fKw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.buT();
            }
        };
        this.dMI = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.dMA != null) {
                    k.this.dMA.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dML = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.fKl != null && !k.this.fKl.isPlaying()) {
                    k.this.p(true, 1);
                }
            }
        };
        this.dMM = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.p(true, 4);
            }
        };
        this.fKx = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.fKn != null && k.this.fKn.cRt != null && videoId.equals(k.this.fKn.cRt.getId())) {
                        k.this.fKi.a(k.this.a(k.this.fKn, bVar));
                    }
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.fKy = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fKn == null) {
                    if (k.this.buM() != null) {
                        k.this.buM().a(view, k.this.fKn);
                        return;
                    }
                    return;
                }
                if (view == k.this.eNW.getUserName()) {
                    k.this.fKn.objType = 3;
                } else if (view == k.this.eNW.getHeaderImg()) {
                    k.this.fKn.objType = 4;
                } else {
                    k.this.fKn.objType = 1;
                }
                if (k.this.buM() != null) {
                    k.this.buM().a(view, k.this.fKn);
                }
            }
        };
        this.fKz = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fKn != null) {
                    k.this.fKn.objType = 4;
                }
                if (k.this.buM() != null) {
                    k.this.buM().a(view, k.this.fKn);
                }
            }
        };
        this.fKA = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.fKr = false;
                }
            }
        };
        this.dik = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fKn != null) {
                    if (k.this.buM() != null) {
                        k.this.buM().a(view, k.this.fKn);
                    }
                    if (k.this.fKn.cRt != null && view != k.this.eOJ.diw) {
                        l.zU(k.this.fKn.cRt.getId());
                        if (!k.this.buX()) {
                            l.a(k.this.mTextTitle, k.this.fKn.cRt.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.fKj.getGodReplyContent(), k.this.fKn.aAj().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.fKB = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                if (k.this.fKn != null && k.this.fKn.cRt != null && k.this.fKn.cRt.aCI() != null) {
                    k.this.buU();
                }
            }
        };
        this.fKC = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.dMA != null) {
                    k.this.dMA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.cVv = tbPageContext;
        View view = getView();
        this.eNV = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fKk = (HeadPendantClickableView) this.eNV.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fKk.getHeadView() != null) {
            this.fKk.getHeadView().setIsRound(true);
            this.fKk.getHeadView().setDrawBorder(false);
            this.fKk.getHeadView().setDefaultResource(17170445);
            this.fKk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fKk.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.ds70));
            this.fKk.getHeadView().setPlaceHolder(1);
        }
        this.fKk.setHasPendantStyle();
        if (this.fKk.getPendantView() != null) {
            this.fKk.getPendantView().setIsRound(true);
            this.fKk.getPendantView().setDrawBorder(false);
        }
        this.dME = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dME.setLoadingAnimationListener(this.fKw);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNW = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eOi = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.eOi.a(this.eNV, dimens, 0);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNX.setLayoutParams(layoutParams);
        }
        this.eNX.setOnClickListener(this);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setShareVisible(true);
        this.eNX.setShareReportFrom(3);
        this.eNX.setForumAfterClickListener(this.dik);
        this.eNX.setFrom(1);
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eOJ.djh.setOnClickListener(this);
        this.eOJ.setFrom(1);
        this.eOJ.setShareReportFrom(3);
        this.eOJ.setForumAfterClickListener(this.dik);
        this.fKd = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dMy = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dMy.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVv.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dMy.setLayoutParams(layoutParams2);
        this.dMA = (TbImageView) view.findViewById(R.id.image_video);
        this.dMA.setDefaultErrorResource(0);
        this.dMA.setPlaceHolder(3);
        this.dMA.setGifIconSupport(false);
        this.dMA.setEvent(this.dMI);
        this.dMA.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dMA;
        TbImageView tbImageView2 = this.dMA;
        tbImageView.setConrers(15);
        this.dMA.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dMA.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dMA.setBorderSurroundContent(true);
        this.dMA.setDrawBorder(true);
        this.dMB = (ImageView) view.findViewById(R.id.image_video_play);
        this.eNV.setOnClickListener(this);
        this.elC = new com.baidu.tieba.play.n(this.cVv.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.rG("cyber_player_test");
        this.fKl = com.baidu.tieba.play.a.b.F(this.cVv.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.dMy.addView(this.fKl.getView(), 0);
        this.fKl.getView().setLayoutParams(layoutParams3);
        this.fKl.setContinuePlayEnable(true);
        this.fKl.setBusiness(this.elC);
        this.fKl.setOnPreparedListener(this.dVG);
        this.fKl.setOnOutInfoListener(this.dVI);
        this.fKl.setOnCompletionListener(this.dVF);
        this.fKl.setOnErrorListener(this.dMJ);
        this.fKl.setOnSurfaceDestroyedListener(this.dMN);
        this.elB = new com.baidu.tieba.play.j();
        this.elB.setPlayer(this.fKl);
        this.elB.a(this.fKB);
        this.dMz = (TextView) view.findViewById(R.id.text_video_duration);
        this.fKm = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMG = (TextView) view.findViewById(R.id.text_video_play_count);
        this.dMF = view.findViewById(R.id.auto_video_black_mask);
        this.dMC = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dMD = view.findViewById(R.id.auto_video_error_background);
        this.ehj = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.aLN = AnimationUtils.loadAnimation(this.cVv.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.aLN.setAnimationListener(this.fKC);
        this.fKj = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fKj.setOnClickListener(this);
        this.cey = view.findViewById(R.id.divider_line);
        this.fKs = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.fKl.getView().setOnClickListener(this);
        this.fKu = (TextView) view.findViewById(R.id.nani_video_icon);
        this.fKi = new com.baidu.afd.videopaster.d(getContext(), this.dMy);
        this.fKi.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void ll() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lk() {
                if (!k.this.fKt) {
                    k.this.fKl.start();
                } else {
                    k.this.startPlay();
                }
                k.this.fKt = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lj() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean lm() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.cUc > 0) {
            if (buM() != null) {
                buM().a(view, this.fKn);
            }
            this.cVv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.cVv.getPageActivity(), this.fKn.cRt.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.aCd(), this.fKn.aAm())));
            return;
        }
        if (view == this.eNV || view == this.fKj) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.fKl.getView()) {
            if (this.fKn != null) {
                this.fKn.objType = 5;
            }
            if (this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.aCI() != null) {
                z = this.fKn.cRt.aCI().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(this.fKl.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bG(this.fKl.getView());
                } else {
                    bH(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bG(this.fKl.getView());
            } else {
                bH(getView());
            }
        }
    }

    private void bF(View view) {
        if (buM() != null) {
            buM().a(view, this.fKn);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buV();
        }
    }

    private void bG(View view) {
        if (buM() != null) {
            buM().a(view, this.fKn);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buW();
        }
    }

    private void buV() {
        if (this.fKn != null && this.fKn.cRt != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fKn.cRt);
            videoItemData.mRecomExtra = this.fKn.getExtra();
            videoItemData.mRecomAbTag = this.fKn.bvx();
            videoItemData.mRecomSource = this.fKn.getSource();
            videoItemData.mRecomWeight = this.fKn.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.fKn.aAm(), "index");
            if (this.fKn.cRt.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fKn.cRt.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buW() {
        if (this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fKn.cRt);
            videoSerializeVideoThreadInfo.source = this.fKn.getSource();
            videoSerializeVideoThreadInfo.extra = this.fKn.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.fKn.bvx();
            videoSerializeVideoThreadInfo.weight = this.fKn.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.ehj.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.ehj.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVv.getPageActivity(), str, this.fKn.cRt.getTid(), l.aCd(), this.fKn.aAm(), videoSerializeVideoThreadInfo);
            if (this.fKn.aAj() != null && this.fKn.aAj().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fKn.aAj().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bH(View view) {
        if (this.fKn != null) {
            this.fKn.objType = 1;
        }
        if (buM() != null) {
            buM().a(view, this.fKn);
        }
        if (this.fKn != null && this.fKn.cRt != null) {
            if (!buX()) {
                l.zU(this.fKn.cRt.getId());
                l.a(this.mTextTitle, this.fKn.cRt.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVv.getPageActivity()).createFromThreadCfg(this.fKn.cRt, null, l.aCd(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fKn.aAm());
            addLocateParam.setVideo_source(this.fKn.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.fKn.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.fKn.cRt.getFid()));
            addLocateParam.setForumName(this.fKn.cRt.aCw());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fKj) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buX() {
        return this.fKn.fOi && !this.fKn.fOp;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.fKn = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buY() {
        this.fKv.removeMessages(202);
        if (this.fKl.getCurrentPosition() > this.EJ) {
            p(false, 3);
            this.fKv.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fKv.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buZ() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fKv.removeMessages(203);
        int currentPosition = this.fKl.getCurrentPosition();
        if (currentPosition != this.fKo) {
            this.fKo = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fKv.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dMB != null && this.dMA != null && this.dMF != null && this.dME != null && this.dMD != null && this.dMC != null) {
            if (z || this.dMH != i) {
                this.dMH = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMM);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dML);
                if (i == 2) {
                    this.dMB.setVisibility(8);
                    this.aLN.cancel();
                    this.dMA.clearAnimation();
                    this.dMA.setVisibility(0);
                    this.dMF.setVisibility(0);
                    this.fKm.setVisibility(0);
                    this.fKs.setVisibility(8);
                    this.dME.startLoading();
                    this.dMD.setVisibility(8);
                    this.dMC.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMM, 60000L);
                } else if (i == 3) {
                    this.dMB.setVisibility(8);
                    this.dMA.startAnimation(this.aLN);
                    this.dMF.setVisibility(8);
                    this.fKm.setVisibility(8);
                    if (this.fKn != null && this.fKn.aAj() != null && this.fKn.aAj().cUc > 0) {
                        this.fKs.setVisibility(0);
                    }
                    this.dME.czI();
                    this.dMD.setVisibility(8);
                    this.dMC.setVisibility(8);
                    if (this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.aCI() != null) {
                        this.fKn.cRt.aCI().video_length.intValue();
                        this.fKn.cRt.aCI().video_duration.intValue();
                        this.fKn.cRt.getTid();
                    }
                } else if (i == 4) {
                    this.dMB.setVisibility(8);
                    this.dMA.startAnimation(this.aLN);
                    this.dMF.setVisibility(8);
                    this.dME.czJ();
                    this.dMD.setVisibility(0);
                    this.dMC.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dML, 2000L);
                } else {
                    this.dMB.setVisibility(0);
                    this.aLN.cancel();
                    this.dMA.clearAnimation();
                    this.dMA.setVisibility(0);
                    this.dMF.setVisibility(0);
                    this.fKm.setVisibility(0);
                    this.dME.czJ();
                    this.dMD.setVisibility(8);
                    this.dMC.setVisibility(8);
                }
                if (this.fKn != null && this.fKn.aAj() != null && this.fKn.aAj().cUc > 0) {
                    this.fKm.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.fKn == null || this.fKn.cRt == null || this.fKn.cRt.aCr() == null) {
            this.eNV.setVisibility(8);
            return;
        }
        this.eNV.setVisibility(0);
        bvb();
        if (!buX() && l.zV(this.fKn.cRt.getId())) {
            l.a(this.mTextTitle, this.fKn.cRt.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.fKj.getGodReplyContent(), this.fKn.aAj().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fKn.aAj().aDm();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.fKn.aAj().aCY());
        if (this.fKn.aAj().aDe() && !StringUtils.isNull(this.fKn.aAj().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fKn.aAj().getTid();
            spannableStringBuilder.append((CharSequence) this.fKn.aAj().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cx("obj_source", "0"));
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
        this.eNW.setData(this.fKn.aAj());
        this.eNW.setUserAfterClickListener(this.fKy);
        if (this.eNW.getHeaderImg() != null) {
            this.eNW.getHeaderImg().setAfterClickListener(this.fKz);
            if (this.eNW.getIsSimpleThread()) {
                this.eNW.getHeaderImg().setVisibility(8);
                this.fKk.setVisibility(8);
            } else if (this.fKn.aAj() == null || this.fKn.aAj().aCr() == null || this.fKn.aAj().aCr().getPendantData() == null || StringUtils.isNull(this.fKn.aAj().aCr().getPendantData().aAJ())) {
                this.fKk.setVisibility(8);
                this.eNW.getHeaderImg().setVisibility(0);
                if (this.fKn.aAj().cUc > 0 && this.fKn.aAj().cUd == 0) {
                    this.fKn.aAj().aCr().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.eNW.getHeaderImg().setData(this.fKn.aAj(), false);
                } else {
                    this.eNW.getHeaderImg().setData(this.fKn.aAj());
                    this.eNW.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.eNW.getHeaderImg().setVisibility(4);
                this.fKk.setVisibility(0);
                this.fKk.setData(this.fKn.aAj());
            }
        }
        this.dMz.setText(aq.stringForVideoTime(this.fKn.cRt.aCI().video_duration.intValue() * 1000));
        this.dMG.setText(String.format(this.cVv.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fKn.cRt.aCI().play_count.intValue())));
        if (this.eOi != null && this.fKn.aAj() != null) {
            al alVar = new al();
            alVar.setTid(this.fKn.aAj().getTid());
            alVar.setFid(this.fKn.aAj().getFid());
            alVar.setFeedBackReasonMap(this.fKn.feedBackReasonMap);
            this.eOi.setData(alVar);
            this.eOi.setFirstRowSingleColumn(true);
            this.eOi.setVisibility(this.fKq ? 0 : 8);
        }
        this.fKj.setData(this.fKn.aAj().aDQ());
        pD(oe(1));
        onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
        if (l.zV(this.fKn.cRt.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.fKn == null || this.fKn.cRt == null || this.fKn.cRt.aCI() == null) {
            z = false;
        } else {
            z = this.fKn.cRt.aCI().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fKu.setVisibility(0);
            if (bvc()) {
                this.fKu.setText(String.format("%s | %s", this.cVv.getResources().getString(R.string.nani_video), this.cVv.getResources().getString(R.string.video_preview)));
            } else {
                this.fKu.setText(this.cVv.getString(R.string.nani_video));
            }
        } else if (bvc()) {
            this.fKu.setVisibility(0);
            this.fKu.setText(this.cVv.getString(R.string.video_preview));
        } else {
            this.fKu.setVisibility(8);
        }
    }

    private void bva() {
        this.fKv.removeMessages(202);
        this.fKv.removeMessages(203);
    }

    private void aTH() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dML);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMM);
    }

    private void bvb() {
        aTH();
        bva();
        if (this.dMA != null && this.dMy != null && this.fKl != null) {
            if (com.baidu.tbadk.core.i.azR().isShowImages() && this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.aCI() != null) {
                this.dMA.setPlaceHolder(3);
                this.dMA.startLoad(this.fKn.cRt.aCI().thumbnail_url, 10, false);
                this.dMy.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.fKn.cRt.aCI().video_url;
                if (bvc()) {
                    this.mVideoUrl = this.fKn.cRt.aCJ().video_url;
                }
                if (StringUtils.isNull(this.fKn.cRt.aCI().video_url)) {
                    p(true, 4);
                }
                if (this.elC != null && this.elC.czt() != null) {
                    this.elC.czt().ak(this.fKn.cRt);
                }
            } else {
                this.dMy.setVisibility(8);
            }
            this.fKi.reset();
            this.elB.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void bz(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fKi.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fKn);
                    }
                }
            });
            this.elC.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void bz(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fKi.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fKn);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cRt != null) {
            bj bjVar = lVar.cRt;
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
        if (lVar == null || lVar.cRt == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.cRt;
        int lq = bVar.lq();
        int lr = bVar.lr();
        int lp = bVar.lp();
        if (lp != -1) {
            i = lq != -1 ? (lp - lq) - 1 : -1;
            if (lr != -1) {
                i4 = (lr - lp) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aCI = bjVar.aCI();
        if (aCI != null) {
            i3 = aCI.video_width.intValue();
            i2 = aCI.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aCw());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", lp + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNV, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMB, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dMC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMz, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fKs, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMD, R.color.common_color_10014);
            am.setBackgroundColor(this.cey, R.color.cp_bg_line_c);
            if (this.fKu != null) {
                am.setViewTextColor(this.fKu, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fKu, R.drawable.video_play_count_bg);
            }
            if (this.dMC != null) {
                this.dMC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.fKj.onChangeSkinType();
            if (this.eOi != null) {
                this.eOi.onChangeSkinType();
            }
            this.eNW.onChangeSkinType();
            this.eNX.onChangeSkinType();
            this.eOJ.onChangeSkinType();
            this.dMA.setPlaceHolder(3);
            this.fKk.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fKA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fKA);
            this.fKx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fKx);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eNW != null) {
            this.eNW.setPageUniqueId(bdUniqueId);
        }
        if (this.dMA != null) {
            this.dMA.setPageId(bdUniqueId);
        }
        if (this.eOi != null) {
            this.eOi.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.fKp;
    }

    public boolean isPlaying() {
        if (this.fKl == null) {
            return false;
        }
        return this.fKl.isPlaying();
    }

    public void startPlay() {
        if (!this.fKp && this.fKn != null && this.fKn.cRt != null && this.fKn.cRt.aCI() != null && this.fKl != null) {
            if (this.fKi.kU()) {
                this.fKi.resume();
                this.fKt = true;
                return;
            }
            this.fKt = false;
            this.fKl.stopPlayback();
            if (af.X(1, this.mVideoUrl)) {
                p(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cx("obj_locate", "index").cx("tid", this.fKn.tid));
                    this.mVideoUrl = this.fKn.cRt.aCI().video_url;
                }
                this.fKp = true;
                this.fKl.setVideoPath(this.mVideoUrl, this.fKn.tid);
                if (this.elB != null) {
                    this.elB.start();
                }
                buU();
            }
        }
    }

    public void stopPlay() {
        this.fKt = false;
        aTH();
        bva();
        p(true, 1);
        if (this.fKl != null) {
            this.fKl.stopPlayback();
            if (this.elB != null) {
                this.elB.stop();
            }
        }
        this.fKp = false;
        this.fKi.stop();
    }

    public View getVideoContainer() {
        return this.dMy;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.fKl == null) {
            return 0;
        }
        return this.fKl.getCurrentPosition();
    }

    public void kn(boolean z) {
        this.fKq = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pD(int i) {
        if (this.fKn != null && this.fKn.cRt != null) {
            if (i == 1) {
                if (this.fKn.cRt.cUc > 0) {
                    this.eOJ.djh.setShowPraiseNum(false);
                    this.eOJ.djh.setShareVisible(false);
                    this.fKs.setText(aq.numFormatOverWan(this.fKn.cRt.cUc));
                    this.fKs.setVisibility(0);
                } else {
                    this.eOJ.djh.setShowPraiseNum(true);
                    this.eOJ.djh.setShareVisible(true);
                    this.fKs.setVisibility(8);
                }
                this.eOJ.setData(this.fKn.cRt);
                this.eNX.setVisibility(8);
                this.eNW.fS(false);
                return;
            }
            this.eOJ.setVisibility(8);
            this.eNW.fS(true);
            if (this.fKn.cRt.cUc > 0) {
                this.eNX.setShowPraiseNum(false);
                this.eNX.setShareVisible(false);
                this.fKs.setText(aq.numFormatOverWan(this.fKn.cRt.cUc));
                this.fKs.setVisibility(0);
            } else {
                this.eNX.setShowPraiseNum(true);
                this.eNX.setShareVisible(true);
                this.fKs.setVisibility(8);
            }
            if (this.eNX.setData(this.fKn.cRt)) {
                this.fKd.setVisibility(8);
            } else {
                this.fKd.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dMA.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dMA.setOnDrawListener(null);
        }
    }

    private boolean bvc() {
        return (this.fKn == null || this.fKn.cRt == null || this.fKn.cRt.aCJ() == null || TextUtils.isEmpty(this.fKn.cRt.aCJ().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.fKi.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.fKi.stop();
    }

    public void onResume() {
        if (this.fKi.kU()) {
            this.fKi.resume();
        }
    }
}
