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
import com.baidu.android.imsdk.internal.IMConnection;
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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
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
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.b<bx> implements com.baidu.tieba.a.e, z {
    private TbCyberVideoView aae;
    private bx agB;
    private String ahw;
    private final View.OnClickListener ajJ;
    private Animation bWC;
    private String eDY;
    private TbPageContext<?> eGu;
    private final View.OnClickListener eVM;
    private CyberPlayerManager.OnPreparedListener emw;
    private CyberPlayerManager.OnErrorListener emx;
    private CyberPlayerManager.OnCompletionListener emy;
    private CyberPlayerManager.OnInfoListener emz;
    public FrameLayout fEW;
    private TextView fEX;
    private TbImageView fEY;
    private ImageView fEZ;
    private TextView fFa;
    private View fFb;
    private m fFc;
    private View fFd;
    private TextView fFe;
    private int fFf;
    private TbImageView.a fFg;
    private ViewTreeObserver.OnGlobalLayoutListener fFh;
    private Runnable fFi;
    private Runnable fFj;
    private TbCyberVideoView.a fFk;
    private View fPU;
    public LinearLayout fXC;
    private RelativeLayout gSw;
    public ThreadUserInfoLayout gSx;
    public ThreadCommentAndPraiseInfoLayout gSy;
    public View gSz;
    protected ThreadSourceShareAndPraiseLayout gTk;
    public ThreadSkinView gTv;
    private f giL;
    private ThreadGodReplyLayout hYg;
    private HeadPendantClickableView hYh;
    private int hYk;
    private boolean hYl;
    private TextView hYq;
    private Handler hYr;
    private VideoLoadingProgressView.a hYs;
    private f.a hYx;
    private Animation.AnimationListener hYy;
    private LinearLayout hZQ;
    public TextView iUg;
    public LinearLayout iUh;
    private i iUi;
    public boolean iUj;
    public int iUk;
    private View.OnClickListener iUl;
    private TbImageView ias;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnA() {
        if (this.aae != null && this.hYl) {
            try {
                this.aae.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hYr.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hYk = 0;
        this.fFf = 1;
        this.hYl = false;
        this.hYr = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.cnF();
                        return;
                    case 203:
                        a.this.cnG();
                        return;
                    default:
                        return;
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.aae != null) {
                    a.this.aae.setVolume(0.0f, 0.0f);
                }
                a.this.cnA();
            }
        };
        this.emz = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.w(false, 3);
                }
                return false;
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.aae.start();
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cnH();
                a.this.w(true, 4);
                a.this.hYl = false;
                return true;
            }
        };
        this.hYs = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.cnA();
            }
        };
        this.fFg = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.fEY != null) {
                    a.this.fEY.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fFh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fEW != null && a.this.fEW.getLayoutParams() != null && a.this.fEW.getVisibility() != 8) {
                    a.this.fEW.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fEW.getLayoutParams();
                    if (a.this.fEW.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fEW.getWidth() * 0.5625d);
                        a.this.fEW.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fFi = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.aae != null && !a.this.aae.isPlaying()) {
                    a.this.w(true, 1);
                }
            }
        };
        this.fFj = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cnH();
                a.this.w(true, 4);
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.iUl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agB != null && !StringUtils.isNull(a.this.agB.blG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eGu.getPageActivity()).createNormalCfg(a.this.agB.blG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.eVM != null) {
                        a.this.eVM.onClick(view);
                    }
                }
            }
        };
        this.ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cnv() != null) {
                    a.this.cnv().a(view, a.this.agB);
                }
            }
        };
        this.eVM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agB != null && a.this.cnv() != null) {
                    a.this.cnv().a(view, a.this.agB);
                }
            }
        };
        this.hYx = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                a.this.cnB();
            }
        };
        this.hYy = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fFf == 3 && a.this.fEY != null) {
                    a.this.fEY.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eGu = tbPageContext;
        View view = getView();
        this.fPU = view.findViewById(R.id.divider_line);
        this.gSw = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ias = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.iUh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gSw.setOnClickListener(this);
        this.hYh = (HeadPendantClickableView) this.gSw.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hYh.getHeadView() != null) {
            this.hYh.getHeadView().setIsRound(true);
            this.hYh.getHeadView().setDrawBorder(false);
            this.hYh.getHeadView().setDefaultResource(17170445);
            this.hYh.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hYh.getHeadView().setRadius(l.getDimens(this.eGu.getPageActivity(), R.dimen.ds70));
        }
        this.hYh.setHasPendantStyle();
        if (this.hYh.getPendantView() != null) {
            this.hYh.getPendantView().setIsRound(true);
            this.hYh.getPendantView().setDrawBorder(false);
        }
        this.iUg = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.iUg.setVisibility(8);
        this.iUg.setOnClickListener(this.iUl);
        this.fFc = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fFc.setLoadingAnimationListener(this.hYs);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gSy.setForumAfterClickListener(this.eVM);
        this.gSx = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gSx.setFrom(3);
        this.gSz = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.gSy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSy.setLayoutParams(layoutParams);
        }
        this.gSy.setOnClickListener(this);
        this.gSy.setReplyTimeVisible(false);
        this.gSy.setShowPraiseNum(true);
        this.gSy.setNeedAddPraiseIcon(true);
        this.gSy.setNeedAddReplyIcon(true);
        this.gSy.setIsBarViewVisible(false);
        this.gSy.setShareVisible(true);
        this.gSy.setShareReportFrom(1);
        this.gSy.setStType("frs_page");
        this.gSy.setFrom(2);
        this.gSy.eVJ = 3;
        this.gTk = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gTk.eWE.setOnClickListener(this);
        this.gTk.setFrom(2);
        this.gTk.setShareReportFrom(1);
        this.gTk.setSourceFromForPb(3);
        this.gTk.setStType("frs_page");
        this.gTk.setHideBarName(true);
        this.fEW = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fEW.setOnClickListener(this);
        this.fEW.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fEW != null) {
                    a.this.fEW.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fFh);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fEW != null) {
                    a.this.fEW.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fFh);
                }
            }
        });
        this.fEY = (TbImageView) view.findViewById(R.id.image_video);
        this.fEY.setPageId(getTag());
        this.fEY.setDefaultErrorResource(0);
        this.fEY.setDrawCorner(true);
        this.fEY.setPlaceHolder(3);
        this.fEY.setEvent(this.fFg);
        this.fEY.setGifIconSupport(false);
        this.fEZ = (ImageView) view.findViewById(R.id.image_video_play);
        this.aae = new TbCyberVideoView(getContext());
        this.aae.setStageType("2003");
        bEK();
        this.aae.setContinuePlayEnable(true);
        this.aae.setOnPreparedListener(this.emw);
        this.aae.setOnCompletionListener(this.emy);
        this.aae.setOnErrorListener(this.emx);
        this.aae.setOnInfoListener(this.emz);
        this.aae.setOnSurfaceDestroyedListener(this.fFk);
        this.giL = new f();
        this.giL.setPlayer(this.aae);
        this.giL.a(this.hYx);
        this.fFd = view.findViewById(R.id.auto_video_black_mask);
        this.fFa = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fFb = view.findViewById(R.id.auto_video_error_background);
        this.fXC = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gTv = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bWC = AnimationUtils.loadAnimation(this.eGu.getPageActivity(), R.anim.fade_out_video_cover);
        this.bWC.setAnimationListener(this.hYy);
        this.fEX = (TextView) view.findViewById(R.id.text_video_duration);
        this.fFe = (TextView) view.findViewById(R.id.text_video_play_count);
        this.hZQ = (LinearLayout) view.findViewById(R.id.duration_container);
        this.iUi = new i(tbPageContext, this.gSw);
        this.iUi.setUniqueId(getTag());
        this.hYg = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hYg.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gSy != null) {
                    a.this.gSy.changeSelectStatus();
                }
            }
        });
        this.gSy.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jt(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
                }
            }
        });
        this.hYq = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bEK() {
        if (this.aae != null && this.aae.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fEW.addView(this.aae.getView(), 0);
            this.aae.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gSw || view == this.gSy.getCommentNumView() || view == this.iUh) {
            cx(this.gSw);
        } else if (view == this.fEW) {
            if (this.agB != null && this.agB.blU() != null) {
                z = this.agB.blU().is_vertical.intValue() == 1;
            }
            if (z) {
                cv(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cH(this.fEW);
            } else {
                cx(this.fEW);
            }
        } else if (view == this.hYg) {
            cx(this.hYg);
        }
        if (this.agB != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.agB));
        }
    }

    private void cv(View view) {
        if (cnv() != null) {
            cnv().a(view, this.agB);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eGu.getPageActivity(), R.string.no_network_guide);
        } else {
            cnC();
        }
    }

    private void cnC() {
        if (this.agB != null) {
            String str = "frs";
            if (this.iUk == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.agB);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.agB.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.agB.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cH(View view) {
        if (this.agB != null) {
            ar arVar = new ar("c11100");
            arVar.dR("tid", this.agB.getId());
            arVar.dR("fid", this.agB.getFid() + "");
            TiebaStatic.log(arVar);
        }
        if (cnv() != null) {
            cnv().a(view, this.agB);
        }
        if (view == this.fEW) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eGu.getPageActivity(), R.string.no_network_guide);
            } else {
                cnD();
            }
        }
    }

    private void cnD() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.agB);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fXC.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fXC.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.iUk == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eGu.getPageActivity(), str, this.agB.getTid(), n.blo(), "", videoSerializeVideoThreadInfo);
        if (this.agB.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.agB.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void cx(View view) {
        String str;
        String str2;
        if (this.agB != null) {
            if (this.agB.bmN()) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dR("fid", String.valueOf(this.agB.getFid())).ak("obj_type", 2));
            } else {
                ar arVar = new ar("c11100");
                arVar.dR("tid", this.agB.getId());
                arVar.dR("fid", this.agB.getFid() + "");
                TiebaStatic.log(arVar);
            }
            if (this.agB.blC() != null && this.agB.blC().getGodUserData() != null && this.agB.blC().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ar("c10806").ak("obj_locate", 3).dR("tid", this.agB.getId()));
            }
        }
        if (cnv() != null) {
            cnv().a(view, this.agB);
        }
        if (this.agB != null) {
            n.IA(this.agB.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            aa.DZ(this.agB.getId());
            String valueOf = String.valueOf(this.agB.getFid());
            if (this.agB.eEQ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.agB.eEQ.id;
                str2 = valueOf;
            }
            if (this.agB.blZ() > 0 && com.baidu.tieba.tbadkCore.util.e.dLe()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eGu.getPageActivity()).createHistoryCfg(this.agB.getTid(), String.valueOf(this.agB.blZ()), false, true, "frs_page");
                String str3 = "frs";
                if (this.iUk == 501) {
                    str3 = "frs_tab";
                } else if (this.agB.bmN()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.agB.bmT());
                createHistoryCfg.setSmartFrsPosition(this.agB.bmZ());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.hYg) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eGu.getPageActivity()).createFromThreadCfg(this.agB, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.iUk == 501) {
                str4 = "frs_tab";
            } else if (this.agB.bmN()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.agB.bmT());
            createFromThreadCfg.setSmartFrsPosition(this.agB.bmZ());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.hYg) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bx bxVar) {
        this.agB = bxVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnF() {
        this.hYr.removeMessages(202);
        if (this.aae.getCurrentPosition() > 0) {
            w(false, 3);
            this.hYr.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hYr.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnG() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hYr.removeMessages(203);
        int currentPosition = this.aae.getCurrentPosition();
        if (currentPosition != this.hYk) {
            this.hYk = currentPosition;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hYr.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fEZ != null && this.fEY != null && this.fFd != null && this.fFc != null && this.fFb != null && this.fFa != null) {
            if (z || this.fFf != i) {
                this.fFf = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFj);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFi);
                if (i == 2) {
                    this.fEZ.setVisibility(8);
                    this.bWC.cancel();
                    this.fEY.clearAnimation();
                    this.fEY.setVisibility(0);
                    this.fFd.setVisibility(0);
                    this.hZQ.setVisibility(0);
                    this.fFc.startLoading();
                    this.fFb.setVisibility(8);
                    this.fFa.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFj, 60000L);
                } else if (i == 3) {
                    this.fEZ.setVisibility(8);
                    this.fEY.startAnimation(this.bWC);
                    this.fFd.setVisibility(8);
                    this.hZQ.setVisibility(8);
                    this.fFc.dwC();
                    this.fFb.setVisibility(8);
                    this.fFa.setVisibility(8);
                    if (this.agB != null && this.agB.blU() != null) {
                        this.agB.blU().video_length.intValue();
                        this.agB.blU().video_duration.intValue();
                        this.agB.getTid();
                    }
                } else if (i == 4) {
                    this.fEZ.setVisibility(8);
                    this.fEY.startAnimation(this.bWC);
                    this.fFd.setVisibility(8);
                    this.fFc.dwD();
                    this.fFb.setVisibility(0);
                    this.fFa.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFi, 2000L);
                } else {
                    this.fEZ.setVisibility(0);
                    this.hZQ.setVisibility(0);
                    this.bWC.cancel();
                    this.fEY.clearAnimation();
                    this.fEY.setVisibility(0);
                    this.fFd.setVisibility(0);
                    this.fFc.dwD();
                    this.fFb.setVisibility(8);
                    this.fFa.setVisibility(8);
                }
            }
        }
    }

    private void aa(final bx bxVar) {
        if (this.ias != null) {
            if (bxVar == null) {
                this.ias.setVisibility(8);
            } else if (!StringUtils.isNull(bxVar.eEG)) {
                if (this.iUi != null && this.iUi.cFH() && (this.ias.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ias.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eGu.getContext(), R.dimen.tbds106);
                    this.ias.setLayoutParams(layoutParams);
                }
                this.ias.setVisibility(0);
                this.ias.setImageDrawable(null);
                this.ias.startLoad(bxVar.eEG, 10, false);
                this.ias.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eGu != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bxVar.eEH, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ias.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.agB == null || this.agB.blC() == null) {
            this.gSw.setVisibility(8);
            return;
        }
        this.gSw.setVisibility(0);
        this.gSw.setOnClickListener(this);
        cnI();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eDY)) {
            this.agB.dE(this.mUrl, this.eDY);
        }
        this.agB.z(false, true);
        SpannableStringBuilder bmm = this.agB.bmm();
        if (this.agB.bms() && !StringUtils.isNull(this.agB.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bpu().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.agB.getTid();
            bmm.append((CharSequence) this.agB.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ar("c12841").dR("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(bmm));
        this.mTextTitle.setText(bmm);
        this.iUi.aA(this.agB);
        aa(this.agB);
        this.gSx.setData(this.agB);
        if (this.gSx.getHeaderImg() != null) {
            if (this.gSx.getIsSimpleThread()) {
                this.gSx.getHeaderImg().setVisibility(8);
                this.hYh.setVisibility(8);
            } else if (this.agB.blC() == null || this.agB.blC().getPendantData() == null || StringUtils.isNull(this.agB.blC().getPendantData().bjy())) {
                this.hYh.setVisibility(8);
                this.gSx.getHeaderImg().setVisibility(0);
                this.gSx.getHeaderImg().setData(this.agB);
            } else {
                this.gSx.getHeaderImg().setVisibility(4);
                this.hYh.setVisibility(0);
                this.hYh.setData(this.agB);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSy.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.gSy.setLayoutParams(layoutParams);
        this.gSx.setUserAfterClickListener(this.ajJ);
        vD(tH(1));
        this.fEX.setText(au.stringForVideoTime(this.agB.blU().video_duration.intValue() * 1000));
        this.fFe.setText(String.format(this.eGu.getResources().getString(R.string.play_count), au.numFormatOverWan(this.agB.blU().play_count.intValue())));
        this.hYg.setData(this.agB.bnh());
        this.hYg.onChangeSkinType();
        if (n.IB(this.agB.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            n.a(this.hYg.getGodReplyContent(), this.agB.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.agB == null || this.agB.blU() == null) {
            z = false;
        } else {
            z = this.agB.blU().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hYq.setVisibility(0);
        } else {
            this.hYq.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) && this.gSy.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agB.bnp() || this.agB.bnq() || this.agB.bnr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnH() {
        this.hYr.removeMessages(202);
        this.hYr.removeMessages(203);
    }

    private void bEL() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFi);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFj);
    }

    private void cnI() {
        bEL();
        cnH();
        if (this.fEY != null && this.fEW != null && this.aae != null) {
            if (k.biL().isShowImages() && this.agB != null && this.agB.blU() != null) {
                this.fEW.setVisibility(0);
                this.fEY.setPlaceHolder(3);
                this.fEY.startLoad(this.agB.blU().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.agB.blU().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                    TiebaStatic.log(new ar("c12026").dR("tid", this.agB.getId()));
                }
                this.aae.setThreadDataForStatistic(this.agB);
                return;
            }
            this.fEW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gSw, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fEZ, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fFa, R.color.CAM_X0101);
            ap.setViewTextColor(this.fEX, R.color.CAM_X0101);
            ap.setViewTextColor(this.fFe, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fFb, R.color.common_color_10014);
            ap.setBackgroundColor(this.fPU, R.color.CAM_X0204);
            if (this.fFa != null) {
                this.fFa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.gTk != null && this.gTk.getVisibility() == 0) {
                this.gTk.onChangeSkinType();
            }
            this.gSy.onChangeSkinType();
            this.mSkinType = i;
            this.gSx.onChangeSkinType();
            if (this.hYh != null && this.hYh.getHeadView() != null && (this.hYh.getHeadView() instanceof TbImageView)) {
                this.hYh.getHeadView().setPlaceHolder(1);
            }
            this.fEY.setPlaceHolder(3);
            this.iUi.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.currentPageType = i;
        if (this.gSy != null) {
            this.gSy.eVJ = i;
            this.gSy.setFrom(2);
        }
        if (this.gSx != null) {
            this.gSx.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.hYl;
    }

    public boolean isPlaying() {
        if (this.aae == null) {
            return false;
        }
        return this.aae.isPlaying();
    }

    public void startPlay() {
        if (!this.hYl && this.agB != null && this.agB.blU() != null && this.aae != null) {
            this.aae.stopPlayback();
            if (ah.bDu()) {
                if (this.iUj || com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    w(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new ar("c12619").dR("obj_locate", "frs").dR("tid", this.agB.getId()));
                        this.mVideoUrl = this.agB.blU().video_url;
                    }
                    this.hYl = true;
                    this.aae.setVideoPath(this.mVideoUrl, this.agB.getId());
                    if (this.giL != null) {
                        this.giL.start();
                    }
                    cnB();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnB() {
        if (this.agB != null && this.agB.blU() != null) {
            String str = this.agB.bmN() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.iUk == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.alZ = this.agB.getTid();
            oVar.fyg = this.agB.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.agB.mRecomSource;
            oVar.mko = this.agB.mRecomAbTag;
            oVar.mkk = this.agB.mRecomAbTag;
            oVar.mkl = this.agB.mRecomWeight;
            oVar.mkm = "";
            oVar.mkp = this.agB.blU().video_md5;
            h.a(this.agB.blU().video_md5, "", "1", oVar, this.aae.getPcdnState());
        }
    }

    public void stopPlay() {
        bEL();
        cnH();
        w(true, 1);
        if (this.aae != null) {
            this.aae.stopPlayback();
            if (this.giL != null) {
                this.giL.stop();
            }
        }
        this.hYl = false;
    }

    public View getVideoContainer() {
        return this.fEW;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.aae == null) {
            return 0;
        }
        return this.aae.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.aae != null) {
            this.aae.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSy != null && this.gSx != null) {
            this.gSx.setPageUniqueId(bdUniqueId);
        }
    }

    public void vD(int i) {
        if (this.agB != null) {
            if (i == 1) {
                this.gSy.setVisibility(8);
                this.gTk.setData(this.agB);
                this.gSz.setVisibility(8);
                return;
            }
            this.gSy.setData(this.agB);
            this.gSz.setVisibility(8);
            this.gTk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    public int tH(int i) {
        return com.baidu.tieba.a.d.bIl().aw(this.ahw, i);
    }
}
