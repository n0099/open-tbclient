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
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private QuickVideoView Di;
    private bj Ki;
    private String La;
    private final View.OnClickListener MT;
    private Animation aGA;
    private View bZT;
    private String cOW;
    private TbPageContext<?> cQU;
    public FrameLayout dHG;
    private TextView dHH;
    private TbImageView dHI;
    private ImageView dHJ;
    private TextView dHK;
    private View dHL;
    private w dHM;
    private View dHN;
    private TextView dHO;
    private int dHP;
    private TbImageView.a dHQ;
    private g.b dHR;
    private ViewTreeObserver.OnGlobalLayoutListener dHS;
    private Runnable dHT;
    private Runnable dHU;
    private QuickVideoView.b dHV;
    private g.a dQN;
    private g.f dQO;
    private g.e dQQ;
    private final View.OnClickListener ddt;
    protected ThreadSourceShareAndPraiseLayout eIU;
    private RelativeLayout eIf;
    public ThreadUserInfoLayout eIg;
    public ThreadCommentAndPraiseInfoLayout eIh;
    public View eIi;
    public ThreadSkinView eJf;
    private g eaB;
    public LinearLayout ect;
    private j egJ;
    private ThreadGodReplyLayout fDF;
    private HeadPendantClickableView fDG;
    private int fDK;
    private boolean fDL;
    private TextView fDQ;
    private Handler fDR;
    private VideoLoadingProgressView.a fDS;
    private j.a fDX;
    private Animation.AnimationListener fDY;
    private TbImageView fFO;
    private LinearLayout fFn;
    private n fGA;
    public TextView gsW;
    public LinearLayout gsX;
    private i gsY;
    public boolean gsZ;
    public int gta;
    private View.OnClickListener gtb;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bsf() {
        if (this.eaB != null && this.fDL) {
            try {
                this.Di.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fDR.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fDK = 0;
        this.dHP = 1;
        this.fDL = false;
        this.fDR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bsk();
                        return;
                    case 203:
                        a.this.bsl();
                        return;
                    default:
                        return;
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.eaB = gVar;
                if (a.this.eaB != null) {
                    a.this.eaB.setVolume(0.0f, 0.0f);
                }
                a.this.bsf();
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.n(false, 3);
                }
                return false;
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Di.start();
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bsm();
                a.this.n(true, 4);
                a.this.fDL = false;
                return true;
            }
        };
        this.fDS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bsf();
            }
        };
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dHI != null) {
                    a.this.dHI.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dHS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.dHG != null && a.this.dHG.getLayoutParams() != null && a.this.dHG.getVisibility() != 8) {
                    a.this.dHG.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.dHG.getLayoutParams();
                    if (a.this.dHG.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.dHG.getWidth() * 0.5625d);
                        a.this.dHG.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dHT = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Di != null && !a.this.Di.isPlaying()) {
                    a.this.n(true, 1);
                }
            }
        };
        this.dHU = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bsm();
                a.this.n(true, 4);
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.gtb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Ki != null && !StringUtils.isNull(a.this.Ki.azJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cQU.getPageActivity()).createNormalCfg(a.this.Ki.azJ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.ddt != null) {
                        a.this.ddt.onClick(view);
                    }
                }
            }
        };
        this.MT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.brY() != null) {
                    a.this.brY().a(view, a.this.Ki);
                }
            }
        };
        this.ddt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Ki != null && a.this.brY() != null) {
                    a.this.brY().a(view, a.this.Ki);
                }
            }
        };
        this.fDX = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void lg() {
                a.this.bsg();
            }
        };
        this.fDY = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.dHP == 3 && a.this.dHI != null) {
                    a.this.dHI.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.cQU = tbPageContext;
        View view = getView();
        this.bZT = view.findViewById(R.id.divider_line);
        this.eIf = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fFO = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.gsX = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eIf.setOnClickListener(this);
        this.fDG = (HeadPendantClickableView) this.eIf.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.fDG.getHeadView() != null) {
            this.fDG.getHeadView().setIsRound(true);
            this.fDG.getHeadView().setDrawBorder(false);
            this.fDG.getHeadView().setDefaultResource(17170445);
            this.fDG.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDG.getHeadView().setRadius(l.getDimens(this.cQU.getPageActivity(), R.dimen.ds70));
        }
        this.fDG.setHasPendantStyle();
        if (this.fDG.getPendantView() != null) {
            this.fDG.getPendantView().setIsRound(true);
            this.fDG.getPendantView().setDrawBorder(false);
        }
        this.gsW = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.gsW.setVisibility(8);
        this.gsW.setOnClickListener(this.gtb);
        this.dHM = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.dHM.setLoadingAnimationListener(this.fDS);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.eIh.setForumAfterClickListener(this.ddt);
        this.eIg = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.eIg.setFrom(3);
        this.eIi = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.eIh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIh.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eIh.setLayoutParams(layoutParams);
        }
        this.eIh.setOnClickListener(this);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setIsBarViewVisible(false);
        this.eIh.setShareVisible(true);
        this.eIh.setShareReportFrom(1);
        this.eIh.setStType("frs_page");
        this.eIh.setFrom(2);
        this.eIh.ddq = 3;
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.eIU.dep.setOnClickListener(this);
        this.eIU.setFrom(2);
        this.eIU.setShareReportFrom(1);
        this.eIU.setSourceFromForPb(3);
        this.eIU.setStType("frs_page");
        this.eIU.setHideBarName(true);
        this.dHG = (FrameLayout) view.findViewById(R.id.frame_video);
        this.dHG.setOnClickListener(this);
        this.dHG.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.dHG != null) {
                    a.this.dHG.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dHS);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.dHG != null) {
                    a.this.dHG.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dHS);
                }
            }
        });
        this.dHI = (TbImageView) view.findViewById(R.id.image_video);
        this.dHI.setPageId(getTag());
        this.dHI.setDefaultErrorResource(0);
        this.dHI.setDrawCorner(true);
        this.dHI.setPlaceHolder(3);
        this.dHI.setEvent(this.dHQ);
        this.dHI.setGifIconSupport(false);
        this.dHJ = (ImageView) view.findViewById(R.id.image_video_play);
        this.Di = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.fGA = new n(this.cQU.getPageActivity());
        this.Di.setPlayerReuseEnable(true);
        this.Di.setContinuePlayEnable(true);
        this.Di.setBusiness(this.fGA);
        this.Di.setOnPreparedListener(this.dQO);
        this.Di.setOnCompletionListener(this.dQN);
        this.Di.setOnErrorListener(this.dHR);
        this.Di.setOnOutInfoListener(this.dQQ);
        this.Di.setOnSurfaceDestroyedListener(this.dHV);
        this.Di.setPageTypeForPerfStat("frs");
        this.egJ = new j();
        this.egJ.setPlayer(this.Di);
        this.egJ.a(this.fDX);
        this.dHN = view.findViewById(R.id.auto_video_black_mask);
        this.dHK = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.dHL = view.findViewById(R.id.auto_video_error_background);
        this.ect = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.eJf = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.aGA = AnimationUtils.loadAnimation(this.cQU.getPageActivity(), R.anim.fade_out_video_cover);
        this.aGA.setAnimationListener(this.fDY);
        this.dHH = (TextView) view.findViewById(R.id.text_video_duration);
        this.dHO = (TextView) view.findViewById(R.id.text_video_play_count);
        this.fFn = (LinearLayout) view.findViewById(R.id.duration_container);
        this.gsY = new i(tbPageContext, this.eIf);
        this.gsY.setUniqueId(getTag());
        this.fDF = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.fDF.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.eIh != null) {
                    a.this.eIh.changeSelectStatus();
                }
            }
        });
        this.eIh.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fH(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.fDQ = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.eIf || view == this.eIh.getCommentNumView() || view == this.gsX) {
            bC(this.eIf);
        } else if (view == this.dHG) {
            if (this.Ki != null && this.Ki.azV() != null) {
                z = this.Ki.azV().is_vertical.intValue() == 1;
            }
            if (z) {
                bA(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bL(this.dHG);
                } else {
                    bC(this.dHG);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bL(this.dHG);
            } else {
                bC(this.dHG);
            }
        } else if (view == this.fDF) {
            bC(this.fDF);
        }
        if (this.Ki != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.Ki));
        }
    }

    private void bA(View view) {
        if (brY() != null) {
            brY().a(view, this.Ki);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.cQU.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bsh();
        }
    }

    private void bsh() {
        if (this.Ki != null) {
            String str = "frs";
            if (this.gta == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.Ki);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.Ki.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.Ki.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bL(View view) {
        if (this.Ki != null) {
            an anVar = new an("c11100");
            anVar.cp("tid", this.Ki.getId());
            anVar.cp("fid", this.Ki.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (brY() != null) {
            brY().a(view, this.Ki);
        }
        if (view == this.dHG) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bsi();
            }
        }
    }

    private void bsi() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.Ki);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.ect.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.ect.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.gta == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.cQU.getPageActivity(), str, this.Ki.getTid(), com.baidu.tieba.card.l.azq(), "", videoSerializeVideoThreadInfo);
        if (this.Ki.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.Ki.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bC(View view) {
        String str;
        String str2;
        if (this.Ki != null) {
            if (this.Ki.aAL()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cp("fid", String.valueOf(this.Ki.getFid())).Z("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cp("tid", this.Ki.getId());
                anVar.cp("fid", this.Ki.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.Ki.azE() != null && this.Ki.azE().getGodUserData() != null && this.Ki.azE().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").Z("obj_locate", 3).cp("tid", this.Ki.getId()));
            }
        }
        if (brY() != null) {
            brY().a(view, this.Ki);
        }
        if (this.Ki != null) {
            com.baidu.tieba.card.l.zs(this.Ki.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.vx(this.Ki.getId());
            String valueOf = String.valueOf(this.Ki.getFid());
            if (this.Ki.cPN == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.Ki.cPN.id;
                str2 = valueOf;
            }
            if (this.Ki.aAa() > 0 && com.baidu.tieba.tbadkCore.util.e.cJw()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.cQU.getPageActivity()).createHistoryCfg(this.Ki.getTid(), String.valueOf(this.Ki.aAa()), false, true, "frs_page");
                String str3 = "frs";
                if (this.gta == 501) {
                    str3 = "frs_tab";
                } else if (this.Ki.aAL()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.Ki.aAR());
                createHistoryCfg.setSmartFrsPosition(this.Ki.aAW());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.fDF) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.cQU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.cQU.getPageActivity()).createFromThreadCfg(this.Ki, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.gta == 501) {
                str4 = "frs_tab";
            } else if (this.Ki.aAL()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.Ki.aAR());
            createFromThreadCfg.setSmartFrsPosition(this.Ki.aAW());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.fDF) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.cQU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.Ki = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsk() {
        this.fDR.removeMessages(202);
        if (this.Di.getCurrentPosition() > 0) {
            n(false, 3);
            this.fDR.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.fDR.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsl() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.fDR.removeMessages(203);
        int currentPosition = this.Di.getCurrentPosition();
        if (currentPosition != this.fDK) {
            this.fDK = currentPosition;
            n(false, 3);
        } else {
            n(false, 2);
        }
        this.fDR.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, int i) {
        if (this.dHJ != null && this.dHI != null && this.dHN != null && this.dHM != null && this.dHL != null && this.dHK != null) {
            if (z || this.dHP != i) {
                this.dHP = i;
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHU);
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHT);
                if (i == 2) {
                    this.dHJ.setVisibility(8);
                    this.aGA.cancel();
                    this.dHI.clearAnimation();
                    this.dHI.setVisibility(0);
                    this.dHN.setVisibility(0);
                    this.fFn.setVisibility(0);
                    this.dHM.startLoading();
                    this.dHL.setVisibility(8);
                    this.dHK.setVisibility(8);
                    com.baidu.adp.lib.f.e.gy().postDelayed(this.dHU, 60000L);
                } else if (i == 3) {
                    this.dHJ.setVisibility(8);
                    this.dHI.startAnimation(this.aGA);
                    this.dHN.setVisibility(8);
                    this.fFn.setVisibility(8);
                    this.dHM.cwJ();
                    this.dHL.setVisibility(8);
                    this.dHK.setVisibility(8);
                    if (this.Ki != null && this.Ki.azV() != null) {
                        this.Ki.azV().video_length.intValue();
                        this.Ki.azV().video_duration.intValue();
                        this.Ki.getTid();
                    }
                } else if (i == 4) {
                    this.dHJ.setVisibility(8);
                    this.dHI.startAnimation(this.aGA);
                    this.dHN.setVisibility(8);
                    this.dHM.cwK();
                    this.dHL.setVisibility(0);
                    this.dHK.setVisibility(0);
                    com.baidu.adp.lib.f.e.gy().postDelayed(this.dHT, 2000L);
                } else {
                    this.dHJ.setVisibility(0);
                    this.fFn.setVisibility(0);
                    this.aGA.cancel();
                    this.dHI.clearAnimation();
                    this.dHI.setVisibility(0);
                    this.dHN.setVisibility(0);
                    this.dHM.cwK();
                    this.dHL.setVisibility(8);
                    this.dHK.setVisibility(8);
                }
            }
        }
    }

    private void V(final bj bjVar) {
        if (this.fFO != null) {
            if (bjVar == null) {
                this.fFO.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cPE)) {
                if (this.gsY != null && this.gsY.bIk() && (this.fFO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fFO.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.cQU.getContext(), R.dimen.tbds106);
                    this.fFO.setLayoutParams(layoutParams);
                }
                this.fFO.setVisibility(0);
                this.fFO.setImageDrawable(null);
                this.fFO.startLoad(bjVar.cPE, 10, false);
                this.fFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.cQU != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.cPF, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fFO.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.Ki == null || this.Ki.azE() == null) {
            this.eIf.setVisibility(8);
            return;
        }
        this.eIf.setVisibility(0);
        this.eIf.setOnClickListener(this);
        bsn();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cOW)) {
            this.Ki.cg(this.mUrl, this.cOW);
        }
        this.Ki.q(false, true);
        SpannableStringBuilder aAl = this.Ki.aAl();
        if (this.Ki.aAr() && !StringUtils.isNull(this.Ki.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.Ki.getTid();
            aAl.append((CharSequence) this.Ki.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cp("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new h(aAl));
        this.mTextTitle.setText(aAl);
        this.gsY.as(this.Ki);
        V(this.Ki);
        this.eIg.setData(this.Ki);
        if (this.eIg.getHeaderImg() != null) {
            if (this.eIg.getIsSimpleThread()) {
                this.eIg.getHeaderImg().setVisibility(8);
                this.fDG.setVisibility(8);
            } else if (this.Ki.azE() == null || this.Ki.azE().getPendantData() == null || StringUtils.isNull(this.Ki.azE().getPendantData().axX())) {
                this.fDG.setVisibility(8);
                this.eIg.getHeaderImg().setVisibility(0);
                this.eIg.getHeaderImg().setData(this.Ki);
            } else {
                this.eIg.getHeaderImg().setVisibility(4);
                this.fDG.setVisibility(0);
                this.fDG.setData(this.Ki);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIh.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.eIh.setLayoutParams(layoutParams);
        this.eIg.setUserAfterClickListener(this.MT);
        pp(nL(1));
        this.dHH.setText(aq.stringForVideoTime(this.Ki.azV().video_duration.intValue() * 1000));
        this.dHO.setText(String.format(this.cQU.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.Ki.azV().play_count.intValue())));
        this.fDF.setData(this.Ki.aBe());
        this.fDF.onChangeSkinType();
        if (com.baidu.tieba.card.l.zt(this.Ki.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.fDF.getGodReplyContent(), this.Ki.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.Ki == null || this.Ki.azV() == null) {
            z = false;
        } else {
            z = this.Ki.azV().is_vertical.intValue() == 1;
        }
        if (z) {
            this.fDQ.setVisibility(0);
        } else {
            this.fDQ.setVisibility(8);
        }
        if (this.eIh.isInFrsAllThread() && com.baidu.tieba.frs.a.bAp().bAq()) {
            this.mMaskView.setVisibility(0);
            if (this.Ki.aBn() || this.Ki.aBo()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        this.fDR.removeMessages(202);
        this.fDR.removeMessages(203);
    }

    private void aQQ() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHT);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHU);
    }

    private void bsn() {
        aQQ();
        bsm();
        if (this.dHI != null && this.dHG != null && this.Di != null) {
            if (com.baidu.tbadk.core.i.axf().isShowImages() && this.Ki != null && this.Ki.azV() != null) {
                this.dHG.setVisibility(0);
                this.dHI.setPlaceHolder(3);
                this.dHI.startLoad(this.Ki.azV().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.Ki.azV().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    n(true, 4);
                    TiebaStatic.log(new an("c12026").cp("tid", this.Ki.getId()));
                }
                if (this.fGA != null && this.fGA.cwu() != null) {
                    this.fGA.cwu().ah(this.Ki);
                    return;
                }
                return;
            }
            this.dHG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eIf, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHJ, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dHK, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHO, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dHL, R.color.common_color_10014);
            am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c);
            if (this.dHK != null) {
                this.dHK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.eIU != null && this.eIU.getVisibility() == 0) {
                this.eIU.onChangeSkinType();
            }
            this.eIh.onChangeSkinType();
            this.mSkinType = i;
            this.eIg.onChangeSkinType();
            if (this.fDG != null && this.fDG.getHeadView() != null && (this.fDG.getHeadView() instanceof TbImageView)) {
                this.fDG.getHeadView().setPlaceHolder(1);
            }
            this.dHI.setPlaceHolder(3);
            this.gsY.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
        this.currentPageType = i;
        if (this.eIh != null) {
            this.eIh.ddq = i;
            if (i == 15) {
                this.eIh.setFrom(10);
            } else {
                this.eIh.setFrom(2);
            }
        }
        if (this.eIg != null) {
            if (i == 15) {
                this.eIg.setFrom(5);
            } else {
                this.eIg.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.fDL;
    }

    public boolean isPlaying() {
        if (this.Di == null) {
            return false;
        }
        return this.Di.isPlaying();
    }

    public void startPlay() {
        if (!this.fDL && this.Ki != null && this.Ki.azV() != null && this.Di != null) {
            this.Di.stopPlayback();
            if (af.aPK()) {
                if (this.gsZ || com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    n(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cp("obj_locate", "frs").cp("tid", this.Ki.getId()));
                        this.mVideoUrl = this.Ki.azV().video_url;
                    }
                    this.fDL = true;
                    this.Di.setVideoPath(this.mVideoUrl, this.Ki.getId());
                    if (this.egJ != null) {
                        this.egJ.start();
                    }
                    bsg();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsg() {
        if (this.Ki != null && this.Ki.azV() != null) {
            String str = this.Ki.aAL() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.Ki.azI()) {
                str = "frs_mcn";
            }
            if (this.gta == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.OC = this.Ki.getTid();
            yVar.fGQ = this.Ki.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.Ki.mRecomSource;
            yVar.mAbTag = this.Ki.mRecomAbTag;
            yVar.jsi = this.Ki.mRecomAbTag;
            yVar.jsj = this.Ki.mRecomWeight;
            yVar.jsk = "";
            yVar.jsl = this.Ki.azV().video_md5;
            com.baidu.tieba.play.l.a(this.Ki.azV().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aQQ();
        bsm();
        n(true, 1);
        if (this.Di != null) {
            this.Di.stopPlayback();
            if (this.egJ != null) {
                this.egJ.stop();
            }
        }
        this.fDL = false;
    }

    public View getVideoContainer() {
        return this.dHG;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Di == null) {
            return 0;
        }
        return this.Di.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.fGA != null) {
            this.fGA.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eIh != null && this.eIg != null) {
            this.eIg.setPageUniqueId(bdUniqueId);
        }
    }

    public void pp(int i) {
        if (this.Ki != null) {
            if (i == 1) {
                this.eIh.setVisibility(8);
                this.eIU.setData(this.Ki);
                this.eIi.setVisibility(8);
                return;
            }
            this.eIh.setData(this.Ki);
            this.eIi.setVisibility(8);
            this.eIU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.dHI.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.dHI.setOnDrawListener(null);
        }
    }
}
