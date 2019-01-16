package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Canvas;
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
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.j.k;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.play.z;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private bb aFI;
    private String aFq;
    private final View.OnClickListener aJa;
    private final View.OnClickListener aLe;
    private String avl;
    private Animation bOS;
    private com.baidu.tieba.play.j bPc;
    public FrameLayout bpB;
    private TextView bpC;
    private TbImageView bpD;
    private ImageView bpE;
    private QuickVideoView bpF;
    private TextView bpG;
    private View bpH;
    private x bpI;
    private View bpJ;
    private TextView bpK;
    private int bpL;
    private TbImageView.a bpM;
    private g.b bpN;
    private ViewTreeObserver.OnGlobalLayoutListener bpO;
    private Runnable bpP;
    private Runnable bpQ;
    private QuickVideoView.b bpR;
    private g.f byA;
    private g.e byC;
    private g.a byz;
    private View bzG;
    private ThreadGodReplyLayout cVR;
    private View.OnClickListener cXX;
    private com.baidu.tieba.play.g cXZ;
    private k cYb;
    private int cYd;
    private boolean cYe;
    private TextView cYj;
    private Handler cYk;
    private VideoLoadingProgressView.a cYl;
    private j.a cYp;
    private Animation.AnimationListener cYq;
    private LinearLayout cZG;
    private String cbk;
    private RelativeLayout cbv;
    public ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    public View cby;
    private HeadPendantClickableView cch;
    protected ThreadSourceShareAndPraiseLayout cck;
    public LinearLayout ccw;
    public ThreadSkinView ccx;
    public TextView dUE;
    public LinearLayout dUF;
    private com.baidu.tieba.frs.vc.g dUG;
    public boolean dUH;
    public int dUI;
    private n daZ;
    private TbImageView daj;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        if (this.cXZ != null && this.cYe) {
            try {
                this.bpF.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cYk.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cYd = 0;
        this.bpL = 1;
        this.cYe = false;
        this.cYk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aqB();
                        return;
                    case 203:
                        a.this.aqC();
                        return;
                    default:
                        return;
                }
            }
        };
        this.byA = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cXZ = gVar;
                if (a.this.cXZ != null) {
                    a.this.cXZ.setVolume(0.0f, 0.0f);
                }
                a.this.cYb.bdY();
                a.this.aqx();
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.e(false, 3);
                }
                return false;
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                a.this.bpF.start();
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.apR();
                a.this.e(true, 4);
                a.this.cYe = false;
                return true;
            }
        };
        this.cYl = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aqx();
            }
        };
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && a.this.bpD != null) {
                    a.this.bpD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bpB != null && a.this.bpB.getLayoutParams() != null && a.this.bpB.getVisibility() != 8) {
                    a.this.bpB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bpB.getLayoutParams();
                    if (a.this.bpB.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bpB.getWidth() * 0.5625d);
                        a.this.bpB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bpP = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bpF != null && !a.this.bpF.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.apR();
                a.this.e(true, 4);
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cXX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFI != null && !StringUtils.isNull(a.this.aFI.zZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.aFI.zZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aJa != null) {
                        a.this.aJa.onClick(view);
                    }
                }
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.aFI);
                }
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFI != null && a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.aFI);
                }
            }
        };
        this.cYp = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void aqF() {
                a.this.aqy();
            }
        };
        this.cYq = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bpL == 3 && a.this.bpD != null) {
                    a.this.bpD.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mContext = tbPageContext;
        View view = getView();
        this.bzG = view.findViewById(e.g.divider_line);
        this.cbv = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.daj = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.dUF = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.cbv.setOnClickListener(this);
        this.cch = (HeadPendantClickableView) this.cbv.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.dUE = (TextView) view.findViewById(e.g.thread_info_bar_name);
        this.dUE.setVisibility(8);
        this.dUE.setOnClickListener(this.cXX);
        this.bpI = new x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bpI.setLoadingAnimationListener(this.cYl);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.cbx.setForumAfterClickListener(this.aJa);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.cbw.setFrom(3);
        this.cby = view.findViewById(e.g.divider_below_reply_number_layout);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setShareVisible(true);
        this.cbx.setShareReportFrom(1);
        this.cbx.setStType("frs_page");
        this.cbx.setFrom(2);
        this.cbx.setDisPraiseFrom(2);
        this.cbx.awo = 3;
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.cck.aKM.setOnClickListener(this);
        this.cck.setFrom(2);
        this.cck.setShareReportFrom(1);
        this.cck.setSourceFromForPb(3);
        this.cck.setStType("frs_page");
        this.cck.setHideBarName(true);
        this.bpB = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bpB.setOnClickListener(this);
        this.bpB.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bpB != null) {
                    a.this.bpB.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bpO);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bpB != null) {
                    a.this.bpB.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bpO);
                }
            }
        });
        this.bpD = (TbImageView) view.findViewById(e.g.image_video);
        this.bpD.setPageId(getTag());
        this.bpD.setDefaultErrorResource(0);
        this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpD.setEvent(this.bpM);
        this.bpD.setGifIconSupport(false);
        this.bpE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bpF = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.daZ = new n(this.mContext.getPageActivity());
        this.bpF.setPlayerReuseEnable(true);
        this.bpF.setContinuePlayEnable(true);
        this.bpF.setBusiness(this.daZ);
        this.bpF.setOnPreparedListener(this.byA);
        this.bpF.setOnCompletionListener(this.byz);
        this.bpF.setOnErrorListener(this.bpN);
        this.bpF.setOnOutInfoListener(this.byC);
        this.bpF.setOnSurfaceDestroyedListener(this.bpR);
        this.bPc = new com.baidu.tieba.play.j();
        this.bPc.setPlayer(this.bpF);
        this.bPc.a(this.cYp);
        this.bpJ = view.findViewById(e.g.auto_video_black_mask);
        this.bpG = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bpH = view.findViewById(e.g.auto_video_error_background);
        this.ccw = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.ccx = (ThreadSkinView) view.findViewById(e.g.frs_thread_skin);
        this.bOS = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.fade_out_video_cover);
        this.bOS.setAnimationListener(this.cYq);
        this.bpC = (TextView) view.findViewById(e.g.text_video_duration);
        this.bpK = (TextView) view.findViewById(e.g.text_video_play_count);
        this.cZG = (LinearLayout) view.findViewById(e.g.duration_container);
        this.dUG = new com.baidu.tieba.frs.vc.g(tbPageContext, this.cbv);
        this.dUG.setUniqueId(getTag());
        this.cVR = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVR.setOnClickListener(this);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cbx != null) {
                    a.this.cbx.changeSelectStatus();
                }
            }
        });
        this.cbx.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bK(boolean z) {
                if (a.this.mMaskView != null) {
                    al.j(a.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            }
        });
        this.cYj = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cYb = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.cbv || view == this.cbx.getCommentNumView() || view == this.dUF) {
            aF(this.cbv);
        } else if (view == this.bpB) {
            if (this.aFI != null && this.aFI.Al() != null) {
                z = this.aFI.Al().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aQ(this.bpB);
            } else {
                aF(this.bpB);
            }
        } else if (view == this.cVR) {
            aF(this.cVR);
        }
        if (this.aFI != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFI));
        }
    }

    private void aD(View view) {
        if (aqp() != null) {
            aqp().a(view, this.aFI);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aqz() {
        if (this.aFI != null) {
            String str = "frs";
            if (this.dUI == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aFI);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void aQ(View view) {
        if (this.aFI != null) {
            am amVar = new am("c11100");
            amVar.aB("tid", this.aFI.getId());
            amVar.aB(ImageViewerConfig.FORUM_ID, this.aFI.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (aqp() != null) {
            aqp().a(view, this.aFI);
        }
        if (view == this.bpB) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
            } else {
                aqA();
            }
        }
    }

    private void aqA() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aFI);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.ccw.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.ccw.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.dUI == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.aFI.getTid(), o.zH(), "", videoSerializeVideoThreadInfo)));
    }

    private void aF(View view) {
        String str;
        String str2;
        if (this.aFI != null) {
            if (this.aFI.AM()) {
                TiebaStatic.log(new am("c10242").aB(ImageViewerConfig.FORUM_ID, String.valueOf(this.aFI.getFid())).y("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.aB("tid", this.aFI.getId());
                amVar.aB(ImageViewerConfig.FORUM_ID, this.aFI.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.aFI.zT() != null && this.aFI.zT().getGodUserData() != null && this.aFI.zT().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").y("obj_locate", 3).aB("tid", this.aFI.getId()));
            }
        }
        if (aqp() != null) {
            aqp().a(view, this.aFI);
        }
        if (this.aFI != null) {
            o.mW(this.aFI.getId());
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            w.jb(this.aFI.getId());
            String valueOf = String.valueOf(this.aFI.getFid());
            if (this.aFI.awe == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aFI.awe.id;
                str2 = valueOf;
            }
            if (this.aFI.Aq() > 0 && com.baidu.tieba.tbadkCore.util.e.bFR()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.aFI.getTid(), String.valueOf(this.aFI.Aq()), false, true, "frs_page");
                String str3 = "frs";
                if (this.dUI == 501) {
                    str3 = "frs_tab";
                } else if (this.aFI.AM()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aFI.AV());
                createHistoryCfg.setSmartFrsPosition(this.aFI.Bc());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cVR) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.aFI, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.dUI == 501) {
                str4 = "frs_tab";
            } else if (this.aFI.AM()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aFI.AV());
            createFromThreadCfg.setSmartFrsPosition(this.aFI.Bc());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cVR) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        this.aFI = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqB() {
        this.cYk.removeMessages(202);
        if (this.bpF.getCurrentPosition() > 0) {
            e(false, 3);
            this.cYk.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cYk.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqC() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cYk.removeMessages(203);
        int currentPosition = this.bpF.getCurrentPosition();
        if (currentPosition != this.cYd) {
            this.cYd = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cYk.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bpE != null && this.bpD != null && this.bpJ != null && this.bpI != null && this.bpH != null && this.bpG != null) {
            if (z || this.bpL != i) {
                this.bpL = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpP);
                if (i == 2) {
                    this.bpE.setVisibility(8);
                    this.bOS.cancel();
                    this.bpD.clearAnimation();
                    this.bpD.setVisibility(0);
                    this.bpJ.setVisibility(0);
                    this.cZG.setVisibility(0);
                    this.bpI.startLoading();
                    this.bpH.setVisibility(8);
                    this.bpG.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpQ, 60000L);
                } else if (i == 3) {
                    this.bpE.setVisibility(8);
                    this.bpD.startAnimation(this.bOS);
                    this.bpJ.setVisibility(8);
                    this.cZG.setVisibility(8);
                    this.bpI.bts();
                    this.bpH.setVisibility(8);
                    this.bpG.setVisibility(8);
                    if (this.aFI != null && this.aFI.Al() != null) {
                        this.cYb.a(this.aFI.getTid(), this.aFI.Al().video_length.intValue(), this.aFI.Al().video_duration.intValue(), "frs", this.bpF);
                    }
                } else if (i == 4) {
                    this.bpE.setVisibility(8);
                    this.bpD.startAnimation(this.bOS);
                    this.bpJ.setVisibility(8);
                    this.bpI.btt();
                    this.bpH.setVisibility(0);
                    this.bpG.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpP, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.bpE.setVisibility(0);
                    this.cZG.setVisibility(0);
                    this.bOS.cancel();
                    this.bpD.clearAnimation();
                    this.bpD.setVisibility(0);
                    this.bpJ.setVisibility(0);
                    this.bpI.btt();
                    this.bpH.setVisibility(8);
                    this.bpG.setVisibility(8);
                }
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.daj != null) {
            if (bbVar == null) {
                this.daj.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avW)) {
                if (this.dUG != null && this.dUG.aIE() && (this.daj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.daj.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), e.C0210e.tbds106);
                    this.daj.setLayoutParams(layoutParams);
                }
                this.daj.setVisibility(0);
                this.daj.setImageDrawable(null);
                this.daj.startLoad(bbVar.avW, 10, false);
                this.daj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.avX, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.daj.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aFI == null || this.aFI.zT() == null) {
            this.cbv.setVisibility(8);
            return;
        }
        this.cbv.setVisibility(0);
        this.cbv.setOnClickListener(this);
        aqD();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.avl)) {
            this.aFI.am(this.mUrl, this.avl);
        }
        this.aFI.g(false, true);
        SpannableStringBuilder At = this.aFI.At();
        if (this.aFI.AA() && !StringUtils.isNull(this.aFI.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aFI.getTid();
            At.append((CharSequence) this.aFI.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(At));
        this.mTextTitle.setText(At);
        this.dUG.af(this.aFI);
        N(this.aFI);
        this.cbw.setData(this.aFI);
        if (this.cbw.getHeaderImg() != null) {
            if (this.cbw.getIsSimpleThread()) {
                this.cbw.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (this.aFI.zT() == null || this.aFI.zT().getPendantData() == null || StringUtils.isNull(this.aFI.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.cbw.getHeaderImg().setVisibility(0);
                this.cbw.getHeaderImg().setData(this.aFI);
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(this.aFI);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.cbx.setLayoutParams(layoutParams);
        this.cbw.setUserAfterClickListener(this.aLe);
        iM(hD(1));
        this.bpC.setText(ao.dV(this.aFI.Al().video_duration.intValue() * 1000));
        this.bpK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.aFI.Al().play_count.intValue())));
        this.cVR.setData(this.aFI.Bk());
        this.cVR.onChangeSkinType();
        if (o.mX(this.aFI.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            o.a(this.cVR.getGodReplyContent(), this.aFI.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.aFI == null || this.aFI.Al() == null) {
            z = false;
        } else {
            z = this.aFI.Al().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cYj.setVisibility(0);
        } else {
            this.cYj.setVisibility(8);
        }
        if (this.cbx.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.mMaskView.setVisibility(0);
            if (this.aFI.Bu() || this.aFI.Bv()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apR() {
        this.cYk.removeMessages(202);
        this.cYk.removeMessages(203);
    }

    private void Si() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpP);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
    }

    private void aqD() {
        Si();
        apR();
        if (this.bpD != null && this.bpB != null && this.bpF != null) {
            if (com.baidu.tbadk.core.i.xR().xV() && this.aFI != null && this.aFI.Al() != null) {
                this.bpB.setVisibility(0);
                this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpD.startLoad(this.aFI.Al().thumbnail_url, 10, false);
                stopPlay();
                this.aFq = this.aFI.Al().video_url;
                if (StringUtils.isNull(this.aFq)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").aB("tid", this.aFI.getId()));
                }
                if (this.daZ != null && this.daZ.btb() != null) {
                    this.daZ.btb().g(this.aFI.Al());
                }
                this.bpF.cu(this.aFq, this.aFI.tid);
                return;
            }
            this.bpB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cbv, e.f.addresslist_item_bg);
            al.c(this.bpE, e.f.btn_icon_play_video_n);
            al.h(this.bpG, e.d.cp_cont_i);
            al.h(this.bpC, e.d.cp_cont_i);
            al.h(this.bpK, e.d.cp_cont_i);
            al.j(this.bpH, e.d.common_color_10014);
            al.j(this.bzG, e.d.cp_bg_line_e);
            if (this.bpG != null) {
                this.bpG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.cck != null && this.cck.getVisibility() == 0) {
                this.cck.onChangeSkinType();
            }
            this.cbx.onChangeSkinType();
            this.mSkinType = i;
            this.cbw.onChangeSkinType();
            this.dUG.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.currentPageType = i;
        if (this.cbx != null) {
            this.cbx.awo = i;
            if (i == 15) {
                this.cbx.setFrom(10);
            } else {
                this.cbx.setFrom(2);
                this.cbx.setDisPraiseFrom(2);
            }
        }
        if (this.cbw != null) {
            if (i == 15) {
                this.cbw.setFrom(5);
            } else {
                this.cbw.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cYe;
    }

    public boolean isPlaying() {
        if (this.bpF == null) {
            return false;
        }
        return this.bpF.isPlaying();
    }

    public void startPlay() {
        if (!this.cYe && this.aFI != null && this.aFI.Al() != null && this.bpF != null) {
            this.bpF.stopPlayback();
            if (com.baidu.tbadk.util.ab.QK()) {
                if (this.dUH || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.cYb.bdX();
                    e(true, 2);
                    if (StringUtils.isNull(this.aFq)) {
                        TiebaStatic.log(new am("c12619").aB("obj_locate", "frs").aB("tid", this.aFI.getId()));
                        this.aFq = this.aFI.Al().video_url;
                    }
                    this.cYe = true;
                    this.bpF.setVideoPath(this.aFq, this.aFI.getId());
                    if (this.bPc != null) {
                        this.bPc.start();
                    }
                    aqy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.aFI != null && this.aFI.Al() != null) {
            String str = this.aFI.AM() ? "floor5" : "frs";
            if (this.aFI.zY()) {
                str = "frs_mcn";
            }
            if (this.dUI == 501) {
                str = "frs_tab";
            }
            z zVar = new z();
            zVar.mLocate = str;
            zVar.bjm = this.aFI.getTid();
            zVar.dbr = this.aFI.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.aFI.mRecomSource;
            zVar.gII = this.aFI.mRecomAbTag;
            zVar.gIJ = this.aFI.mRecomWeight;
            zVar.gIK = "";
            zVar.gIM = this.aFI.Al().video_md5;
            com.baidu.tieba.play.l.a(this.aFI.Al().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        Si();
        apR();
        e(true, 1);
        if (this.bpF != null) {
            this.bpF.stopPlayback();
            if (this.bPc != null) {
                this.bPc.stop();
            }
        }
        this.cYe = false;
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cbx;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        return this.cck.aKM;
    }

    public View getVideoContainer() {
        return this.bpB;
    }

    public String getPlayUrl() {
        return this.aFq;
    }

    public int getCurrentPosition() {
        if (this.bpF == null) {
            return 0;
        }
        return this.bpF.getCurrentPosition();
    }

    public void setVideoStatsData(z zVar) {
        if (this.daZ != null) {
            this.daZ.setVideoStatsData(zVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cbx != null && this.cbw != null) {
            this.cbw.setPageUniqueId(bdUniqueId);
        }
    }

    public void iM(int i) {
        if (this.aFI != null) {
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setData(this.aFI);
                this.cby.setVisibility(8);
                return;
            }
            this.cbx.setData(this.aFI);
            this.cby.setVisibility(8);
            this.cck.setVisibility(8);
        }
    }

    public void am(String str, String str2) {
        this.mUrl = str;
        this.avl = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bpD.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bpD.setOnDrawListener(null);
        }
    }
}
