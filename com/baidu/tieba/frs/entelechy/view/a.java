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
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private QuickVideoView Xb;
    private bj adG;
    private String aey;
    private final View.OnClickListener agi;
    private Animation bhu;
    private View cDw;
    private final View.OnClickListener dIf;
    private String dsH;
    private TbPageContext<?> duG;
    private g eFh;
    public LinearLayout eGZ;
    private j ePb;
    private g.b emA;
    private ViewTreeObserver.OnGlobalLayoutListener emB;
    private Runnable emC;
    private Runnable emD;
    private QuickVideoView.b emE;
    public FrameLayout emp;
    private TextView emq;
    private TbImageView emr;
    private ImageView ems;
    private TextView emt;
    private View emu;
    private w emv;
    private View emw;
    private TextView emx;
    private int emy;
    private TbImageView.a emz;
    private g.a evE;
    private g.f evF;
    private g.e evH;
    private RelativeLayout fsp;
    public ThreadUserInfoLayout fsq;
    public ThreadCommentAndPraiseInfoLayout fsr;
    public View fss;
    protected ThreadSourceShareAndPraiseLayout ftd;
    public ThreadSkinView fto;
    private ThreadGodReplyLayout goP;
    private HeadPendantClickableView goQ;
    private int goU;
    private boolean goV;
    private TextView gpa;
    private Handler gpb;
    private VideoLoadingProgressView.a gpc;
    private j.a gph;
    private Animation.AnimationListener gpi;
    private TbImageView gqZ;
    private LinearLayout gqy;
    private n grL;
    public TextView hiO;
    public LinearLayout hiP;
    private i hiQ;
    public boolean hiR;
    public int hiS;
    private View.OnClickListener hiT;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.eFh != null && this.goV) {
            try {
                this.Xb.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gpb.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.goU = 0;
        this.emy = 1;
        this.goV = false;
        this.gpb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bEK();
                        return;
                    case 203:
                        a.this.bEL();
                        return;
                    default:
                        return;
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.eFh = gVar;
                if (a.this.eFh != null) {
                    a.this.eFh.setVolume(0.0f, 0.0f);
                }
                a.this.bEF();
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.q(false, 3);
                }
                return false;
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Xb.start();
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bEM();
                a.this.q(true, 4);
                a.this.goV = false;
                return true;
            }
        };
        this.gpc = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bEF();
            }
        };
        this.emz = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.emr != null) {
                    a.this.emr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.emB = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.emp != null && a.this.emp.getLayoutParams() != null && a.this.emp.getVisibility() != 8) {
                    a.this.emp.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.emp.getLayoutParams();
                    if (a.this.emp.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.emp.getWidth() * 0.5625d);
                        a.this.emp.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.emC = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Xb != null && !a.this.Xb.isPlaying()) {
                    a.this.q(true, 1);
                }
            }
        };
        this.emD = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bEM();
                a.this.q(true, 4);
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.hiT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.adG != null && !StringUtils.isNull(a.this.adG.aKJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.duG.getPageActivity()).createNormalCfg(a.this.adG.aKJ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.dIf != null) {
                        a.this.dIf.onClick(view);
                    }
                }
            }
        };
        this.agi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEy() != null) {
                    a.this.bEy().a(view, a.this.adG);
                }
            }
        };
        this.dIf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.adG != null && a.this.bEy() != null) {
                    a.this.bEy().a(view, a.this.adG);
                }
            }
        };
        this.gph = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qa() {
                a.this.bEG();
            }
        };
        this.gpi = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.emy == 3 && a.this.emr != null) {
                    a.this.emr.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.duG = tbPageContext;
        View view = getView();
        this.cDw = view.findViewById(R.id.divider_line);
        this.fsp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.gqZ = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.hiP = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fsp.setOnClickListener(this);
        this.goQ = (HeadPendantClickableView) this.fsp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.goQ.getHeadView() != null) {
            this.goQ.getHeadView().setIsRound(true);
            this.goQ.getHeadView().setDrawBorder(false);
            this.goQ.getHeadView().setDefaultResource(17170445);
            this.goQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goQ.getHeadView().setRadius(l.getDimens(this.duG.getPageActivity(), R.dimen.ds70));
        }
        this.goQ.setHasPendantStyle();
        if (this.goQ.getPendantView() != null) {
            this.goQ.getPendantView().setIsRound(true);
            this.goQ.getPendantView().setDrawBorder(false);
        }
        this.hiO = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.hiO.setVisibility(8);
        this.hiO.setOnClickListener(this.hiT);
        this.emv = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.emv.setLoadingAnimationListener(this.gpc);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsr.setForumAfterClickListener(this.dIf);
        this.fsq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fsq.setFrom(3);
        this.fss = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.fsr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsr.setLayoutParams(layoutParams);
        }
        this.fsr.setOnClickListener(this);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setIsBarViewVisible(false);
        this.fsr.setShareVisible(true);
        this.fsr.setShareReportFrom(1);
        this.fsr.setStType("frs_page");
        this.fsr.setFrom(2);
        this.fsr.dIc = 3;
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.ftd.dJa.setOnClickListener(this);
        this.ftd.setFrom(2);
        this.ftd.setShareReportFrom(1);
        this.ftd.setSourceFromForPb(3);
        this.ftd.setStType("frs_page");
        this.ftd.setHideBarName(true);
        this.emp = (FrameLayout) view.findViewById(R.id.frame_video);
        this.emp.setOnClickListener(this);
        this.emp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.emp != null) {
                    a.this.emp.getViewTreeObserver().addOnGlobalLayoutListener(a.this.emB);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.emp != null) {
                    a.this.emp.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.emB);
                }
            }
        });
        this.emr = (TbImageView) view.findViewById(R.id.image_video);
        this.emr.setPageId(getTag());
        this.emr.setDefaultErrorResource(0);
        this.emr.setDrawCorner(true);
        this.emr.setPlaceHolder(3);
        this.emr.setEvent(this.emz);
        this.emr.setGifIconSupport(false);
        this.ems = (ImageView) view.findViewById(R.id.image_video_play);
        this.Xb = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.grL = new n(this.duG.getPageActivity());
        this.Xb.setContinuePlayEnable(true);
        this.Xb.setBusiness(this.grL);
        this.Xb.setOnPreparedListener(this.evF);
        this.Xb.setOnCompletionListener(this.evE);
        this.Xb.setOnErrorListener(this.emA);
        this.Xb.setOnOutInfoListener(this.evH);
        this.Xb.setOnSurfaceDestroyedListener(this.emE);
        this.ePb = new j();
        this.ePb.setPlayer(this.Xb);
        this.ePb.a(this.gph);
        this.emw = view.findViewById(R.id.auto_video_black_mask);
        this.emt = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.emu = view.findViewById(R.id.auto_video_error_background);
        this.eGZ = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fto = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bhu = AnimationUtils.loadAnimation(this.duG.getPageActivity(), R.anim.fade_out_video_cover);
        this.bhu.setAnimationListener(this.gpi);
        this.emq = (TextView) view.findViewById(R.id.text_video_duration);
        this.emx = (TextView) view.findViewById(R.id.text_video_play_count);
        this.gqy = (LinearLayout) view.findViewById(R.id.duration_container);
        this.hiQ = new i(tbPageContext, this.fsp);
        this.hiQ.setUniqueId(getTag());
        this.goP = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.goP.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.fsr != null) {
                    a.this.fsr.changeSelectStatus();
                }
            }
        });
        this.fsr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void gS(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.gpa = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fsp || view == this.fsr.getCommentNumView() || view == this.hiP) {
            bM(this.fsp);
        } else if (view == this.emp) {
            if (this.adG != null && this.adG.aKV() != null) {
                z = this.adG.aKV().is_vertical.intValue() == 1;
            }
            if (z) {
                bK(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bY(this.emp);
                } else {
                    bM(this.emp);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bY(this.emp);
            } else {
                bM(this.emp);
            }
        } else if (view == this.goP) {
            bM(this.goP);
        }
        if (this.adG != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.adG));
        }
    }

    private void bK(View view) {
        if (bEy() != null) {
            bEy().a(view, this.adG);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.duG.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEH();
        }
    }

    private void bEH() {
        if (this.adG != null) {
            String str = "frs";
            if (this.hiS == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.adG);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.adG.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.adG.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bY(View view) {
        if (this.adG != null) {
            an anVar = new an("c11100");
            anVar.cI("tid", this.adG.getId());
            anVar.cI("fid", this.adG.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (bEy() != null) {
            bEy().a(view, this.adG);
        }
        if (view == this.emp) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bEI();
            }
        }
    }

    private void bEI() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.adG);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.eGZ.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.eGZ.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.hiS == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.duG.getPageActivity(), str, this.adG.getTid(), com.baidu.tieba.card.l.aKq(), "", videoSerializeVideoThreadInfo);
        if (this.adG.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.adG.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bM(View view) {
        String str;
        String str2;
        if (this.adG != null) {
            if (this.adG.aLK()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cI("fid", String.valueOf(this.adG.getFid())).af("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cI("tid", this.adG.getId());
                anVar.cI("fid", this.adG.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.adG.aKE() != null && this.adG.aKE().getGodUserData() != null && this.adG.aKE().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").af("obj_locate", 3).cI("tid", this.adG.getId()));
            }
        }
        if (bEy() != null) {
            bEy().a(view, this.adG);
        }
        if (this.adG != null) {
            com.baidu.tieba.card.l.BB(this.adG.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.xk(this.adG.getId());
            String valueOf = String.valueOf(this.adG.getFid());
            if (this.adG.dtz == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.adG.dtz.id;
                str2 = valueOf;
            }
            if (this.adG.aLa() > 0 && com.baidu.tieba.tbadkCore.util.e.cXt()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.duG.getPageActivity()).createHistoryCfg(this.adG.getTid(), String.valueOf(this.adG.aLa()), false, true, "frs_page");
                String str3 = "frs";
                if (this.hiS == 501) {
                    str3 = "frs_tab";
                } else if (this.adG.aLK()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.adG.aLQ());
                createHistoryCfg.setSmartFrsPosition(this.adG.aLW());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.goP) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.duG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.duG.getPageActivity()).createFromThreadCfg(this.adG, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.hiS == 501) {
                str4 = "frs_tab";
            } else if (this.adG.aLK()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.adG.aLQ());
            createFromThreadCfg.setSmartFrsPosition(this.adG.aLW());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.goP) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.duG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.adG = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEK() {
        this.gpb.removeMessages(202);
        if (this.Xb.getCurrentPosition() > 0) {
            q(false, 3);
            this.gpb.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gpb.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEL() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gpb.removeMessages(203);
        int currentPosition = this.Xb.getCurrentPosition();
        if (currentPosition != this.goU) {
            this.goU = currentPosition;
            q(false, 3);
        } else {
            q(false, 2);
        }
        this.gpb.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, int i) {
        if (this.ems != null && this.emr != null && this.emw != null && this.emv != null && this.emu != null && this.emt != null) {
            if (z || this.emy != i) {
                this.emy = i;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emD);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emC);
                if (i == 2) {
                    this.ems.setVisibility(8);
                    this.bhu.cancel();
                    this.emr.clearAnimation();
                    this.emr.setVisibility(0);
                    this.emw.setVisibility(0);
                    this.gqy.setVisibility(0);
                    this.emv.startLoading();
                    this.emu.setVisibility(8);
                    this.emt.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emD, 60000L);
                } else if (i == 3) {
                    this.ems.setVisibility(8);
                    this.emr.startAnimation(this.bhu);
                    this.emw.setVisibility(8);
                    this.gqy.setVisibility(8);
                    this.emv.cKn();
                    this.emu.setVisibility(8);
                    this.emt.setVisibility(8);
                    if (this.adG != null && this.adG.aKV() != null) {
                        this.adG.aKV().video_length.intValue();
                        this.adG.aKV().video_duration.intValue();
                        this.adG.getTid();
                    }
                } else if (i == 4) {
                    this.ems.setVisibility(8);
                    this.emr.startAnimation(this.bhu);
                    this.emw.setVisibility(8);
                    this.emv.cKo();
                    this.emu.setVisibility(0);
                    this.emt.setVisibility(0);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emC, 2000L);
                } else {
                    this.ems.setVisibility(0);
                    this.gqy.setVisibility(0);
                    this.bhu.cancel();
                    this.emr.clearAnimation();
                    this.emr.setVisibility(0);
                    this.emw.setVisibility(0);
                    this.emv.cKo();
                    this.emu.setVisibility(8);
                    this.emt.setVisibility(8);
                }
            }
        }
    }

    private void Y(final bj bjVar) {
        if (this.gqZ != null) {
            if (bjVar == null) {
                this.gqZ.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.dtp)) {
                if (this.hiQ != null && this.hiQ.bVD() && (this.gqZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqZ.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.duG.getContext(), R.dimen.tbds106);
                    this.gqZ.setLayoutParams(layoutParams);
                }
                this.gqZ.setVisibility(0);
                this.gqZ.setImageDrawable(null);
                this.gqZ.startLoad(bjVar.dtp, 10, false);
                this.gqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.duG != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.dtq, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gqZ.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.adG == null || this.adG.aKE() == null) {
            this.fsp.setVisibility(8);
            return;
        }
        this.fsp.setVisibility(0);
        this.fsp.setOnClickListener(this);
        bEN();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dsH)) {
            this.adG.cz(this.mUrl, this.dsH);
        }
        this.adG.s(false, true);
        SpannableStringBuilder aLl = this.adG.aLl();
        if (this.adG.aLr() && !StringUtils.isNull(this.adG.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.adG.getTid();
            aLl.append((CharSequence) this.adG.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").cI("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(aLl));
        this.mTextTitle.setText(aLl);
        this.hiQ.az(this.adG);
        Y(this.adG);
        this.fsq.setData(this.adG);
        if (this.fsq.getHeaderImg() != null) {
            if (this.fsq.getIsSimpleThread()) {
                this.fsq.getHeaderImg().setVisibility(8);
                this.goQ.setVisibility(8);
            } else if (this.adG.aKE() == null || this.adG.aKE().getPendantData() == null || StringUtils.isNull(this.adG.aKE().getPendantData().aIW())) {
                this.goQ.setVisibility(8);
                this.fsq.getHeaderImg().setVisibility(0);
                this.fsq.getHeaderImg().setData(this.adG);
            } else {
                this.fsq.getHeaderImg().setVisibility(4);
                this.goQ.setVisibility(0);
                this.goQ.setData(this.adG);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsr.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.fsr.setLayoutParams(layoutParams);
        this.fsq.setUserAfterClickListener(this.agi);
        pX(or(1));
        this.emq.setText(aq.stringForVideoTime(this.adG.aKV().video_duration.intValue() * 1000));
        this.emx.setText(String.format(this.duG.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.adG.aKV().play_count.intValue())));
        this.goP.setData(this.adG.aMe());
        this.goP.onChangeSkinType();
        if (com.baidu.tieba.card.l.BC(this.adG.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.goP.getGodReplyContent(), this.adG.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.adG == null || this.adG.aKV() == null) {
            z = false;
        } else {
            z = this.adG.aKV().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gpa.setVisibility(0);
        } else {
            this.gpa.setVisibility(8);
        }
        if (this.fsr.isInFrsAllThread() && com.baidu.tieba.frs.a.bND().bNE()) {
            this.mMaskView.setVisibility(0);
            if (this.adG.aMn() || this.adG.aMo()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEM() {
        this.gpb.removeMessages(202);
        this.gpb.removeMessages(203);
    }

    private void bbR() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emC);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emD);
    }

    private void bEN() {
        bbR();
        bEM();
        if (this.emr != null && this.emp != null && this.Xb != null) {
            if (com.baidu.tbadk.core.i.aIe().isShowImages() && this.adG != null && this.adG.aKV() != null) {
                this.emp.setVisibility(0);
                this.emr.setPlaceHolder(3);
                this.emr.startLoad(this.adG.aKV().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.adG.aKV().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    q(true, 4);
                    TiebaStatic.log(new an("c12026").cI("tid", this.adG.getId()));
                }
                if (this.grL != null && this.grL.cJY() != null) {
                    this.grL.cJY().am(this.adG);
                    return;
                }
                return;
            }
            this.emp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.ems, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.emt, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emx, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.emu, R.color.common_color_10014);
            am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c);
            if (this.emt != null) {
                this.emt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.ftd != null && this.ftd.getVisibility() == 0) {
                this.ftd.onChangeSkinType();
            }
            this.fsr.onChangeSkinType();
            this.mSkinType = i;
            this.fsq.onChangeSkinType();
            if (this.goQ != null && this.goQ.getHeadView() != null && (this.goQ.getHeadView() instanceof TbImageView)) {
                this.goQ.getHeadView().setPlaceHolder(1);
            }
            this.emr.setPlaceHolder(3);
            this.hiQ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.currentPageType = i;
        if (this.fsr != null) {
            this.fsr.dIc = i;
            this.fsr.setFrom(2);
        }
        if (this.fsq != null) {
            this.fsq.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.goV;
    }

    public boolean isPlaying() {
        if (this.Xb == null) {
            return false;
        }
        return this.Xb.isPlaying();
    }

    public void startPlay() {
        if (!this.goV && this.adG != null && this.adG.aKV() != null && this.Xb != null) {
            this.Xb.stopPlayback();
            if (af.baK()) {
                if (this.hiR || com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    q(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cI("obj_locate", "frs").cI("tid", this.adG.getId()));
                        this.mVideoUrl = this.adG.aKV().video_url;
                    }
                    this.goV = true;
                    this.Xb.setVideoPath(this.mVideoUrl, this.adG.getId());
                    if (this.ePb != null) {
                        this.ePb.start();
                    }
                    bEG();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.adG != null && this.adG.aKV() != null) {
            String str = this.adG.aLK() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.adG.aKI()) {
                str = "frs_mcn";
            }
            if (this.hiS == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.ahL = this.adG.getTid();
            yVar.eQf = this.adG.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.adG.mRecomSource;
            yVar.kir = this.adG.mRecomAbTag;
            yVar.kin = this.adG.mRecomAbTag;
            yVar.kio = this.adG.mRecomWeight;
            yVar.kip = "";
            yVar.kis = this.adG.aKV().video_md5;
            com.baidu.tieba.play.l.a(this.adG.aKV().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        bbR();
        bEM();
        q(true, 1);
        if (this.Xb != null) {
            this.Xb.stopPlayback();
            if (this.ePb != null) {
                this.ePb.stop();
            }
        }
        this.goV = false;
    }

    public View getVideoContainer() {
        return this.emp;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Xb == null) {
            return 0;
        }
        return this.Xb.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.grL != null) {
            this.grL.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsr != null && this.fsq != null) {
            this.fsq.setPageUniqueId(bdUniqueId);
        }
    }

    public void pX(int i) {
        if (this.adG != null) {
            if (i == 1) {
                this.fsr.setVisibility(8);
                this.ftd.setData(this.adG);
                this.fss.setVisibility(8);
                return;
            }
            this.fsr.setData(this.adG);
            this.fss.setVisibility(8);
            this.ftd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.emr.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.i(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.emr.setOnDrawListener(null);
        }
    }
}
