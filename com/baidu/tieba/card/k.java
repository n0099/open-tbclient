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
    private Animation aLz;
    private TbPageContext<?> cVi;
    private View cen;
    public FrameLayout dMi;
    private TextView dMj;
    private TbImageView dMk;
    private ImageView dMl;
    private TextView dMm;
    private View dMn;
    private com.baidu.tieba.play.w dMo;
    private View dMp;
    private TextView dMq;
    private int dMr;
    private TbImageView.a dMs;
    private g.b dMt;
    private Runnable dMv;
    private Runnable dMw;
    private QuickVideoView.b dMx;
    private g.a dVp;
    private g.f dVq;
    private g.e dVs;
    private final View.OnClickListener dhW;
    private NEGFeedBackView eNK;
    private RelativeLayout eNx;
    public ThreadUserInfoLayout eNy;
    public ThreadCommentAndPraiseInfoLayout eNz;
    public ThreadSourceShareAndPraiseLayout eOl;
    protected LinearLayout egT;
    private com.baidu.tieba.play.j ell;
    private com.baidu.tieba.play.n elm;
    private com.baidu.afd.videopaster.d fJA;
    public ThreadGodReplyLayout fJB;
    private HeadPendantClickableView fJC;
    private com.baidu.tieba.play.a.a fJD;
    private LinearLayout fJE;
    private com.baidu.tieba.card.data.l fJF;
    private int fJG;
    private boolean fJH;
    private boolean fJI;
    private boolean fJJ;
    private TextView fJK;
    private boolean fJL;
    private TextView fJM;
    private Handler fJN;
    private VideoLoadingProgressView.a fJO;
    private CustomMessageListener fJP;
    private final View.OnClickListener fJQ;
    private final View.OnClickListener fJR;
    private CustomMessageListener fJS;
    private j.a fJT;
    private Animation.AnimationListener fJU;
    private View fJv;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.fJD != null && this.fJH) {
            try {
                this.fJD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int He = com.baidu.tieba.play.x.czt().He(this.mVideoUrl);
            if (He <= 100 || this.fJD.getDuration() <= He) {
                He = 100;
            }
            this.EJ = He;
            this.fJN.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buP() {
        if (this.fJF != null && this.fJF.cRg != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.fJF.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.Pj = this.fJF.cRg.getTid();
            yVar.emo = this.fJF.cRg.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.fJF.cRg.mRecomSource;
            yVar.mAbTag = this.fJF.cRg.mRecomAbTag;
            yVar.jwS = this.fJF.cRg.mRecomAbTag;
            yVar.jwT = this.fJF.cRg.mRecomWeight;
            yVar.jwU = "";
            yVar.cOS = this.fJF.getExtra();
            if (this.fJF.cRg.aCF() != null) {
                yVar.jwW = this.fJF.cRg.aCF().video_md5;
            }
            com.baidu.tieba.play.l.a(this.fJF.cRg.aCF().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNK = null;
        this.mSkinType = 3;
        this.fJG = 0;
        this.dMr = 1;
        this.fJH = false;
        this.fJI = true;
        this.fJJ = false;
        this.EJ = 100;
        this.fJL = false;
        this.isNewPlayer = false;
        this.fJN = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.buT();
                        return;
                    case 203:
                        k.this.buU();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVq = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.fJD != null) {
                    k.this.fJD.setVolume(0.0f, 0.0f);
                }
                k.this.buO();
            }
        };
        this.dVs = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVp = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.fJA.a(false, false, "NEWINDEX")) {
                    k.this.fJD.start();
                }
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.p(true, 4);
                k.this.fJH = false;
                return true;
            }
        };
        this.fJO = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.buO();
            }
        };
        this.dMs = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.dMk != null) {
                    k.this.dMk.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMv = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.fJD != null && !k.this.fJD.isPlaying()) {
                    k.this.p(true, 1);
                }
            }
        };
        this.dMw = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.p(true, 4);
            }
        };
        this.fJP = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.fJF != null && k.this.fJF.cRg != null && videoId.equals(k.this.fJF.cRg.getId())) {
                        k.this.fJA.a(k.this.a(k.this.fJF, bVar));
                    }
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.fJQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJF == null) {
                    if (k.this.buH() != null) {
                        k.this.buH().a(view, k.this.fJF);
                        return;
                    }
                    return;
                }
                if (view == k.this.eNy.getUserName()) {
                    k.this.fJF.objType = 3;
                } else if (view == k.this.eNy.getHeaderImg()) {
                    k.this.fJF.objType = 4;
                } else {
                    k.this.fJF.objType = 1;
                }
                if (k.this.buH() != null) {
                    k.this.buH().a(view, k.this.fJF);
                }
            }
        };
        this.fJR = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJF != null) {
                    k.this.fJF.objType = 4;
                }
                if (k.this.buH() != null) {
                    k.this.buH().a(view, k.this.fJF);
                }
            }
        };
        this.fJS = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.fJJ = false;
                }
            }
        };
        this.dhW = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJF != null) {
                    if (k.this.buH() != null) {
                        k.this.buH().a(view, k.this.fJF);
                    }
                    if (k.this.fJF.cRg != null && view != k.this.eOl.dih) {
                        l.zT(k.this.fJF.cRg.getId());
                        if (!k.this.buS()) {
                            l.a(k.this.mTextTitle, k.this.fJF.cRg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.fJB.getGodReplyContent(), k.this.fJF.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.fJT = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                if (k.this.fJF != null && k.this.fJF.cRg != null && k.this.fJF.cRg.aCF() != null) {
                    k.this.buP();
                }
            }
        };
        this.fJU = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.dMk != null) {
                    k.this.dMk.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.cVi = tbPageContext;
        View view = getView();
        this.eNx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fJC = (HeadPendantClickableView) this.eNx.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJC.getHeadView() != null) {
            this.fJC.getHeadView().setIsRound(true);
            this.fJC.getHeadView().setDrawBorder(false);
            this.fJC.getHeadView().setDefaultResource(17170445);
            this.fJC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJC.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.ds70));
            this.fJC.getHeadView().setPlaceHolder(1);
        }
        this.fJC.setHasPendantStyle();
        if (this.fJC.getPendantView() != null) {
            this.fJC.getPendantView().setIsRound(true);
            this.fJC.getPendantView().setDrawBorder(false);
        }
        this.dMo = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dMo.setLoadingAnimationListener(this.fJO);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNy = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eNK = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.eNK.a(this.eNx, dimens, 0);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNz.setLayoutParams(layoutParams);
        }
        this.eNz.setOnClickListener(this);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setNeedAddPraiseIcon(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setShareVisible(true);
        this.eNz.setShareReportFrom(3);
        this.eNz.setForumAfterClickListener(this.dhW);
        this.eNz.setFrom(1);
        this.eOl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eOl.diU.setOnClickListener(this);
        this.eOl.setFrom(1);
        this.eOl.setShareReportFrom(3);
        this.eOl.setForumAfterClickListener(this.dhW);
        this.fJv = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dMi = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dMi.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVi.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dMi.setLayoutParams(layoutParams2);
        this.dMk = (TbImageView) view.findViewById(R.id.image_video);
        this.dMk.setDefaultErrorResource(0);
        this.dMk.setPlaceHolder(3);
        this.dMk.setGifIconSupport(false);
        this.dMk.setEvent(this.dMs);
        this.dMk.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dMk;
        TbImageView tbImageView2 = this.dMk;
        tbImageView.setConrers(15);
        this.dMk.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dMk.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dMk.setBorderSurroundContent(true);
        this.dMk.setDrawBorder(true);
        this.dMl = (ImageView) view.findViewById(R.id.image_video_play);
        this.eNx.setOnClickListener(this);
        this.elm = new com.baidu.tieba.play.n(this.cVi.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.rH("cyber_player_test");
        this.fJD = com.baidu.tieba.play.a.b.F(this.cVi.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.dMi.addView(this.fJD.getView(), 0);
        this.fJD.getView().setLayoutParams(layoutParams3);
        this.fJD.setContinuePlayEnable(true);
        this.fJD.setBusiness(this.elm);
        this.fJD.setOnPreparedListener(this.dVq);
        this.fJD.setOnOutInfoListener(this.dVs);
        this.fJD.setOnCompletionListener(this.dVp);
        this.fJD.setOnErrorListener(this.dMt);
        this.fJD.setOnSurfaceDestroyedListener(this.dMx);
        this.ell = new com.baidu.tieba.play.j();
        this.ell.setPlayer(this.fJD);
        this.ell.a(this.fJT);
        this.dMj = (TextView) view.findViewById(R.id.text_video_duration);
        this.fJE = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMq = (TextView) view.findViewById(R.id.text_video_play_count);
        this.dMp = view.findViewById(R.id.auto_video_black_mask);
        this.dMm = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dMn = view.findViewById(R.id.auto_video_error_background);
        this.egT = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.aLz = AnimationUtils.loadAnimation(this.cVi.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.aLz.setAnimationListener(this.fJU);
        this.fJB = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJB.setOnClickListener(this);
        this.cen = view.findViewById(R.id.divider_line);
        this.fJK = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.fJD.getView().setOnClickListener(this);
        this.fJM = (TextView) view.findViewById(R.id.nani_video_icon);
        this.fJA = new com.baidu.afd.videopaster.d(getContext(), this.dMi);
        this.fJA.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void ll() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lk() {
                if (!k.this.fJL) {
                    k.this.fJD.start();
                } else {
                    k.this.startPlay();
                }
                k.this.fJL = false;
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
        if (this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.cTP > 0) {
            if (buH() != null) {
                buH().a(view, this.fJF);
            }
            this.cVi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.cVi.getPageActivity(), this.fJF.cRg.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.aCa(), this.fJF.aAj())));
            return;
        }
        if (view == this.eNx || view == this.fJB) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.fJD.getView()) {
            if (this.fJF != null) {
                this.fJF.objType = 5;
            }
            if (this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.aCF() != null) {
                z = this.fJF.cRg.aCF().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(this.fJD.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bG(this.fJD.getView());
                } else {
                    bH(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bG(this.fJD.getView());
            } else {
                bH(getView());
            }
        }
    }

    private void bF(View view) {
        if (buH() != null) {
            buH().a(view, this.fJF);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVi.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buQ();
        }
    }

    private void bG(View view) {
        if (buH() != null) {
            buH().a(view, this.fJF);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVi.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buR();
        }
    }

    private void buQ() {
        if (this.fJF != null && this.fJF.cRg != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fJF.cRg);
            videoItemData.mRecomExtra = this.fJF.getExtra();
            videoItemData.mRecomAbTag = this.fJF.bvs();
            videoItemData.mRecomSource = this.fJF.getSource();
            videoItemData.mRecomWeight = this.fJF.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.fJF.aAj(), "index");
            if (this.fJF.cRg.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fJF.cRg.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buR() {
        if (this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fJF.cRg);
            videoSerializeVideoThreadInfo.source = this.fJF.getSource();
            videoSerializeVideoThreadInfo.extra = this.fJF.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.fJF.bvs();
            videoSerializeVideoThreadInfo.weight = this.fJF.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.egT.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.egT.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVi.getPageActivity(), str, this.fJF.cRg.getTid(), l.aCa(), this.fJF.aAj(), videoSerializeVideoThreadInfo);
            if (this.fJF.aAg() != null && this.fJF.aAg().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fJF.aAg().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bH(View view) {
        if (this.fJF != null) {
            this.fJF.objType = 1;
        }
        if (buH() != null) {
            buH().a(view, this.fJF);
        }
        if (this.fJF != null && this.fJF.cRg != null) {
            if (!buS()) {
                l.zT(this.fJF.cRg.getId());
                l.a(this.mTextTitle, this.fJF.cRg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVi.getPageActivity()).createFromThreadCfg(this.fJF.cRg, null, l.aCa(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fJF.aAj());
            addLocateParam.setVideo_source(this.fJF.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.fJF.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.fJF.cRg.getFid()));
            addLocateParam.setForumName(this.fJF.cRg.aCt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fJB) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buS() {
        return this.fJF.fNA && !this.fJF.fNH;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.fJF = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        this.fJN.removeMessages(202);
        if (this.fJD.getCurrentPosition() > this.EJ) {
            p(false, 3);
            this.fJN.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fJN.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fJN.removeMessages(203);
        int currentPosition = this.fJD.getCurrentPosition();
        if (currentPosition != this.fJG) {
            this.fJG = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fJN.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dMl != null && this.dMk != null && this.dMp != null && this.dMo != null && this.dMn != null && this.dMm != null) {
            if (z || this.dMr != i) {
                this.dMr = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMw);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMv);
                if (i == 2) {
                    this.dMl.setVisibility(8);
                    this.aLz.cancel();
                    this.dMk.clearAnimation();
                    this.dMk.setVisibility(0);
                    this.dMp.setVisibility(0);
                    this.fJE.setVisibility(0);
                    this.fJK.setVisibility(8);
                    this.dMo.startLoading();
                    this.dMn.setVisibility(8);
                    this.dMm.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMw, 60000L);
                } else if (i == 3) {
                    this.dMl.setVisibility(8);
                    this.dMk.startAnimation(this.aLz);
                    this.dMp.setVisibility(8);
                    this.fJE.setVisibility(8);
                    if (this.fJF != null && this.fJF.aAg() != null && this.fJF.aAg().cTP > 0) {
                        this.fJK.setVisibility(0);
                    }
                    this.dMo.czp();
                    this.dMn.setVisibility(8);
                    this.dMm.setVisibility(8);
                    if (this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.aCF() != null) {
                        this.fJF.cRg.aCF().video_length.intValue();
                        this.fJF.cRg.aCF().video_duration.intValue();
                        this.fJF.cRg.getTid();
                    }
                } else if (i == 4) {
                    this.dMl.setVisibility(8);
                    this.dMk.startAnimation(this.aLz);
                    this.dMp.setVisibility(8);
                    this.dMo.czq();
                    this.dMn.setVisibility(0);
                    this.dMm.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMv, 2000L);
                } else {
                    this.dMl.setVisibility(0);
                    this.aLz.cancel();
                    this.dMk.clearAnimation();
                    this.dMk.setVisibility(0);
                    this.dMp.setVisibility(0);
                    this.fJE.setVisibility(0);
                    this.dMo.czq();
                    this.dMn.setVisibility(8);
                    this.dMm.setVisibility(8);
                }
                if (this.fJF != null && this.fJF.aAg() != null && this.fJF.aAg().cTP > 0) {
                    this.fJE.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.fJF == null || this.fJF.cRg == null || this.fJF.cRg.aCo() == null) {
            this.eNx.setVisibility(8);
            return;
        }
        this.eNx.setVisibility(0);
        buW();
        if (!buS() && l.zU(this.fJF.cRg.getId())) {
            l.a(this.mTextTitle, this.fJF.cRg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.fJB.getGodReplyContent(), this.fJF.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fJF.aAg().aDj();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.fJF.aAg().aCV());
        if (this.fJF.aAg().aDb() && !StringUtils.isNull(this.fJF.aAg().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fJF.aAg().getTid();
            spannableStringBuilder.append((CharSequence) this.fJF.aAg().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cy("obj_source", "0"));
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
        this.eNy.setData(this.fJF.aAg());
        this.eNy.setUserAfterClickListener(this.fJQ);
        if (this.eNy.getHeaderImg() != null) {
            this.eNy.getHeaderImg().setAfterClickListener(this.fJR);
            if (this.eNy.getIsSimpleThread()) {
                this.eNy.getHeaderImg().setVisibility(8);
                this.fJC.setVisibility(8);
            } else if (this.fJF.aAg() == null || this.fJF.aAg().aCo() == null || this.fJF.aAg().aCo().getPendantData() == null || StringUtils.isNull(this.fJF.aAg().aCo().getPendantData().aAG())) {
                this.fJC.setVisibility(8);
                this.eNy.getHeaderImg().setVisibility(0);
                if (this.fJF.aAg().cTP > 0 && this.fJF.aAg().cTQ == 0) {
                    this.fJF.aAg().aCo().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.eNy.getHeaderImg().setData(this.fJF.aAg(), false);
                } else {
                    this.eNy.getHeaderImg().setData(this.fJF.aAg());
                    this.eNy.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.eNy.getHeaderImg().setVisibility(4);
                this.fJC.setVisibility(0);
                this.fJC.setData(this.fJF.aAg());
            }
        }
        this.dMj.setText(aq.stringForVideoTime(this.fJF.cRg.aCF().video_duration.intValue() * 1000));
        this.dMq.setText(String.format(this.cVi.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fJF.cRg.aCF().play_count.intValue())));
        if (this.eNK != null && this.fJF.aAg() != null) {
            al alVar = new al();
            alVar.setTid(this.fJF.aAg().getTid());
            alVar.setFid(this.fJF.aAg().getFid());
            alVar.setFeedBackReasonMap(this.fJF.feedBackReasonMap);
            this.eNK.setData(alVar);
            this.eNK.setFirstRowSingleColumn(true);
            this.eNK.setVisibility(this.fJI ? 0 : 8);
        }
        this.fJB.setData(this.fJF.aAg().aDM());
        pB(oc(1));
        onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
        if (l.zU(this.fJF.cRg.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.fJF == null || this.fJF.cRg == null || this.fJF.cRg.aCF() == null) {
            z = false;
        } else {
            z = this.fJF.cRg.aCF().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fJM.setVisibility(0);
            if (buX()) {
                this.fJM.setText(String.format("%s | %s", this.cVi.getResources().getString(R.string.nani_video), this.cVi.getResources().getString(R.string.video_preview)));
            } else {
                this.fJM.setText(this.cVi.getString(R.string.nani_video));
            }
        } else if (buX()) {
            this.fJM.setVisibility(0);
            this.fJM.setText(this.cVi.getString(R.string.video_preview));
        } else {
            this.fJM.setVisibility(8);
        }
    }

    private void buV() {
        this.fJN.removeMessages(202);
        this.fJN.removeMessages(203);
    }

    private void aTD() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMv);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMw);
    }

    private void buW() {
        aTD();
        buV();
        if (this.dMk != null && this.dMi != null && this.fJD != null) {
            if (com.baidu.tbadk.core.i.azO().isShowImages() && this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.aCF() != null) {
                this.dMk.setPlaceHolder(3);
                this.dMk.startLoad(this.fJF.cRg.aCF().thumbnail_url, 10, false);
                this.dMi.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.fJF.cRg.aCF().video_url;
                if (buX()) {
                    this.mVideoUrl = this.fJF.cRg.aCG().video_url;
                }
                if (StringUtils.isNull(this.fJF.cRg.aCF().video_url)) {
                    p(true, 4);
                }
                if (this.elm != null && this.elm.cza() != null) {
                    this.elm.cza().aj(this.fJF.cRg);
                }
            } else {
                this.dMi.setVisibility(8);
            }
            this.fJA.reset();
            this.ell.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fJA.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fJF);
                    }
                }
            });
            this.elm.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fJA.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fJF);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cRg != null) {
            bj bjVar = lVar.cRg;
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
        if (lVar == null || lVar.cRg == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.cRg;
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
        VideoInfo aCF = bjVar.aCF();
        if (aCF != null) {
            i3 = aCF.video_width.intValue();
            i2 = aCF.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aCt());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", lp + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNx, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMl, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dMm, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMj, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fJK, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMn, R.color.common_color_10014);
            am.setBackgroundColor(this.cen, R.color.cp_bg_line_c);
            if (this.fJM != null) {
                am.setViewTextColor(this.fJM, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fJM, R.drawable.video_play_count_bg);
            }
            if (this.dMm != null) {
                this.dMm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.fJB.onChangeSkinType();
            if (this.eNK != null) {
                this.eNK.onChangeSkinType();
            }
            this.eNy.onChangeSkinType();
            this.eNz.onChangeSkinType();
            this.eOl.onChangeSkinType();
            this.dMk.setPlaceHolder(3);
            this.fJC.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fJS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fJS);
            this.fJP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fJP);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eNy != null) {
            this.eNy.setPageUniqueId(bdUniqueId);
        }
        if (this.dMk != null) {
            this.dMk.setPageId(bdUniqueId);
        }
        if (this.eNK != null) {
            this.eNK.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.fJH;
    }

    public boolean isPlaying() {
        if (this.fJD == null) {
            return false;
        }
        return this.fJD.isPlaying();
    }

    public void startPlay() {
        if (!this.fJH && this.fJF != null && this.fJF.cRg != null && this.fJF.cRg.aCF() != null && this.fJD != null) {
            if (this.fJA.kU()) {
                this.fJA.resume();
                this.fJL = true;
                return;
            }
            this.fJL = false;
            this.fJD.stopPlayback();
            if (af.X(1, this.mVideoUrl)) {
                p(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cy("obj_locate", "index").cy("tid", this.fJF.tid));
                    this.mVideoUrl = this.fJF.cRg.aCF().video_url;
                }
                this.fJH = true;
                this.fJD.setVideoPath(this.mVideoUrl, this.fJF.tid);
                if (this.ell != null) {
                    this.ell.start();
                }
                buP();
            }
        }
    }

    public void stopPlay() {
        this.fJL = false;
        aTD();
        buV();
        p(true, 1);
        if (this.fJD != null) {
            this.fJD.stopPlayback();
            if (this.ell != null) {
                this.ell.stop();
            }
        }
        this.fJH = false;
        this.fJA.stop();
    }

    public View getVideoContainer() {
        return this.dMi;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.fJD == null) {
            return 0;
        }
        return this.fJD.getCurrentPosition();
    }

    public void ki(boolean z) {
        this.fJI = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pB(int i) {
        if (this.fJF != null && this.fJF.cRg != null) {
            if (i == 1) {
                if (this.fJF.cRg.cTP > 0) {
                    this.eOl.diU.setShowPraiseNum(false);
                    this.eOl.diU.setShareVisible(false);
                    this.fJK.setText(aq.numFormatOverWan(this.fJF.cRg.cTP));
                    this.fJK.setVisibility(0);
                } else {
                    this.eOl.diU.setShowPraiseNum(true);
                    this.eOl.diU.setShareVisible(true);
                    this.fJK.setVisibility(8);
                }
                this.eOl.setData(this.fJF.cRg);
                this.eNz.setVisibility(8);
                this.eNy.fR(false);
                return;
            }
            this.eOl.setVisibility(8);
            this.eNy.fR(true);
            if (this.fJF.cRg.cTP > 0) {
                this.eNz.setShowPraiseNum(false);
                this.eNz.setShareVisible(false);
                this.fJK.setText(aq.numFormatOverWan(this.fJF.cRg.cTP));
                this.fJK.setVisibility(0);
            } else {
                this.eNz.setShowPraiseNum(true);
                this.eNz.setShareVisible(true);
                this.fJK.setVisibility(8);
            }
            if (this.eNz.setData(this.fJF.cRg)) {
                this.fJv.setVisibility(8);
            } else {
                this.fJv.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXG().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dMk.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dMk.setOnDrawListener(null);
        }
    }

    private boolean buX() {
        return (this.fJF == null || this.fJF.cRg == null || this.fJF.cRg.aCG() == null || TextUtils.isEmpty(this.fJF.cRg.aCG().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.fJA.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.fJA.stop();
    }

    public void onResume() {
        if (this.fJA.kU()) {
            this.fJA.resume();
        }
    }
}
