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
    private TbCyberVideoView Zn;
    private int Zt;
    private String agH;
    private Animation bAf;
    private CyberPlayerManager.OnPreparedListener dLH;
    private CyberPlayerManager.OnErrorListener dLI;
    private CyberPlayerManager.OnCompletionListener dLJ;
    private CyberPlayerManager.OnInfoListener dLK;
    private TbPageContext<?> efn;
    private final View.OnClickListener etZ;
    private com.baidu.tieba.play.f fDM;
    public FrameLayout fbV;
    private TextView fbW;
    private TbImageView fbX;
    private ImageView fbY;
    private TextView fbZ;
    private View fca;
    private com.baidu.tieba.play.m fcb;
    private View fcc;
    private TextView fcd;
    private int fce;
    private TbImageView.a fcf;
    private Runnable fch;
    private Runnable fci;
    private TbCyberVideoView.a fcj;
    private View fmE;
    protected LinearLayout fum;
    private RelativeLayout giY;
    public ThreadUserInfoLayout giZ;
    public ThreadSourceShareAndPraiseLayout gjM;
    public ThreadCommentAndPraiseInfoLayout gja;
    private NEGFeedBackView gjl;
    private final View.OnClickListener hjA;
    private CustomMessageListener hjB;
    private f.a hjC;
    private Animation.AnimationListener hjD;
    private com.baidu.afd.videopaster.d hjj;
    private View hjk;
    public ThreadGodReplyLayout hjl;
    private HeadPendantClickableView hjm;
    private LinearLayout hjn;
    private com.baidu.tieba.card.data.m hjo;
    private int hjp;
    private boolean hjq;
    private boolean hjr;
    private boolean hjs;
    private TextView hjt;
    private boolean hju;
    private TextView hjv;
    private Handler hjw;
    private VideoLoadingProgressView.a hjx;
    private CustomMessageListener hjy;
    private final View.OnClickListener hjz;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        if (this.Zn != null && this.hjq) {
            try {
                this.Zn.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int OE = com.baidu.tieba.play.n.dkd().OE(this.mVideoUrl);
            if (OE <= 100 || this.Zn.getDuration() <= OE) {
                OE = 100;
            }
            this.Zt = OE;
            this.hjw.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.hjo != null && this.hjo.dUS != null) {
            com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = this.hjo.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            oVar.akY = this.hjo.dUS.getTid();
            oVar.eVt = this.hjo.dUS.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.hjo.dUS.mRecomSource;
            oVar.ltg = this.hjo.dUS.mRecomAbTag;
            oVar.ltc = this.hjo.dUS.mRecomAbTag;
            oVar.ltd = this.hjo.dUS.mRecomWeight;
            oVar.lte = "";
            oVar.dYo = this.hjo.getExtra();
            if (this.hjo.dUS.beW() != null) {
                oVar.lth = this.hjo.dUS.beW().video_md5;
            }
            com.baidu.tieba.play.h.a(this.hjo.dUS.beW().video_md5, "", "1", oVar, this.Zn.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjl = null;
        this.mSkinType = 3;
        this.hjp = 0;
        this.fce = 1;
        this.hjq = false;
        this.hjr = true;
        this.hjs = false;
        this.Zt = 100;
        this.hju = false;
        this.hjw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.cbJ();
                        return;
                    case 203:
                        l.this.cbK();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (l.this.Zn != null) {
                    l.this.Zn.setVolume(0.0f, 0.0f);
                }
                l.this.cbE();
            }
        };
        this.dLK = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.card.l.14
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                if (!l.this.hjj.a(false, false, "NEWINDEX")) {
                    l.this.Zn.start();
                }
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                l.this.v(true, 4);
                l.this.hjq = false;
                return true;
            }
        };
        this.hjx = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.cbE();
            }
        };
        this.fcf = new TbImageView.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.fbX != null) {
                    l.this.fbX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fch = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.Zn != null && !l.this.Zn.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.fci = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.hjy = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.hjo != null && l.this.hjo.dUS != null && videoId.equals(l.this.hjo.dUS.getId())) {
                        l.this.hjj.a(l.this.a(l.this.hjo, bVar));
                    }
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.l.6
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.hjz = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hjo == null) {
                    if (l.this.cbz() != null) {
                        l.this.cbz().a(view, l.this.hjo);
                        return;
                    }
                    return;
                }
                if (view == l.this.giZ.getUserName()) {
                    l.this.hjo.objType = 3;
                } else if (view == l.this.giZ.getHeaderImg()) {
                    l.this.hjo.objType = 4;
                } else {
                    l.this.hjo.objType = 1;
                }
                if (l.this.cbz() != null) {
                    l.this.cbz().a(view, l.this.hjo);
                }
            }
        };
        this.hjA = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hjo != null) {
                    l.this.hjo.objType = 4;
                }
                if (l.this.cbz() != null) {
                    l.this.cbz().a(view, l.this.hjo);
                }
            }
        };
        this.hjB = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.hjs = false;
                }
            }
        };
        this.etZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hjo != null) {
                    if (l.this.cbz() != null) {
                        l.this.cbz().a(view, l.this.hjo);
                    }
                    if (l.this.hjo.dUS != null && view != l.this.gjM.euj) {
                        m.GY(l.this.hjo.dUS.getId());
                        if (!l.this.cbI()) {
                            m.a(l.this.mTextTitle, l.this.hjo.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                            m.a(l.this.hjl.getGodReplyContent(), l.this.hjo.bce().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.hjC = new f.a() { // from class: com.baidu.tieba.card.l.11
            @Override // com.baidu.tieba.play.f.a
            public void rX() {
                if (l.this.hjo != null && l.this.hjo.dUS != null && l.this.hjo.dUS.beW() != null) {
                    l.this.cbF();
                }
            }
        };
        this.hjD = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.fbX != null) {
                    l.this.fbX.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.efn = tbPageContext;
        View view = getView();
        this.giY = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hjm = (HeadPendantClickableView) this.giY.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hjm.getHeadView() != null) {
            this.hjm.getHeadView().setIsRound(true);
            this.hjm.getHeadView().setDrawBorder(false);
            this.hjm.getHeadView().setDefaultResource(17170445);
            this.hjm.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjm.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.ds70));
            this.hjm.getHeadView().setPlaceHolder(1);
        }
        this.hjm.setHasPendantStyle();
        if (this.hjm.getPendantView() != null) {
            this.hjm.getPendantView().setIsRound(true);
            this.hjm.getPendantView().setDrawBorder(false);
        }
        this.fcb = new com.baidu.tieba.play.m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fcb.setLoadingAnimationListener(this.hjx);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.giZ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gjl = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.gjl.a(this.giY, dimens, 0);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.gja.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gja.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gja.setLayoutParams(layoutParams);
        }
        this.gja.setOnClickListener(this);
        this.gja.setReplyTimeVisible(false);
        this.gja.setShowPraiseNum(true);
        this.gja.setNeedAddPraiseIcon(true);
        this.gja.setNeedAddReplyIcon(true);
        this.gja.setShareVisible(true);
        this.gja.setShareReportFrom(3);
        this.gja.setForumAfterClickListener(this.etZ);
        this.gja.setFrom(1);
        this.gjM = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gjM.euU.setOnClickListener(this);
        this.gjM.setFrom(1);
        this.gjM.setShareReportFrom(3);
        this.gjM.setForumAfterClickListener(this.etZ);
        this.hjk = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fbV = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbV.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.efn.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.fbV.setLayoutParams(layoutParams2);
        this.fbX = (TbImageView) view.findViewById(R.id.image_video);
        this.fbX.setDefaultErrorResource(0);
        this.fbX.setPlaceHolder(3);
        this.fbX.setGifIconSupport(false);
        this.fbX.setEvent(this.fcf);
        this.fbX.setRadius(com.baidu.adp.lib.util.l.getDimens(this.efn.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.fbX;
        TbImageView tbImageView2 = this.fbX;
        tbImageView.setConrers(15);
        this.fbX.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fbX.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.fbX.setBorderSurroundContent(true);
        this.fbX.setDrawBorder(true);
        this.fbY = (ImageView) view.findViewById(R.id.image_video_play);
        this.giY.setOnClickListener(this);
        this.Zn = new TbCyberVideoView(getContext());
        this.Zn.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.fbV.addView(this.Zn.getView(), 0);
        this.Zn.getView().setLayoutParams(layoutParams3);
        this.Zn.setContinuePlayEnable(true);
        this.Zn.setOnPreparedListener(this.dLH);
        this.Zn.setOnInfoListener(this.dLK);
        this.Zn.setOnCompletionListener(this.dLJ);
        this.Zn.setOnErrorListener(this.dLI);
        this.Zn.setOnSurfaceDestroyedListener(this.fcj);
        this.fDM = new com.baidu.tieba.play.f();
        this.fDM.setPlayer(this.Zn);
        this.fDM.a(this.hjC);
        this.fbW = (TextView) view.findViewById(R.id.text_video_duration);
        this.hjn = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fcd = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fcc = view.findViewById(R.id.auto_video_black_mask);
        this.fbZ = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fca = view.findViewById(R.id.auto_video_error_background);
        this.fum = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.bAf = AnimationUtils.loadAnimation(this.efn.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.bAf.setAnimationListener(this.hjD);
        this.hjl = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hjl.setOnClickListener(this);
        this.fmE = view.findViewById(R.id.divider_line);
        this.hjt = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.Zn.getView().setOnClickListener(this);
        this.hjv = (TextView) view.findViewById(R.id.nani_video_icon);
        this.hjj = new com.baidu.afd.videopaster.d(getContext(), this.fbV);
        this.hjj.a(new d.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.afd.videopaster.d.a
            public void rM() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rL() {
                if (!l.this.hju) {
                    l.this.Zn.start();
                } else {
                    l.this.startPlay();
                }
                l.this.hju = false;
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
        if (this.hjo != null && this.hjo.dUS != null && this.hjo.dUS.edC > 0) {
            if (cbz() != null) {
                cbz().a(view, this.hjo);
            }
            this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.efn.getPageActivity(), this.hjo.dUS.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.beq(), this.hjo.bch())));
            return;
        }
        if (view == this.giY || view == this.hjl) {
            bX(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.Zn.getView()) {
            if (this.hjo != null) {
                this.hjo.objType = 5;
            }
            if (this.hjo != null && this.hjo.dUS != null && this.hjo.dUS.beW() != null) {
                z = this.hjo.dUS.beW().is_vertical.intValue() == 1;
            }
            if (z) {
                bV(this.Zn.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bW(this.Zn.getView());
            } else {
                bX(getView());
            }
        }
    }

    private void bV(View view) {
        if (cbz() != null) {
            cbz().a(view, this.hjo);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.efn.getPageActivity(), R.string.no_network_guide);
        } else {
            cbG();
        }
    }

    private void bW(View view) {
        if (cbz() != null) {
            cbz().a(view, this.hjo);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.efn.getPageActivity(), R.string.no_network_guide);
        } else {
            cbH();
        }
    }

    private void cbG() {
        if (this.hjo != null && this.hjo.dUS != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.hjo.dUS);
            videoItemData.mRecomExtra = this.hjo.getExtra();
            videoItemData.mRecomAbTag = this.hjo.cck();
            videoItemData.mRecomSource = this.hjo.getSource();
            videoItemData.mRecomWeight = this.hjo.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.hjo.bch(), "index");
            if (this.hjo.dUS.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.hjo.dUS.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cbH() {
        if (this.hjo != null && this.hjo.dUS != null && this.hjo.dUS.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.hjo.dUS);
            videoSerializeVideoThreadInfo.source = this.hjo.getSource();
            videoSerializeVideoThreadInfo.extra = this.hjo.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.hjo.cck();
            videoSerializeVideoThreadInfo.weight = this.hjo.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fum.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fum.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!at.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.efn.getPageActivity(), str, this.hjo.dUS.getTid(), m.beq(), this.hjo.bch(), videoSerializeVideoThreadInfo);
            if (this.hjo.bce() != null && this.hjo.bce().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.hjo.bce().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bX(View view) {
        if (this.hjo != null) {
            this.hjo.objType = 1;
        }
        if (cbz() != null) {
            cbz().a(view, this.hjo);
        }
        if (this.hjo != null && this.hjo.dUS != null) {
            if (!cbI()) {
                m.GY(this.hjo.dUS.getId());
                m.a(this.mTextTitle, this.hjo.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.efn.getPageActivity()).createFromThreadCfg(this.hjo.dUS, null, m.beq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hjo.bch());
            addLocateParam.setVideo_source(this.hjo.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.hjo.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.hjo.dUS.getFid()));
            addLocateParam.setForumName(this.hjo.dUS.beI());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.hjl) {
                addLocateParam.setJumpGodReply(true);
            }
            this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbI() {
        return this.hjo.hno && !this.hjo.hnt;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.hjo = mVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbJ() {
        this.hjw.removeMessages(202);
        if (this.Zn.getCurrentPositionSync() > this.Zt) {
            v(false, 3);
            this.hjw.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hjw.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbK() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hjw.removeMessages(203);
        int currentPositionSync = this.Zn.getCurrentPositionSync();
        if (currentPositionSync != this.hjp) {
            this.hjp = currentPositionSync;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.hjw.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fbY != null && this.fbX != null && this.fcc != null && this.fcb != null && this.fca != null && this.fbZ != null) {
            if (z || this.fce != i) {
                this.fce = i;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fci);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fch);
                if (i == 2) {
                    this.fbY.setVisibility(8);
                    this.bAf.cancel();
                    this.fbX.clearAnimation();
                    this.fbX.setVisibility(0);
                    this.fcc.setVisibility(0);
                    this.hjn.setVisibility(0);
                    this.hjt.setVisibility(8);
                    this.fcb.startLoading();
                    this.fca.setVisibility(8);
                    this.fbZ.setVisibility(8);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fci, 60000L);
                } else if (i == 3) {
                    this.fbY.setVisibility(8);
                    this.fbX.startAnimation(this.bAf);
                    this.fcc.setVisibility(8);
                    this.hjn.setVisibility(8);
                    if (this.hjo != null && this.hjo.bce() != null && this.hjo.bce().edC > 0) {
                        this.hjt.setVisibility(0);
                    }
                    this.fcb.djZ();
                    this.fca.setVisibility(8);
                    this.fbZ.setVisibility(8);
                    if (this.hjo != null && this.hjo.dUS != null && this.hjo.dUS.beW() != null) {
                        this.hjo.dUS.beW().video_length.intValue();
                        this.hjo.dUS.beW().video_duration.intValue();
                        this.hjo.dUS.getTid();
                    }
                } else if (i == 4) {
                    this.fbY.setVisibility(8);
                    this.fbX.startAnimation(this.bAf);
                    this.fcc.setVisibility(8);
                    this.fcb.dka();
                    this.fca.setVisibility(0);
                    this.fbZ.setVisibility(0);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.fch, 2000L);
                } else {
                    this.fbY.setVisibility(0);
                    this.bAf.cancel();
                    this.fbX.clearAnimation();
                    this.fbX.setVisibility(0);
                    this.fcc.setVisibility(0);
                    this.hjn.setVisibility(0);
                    this.fcb.dka();
                    this.fca.setVisibility(8);
                    this.fbZ.setVisibility(8);
                }
                if (this.hjo != null && this.hjo.bce() != null && this.hjo.bce().edC > 0) {
                    this.hjn.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.hjo == null || this.hjo.dUS == null || this.hjo.dUS.beE() == null) {
            this.giY.setVisibility(8);
            return;
        }
        this.giY.setVisibility(0);
        cbM();
        if (!cbI() && m.GZ(this.hjo.dUS.getId())) {
            m.a(this.mTextTitle, this.hjo.dUS.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hjl.getGodReplyContent(), this.hjo.bce().getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        this.hjo.bce().bfC();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hjo.bce().bfo());
        if (this.hjo.bce().bfu() && !StringUtils.isNull(this.hjo.bce().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.hjo.bce().getTid();
            spannableStringBuilder.append((CharSequence) this.hjo.bce().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.20
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
        this.giZ.setData(this.hjo.bce());
        this.giZ.setUserAfterClickListener(this.hjz);
        if (this.giZ.getHeaderImg() != null) {
            this.giZ.getHeaderImg().setAfterClickListener(this.hjA);
            if (this.giZ.getIsSimpleThread()) {
                this.giZ.getHeaderImg().setVisibility(8);
                this.hjm.setVisibility(8);
            } else if (this.hjo.bce() == null || this.hjo.bce().beE() == null || this.hjo.bce().beE().getPendantData() == null || StringUtils.isNull(this.hjo.bce().beE().getPendantData().bcA())) {
                this.hjm.setVisibility(8);
                this.giZ.getHeaderImg().setVisibility(0);
                if (this.hjo.bce().edC > 0 && this.hjo.bce().edD == 0) {
                    this.hjo.bce().beE().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.giZ.getHeaderImg().setData(this.hjo.bce(), false);
                } else {
                    this.giZ.getHeaderImg().setData(this.hjo.bce());
                    this.giZ.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.giZ.getHeaderImg().setVisibility(4);
                this.hjm.setVisibility(0);
                this.hjm.setData(this.hjo.bce());
            }
        }
        this.fbW.setText(at.stringForVideoTime(this.hjo.dUS.beW().video_duration.intValue() * 1000));
        this.fcd.setText(String.format(this.efn.getResources().getString(R.string.play_count), at.numFormatOverWan(this.hjo.dUS.beW().play_count.intValue())));
        if (this.gjl != null && this.hjo.bce() != null) {
            ar arVar = new ar();
            arVar.setTid(this.hjo.bce().getTid());
            arVar.setFid(this.hjo.bce().getFid());
            arVar.setNid(this.hjo.bce().getNid());
            arVar.setFeedBackReasonMap(this.hjo.feedBackReasonMap);
            this.gjl.setData(arVar);
            this.gjl.setFirstRowSingleColumn(true);
            this.gjl.setVisibility(this.hjr ? 0 : 8);
        }
        this.hjl.setData(this.hjo.bce().bgh());
        tB(rY(1));
        onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
        if (m.GZ(this.hjo.dUS.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.hjo == null || this.hjo.dUS == null || this.hjo.dUS.beW() == null) {
            z = false;
        } else {
            z = this.hjo.dUS.beW().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hjv.setVisibility(0);
            if (cbN()) {
                this.hjv.setText(String.format("%s | %s", this.efn.getResources().getString(R.string.nani_video), this.efn.getResources().getString(R.string.video_preview)));
            } else {
                this.hjv.setText(this.efn.getString(R.string.nani_video));
            }
        } else if (cbN()) {
            this.hjv.setVisibility(0);
            this.hjv.setText(this.efn.getString(R.string.video_preview));
        } else {
            this.hjv.setVisibility(8);
        }
    }

    private void cbL() {
        this.hjw.removeMessages(202);
        this.hjw.removeMessages(203);
    }

    private void bxg() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fch);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fci);
    }

    private void cbM() {
        bxg();
        cbL();
        if (this.fbX != null && this.fbV != null && this.Zn != null) {
            if (com.baidu.tbadk.core.k.bbM().isShowImages() && this.hjo != null && this.hjo.dUS != null && this.hjo.dUS.beW() != null) {
                this.fbX.setPlaceHolder(3);
                this.fbX.startLoad(this.hjo.dUS.beW().thumbnail_url, 10, false);
                this.fbV.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.hjo.dUS.beW().video_url;
                if (cbN()) {
                    this.mVideoUrl = this.hjo.dUS.beX().video_url;
                }
                if (StringUtils.isNull(this.hjo.dUS.beW().video_url)) {
                    v(true, 4);
                }
                this.Zn.setThreadDataForStatistic(this.hjo.dUS);
            } else {
                this.fbV.setVisibility(8);
            }
            this.hjj.reset();
            this.fDM.a(new f.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.f.b
                public void bX(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.hjj.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.hjo);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.m mVar) {
        if (mVar != null && mVar.dUS != null) {
            bw bwVar = mVar.dUS;
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
        if (mVar == null || mVar.dUS == null || bVar == null) {
            return null;
        }
        bw bwVar = mVar.dUS;
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
            ap.setBackgroundResource(this.giY, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fbY, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fbZ, R.color.cp_cont_a);
            ap.setViewTextColor(this.fbW, R.color.cp_cont_a);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
            ap.setViewTextColor(this.hjt, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fca, R.color.common_color_10014);
            ap.setBackgroundColor(this.fmE, R.color.cp_bg_line_c);
            if (this.hjv != null) {
                ap.setViewTextColor(this.hjv, R.color.cp_cont_a);
                ap.setBackgroundResource(this.hjv, R.drawable.video_play_count_bg);
            }
            if (this.fbZ != null) {
                this.fbZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.hjl.onChangeSkinType();
            if (this.gjl != null) {
                this.gjl.onChangeSkinType();
            }
            this.giZ.onChangeSkinType();
            this.gja.onChangeSkinType();
            this.gjM.onChangeSkinType();
            this.fbX.setPlaceHolder(3);
            this.hjm.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.hjB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjB);
            this.hjy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hjy);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.giZ != null) {
            this.giZ.setPageUniqueId(bdUniqueId);
        }
        if (this.fbX != null) {
            this.fbX.setPageId(bdUniqueId);
        }
        if (this.gjl != null) {
            this.gjl.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.hjq;
    }

    public boolean isPlaying() {
        if (this.Zn == null) {
            return false;
        }
        return this.Zn.isPlaying();
    }

    public void startPlay() {
        if (!this.hjq && this.hjo != null && this.hjo.dUS != null && this.hjo.dUS.beW() != null && this.Zn != null) {
            if (this.hjj.rv()) {
                this.hjj.resume();
                this.hju = true;
                return;
            }
            this.hju = false;
            this.Zn.stopPlayback();
            if (ah.as(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new aq("c12619").dD("obj_locate", "index").dD("tid", this.hjo.tid));
                    this.mVideoUrl = this.hjo.dUS.beW().video_url;
                }
                this.hjq = true;
                this.Zn.setVideoPath(this.mVideoUrl, this.hjo.tid);
                if (this.fDM != null) {
                    this.fDM.start();
                }
                cbF();
            }
        }
    }

    public void stopPlay() {
        this.hju = false;
        bxg();
        cbL();
        v(true, 1);
        if (this.Zn != null) {
            this.Zn.stopPlayback();
            if (this.fDM != null) {
                this.fDM.stop();
            }
        }
        this.hjq = false;
        this.hjj.stop();
    }

    public View getVideoContainer() {
        return this.fbV;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Zn == null) {
            return 0;
        }
        return this.Zn.getCurrentPosition();
    }

    public void nd(boolean z) {
        this.hjr = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void tB(int i) {
        if (this.hjo != null && this.hjo.dUS != null) {
            if (i == 1) {
                if (this.hjo.dUS.edC > 0) {
                    this.gjM.euU.setShowPraiseNum(false);
                    this.gjM.euU.setShareVisible(false);
                    this.hjt.setText(at.numFormatOverWan(this.hjo.dUS.edC));
                    this.hjt.setVisibility(0);
                } else {
                    this.gjM.euU.setShowPraiseNum(true);
                    this.gjM.euU.setShareVisible(true);
                    this.hjt.setVisibility(8);
                }
                this.gjM.setData(this.hjo.dUS);
                this.gja.setVisibility(8);
                this.giZ.iB(false);
                return;
            }
            this.gjM.setVisibility(8);
            this.giZ.iB(true);
            if (this.hjo.dUS.edC > 0) {
                this.gja.setShowPraiseNum(false);
                this.gja.setShareVisible(false);
                this.hjt.setText(at.numFormatOverWan(this.hjo.dUS.edC));
                this.hjt.setVisibility(0);
            } else {
                this.gja.setShowPraiseNum(true);
                this.gja.setShareVisible(true);
                this.hjt.setVisibility(8);
            }
            if (this.gja.setData(this.hjo.dUS)) {
                this.hjk.setVisibility(8);
            } else {
                this.hjk.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAA().au(this.agH, i);
    }

    private boolean cbN() {
        return (this.hjo == null || this.hjo.dUS == null || this.hjo.dUS.beX() == null || TextUtils.isEmpty(this.hjo.dUS.beX().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.hjj.onDestroy();
    }
}
