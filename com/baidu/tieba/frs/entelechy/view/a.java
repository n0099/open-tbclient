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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ai;
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
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, z {
    private TbCyberVideoView ZY;
    private bw agx;
    private String ahu;
    private final View.OnClickListener ajG;
    private Animation bYm;
    private String eFG;
    private TbPageContext<?> eIc;
    private final View.OnClickListener eWC;
    private CyberPlayerManager.OnPreparedListener eog;
    private CyberPlayerManager.OnErrorListener eoh;
    private CyberPlayerManager.OnCompletionListener eoi;
    private CyberPlayerManager.OnInfoListener eoj;
    private m fFA;
    private View fFB;
    private TextView fFC;
    private int fFD;
    private TbImageView.a fFE;
    private ViewTreeObserver.OnGlobalLayoutListener fFF;
    private Runnable fFG;
    private Runnable fFH;
    private TbCyberVideoView.a fFI;
    public FrameLayout fFu;
    private TextView fFv;
    private TbImageView fFw;
    private ImageView fFx;
    private TextView fFy;
    private View fFz;
    private View fQl;
    public LinearLayout fXV;
    private RelativeLayout gSP;
    public ThreadUserInfoLayout gSQ;
    public ThreadCommentAndPraiseInfoLayout gSR;
    public View gSS;
    protected ThreadSourceShareAndPraiseLayout gTD;
    public ThreadSkinView gTO;
    private f gje;
    private ThreadGodReplyLayout hXG;
    private HeadPendantClickableView hXH;
    private int hXK;
    private boolean hXL;
    private TextView hXQ;
    private Handler hXR;
    private VideoLoadingProgressView.a hXS;
    private f.a hXX;
    private Animation.AnimationListener hXY;
    private TbImageView hZR;
    private LinearLayout hZq;
    public TextView iTu;
    public LinearLayout iTv;
    private i iTw;
    public boolean iTx;
    public int iTy;
    private View.OnClickListener iTz;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnY() {
        if (this.ZY != null && this.hXL) {
            try {
                this.ZY.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hXR.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hXK = 0;
        this.fFD = 1;
        this.hXL = false;
        this.hXR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.cod();
                        return;
                    case 203:
                        a.this.coe();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.ZY != null) {
                    a.this.ZY.setVolume(0.0f, 0.0f);
                }
                a.this.cnY();
            }
        };
        this.eoj = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.w(false, 3);
                }
                return false;
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.ZY.start();
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cof();
                a.this.w(true, 4);
                a.this.hXL = false;
                return true;
            }
        };
        this.hXS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.cnY();
            }
        };
        this.fFE = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.fFw != null) {
                    a.this.fFw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fFF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fFu != null && a.this.fFu.getLayoutParams() != null && a.this.fFu.getVisibility() != 8) {
                    a.this.fFu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fFu.getLayoutParams();
                    if (a.this.fFu.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fFu.getWidth() * 0.5625d);
                        a.this.fFu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fFG = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ZY != null && !a.this.ZY.isPlaying()) {
                    a.this.w(true, 1);
                }
            }
        };
        this.fFH = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cof();
                a.this.w(true, 4);
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.iTz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agx != null && !StringUtils.isNull(a.this.agx.bmE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eIc.getPageActivity()).createNormalCfg(a.this.agx.bmE(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.eWC != null) {
                        a.this.eWC.onClick(view);
                    }
                }
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cnT() != null) {
                    a.this.cnT().a(view, a.this.agx);
                }
            }
        };
        this.eWC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agx != null && a.this.cnT() != null) {
                    a.this.cnT().a(view, a.this.agx);
                }
            }
        };
        this.hXX = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                a.this.cnZ();
            }
        };
        this.hXY = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fFD == 3 && a.this.fFw != null) {
                    a.this.fFw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eIc = tbPageContext;
        View view = getView();
        this.fQl = view.findViewById(R.id.divider_line);
        this.gSP = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hZR = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.iTv = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gSP.setOnClickListener(this);
        this.hXH = (HeadPendantClickableView) this.gSP.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hXH.getHeadView() != null) {
            this.hXH.getHeadView().setIsRound(true);
            this.hXH.getHeadView().setDrawBorder(false);
            this.hXH.getHeadView().setDefaultResource(17170445);
            this.hXH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hXH.getHeadView().setRadius(l.getDimens(this.eIc.getPageActivity(), R.dimen.ds70));
        }
        this.hXH.setHasPendantStyle();
        if (this.hXH.getPendantView() != null) {
            this.hXH.getPendantView().setIsRound(true);
            this.hXH.getPendantView().setDrawBorder(false);
        }
        this.iTu = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.iTu.setVisibility(8);
        this.iTu.setOnClickListener(this.iTz);
        this.fFA = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fFA.setLoadingAnimationListener(this.hXS);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gSR.setForumAfterClickListener(this.eWC);
        this.gSQ = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gSQ.setFrom(3);
        this.gSS = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.gSR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSR.setLayoutParams(layoutParams);
        }
        this.gSR.setOnClickListener(this);
        this.gSR.setReplyTimeVisible(false);
        this.gSR.setShowPraiseNum(true);
        this.gSR.setNeedAddPraiseIcon(true);
        this.gSR.setNeedAddReplyIcon(true);
        this.gSR.setIsBarViewVisible(false);
        this.gSR.setShareVisible(true);
        this.gSR.setShareReportFrom(1);
        this.gSR.setStType("frs_page");
        this.gSR.setFrom(2);
        this.gSR.eWz = 3;
        this.gTD = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gTD.eXx.setOnClickListener(this);
        this.gTD.setFrom(2);
        this.gTD.setShareReportFrom(1);
        this.gTD.setSourceFromForPb(3);
        this.gTD.setStType("frs_page");
        this.gTD.setHideBarName(true);
        this.fFu = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fFu.setOnClickListener(this);
        this.fFu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fFu != null) {
                    a.this.fFu.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fFF);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fFu != null) {
                    a.this.fFu.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fFF);
                }
            }
        });
        this.fFw = (TbImageView) view.findViewById(R.id.image_video);
        this.fFw.setPageId(getTag());
        this.fFw.setDefaultErrorResource(0);
        this.fFw.setDrawCorner(true);
        this.fFw.setPlaceHolder(3);
        this.fFw.setEvent(this.fFE);
        this.fFw.setGifIconSupport(false);
        this.fFx = (ImageView) view.findViewById(R.id.image_video_play);
        this.ZY = new TbCyberVideoView(getContext());
        this.ZY.setStageType("2003");
        bFr();
        this.ZY.setContinuePlayEnable(true);
        this.ZY.setOnPreparedListener(this.eog);
        this.ZY.setOnCompletionListener(this.eoi);
        this.ZY.setOnErrorListener(this.eoh);
        this.ZY.setOnInfoListener(this.eoj);
        this.ZY.setOnSurfaceDestroyedListener(this.fFI);
        this.gje = new f();
        this.gje.setPlayer(this.ZY);
        this.gje.a(this.hXX);
        this.fFB = view.findViewById(R.id.auto_video_black_mask);
        this.fFy = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fFz = view.findViewById(R.id.auto_video_error_background);
        this.fXV = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gTO = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bYm = AnimationUtils.loadAnimation(this.eIc.getPageActivity(), R.anim.fade_out_video_cover);
        this.bYm.setAnimationListener(this.hXY);
        this.fFv = (TextView) view.findViewById(R.id.text_video_duration);
        this.fFC = (TextView) view.findViewById(R.id.text_video_play_count);
        this.hZq = (LinearLayout) view.findViewById(R.id.duration_container);
        this.iTw = new i(tbPageContext, this.gSP);
        this.iTw.setUniqueId(getTag());
        this.hXG = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hXG.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gSR != null) {
                    a.this.gSR.changeSelectStatus();
                }
            }
        });
        this.gSR.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void js(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.hXQ = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bFr() {
        if (this.ZY != null && this.ZY.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fFu.addView(this.ZY.getView(), 0);
            this.ZY.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gSP || view == this.gSR.getCommentNumView() || view == this.iTv) {
            ct(this.gSP);
        } else if (view == this.fFu) {
            if (this.agx != null && this.agx.bmS() != null) {
                z = this.agx.bmS().is_vertical.intValue() == 1;
            }
            if (z) {
                cr(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cD(this.fFu);
            } else {
                ct(this.fFu);
            }
        } else if (view == this.hXG) {
            ct(this.hXG);
        }
        if (this.agx != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.agx));
        }
    }

    private void cr(View view) {
        if (cnT() != null) {
            cnT().a(view, this.agx);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eIc.getPageActivity(), R.string.no_network_guide);
        } else {
            coa();
        }
    }

    private void coa() {
        if (this.agx != null) {
            String str = "frs";
            if (this.iTy == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.agx);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.agx.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.agx.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cD(View view) {
        if (this.agx != null) {
            aq aqVar = new aq("c11100");
            aqVar.dR("tid", this.agx.getId());
            aqVar.dR("fid", this.agx.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (cnT() != null) {
            cnT().a(view, this.agx);
        }
        if (view == this.fFu) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eIc.getPageActivity(), R.string.no_network_guide);
            } else {
                cob();
            }
        }
    }

    private void cob() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.agx);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fXV.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fXV.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.iTy == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eIc.getPageActivity(), str, this.agx.getTid(), n.bmm(), "", videoSerializeVideoThreadInfo);
        if (this.agx.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.agx.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void ct(View view) {
        String str;
        String str2;
        if (this.agx != null) {
            if (this.agx.bnJ()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dR("fid", String.valueOf(this.agx.getFid())).al("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dR("tid", this.agx.getId());
                aqVar.dR("fid", this.agx.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.agx.bmA() != null && this.agx.bmA().getGodUserData() != null && this.agx.bmA().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").al("obj_locate", 3).dR("tid", this.agx.getId()));
            }
        }
        if (cnT() != null) {
            cnT().a(view, this.agx);
        }
        if (this.agx != null) {
            n.IZ(this.agx.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ac.EA(this.agx.getId());
            String valueOf = String.valueOf(this.agx.getFid());
            if (this.agx.eGy == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.agx.eGy.id;
                str2 = valueOf;
            }
            if (this.agx.bmX() > 0 && com.baidu.tieba.tbadkCore.util.e.dLf()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eIc.getPageActivity()).createHistoryCfg(this.agx.getTid(), String.valueOf(this.agx.bmX()), false, true, "frs_page");
                String str3 = "frs";
                if (this.iTy == 501) {
                    str3 = "frs_tab";
                } else if (this.agx.bnJ()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.agx.bnP());
                createHistoryCfg.setSmartFrsPosition(this.agx.bnV());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.hXG) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eIc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eIc.getPageActivity()).createFromThreadCfg(this.agx, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.iTy == 501) {
                str4 = "frs_tab";
            } else if (this.agx.bnJ()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.agx.bnP());
            createFromThreadCfg.setSmartFrsPosition(this.agx.bnV());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.hXG) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eIc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.agx = bwVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        this.hXR.removeMessages(202);
        if (this.ZY.getCurrentPosition() > 0) {
            w(false, 3);
            this.hXR.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hXR.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coe() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hXR.removeMessages(203);
        int currentPosition = this.ZY.getCurrentPosition();
        if (currentPosition != this.hXK) {
            this.hXK = currentPosition;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hXR.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fFx != null && this.fFw != null && this.fFB != null && this.fFA != null && this.fFz != null && this.fFy != null) {
            if (z || this.fFD != i) {
                this.fFD = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFH);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFG);
                if (i == 2) {
                    this.fFx.setVisibility(8);
                    this.bYm.cancel();
                    this.fFw.clearAnimation();
                    this.fFw.setVisibility(0);
                    this.fFB.setVisibility(0);
                    this.hZq.setVisibility(0);
                    this.fFA.startLoading();
                    this.fFz.setVisibility(8);
                    this.fFy.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFH, 60000L);
                } else if (i == 3) {
                    this.fFx.setVisibility(8);
                    this.fFw.startAnimation(this.bYm);
                    this.fFB.setVisibility(8);
                    this.hZq.setVisibility(8);
                    this.fFA.dxc();
                    this.fFz.setVisibility(8);
                    this.fFy.setVisibility(8);
                    if (this.agx != null && this.agx.bmS() != null) {
                        this.agx.bmS().video_length.intValue();
                        this.agx.bmS().video_duration.intValue();
                        this.agx.getTid();
                    }
                } else if (i == 4) {
                    this.fFx.setVisibility(8);
                    this.fFw.startAnimation(this.bYm);
                    this.fFB.setVisibility(8);
                    this.fFA.dxd();
                    this.fFz.setVisibility(0);
                    this.fFy.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fFG, 2000L);
                } else {
                    this.fFx.setVisibility(0);
                    this.hZq.setVisibility(0);
                    this.bYm.cancel();
                    this.fFw.clearAnimation();
                    this.fFw.setVisibility(0);
                    this.fFB.setVisibility(0);
                    this.fFA.dxd();
                    this.fFz.setVisibility(8);
                    this.fFy.setVisibility(8);
                }
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hZR != null) {
            if (bwVar == null) {
                this.hZR.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.eGo)) {
                if (this.iTw != null && this.iTw.cGc() && (this.hZR.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZR.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eIc.getContext(), R.dimen.tbds106);
                    this.hZR.setLayoutParams(layoutParams);
                }
                this.hZR.setVisibility(0);
                this.hZR.setImageDrawable(null);
                this.hZR.startLoad(bwVar.eGo, 10, false);
                this.hZR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eIc != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bwVar.eGp, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hZR.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.agx == null || this.agx.bmA() == null) {
            this.gSP.setVisibility(8);
            return;
        }
        this.gSP.setVisibility(0);
        this.gSP.setOnClickListener(this);
        cog();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eFG)) {
            this.agx.dG(this.mUrl, this.eFG);
        }
        this.agx.z(false, true);
        SpannableStringBuilder bnk = this.agx.bnk();
        if (this.agx.bnq() && !StringUtils.isNull(this.agx.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bqh().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.agx.getTid();
            bnk.append((CharSequence) this.agx.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dR("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(bnk));
        this.mTextTitle.setText(bnk);
        this.iTw.ay(this.agx);
        Y(this.agx);
        this.gSQ.setData(this.agx);
        if (this.gSQ.getHeaderImg() != null) {
            if (this.gSQ.getIsSimpleThread()) {
                this.gSQ.getHeaderImg().setVisibility(8);
                this.hXH.setVisibility(8);
            } else if (this.agx.bmA() == null || this.agx.bmA().getPendantData() == null || StringUtils.isNull(this.agx.bmA().getPendantData().bkw())) {
                this.hXH.setVisibility(8);
                this.gSQ.getHeaderImg().setVisibility(0);
                this.gSQ.getHeaderImg().setData(this.agx);
            } else {
                this.gSQ.getHeaderImg().setVisibility(4);
                this.hXH.setVisibility(0);
                this.hXH.setData(this.agx);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSR.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.gSR.setLayoutParams(layoutParams);
        this.gSQ.setUserAfterClickListener(this.ajG);
        vf(tj(1));
        this.fFv.setText(at.stringForVideoTime(this.agx.bmS().video_duration.intValue() * 1000));
        this.fFC.setText(String.format(this.eIc.getResources().getString(R.string.play_count), at.numFormatOverWan(this.agx.bmS().play_count.intValue())));
        this.hXG.setData(this.agx.bod());
        this.hXG.onChangeSkinType();
        if (n.Ja(this.agx.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            n.a(this.hXG.getGodReplyContent(), this.agx.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.agx == null || this.agx.bmS() == null) {
            z = false;
        } else {
            z = this.agx.bmS().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hXQ.setVisibility(0);
        } else {
            this.hXQ.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) && this.gSR.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agx.bol() || this.agx.bom() || this.agx.bon()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cof() {
        this.hXR.removeMessages(202);
        this.hXR.removeMessages(203);
    }

    private void bFs() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFG);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFH);
    }

    private void cog() {
        bFs();
        cof();
        if (this.fFw != null && this.fFu != null && this.ZY != null) {
            if (k.bjH().isShowImages() && this.agx != null && this.agx.bmS() != null) {
                this.fFu.setVisibility(0);
                this.fFw.setPlaceHolder(3);
                this.fFw.startLoad(this.agx.bmS().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.agx.bmS().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                    TiebaStatic.log(new aq("c12026").dR("tid", this.agx.getId()));
                }
                this.ZY.setThreadDataForStatistic(this.agx);
                return;
            }
            this.fFu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gSP, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fFx, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fFy, R.color.cp_cont_a);
            ap.setViewTextColor(this.fFv, R.color.cp_cont_a);
            ap.setViewTextColor(this.fFC, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fFz, R.color.common_color_10014);
            ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c);
            if (this.fFy != null) {
                this.fFy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.gTD != null && this.gTD.getVisibility() == 0) {
                this.gTD.onChangeSkinType();
            }
            this.gSR.onChangeSkinType();
            this.mSkinType = i;
            this.gSQ.onChangeSkinType();
            if (this.hXH != null && this.hXH.getHeadView() != null && (this.hXH.getHeadView() instanceof TbImageView)) {
                this.hXH.getHeadView().setPlaceHolder(1);
            }
            this.fFw.setPlaceHolder(3);
            this.iTw.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
        this.currentPageType = i;
        if (this.gSR != null) {
            this.gSR.eWz = i;
            this.gSR.setFrom(2);
        }
        if (this.gSQ != null) {
            this.gSQ.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.hXL;
    }

    public boolean isPlaying() {
        if (this.ZY == null) {
            return false;
        }
        return this.ZY.isPlaying();
    }

    public void startPlay() {
        if (!this.hXL && this.agx != null && this.agx.bmS() != null && this.ZY != null) {
            this.ZY.stopPlayback();
            if (ai.bEb()) {
                if (this.iTx || com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    w(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dR("obj_locate", "frs").dR("tid", this.agx.getId()));
                        this.mVideoUrl = this.agx.bmS().video_url;
                    }
                    this.hXL = true;
                    this.ZY.setVideoPath(this.mVideoUrl, this.agx.getId());
                    if (this.gje != null) {
                        this.gje.start();
                    }
                    cnZ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnZ() {
        if (this.agx != null && this.agx.bmS() != null) {
            String str = this.agx.bnJ() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.iTy == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.alT = this.agx.getTid();
            oVar.fyR = this.agx.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.agx.mRecomSource;
            oVar.mjV = this.agx.mRecomAbTag;
            oVar.mjR = this.agx.mRecomAbTag;
            oVar.mjS = this.agx.mRecomWeight;
            oVar.mjT = "";
            oVar.mjW = this.agx.bmS().video_md5;
            h.a(this.agx.bmS().video_md5, "", "1", oVar, this.ZY.getPcdnState());
        }
    }

    public void stopPlay() {
        bFs();
        cof();
        w(true, 1);
        if (this.ZY != null) {
            this.ZY.stopPlayback();
            if (this.gje != null) {
                this.gje.stop();
            }
        }
        this.hXL = false;
    }

    public View getVideoContainer() {
        return this.fFu;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZY == null) {
            return 0;
        }
        return this.ZY.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.ZY != null) {
            this.ZY.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSR != null && this.gSQ != null) {
            this.gSQ.setPageUniqueId(bdUniqueId);
        }
    }

    public void vf(int i) {
        if (this.agx != null) {
            if (i == 1) {
                this.gSR.setVisibility(8);
                this.gTD.setData(this.agx);
                this.gSS.setVisibility(8);
                return;
            }
            this.gSR.setData(this.agx);
            this.gSS.setVisibility(8);
            this.gTD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int tj(int i) {
        return com.baidu.tieba.a.d.bIR().ax(this.ahu, i);
    }
}
