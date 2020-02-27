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
    private Animation aLx;
    private TbPageContext<?> cVg;
    private View cel;
    public FrameLayout dLU;
    private TextView dLV;
    private TbImageView dLW;
    private ImageView dLX;
    private TextView dLY;
    private View dLZ;
    private com.baidu.tieba.play.w dMa;
    private View dMb;
    private TextView dMc;
    private int dMd;
    private TbImageView.a dMe;
    private g.b dMf;
    private Runnable dMh;
    private Runnable dMi;
    private QuickVideoView.b dMj;
    private g.a dVb;
    private g.f dVc;
    private g.e dVe;
    private final View.OnClickListener dhI;
    public ThreadSourceShareAndPraiseLayout eNX;
    private RelativeLayout eNj;
    public ThreadUserInfoLayout eNk;
    public ThreadCommentAndPraiseInfoLayout eNl;
    private NEGFeedBackView eNw;
    protected LinearLayout egF;
    private com.baidu.tieba.play.j ekX;
    private com.baidu.tieba.play.n ekY;
    private CustomMessageListener fJA;
    private final View.OnClickListener fJB;
    private final View.OnClickListener fJC;
    private CustomMessageListener fJD;
    private j.a fJE;
    private Animation.AnimationListener fJF;
    private View fJg;
    private com.baidu.afd.videopaster.d fJl;
    public ThreadGodReplyLayout fJm;
    private HeadPendantClickableView fJn;
    private com.baidu.tieba.play.a.a fJo;
    private LinearLayout fJp;
    private com.baidu.tieba.card.data.l fJq;
    private int fJr;
    private boolean fJs;
    private boolean fJt;
    private boolean fJu;
    private TextView fJv;
    private boolean fJw;
    private TextView fJx;
    private Handler fJy;
    private VideoLoadingProgressView.a fJz;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        if (this.fJo != null && this.fJs) {
            try {
                this.fJo.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Hd = com.baidu.tieba.play.x.czq().Hd(this.mVideoUrl);
            if (Hd <= 100 || this.fJo.getDuration() <= Hd) {
                Hd = 100;
            }
            this.EJ = Hd;
            this.fJy.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        if (this.fJq != null && this.fJq.cRe != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.fJq.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.Pj = this.fJq.cRe.getTid();
            yVar.ema = this.fJq.cRe.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.fJq.cRe.mRecomSource;
            yVar.mAbTag = this.fJq.cRe.mRecomAbTag;
            yVar.jwE = this.fJq.cRe.mRecomAbTag;
            yVar.jwF = this.fJq.cRe.mRecomWeight;
            yVar.jwG = "";
            yVar.cOQ = this.fJq.getExtra();
            if (this.fJq.cRe.aCD() != null) {
                yVar.jwI = this.fJq.cRe.aCD().video_md5;
            }
            com.baidu.tieba.play.l.a(this.fJq.cRe.aCD().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNw = null;
        this.mSkinType = 3;
        this.fJr = 0;
        this.dMd = 1;
        this.fJs = false;
        this.fJt = true;
        this.fJu = false;
        this.EJ = 100;
        this.fJw = false;
        this.isNewPlayer = false;
        this.fJy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.buQ();
                        return;
                    case 203:
                        k.this.buR();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.fJo != null) {
                    k.this.fJo.setVolume(0.0f, 0.0f);
                }
                k.this.buL();
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVb = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.fJl.a(false, false, "NEWINDEX")) {
                    k.this.fJo.start();
                }
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.p(true, 4);
                k.this.fJs = false;
                return true;
            }
        };
        this.fJz = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.buL();
            }
        };
        this.dMe = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.dLW != null) {
                    k.this.dLW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMh = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.fJo != null && !k.this.fJo.isPlaying()) {
                    k.this.p(true, 1);
                }
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.p(true, 4);
            }
        };
        this.fJA = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.fJq != null && k.this.fJq.cRe != null && videoId.equals(k.this.fJq.cRe.getId())) {
                        k.this.fJl.a(k.this.a(k.this.fJq, bVar));
                    }
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.fJB = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJq == null) {
                    if (k.this.buE() != null) {
                        k.this.buE().a(view, k.this.fJq);
                        return;
                    }
                    return;
                }
                if (view == k.this.eNk.getUserName()) {
                    k.this.fJq.objType = 3;
                } else if (view == k.this.eNk.getHeaderImg()) {
                    k.this.fJq.objType = 4;
                } else {
                    k.this.fJq.objType = 1;
                }
                if (k.this.buE() != null) {
                    k.this.buE().a(view, k.this.fJq);
                }
            }
        };
        this.fJC = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJq != null) {
                    k.this.fJq.objType = 4;
                }
                if (k.this.buE() != null) {
                    k.this.buE().a(view, k.this.fJq);
                }
            }
        };
        this.fJD = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.fJu = false;
                }
            }
        };
        this.dhI = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJq != null) {
                    if (k.this.buE() != null) {
                        k.this.buE().a(view, k.this.fJq);
                    }
                    if (k.this.fJq.cRe != null && view != k.this.eNX.dhS) {
                        l.zS(k.this.fJq.cRe.getId());
                        if (!k.this.buP()) {
                            l.a(k.this.mTextTitle, k.this.fJq.cRe.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.fJm.getGodReplyContent(), k.this.fJq.aAe().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.fJE = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                if (k.this.fJq != null && k.this.fJq.cRe != null && k.this.fJq.cRe.aCD() != null) {
                    k.this.buM();
                }
            }
        };
        this.fJF = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.dLW != null) {
                    k.this.dLW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.cVg = tbPageContext;
        View view = getView();
        this.eNj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fJn = (HeadPendantClickableView) this.eNj.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJn.getHeadView() != null) {
            this.fJn.getHeadView().setIsRound(true);
            this.fJn.getHeadView().setDrawBorder(false);
            this.fJn.getHeadView().setDefaultResource(17170445);
            this.fJn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJn.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.ds70));
            this.fJn.getHeadView().setPlaceHolder(1);
        }
        this.fJn.setHasPendantStyle();
        if (this.fJn.getPendantView() != null) {
            this.fJn.getPendantView().setIsRound(true);
            this.fJn.getPendantView().setDrawBorder(false);
        }
        this.dMa = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dMa.setLoadingAnimationListener(this.fJz);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNk = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eNw = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.eNw.a(this.eNj, dimens, 0);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNl.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNl.setLayoutParams(layoutParams);
        }
        this.eNl.setOnClickListener(this);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setShareVisible(true);
        this.eNl.setShareReportFrom(3);
        this.eNl.setForumAfterClickListener(this.dhI);
        this.eNl.setFrom(1);
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eNX.diG.setOnClickListener(this);
        this.eNX.setFrom(1);
        this.eNX.setShareReportFrom(3);
        this.eNX.setForumAfterClickListener(this.dhI);
        this.fJg = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dLU = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLU.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVg.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dLU.setLayoutParams(layoutParams2);
        this.dLW = (TbImageView) view.findViewById(R.id.image_video);
        this.dLW.setDefaultErrorResource(0);
        this.dLW.setPlaceHolder(3);
        this.dLW.setGifIconSupport(false);
        this.dLW.setEvent(this.dMe);
        this.dLW.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dLW;
        TbImageView tbImageView2 = this.dLW;
        tbImageView.setConrers(15);
        this.dLW.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dLW.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dLW.setBorderSurroundContent(true);
        this.dLW.setDrawBorder(true);
        this.dLX = (ImageView) view.findViewById(R.id.image_video_play);
        this.eNj.setOnClickListener(this);
        this.ekY = new com.baidu.tieba.play.n(this.cVg.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.rH("cyber_player_test");
        this.fJo = com.baidu.tieba.play.a.b.F(this.cVg.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.dLU.addView(this.fJo.getView(), 0);
        this.fJo.getView().setLayoutParams(layoutParams3);
        this.fJo.setContinuePlayEnable(true);
        this.fJo.setBusiness(this.ekY);
        this.fJo.setOnPreparedListener(this.dVc);
        this.fJo.setOnOutInfoListener(this.dVe);
        this.fJo.setOnCompletionListener(this.dVb);
        this.fJo.setOnErrorListener(this.dMf);
        this.fJo.setOnSurfaceDestroyedListener(this.dMj);
        this.ekX = new com.baidu.tieba.play.j();
        this.ekX.setPlayer(this.fJo);
        this.ekX.a(this.fJE);
        this.dLV = (TextView) view.findViewById(R.id.text_video_duration);
        this.fJp = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMc = (TextView) view.findViewById(R.id.text_video_play_count);
        this.dMb = view.findViewById(R.id.auto_video_black_mask);
        this.dLY = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dLZ = view.findViewById(R.id.auto_video_error_background);
        this.egF = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.aLx = AnimationUtils.loadAnimation(this.cVg.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.aLx.setAnimationListener(this.fJF);
        this.fJm = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJm.setOnClickListener(this);
        this.cel = view.findViewById(R.id.divider_line);
        this.fJv = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.fJo.getView().setOnClickListener(this);
        this.fJx = (TextView) view.findViewById(R.id.nani_video_icon);
        this.fJl = new com.baidu.afd.videopaster.d(getContext(), this.dLU);
        this.fJl.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void ll() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lk() {
                if (!k.this.fJw) {
                    k.this.fJo.start();
                } else {
                    k.this.startPlay();
                }
                k.this.fJw = false;
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
        if (this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.cTN > 0) {
            if (buE() != null) {
                buE().a(view, this.fJq);
            }
            this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.cVg.getPageActivity(), this.fJq.cRe.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.aBY(), this.fJq.aAh())));
            return;
        }
        if (view == this.eNj || view == this.fJm) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.fJo.getView()) {
            if (this.fJq != null) {
                this.fJq.objType = 5;
            }
            if (this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.aCD() != null) {
                z = this.fJq.cRe.aCD().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(this.fJo.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bG(this.fJo.getView());
                } else {
                    bH(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bG(this.fJo.getView());
            } else {
                bH(getView());
            }
        }
    }

    private void bF(View view) {
        if (buE() != null) {
            buE().a(view, this.fJq);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVg.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buN();
        }
    }

    private void bG(View view) {
        if (buE() != null) {
            buE().a(view, this.fJq);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVg.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buO();
        }
    }

    private void buN() {
        if (this.fJq != null && this.fJq.cRe != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fJq.cRe);
            videoItemData.mRecomExtra = this.fJq.getExtra();
            videoItemData.mRecomAbTag = this.fJq.bvp();
            videoItemData.mRecomSource = this.fJq.getSource();
            videoItemData.mRecomWeight = this.fJq.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.fJq.aAh(), "index");
            if (this.fJq.cRe.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fJq.cRe.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buO() {
        if (this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fJq.cRe);
            videoSerializeVideoThreadInfo.source = this.fJq.getSource();
            videoSerializeVideoThreadInfo.extra = this.fJq.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.fJq.bvp();
            videoSerializeVideoThreadInfo.weight = this.fJq.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.egF.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.egF.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVg.getPageActivity(), str, this.fJq.cRe.getTid(), l.aBY(), this.fJq.aAh(), videoSerializeVideoThreadInfo);
            if (this.fJq.aAe() != null && this.fJq.aAe().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fJq.aAe().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bH(View view) {
        if (this.fJq != null) {
            this.fJq.objType = 1;
        }
        if (buE() != null) {
            buE().a(view, this.fJq);
        }
        if (this.fJq != null && this.fJq.cRe != null) {
            if (!buP()) {
                l.zS(this.fJq.cRe.getId());
                l.a(this.mTextTitle, this.fJq.cRe.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVg.getPageActivity()).createFromThreadCfg(this.fJq.cRe, null, l.aBY(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fJq.aAh());
            addLocateParam.setVideo_source(this.fJq.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.fJq.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.fJq.cRe.getFid()));
            addLocateParam.setForumName(this.fJq.cRe.aCr());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fJm) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buP() {
        return this.fJq.fNl && !this.fJq.fNs;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.fJq = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        this.fJy.removeMessages(202);
        if (this.fJo.getCurrentPosition() > this.EJ) {
            p(false, 3);
            this.fJy.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fJy.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buR() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fJy.removeMessages(203);
        int currentPosition = this.fJo.getCurrentPosition();
        if (currentPosition != this.fJr) {
            this.fJr = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fJy.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dLX != null && this.dLW != null && this.dMb != null && this.dMa != null && this.dLZ != null && this.dLY != null) {
            if (z || this.dMd != i) {
                this.dMd = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMh);
                if (i == 2) {
                    this.dLX.setVisibility(8);
                    this.aLx.cancel();
                    this.dLW.clearAnimation();
                    this.dLW.setVisibility(0);
                    this.dMb.setVisibility(0);
                    this.fJp.setVisibility(0);
                    this.fJv.setVisibility(8);
                    this.dMa.startLoading();
                    this.dLZ.setVisibility(8);
                    this.dLY.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMi, 60000L);
                } else if (i == 3) {
                    this.dLX.setVisibility(8);
                    this.dLW.startAnimation(this.aLx);
                    this.dMb.setVisibility(8);
                    this.fJp.setVisibility(8);
                    if (this.fJq != null && this.fJq.aAe() != null && this.fJq.aAe().cTN > 0) {
                        this.fJv.setVisibility(0);
                    }
                    this.dMa.czm();
                    this.dLZ.setVisibility(8);
                    this.dLY.setVisibility(8);
                    if (this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.aCD() != null) {
                        this.fJq.cRe.aCD().video_length.intValue();
                        this.fJq.cRe.aCD().video_duration.intValue();
                        this.fJq.cRe.getTid();
                    }
                } else if (i == 4) {
                    this.dLX.setVisibility(8);
                    this.dLW.startAnimation(this.aLx);
                    this.dMb.setVisibility(8);
                    this.dMa.czn();
                    this.dLZ.setVisibility(0);
                    this.dLY.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMh, 2000L);
                } else {
                    this.dLX.setVisibility(0);
                    this.aLx.cancel();
                    this.dLW.clearAnimation();
                    this.dLW.setVisibility(0);
                    this.dMb.setVisibility(0);
                    this.fJp.setVisibility(0);
                    this.dMa.czn();
                    this.dLZ.setVisibility(8);
                    this.dLY.setVisibility(8);
                }
                if (this.fJq != null && this.fJq.aAe() != null && this.fJq.aAe().cTN > 0) {
                    this.fJp.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.fJq == null || this.fJq.cRe == null || this.fJq.cRe.aCm() == null) {
            this.eNj.setVisibility(8);
            return;
        }
        this.eNj.setVisibility(0);
        buT();
        if (!buP() && l.zT(this.fJq.cRe.getId())) {
            l.a(this.mTextTitle, this.fJq.cRe.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.fJm.getGodReplyContent(), this.fJq.aAe().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fJq.aAe().aDh();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.fJq.aAe().aCT());
        if (this.fJq.aAe().aCZ() && !StringUtils.isNull(this.fJq.aAe().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fJq.aAe().getTid();
            spannableStringBuilder.append((CharSequence) this.fJq.aAe().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
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
        this.eNk.setData(this.fJq.aAe());
        this.eNk.setUserAfterClickListener(this.fJB);
        if (this.eNk.getHeaderImg() != null) {
            this.eNk.getHeaderImg().setAfterClickListener(this.fJC);
            if (this.eNk.getIsSimpleThread()) {
                this.eNk.getHeaderImg().setVisibility(8);
                this.fJn.setVisibility(8);
            } else if (this.fJq.aAe() == null || this.fJq.aAe().aCm() == null || this.fJq.aAe().aCm().getPendantData() == null || StringUtils.isNull(this.fJq.aAe().aCm().getPendantData().aAE())) {
                this.fJn.setVisibility(8);
                this.eNk.getHeaderImg().setVisibility(0);
                if (this.fJq.aAe().cTN > 0 && this.fJq.aAe().cTO == 0) {
                    this.fJq.aAe().aCm().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.eNk.getHeaderImg().setData(this.fJq.aAe(), false);
                } else {
                    this.eNk.getHeaderImg().setData(this.fJq.aAe());
                    this.eNk.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.eNk.getHeaderImg().setVisibility(4);
                this.fJn.setVisibility(0);
                this.fJn.setData(this.fJq.aAe());
            }
        }
        this.dLV.setText(aq.stringForVideoTime(this.fJq.cRe.aCD().video_duration.intValue() * 1000));
        this.dMc.setText(String.format(this.cVg.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fJq.cRe.aCD().play_count.intValue())));
        if (this.eNw != null && this.fJq.aAe() != null) {
            al alVar = new al();
            alVar.setTid(this.fJq.aAe().getTid());
            alVar.setFid(this.fJq.aAe().getFid());
            alVar.setFeedBackReasonMap(this.fJq.feedBackReasonMap);
            this.eNw.setData(alVar);
            this.eNw.setFirstRowSingleColumn(true);
            this.eNw.setVisibility(this.fJt ? 0 : 8);
        }
        this.fJm.setData(this.fJq.aAe().aDK());
        pB(oc(1));
        onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
        if (l.zT(this.fJq.cRe.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.fJq == null || this.fJq.cRe == null || this.fJq.cRe.aCD() == null) {
            z = false;
        } else {
            z = this.fJq.cRe.aCD().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fJx.setVisibility(0);
            if (buU()) {
                this.fJx.setText(String.format("%s | %s", this.cVg.getResources().getString(R.string.nani_video), this.cVg.getResources().getString(R.string.video_preview)));
            } else {
                this.fJx.setText(this.cVg.getString(R.string.nani_video));
            }
        } else if (buU()) {
            this.fJx.setVisibility(0);
            this.fJx.setText(this.cVg.getString(R.string.video_preview));
        } else {
            this.fJx.setVisibility(8);
        }
    }

    private void buS() {
        this.fJy.removeMessages(202);
        this.fJy.removeMessages(203);
    }

    private void aTA() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMh);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
    }

    private void buT() {
        aTA();
        buS();
        if (this.dLW != null && this.dLU != null && this.fJo != null) {
            if (com.baidu.tbadk.core.i.azM().isShowImages() && this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.aCD() != null) {
                this.dLW.setPlaceHolder(3);
                this.dLW.startLoad(this.fJq.cRe.aCD().thumbnail_url, 10, false);
                this.dLU.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.fJq.cRe.aCD().video_url;
                if (buU()) {
                    this.mVideoUrl = this.fJq.cRe.aCE().video_url;
                }
                if (StringUtils.isNull(this.fJq.cRe.aCD().video_url)) {
                    p(true, 4);
                }
                if (this.ekY != null && this.ekY.cyX() != null) {
                    this.ekY.cyX().aj(this.fJq.cRe);
                }
            } else {
                this.dLU.setVisibility(8);
            }
            this.fJl.reset();
            this.ekX.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fJl.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fJq);
                    }
                }
            });
            this.ekY.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fJl.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fJq);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cRe != null) {
            bj bjVar = lVar.cRe;
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
        if (lVar == null || lVar.cRe == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.cRe;
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
        VideoInfo aCD = bjVar.aCD();
        if (aCD != null) {
            i3 = aCD.video_width.intValue();
            i2 = aCD.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aCr());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", lp + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNj, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLX, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dLY, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dLV, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMc, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fJv, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dLZ, R.color.common_color_10014);
            am.setBackgroundColor(this.cel, R.color.cp_bg_line_c);
            if (this.fJx != null) {
                am.setViewTextColor(this.fJx, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fJx, R.drawable.video_play_count_bg);
            }
            if (this.dLY != null) {
                this.dLY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.fJm.onChangeSkinType();
            if (this.eNw != null) {
                this.eNw.onChangeSkinType();
            }
            this.eNk.onChangeSkinType();
            this.eNl.onChangeSkinType();
            this.eNX.onChangeSkinType();
            this.dLW.setPlaceHolder(3);
            this.fJn.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fJD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fJD);
            this.fJA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fJA);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eNk != null) {
            this.eNk.setPageUniqueId(bdUniqueId);
        }
        if (this.dLW != null) {
            this.dLW.setPageId(bdUniqueId);
        }
        if (this.eNw != null) {
            this.eNw.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.fJs;
    }

    public boolean isPlaying() {
        if (this.fJo == null) {
            return false;
        }
        return this.fJo.isPlaying();
    }

    public void startPlay() {
        if (!this.fJs && this.fJq != null && this.fJq.cRe != null && this.fJq.cRe.aCD() != null && this.fJo != null) {
            if (this.fJl.kU()) {
                this.fJl.resume();
                this.fJw = true;
                return;
            }
            this.fJw = false;
            this.fJo.stopPlayback();
            if (af.X(1, this.mVideoUrl)) {
                p(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cy("obj_locate", "index").cy("tid", this.fJq.tid));
                    this.mVideoUrl = this.fJq.cRe.aCD().video_url;
                }
                this.fJs = true;
                this.fJo.setVideoPath(this.mVideoUrl, this.fJq.tid);
                if (this.ekX != null) {
                    this.ekX.start();
                }
                buM();
            }
        }
    }

    public void stopPlay() {
        this.fJw = false;
        aTA();
        buS();
        p(true, 1);
        if (this.fJo != null) {
            this.fJo.stopPlayback();
            if (this.ekX != null) {
                this.ekX.stop();
            }
        }
        this.fJs = false;
        this.fJl.stop();
    }

    public View getVideoContainer() {
        return this.dLU;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.fJo == null) {
            return 0;
        }
        return this.fJo.getCurrentPosition();
    }

    public void ki(boolean z) {
        this.fJt = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pB(int i) {
        if (this.fJq != null && this.fJq.cRe != null) {
            if (i == 1) {
                if (this.fJq.cRe.cTN > 0) {
                    this.eNX.diG.setShowPraiseNum(false);
                    this.eNX.diG.setShareVisible(false);
                    this.fJv.setText(aq.numFormatOverWan(this.fJq.cRe.cTN));
                    this.fJv.setVisibility(0);
                } else {
                    this.eNX.diG.setShowPraiseNum(true);
                    this.eNX.diG.setShareVisible(true);
                    this.fJv.setVisibility(8);
                }
                this.eNX.setData(this.fJq.cRe);
                this.eNl.setVisibility(8);
                this.eNk.fR(false);
                return;
            }
            this.eNX.setVisibility(8);
            this.eNk.fR(true);
            if (this.fJq.cRe.cTN > 0) {
                this.eNl.setShowPraiseNum(false);
                this.eNl.setShareVisible(false);
                this.fJv.setText(aq.numFormatOverWan(this.fJq.cRe.cTN));
                this.fJv.setVisibility(0);
            } else {
                this.eNl.setShowPraiseNum(true);
                this.eNl.setShareVisible(true);
                this.fJv.setVisibility(8);
            }
            if (this.eNl.setData(this.fJq.cRe)) {
                this.fJg.setVisibility(8);
            } else {
                this.fJg.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dLW.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dLW.setOnDrawListener(null);
        }
    }

    private boolean buU() {
        return (this.fJq == null || this.fJq.cRe == null || this.fJq.cRe.aCE() == null || TextUtils.isEmpty(this.fJq.cRe.aCE().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.fJl.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.fJl.stop();
    }

    public void onResume() {
        if (this.fJl.kU()) {
            this.fJl.resume();
        }
    }
}
