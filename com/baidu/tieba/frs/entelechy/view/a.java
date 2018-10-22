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
    private bb aAQ;
    private String aAy;
    private final View.OnClickListener aEh;
    private final View.OnClickListener aGk;
    private String aqw;
    private Animation bJD;
    private com.baidu.tieba.play.j bJO;
    private String bVS;
    private HeadPendantClickableView bWP;
    protected ThreadSourceShareAndPraiseLayout bWS;
    private RelativeLayout bWd;
    public ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    public View bWg;
    public LinearLayout bXd;
    public ThreadSkinView bXe;
    public FrameLayout bkB;
    private TextView bkC;
    private TbImageView bkD;
    private ImageView bkE;
    private QuickVideoView bkF;
    private TextView bkG;
    private View bkH;
    private x bkI;
    private View bkJ;
    private TextView bkK;
    private int bkL;
    private TbImageView.a bkM;
    private g.b bkN;
    private ViewTreeObserver.OnGlobalLayoutListener bkO;
    private Runnable bkP;
    private Runnable bkQ;
    private QuickVideoView.b bkR;
    private g.e btB;
    private g.a bty;
    private g.f btz;
    private View buH;
    private ThreadGodReplyLayout cKD;
    private View.OnClickListener cMJ;
    private com.baidu.tieba.play.g cML;
    private k cMN;
    private int cMP;
    private boolean cMQ;
    private TextView cMV;
    private Handler cMW;
    private VideoLoadingProgressView.a cMX;
    private j.a cNb;
    private Animation.AnimationListener cNc;
    private TbImageView cOV;
    private LinearLayout cOs;
    private n cPJ;
    public TextView dJA;
    public LinearLayout dJB;
    private com.baidu.tieba.frs.vc.g dJC;
    public boolean dJD;
    public int dJE;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void anX() {
        if (this.cML != null && this.cMQ) {
            try {
                this.bkF.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cMW.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cMP = 0;
        this.bkL = 1;
        this.cMQ = false;
        this.cMW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aob();
                        return;
                    case 203:
                        a.this.aoc();
                        return;
                    default:
                        return;
                }
            }
        };
        this.btz = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cML = gVar;
                if (a.this.cML != null) {
                    a.this.cML.setVolume(0.0f, 0.0f);
                }
                a.this.cMN.bbv();
                a.this.anX();
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.e(false, 3);
                }
                return false;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                y.bqO().remove(a.this.aAy);
                a.this.bkF.start();
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ans();
                a.this.e(true, 4);
                a.this.cMQ = false;
                return true;
            }
        };
        this.cMX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.anX();
            }
        };
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && a.this.bkD != null) {
                    a.this.bkD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bkO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bkB != null && a.this.bkB.getLayoutParams() != null && a.this.bkB.getVisibility() != 8) {
                    a.this.bkB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bkB.getLayoutParams();
                    if (a.this.bkB.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bkB.getWidth() * 0.5625d);
                        a.this.bkB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bkP = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bkF != null && !a.this.bkF.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bkQ = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.ans();
                a.this.e(true, 4);
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cMJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aAQ != null && !StringUtils.isNull(a.this.aAQ.yB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.aAQ.yB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aEh != null) {
                        a.this.aEh.onClick(view);
                    }
                }
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.aAQ);
                }
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aAQ != null && a.this.anP() != null) {
                    a.this.anP().a(view, a.this.aAQ);
                }
            }
        };
        this.cNb = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void aof() {
                a.this.anY();
            }
        };
        this.cNc = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bkL == 3 && a.this.bkD != null) {
                    a.this.bkD.setVisibility(8);
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
        this.buH = view.findViewById(e.g.divider_line);
        this.bWd = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cOV = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.dJB = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bWd.setOnClickListener(this);
        this.bWP = (HeadPendantClickableView) this.bWd.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), e.C0175e.ds70));
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.dJA = (TextView) view.findViewById(e.g.thread_info_bar_name);
        this.dJA.setVisibility(8);
        this.dJA.setOnClickListener(this.cMJ);
        this.bkI = new x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bkI.setLoadingAnimationListener(this.cMX);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.bWf.setForumAfterClickListener(this.aEh);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.bWe.setFrom(3);
        this.bWg = view.findViewById(e.g.divider_below_reply_number_layout);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setShareVisible(true);
        this.bWf.setShareReportFrom(1);
        this.bWf.setStType("frs_page");
        this.bWf.setFrom(2);
        this.bWf.setDisPraiseFrom(2);
        this.bWf.ary = 3;
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.bWS.aFS.setOnClickListener(this);
        this.bWS.setFrom(2);
        this.bWS.setShareReportFrom(1);
        this.bWS.setSourceFromForPb(3);
        this.bWS.setStType("frs_page");
        this.bWS.setHideBarName(true);
        this.bkB = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bkB.setOnClickListener(this);
        this.bkB.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bkB != null) {
                    a.this.bkB.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bkO);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bkB != null) {
                    a.this.bkB.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bkO);
                }
            }
        });
        this.bkD = (TbImageView) view.findViewById(e.g.image_video);
        this.bkD.setPageId(getTag());
        this.bkD.setDefaultErrorResource(0);
        this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bkD.setEvent(this.bkM);
        this.bkD.setGifIconSupport(false);
        this.bkE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bkF = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.cPJ = new n(this.mContext.getPageActivity());
        this.bkF.setPlayerReuseEnable(true);
        this.bkF.setContinuePlayEnable(true);
        this.bkF.setBusiness(this.cPJ);
        this.bkF.setOnPreparedListener(this.btz);
        this.bkF.setOnCompletionListener(this.bty);
        this.bkF.setOnErrorListener(this.bkN);
        this.bkF.setOnOutInfoListener(this.btB);
        this.bkF.setOnSurfaceDestroyedListener(this.bkR);
        this.bJO = new com.baidu.tieba.play.j();
        this.bJO.setPlayer(this.bkF);
        this.bJO.a(this.cNb);
        this.bkJ = view.findViewById(e.g.auto_video_black_mask);
        this.bkG = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bkH = view.findViewById(e.g.auto_video_error_background);
        this.bXd = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bXe = (ThreadSkinView) view.findViewById(e.g.frs_thread_skin);
        this.bJD = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.fade_out_video_cover);
        this.bJD.setAnimationListener(this.cNc);
        this.bkC = (TextView) view.findViewById(e.g.text_video_duration);
        this.bkK = (TextView) view.findViewById(e.g.text_video_play_count);
        this.cOs = (LinearLayout) view.findViewById(e.g.duration_container);
        this.dJC = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bWd);
        this.dJC.setUniqueId(getTag());
        this.cKD = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cKD.setOnClickListener(this);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bWf != null) {
                    a.this.bWf.changeSelectStatus();
                }
            }
        });
        this.bWf.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void br(boolean z) {
                if (a.this.mMaskView != null) {
                    al.j(a.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            }
        });
        this.cMV = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cMN = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bWd || view == this.bWf.getCommentNumView() || view == this.dJB) {
            aA(this.bWd);
        } else if (view == this.bkB) {
            if (this.aAQ != null && this.aAQ.yN() != null) {
                z = this.aAQ.yN().is_vertical.intValue() == 1;
            }
            if (z) {
                ay(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aL(this.bkB);
            } else {
                aA(this.bkB);
            }
        } else if (view == this.cKD) {
            aA(this.cKD);
        }
        if (this.aAQ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aAQ));
        }
    }

    private void ay(View view) {
        if (anP() != null) {
            anP().a(view, this.aAQ);
        }
        if (!com.baidu.adp.lib.util.j.kX()) {
            l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anZ();
        }
    }

    private void anZ() {
        if (this.aAQ != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aAQ);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs")));
        }
    }

    private void aL(View view) {
        if (this.aAQ != null) {
            am amVar = new am("c11100");
            amVar.ax("tid", this.aAQ.getId());
            amVar.ax(ImageViewerConfig.FORUM_ID, this.aAQ.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (anP() != null) {
            anP().a(view, this.aAQ);
        }
        if (view == this.bkB) {
            if (!com.baidu.adp.lib.util.j.kX()) {
                l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
            } else {
                aoa();
            }
        }
    }

    private void aoa() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aAQ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bXd.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bXd.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "frs", this.aAQ.getTid(), o.yj(), "", videoSerializeVideoThreadInfo)));
    }

    private void aA(View view) {
        String str;
        String str2;
        if (this.aAQ != null) {
            if (this.aAQ.zo()) {
                TiebaStatic.log(new am("c10242").ax(ImageViewerConfig.FORUM_ID, String.valueOf(this.aAQ.getFid())).x("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.ax("tid", this.aAQ.getId());
                amVar.ax(ImageViewerConfig.FORUM_ID, this.aAQ.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.aAQ.yv() != null && this.aAQ.yv().getGodUserData() != null && this.aAQ.yv().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").x("obj_locate", 3).ax("tid", this.aAQ.getId()));
            }
        }
        if (anP() != null) {
            anP().a(view, this.aAQ);
        }
        if (this.aAQ != null) {
            o.md(this.aAQ.getId());
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            v.ir(this.aAQ.getId());
            String valueOf = String.valueOf(this.aAQ.getFid());
            if (this.aAQ.arp == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aAQ.arp.id;
                str2 = valueOf;
            }
            if (this.aAQ.yS() > 0 && com.baidu.tieba.tbadkCore.util.e.bDb()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.aAQ.getTid(), String.valueOf(this.aAQ.yS()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.aAQ.zo() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aAQ.zx());
                createHistoryCfg.setSmartFrsPosition(this.aAQ.zE());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cKD) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.aAQ, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aAQ.zo() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aAQ.zx());
            createFromThreadCfg.setSmartFrsPosition(this.aAQ.zE());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cKD) {
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
        this.aAQ = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aob() {
        this.cMW.removeMessages(202);
        if (this.bkF.getCurrentPosition() > 0) {
            e(false, 3);
            this.cMW.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cMW.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoc() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cMW.removeMessages(203);
        int currentPosition = this.bkF.getCurrentPosition();
        if (currentPosition != this.cMP) {
            this.cMP = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cMW.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bkE != null && this.bkD != null && this.bkJ != null && this.bkI != null && this.bkH != null && this.bkG != null) {
            if (z || this.bkL != i) {
                this.bkL = i;
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkQ);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkP);
                if (i == 2) {
                    this.bkE.setVisibility(8);
                    this.bJD.cancel();
                    this.bkD.clearAnimation();
                    this.bkD.setVisibility(0);
                    this.bkJ.setVisibility(0);
                    this.cOs.setVisibility(0);
                    this.bkI.startLoading();
                    this.bkH.setVisibility(8);
                    this.bkG.setVisibility(8);
                    com.baidu.adp.lib.g.e.jI().postDelayed(this.bkQ, 60000L);
                } else if (i == 3) {
                    this.bkE.setVisibility(8);
                    this.bkD.startAnimation(this.bJD);
                    this.bkJ.setVisibility(8);
                    this.cOs.setVisibility(8);
                    this.bkI.bqJ();
                    this.bkH.setVisibility(8);
                    this.bkG.setVisibility(8);
                    if (this.aAQ != null && this.aAQ.yN() != null) {
                        this.cMN.a(this.aAQ.getTid(), this.aAQ.yN().video_length.intValue(), this.aAQ.yN().video_duration.intValue(), "frs");
                    }
                } else if (i == 4) {
                    this.bkE.setVisibility(8);
                    this.bkD.startAnimation(this.bJD);
                    this.bkJ.setVisibility(8);
                    this.bkI.bqK();
                    this.bkH.setVisibility(0);
                    this.bkG.setVisibility(0);
                    com.baidu.adp.lib.g.e.jI().postDelayed(this.bkP, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.bkE.setVisibility(0);
                    this.cOs.setVisibility(0);
                    this.bJD.cancel();
                    this.bkD.clearAnimation();
                    this.bkD.setVisibility(0);
                    this.bkJ.setVisibility(0);
                    this.bkI.bqK();
                    this.bkH.setVisibility(8);
                    this.bkG.setVisibility(8);
                }
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cOV != null) {
            if (bbVar == null) {
                this.cOV.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arh)) {
                if (this.dJC != null && this.dJC.aGk() && (this.cOV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOV.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), e.C0175e.tbds106);
                    this.cOV.setLayoutParams(layoutParams);
                }
                this.cOV.setVisibility(0);
                this.cOV.setImageDrawable(null);
                this.cOV.startLoad(bbVar.arh, 10, false);
                this.cOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.ari, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cOV.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aAQ == null || this.aAQ.yv() == null) {
            this.bWd.setVisibility(8);
            return;
        }
        this.bWd.setVisibility(0);
        this.bWd.setOnClickListener(this);
        aod();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.aqw)) {
            this.aAQ.ai(this.mUrl, this.aqw);
        }
        this.aAQ.g(false, true);
        SpannableStringBuilder yV = this.aAQ.yV();
        if (this.aAQ.zc() && !StringUtils.isNull(this.aAQ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aAQ.getTid();
            yV.append((CharSequence) this.aAQ.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(yV));
        this.mTextTitle.setText(yV);
        this.dJC.af(this.aAQ);
        N(this.aAQ);
        this.bWe.setData(this.aAQ);
        if (this.bWe.getHeaderImg() != null) {
            if (this.bWe.getIsSimpleThread()) {
                this.bWe.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (this.aAQ.yv() == null || this.aAQ.yv().getPendantData() == null || StringUtils.isNull(this.aAQ.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.bWe.getHeaderImg().setVisibility(0);
                this.bWe.getHeaderImg().setData(this.aAQ);
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(this.aAQ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bWf.setLayoutParams(layoutParams);
        this.bWe.setUserAfterClickListener(this.aGk);
        ik(hb(1));
        this.bkC.setText(ao.dt(this.aAQ.yN().video_duration.intValue() * 1000));
        this.bkK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.N(this.aAQ.yN().play_count.intValue())));
        this.cKD.setData(this.aAQ.zM());
        this.cKD.onChangeSkinType();
        if (o.me(this.aAQ.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            o.a(this.cKD.getGodReplyContent(), this.aAQ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.aAQ == null || this.aAQ.yN() == null) {
            z = false;
        } else {
            z = this.aAQ.yN().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cMV.setVisibility(0);
        } else {
            this.cMV.setVisibility(8);
        }
        if (this.bWf.isInFrsAllThread() && com.baidu.tieba.frs.a.ayN().ayO()) {
            this.mMaskView.setVisibility(0);
            if (this.aAQ.zW() || this.aAQ.zX()) {
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
    public void ans() {
        this.cMW.removeMessages(202);
        this.cMW.removeMessages(203);
    }

    private void Qv() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkP);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkQ);
    }

    private void aod() {
        Qv();
        ans();
        if (this.bkD != null && this.bkB != null && this.bkF != null) {
            if (com.baidu.tbadk.core.i.ws().ww() && this.aAQ != null && this.aAQ.yN() != null) {
                this.bkB.setVisibility(0);
                this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bkD.startLoad(this.aAQ.yN().thumbnail_url, 10, false);
                stopPlay();
                this.aAy = this.aAQ.yN().video_url;
                if (StringUtils.isNull(this.aAy)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").ax("tid", this.aAQ.getId()));
                }
                if (this.cPJ != null && this.cPJ.bqs() != null) {
                    this.cPJ.bqs().g(this.aAQ.yN());
                }
                this.bkF.co(this.aAy, this.aAQ.tid);
                return;
            }
            this.bkB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bWd, e.f.addresslist_item_bg);
            al.c(this.bkE, e.f.btn_icon_play_video_n);
            al.h(this.bkG, e.d.cp_cont_i);
            al.h(this.bkC, e.d.cp_cont_i);
            al.h(this.bkK, e.d.cp_cont_i);
            al.j(this.bkH, e.d.common_color_10014);
            al.j(this.buH, e.d.cp_bg_line_e);
            if (this.bkG != null) {
                this.bkG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bWS != null && this.bWS.getVisibility() == 0) {
                this.bWS.onChangeSkinType();
            }
            this.bWf.onChangeSkinType();
            this.mSkinType = i;
            this.bWe.onChangeSkinType();
            this.dJC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.currentPageType = i;
        if (this.bWf != null) {
            this.bWf.ary = i;
            if (i == 15) {
                this.bWf.setFrom(10);
            } else {
                this.bWf.setFrom(2);
                this.bWf.setDisPraiseFrom(2);
            }
        }
        if (this.bWe != null) {
            if (i == 15) {
                this.bWe.setFrom(5);
            } else {
                this.bWe.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cMQ;
    }

    public boolean isPlaying() {
        if (this.bkF == null) {
            return false;
        }
        return this.bkF.isPlaying();
    }

    public void startPlay() {
        if (!this.cMQ && this.aAQ != null && this.aAQ.yN() != null && this.bkF != null) {
            this.bkF.stopPlayback();
            if (aa.OY()) {
                if (this.dJD || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.cMN.bbu();
                    e(true, 2);
                    if (StringUtils.isNull(this.aAy)) {
                        TiebaStatic.log(new am("c12619").ax("obj_locate", "frs").ax("tid", this.aAQ.getId()));
                        this.aAy = this.aAQ.yN().video_url;
                    }
                    this.cMQ = true;
                    this.bkF.setVideoPath(this.aAy, this.aAQ.getId());
                    if (this.bJO != null) {
                        this.bJO.start();
                    }
                    anY();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anY() {
        if (this.aAQ != null && this.aAQ.yN() != null) {
            String str = this.aAQ.zo() ? "floor5" : "frs";
            if (this.aAQ.yA()) {
                str = "frs_mcn";
            }
            if (this.dJE == 501) {
                str = "frs_tab";
            }
            z zVar = new z();
            zVar.mLocate = str;
            zVar.beh = this.aAQ.getTid();
            zVar.cQb = this.aAQ.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.aAQ.mRecomSource;
            zVar.gww = this.aAQ.mRecomAbTag;
            zVar.gwx = this.aAQ.mRecomWeight;
            zVar.gwy = "";
            zVar.gwA = this.aAQ.yN().video_md5;
            com.baidu.tieba.play.l.a(this.aAQ.yN().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        Qv();
        ans();
        e(true, 1);
        if (this.bkF != null) {
            this.bkF.stopPlayback();
            if (this.bJO != null) {
                this.bJO.stop();
            }
        }
        this.cMQ = false;
    }

    public ThreadCommentAndPraiseInfoLayout aaY() {
        return this.bWf;
    }

    public ThreadCommentAndPraiseInfoLayout aaZ() {
        return this.bWS.aFS;
    }

    public View getVideoContainer() {
        return this.bkB;
    }

    public String getPlayUrl() {
        return this.aAy;
    }

    public int getCurrentPosition() {
        if (this.bkF == null) {
            return 0;
        }
        return this.bkF.getCurrentPosition();
    }

    public void setVideoStatsData(z zVar) {
        if (this.cPJ != null) {
            this.cPJ.setVideoStatsData(zVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWf != null && this.bWe != null) {
            this.bWe.setPageUniqueId(bdUniqueId);
        }
    }

    public void ik(int i) {
        if (this.aAQ != null) {
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setData(this.aAQ);
                this.bWg.setVisibility(8);
                return;
            }
            this.bWg.setVisibility(this.bWf.setData(this.aAQ) ? 0 : 8);
            this.bWS.setVisibility(8);
        }
    }

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.aqw = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bkD.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bkD.setOnDrawListener(null);
        }
    }
}
