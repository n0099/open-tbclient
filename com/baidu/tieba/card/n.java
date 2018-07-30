package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class n extends a<com.baidu.tieba.card.data.l> implements View.OnClickListener, com.baidu.tieba.a.e {
    private final View.OnClickListener axz;
    private String bHB;
    private RelativeLayout bHM;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    protected LinearLayout bIN;
    private NEGFeedBackView bIa;
    private HeadPendantClickableView bIz;
    public FrameLayout bcQ;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private QuickVideoView bcU;
    private TextView bcV;
    private View bcW;
    private com.baidu.tieba.play.w bcX;
    private View bcY;
    private TextView bcZ;
    private int bda;
    private String bdb;
    private TbImageView.a bdc;
    private g.b bdd;
    private Runnable bdf;
    private Runnable bdg;
    private QuickVideoView.b bdh;
    private g.a bjG;
    private g.f bjH;
    private View bkE;
    private Animation bve;
    private com.baidu.tieba.play.j bvq;
    private com.baidu.tieba.play.n bvr;
    public ThreadGodReplyLayout cwv;
    private com.baidu.tieba.play.g cyE;
    private LinearLayout cyF;
    private com.baidu.tieba.j.k cyG;
    private com.baidu.tieba.card.data.l cyH;
    private int cyI;
    private boolean cyJ;
    private boolean cyK;
    private boolean cyL;
    private TextView cyM;
    private TextView cyN;
    private Handler cyO;
    private VideoLoadingProgressView.a cyP;
    private final View.OnClickListener cyQ;
    private final View.OnClickListener cyR;
    private CustomMessageListener cyS;
    private j.a cyT;
    private Animation.AnimationListener cyU;
    private View cyz;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.cyE != null) {
            try {
                this.bcU.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int se = com.baidu.tieba.play.x.bkW().se(this.bdb);
            if (se != 0) {
                if (this.bcU != null) {
                    this.bcU.rH(se);
                } else {
                    this.cyE.seekTo(se);
                }
            }
            this.cyO.sendEmptyMessageDelayed(202, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        if (this.cyH != null && this.cyH.btJ != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.cyH.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aWq = this.cyH.btJ.getTid();
            yVar.cBU = this.cyH.btJ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cyH.btJ.mRecomSource;
            yVar.ghC = this.cyH.btJ.mRecomAbTag;
            yVar.ghD = this.cyH.btJ.mRecomWeight;
            yVar.ghE = "";
            yVar.afx = this.cyH.getExtra();
            if (this.cyH.btJ.vC() != null) {
                yVar.ghG = this.cyH.btJ.vC().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cyH.btJ.vC().video_md5, "", "1", yVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.mSkinType = 3;
        this.cyI = 0;
        this.bda = 1;
        this.cyJ = false;
        this.cyK = true;
        this.cyL = false;
        this.cyO = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aiL();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        n.this.aiM();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bjH = new g.f() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cyE = gVar;
                if (n.this.cyE != null) {
                    n.this.cyE.setVolume(0.0f, 0.0f);
                }
                n.this.cyG.aVZ();
                n.this.aiH();
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                com.baidu.tieba.play.x.bkW().remove(n.this.bdb);
                n.this.bcU.start();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.card.n.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                n.this.e(true, 4);
                return true;
            }
        };
        this.cyP = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aiH();
            }
        };
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.n.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && n.this.bcS != null) {
                    n.this.bcS.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.card.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.bcU != null && !n.this.bcU.isPlaying()) {
                    n.this.e(true, 1);
                }
            }
        };
        this.bdg = new Runnable() { // from class: com.baidu.tieba.card.n.4
            @Override // java.lang.Runnable
            public void run() {
                n.this.e(true, 4);
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.n.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                n.this.stopPlay();
            }
        };
        this.cyQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyH == null) {
                    if (n.this.aiz() != null) {
                        n.this.aiz().a(view, n.this.cyH);
                        return;
                    }
                    return;
                }
                if (view == n.this.bHN.getUserName()) {
                    n.this.cyH.cBO = 3;
                } else if (view == n.this.bHN.getHeaderImg()) {
                    n.this.cyH.cBO = 4;
                } else {
                    n.this.cyH.cBO = 1;
                }
                if (n.this.aiz() != null) {
                    n.this.aiz().a(view, n.this.cyH);
                }
            }
        };
        this.cyR = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyH != null) {
                    n.this.cyH.cBO = 4;
                }
                if (n.this.aiz() != null) {
                    n.this.aiz().a(view, n.this.cyH);
                }
            }
        };
        this.cyS = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cyL = false;
                }
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyH != null) {
                    if (n.this.aiz() != null) {
                        n.this.aiz().a(view, n.this.cyH);
                    }
                    if (n.this.cyH.btJ != null && view != n.this.bIC.ayq) {
                        o.kW(n.this.cyH.btJ.getId());
                        if (!n.this.aiD()) {
                            o.a(n.this.mTextTitle, n.this.cyH.btJ.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                            o.a(n.this.cwv.getGodReplyContent(), n.this.cyH.Td().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cyT = new j.a() { // from class: com.baidu.tieba.card.n.10
            @Override // com.baidu.tieba.play.j.a
            public void aiO() {
                if (n.this.cyH != null && n.this.cyH.btJ != null && n.this.cyH.btJ.vC() != null) {
                    n.this.aiI();
                }
            }
        };
        this.cyU = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (n.this.bcS != null) {
                    n.this.bcS.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mContext = tbPageContext;
        View view = getView();
        this.bHM = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bIz = (HeadPendantClickableView) this.bHM.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bcX = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.bcX.setLoadingAnimationListener(this.cyP);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bIa = new NEGFeedBackView(aiy());
        int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds16);
        this.bIa.a(this.bHM, f, 0);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setShareReportFrom(3);
        this.bHO.setForumAfterClickListener(this.axz);
        this.bHO.setFrom(1);
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.bIC.ayr.setOnClickListener(this);
        this.bIC.setFrom(1);
        this.bIC.setShareReportFrom(3);
        this.bIC.setForumAfterClickListener(this.axz);
        this.cyz = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bcQ = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bcQ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bcQ.setLayoutParams(layoutParams2);
        this.bcS = (TbImageView) view.findViewById(d.g.image_video);
        this.bcS.setDefaultErrorResource(0);
        this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcS.setEvent(this.bdc);
        this.bcT = (ImageView) view.findViewById(d.g.image_video_play);
        this.bHM.setOnClickListener(this);
        this.bcU = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bvr = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.bcU.setBusiness(this.bvr);
        this.bcU.setOnPreparedListener(this.bjH);
        this.bcU.setOnCompletionListener(this.bjG);
        this.bcU.setOnErrorListener(this.bdd);
        this.bcU.setOnSurfaceDestroyedListener(this.bdh);
        this.bvq = new com.baidu.tieba.play.j();
        this.bvq.setPlayer(this.bcU);
        this.bvq.a(this.cyT);
        this.bcR = (TextView) view.findViewById(d.g.text_video_duration);
        this.cyF = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bcZ = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bcY = view.findViewById(d.g.auto_video_black_mask);
        this.bcV = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bcW = view.findViewById(d.g.auto_video_error_background);
        this.bIN = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bve = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bve.setAnimationListener(this.cyU);
        this.cwv = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cwv.setOnClickListener(this);
        this.bkE = view.findViewById(d.g.divider_line);
        this.cyM = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.bcU.setOnClickListener(this);
        this.cyN = (TextView) view.findViewById(d.g.nani_video_icon);
        this.cyG = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.ajF > 0) {
            if (aiz() != null) {
                aiz().a(view, this.cyH);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cyH.btJ.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.uY(), this.cyH.ajj())));
            return;
        }
        if (view == this.bHM || view == this.cwv) {
            am(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcU) {
            if (this.cyH != null) {
                this.cyH.cBO = 5;
            }
            if (this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.vC() != null) {
                z = this.cyH.btJ.vC().is_vertical.intValue() == 1;
            }
            if (z) {
                ak(getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                al(getView());
            } else {
                am(getView());
            }
        }
    }

    private void ak(View view) {
        if (aiz() != null) {
            aiz().a(view, this.cyH);
        }
        if (!com.baidu.adp.lib.util.j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aiJ();
        }
    }

    private void al(View view) {
        if (aiz() != null) {
            aiz().a(view, this.cyH);
        }
        if (!com.baidu.adp.lib.util.j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.jF() && !com.baidu.tieba.video.g.bAi().bAj()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) n.this.mContext.getPageActivity(), n.this.mContext.getPageActivity().getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.card.n.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    n.this.aiK();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.n.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ch(1);
            aVar.cg(d.C0140d.cp_cont_b);
            aVar.au(true);
            aVar.b(this.mTbPageContext).xf();
        } else {
            aiK();
        }
    }

    private void aiJ() {
        if (this.cyH != null && this.cyH.btJ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cyH.btJ);
            videoItemData.mRecomExtra = this.cyH.getExtra();
            videoItemData.mRecomAbTag = this.cyH.ajk();
            videoItemData.mRecomSource = this.cyH.getSource();
            videoItemData.mRecomWeight = this.cyH.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cyH.ajj(), "index")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cyH.btJ);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.bIN.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bIN.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            String str = "index";
            if (!ap.isEmpty(this.mFrom) && this.mFrom.equals(VideoMiddlePageActivityConfig.FROM_HOTTOPIC)) {
                str = VideoMiddlePageActivityConfig.FROM_HOTTOPIC;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cyH.btJ.getTid(), o.uY(), this.cyH.ajj(), videoSerializeVideoThreadInfo)));
        }
    }

    private void am(View view) {
        if (this.cyH != null) {
            this.cyH.cBO = 1;
        }
        if (aiz() != null) {
            aiz().a(view, this.cyH);
        }
        if (this.cyH != null && this.cyH.btJ != null) {
            if (!aiD()) {
                o.kW(this.cyH.btJ.getId());
                o.a(this.mTextTitle, this.cyH.btJ.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cyH.btJ, null, o.uY(), 18003, true, false, false).addLocateParam(this.cyH.ajj());
            addLocateParam.setVideo_source(this.cyH.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cyH.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cyH.btJ.getFid()));
            addLocateParam.setForumName(this.cyH.btJ.vq());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cwv) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiD() {
        return this.cyH.cCm && !this.cyH.cCv;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cyH = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiL() {
        this.cyO.removeMessages(202);
        if (this.bcU.getCurrentPosition() > 0) {
            e(true, 3);
            this.cyO.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            if (this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.vC() != null) {
                this.cyG.a(this.cyH.btJ.getTid(), this.cyH.btJ.vC().video_length.intValue(), this.cyH.btJ.vC().video_duration.intValue(), "homepage");
                return;
            }
            return;
        }
        this.cyO.sendEmptyMessageDelayed(202, 40L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiM() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cyO.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bcU.getCurrentPosition();
        if (currentPosition != this.cyI) {
            this.cyI = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cyO.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bcT != null && this.bcS != null && this.bcY != null && this.bcX != null && this.bcW != null && this.bcV != null) {
            if (z || this.bda != i) {
                this.bda = i;
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
                if (i == 2) {
                    this.bcT.setVisibility(8);
                    this.bve.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.cyF.setVisibility(0);
                    this.cyM.setVisibility(8);
                    this.bcX.startLoading();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdg, 60000L);
                } else if (i == 3) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bve);
                    this.bcY.setVisibility(8);
                    this.cyF.setVisibility(8);
                    if (this.cyH != null && this.cyH.Td() != null && this.cyH.Td().ajF > 0) {
                        this.cyM.setVisibility(0);
                    }
                    this.bcX.bkR();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                } else if (i == 4) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bve);
                    this.bcY.setVisibility(8);
                    this.bcX.bkS();
                    this.bcW.setVisibility(0);
                    this.bcV.setVisibility(0);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdf, 2000L);
                } else {
                    this.bcT.setVisibility(0);
                    this.bve.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.cyF.setVisibility(0);
                    this.bcX.bkS();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                }
                if (this.cyH != null && this.cyH.Td() != null && this.cyH.Td().ajF > 0) {
                    this.cyF.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cyH == null || this.cyH.btJ == null || this.cyH.btJ.vk() == null) {
            this.bHM.setVisibility(8);
            return;
        }
        this.bHM.setVisibility(0);
        aiN();
        if (!aiD() && o.kX(this.cyH.btJ.getId())) {
            o.a(this.mTextTitle, this.cyH.btJ.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            o.a(this.cwv.getGodReplyContent(), this.cyH.Td().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        this.cyH.Td().vS();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cyH.Td().vJ());
        if (this.cyH.Td().vP() && !StringUtils.isNull(this.cyH.Td().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cyH.Td().getTid();
            spannableStringBuilder.append((CharSequence) this.cyH.Td().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.bHN.setData(this.cyH.Td());
        this.bHN.setUserAfterClickListener(this.cyQ);
        if (this.bHN.getHeaderImg() != null) {
            this.bHN.getHeaderImg().setAfterClickListener(this.cyR);
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (this.cyH.Td() == null || this.cyH.Td().vk() == null || this.cyH.Td().vk().getPendantData() == null || StringUtils.isNull(this.cyH.Td().vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                if (this.cyH.Td().ajF > 0 && this.cyH.Td().ajG == 0) {
                    this.cyH.Td().vk().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bHN.getHeaderImg().setData(this.cyH.Td(), false);
                } else {
                    this.bHN.getHeaderImg().setData(this.cyH.Td());
                    this.bHN.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(this.cyH.Td());
            }
        }
        this.bcR.setText(ap.da(this.cyH.btJ.vC().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.H(this.cyH.btJ.vC().play_count.intValue())));
        if (this.bIa != null && this.cyH.Td() != null) {
            ah ahVar = new ah();
            ahVar.dh(this.cyH.Td().getTid());
            ahVar.setFid(this.cyH.Td().getFid());
            ahVar.a(this.cyH.agt);
            this.bIa.setData(ahVar);
            this.bIa.setFirstRowSingleColumn(true);
            this.bIa.setVisibility(this.cyK ? 0 : 8);
        }
        this.cwv.setData(this.cyH.Td().wx());
        hn(gu(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kX(this.cyH.btJ.getId())) {
            am.c(this.mTextTitle, d.C0140d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
        if (this.cyH == null || this.cyH.btJ == null || this.cyH.btJ.vC() == null) {
            z = false;
        } else {
            z = this.cyH.btJ.vC().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cyN.setVisibility(0);
        } else {
            this.cyN.setVisibility(8);
        }
    }

    private void ahY() {
        this.cyO.removeMessages(202);
        this.cyO.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Nc() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
    }

    private void aiN() {
        Nc();
        ahY();
        if (this.bcS != null && this.bcQ != null && this.bcU != null) {
            if (com.baidu.tbadk.core.i.te().tk() && this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.vC() != null) {
                this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcS.startLoad(this.cyH.btJ.vC().thumbnail_url, 10, false);
                this.bcQ.setVisibility(0);
                stopPlay();
                this.bdb = this.cyH.btJ.vC().video_url;
                if (StringUtils.isNull(this.cyH.btJ.vC().video_url)) {
                    e(true, 4);
                }
                if (this.bvr != null && this.bvr.bkA() != null) {
                    this.bvr.bkA().g(this.cyH.btJ.vC());
                    return;
                }
                return;
            }
            this.bcQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bHM, d.f.addresslist_item_bg);
            am.c(this.bcT, d.f.btn_icon_play_video_n);
            am.h(this.bcV, d.C0140d.cp_cont_i);
            am.h(this.bcR, d.C0140d.cp_cont_i);
            am.h(this.bcZ, d.C0140d.cp_cont_i);
            am.h(this.cyM, d.C0140d.cp_cont_i);
            am.j(this.bcW, d.C0140d.common_color_10014);
            am.j(this.bkE, d.C0140d.cp_bg_line_e);
            if (this.cyN != null) {
                am.h(this.cyN, d.C0140d.cp_cont_i);
                am.i(this.cyN, d.f.video_play_count_bg);
            }
            if (this.bcV != null) {
                this.bcV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cwv.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            this.bHN.onChangeSkinType();
            this.bHO.onChangeSkinType();
            this.bIC.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cyS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyS);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
        if (this.bcS != null) {
            this.bcS.setPageId(bdUniqueId);
        }
        if (this.bIa != null) {
            this.bIa.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cyJ;
    }

    public boolean isPlaying() {
        if (this.bcU == null) {
            return false;
        }
        return this.bcU.isPlaying();
    }

    public void startPlay() {
        if (!this.cyJ && this.cyH != null && this.cyH.btJ != null && this.cyH.btJ.vC() != null && this.bcU != null && com.baidu.tbadk.util.y.q(1, this.bdb)) {
            this.cyG.aVY();
            e(true, 2);
            if (StringUtils.isNull(this.bdb)) {
                TiebaStatic.log(new an("c12619").af("obj_locate", "index").af("tid", this.cyH.tid));
                this.bdb = this.cyH.btJ.vC().video_url;
            }
            this.bcU.setVideoPath(this.bdb, this.cyH.tid);
            if (this.bvq != null) {
                this.bvq.start();
            }
            this.cyJ = true;
            aiI();
        }
    }

    public void stopPlay() {
        Nc();
        ahY();
        e(true, 1);
        if (this.bcU != null) {
            if (this.bcU.isPlaying()) {
                com.baidu.tieba.play.x.bkW().aD(this.bdb, this.bcU.getCurrentPosition());
            }
            this.bcU.stopPlayback();
            if (this.bvq != null) {
                this.bvq.stop();
            }
        }
        this.cyJ = false;
    }

    public View getVideoContainer() {
        return this.bcQ;
    }

    public String getPlayUrl() {
        return this.bdb;
    }

    public int getCurrentPosition() {
        if (this.bcU == null) {
            return 0;
        }
        return this.bcU.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.bvr != null) {
            this.bvr.setVideoStatsData(yVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axK;
        }
        return null;
    }

    public View aiC() {
        if (this.bHN != null) {
            return this.bHN.axL;
        }
        return null;
    }

    public void et(boolean z) {
        this.cyK = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void hn(int i) {
        if (this.cyH != null && this.cyH.btJ != null) {
            if (i == 1) {
                if (this.cyH.btJ.ajF > 0) {
                    this.bIC.ayr.setShowPraiseNum(false);
                    this.bIC.ayr.setShareVisible(false);
                    this.cyM.setText(ap.H(this.cyH.btJ.ajF));
                    this.cyM.setVisibility(0);
                } else {
                    this.bIC.ayr.setShowPraiseNum(true);
                    this.bIC.ayr.setShareVisible(true);
                    this.cyM.setVisibility(8);
                }
                this.bIC.setData(this.cyH.btJ);
                this.bHO.setVisibility(8);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
            if (this.cyH.btJ.ajF > 0) {
                this.bHO.setShowPraiseNum(false);
                this.bHO.setShareVisible(false);
                this.cyM.setText(ap.H(this.cyH.btJ.ajF));
                this.cyM.setVisibility(0);
            } else {
                this.bHO.setShowPraiseNum(true);
                this.bHO.setShareVisible(true);
                this.cyM.setVisibility(8);
            }
            if (this.bHO.setData(this.cyH.btJ)) {
                this.cyz.setVisibility(8);
            } else {
                this.cyz.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
