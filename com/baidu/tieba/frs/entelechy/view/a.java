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
    private TbCyberVideoView acZ;
    private cb aiB;
    private String ajx;
    private final View.OnClickListener alB;
    private Animation cjy;
    private CyberPlayerManager.OnPreparedListener eCb;
    private CyberPlayerManager.OnErrorListener eCc;
    private CyberPlayerManager.OnCompletionListener eCd;
    private CyberPlayerManager.OnInfoListener eCe;
    private String eTW;
    private TbPageContext<?> eWx;
    private m fVA;
    private View fVB;
    private TextView fVC;
    private int fVD;
    private TbImageView.b fVE;
    private ViewTreeObserver.OnGlobalLayoutListener fVF;
    private Runnable fVG;
    private Runnable fVH;
    private TbCyberVideoView.a fVI;
    public FrameLayout fVu;
    private TextView fVv;
    private TbImageView fVw;
    private ImageView fVx;
    private TextView fVy;
    private View fVz;
    private final View.OnClickListener flY;
    private f gBV;
    private View ghb;
    public LinearLayout gpQ;
    protected ThreadSourceShareAndPraiseLayout hpQ;
    private RelativeLayout hpc;
    public ThreadUserInfoLayout hpd;
    public ThreadCommentAndPraiseInfoLayout hpe;
    public View hpf;
    public ThreadSkinView hqb;
    private TbImageView iAL;
    private LinearLayout iAh;
    private TextView iyE;
    private Handler iyF;
    private VideoLoadingProgressView.a iyG;
    private f.a iyL;
    private Animation.AnimationListener iyM;
    private ThreadGodReplyLayout iyu;
    private HeadPendantClickableView iyv;
    private int iyy;
    private boolean iyz;
    public TextView juA;
    public LinearLayout juB;
    private i juC;
    public boolean juD;
    public int juE;
    private View.OnClickListener juF;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        if (this.acZ != null && this.iyz) {
            try {
                this.acZ.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.iyF.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.iyy = 0;
        this.fVD = 1;
        this.iyz = false;
        this.iyF = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.css();
                        return;
                    case 203:
                        a.this.cst();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.acZ != null) {
                    a.this.acZ.setVolume(0.0f, 0.0f);
                }
                a.this.csn();
            }
        };
        this.eCe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.acZ.start();
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.csu();
                a.this.v(true, 4);
                a.this.iyz = false;
                return true;
            }
        };
        this.iyG = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.csn();
            }
        };
        this.fVE = new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && a.this.fVw != null) {
                    a.this.fVw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fVF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fVu != null && a.this.fVu.getLayoutParams() != null && a.this.fVu.getVisibility() != 8) {
                    a.this.fVu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fVu.getLayoutParams();
                    if (a.this.fVu.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fVu.getWidth() * 0.5625d);
                        a.this.fVu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fVG = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.acZ != null && !a.this.acZ.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.fVH = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.csu();
                a.this.v(true, 4);
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.juF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiB != null && !StringUtils.isNull(a.this.aiB.bnW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eWx.getPageActivity()).createNormalCfg(a.this.aiB.bnW(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.flY != null) {
                        a.this.flY.onClick(view);
                    }
                }
            }
        };
        this.alB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.csi() != null) {
                    a.this.csi().a(view, a.this.aiB);
                }
            }
        };
        this.flY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiB != null && a.this.csi() != null) {
                    a.this.csi().a(view, a.this.aiB);
                }
            }
        };
        this.iyL = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void rD() {
                a.this.cso();
            }
        };
        this.iyM = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fVD == 3 && a.this.fVw != null) {
                    a.this.fVw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eWx = tbPageContext;
        View view = getView();
        this.ghb = view.findViewById(R.id.divider_line);
        this.hpc = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.iAL = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.juB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hpc.setOnClickListener(this);
        this.iyv = (HeadPendantClickableView) this.hpc.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.iyv.getHeadView() != null) {
            this.iyv.getHeadView().setIsRound(true);
            this.iyv.getHeadView().setDrawBorder(false);
            this.iyv.getHeadView().setDefaultResource(17170445);
            this.iyv.getHeadView().setRadius(l.getDimens(this.eWx.getPageActivity(), R.dimen.ds70));
        }
        this.iyv.setHasPendantStyle();
        if (this.iyv.getPendantView() != null) {
            this.iyv.getPendantView().setIsRound(true);
            this.iyv.getPendantView().setDrawBorder(false);
        }
        this.juA = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.juA.setVisibility(8);
        this.juA.setOnClickListener(this.juF);
        this.fVA = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fVA.setLoadingAnimationListener(this.iyG);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.hpe.setForumAfterClickListener(this.flY);
        this.hpd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hpd.setFrom(3);
        this.hpf = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.hpe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hpe.setLayoutParams(layoutParams);
        }
        this.hpe.setOnClickListener(this);
        this.hpe.setReplyTimeVisible(false);
        this.hpe.setShowPraiseNum(true);
        this.hpe.setNeedAddPraiseIcon(true);
        this.hpe.setNeedAddReplyIcon(true);
        this.hpe.setIsBarViewVisible(false);
        this.hpe.setShareVisible(true);
        this.hpe.setShareReportFrom(1);
        this.hpe.setStType("frs_page");
        this.hpe.setFrom(2);
        this.hpe.flV = 3;
        this.hpQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hpQ.fmS.setOnClickListener(this);
        this.hpQ.setFrom(2);
        this.hpQ.setShareReportFrom(1);
        this.hpQ.setSourceFromForPb(3);
        this.hpQ.setStType("frs_page");
        this.hpQ.setHideBarName(true);
        this.fVu = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fVu.setOnClickListener(this);
        this.fVu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fVu != null) {
                    a.this.fVu.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fVF);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fVu != null) {
                    a.this.fVu.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fVF);
                }
            }
        });
        this.fVw = (TbImageView) view.findViewById(R.id.image_video);
        this.fVw.setPageId(getTag());
        this.fVw.setDrawCorner(true);
        this.fVw.setPlaceHolder(3);
        this.fVw.setEvent(this.fVE);
        this.fVw.setGifIconSupport(false);
        this.fVx = (ImageView) view.findViewById(R.id.image_video_play);
        this.acZ = new TbCyberVideoView(getContext());
        this.acZ.setStageType("2003");
        bHm();
        this.acZ.setContinuePlayEnable(true);
        this.acZ.setOnPreparedListener(this.eCb);
        this.acZ.setOnCompletionListener(this.eCd);
        this.acZ.setOnErrorListener(this.eCc);
        this.acZ.setOnInfoListener(this.eCe);
        this.acZ.setOnSurfaceDestroyedListener(this.fVI);
        this.gBV = new f();
        this.gBV.setPlayer(this.acZ);
        this.gBV.a(this.iyL);
        this.fVB = view.findViewById(R.id.auto_video_black_mask);
        this.fVy = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fVz = view.findViewById(R.id.auto_video_error_background);
        this.gpQ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hqb = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.cjy = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.fade_out_video_cover);
        this.cjy.setAnimationListener(this.iyM);
        this.fVv = (TextView) view.findViewById(R.id.text_video_duration);
        this.fVC = (TextView) view.findViewById(R.id.text_video_play_count);
        this.iAh = (LinearLayout) view.findViewById(R.id.duration_container);
        this.juC = new i(tbPageContext, this.hpc);
        this.juC.setUniqueId(getTag());
        this.iyu = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.iyu.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.hpe != null) {
                    a.this.hpe.changeSelectStatus();
                }
            }
        });
        this.hpe.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void ke(boolean z) {
                if (a.this.mMaskView != null) {
                    ap.setBackgroundColor(a.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
                }
            }
        });
        this.iyE = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bHm() {
        if (this.acZ != null && this.acZ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fVu.addView(this.acZ.getView(), 0);
            this.acZ.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.hpc || view == this.hpe.getCommentNumView() || view == this.juB) {
            cM(this.hpc);
        } else if (view == this.fVu) {
            if (this.aiB != null && this.aiB.boj() != null) {
                z = this.aiB.boj().is_vertical.intValue() == 1;
            }
            if (z) {
                cK(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cW(this.fVu);
            } else {
                cM(this.fVu);
            }
        } else if (view == this.iyu) {
            cM(this.iyu);
        }
        if (this.aiB != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiB));
        }
    }

    private void cK(View view) {
        if (csi() != null) {
            csi().a(view, this.aiB);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eWx.getPageActivity(), R.string.no_network_guide);
        } else {
            csp();
        }
    }

    private void csp() {
        if (this.aiB != null) {
            String str = "frs";
            if (this.juE == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aiB);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.aiB.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.aiB.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cW(View view) {
        if (this.aiB != null) {
            ar arVar = new ar("c11100");
            arVar.dR("tid", this.aiB.getId());
            arVar.dR("fid", this.aiB.getFid() + "");
            TiebaStatic.log(arVar);
        }
        if (csi() != null) {
            csi().a(view, this.aiB);
        }
        if (view == this.fVu) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eWx.getPageActivity(), R.string.no_network_guide);
            } else {
                csq();
            }
        }
    }

    private void csq() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aiB);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.gpQ.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.gpQ.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.juE == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eWx.getPageActivity(), str, this.aiB.getTid(), com.baidu.tieba.card.m.bnE(), "", videoSerializeVideoThreadInfo);
        if (this.aiB.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.aiB.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void cM(View view) {
        String str;
        String str2;
        if (this.aiB != null) {
            if (this.aiB.bpc()) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dR("fid", String.valueOf(this.aiB.getFid())).aq("obj_type", 2));
            } else {
                ar arVar = new ar("c11100");
                arVar.dR("tid", this.aiB.getId());
                arVar.dR("fid", this.aiB.getFid() + "");
                TiebaStatic.log(arVar);
            }
            if (this.aiB.bnS() != null && this.aiB.bnS().getGodUserData() != null && this.aiB.bnS().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ar("c10806").aq("obj_locate", 3).dR("tid", this.aiB.getId()));
            }
        }
        if (csi() != null) {
            csi().a(view, this.aiB);
        }
        if (this.aiB != null) {
            com.baidu.tieba.card.m.IW(this.aiB.getId());
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            ab.DV(this.aiB.getId());
            String valueOf = String.valueOf(this.aiB.getFid());
            if (this.aiB.eUO == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aiB.eUO.id;
                str2 = valueOf;
            }
            if (this.aiB.boo() > 0 && com.baidu.tieba.tbadkCore.util.e.dPe()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eWx.getPageActivity()).createHistoryCfg(this.aiB.getTid(), String.valueOf(this.aiB.boo()), false, true, "frs_page");
                String str3 = "frs";
                if (this.juE == 501) {
                    str3 = "frs_tab";
                } else if (this.aiB.bpc()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aiB.bpj());
                createHistoryCfg.setSmartFrsPosition(this.aiB.bpp());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.iyu) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eWx.getPageActivity()).createFromThreadCfg(this.aiB, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.juE == 501) {
                str4 = "frs_tab";
            } else if (this.aiB.bpc()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aiB.bpj());
            createFromThreadCfg.setSmartFrsPosition(this.aiB.bpp());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.iyu) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(cb cbVar) {
        this.aiB = cbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void css() {
        this.iyF.removeMessages(202);
        if (this.acZ.getCurrentPosition() > 0) {
            v(false, 3);
            this.iyF.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.iyF.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cst() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.iyF.removeMessages(203);
        int currentPosition = this.acZ.getCurrentPosition();
        if (currentPosition != this.iyy) {
            this.iyy = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.iyF.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fVx != null && this.fVw != null && this.fVB != null && this.fVA != null && this.fVz != null && this.fVy != null) {
            if (z || this.fVD != i) {
                this.fVD = i;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVH);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVG);
                if (i == 2) {
                    this.fVx.setVisibility(8);
                    this.cjy.cancel();
                    this.fVw.clearAnimation();
                    this.fVw.setVisibility(0);
                    this.fVB.setVisibility(0);
                    this.iAh.setVisibility(0);
                    this.fVA.startLoading();
                    this.fVz.setVisibility(8);
                    this.fVy.setVisibility(8);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fVH, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fVx.setVisibility(8);
                    this.fVw.startAnimation(this.cjy);
                    this.fVB.setVisibility(8);
                    this.iAh.setVisibility(8);
                    this.fVA.dAq();
                    this.fVz.setVisibility(8);
                    this.fVy.setVisibility(8);
                    if (this.aiB != null && this.aiB.boj() != null) {
                        this.aiB.boj().video_length.intValue();
                        this.aiB.boj().video_duration.intValue();
                        this.aiB.getTid();
                    }
                } else if (i == 4) {
                    this.fVx.setVisibility(8);
                    this.fVw.startAnimation(this.cjy);
                    this.fVB.setVisibility(8);
                    this.fVA.dAr();
                    this.fVz.setVisibility(0);
                    this.fVy.setVisibility(0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.fVG, 2000L);
                } else {
                    this.fVx.setVisibility(0);
                    this.iAh.setVisibility(0);
                    this.cjy.cancel();
                    this.fVw.clearAnimation();
                    this.fVw.setVisibility(0);
                    this.fVB.setVisibility(0);
                    this.fVA.dAr();
                    this.fVz.setVisibility(8);
                    this.fVy.setVisibility(8);
                }
            }
        }
    }

    private void ab(final cb cbVar) {
        if (this.iAL != null) {
            if (cbVar == null) {
                this.iAL.setVisibility(8);
            } else if (!StringUtils.isNull(cbVar.eUE)) {
                if (this.juC != null && this.juC.cLI() && (this.iAL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iAL.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eWx.getContext(), R.dimen.tbds106);
                    this.iAL.setLayoutParams(layoutParams);
                }
                this.iAL.setVisibility(0);
                this.iAL.setImageDrawable(null);
                this.iAL.startLoad(cbVar.eUE, 10, false);
                this.iAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eWx != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", cbVar.eUF, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.iAL.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aiB == null || this.aiB.bnS() == null) {
            this.hpc.setVisibility(8);
            return;
        }
        this.hpc.setVisibility(0);
        this.hpc.setOnClickListener(this);
        csv();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eTW)) {
            this.aiB.dD(this.mUrl, this.eTW);
        }
        this.aiB.y(false, true);
        SpannableStringBuilder boB = this.aiB.boB();
        if (this.aiB.boH() && !StringUtils.isNull(this.aiB.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.brR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aiB.getTid();
            boB.append((CharSequence) this.aiB.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(boB));
        this.mTextTitle.setText(boB);
        this.juC.aB(this.aiB);
        ab(this.aiB);
        this.hpd.setData(this.aiB);
        if (this.hpd.getHeaderImg() != null) {
            if (this.hpd.getIsSimpleThread()) {
                this.hpd.getHeaderImg().setVisibility(8);
                this.iyv.setVisibility(8);
            } else if (this.aiB.bnS() == null || this.aiB.bnS().getPendantData() == null || StringUtils.isNull(this.aiB.bnS().getPendantData().getImgUrl())) {
                this.iyv.setVisibility(8);
                this.hpd.getHeaderImg().setVisibility(0);
                this.hpd.getHeaderImg().setData(this.aiB);
            } else {
                this.hpd.getHeaderImg().setVisibility(4);
                this.iyv.setVisibility(0);
                this.iyv.setData(this.aiB);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpe.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.hpe.setLayoutParams(layoutParams);
        this.hpd.setUserAfterClickListener(this.alB);
        vb(sY(1));
        this.fVv.setText(au.stringForVideoTime(this.aiB.boj().video_duration.intValue() * 1000));
        this.fVC.setText(String.format(this.eWx.getResources().getString(R.string.play_count), au.numFormatOverWan(this.aiB.boj().play_count.intValue())));
        this.iyu.setData(this.aiB.bpx());
        this.iyu.onChangeSkinType();
        if (com.baidu.tieba.card.m.IX(this.aiB.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            com.baidu.tieba.card.m.a(this.iyu.getGodReplyContent(), this.aiB.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.aiB == null || this.aiB.boj() == null) {
            z = false;
        } else {
            z = this.aiB.boj().is_vertical.intValue() == 1;
        }
        if (z) {
            this.iyE.setVisibility(0);
        } else {
            this.iyE.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) && this.hpe.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aiB.bpF() || this.aiB.bpG() || this.aiB.bpH()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csu() {
        this.iyF.removeMessages(202);
        this.iyF.removeMessages(203);
    }

    private void bHn() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVG);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVH);
    }

    private void csv() {
        bHn();
        csu();
        if (this.fVw != null && this.fVu != null && this.acZ != null) {
            if (k.bkV().isShowImages() && this.aiB != null && this.aiB.boj() != null) {
                this.fVu.setVisibility(0);
                this.fVw.setPlaceHolder(3);
                this.fVw.startLoad(this.aiB.boj().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aiB.boj().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new ar("c12026").dR("tid", this.aiB.getId()));
                }
                this.acZ.setThreadDataForStatistic(this.aiB);
                return;
            }
            this.fVu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.hpc, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fVx, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fVy, R.color.CAM_X0101);
            ap.setViewTextColor(this.fVv, R.color.CAM_X0101);
            ap.setViewTextColor(this.fVC, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fVz, R.color.common_color_10014);
            ap.setBackgroundColor(this.ghb, R.color.CAM_X0204);
            if (this.fVy != null) {
                this.fVy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.hpQ != null && this.hpQ.getVisibility() == 0) {
                this.hpQ.onChangeSkinType();
            }
            this.hpe.onChangeSkinType();
            this.mSkinType = i;
            this.hpd.onChangeSkinType();
            if (this.iyv != null && this.iyv.getHeadView() != null && (this.iyv.getHeadView() instanceof TbImageView)) {
                this.iyv.getHeadView().setPlaceHolder(1);
            }
            this.fVw.setPlaceHolder(3);
            this.juC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
        this.currentPageType = i;
        if (this.hpe != null) {
            this.hpe.flV = i;
            this.hpe.setFrom(2);
        }
        if (this.hpd != null) {
            this.hpd.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.iyz;
    }

    public boolean isPlaying() {
        if (this.acZ == null) {
            return false;
        }
        return this.acZ.isPlaying();
    }

    public void startPlay() {
        if (!this.iyz && this.aiB != null && this.aiB.boj() != null && this.acZ != null) {
            this.acZ.stopPlayback();
            if (ak.bFV()) {
                if (this.juD || com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new ar("c12619").dR("obj_locate", "frs").dR("tid", this.aiB.getId()));
                        this.mVideoUrl = this.aiB.boj().video_url;
                    }
                    this.iyz = true;
                    this.acZ.setVideoPath(this.mVideoUrl, this.aiB.getId());
                    if (this.gBV != null) {
                        this.gBV.start();
                    }
                    cso();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        if (this.aiB != null && this.aiB.boj() != null) {
            String str = this.aiB.bpc() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.juE == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.anU = this.aiB.getTid();
            oVar.fOD = this.aiB.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.aiB.mRecomSource;
            oVar.mKD = this.aiB.mRecomAbTag;
            oVar.mKz = this.aiB.mRecomAbTag;
            oVar.mKA = this.aiB.mRecomWeight;
            oVar.mKB = "";
            oVar.mKE = this.aiB.boj().video_md5;
            h.a(this.aiB.boj().video_md5, "", "1", oVar, this.acZ.getPcdnState());
        }
    }

    public void stopPlay() {
        bHn();
        csu();
        v(true, 1);
        if (this.acZ != null) {
            this.acZ.stopPlayback();
            if (this.gBV != null) {
                this.gBV.stop();
            }
        }
        this.iyz = false;
    }

    public View getVideoContainer() {
        return this.fVu;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.acZ == null) {
            return 0;
        }
        return this.acZ.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.acZ != null) {
            this.acZ.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hpe != null && this.hpd != null) {
            this.hpd.setPageUniqueId(bdUniqueId);
        }
    }

    public void vb(int i) {
        if (this.aiB != null) {
            if (i == 1) {
                this.hpe.setVisibility(8);
                this.hpQ.setData(this.aiB);
                this.hpf.setVisibility(8);
                return;
            }
            this.hpe.setData(this.aiB);
            this.hpf.setVisibility(8);
            this.hpQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public int sY(int i) {
        return com.baidu.tieba.a.d.bKY().aB(this.ajx, i);
    }
}
