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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
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
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<cb> implements e, z {
    private TbCyberVideoView abD;
    private cb ahi;
    private String aif;
    private final View.OnClickListener aki;
    private Animation chX;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnErrorListener eAB;
    private CyberPlayerManager.OnCompletionListener eAC;
    private CyberPlayerManager.OnInfoListener eAD;
    private String eSv;
    private TbPageContext<?> eUY;
    public FrameLayout fTU;
    private TextView fTV;
    private TbImageView fTW;
    private ImageView fTX;
    private TextView fTY;
    private View fTZ;
    private m fUa;
    private View fUb;
    private TextView fUc;
    private int fUd;
    private TbImageView.b fUe;
    private ViewTreeObserver.OnGlobalLayoutListener fUf;
    private Runnable fUg;
    private Runnable fUh;
    private TbCyberVideoView.a fUi;
    private final View.OnClickListener fkz;
    private f gAm;
    private View gfy;
    public LinearLayout goh;
    private RelativeLayout hns;
    public ThreadUserInfoLayout hnt;
    public ThreadCommentAndPraiseInfoLayout hnu;
    public View hnv;
    protected ThreadSourceShareAndPraiseLayout hog;
    public ThreadSkinView hor;
    private ThreadGodReplyLayout iwL;
    private HeadPendantClickableView iwM;
    private int iwP;
    private boolean iwQ;
    private TextView iwV;
    private Handler iwW;
    private VideoLoadingProgressView.a iwX;
    private f.a ixc;
    private Animation.AnimationListener ixd;
    private LinearLayout iyy;
    private TbImageView izc;
    public TextView jsR;
    public LinearLayout jsS;
    private i jsT;
    public boolean jsU;
    public int jsV;
    private View.OnClickListener jsW;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void csh() {
        if (this.abD != null && this.iwQ) {
            try {
                this.abD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.iwW.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.iwP = 0;
        this.fUd = 1;
        this.iwQ = false;
        this.iwW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.csm();
                        return;
                    case 203:
                        a.this.csn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.abD != null) {
                    a.this.abD.setVolume(0.0f, 0.0f);
                }
                a.this.csh();
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.abD.start();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cso();
                a.this.v(true, 4);
                a.this.iwQ = false;
                return true;
            }
        };
        this.iwX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.csh();
            }
        };
        this.fUe = new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && a.this.fTW != null) {
                    a.this.fTW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fUf = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fTU != null && a.this.fTU.getLayoutParams() != null && a.this.fTU.getVisibility() != 8) {
                    a.this.fTU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fTU.getLayoutParams();
                    if (a.this.fTU.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fTU.getWidth() * 0.5625d);
                        a.this.fTU.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.abD != null && !a.this.abD.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.fUh = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cso();
                a.this.v(true, 4);
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.jsW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ahi != null && !StringUtils.isNull(a.this.ahi.bnU())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eUY.getPageActivity()).createNormalCfg(a.this.ahi.bnU(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.fkz != null) {
                        a.this.fkz.onClick(view);
                    }
                }
            }
        };
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.csc() != null) {
                    a.this.csc().a(view, a.this.ahi);
                }
            }
        };
        this.fkz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ahi != null && a.this.csc() != null) {
                    a.this.csc().a(view, a.this.ahi);
                }
            }
        };
        this.ixc = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void rD() {
                a.this.csi();
            }
        };
        this.ixd = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fUd == 3 && a.this.fTW != null) {
                    a.this.fTW.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eUY = tbPageContext;
        View view = getView();
        this.gfy = view.findViewById(R.id.divider_line);
        this.hns = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.izc = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.jsS = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hns.setOnClickListener(this);
        this.iwM = (HeadPendantClickableView) this.hns.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.iwM.getHeadView() != null) {
            this.iwM.getHeadView().setIsRound(true);
            this.iwM.getHeadView().setDrawBorder(false);
            this.iwM.getHeadView().setDefaultResource(17170445);
            this.iwM.getHeadView().setRadius(l.getDimens(this.eUY.getPageActivity(), R.dimen.ds70));
        }
        this.iwM.setHasPendantStyle();
        if (this.iwM.getPendantView() != null) {
            this.iwM.getPendantView().setIsRound(true);
            this.iwM.getPendantView().setDrawBorder(false);
        }
        this.jsR = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.jsR.setVisibility(8);
        this.jsR.setOnClickListener(this.jsW);
        this.fUa = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fUa.setLoadingAnimationListener(this.iwX);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hnu = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.hnu.setForumAfterClickListener(this.fkz);
        this.hnt = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hnt.setFrom(3);
        this.hnv = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.hnu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnu.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnu.setLayoutParams(layoutParams);
        }
        this.hnu.setOnClickListener(this);
        this.hnu.setReplyTimeVisible(false);
        this.hnu.setShowPraiseNum(true);
        this.hnu.setNeedAddPraiseIcon(true);
        this.hnu.setNeedAddReplyIcon(true);
        this.hnu.setIsBarViewVisible(false);
        this.hnu.setShareVisible(true);
        this.hnu.setShareReportFrom(1);
        this.hnu.setStType("frs_page");
        this.hnu.setFrom(2);
        this.hnu.fkw = 3;
        this.hog = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hog.fls.setOnClickListener(this);
        this.hog.setFrom(2);
        this.hog.setShareReportFrom(1);
        this.hog.setSourceFromForPb(3);
        this.hog.setStType("frs_page");
        this.hog.setHideBarName(true);
        this.fTU = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fTU.setOnClickListener(this);
        this.fTU.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fTU != null) {
                    a.this.fTU.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fUf);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fTU != null) {
                    a.this.fTU.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fUf);
                }
            }
        });
        this.fTW = (TbImageView) view.findViewById(R.id.image_video);
        this.fTW.setPageId(getTag());
        this.fTW.setDrawCorner(true);
        this.fTW.setPlaceHolder(3);
        this.fTW.setEvent(this.fUe);
        this.fTW.setGifIconSupport(false);
        this.fTX = (ImageView) view.findViewById(R.id.image_video_play);
        this.abD = new TbCyberVideoView(getContext());
        this.abD.setStageType("2003");
        bHi();
        this.abD.setContinuePlayEnable(true);
        this.abD.setOnPreparedListener(this.eAA);
        this.abD.setOnCompletionListener(this.eAC);
        this.abD.setOnErrorListener(this.eAB);
        this.abD.setOnInfoListener(this.eAD);
        this.abD.setOnSurfaceDestroyedListener(this.fUi);
        this.gAm = new f();
        this.gAm.setPlayer(this.abD);
        this.gAm.a(this.ixc);
        this.fUb = view.findViewById(R.id.auto_video_black_mask);
        this.fTY = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fTZ = view.findViewById(R.id.auto_video_error_background);
        this.goh = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hor = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.chX = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.fade_out_video_cover);
        this.chX.setAnimationListener(this.ixd);
        this.fTV = (TextView) view.findViewById(R.id.text_video_duration);
        this.fUc = (TextView) view.findViewById(R.id.text_video_play_count);
        this.iyy = (LinearLayout) view.findViewById(R.id.duration_container);
        this.jsT = new i(tbPageContext, this.hns);
        this.jsT.setUniqueId(getTag());
        this.iwL = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.iwL.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.hnu != null) {
                    a.this.hnu.changeSelectStatus();
                }
            }
        });
        this.hnu.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void ke(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
                }
            }
        });
        this.iwV = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bHi() {
        if (this.abD != null && this.abD.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fTU.addView(this.abD.getView(), 0);
            this.abD.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.hns || view == this.hnu.getCommentNumView() || view == this.jsS) {
            cM(this.hns);
        } else if (view == this.fTU) {
            if (this.ahi != null && this.ahi.boh() != null) {
                z = this.ahi.boh().is_vertical.intValue() == 1;
            }
            if (z) {
                cK(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cW(this.fTU);
            } else {
                cM(this.fTU);
            }
        } else if (view == this.iwL) {
            cM(this.iwL);
        }
        if (this.ahi != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ahi));
        }
    }

    private void cK(View view) {
        if (csc() != null) {
            csc().a(view, this.ahi);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eUY.getPageActivity(), R.string.no_network_guide);
        } else {
            csj();
        }
    }

    private void csj() {
        if (this.ahi != null) {
            String str = "frs";
            if (this.jsV == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ahi);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.ahi.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.ahi.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cW(View view) {
        if (this.ahi != null) {
            ar arVar = new ar("c11100");
            arVar.dR("tid", this.ahi.getId());
            arVar.dR("fid", this.ahi.getFid() + "");
            TiebaStatic.log(arVar);
        }
        if (csc() != null) {
            csc().a(view, this.ahi);
        }
        if (view == this.fTU) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eUY.getPageActivity(), R.string.no_network_guide);
            } else {
                csk();
            }
        }
    }

    private void csk() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ahi);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.goh.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.goh.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.jsV == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eUY.getPageActivity(), str, this.ahi.getTid(), com.baidu.tieba.card.m.bnC(), "", videoSerializeVideoThreadInfo);
        if (this.ahi.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.ahi.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void cM(View view) {
        String str;
        String str2;
        if (this.ahi != null) {
            if (this.ahi.bpa()) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dR("fid", String.valueOf(this.ahi.getFid())).ap("obj_type", 2));
            } else {
                ar arVar = new ar("c11100");
                arVar.dR("tid", this.ahi.getId());
                arVar.dR("fid", this.ahi.getFid() + "");
                TiebaStatic.log(arVar);
            }
            if (this.ahi.bnQ() != null && this.ahi.bnQ().getGodUserData() != null && this.ahi.bnQ().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ar("c10806").ap("obj_locate", 3).dR("tid", this.ahi.getId()));
            }
        }
        if (csc() != null) {
            csc().a(view, this.ahi);
        }
        if (this.ahi != null) {
            com.baidu.tieba.card.m.IN(this.ahi.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            ab.DO(this.ahi.getId());
            String valueOf = String.valueOf(this.ahi.getFid());
            if (this.ahi.eTn == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.ahi.eTn.id;
                str2 = valueOf;
            }
            if (this.ahi.bom() > 0 && com.baidu.tieba.tbadkCore.util.e.dOV()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eUY.getPageActivity()).createHistoryCfg(this.ahi.getTid(), String.valueOf(this.ahi.bom()), false, true, "frs_page");
                String str3 = "frs";
                if (this.jsV == 501) {
                    str3 = "frs_tab";
                } else if (this.ahi.bpa()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.ahi.bph());
                createHistoryCfg.setSmartFrsPosition(this.ahi.bpn());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.iwL) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eUY.getPageActivity()).createFromThreadCfg(this.ahi, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.jsV == 501) {
                str4 = "frs_tab";
            } else if (this.ahi.bpa()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.ahi.bph());
            createFromThreadCfg.setSmartFrsPosition(this.ahi.bpn());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.iwL) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        this.ahi = cbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csm() {
        this.iwW.removeMessages(202);
        if (this.abD.getCurrentPosition() > 0) {
            v(false, 3);
            this.iwW.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.iwW.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.iwW.removeMessages(203);
        int currentPosition = this.abD.getCurrentPosition();
        if (currentPosition != this.iwP) {
            this.iwP = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.iwW.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fTX != null && this.fTW != null && this.fUb != null && this.fUa != null && this.fTZ != null && this.fTY != null) {
            if (z || this.fUd != i) {
                this.fUd = i;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUh);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUg);
                if (i == 2) {
                    this.fTX.setVisibility(8);
                    this.chX.cancel();
                    this.fTW.clearAnimation();
                    this.fTW.setVisibility(0);
                    this.fUb.setVisibility(0);
                    this.iyy.setVisibility(0);
                    this.fUa.startLoading();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fUh, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fTX.setVisibility(8);
                    this.fTW.startAnimation(this.chX);
                    this.fUb.setVisibility(8);
                    this.iyy.setVisibility(8);
                    this.fUa.dAi();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                    if (this.ahi != null && this.ahi.boh() != null) {
                        this.ahi.boh().video_length.intValue();
                        this.ahi.boh().video_duration.intValue();
                        this.ahi.getTid();
                    }
                } else if (i == 4) {
                    this.fTX.setVisibility(8);
                    this.fTW.startAnimation(this.chX);
                    this.fUb.setVisibility(8);
                    this.fUa.dAj();
                    this.fTZ.setVisibility(0);
                    this.fTY.setVisibility(0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fUg, 2000L);
                } else {
                    this.fTX.setVisibility(0);
                    this.iyy.setVisibility(0);
                    this.chX.cancel();
                    this.fTW.clearAnimation();
                    this.fTW.setVisibility(0);
                    this.fUb.setVisibility(0);
                    this.fUa.dAj();
                    this.fTZ.setVisibility(8);
                    this.fTY.setVisibility(8);
                }
            }
        }
    }

    private void ab(final cb cbVar) {
        if (this.izc != null) {
            if (cbVar == null) {
                this.izc.setVisibility(8);
            } else if (!StringUtils.isNull(cbVar.eTd)) {
                if (this.jsT != null && this.jsT.cLC() && (this.izc.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.izc.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eUY.getContext(), R.dimen.tbds106);
                    this.izc.setLayoutParams(layoutParams);
                }
                this.izc.setVisibility(0);
                this.izc.setImageDrawable(null);
                this.izc.startLoad(cbVar.eTd, 10, false);
                this.izc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eUY != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", cbVar.eTe, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.izc.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ahi == null || this.ahi.bnQ() == null) {
            this.hns.setVisibility(8);
            return;
        }
        this.hns.setVisibility(0);
        this.hns.setOnClickListener(this);
        csp();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eSv)) {
            this.ahi.dD(this.mUrl, this.eSv);
        }
        this.ahi.y(false, true);
        SpannableStringBuilder boz = this.ahi.boz();
        if (this.ahi.boF() && !StringUtils.isNull(this.ahi.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ahi.getTid();
            boz.append((CharSequence) this.ahi.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(boz));
        this.mTextTitle.setText(boz);
        this.jsT.aB(this.ahi);
        ab(this.ahi);
        this.hnt.setData(this.ahi);
        if (this.hnt.getHeaderImg() != null) {
            if (this.hnt.getIsSimpleThread()) {
                this.hnt.getHeaderImg().setVisibility(8);
                this.iwM.setVisibility(8);
            } else if (this.ahi.bnQ() == null || this.ahi.bnQ().getPendantData() == null || StringUtils.isNull(this.ahi.bnQ().getPendantData().getImgUrl())) {
                this.iwM.setVisibility(8);
                this.hnt.getHeaderImg().setVisibility(0);
                this.hnt.getHeaderImg().setData(this.ahi);
            } else {
                this.hnt.getHeaderImg().setVisibility(4);
                this.iwM.setVisibility(0);
                this.iwM.setData(this.ahi);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnu.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.hnu.setLayoutParams(layoutParams);
        this.hnt.setUserAfterClickListener(this.aki);
        uZ(sW(1));
        this.fTV.setText(au.stringForVideoTime(this.ahi.boh().video_duration.intValue() * 1000));
        this.fUc.setText(String.format(this.eUY.getResources().getString(R.string.play_count), au.numFormatOverWan(this.ahi.boh().play_count.intValue())));
        this.iwL.setData(this.ahi.bpv());
        this.iwL.onChangeSkinType();
        if (com.baidu.tieba.card.m.IO(this.ahi.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            com.baidu.tieba.card.m.a(this.iwL.getGodReplyContent(), this.ahi.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.ahi == null || this.ahi.boh() == null) {
            z = false;
        } else {
            z = this.ahi.boh().is_vertical.intValue() == 1;
        }
        if (z) {
            this.iwV.setVisibility(0);
        } else {
            this.iwV.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs()) && this.hnu.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.ahi.bpD() || this.ahi.bpE() || this.ahi.bpF()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        this.iwW.removeMessages(202);
        this.iwW.removeMessages(203);
    }

    private void bHj() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUg);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUh);
    }

    private void csp() {
        bHj();
        cso();
        if (this.fTW != null && this.fTU != null && this.abD != null) {
            if (k.bkT().isShowImages() && this.ahi != null && this.ahi.boh() != null) {
                this.fTU.setVisibility(0);
                this.fTW.setPlaceHolder(3);
                this.fTW.startLoad(this.ahi.boh().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.ahi.boh().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new ar("c12026").dR("tid", this.ahi.getId()));
                }
                this.abD.setThreadDataForStatistic(this.ahi);
                return;
            }
            this.fTU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hns, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fTX, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fTY, R.color.CAM_X0101);
            ap.setViewTextColor(this.fTV, R.color.CAM_X0101);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fTZ, R.color.common_color_10014);
            ap.setBackgroundColor(this.gfy, R.color.CAM_X0204);
            if (this.fTY != null) {
                this.fTY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.hog != null && this.hog.getVisibility() == 0) {
                this.hog.onChangeSkinType();
            }
            this.hnu.onChangeSkinType();
            this.mSkinType = i;
            this.hnt.onChangeSkinType();
            if (this.iwM != null && this.iwM.getHeadView() != null && (this.iwM.getHeadView() instanceof TbImageView)) {
                this.iwM.getHeadView().setPlaceHolder(1);
            }
            this.fTW.setPlaceHolder(3);
            this.jsT.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.currentPageType = i;
        if (this.hnu != null) {
            this.hnu.fkw = i;
            this.hnu.setFrom(2);
        }
        if (this.hnt != null) {
            this.hnt.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.iwQ;
    }

    public boolean isPlaying() {
        if (this.abD == null) {
            return false;
        }
        return this.abD.isPlaying();
    }

    public void startPlay() {
        if (!this.iwQ && this.ahi != null && this.ahi.boh() != null && this.abD != null) {
            this.abD.stopPlayback();
            if (ak.bFR()) {
                if (this.jsU || com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new ar("c12619").dR("obj_locate", "frs").dR("tid", this.ahi.getId()));
                        this.mVideoUrl = this.ahi.boh().video_url;
                    }
                    this.iwQ = true;
                    this.abD.setVideoPath(this.mVideoUrl, this.ahi.getId());
                    if (this.gAm != null) {
                        this.gAm.start();
                    }
                    csi();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csi() {
        if (this.ahi != null && this.ahi.boh() != null) {
            String str = this.ahi.bpa() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.jsV == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.amC = this.ahi.getTid();
            oVar.fNd = this.ahi.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.ahi.mRecomSource;
            oVar.mIz = this.ahi.mRecomAbTag;
            oVar.mIv = this.ahi.mRecomAbTag;
            oVar.mIw = this.ahi.mRecomWeight;
            oVar.mIx = "";
            oVar.mIA = this.ahi.boh().video_md5;
            h.a(this.ahi.boh().video_md5, "", "1", oVar, this.abD.getPcdnState());
        }
    }

    public void stopPlay() {
        bHj();
        cso();
        v(true, 1);
        if (this.abD != null) {
            this.abD.stopPlayback();
            if (this.gAm != null) {
                this.gAm.stop();
            }
        }
        this.iwQ = false;
    }

    public View getVideoContainer() {
        return this.fTU;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abD == null) {
            return 0;
        }
        return this.abD.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.abD != null) {
            this.abD.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnu != null && this.hnt != null) {
            this.hnt.setPageUniqueId(bdUniqueId);
        }
    }

    public void uZ(int i) {
        if (this.ahi != null) {
            if (i == 1) {
                this.hnu.setVisibility(8);
                this.hog.setData(this.ahi);
                this.hnv.setVisibility(8);
                return;
            }
            this.hnu.setData(this.ahi);
            this.hnv.setVisibility(8);
            this.hog.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKU().aB(this.aif, i);
    }
}
