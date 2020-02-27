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
    private Animation aLx;
    private String cTi;
    private TbPageContext<?> cVg;
    private View cel;
    public FrameLayout dLU;
    private TextView dLV;
    private TbImageView dLW;
    private ImageView dLX;
    private TextView dLY;
    private View dLZ;
    private w dMa;
    private View dMb;
    private TextView dMc;
    private int dMd;
    private TbImageView.a dMe;
    private g.b dMf;
    private ViewTreeObserver.OnGlobalLayoutListener dMg;
    private Runnable dMh;
    private Runnable dMi;
    private QuickVideoView.b dMj;
    private g.a dVb;
    private g.f dVc;
    private g.e dVe;
    private final View.OnClickListener dhI;
    protected ThreadSourceShareAndPraiseLayout eNX;
    private RelativeLayout eNj;
    public ThreadUserInfoLayout eNk;
    public ThreadCommentAndPraiseInfoLayout eNl;
    public View eNm;
    public ThreadSkinView eOi;
    private g eeN;
    public LinearLayout egF;
    private j ekX;
    private j.a fJE;
    private Animation.AnimationListener fJF;
    private ThreadGodReplyLayout fJm;
    private HeadPendantClickableView fJn;
    private int fJr;
    private boolean fJs;
    private TextView fJx;
    private Handler fJy;
    private VideoLoadingProgressView.a fJz;
    private LinearLayout fKU;
    private TbImageView fLv;
    private n fMh;
    public TextView gyg;
    public LinearLayout gyh;
    private i gyi;
    public boolean gyj;
    public int gyk;
    private View.OnClickListener gyl;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        if (this.eeN != null && this.fJs) {
            try {
                this.DI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fJy.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fJr = 0;
        this.dMd = 1;
        this.fJs = false;
        this.fJy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.buQ();
                        return;
                    case 203:
                        a.this.buR();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.eeN = gVar;
                if (a.this.eeN != null) {
                    a.this.eeN.setVolume(0.0f, 0.0f);
                }
                a.this.buL();
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVb = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.DI.start();
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.buS();
                a.this.p(true, 4);
                a.this.fJs = false;
                return true;
            }
        };
        this.fJz = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.buL();
            }
        };
        this.dMe = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dLW != null) {
                    a.this.dLW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.dLU != null && a.this.dLU.getLayoutParams() != null && a.this.dLU.getVisibility() != 8) {
                    a.this.dLU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.dLU.getLayoutParams();
                    if (a.this.dLU.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.dLU.getWidth() * 0.5625d);
                        a.this.dLU.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dMh = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.DI != null && !a.this.DI.isPlaying()) {
                    a.this.p(true, 1);
                }
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.buS();
                a.this.p(true, 4);
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.gyl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && !StringUtils.isNull(a.this.KJ.aCr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVg.getPageActivity()).createNormalCfg(a.this.KJ.aCr(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.dhI != null) {
                        a.this.dhI.onClick(view);
                    }
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buE() != null) {
                    a.this.buE().a(view, a.this.KJ);
                }
            }
        };
        this.dhI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && a.this.buE() != null) {
                    a.this.buE().a(view, a.this.KJ);
                }
            }
        };
        this.fJE = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                a.this.buM();
            }
        };
        this.fJF = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dMd == 3 && a.this.dLW != null) {
                    a.this.dLW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.cVg = tbPageContext;
        View view = getView();
        this.cel = view.findViewById(R.id.divider_line);
        this.eNj = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fLv = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.gyh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNj.setOnClickListener(this);
        this.fJn = (HeadPendantClickableView) this.eNj.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fJn.getHeadView() != null) {
            this.fJn.getHeadView().setIsRound(true);
            this.fJn.getHeadView().setDrawBorder(false);
            this.fJn.getHeadView().setDefaultResource(17170445);
            this.fJn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJn.getHeadView().setRadius(l.getDimens(this.cVg.getPageActivity(), R.dimen.ds70));
        }
        this.fJn.setHasPendantStyle();
        if (this.fJn.getPendantView() != null) {
            this.fJn.getPendantView().setIsRound(true);
            this.fJn.getPendantView().setDrawBorder(false);
        }
        this.gyg = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.gyg.setVisibility(8);
        this.gyg.setOnClickListener(this.gyl);
        this.dMa = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dMa.setLoadingAnimationListener(this.fJz);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNl.setForumAfterClickListener(this.dhI);
        this.eNk = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eNk.setFrom(3);
        this.eNm = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.eNl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNl.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNl.setLayoutParams(layoutParams);
        }
        this.eNl.setOnClickListener(this);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setIsBarViewVisible(false);
        this.eNl.setShareVisible(true);
        this.eNl.setShareReportFrom(1);
        this.eNl.setStType("frs_page");
        this.eNl.setFrom(2);
        this.eNl.dhF = 3;
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eNX.diG.setOnClickListener(this);
        this.eNX.setFrom(2);
        this.eNX.setShareReportFrom(1);
        this.eNX.setSourceFromForPb(3);
        this.eNX.setStType("frs_page");
        this.eNX.setHideBarName(true);
        this.dLU = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dLU.setOnClickListener(this);
        this.dLU.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.dLU != null) {
                    a.this.dLU.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dMg);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.dLU != null) {
                    a.this.dLU.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dMg);
                }
            }
        });
        this.dLW = (TbImageView) view.findViewById(R.id.image_video);
        this.dLW.setPageId(getTag());
        this.dLW.setDefaultErrorResource(0);
        this.dLW.setDrawCorner(true);
        this.dLW.setPlaceHolder(3);
        this.dLW.setEvent(this.dMe);
        this.dLW.setGifIconSupport(false);
        this.dLX = (ImageView) view.findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.fMh = new n(this.cVg.getPageActivity());
        this.DI.setPlayerReuseEnable(true);
        this.DI.setContinuePlayEnable(true);
        this.DI.setBusiness(this.fMh);
        this.DI.setOnPreparedListener(this.dVc);
        this.DI.setOnCompletionListener(this.dVb);
        this.DI.setOnErrorListener(this.dMf);
        this.DI.setOnOutInfoListener(this.dVe);
        this.DI.setOnSurfaceDestroyedListener(this.dMj);
        this.ekX = new j();
        this.ekX.setPlayer(this.DI);
        this.ekX.a(this.fJE);
        this.dMb = view.findViewById(R.id.auto_video_black_mask);
        this.dLY = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dLZ = view.findViewById(R.id.auto_video_error_background);
        this.egF = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eOi = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.aLx = AnimationUtils.loadAnimation(this.cVg.getPageActivity(), R.anim.fade_out_video_cover);
        this.aLx.setAnimationListener(this.fJF);
        this.dLV = (TextView) view.findViewById(R.id.text_video_duration);
        this.dMc = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fKU = (LinearLayout) view.findViewById(R.id.duration_container);
        this.gyi = new i(tbPageContext, this.eNj);
        this.gyi.setUniqueId(getTag());
        this.fJm = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fJm.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eNl != null) {
                    a.this.eNl.changeSelectStatus();
                }
            }
        });
        this.eNl.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fT(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.fJx = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNj || view == this.eNl.getCommentNumView() || view == this.gyh) {
            bH(this.eNj);
        } else if (view == this.dLU) {
            if (this.KJ != null && this.KJ.aCD() != null) {
                z = this.KJ.aCD().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bQ(this.dLU);
                } else {
                    bH(this.dLU);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bQ(this.dLU);
            } else {
                bH(this.dLU);
            }
        } else if (view == this.fJm) {
            bH(this.fJm);
        }
        if (this.KJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.KJ));
        }
    }

    private void bF(View view) {
        if (buE() != null) {
            buE().a(view, this.KJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.cVg.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buN();
        }
    }

    private void buN() {
        if (this.KJ != null) {
            String str = "frs";
            if (this.gyk == 501) {
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
        if (buE() != null) {
            buE().a(view, this.KJ);
        }
        if (view == this.dLU) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                buO();
            }
        }
    }

    private void buO() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.KJ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.egF.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.egF.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.gyk == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVg.getPageActivity(), str, this.KJ.getTid(), com.baidu.tieba.card.l.aBY(), "", videoSerializeVideoThreadInfo);
        if (this.KJ.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.KJ.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bH(View view) {
        String str;
        String str2;
        if (this.KJ != null) {
            if (this.KJ.aDr()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cy("fid", String.valueOf(this.KJ.getFid())).X("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cy("tid", this.KJ.getId());
                anVar.cy("fid", this.KJ.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.KJ.aCm() != null && this.KJ.aCm().getGodUserData() != null && this.KJ.aCm().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").X("obj_locate", 3).cy("tid", this.KJ.getId()));
            }
        }
        if (buE() != null) {
            buE().a(view, this.KJ);
        }
        if (this.KJ != null) {
            com.baidu.tieba.card.l.zS(this.KJ.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.vW(this.KJ.getId());
            String valueOf = String.valueOf(this.KJ.getFid());
            if (this.KJ.cTZ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.KJ.cTZ.id;
                str2 = valueOf;
            }
            if (this.KJ.aCI() > 0 && com.baidu.tieba.tbadkCore.util.e.cMa()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.cVg.getPageActivity()).createHistoryCfg(this.KJ.getTid(), String.valueOf(this.KJ.aCI()), false, true, "frs_page");
                String str3 = "frs";
                if (this.gyk == 501) {
                    str3 = "frs_tab";
                } else if (this.KJ.aDr()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.KJ.aDx());
                createHistoryCfg.setSmartFrsPosition(this.KJ.aDC());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.fJm) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.cVg.getPageActivity()).createFromThreadCfg(this.KJ, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.gyk == 501) {
                str4 = "frs_tab";
            } else if (this.KJ.aDr()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.KJ.aDx());
            createFromThreadCfg.setSmartFrsPosition(this.KJ.aDC());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.fJm) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
    public void buQ() {
        this.fJy.removeMessages(202);
        if (this.DI.getCurrentPosition() > 0) {
            p(false, 3);
            this.fJy.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fJy.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buR() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fJy.removeMessages(203);
        int currentPosition = this.DI.getCurrentPosition();
        if (currentPosition != this.fJr) {
            this.fJr = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fJy.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dLX != null && this.dLW != null && this.dMb != null && this.dMa != null && this.dLZ != null && this.dLY != null) {
            if (z || this.dMd != i) {
                this.dMd = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMh);
                if (i == 2) {
                    this.dLX.setVisibility(8);
                    this.aLx.cancel();
                    this.dLW.clearAnimation();
                    this.dLW.setVisibility(0);
                    this.dMb.setVisibility(0);
                    this.fKU.setVisibility(0);
                    this.dMa.startLoading();
                    this.dLZ.setVisibility(8);
                    this.dLY.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMi, 60000L);
                } else if (i == 3) {
                    this.dLX.setVisibility(8);
                    this.dLW.startAnimation(this.aLx);
                    this.dMb.setVisibility(8);
                    this.fKU.setVisibility(8);
                    this.dMa.czm();
                    this.dLZ.setVisibility(8);
                    this.dLY.setVisibility(8);
                    if (this.KJ != null && this.KJ.aCD() != null) {
                        this.KJ.aCD().video_length.intValue();
                        this.KJ.aCD().video_duration.intValue();
                        this.KJ.getTid();
                    }
                } else if (i == 4) {
                    this.dLX.setVisibility(8);
                    this.dLW.startAnimation(this.aLx);
                    this.dMb.setVisibility(8);
                    this.dMa.czn();
                    this.dLZ.setVisibility(0);
                    this.dLY.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMh, 2000L);
                } else {
                    this.dLX.setVisibility(0);
                    this.fKU.setVisibility(0);
                    this.aLx.cancel();
                    this.dLW.clearAnimation();
                    this.dLW.setVisibility(0);
                    this.dMb.setVisibility(0);
                    this.dMa.czn();
                    this.dLZ.setVisibility(8);
                    this.dLY.setVisibility(8);
                }
            }
        }
    }

    private void X(final bj bjVar) {
        if (this.fLv != null) {
            if (bjVar == null) {
                this.fLv.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cTQ)) {
                if (this.gyi != null && this.gyi.bKN() && (this.fLv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLv.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.cVg.getContext(), R.dimen.tbds106);
                    this.fLv.setLayoutParams(layoutParams);
                }
                this.fLv.setVisibility(0);
                this.fLv.setImageDrawable(null);
                this.fLv.startLoad(bjVar.cTQ, 10, false);
                this.fLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.cVg != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.cTR, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fLv.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.KJ == null || this.KJ.aCm() == null) {
            this.eNj.setVisibility(8);
            return;
        }
        this.eNj.setVisibility(0);
        this.eNj.setOnClickListener(this);
        buT();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTi)) {
            this.KJ.cp(this.mUrl, this.cTi);
        }
        this.KJ.s(false, true);
        SpannableStringBuilder aCT = this.KJ.aCT();
        if (this.KJ.aCZ() && !StringUtils.isNull(this.KJ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.KJ.getTid();
            aCT.append((CharSequence) this.KJ.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new h(aCT));
        this.mTextTitle.setText(aCT);
        this.gyi.ax(this.KJ);
        X(this.KJ);
        this.eNk.setData(this.KJ);
        if (this.eNk.getHeaderImg() != null) {
            if (this.eNk.getIsSimpleThread()) {
                this.eNk.getHeaderImg().setVisibility(8);
                this.fJn.setVisibility(8);
            } else if (this.KJ.aCm() == null || this.KJ.aCm().getPendantData() == null || StringUtils.isNull(this.KJ.aCm().getPendantData().aAE())) {
                this.fJn.setVisibility(8);
                this.eNk.getHeaderImg().setVisibility(0);
                this.eNk.getHeaderImg().setData(this.KJ);
            } else {
                this.eNk.getHeaderImg().setVisibility(4);
                this.fJn.setVisibility(0);
                this.fJn.setData(this.KJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNl.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.eNl.setLayoutParams(layoutParams);
        this.eNk.setUserAfterClickListener(this.Nw);
        pB(oc(1));
        this.dLV.setText(aq.stringForVideoTime(this.KJ.aCD().video_duration.intValue() * 1000));
        this.dMc.setText(String.format(this.cVg.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.KJ.aCD().play_count.intValue())));
        this.fJm.setData(this.KJ.aDK());
        this.fJm.onChangeSkinType();
        if (com.baidu.tieba.card.l.zT(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.fJm.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.KJ == null || this.KJ.aCD() == null) {
            z = false;
        } else {
            z = this.KJ.aCD().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fJx.setVisibility(0);
        } else {
            this.fJx.setVisibility(8);
        }
        if (this.eNl.isInFrsAllThread() && com.baidu.tieba.frs.a.bCT().bCU()) {
            this.mMaskView.setVisibility(0);
            if (this.KJ.aDT() || this.KJ.aDU()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buS() {
        this.fJy.removeMessages(202);
        this.fJy.removeMessages(203);
    }

    private void aTA() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMh);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
    }

    private void buT() {
        aTA();
        buS();
        if (this.dLW != null && this.dLU != null && this.DI != null) {
            if (com.baidu.tbadk.core.i.azM().isShowImages() && this.KJ != null && this.KJ.aCD() != null) {
                this.dLU.setVisibility(0);
                this.dLW.setPlaceHolder(3);
                this.dLW.startLoad(this.KJ.aCD().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.KJ.aCD().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                    TiebaStatic.log(new an("c12026").cy("tid", this.KJ.getId()));
                }
                if (this.fMh != null && this.fMh.cyX() != null) {
                    this.fMh.cyX().aj(this.KJ);
                    return;
                }
                return;
            }
            this.dLU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNj, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLX, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dLY, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dLV, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMc, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dLZ, R.color.common_color_10014);
            am.setBackgroundColor(this.cel, R.color.cp_bg_line_c);
            if (this.dLY != null) {
                this.dLY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.eNX != null && this.eNX.getVisibility() == 0) {
                this.eNX.onChangeSkinType();
            }
            this.eNl.onChangeSkinType();
            this.mSkinType = i;
            this.eNk.onChangeSkinType();
            if (this.fJn != null && this.fJn.getHeadView() != null && (this.fJn.getHeadView() instanceof TbImageView)) {
                this.fJn.getHeadView().setPlaceHolder(1);
            }
            this.dLW.setPlaceHolder(3);
            this.gyi.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.currentPageType = i;
        if (this.eNl != null) {
            this.eNl.dhF = i;
            this.eNl.setFrom(2);
        }
        if (this.eNk != null) {
            this.eNk.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.fJs;
    }

    public boolean isPlaying() {
        if (this.DI == null) {
            return false;
        }
        return this.DI.isPlaying();
    }

    public void startPlay() {
        if (!this.fJs && this.KJ != null && this.KJ.aCD() != null && this.DI != null) {
            this.DI.stopPlayback();
            if (af.aSu()) {
                if (this.gyj || com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    p(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cy("obj_locate", "frs").cy("tid", this.KJ.getId()));
                        this.mVideoUrl = this.KJ.aCD().video_url;
                    }
                    this.fJs = true;
                    this.DI.setVideoPath(this.mVideoUrl, this.KJ.getId());
                    if (this.ekX != null) {
                        this.ekX.start();
                    }
                    buM();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        if (this.KJ != null && this.KJ.aCD() != null) {
            String str = this.KJ.aDr() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.KJ.aCq()) {
                str = "frs_mcn";
            }
            if (this.gyk == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.Pj = this.KJ.getTid();
            yVar.ema = this.KJ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.KJ.mRecomSource;
            yVar.mAbTag = this.KJ.mRecomAbTag;
            yVar.jwE = this.KJ.mRecomAbTag;
            yVar.jwF = this.KJ.mRecomWeight;
            yVar.jwG = "";
            yVar.jwI = this.KJ.aCD().video_md5;
            com.baidu.tieba.play.l.a(this.KJ.aCD().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aTA();
        buS();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
            if (this.ekX != null) {
                this.ekX.stop();
            }
        }
        this.fJs = false;
    }

    public View getVideoContainer() {
        return this.dLU;
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
        if (this.fMh != null) {
            this.fMh.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNl != null && this.eNk != null) {
            this.eNk.setPageUniqueId(bdUniqueId);
        }
    }

    public void pB(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNl.setVisibility(8);
                this.eNX.setData(this.KJ);
                this.eNm.setVisibility(8);
                return;
            }
            this.eNl.setData(this.KJ);
            this.eNm.setVisibility(8);
            this.eNX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dLW.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dLW.setOnDrawListener(null);
        }
    }
}
