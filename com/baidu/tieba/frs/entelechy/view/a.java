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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private QuickVideoView Be;
    private bh FT;
    private String GC;
    private final View.OnClickListener HO;
    private Animation azg;
    public FrameLayout cUe;
    private TextView cUf;
    private TbImageView cUg;
    private ImageView cUh;
    private TextView cUi;
    private View cUj;
    private x cUk;
    private View cUl;
    private TextView cUm;
    private int cUn;
    private TbImageView.a cUo;
    private g.b cUp;
    private ViewTreeObserver.OnGlobalLayoutListener cUq;
    private Runnable cUr;
    private Runnable cUs;
    private QuickVideoView.b cUt;
    private String cdn;
    private TbPageContext<?> cfl;
    private String cmf;
    private final View.OnClickListener cpN;
    private RelativeLayout dTp;
    public ThreadUserInfoLayout dTq;
    public ThreadCommentAndPraiseInfoLayout dTr;
    public View dTs;
    protected ThreadSourceShareAndPraiseLayout dUf;
    public LinearLayout dUq;
    public ThreadSkinView dUr;
    private g.a ddK;
    private g.f ddL;
    private g.e ddN;
    private View deR;
    private g drt;
    private j dwy;
    private ThreadGodReplyLayout eMG;
    private HeadPendantClickableView eMH;
    private int eML;
    private boolean eMM;
    private TextView eMR;
    private Handler eMS;
    private VideoLoadingProgressView.a eMT;
    private j.a eMY;
    private Animation.AnimationListener eMZ;
    private TbImageView eOS;
    private LinearLayout eOp;
    private n ePD;
    public TextView fFu;
    public LinearLayout fFv;
    private com.baidu.tieba.frs.vc.g fFw;
    public boolean fFx;
    public int fFy;
    private View.OnClickListener fFz;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        if (this.drt != null && this.eMM) {
            try {
                this.Be.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eMS.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eML = 0;
        this.cUn = 1;
        this.eMM = false;
        this.eMS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.bai();
                        return;
                    case 203:
                        a.this.baj();
                        return;
                    default:
                        return;
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.drt = gVar;
                if (a.this.drt != null) {
                    a.this.drt.setVolume(0.0f, 0.0f);
                }
                a.this.bad();
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.j(false, 3);
                }
                return false;
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Be.start();
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bak();
                a.this.j(true, 4);
                a.this.eMM = false;
                return true;
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.bad();
            }
        };
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.cUg != null) {
                    a.this.cUg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cUq = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cUe != null && a.this.cUe.getLayoutParams() != null && a.this.cUe.getVisibility() != 8) {
                    a.this.cUe.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cUe.getLayoutParams();
                    if (a.this.cUe.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cUe.getWidth() * 0.5625d);
                        a.this.cUe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cUr = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Be != null && !a.this.Be.isPlaying()) {
                    a.this.j(true, 1);
                }
            }
        };
        this.cUs = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bak();
                a.this.j(true, 4);
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fFz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.FT != null && !StringUtils.isNull(a.this.FT.aiL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.cfl.getPageActivity()).createNormalCfg(a.this.FT.aiL(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.cpN != null) {
                        a.this.cpN.onClick(view);
                    }
                }
            }
        };
        this.HO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.FT);
                }
            }
        };
        this.cpN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.FT != null && a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.FT);
                }
            }
        };
        this.eMY = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void kP() {
                a.this.bae();
            }
        };
        this.eMZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cUn == 3 && a.this.cUg != null) {
                    a.this.cUg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.cfl = tbPageContext;
        View view = getView();
        this.deR = view.findViewById(R.id.divider_line);
        this.dTp = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eOS = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.fFv = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dTp.setOnClickListener(this);
        this.eMH = (HeadPendantClickableView) this.dTp.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eMH.getHeadView() != null) {
            this.eMH.getHeadView().setIsRound(true);
            this.eMH.getHeadView().setDrawBorder(false);
            this.eMH.getHeadView().setDefaultResource(17170445);
            this.eMH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eMH.getHeadView().setRadius(l.getDimens(this.cfl.getPageActivity(), R.dimen.ds70));
        }
        this.eMH.setHasPendantStyle();
        if (this.eMH.getPendantView() != null) {
            this.eMH.getPendantView().setIsRound(true);
            this.eMH.getPendantView().setDrawBorder(false);
        }
        this.fFu = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fFu.setVisibility(8);
        this.fFu.setOnClickListener(this.fFz);
        this.cUk = new x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cUk.setLoadingAnimationListener(this.eMT);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dTr.setForumAfterClickListener(this.cpN);
        this.dTq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dTq.setFrom(3);
        this.dTs = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.dTr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dTr.setLayoutParams(layoutParams);
        }
        this.dTr.setOnClickListener(this);
        this.dTr.setReplyTimeVisible(false);
        this.dTr.setShowPraiseNum(true);
        this.dTr.setNeedAddPraiseIcon(true);
        this.dTr.setNeedAddReplyIcon(true);
        this.dTr.setIsBarViewVisible(false);
        this.dTr.setShareVisible(true);
        this.dTr.setShareReportFrom(1);
        this.dTr.setStType("frs_page");
        this.dTr.setFrom(2);
        this.dTr.setDisPraiseFrom(2);
        this.dTr.cqT = 3;
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dUf.crO.setOnClickListener(this);
        this.dUf.setFrom(2);
        this.dUf.setShareReportFrom(1);
        this.dUf.setSourceFromForPb(3);
        this.dUf.setStType("frs_page");
        this.dUf.setHideBarName(true);
        this.cUe = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cUe.setOnClickListener(this);
        this.cUe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cUe != null) {
                    a.this.cUe.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cUq);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cUe != null) {
                    a.this.cUe.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cUq);
                }
            }
        });
        this.cUg = (TbImageView) view.findViewById(R.id.image_video);
        this.cUg.setPageId(getTag());
        this.cUg.setDefaultErrorResource(0);
        this.cUg.setDrawCorner(true);
        this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
        this.cUg.setEvent(this.cUo);
        this.cUg.setGifIconSupport(false);
        this.cUh = (ImageView) view.findViewById(R.id.image_video_play);
        this.Be = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.ePD = new n(this.cfl.getPageActivity());
        this.Be.setPlayerReuseEnable(true);
        this.Be.setContinuePlayEnable(true);
        this.Be.setBusiness(this.ePD);
        this.Be.setOnPreparedListener(this.ddL);
        this.Be.setOnCompletionListener(this.ddK);
        this.Be.setOnErrorListener(this.cUp);
        this.Be.setOnOutInfoListener(this.ddN);
        this.Be.setOnSurfaceDestroyedListener(this.cUt);
        this.Be.setPageTypeForPerfStat("frs");
        this.dwy = new j();
        this.dwy.setPlayer(this.Be);
        this.dwy.a(this.eMY);
        this.cUl = view.findViewById(R.id.auto_video_black_mask);
        this.cUi = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cUj = view.findViewById(R.id.auto_video_error_background);
        this.dUq = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dUr = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.azg = AnimationUtils.loadAnimation(this.cfl.getPageActivity(), R.anim.fade_out_video_cover);
        this.azg.setAnimationListener(this.eMZ);
        this.cUf = (TextView) view.findViewById(R.id.text_video_duration);
        this.cUm = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eOp = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fFw = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dTp);
        this.fFw.setUniqueId(getTag());
        this.eMG = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eMG.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dTr != null) {
                    a.this.dTr.changeSelectStatus();
                }
            }
        });
        this.dTr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ev(boolean z) {
                if (a.this.mMaskView != null) {
                    am.setBackgroundColor(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.eMR = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dTp || view == this.dTr.getCommentNumView() || view == this.fFv) {
            bF(this.dTp);
        } else if (view == this.cUe) {
            if (this.FT != null && this.FT.aiX() != null) {
                z = this.FT.aiX().is_vertical.intValue() == 1;
            }
            if (z) {
                bD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bQ(this.cUe);
            } else {
                bF(this.cUe);
            }
        } else if (view == this.eMG) {
            bF(this.eMG);
        }
        if (this.FT != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.FT));
        }
    }

    private void bD(View view) {
        if (aZX() != null) {
            aZX().a(view, this.FT);
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showToast(this.cfl.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            baf();
        }
    }

    private void baf() {
        if (this.FT != null) {
            String str = "frs";
            if (this.fFy == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.FT);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bQ(View view) {
        if (this.FT != null) {
            an anVar = new an("c11100");
            anVar.bS("tid", this.FT.getId());
            anVar.bS("fid", this.FT.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aZX() != null) {
            aZX().a(view, this.FT);
        }
        if (view == this.cUe) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bag();
            }
        }
    }

    private void bag() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.FT);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.dUq.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.dUq.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fFy == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.cfl.getPageActivity(), str, this.FT.getTid(), com.baidu.tieba.card.n.ait(), "", videoSerializeVideoThreadInfo)));
    }

    private void bF(View view) {
        String str;
        String str2;
        if (this.FT != null) {
            if (this.FT.ajH()) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).bS("fid", String.valueOf(this.FT.getFid())).O("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.bS("tid", this.FT.getId());
                anVar.bS("fid", this.FT.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.FT.aiG() != null && this.FT.aiG().getGodUserData() != null && this.FT.aiG().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").O("obj_locate", 3).bS("tid", this.FT.getId()));
            }
        }
        if (aZX() != null) {
            aZX().a(view, this.FT);
        }
        if (this.FT != null) {
            com.baidu.tieba.card.n.uz(this.FT.getId());
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tbadk.util.x.qr(this.FT.getId());
            String valueOf = String.valueOf(this.FT.getFid());
            if (this.FT.cem == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.FT.cem.id;
                str2 = valueOf;
            }
            if (this.FT.ajc() > 0 && com.baidu.tieba.tbadkCore.util.e.cps()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.cfl.getPageActivity()).createHistoryCfg(this.FT.getTid(), String.valueOf(this.FT.ajc()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fFy == 501) {
                    str3 = "frs_tab";
                } else if (this.FT.ajH()) {
                    str3 = ConstantData.VideoLocationType.FRS_5FLOOR;
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.FT.ajO());
                createHistoryCfg.setSmartFrsPosition(this.FT.ajV());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.eMG) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.cfl.getPageActivity()).createFromThreadCfg(this.FT, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            String str4 = "frs";
            if (this.fFy == 501) {
                str4 = "frs_tab";
            } else if (this.FT.ajH()) {
                str4 = ConstantData.VideoLocationType.FRS_5FLOOR;
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.FT.ajO());
            createFromThreadCfg.setSmartFrsPosition(this.FT.ajV());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.eMG) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        this.FT = bhVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        this.eMS.removeMessages(202);
        if (this.Be.getCurrentPosition() > 0) {
            j(false, 3);
            this.eMS.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eMS.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baj() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eMS.removeMessages(203);
        int currentPosition = this.Be.getCurrentPosition();
        if (currentPosition != this.eML) {
            this.eML = currentPosition;
            j(false, 3);
        } else {
            j(false, 2);
        }
        this.eMS.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.cUh != null && this.cUg != null && this.cUl != null && this.cUk != null && this.cUj != null && this.cUi != null) {
            if (z || this.cUn != i) {
                this.cUn = i;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUs);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUr);
                if (i == 2) {
                    this.cUh.setVisibility(8);
                    this.azg.cancel();
                    this.cUg.clearAnimation();
                    this.cUg.setVisibility(0);
                    this.cUl.setVisibility(0);
                    this.eOp.setVisibility(0);
                    this.cUk.startLoading();
                    this.cUj.setVisibility(8);
                    this.cUi.setVisibility(8);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cUs, 60000L);
                } else if (i == 3) {
                    this.cUh.setVisibility(8);
                    this.cUg.startAnimation(this.azg);
                    this.cUl.setVisibility(8);
                    this.eOp.setVisibility(8);
                    this.cUk.ccO();
                    this.cUj.setVisibility(8);
                    this.cUi.setVisibility(8);
                    if (this.FT != null && this.FT.aiX() != null) {
                        this.FT.aiX().video_length.intValue();
                        this.FT.aiX().video_duration.intValue();
                        this.FT.getTid();
                    }
                } else if (i == 4) {
                    this.cUh.setVisibility(8);
                    this.cUg.startAnimation(this.azg);
                    this.cUl.setVisibility(8);
                    this.cUk.ccP();
                    this.cUj.setVisibility(0);
                    this.cUi.setVisibility(0);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.cUr, 2000L);
                } else {
                    this.cUh.setVisibility(0);
                    this.eOp.setVisibility(0);
                    this.azg.cancel();
                    this.cUg.clearAnimation();
                    this.cUg.setVisibility(0);
                    this.cUl.setVisibility(0);
                    this.cUk.ccP();
                    this.cUj.setVisibility(8);
                    this.cUi.setVisibility(8);
                }
            }
        }
    }

    private void R(final bh bhVar) {
        if (this.eOS != null) {
            if (bhVar == null) {
                this.eOS.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.ced)) {
                if (this.fFw != null && this.fFw.bqL() && (this.eOS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eOS.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.cfl.getContext(), R.dimen.tbds106);
                    this.eOS.setLayoutParams(layoutParams);
                }
                this.eOS.setVisibility(0);
                this.eOS.setImageDrawable(null);
                this.eOS.startLoad(bhVar.ced, 10, false);
                this.eOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.cfl != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bhVar.cee, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.eOS.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.FT == null || this.FT.aiG() == null) {
            this.dTp.setVisibility(8);
            return;
        }
        this.dTp.setVisibility(0);
        this.dTp.setOnClickListener(this);
        bal();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cdn)) {
            this.FT.bI(this.mUrl, this.cdn);
        }
        this.FT.q(false, true);
        SpannableStringBuilder ajm = this.FT.ajm();
        if (this.FT.ajt() && !StringUtils.isNull(this.FT.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.FT.getTid();
            ajm.append((CharSequence) this.FT.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bS("obj_source", "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(ajm));
        this.mTextTitle.setText(ajm);
        this.fFw.am(this.FT);
        R(this.FT);
        this.dTq.setData(this.FT);
        if (this.dTq.getHeaderImg() != null) {
            if (this.dTq.getIsSimpleThread()) {
                this.dTq.getHeaderImg().setVisibility(8);
                this.eMH.setVisibility(8);
            } else if (this.FT.aiG() == null || this.FT.aiG().getPendantData() == null || StringUtils.isNull(this.FT.aiG().getPendantData().ahf())) {
                this.eMH.setVisibility(8);
                this.dTq.getHeaderImg().setVisibility(0);
                this.dTq.getHeaderImg().setData(this.FT);
            } else {
                this.dTq.getHeaderImg().setVisibility(4);
                this.eMH.setVisibility(0);
                this.eMH.setData(this.FT);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTr.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dTr.setLayoutParams(layoutParams);
        this.dTq.setUserAfterClickListener(this.HO);
        mZ(ly(1));
        this.cUf.setText(aq.stringForVideoTime(this.FT.aiX().video_duration.intValue() * 1000));
        this.cUm.setText(String.format(this.cfl.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.FT.aiX().play_count.intValue())));
        this.eMG.setData(this.FT.akd());
        this.eMG.onChangeSkinType();
        if (com.baidu.tieba.card.n.uA(this.FT.getId())) {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.eMG.getGodReplyContent(), this.FT.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.FT == null || this.FT.aiX() == null) {
            z = false;
        } else {
            z = this.FT.aiX().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eMR.setVisibility(0);
        } else {
            this.eMR.setVisibility(8);
        }
        if (this.dTr.isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.mMaskView.setVisibility(0);
            if (this.FT.ako() || this.FT.akp()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bak() {
        this.eMS.removeMessages(202);
        this.eMS.removeMessages(203);
    }

    private void ayS() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUr);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUs);
    }

    private void bal() {
        ayS();
        bak();
        if (this.cUg != null && this.cUe != null && this.Be != null) {
            if (i.agq().isShowImages() && this.FT != null && this.FT.aiX() != null) {
                this.cUe.setVisibility(0);
                this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
                this.cUg.startLoad(this.FT.aiX().thumbnail_url, 10, false);
                stopPlay();
                this.cmf = this.FT.aiX().video_url;
                if (StringUtils.isNull(this.cmf)) {
                    j(true, 4);
                    TiebaStatic.log(new an("c12026").bS("tid", this.FT.getId()));
                }
                if (this.ePD != null && this.ePD.ccy() != null) {
                    this.ePD.ccy().g(this.FT.aiX());
                    return;
                }
                return;
            }
            this.cUe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dTp, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cUh, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.cUi, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUf, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUm, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.cUj, R.color.common_color_10014);
            am.setBackgroundColor(this.deR, R.color.cp_bg_line_c);
            if (this.cUi != null) {
                this.cUi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dUf != null && this.dUf.getVisibility() == 0) {
                this.dUf.onChangeSkinType();
            }
            this.dTr.onChangeSkinType();
            this.mSkinType = i;
            this.dTq.onChangeSkinType();
            if (this.eMH != null && this.eMH.getHeadView() != null && (this.eMH.getHeadView() instanceof TbImageView)) {
                this.eMH.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            }
            this.cUg.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.fFw.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
        this.currentPageType = i;
        if (this.dTr != null) {
            this.dTr.cqT = i;
            if (i == 15) {
                this.dTr.setFrom(10);
            } else {
                this.dTr.setFrom(2);
                this.dTr.setDisPraiseFrom(2);
            }
        }
        if (this.dTq != null) {
            if (i == 15) {
                this.dTq.setFrom(5);
            } else {
                this.dTq.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.eMM;
    }

    public boolean isPlaying() {
        if (this.Be == null) {
            return false;
        }
        return this.Be.isPlaying();
    }

    public void startPlay() {
        if (!this.eMM && this.FT != null && this.FT.aiX() != null && this.Be != null) {
            this.Be.stopPlayback();
            if (ac.axV()) {
                if (this.fFx || com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1) {
                    j(true, 2);
                    if (StringUtils.isNull(this.cmf)) {
                        TiebaStatic.log(new an("c12619").bS("obj_locate", "frs").bS("tid", this.FT.getId()));
                        this.cmf = this.FT.aiX().video_url;
                    }
                    this.eMM = true;
                    this.Be.setVideoPath(this.cmf, this.FT.getId());
                    if (this.dwy != null) {
                        this.dwy.start();
                    }
                    bae();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        if (this.FT != null && this.FT.aiX() != null) {
            String str = this.FT.ajH() ? ConstantData.VideoLocationType.FRS_5FLOOR : "frs";
            if (this.FT.aiK()) {
                str = "frs_mcn";
            }
            if (this.fFy == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.cmS = this.FT.getTid();
            zVar.ePT = this.FT.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.FT.mRecomSource;
            zVar.iza = this.FT.mRecomAbTag;
            zVar.izb = this.FT.mRecomWeight;
            zVar.izc = "";
            zVar.ize = this.FT.aiX().video_md5;
            com.baidu.tieba.play.l.a(this.FT.aiX().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        ayS();
        bak();
        j(true, 1);
        if (this.Be != null) {
            this.Be.stopPlayback();
            if (this.dwy != null) {
                this.dwy.stop();
            }
        }
        this.eMM = false;
    }

    public View getVideoContainer() {
        return this.cUe;
    }

    public String getPlayUrl() {
        return this.cmf;
    }

    public int getCurrentPosition() {
        if (this.Be == null) {
            return 0;
        }
        return this.Be.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.ePD != null) {
            this.ePD.setVideoStatsData(zVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dTr != null && this.dTq != null) {
            this.dTq.setPageUniqueId(bdUniqueId);
        }
    }

    public void mZ(int i) {
        if (this.FT != null) {
            if (i == 1) {
                this.dTr.setVisibility(8);
                this.dUf.setData(this.FT);
                this.dTs.setVisibility(8);
                return;
            }
            this.dTr.setData(this.FT);
            this.dTs.setVisibility(8);
            this.dUf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cUg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.h(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cUg.setOnDrawListener(null);
        }
    }
}
