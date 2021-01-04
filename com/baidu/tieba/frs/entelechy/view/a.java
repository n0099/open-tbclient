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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
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
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.b<bz> implements e, y {
    private TbCyberVideoView abK;
    private bz aim;
    private String aji;
    private final View.OnClickListener alk;
    private Animation ciC;
    private CyberPlayerManager.OnPreparedListener eDf;
    private CyberPlayerManager.OnErrorListener eDg;
    private CyberPlayerManager.OnCompletionListener eDh;
    private CyberPlayerManager.OnInfoListener eDi;
    private String eUU;
    private TbPageContext<?> eXu;
    private TbCyberVideoView.a fWA;
    public FrameLayout fWm;
    private TextView fWn;
    private TbImageView fWo;
    private ImageView fWp;
    private TextView fWq;
    private View fWr;
    private m fWs;
    private View fWt;
    private TextView fWu;
    private int fWv;
    private TbImageView.b fWw;
    private ViewTreeObserver.OnGlobalLayoutListener fWx;
    private Runnable fWy;
    private Runnable fWz;
    private final View.OnClickListener fmS;
    private f gBV;
    private View ghM;
    public LinearLayout gpU;
    public View hnA;
    private RelativeLayout hnx;
    public ThreadUserInfoLayout hny;
    public ThreadCommentAndPraiseInfoLayout hnz;
    protected ThreadSourceShareAndPraiseLayout hol;
    public ThreadSkinView hox;
    private ThreadGodReplyLayout ivA;
    private HeadPendantClickableView ivB;
    private int ivE;
    private boolean ivF;
    private TextView ivK;
    private Handler ivL;
    private VideoLoadingProgressView.a ivM;
    private f.a ivR;
    private Animation.AnimationListener ivS;
    private TbImageView ixL;
    private LinearLayout ixj;
    public TextView jrD;
    public LinearLayout jrE;
    private i jrF;
    public boolean jrG;
    public int jrH;
    private View.OnClickListener jrI;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cuH() {
        if (this.abK != null && this.ivF) {
            try {
                this.abK.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ivL.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ivE = 0;
        this.fWv = 1;
        this.ivF = false;
        this.ivL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.cuM();
                        return;
                    case 203:
                        a.this.cuN();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.abK != null) {
                    a.this.abK.setVolume(0.0f, 0.0f);
                }
                a.this.cuH();
            }
        };
        this.eDi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.abK.start();
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cuO();
                a.this.v(true, 4);
                a.this.ivF = false;
                return true;
            }
        };
        this.ivM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.cuH();
            }
        };
        this.fWw = new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && a.this.fWo != null) {
                    a.this.fWo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fWx = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fWm != null && a.this.fWm.getLayoutParams() != null && a.this.fWm.getVisibility() != 8) {
                    a.this.fWm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fWm.getLayoutParams();
                    if (a.this.fWm.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fWm.getWidth() * 0.5625d);
                        a.this.fWm.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fWy = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.abK != null && !a.this.abK.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.fWz = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cuO();
                a.this.v(true, 4);
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.jrI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aim != null && !StringUtils.isNull(a.this.aim.bru())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eXu.getPageActivity()).createNormalCfg(a.this.aim.bru(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.fmS != null) {
                        a.this.fmS.onClick(view);
                    }
                }
            }
        };
        this.alk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cuC() != null) {
                    a.this.cuC().a(view, a.this.aim);
                }
            }
        };
        this.fmS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aim != null && a.this.cuC() != null) {
                    a.this.cuC().a(view, a.this.aim);
                }
            }
        };
        this.ivR = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void rF() {
                a.this.cuI();
            }
        };
        this.ivS = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fWv == 3 && a.this.fWo != null) {
                    a.this.fWo.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eXu = tbPageContext;
        View view = getView();
        this.ghM = view.findViewById(R.id.divider_line);
        this.hnx = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ixL = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.jrE = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hnx.setOnClickListener(this);
        this.ivB = (HeadPendantClickableView) this.hnx.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.ivB.getHeadView() != null) {
            this.ivB.getHeadView().setIsRound(true);
            this.ivB.getHeadView().setDrawBorder(false);
            this.ivB.getHeadView().setDefaultResource(17170445);
            this.ivB.getHeadView().setRadius(l.getDimens(this.eXu.getPageActivity(), R.dimen.ds70));
        }
        this.ivB.setHasPendantStyle();
        if (this.ivB.getPendantView() != null) {
            this.ivB.getPendantView().setIsRound(true);
            this.ivB.getPendantView().setDrawBorder(false);
        }
        this.jrD = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.jrD.setVisibility(8);
        this.jrD.setOnClickListener(this.jrI);
        this.fWs = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fWs.setLoadingAnimationListener(this.ivM);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.hnz.setForumAfterClickListener(this.fmS);
        this.hny = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hny.setFrom(3);
        this.hnA = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.hnz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnz.setLayoutParams(layoutParams);
        }
        this.hnz.setOnClickListener(this);
        this.hnz.setReplyTimeVisible(false);
        this.hnz.setShowPraiseNum(true);
        this.hnz.setNeedAddPraiseIcon(true);
        this.hnz.setNeedAddReplyIcon(true);
        this.hnz.setIsBarViewVisible(false);
        this.hnz.setShareVisible(true);
        this.hnz.setShareReportFrom(1);
        this.hnz.setStType("frs_page");
        this.hnz.setFrom(2);
        this.hnz.fmP = 3;
        this.hol = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hol.fnK.setOnClickListener(this);
        this.hol.setFrom(2);
        this.hol.setShareReportFrom(1);
        this.hol.setSourceFromForPb(3);
        this.hol.setStType("frs_page");
        this.hol.setHideBarName(true);
        this.fWm = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fWm.setOnClickListener(this);
        this.fWm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fWm != null) {
                    a.this.fWm.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fWx);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fWm != null) {
                    a.this.fWm.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fWx);
                }
            }
        });
        this.fWo = (TbImageView) view.findViewById(R.id.image_video);
        this.fWo.setPageId(getTag());
        this.fWo.setDrawCorner(true);
        this.fWo.setPlaceHolder(3);
        this.fWo.setEvent(this.fWw);
        this.fWo.setGifIconSupport(false);
        this.fWp = (ImageView) view.findViewById(R.id.image_video_play);
        this.abK = new TbCyberVideoView(getContext());
        this.abK.setStageType("2003");
        bKF();
        this.abK.setContinuePlayEnable(true);
        this.abK.setOnPreparedListener(this.eDf);
        this.abK.setOnCompletionListener(this.eDh);
        this.abK.setOnErrorListener(this.eDg);
        this.abK.setOnInfoListener(this.eDi);
        this.abK.setOnSurfaceDestroyedListener(this.fWA);
        this.gBV = new f();
        this.gBV.setPlayer(this.abK);
        this.gBV.a(this.ivR);
        this.fWt = view.findViewById(R.id.auto_video_black_mask);
        this.fWq = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fWr = view.findViewById(R.id.auto_video_error_background);
        this.gpU = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hox = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.ciC = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.fade_out_video_cover);
        this.ciC.setAnimationListener(this.ivS);
        this.fWn = (TextView) view.findViewById(R.id.text_video_duration);
        this.fWu = (TextView) view.findViewById(R.id.text_video_play_count);
        this.ixj = (LinearLayout) view.findViewById(R.id.duration_container);
        this.jrF = new i(tbPageContext, this.hnx);
        this.jrF.setUniqueId(getTag());
        this.ivA = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.ivA.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.hnz != null) {
                    a.this.hnz.changeSelectStatus();
                }
            }
        });
        this.hnz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void kf(boolean z) {
                if (a.this.mMaskView != null) {
                    ao.setBackgroundColor(a.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
                }
            }
        });
        this.ivK = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bKF() {
        if (this.abK != null && this.abK.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fWm.addView(this.abK.getView(), 0);
            this.abK.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.hnx || view == this.hnz.getCommentNumView() || view == this.jrE) {
            cO(this.hnx);
        } else if (view == this.fWm) {
            if (this.aim != null && this.aim.brH() != null) {
                z = this.aim.brH().is_vertical.intValue() == 1;
            }
            if (z) {
                cM(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cY(this.fWm);
            } else {
                cO(this.fWm);
            }
        } else if (view == this.ivA) {
            cO(this.ivA);
        }
        if (this.aim != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aim));
        }
    }

    private void cM(View view) {
        if (cuC() != null) {
            cuC().a(view, this.aim);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eXu.getPageActivity(), R.string.no_network_guide);
        } else {
            cuJ();
        }
    }

    private void cuJ() {
        if (this.aim != null) {
            String str = "frs";
            if (this.jrH == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aim);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.aim.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.aim.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cY(View view) {
        if (this.aim != null) {
            aq aqVar = new aq("c11100");
            aqVar.dX("tid", this.aim.getId());
            aqVar.dX("fid", this.aim.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (cuC() != null) {
            cuC().a(view, this.aim);
        }
        if (view == this.fWm) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eXu.getPageActivity(), R.string.no_network_guide);
            } else {
                cuK();
            }
        }
    }

    private void cuK() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aim);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.gpU.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.gpU.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.jrH == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eXu.getPageActivity(), str, this.aim.getTid(), com.baidu.tieba.card.m.brc(), "", videoSerializeVideoThreadInfo);
        if (this.aim.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.aim.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void cO(View view) {
        String str;
        String str2;
        if (this.aim != null) {
            if (this.aim.bsB()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dX("fid", String.valueOf(this.aim.getFid())).an("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dX("tid", this.aim.getId());
                aqVar.dX("fid", this.aim.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.aim.brq() != null && this.aim.brq().getGodUserData() != null && this.aim.brq().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").an("obj_locate", 3).dX("tid", this.aim.getId()));
            }
        }
        if (cuC() != null) {
            cuC().a(view, this.aim);
        }
        if (this.aim != null) {
            com.baidu.tieba.card.m.Jo(this.aim.getId());
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            z.EK(this.aim.getId());
            String valueOf = String.valueOf(this.aim.getFid());
            if (this.aim.eVM == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aim.eVM.id;
                str2 = valueOf;
            }
            if (this.aim.brM() > 0 && com.baidu.tieba.tbadkCore.util.e.dQt()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eXu.getPageActivity()).createHistoryCfg(this.aim.getTid(), String.valueOf(this.aim.brM()), false, true, "frs_page");
                String str3 = "frs";
                if (this.jrH == 501) {
                    str3 = "frs_tab";
                } else if (this.aim.bsB()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aim.bsI());
                createHistoryCfg.setSmartFrsPosition(this.aim.bsO());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.ivA) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eXu.getPageActivity()).createFromThreadCfg(this.aim, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.jrH == 501) {
                str4 = "frs_tab";
            } else if (this.aim.bsB()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aim.bsI());
            createFromThreadCfg.setSmartFrsPosition(this.aim.bsO());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.ivA) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        this.aim = bzVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuM() {
        this.ivL.removeMessages(202);
        if (this.abK.getCurrentPosition() > 0) {
            v(false, 3);
            this.ivL.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.ivL.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuN() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ivL.removeMessages(203);
        int currentPosition = this.abK.getCurrentPosition();
        if (currentPosition != this.ivE) {
            this.ivE = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.ivL.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fWp != null && this.fWo != null && this.fWt != null && this.fWs != null && this.fWr != null && this.fWq != null) {
            if (z || this.fWv != i) {
                this.fWv = i;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWz);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWy);
                if (i == 2) {
                    this.fWp.setVisibility(8);
                    this.ciC.cancel();
                    this.fWo.clearAnimation();
                    this.fWo.setVisibility(0);
                    this.fWt.setVisibility(0);
                    this.ixj.setVisibility(0);
                    this.fWs.startLoading();
                    this.fWr.setVisibility(8);
                    this.fWq.setVisibility(8);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fWz, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fWp.setVisibility(8);
                    this.fWo.startAnimation(this.ciC);
                    this.fWt.setVisibility(8);
                    this.ixj.setVisibility(8);
                    this.fWs.dBK();
                    this.fWr.setVisibility(8);
                    this.fWq.setVisibility(8);
                    if (this.aim != null && this.aim.brH() != null) {
                        this.aim.brH().video_length.intValue();
                        this.aim.brH().video_duration.intValue();
                        this.aim.getTid();
                    }
                } else if (i == 4) {
                    this.fWp.setVisibility(8);
                    this.fWo.startAnimation(this.ciC);
                    this.fWt.setVisibility(8);
                    this.fWs.dBL();
                    this.fWr.setVisibility(0);
                    this.fWq.setVisibility(0);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fWy, 2000L);
                } else {
                    this.fWp.setVisibility(0);
                    this.ixj.setVisibility(0);
                    this.ciC.cancel();
                    this.fWo.clearAnimation();
                    this.fWo.setVisibility(0);
                    this.fWt.setVisibility(0);
                    this.fWs.dBL();
                    this.fWr.setVisibility(8);
                    this.fWq.setVisibility(8);
                }
            }
        }
    }

    private void aa(final bz bzVar) {
        if (this.ixL != null) {
            if (bzVar == null) {
                this.ixL.setVisibility(8);
            } else if (!StringUtils.isNull(bzVar.eVC)) {
                if (this.jrF != null && this.jrF.cNY() && (this.ixL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixL.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eXu.getContext(), R.dimen.tbds106);
                    this.ixL.setLayoutParams(layoutParams);
                }
                this.ixL.setVisibility(0);
                this.ixL.setImageDrawable(null);
                this.ixL.startLoad(bzVar.eVC, 10, false);
                this.ixL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eXu != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bzVar.eVD, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ixL.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aim == null || this.aim.brq() == null) {
            this.hnx.setVisibility(8);
            return;
        }
        this.hnx.setVisibility(0);
        this.hnx.setOnClickListener(this);
        cuP();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eUU)) {
            this.aim.dK(this.mUrl, this.eUU);
        }
        this.aim.z(false, true);
        SpannableStringBuilder brZ = this.aim.brZ();
        if (this.aim.bsg() && !StringUtils.isNull(this.aim.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.bvq().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aim.getTid();
            brZ.append((CharSequence) this.aim.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dX("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(brZ));
        this.mTextTitle.setText(brZ);
        this.jrF.aA(this.aim);
        aa(this.aim);
        this.hny.setData(this.aim);
        if (this.hny.getHeaderImg() != null) {
            if (this.hny.getIsSimpleThread()) {
                this.hny.getHeaderImg().setVisibility(8);
                this.ivB.setVisibility(8);
            } else if (this.aim.brq() == null || this.aim.brq().getPendantData() == null || StringUtils.isNull(this.aim.brq().getPendantData().getImgUrl())) {
                this.ivB.setVisibility(8);
                this.hny.getHeaderImg().setVisibility(0);
                this.hny.getHeaderImg().setData(this.aim);
            } else {
                this.hny.getHeaderImg().setVisibility(4);
                this.ivB.setVisibility(0);
                this.ivB.setData(this.aim);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnz.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.hnz.setLayoutParams(layoutParams);
        this.hny.setUserAfterClickListener(this.alk);
        wv(ux(1));
        this.fWn.setText(at.stringForVideoTime(this.aim.brH().video_duration.intValue() * 1000));
        this.fWu.setText(String.format(this.eXu.getResources().getString(R.string.play_count), at.numFormatOverWan(this.aim.brH().play_count.intValue())));
        this.ivA.setData(this.aim.bsW());
        this.ivA.onChangeSkinType();
        if (com.baidu.tieba.card.m.Jp(this.aim.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            com.baidu.tieba.card.m.a(this.ivA.getGodReplyContent(), this.aim.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.aim == null || this.aim.brH() == null) {
            z = false;
        } else {
            z = this.aim.brH().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ivK.setVisibility(0);
        } else {
            this.ivK.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cDX().cDR() || com.baidu.tieba.frs.a.cDQ().cDR()) && this.hnz.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aim.bte() || this.aim.btf() || this.aim.btg()) {
                ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuO() {
        this.ivL.removeMessages(202);
        this.ivL.removeMessages(203);
    }

    private void bKG() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWy);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWz);
    }

    private void cuP() {
        bKG();
        cuO();
        if (this.fWo != null && this.fWm != null && this.abK != null) {
            if (k.bou().isShowImages() && this.aim != null && this.aim.brH() != null) {
                this.fWm.setVisibility(0);
                this.fWo.setPlaceHolder(3);
                this.fWo.startLoad(this.aim.brH().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aim.brH().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new aq("c12026").dX("tid", this.aim.getId()));
                }
                this.abK.setThreadDataForStatistic(this.aim);
                return;
            }
            this.fWm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hnx, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.fWp, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.fWq, R.color.CAM_X0101);
            ao.setViewTextColor(this.fWn, R.color.CAM_X0101);
            ao.setViewTextColor(this.fWu, R.color.CAM_X0101);
            ao.setBackgroundColor(this.fWr, R.color.common_color_10014);
            ao.setBackgroundColor(this.ghM, R.color.CAM_X0204);
            if (this.fWq != null) {
                this.fWq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.hol != null && this.hol.getVisibility() == 0) {
                this.hol.onChangeSkinType();
            }
            this.hnz.onChangeSkinType();
            this.mSkinType = i;
            this.hny.onChangeSkinType();
            if (this.ivB != null && this.ivB.getHeadView() != null && (this.ivB.getHeadView() instanceof TbImageView)) {
                this.ivB.getHeadView().setPlaceHolder(1);
            }
            this.fWo.setPlaceHolder(3);
            this.jrF.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.currentPageType = i;
        if (this.hnz != null) {
            this.hnz.fmP = i;
            this.hnz.setFrom(2);
        }
        if (this.hny != null) {
            this.hny.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.ivF;
    }

    public boolean isPlaying() {
        if (this.abK == null) {
            return false;
        }
        return this.abK.isPlaying();
    }

    public void startPlay() {
        if (!this.ivF && this.aim != null && this.aim.brH() != null && this.abK != null) {
            this.abK.stopPlayback();
            if (ah.bJo()) {
                if (this.jrG || com.baidu.tbadk.core.sharedPref.b.bvq().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dX("obj_locate", "frs").dX("tid", this.aim.getId()));
                        this.mVideoUrl = this.aim.brH().video_url;
                    }
                    this.ivF = true;
                    this.abK.setVideoPath(this.mVideoUrl, this.aim.getId());
                    if (this.gBV != null) {
                        this.gBV.start();
                    }
                    cuI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuI() {
        if (this.aim != null && this.aim.brH() != null) {
            String str = this.aim.bsB() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.jrH == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.anD = this.aim.getTid();
            oVar.fPy = this.aim.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.aim.mRecomSource;
            oVar.mDL = this.aim.mRecomAbTag;
            oVar.mDH = this.aim.mRecomAbTag;
            oVar.mDI = this.aim.mRecomWeight;
            oVar.mDJ = "";
            oVar.mDM = this.aim.brH().video_md5;
            h.a(this.aim.brH().video_md5, "", "1", oVar, this.abK.getPcdnState());
        }
    }

    public void stopPlay() {
        bKG();
        cuO();
        v(true, 1);
        if (this.abK != null) {
            this.abK.stopPlayback();
            if (this.gBV != null) {
                this.gBV.stop();
            }
        }
        this.ivF = false;
    }

    public View getVideoContainer() {
        return this.fWm;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abK == null) {
            return 0;
        }
        return this.abK.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.abK != null) {
            this.abK.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnz != null && this.hny != null) {
            this.hny.setPageUniqueId(bdUniqueId);
        }
    }

    public void wv(int i) {
        if (this.aim != null) {
            if (i == 1) {
                this.hnz.setVisibility(8);
                this.hol.setData(this.aim);
                this.hnA.setVisibility(8);
                return;
            }
            this.hnz.setData(this.aim);
            this.hnA.setVisibility(8);
            this.hol.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public int ux(int i) {
        return com.baidu.tieba.a.d.bOm().az(this.aji, i);
    }
}
