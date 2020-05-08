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
    private QuickVideoView Xe;
    private bj adJ;
    private String aeB;
    private final View.OnClickListener agl;
    private Animation bhz;
    private View cDC;
    private final View.OnClickListener dIj;
    private String dsL;
    private TbPageContext<?> duK;
    private g eFm;
    public LinearLayout eHe;
    private j ePg;
    private w emA;
    private View emB;
    private TextView emC;
    private int emD;
    private TbImageView.a emE;
    private g.b emF;
    private ViewTreeObserver.OnGlobalLayoutListener emG;
    private Runnable emH;
    private Runnable emI;
    private QuickVideoView.b emJ;
    public FrameLayout emu;
    private TextView emv;
    private TbImageView emw;
    private ImageView emx;
    private TextView emy;
    private View emz;
    private g.a evJ;
    private g.f evK;
    private g.e evM;
    private RelativeLayout fsu;
    public ThreadUserInfoLayout fsv;
    public ThreadCommentAndPraiseInfoLayout fsw;
    public View fsx;
    protected ThreadSourceShareAndPraiseLayout fti;
    public ThreadSkinView ftt;
    private ThreadGodReplyLayout goV;
    private HeadPendantClickableView goW;
    private int gpa;
    private boolean gpb;
    private TextView gpg;
    private Handler gph;
    private VideoLoadingProgressView.a gpi;
    private j.a gpn;
    private Animation.AnimationListener gpo;
    private LinearLayout gqE;
    private n grR;
    private TbImageView grf;
    public TextView hiU;
    public LinearLayout hiV;
    private i hiW;
    public boolean hiX;
    public int hiY;
    private View.OnClickListener hiZ;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;
    private String mVideoUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bED() {
        if (this.eFm != null && this.gpb) {
            try {
                this.Xe.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gph.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gpa = 0;
        this.emD = 1;
        this.gpb = false;
        this.gph = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bEI();
                        return;
                    case 203:
                        a.this.bEJ();
                        return;
                    default:
                        return;
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.eFm = gVar;
                if (a.this.eFm != null) {
                    a.this.eFm.setVolume(0.0f, 0.0f);
                }
                a.this.bED();
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.q(false, 3);
                }
                return false;
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Xe.start();
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bEK();
                a.this.q(true, 4);
                a.this.gpb = false;
                return true;
            }
        };
        this.gpi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bED();
            }
        };
        this.emE = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.emw != null) {
                    a.this.emw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.emG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.emu != null && a.this.emu.getLayoutParams() != null && a.this.emu.getVisibility() != 8) {
                    a.this.emu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.emu.getLayoutParams();
                    if (a.this.emu.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.emu.getWidth() * 0.5625d);
                        a.this.emu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.emH = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Xe != null && !a.this.Xe.isPlaying()) {
                    a.this.q(true, 1);
                }
            }
        };
        this.emI = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bEK();
                a.this.q(true, 4);
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.hiZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.adJ != null && !StringUtils.isNull(a.this.adJ.aKH())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.duK.getPageActivity()).createNormalCfg(a.this.adJ.aKH(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.dIj != null) {
                        a.this.dIj.onClick(view);
                    }
                }
            }
        };
        this.agl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEw() != null) {
                    a.this.bEw().a(view, a.this.adJ);
                }
            }
        };
        this.dIj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.adJ != null && a.this.bEw() != null) {
                    a.this.bEw().a(view, a.this.adJ);
                }
            }
        };
        this.gpn = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qa() {
                a.this.bEE();
            }
        };
        this.gpo = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.emD == 3 && a.this.emw != null) {
                    a.this.emw.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.duK = tbPageContext;
        View view = getView();
        this.cDC = view.findViewById(R.id.divider_line);
        this.fsu = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.grf = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.hiV = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fsu.setOnClickListener(this);
        this.goW = (HeadPendantClickableView) this.fsu.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.goW.getHeadView() != null) {
            this.goW.getHeadView().setIsRound(true);
            this.goW.getHeadView().setDrawBorder(false);
            this.goW.getHeadView().setDefaultResource(17170445);
            this.goW.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goW.getHeadView().setRadius(l.getDimens(this.duK.getPageActivity(), R.dimen.ds70));
        }
        this.goW.setHasPendantStyle();
        if (this.goW.getPendantView() != null) {
            this.goW.getPendantView().setIsRound(true);
            this.goW.getPendantView().setDrawBorder(false);
        }
        this.hiU = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.hiU.setVisibility(8);
        this.hiU.setOnClickListener(this.hiZ);
        this.emA = new w((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.emA.setLoadingAnimationListener(this.gpi);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.fsw.setForumAfterClickListener(this.dIj);
        this.fsv = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.fsv.setFrom(3);
        this.fsx = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.fsw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsw.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsw.setLayoutParams(layoutParams);
        }
        this.fsw.setOnClickListener(this);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setIsBarViewVisible(false);
        this.fsw.setShareVisible(true);
        this.fsw.setShareReportFrom(1);
        this.fsw.setStType("frs_page");
        this.fsw.setFrom(2);
        this.fsw.dIg = 3;
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.fti.dJe.setOnClickListener(this);
        this.fti.setFrom(2);
        this.fti.setShareReportFrom(1);
        this.fti.setSourceFromForPb(3);
        this.fti.setStType("frs_page");
        this.fti.setHideBarName(true);
        this.emu = (FrameLayout) view.findViewById(R.id.frame_video);
        this.emu.setOnClickListener(this);
        this.emu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.emu != null) {
                    a.this.emu.getViewTreeObserver().addOnGlobalLayoutListener(a.this.emG);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.emu != null) {
                    a.this.emu.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.emG);
                }
            }
        });
        this.emw = (TbImageView) view.findViewById(R.id.image_video);
        this.emw.setPageId(getTag());
        this.emw.setDefaultErrorResource(0);
        this.emw.setDrawCorner(true);
        this.emw.setPlaceHolder(3);
        this.emw.setEvent(this.emE);
        this.emw.setGifIconSupport(false);
        this.emx = (ImageView) view.findViewById(R.id.image_video_play);
        this.Xe = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.grR = new n(this.duK.getPageActivity());
        this.Xe.setContinuePlayEnable(true);
        this.Xe.setBusiness(this.grR);
        this.Xe.setOnPreparedListener(this.evK);
        this.Xe.setOnCompletionListener(this.evJ);
        this.Xe.setOnErrorListener(this.emF);
        this.Xe.setOnOutInfoListener(this.evM);
        this.Xe.setOnSurfaceDestroyedListener(this.emJ);
        this.ePg = new j();
        this.ePg.setPlayer(this.Xe);
        this.ePg.a(this.gpn);
        this.emB = view.findViewById(R.id.auto_video_black_mask);
        this.emy = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.emz = view.findViewById(R.id.auto_video_error_background);
        this.eHe = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.ftt = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.bhz = AnimationUtils.loadAnimation(this.duK.getPageActivity(), R.anim.fade_out_video_cover);
        this.bhz.setAnimationListener(this.gpo);
        this.emv = (TextView) view.findViewById(R.id.text_video_duration);
        this.emC = (TextView) view.findViewById(R.id.text_video_play_count);
        this.gqE = (LinearLayout) view.findViewById(R.id.duration_container);
        this.hiW = new i(tbPageContext, this.fsu);
        this.hiW.setUniqueId(getTag());
        this.goV = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.goV.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.fsw != null) {
                    a.this.fsw.changeSelectStatus();
                }
            }
        });
        this.fsw.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void gS(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.gpg = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fsu || view == this.fsw.getCommentNumView() || view == this.hiV) {
            bM(this.fsu);
        } else if (view == this.emu) {
            if (this.adJ != null && this.adJ.aKT() != null) {
                z = this.adJ.aKT().is_vertical.intValue() == 1;
            }
            if (z) {
                bK(view);
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF) {
                if (UtilHelper.isGotoVideoMiddlePage()) {
                    bY(this.emu);
                } else {
                    bM(this.emu);
                }
            } else if (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE) {
                bY(this.emu);
            } else {
                bM(this.emu);
            }
        } else if (view == this.goV) {
            bM(this.goV);
        }
        if (this.adJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.adJ));
        }
    }

    private void bK(View view) {
        if (bEw() != null) {
            bEw().a(view, this.adJ);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.duK.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bEF();
        }
    }

    private void bEF() {
        if (this.adJ != null) {
            String str = "frs";
            if (this.hiY == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.adJ);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.adJ.getBaijiahaoData() != null) {
                videoPlayActivityConfig.setNid(this.adJ.getBaijiahaoData().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoPlayActivityConfig));
        }
    }

    private void bY(View view) {
        if (this.adJ != null) {
            an anVar = new an("c11100");
            anVar.cI("tid", this.adJ.getId());
            anVar.cI("fid", this.adJ.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (bEw() != null) {
            bEw().a(view, this.adJ);
        }
        if (view == this.emu) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.duK.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bEG();
            }
        }
    }

    private void bEG() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.adJ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.eHe.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.eHe.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.hiY == 501) {
            str = "frs_tab";
        }
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.duK.getPageActivity(), str, this.adJ.getTid(), com.baidu.tieba.card.l.aKo(), "", videoSerializeVideoThreadInfo);
        if (this.adJ.getBaijiahaoData() != null) {
            videoMiddlePageActivityConfig.setNid(this.adJ.getBaijiahaoData().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
    }

    private void bM(View view) {
        String str;
        String str2;
        if (this.adJ != null) {
            if (this.adJ.aLI()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).cI("fid", String.valueOf(this.adJ.getFid())).af("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.cI("tid", this.adJ.getId());
                anVar.cI("fid", this.adJ.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.adJ.aKC() != null && this.adJ.aKC().getGodUserData() != null && this.adJ.aKC().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").af("obj_locate", 3).cI("tid", this.adJ.getId()));
            }
        }
        if (bEw() != null) {
            bEw().a(view, this.adJ);
        }
        if (this.adJ != null) {
            com.baidu.tieba.card.l.BE(this.adJ.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            aa.xn(this.adJ.getId());
            String valueOf = String.valueOf(this.adJ.getFid());
            if (this.adJ.dtD == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.adJ.dtD.id;
                str2 = valueOf;
            }
            if (this.adJ.aKY() > 0 && com.baidu.tieba.tbadkCore.util.e.cXq()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.duK.getPageActivity()).createHistoryCfg(this.adJ.getTid(), String.valueOf(this.adJ.aKY()), false, true, "frs_page");
                String str3 = "frs";
                if (this.hiY == 501) {
                    str3 = "frs_tab";
                } else if (this.adJ.aLI()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.adJ.aLO());
                createHistoryCfg.setSmartFrsPosition(this.adJ.aLU());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.goV) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.duK.getPageActivity()).createFromThreadCfg(this.adJ, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.hiY == 501) {
                str4 = "frs_tab";
            } else if (this.adJ.aLI()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.adJ.aLO());
            createFromThreadCfg.setSmartFrsPosition(this.adJ.aLU());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.goV) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bj bjVar) {
        this.adJ = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEI() {
        this.gph.removeMessages(202);
        if (this.Xe.getCurrentPosition() > 0) {
            q(false, 3);
            this.gph.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.gph.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEJ() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.gph.removeMessages(203);
        int currentPosition = this.Xe.getCurrentPosition();
        if (currentPosition != this.gpa) {
            this.gpa = currentPosition;
            q(false, 3);
        } else {
            q(false, 2);
        }
        this.gph.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, int i) {
        if (this.emx != null && this.emw != null && this.emB != null && this.emA != null && this.emz != null && this.emy != null) {
            if (z || this.emD != i) {
                this.emD = i;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emI);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emH);
                if (i == 2) {
                    this.emx.setVisibility(8);
                    this.bhz.cancel();
                    this.emw.clearAnimation();
                    this.emw.setVisibility(0);
                    this.emB.setVisibility(0);
                    this.gqE.setVisibility(0);
                    this.emA.startLoading();
                    this.emz.setVisibility(8);
                    this.emy.setVisibility(8);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emI, 60000L);
                } else if (i == 3) {
                    this.emx.setVisibility(8);
                    this.emw.startAnimation(this.bhz);
                    this.emB.setVisibility(8);
                    this.gqE.setVisibility(8);
                    this.emA.cKk();
                    this.emz.setVisibility(8);
                    this.emy.setVisibility(8);
                    if (this.adJ != null && this.adJ.aKT() != null) {
                        this.adJ.aKT().video_length.intValue();
                        this.adJ.aKT().video_duration.intValue();
                        this.adJ.getTid();
                    }
                } else if (i == 4) {
                    this.emx.setVisibility(8);
                    this.emw.startAnimation(this.bhz);
                    this.emB.setVisibility(8);
                    this.emA.cKl();
                    this.emz.setVisibility(0);
                    this.emy.setVisibility(0);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.emH, 2000L);
                } else {
                    this.emx.setVisibility(0);
                    this.gqE.setVisibility(0);
                    this.bhz.cancel();
                    this.emw.clearAnimation();
                    this.emw.setVisibility(0);
                    this.emB.setVisibility(0);
                    this.emA.cKl();
                    this.emz.setVisibility(8);
                    this.emy.setVisibility(8);
                }
            }
        }
    }

    private void Y(final bj bjVar) {
        if (this.grf != null) {
            if (bjVar == null) {
                this.grf.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.dtu)) {
                if (this.hiW != null && this.hiW.bVB() && (this.grf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grf.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.duK.getContext(), R.dimen.tbds106);
                    this.grf.setLayoutParams(layoutParams);
                }
                this.grf.setVisibility(0);
                this.grf.setImageDrawable(null);
                this.grf.startLoad(bjVar.dtu, 10, false);
                this.grf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.duK != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bjVar.dtv, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.grf.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.adJ == null || this.adJ.aKC() == null) {
            this.fsu.setVisibility(8);
            return;
        }
        this.fsu.setVisibility(0);
        this.fsu.setOnClickListener(this);
        bEL();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dsL)) {
            this.adJ.cz(this.mUrl, this.dsL);
        }
        this.adJ.s(false, true);
        SpannableStringBuilder aLj = this.adJ.aLj();
        if (this.adJ.aLp() && !StringUtils.isNull(this.adJ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.adJ.getTid();
            aLj.append((CharSequence) this.adJ.a(new f(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.i(aLj));
        this.mTextTitle.setText(aLj);
        this.hiW.az(this.adJ);
        Y(this.adJ);
        this.fsv.setData(this.adJ);
        if (this.fsv.getHeaderImg() != null) {
            if (this.fsv.getIsSimpleThread()) {
                this.fsv.getHeaderImg().setVisibility(8);
                this.goW.setVisibility(8);
            } else if (this.adJ.aKC() == null || this.adJ.aKC().getPendantData() == null || StringUtils.isNull(this.adJ.aKC().getPendantData().aIU())) {
                this.goW.setVisibility(8);
                this.fsv.getHeaderImg().setVisibility(0);
                this.fsv.getHeaderImg().setData(this.adJ);
            } else {
                this.fsv.getHeaderImg().setVisibility(4);
                this.goW.setVisibility(0);
                this.goW.setData(this.adJ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsw.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.fsw.setLayoutParams(layoutParams);
        this.fsv.setUserAfterClickListener(this.agl);
        pX(or(1));
        this.emv.setText(aq.stringForVideoTime(this.adJ.aKT().video_duration.intValue() * 1000));
        this.emC.setText(String.format(this.duK.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.adJ.aKT().play_count.intValue())));
        this.goV.setData(this.adJ.aMc());
        this.goV.onChangeSkinType();
        if (com.baidu.tieba.card.l.BF(this.adJ.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.l.a(this.goV.getGodReplyContent(), this.adJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.adJ == null || this.adJ.aKT() == null) {
            z = false;
        } else {
            z = this.adJ.aKT().is_vertical.intValue() == 1;
        }
        if (z) {
            this.gpg.setVisibility(0);
        } else {
            this.gpg.setVisibility(8);
        }
        if (this.fsw.isInFrsAllThread() && com.baidu.tieba.frs.a.bNB().bNC()) {
            this.mMaskView.setVisibility(0);
            if (this.adJ.aMl() || this.adJ.aMm()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEK() {
        this.gph.removeMessages(202);
        this.gph.removeMessages(203);
    }

    private void bbP() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emH);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emI);
    }

    private void bEL() {
        bbP();
        bEK();
        if (this.emw != null && this.emu != null && this.Xe != null) {
            if (com.baidu.tbadk.core.i.aIc().isShowImages() && this.adJ != null && this.adJ.aKT() != null) {
                this.emu.setVisibility(0);
                this.emw.setPlaceHolder(3);
                this.emw.startLoad(this.adJ.aKT().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.adJ.aKT().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    q(true, 4);
                    TiebaStatic.log(new an("c12026").cI("tid", this.adJ.getId()));
                }
                if (this.grR != null && this.grR.cJV() != null) {
                    this.grR.cJV().am(this.adJ);
                    return;
                }
                return;
            }
            this.emu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fsu, R.drawable.addresslist_item_bg);
            am.setImageResource(this.emx, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.emy, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emC, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.emz, R.color.common_color_10014);
            am.setBackgroundColor(this.cDC, R.color.cp_bg_line_c);
            if (this.emy != null) {
                this.emy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.fti != null && this.fti.getVisibility() == 0) {
                this.fti.onChangeSkinType();
            }
            this.fsw.onChangeSkinType();
            this.mSkinType = i;
            this.fsv.onChangeSkinType();
            if (this.goW != null && this.goW.getHeadView() != null && (this.goW.getHeadView() instanceof TbImageView)) {
                this.goW.getHeadView().setPlaceHolder(1);
            }
            this.emw.setPlaceHolder(3);
            this.hiW.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.currentPageType = i;
        if (this.fsw != null) {
            this.fsw.dIg = i;
            this.fsw.setFrom(2);
        }
        if (this.fsv != null) {
            this.fsv.setFrom(3);
        }
    }

    public boolean isPlayStarted() {
        return this.gpb;
    }

    public boolean isPlaying() {
        if (this.Xe == null) {
            return false;
        }
        return this.Xe.isPlaying();
    }

    public void startPlay() {
        if (!this.gpb && this.adJ != null && this.adJ.aKT() != null && this.Xe != null) {
            this.Xe.stopPlayback();
            if (af.baI()) {
                if (this.hiX || com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    q(true, 2);
                    if (StringUtils.isNull(this.mVideoUrl)) {
                        TiebaStatic.log(new an("c12619").cI("obj_locate", "frs").cI("tid", this.adJ.getId()));
                        this.mVideoUrl = this.adJ.aKT().video_url;
                    }
                    this.gpb = true;
                    this.Xe.setVideoPath(this.mVideoUrl, this.adJ.getId());
                    if (this.ePg != null) {
                        this.ePg.start();
                    }
                    bEE();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEE() {
        if (this.adJ != null && this.adJ.aKT() != null) {
            String str = this.adJ.aLI() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.adJ.aKG()) {
                str = "frs_mcn";
            }
            if (this.hiY == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.ahO = this.adJ.getTid();
            yVar.eQk = this.adJ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.adJ.mRecomSource;
            yVar.kiv = this.adJ.mRecomAbTag;
            yVar.kir = this.adJ.mRecomAbTag;
            yVar.kis = this.adJ.mRecomWeight;
            yVar.kit = "";
            yVar.kiw = this.adJ.aKT().video_md5;
            com.baidu.tieba.play.l.a(this.adJ.aKT().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        bbP();
        bEK();
        q(true, 1);
        if (this.Xe != null) {
            this.Xe.stopPlayback();
            if (this.ePg != null) {
                this.ePg.stop();
            }
        }
        this.gpb = false;
    }

    public View getVideoContainer() {
        return this.emu;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Xe == null) {
            return 0;
        }
        return this.Xe.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.grR != null) {
            this.grR.setVideoStatsData(yVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsw != null && this.fsv != null) {
            this.fsv.setPageUniqueId(bdUniqueId);
        }
    }

    public void pX(int i) {
        if (this.adJ != null) {
            if (i == 1) {
                this.fsw.setVisibility(8);
                this.fti.setData(this.adJ);
                this.fsx.setVisibility(8);
                return;
            }
            this.fsw.setData(this.adJ);
            this.fsx.setVisibility(8);
            this.fti.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.emw.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.i(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.c
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.emw.setOnDrawListener(null);
        }
    }
}
