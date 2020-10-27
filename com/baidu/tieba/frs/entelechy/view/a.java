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
    private Animation bSC;
    private TbPageContext<?> eCn;
    private final View.OnClickListener eQN;
    private CyberPlayerManager.OnPreparedListener eim;
    private CyberPlayerManager.OnErrorListener ein;
    private CyberPlayerManager.OnCompletionListener eio;
    private CyberPlayerManager.OnInfoListener eip;
    private String ezR;
    private View fKv;
    public LinearLayout fSf;
    public FrameLayout fzE;
    private TextView fzF;
    private TbImageView fzG;
    private ImageView fzH;
    private TextView fzI;
    private View fzJ;
    private m fzK;
    private View fzL;
    private TextView fzM;
    private int fzN;
    private TbImageView.a fzO;
    private ViewTreeObserver.OnGlobalLayoutListener fzP;
    private Runnable fzQ;
    private Runnable fzR;
    private TbCyberVideoView.a fzS;
    private RelativeLayout gMq;
    public ThreadUserInfoLayout gMr;
    public ThreadCommentAndPraiseInfoLayout gMs;
    public View gMt;
    protected ThreadSourceShareAndPraiseLayout gNe;
    public ThreadSkinView gNp;
    private f gdo;
    private ThreadGodReplyLayout hRJ;
    private HeadPendantClickableView hRK;
    private int hRN;
    private boolean hRO;
    private TextView hRT;
    private Handler hRU;
    private VideoLoadingProgressView.a hRV;
    private f.a hSa;
    private Animation.AnimationListener hSb;
    private TbImageView hTU;
    private LinearLayout hTt;
    public boolean iNA;
    public int iNB;
    private View.OnClickListener iNC;
    public TextView iNx;
    public LinearLayout iNy;
    private i iNz;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        if (this.ZY != null && this.hRO) {
            try {
                this.ZY.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hRU.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hRN = 0;
        this.fzN = 1;
        this.hRO = false;
        this.hRU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.clC();
                        return;
                    case 203:
                        a.this.clD();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.ZY != null) {
                    a.this.ZY.setVolume(0.0f, 0.0f);
                }
                a.this.clx();
            }
        };
        this.eip = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.w(false, 3);
                }
                return false;
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.ZY.start();
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.clE();
                a.this.w(true, 4);
                a.this.hRO = false;
                return true;
            }
        };
        this.hRV = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.clx();
            }
        };
        this.fzO = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.fzG != null) {
                    a.this.fzG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.fzP = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fzE != null && a.this.fzE.getLayoutParams() != null && a.this.fzE.getVisibility() != 8) {
                    a.this.fzE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fzE.getLayoutParams();
                    if (a.this.fzE.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fzE.getWidth() * 0.5625d);
                        a.this.fzE.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fzQ = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ZY != null && !a.this.ZY.isPlaying()) {
                    a.this.w(true, 1);
                }
            }
        };
        this.fzR = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.clE();
                a.this.w(true, 4);
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.iNC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agx != null && !StringUtils.isNull(a.this.agx.bke())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eCn.getPageActivity()).createNormalCfg(a.this.agx.bke(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.eQN != null) {
                        a.this.eQN.onClick(view);
                    }
                }
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cls() != null) {
                    a.this.cls().a(view, a.this.agx);
                }
            }
        };
        this.eQN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agx != null && a.this.cls() != null) {
                    a.this.cls().a(view, a.this.agx);
                }
            }
        };
        this.hSa = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                a.this.cly();
            }
        };
        this.hSb = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fzN == 3 && a.this.fzG != null) {
                    a.this.fzG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eCn = tbPageContext;
        View view = getView();
        this.fKv = view.findViewById(R.id.divider_line);
        this.gMq = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hTU = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.iNy = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gMq.setOnClickListener(this);
        this.hRK = (HeadPendantClickableView) this.gMq.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hRK.getHeadView() != null) {
            this.hRK.getHeadView().setIsRound(true);
            this.hRK.getHeadView().setDrawBorder(false);
            this.hRK.getHeadView().setDefaultResource(17170445);
            this.hRK.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hRK.getHeadView().setRadius(l.getDimens(this.eCn.getPageActivity(), R.dimen.ds70));
        }
        this.hRK.setHasPendantStyle();
        if (this.hRK.getPendantView() != null) {
            this.hRK.getPendantView().setIsRound(true);
            this.hRK.getPendantView().setDrawBorder(false);
        }
        this.iNx = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.iNx.setVisibility(8);
        this.iNx.setOnClickListener(this.iNC);
        this.fzK = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fzK.setLoadingAnimationListener(this.hRV);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gMs.setForumAfterClickListener(this.eQN);
        this.gMr = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gMr.setFrom(3);
        this.gMt = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.gMs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMs.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gMs.setLayoutParams(layoutParams);
        }
        this.gMs.setOnClickListener(this);
        this.gMs.setReplyTimeVisible(false);
        this.gMs.setShowPraiseNum(true);
        this.gMs.setNeedAddPraiseIcon(true);
        this.gMs.setNeedAddReplyIcon(true);
        this.gMs.setIsBarViewVisible(false);
        this.gMs.setShareVisible(true);
        this.gMs.setShareReportFrom(1);
        this.gMs.setStType("frs_page");
        this.gMs.setFrom(2);
        this.gMs.eQK = 3;
        this.gNe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gNe.eRI.setOnClickListener(this);
        this.gNe.setFrom(2);
        this.gNe.setShareReportFrom(1);
        this.gNe.setSourceFromForPb(3);
        this.gNe.setStType("frs_page");
        this.gNe.setHideBarName(true);
        this.fzE = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fzE.setOnClickListener(this);
        this.fzE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fzE != null) {
                    a.this.fzE.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fzP);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fzE != null) {
                    a.this.fzE.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fzP);
                }
            }
        });
        this.fzG = (TbImageView) view.findViewById(R.id.image_video);
        this.fzG.setPageId(getTag());
        this.fzG.setDefaultErrorResource(0);
        this.fzG.setDrawCorner(true);
        this.fzG.setPlaceHolder(3);
        this.fzG.setEvent(this.fzO);
        this.fzG.setGifIconSupport(false);
        this.fzH = (ImageView) view.findViewById(R.id.image_video_play);
        this.ZY = new TbCyberVideoView(getContext());
        this.ZY.setStageType("2003");
        bCS();
        this.ZY.setContinuePlayEnable(true);
        this.ZY.setOnPreparedListener(this.eim);
        this.ZY.setOnCompletionListener(this.eio);
        this.ZY.setOnErrorListener(this.ein);
        this.ZY.setOnInfoListener(this.eip);
        this.ZY.setOnSurfaceDestroyedListener(this.fzS);
        this.gdo = new f();
        this.gdo.setPlayer(this.ZY);
        this.gdo.a(this.hSa);
        this.fzL = view.findViewById(R.id.auto_video_black_mask);
        this.fzI = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fzJ = view.findViewById(R.id.auto_video_error_background);
        this.fSf = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gNp = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bSC = AnimationUtils.loadAnimation(this.eCn.getPageActivity(), R.anim.fade_out_video_cover);
        this.bSC.setAnimationListener(this.hSb);
        this.fzF = (TextView) view.findViewById(R.id.text_video_duration);
        this.fzM = (TextView) view.findViewById(R.id.text_video_play_count);
        this.hTt = (LinearLayout) view.findViewById(R.id.duration_container);
        this.iNz = new i(tbPageContext, this.gMq);
        this.iNz.setUniqueId(getTag());
        this.hRJ = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hRJ.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gMs != null) {
                    a.this.gMs.changeSelectStatus();
                }
            }
        });
        this.gMs.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jj(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.hRT = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bCS() {
        if (this.ZY != null && this.ZY.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fzE.addView(this.ZY.getView(), 0);
            this.ZY.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gMq || view == this.gMs.getCommentNumView() || view == this.iNy) {
            co(this.gMq);
        } else if (view == this.fzE) {
            if (this.agx != null && this.agx.bks() != null) {
                z = this.agx.bks().is_vertical.intValue() == 1;
            }
            if (z) {
                cm(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cy(this.fzE);
            } else {
                co(this.fzE);
            }
        } else if (view == this.hRJ) {
            co(this.hRJ);
        }
        if (this.agx != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.agx));
        }
    }

    private void cm(View view) {
        if (cls() != null) {
            cls().a(view, this.agx);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eCn.getPageActivity(), R.string.no_network_guide);
        } else {
            clz();
        }
    }

    private void clz() {
        if (this.agx != null) {
            String str = "frs";
            if (this.iNB == 501) {
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

    private void cy(View view) {
        if (this.agx != null) {
            aq aqVar = new aq("c11100");
            aqVar.dR("tid", this.agx.getId());
            aqVar.dR("fid", this.agx.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (cls() != null) {
            cls().a(view, this.agx);
        }
        if (view == this.fzE) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eCn.getPageActivity(), R.string.no_network_guide);
            } else {
                clA();
            }
        }
    }

    private void clA() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.agx);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fSf.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fSf.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.iNB == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eCn.getPageActivity(), str, this.agx.getTid(), n.bjM(), "", videoSerializeVideoThreadInfo);
        if (this.agx.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.agx.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void co(View view) {
        String str;
        String str2;
        if (this.agx != null) {
            if (this.agx.blj()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dR("fid", String.valueOf(this.agx.getFid())).aj("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dR("tid", this.agx.getId());
                aqVar.dR("fid", this.agx.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.agx.bka() != null && this.agx.bka().getGodUserData() != null && this.agx.bka().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").aj("obj_locate", 3).dR("tid", this.agx.getId()));
            }
        }
        if (cls() != null) {
            cls().a(view, this.agx);
        }
        if (this.agx != null) {
            n.II(this.agx.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ac.Em(this.agx.getId());
            String valueOf = String.valueOf(this.agx.getFid());
            if (this.agx.eAJ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.agx.eAJ.id;
                str2 = valueOf;
            }
            if (this.agx.bkx() > 0 && com.baidu.tieba.tbadkCore.util.e.dID()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eCn.getPageActivity()).createHistoryCfg(this.agx.getTid(), String.valueOf(this.agx.bkx()), false, true, "frs_page");
                String str3 = "frs";
                if (this.iNB == 501) {
                    str3 = "frs_tab";
                } else if (this.agx.blj()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.agx.blp());
                createHistoryCfg.setSmartFrsPosition(this.agx.blv());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.hRJ) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eCn.getPageActivity()).createFromThreadCfg(this.agx, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.iNB == 501) {
                str4 = "frs_tab";
            } else if (this.agx.blj()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.agx.blp());
            createFromThreadCfg.setSmartFrsPosition(this.agx.blv());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.hRJ) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
    public void clC() {
        this.hRU.removeMessages(202);
        if (this.ZY.getCurrentPosition() > 0) {
            w(false, 3);
            this.hRU.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hRU.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clD() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hRU.removeMessages(203);
        int currentPosition = this.ZY.getCurrentPosition();
        if (currentPosition != this.hRN) {
            this.hRN = currentPosition;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hRU.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.fzH != null && this.fzG != null && this.fzL != null && this.fzK != null && this.fzJ != null && this.fzI != null) {
            if (z || this.fzN != i) {
                this.fzN = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzR);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzQ);
                if (i == 2) {
                    this.fzH.setVisibility(8);
                    this.bSC.cancel();
                    this.fzG.clearAnimation();
                    this.fzG.setVisibility(0);
                    this.fzL.setVisibility(0);
                    this.hTt.setVisibility(0);
                    this.fzK.startLoading();
                    this.fzJ.setVisibility(8);
                    this.fzI.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fzR, 60000L);
                } else if (i == 3) {
                    this.fzH.setVisibility(8);
                    this.fzG.startAnimation(this.bSC);
                    this.fzL.setVisibility(8);
                    this.hTt.setVisibility(8);
                    this.fzK.duA();
                    this.fzJ.setVisibility(8);
                    this.fzI.setVisibility(8);
                    if (this.agx != null && this.agx.bks() != null) {
                        this.agx.bks().video_length.intValue();
                        this.agx.bks().video_duration.intValue();
                        this.agx.getTid();
                    }
                } else if (i == 4) {
                    this.fzH.setVisibility(8);
                    this.fzG.startAnimation(this.bSC);
                    this.fzL.setVisibility(8);
                    this.fzK.duB();
                    this.fzJ.setVisibility(0);
                    this.fzI.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fzQ, 2000L);
                } else {
                    this.fzH.setVisibility(0);
                    this.hTt.setVisibility(0);
                    this.bSC.cancel();
                    this.fzG.clearAnimation();
                    this.fzG.setVisibility(0);
                    this.fzL.setVisibility(0);
                    this.fzK.duB();
                    this.fzJ.setVisibility(8);
                    this.fzI.setVisibility(8);
                }
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hTU != null) {
            if (bwVar == null) {
                this.hTU.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.eAz)) {
                if (this.iNz != null && this.iNz.cDB() && (this.hTU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTU.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eCn.getContext(), R.dimen.tbds106);
                    this.hTU.setLayoutParams(layoutParams);
                }
                this.hTU.setVisibility(0);
                this.hTU.setImageDrawable(null);
                this.hTU.startLoad(bwVar.eAz, 10, false);
                this.hTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eCn != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bwVar.eAA, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hTU.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.agx == null || this.agx.bka() == null) {
            this.gMq.setVisibility(8);
            return;
        }
        this.gMq.setVisibility(0);
        this.gMq.setOnClickListener(this);
        clF();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ezR)) {
            this.agx.dG(this.mUrl, this.ezR);
        }
        this.agx.z(false, true);
        SpannableStringBuilder bkK = this.agx.bkK();
        if (this.agx.bkQ() && !StringUtils.isNull(this.agx.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bnH().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.agx.getTid();
            bkK.append((CharSequence) this.agx.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(bkK));
        this.mTextTitle.setText(bkK);
        this.iNz.ay(this.agx);
        Y(this.agx);
        this.gMr.setData(this.agx);
        if (this.gMr.getHeaderImg() != null) {
            if (this.gMr.getIsSimpleThread()) {
                this.gMr.getHeaderImg().setVisibility(8);
                this.hRK.setVisibility(8);
            } else if (this.agx.bka() == null || this.agx.bka().getPendantData() == null || StringUtils.isNull(this.agx.bka().getPendantData().bhW())) {
                this.hRK.setVisibility(8);
                this.gMr.getHeaderImg().setVisibility(0);
                this.gMr.getHeaderImg().setData(this.agx);
            } else {
                this.gMr.getHeaderImg().setVisibility(4);
                this.hRK.setVisibility(0);
                this.hRK.setData(this.agx);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMs.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.gMs.setLayoutParams(layoutParams);
        this.gMr.setUserAfterClickListener(this.ajG);
        uS(sZ(1));
        this.fzF.setText(at.stringForVideoTime(this.agx.bks().video_duration.intValue() * 1000));
        this.fzM.setText(String.format(this.eCn.getResources().getString(R.string.play_count), at.numFormatOverWan(this.agx.bks().play_count.intValue())));
        this.hRJ.setData(this.agx.blD());
        this.hRJ.onChangeSkinType();
        if (n.IJ(this.agx.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            n.a(this.hRJ.getGodReplyContent(), this.agx.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.agx == null || this.agx.bks() == null) {
            z = false;
        } else {
            z = this.agx.bks().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hRT.setVisibility(0);
        } else {
            this.hRT.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) && this.gMs.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agx.blL() || this.agx.blM() || this.agx.blN()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clE() {
        this.hRU.removeMessages(202);
        this.hRU.removeMessages(203);
    }

    private void bCT() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzQ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzR);
    }

    private void clF() {
        bCT();
        clE();
        if (this.fzG != null && this.fzE != null && this.ZY != null) {
            if (k.bhh().isShowImages() && this.agx != null && this.agx.bks() != null) {
                this.fzE.setVisibility(0);
                this.fzG.setPlaceHolder(3);
                this.fzG.startLoad(this.agx.bks().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.agx.bks().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                    TiebaStatic.log(new aq("c12026").dR("tid", this.agx.getId()));
                }
                this.ZY.setThreadDataForStatistic(this.agx);
                return;
            }
            this.fzE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gMq, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fzH, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fzI, R.color.cp_cont_a);
            ap.setViewTextColor(this.fzF, R.color.cp_cont_a);
            ap.setViewTextColor(this.fzM, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fzJ, R.color.common_color_10014);
            ap.setBackgroundColor(this.fKv, R.color.cp_bg_line_c);
            if (this.fzI != null) {
                this.fzI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.gNe != null && this.gNe.getVisibility() == 0) {
                this.gNe.onChangeSkinType();
            }
            this.gMs.onChangeSkinType();
            this.mSkinType = i;
            this.gMr.onChangeSkinType();
            if (this.hRK != null && this.hRK.getHeadView() != null && (this.hRK.getHeadView() instanceof TbImageView)) {
                this.hRK.getHeadView().setPlaceHolder(1);
            }
            this.fzG.setPlaceHolder(3);
            this.iNz.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
        this.currentPageType = i;
        if (this.gMs != null) {
            this.gMs.eQK = i;
            this.gMs.setFrom(2);
        }
        if (this.gMr != null) {
            this.gMr.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.hRO;
    }

    public boolean isPlaying() {
        if (this.ZY == null) {
            return false;
        }
        return this.ZY.isPlaying();
    }

    public void startPlay() {
        if (!this.hRO && this.agx != null && this.agx.bks() != null && this.ZY != null) {
            this.ZY.stopPlayback();
            if (ai.bBC()) {
                if (this.iNA || com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    w(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dR("obj_locate", "frs").dR("tid", this.agx.getId()));
                        this.mVideoUrl = this.agx.bks().video_url;
                    }
                    this.hRO = true;
                    this.ZY.setVideoPath(this.mVideoUrl, this.agx.getId());
                    if (this.gdo != null) {
                        this.gdo.start();
                    }
                    cly();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        if (this.agx != null && this.agx.bks() != null) {
            String str = this.agx.blj() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.iNB == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.alT = this.agx.getTid();
            oVar.fsZ = this.agx.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.agx.mRecomSource;
            oVar.mdW = this.agx.mRecomAbTag;
            oVar.mdS = this.agx.mRecomAbTag;
            oVar.mdT = this.agx.mRecomWeight;
            oVar.mdU = "";
            oVar.mdX = this.agx.bks().video_md5;
            h.a(this.agx.bks().video_md5, "", "1", oVar, this.ZY.getPcdnState());
        }
    }

    public void stopPlay() {
        bCT();
        clE();
        w(true, 1);
        if (this.ZY != null) {
            this.ZY.stopPlayback();
            if (this.gdo != null) {
                this.gdo.stop();
            }
        }
        this.hRO = false;
    }

    public View getVideoContainer() {
        return this.fzE;
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
        if (bdUniqueId != null && this.gMs != null && this.gMr != null) {
            this.gMr.setPageUniqueId(bdUniqueId);
        }
    }

    public void uS(int i) {
        if (this.agx != null) {
            if (i == 1) {
                this.gMs.setVisibility(8);
                this.gNe.setData(this.agx);
                this.gMt.setVisibility(8);
                return;
            }
            this.gMs.setData(this.agx);
            this.gMt.setVisibility(8);
            this.gNe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int sZ(int i) {
        return com.baidu.tieba.a.d.bGs().av(this.ahu, i);
    }
}
