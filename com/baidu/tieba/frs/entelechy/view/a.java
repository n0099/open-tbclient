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
    private bb aFJ;
    private String aFr;
    private final View.OnClickListener aJb;
    private final View.OnClickListener aLf;
    private String avm;
    private Animation bOT;
    private com.baidu.tieba.play.j bPd;
    public FrameLayout bpC;
    private TextView bpD;
    private TbImageView bpE;
    private ImageView bpF;
    private QuickVideoView bpG;
    private TextView bpH;
    private View bpI;
    private x bpJ;
    private View bpK;
    private TextView bpL;
    private int bpM;
    private TbImageView.a bpN;
    private g.b bpO;
    private ViewTreeObserver.OnGlobalLayoutListener bpP;
    private Runnable bpQ;
    private Runnable bpR;
    private QuickVideoView.b bpS;
    private g.a byA;
    private g.f byB;
    private g.e byD;
    private View bzH;
    private ThreadGodReplyLayout cVS;
    private View.OnClickListener cXY;
    private com.baidu.tieba.play.g cYa;
    private k cYc;
    private int cYe;
    private boolean cYf;
    private TextView cYk;
    private Handler cYl;
    private VideoLoadingProgressView.a cYm;
    private j.a cYq;
    private Animation.AnimationListener cYr;
    private LinearLayout cZH;
    private String cbl;
    private RelativeLayout cbw;
    public ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    public View cbz;
    private HeadPendantClickableView cci;
    protected ThreadSourceShareAndPraiseLayout ccl;
    public LinearLayout ccx;
    public ThreadSkinView ccy;
    public TextView dUF;
    public LinearLayout dUG;
    private com.baidu.tieba.frs.vc.g dUH;
    public boolean dUI;
    public int dUJ;
    private TbImageView dak;
    private n dba;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
        if (this.cYa != null && this.cYf) {
            try {
                this.bpG.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cYl.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cYe = 0;
        this.bpM = 1;
        this.cYf = false;
        this.cYl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
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
        this.byB = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cYa = gVar;
                if (a.this.cYa != null) {
                    a.this.cYa.setVolume(0.0f, 0.0f);
                }
                a.this.cYc.bdY();
                a.this.aqx();
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.e(false, 3);
                }
                return false;
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                a.this.bpG.start();
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.apR();
                a.this.e(true, 4);
                a.this.cYf = false;
                return true;
            }
        };
        this.cYm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aqx();
            }
        };
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && a.this.bpE != null) {
                    a.this.bpE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpP = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bpC != null && a.this.bpC.getLayoutParams() != null && a.this.bpC.getVisibility() != 8) {
                    a.this.bpC.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bpC.getLayoutParams();
                    if (a.this.bpC.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bpC.getWidth() * 0.5625d);
                        a.this.bpC.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bpG != null && !a.this.bpG.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bpR = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.apR();
                a.this.e(true, 4);
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cXY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFJ != null && !StringUtils.isNull(a.this.aFJ.zZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.aFJ.zZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aJb != null) {
                        a.this.aJb.onClick(view);
                    }
                }
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.aFJ);
                }
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFJ != null && a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.aFJ);
                }
            }
        };
        this.cYq = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void aqF() {
                a.this.aqy();
            }
        };
        this.cYr = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bpM == 3 && a.this.bpE != null) {
                    a.this.bpE.setVisibility(8);
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
        this.bzH = view.findViewById(e.g.divider_line);
        this.cbw = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.dak = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.dUG = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.cbw.setOnClickListener(this);
        this.cci = (HeadPendantClickableView) this.cbw.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.dUF = (TextView) view.findViewById(e.g.thread_info_bar_name);
        this.dUF.setVisibility(8);
        this.dUF.setOnClickListener(this.cXY);
        this.bpJ = new x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bpJ.setLoadingAnimationListener(this.cYm);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.cby.setForumAfterClickListener(this.aJb);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.cbx.setFrom(3);
        this.cbz = view.findViewById(e.g.divider_below_reply_number_layout);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setIsBarViewVisible(false);
        this.cby.setShareVisible(true);
        this.cby.setShareReportFrom(1);
        this.cby.setStType("frs_page");
        this.cby.setFrom(2);
        this.cby.setDisPraiseFrom(2);
        this.cby.awp = 3;
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.ccl.aKN.setOnClickListener(this);
        this.ccl.setFrom(2);
        this.ccl.setShareReportFrom(1);
        this.ccl.setSourceFromForPb(3);
        this.ccl.setStType("frs_page");
        this.ccl.setHideBarName(true);
        this.bpC = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bpC.setOnClickListener(this);
        this.bpC.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bpC != null) {
                    a.this.bpC.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bpP);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bpC != null) {
                    a.this.bpC.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bpP);
                }
            }
        });
        this.bpE = (TbImageView) view.findViewById(e.g.image_video);
        this.bpE.setPageId(getTag());
        this.bpE.setDefaultErrorResource(0);
        this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpE.setEvent(this.bpN);
        this.bpE.setGifIconSupport(false);
        this.bpF = (ImageView) view.findViewById(e.g.image_video_play);
        this.bpG = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.dba = new n(this.mContext.getPageActivity());
        this.bpG.setPlayerReuseEnable(true);
        this.bpG.setContinuePlayEnable(true);
        this.bpG.setBusiness(this.dba);
        this.bpG.setOnPreparedListener(this.byB);
        this.bpG.setOnCompletionListener(this.byA);
        this.bpG.setOnErrorListener(this.bpO);
        this.bpG.setOnOutInfoListener(this.byD);
        this.bpG.setOnSurfaceDestroyedListener(this.bpS);
        this.bPd = new com.baidu.tieba.play.j();
        this.bPd.setPlayer(this.bpG);
        this.bPd.a(this.cYq);
        this.bpK = view.findViewById(e.g.auto_video_black_mask);
        this.bpH = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bpI = view.findViewById(e.g.auto_video_error_background);
        this.ccx = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.ccy = (ThreadSkinView) view.findViewById(e.g.frs_thread_skin);
        this.bOT = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.fade_out_video_cover);
        this.bOT.setAnimationListener(this.cYr);
        this.bpD = (TextView) view.findViewById(e.g.text_video_duration);
        this.bpL = (TextView) view.findViewById(e.g.text_video_play_count);
        this.cZH = (LinearLayout) view.findViewById(e.g.duration_container);
        this.dUH = new com.baidu.tieba.frs.vc.g(tbPageContext, this.cbw);
        this.dUH.setUniqueId(getTag());
        this.cVS = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVS.setOnClickListener(this);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.cby != null) {
                    a.this.cby.changeSelectStatus();
                }
            }
        });
        this.cby.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bK(boolean z) {
                if (a.this.mMaskView != null) {
                    al.j(a.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            }
        });
        this.cYk = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cYc = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.cbw || view == this.cby.getCommentNumView() || view == this.dUG) {
            aF(this.cbw);
        } else if (view == this.bpC) {
            if (this.aFJ != null && this.aFJ.Al() != null) {
                z = this.aFJ.Al().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aQ(this.bpC);
            } else {
                aF(this.bpC);
            }
        } else if (view == this.cVS) {
            aF(this.cVS);
        }
        if (this.aFJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFJ));
        }
    }

    private void aD(View view) {
        if (aqp() != null) {
            aqp().a(view, this.aFJ);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aqz() {
        if (this.aFJ != null) {
            String str = "frs";
            if (this.dUJ == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aFJ);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void aQ(View view) {
        if (this.aFJ != null) {
            am amVar = new am("c11100");
            amVar.aB("tid", this.aFJ.getId());
            amVar.aB(ImageViewerConfig.FORUM_ID, this.aFJ.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (aqp() != null) {
            aqp().a(view, this.aFJ);
        }
        if (view == this.bpC) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
            } else {
                aqA();
            }
        }
    }

    private void aqA() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aFJ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.ccx.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.ccx.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.dUJ == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.aFJ.getTid(), o.zH(), "", videoSerializeVideoThreadInfo)));
    }

    private void aF(View view) {
        String str;
        String str2;
        if (this.aFJ != null) {
            if (this.aFJ.AM()) {
                TiebaStatic.log(new am("c10242").aB(ImageViewerConfig.FORUM_ID, String.valueOf(this.aFJ.getFid())).y("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.aB("tid", this.aFJ.getId());
                amVar.aB(ImageViewerConfig.FORUM_ID, this.aFJ.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.aFJ.zT() != null && this.aFJ.zT().getGodUserData() != null && this.aFJ.zT().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").y("obj_locate", 3).aB("tid", this.aFJ.getId()));
            }
        }
        if (aqp() != null) {
            aqp().a(view, this.aFJ);
        }
        if (this.aFJ != null) {
            o.mW(this.aFJ.getId());
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            w.jb(this.aFJ.getId());
            String valueOf = String.valueOf(this.aFJ.getFid());
            if (this.aFJ.awf == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aFJ.awf.id;
                str2 = valueOf;
            }
            if (this.aFJ.Aq() > 0 && com.baidu.tieba.tbadkCore.util.e.bFR()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.aFJ.getTid(), String.valueOf(this.aFJ.Aq()), false, true, "frs_page");
                String str3 = "frs";
                if (this.dUJ == 501) {
                    str3 = "frs_tab";
                } else if (this.aFJ.AM()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aFJ.AV());
                createHistoryCfg.setSmartFrsPosition(this.aFJ.Bc());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cVS) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.aFJ, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.dUJ == 501) {
                str4 = "frs_tab";
            } else if (this.aFJ.AM()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aFJ.AV());
            createFromThreadCfg.setSmartFrsPosition(this.aFJ.Bc());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cVS) {
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
        this.aFJ = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqB() {
        this.cYl.removeMessages(202);
        if (this.bpG.getCurrentPosition() > 0) {
            e(false, 3);
            this.cYl.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cYl.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqC() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cYl.removeMessages(203);
        int currentPosition = this.bpG.getCurrentPosition();
        if (currentPosition != this.cYe) {
            this.cYe = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cYl.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bpF != null && this.bpE != null && this.bpK != null && this.bpJ != null && this.bpI != null && this.bpH != null) {
            if (z || this.bpM != i) {
                this.bpM = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpR);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
                if (i == 2) {
                    this.bpF.setVisibility(8);
                    this.bOT.cancel();
                    this.bpE.clearAnimation();
                    this.bpE.setVisibility(0);
                    this.bpK.setVisibility(0);
                    this.cZH.setVisibility(0);
                    this.bpJ.startLoading();
                    this.bpI.setVisibility(8);
                    this.bpH.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpR, 60000L);
                } else if (i == 3) {
                    this.bpF.setVisibility(8);
                    this.bpE.startAnimation(this.bOT);
                    this.bpK.setVisibility(8);
                    this.cZH.setVisibility(8);
                    this.bpJ.bts();
                    this.bpI.setVisibility(8);
                    this.bpH.setVisibility(8);
                    if (this.aFJ != null && this.aFJ.Al() != null) {
                        this.cYc.a(this.aFJ.getTid(), this.aFJ.Al().video_length.intValue(), this.aFJ.Al().video_duration.intValue(), "frs", this.bpG);
                    }
                } else if (i == 4) {
                    this.bpF.setVisibility(8);
                    this.bpE.startAnimation(this.bOT);
                    this.bpK.setVisibility(8);
                    this.bpJ.btt();
                    this.bpI.setVisibility(0);
                    this.bpH.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpQ, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.bpF.setVisibility(0);
                    this.cZH.setVisibility(0);
                    this.bOT.cancel();
                    this.bpE.clearAnimation();
                    this.bpE.setVisibility(0);
                    this.bpK.setVisibility(0);
                    this.bpJ.btt();
                    this.bpI.setVisibility(8);
                    this.bpH.setVisibility(8);
                }
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.dak != null) {
            if (bbVar == null) {
                this.dak.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avX)) {
                if (this.dUH != null && this.dUH.aIE() && (this.dak.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dak.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), e.C0210e.tbds106);
                    this.dak.setLayoutParams(layoutParams);
                }
                this.dak.setVisibility(0);
                this.dak.setImageDrawable(null);
                this.dak.startLoad(bbVar.avX, 10, false);
                this.dak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.avY, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.dak.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aFJ == null || this.aFJ.zT() == null) {
            this.cbw.setVisibility(8);
            return;
        }
        this.cbw.setVisibility(0);
        this.cbw.setOnClickListener(this);
        aqD();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.avm)) {
            this.aFJ.am(this.mUrl, this.avm);
        }
        this.aFJ.g(false, true);
        SpannableStringBuilder At = this.aFJ.At();
        if (this.aFJ.AA() && !StringUtils.isNull(this.aFJ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aFJ.getTid();
            At.append((CharSequence) this.aFJ.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.dUH.af(this.aFJ);
        N(this.aFJ);
        this.cbx.setData(this.aFJ);
        if (this.cbx.getHeaderImg() != null) {
            if (this.cbx.getIsSimpleThread()) {
                this.cbx.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (this.aFJ.zT() == null || this.aFJ.zT().getPendantData() == null || StringUtils.isNull(this.aFJ.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.cbx.getHeaderImg().setVisibility(0);
                this.cbx.getHeaderImg().setData(this.aFJ);
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(this.aFJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.cby.setLayoutParams(layoutParams);
        this.cbx.setUserAfterClickListener(this.aLf);
        iM(hD(1));
        this.bpD.setText(ao.dV(this.aFJ.Al().video_duration.intValue() * 1000));
        this.bpL.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.aFJ.Al().play_count.intValue())));
        this.cVS.setData(this.aFJ.Bk());
        this.cVS.onChangeSkinType();
        if (o.mX(this.aFJ.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            o.a(this.cVS.getGodReplyContent(), this.aFJ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.aFJ == null || this.aFJ.Al() == null) {
            z = false;
        } else {
            z = this.aFJ.Al().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cYk.setVisibility(0);
        } else {
            this.cYk.setVisibility(8);
        }
        if (this.cby.isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.mMaskView.setVisibility(0);
            if (this.aFJ.Bu() || this.aFJ.Bv()) {
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
        this.cYl.removeMessages(202);
        this.cYl.removeMessages(203);
    }

    private void Si() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpR);
    }

    private void aqD() {
        Si();
        apR();
        if (this.bpE != null && this.bpC != null && this.bpG != null) {
            if (com.baidu.tbadk.core.i.xR().xV() && this.aFJ != null && this.aFJ.Al() != null) {
                this.bpC.setVisibility(0);
                this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpE.startLoad(this.aFJ.Al().thumbnail_url, 10, false);
                stopPlay();
                this.aFr = this.aFJ.Al().video_url;
                if (StringUtils.isNull(this.aFr)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").aB("tid", this.aFJ.getId()));
                }
                if (this.dba != null && this.dba.btb() != null) {
                    this.dba.btb().g(this.aFJ.Al());
                }
                this.bpG.cu(this.aFr, this.aFJ.tid);
                return;
            }
            this.bpC.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.cbw, e.f.addresslist_item_bg);
            al.c(this.bpF, e.f.btn_icon_play_video_n);
            al.h(this.bpH, e.d.cp_cont_i);
            al.h(this.bpD, e.d.cp_cont_i);
            al.h(this.bpL, e.d.cp_cont_i);
            al.j(this.bpI, e.d.common_color_10014);
            al.j(this.bzH, e.d.cp_bg_line_e);
            if (this.bpH != null) {
                this.bpH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.ccl != null && this.ccl.getVisibility() == 0) {
                this.ccl.onChangeSkinType();
            }
            this.cby.onChangeSkinType();
            this.mSkinType = i;
            this.cbx.onChangeSkinType();
            this.dUH.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.currentPageType = i;
        if (this.cby != null) {
            this.cby.awp = i;
            if (i == 15) {
                this.cby.setFrom(10);
            } else {
                this.cby.setFrom(2);
                this.cby.setDisPraiseFrom(2);
            }
        }
        if (this.cbx != null) {
            if (i == 15) {
                this.cbx.setFrom(5);
            } else {
                this.cbx.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cYf;
    }

    public boolean isPlaying() {
        if (this.bpG == null) {
            return false;
        }
        return this.bpG.isPlaying();
    }

    public void startPlay() {
        if (!this.cYf && this.aFJ != null && this.aFJ.Al() != null && this.bpG != null) {
            this.bpG.stopPlayback();
            if (com.baidu.tbadk.util.ab.QK()) {
                if (this.dUI || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.cYc.bdX();
                    e(true, 2);
                    if (StringUtils.isNull(this.aFr)) {
                        TiebaStatic.log(new am("c12619").aB("obj_locate", "frs").aB("tid", this.aFJ.getId()));
                        this.aFr = this.aFJ.Al().video_url;
                    }
                    this.cYf = true;
                    this.bpG.setVideoPath(this.aFr, this.aFJ.getId());
                    if (this.bPd != null) {
                        this.bPd.start();
                    }
                    aqy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.aFJ != null && this.aFJ.Al() != null) {
            String str = this.aFJ.AM() ? "floor5" : "frs";
            if (this.aFJ.zY()) {
                str = "frs_mcn";
            }
            if (this.dUJ == 501) {
                str = "frs_tab";
            }
            z zVar = new z();
            zVar.mLocate = str;
            zVar.bjn = this.aFJ.getTid();
            zVar.dbs = this.aFJ.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.aFJ.mRecomSource;
            zVar.gIJ = this.aFJ.mRecomAbTag;
            zVar.gIK = this.aFJ.mRecomWeight;
            zVar.gIL = "";
            zVar.gIN = this.aFJ.Al().video_md5;
            com.baidu.tieba.play.l.a(this.aFJ.Al().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        Si();
        apR();
        e(true, 1);
        if (this.bpG != null) {
            this.bpG.stopPlayback();
            if (this.bPd != null) {
                this.bPd.stop();
            }
        }
        this.cYf = false;
    }

    public ThreadCommentAndPraiseInfoLayout acN() {
        return this.cby;
    }

    public ThreadCommentAndPraiseInfoLayout acO() {
        return this.ccl.aKN;
    }

    public View getVideoContainer() {
        return this.bpC;
    }

    public String getPlayUrl() {
        return this.aFr;
    }

    public int getCurrentPosition() {
        if (this.bpG == null) {
            return 0;
        }
        return this.bpG.getCurrentPosition();
    }

    public void setVideoStatsData(z zVar) {
        if (this.dba != null) {
            this.dba.setVideoStatsData(zVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cby != null && this.cbx != null) {
            this.cbx.setPageUniqueId(bdUniqueId);
        }
    }

    public void iM(int i) {
        if (this.aFJ != null) {
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setData(this.aFJ);
                this.cbz.setVisibility(8);
                return;
            }
            this.cby.setData(this.aFJ);
            this.cbz.setVisibility(8);
            this.ccl.setVisibility(8);
        }
    }

    public void am(String str, String str2) {
        this.mUrl = str;
        this.avm = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bpE.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bpE.setOnDrawListener(null);
        }
    }
}
