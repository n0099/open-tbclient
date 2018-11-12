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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.v;
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
import com.baidu.tieba.play.y;
import com.baidu.tieba.play.z;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private bb aBF;
    private String aBn;
    private final View.OnClickListener aEX;
    private final View.OnClickListener aHa;
    private String arj;
    private Animation bKo;
    private com.baidu.tieba.play.j bKz;
    private String bWE;
    private RelativeLayout bWP;
    public ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    public View bWS;
    private HeadPendantClickableView bXB;
    protected ThreadSourceShareAndPraiseLayout bXE;
    public LinearLayout bXP;
    public ThreadSkinView bXQ;
    private Runnable blA;
    private Runnable blB;
    private QuickVideoView.b blC;
    public FrameLayout blm;
    private TextView bln;
    private TbImageView blo;
    private ImageView blp;
    private QuickVideoView blq;
    private TextView blr;
    private View bls;
    private x blt;
    private View blu;
    private TextView blv;
    private int blw;
    private TbImageView.a blx;
    private g.b bly;
    private ViewTreeObserver.OnGlobalLayoutListener blz;
    private g.a bul;
    private g.f bum;
    private g.e buo;
    private View bvs;
    private ThreadGodReplyLayout cLJ;
    private View.OnClickListener cNP;
    private com.baidu.tieba.play.g cNR;
    private k cNT;
    private int cNV;
    private boolean cNW;
    private TextView cOb;
    private Handler cOc;
    private VideoLoadingProgressView.a cOd;
    private j.a cOh;
    private Animation.AnimationListener cOi;
    private LinearLayout cPy;
    private n cQP;
    private TbImageView cQb;
    public TextView dKE;
    public LinearLayout dKF;
    private com.baidu.tieba.frs.vc.g dKG;
    public boolean dKH;
    public int dKI;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void any() {
        if (this.cNR != null && this.cNW) {
            try {
                this.blq.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cOc.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cNV = 0;
        this.blw = 1;
        this.cNW = false;
        this.cOc = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.anC();
                        return;
                    case 203:
                        a.this.anD();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bum = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cNR = gVar;
                if (a.this.cNR != null) {
                    a.this.cNR.setVolume(0.0f, 0.0f);
                }
                a.this.cNT.baU();
                a.this.any();
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.e(false, 3);
                }
                return false;
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                y.bqk().remove(a.this.aBn);
                a.this.blq.start();
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.amS();
                a.this.e(true, 4);
                a.this.cNW = false;
                return true;
            }
        };
        this.cOd = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.any();
            }
        };
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && a.this.blo != null) {
                    a.this.blo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.blz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.blm != null && a.this.blm.getLayoutParams() != null && a.this.blm.getVisibility() != 8) {
                    a.this.blm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.blm.getLayoutParams();
                    if (a.this.blm.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.blm.getWidth() * 0.5625d);
                        a.this.blm.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.blA = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.blq != null && !a.this.blq.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.blB = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.amS();
                a.this.e(true, 4);
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cNP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aBF != null && !StringUtils.isNull(a.this.aBF.yI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.aBF.yI(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aEX != null) {
                        a.this.aEX.onClick(view);
                    }
                }
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.aBF);
                }
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aBF != null && a.this.anq() != null) {
                    a.this.anq().a(view, a.this.aBF);
                }
            }
        };
        this.cOh = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void anG() {
                a.this.anz();
            }
        };
        this.cOi = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.blw == 3 && a.this.blo != null) {
                    a.this.blo.setVisibility(8);
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
        this.bvs = view.findViewById(e.g.divider_line);
        this.bWP = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cQb = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.dKF = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bWP.setOnClickListener(this);
        this.bXB = (HeadPendantClickableView) this.bWP.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), e.C0200e.ds70));
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.dKE = (TextView) view.findViewById(e.g.thread_info_bar_name);
        this.dKE.setVisibility(8);
        this.dKE.setOnClickListener(this.cNP);
        this.blt = new x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.blt.setLoadingAnimationListener(this.cOd);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.bWR.setForumAfterClickListener(this.aEX);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.bWQ.setFrom(3);
        this.bWS = view.findViewById(e.g.divider_below_reply_number_layout);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setShareVisible(true);
        this.bWR.setShareReportFrom(1);
        this.bWR.setStType("frs_page");
        this.bWR.setFrom(2);
        this.bWR.setDisPraiseFrom(2);
        this.bWR.asl = 3;
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.bXE.aGI.setOnClickListener(this);
        this.bXE.setFrom(2);
        this.bXE.setShareReportFrom(1);
        this.bXE.setSourceFromForPb(3);
        this.bXE.setStType("frs_page");
        this.bXE.setHideBarName(true);
        this.blm = (FrameLayout) view.findViewById(e.g.frame_video);
        this.blm.setOnClickListener(this);
        this.blm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.blm != null) {
                    a.this.blm.getViewTreeObserver().addOnGlobalLayoutListener(a.this.blz);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.blm != null) {
                    a.this.blm.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.blz);
                }
            }
        });
        this.blo = (TbImageView) view.findViewById(e.g.image_video);
        this.blo.setPageId(getTag());
        this.blo.setDefaultErrorResource(0);
        this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.blo.setEvent(this.blx);
        this.blo.setGifIconSupport(false);
        this.blp = (ImageView) view.findViewById(e.g.image_video_play);
        this.blq = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.cQP = new n(this.mContext.getPageActivity());
        this.blq.setPlayerReuseEnable(true);
        this.blq.setContinuePlayEnable(true);
        this.blq.setBusiness(this.cQP);
        this.blq.setOnPreparedListener(this.bum);
        this.blq.setOnCompletionListener(this.bul);
        this.blq.setOnErrorListener(this.bly);
        this.blq.setOnOutInfoListener(this.buo);
        this.blq.setOnSurfaceDestroyedListener(this.blC);
        this.bKz = new com.baidu.tieba.play.j();
        this.bKz.setPlayer(this.blq);
        this.bKz.a(this.cOh);
        this.blu = view.findViewById(e.g.auto_video_black_mask);
        this.blr = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bls = view.findViewById(e.g.auto_video_error_background);
        this.bXP = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bXQ = (ThreadSkinView) view.findViewById(e.g.frs_thread_skin);
        this.bKo = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.fade_out_video_cover);
        this.bKo.setAnimationListener(this.cOi);
        this.bln = (TextView) view.findViewById(e.g.text_video_duration);
        this.blv = (TextView) view.findViewById(e.g.text_video_play_count);
        this.cPy = (LinearLayout) view.findViewById(e.g.duration_container);
        this.dKG = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bWP);
        this.dKG.setUniqueId(getTag());
        this.cLJ = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cLJ.setOnClickListener(this);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bWR != null) {
                    a.this.bWR.changeSelectStatus();
                }
            }
        });
        this.bWR.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bI(boolean z) {
                if (a.this.mMaskView != null) {
                    al.j(a.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            }
        });
        this.cOb = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cNT = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bWP || view == this.bWR.getCommentNumView() || view == this.dKF) {
            aC(this.bWP);
        } else if (view == this.blm) {
            if (this.aBF != null && this.aBF.yU() != null) {
                z = this.aBF.yU().is_vertical.intValue() == 1;
            }
            if (z) {
                aA(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aN(this.blm);
            } else {
                aC(this.blm);
            }
        } else if (view == this.cLJ) {
            aC(this.cLJ);
        }
        if (this.aBF != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aBF));
        }
    }

    private void aA(View view) {
        if (anq() != null) {
            anq().a(view, this.aBF);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anA();
        }
    }

    private void anA() {
        if (this.aBF != null) {
            String str = "frs";
            if (this.dKI == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aBF);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void aN(View view) {
        if (this.aBF != null) {
            am amVar = new am("c11100");
            amVar.ax("tid", this.aBF.getId());
            amVar.ax(ImageViewerConfig.FORUM_ID, this.aBF.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (anq() != null) {
            anq().a(view, this.aBF);
        }
        if (view == this.blm) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
            } else {
                anB();
            }
        }
    }

    private void anB() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aBF);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bXP.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bXP.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.dKI == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.aBF.getTid(), o.yq(), "", videoSerializeVideoThreadInfo)));
    }

    private void aC(View view) {
        String str;
        String str2;
        if (this.aBF != null) {
            if (this.aBF.zv()) {
                TiebaStatic.log(new am("c10242").ax(ImageViewerConfig.FORUM_ID, String.valueOf(this.aBF.getFid())).x("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.ax("tid", this.aBF.getId());
                amVar.ax(ImageViewerConfig.FORUM_ID, this.aBF.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.aBF.yC() != null && this.aBF.yC().getGodUserData() != null && this.aBF.yC().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").x("obj_locate", 3).ax("tid", this.aBF.getId()));
            }
        }
        if (anq() != null) {
            anq().a(view, this.aBF);
        }
        if (this.aBF != null) {
            o.me(this.aBF.getId());
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            v.is(this.aBF.getId());
            String valueOf = String.valueOf(this.aBF.getFid());
            if (this.aBF.asc == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aBF.asc.id;
                str2 = valueOf;
            }
            if (this.aBF.yZ() > 0 && com.baidu.tieba.tbadkCore.util.e.bCw()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.aBF.getTid(), String.valueOf(this.aBF.yZ()), false, true, "frs_page");
                String str3 = "frs";
                if (this.dKI == 501) {
                    str3 = "frs_tab";
                } else if (this.aBF.zv()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aBF.zE());
                createHistoryCfg.setSmartFrsPosition(this.aBF.zL());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cLJ) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.aBF, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.dKI == 501) {
                str4 = "frs_tab";
            } else if (this.aBF.zv()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aBF.zE());
            createFromThreadCfg.setSmartFrsPosition(this.aBF.zL());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cLJ) {
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
        this.aBF = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anC() {
        this.cOc.removeMessages(202);
        if (this.blq.getCurrentPosition() > 0) {
            e(false, 3);
            this.cOc.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cOc.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cOc.removeMessages(203);
        int currentPosition = this.blq.getCurrentPosition();
        if (currentPosition != this.cNV) {
            this.cNV = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cOc.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.blp != null && this.blo != null && this.blu != null && this.blt != null && this.bls != null && this.blr != null) {
            if (z || this.blw != i) {
                this.blw = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blB);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blA);
                if (i == 2) {
                    this.blp.setVisibility(8);
                    this.bKo.cancel();
                    this.blo.clearAnimation();
                    this.blo.setVisibility(0);
                    this.blu.setVisibility(0);
                    this.cPy.setVisibility(0);
                    this.blt.startLoading();
                    this.bls.setVisibility(8);
                    this.blr.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.blB, 60000L);
                } else if (i == 3) {
                    this.blp.setVisibility(8);
                    this.blo.startAnimation(this.bKo);
                    this.blu.setVisibility(8);
                    this.cPy.setVisibility(8);
                    this.blt.bqf();
                    this.bls.setVisibility(8);
                    this.blr.setVisibility(8);
                    if (this.aBF != null && this.aBF.yU() != null) {
                        this.cNT.a(this.aBF.getTid(), this.aBF.yU().video_length.intValue(), this.aBF.yU().video_duration.intValue(), "frs", this.blq);
                    }
                } else if (i == 4) {
                    this.blp.setVisibility(8);
                    this.blo.startAnimation(this.bKo);
                    this.blu.setVisibility(8);
                    this.blt.bqg();
                    this.bls.setVisibility(0);
                    this.blr.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.blA, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.blp.setVisibility(0);
                    this.cPy.setVisibility(0);
                    this.bKo.cancel();
                    this.blo.clearAnimation();
                    this.blo.setVisibility(0);
                    this.blu.setVisibility(0);
                    this.blt.bqg();
                    this.bls.setVisibility(8);
                    this.blr.setVisibility(8);
                }
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cQb != null) {
            if (bbVar == null) {
                this.cQb.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arU)) {
                if (this.dKG != null && this.dKG.aFG() && (this.cQb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cQb.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), e.C0200e.tbds106);
                    this.cQb.setLayoutParams(layoutParams);
                }
                this.cQb.setVisibility(0);
                this.cQb.setImageDrawable(null);
                this.cQb.startLoad(bbVar.arU, 10, false);
                this.cQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.arV, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cQb.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aBF == null || this.aBF.yC() == null) {
            this.bWP.setVisibility(8);
            return;
        }
        this.bWP.setVisibility(0);
        this.bWP.setOnClickListener(this);
        anE();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.arj)) {
            this.aBF.ai(this.mUrl, this.arj);
        }
        this.aBF.g(false, true);
        SpannableStringBuilder zc = this.aBF.zc();
        if (this.aBF.zj() && !StringUtils.isNull(this.aBF.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aBF.getTid();
            zc.append((CharSequence) this.aBF.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(zc));
        this.mTextTitle.setText(zc);
        this.dKG.af(this.aBF);
        N(this.aBF);
        this.bWQ.setData(this.aBF);
        if (this.bWQ.getHeaderImg() != null) {
            if (this.bWQ.getIsSimpleThread()) {
                this.bWQ.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (this.aBF.yC() == null || this.aBF.yC().getPendantData() == null || StringUtils.isNull(this.aBF.yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.bWQ.getHeaderImg().setVisibility(0);
                this.bWQ.getHeaderImg().setData(this.aBF);
            } else {
                this.bWQ.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(this.aBF);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bWR.setLayoutParams(layoutParams);
        this.bWQ.setUserAfterClickListener(this.aHa);
        ix(ho(1));
        this.bln.setText(ao.dH(this.aBF.yU().video_duration.intValue() * 1000));
        this.blv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.P(this.aBF.yU().play_count.intValue())));
        this.cLJ.setData(this.aBF.zT());
        this.cLJ.onChangeSkinType();
        if (o.mf(this.aBF.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            o.a(this.cLJ.getGodReplyContent(), this.aBF.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.aBF == null || this.aBF.yU() == null) {
            z = false;
        } else {
            z = this.aBF.yU().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cOb.setVisibility(0);
        } else {
            this.cOb.setVisibility(8);
        }
        if (this.bWR.isInFrsAllThread() && com.baidu.tieba.frs.a.ayk().ayl()) {
            this.mMaskView.setVisibility(0);
            if (this.aBF.Ad() || this.aBF.Ae()) {
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
    public void amS() {
        this.cOc.removeMessages(202);
        this.cOc.removeMessages(203);
    }

    private void QE() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blA);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blB);
    }

    private void anE() {
        QE();
        amS();
        if (this.blo != null && this.blm != null && this.blq != null) {
            if (com.baidu.tbadk.core.i.wA().wE() && this.aBF != null && this.aBF.yU() != null) {
                this.blm.setVisibility(0);
                this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.blo.startLoad(this.aBF.yU().thumbnail_url, 10, false);
                stopPlay();
                this.aBn = this.aBF.yU().video_url;
                if (StringUtils.isNull(this.aBn)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").ax("tid", this.aBF.getId()));
                }
                if (this.cQP != null && this.cQP.bpO() != null) {
                    this.cQP.bpO().g(this.aBF.yU());
                }
                this.blq.co(this.aBn, this.aBF.tid);
                return;
            }
            this.blm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bWP, e.f.addresslist_item_bg);
            al.c(this.blp, e.f.btn_icon_play_video_n);
            al.h(this.blr, e.d.cp_cont_i);
            al.h(this.bln, e.d.cp_cont_i);
            al.h(this.blv, e.d.cp_cont_i);
            al.j(this.bls, e.d.common_color_10014);
            al.j(this.bvs, e.d.cp_bg_line_e);
            if (this.blr != null) {
                this.blr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bXE != null && this.bXE.getVisibility() == 0) {
                this.bXE.onChangeSkinType();
            }
            this.bWR.onChangeSkinType();
            this.mSkinType = i;
            this.bWQ.onChangeSkinType();
            this.dKG.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iv(int i) {
        this.currentPageType = i;
        if (this.bWR != null) {
            this.bWR.asl = i;
            if (i == 15) {
                this.bWR.setFrom(10);
            } else {
                this.bWR.setFrom(2);
                this.bWR.setDisPraiseFrom(2);
            }
        }
        if (this.bWQ != null) {
            if (i == 15) {
                this.bWQ.setFrom(5);
            } else {
                this.bWQ.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cNW;
    }

    public boolean isPlaying() {
        if (this.blq == null) {
            return false;
        }
        return this.blq.isPlaying();
    }

    public void startPlay() {
        if (!this.cNW && this.aBF != null && this.aBF.yU() != null && this.blq != null) {
            this.blq.stopPlayback();
            if (aa.Ph()) {
                if (this.dKH || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.cNT.baT();
                    e(true, 2);
                    if (StringUtils.isNull(this.aBn)) {
                        TiebaStatic.log(new am("c12619").ax("obj_locate", "frs").ax("tid", this.aBF.getId()));
                        this.aBn = this.aBF.yU().video_url;
                    }
                    this.cNW = true;
                    this.blq.setVideoPath(this.aBn, this.aBF.getId());
                    if (this.bKz != null) {
                        this.bKz.start();
                    }
                    anz();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anz() {
        if (this.aBF != null && this.aBF.yU() != null) {
            String str = this.aBF.zv() ? "floor5" : "frs";
            if (this.aBF.yH()) {
                str = "frs_mcn";
            }
            if (this.dKI == 501) {
                str = "frs_tab";
            }
            z zVar = new z();
            zVar.mLocate = str;
            zVar.beV = this.aBF.getTid();
            zVar.cRh = this.aBF.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.aBF.mRecomSource;
            zVar.gxX = this.aBF.mRecomAbTag;
            zVar.gxY = this.aBF.mRecomWeight;
            zVar.gxZ = "";
            zVar.gyb = this.aBF.yU().video_md5;
            com.baidu.tieba.play.l.a(this.aBF.yU().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        QE();
        amS();
        e(true, 1);
        if (this.blq != null) {
            this.blq.stopPlayback();
            if (this.bKz != null) {
                this.bKz.stop();
            }
        }
        this.cNW = false;
    }

    public ThreadCommentAndPraiseInfoLayout abi() {
        return this.bWR;
    }

    public ThreadCommentAndPraiseInfoLayout abj() {
        return this.bXE.aGI;
    }

    public View getVideoContainer() {
        return this.blm;
    }

    public String getPlayUrl() {
        return this.aBn;
    }

    public int getCurrentPosition() {
        if (this.blq == null) {
            return 0;
        }
        return this.blq.getCurrentPosition();
    }

    public void setVideoStatsData(z zVar) {
        if (this.cQP != null) {
            this.cQP.setVideoStatsData(zVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWR != null && this.bWQ != null) {
            this.bWQ.setPageUniqueId(bdUniqueId);
        }
    }

    public void ix(int i) {
        if (this.aBF != null) {
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setData(this.aBF);
                this.bWS.setVisibility(8);
                return;
            }
            this.bWR.setData(this.aBF);
            this.bWS.setVisibility(8);
            this.bXE.setVisibility(8);
        }
    }

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.arj = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.blo.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.blo.setOnDrawListener(null);
        }
    }
}
