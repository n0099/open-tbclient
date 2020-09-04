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
import com.baidu.tbadk.util.ah;
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
/* loaded from: classes15.dex */
public class l extends b<com.baidu.tieba.card.data.m> implements View.OnClickListener, com.baidu.tieba.a.e {
    private TbCyberVideoView Zp;
    private int Zv;
    private String agJ;
    private Animation bAi;
    private CyberPlayerManager.OnPreparedListener dLL;
    private CyberPlayerManager.OnErrorListener dLM;
    private CyberPlayerManager.OnCompletionListener dLN;
    private CyberPlayerManager.OnInfoListener dLO;
    private TbPageContext<?> efr;
    private final View.OnClickListener eud;
    private com.baidu.tieba.play.f fDQ;
    public FrameLayout fbZ;
    private TextView fca;
    private TbImageView fcb;
    private ImageView fcc;
    private TextView fcd;
    private View fce;
    private com.baidu.tieba.play.m fcf;
    private View fcg;
    private TextView fch;
    private int fci;
    private TbImageView.a fcj;
    private Runnable fcl;
    private Runnable fcm;
    private TbCyberVideoView.a fcn;
    private View fmI;
    protected LinearLayout fuq;
    public ThreadSourceShareAndPraiseLayout gjQ;
    private RelativeLayout gjc;
    public ThreadUserInfoLayout gjd;
    public ThreadCommentAndPraiseInfoLayout gje;
    private NEGFeedBackView gjp;
    private Handler hjA;
    private VideoLoadingProgressView.a hjB;
    private CustomMessageListener hjC;
    private final View.OnClickListener hjD;
    private final View.OnClickListener hjE;
    private CustomMessageListener hjF;
    private f.a hjG;
    private Animation.AnimationListener hjH;
    private com.baidu.afd.videopaster.d hjn;
    private View hjo;
    public ThreadGodReplyLayout hjp;
    private HeadPendantClickableView hjq;
    private LinearLayout hjr;
    private com.baidu.tieba.card.data.m hjs;
    private int hjt;
    private boolean hju;
    private boolean hjv;
    private boolean hjw;
    private TextView hjx;
    private boolean hjy;
    private TextView hjz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.Zp != null && this.hju) {
            try {
                this.Zp.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int OF = com.baidu.tieba.play.n.dkg().OF(this.mVideoUrl);
            if (OF <= 100 || this.Zp.getDuration() <= OF) {
                OF = 100;
            }
            this.Zv = OF;
            this.hjA.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbG() {
        if (this.hjs != null && this.hjs.dUW != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.hjs.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.ala = this.hjs.dUW.getTid();
            oVar.eVx = this.hjs.dUW.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.hjs.dUW.mRecomSource;
            oVar.lts = this.hjs.dUW.mRecomAbTag;
            oVar.ltn = this.hjs.dUW.mRecomAbTag;
            oVar.lto = this.hjs.dUW.mRecomWeight;
            oVar.ltp = "";
            oVar.dYs = this.hjs.getExtra();
            if (this.hjs.dUW.beW() != null) {
                oVar.ltt = this.hjs.dUW.beW().video_md5;
            }
            com.baidu.tieba.play.h.a(this.hjs.dUW.beW().video_md5, "", "1", oVar, this.Zp.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjp = null;
        this.mSkinType = 3;
        this.hjt = 0;
        this.fci = 1;
        this.hju = false;
        this.hjv = true;
        this.hjw = false;
        this.Zv = 100;
        this.hjy = false;
        this.hjA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.cbK();
                        return;
                    case 203:
                        l.this.cbL();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.Zp != null) {
                    l.this.Zp.setVolume(0.0f, 0.0f);
                }
                l.this.cbF();
            }
        };
        this.dLO = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.hjn.a(false, false, "NEWINDEX")) {
                    l.this.Zp.start();
                }
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.hju = false;
                return true;
            }
        };
        this.hjB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.cbF();
            }
        };
        this.fcj = new TbImageView.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.fcb != null) {
                    l.this.fcb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fcl = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.Zp != null && !l.this.Zp.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.fcm = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.hjC = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.hjs != null && l.this.hjs.dUW != null && videoId.equals(l.this.hjs.dUW.getId())) {
                        l.this.hjn.a(l.this.a(l.this.hjs, bVar));
                    }
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.hjD = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hjs == null) {
                    if (l.this.cbA() != null) {
                        l.this.cbA().a(view, l.this.hjs);
                        return;
                    }
                    return;
                }
                if (view == l.this.gjd.getUserName()) {
                    l.this.hjs.objType = 3;
                } else if (view == l.this.gjd.getHeaderImg()) {
                    l.this.hjs.objType = 4;
                } else {
                    l.this.hjs.objType = 1;
                }
                if (l.this.cbA() != null) {
                    l.this.cbA().a(view, l.this.hjs);
                }
            }
        };
        this.hjE = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hjs != null) {
                    l.this.hjs.objType = 4;
                }
                if (l.this.cbA() != null) {
                    l.this.cbA().a(view, l.this.hjs);
                }
            }
        };
        this.hjF = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.hjw = false;
                }
            }
        };
        this.eud = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hjs != null) {
                    if (l.this.cbA() != null) {
                        l.this.cbA().a(view, l.this.hjs);
                    }
                    if (l.this.hjs.dUW != null && view != l.this.gjQ.eun) {
                        m.GZ(l.this.hjs.dUW.getId());
                        if (!l.this.cbJ()) {
                            m.a(l.this.mTextTitle, l.this.hjs.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                            m.a(l.this.hjp.getGodReplyContent(), l.this.hjs.bce().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.hjG = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void rX() {
                if (l.this.hjs != null && l.this.hjs.dUW != null && l.this.hjs.dUW.beW() != null) {
                    l.this.cbG();
                }
            }
        };
        this.hjH = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.fcb != null) {
                    l.this.fcb.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.efr = tbPageContext;
        View view = getView();
        this.gjc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hjq = (HeadPendantClickableView) this.gjc.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hjq.getHeadView() != null) {
            this.hjq.getHeadView().setIsRound(true);
            this.hjq.getHeadView().setDrawBorder(false);
            this.hjq.getHeadView().setDefaultResource(17170445);
            this.hjq.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjq.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.ds70));
            this.hjq.getHeadView().setPlaceHolder(1);
        }
        this.hjq.setHasPendantStyle();
        if (this.hjq.getPendantView() != null) {
            this.hjq.getPendantView().setIsRound(true);
            this.hjq.getPendantView().setDrawBorder(false);
        }
        this.fcf = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fcf.setLoadingAnimationListener(this.hjB);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gjd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gjp = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.gjp.a(this.gjc, dimens, 0);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.gje.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gje.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gje.setLayoutParams(layoutParams);
        }
        this.gje.setOnClickListener(this);
        this.gje.setReplyTimeVisible(false);
        this.gje.setShowPraiseNum(true);
        this.gje.setNeedAddPraiseIcon(true);
        this.gje.setNeedAddReplyIcon(true);
        this.gje.setShareVisible(true);
        this.gje.setShareReportFrom(3);
        this.gje.setForumAfterClickListener(this.eud);
        this.gje.setFrom(1);
        this.gjQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gjQ.euY.setOnClickListener(this);
        this.gjQ.setFrom(1);
        this.gjQ.setShareReportFrom(3);
        this.gjQ.setForumAfterClickListener(this.eud);
        this.hjo = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fbZ = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbZ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.efr.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fbZ.setLayoutParams(layoutParams2);
        this.fcb = (TbImageView) view.findViewById(R.id.image_video);
        this.fcb.setDefaultErrorResource(0);
        this.fcb.setPlaceHolder(3);
        this.fcb.setGifIconSupport(false);
        this.fcb.setEvent(this.fcj);
        this.fcb.setRadius(com.baidu.adp.lib.util.l.getDimens(this.efr.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fcb;
        TbImageView tbImageView2 = this.fcb;
        tbImageView.setConrers(15);
        this.fcb.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fcb.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fcb.setBorderSurroundContent(true);
        this.fcb.setDrawBorder(true);
        this.fcc = (ImageView) view.findViewById(R.id.image_video_play);
        this.gjc.setOnClickListener(this);
        this.Zp = new TbCyberVideoView(getContext());
        this.Zp.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fbZ.addView(this.Zp.getView(), 0);
        this.Zp.getView().setLayoutParams(layoutParams3);
        this.Zp.setContinuePlayEnable(true);
        this.Zp.setOnPreparedListener(this.dLL);
        this.Zp.setOnInfoListener(this.dLO);
        this.Zp.setOnCompletionListener(this.dLN);
        this.Zp.setOnErrorListener(this.dLM);
        this.Zp.setOnSurfaceDestroyedListener(this.fcn);
        this.fDQ = new com.baidu.tieba.play.f();
        this.fDQ.setPlayer(this.Zp);
        this.fDQ.a(this.hjG);
        this.fca = (TextView) view.findViewById(R.id.text_video_duration);
        this.hjr = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fch = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fcg = view.findViewById(R.id.auto_video_black_mask);
        this.fcd = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fce = view.findViewById(R.id.auto_video_error_background);
        this.fuq = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bAi = AnimationUtils.loadAnimation(this.efr.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bAi.setAnimationListener(this.hjH);
        this.hjp = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hjp.setOnClickListener(this);
        this.fmI = view.findViewById(R.id.divider_line);
        this.hjx = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.Zp.getView().setOnClickListener(this);
        this.hjz = (TextView) view.findViewById(R.id.nani_video_icon);
        this.hjn = new com.baidu.afd.videopaster.d(getContext(), this.fbZ);
        this.hjn.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rM() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rL() {
                if (!l.this.hjy) {
                    l.this.Zp.start();
                } else {
                    l.this.startPlay();
                }
                l.this.hjy = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rK() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rN() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.hjs != null && this.hjs.dUW != null && this.hjs.dUW.edG > 0) {
            if (cbA() != null) {
                cbA().a(view, this.hjs);
            }
            this.efr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.efr.getPageActivity(), this.hjs.dUW.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.beq(), this.hjs.bch())));
            return;
        }
        if (view == this.gjc || view == this.hjp) {
            bX(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.Zp.getView()) {
            if (this.hjs != null) {
                this.hjs.objType = 5;
            }
            if (this.hjs != null && this.hjs.dUW != null && this.hjs.dUW.beW() != null) {
                z = this.hjs.dUW.beW().is_vertical.intValue() == 1;
            }
            if (z) {
                bV(this.Zp.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bW(this.Zp.getView());
            } else {
                bX(getView());
            }
        }
    }

    private void bV(View view) {
        if (cbA() != null) {
            cbA().a(view, this.hjs);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.efr.getPageActivity(), R.string.no_network_guide);
        } else {
            cbH();
        }
    }

    private void bW(View view) {
        if (cbA() != null) {
            cbA().a(view, this.hjs);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.efr.getPageActivity(), R.string.no_network_guide);
        } else {
            cbI();
        }
    }

    private void cbH() {
        if (this.hjs != null && this.hjs.dUW != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.hjs.dUW);
            videoItemData.mRecomExtra = this.hjs.getExtra();
            videoItemData.mRecomAbTag = this.hjs.ccl();
            videoItemData.mRecomSource = this.hjs.getSource();
            videoItemData.mRecomWeight = this.hjs.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.hjs.bch(), "index");
            if (this.hjs.dUW.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.hjs.dUW.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cbI() {
        if (this.hjs != null && this.hjs.dUW != null && this.hjs.dUW.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.hjs.dUW);
            videoSerializeVideoThreadInfo.source = this.hjs.getSource();
            videoSerializeVideoThreadInfo.extra = this.hjs.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.hjs.ccl();
            videoSerializeVideoThreadInfo.weight = this.hjs.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fuq.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fuq.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.efr.getPageActivity(), str, this.hjs.dUW.getTid(), m.beq(), this.hjs.bch(), videoSerializeVideoThreadInfo);
            if (this.hjs.bce() != null && this.hjs.bce().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.hjs.bce().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bX(View view) {
        if (this.hjs != null) {
            this.hjs.objType = 1;
        }
        if (cbA() != null) {
            cbA().a(view, this.hjs);
        }
        if (this.hjs != null && this.hjs.dUW != null) {
            if (!cbJ()) {
                m.GZ(this.hjs.dUW.getId());
                m.a(this.mTextTitle, this.hjs.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.efr.getPageActivity()).createFromThreadCfg(this.hjs.dUW, null, m.beq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hjs.bch());
            addLocateParam.setVideo_source(this.hjs.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.hjs.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.hjs.dUW.getFid()));
            addLocateParam.setForumName(this.hjs.dUW.beI());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.hjp) {
                addLocateParam.setJumpGodReply(true);
            }
            this.efr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbJ() {
        return this.hjs.hns && !this.hjs.hnx;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.hjs = mVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbK() {
        this.hjA.removeMessages(202);
        if (this.Zp.getCurrentPositionSync() > this.Zv) {
            v(false, 3);
            this.hjA.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hjA.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbL() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hjA.removeMessages(203);
        int currentPositionSync = this.Zp.getCurrentPositionSync();
        if (currentPositionSync != this.hjt) {
            this.hjt = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.hjA.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fcc != null && this.fcb != null && this.fcg != null && this.fcf != null && this.fce != null && this.fcd != null) {
            if (z || this.fci != i) {
                this.fci = i;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcm);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcl);
                if (i == 2) {
                    this.fcc.setVisibility(8);
                    this.bAi.cancel();
                    this.fcb.clearAnimation();
                    this.fcb.setVisibility(0);
                    this.fcg.setVisibility(0);
                    this.hjr.setVisibility(0);
                    this.hjx.setVisibility(8);
                    this.fcf.startLoading();
                    this.fce.setVisibility(8);
                    this.fcd.setVisibility(8);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fcm, 60000L);
                } else if (i == 3) {
                    this.fcc.setVisibility(8);
                    this.fcb.startAnimation(this.bAi);
                    this.fcg.setVisibility(8);
                    this.hjr.setVisibility(8);
                    if (this.hjs != null && this.hjs.bce() != null && this.hjs.bce().edG > 0) {
                        this.hjx.setVisibility(0);
                    }
                    this.fcf.dkc();
                    this.fce.setVisibility(8);
                    this.fcd.setVisibility(8);
                    if (this.hjs != null && this.hjs.dUW != null && this.hjs.dUW.beW() != null) {
                        this.hjs.dUW.beW().video_length.intValue();
                        this.hjs.dUW.beW().video_duration.intValue();
                        this.hjs.dUW.getTid();
                    }
                } else if (i == 4) {
                    this.fcc.setVisibility(8);
                    this.fcb.startAnimation(this.bAi);
                    this.fcg.setVisibility(8);
                    this.fcf.dkd();
                    this.fce.setVisibility(0);
                    this.fcd.setVisibility(0);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fcl, 2000L);
                } else {
                    this.fcc.setVisibility(0);
                    this.bAi.cancel();
                    this.fcb.clearAnimation();
                    this.fcb.setVisibility(0);
                    this.fcg.setVisibility(0);
                    this.hjr.setVisibility(0);
                    this.fcf.dkd();
                    this.fce.setVisibility(8);
                    this.fcd.setVisibility(8);
                }
                if (this.hjs != null && this.hjs.bce() != null && this.hjs.bce().edG > 0) {
                    this.hjr.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.hjs == null || this.hjs.dUW == null || this.hjs.dUW.beE() == null) {
            this.gjc.setVisibility(8);
            return;
        }
        this.gjc.setVisibility(0);
        cbN();
        if (!cbJ() && m.Ha(this.hjs.dUW.getId())) {
            m.a(this.mTextTitle, this.hjs.dUW.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hjp.getGodReplyContent(), this.hjs.bce().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        this.hjs.bce().bfC();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hjs.bce().bfo());
        if (this.hjs.bce().bfu() && !StringUtils.isNull(this.hjs.bce().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.hjs.bce().getTid();
            spannableStringBuilder.append((CharSequence) this.hjs.bce().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dD("obj_source", "0"));
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
        this.gjd.setData(this.hjs.bce());
        this.gjd.setUserAfterClickListener(this.hjD);
        if (this.gjd.getHeaderImg() != null) {
            this.gjd.getHeaderImg().setAfterClickListener(this.hjE);
            if (this.gjd.getIsSimpleThread()) {
                this.gjd.getHeaderImg().setVisibility(8);
                this.hjq.setVisibility(8);
            } else if (this.hjs.bce() == null || this.hjs.bce().beE() == null || this.hjs.bce().beE().getPendantData() == null || StringUtils.isNull(this.hjs.bce().beE().getPendantData().bcA())) {
                this.hjq.setVisibility(8);
                this.gjd.getHeaderImg().setVisibility(0);
                if (this.hjs.bce().edG > 0 && this.hjs.bce().edH == 0) {
                    this.hjs.bce().beE().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.gjd.getHeaderImg().setData(this.hjs.bce(), false);
                } else {
                    this.gjd.getHeaderImg().setData(this.hjs.bce());
                    this.gjd.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.gjd.getHeaderImg().setVisibility(4);
                this.hjq.setVisibility(0);
                this.hjq.setData(this.hjs.bce());
            }
        }
        this.fca.setText(at.stringForVideoTime(this.hjs.dUW.beW().video_duration.intValue() * 1000));
        this.fch.setText(String.format(this.efr.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hjs.dUW.beW().play_count.intValue())));
        if (this.gjp != null && this.hjs.bce() != null) {
            ar arVar = new ar();
            arVar.setTid(this.hjs.bce().getTid());
            arVar.setFid(this.hjs.bce().getFid());
            arVar.setNid(this.hjs.bce().getNid());
            arVar.setFeedBackReasonMap(this.hjs.feedBackReasonMap);
            this.gjp.setData(arVar);
            this.gjp.setFirstRowSingleColumn(true);
            this.gjp.setVisibility(this.hjv ? 0 : 8);
        }
        this.hjp.setData(this.hjs.bce().bgh());
        tB(rY(1));
        onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
        if (m.Ha(this.hjs.dUW.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.hjs == null || this.hjs.dUW == null || this.hjs.dUW.beW() == null) {
            z = false;
        } else {
            z = this.hjs.dUW.beW().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hjz.setVisibility(0);
            if (cbO()) {
                this.hjz.setText(String.format("%s | %s", this.efr.getResources().getString(R.string.nani_video), this.efr.getResources().getString(R.string.video_preview)));
            } else {
                this.hjz.setText(this.efr.getString(R.string.nani_video));
            }
        } else if (cbO()) {
            this.hjz.setVisibility(0);
            this.hjz.setText(this.efr.getString(R.string.video_preview));
        } else {
            this.hjz.setVisibility(8);
        }
    }

    private void cbM() {
        this.hjA.removeMessages(202);
        this.hjA.removeMessages(203);
    }

    private void bxh() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcl);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcm);
    }

    private void cbN() {
        bxh();
        cbM();
        if (this.fcb != null && this.fbZ != null && this.Zp != null) {
            if (com.baidu.tbadk.core.k.bbM().isShowImages() && this.hjs != null && this.hjs.dUW != null && this.hjs.dUW.beW() != null) {
                this.fcb.setPlaceHolder(3);
                this.fcb.startLoad(this.hjs.dUW.beW().thumbnail_url, 10, false);
                this.fbZ.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.hjs.dUW.beW().video_url;
                if (cbO()) {
                    this.mVideoUrl = this.hjs.dUW.beX().video_url;
                }
                if (StringUtils.isNull(this.hjs.dUW.beW().video_url)) {
                    v(true, 4);
                }
                this.Zp.setThreadDataForStatistic(this.hjs.dUW);
            } else {
                this.fbZ.setVisibility(8);
            }
            this.hjn.reset();
            this.fDQ.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void bX(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.hjn.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.hjs);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.m mVar) {
        if (mVar != null && mVar.dUW != null) {
            bw bwVar = mVar.dUW;
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
        if (mVar == null || mVar.dUW == null || bVar == null) {
            return null;
        }
        bw bwVar = mVar.dUW;
        int rR = bVar.rR();
        int rS = bVar.rS();
        int rQ = bVar.rQ();
        if (rQ != -1) {
            i = rR != -1 ? (rQ - rR) - 1 : -1;
            if (rS != -1) {
                i4 = (rS - rQ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo beW = bwVar.beW();
        if (beW != null) {
            i3 = beW.video_width.intValue();
            i2 = beW.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.beI());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rQ + 1, i3, i2);
        a.u(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gjc, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fcc, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
            ap.setViewTextColor(this.fca, R.color.cp_cont_a);
            ap.setViewTextColor(this.fch, R.color.cp_cont_a);
            ap.setViewTextColor(this.hjx, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fce, R.color.common_color_10014);
            ap.setBackgroundColor(this.fmI, R.color.cp_bg_line_c);
            if (this.hjz != null) {
                ap.setViewTextColor(this.hjz, R.color.cp_cont_a);
                ap.setBackgroundResource(this.hjz, R.drawable.video_play_count_bg);
            }
            if (this.fcd != null) {
                this.fcd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.hjp.onChangeSkinType();
            if (this.gjp != null) {
                this.gjp.onChangeSkinType();
            }
            this.gjd.onChangeSkinType();
            this.gje.onChangeSkinType();
            this.gjQ.onChangeSkinType();
            this.fcb.setPlaceHolder(3);
            this.hjq.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hjF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjF);
            this.hjC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjC);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gjd != null) {
            this.gjd.setPageUniqueId(bdUniqueId);
        }
        if (this.fcb != null) {
            this.fcb.setPageId(bdUniqueId);
        }
        if (this.gjp != null) {
            this.gjp.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.hju;
    }

    public boolean isPlaying() {
        if (this.Zp == null) {
            return false;
        }
        return this.Zp.isPlaying();
    }

    public void startPlay() {
        if (!this.hju && this.hjs != null && this.hjs.dUW != null && this.hjs.dUW.beW() != null && this.Zp != null) {
            if (this.hjn.rv()) {
                this.hjn.resume();
                this.hjy = true;
                return;
            }
            this.hjy = false;
            this.Zp.stopPlayback();
            if (ah.as(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dD("obj_locate", "index").dD("tid", this.hjs.tid));
                    this.mVideoUrl = this.hjs.dUW.beW().video_url;
                }
                this.hju = true;
                this.Zp.setVideoPath(this.mVideoUrl, this.hjs.tid);
                if (this.fDQ != null) {
                    this.fDQ.start();
                }
                cbG();
            }
        }
    }

    public void stopPlay() {
        this.hjy = false;
        bxh();
        cbM();
        v(true, 1);
        if (this.Zp != null) {
            this.Zp.stopPlayback();
            if (this.fDQ != null) {
                this.fDQ.stop();
            }
        }
        this.hju = false;
        this.hjn.stop();
    }

    public View getVideoContainer() {
        return this.fbZ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Zp == null) {
            return 0;
        }
        return this.Zp.getCurrentPosition();
    }

    public void nf(boolean z) {
        this.hjv = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void tB(int i) {
        if (this.hjs != null && this.hjs.dUW != null) {
            if (i == 1) {
                if (this.hjs.dUW.edG > 0) {
                    this.gjQ.euY.setShowPraiseNum(false);
                    this.gjQ.euY.setShareVisible(false);
                    this.hjx.setText(at.numFormatOverWan(this.hjs.dUW.edG));
                    this.hjx.setVisibility(0);
                } else {
                    this.gjQ.euY.setShowPraiseNum(true);
                    this.gjQ.euY.setShareVisible(true);
                    this.hjx.setVisibility(8);
                }
                this.gjQ.setData(this.hjs.dUW);
                this.gje.setVisibility(8);
                this.gjd.iC(false);
                return;
            }
            this.gjQ.setVisibility(8);
            this.gjd.iC(true);
            if (this.hjs.dUW.edG > 0) {
                this.gje.setShowPraiseNum(false);
                this.gje.setShareVisible(false);
                this.hjx.setText(at.numFormatOverWan(this.hjs.dUW.edG));
                this.hjx.setVisibility(0);
            } else {
                this.gje.setShowPraiseNum(true);
                this.gje.setShareVisible(true);
                this.hjx.setVisibility(8);
            }
            if (this.gje.setData(this.hjs.dUW)) {
                this.hjo.setVisibility(8);
            } else {
                this.hjo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAB().au(this.agJ, i);
    }

    private boolean cbO() {
        return (this.hjs == null || this.hjs.dUW == null || this.hjs.dUW.beX() == null || TextUtils.isEmpty(this.hjs.dUW.beX().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.hjn.onDestroy();
    }
}
