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
import com.baidu.tieba.card.y;
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
public class a extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private TbCyberVideoView ZX;
    private bw agw;
    private String aht;
    private final View.OnClickListener ajF;
    private Animation bKh;
    private CyberPlayerManager.OnPreparedListener dZP;
    private CyberPlayerManager.OnErrorListener dZQ;
    private CyberPlayerManager.OnCompletionListener dZR;
    private CyberPlayerManager.OnInfoListener dZS;
    private final View.OnClickListener eIr;
    private String erq;
    private TbPageContext<?> etO;
    private View fCa;
    public LinearLayout fJK;
    private f fTl;
    public FrameLayout frg;
    private TextView frh;
    private TbImageView fri;
    private ImageView frj;
    private TextView frk;
    private View frl;
    private m frm;
    private View frn;
    private TextView fro;
    private int frp;
    private TbImageView.a frq;
    private ViewTreeObserver.OnGlobalLayoutListener frr;
    private Runnable frt;
    private Runnable fru;
    private TbCyberVideoView.a frv;
    private RelativeLayout gAC;
    public ThreadUserInfoLayout gAD;
    public ThreadCommentAndPraiseInfoLayout gAE;
    public View gAF;
    public ThreadSkinView gBB;
    protected ThreadSourceShareAndPraiseLayout gBq;
    private f.a hFD;
    private Animation.AnimationListener hFE;
    private ThreadGodReplyLayout hFm;
    private HeadPendantClickableView hFn;
    private int hFq;
    private boolean hFr;
    private TextView hFw;
    private Handler hFx;
    private VideoLoadingProgressView.a hFy;
    private LinearLayout hGW;
    private TbImageView hHx;
    public TextView iBb;
    public LinearLayout iBc;
    private i iBd;
    public boolean iBe;
    public int iBf;
    private View.OnClickListener iBg;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void ciq() {
        if (this.ZX != null && this.hFr) {
            try {
                this.ZX.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hFx.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.hFq = 0;
        this.frp = 1;
        this.hFr = false;
        this.hFx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.civ();
                        return;
                    case 203:
                        a.this.ciw();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.ZX != null) {
                    a.this.ZX.setVolume(0.0f, 0.0f);
                }
                a.this.ciq();
            }
        };
        this.dZS = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.w(false, 3);
                }
                return false;
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.ZX.start();
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cix();
                a.this.w(true, 4);
                a.this.hFr = false;
                return true;
            }
        };
        this.hFy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.ciq();
            }
        };
        this.frq = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.fri != null) {
                    a.this.fri.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.frr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.frg != null && a.this.frg.getLayoutParams() != null && a.this.frg.getVisibility() != 8) {
                    a.this.frg.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.frg.getLayoutParams();
                    if (a.this.frg.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.frg.getWidth() * 0.5625d);
                        a.this.frg.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.frt = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ZX != null && !a.this.ZX.isPlaying()) {
                    a.this.w(true, 1);
                }
            }
        };
        this.fru = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cix();
                a.this.w(true, 4);
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.iBg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agw != null && !StringUtils.isNull(a.this.agw.bil())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.etO.getPageActivity()).createNormalCfg(a.this.agw.bil(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.eIr != null) {
                        a.this.eIr.onClick(view);
                    }
                }
            }
        };
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cil() != null) {
                    a.this.cil().a(view, a.this.agw);
                }
            }
        };
        this.eIr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.agw != null && a.this.cil() != null) {
                    a.this.cil().a(view, a.this.agw);
                }
            }
        };
        this.hFD = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void sc() {
                a.this.cir();
            }
        };
        this.hFE = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.frp == 3 && a.this.fri != null) {
                    a.this.fri.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.etO = tbPageContext;
        View view = getView();
        this.fCa = view.findViewById(R.id.divider_line);
        this.gAC = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.hHx = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.iBc = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gAC.setOnClickListener(this);
        this.hFn = (HeadPendantClickableView) this.gAC.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.hFn.getHeadView() != null) {
            this.hFn.getHeadView().setIsRound(true);
            this.hFn.getHeadView().setDrawBorder(false);
            this.hFn.getHeadView().setDefaultResource(17170445);
            this.hFn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hFn.getHeadView().setRadius(l.getDimens(this.etO.getPageActivity(), R.dimen.ds70));
        }
        this.hFn.setHasPendantStyle();
        if (this.hFn.getPendantView() != null) {
            this.hFn.getPendantView().setIsRound(true);
            this.hFn.getPendantView().setDrawBorder(false);
        }
        this.iBb = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.iBb.setVisibility(8);
        this.iBb.setOnClickListener(this.iBg);
        this.frm = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.frm.setLoadingAnimationListener(this.hFy);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.gAE.setForumAfterClickListener(this.eIr);
        this.gAD = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.gAD.setFrom(3);
        this.gAF = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.gAE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gAE.setLayoutParams(layoutParams);
        }
        this.gAE.setOnClickListener(this);
        this.gAE.setReplyTimeVisible(false);
        this.gAE.setShowPraiseNum(true);
        this.gAE.setNeedAddPraiseIcon(true);
        this.gAE.setNeedAddReplyIcon(true);
        this.gAE.setIsBarViewVisible(false);
        this.gAE.setShareVisible(true);
        this.gAE.setShareReportFrom(1);
        this.gAE.setStType("frs_page");
        this.gAE.setFrom(2);
        this.gAE.eIo = 3;
        this.gBq = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.gBq.eJm.setOnClickListener(this);
        this.gBq.setFrom(2);
        this.gBq.setShareReportFrom(1);
        this.gBq.setSourceFromForPb(3);
        this.gBq.setStType("frs_page");
        this.gBq.setHideBarName(true);
        this.frg = (FrameLayout) view.findViewById(R.id.frame_video);
        this.frg.setOnClickListener(this);
        this.frg.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.frg != null) {
                    a.this.frg.getViewTreeObserver().addOnGlobalLayoutListener(a.this.frr);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.frg != null) {
                    a.this.frg.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.frr);
                }
            }
        });
        this.fri = (TbImageView) view.findViewById(R.id.image_video);
        this.fri.setPageId(getTag());
        this.fri.setDefaultErrorResource(0);
        this.fri.setDrawCorner(true);
        this.fri.setPlaceHolder(3);
        this.fri.setEvent(this.frq);
        this.fri.setGifIconSupport(false);
        this.frj = (ImageView) view.findViewById(R.id.image_video_play);
        this.ZX = new TbCyberVideoView(getContext());
        this.ZX.setStageType("2003");
        bAZ();
        this.ZX.setContinuePlayEnable(true);
        this.ZX.setOnPreparedListener(this.dZP);
        this.ZX.setOnCompletionListener(this.dZR);
        this.ZX.setOnErrorListener(this.dZQ);
        this.ZX.setOnInfoListener(this.dZS);
        this.ZX.setOnSurfaceDestroyedListener(this.frv);
        this.fTl = new f();
        this.fTl.setPlayer(this.ZX);
        this.fTl.a(this.hFD);
        this.frn = view.findViewById(R.id.auto_video_black_mask);
        this.frk = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.frl = view.findViewById(R.id.auto_video_error_background);
        this.fJK = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gBB = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bKh = AnimationUtils.loadAnimation(this.etO.getPageActivity(), R.anim.fade_out_video_cover);
        this.bKh.setAnimationListener(this.hFE);
        this.frh = (TextView) view.findViewById(R.id.text_video_duration);
        this.fro = (TextView) view.findViewById(R.id.text_video_play_count);
        this.hGW = (LinearLayout) view.findViewById(R.id.duration_container);
        this.iBd = new i(tbPageContext, this.gAC);
        this.iBd.setUniqueId(getTag());
        this.hFm = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.hFm.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.gAE != null) {
                    a.this.gAE.changeSelectStatus();
                }
            }
        });
        this.gAE.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iW(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.hFw = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bAZ() {
        if (this.ZX != null && this.ZX.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.frg.addView(this.ZX.getView(), 0);
            this.ZX.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gAC || view == this.gAE.getCommentNumView() || view == this.iBc) {
            ck(this.gAC);
        } else if (view == this.frg) {
            if (this.agw != null && this.agw.biz() != null) {
                z = this.agw.biz().is_vertical.intValue() == 1;
            }
            if (z) {
                ci(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cu(this.frg);
            } else {
                ck(this.frg);
            }
        } else if (view == this.hFm) {
            ck(this.hFm);
        }
        if (this.agw != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.agw));
        }
    }

    private void ci(View view) {
        if (cil() != null) {
            cil().a(view, this.agw);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.etO.getPageActivity(), R.string.no_network_guide);
        } else {
            cis();
        }
    }

    private void cis() {
        if (this.agw != null) {
            String str = "frs";
            if (this.iBf == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.agw);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.agw.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.agw.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cu(View view) {
        if (this.agw != null) {
            aq aqVar = new aq("c11100");
            aqVar.dK("tid", this.agw.getId());
            aqVar.dK("fid", this.agw.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (cil() != null) {
            cil().a(view, this.agw);
        }
        if (view == this.frg) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.etO.getPageActivity(), R.string.no_network_guide);
            } else {
                cit();
            }
        }
    }

    private void cit() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.agw);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.fJK.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.fJK.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.iBf == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.etO.getPageActivity(), str, this.agw.getTid(), com.baidu.tieba.card.m.bhT(), "", videoSerializeVideoThreadInfo);
        if (this.agw.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.agw.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void ck(View view) {
        String str;
        String str2;
        if (this.agw != null) {
            if (this.agw.bjq()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dK("fid", String.valueOf(this.agw.getFid())).aj("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dK("tid", this.agw.getId());
                aqVar.dK("fid", this.agw.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.agw.bih() != null && this.agw.bih().getGodUserData() != null && this.agw.bih().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").aj("obj_locate", 3).dK("tid", this.agw.getId()));
            }
        }
        if (cil() != null) {
            cil().a(view, this.agw);
        }
        if (this.agw != null) {
            com.baidu.tieba.card.m.Ij(this.agw.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            ac.DT(this.agw.getId());
            String valueOf = String.valueOf(this.agw.getFid());
            if (this.agw.esj == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.agw.esj.id;
                str2 = valueOf;
            }
            if (this.agw.biE() > 0 && com.baidu.tieba.tbadkCore.util.e.dFv()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.etO.getPageActivity()).createHistoryCfg(this.agw.getTid(), String.valueOf(this.agw.biE()), false, true, "frs_page");
                String str3 = "frs";
                if (this.iBf == 501) {
                    str3 = "frs_tab";
                } else if (this.agw.bjq()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.agw.bjw());
                createHistoryCfg.setSmartFrsPosition(this.agw.bjC());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.hFm) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.etO.getPageActivity()).createFromThreadCfg(this.agw, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.iBf == 501) {
                str4 = "frs_tab";
            } else if (this.agw.bjq()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.agw.bjw());
            createFromThreadCfg.setSmartFrsPosition(this.agw.bjC());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.hFm) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bw bwVar) {
        this.agw = bwVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void civ() {
        this.hFx.removeMessages(202);
        if (this.ZX.getCurrentPosition() > 0) {
            w(false, 3);
            this.hFx.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.hFx.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciw() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.hFx.removeMessages(203);
        int currentPosition = this.ZX.getCurrentPosition();
        if (currentPosition != this.hFq) {
            this.hFq = currentPosition;
            w(false, 3);
        } else {
            w(false, 2);
        }
        this.hFx.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, int i) {
        if (this.frj != null && this.fri != null && this.frn != null && this.frm != null && this.frl != null && this.frk != null) {
            if (z || this.frp != i) {
                this.frp = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fru);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.frt);
                if (i == 2) {
                    this.frj.setVisibility(8);
                    this.bKh.cancel();
                    this.fri.clearAnimation();
                    this.fri.setVisibility(0);
                    this.frn.setVisibility(0);
                    this.hGW.setVisibility(0);
                    this.frm.startLoading();
                    this.frl.setVisibility(8);
                    this.frk.setVisibility(8);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.fru, 60000L);
                } else if (i == 3) {
                    this.frj.setVisibility(8);
                    this.fri.startAnimation(this.bKh);
                    this.frn.setVisibility(8);
                    this.hGW.setVisibility(8);
                    this.frm.drt();
                    this.frl.setVisibility(8);
                    this.frk.setVisibility(8);
                    if (this.agw != null && this.agw.biz() != null) {
                        this.agw.biz().video_length.intValue();
                        this.agw.biz().video_duration.intValue();
                        this.agw.getTid();
                    }
                } else if (i == 4) {
                    this.frj.setVisibility(8);
                    this.fri.startAnimation(this.bKh);
                    this.frn.setVisibility(8);
                    this.frm.dru();
                    this.frl.setVisibility(0);
                    this.frk.setVisibility(0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.frt, 2000L);
                } else {
                    this.frj.setVisibility(0);
                    this.hGW.setVisibility(0);
                    this.bKh.cancel();
                    this.fri.clearAnimation();
                    this.fri.setVisibility(0);
                    this.frn.setVisibility(0);
                    this.frm.dru();
                    this.frl.setVisibility(8);
                    this.frk.setVisibility(8);
                }
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hHx != null) {
            if (bwVar == null) {
                this.hHx.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.erZ)) {
                if (this.iBd != null && this.iBd.cAu() && (this.hHx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHx.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.etO.getContext(), R.dimen.tbds106);
                    this.hHx.setLayoutParams(layoutParams);
                }
                this.hHx.setVisibility(0);
                this.hHx.setImageDrawable(null);
                this.hHx.startLoad(bwVar.erZ, 10, false);
                this.hHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.etO != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bwVar.esa, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hHx.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.agw == null || this.agw.bih() == null) {
            this.gAC.setVisibility(8);
            return;
        }
        this.gAC.setVisibility(0);
        this.gAC.setOnClickListener(this);
        ciy();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.erq)) {
            this.agw.dz(this.mUrl, this.erq);
        }
        this.agw.z(false, true);
        SpannableStringBuilder biR = this.agw.biR();
        if (this.agw.biX() && !StringUtils.isNull(this.agw.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.blO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.agw.getTid();
            biR.append((CharSequence) this.agw.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dK("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(biR));
        this.mTextTitle.setText(biR);
        this.iBd.ay(this.agw);
        Y(this.agw);
        this.gAD.setData(this.agw);
        if (this.gAD.getHeaderImg() != null) {
            if (this.gAD.getIsSimpleThread()) {
                this.gAD.getHeaderImg().setVisibility(8);
                this.hFn.setVisibility(8);
            } else if (this.agw.bih() == null || this.agw.bih().getPendantData() == null || StringUtils.isNull(this.agw.bih().getPendantData().bgd())) {
                this.hFn.setVisibility(8);
                this.gAD.getHeaderImg().setVisibility(0);
                this.gAD.getHeaderImg().setData(this.agw);
            } else {
                this.gAD.getHeaderImg().setVisibility(4);
                this.hFn.setVisibility(0);
                this.hFn.setData(this.agw);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAE.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.gAE.setLayoutParams(layoutParams);
        this.gAD.setUserAfterClickListener(this.ajF);
        uz(sO(1));
        this.frh.setText(at.stringForVideoTime(this.agw.biz().video_duration.intValue() * 1000));
        this.fro.setText(String.format(this.etO.getResources().getString(R.string.play_count), at.numFormatOverWan(this.agw.biz().play_count.intValue())));
        this.hFm.setData(this.agw.bjK());
        this.hFm.onChangeSkinType();
        if (com.baidu.tieba.card.m.Ik(this.agw.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.hFm.getGodReplyContent(), this.agw.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.agw == null || this.agw.biz() == null) {
            z = false;
        } else {
            z = this.agw.biz().is_vertical.intValue() == 1;
        }
        if (z) {
            this.hFw.setVisibility(0);
        } else {
            this.hFw.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) && this.gAE.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agw.bjS() || this.agw.bjT() || this.agw.bjU()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cix() {
        this.hFx.removeMessages(202);
        this.hFx.removeMessages(203);
    }

    private void bBa() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.frt);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fru);
    }

    private void ciy() {
        bBa();
        cix();
        if (this.fri != null && this.frg != null && this.ZX != null) {
            if (k.bfo().isShowImages() && this.agw != null && this.agw.biz() != null) {
                this.frg.setVisibility(0);
                this.fri.setPlaceHolder(3);
                this.fri.startLoad(this.agw.biz().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.agw.biz().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                    TiebaStatic.log(new aq("c12026").dK("tid", this.agw.getId()));
                }
                this.ZX.setThreadDataForStatistic(this.agw);
                return;
            }
            this.frg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gAC, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.frj, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.frk, R.color.cp_cont_a);
            ap.setViewTextColor(this.frh, R.color.cp_cont_a);
            ap.setViewTextColor(this.fro, R.color.cp_cont_a);
            ap.setBackgroundColor(this.frl, R.color.common_color_10014);
            ap.setBackgroundColor(this.fCa, R.color.cp_bg_line_c);
            if (this.frk != null) {
                this.frk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.gBq != null && this.gBq.getVisibility() == 0) {
                this.gBq.onChangeSkinType();
            }
            this.gAE.onChangeSkinType();
            this.mSkinType = i;
            this.gAD.onChangeSkinType();
            if (this.hFn != null && this.hFn.getHeadView() != null && (this.hFn.getHeadView() instanceof TbImageView)) {
                this.hFn.getHeadView().setPlaceHolder(1);
            }
            this.fri.setPlaceHolder(3);
            this.iBd.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.currentPageType = i;
        if (this.gAE != null) {
            this.gAE.eIo = i;
            this.gAE.setFrom(2);
        }
        if (this.gAD != null) {
            this.gAD.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.hFr;
    }

    public boolean isPlaying() {
        if (this.ZX == null) {
            return false;
        }
        return this.ZX.isPlaying();
    }

    public void startPlay() {
        if (!this.hFr && this.agw != null && this.agw.biz() != null && this.ZX != null) {
            this.ZX.stopPlayback();
            if (ai.bzJ()) {
                if (this.iBe || com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    w(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dK("obj_locate", "frs").dK("tid", this.agw.getId()));
                        this.mVideoUrl = this.agw.biz().video_url;
                    }
                    this.hFr = true;
                    this.ZX.setVideoPath(this.mVideoUrl, this.agw.getId());
                    if (this.fTl != null) {
                        this.fTl.start();
                    }
                    cir();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cir() {
        if (this.agw != null && this.agw.biz() != null) {
            String str = this.agw.bjq() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.iBf == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.alS = this.agw.getTid();
            oVar.fkA = this.agw.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.agw.mRecomSource;
            oVar.lRy = this.agw.mRecomAbTag;
            oVar.lRu = this.agw.mRecomAbTag;
            oVar.lRv = this.agw.mRecomWeight;
            oVar.lRw = "";
            oVar.lRz = this.agw.biz().video_md5;
            h.a(this.agw.biz().video_md5, "", "1", oVar, this.ZX.getPcdnState());
        }
    }

    public void stopPlay() {
        bBa();
        cix();
        w(true, 1);
        if (this.ZX != null) {
            this.ZX.stopPlayback();
            if (this.fTl != null) {
                this.fTl.stop();
            }
        }
        this.hFr = false;
    }

    public View getVideoContainer() {
        return this.frg;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZX == null) {
            return 0;
        }
        return this.ZX.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.ZX != null) {
            this.ZX.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gAE != null && this.gAD != null) {
            this.gAD.setPageUniqueId(bdUniqueId);
        }
    }

    public void uz(int i) {
        if (this.agw != null) {
            if (i == 1) {
                this.gAE.setVisibility(8);
                this.gBq.setData(this.agw);
                this.gAF.setVisibility(8);
                return;
            }
            this.gAE.setData(this.agw);
            this.gAF.setVisibility(8);
            this.gBq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public int sO(int i) {
        return com.baidu.tieba.a.d.bEz().av(this.aht, i);
    }
}
