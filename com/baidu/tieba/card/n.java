package com.baidu.tieba.card;

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
import com.baidu.tieba.f;
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
    private final View.OnClickListener axw;
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
    private g.a bjM;
    private g.f bjN;
    private View bkJ;
    private Animation bvg;
    private com.baidu.tieba.play.j bvs;
    private com.baidu.tieba.play.n bvt;
    public ThreadGodReplyLayout cws;
    private com.baidu.tieba.play.g cyB;
    private LinearLayout cyC;
    private com.baidu.tieba.j.k cyD;
    private com.baidu.tieba.card.data.l cyE;
    private int cyF;
    private boolean cyG;
    private boolean cyH;
    private boolean cyI;
    private TextView cyJ;
    private TextView cyK;
    private Handler cyL;
    private VideoLoadingProgressView.a cyM;
    private final View.OnClickListener cyN;
    private final View.OnClickListener cyO;
    private CustomMessageListener cyP;
    private j.a cyQ;
    private Animation.AnimationListener cyR;
    private View cyw;
    private TbPageContext<?> mContext;
    private String mFrom;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.cyB != null) {
            try {
                this.bcU.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int sh = com.baidu.tieba.play.x.bkT().sh(this.bdb);
            if (sh != 0) {
                if (this.bcU != null) {
                    this.bcU.rH(sh);
                } else {
                    this.cyB.seekTo(sh);
                }
            }
            this.cyL.sendEmptyMessageDelayed(202, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiL() {
        if (this.cyE != null && this.cyE.btL != null) {
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = this.cyE.sourceType == 0 ? "index" : "hot_juhe";
            yVar.aWq = this.cyE.btL.getTid();
            yVar.cBR = this.cyE.btL.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.cyE.btL.mRecomSource;
            yVar.ghB = this.cyE.btL.mRecomAbTag;
            yVar.ghC = this.cyE.btL.mRecomWeight;
            yVar.ghD = "";
            yVar.afx = this.cyE.getExtra();
            if (this.cyE.btL.vB() != null) {
                yVar.ghF = this.cyE.btL.vB().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cyE.btL.vB().video_md5, "", "1", yVar);
        }
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.mSkinType = 3;
        this.cyF = 0;
        this.bda = 1;
        this.cyG = false;
        this.cyH = true;
        this.cyI = false;
        this.cyL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.n.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        n.this.aiO();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        n.this.aiP();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bjN = new g.f() { // from class: com.baidu.tieba.card.n.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                n.this.cyB = gVar;
                if (n.this.cyB != null) {
                    n.this.cyB.setVolume(0.0f, 0.0f);
                }
                n.this.cyD.aVV();
                n.this.aiK();
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.card.n.13
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                com.baidu.tieba.play.x.bkT().remove(n.this.bdb);
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
        this.cyM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.n.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                n.this.aiK();
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
        this.cyN = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyE == null) {
                    if (n.this.aiC() != null) {
                        n.this.aiC().a(view, n.this.cyE);
                        return;
                    }
                    return;
                }
                if (view == n.this.bHN.getUserName()) {
                    n.this.cyE.cBL = 3;
                } else if (view == n.this.bHN.getHeaderImg()) {
                    n.this.cyE.cBL = 4;
                } else {
                    n.this.cyE.cBL = 1;
                }
                if (n.this.aiC() != null) {
                    n.this.aiC().a(view, n.this.cyE);
                }
            }
        };
        this.cyO = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyE != null) {
                    n.this.cyE.cBL = 4;
                }
                if (n.this.aiC() != null) {
                    n.this.aiC().a(view, n.this.cyE);
                }
            }
        };
        this.cyP = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.n.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    n.this.cyI = false;
                }
            }
        };
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.cyE != null) {
                    if (n.this.aiC() != null) {
                        n.this.aiC().a(view, n.this.cyE);
                    }
                    if (n.this.cyE.btL != null && view != n.this.bIC.ayn) {
                        o.kY(n.this.cyE.btL.getId());
                        if (!n.this.aiG()) {
                            o.a(n.this.mTextTitle, n.this.cyE.btL.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
                            o.a(n.this.cws.getGodReplyContent(), n.this.cyE.Tg().getId(), f.d.cp_cont_f, f.d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cyQ = new j.a() { // from class: com.baidu.tieba.card.n.10
            @Override // com.baidu.tieba.play.j.a
            public void aiR() {
                if (n.this.cyE != null && n.this.cyE.btL != null && n.this.cyE.btL.vB() != null) {
                    n.this.aiL();
                }
            }
        };
        this.cyR = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.n.11
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
        this.bHM = (RelativeLayout) view.findViewById(f.g.layout_root);
        this.bIz = (HeadPendantClickableView) this.bHM.findViewById(f.g.card_home_page_video_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bcX = new com.baidu.tieba.play.w((ViewGroup) view.findViewById(f.g.auto_video_loading_container));
        this.bcX.setLoadingAnimationListener(this.cyM);
        this.mTextTitle = (TextView) view.findViewById(f.g.text_title);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_home_page_auto_video_user_info_layout);
        this.bIa = new NEGFeedBackView(aiB());
        int f = com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds120);
        com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds16);
        this.bIa.a(this.bHM, f, 0);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.text_bottom);
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
        this.bHO.setForumAfterClickListener(this.axw);
        this.bHO.setFrom(1);
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.text_bottom_threaad);
        this.bIC.ayo.setOnClickListener(this);
        this.bIC.setFrom(1);
        this.bIC.setShareReportFrom(3);
        this.bIC.setForumAfterClickListener(this.axw);
        this.cyw = view.findViewById(f.g.divider_below_reply_number_layout);
        this.bcQ = (FrameLayout) view.findViewById(f.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bcQ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bcQ.setLayoutParams(layoutParams2);
        this.bcS = (TbImageView) view.findViewById(f.g.image_video);
        this.bcS.setDefaultErrorResource(0);
        this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcS.setEvent(this.bdc);
        this.bcT = (ImageView) view.findViewById(f.g.image_video_play);
        this.bHM.setOnClickListener(this);
        this.bcU = (QuickVideoView) view.findViewById(f.g.texture_video_view);
        this.bvt = new com.baidu.tieba.play.n(this.mContext.getPageActivity());
        this.bcU.setBusiness(this.bvt);
        this.bcU.setOnPreparedListener(this.bjN);
        this.bcU.setOnCompletionListener(this.bjM);
        this.bcU.setOnErrorListener(this.bdd);
        this.bcU.setOnSurfaceDestroyedListener(this.bdh);
        this.bvs = new com.baidu.tieba.play.j();
        this.bvs.setPlayer(this.bcU);
        this.bvs.a(this.cyQ);
        this.bcR = (TextView) view.findViewById(f.g.text_video_duration);
        this.cyC = (LinearLayout) view.findViewById(f.g.duration_container);
        this.bcZ = (TextView) view.findViewById(f.g.text_video_play_count);
        this.bcY = view.findViewById(f.g.auto_video_black_mask);
        this.bcV = (TextView) view.findViewById(f.g.auto_video_error_tips);
        this.bcW = view.findViewById(f.g.auto_video_error_background);
        this.bIN = (LinearLayout) view.findViewById(f.g.video_card_content_layout);
        this.bvg = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bvg.setAnimationListener(this.cyR);
        this.cws = (ThreadGodReplyLayout) view.findViewById(f.g.card_god_reply_layout);
        this.cws.setOnClickListener(this);
        this.bkJ = view.findViewById(f.g.divider_line);
        this.cyJ = (TextView) view.findViewById(f.g.txt_video_num_during_playing);
        this.bcU.setOnClickListener(this);
        this.cyK = (TextView) view.findViewById(f.g.nani_video_icon);
        this.cyD = new com.baidu.tieba.j.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (this.cyE != null && this.cyE.btL != null && this.cyE.btL.ajF > 0) {
            if (aiC() != null) {
                aiC().a(view, this.cyE);
            }
            this.mContext.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.mContext.getPageActivity(), this.cyE.btL.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, o.uX(), this.cyE.ajm())));
            return;
        }
        if (view == this.bHM || view == this.cws) {
            am(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcU) {
            if (this.cyE != null) {
                this.cyE.cBL = 5;
            }
            if (this.cyE != null && this.cyE.btL != null && this.cyE.btL.vB() != null) {
                z = this.cyE.btL.vB().is_vertical.intValue() == 1;
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
        if (aiC() != null) {
            aiC().a(view, this.cyE);
        }
        if (!com.baidu.adp.lib.util.j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), f.j.no_network_guide);
        } else {
            aiM();
        }
    }

    private void al(View view) {
        if (aiC() != null) {
            aiC().a(view, this.cyE);
        }
        if (!com.baidu.adp.lib.util.j.jE()) {
            com.baidu.adp.lib.util.l.showToast(this.mContext.getPageActivity(), f.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.jF() && !com.baidu.tieba.video.g.bAk().bAl()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(f.g.tv_title)).setText(f.j.confirm_title);
            ((TextView) inflate.findViewById(f.g.tv_msg)).setText(f.j.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(f.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, n.this.mContext.getPageActivity(), n.this.mContext.getPageActivity().getResources().getString(f.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.card.n.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    n.this.aiN();
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.card.n.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ch(1);
            aVar.cg(f.d.cp_cont_b);
            aVar.av(true);
            aVar.b(this.mTbPageContext).xe();
        } else {
            aiN();
        }
    }

    private void aiM() {
        if (this.cyE != null && this.cyE.btL != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cyE.btL);
            videoItemData.mRecomExtra = this.cyE.getExtra();
            videoItemData.mRecomAbTag = this.cyE.ajn();
            videoItemData.mRecomSource = this.cyE.getSource();
            videoItemData.mRecomWeight = this.cyE.getWeight();
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.cyE.ajm(), "index")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiN() {
        if (this.cyE != null && this.cyE.btL != null && this.cyE.btL.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cyE.btL);
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.cyE.btL.getTid(), o.uX(), this.cyE.ajm(), videoSerializeVideoThreadInfo)));
        }
    }

    private void am(View view) {
        if (this.cyE != null) {
            this.cyE.cBL = 1;
        }
        if (aiC() != null) {
            aiC().a(view, this.cyE);
        }
        if (this.cyE != null && this.cyE.btL != null) {
            if (!aiG()) {
                o.kY(this.cyE.btL.getId());
                o.a(this.mTextTitle, this.cyE.btL.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.cyE.btL, null, o.uX(), 18003, true, false, false).addLocateParam(this.cyE.ajm());
            addLocateParam.setVideo_source(this.cyE.sourceType == 0 ? "index" : "hot_juhe");
            if (this.cyE.sourceType == 0) {
                addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            }
            addLocateParam.setForumId(String.valueOf(this.cyE.btL.getFid()));
            addLocateParam.setForumName(this.cyE.btL.vp());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cws) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiG() {
        return this.cyE.cCj && !this.cyE.cCs;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        this.cyE = lVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiO() {
        this.cyL.removeMessages(202);
        if (this.bcU.getCurrentPosition() > 0) {
            e(true, 3);
            this.cyL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            if (this.cyE != null && this.cyE.btL != null && this.cyE.btL.vB() != null) {
                this.cyD.a(this.cyE.btL.getTid(), this.cyE.btL.vB().video_length.intValue(), this.cyE.btL.vB().video_duration.intValue(), "homepage");
                return;
            }
            return;
        }
        this.cyL.sendEmptyMessageDelayed(202, 40L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiP() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cyL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bcU.getCurrentPosition();
        if (currentPosition != this.cyF) {
            this.cyF = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cyL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
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
                    this.bvg.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.cyC.setVisibility(0);
                    this.cyJ.setVisibility(8);
                    this.bcX.startLoading();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdg, 60000L);
                } else if (i == 3) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bvg);
                    this.bcY.setVisibility(8);
                    this.cyC.setVisibility(8);
                    if (this.cyE != null && this.cyE.Tg() != null && this.cyE.Tg().ajF > 0) {
                        this.cyJ.setVisibility(0);
                    }
                    this.bcX.bkO();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                } else if (i == 4) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bvg);
                    this.bcY.setVisibility(8);
                    this.bcX.bkP();
                    this.bcW.setVisibility(0);
                    this.bcV.setVisibility(0);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdf, 2000L);
                } else {
                    this.bcT.setVisibility(0);
                    this.bvg.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.cyC.setVisibility(0);
                    this.bcX.bkP();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                }
                if (this.cyE != null && this.cyE.Tg() != null && this.cyE.Tg().ajF > 0) {
                    this.cyC.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.cyE == null || this.cyE.btL == null || this.cyE.btL.vj() == null) {
            this.bHM.setVisibility(8);
            return;
        }
        this.bHM.setVisibility(0);
        aiQ();
        if (!aiG() && o.kZ(this.cyE.btL.getId())) {
            o.a(this.mTextTitle, this.cyE.btL.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            o.a(this.cws.getGodReplyContent(), this.cyE.Tg().getId(), f.d.cp_cont_f, f.d.cp_cont_d);
        }
        this.cyE.Tg().vR();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cyE.Tg().vI());
        if (this.cyE.Tg().vO() && !StringUtils.isNull(this.cyE.Tg().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cyE.Tg().getTid();
            spannableStringBuilder.append((CharSequence) this.cyE.Tg().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.n.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(f.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.bHN.setData(this.cyE.Tg());
        this.bHN.setUserAfterClickListener(this.cyN);
        if (this.bHN.getHeaderImg() != null) {
            this.bHN.getHeaderImg().setAfterClickListener(this.cyO);
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (this.cyE.Tg() == null || this.cyE.Tg().vj() == null || this.cyE.Tg().vj().getPendantData() == null || StringUtils.isNull(this.cyE.Tg().vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                if (this.cyE.Tg().ajF > 0 && this.cyE.Tg().ajG == 0) {
                    this.cyE.Tg().vj().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.bHN.getHeaderImg().setData(this.cyE.Tg(), false);
                } else {
                    this.bHN.getHeaderImg().setData(this.cyE.Tg());
                    this.bHN.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(this.cyE.Tg());
            }
        }
        this.bcR.setText(ap.da(this.cyE.btL.vB().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(f.j.play_count), ap.H(this.cyE.btL.vB().play_count.intValue())));
        if (this.bIa != null && this.cyE.Tg() != null) {
            ah ahVar = new ah();
            ahVar.setTid(this.cyE.Tg().getTid());
            ahVar.setFid(this.cyE.Tg().getFid());
            ahVar.a(this.cyE.agt);
            this.bIa.setData(ahVar);
            this.bIa.setFirstRowSingleColumn(true);
            this.bIa.setVisibility(this.cyH ? 0 : 8);
        }
        this.cws.setData(this.cyE.Tg().ww());
        hm(gt(1));
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        if (o.kZ(this.cyE.btL.getId())) {
            am.c(this.mTextTitle, f.d.cp_cont_d, 1);
        } else {
            am.c(this.mTextTitle, f.d.cp_cont_b, 1);
        }
        if (this.cyE == null || this.cyE.btL == null || this.cyE.btL.vB() == null) {
            z = false;
        } else {
            z = this.cyE.btL.vB().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cyK.setVisibility(0);
        } else {
            this.cyK.setVisibility(8);
        }
    }

    private void aib() {
        this.cyL.removeMessages(202);
        this.cyL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Ng() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
    }

    private void aiQ() {
        Ng();
        aib();
        if (this.bcS != null && this.bcQ != null && this.bcU != null) {
            if (com.baidu.tbadk.core.i.td().tj() && this.cyE != null && this.cyE.btL != null && this.cyE.btL.vB() != null) {
                this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                this.bcS.startLoad(this.cyE.btL.vB().thumbnail_url, 10, false);
                this.bcQ.setVisibility(0);
                stopPlay();
                this.bdb = this.cyE.btL.vB().video_url;
                if (StringUtils.isNull(this.cyE.btL.vB().video_url)) {
                    e(true, 4);
                }
                if (this.bvt != null && this.bvt.bkx() != null) {
                    this.bvt.bkx().g(this.cyE.btL.vB());
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
            am.i(this.bHM, f.C0146f.addresslist_item_bg);
            am.c(this.bcT, f.C0146f.btn_icon_play_video_n);
            am.h(this.bcV, f.d.cp_cont_i);
            am.h(this.bcR, f.d.cp_cont_i);
            am.h(this.bcZ, f.d.cp_cont_i);
            am.h(this.cyJ, f.d.cp_cont_i);
            am.j(this.bcW, f.d.common_color_10014);
            am.j(this.bkJ, f.d.cp_bg_line_e);
            if (this.cyK != null) {
                am.h(this.cyK, f.d.cp_cont_i);
                am.i(this.cyK, f.C0146f.video_play_count_bg);
            }
            if (this.bcV != null) {
                this.bcV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cws.onChangeSkinType();
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
            this.cyP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyP);
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
        return this.cyG;
    }

    public boolean isPlaying() {
        if (this.bcU == null) {
            return false;
        }
        return this.bcU.isPlaying();
    }

    public void startPlay() {
        if (!this.cyG && this.cyE != null && this.cyE.btL != null && this.cyE.btL.vB() != null && this.bcU != null && com.baidu.tbadk.util.y.q(1, this.bdb)) {
            this.cyD.aVU();
            e(true, 2);
            if (StringUtils.isNull(this.bdb)) {
                TiebaStatic.log(new an("c12619").ae("obj_locate", "index").ae("tid", this.cyE.tid));
                this.bdb = this.cyE.btL.vB().video_url;
            }
            this.bcU.setVideoPath(this.bdb, this.cyE.tid);
            if (this.bvs != null) {
                this.bvs.start();
            }
            this.cyG = true;
            aiL();
        }
    }

    public void stopPlay() {
        Ng();
        aib();
        e(true, 1);
        if (this.bcU != null) {
            if (this.bcU.isPlaying()) {
                com.baidu.tieba.play.x.bkT().aD(this.bdb, this.bcU.getCurrentPosition());
            }
            this.bcU.stopPlayback();
            if (this.bvs != null) {
                this.bvs.stop();
            }
        }
        this.cyG = false;
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
        if (this.bvt != null) {
            this.bvt.setVideoStatsData(yVar);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axH;
        }
        return null;
    }

    public View aiF() {
        if (this.bHN != null) {
            return this.bHN.axI;
        }
        return null;
    }

    public void et(boolean z) {
        this.cyH = z;
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void hm(int i) {
        if (this.cyE != null && this.cyE.btL != null) {
            if (i == 1) {
                if (this.cyE.btL.ajF > 0) {
                    this.bIC.ayo.setShowPraiseNum(false);
                    this.bIC.ayo.setShareVisible(false);
                    this.cyJ.setText(ap.H(this.cyE.btL.ajF));
                    this.cyJ.setVisibility(0);
                } else {
                    this.bIC.ayo.setShowPraiseNum(true);
                    this.bIC.ayo.setShareVisible(true);
                    this.cyJ.setVisibility(8);
                }
                this.bIC.setData(this.cyE.btL);
                this.bHO.setVisibility(8);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
            if (this.cyE.btL.ajF > 0) {
                this.bHO.setShowPraiseNum(false);
                this.bHO.setShareVisible(false);
                this.cyJ.setText(ap.H(this.cyE.btL.ajF));
                this.cyJ.setVisibility(0);
            } else {
                this.bHO.setShowPraiseNum(true);
                this.bHO.setShareVisible(true);
                this.cyJ.setVisibility(8);
            }
            if (this.bHO.setData(this.cyE.btL)) {
                this.cyw.setVisibility(8);
            } else {
                this.cyw.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
