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
    public FrameLayout eAZ;
    private TextView eBa;
    private TbImageView eBb;
    private ImageView eBc;
    private TextView eBd;
    private View eBe;
    private w eBf;
    private View eBg;
    private TextView eBh;
    private int eBi;
    private TbImageView.a eBj;
    private g.b eBk;
    private ViewTreeObserver.OnGlobalLayoutListener eBl;
    private Runnable eBm;
    private Runnable eBn;
    private QuickVideoView.b eBo;
    private g.a eKl;
    private g.f eKm;
    private g.e eKo;
    private View eLg;
    public LinearLayout eTB;
    private RelativeLayout fGm;
    public ThreadUserInfoLayout fGn;
    public ThreadCommentAndPraiseInfoLayout fGo;
    public View fGp;
    protected ThreadSourceShareAndPraiseLayout fHa;
    public ThreadSkinView fHl;
    private j fbN;
    private ThreadGodReplyLayout gDL;
    private HeadPendantClickableView gDM;
    private int gDQ;
    private boolean gDR;
    private TextView gDW;
    private Handler gDX;
    private VideoLoadingProgressView.a gDY;
    private j.a gEd;
    private Animation.AnimationListener gEe;
    private TbImageView gFU;
    private LinearLayout gFt;
    private n gGG;
    public TextView hxH;
    public LinearLayout hxI;
    private g hxJ;
    private i hxK;
    public boolean hxL;
    public int hxM;
    private View.OnClickListener hxN;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bKX() {
        if (this.hxJ != null && this.gDR) {
            try {
                this.Xt.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gDX.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gDQ = 0;
        this.eBi = 1;
        this.gDR = false;
        this.gDX = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bLc();
                        return;
                    case 203:
                        a.this.bLd();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.hxJ = gVar;
                if (a.this.hxJ != null) {
                    a.this.hxJ.setVolume(0.0f, 0.0f);
                }
                a.this.bKX();
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.t(false, 3);
                }
                return false;
            }
        };
        this.eKl = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Xt.start();
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bLe();
                a.this.t(true, 4);
                a.this.gDR = false;
                return true;
            }
        };
        this.gDY = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bKX();
            }
        };
        this.eBj = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.eBb != null) {
                    a.this.eBb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eBl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.eAZ != null && a.this.eAZ.getLayoutParams() != null && a.this.eAZ.getVisibility() != 8) {
                    a.this.eAZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.eAZ.getLayoutParams();
                    if (a.this.eAZ.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.eAZ.getWidth() * 0.5625d);
                        a.this.eAZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eBm = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Xt != null && !a.this.Xt.isPlaying()) {
                    a.this.t(true, 1);
                }
            }
        };
        this.eBn = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bLe();
                a.this.t(true, 4);
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.hxN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
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
                if (a.this.bKS() != null) {
                    a.this.bKS().a(view, a.this.aee);
                }
            }
        };
        this.dWy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aee != null && a.this.bKS() != null) {
                    a.this.bKS().a(view, a.this.aee);
                }
            }
        };
        this.gEd = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qg() {
                a.this.bKY();
            }
        };
        this.gEe = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.eBi == 3 && a.this.eBb != null) {
                    a.this.eBb.setVisibility(8);
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
        this.eLg = view.findViewById(R.id.divider_line);
        this.fGm = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gFU = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.hxI = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fGm.setOnClickListener(this);
        this.gDM = (HeadPendantClickableView) this.fGm.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.gDM.getHeadView() != null) {
            this.gDM.getHeadView().setIsRound(true);
            this.gDM.getHeadView().setDrawBorder(false);
            this.gDM.getHeadView().setDefaultResource(17170445);
            this.gDM.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDM.getHeadView().setRadius(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds70));
        }
        this.gDM.setHasPendantStyle();
        if (this.gDM.getPendantView() != null) {
            this.gDM.getPendantView().setIsRound(true);
            this.gDM.getPendantView().setDrawBorder(false);
        }
        this.hxH = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.hxH.setVisibility(8);
        this.hxH.setOnClickListener(this.hxN);
        this.eBf = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.eBf.setLoadingAnimationListener(this.gDY);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fGo.setForumAfterClickListener(this.dWy);
        this.fGn = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fGn.setFrom(3);
        this.fGp = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.fGo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGo.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGo.setLayoutParams(layoutParams);
        }
        this.fGo.setOnClickListener(this);
        this.fGo.setReplyTimeVisible(false);
        this.fGo.setShowPraiseNum(true);
        this.fGo.setNeedAddPraiseIcon(true);
        this.fGo.setNeedAddReplyIcon(true);
        this.fGo.setIsBarViewVisible(false);
        this.fGo.setShareVisible(true);
        this.fGo.setShareReportFrom(1);
        this.fGo.setStType("frs_page");
        this.fGo.setFrom(2);
        this.fGo.dWv = 3;
        this.fHa = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fHa.dXt.setOnClickListener(this);
        this.fHa.setFrom(2);
        this.fHa.setShareReportFrom(1);
        this.fHa.setSourceFromForPb(3);
        this.fHa.setStType("frs_page");
        this.fHa.setHideBarName(true);
        this.eAZ = (FrameLayout) view.findViewById(R.id.frame_video);
        this.eAZ.setOnClickListener(this);
        this.eAZ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.eAZ != null) {
                    a.this.eAZ.getViewTreeObserver().addOnGlobalLayoutListener(a.this.eBl);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.eAZ != null) {
                    a.this.eAZ.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.eBl);
                }
            }
        });
        this.eBb = (TbImageView) view.findViewById(R.id.image_video);
        this.eBb.setPageId(getTag());
        this.eBb.setDefaultErrorResource(0);
        this.eBb.setDrawCorner(true);
        this.eBb.setPlaceHolder(3);
        this.eBb.setEvent(this.eBj);
        this.eBb.setGifIconSupport(false);
        this.eBc = (ImageView) view.findViewById(R.id.image_video_play);
        this.Xt = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.gGG = new n(this.dIF.getPageActivity());
        this.Xt.setContinuePlayEnable(true);
        this.Xt.setBusiness(this.gGG);
        this.Xt.setOnPreparedListener(this.eKm);
        this.Xt.setOnCompletionListener(this.eKl);
        this.Xt.setOnErrorListener(this.eBk);
        this.Xt.setOnOutInfoListener(this.eKo);
        this.Xt.setOnSurfaceDestroyedListener(this.eBo);
        this.fbN = new j();
        this.fbN.setPlayer(this.Xt);
        this.fbN.a(this.gEd);
        this.eBg = view.findViewById(R.id.auto_video_black_mask);
        this.eBd = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.eBe = view.findViewById(R.id.auto_video_error_background);
        this.eTB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fHl = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.boX = AnimationUtils.loadAnimation(this.dIF.getPageActivity(), R.anim.fade_out_video_cover);
        this.boX.setAnimationListener(this.gEe);
        this.eBa = (TextView) view.findViewById(R.id.text_video_duration);
        this.eBh = (TextView) view.findViewById(R.id.text_video_play_count);
        this.gFt = (LinearLayout) view.findViewById(R.id.duration_container);
        this.hxK = new i(tbPageContext, this.fGm);
        this.hxK.setUniqueId(getTag());
        this.gDL = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.gDL.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.fGo != null) {
                    a.this.fGo.changeSelectStatus();
                }
            }
        });
        this.fGo.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hp(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.gDW = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fGm || view == this.fGo.getCommentNumView() || view == this.hxI) {
            bL(this.fGm);
        } else if (view == this.eAZ) {
            if (this.aee != null && this.aee.aQQ() != null) {
                z = this.aee.aQQ().is_vertical.intValue() == 1;
            }
            if (z) {
                bJ(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bY(this.eAZ);
                } else {
                    bL(this.eAZ);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bY(this.eAZ);
            } else {
                bL(this.eAZ);
            }
        } else if (view == this.gDL) {
            bL(this.gDL);
        }
        if (this.aee != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aee));
        }
    }

    private void bJ(View view) {
        if (bKS() != null) {
            bKS().a(view, this.aee);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bKZ();
        }
    }

    private void bKZ() {
        if (this.aee != null) {
            String str = "frs";
            if (this.hxM == 501) {
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
        if (bKS() != null) {
            bKS().a(view, this.aee);
        }
        if (view == this.eAZ) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bLa();
            }
        }
    }

    private void bLa() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aee);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.eTB.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.eTB.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.hxM == 501) {
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
        if (bKS() != null) {
            bKS().a(view, this.aee);
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
            if (this.aee.aQV() > 0 && com.baidu.tieba.tbadkCore.util.e.deF()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.dIF.getPageActivity()).createHistoryCfg(this.aee.getTid(), String.valueOf(this.aee.aQV()), false, true, "frs_page");
                String str3 = "frs";
                if (this.hxM == 501) {
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
                if (view == this.gDL) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.dIF.getPageActivity()).createFromThreadCfg(this.aee, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.hxM == 501) {
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
            if (view == this.gDL) {
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
    public void bLc() {
        this.gDX.removeMessages(202);
        if (this.Xt.getCurrentPosition() > 0) {
            t(false, 3);
            this.gDX.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gDX.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLd() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gDX.removeMessages(203);
        int currentPosition = this.Xt.getCurrentPosition();
        if (currentPosition != this.gDQ) {
            this.gDQ = currentPosition;
            t(false, 3);
        } else {
            t(false, 2);
        }
        this.gDX.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, int i) {
        if (this.eBc != null && this.eBb != null && this.eBg != null && this.eBf != null && this.eBe != null && this.eBd != null) {
            if (z || this.eBi != i) {
                this.eBi = i;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBn);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBm);
                if (i == 2) {
                    this.eBc.setVisibility(8);
                    this.boX.cancel();
                    this.eBb.clearAnimation();
                    this.eBb.setVisibility(0);
                    this.eBg.setVisibility(0);
                    this.gFt.setVisibility(0);
                    this.eBf.startLoading();
                    this.eBe.setVisibility(8);
                    this.eBd.setVisibility(8);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBn, 60000L);
                } else if (i == 3) {
                    this.eBc.setVisibility(8);
                    this.eBb.startAnimation(this.boX);
                    this.eBg.setVisibility(8);
                    this.gFt.setVisibility(8);
                    this.eBf.cRk();
                    this.eBe.setVisibility(8);
                    this.eBd.setVisibility(8);
                    if (this.aee != null && this.aee.aQQ() != null) {
                        this.aee.aQQ().video_length.intValue();
                        this.aee.aQQ().video_duration.intValue();
                        this.aee.getTid();
                    }
                } else if (i == 4) {
                    this.eBc.setVisibility(8);
                    this.eBb.startAnimation(this.boX);
                    this.eBg.setVisibility(8);
                    this.eBf.cRl();
                    this.eBe.setVisibility(0);
                    this.eBd.setVisibility(0);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.eBm, 2000L);
                } else {
                    this.eBc.setVisibility(0);
                    this.gFt.setVisibility(0);
                    this.boX.cancel();
                    this.eBb.clearAnimation();
                    this.eBb.setVisibility(0);
                    this.eBg.setVisibility(0);
                    this.eBf.cRl();
                    this.eBe.setVisibility(8);
                    this.eBd.setVisibility(8);
                }
            }
        }
    }

    private void Z(final bk bkVar) {
        if (this.gFU != null) {
            if (bkVar == null) {
                this.gFU.setVisibility(8);
            } else if (!StringUtils.isNull(bkVar.dHn)) {
                if (this.hxK != null && this.hxK.cca() && (this.gFU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFU.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.dIF.getContext(), R.dimen.tbds106);
                    this.gFU.setLayoutParams(layoutParams);
                }
                this.gFU.setVisibility(0);
                this.gFU.setImageDrawable(null);
                this.gFU.startLoad(bkVar.dHn, 10, false);
                this.gFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.dIF != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bkVar.dHo, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gFU.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aee == null || this.aee.aQx() == null) {
            this.fGm.setVisibility(8);
            return;
        }
        this.fGm.setVisibility(0);
        this.fGm.setOnClickListener(this);
        bLf();
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
        this.hxK.aA(this.aee);
        Z(this.aee);
        this.fGn.setData(this.aee);
        if (this.fGn.getHeaderImg() != null) {
            if (this.fGn.getIsSimpleThread()) {
                this.fGn.getHeaderImg().setVisibility(8);
                this.gDM.setVisibility(8);
            } else if (this.aee.aQx() == null || this.aee.aQx().getPendantData() == null || StringUtils.isNull(this.aee.aQx().getPendantData().aOP())) {
                this.gDM.setVisibility(8);
                this.fGn.getHeaderImg().setVisibility(0);
                this.fGn.getHeaderImg().setData(this.aee);
            } else {
                this.fGn.getHeaderImg().setVisibility(4);
                this.gDM.setVisibility(0);
                this.gDM.setData(this.aee);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGo.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.fGo.setLayoutParams(layoutParams);
        this.fGn.setUserAfterClickListener(this.agI);
        qy(oY(1));
        this.eBa.setText(aq.stringForVideoTime(this.aee.aQQ().video_duration.intValue() * 1000));
        this.eBh.setText(String.format(this.dIF.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.aee.aQQ().play_count.intValue())));
        this.gDL.setData(this.aee.aSb());
        this.gDL.onChangeSkinType();
        if (m.Do(this.aee.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            m.a(this.gDL.getGodReplyContent(), this.aee.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.aee == null || this.aee.aQQ() == null) {
            z = false;
        } else {
            z = this.aee.aQQ().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gDW.setVisibility(0);
        } else {
            this.gDW.setVisibility(8);
        }
        if (this.fGo.isInFrsAllThread() && com.baidu.tieba.frs.a.bTX().bTY()) {
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
    public void bLe() {
        this.gDX.removeMessages(202);
        this.gDX.removeMessages(203);
    }

    private void bia() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBm);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBn);
    }

    private void bLf() {
        bia();
        bLe();
        if (this.eBb != null && this.eAZ != null && this.Xt != null) {
            if (k.aNQ().isShowImages() && this.aee != null && this.aee.aQQ() != null) {
                this.eAZ.setVisibility(0);
                this.eBb.setPlaceHolder(3);
                this.eBb.startLoad(this.aee.aQQ().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aee.aQQ().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    t(true, 4);
                    TiebaStatic.log(new an("c12026").dh("tid", this.aee.getId()));
                }
                if (this.gGG != null && this.gGG.cQV() != null) {
                    this.gGG.cQV().an(this.aee);
                    return;
                }
                return;
            }
            this.eAZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGm, R.drawable.addresslist_item_bg);
            am.setImageResource(this.eBc, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.eBd, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBa, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBh, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eBe, R.color.common_color_10014);
            am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c);
            if (this.eBd != null) {
                this.eBd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.fHa != null && this.fHa.getVisibility() == 0) {
                this.fHa.onChangeSkinType();
            }
            this.fGo.onChangeSkinType();
            this.mSkinType = i;
            this.fGn.onChangeSkinType();
            if (this.gDM != null && this.gDM.getHeadView() != null && (this.gDM.getHeadView() instanceof TbImageView)) {
                this.gDM.getHeadView().setPlaceHolder(1);
            }
            this.eBb.setPlaceHolder(3);
            this.hxK.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
        this.currentPageType = i;
        if (this.fGo != null) {
            this.fGo.dWv = i;
            this.fGo.setFrom(2);
        }
        if (this.fGn != null) {
            this.fGn.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.gDR;
    }

    public boolean isPlaying() {
        if (this.Xt == null) {
            return false;
        }
        return this.Xt.isPlaying();
    }

    public void startPlay() {
        if (!this.gDR && this.aee != null && this.aee.aQQ() != null && this.Xt != null) {
            this.Xt.stopPlayback();
            if (ag.bgT()) {
                if (this.hxL || com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    t(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").dh("obj_locate", "frs").dh("tid", this.aee.getId()));
                        this.mVideoUrl = this.aee.aQQ().video_url;
                    }
                    this.gDR = true;
                    this.Xt.setVideoPath(this.mVideoUrl, this.aee.getId());
                    if (this.fbN != null) {
                        this.fbN.start();
                    }
                    bKY();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKY() {
        if (this.aee != null && this.aee.aQQ() != null) {
            String str = this.aee.aRH() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.aee.aQB()) {
                str = "frs_mcn";
            }
            if (this.hxM == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.ais = this.aee.getTid();
            yVar.evm = this.aee.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.aee.mRecomSource;
            yVar.kAp = this.aee.mRecomAbTag;
            yVar.kAl = this.aee.mRecomAbTag;
            yVar.kAm = this.aee.mRecomWeight;
            yVar.kAn = "";
            yVar.kAq = this.aee.aQQ().video_md5;
            com.baidu.tieba.play.l.a(this.aee.aQQ().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        bia();
        bLe();
        t(true, 1);
        if (this.Xt != null) {
            this.Xt.stopPlayback();
            if (this.fbN != null) {
                this.fbN.stop();
            }
        }
        this.gDR = false;
    }

    public View getVideoContainer() {
        return this.eAZ;
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
        if (this.gGG != null) {
            this.gGG.setVideoStatsData(yVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGo != null && this.fGn != null) {
            this.fGn.setPageUniqueId(bdUniqueId);
        }
    }

    public void qy(int i) {
        if (this.aee != null) {
            if (i == 1) {
                this.fGo.setVisibility(8);
                this.fHa.setData(this.aee);
                this.fGp.setVisibility(8);
                return;
            }
            this.fGo.setData(this.aee);
            this.fGp.setVisibility(8);
            this.fHa.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int oY(int i) {
        return com.baidu.tieba.a.d.blZ().as(this.aeX, i);
    }
}
