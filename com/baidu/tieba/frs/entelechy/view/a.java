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
    private final View.OnClickListener Nx;
    private Animation aLN;
    private String cTx;
    private TbPageContext<?> cVv;
    private View cey;
    private TbImageView dMA;
    private ImageView dMB;
    private TextView dMC;
    private View dMD;
    private w dME;
    private View dMF;
    private TextView dMG;
    private int dMH;
    private TbImageView.a dMI;
    private g.b dMJ;
    private ViewTreeObserver.OnGlobalLayoutListener dMK;
    private Runnable dML;
    private Runnable dMM;
    private QuickVideoView.b dMN;
    public FrameLayout dMy;
    private TextView dMz;
    private g.a dVF;
    private g.f dVG;
    private g.e dVI;
    private final View.OnClickListener dik;
    private RelativeLayout eNV;
    public ThreadUserInfoLayout eNW;
    public ThreadCommentAndPraiseInfoLayout eNX;
    public View eNY;
    protected ThreadSourceShareAndPraiseLayout eOJ;
    public ThreadSkinView eOU;
    private g efr;
    public LinearLayout ehj;
    private j elB;
    private j.a fKB;
    private Animation.AnimationListener fKC;
    private ThreadGodReplyLayout fKj;
    private HeadPendantClickableView fKk;
    private int fKo;
    private boolean fKp;
    private TextView fKu;
    private Handler fKv;
    private VideoLoadingProgressView.a fKw;
    private LinearLayout fLR;
    private TbImageView fMs;
    private n fNe;
    public TextView gzs;
    public LinearLayout gzt;
    private i gzu;
    public boolean gzv;
    public int gzw;
    private View.OnClickListener gzx;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        if (this.efr != null && this.fKp) {
            try {
                this.DI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fKv.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fKo = 0;
        this.dMH = 1;
        this.fKp = false;
        this.fKv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.buY();
                        return;
                    case 203:
                        a.this.buZ();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.efr = gVar;
                if (a.this.efr != null) {
                    a.this.efr.setVolume(0.0f, 0.0f);
                }
                a.this.buT();
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.p(false, 3);
                }
                return false;
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.DI.start();
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bva();
                a.this.p(true, 4);
                a.this.fKp = false;
                return true;
            }
        };
        this.fKw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.buT();
            }
        };
        this.dMI = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dMA != null) {
                    a.this.dMA.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMK = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.dMy != null && a.this.dMy.getLayoutParams() != null && a.this.dMy.getVisibility() != 8) {
                    a.this.dMy.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.dMy.getLayoutParams();
                    if (a.this.dMy.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.dMy.getWidth() * 0.5625d);
                        a.this.dMy.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dML = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.DI != null && !a.this.DI.isPlaying()) {
                    a.this.p(true, 1);
                }
            }
        };
        this.dMM = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bva();
                a.this.p(true, 4);
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.gzx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && !StringUtils.isNull(a.this.KJ.aCw())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cVv.getPageActivity()).createNormalCfg(a.this.KJ.aCw(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.dik != null) {
                        a.this.dik.onClick(view);
                    }
                }
            }
        };
        this.Nx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buM() != null) {
                    a.this.buM().a(view, a.this.KJ);
                }
            }
        };
        this.dik = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.KJ != null && a.this.buM() != null) {
                    a.this.buM().a(view, a.this.KJ);
                }
            }
        };
        this.fKB = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void lw() {
                a.this.buU();
            }
        };
        this.fKC = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dMH == 3 && a.this.dMA != null) {
                    a.this.dMA.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.cVv = tbPageContext;
        View view = getView();
        this.cey = view.findViewById(R.id.divider_line);
        this.eNV = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fMs = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.gzt = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eNV.setOnClickListener(this);
        this.fKk = (HeadPendantClickableView) this.eNV.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fKk.getHeadView() != null) {
            this.fKk.getHeadView().setIsRound(true);
            this.fKk.getHeadView().setDrawBorder(false);
            this.fKk.getHeadView().setDefaultResource(17170445);
            this.fKk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fKk.getHeadView().setRadius(l.getDimens(this.cVv.getPageActivity(), R.dimen.ds70));
        }
        this.fKk.setHasPendantStyle();
        if (this.fKk.getPendantView() != null) {
            this.fKk.getPendantView().setIsRound(true);
            this.fKk.getPendantView().setDrawBorder(false);
        }
        this.gzs = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.gzs.setVisibility(8);
        this.gzs.setOnClickListener(this.gzx);
        this.dME = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dME.setLoadingAnimationListener(this.fKw);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eNX.setForumAfterClickListener(this.dik);
        this.eNW = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eNW.setFrom(3);
        this.eNY = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.eNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNX.setLayoutParams(layoutParams);
        }
        this.eNX.setOnClickListener(this);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setIsBarViewVisible(false);
        this.eNX.setShareVisible(true);
        this.eNX.setShareReportFrom(1);
        this.eNX.setStType("frs_page");
        this.eNX.setFrom(2);
        this.eNX.dih = 3;
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eOJ.djh.setOnClickListener(this);
        this.eOJ.setFrom(2);
        this.eOJ.setShareReportFrom(1);
        this.eOJ.setSourceFromForPb(3);
        this.eOJ.setStType("frs_page");
        this.eOJ.setHideBarName(true);
        this.dMy = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dMy.setOnClickListener(this);
        this.dMy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.dMy != null) {
                    a.this.dMy.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dMK);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.dMy != null) {
                    a.this.dMy.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dMK);
                }
            }
        });
        this.dMA = (TbImageView) view.findViewById(R.id.image_video);
        this.dMA.setPageId(getTag());
        this.dMA.setDefaultErrorResource(0);
        this.dMA.setDrawCorner(true);
        this.dMA.setPlaceHolder(3);
        this.dMA.setEvent(this.dMI);
        this.dMA.setGifIconSupport(false);
        this.dMB = (ImageView) view.findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.fNe = new n(this.cVv.getPageActivity());
        this.DI.setPlayerReuseEnable(true);
        this.DI.setContinuePlayEnable(true);
        this.DI.setBusiness(this.fNe);
        this.DI.setOnPreparedListener(this.dVG);
        this.DI.setOnCompletionListener(this.dVF);
        this.DI.setOnErrorListener(this.dMJ);
        this.DI.setOnOutInfoListener(this.dVI);
        this.DI.setOnSurfaceDestroyedListener(this.dMN);
        this.elB = new j();
        this.elB.setPlayer(this.DI);
        this.elB.a(this.fKB);
        this.dMF = view.findViewById(R.id.auto_video_black_mask);
        this.dMC = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dMD = view.findViewById(R.id.auto_video_error_background);
        this.ehj = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eOU = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.aLN = AnimationUtils.loadAnimation(this.cVv.getPageActivity(), R.anim.fade_out_video_cover);
        this.aLN.setAnimationListener(this.fKC);
        this.dMz = (TextView) view.findViewById(R.id.text_video_duration);
        this.dMG = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fLR = (LinearLayout) view.findViewById(R.id.duration_container);
        this.gzu = new i(tbPageContext, this.eNV);
        this.gzu.setUniqueId(getTag());
        this.fKj = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fKj.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eNX != null) {
                    a.this.eNX.changeSelectStatus();
                }
            }
        });
        this.eNX.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fU(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.fKu = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eNV || view == this.eNX.getCommentNumView() || view == this.gzt) {
            bH(this.eNV);
        } else if (view == this.dMy) {
            if (this.KJ != null && this.KJ.aCI() != null) {
                z = this.KJ.aCI().is_vertical.intValue() == 1;
            }
            if (z) {
                bF(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bQ(this.dMy);
                } else {
                    bH(this.dMy);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bQ(this.dMy);
            } else {
                bH(this.dMy);
            }
        } else if (view == this.fKj) {
            bH(this.fKj);
        }
        if (this.KJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.KJ));
        }
    }

    private void bF(View view) {
        if (buM() != null) {
            buM().a(view, this.KJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.cVv.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            buV();
        }
    }

    private void buV() {
        if (this.KJ != null) {
            String str = "frs";
            if (this.gzw == 501) {
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
            anVar.cx("tid", this.KJ.getId());
            anVar.cx("fid", this.KJ.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (buM() != null) {
            buM().a(view, this.KJ);
        }
        if (view == this.dMy) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                buW();
            }
        }
    }

    private void buW() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.KJ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.ehj.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.ehj.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.gzw == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cVv.getPageActivity(), str, this.KJ.getTid(), com.baidu.tieba.card.l.aCd(), "", videoSerializeVideoThreadInfo);
        if (this.KJ.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.KJ.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bH(View view) {
        String str;
        String str2;
        if (this.KJ != null) {
            if (this.KJ.aDx()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cx("fid", String.valueOf(this.KJ.getFid())).X("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cx("tid", this.KJ.getId());
                anVar.cx("fid", this.KJ.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.KJ.aCr() != null && this.KJ.aCr().getGodUserData() != null && this.KJ.aCr().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").X("obj_locate", 3).cx("tid", this.KJ.getId()));
            }
        }
        if (buM() != null) {
            buM().a(view, this.KJ);
        }
        if (this.KJ != null) {
            com.baidu.tieba.card.l.zV(this.KJ.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.vY(this.KJ.getId());
            String valueOf = String.valueOf(this.KJ.getFid());
            if (this.KJ.cUo == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.KJ.cUo.id;
                str2 = valueOf;
            }
            if (this.KJ.aCN() > 0 && com.baidu.tieba.tbadkCore.util.e.cMx()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.cVv.getPageActivity()).createHistoryCfg(this.KJ.getTid(), String.valueOf(this.KJ.aCN()), false, true, "frs_page");
                String str3 = "frs";
                if (this.gzw == 501) {
                    str3 = "frs_tab";
                } else if (this.KJ.aDx()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.KJ.aDD());
                createHistoryCfg.setSmartFrsPosition(this.KJ.aDI());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.fKj) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.cVv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.cVv.getPageActivity()).createFromThreadCfg(this.KJ, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.gzw == 501) {
                str4 = "frs_tab";
            } else if (this.KJ.aDx()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.KJ.aDD());
            createFromThreadCfg.setSmartFrsPosition(this.KJ.aDI());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.fKj) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.cVv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
    public void buY() {
        this.fKv.removeMessages(202);
        if (this.DI.getCurrentPosition() > 0) {
            p(false, 3);
            this.fKv.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fKv.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buZ() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fKv.removeMessages(203);
        int currentPosition = this.DI.getCurrentPosition();
        if (currentPosition != this.fKo) {
            this.fKo = currentPosition;
            p(false, 3);
        } else {
            p(false, 2);
        }
        this.fKv.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dMB != null && this.dMA != null && this.dMF != null && this.dME != null && this.dMD != null && this.dMC != null) {
            if (z || this.dMH != i) {
                this.dMH = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMM);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dML);
                if (i == 2) {
                    this.dMB.setVisibility(8);
                    this.aLN.cancel();
                    this.dMA.clearAnimation();
                    this.dMA.setVisibility(0);
                    this.dMF.setVisibility(0);
                    this.fLR.setVisibility(0);
                    this.dME.startLoading();
                    this.dMD.setVisibility(8);
                    this.dMC.setVisibility(8);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dMM, 60000L);
                } else if (i == 3) {
                    this.dMB.setVisibility(8);
                    this.dMA.startAnimation(this.aLN);
                    this.dMF.setVisibility(8);
                    this.fLR.setVisibility(8);
                    this.dME.czI();
                    this.dMD.setVisibility(8);
                    this.dMC.setVisibility(8);
                    if (this.KJ != null && this.KJ.aCI() != null) {
                        this.KJ.aCI().video_length.intValue();
                        this.KJ.aCI().video_duration.intValue();
                        this.KJ.getTid();
                    }
                } else if (i == 4) {
                    this.dMB.setVisibility(8);
                    this.dMA.startAnimation(this.aLN);
                    this.dMF.setVisibility(8);
                    this.dME.czJ();
                    this.dMD.setVisibility(0);
                    this.dMC.setVisibility(0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.dML, 2000L);
                } else {
                    this.dMB.setVisibility(0);
                    this.fLR.setVisibility(0);
                    this.aLN.cancel();
                    this.dMA.clearAnimation();
                    this.dMA.setVisibility(0);
                    this.dMF.setVisibility(0);
                    this.dME.czJ();
                    this.dMD.setVisibility(8);
                    this.dMC.setVisibility(8);
                }
            }
        }
    }

    private void Y(final bj bjVar) {
        if (this.fMs != null) {
            if (bjVar == null) {
                this.fMs.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cUf)) {
                if (this.gzu != null && this.gzu.bLd() && (this.fMs.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMs.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.cVv.getContext(), R.dimen.tbds106);
                    this.fMs.setLayoutParams(layoutParams);
                }
                this.fMs.setVisibility(0);
                this.fMs.setImageDrawable(null);
                this.fMs.startLoad(bjVar.cUf, 10, false);
                this.fMs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.cVv != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.cUg, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fMs.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.KJ == null || this.KJ.aCr() == null) {
            this.eNV.setVisibility(8);
            return;
        }
        this.eNV.setVisibility(0);
        this.eNV.setOnClickListener(this);
        bvb();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cTx)) {
            this.KJ.co(this.mUrl, this.cTx);
        }
        this.KJ.t(false, true);
        SpannableStringBuilder aCY = this.KJ.aCY();
        if (this.KJ.aDe() && !StringUtils.isNull(this.KJ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.KJ.getTid();
            aCY.append((CharSequence) this.KJ.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cx("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aCY));
        this.mTextTitle.setText(aCY);
        this.gzu.ay(this.KJ);
        Y(this.KJ);
        this.eNW.setData(this.KJ);
        if (this.eNW.getHeaderImg() != null) {
            if (this.eNW.getIsSimpleThread()) {
                this.eNW.getHeaderImg().setVisibility(8);
                this.fKk.setVisibility(8);
            } else if (this.KJ.aCr() == null || this.KJ.aCr().getPendantData() == null || StringUtils.isNull(this.KJ.aCr().getPendantData().aAJ())) {
                this.fKk.setVisibility(8);
                this.eNW.getHeaderImg().setVisibility(0);
                this.eNW.getHeaderImg().setData(this.KJ);
            } else {
                this.eNW.getHeaderImg().setVisibility(4);
                this.fKk.setVisibility(0);
                this.fKk.setData(this.KJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.eNX.setLayoutParams(layoutParams);
        this.eNW.setUserAfterClickListener(this.Nx);
        pD(oe(1));
        this.dMz.setText(aq.stringForVideoTime(this.KJ.aCI().video_duration.intValue() * 1000));
        this.dMG.setText(String.format(this.cVv.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.KJ.aCI().play_count.intValue())));
        this.fKj.setData(this.KJ.aDQ());
        this.fKj.onChangeSkinType();
        if (com.baidu.tieba.card.l.zW(this.KJ.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.fKj.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.KJ == null || this.KJ.aCI() == null) {
            z = false;
        } else {
            z = this.KJ.aCI().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fKu.setVisibility(0);
        } else {
            this.fKu.setVisibility(8);
        }
        if (this.eNX.isInFrsAllThread() && com.baidu.tieba.frs.a.bDd().bDe()) {
            this.mMaskView.setVisibility(0);
            if (this.KJ.aDZ() || this.KJ.aEa()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bva() {
        this.fKv.removeMessages(202);
        this.fKv.removeMessages(203);
    }

    private void aTH() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dML);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMM);
    }

    private void bvb() {
        aTH();
        bva();
        if (this.dMA != null && this.dMy != null && this.DI != null) {
            if (com.baidu.tbadk.core.i.azR().isShowImages() && this.KJ != null && this.KJ.aCI() != null) {
                this.dMy.setVisibility(0);
                this.dMA.setPlaceHolder(3);
                this.dMA.startLoad(this.KJ.aCI().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.KJ.aCI().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                    TiebaStatic.log(new an("c12026").cx("tid", this.KJ.getId()));
                }
                if (this.fNe != null && this.fNe.czt() != null) {
                    this.fNe.czt().ak(this.KJ);
                    return;
                }
                return;
            }
            this.dMy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eNV, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMB, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dMC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMz, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMG, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMD, R.color.common_color_10014);
            am.setBackgroundColor(this.cey, R.color.cp_bg_line_c);
            if (this.dMC != null) {
                this.dMC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.eOJ != null && this.eOJ.getVisibility() == 0) {
                this.eOJ.onChangeSkinType();
            }
            this.eNX.onChangeSkinType();
            this.mSkinType = i;
            this.eNW.onChangeSkinType();
            if (this.fKk != null && this.fKk.getHeadView() != null && (this.fKk.getHeadView() instanceof TbImageView)) {
                this.fKk.getHeadView().setPlaceHolder(1);
            }
            this.dMA.setPlaceHolder(3);
            this.gzu.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
        this.currentPageType = i;
        if (this.eNX != null) {
            this.eNX.dih = i;
            this.eNX.setFrom(2);
        }
        if (this.eNW != null) {
            this.eNW.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.fKp;
    }

    public boolean isPlaying() {
        if (this.DI == null) {
            return false;
        }
        return this.DI.isPlaying();
    }

    public void startPlay() {
        if (!this.fKp && this.KJ != null && this.KJ.aCI() != null && this.DI != null) {
            this.DI.stopPlayback();
            if (af.aSB()) {
                if (this.gzv || com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    p(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cx("obj_locate", "frs").cx("tid", this.KJ.getId()));
                        this.mVideoUrl = this.KJ.aCI().video_url;
                    }
                    this.fKp = true;
                    this.DI.setVideoPath(this.mVideoUrl, this.KJ.getId());
                    if (this.elB != null) {
                        this.elB.start();
                    }
                    buU();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (this.KJ != null && this.KJ.aCI() != null) {
            String str = this.KJ.aDx() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.KJ.aCv()) {
                str = "frs_mcn";
            }
            if (this.gzw == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.Pk = this.KJ.getTid();
            yVar.emF = this.KJ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.KJ.mRecomSource;
            yVar.mAbTag = this.KJ.mRecomAbTag;
            yVar.jyr = this.KJ.mRecomAbTag;
            yVar.jys = this.KJ.mRecomWeight;
            yVar.jyt = "";
            yVar.jyv = this.KJ.aCI().video_md5;
            com.baidu.tieba.play.l.a(this.KJ.aCI().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aTH();
        bva();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
            if (this.elB != null) {
                this.elB.stop();
            }
        }
        this.fKp = false;
    }

    public View getVideoContainer() {
        return this.dMy;
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
        if (this.fNe != null) {
            this.fNe.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNX != null && this.eNW != null) {
            this.eNW.setPageUniqueId(bdUniqueId);
        }
    }

    public void pD(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNX.setVisibility(8);
                this.eOJ.setData(this.KJ);
                this.eNY.setVisibility(8);
                return;
            }
            this.eNX.setData(this.KJ);
            this.eNY.setVisibility(8);
            this.eOJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dMA.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dMA.setOnDrawListener(null);
        }
    }
}
