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
    private Animation aLy;
    private TbPageContext<?> cVh;
    private View cem;
    public FrameLayout dLV;
    private TextView dLW;
    private TbImageView dLX;
    private ImageView dLY;
    private TextView dLZ;
    private View dMa;
    private com.baidu.tieba.play.w dMb;
    private View dMc;
    private TextView dMd;
    private int dMe;
    private TbImageView.a dMf;
    private g.b dMg;
    private Runnable dMi;
    private Runnable dMj;
    private QuickVideoView.b dMk;
    private g.a dVc;
    private g.f dVd;
    private g.e dVf;
    private final View.OnClickListener dhJ;
    public ThreadSourceShareAndPraiseLayout eNY;
    private RelativeLayout eNk;
    public ThreadUserInfoLayout eNl;
    public ThreadCommentAndPraiseInfoLayout eNm;
    private NEGFeedBackView eNx;
    protected LinearLayout egG;
    private com.baidu.tieba.play.j ekY;
    private com.baidu.tieba.play.n ekZ;
    private Handler fJA;
    private VideoLoadingProgressView.a fJB;
    private CustomMessageListener fJC;
    private final View.OnClickListener fJD;
    private final View.OnClickListener fJE;
    private CustomMessageListener fJF;
    private j.a fJG;
    private Animation.AnimationListener fJH;
    private View fJi;
    private com.baidu.afd.videopaster.d fJn;
    public ThreadGodReplyLayout fJo;
    private HeadPendantClickableView fJp;
    private com.baidu.tieba.play.a.a fJq;
    private LinearLayout fJr;
    private com.baidu.tieba.card.data.l fJs;
    private int fJt;
    private boolean fJu;
    private boolean fJv;
    private boolean fJw;
    private TextView fJx;
    private boolean fJy;
    private TextView fJz;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buN() {
        if (this.fJq != null && this.fJu) {
            try {
                this.fJq.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Hd = com.baidu.tieba.play.x.czs().Hd(this.mVideoUrl);
            if (Hd <= 100 || this.fJq.getDuration() <= Hd) {
                Hd = 100;
            }
            this.EJ = Hd;
            this.fJA.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.fJs != null && this.fJs.cRf != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.fJs.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.Pj = this.fJs.cRf.getTid();
            yVar.emb = this.fJs.cRf.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.fJs.cRf.mRecomSource;
            yVar.mAbTag = this.fJs.cRf.mRecomAbTag;
            yVar.jwG = this.fJs.cRf.mRecomAbTag;
            yVar.jwH = this.fJs.cRf.mRecomWeight;
            yVar.jwI = "";
            yVar.cOR = this.fJs.getExtra();
            if (this.fJs.cRf.aCF() != null) {
                yVar.jwK = this.fJs.cRf.aCF().video_md5;
            }
            com.baidu.tieba.play.l.a(this.fJs.cRf.aCF().video_md5, "", "1", yVar);
        }
    }

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNx = null;
        this.mSkinType = 3;
        this.fJt = 0;
        this.dMe = 1;
        this.fJu = false;
        this.fJv = true;
        this.fJw = false;
        this.EJ = 100;
        this.fJy = false;
        this.isNewPlayer = false;
        this.fJA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        k.this.buS();
                        return;
                    case 203:
                        k.this.buT();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.card.k.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (k.this.fJq != null) {
                    k.this.fJq.setVolume(0.0f, 0.0f);
                }
                k.this.buN();
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.card.k.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    k.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVc = new g.a() { // from class: com.baidu.tieba.card.k.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!k.this.fJn.a(false, false, "NEWINDEX")) {
                    k.this.fJq.start();
                }
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.card.k.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                k.this.p(true, 4);
                k.this.fJu = false;
                return true;
            }
        };
        this.fJB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.k.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                k.this.buN();
            }
        };
        this.dMf = new TbImageView.a() { // from class: com.baidu.tieba.card.k.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && k.this.dLX != null) {
                    k.this.dLX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tieba.card.k.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.fJq != null && !k.this.fJq.isPlaying()) {
                    k.this.p(true, 1);
                }
            }
        };
        this.dMj = new Runnable() { // from class: com.baidu.tieba.card.k.3
            @Override // java.lang.Runnable
            public void run() {
                k.this.p(true, 4);
            }
        };
        this.fJC = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && k.this.fJs != null && k.this.fJs.cRf != null && videoId.equals(k.this.fJs.cRf.getId())) {
                        k.this.fJn.a(k.this.a(k.this.fJs, bVar));
                    }
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.card.k.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                k.this.stopPlay();
            }
        };
        this.fJD = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJs == null) {
                    if (k.this.buG() != null) {
                        k.this.buG().a(view, k.this.fJs);
                        return;
                    }
                    return;
                }
                if (view == k.this.eNl.getUserName()) {
                    k.this.fJs.objType = 3;
                } else if (view == k.this.eNl.getHeaderImg()) {
                    k.this.fJs.objType = 4;
                } else {
                    k.this.fJs.objType = 1;
                }
                if (k.this.buG() != null) {
                    k.this.buG().a(view, k.this.fJs);
                }
            }
        };
        this.fJE = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJs != null) {
                    k.this.fJs.objType = 4;
                }
                if (k.this.buG() != null) {
                    k.this.buG().a(view, k.this.fJs);
                }
            }
        };
        this.fJF = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.k.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    k.this.fJw = false;
                }
            }
        };
        this.dhJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJs != null) {
                    if (k.this.buG() != null) {
                        k.this.buG().a(view, k.this.fJs);
                    }
                    if (k.this.fJs.cRf != null && view != k.this.eNY.dhT) {
                        l.zS(k.this.fJs.cRf.getId());
                        if (!k.this.buR()) {
                            l.a(k.this.mTextTitle, k.this.fJs.cRf.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            l.a(k.this.fJo.getGodReplyContent(), k.this.fJs.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.fJG = new j.a() { // from class: com.baidu.tieba.card.k.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                if (k.this.fJs != null && k.this.fJs.cRf != null && k.this.fJs.cRf.aCF() != null) {
                    k.this.buO();
                }
            }
        };
        this.fJH = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.k.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (k.this.dLX != null) {
                    k.this.dLX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.cVh = tbPageContext;
        View view = getView();
        this.eNk = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fJp = (HeadPendantClickableView) this.eNk.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJp.getHeadView() != null) {
            this.fJp.getHeadView().setIsRound(true);
            this.fJp.getHeadView().setDrawBorder(false);
            this.fJp.getHeadView().setDefaultResource(17170445);
            this.fJp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJp.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.ds70));
            this.fJp.getHeadView().setPlaceHolder(1);
        }
        this.fJp.setHasPendantStyle();
        if (this.fJp.getPendantView() != null) {
            this.fJp.getPendantView().setIsRound(true);
            this.fJp.getPendantView().setDrawBorder(false);
        }
        this.dMb = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dMb.setLoadingAnimationListener(this.fJB);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNl = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eNx = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.eNx.a(this.eNk, dimens, 0);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.eNm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNm.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNm.setLayoutParams(layoutParams);
        }
        this.eNm.setOnClickListener(this);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setShareVisible(true);
        this.eNm.setShareReportFrom(3);
        this.eNm.setForumAfterClickListener(this.dhJ);
        this.eNm.setFrom(1);
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eNY.diH.setOnClickListener(this);
        this.eNY.setFrom(1);
        this.eNY.setShareReportFrom(3);
        this.eNY.setForumAfterClickListener(this.dhJ);
        this.fJi = view.findViewById(R.id.divider_below_reply_number_layout);
        this.dLV = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLV.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cVh.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.dLV.setLayoutParams(layoutParams2);
        this.dLX = (TbImageView) view.findViewById(R.id.image_video);
        this.dLX.setDefaultErrorResource(0);
        this.dLX.setPlaceHolder(3);
        this.dLX.setGifIconSupport(false);
        this.dLX.setEvent(this.dMf);
        this.dLX.setRadius(com.baidu.adp.lib.util.l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.dLX;
        TbImageView tbImageView2 = this.dLX;
        tbImageView.setConrers(15);
        this.dLX.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.dLX.setBorderColor(am.getColor(R.color.cp_border_a));
        this.dLX.setBorderSurroundContent(true);
        this.dLX.setDrawBorder(true);
        this.dLY = (ImageView) view.findViewById(R.id.image_video_play);
        this.eNk.setOnClickListener(this);
        this.ekZ = new com.baidu.tieba.play.n(this.cVh.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.rH("cyber_player_test");
        this.fJq = com.baidu.tieba.play.a.b.F(this.cVh.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.dLV.addView(this.fJq.getView(), 0);
        this.fJq.getView().setLayoutParams(layoutParams3);
        this.fJq.setContinuePlayEnable(true);
        this.fJq.setBusiness(this.ekZ);
        this.fJq.setOnPreparedListener(this.dVd);
        this.fJq.setOnOutInfoListener(this.dVf);
        this.fJq.setOnCompletionListener(this.dVc);
        this.fJq.setOnErrorListener(this.dMg);
        this.fJq.setOnSurfaceDestroyedListener(this.dMk);
        this.ekY = new com.baidu.tieba.play.j();
        this.ekY.setPlayer(this.fJq);
        this.ekY.a(this.fJG);
        this.dLW = (TextView) view.findViewById(R.id.text_video_duration);
        this.fJr = (LinearLayout) view.findViewById(R.id.duration_container);
        this.dMd = (TextView) view.findViewById(R.id.text_video_play_count);
        this.dMc = view.findViewById(R.id.auto_video_black_mask);
        this.dLZ = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dMa = view.findViewById(R.id.auto_video_error_background);
        this.egG = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.aLy = AnimationUtils.loadAnimation(this.cVh.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.aLy.setAnimationListener(this.fJH);
        this.fJo = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJo.setOnClickListener(this);
        this.cem = view.findViewById(R.id.divider_line);
        this.fJx = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.fJq.getView().setOnClickListener(this);
        this.fJz = (TextView) view.findViewById(R.id.nani_video_icon);
        this.fJn = new com.baidu.afd.videopaster.d(getContext(), this.dLV);
        this.fJn.a(new d.a() { // from class: com.baidu.tieba.card.k.20
            @Override // com.baidu.afd.videopaster.d.a
            public void ll() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lk() {
                if (!k.this.fJy) {
                    k.this.fJq.start();
                } else {
                    k.this.startPlay();
                }
                k.this.fJy = false;
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
        if (this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.cTO > 0) {
            if (buG() != null) {
                buG().a(view, this.fJs);
            }
            this.cVh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.cVh.getPageActivity(), this.fJs.cRf.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, l.aCa(), this.fJs.aAj())));
            return;
        }
        if (view == this.eNk || view == this.fJo) {
            bH(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.fJq.getView()) {
            if (this.fJs != null) {
                this.fJs.objType = 5;
            }
            if (this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.aCF() != null) {
                z = this.fJs.cRf.aCF().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(this.fJq.getView());
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bG(this.fJq.getView());
                } else {
                    bH(getView());
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bG(this.fJq.getView());
            } else {
                bH(getView());
            }
        }
    }

    private void bF(View view) {
        if (buG() != null) {
            buG().a(view, this.fJs);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVh.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buP();
        }
    }

    private void bG(View view) {
        if (buG() != null) {
            buG().a(view, this.fJs);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.cVh.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buQ();
        }
    }

    private void buP() {
        if (this.fJs != null && this.fJs.cRf != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.fJs.cRf);
            videoItemData.mRecomExtra = this.fJs.getExtra();
            videoItemData.mRecomAbTag = this.fJs.bvr();
            videoItemData.mRecomSource = this.fJs.getSource();
            videoItemData.mRecomWeight = this.fJs.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.fJs.aAj(), "index");
            if (this.fJs.cRf.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.fJs.cRf.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void buQ() {
        if (this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.fJs.cRf);
            videoSerializeVideoThreadInfo.source = this.fJs.getSource();
            videoSerializeVideoThreadInfo.extra = this.fJs.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.fJs.bvr();
            videoSerializeVideoThreadInfo.weight = this.fJs.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.egG.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.egG.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!aq.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVh.getPageActivity(), str, this.fJs.cRf.getTid(), l.aCa(), this.fJs.aAj(), videoSerializeVideoThreadInfo);
            if (this.fJs.aAg() != null && this.fJs.aAg().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.fJs.aAg().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bH(View view) {
        if (this.fJs != null) {
            this.fJs.objType = 1;
        }
        if (buG() != null) {
            buG().a(view, this.fJs);
        }
        if (this.fJs != null && this.fJs.cRf != null) {
            if (!buR()) {
                l.zS(this.fJs.cRf.getId());
                l.a(this.mTextTitle, this.fJs.cRf.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVh.getPageActivity()).createFromThreadCfg(this.fJs.cRf, null, l.aCa(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.fJs.aAj());
            addLocateParam.setVideo_source(this.fJs.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.fJs.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.fJs.cRf.getFid()));
            addLocateParam.setForumName(this.fJs.cRf.aCt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.fJo) {
                addLocateParam.setJumpGodReply(true);
            }
            this.cVh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buR() {
        return this.fJs.fNn && !this.fJs.fNu;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.fJs = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buS() {
        this.fJA.removeMessages(202);
        if (this.fJq.getCurrentPosition() > this.EJ) {
            p(false, 3);
            this.fJA.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fJA.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fJA.removeMessages(203);
        int currentPosition = this.fJq.getCurrentPosition();
        if (currentPosition != this.fJt) {
            this.fJt = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fJA.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dLY != null && this.dLX != null && this.dMc != null && this.dMb != null && this.dMa != null && this.dLZ != null) {
            if (z || this.dMe != i) {
                this.dMe = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMj);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
                if (i == 2) {
                    this.dLY.setVisibility(8);
                    this.aLy.cancel();
                    this.dLX.clearAnimation();
                    this.dLX.setVisibility(0);
                    this.dMc.setVisibility(0);
                    this.fJr.setVisibility(0);
                    this.fJx.setVisibility(8);
                    this.dMb.startLoading();
                    this.dMa.setVisibility(8);
                    this.dLZ.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMj, 60000L);
                } else if (i == 3) {
                    this.dLY.setVisibility(8);
                    this.dLX.startAnimation(this.aLy);
                    this.dMc.setVisibility(8);
                    this.fJr.setVisibility(8);
                    if (this.fJs != null && this.fJs.aAg() != null && this.fJs.aAg().cTO > 0) {
                        this.fJx.setVisibility(0);
                    }
                    this.dMb.czo();
                    this.dMa.setVisibility(8);
                    this.dLZ.setVisibility(8);
                    if (this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.aCF() != null) {
                        this.fJs.cRf.aCF().video_length.intValue();
                        this.fJs.cRf.aCF().video_duration.intValue();
                        this.fJs.cRf.getTid();
                    }
                } else if (i == 4) {
                    this.dLY.setVisibility(8);
                    this.dLX.startAnimation(this.aLy);
                    this.dMc.setVisibility(8);
                    this.dMb.czp();
                    this.dMa.setVisibility(0);
                    this.dLZ.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMi, 2000L);
                } else {
                    this.dLY.setVisibility(0);
                    this.aLy.cancel();
                    this.dLX.clearAnimation();
                    this.dLX.setVisibility(0);
                    this.dMc.setVisibility(0);
                    this.fJr.setVisibility(0);
                    this.dMb.czp();
                    this.dMa.setVisibility(8);
                    this.dLZ.setVisibility(8);
                }
                if (this.fJs != null && this.fJs.aAg() != null && this.fJs.aAg().cTO > 0) {
                    this.fJr.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.fJs == null || this.fJs.cRf == null || this.fJs.cRf.aCo() == null) {
            this.eNk.setVisibility(8);
            return;
        }
        this.eNk.setVisibility(0);
        buV();
        if (!buR() && l.zT(this.fJs.cRf.getId())) {
            l.a(this.mTextTitle, this.fJs.cRf.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            l.a(this.fJo.getGodReplyContent(), this.fJs.aAg().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.fJs.aAg().aDj();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.fJs.aAg().aCV());
        if (this.fJs.aAg().aDb() && !StringUtils.isNull(this.fJs.aAg().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.fJs.aAg().getTid();
            spannableStringBuilder.append((CharSequence) this.fJs.aAg().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.k.22
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
        this.eNl.setData(this.fJs.aAg());
        this.eNl.setUserAfterClickListener(this.fJD);
        if (this.eNl.getHeaderImg() != null) {
            this.eNl.getHeaderImg().setAfterClickListener(this.fJE);
            if (this.eNl.getIsSimpleThread()) {
                this.eNl.getHeaderImg().setVisibility(8);
                this.fJp.setVisibility(8);
            } else if (this.fJs.aAg() == null || this.fJs.aAg().aCo() == null || this.fJs.aAg().aCo().getPendantData() == null || StringUtils.isNull(this.fJs.aAg().aCo().getPendantData().aAG())) {
                this.fJp.setVisibility(8);
                this.eNl.getHeaderImg().setVisibility(0);
                if (this.fJs.aAg().cTO > 0 && this.fJs.aAg().cTP == 0) {
                    this.fJs.aAg().aCo().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.eNl.getHeaderImg().setData(this.fJs.aAg(), false);
                } else {
                    this.eNl.getHeaderImg().setData(this.fJs.aAg());
                    this.eNl.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.eNl.getHeaderImg().setVisibility(4);
                this.fJp.setVisibility(0);
                this.fJp.setData(this.fJs.aAg());
            }
        }
        this.dLW.setText(aq.stringForVideoTime(this.fJs.cRf.aCF().video_duration.intValue() * 1000));
        this.dMd.setText(String.format(this.cVh.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.fJs.cRf.aCF().play_count.intValue())));
        if (this.eNx != null && this.fJs.aAg() != null) {
            al alVar = new al();
            alVar.setTid(this.fJs.aAg().getTid());
            alVar.setFid(this.fJs.aAg().getFid());
            alVar.setFeedBackReasonMap(this.fJs.feedBackReasonMap);
            this.eNx.setData(alVar);
            this.eNx.setFirstRowSingleColumn(true);
            this.eNx.setVisibility(this.fJv ? 0 : 8);
        }
        this.fJo.setData(this.fJs.aAg().aDM());
        pB(oc(1));
        onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
        if (l.zT(this.fJs.cRf.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.fJs == null || this.fJs.cRf == null || this.fJs.cRf.aCF() == null) {
            z = false;
        } else {
            z = this.fJs.cRf.aCF().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fJz.setVisibility(0);
            if (buW()) {
                this.fJz.setText(String.format("%s | %s", this.cVh.getResources().getString(R.string.nani_video), this.cVh.getResources().getString(R.string.video_preview)));
            } else {
                this.fJz.setText(this.cVh.getString(R.string.nani_video));
            }
        } else if (buW()) {
            this.fJz.setVisibility(0);
            this.fJz.setText(this.cVh.getString(R.string.video_preview));
        } else {
            this.fJz.setVisibility(8);
        }
    }

    private void buU() {
        this.fJA.removeMessages(202);
        this.fJA.removeMessages(203);
    }

    private void aTC() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMj);
    }

    private void buV() {
        aTC();
        buU();
        if (this.dLX != null && this.dLV != null && this.fJq != null) {
            if (com.baidu.tbadk.core.i.azO().isShowImages() && this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.aCF() != null) {
                this.dLX.setPlaceHolder(3);
                this.dLX.startLoad(this.fJs.cRf.aCF().thumbnail_url, 10, false);
                this.dLV.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.fJs.cRf.aCF().video_url;
                if (buW()) {
                    this.mVideoUrl = this.fJs.cRf.aCG().video_url;
                }
                if (StringUtils.isNull(this.fJs.cRf.aCF().video_url)) {
                    p(true, 4);
                }
                if (this.ekZ != null && this.ekZ.cyZ() != null) {
                    this.ekZ.cyZ().aj(this.fJs.cRf);
                }
            } else {
                this.dLV.setVisibility(8);
            }
            this.fJn.reset();
            this.ekY.a(new j.b() { // from class: com.baidu.tieba.card.k.4
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fJn.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fJs);
                    }
                }
            });
            this.ekZ.a(new j.b() { // from class: com.baidu.tieba.card.k.5
                @Override // com.baidu.tieba.play.j.b
                public void by(int i, int i2) {
                    if (i2 >= i) {
                        if (k.this.fJn.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        k.this.b(k.this.fJs);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.cRf != null) {
            bj bjVar = lVar.cRf;
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
        if (lVar == null || lVar.cRf == null || bVar == null) {
            return null;
        }
        bj bjVar = lVar.cRf;
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
            am.setBackgroundResource(this.eNk, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLY, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dLZ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dLW, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMd, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fJx, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMa, R.color.common_color_10014);
            am.setBackgroundColor(this.cem, R.color.cp_bg_line_c);
            if (this.fJz != null) {
                am.setViewTextColor(this.fJz, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fJz, R.drawable.video_play_count_bg);
            }
            if (this.dLZ != null) {
                this.dLZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.fJo.onChangeSkinType();
            if (this.eNx != null) {
                this.eNx.onChangeSkinType();
            }
            this.eNl.onChangeSkinType();
            this.eNm.onChangeSkinType();
            this.eNY.onChangeSkinType();
            this.dLX.setPlaceHolder(3);
            this.fJp.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fJF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fJF);
            this.fJC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fJC);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eNl != null) {
            this.eNl.setPageUniqueId(bdUniqueId);
        }
        if (this.dLX != null) {
            this.dLX.setPageId(bdUniqueId);
        }
        if (this.eNx != null) {
            this.eNx.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.fJu;
    }

    public boolean isPlaying() {
        if (this.fJq == null) {
            return false;
        }
        return this.fJq.isPlaying();
    }

    public void startPlay() {
        if (!this.fJu && this.fJs != null && this.fJs.cRf != null && this.fJs.cRf.aCF() != null && this.fJq != null) {
            if (this.fJn.kU()) {
                this.fJn.resume();
                this.fJy = true;
                return;
            }
            this.fJy = false;
            this.fJq.stopPlayback();
            if (af.X(1, this.mVideoUrl)) {
                p(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new an("c12619").cy("obj_locate", "index").cy("tid", this.fJs.tid));
                    this.mVideoUrl = this.fJs.cRf.aCF().video_url;
                }
                this.fJu = true;
                this.fJq.setVideoPath(this.mVideoUrl, this.fJs.tid);
                if (this.ekY != null) {
                    this.ekY.start();
                }
                buO();
            }
        }
    }

    public void stopPlay() {
        this.fJy = false;
        aTC();
        buU();
        p(true, 1);
        if (this.fJq != null) {
            this.fJq.stopPlayback();
            if (this.ekY != null) {
                this.ekY.stop();
            }
        }
        this.fJu = false;
        this.fJn.stop();
    }

    public View getVideoContainer() {
        return this.dLV;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.fJq == null) {
            return 0;
        }
        return this.fJq.getCurrentPosition();
    }

    public void ki(boolean z) {
        this.fJv = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void pB(int i) {
        if (this.fJs != null && this.fJs.cRf != null) {
            if (i == 1) {
                if (this.fJs.cRf.cTO > 0) {
                    this.eNY.diH.setShowPraiseNum(false);
                    this.eNY.diH.setShareVisible(false);
                    this.fJx.setText(aq.numFormatOverWan(this.fJs.cRf.cTO));
                    this.fJx.setVisibility(0);
                } else {
                    this.eNY.diH.setShowPraiseNum(true);
                    this.eNY.diH.setShareVisible(true);
                    this.fJx.setVisibility(8);
                }
                this.eNY.setData(this.fJs.cRf);
                this.eNm.setVisibility(8);
                this.eNl.fR(false);
                return;
            }
            this.eNY.setVisibility(8);
            this.eNl.fR(true);
            if (this.fJs.cRf.cTO > 0) {
                this.eNm.setShowPraiseNum(false);
                this.eNm.setShareVisible(false);
                this.fJx.setText(aq.numFormatOverWan(this.fJs.cRf.cTO));
                this.fJx.setVisibility(0);
            } else {
                this.eNm.setShowPraiseNum(true);
                this.eNm.setShareVisible(true);
                this.fJx.setVisibility(8);
            }
            if (this.eNm.setData(this.fJs.cRf)) {
                this.fJi.setVisibility(8);
            } else {
                this.fJi.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dLX.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.card.k.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dLX.setOnDrawListener(null);
        }
    }

    private boolean buW() {
        return (this.fJs == null || this.fJs.cRf == null || this.fJs.cRf.aCG() == null || TextUtils.isEmpty(this.fJs.cRf.aCG().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        this.fJn.onDestroy();
    }

    @Override // com.baidu.tieba.card.a
    public void onPause() {
        this.fJn.stop();
    }

    public void onResume() {
        if (this.fJn.kU()) {
            this.fJn.resume();
        }
    }
}
