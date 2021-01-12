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
    private TbCyberVideoView abI;
    private bz ahu;
    private String air;
    private final View.OnClickListener akt;
    private Animation cdP;
    private String eQj;
    private TbPageContext<?> eSJ;
    private CyberPlayerManager.OnPreparedListener eyt;
    private CyberPlayerManager.OnErrorListener eyu;
    private CyberPlayerManager.OnCompletionListener eyv;
    private CyberPlayerManager.OnInfoListener eyw;
    public FrameLayout fRF;
    private TextView fRG;
    private TbImageView fRH;
    private ImageView fRI;
    private TextView fRJ;
    private View fRK;
    private m fRL;
    private View fRM;
    private TextView fRN;
    private int fRO;
    private TbImageView.b fRP;
    private ViewTreeObserver.OnGlobalLayoutListener fRQ;
    private Runnable fRR;
    private Runnable fRS;
    private TbCyberVideoView.a fRT;
    private final View.OnClickListener fih;
    private View gde;
    public LinearLayout gln;
    private f gxo;
    private RelativeLayout hiR;
    public ThreadUserInfoLayout hiS;
    public ThreadCommentAndPraiseInfoLayout hiT;
    public View hiU;
    protected ThreadSourceShareAndPraiseLayout hjF;
    public ThreadSkinView hjQ;
    private ThreadGodReplyLayout iqT;
    private HeadPendantClickableView iqU;
    private int iqX;
    private boolean iqY;
    private TextView ird;
    private Handler ire;
    private VideoLoadingProgressView.a irf;
    private f.a irk;
    private Animation.AnimationListener irl;
    private LinearLayout isC;
    private TbImageView ite;
    public TextView jmX;
    public LinearLayout jmY;
    private i jmZ;
    public boolean jna;
    public int jnb;
    private View.OnClickListener jnc;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void cqQ() {
        if (this.abI != null && this.iqY) {
            try {
                this.abI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ire.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.iqX = 0;
        this.fRO = 1;
        this.iqY = false;
        this.ire = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.cqV();
                        return;
                    case 203:
                        a.this.cqW();
                        return;
                    default:
                        return;
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (a.this.abI != null) {
                    a.this.abI.setVolume(0.0f, 0.0f);
                }
                a.this.cqQ();
            }
        };
        this.eyw = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                if (i == 3) {
                    a.this.v(false, 3);
                }
                return false;
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                a.this.abI.start();
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                a.this.cqX();
                a.this.v(true, 4);
                a.this.iqY = false;
                return true;
            }
        };
        this.irf = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.cqQ();
            }
        };
        this.fRP = new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && a.this.fRH != null) {
                    a.this.fRH.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.fRQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.fRF != null && a.this.fRF.getLayoutParams() != null && a.this.fRF.getVisibility() != 8) {
                    a.this.fRF.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.fRF.getLayoutParams();
                    if (a.this.fRF.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.fRF.getWidth() * 0.5625d);
                        a.this.fRF.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fRR = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.abI != null && !a.this.abI.isPlaying()) {
                    a.this.v(true, 1);
                }
            }
        };
        this.fRS = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.cqX();
                a.this.v(true, 4);
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.jnc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ahu != null && !StringUtils.isNull(a.this.ahu.bnB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.eSJ.getPageActivity()).createNormalCfg(a.this.ahu.bnB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.fih != null) {
                        a.this.fih.onClick(view);
                    }
                }
            }
        };
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cqL() != null) {
                    a.this.cqL().a(view, a.this.ahu);
                }
            }
        };
        this.fih = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ahu != null && a.this.cqL() != null) {
                    a.this.cqL().a(view, a.this.ahu);
                }
            }
        };
        this.irk = new f.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.f.a
            public void rF() {
                a.this.cqR();
            }
        };
        this.irl = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.fRO == 3 && a.this.fRH != null) {
                    a.this.fRH.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.eSJ = tbPageContext;
        View view = getView();
        this.gde = view.findViewById(R.id.divider_line);
        this.hiR = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ite = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.jmY = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hiR.setOnClickListener(this);
        this.iqU = (HeadPendantClickableView) this.hiR.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.iqU.getHeadView() != null) {
            this.iqU.getHeadView().setIsRound(true);
            this.iqU.getHeadView().setDrawBorder(false);
            this.iqU.getHeadView().setDefaultResource(17170445);
            this.iqU.getHeadView().setRadius(l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds70));
        }
        this.iqU.setHasPendantStyle();
        if (this.iqU.getPendantView() != null) {
            this.iqU.getPendantView().setIsRound(true);
            this.iqU.getPendantView().setDrawBorder(false);
        }
        this.jmX = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.jmX.setVisibility(8);
        this.jmX.setOnClickListener(this.jnc);
        this.fRL = new m((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.fRL.setLoadingAnimationListener(this.irf);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.hiT.setForumAfterClickListener(this.fih);
        this.hiS = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.hiS.setFrom(3);
        this.hiU = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.hiT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hiT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hiT.setLayoutParams(layoutParams);
        }
        this.hiT.setOnClickListener(this);
        this.hiT.setReplyTimeVisible(false);
        this.hiT.setShowPraiseNum(true);
        this.hiT.setNeedAddPraiseIcon(true);
        this.hiT.setNeedAddReplyIcon(true);
        this.hiT.setIsBarViewVisible(false);
        this.hiT.setShareVisible(true);
        this.hiT.setShareReportFrom(1);
        this.hiT.setStType("frs_page");
        this.hiT.setFrom(2);
        this.hiT.fie = 3;
        this.hjF = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.hjF.fjb.setOnClickListener(this);
        this.hjF.setFrom(2);
        this.hjF.setShareReportFrom(1);
        this.hjF.setSourceFromForPb(3);
        this.hjF.setStType("frs_page");
        this.hjF.setHideBarName(true);
        this.fRF = (FrameLayout) view.findViewById(R.id.frame_video);
        this.fRF.setOnClickListener(this);
        this.fRF.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.fRF != null) {
                    a.this.fRF.getViewTreeObserver().addOnGlobalLayoutListener(a.this.fRQ);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.fRF != null) {
                    a.this.fRF.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.fRQ);
                }
            }
        });
        this.fRH = (TbImageView) view.findViewById(R.id.image_video);
        this.fRH.setPageId(getTag());
        this.fRH.setDrawCorner(true);
        this.fRH.setPlaceHolder(3);
        this.fRH.setEvent(this.fRP);
        this.fRH.setGifIconSupport(false);
        this.fRI = (ImageView) view.findViewById(R.id.image_video_play);
        this.abI = new TbCyberVideoView(getContext());
        this.abI.setStageType("2003");
        bGO();
        this.abI.setContinuePlayEnable(true);
        this.abI.setOnPreparedListener(this.eyt);
        this.abI.setOnCompletionListener(this.eyv);
        this.abI.setOnErrorListener(this.eyu);
        this.abI.setOnInfoListener(this.eyw);
        this.abI.setOnSurfaceDestroyedListener(this.fRT);
        this.gxo = new f();
        this.gxo.setPlayer(this.abI);
        this.gxo.a(this.irk);
        this.fRM = view.findViewById(R.id.auto_video_black_mask);
        this.fRJ = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.fRK = view.findViewById(R.id.auto_video_error_background);
        this.gln = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hjQ = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.cdP = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.fade_out_video_cover);
        this.cdP.setAnimationListener(this.irl);
        this.fRG = (TextView) view.findViewById(R.id.text_video_duration);
        this.fRN = (TextView) view.findViewById(R.id.text_video_play_count);
        this.isC = (LinearLayout) view.findViewById(R.id.duration_container);
        this.jmZ = new i(tbPageContext, this.hiR);
        this.jmZ.setUniqueId(getTag());
        this.iqT = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.iqT.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.hiT != null) {
                    a.this.hiT.changeSelectStatus();
                }
            }
        });
        this.hiT.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void kb(boolean z) {
                if (a.this.mMaskView != null) {
                    ao.setBackgroundColor(a.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
                }
            }
        });
        this.ird = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    private void bGO() {
        if (this.abI != null && this.abI.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fRF.addView(this.abI.getView(), 0);
            this.abI.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.hiR || view == this.hiT.getCommentNumView() || view == this.jmY) {
            cO(this.hiR);
        } else if (view == this.fRF) {
            if (this.ahu != null && this.ahu.bnO() != null) {
                z = this.ahu.bnO().is_vertical.intValue() == 1;
            }
            if (z) {
                cM(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                cY(this.fRF);
            } else {
                cO(this.fRF);
            }
        } else if (view == this.iqT) {
            cO(this.iqT);
        }
        if (this.ahu != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ahu));
        }
    }

    private void cM(View view) {
        if (cqL() != null) {
            cqL().a(view, this.ahu);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.eSJ.getPageActivity(), R.string.no_network_guide);
        } else {
            cqS();
        }
    }

    private void cqS() {
        if (this.ahu != null) {
            String str = "frs";
            if (this.jnb == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ahu);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.ahu.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.ahu.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void cY(View view) {
        if (this.ahu != null) {
            aq aqVar = new aq("c11100");
            aqVar.dW("tid", this.ahu.getId());
            aqVar.dW("fid", this.ahu.getFid() + "");
            TiebaStatic.log(aqVar);
        }
        if (cqL() != null) {
            cqL().a(view, this.ahu);
        }
        if (view == this.fRF) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(this.eSJ.getPageActivity(), R.string.no_network_guide);
            } else {
                cqT();
            }
        }
    }

    private void cqT() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ahu);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.gln.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.gln.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.jnb == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.eSJ.getPageActivity(), str, this.ahu.getTid(), com.baidu.tieba.card.m.bnj(), "", videoSerializeVideoThreadInfo);
        if (this.ahu.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.ahu.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void cO(View view) {
        String str;
        String str2;
        if (this.ahu != null) {
            if (this.ahu.boI()) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).dW("fid", String.valueOf(this.ahu.getFid())).an("obj_type", 2));
            } else {
                aq aqVar = new aq("c11100");
                aqVar.dW("tid", this.ahu.getId());
                aqVar.dW("fid", this.ahu.getFid() + "");
                TiebaStatic.log(aqVar);
            }
            if (this.ahu.bnx() != null && this.ahu.bnx().getGodUserData() != null && this.ahu.bnx().getGodUserData().getType() == 2) {
                TiebaStatic.log(new aq("c10806").an("obj_locate", 3).dW("tid", this.ahu.getId()));
            }
        }
        if (cqL() != null) {
            cqL().a(view, this.ahu);
        }
        if (this.ahu != null) {
            com.baidu.tieba.card.m.Ic(this.ahu.getId());
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            z.Dy(this.ahu.getId());
            String valueOf = String.valueOf(this.ahu.getFid());
            if (this.ahu.eRb == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.ahu.eRb.id;
                str2 = valueOf;
            }
            if (this.ahu.bnT() > 0 && com.baidu.tieba.tbadkCore.util.e.dMC()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.eSJ.getPageActivity()).createHistoryCfg(this.ahu.getTid(), String.valueOf(this.ahu.bnT()), false, true, "frs_page");
                String str3 = "frs";
                if (this.jnb == 501) {
                    str3 = "frs_tab";
                } else if (this.ahu.boI()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.ahu.boP());
                createHistoryCfg.setSmartFrsPosition(this.ahu.boV());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.iqT) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.eSJ.getPageActivity()).createFromThreadCfg(this.ahu, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.jnb == 501) {
                str4 = "frs_tab";
            } else if (this.ahu.boI()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.ahu.boP());
            createFromThreadCfg.setSmartFrsPosition(this.ahu.boV());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.iqT) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        this.ahu = bzVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqV() {
        this.ire.removeMessages(202);
        if (this.abI.getCurrentPosition() > 0) {
            v(false, 3);
            this.ire.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
            return;
        }
        this.ire.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqW() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ire.removeMessages(203);
        int currentPosition = this.abI.getCurrentPosition();
        if (currentPosition != this.iqX) {
            this.iqX = currentPosition;
            v(false, 3);
        } else {
            v(false, 2);
        }
        this.ire.sendEmptyMessageDelayed(203, IMConnection.RETRY_DELAY_TIMES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, int i) {
        if (this.fRI != null && this.fRH != null && this.fRM != null && this.fRL != null && this.fRK != null && this.fRJ != null) {
            if (z || this.fRO != i) {
                this.fRO = i;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRS);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRR);
                if (i == 2) {
                    this.fRI.setVisibility(8);
                    this.cdP.cancel();
                    this.fRH.clearAnimation();
                    this.fRH.setVisibility(0);
                    this.fRM.setVisibility(0);
                    this.isC.setVisibility(0);
                    this.fRL.startLoading();
                    this.fRK.setVisibility(8);
                    this.fRJ.setVisibility(8);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fRS, AppStatusRules.DEFAULT_GRANULARITY);
                } else if (i == 3) {
                    this.fRI.setVisibility(8);
                    this.fRH.startAnimation(this.cdP);
                    this.fRM.setVisibility(8);
                    this.isC.setVisibility(8);
                    this.fRL.dxT();
                    this.fRK.setVisibility(8);
                    this.fRJ.setVisibility(8);
                    if (this.ahu != null && this.ahu.bnO() != null) {
                        this.ahu.bnO().video_length.intValue();
                        this.ahu.bnO().video_duration.intValue();
                        this.ahu.getTid();
                    }
                } else if (i == 4) {
                    this.fRI.setVisibility(8);
                    this.fRH.startAnimation(this.cdP);
                    this.fRM.setVisibility(8);
                    this.fRL.dxU();
                    this.fRK.setVisibility(0);
                    this.fRJ.setVisibility(0);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.fRR, 2000L);
                } else {
                    this.fRI.setVisibility(0);
                    this.isC.setVisibility(0);
                    this.cdP.cancel();
                    this.fRH.clearAnimation();
                    this.fRH.setVisibility(0);
                    this.fRM.setVisibility(0);
                    this.fRL.dxU();
                    this.fRK.setVisibility(8);
                    this.fRJ.setVisibility(8);
                }
            }
        }
    }

    private void aa(final bz bzVar) {
        if (this.ite != null) {
            if (bzVar == null) {
                this.ite.setVisibility(8);
            } else if (!StringUtils.isNull(bzVar.eQR)) {
                if (this.jmZ != null && this.jmZ.cKh() && (this.ite.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ite.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.eSJ.getContext(), R.dimen.tbds106);
                    this.ite.setLayoutParams(layoutParams);
                }
                this.ite.setVisibility(0);
                this.ite.setImageDrawable(null);
                this.ite.startLoad(bzVar.eQR, 10, false);
                this.ite.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.eSJ != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bzVar.eQS, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ite.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.ahu == null || this.ahu.bnx() == null) {
            this.hiR.setVisibility(8);
            return;
        }
        this.hiR.setVisibility(0);
        this.hiR.setOnClickListener(this);
        cqY();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eQj)) {
            this.ahu.dJ(this.mUrl, this.eQj);
        }
        this.ahu.z(false, true);
        SpannableStringBuilder bog = this.ahu.bog();
        if (this.ahu.bon() && !StringUtils.isNull(this.ahu.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.brx().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.ahu.getTid();
            bog.append((CharSequence) this.ahu.a(new com.baidu.tbadk.widget.richText.f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new aq("c12841").dW("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(bog));
        this.mTextTitle.setText(bog);
        this.jmZ.aA(this.ahu);
        aa(this.ahu);
        this.hiS.setData(this.ahu);
        if (this.hiS.getHeaderImg() != null) {
            if (this.hiS.getIsSimpleThread()) {
                this.hiS.getHeaderImg().setVisibility(8);
                this.iqU.setVisibility(8);
            } else if (this.ahu.bnx() == null || this.ahu.bnx().getPendantData() == null || StringUtils.isNull(this.ahu.bnx().getPendantData().getImgUrl())) {
                this.iqU.setVisibility(8);
                this.hiS.getHeaderImg().setVisibility(0);
                this.hiS.getHeaderImg().setData(this.ahu);
            } else {
                this.hiS.getHeaderImg().setVisibility(4);
                this.iqU.setVisibility(0);
                this.iqU.setData(this.ahu);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hiT.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.hiT.setLayoutParams(layoutParams);
        this.hiS.setUserAfterClickListener(this.akt);
        uP(sR(1));
        this.fRG.setText(at.stringForVideoTime(this.ahu.bnO().video_duration.intValue() * 1000));
        this.fRN.setText(String.format(this.eSJ.getResources().getString(R.string.play_count), at.numFormatOverWan(this.ahu.bnO().play_count.intValue())));
        this.iqT.setData(this.ahu.bpd());
        this.iqT.onChangeSkinType();
        if (com.baidu.tieba.card.m.Id(this.ahu.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109, 1);
            com.baidu.tieba.card.m.a(this.iqT.getGodReplyContent(), this.ahu.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105, 1);
        }
        if (this.ahu == null || this.ahu.bnO() == null) {
            z = false;
        } else {
            z = this.ahu.bnO().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ird.setVisibility(0);
        } else {
            this.ird.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) && this.hiT.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.ahu.bpl() || this.ahu.bpm() || this.ahu.bpn()) {
                ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqX() {
        this.ire.removeMessages(202);
        this.ire.removeMessages(203);
    }

    private void bGP() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRR);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRS);
    }

    private void cqY() {
        bGP();
        cqX();
        if (this.fRH != null && this.fRF != null && this.abI != null) {
            if (k.bkB().isShowImages() && this.ahu != null && this.ahu.bnO() != null) {
                this.fRF.setVisibility(0);
                this.fRH.setPlaceHolder(3);
                this.fRH.startLoad(this.ahu.bnO().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.ahu.bnO().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                    TiebaStatic.log(new aq("c12026").dW("tid", this.ahu.getId()));
                }
                this.abI.setThreadDataForStatistic(this.ahu);
                return;
            }
            this.fRF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hiR, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.fRI, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.fRJ, R.color.CAM_X0101);
            ao.setViewTextColor(this.fRG, R.color.CAM_X0101);
            ao.setViewTextColor(this.fRN, R.color.CAM_X0101);
            ao.setBackgroundColor(this.fRK, R.color.common_color_10014);
            ao.setBackgroundColor(this.gde, R.color.CAM_X0204);
            if (this.fRJ != null) {
                this.fRJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.hjF != null && this.hjF.getVisibility() == 0) {
                this.hjF.onChangeSkinType();
            }
            this.hiT.onChangeSkinType();
            this.mSkinType = i;
            this.hiS.onChangeSkinType();
            if (this.iqU != null && this.iqU.getHeadView() != null && (this.iqU.getHeadView() instanceof TbImageView)) {
                this.iqU.getHeadView().setPlaceHolder(1);
            }
            this.fRH.setPlaceHolder(3);
            this.jmZ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.currentPageType = i;
        if (this.hiT != null) {
            this.hiT.fie = i;
            this.hiT.setFrom(2);
        }
        if (this.hiS != null) {
            this.hiS.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.iqY;
    }

    public boolean isPlaying() {
        if (this.abI == null) {
            return false;
        }
        return this.abI.isPlaying();
    }

    public void startPlay() {
        if (!this.iqY && this.ahu != null && this.ahu.bnO() != null && this.abI != null) {
            this.abI.stopPlayback();
            if (ah.bFx()) {
                if (this.jna || com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    v(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new aq("c12619").dW("obj_locate", "frs").dW("tid", this.ahu.getId()));
                        this.mVideoUrl = this.ahu.bnO().video_url;
                    }
                    this.iqY = true;
                    this.abI.setVideoPath(this.mVideoUrl, this.ahu.getId());
                    if (this.gxo != null) {
                        this.gxo.start();
                    }
                    cqR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        if (this.ahu != null && this.ahu.bnO() != null) {
            String str = this.ahu.boI() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.jnb == 501) {
                str = "frs_tab";
            }
            o oVar = new o();
            oVar.mLocate = str;
            oVar.amM = this.ahu.getTid();
            oVar.fKR = this.ahu.getFid() + "";
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mSource = this.ahu.mRecomSource;
            oVar.mzb = this.ahu.mRecomAbTag;
            oVar.myX = this.ahu.mRecomAbTag;
            oVar.myY = this.ahu.mRecomWeight;
            oVar.myZ = "";
            oVar.mzc = this.ahu.bnO().video_md5;
            h.a(this.ahu.bnO().video_md5, "", "1", oVar, this.abI.getPcdnState());
        }
    }

    public void stopPlay() {
        bGP();
        cqX();
        v(true, 1);
        if (this.abI != null) {
            this.abI.stopPlayback();
            if (this.gxo != null) {
                this.gxo.stop();
            }
        }
        this.iqY = false;
    }

    public View getVideoContainer() {
        return this.fRF;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abI == null) {
            return 0;
        }
        return this.abI.getCurrentPosition();
    }

    public void setVideoStatsData(o oVar) {
        if (this.abI != null) {
            this.abI.setVideoStatData(oVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hiT != null && this.hiS != null) {
            this.hiS.setPageUniqueId(bdUniqueId);
        }
    }

    public void uP(int i) {
        if (this.ahu != null) {
            if (i == 1) {
                this.hiT.setVisibility(8);
                this.hjF.setData(this.ahu);
                this.hiU.setVisibility(8);
                return;
            }
            this.hiT.setData(this.ahu);
            this.hiU.setVisibility(8);
            this.hjF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public int sR(int i) {
        return com.baidu.tieba.a.d.bKv().az(this.air, i);
    }
}
