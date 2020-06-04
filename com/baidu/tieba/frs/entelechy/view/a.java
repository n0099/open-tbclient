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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<bk> implements com.baidu.tieba.a.e, y {
    private QuickVideoView Xt;
    private String aeX;
    private bk aee;
    private final View.OnClickListener agI;
    private Animation boX;
    private String dGF;
    private TbPageContext<?> dIF;
    private final View.OnClickListener dWy;
    public FrameLayout eBk;
    private TextView eBl;
    private TbImageView eBm;
    private ImageView eBn;
    private TextView eBo;
    private View eBp;
    private w eBq;
    private View eBr;
    private TextView eBs;
    private int eBt;
    private TbImageView.a eBu;
    private g.b eBv;
    private ViewTreeObserver.OnGlobalLayoutListener eBw;
    private Runnable eBx;
    private Runnable eBy;
    private QuickVideoView.b eBz;
    private g.a eKw;
    private g.f eKx;
    private g.e eKz;
    private View eLr;
    public LinearLayout eTM;
    public View fGA;
    private RelativeLayout fGx;
    public ThreadUserInfoLayout fGy;
    public ThreadCommentAndPraiseInfoLayout fGz;
    protected ThreadSourceShareAndPraiseLayout fHl;
    public ThreadSkinView fHw;
    private j fbY;
    private ThreadGodReplyLayout gDW;
    private HeadPendantClickableView gDX;
    private int gEb;
    private boolean gEc;
    private TextView gEh;
    private Handler gEi;
    private VideoLoadingProgressView.a gEj;
    private j.a gEo;
    private Animation.AnimationListener gEp;
    private LinearLayout gFE;
    private n gGR;
    private TbImageView gGf;
    public TextView hxS;
    public LinearLayout hxT;
    private g hxU;
    private i hxV;
    public boolean hxW;
    public int hxX;
    private View.OnClickListener hxY;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bKZ() {
        if (this.hxU != null && this.gEc) {
            try {
                this.Xt.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gEi.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gEb = 0;
        this.eBt = 1;
        this.gEc = false;
        this.gEi = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bLe();
                        return;
                    case 203:
                        a.this.bLf();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.hxU = gVar;
                if (a.this.hxU != null) {
                    a.this.hxU.setVolume(0.0f, 0.0f);
                }
                a.this.bKZ();
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.t(false, 3);
                }
                return false;
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Xt.start();
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bLg();
                a.this.t(true, 4);
                a.this.gEc = false;
                return true;
            }
        };
        this.gEj = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bKZ();
            }
        };
        this.eBu = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.eBm != null) {
                    a.this.eBm.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eBw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.eBk != null && a.this.eBk.getLayoutParams() != null && a.this.eBk.getVisibility() != 8) {
                    a.this.eBk.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.eBk.getLayoutParams();
                    if (a.this.eBk.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.eBk.getWidth() * 0.5625d);
                        a.this.eBk.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eBx = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Xt != null && !a.this.Xt.isPlaying()) {
                    a.this.t(true, 1);
                }
            }
        };
        this.eBy = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bLg();
                a.this.t(true, 4);
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.hxY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aee != null && !StringUtils.isNull(a.this.aee.aQC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.dIF.getPageActivity()).createNormalCfg(a.this.aee.aQC(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.dWy != null) {
                        a.this.dWy.onClick(view);
                    }
                }
            }
        };
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bKU() != null) {
                    a.this.bKU().a(view, a.this.aee);
                }
            }
        };
        this.dWy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aee != null && a.this.bKU() != null) {
                    a.this.bKU().a(view, a.this.aee);
                }
            }
        };
        this.gEo = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qg() {
                a.this.bLa();
            }
        };
        this.gEp = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.eBt == 3 && a.this.eBm != null) {
                    a.this.eBm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.dIF = tbPageContext;
        View view = getView();
        this.eLr = view.findViewById(R.id.divider_line);
        this.fGx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gGf = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.hxT = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fGx.setOnClickListener(this);
        this.gDX = (HeadPendantClickableView) this.fGx.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gDX.getHeadView() != null) {
            this.gDX.getHeadView().setIsRound(true);
            this.gDX.getHeadView().setDrawBorder(false);
            this.gDX.getHeadView().setDefaultResource(17170445);
            this.gDX.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDX.getHeadView().setRadius(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds70));
        }
        this.gDX.setHasPendantStyle();
        if (this.gDX.getPendantView() != null) {
            this.gDX.getPendantView().setIsRound(true);
            this.gDX.getPendantView().setDrawBorder(false);
        }
        this.hxS = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.hxS.setVisibility(8);
        this.hxS.setOnClickListener(this.hxY);
        this.eBq = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eBq.setLoadingAnimationListener(this.gEj);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fGz.setForumAfterClickListener(this.dWy);
        this.fGy = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fGy.setFrom(3);
        this.fGA = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.fGz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGz.setLayoutParams(layoutParams);
        }
        this.fGz.setOnClickListener(this);
        this.fGz.setReplyTimeVisible(false);
        this.fGz.setShowPraiseNum(true);
        this.fGz.setNeedAddPraiseIcon(true);
        this.fGz.setNeedAddReplyIcon(true);
        this.fGz.setIsBarViewVisible(false);
        this.fGz.setShareVisible(true);
        this.fGz.setShareReportFrom(1);
        this.fGz.setStType("frs_page");
        this.fGz.setFrom(2);
        this.fGz.dWv = 3;
        this.fHl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fHl.dXt.setOnClickListener(this);
        this.fHl.setFrom(2);
        this.fHl.setShareReportFrom(1);
        this.fHl.setSourceFromForPb(3);
        this.fHl.setStType("frs_page");
        this.fHl.setHideBarName(true);
        this.eBk = (FrameLayout) view.findViewById(R.id.frame_video);
        this.eBk.setOnClickListener(this);
        this.eBk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.eBk != null) {
                    a.this.eBk.getViewTreeObserver().addOnGlobalLayoutListener(a.this.eBw);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.eBk != null) {
                    a.this.eBk.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.eBw);
                }
            }
        });
        this.eBm = (TbImageView) view.findViewById(R.id.image_video);
        this.eBm.setPageId(getTag());
        this.eBm.setDefaultErrorResource(0);
        this.eBm.setDrawCorner(true);
        this.eBm.setPlaceHolder(3);
        this.eBm.setEvent(this.eBu);
        this.eBm.setGifIconSupport(false);
        this.eBn = (ImageView) view.findViewById(R.id.image_video_play);
        this.Xt = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.gGR = new n(this.dIF.getPageActivity());
        this.Xt.setContinuePlayEnable(true);
        this.Xt.setBusiness(this.gGR);
        this.Xt.setOnPreparedListener(this.eKx);
        this.Xt.setOnCompletionListener(this.eKw);
        this.Xt.setOnErrorListener(this.eBv);
        this.Xt.setOnOutInfoListener(this.eKz);
        this.Xt.setOnSurfaceDestroyedListener(this.eBz);
        this.fbY = new j();
        this.fbY.setPlayer(this.Xt);
        this.fbY.a(this.gEo);
        this.eBr = view.findViewById(R.id.auto_video_black_mask);
        this.eBo = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eBp = view.findViewById(R.id.auto_video_error_background);
        this.eTM = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fHw = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.boX = AnimationUtils.loadAnimation(this.dIF.getPageActivity(), R.anim.fade_out_video_cover);
        this.boX.setAnimationListener(this.gEp);
        this.eBl = (TextView) view.findViewById(R.id.text_video_duration);
        this.eBs = (TextView) view.findViewById(R.id.text_video_play_count);
        this.gFE = (LinearLayout) view.findViewById(R.id.duration_container);
        this.hxV = new i(tbPageContext, this.fGx);
        this.hxV.setUniqueId(getTag());
        this.gDW = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gDW.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.fGz != null) {
                    a.this.fGz.changeSelectStatus();
                }
            }
        });
        this.fGz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hp(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.gEh = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fGx || view == this.fGz.getCommentNumView() || view == this.hxT) {
            bL(this.fGx);
        } else if (view == this.eBk) {
            if (this.aee != null && this.aee.aQQ() != null) {
                z = this.aee.aQQ().is_vertical.intValue() == 1;
            }
            if (z) {
                bJ(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bY(this.eBk);
                } else {
                    bL(this.eBk);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bY(this.eBk);
            } else {
                bL(this.eBk);
            }
        } else if (view == this.gDW) {
            bL(this.gDW);
        }
        if (this.aee != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aee));
        }
    }

    private void bJ(View view) {
        if (bKU() != null) {
            bKU().a(view, this.aee);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bLb();
        }
    }

    private void bLb() {
        if (this.aee != null) {
            String str = "frs";
            if (this.hxX == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aee);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.aee.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.aee.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bY(View view) {
        if (this.aee != null) {
            an anVar = new an("c11100");
            anVar.dh("tid", this.aee.getId());
            anVar.dh("fid", this.aee.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (bKU() != null) {
            bKU().a(view, this.aee);
        }
        if (view == this.eBk) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bLc();
            }
        }
    }

    private void bLc() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aee);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.eTM.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.eTM.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.hxX == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.dIF.getPageActivity(), str, this.aee.getTid(), m.aQj(), "", videoSerializeVideoThreadInfo);
        if (this.aee.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.aee.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bL(View view) {
        String str;
        String str2;
        if (this.aee != null) {
            if (this.aee.aRH()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dh("fid", String.valueOf(this.aee.getFid())).ag("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.dh("tid", this.aee.getId());
                anVar.dh("fid", this.aee.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.aee.aQx() != null && this.aee.aQx().getGodUserData() != null && this.aee.aQx().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").ag("obj_locate", 3).dh("tid", this.aee.getId()));
            }
        }
        if (bKU() != null) {
            bKU().a(view, this.aee);
        }
        if (this.aee != null) {
            m.Dn(this.aee.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ab.yT(this.aee.getId());
            String valueOf = String.valueOf(this.aee.getFid());
            if (this.aee.dHw == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aee.dHw.id;
                str2 = valueOf;
            }
            if (this.aee.aQV() > 0 && com.baidu.tieba.tbadkCore.util.e.deU()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.dIF.getPageActivity()).createHistoryCfg(this.aee.getTid(), String.valueOf(this.aee.aQV()), false, true, "frs_page");
                String str3 = "frs";
                if (this.hxX == 501) {
                    str3 = "frs_tab";
                } else if (this.aee.aRH()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aee.aRN());
                createHistoryCfg.setSmartFrsPosition(this.aee.aRT());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.gDW) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.dIF.getPageActivity()).createFromThreadCfg(this.aee, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.hxX == 501) {
                str4 = "frs_tab";
            } else if (this.aee.aRH()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aee.aRN());
            createFromThreadCfg.setSmartFrsPosition(this.aee.aRT());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.gDW) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bk bkVar) {
        this.aee = bkVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLe() {
        this.gEi.removeMessages(202);
        if (this.Xt.getCurrentPosition() > 0) {
            t(false, 3);
            this.gEi.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gEi.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLf() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gEi.removeMessages(203);
        int currentPosition = this.Xt.getCurrentPosition();
        if (currentPosition != this.gEb) {
            this.gEb = currentPosition;
            t(false, 3);
        } else {
            t(false, 2);
        }
        this.gEi.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, int i) {
        if (this.eBn != null && this.eBm != null && this.eBr != null && this.eBq != null && this.eBp != null && this.eBo != null) {
            if (z || this.eBt != i) {
                this.eBt = i;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBy);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBx);
                if (i == 2) {
                    this.eBn.setVisibility(8);
                    this.boX.cancel();
                    this.eBm.clearAnimation();
                    this.eBm.setVisibility(0);
                    this.eBr.setVisibility(0);
                    this.gFE.setVisibility(0);
                    this.eBq.startLoading();
                    this.eBp.setVisibility(8);
                    this.eBo.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBy, 60000L);
                } else if (i == 3) {
                    this.eBn.setVisibility(8);
                    this.eBm.startAnimation(this.boX);
                    this.eBr.setVisibility(8);
                    this.gFE.setVisibility(8);
                    this.eBq.cRA();
                    this.eBp.setVisibility(8);
                    this.eBo.setVisibility(8);
                    if (this.aee != null && this.aee.aQQ() != null) {
                        this.aee.aQQ().video_length.intValue();
                        this.aee.aQQ().video_duration.intValue();
                        this.aee.getTid();
                    }
                } else if (i == 4) {
                    this.eBn.setVisibility(8);
                    this.eBm.startAnimation(this.boX);
                    this.eBr.setVisibility(8);
                    this.eBq.cRB();
                    this.eBp.setVisibility(0);
                    this.eBo.setVisibility(0);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBx, 2000L);
                } else {
                    this.eBn.setVisibility(0);
                    this.gFE.setVisibility(0);
                    this.boX.cancel();
                    this.eBm.clearAnimation();
                    this.eBm.setVisibility(0);
                    this.eBr.setVisibility(0);
                    this.eBq.cRB();
                    this.eBp.setVisibility(8);
                    this.eBo.setVisibility(8);
                }
            }
        }
    }

    private void Z(final bk bkVar) {
        if (this.gGf != null) {
            if (bkVar == null) {
                this.gGf.setVisibility(8);
            } else if (!StringUtils.isNull(bkVar.dHn)) {
                if (this.hxV != null && this.hxV.cci() && (this.gGf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGf.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.dIF.getContext(), R.dimen.tbds106);
                    this.gGf.setLayoutParams(layoutParams);
                }
                this.gGf.setVisibility(0);
                this.gGf.setImageDrawable(null);
                this.gGf.startLoad(bkVar.dHn, 10, false);
                this.gGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.dIF != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bkVar.dHo, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gGf.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aee == null || this.aee.aQx() == null) {
            this.fGx.setVisibility(8);
            return;
        }
        this.fGx.setVisibility(0);
        this.fGx.setOnClickListener(this);
        bLh();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dGF)) {
            this.aee.cY(this.mUrl, this.dGF);
        }
        this.aee.v(false, true);
        SpannableStringBuilder aRi = this.aee.aRi();
        if (this.aee.aRo() && !StringUtils.isNull(this.aee.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aee.getTid();
            aRi.append((CharSequence) this.aee.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").dh("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(aRi));
        this.mTextTitle.setText(aRi);
        this.hxV.aA(this.aee);
        Z(this.aee);
        this.fGy.setData(this.aee);
        if (this.fGy.getHeaderImg() != null) {
            if (this.fGy.getIsSimpleThread()) {
                this.fGy.getHeaderImg().setVisibility(8);
                this.gDX.setVisibility(8);
            } else if (this.aee.aQx() == null || this.aee.aQx().getPendantData() == null || StringUtils.isNull(this.aee.aQx().getPendantData().aOP())) {
                this.gDX.setVisibility(8);
                this.fGy.getHeaderImg().setVisibility(0);
                this.fGy.getHeaderImg().setData(this.aee);
            } else {
                this.fGy.getHeaderImg().setVisibility(4);
                this.gDX.setVisibility(0);
                this.gDX.setData(this.aee);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGz.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.fGz.setLayoutParams(layoutParams);
        this.fGy.setUserAfterClickListener(this.agI);
        qA(pa(1));
        this.eBl.setText(aq.stringForVideoTime(this.aee.aQQ().video_duration.intValue() * 1000));
        this.eBs.setText(String.format(this.dIF.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.aee.aQQ().play_count.intValue())));
        this.gDW.setData(this.aee.aSb());
        this.gDW.onChangeSkinType();
        if (m.Do(this.aee.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            m.a(this.gDW.getGodReplyContent(), this.aee.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.aee == null || this.aee.aQQ() == null) {
            z = false;
        } else {
            z = this.aee.aQQ().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gEh.setVisibility(0);
        } else {
            this.gEh.setVisibility(8);
        }
        if (this.fGz.isInFrsAllThread() && com.baidu.tieba.frs.a.bTZ().bUa()) {
            this.mMaskView.setVisibility(0);
            if (this.aee.aSk() || this.aee.aSl()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLg() {
        this.gEi.removeMessages(202);
        this.gEi.removeMessages(203);
    }

    private void bic() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBx);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBy);
    }

    private void bLh() {
        bic();
        bLg();
        if (this.eBm != null && this.eBk != null && this.Xt != null) {
            if (k.aNQ().isShowImages() && this.aee != null && this.aee.aQQ() != null) {
                this.eBk.setVisibility(0);
                this.eBm.setPlaceHolder(3);
                this.eBm.startLoad(this.aee.aQQ().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aee.aQQ().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    t(true, 4);
                    TiebaStatic.log(new an("c12026").dh("tid", this.aee.getId()));
                }
                if (this.gGR != null && this.gGR.cRl() != null) {
                    this.gGR.cRl().an(this.aee);
                    return;
                }
                return;
            }
            this.eBk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGx, R.drawable.addresslist_item_bg);
            am.setImageResource(this.eBn, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.eBo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBl, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBs, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eBp, R.color.common_color_10014);
            am.setBackgroundColor(this.eLr, R.color.cp_bg_line_c);
            if (this.eBo != null) {
                this.eBo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.fHl != null && this.fHl.getVisibility() == 0) {
                this.fHl.onChangeSkinType();
            }
            this.fGz.onChangeSkinType();
            this.mSkinType = i;
            this.fGy.onChangeSkinType();
            if (this.gDX != null && this.gDX.getHeadView() != null && (this.gDX.getHeadView() instanceof TbImageView)) {
                this.gDX.getHeadView().setPlaceHolder(1);
            }
            this.eBm.setPlaceHolder(3);
            this.hxV.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.currentPageType = i;
        if (this.fGz != null) {
            this.fGz.dWv = i;
            this.fGz.setFrom(2);
        }
        if (this.fGy != null) {
            this.fGy.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.gEc;
    }

    public boolean isPlaying() {
        if (this.Xt == null) {
            return false;
        }
        return this.Xt.isPlaying();
    }

    public void startPlay() {
        if (!this.gEc && this.aee != null && this.aee.aQQ() != null && this.Xt != null) {
            this.Xt.stopPlayback();
            if (ag.bgU()) {
                if (this.hxW || com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    t(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").dh("obj_locate", "frs").dh("tid", this.aee.getId()));
                        this.mVideoUrl = this.aee.aQQ().video_url;
                    }
                    this.gEc = true;
                    this.Xt.setVideoPath(this.mVideoUrl, this.aee.getId());
                    if (this.fbY != null) {
                        this.fbY.start();
                    }
                    bLa();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLa() {
        if (this.aee != null && this.aee.aQQ() != null) {
            String str = this.aee.aRH() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.aee.aQB()) {
                str = "frs_mcn";
            }
            if (this.hxX == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.ais = this.aee.getTid();
            yVar.evm = this.aee.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.aee.mRecomSource;
            yVar.kBv = this.aee.mRecomAbTag;
            yVar.kBr = this.aee.mRecomAbTag;
            yVar.kBs = this.aee.mRecomWeight;
            yVar.kBt = "";
            yVar.kBw = this.aee.aQQ().video_md5;
            com.baidu.tieba.play.l.a(this.aee.aQQ().video_md5, "", "1", yVar, this.Xt.getPcdnState());
        }
    }

    public void stopPlay() {
        bic();
        bLg();
        t(true, 1);
        if (this.Xt != null) {
            this.Xt.stopPlayback();
            if (this.fbY != null) {
                this.fbY.stop();
            }
        }
        this.gEc = false;
    }

    public View getVideoContainer() {
        return this.eBk;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Xt == null) {
            return 0;
        }
        return this.Xt.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.gGR != null) {
            this.gGR.setVideoStatsData(yVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGz != null && this.fGy != null) {
            this.fGy.setPageUniqueId(bdUniqueId);
        }
    }

    public void qA(int i) {
        if (this.aee != null) {
            if (i == 1) {
                this.fGz.setVisibility(8);
                this.fHl.setData(this.aee);
                this.fGA.setVisibility(8);
                return;
            }
            this.fGz.setData(this.aee);
            this.fGA.setVisibility(8);
            this.fHl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int pa(int i) {
        return com.baidu.tieba.a.d.bmb().as(this.aeX, i);
    }
}
