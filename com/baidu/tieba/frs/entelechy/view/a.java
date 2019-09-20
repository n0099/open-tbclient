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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    private QuickVideoView RF;
    private String WM;
    private bh Wd;
    private final View.OnClickListener XU;
    private Animation afI;
    private String bLE;
    private String bXa;
    public FrameLayout cKE;
    private TextView cKF;
    private TbImageView cKG;
    private ImageView cKH;
    private TextView cKI;
    private View cKJ;
    private x cKK;
    private View cKL;
    private TextView cKM;
    private int cKN;
    private TbImageView.a cKO;
    private g.b cKP;
    private ViewTreeObserver.OnGlobalLayoutListener cKQ;
    private Runnable cKR;
    private Runnable cKS;
    private QuickVideoView.b cKT;
    private g.a cUp;
    private g.f cUq;
    private g.e cUs;
    private View cVw;
    private final View.OnClickListener cbv;
    private RelativeLayout dGr;
    public ThreadUserInfoLayout dGs;
    public ThreadCommentAndPraiseInfoLayout dGt;
    public View dGu;
    protected ThreadSourceShareAndPraiseLayout dHg;
    public LinearLayout dHr;
    public ThreadSkinView dHs;
    private g dhY;
    private j dpo;
    private ThreadGodReplyLayout eDZ;
    private HeadPendantClickableView eEa;
    private int eEe;
    private boolean eEf;
    private TextView eEk;
    private Handler eEl;
    private VideoLoadingProgressView.a eEm;
    private j.a eEr;
    private Animation.AnimationListener eEs;
    private LinearLayout eFI;
    private n eGX;
    private TbImageView eGl;
    public TextView fGd;
    public LinearLayout fGe;
    private com.baidu.tieba.frs.vc.g fGf;
    public boolean fGg;
    public int fGh;
    private View.OnClickListener fGi;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void baa() {
        if (this.dhY != null && this.eEf) {
            try {
                this.RF.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eEl.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eEe = 0;
        this.cKN = 1;
        this.eEf = false;
        this.eEl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.baf();
                        return;
                    case 203:
                        a.this.bag();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.dhY = gVar;
                if (a.this.dhY != null) {
                    a.this.dhY.setVolume(0.0f, 0.0f);
                }
                a.this.baa();
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.i(false, 3);
                }
                return false;
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.RF.start();
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.bah();
                a.this.i(true, 4);
                a.this.eEf = false;
                return true;
            }
        };
        this.eEm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.baa();
            }
        };
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && a.this.cKG != null) {
                    a.this.cKG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cKQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cKE != null && a.this.cKE.getLayoutParams() != null && a.this.cKE.getVisibility() != 8) {
                    a.this.cKE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cKE.getLayoutParams();
                    if (a.this.cKE.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cKE.getWidth() * 0.5625d);
                        a.this.cKE.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cKR = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.RF != null && !a.this.RF.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cKS = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.bah();
                a.this.i(true, 4);
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fGi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Wd != null && !StringUtils.isNull(a.this.Wd.aeH())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.Wd.aeH(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.cbv != null) {
                        a.this.cbv.onClick(view);
                    }
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.Wd);
                }
            }
        };
        this.cbv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Wd != null && a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.Wd);
                }
            }
        };
        this.eEr = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void pV() {
                a.this.bab();
            }
        };
        this.eEs = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cKN == 3 && a.this.cKG != null) {
                    a.this.cKG.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mContext = tbPageContext;
        View view = getView();
        this.cVw = view.findViewById(R.id.divider_line);
        this.dGr = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eGl = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.fGe = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dGr.setOnClickListener(this);
        this.eEa = (HeadPendantClickableView) this.dGr.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eEa.getHeadView() != null) {
            this.eEa.getHeadView().setIsRound(true);
            this.eEa.getHeadView().setDrawBorder(false);
            this.eEa.getHeadView().setDefaultResource(17170445);
            this.eEa.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eEa.getHeadView().setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.eEa.setHasPendantStyle();
        if (this.eEa.getPendantView() != null) {
            this.eEa.getPendantView().setIsRound(true);
            this.eEa.getPendantView().setDrawBorder(false);
        }
        this.fGd = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fGd.setVisibility(8);
        this.fGd.setOnClickListener(this.fGi);
        this.cKK = new x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cKK.setLoadingAnimationListener(this.eEm);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dGt.setForumAfterClickListener(this.cbv);
        this.dGs = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dGs.setFrom(3);
        this.dGu = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.dGt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGt.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dGt.setLayoutParams(layoutParams);
        }
        this.dGt.setOnClickListener(this);
        this.dGt.setReplyTimeVisible(false);
        this.dGt.setShowPraiseNum(true);
        this.dGt.setNeedAddPraiseIcon(true);
        this.dGt.setNeedAddReplyIcon(true);
        this.dGt.setIsBarViewVisible(false);
        this.dGt.setShareVisible(true);
        this.dGt.setShareReportFrom(1);
        this.dGt.setStType("frs_page");
        this.dGt.setFrom(2);
        this.dGt.setDisPraiseFrom(2);
        this.dGt.ccG = 3;
        this.dHg = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dHg.cdA.setOnClickListener(this);
        this.dHg.setFrom(2);
        this.dHg.setShareReportFrom(1);
        this.dHg.setSourceFromForPb(3);
        this.dHg.setStType("frs_page");
        this.dHg.setHideBarName(true);
        this.cKE = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cKE.setOnClickListener(this);
        this.cKE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cKE != null) {
                    a.this.cKE.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cKQ);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cKE != null) {
                    a.this.cKE.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cKQ);
                }
            }
        });
        this.cKG = (TbImageView) view.findViewById(R.id.image_video);
        this.cKG.setPageId(getTag());
        this.cKG.setDefaultErrorResource(0);
        this.cKG.setDrawCorner(true);
        this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        this.cKG.setEvent(this.cKO);
        this.cKG.setGifIconSupport(false);
        this.cKH = (ImageView) view.findViewById(R.id.image_video_play);
        this.RF = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.eGX = new n(this.mContext.getPageActivity());
        this.RF.setPlayerReuseEnable(true);
        this.RF.setContinuePlayEnable(true);
        this.RF.setBusiness(this.eGX);
        this.RF.setOnPreparedListener(this.cUq);
        this.RF.setOnCompletionListener(this.cUp);
        this.RF.setOnErrorListener(this.cKP);
        this.RF.setOnOutInfoListener(this.cUs);
        this.RF.setOnSurfaceDestroyedListener(this.cKT);
        this.RF.setPageTypeForPerfStat("frs");
        this.dpo = new j();
        this.dpo.setPlayer(this.RF);
        this.dpo.a(this.eEr);
        this.cKL = view.findViewById(R.id.auto_video_black_mask);
        this.cKI = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cKJ = view.findViewById(R.id.auto_video_error_background);
        this.dHr = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dHs = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.afI = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.fade_out_video_cover);
        this.afI.setAnimationListener(this.eEs);
        this.cKF = (TextView) view.findViewById(R.id.text_video_duration);
        this.cKM = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eFI = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fGf = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dGr);
        this.fGf.setUniqueId(getTag());
        this.eDZ = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eDZ.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dGt != null) {
                    a.this.dGt.changeSelectStatus();
                }
            }
        });
        this.dGt.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ex(boolean z) {
                if (a.this.mMaskView != null) {
                    am.l(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.eEk = (TextView) view.findViewById(R.id.nani_video_icon);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dGr || view == this.dGt.getCommentNumView() || view == this.fGe) {
            bI(this.dGr);
        } else if (view == this.cKE) {
            if (this.Wd != null && this.Wd.aeT() != null) {
                z = this.Wd.aeT().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bT(this.cKE);
            } else {
                bI(this.cKE);
            }
        } else if (view == this.eDZ) {
            bI(this.eDZ);
        }
        if (this.Wd != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.Wd));
        }
    }

    private void bG(View view) {
        if (aZU() != null) {
            aZU().a(view, this.Wd);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bac();
        }
    }

    private void bac() {
        if (this.Wd != null) {
            String str = "frs";
            if (this.fGh == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.Wd);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bT(View view) {
        if (this.Wd != null) {
            an anVar = new an("c11100");
            anVar.bT("tid", this.Wd.getId());
            anVar.bT("fid", this.Wd.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aZU() != null) {
            aZU().a(view, this.Wd);
        }
        if (view == this.cKE) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                bad();
            }
        }
    }

    private void bad() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.Wd);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.dHr.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.dHr.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fGh == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.Wd.getTid(), com.baidu.tieba.card.n.aep(), "", videoSerializeVideoThreadInfo)));
    }

    private void bI(View view) {
        String str;
        String str2;
        if (this.Wd != null) {
            if (this.Wd.afD()) {
                TiebaStatic.log(new an("c10242").bT("fid", String.valueOf(this.Wd.getFid())).P("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.bT("tid", this.Wd.getId());
                anVar.bT("fid", this.Wd.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.Wd.aeC() != null && this.Wd.aeC().getGodUserData() != null && this.Wd.aeC().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").P("obj_locate", 3).bT("tid", this.Wd.getId()));
            }
        }
        if (aZU() != null) {
            aZU().a(view, this.Wd);
        }
        if (this.Wd != null) {
            com.baidu.tieba.card.n.vW(this.Wd.getId());
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tbadk.util.x.rx(this.Wd.getId());
            String valueOf = String.valueOf(this.Wd.getFid());
            if (this.Wd.bMD == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.Wd.bMD.id;
                str2 = valueOf;
            }
            if (this.Wd.aeY() > 0 && com.baidu.tieba.tbadkCore.util.e.crz()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.Wd.getTid(), String.valueOf(this.Wd.aeY()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fGh == 501) {
                    str3 = "frs_tab";
                } else if (this.Wd.afD()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.Wd.afL());
                createHistoryCfg.setSmartFrsPosition(this.Wd.afS());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.eDZ) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.Wd, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fGh == 501) {
                str4 = "frs_tab";
            } else if (this.Wd.afD()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.Wd.afL());
            createFromThreadCfg.setSmartFrsPosition(this.Wd.afS());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.eDZ) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        this.Wd = bhVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        this.eEl.removeMessages(202);
        if (this.RF.getCurrentPosition() > 0) {
            i(false, 3);
            this.eEl.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eEl.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bag() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eEl.removeMessages(203);
        int currentPosition = this.RF.getCurrentPosition();
        if (currentPosition != this.eEe) {
            this.eEe = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eEl.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cKH != null && this.cKG != null && this.cKL != null && this.cKK != null && this.cKJ != null && this.cKI != null) {
            if (z || this.cKN != i) {
                this.cKN = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKS);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKR);
                if (i == 2) {
                    this.cKH.setVisibility(8);
                    this.afI.cancel();
                    this.cKG.clearAnimation();
                    this.cKG.setVisibility(0);
                    this.cKL.setVisibility(0);
                    this.eFI.setVisibility(0);
                    this.cKK.startLoading();
                    this.cKJ.setVisibility(8);
                    this.cKI.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKS, 60000L);
                } else if (i == 3) {
                    this.cKH.setVisibility(8);
                    this.cKG.startAnimation(this.afI);
                    this.cKL.setVisibility(8);
                    this.eFI.setVisibility(8);
                    this.cKK.cfN();
                    this.cKJ.setVisibility(8);
                    this.cKI.setVisibility(8);
                    if (this.Wd != null && this.Wd.aeT() != null) {
                        this.Wd.aeT().video_length.intValue();
                        this.Wd.aeT().video_duration.intValue();
                        this.Wd.getTid();
                    }
                } else if (i == 4) {
                    this.cKH.setVisibility(8);
                    this.cKG.startAnimation(this.afI);
                    this.cKL.setVisibility(8);
                    this.cKK.cfO();
                    this.cKJ.setVisibility(0);
                    this.cKI.setVisibility(0);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKR, 2000L);
                } else {
                    this.cKH.setVisibility(0);
                    this.eFI.setVisibility(0);
                    this.afI.cancel();
                    this.cKG.clearAnimation();
                    this.cKG.setVisibility(0);
                    this.cKL.setVisibility(0);
                    this.cKK.cfO();
                    this.cKJ.setVisibility(8);
                    this.cKI.setVisibility(8);
                }
            }
        }
    }

    private void T(final bh bhVar) {
        if (this.eGl != null) {
            if (bhVar == null) {
                this.eGl.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.bMu)) {
                if (this.fGf != null && this.fGf.btI() && (this.eGl.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eGl.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mContext.getContext(), R.dimen.tbds106);
                    this.eGl.setLayoutParams(layoutParams);
                }
                this.eGl.setVisibility(0);
                this.eGl.setImageDrawable(null);
                this.eGl.startLoad(bhVar.bMu, 10, false);
                this.eGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bhVar.bMv, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eGl.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.Wd == null || this.Wd.aeC() == null) {
            this.dGr.setVisibility(8);
            return;
        }
        this.dGr.setVisibility(0);
        this.dGr.setOnClickListener(this);
        bai();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLE)) {
            this.Wd.bC(this.mUrl, this.bLE);
        }
        this.Wd.m(false, true);
        SpannableStringBuilder afi = this.Wd.afi();
        if (this.Wd.afp() && !StringUtils.isNull(this.Wd.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.Wd.getTid();
            afi.append((CharSequence) this.Wd.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(afi));
        this.mTextTitle.setText(afi);
        this.fGf.ao(this.Wd);
        T(this.Wd);
        this.dGs.setData(this.Wd);
        if (this.dGs.getHeaderImg() != null) {
            if (this.dGs.getIsSimpleThread()) {
                this.dGs.getHeaderImg().setVisibility(8);
                this.eEa.setVisibility(8);
            } else if (this.Wd.aeC() == null || this.Wd.aeC().getPendantData() == null || StringUtils.isNull(this.Wd.aeC().getPendantData().acZ())) {
                this.eEa.setVisibility(8);
                this.dGs.getHeaderImg().setVisibility(0);
                this.dGs.getHeaderImg().setData(this.Wd);
            } else {
                this.dGs.getHeaderImg().setVisibility(4);
                this.eEa.setVisibility(0);
                this.eEa.setData(this.Wd);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGt.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dGt.setLayoutParams(layoutParams);
        this.dGs.setUserAfterClickListener(this.XU);
        nJ(mt(1));
        this.cKF.setText(aq.it(this.Wd.aeT().video_duration.intValue() * 1000));
        this.cKM.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.Wd.aeT().play_count.intValue())));
        this.eDZ.setData(this.Wd.aga());
        this.eDZ.onChangeSkinType();
        if (com.baidu.tieba.card.n.vX(this.Wd.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.eDZ.getGodReplyContent(), this.Wd.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.Wd == null || this.Wd.aeT() == null) {
            z = false;
        } else {
            z = this.Wd.aeT().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eEk.setVisibility(0);
        } else {
            this.eEk.setVisibility(8);
        }
        if (this.dGt.isInFrsAllThread() && com.baidu.tieba.frs.a.blQ().blR()) {
            this.mMaskView.setVisibility(0);
            if (this.Wd.agl() || this.Wd.agm()) {
                am.l(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bah() {
        this.eEl.removeMessages(202);
        this.eEl.removeMessages(203);
    }

    private void ayG() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKR);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKS);
    }

    private void bai() {
        ayG();
        bah();
        if (this.cKG != null && this.cKE != null && this.RF != null) {
            if (i.ace().aci() && this.Wd != null && this.Wd.aeT() != null) {
                this.cKE.setVisibility(0);
                this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
                this.cKG.startLoad(this.Wd.aeT().thumbnail_url, 10, false);
                stopPlay();
                this.bXa = this.Wd.aeT().video_url;
                if (StringUtils.isNull(this.bXa)) {
                    i(true, 4);
                    TiebaStatic.log(new an("c12026").bT("tid", this.Wd.getId()));
                }
                if (this.eGX != null && this.eGX.cfw() != null) {
                    this.eGX.cfw().g(this.Wd.aeT());
                    return;
                }
                return;
            }
            this.cKE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dGr, R.drawable.addresslist_item_bg);
            am.c(this.cKH, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cKI, R.color.cp_cont_a);
            am.j(this.cKF, R.color.cp_cont_a);
            am.j(this.cKM, R.color.cp_cont_a);
            am.l(this.cKJ, R.color.common_color_10014);
            am.l(this.cVw, R.color.cp_bg_line_c);
            if (this.cKI != null) {
                this.cKI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dHg != null && this.dHg.getVisibility() == 0) {
                this.dHg.onChangeSkinType();
            }
            this.dGt.onChangeSkinType();
            this.mSkinType = i;
            this.dGs.onChangeSkinType();
            if (this.eEa != null && this.eEa.getHeadView() != null && (this.eEa.getHeadView() instanceof TbImageView)) {
                this.eEa.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            }
            this.cKG.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            this.fGf.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nH(int i) {
        this.currentPageType = i;
        if (this.dGt != null) {
            this.dGt.ccG = i;
            if (i == 15) {
                this.dGt.setFrom(10);
            } else {
                this.dGt.setFrom(2);
                this.dGt.setDisPraiseFrom(2);
            }
        }
        if (this.dGs != null) {
            if (i == 15) {
                this.dGs.setFrom(5);
            } else {
                this.dGs.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.eEf;
    }

    public boolean isPlaying() {
        if (this.RF == null) {
            return false;
        }
        return this.RF.isPlaying();
    }

    public void startPlay() {
        if (!this.eEf && this.Wd != null && this.Wd.aeT() != null && this.RF != null) {
            this.RF.stopPlayback();
            if (ac.awV()) {
                if (this.fGg || com.baidu.tbadk.core.sharedPref.b.ahU().getInt("auto_play_video_frs", 0) == 1) {
                    i(true, 2);
                    if (StringUtils.isNull(this.bXa)) {
                        TiebaStatic.log(new an("c12619").bT("obj_locate", "frs").bT("tid", this.Wd.getId()));
                        this.bXa = this.Wd.aeT().video_url;
                    }
                    this.eEf = true;
                    this.RF.setVideoPath(this.bXa, this.Wd.getId());
                    if (this.dpo != null) {
                        this.dpo.start();
                    }
                    bab();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.Wd != null && this.Wd.aeT() != null) {
            String str = this.Wd.afD() ? "floor5" : "frs";
            if (this.Wd.aeG()) {
                str = "frs_mcn";
            }
            if (this.fGh == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.bXN = this.Wd.getTid();
            zVar.eHo = this.Wd.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.Wd.mRecomSource;
            zVar.iAD = this.Wd.mRecomAbTag;
            zVar.iAE = this.Wd.mRecomWeight;
            zVar.iAF = "";
            zVar.iAH = this.Wd.aeT().video_md5;
            com.baidu.tieba.play.l.a(this.Wd.aeT().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        ayG();
        bah();
        i(true, 1);
        if (this.RF != null) {
            this.RF.stopPlayback();
            if (this.dpo != null) {
                this.dpo.stop();
            }
        }
        this.eEf = false;
    }

    public View getVideoContainer() {
        return this.cKE;
    }

    public String getPlayUrl() {
        return this.bXa;
    }

    public int getCurrentPosition() {
        if (this.RF == null) {
            return 0;
        }
        return this.RF.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.eGX != null) {
            this.eGX.setVideoStatsData(zVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dGt != null && this.dGs != null) {
            this.dGs.setPageUniqueId(bdUniqueId);
        }
    }

    public void nJ(int i) {
        if (this.Wd != null) {
            if (i == 1) {
                this.dGt.setVisibility(8);
                this.dHg.setData(this.Wd);
                this.dGu.setVisibility(8);
                return;
            }
            this.dGt.setData(this.Wd);
            this.dGu.setVisibility(8);
            this.dHg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public int mt(int i) {
        return com.baidu.tieba.a.d.aCV().ag(this.WM, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cKG.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cKG.setOnDrawListener(null);
        }
    }
}
