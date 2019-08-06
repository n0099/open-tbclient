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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.j.k;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private QuickVideoView RG;
    private String WN;
    private bh We;
    private final View.OnClickListener XU;
    private Animation afI;
    private String bLg;
    private String bWh;
    public FrameLayout cJO;
    private TextView cJP;
    private TbImageView cJQ;
    private ImageView cJR;
    private TextView cJS;
    private View cJT;
    private x cJU;
    private View cJV;
    private TextView cJW;
    private int cJX;
    private TbImageView.a cJY;
    private g.b cJZ;
    private ViewTreeObserver.OnGlobalLayoutListener cKa;
    private Runnable cKb;
    private Runnable cKc;
    private QuickVideoView.b cKd;
    private g.a cTw;
    private g.f cTx;
    private g.e cTz;
    private View cUD;
    private final View.OnClickListener caC;
    private RelativeLayout dEG;
    public ThreadUserInfoLayout dEH;
    public ThreadCommentAndPraiseInfoLayout dEI;
    public View dEJ;
    public LinearLayout dFG;
    public ThreadSkinView dFH;
    protected ThreadSourceShareAndPraiseLayout dFv;
    private g dgn;
    private j dnC;
    private TextView eCB;
    private Handler eCC;
    private VideoLoadingProgressView.a eCD;
    private j.a eCI;
    private Animation.AnimationListener eCJ;
    private ThreadGodReplyLayout eCq;
    private HeadPendantClickableView eCr;
    private k eCt;
    private int eCv;
    private boolean eCw;
    private LinearLayout eDZ;
    private TbImageView eEC;
    private n eFo;
    public TextView fEo;
    public LinearLayout fEp;
    private com.baidu.tieba.frs.vc.g fEq;
    public boolean fEr;
    public int fEs;
    private View.OnClickListener fEt;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        if (this.dgn != null && this.eCw) {
            try {
                this.RG.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eCC.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eCv = 0;
        this.cJX = 1;
        this.eCw = false;
        this.eCC = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aZB();
                        return;
                    case 203:
                        a.this.aZC();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.dgn = gVar;
                if (a.this.dgn != null) {
                    a.this.dgn.setVolume(0.0f, 0.0f);
                }
                a.this.eCt.bPj();
                a.this.aZw();
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.i(false, 3);
                }
                return false;
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.RG.start();
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.aZD();
                a.this.i(true, 4);
                a.this.eCw = false;
                return true;
            }
        };
        this.eCD = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aZw();
            }
        };
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && a.this.cJQ != null) {
                    a.this.cJQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cKa = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cJO != null && a.this.cJO.getLayoutParams() != null && a.this.cJO.getVisibility() != 8) {
                    a.this.cJO.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cJO.getLayoutParams();
                    if (a.this.cJO.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cJO.getWidth() * 0.5625d);
                        a.this.cJO.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cKb = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.RG != null && !a.this.RG.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cKc = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aZD();
                a.this.i(true, 4);
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fEt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We != null && !StringUtils.isNull(a.this.We.aeD())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.We.aeD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.caC != null) {
                        a.this.caC.onClick(view);
                    }
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.We);
                }
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We != null && a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.We);
                }
            }
        };
        this.eCI = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void pU() {
                a.this.aZx();
            }
        };
        this.eCJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cJX == 3 && a.this.cJQ != null) {
                    a.this.cJQ.setVisibility(8);
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
        this.cUD = view.findViewById(R.id.divider_line);
        this.dEG = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eEC = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.fEp = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dEG.setOnClickListener(this);
        this.eCr = (HeadPendantClickableView) this.dEG.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eCr.getHeadView() != null) {
            this.eCr.getHeadView().setIsRound(true);
            this.eCr.getHeadView().setDrawBorder(false);
            this.eCr.getHeadView().setDefaultResource(17170445);
            this.eCr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCr.getHeadView().setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCr.setHasPendantStyle();
        if (this.eCr.getPendantView() != null) {
            this.eCr.getPendantView().setIsRound(true);
            this.eCr.getPendantView().setDrawBorder(false);
        }
        this.fEo = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fEo.setVisibility(8);
        this.fEo.setOnClickListener(this.fEt);
        this.cJU = new x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cJU.setLoadingAnimationListener(this.eCD);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dEI.setForumAfterClickListener(this.caC);
        this.dEH = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dEH.setFrom(3);
        this.dEJ = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.dEI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEI.setLayoutParams(layoutParams);
        }
        this.dEI.setOnClickListener(this);
        this.dEI.setReplyTimeVisible(false);
        this.dEI.setShowPraiseNum(true);
        this.dEI.setNeedAddPraiseIcon(true);
        this.dEI.setNeedAddReplyIcon(true);
        this.dEI.setIsBarViewVisible(false);
        this.dEI.setShareVisible(true);
        this.dEI.setShareReportFrom(1);
        this.dEI.setStType("frs_page");
        this.dEI.setFrom(2);
        this.dEI.setDisPraiseFrom(2);
        this.dEI.cbM = 3;
        this.dFv = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dFv.ccH.setOnClickListener(this);
        this.dFv.setFrom(2);
        this.dFv.setShareReportFrom(1);
        this.dFv.setSourceFromForPb(3);
        this.dFv.setStType("frs_page");
        this.dFv.setHideBarName(true);
        this.cJO = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cJO.setOnClickListener(this);
        this.cJO.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cJO != null) {
                    a.this.cJO.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cKa);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cJO != null) {
                    a.this.cJO.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cKa);
                }
            }
        });
        this.cJQ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJQ.setPageId(getTag());
        this.cJQ.setDefaultErrorResource(0);
        this.cJQ.setDrawCorner(true);
        this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.cJQ.setEvent(this.cJY);
        this.cJQ.setGifIconSupport(false);
        this.cJR = (ImageView) view.findViewById(R.id.image_video_play);
        this.RG = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.eFo = new n(this.mContext.getPageActivity());
        this.RG.setPlayerReuseEnable(true);
        this.RG.setContinuePlayEnable(true);
        this.RG.setBusiness(this.eFo);
        this.RG.setOnPreparedListener(this.cTx);
        this.RG.setOnCompletionListener(this.cTw);
        this.RG.setOnErrorListener(this.cJZ);
        this.RG.setOnOutInfoListener(this.cTz);
        this.RG.setOnSurfaceDestroyedListener(this.cKd);
        this.dnC = new j();
        this.dnC.setPlayer(this.RG);
        this.dnC.a(this.eCI);
        this.cJV = view.findViewById(R.id.auto_video_black_mask);
        this.cJS = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cJT = view.findViewById(R.id.auto_video_error_background);
        this.dFG = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dFH = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.afI = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.fade_out_video_cover);
        this.afI.setAnimationListener(this.eCJ);
        this.cJP = (TextView) view.findViewById(R.id.text_video_duration);
        this.cJW = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eDZ = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fEq = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dEG);
        this.fEq.setUniqueId(getTag());
        this.eCq = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eCq.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dEI != null) {
                    a.this.dEI.changeSelectStatus();
                }
            }
        });
        this.dEI.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eu(boolean z) {
                if (a.this.mMaskView != null) {
                    am.l(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.eCB = (TextView) view.findViewById(R.id.nani_video_icon);
        this.eCt = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dEG || view == this.dEI.getCommentNumView() || view == this.fEp) {
            bI(this.dEG);
        } else if (view == this.cJO) {
            if (this.We != null && this.We.aeP() != null) {
                z = this.We.aeP().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bT(this.cJO);
            } else {
                bI(this.cJO);
            }
        } else if (view == this.eCq) {
            bI(this.eCq);
        }
        if (this.We != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.We));
        }
    }

    private void bG(View view) {
        if (aZq() != null) {
            aZq().a(view, this.We);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZy();
        }
    }

    private void aZy() {
        if (this.We != null) {
            String str = "frs";
            if (this.fEs == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.We);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bT(View view) {
        if (this.We != null) {
            an anVar = new an("c11100");
            anVar.bT("tid", this.We.getId());
            anVar.bT("fid", this.We.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aZq() != null) {
            aZq().a(view, this.We);
        }
        if (view == this.cJO) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                aZz();
            }
        }
    }

    private void aZz() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.We);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.dFG.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.dFG.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fEs == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.We.getTid(), com.baidu.tieba.card.n.ael(), "", videoSerializeVideoThreadInfo)));
    }

    private void bI(View view) {
        String str;
        String str2;
        if (this.We != null) {
            if (this.We.afz()) {
                TiebaStatic.log(new an("c10242").bT("fid", String.valueOf(this.We.getFid())).P("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.bT("tid", this.We.getId());
                anVar.bT("fid", this.We.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.We.aey() != null && this.We.aey().getGodUserData() != null && this.We.aey().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").P("obj_locate", 3).bT("tid", this.We.getId()));
            }
        }
        if (aZq() != null) {
            aZq().a(view, this.We);
        }
        if (this.We != null) {
            com.baidu.tieba.card.n.vx(this.We.getId());
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
            y.rm(this.We.getId());
            String valueOf = String.valueOf(this.We.getFid());
            if (this.We.bMf == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.We.bMf.id;
                str2 = valueOf;
            }
            if (this.We.aeU() > 0 && com.baidu.tieba.tbadkCore.util.e.cqL()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.We.getTid(), String.valueOf(this.We.aeU()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fEs == 501) {
                    str3 = "frs_tab";
                } else if (this.We.afz()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.We.afH());
                createHistoryCfg.setSmartFrsPosition(this.We.afO());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.eCq) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.We, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fEs == 501) {
                str4 = "frs_tab";
            } else if (this.We.afz()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.We.afH());
            createFromThreadCfg.setSmartFrsPosition(this.We.afO());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.eCq) {
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
        this.We = bhVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZB() {
        this.eCC.removeMessages(202);
        if (this.RG.getCurrentPosition() > 0) {
            i(false, 3);
            this.eCC.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eCC.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZC() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eCC.removeMessages(203);
        int currentPosition = this.RG.getCurrentPosition();
        if (currentPosition != this.eCv) {
            this.eCv = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eCC.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cJR != null && this.cJQ != null && this.cJV != null && this.cJU != null && this.cJT != null && this.cJS != null) {
            if (z || this.cJX != i) {
                this.cJX = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKc);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKb);
                if (i == 2) {
                    this.cJR.setVisibility(8);
                    this.afI.cancel();
                    this.cJQ.clearAnimation();
                    this.cJQ.setVisibility(0);
                    this.cJV.setVisibility(0);
                    this.eDZ.setVisibility(0);
                    this.cJU.startLoading();
                    this.cJT.setVisibility(8);
                    this.cJS.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKc, 60000L);
                } else if (i == 3) {
                    this.cJR.setVisibility(8);
                    this.cJQ.startAnimation(this.afI);
                    this.cJV.setVisibility(8);
                    this.eDZ.setVisibility(8);
                    this.cJU.ceZ();
                    this.cJT.setVisibility(8);
                    this.cJS.setVisibility(8);
                    if (this.We != null && this.We.aeP() != null) {
                        this.eCt.a(this.We.getTid(), this.We.aeP().video_length.intValue(), this.We.aeP().video_duration.intValue(), "frs", this.RG);
                    }
                } else if (i == 4) {
                    this.cJR.setVisibility(8);
                    this.cJQ.startAnimation(this.afI);
                    this.cJV.setVisibility(8);
                    this.cJU.cfa();
                    this.cJT.setVisibility(0);
                    this.cJS.setVisibility(0);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cKb, 2000L);
                } else {
                    this.cJR.setVisibility(0);
                    this.eDZ.setVisibility(0);
                    this.afI.cancel();
                    this.cJQ.clearAnimation();
                    this.cJQ.setVisibility(0);
                    this.cJV.setVisibility(0);
                    this.cJU.cfa();
                    this.cJT.setVisibility(8);
                    this.cJS.setVisibility(8);
                }
            }
        }
    }

    private void S(final bh bhVar) {
        if (this.eEC != null) {
            if (bhVar == null) {
                this.eEC.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.bLW)) {
                if (this.fEq != null && this.fEq.bsV() && (this.eEC.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEC.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mContext.getContext(), R.dimen.tbds106);
                    this.eEC.setLayoutParams(layoutParams);
                }
                this.eEC.setVisibility(0);
                this.eEC.setImageDrawable(null);
                this.eEC.startLoad(bhVar.bLW, 10, false);
                this.eEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bhVar.bLX, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eEC.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.We == null || this.We.aey() == null) {
            this.dEG.setVisibility(8);
            return;
        }
        this.dEG.setVisibility(0);
        this.dEG.setOnClickListener(this);
        aZE();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLg)) {
            this.We.bC(this.mUrl, this.bLg);
        }
        this.We.m(false, true);
        SpannableStringBuilder afe = this.We.afe();
        if (this.We.afl() && !StringUtils.isNull(this.We.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.We.getTid();
            afe.append((CharSequence) this.We.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(afe));
        this.mTextTitle.setText(afe);
        this.fEq.an(this.We);
        S(this.We);
        this.dEH.setData(this.We);
        if (this.dEH.getHeaderImg() != null) {
            if (this.dEH.getIsSimpleThread()) {
                this.dEH.getHeaderImg().setVisibility(8);
                this.eCr.setVisibility(8);
            } else if (this.We.aey() == null || this.We.aey().getPendantData() == null || StringUtils.isNull(this.We.aey().getPendantData().acV())) {
                this.eCr.setVisibility(8);
                this.dEH.getHeaderImg().setVisibility(0);
                this.dEH.getHeaderImg().setData(this.We);
            } else {
                this.dEH.getHeaderImg().setVisibility(4);
                this.eCr.setVisibility(0);
                this.eCr.setData(this.We);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEI.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dEI.setLayoutParams(layoutParams);
        this.dEH.setUserAfterClickListener(this.XU);
        nF(mp(1));
        this.cJP.setText(aq.is(this.We.aeP().video_duration.intValue() * 1000));
        this.cJW.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.We.aeP().play_count.intValue())));
        this.eCq.setData(this.We.afW());
        this.eCq.onChangeSkinType();
        if (com.baidu.tieba.card.n.vy(this.We.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.eCq.getGodReplyContent(), this.We.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.We == null || this.We.aeP() == null) {
            z = false;
        } else {
            z = this.We.aeP().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eCB.setVisibility(0);
        } else {
            this.eCB.setVisibility(8);
        }
        if (this.dEI.isInFrsAllThread() && com.baidu.tieba.frs.a.blf().blg()) {
            this.mMaskView.setVisibility(0);
            if (this.We.agh() || this.We.agi()) {
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
    public void aZD() {
        this.eCC.removeMessages(202);
        this.eCC.removeMessages(203);
    }

    private void ayu() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKb);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKc);
    }

    private void aZE() {
        ayu();
        aZD();
        if (this.cJQ != null && this.cJO != null && this.RG != null) {
            if (i.aca().ace() && this.We != null && this.We.aeP() != null) {
                this.cJO.setVisibility(0);
                this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
                this.cJQ.startLoad(this.We.aeP().thumbnail_url, 10, false);
                stopPlay();
                this.bWh = this.We.aeP().video_url;
                if (StringUtils.isNull(this.bWh)) {
                    i(true, 4);
                    TiebaStatic.log(new an("c12026").bT("tid", this.We.getId()));
                }
                if (this.eFo != null && this.eFo.ceI() != null) {
                    this.eFo.ceI().g(this.We.aeP());
                }
                this.RG.dS(this.bWh, this.We.tid);
                return;
            }
            this.cJO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dEG, R.drawable.addresslist_item_bg);
            am.c(this.cJR, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cJS, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            am.j(this.cJW, R.color.cp_btn_a);
            am.l(this.cJT, R.color.common_color_10014);
            am.l(this.cUD, R.color.cp_bg_line_e);
            if (this.cJS != null) {
                this.cJS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dFv != null && this.dFv.getVisibility() == 0) {
                this.dFv.onChangeSkinType();
            }
            this.dEI.onChangeSkinType();
            this.mSkinType = i;
            this.dEH.onChangeSkinType();
            if (this.eCr != null && this.eCr.getHeadView() != null && (this.eCr.getHeadView() instanceof TbImageView)) {
                this.eCr.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            }
            this.cJQ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.fEq.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nD(int i) {
        this.currentPageType = i;
        if (this.dEI != null) {
            this.dEI.cbM = i;
            if (i == 15) {
                this.dEI.setFrom(10);
            } else {
                this.dEI.setFrom(2);
                this.dEI.setDisPraiseFrom(2);
            }
        }
        if (this.dEH != null) {
            if (i == 15) {
                this.dEH.setFrom(5);
            } else {
                this.dEH.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.eCw;
    }

    public boolean isPlaying() {
        if (this.RG == null) {
            return false;
        }
        return this.RG.isPlaying();
    }

    public void startPlay() {
        if (!this.eCw && this.We != null && this.We.aeP() != null && this.RG != null) {
            this.RG.cey();
            if (ad.awJ()) {
                if (this.fEr || com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("auto_play_video_frs", 0) == 1) {
                    this.eCt.bPi();
                    i(true, 2);
                    if (StringUtils.isNull(this.bWh)) {
                        TiebaStatic.log(new an("c12619").bT("obj_locate", "frs").bT("tid", this.We.getId()));
                        this.bWh = this.We.aeP().video_url;
                    }
                    this.eCw = true;
                    this.RG.setVideoPath(this.bWh, this.We.getId());
                    if (this.dnC != null) {
                        this.dnC.start();
                    }
                    aZx();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZx() {
        if (this.We != null && this.We.aeP() != null) {
            String str = this.We.afz() ? "floor5" : "frs";
            if (this.We.aeC()) {
                str = "frs_mcn";
            }
            if (this.fEs == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.bWU = this.We.getTid();
            zVar.eFF = this.We.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.We.mRecomSource;
            zVar.iyB = this.We.mRecomAbTag;
            zVar.iyC = this.We.mRecomWeight;
            zVar.iyD = "";
            zVar.iyF = this.We.aeP().video_md5;
            com.baidu.tieba.play.l.a(this.We.aeP().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        ayu();
        aZD();
        i(true, 1);
        if (this.RG != null) {
            this.RG.cey();
            if (this.dnC != null) {
                this.dnC.stop();
            }
        }
        this.eCw = false;
    }

    public View getVideoContainer() {
        return this.cJO;
    }

    public String getPlayUrl() {
        return this.bWh;
    }

    public int getCurrentPosition() {
        if (this.RG == null) {
            return 0;
        }
        return this.RG.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.eFo != null) {
            this.eFo.setVideoStatsData(zVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dEI != null && this.dEH != null) {
            this.dEH.setPageUniqueId(bdUniqueId);
        }
    }

    public void nF(int i) {
        if (this.We != null) {
            if (i == 1) {
                this.dEI.setVisibility(8);
                this.dFv.setData(this.We);
                this.dEJ.setVisibility(8);
                return;
            }
            this.dEI.setData(this.We);
            this.dEJ.setVisibility(8);
            this.dFv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mp(int i) {
        return com.baidu.tieba.a.d.aCH().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cJQ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cJQ.setOnDrawListener(null);
        }
    }
}
