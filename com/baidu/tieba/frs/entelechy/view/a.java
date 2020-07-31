package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.b<bv> implements com.baidu.tieba.a.e, y {
    private TbCyberVideoView YH;
    private bv aeA;
    private String afx;
    private final View.OnClickListener ahD;
    private Animation buu;
    private CyberPlayerManager.OnInfoListener dCA;
    private CyberPlayerManager.OnPreparedListener dCx;
    private CyberPlayerManager.OnErrorListener dCy;
    private CyberPlayerManager.OnCompletionListener dCz;
    private String dTB;
    private TbPageContext<?> dVN;
    private ViewTreeObserver.OnGlobalLayoutListener eRA;
    private Runnable eRB;
    private Runnable eRC;
    private TbCyberVideoView.a eRD;
    public FrameLayout eRp;
    private TextView eRq;
    private TbImageView eRr;
    private ImageView eRs;
    private TextView eRt;
    private View eRu;
    private m eRv;
    private View eRw;
    private TextView eRx;
    private int eRy;
    private TbImageView.a eRz;
    private final View.OnClickListener eke;
    private RelativeLayout fWZ;
    protected ThreadSourceShareAndPraiseLayout fXN;
    public ThreadSkinView fXY;
    public ThreadUserInfoLayout fXa;
    public ThreadCommentAndPraiseInfoLayout fXb;
    public View fXc;
    private View fbk;
    public LinearLayout fiQ;
    private f fss;
    private TextView gWC;
    private Handler gWD;
    private VideoLoadingProgressView.a gWE;
    private f.a gWJ;
    private Animation.AnimationListener gWK;
    private ThreadGodReplyLayout gWs;
    private HeadPendantClickableView gWt;
    private int gWw;
    private boolean gWx;
    private TbImageView gYD;
    private LinearLayout gYc;
    public TextView hQP;
    public LinearLayout hQQ;
    private i hQR;
    public boolean hQS;
    public int hQT;
    private View.OnClickListener hQU;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bRs() {
        if (this.YH != null && this.gWx) {
            try {
                this.YH.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gWD.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gWw = 0;
        this.eRy = 1;
        this.gWx = false;
        this.gWD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bRx();
                        return;
                    case 203:
                        a.this.bRy();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.YH != null) {
                    a.this.YH.setVolume(0.0f, 0.0f);
                }
                a.this.bRs();
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.YH.start();
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.bRz();
                a.this.v(true, 4);
                a.this.gWx = false;
                return true;
            }
        };
        this.gWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bRs();
            }
        };
        this.eRz = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.eRr != null) {
                    a.this.eRr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eRA = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.eRp != null && a.this.eRp.getLayoutParams() != null && a.this.eRp.getVisibility() != 8) {
                    a.this.eRp.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.eRp.getLayoutParams();
                    if (a.this.eRp.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.eRp.getWidth() * 0.5625d);
                        a.this.eRp.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eRB = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.YH != null && !a.this.YH.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.eRC = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bRz();
                a.this.v(true, 4);
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.hQU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aeA != null && !StringUtils.isNull(a.this.aeA.aWp())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dVN.getPageActivity()).createNormalCfg(a.this.aeA.aWp(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.eke != null) {
                        a.this.eke.onClick(view);
                    }
                }
            }
        };
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bRn() != null) {
                    a.this.bRn().a(view, a.this.aeA);
                }
            }
        };
        this.eke = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aeA != null && a.this.bRn() != null) {
                    a.this.bRn().a(view, a.this.aeA);
                }
            }
        };
        this.gWJ = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void qy() {
                a.this.bRt();
            }
        };
        this.gWK = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.eRy == 3 && a.this.eRr != null) {
                    a.this.eRr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.dVN = tbPageContext;
        View view = getView();
        this.fbk = view.findViewById(R.id.divider_line);
        this.fWZ = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gYD = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.hQQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fWZ.setOnClickListener(this);
        this.gWt = (HeadPendantClickableView) this.fWZ.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gWt.getHeadView() != null) {
            this.gWt.getHeadView().setIsRound(true);
            this.gWt.getHeadView().setDrawBorder(false);
            this.gWt.getHeadView().setDefaultResource(17170445);
            this.gWt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gWt.getHeadView().setRadius(l.getDimens(this.dVN.getPageActivity(), R.dimen.ds70));
        }
        this.gWt.setHasPendantStyle();
        if (this.gWt.getPendantView() != null) {
            this.gWt.getPendantView().setIsRound(true);
            this.gWt.getPendantView().setDrawBorder(false);
        }
        this.hQP = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.hQP.setVisibility(8);
        this.hQP.setOnClickListener(this.hQU);
        this.eRv = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eRv.setLoadingAnimationListener(this.gWE);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fXb.setForumAfterClickListener(this.eke);
        this.fXa = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fXa.setFrom(3);
        this.fXc = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.fXb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fXb.setLayoutParams(layoutParams);
        }
        this.fXb.setOnClickListener(this);
        this.fXb.setReplyTimeVisible(false);
        this.fXb.setShowPraiseNum(true);
        this.fXb.setNeedAddPraiseIcon(true);
        this.fXb.setNeedAddReplyIcon(true);
        this.fXb.setIsBarViewVisible(false);
        this.fXb.setShareVisible(true);
        this.fXb.setShareReportFrom(1);
        this.fXb.setStType("frs_page");
        this.fXb.setFrom(2);
        this.fXb.ekb = 3;
        this.fXN = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fXN.ekZ.setOnClickListener(this);
        this.fXN.setFrom(2);
        this.fXN.setShareReportFrom(1);
        this.fXN.setSourceFromForPb(3);
        this.fXN.setStType("frs_page");
        this.fXN.setHideBarName(true);
        this.eRp = (FrameLayout) view.findViewById(R.id.frame_video);
        this.eRp.setOnClickListener(this);
        this.eRp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.eRp != null) {
                    a.this.eRp.getViewTreeObserver().addOnGlobalLayoutListener(a.this.eRA);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.eRp != null) {
                    a.this.eRp.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.eRA);
                }
            }
        });
        this.eRr = (TbImageView) view.findViewById(R.id.image_video);
        this.eRr.setPageId(getTag());
        this.eRr.setDefaultErrorResource(0);
        this.eRr.setDrawCorner(true);
        this.eRr.setPlaceHolder(3);
        this.eRr.setEvent(this.eRz);
        this.eRr.setGifIconSupport(false);
        this.eRs = (ImageView) view.findViewById(R.id.image_video_play);
        this.YH = new TbCyberVideoView(getContext());
        bos();
        this.YH.setContinuePlayEnable(true);
        this.YH.setOnPreparedListener(this.dCx);
        this.YH.setOnCompletionListener(this.dCz);
        this.YH.setOnErrorListener(this.dCy);
        this.YH.setOnInfoListener(this.dCA);
        this.YH.setOnSurfaceDestroyedListener(this.eRD);
        this.fss = new f();
        this.fss.setPlayer(this.YH);
        this.fss.a(this.gWJ);
        this.eRw = view.findViewById(R.id.auto_video_black_mask);
        this.eRt = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eRu = view.findViewById(R.id.auto_video_error_background);
        this.fiQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fXY = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.buu = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.fade_out_video_cover);
        this.buu.setAnimationListener(this.gWK);
        this.eRq = (TextView) view.findViewById(R.id.text_video_duration);
        this.eRx = (TextView) view.findViewById(R.id.text_video_play_count);
        this.gYc = (LinearLayout) view.findViewById(R.id.duration_container);
        this.hQR = new i(tbPageContext, this.fWZ);
        this.hQR.setUniqueId(getTag());
        this.gWs = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gWs.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.fXb != null) {
                    a.this.fXb.changeSelectStatus();
                }
            }
        });
        this.fXb.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void id(boolean z) {
                if (a.this.mMaskView != null) {
                    ao.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.gWC = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bos() {
        if (this.YH != null && this.YH.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.eRp.addView(this.YH.getView(), 0);
            this.YH.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fWZ || view == this.fXb.getCommentNumView() || view == this.hQQ) {
            bV(this.fWZ);
        } else if (view == this.eRp) {
            if (this.aeA != null && this.aeA.aWD() != null) {
                z = this.aeA.aWD().is_vertical.intValue() == 1;
            }
            if (z) {
                bT(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cf(this.eRp);
            } else {
                bV(this.eRp);
            }
        } else if (view == this.gWs) {
            bV(this.gWs);
        }
        if (this.aeA != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aeA));
        }
    }

    private void bT(View view) {
        if (bRn() != null) {
            bRn().a(view, this.aeA);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.dVN.getPageActivity(), R.string.no_network_guide);
        } else {
            bRu();
        }
    }

    private void bRu() {
        if (this.aeA != null) {
            String str = "frs";
            if (this.hQT == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aeA);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.aeA.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.aeA.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cf(View view) {
        if (this.aeA != null) {
            ap apVar = new ap("c11100");
            apVar.dn("tid", this.aeA.getId());
            apVar.dn("fid", this.aeA.getFid() + "");
            TiebaStatic.log(apVar);
        }
        if (bRn() != null) {
            bRn().a(view, this.aeA);
        }
        if (view == this.eRp) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.dVN.getPageActivity(), R.string.no_network_guide);
            } else {
                bRv();
            }
        }
    }

    private void bRv() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aeA);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fiQ.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fiQ.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.hQT == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.dVN.getPageActivity(), str, this.aeA.getTid(), com.baidu.tieba.card.m.aVX(), "", videoSerializeVideoThreadInfo);
        if (this.aeA.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.aeA.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bV(View view) {
        String str;
        String str2;
        if (this.aeA != null) {
            if (this.aeA.aXu()) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dn("fid", String.valueOf(this.aeA.getFid())).ah("obj_type", 2));
            } else {
                ap apVar = new ap("c11100");
                apVar.dn("tid", this.aeA.getId());
                apVar.dn("fid", this.aeA.getFid() + "");
                TiebaStatic.log(apVar);
            }
            if (this.aeA.aWl() != null && this.aeA.aWl().getGodUserData() != null && this.aeA.aWl().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ap("c10806").ah("obj_locate", 3).dn("tid", this.aeA.getId()));
            }
        }
        if (bRn() != null) {
            bRn().a(view, this.aeA);
        }
        if (this.aeA != null) {
            com.baidu.tieba.card.m.Ez(this.aeA.getId());
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ab.Au(this.aeA.getId());
            String valueOf = String.valueOf(this.aeA.getFid());
            if (this.aeA.dUt == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aeA.dUt.id;
                str2 = valueOf;
            }
            if (this.aeA.aWI() > 0 && com.baidu.tieba.tbadkCore.util.e.dmp()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.dVN.getPageActivity()).createHistoryCfg(this.aeA.getTid(), String.valueOf(this.aeA.aWI()), false, true, "frs_page");
                String str3 = "frs";
                if (this.hQT == 501) {
                    str3 = "frs_tab";
                } else if (this.aeA.aXu()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aeA.aXA());
                createHistoryCfg.setSmartFrsPosition(this.aeA.aXG());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.gWs) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.dVN.getPageActivity()).createFromThreadCfg(this.aeA, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.hQT == 501) {
                str4 = "frs_tab";
            } else if (this.aeA.aXu()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aeA.aXA());
            createFromThreadCfg.setSmartFrsPosition(this.aeA.aXG());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.gWs) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bv bvVar) {
        this.aeA = bvVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        this.gWD.removeMessages(202);
        if (this.YH.getCurrentPosition() > 0) {
            v(false, 3);
            this.gWD.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gWD.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gWD.removeMessages(203);
        int currentPosition = this.YH.getCurrentPosition();
        if (currentPosition != this.gWw) {
            this.gWw = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.gWD.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.eRs != null && this.eRr != null && this.eRw != null && this.eRv != null && this.eRu != null && this.eRt != null) {
            if (z || this.eRy != i) {
                this.eRy = i;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRC);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRB);
                if (i == 2) {
                    this.eRs.setVisibility(8);
                    this.buu.cancel();
                    this.eRr.clearAnimation();
                    this.eRr.setVisibility(0);
                    this.eRw.setVisibility(0);
                    this.gYc.setVisibility(0);
                    this.eRv.startLoading();
                    this.eRu.setVisibility(8);
                    this.eRt.setVisibility(8);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eRC, 60000L);
                } else if (i == 3) {
                    this.eRs.setVisibility(8);
                    this.eRr.startAnimation(this.buu);
                    this.eRw.setVisibility(8);
                    this.gYc.setVisibility(8);
                    this.eRv.cYW();
                    this.eRu.setVisibility(8);
                    this.eRt.setVisibility(8);
                    if (this.aeA != null && this.aeA.aWD() != null) {
                        this.aeA.aWD().video_length.intValue();
                        this.aeA.aWD().video_duration.intValue();
                        this.aeA.getTid();
                    }
                } else if (i == 4) {
                    this.eRs.setVisibility(8);
                    this.eRr.startAnimation(this.buu);
                    this.eRw.setVisibility(8);
                    this.eRv.cYX();
                    this.eRu.setVisibility(0);
                    this.eRt.setVisibility(0);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.eRB, 2000L);
                } else {
                    this.eRs.setVisibility(0);
                    this.gYc.setVisibility(0);
                    this.buu.cancel();
                    this.eRr.clearAnimation();
                    this.eRr.setVisibility(0);
                    this.eRw.setVisibility(0);
                    this.eRv.cYX();
                    this.eRu.setVisibility(8);
                    this.eRt.setVisibility(8);
                }
            }
        }
    }

    private void X(final bv bvVar) {
        if (this.gYD != null) {
            if (bvVar == null) {
                this.gYD.setVisibility(8);
            } else if (!StringUtils.isNull(bvVar.dUj)) {
                if (this.hQR != null && this.hQR.cja() && (this.gYD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYD.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.dVN.getContext(), R.dimen.tbds106);
                    this.gYD.setLayoutParams(layoutParams);
                }
                this.gYD.setVisibility(0);
                this.gYD.setImageDrawable(null);
                this.gYD.startLoad(bvVar.dUj, 10, false);
                this.gYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.dVN != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bvVar.dUk, true)));
                        }
                        TiebaStatic.log(new ap(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gYD.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aeA == null || this.aeA.aWl() == null) {
            this.fWZ.setVisibility(8);
            return;
        }
        this.fWZ.setVisibility(0);
        this.fWZ.setOnClickListener(this);
        bRA();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dTB)) {
            this.aeA.de(this.mUrl, this.dTB);
        }
        this.aeA.w(false, true);
        SpannableStringBuilder aWV = this.aeA.aWV();
        if (this.aeA.aXb() && !StringUtils.isNull(this.aeA.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aeA.getTid();
            aWV.append((CharSequence) this.aeA.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ap("c12841").dn("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(aWV));
        this.mTextTitle.setText(aWV);
        this.hQR.ax(this.aeA);
        X(this.aeA);
        this.fXa.setData(this.aeA);
        if (this.fXa.getHeaderImg() != null) {
            if (this.fXa.getIsSimpleThread()) {
                this.fXa.getHeaderImg().setVisibility(8);
                this.gWt.setVisibility(8);
            } else if (this.aeA.aWl() == null || this.aeA.aWl().getPendantData() == null || StringUtils.isNull(this.aeA.aWl().getPendantData().aUh())) {
                this.gWt.setVisibility(8);
                this.fXa.getHeaderImg().setVisibility(0);
                this.fXa.getHeaderImg().setData(this.aeA);
            } else {
                this.fXa.getHeaderImg().setVisibility(4);
                this.gWt.setVisibility(0);
                this.gWt.setData(this.aeA);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXb.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.fXb.setLayoutParams(layoutParams);
        this.fXa.setUserAfterClickListener(this.ahD);
        rp(pM(1));
        this.eRq.setText(as.stringForVideoTime(this.aeA.aWD().video_duration.intValue() * 1000));
        this.eRx.setText(String.format(this.dVN.getResources().getString(R.string.play_count), as.numFormatOverWan(this.aeA.aWD().play_count.intValue())));
        this.gWs.setData(this.aeA.aXO());
        this.gWs.onChangeSkinType();
        if (com.baidu.tieba.card.m.EA(this.aeA.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.gWs.getGodReplyContent(), this.aeA.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.aeA == null || this.aeA.aWD() == null) {
            z = false;
        } else {
            z = this.aeA.aWD().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gWC.setVisibility(0);
        } else {
            this.gWC.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) && this.fXb.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aeA.aXW() || this.aeA.aXX() || this.aeA.aXY()) {
                ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRz() {
        this.gWD.removeMessages(202);
        this.gWD.removeMessages(203);
    }

    private void bot() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRB);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRC);
    }

    private void bRA() {
        bot();
        bRz();
        if (this.eRr != null && this.eRp != null && this.YH != null) {
            if (k.aTv().isShowImages() && this.aeA != null && this.aeA.aWD() != null) {
                this.eRp.setVisibility(0);
                this.eRr.setPlaceHolder(3);
                this.eRr.startLoad(this.aeA.aWD().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aeA.aWD().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new ap("c12026").dn("tid", this.aeA.getId()));
                }
                this.YH.setThreadDataForStatistic(this.aeA);
                return;
            }
            this.eRp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fWZ, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.eRs, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.eRt, R.color.cp_cont_a);
            ao.setViewTextColor(this.eRq, R.color.cp_cont_a);
            ao.setViewTextColor(this.eRx, R.color.cp_cont_a);
            ao.setBackgroundColor(this.eRu, R.color.common_color_10014);
            ao.setBackgroundColor(this.fbk, R.color.cp_bg_line_c);
            if (this.eRt != null) {
                this.eRt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.fXN != null && this.fXN.getVisibility() == 0) {
                this.fXN.onChangeSkinType();
            }
            this.fXb.onChangeSkinType();
            this.mSkinType = i;
            this.fXa.onChangeSkinType();
            if (this.gWt != null && this.gWt.getHeadView() != null && (this.gWt.getHeadView() instanceof TbImageView)) {
                this.gWt.getHeadView().setPlaceHolder(1);
            }
            this.eRr.setPlaceHolder(3);
            this.hQR.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.currentPageType = i;
        if (this.fXb != null) {
            this.fXb.ekb = i;
            this.fXb.setFrom(2);
        }
        if (this.fXa != null) {
            this.fXa.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.gWx;
    }

    public boolean isPlaying() {
        if (this.YH == null) {
            return false;
        }
        return this.YH.isPlaying();
    }

    public void startPlay() {
        if (!this.gWx && this.aeA != null && this.aeA.aWD() != null && this.YH != null) {
            this.YH.stopPlayback();
            if (ag.bnb()) {
                if (this.hQS || com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new ap("c12619").dn("obj_locate", "frs").dn("tid", this.aeA.getId()));
                        this.mVideoUrl = this.aeA.aWD().video_url;
                    }
                    this.gWx = true;
                    this.YH.setVideoPath(this.mVideoUrl, this.aeA.getId());
                    if (this.fss != null) {
                        this.fss.start();
                    }
                    bRt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRt() {
        if (this.aeA != null && this.aeA.aWD() != null) {
            String str = this.aeA.aXu() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.hQT == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.ajJ = this.aeA.getTid();
            oVar.eKO = this.aeA.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.aeA.mRecomSource;
            oVar.lcL = this.aeA.mRecomAbTag;
            oVar.lcH = this.aeA.mRecomAbTag;
            oVar.lcI = this.aeA.mRecomWeight;
            oVar.lcJ = "";
            oVar.lcM = this.aeA.aWD().video_md5;
            h.a(this.aeA.aWD().video_md5, "", "1", oVar, this.YH.getPcdnState());
        }
    }

    public void stopPlay() {
        bot();
        bRz();
        v(true, 1);
        if (this.YH != null) {
            this.YH.stopPlayback();
            if (this.fss != null) {
                this.fss.stop();
            }
        }
        this.gWx = false;
    }

    public View getVideoContainer() {
        return this.eRp;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.YH == null) {
            return 0;
        }
        return this.YH.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.YH != null) {
            this.YH.setVideoStatData(oVar);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fXb != null && this.fXa != null) {
            this.fXa.setPageUniqueId(bdUniqueId);
        }
    }

    public void rp(int i) {
        if (this.aeA != null) {
            if (i == 1) {
                this.fXb.setVisibility(8);
                this.fXN.setData(this.aeA);
                this.fXc.setVisibility(8);
                return;
            }
            this.fXb.setData(this.aeA);
            this.fXc.setVisibility(8);
            this.fXN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public int pM(int i) {
        return com.baidu.tieba.a.d.brD().ar(this.afx, i);
    }
}
