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
import com.baidu.tbadk.core.data.bg;
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
public class a extends com.baidu.tieba.card.a<bg> implements com.baidu.tieba.a.e, z {
    private QuickVideoView RG;
    private String WN;
    private bg We;
    private final View.OnClickListener XU;
    private Animation afI;
    private String bLb;
    private String bWb;
    public FrameLayout cJH;
    private TextView cJI;
    private TbImageView cJJ;
    private ImageView cJK;
    private TextView cJL;
    private View cJM;
    private x cJN;
    private View cJO;
    private TextView cJP;
    private int cJQ;
    private TbImageView.a cJR;
    private g.b cJS;
    private ViewTreeObserver.OnGlobalLayoutListener cJT;
    private Runnable cJU;
    private Runnable cJV;
    private QuickVideoView.b cJW;
    private g.a cTp;
    private g.f cTq;
    private g.e cTs;
    private View cUw;
    private final View.OnClickListener caw;
    public ThreadUserInfoLayout dEA;
    public ThreadCommentAndPraiseInfoLayout dEB;
    public View dEC;
    private RelativeLayout dEz;
    public ThreadSkinView dFA;
    protected ThreadSourceShareAndPraiseLayout dFo;
    public LinearLayout dFz;
    private g dgg;
    private j dnv;
    private j.a eCB;
    private Animation.AnimationListener eCC;
    private ThreadGodReplyLayout eCj;
    private HeadPendantClickableView eCk;
    private k eCm;
    private int eCo;
    private boolean eCp;
    private TextView eCu;
    private Handler eCv;
    private VideoLoadingProgressView.a eCw;
    private LinearLayout eDS;
    private TbImageView eEv;
    private n eFh;
    public TextView fDA;
    public LinearLayout fDB;
    private com.baidu.tieba.frs.vc.g fDC;
    public boolean fDD;
    public int fDE;
    private View.OnClickListener fDF;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aZu() {
        if (this.dgg != null && this.eCp) {
            try {
                this.RG.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eCv.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eCo = 0;
        this.cJQ = 1;
        this.eCp = false;
        this.eCv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aZz();
                        return;
                    case 203:
                        a.this.aZA();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.dgg = gVar;
                if (a.this.dgg != null) {
                    a.this.dgg.setVolume(0.0f, 0.0f);
                }
                a.this.eCm.bOV();
                a.this.aZu();
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.i(false, 3);
                }
                return false;
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.RG.start();
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.aZB();
                a.this.i(true, 4);
                a.this.eCp = false;
                return true;
            }
        };
        this.eCw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aZu();
            }
        };
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && a.this.cJJ != null) {
                    a.this.cJJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cJT = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cJH != null && a.this.cJH.getLayoutParams() != null && a.this.cJH.getVisibility() != 8) {
                    a.this.cJH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cJH.getLayoutParams();
                    if (a.this.cJH.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cJH.getWidth() * 0.5625d);
                        a.this.cJH.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cJU = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.RG != null && !a.this.RG.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cJV = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aZB();
                a.this.i(true, 4);
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fDF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We != null && !StringUtils.isNull(a.this.We.aeC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.We.aeC(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.caw != null) {
                        a.this.caw.onClick(view);
                    }
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.We);
                }
            }
        };
        this.caw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.We != null && a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.We);
                }
            }
        };
        this.eCB = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void pU() {
                a.this.aZv();
            }
        };
        this.eCC = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cJQ == 3 && a.this.cJJ != null) {
                    a.this.cJJ.setVisibility(8);
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
        this.cUw = view.findViewById(R.id.divider_line);
        this.dEz = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.eEv = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.fDB = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dEz.setOnClickListener(this);
        this.eCk = (HeadPendantClickableView) this.dEz.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.eCk.getHeadView() != null) {
            this.eCk.getHeadView().setIsRound(true);
            this.eCk.getHeadView().setDrawBorder(false);
            this.eCk.getHeadView().setDefaultResource(17170445);
            this.eCk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCk.getHeadView().setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCk.setHasPendantStyle();
        if (this.eCk.getPendantView() != null) {
            this.eCk.getPendantView().setIsRound(true);
            this.eCk.getPendantView().setDrawBorder(false);
        }
        this.fDA = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fDA.setVisibility(8);
        this.fDA.setOnClickListener(this.fDF);
        this.cJN = new x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cJN.setLoadingAnimationListener(this.eCw);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dEB.setForumAfterClickListener(this.caw);
        this.dEA = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dEA.setFrom(3);
        this.dEC = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.dEB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEB.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEB.setLayoutParams(layoutParams);
        }
        this.dEB.setOnClickListener(this);
        this.dEB.setReplyTimeVisible(false);
        this.dEB.setShowPraiseNum(true);
        this.dEB.setNeedAddPraiseIcon(true);
        this.dEB.setNeedAddReplyIcon(true);
        this.dEB.setIsBarViewVisible(false);
        this.dEB.setShareVisible(true);
        this.dEB.setShareReportFrom(1);
        this.dEB.setStType("frs_page");
        this.dEB.setFrom(2);
        this.dEB.setDisPraiseFrom(2);
        this.dEB.cbF = 3;
        this.dFo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dFo.ccA.setOnClickListener(this);
        this.dFo.setFrom(2);
        this.dFo.setShareReportFrom(1);
        this.dFo.setSourceFromForPb(3);
        this.dFo.setStType("frs_page");
        this.dFo.setHideBarName(true);
        this.cJH = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cJH.setOnClickListener(this);
        this.cJH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cJH != null) {
                    a.this.cJH.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cJT);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cJH != null) {
                    a.this.cJH.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cJT);
                }
            }
        });
        this.cJJ = (TbImageView) view.findViewById(R.id.image_video);
        this.cJJ.setPageId(getTag());
        this.cJJ.setDefaultErrorResource(0);
        this.cJJ.setDrawCorner(true);
        this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.cJJ.setEvent(this.cJR);
        this.cJJ.setGifIconSupport(false);
        this.cJK = (ImageView) view.findViewById(R.id.image_video_play);
        this.RG = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.eFh = new n(this.mContext.getPageActivity());
        this.RG.setPlayerReuseEnable(true);
        this.RG.setContinuePlayEnable(true);
        this.RG.setBusiness(this.eFh);
        this.RG.setOnPreparedListener(this.cTq);
        this.RG.setOnCompletionListener(this.cTp);
        this.RG.setOnErrorListener(this.cJS);
        this.RG.setOnOutInfoListener(this.cTs);
        this.RG.setOnSurfaceDestroyedListener(this.cJW);
        this.dnv = new j();
        this.dnv.setPlayer(this.RG);
        this.dnv.a(this.eCB);
        this.cJO = view.findViewById(R.id.auto_video_black_mask);
        this.cJL = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cJM = view.findViewById(R.id.auto_video_error_background);
        this.dFz = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dFA = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.afI = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.fade_out_video_cover);
        this.afI.setAnimationListener(this.eCC);
        this.cJI = (TextView) view.findViewById(R.id.text_video_duration);
        this.cJP = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eDS = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fDC = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dEz);
        this.fDC.setUniqueId(getTag());
        this.eCj = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.eCj.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dEB != null) {
                    a.this.dEB.changeSelectStatus();
                }
            }
        });
        this.dEB.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eu(boolean z) {
                if (a.this.mMaskView != null) {
                    am.l(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.eCu = (TextView) view.findViewById(R.id.nani_video_icon);
        this.eCm = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dEz || view == this.dEB.getCommentNumView() || view == this.fDB) {
            bI(this.dEz);
        } else if (view == this.cJH) {
            if (this.We != null && this.We.aeO() != null) {
                z = this.We.aeO().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bS(this.cJH);
            } else {
                bI(this.cJH);
            }
        } else if (view == this.eCj) {
            bI(this.eCj);
        }
        if (this.We != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.We));
        }
    }

    private void bG(View view) {
        if (aZo() != null) {
            aZo().a(view, this.We);
        }
        if (!com.baidu.adp.lib.util.j.kc()) {
            l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZw();
        }
    }

    private void aZw() {
        if (this.We != null) {
            String str = "frs";
            if (this.fDE == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.We);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bS(View view) {
        if (this.We != null) {
            an anVar = new an("c11100");
            anVar.bT("tid", this.We.getId());
            anVar.bT("fid", this.We.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aZo() != null) {
            aZo().a(view, this.We);
        }
        if (view == this.cJH) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                aZx();
            }
        }
    }

    private void aZx() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.We);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.dFz.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.dFz.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fDE == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.We.getTid(), com.baidu.tieba.card.n.aek(), "", videoSerializeVideoThreadInfo)));
    }

    private void bI(View view) {
        String str;
        String str2;
        if (this.We != null) {
            if (this.We.afy()) {
                TiebaStatic.log(new an("c10242").bT("fid", String.valueOf(this.We.getFid())).P("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.bT("tid", this.We.getId());
                anVar.bT("fid", this.We.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.We.aex() != null && this.We.aex().getGodUserData() != null && this.We.aex().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").P("obj_locate", 3).bT("tid", this.We.getId()));
            }
        }
        if (aZo() != null) {
            aZo().a(view, this.We);
        }
        if (this.We != null) {
            com.baidu.tieba.card.n.vw(this.We.getId());
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
            y.rm(this.We.getId());
            String valueOf = String.valueOf(this.We.getFid());
            if (this.We.bMa == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.We.bMa.id;
                str2 = valueOf;
            }
            if (this.We.aeT() > 0 && com.baidu.tieba.tbadkCore.util.e.cqp()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.We.getTid(), String.valueOf(this.We.aeT()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fDE == 501) {
                    str3 = "frs_tab";
                } else if (this.We.afy()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.We.afG());
                createHistoryCfg.setSmartFrsPosition(this.We.afN());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.eCj) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.We, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fDE == 501) {
                str4 = "frs_tab";
            } else if (this.We.afy()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.We.afG());
            createFromThreadCfg.setSmartFrsPosition(this.We.afN());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.eCj) {
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
    public void a(bg bgVar) {
        this.We = bgVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZz() {
        this.eCv.removeMessages(202);
        if (this.RG.getCurrentPosition() > 0) {
            i(false, 3);
            this.eCv.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eCv.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZA() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eCv.removeMessages(203);
        int currentPosition = this.RG.getCurrentPosition();
        if (currentPosition != this.eCo) {
            this.eCo = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eCv.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cJK != null && this.cJJ != null && this.cJO != null && this.cJN != null && this.cJM != null && this.cJL != null) {
            if (z || this.cJQ != i) {
                this.cJQ = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJV);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJU);
                if (i == 2) {
                    this.cJK.setVisibility(8);
                    this.afI.cancel();
                    this.cJJ.clearAnimation();
                    this.cJJ.setVisibility(0);
                    this.cJO.setVisibility(0);
                    this.eDS.setVisibility(0);
                    this.cJN.startLoading();
                    this.cJM.setVisibility(8);
                    this.cJL.setVisibility(8);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cJV, 60000L);
                } else if (i == 3) {
                    this.cJK.setVisibility(8);
                    this.cJJ.startAnimation(this.afI);
                    this.cJO.setVisibility(8);
                    this.eDS.setVisibility(8);
                    this.cJN.ceH();
                    this.cJM.setVisibility(8);
                    this.cJL.setVisibility(8);
                    if (this.We != null && this.We.aeO() != null) {
                        this.eCm.a(this.We.getTid(), this.We.aeO().video_length.intValue(), this.We.aeO().video_duration.intValue(), "frs", this.RG);
                    }
                } else if (i == 4) {
                    this.cJK.setVisibility(8);
                    this.cJJ.startAnimation(this.afI);
                    this.cJO.setVisibility(8);
                    this.cJN.ceI();
                    this.cJM.setVisibility(0);
                    this.cJL.setVisibility(0);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.cJU, 2000L);
                } else {
                    this.cJK.setVisibility(0);
                    this.eDS.setVisibility(0);
                    this.afI.cancel();
                    this.cJJ.clearAnimation();
                    this.cJJ.setVisibility(0);
                    this.cJO.setVisibility(0);
                    this.cJN.ceI();
                    this.cJM.setVisibility(8);
                    this.cJL.setVisibility(8);
                }
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.eEv != null) {
            if (bgVar == null) {
                this.eEv.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bLR)) {
                if (this.fDC != null && this.fDC.bsI() && (this.eEv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEv.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mContext.getContext(), R.dimen.tbds106);
                    this.eEv.setLayoutParams(layoutParams);
                }
                this.eEv.setVisibility(0);
                this.eEv.setImageDrawable(null);
                this.eEv.startLoad(bgVar.bLR, 10, false);
                this.eEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bgVar.bLS, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eEv.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.We == null || this.We.aex() == null) {
            this.dEz.setVisibility(8);
            return;
        }
        this.dEz.setVisibility(0);
        this.dEz.setOnClickListener(this);
        aZC();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLb)) {
            this.We.bC(this.mUrl, this.bLb);
        }
        this.We.m(false, true);
        SpannableStringBuilder afd = this.We.afd();
        if (this.We.afk() && !StringUtils.isNull(this.We.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.We.getTid();
            afd.append((CharSequence) this.We.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(afd));
        this.mTextTitle.setText(afd);
        this.fDC.am(this.We);
        R(this.We);
        this.dEA.setData(this.We);
        if (this.dEA.getHeaderImg() != null) {
            if (this.dEA.getIsSimpleThread()) {
                this.dEA.getHeaderImg().setVisibility(8);
                this.eCk.setVisibility(8);
            } else if (this.We.aex() == null || this.We.aex().getPendantData() == null || StringUtils.isNull(this.We.aex().getPendantData().acU())) {
                this.eCk.setVisibility(8);
                this.dEA.getHeaderImg().setVisibility(0);
                this.dEA.getHeaderImg().setData(this.We);
            } else {
                this.dEA.getHeaderImg().setVisibility(4);
                this.eCk.setVisibility(0);
                this.eCk.setData(this.We);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEB.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dEB.setLayoutParams(layoutParams);
        this.dEA.setUserAfterClickListener(this.XU);
        nE(mo(1));
        this.cJI.setText(aq.is(this.We.aeO().video_duration.intValue() * 1000));
        this.cJP.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.We.aeO().play_count.intValue())));
        this.eCj.setData(this.We.afV());
        this.eCj.onChangeSkinType();
        if (com.baidu.tieba.card.n.vx(this.We.getId())) {
            am.f(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.eCj.getGodReplyContent(), this.We.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            am.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.We == null || this.We.aeO() == null) {
            z = false;
        } else {
            z = this.We.aeO().is_vertical.intValue() == 1;
        }
        if (z) {
            this.eCu.setVisibility(0);
        } else {
            this.eCu.setVisibility(8);
        }
        if (this.dEB.isInFrsAllThread() && com.baidu.tieba.frs.a.bkY().bkZ()) {
            this.mMaskView.setVisibility(0);
            if (this.We.agg() || this.We.agh()) {
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
    public void aZB() {
        this.eCv.removeMessages(202);
        this.eCv.removeMessages(203);
    }

    private void ays() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJU);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJV);
    }

    private void aZC() {
        ays();
        aZB();
        if (this.cJJ != null && this.cJH != null && this.RG != null) {
            if (i.aca().ace() && this.We != null && this.We.aeO() != null) {
                this.cJH.setVisibility(0);
                this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
                this.cJJ.startLoad(this.We.aeO().thumbnail_url, 10, false);
                stopPlay();
                this.bWb = this.We.aeO().video_url;
                if (StringUtils.isNull(this.bWb)) {
                    i(true, 4);
                    TiebaStatic.log(new an("c12026").bT("tid", this.We.getId()));
                }
                if (this.eFh != null && this.eFh.ceq() != null) {
                    this.eFh.ceq().g(this.We.aeO());
                }
                this.RG.dS(this.bWb, this.We.tid);
                return;
            }
            this.cJH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.dEz, R.drawable.addresslist_item_bg);
            am.c(this.cJK, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cJL, R.color.cp_btn_a);
            am.j(this.cJI, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            am.l(this.cJM, R.color.common_color_10014);
            am.l(this.cUw, R.color.cp_bg_line_e);
            if (this.cJL != null) {
                this.cJL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dFo != null && this.dFo.getVisibility() == 0) {
                this.dFo.onChangeSkinType();
            }
            this.dEB.onChangeSkinType();
            this.mSkinType = i;
            this.dEA.onChangeSkinType();
            if (this.eCk != null && this.eCk.getHeadView() != null && (this.eCk.getHeadView() instanceof TbImageView)) {
                this.eCk.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            }
            this.cJJ.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.fDC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nC(int i) {
        this.currentPageType = i;
        if (this.dEB != null) {
            this.dEB.cbF = i;
            if (i == 15) {
                this.dEB.setFrom(10);
            } else {
                this.dEB.setFrom(2);
                this.dEB.setDisPraiseFrom(2);
            }
        }
        if (this.dEA != null) {
            if (i == 15) {
                this.dEA.setFrom(5);
            } else {
                this.dEA.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.eCp;
    }

    public boolean isPlaying() {
        if (this.RG == null) {
            return false;
        }
        return this.RG.isPlaying();
    }

    public void startPlay() {
        if (!this.eCp && this.We != null && this.We.aeO() != null && this.RG != null) {
            this.RG.ceg();
            if (ad.awH()) {
                if (this.fDD || com.baidu.tbadk.core.sharedPref.b.ahO().getInt("auto_play_video_frs", 0) == 1) {
                    this.eCm.bOU();
                    i(true, 2);
                    if (StringUtils.isNull(this.bWb)) {
                        TiebaStatic.log(new an("c12619").bT("obj_locate", "frs").bT("tid", this.We.getId()));
                        this.bWb = this.We.aeO().video_url;
                    }
                    this.eCp = true;
                    this.RG.setVideoPath(this.bWb, this.We.getId());
                    if (this.dnv != null) {
                        this.dnv.start();
                    }
                    aZv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZv() {
        if (this.We != null && this.We.aeO() != null) {
            String str = this.We.afy() ? "floor5" : "frs";
            if (this.We.aeB()) {
                str = "frs_mcn";
            }
            if (this.fDE == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.bWO = this.We.getTid();
            zVar.eFy = this.We.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.We.mRecomSource;
            zVar.ixy = this.We.mRecomAbTag;
            zVar.ixz = this.We.mRecomWeight;
            zVar.ixA = "";
            zVar.ixC = this.We.aeO().video_md5;
            com.baidu.tieba.play.l.a(this.We.aeO().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        ays();
        aZB();
        i(true, 1);
        if (this.RG != null) {
            this.RG.ceg();
            if (this.dnv != null) {
                this.dnv.stop();
            }
        }
        this.eCp = false;
    }

    public View getVideoContainer() {
        return this.cJH;
    }

    public String getPlayUrl() {
        return this.bWb;
    }

    public int getCurrentPosition() {
        if (this.RG == null) {
            return 0;
        }
        return this.RG.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.eFh != null) {
            this.eFh.setVideoStatsData(zVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dEB != null && this.dEA != null) {
            this.dEA.setPageUniqueId(bdUniqueId);
        }
    }

    public void nE(int i) {
        if (this.We != null) {
            if (i == 1) {
                this.dEB.setVisibility(8);
                this.dFo.setData(this.We);
                this.dEC.setVisibility(8);
                return;
            }
            this.dEB.setData(this.We);
            this.dEC.setVisibility(8);
            this.dFo.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mo(int i) {
        return com.baidu.tieba.a.d.aCF().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cJJ.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cJJ.setOnDrawListener(null);
        }
    }
}
