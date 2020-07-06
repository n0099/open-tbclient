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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class l extends b<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private int YW;
    private String afG;
    private Animation btX;
    private TbPageContext<?> dPv;
    public FrameLayout eKT;
    private TextView eKU;
    private TbImageView eKV;
    private ImageView eKW;
    private TextView eKX;
    private View eKY;
    private com.baidu.tieba.play.w eKZ;
    private View eLa;
    private TextView eLb;
    private int eLc;
    private TbImageView.a eLd;
    private g.b eLe;
    private Runnable eLg;
    private Runnable eLh;
    private QuickVideoView.b eLi;
    private g.a eUI;
    private g.f eUJ;
    private g.e eUL;
    private View eVD;
    private final View.OnClickListener edU;
    private RelativeLayout fRG;
    public ThreadUserInfoLayout fRH;
    public ThreadCommentAndPraiseInfoLayout fRI;
    private NEGFeedBackView fRT;
    public ThreadSourceShareAndPraiseLayout fSu;
    protected LinearLayout fdX;
    private com.baidu.tieba.play.j fni;
    private com.baidu.tieba.play.n fnj;
    private com.baidu.afd.videopaster.d gQK;
    private View gQL;
    public ThreadGodReplyLayout gQM;
    private HeadPendantClickableView gQN;
    private com.baidu.tieba.play.a.a gQO;
    private LinearLayout gQP;
    private com.baidu.tieba.card.data.l gQQ;
    private int gQR;
    private boolean gQS;
    private boolean gQT;
    private boolean gQU;
    private TextView gQV;
    private boolean gQW;
    private TextView gQX;
    private Handler gQY;
    private VideoLoadingProgressView.a gQZ;
    private CustomMessageListener gRa;
    private final View.OnClickListener gRb;
    private final View.OnClickListener gRc;
    private CustomMessageListener gRd;
    private j.a gRe;
    private Animation.AnimationListener gRf;
    private boolean isNewPlayer;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bOi() {
        if (this.gQO != null && this.gQS) {
            try {
                this.gQO.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int Lc = com.baidu.tieba.play.x.cVW().Lc(this.mVideoUrl);
            if (Lc <= 100 || this.gQO.getDuration() <= Lc) {
                Lc = 100;
            }
            this.YW = Lc;
            this.gQY.sendEmptyMessageDelayed(202, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOj() {
        if (this.gQQ != null && this.gQQ.dLi != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.gQQ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE;
            yVar.ajO = this.gQQ.dLi.getTid();
            yVar.eEs = this.gQQ.dLi.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.gQQ.dLi.mRecomSource;
            yVar.kVs = this.gQQ.dLi.mRecomAbTag;
            yVar.kVo = this.gQQ.dLi.mRecomAbTag;
            yVar.kVp = this.gQQ.dLi.mRecomWeight;
            yVar.kVq = "";
            yVar.dIK = this.gQQ.getExtra();
            if (this.gQQ.dLi.aSH() != null) {
                yVar.kVt = this.gQQ.dLi.aSH().video_md5;
            }
            com.baidu.tieba.play.l.a(this.gQQ.dLi.aSH().video_md5, "", "1", yVar, this.gQO.getPcdnState());
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fRT = null;
        this.mSkinType = 3;
        this.gQR = 0;
        this.eLc = 1;
        this.gQS = false;
        this.gQT = true;
        this.gQU = false;
        this.YW = 100;
        this.gQW = false;
        this.isNewPlayer = false;
        this.gQY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.l.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        l.this.bOn();
                        return;
                    case 203:
                        l.this.bOo();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.card.l.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (l.this.gQO != null) {
                    l.this.gQO.setVolume(0.0f, 0.0f);
                }
                l.this.bOi();
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.card.l.15
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3 || i == 904) {
                    l.this.v(false, 3);
                }
                return false;
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.card.l.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                if (!l.this.gQK.a(false, false, "NEWINDEX")) {
                    l.this.gQO.start();
                }
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.card.l.17
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                l.this.v(true, 4);
                l.this.gQS = false;
                return true;
            }
        };
        this.gQZ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.l.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                l.this.bOi();
            }
        };
        this.eLd = new TbImageView.a() { // from class: com.baidu.tieba.card.l.20
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && l.this.eKV != null) {
                    l.this.eKV.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eLg = new Runnable() { // from class: com.baidu.tieba.card.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.gQO != null && !l.this.gQO.isPlaying()) {
                    l.this.v(true, 1);
                }
            }
        };
        this.eLh = new Runnable() { // from class: com.baidu.tieba.card.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.v(true, 4);
            }
        };
        this.gRa = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.card.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && l.this.gQQ != null && l.this.gQQ.dLi != null && videoId.equals(l.this.gQQ.dLi.getId())) {
                        l.this.gQK.a(l.this.a(l.this.gQQ, bVar));
                    }
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.card.l.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                l.this.stopPlay();
            }
        };
        this.gRb = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gQQ == null) {
                    if (l.this.bOd() != null) {
                        l.this.bOd().a(view, l.this.gQQ);
                        return;
                    }
                    return;
                }
                if (view == l.this.fRH.getUserName()) {
                    l.this.gQQ.objType = 3;
                } else if (view == l.this.fRH.getHeaderImg()) {
                    l.this.gQQ.objType = 4;
                } else {
                    l.this.gQQ.objType = 1;
                }
                if (l.this.bOd() != null) {
                    l.this.bOd().a(view, l.this.gQQ);
                }
            }
        };
        this.gRc = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gQQ != null) {
                    l.this.gQQ.objType = 4;
                }
                if (l.this.bOd() != null) {
                    l.this.bOd().a(view, l.this.gQQ);
                }
            }
        };
        this.gRd = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.l.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    l.this.gQU = false;
                }
            }
        };
        this.edU = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gQQ != null) {
                    if (l.this.bOd() != null) {
                        l.this.bOd().a(view, l.this.gQQ);
                    }
                    if (l.this.gQQ.dLi != null && view != l.this.fSu.eee) {
                        m.DO(l.this.gQQ.dLi.getId());
                        if (!l.this.bOm()) {
                            m.a(l.this.mTextTitle, l.this.gQQ.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                            m.a(l.this.gQM.getGodReplyContent(), l.this.gQQ.aPS().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.gRe = new j.a() { // from class: com.baidu.tieba.card.l.13
            @Override // com.baidu.tieba.play.j.a
            public void qx() {
                if (l.this.gQQ != null && l.this.gQQ.dLi != null && l.this.gQQ.dLi.aSH() != null) {
                    l.this.bOj();
                }
            }
        };
        this.gRf = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.l.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (l.this.eKV != null) {
                    l.this.eKV.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.dPv = tbPageContext;
        View view = getView();
        this.fRG = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gQN = (HeadPendantClickableView) this.fRG.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gQN.getHeadView() != null) {
            this.gQN.getHeadView().setIsRound(true);
            this.gQN.getHeadView().setDrawBorder(false);
            this.gQN.getHeadView().setDefaultResource(17170445);
            this.gQN.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gQN.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.ds70));
            this.gQN.getHeadView().setPlaceHolder(1);
        }
        this.gQN.setHasPendantStyle();
        if (this.gQN.getPendantView() != null) {
            this.gQN.getPendantView().setIsRound(true);
            this.gQN.getPendantView().setDrawBorder(false);
        }
        this.eKZ = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eKZ.setLoadingAnimationListener(this.gQZ);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fRH = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fRT = new NEGFeedBackView(getTbPageContext());
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        this.fRT.a(this.fRG, dimens, 0);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        if (this.fRI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fRI.setLayoutParams(layoutParams);
        }
        this.fRI.setOnClickListener(this);
        this.fRI.setReplyTimeVisible(false);
        this.fRI.setShowPraiseNum(true);
        this.fRI.setNeedAddPraiseIcon(true);
        this.fRI.setNeedAddReplyIcon(true);
        this.fRI.setShareVisible(true);
        this.fRI.setShareReportFrom(3);
        this.fRI.setForumAfterClickListener(this.edU);
        this.fRI.setFrom(1);
        this.fSu = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fSu.eeP.setOnClickListener(this);
        this.fSu.setFrom(1);
        this.fSu.setShareReportFrom(3);
        this.fSu.setForumAfterClickListener(this.edU);
        this.gQL = view.findViewById(R.id.divider_below_reply_number_layout);
        this.eKT = (FrameLayout) view.findViewById(R.id.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKT.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.dPv.getPageActivity()) - com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.eKT.setLayoutParams(layoutParams2);
        this.eKV = (TbImageView) view.findViewById(R.id.image_video);
        this.eKV.setDefaultErrorResource(0);
        this.eKV.setPlaceHolder(3);
        this.eKV.setGifIconSupport(false);
        this.eKV.setEvent(this.eLd);
        this.eKV.setRadius(com.baidu.adp.lib.util.l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds10));
        TbImageView tbImageView = this.eKV;
        TbImageView tbImageView2 = this.eKV;
        tbImageView.setConrers(15);
        this.eKV.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eKV.setBorderColor(an.getColor(R.color.cp_border_a));
        this.eKV.setBorderSurroundContent(true);
        this.eKV.setDrawBorder(true);
        this.eKW = (ImageView) view.findViewById(R.id.image_video_play);
        this.fRG.setOnClickListener(this);
        this.fnj = new com.baidu.tieba.play.n(this.dPv.getPageActivity());
        this.isNewPlayer = com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test");
        this.gQO = com.baidu.tieba.play.a.b.A(this.dPv.getPageActivity(), this.isNewPlayer ? 1 : 0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.eKT.addView(this.gQO.getView(), 0);
        this.gQO.getView().setLayoutParams(layoutParams3);
        this.gQO.setContinuePlayEnable(true);
        this.gQO.setBusiness(this.fnj);
        this.gQO.setOnPreparedListener(this.eUJ);
        this.gQO.setOnOutInfoListener(this.eUL);
        this.gQO.setOnCompletionListener(this.eUI);
        this.gQO.setOnErrorListener(this.eLe);
        this.gQO.setOnSurfaceDestroyedListener(this.eLi);
        this.fni = new com.baidu.tieba.play.j();
        this.fni.setPlayer(this.gQO);
        this.fni.a(this.gRe);
        this.eKU = (TextView) view.findViewById(R.id.text_video_duration);
        this.gQP = (LinearLayout) view.findViewById(R.id.duration_container);
        this.eLb = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eLa = view.findViewById(R.id.auto_video_black_mask);
        this.eKX = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eKY = view.findViewById(R.id.auto_video_error_background);
        this.fdX = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.btX = AnimationUtils.loadAnimation(this.dPv.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.btX.setAnimationListener(this.gRf);
        this.gQM = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gQM.setOnClickListener(this);
        this.eVD = view.findViewById(R.id.divider_line);
        this.gQV = (TextView) view.findViewById(R.id.txt_video_num_during_playing);
        this.gQO.getView().setOnClickListener(this);
        this.gQX = (TextView) view.findViewById(R.id.nani_video_icon);
        this.gQK = new com.baidu.afd.videopaster.d(getContext(), this.eKT);
        this.gQK.a(new d.a() { // from class: com.baidu.tieba.card.l.19
            @Override // com.baidu.afd.videopaster.d.a
            public void qm() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void ql() {
                if (!l.this.gQW) {
                    l.this.gQO.start();
                } else {
                    l.this.startPlay();
                }
                l.this.gQW = false;
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qk() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean qn() {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.gQQ != null && this.gQQ.dLi != null && this.gQQ.dLi.dNV > 0) {
            if (bOd() != null) {
                bOd().a(view, this.gQQ);
            }
            this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.dPv.getPageActivity(), this.gQQ.dLi.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.aSb(), this.gQQ.aPV())));
            return;
        }
        if (view == this.fRG || view == this.gQM) {
            bP(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.gQO.getView()) {
            if (this.gQQ != null) {
                this.gQQ.objType = 5;
            }
            if (this.gQQ != null && this.gQQ.dLi != null && this.gQQ.dLi.aSH() != null) {
                z = this.gQQ.dLi.aSH().is_vertical.intValue() == 1;
            }
            if (z) {
                bN(this.gQO.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bO(this.gQO.getView());
            } else {
                bP(getView());
            }
        }
    }

    private void bN(View view) {
        if (bOd() != null) {
            bOd().a(view, this.gQQ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dPv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bOk();
        }
    }

    private void bO(View view) {
        if (bOd() != null) {
            bOd().a(view, this.gQQ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            com.baidu.adp.lib.util.l.showToast(this.dPv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bOl();
        }
    }

    private void bOk() {
        if (this.gQQ != null && this.gQQ.dLi != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.gQQ.dLi);
            videoItemData.mRecomExtra = this.gQQ.getExtra();
            videoItemData.mRecomAbTag = this.gQQ.bON();
            videoItemData.mRecomSource = this.gQQ.getSource();
            videoItemData.mRecomWeight = this.gQQ.getWeight();
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.gQQ.aPV(), "index");
            if (this.gQQ.dLi.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.gQQ.dLi.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bOl() {
        if (this.gQQ != null && this.gQQ.dLi != null && this.gQQ.dLi.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.gQQ.dLi);
            videoSerializeVideoThreadInfo.source = this.gQQ.getSource();
            videoSerializeVideoThreadInfo.extra = this.gQQ.getExtra();
            videoSerializeVideoThreadInfo.ab_tag = this.gQQ.bON();
            videoSerializeVideoThreadInfo.weight = this.gQQ.getWeight();
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.fdX.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.fdX.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ar.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.dPv.getPageActivity(), str, this.gQQ.dLi.getTid(), m.aSb(), this.gQQ.aPV(), videoSerializeVideoThreadInfo);
            if (this.gQQ.aPS() != null && this.gQQ.aPS().getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig.setNid(this.gQQ.aPS().getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private void bP(View view) {
        if (this.gQQ != null) {
            this.gQQ.objType = 1;
        }
        if (bOd() != null) {
            bOd().a(view, this.gQQ);
        }
        if (this.gQQ != null && this.gQQ.dLi != null) {
            if (!bOm()) {
                m.DO(this.gQQ.dLi.getId());
                m.a(this.mTextTitle, this.gQQ.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dPv.getPageActivity()).createFromThreadCfg(this.gQQ.dLi, null, m.aSb(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.gQQ.aPV());
            addLocateParam.setVideo_source(this.gQQ.sourceType == 0 ? "index" : ConstantData.VideoLocationType.HOT_TOPIC_JUHE);
            if (this.gQQ.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.gQQ.dLi.getFid()));
            addLocateParam.setForumName(this.gQQ.dLi.aSt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.gQM) {
                addLocateParam.setJumpGodReply(true);
            }
            this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOm() {
        return this.gQQ.gUT && !this.gQQ.gUY;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.gQQ = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOn() {
        this.gQY.removeMessages(202);
        if (this.gQO.getCurrentPosition() > this.YW) {
            v(false, 3);
            this.gQY.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gQY.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOo() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gQY.removeMessages(203);
        int currentPosition = this.gQO.getCurrentPosition();
        if (currentPosition != this.gQR) {
            this.gQR = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.gQY.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.eKW != null && this.eKV != null && this.eLa != null && this.eKZ != null && this.eKY != null && this.eKX != null) {
            if (z || this.eLc != i) {
                this.eLc = i;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLh);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLg);
                if (i == 2) {
                    this.eKW.setVisibility(8);
                    this.btX.cancel();
                    this.eKV.clearAnimation();
                    this.eKV.setVisibility(0);
                    this.eLa.setVisibility(0);
                    this.gQP.setVisibility(0);
                    this.gQV.setVisibility(8);
                    this.eKZ.startLoading();
                    this.eKY.setVisibility(8);
                    this.eKX.setVisibility(8);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eLh, 60000L);
                } else if (i == 3) {
                    this.eKW.setVisibility(8);
                    this.eKV.startAnimation(this.btX);
                    this.eLa.setVisibility(8);
                    this.gQP.setVisibility(8);
                    if (this.gQQ != null && this.gQQ.aPS() != null && this.gQQ.aPS().dNV > 0) {
                        this.gQV.setVisibility(0);
                    }
                    this.eKZ.cVS();
                    this.eKY.setVisibility(8);
                    this.eKX.setVisibility(8);
                    if (this.gQQ != null && this.gQQ.dLi != null && this.gQQ.dLi.aSH() != null) {
                        this.gQQ.dLi.aSH().video_length.intValue();
                        this.gQQ.dLi.aSH().video_duration.intValue();
                        this.gQQ.dLi.getTid();
                    }
                } else if (i == 4) {
                    this.eKW.setVisibility(8);
                    this.eKV.startAnimation(this.btX);
                    this.eLa.setVisibility(8);
                    this.eKZ.cVT();
                    this.eKY.setVisibility(0);
                    this.eKX.setVisibility(0);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eLg, 2000L);
                } else {
                    this.eKW.setVisibility(0);
                    this.btX.cancel();
                    this.eKV.clearAnimation();
                    this.eKV.setVisibility(0);
                    this.eLa.setVisibility(0);
                    this.gQP.setVisibility(0);
                    this.eKZ.cVT();
                    this.eKY.setVisibility(8);
                    this.eKX.setVisibility(8);
                }
                if (this.gQQ != null && this.gQQ.aPS() != null && this.gQQ.aPS().dNV > 0) {
                    this.gQP.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.gQQ == null || this.gQQ.dLi == null || this.gQQ.dLi.aSp() == null) {
            this.fRG.setVisibility(8);
            return;
        }
        this.fRG.setVisibility(0);
        bOq();
        if (!bOm() && m.DP(this.gQQ.dLi.getId())) {
            m.a(this.mTextTitle, this.gQQ.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.gQM.getGodReplyContent(), this.gQQ.aPS().getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        this.gQQ.aPS().aTn();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gQQ.aPS().aSZ());
        if (this.gQQ.aPS().aTf() && !StringUtils.isNull(this.gQQ.aPS().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.gQQ.aPS().getTid();
            spannableStringBuilder.append((CharSequence) this.gQQ.aPS().a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.card.l.21
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ao("c12841").dk("obj_source", "0"));
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
        this.fRH.setData(this.gQQ.aPS());
        this.fRH.setUserAfterClickListener(this.gRb);
        if (this.fRH.getHeaderImg() != null) {
            this.fRH.getHeaderImg().setAfterClickListener(this.gRc);
            if (this.fRH.getIsSimpleThread()) {
                this.fRH.getHeaderImg().setVisibility(8);
                this.gQN.setVisibility(8);
            } else if (this.gQQ.aPS() == null || this.gQQ.aPS().aSp() == null || this.gQQ.aPS().aSp().getPendantData() == null || StringUtils.isNull(this.gQQ.aPS().aSp().getPendantData().aQl())) {
                this.gQN.setVisibility(8);
                this.fRH.getHeaderImg().setVisibility(0);
                if (this.gQQ.aPS().dNV > 0 && this.gQQ.aPS().dNW == 0) {
                    this.gQQ.aPS().aSp().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.fRH.getHeaderImg().setData(this.gQQ.aPS(), false);
                } else {
                    this.fRH.getHeaderImg().setData(this.gQQ.aPS());
                    this.fRH.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.fRH.getHeaderImg().setVisibility(4);
                this.gQN.setVisibility(0);
                this.gQN.setData(this.gQQ.aPS());
            }
        }
        this.eKU.setText(ar.stringForVideoTime(this.gQQ.dLi.aSH().video_duration.intValue() * 1000));
        this.eLb.setText(String.format(this.dPv.getResources().getString(R.string.play_count), ar.numFormatOverWan(this.gQQ.dLi.aSH().play_count.intValue())));
        if (this.fRT != null && this.gQQ.aPS() != null) {
            ap apVar = new ap();
            apVar.setTid(this.gQQ.aPS().getTid());
            apVar.setFid(this.gQQ.aPS().getFid());
            apVar.setNid(this.gQQ.aPS().getNid());
            apVar.setFeedBackReasonMap(this.gQQ.feedBackReasonMap);
            this.fRT.setData(apVar);
            this.fRT.setFirstRowSingleColumn(true);
            this.fRT.setVisibility(this.gQT ? 0 : 8);
        }
        this.gQM.setData(this.gQQ.aPS().aTS());
        qZ(pz(1));
        onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
        if (m.DP(this.gQQ.dLi.getId())) {
            an.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
        } else {
            an.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.gQQ == null || this.gQQ.dLi == null || this.gQQ.dLi.aSH() == null) {
            z = false;
        } else {
            z = this.gQQ.dLi.aSH().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gQX.setVisibility(0);
            if (bOr()) {
                this.gQX.setText(String.format("%s | %s", this.dPv.getResources().getString(R.string.nani_video), this.dPv.getResources().getString(R.string.video_preview)));
            } else {
                this.gQX.setText(this.dPv.getString(R.string.nani_video));
            }
        } else if (bOr()) {
            this.gQX.setVisibility(0);
            this.gQX.setText(this.dPv.getString(R.string.video_preview));
        } else {
            this.gQX.setVisibility(8);
        }
    }

    private void bOp() {
        this.gQY.removeMessages(202);
        this.gQY.removeMessages(203);
    }

    private void bkz() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLg);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLh);
    }

    private void bOq() {
        bkz();
        bOp();
        if (this.eKV != null && this.eKT != null && this.gQO != null) {
            if (com.baidu.tbadk.core.k.aPA().isShowImages() && this.gQQ != null && this.gQQ.dLi != null && this.gQQ.dLi.aSH() != null) {
                this.eKV.setPlaceHolder(3);
                this.eKV.startLoad(this.gQQ.dLi.aSH().thumbnail_url, 10, false);
                this.eKT.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.gQQ.dLi.aSH().video_url;
                if (bOr()) {
                    this.mVideoUrl = this.gQQ.dLi.aSI().video_url;
                }
                if (StringUtils.isNull(this.gQQ.dLi.aSH().video_url)) {
                    v(true, 4);
                }
                if (this.fnj != null && this.fnj.cVD() != null) {
                    this.fnj.cVD().an(this.gQQ.dLi);
                }
            } else {
                this.eKT.setVisibility(8);
            }
            this.gQK.reset();
            this.fni.a(new j.b() { // from class: com.baidu.tieba.card.l.4
                @Override // com.baidu.tieba.play.j.b
                public void bM(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.gQK.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.gQQ);
                    }
                }
            });
            this.fnj.a(new j.b() { // from class: com.baidu.tieba.card.l.5
                @Override // com.baidu.tieba.play.j.b
                public void bM(int i, int i2) {
                    if (i2 >= i) {
                        if (l.this.gQK.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && (i2 * 100) / i >= 80 && i > 15000) {
                        l.this.b(l.this.gQQ);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.l lVar) {
        if (lVar != null && lVar.dLi != null) {
            bu buVar = lVar.dLi;
            if (buVar.getId() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, buVar.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(com.baidu.tieba.card.data.l lVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (lVar == null || lVar.dLi == null || bVar == null) {
            return null;
        }
        bu buVar = lVar.dLi;
        int qr = bVar.qr();
        int qs = bVar.qs();
        int qq = bVar.qq();
        if (qq != -1) {
            i = qr != -1 ? (qq - qr) - 1 : -1;
            if (qs != -1) {
                i4 = (qs - qq) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aSH = buVar.aSH();
        if (aSH != null) {
            i3 = aSH.video_width.intValue();
            i2 = aSH.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", buVar.getId());
        hashMap.put("video_title", buVar.getTitle());
        hashMap.put("forum_id", String.valueOf(buVar.getFid()));
        hashMap.put("forum_name", buVar.aSt());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qq + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fRG, R.drawable.addresslist_item_bg);
            an.setImageResource(this.eKW, R.drawable.btn_icon_play_video_n);
            an.setViewTextColor(this.eKX, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.eKU, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.eLb, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.gQV, (int) R.color.cp_cont_a);
            an.setBackgroundColor(this.eKY, R.color.common_color_10014);
            an.setBackgroundColor(this.eVD, R.color.cp_bg_line_c);
            if (this.gQX != null) {
                an.setViewTextColor(this.gQX, (int) R.color.cp_cont_a);
                an.setBackgroundResource(this.gQX, R.drawable.video_play_count_bg);
            }
            if (this.eKX != null) {
                this.eKX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.gQM.onChangeSkinType();
            if (this.fRT != null) {
                this.fRT.onChangeSkinType();
            }
            this.fRH.onChangeSkinType();
            this.fRI.onChangeSkinType();
            this.fSu.onChangeSkinType();
            this.eKV.setPlaceHolder(3);
            this.gQN.getHeadView().setPlaceHolder(1);
            this.mSkinType = i;
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.gRd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gRd);
            this.gRa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gRa);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fRH != null) {
            this.fRH.setPageUniqueId(bdUniqueId);
        }
        if (this.eKV != null) {
            this.eKV.setPageId(bdUniqueId);
        }
        if (this.fRT != null) {
            this.fRT.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.gQS;
    }

    public boolean isPlaying() {
        if (this.gQO == null) {
            return false;
        }
        return this.gQO.isPlaying();
    }

    public void startPlay() {
        if (!this.gQS && this.gQQ != null && this.gQQ.dLi != null && this.gQQ.dLi.aSH() != null && this.gQO != null) {
            if (this.gQK.pV()) {
                this.gQK.resume();
                this.gQW = true;
                return;
            }
            this.gQW = false;
            this.gQO.stopPlayback();
            if (ag.at(1, this.mVideoUrl)) {
                v(true, 2);
                if (StringUtils.isNull(this.mVideoUrl)) {
                    TiebaStatic.log(new ao("c12619").dk("obj_locate", "index").dk("tid", this.gQQ.tid));
                    this.mVideoUrl = this.gQQ.dLi.aSH().video_url;
                }
                this.gQS = true;
                this.gQO.setVideoPath(this.mVideoUrl, this.gQQ.tid);
                if (this.fni != null) {
                    this.fni.start();
                }
                bOj();
            }
        }
    }

    public void stopPlay() {
        this.gQW = false;
        bkz();
        bOp();
        v(true, 1);
        if (this.gQO != null) {
            this.gQO.stopPlayback();
            if (this.fni != null) {
                this.fni.stop();
            }
        }
        this.gQS = false;
        this.gQK.stop();
    }

    public View getVideoContainer() {
        return this.eKT;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.gQO == null) {
            return 0;
        }
        return this.gQO.getCurrentPosition();
    }

    public void lV(boolean z) {
        this.gQT = z;
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void qZ(int i) {
        if (this.gQQ != null && this.gQQ.dLi != null) {
            if (i == 1) {
                if (this.gQQ.dLi.dNV > 0) {
                    this.fSu.eeP.setShowPraiseNum(false);
                    this.fSu.eeP.setShareVisible(false);
                    this.gQV.setText(ar.numFormatOverWan(this.gQQ.dLi.dNV));
                    this.gQV.setVisibility(0);
                } else {
                    this.fSu.eeP.setShowPraiseNum(true);
                    this.fSu.eeP.setShareVisible(true);
                    this.gQV.setVisibility(8);
                }
                this.fSu.setData(this.gQQ.dLi);
                this.fRI.setVisibility(8);
                this.fRH.hz(false);
                return;
            }
            this.fSu.setVisibility(8);
            this.fRH.hz(true);
            if (this.gQQ.dLi.dNV > 0) {
                this.fRI.setShowPraiseNum(false);
                this.fRI.setShareVisible(false);
                this.gQV.setText(ar.numFormatOverWan(this.gQQ.dLi.dNV));
                this.gQV.setVisibility(0);
            } else {
                this.fRI.setShowPraiseNum(true);
                this.fRI.setShareVisible(true);
                this.gQV.setVisibility(8);
            }
            if (this.fRI.setData(this.gQQ.dLi)) {
                this.gQL.setVisibility(8);
            } else {
                this.gQL.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public int pz(int i) {
        return com.baidu.tieba.a.d.boB().as(this.afG, i);
    }

    private boolean bOr() {
        return (this.gQQ == null || this.gQQ.dLi == null || this.gQQ.dLi.aSI() == null || TextUtils.isEmpty(this.gQQ.dLi.aSI().video_url)) ? false : true;
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        this.gQK.onDestroy();
    }
}
