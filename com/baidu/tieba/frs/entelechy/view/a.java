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
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.play.y;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private QuickVideoView DI;
    private bj KJ;
    private String LC;
    private final View.OnClickListener Nw;
    private Animation aLz;
    private String cTk;
    private TbPageContext<?> cVi;
    private View cen;
    public FrameLayout dMi;
    private TextView dMj;
    private TbImageView dMk;
    private ImageView dMl;
    private TextView dMm;
    private View dMn;
    private w dMo;
    private View dMp;
    private TextView dMq;
    private int dMr;
    private TbImageView.a dMs;
    private g.b dMt;
    private ViewTreeObserver.OnGlobalLayoutListener dMu;
    private Runnable dMv;
    private Runnable dMw;
    private QuickVideoView.b dMx;
    private g.a dVp;
    private g.f dVq;
    private g.e dVs;
    private final View.OnClickListener dhW;
    public View eNA;
    private RelativeLayout eNx;
    public ThreadUserInfoLayout eNy;
    public ThreadCommentAndPraiseInfoLayout eNz;
    protected ThreadSourceShareAndPraiseLayout eOl;
    public ThreadSkinView eOw;
    private g efb;
    public LinearLayout egT;
    private j ell;
    private ThreadGodReplyLayout fJB;
    private HeadPendantClickableView fJC;
    private int fJG;
    private boolean fJH;
    private TextView fJM;
    private Handler fJN;
    private VideoLoadingProgressView.a fJO;
    private j.a fJT;
    private Animation.AnimationListener fJU;
    private TbImageView fLK;
    private LinearLayout fLj;
    private n fMw;
    public TextView gyu;
    public LinearLayout gyv;
    private i gyw;
    public boolean gyx;
    public int gyy;
    private View.OnClickListener gyz;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.efb != null && this.fJH) {
            try {
                this.DI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fJN.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fJG = 0;
        this.dMr = 1;
        this.fJH = false;
        this.fJN = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.buT();
                        return;
                    case 203:
                        a.this.buU();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVq = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.efb = gVar;
                if (a.this.efb != null) {
                    a.this.efb.setVolume(0.0f, 0.0f);
                }
                a.this.buO();
            }
        };
        this.dVs = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVp = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.DI.start();
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.buV();
                a.this.p(true, 4);
                a.this.fJH = false;
                return true;
            }
        };
        this.fJO = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.buO();
            }
        };
        this.dMs = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dMk != null) {
                    a.this.dMk.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMu = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.dMi != null && a.this.dMi.getLayoutParams() != null && a.this.dMi.getVisibility() != 8) {
                    a.this.dMi.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.dMi.getLayoutParams();
                    if (a.this.dMi.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.dMi.getWidth() * 0.5625d);
                        a.this.dMi.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dMv = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.DI != null && !a.this.DI.isPlaying()) {
                    a.this.p(true, 1);
                }
            }
        };
        this.dMw = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.buV();
                a.this.p(true, 4);
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.gyz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && !StringUtils.isNull(a.this.KJ.aCt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVi.getPageActivity()).createNormalCfg(a.this.KJ.aCt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.dhW != null) {
                        a.this.dhW.onClick(view);
                    }
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buH() != null) {
                    a.this.buH().a(view, a.this.KJ);
                }
            }
        };
        this.dhW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && a.this.buH() != null) {
                    a.this.buH().a(view, a.this.KJ);
                }
            }
        };
        this.fJT = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                a.this.buP();
            }
        };
        this.fJU = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dMr == 3 && a.this.dMk != null) {
                    a.this.dMk.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.cVi = tbPageContext;
        View view = getView();
        this.cen = view.findViewById(R.id.divider_line);
        this.eNx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fLK = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.gyv = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNx.setOnClickListener(this);
        this.fJC = (HeadPendantClickableView) this.eNx.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJC.getHeadView() != null) {
            this.fJC.getHeadView().setIsRound(true);
            this.fJC.getHeadView().setDrawBorder(false);
            this.fJC.getHeadView().setDefaultResource(17170445);
            this.fJC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJC.getHeadView().setRadius(l.getDimens(this.cVi.getPageActivity(), R.dimen.ds70));
        }
        this.fJC.setHasPendantStyle();
        if (this.fJC.getPendantView() != null) {
            this.fJC.getPendantView().setIsRound(true);
            this.fJC.getPendantView().setDrawBorder(false);
        }
        this.gyu = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.gyu.setVisibility(8);
        this.gyu.setOnClickListener(this.gyz);
        this.dMo = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dMo.setLoadingAnimationListener(this.fJO);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNz.setForumAfterClickListener(this.dhW);
        this.eNy = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eNy.setFrom(3);
        this.eNA = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.eNz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNz.setLayoutParams(layoutParams);
        }
        this.eNz.setOnClickListener(this);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setNeedAddPraiseIcon(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setIsBarViewVisible(false);
        this.eNz.setShareVisible(true);
        this.eNz.setShareReportFrom(1);
        this.eNz.setStType("frs_page");
        this.eNz.setFrom(2);
        this.eNz.dhT = 3;
        this.eOl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eOl.diU.setOnClickListener(this);
        this.eOl.setFrom(2);
        this.eOl.setShareReportFrom(1);
        this.eOl.setSourceFromForPb(3);
        this.eOl.setStType("frs_page");
        this.eOl.setHideBarName(true);
        this.dMi = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dMi.setOnClickListener(this);
        this.dMi.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.dMi != null) {
                    a.this.dMi.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dMu);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.dMi != null) {
                    a.this.dMi.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dMu);
                }
            }
        });
        this.dMk = (TbImageView) view.findViewById(R.id.image_video);
        this.dMk.setPageId(getTag());
        this.dMk.setDefaultErrorResource(0);
        this.dMk.setDrawCorner(true);
        this.dMk.setPlaceHolder(3);
        this.dMk.setEvent(this.dMs);
        this.dMk.setGifIconSupport(false);
        this.dMl = (ImageView) view.findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.fMw = new n(this.cVi.getPageActivity());
        this.DI.setPlayerReuseEnable(true);
        this.DI.setContinuePlayEnable(true);
        this.DI.setBusiness(this.fMw);
        this.DI.setOnPreparedListener(this.dVq);
        this.DI.setOnCompletionListener(this.dVp);
        this.DI.setOnErrorListener(this.dMt);
        this.DI.setOnOutInfoListener(this.dVs);
        this.DI.setOnSurfaceDestroyedListener(this.dMx);
        this.ell = new j();
        this.ell.setPlayer(this.DI);
        this.ell.a(this.fJT);
        this.dMp = view.findViewById(R.id.auto_video_black_mask);
        this.dMm = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dMn = view.findViewById(R.id.auto_video_error_background);
        this.egT = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eOw = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.aLz = AnimationUtils.loadAnimation(this.cVi.getPageActivity(), R.anim.fade_out_video_cover);
        this.aLz.setAnimationListener(this.fJU);
        this.dMj = (TextView) view.findViewById(R.id.text_video_duration);
        this.dMq = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fLj = (LinearLayout) view.findViewById(R.id.duration_container);
        this.gyw = new i(tbPageContext, this.eNx);
        this.gyw.setUniqueId(getTag());
        this.fJB = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJB.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eNz != null) {
                    a.this.eNz.changeSelectStatus();
                }
            }
        });
        this.eNz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.fJM = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNx || view == this.eNz.getCommentNumView() || view == this.gyv) {
            bH(this.eNx);
        } else if (view == this.dMi) {
            if (this.KJ != null && this.KJ.aCF() != null) {
                z = this.KJ.aCF().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bQ(this.dMi);
                } else {
                    bH(this.dMi);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bQ(this.dMi);
            } else {
                bH(this.dMi);
            }
        } else if (view == this.fJB) {
            bH(this.fJB);
        }
        if (this.KJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.KJ));
        }
    }

    private void bF(View view) {
        if (buH() != null) {
            buH().a(view, this.KJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.cVi.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buQ();
        }
    }

    private void buQ() {
        if (this.KJ != null) {
            String str = "frs";
            if (this.gyy == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.KJ);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.KJ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.KJ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bQ(View view) {
        if (this.KJ != null) {
            an anVar = new an("c11100");
            anVar.cy("tid", this.KJ.getId());
            anVar.cy("fid", this.KJ.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (buH() != null) {
            buH().a(view, this.KJ);
        }
        if (view == this.dMi) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                buR();
            }
        }
    }

    private void buR() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.KJ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.egT.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.egT.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.gyy == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVi.getPageActivity(), str, this.KJ.getTid(), com.baidu.tieba.card.l.aCa(), "", videoSerializeVideoThreadInfo);
        if (this.KJ.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.KJ.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bH(View view) {
        String str;
        String str2;
        if (this.KJ != null) {
            if (this.KJ.aDt()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cy("fid", String.valueOf(this.KJ.getFid())).X("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cy("tid", this.KJ.getId());
                anVar.cy("fid", this.KJ.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.KJ.aCo() != null && this.KJ.aCo().getGodUserData() != null && this.KJ.aCo().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").X("obj_locate", 3).cy("tid", this.KJ.getId()));
            }
        }
        if (buH() != null) {
            buH().a(view, this.KJ);
        }
        if (this.KJ != null) {
            com.baidu.tieba.card.l.zT(this.KJ.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.vX(this.KJ.getId());
            String valueOf = String.valueOf(this.KJ.getFid());
            if (this.KJ.cUb == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.KJ.cUb.id;
                str2 = valueOf;
            }
            if (this.KJ.aCK() > 0 && com.baidu.tieba.tbadkCore.util.e.cMd()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.cVi.getPageActivity()).createHistoryCfg(this.KJ.getTid(), String.valueOf(this.KJ.aCK()), false, true, "frs_page");
                String str3 = "frs";
                if (this.gyy == 501) {
                    str3 = "frs_tab";
                } else if (this.KJ.aDt()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.KJ.aDz());
                createHistoryCfg.setSmartFrsPosition(this.KJ.aDE());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.fJB) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.cVi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.cVi.getPageActivity()).createFromThreadCfg(this.KJ, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.gyy == 501) {
                str4 = "frs_tab";
            } else if (this.KJ.aDt()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.KJ.aDz());
            createFromThreadCfg.setSmartFrsPosition(this.KJ.aDE());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.fJB) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.cVi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.KJ = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        this.fJN.removeMessages(202);
        if (this.DI.getCurrentPosition() > 0) {
            p(false, 3);
            this.fJN.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fJN.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fJN.removeMessages(203);
        int currentPosition = this.DI.getCurrentPosition();
        if (currentPosition != this.fJG) {
            this.fJG = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fJN.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dMl != null && this.dMk != null && this.dMp != null && this.dMo != null && this.dMn != null && this.dMm != null) {
            if (z || this.dMr != i) {
                this.dMr = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMw);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMv);
                if (i == 2) {
                    this.dMl.setVisibility(8);
                    this.aLz.cancel();
                    this.dMk.clearAnimation();
                    this.dMk.setVisibility(0);
                    this.dMp.setVisibility(0);
                    this.fLj.setVisibility(0);
                    this.dMo.startLoading();
                    this.dMn.setVisibility(8);
                    this.dMm.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMw, 60000L);
                } else if (i == 3) {
                    this.dMl.setVisibility(8);
                    this.dMk.startAnimation(this.aLz);
                    this.dMp.setVisibility(8);
                    this.fLj.setVisibility(8);
                    this.dMo.czp();
                    this.dMn.setVisibility(8);
                    this.dMm.setVisibility(8);
                    if (this.KJ != null && this.KJ.aCF() != null) {
                        this.KJ.aCF().video_length.intValue();
                        this.KJ.aCF().video_duration.intValue();
                        this.KJ.getTid();
                    }
                } else if (i == 4) {
                    this.dMl.setVisibility(8);
                    this.dMk.startAnimation(this.aLz);
                    this.dMp.setVisibility(8);
                    this.dMo.czq();
                    this.dMn.setVisibility(0);
                    this.dMm.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMv, 2000L);
                } else {
                    this.dMl.setVisibility(0);
                    this.fLj.setVisibility(0);
                    this.aLz.cancel();
                    this.dMk.clearAnimation();
                    this.dMk.setVisibility(0);
                    this.dMp.setVisibility(0);
                    this.dMo.czq();
                    this.dMn.setVisibility(8);
                    this.dMm.setVisibility(8);
                }
            }
        }
    }

    private void X(final bj bjVar) {
        if (this.fLK != null) {
            if (bjVar == null) {
                this.fLK.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTS)) {
                if (this.gyw != null && this.gyw.bKQ() && (this.fLK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLK.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.cVi.getContext(), R.dimen.tbds106);
                    this.fLK.setLayoutParams(layoutParams);
                }
                this.fLK.setVisibility(0);
                this.fLK.setImageDrawable(null);
                this.fLK.startLoad(bjVar.cTS, 10, false);
                this.fLK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.cVi != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.cTT, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLK.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.KJ == null || this.KJ.aCo() == null) {
            this.eNx.setVisibility(8);
            return;
        }
        this.eNx.setVisibility(0);
        this.eNx.setOnClickListener(this);
        buW();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTk)) {
            this.KJ.cp(this.mUrl, this.cTk);
        }
        this.KJ.t(false, true);
        SpannableStringBuilder aCV = this.KJ.aCV();
        if (this.KJ.aDb() && !StringUtils.isNull(this.KJ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.KJ.getTid();
            aCV.append((CharSequence) this.KJ.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cy("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aCV));
        this.mTextTitle.setText(aCV);
        this.gyw.ax(this.KJ);
        X(this.KJ);
        this.eNy.setData(this.KJ);
        if (this.eNy.getHeaderImg() != null) {
            if (this.eNy.getIsSimpleThread()) {
                this.eNy.getHeaderImg().setVisibility(8);
                this.fJC.setVisibility(8);
            } else if (this.KJ.aCo() == null || this.KJ.aCo().getPendantData() == null || StringUtils.isNull(this.KJ.aCo().getPendantData().aAG())) {
                this.fJC.setVisibility(8);
                this.eNy.getHeaderImg().setVisibility(0);
                this.eNy.getHeaderImg().setData(this.KJ);
            } else {
                this.eNy.getHeaderImg().setVisibility(4);
                this.fJC.setVisibility(0);
                this.fJC.setData(this.KJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNz.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.eNz.setLayoutParams(layoutParams);
        this.eNy.setUserAfterClickListener(this.Nw);
        pB(oc(1));
        this.dMj.setText(aq.stringForVideoTime(this.KJ.aCF().video_duration.intValue() * 1000));
        this.dMq.setText(String.format(this.cVi.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.KJ.aCF().play_count.intValue())));
        this.fJB.setData(this.KJ.aDM());
        this.fJB.onChangeSkinType();
        if (com.baidu.tieba.card.l.zU(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.fJB.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.KJ == null || this.KJ.aCF() == null) {
            z = false;
        } else {
            z = this.KJ.aCF().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fJM.setVisibility(0);
        } else {
            this.fJM.setVisibility(8);
        }
        if (this.eNz.isInFrsAllThread() && com.baidu.tieba.frs.a.bCW().bCX()) {
            this.mMaskView.setVisibility(0);
            if (this.KJ.aDV() || this.KJ.aDW()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buV() {
        this.fJN.removeMessages(202);
        this.fJN.removeMessages(203);
    }

    private void aTD() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMv);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMw);
    }

    private void buW() {
        aTD();
        buV();
        if (this.dMk != null && this.dMi != null && this.DI != null) {
            if (com.baidu.tbadk.core.i.azO().isShowImages() && this.KJ != null && this.KJ.aCF() != null) {
                this.dMi.setVisibility(0);
                this.dMk.setPlaceHolder(3);
                this.dMk.startLoad(this.KJ.aCF().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.KJ.aCF().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                    TiebaStatic.log(new an("c12026").cy("tid", this.KJ.getId()));
                }
                if (this.fMw != null && this.fMw.cza() != null) {
                    this.fMw.cza().aj(this.KJ);
                    return;
                }
                return;
            }
            this.dMi.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNx, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMl, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dMm, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMj, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMq, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMn, R.color.common_color_10014);
            am.setBackgroundColor(this.cen, R.color.cp_bg_line_c);
            if (this.dMm != null) {
                this.dMm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.eOl != null && this.eOl.getVisibility() == 0) {
                this.eOl.onChangeSkinType();
            }
            this.eNz.onChangeSkinType();
            this.mSkinType = i;
            this.eNy.onChangeSkinType();
            if (this.fJC != null && this.fJC.getHeadView() != null && (this.fJC.getHeadView() instanceof TbImageView)) {
                this.fJC.getHeadView().setPlaceHolder(1);
            }
            this.dMk.setPlaceHolder(3);
            this.gyw.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.currentPageType = i;
        if (this.eNz != null) {
            this.eNz.dhT = i;
            this.eNz.setFrom(2);
        }
        if (this.eNy != null) {
            this.eNy.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.fJH;
    }

    public boolean isPlaying() {
        if (this.DI == null) {
            return false;
        }
        return this.DI.isPlaying();
    }

    public void startPlay() {
        if (!this.fJH && this.KJ != null && this.KJ.aCF() != null && this.DI != null) {
            this.DI.stopPlayback();
            if (af.aSx()) {
                if (this.gyx || com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    p(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cy("obj_locate", "frs").cy("tid", this.KJ.getId()));
                        this.mVideoUrl = this.KJ.aCF().video_url;
                    }
                    this.fJH = true;
                    this.DI.setVideoPath(this.mVideoUrl, this.KJ.getId());
                    if (this.ell != null) {
                        this.ell.start();
                    }
                    buP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buP() {
        if (this.KJ != null && this.KJ.aCF() != null) {
            String str = this.KJ.aDt() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.KJ.aCs()) {
                str = "frs_mcn";
            }
            if (this.gyy == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.Pj = this.KJ.getTid();
            yVar.emo = this.KJ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.KJ.mRecomSource;
            yVar.mAbTag = this.KJ.mRecomAbTag;
            yVar.jwS = this.KJ.mRecomAbTag;
            yVar.jwT = this.KJ.mRecomWeight;
            yVar.jwU = "";
            yVar.jwW = this.KJ.aCF().video_md5;
            com.baidu.tieba.play.l.a(this.KJ.aCF().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aTD();
        buV();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
            if (this.ell != null) {
                this.ell.stop();
            }
        }
        this.fJH = false;
    }

    public View getVideoContainer() {
        return this.dMi;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.DI == null) {
            return 0;
        }
        return this.DI.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.fMw != null) {
            this.fMw.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNz != null && this.eNy != null) {
            this.eNy.setPageUniqueId(bdUniqueId);
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNz.setVisibility(8);
                this.eOl.setData(this.KJ);
                this.eNA.setVisibility(8);
                return;
            }
            this.eNz.setData(this.KJ);
            this.eNA.setVisibility(8);
            this.eOl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXG().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dMk.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dMk.setOnDrawListener(null);
        }
    }
}
