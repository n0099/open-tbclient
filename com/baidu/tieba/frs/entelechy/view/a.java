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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.z;
import com.baidu.tieba.d;
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
    private QuickVideoView TC;
    private bg XR;
    private String Yz;
    private final View.OnClickListener ZF;
    private Animation aeY;
    private String bCE;
    private String bNk;
    private final View.OnClickListener bRy;
    public FrameLayout cAe;
    private TextView cAf;
    private TbImageView cAg;
    private ImageView cAh;
    private TextView cAi;
    private View cAj;
    private x cAk;
    private View cAl;
    private TextView cAm;
    private int cAn;
    private TbImageView.a cAo;
    private g.b cAp;
    private ViewTreeObserver.OnGlobalLayoutListener cAq;
    private Runnable cAr;
    private Runnable cAs;
    private QuickVideoView.b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.e cJL;
    private View cKN;
    private j dbh;
    public View dqA;
    private RelativeLayout dqx;
    public ThreadUserInfoLayout dqy;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSkinView drA;
    protected ThreadSourceShareAndPraiseLayout dro;
    public LinearLayout drz;
    private ThreadGodReplyLayout ehN;
    private HeadPendantClickableView ehO;
    private g ehP;
    private k ehR;
    private int ehT;
    private boolean ehU;
    private TextView ehZ;
    private Handler eia;
    private VideoLoadingProgressView.a eib;
    private j.a eig;
    private Animation.AnimationListener eih;
    private LinearLayout ejx;
    private n ekN;
    private TbImageView ekb;
    public boolean fiA;
    public int fiB;
    private View.OnClickListener fiC;
    public TextView fiw;
    public LinearLayout fiy;
    private com.baidu.tieba.frs.vc.g fiz;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.ehP != null && this.ehU) {
            try {
                this.TC.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eia.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehT = 0;
        this.cAn = 1;
        this.ehU = false;
        this.eia = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aQt();
                        return;
                    case 203:
                        a.this.aQu();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJJ = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.ehP = gVar;
                if (a.this.ehP != null) {
                    a.this.ehP.setVolume(0.0f, 0.0f);
                }
                a.this.ehR.bEC();
                a.this.aQo();
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.i(false, 3);
                }
                return false;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.TC.start();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.aQv();
                a.this.i(true, 4);
                a.this.ehU = false;
                return true;
            }
        };
        this.eib = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aQo();
            }
        };
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && a.this.cAg != null) {
                    a.this.cAg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAq = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cAe != null && a.this.cAe.getLayoutParams() != null && a.this.cAe.getVisibility() != 8) {
                    a.this.cAe.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cAe.getLayoutParams();
                    if (a.this.cAe.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cAe.getWidth() * 0.5625d);
                        a.this.cAe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.TC != null && !a.this.TC.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cAs = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aQv();
                a.this.i(true, 4);
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fiC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XR != null && !StringUtils.isNull(a.this.XR.YW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.XR.YW(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bRy != null) {
                        a.this.bRy.onClick(view);
                    }
                }
            }
        };
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQi() != null) {
                    a.this.aQi().a(view, a.this.XR);
                }
            }
        };
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XR != null && a.this.aQi() != null) {
                    a.this.aQi().a(view, a.this.XR);
                }
            }
        };
        this.eig = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                a.this.aQp();
            }
        };
        this.eih = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cAn == 3 && a.this.cAg != null) {
                    a.this.cAg.setVisibility(8);
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
        this.cKN = view.findViewById(d.g.divider_line);
        this.dqx = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ekb = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.fiy = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqx.setOnClickListener(this);
        this.ehO = (HeadPendantClickableView) this.dqx.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehO.getHeadView() != null) {
            this.ehO.getHeadView().setIsRound(true);
            this.ehO.getHeadView().setDrawBorder(false);
            this.ehO.getHeadView().setDefaultResource(17170445);
            this.ehO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehO.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehO.setHasPendantStyle();
        if (this.ehO.getPendantView() != null) {
            this.ehO.getPendantView().setIsRound(true);
            this.ehO.getPendantView().setDrawBorder(false);
        }
        this.fiw = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.fiw.setVisibility(8);
        this.fiw.setOnClickListener(this.fiC);
        this.cAk = new x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.eib);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.dqz.setForumAfterClickListener(this.bRy);
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.dqy.setFrom(3);
        this.dqA = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShareVisible(true);
        this.dqz.setShareReportFrom(1);
        this.dqz.setStType("frs_page");
        this.dqz.setFrom(2);
        this.dqz.setDisPraiseFrom(2);
        this.dqz.bSG = 3;
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.dro.bTy.setOnClickListener(this);
        this.dro.setFrom(2);
        this.dro.setShareReportFrom(1);
        this.dro.setSourceFromForPb(3);
        this.dro.setStType("frs_page");
        this.dro.setHideBarName(true);
        this.cAe = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cAe.setOnClickListener(this);
        this.cAe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cAe != null) {
                    a.this.cAe.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cAq);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cAe != null) {
                    a.this.cAe.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cAq);
                }
            }
        });
        this.cAg = (TbImageView) view.findViewById(d.g.image_video);
        this.cAg.setPageId(getTag());
        this.cAg.setDefaultErrorResource(0);
        this.cAg.setDrawCorner(true);
        this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAg.setEvent(this.cAo);
        this.cAg.setGifIconSupport(false);
        this.cAh = (ImageView) view.findViewById(d.g.image_video_play);
        this.TC = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.ekN = new n(this.mContext.getPageActivity());
        this.TC.setPlayerReuseEnable(true);
        this.TC.setContinuePlayEnable(true);
        this.TC.setBusiness(this.ekN);
        this.TC.setOnPreparedListener(this.cJJ);
        this.TC.setOnCompletionListener(this.cJI);
        this.TC.setOnErrorListener(this.cAp);
        this.TC.setOnOutInfoListener(this.cJL);
        this.TC.setOnSurfaceDestroyedListener(this.cAt);
        this.dbh = new j();
        this.dbh.setPlayer(this.TC);
        this.dbh.a(this.eig);
        this.cAl = view.findViewById(d.g.auto_video_black_mask);
        this.cAi = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAj = view.findViewById(d.g.auto_video_error_background);
        this.drz = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.drA = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.aeY = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.aeY.setAnimationListener(this.eih);
        this.cAf = (TextView) view.findViewById(d.g.text_video_duration);
        this.cAm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.ejx = (LinearLayout) view.findViewById(d.g.duration_container);
        this.fiz = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dqx);
        this.fiz.setUniqueId(getTag());
        this.ehN = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehN.setOnClickListener(this);
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dqz != null) {
                    a.this.dqz.changeSelectStatus();
                }
            }
        });
        this.dqz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                if (a.this.mMaskView != null) {
                    al.l(a.this.mMaskView, z ? d.C0236d.cp_bg_line_d : d.C0236d.transparent);
                }
            }
        });
        this.ehZ = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehR = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqx || view == this.dqz.getCommentNumView() || view == this.fiy) {
            bz(this.dqx);
        } else if (view == this.cAe) {
            if (this.XR != null && this.XR.Zi() != null) {
                z = this.XR.Zi().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bI(this.cAe);
            } else {
                bz(this.cAe);
            }
        } else if (view == this.ehN) {
            bz(this.ehN);
        }
        if (this.XR != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.XR));
        }
    }

    private void bx(View view) {
        if (aQi() != null) {
            aQi().a(view, this.XR);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQq();
        }
    }

    private void aQq() {
        if (this.XR != null) {
            String str = "frs";
            if (this.fiB == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.XR);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bI(View view) {
        if (this.XR != null) {
            am amVar = new am("c11100");
            amVar.bJ("tid", this.XR.getId());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.XR.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (aQi() != null) {
            aQi().a(view, this.XR);
        }
        if (view == this.cAe) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
            } else {
                aQr();
            }
        }
    }

    private void aQr() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.XR);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.drz.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.drz.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fiB == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.XR.getTid(), com.baidu.tieba.card.n.YE(), "", videoSerializeVideoThreadInfo)));
    }

    private void bz(View view) {
        String str;
        String str2;
        if (this.XR != null) {
            if (this.XR.ZS()) {
                TiebaStatic.log(new am("c10242").bJ(ImageViewerConfig.FORUM_ID, String.valueOf(this.XR.getFid())).T("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.bJ("tid", this.XR.getId());
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.XR.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.XR.YR() != null && this.XR.YR().getGodUserData() != null && this.XR.YR().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").T("obj_locate", 3).bJ("tid", this.XR.getId()));
            }
        }
        if (aQi() != null) {
            aQi().a(view, this.XR);
        }
        if (this.XR != null) {
            com.baidu.tieba.card.n.tC(this.XR.getId());
            al.d(this.mTextTitle, d.C0236d.cp_cont_d, 1);
            y.pN(this.XR.getId());
            String valueOf = String.valueOf(this.XR.getFid());
            if (this.XR.bDC == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.XR.bDC.id;
                str2 = valueOf;
            }
            if (this.XR.Zn() > 0 && com.baidu.tieba.tbadkCore.util.e.cfr()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.XR.getTid(), String.valueOf(this.XR.Zn()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fiB == 501) {
                    str3 = "frs_tab";
                } else if (this.XR.ZS()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.XR.aaa());
                createHistoryCfg.setSmartFrsPosition(this.XR.aah());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.ehN) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.XR, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fiB == 501) {
                str4 = "frs_tab";
            } else if (this.XR.ZS()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.XR.aaa());
            createFromThreadCfg.setSmartFrsPosition(this.XR.aah());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.ehN) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        this.XR = bgVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        this.eia.removeMessages(202);
        if (this.TC.getCurrentPosition() > 0) {
            i(false, 3);
            this.eia.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.eia.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQu() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.eia.removeMessages(203);
        int currentPosition = this.TC.getCurrentPosition();
        if (currentPosition != this.ehT) {
            this.ehT = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.eia.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cAh != null && this.cAg != null && this.cAl != null && this.cAk != null && this.cAj != null && this.cAi != null) {
            if (z || this.cAn != i) {
                this.cAn = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
                if (i == 2) {
                    this.cAh.setVisibility(8);
                    this.aeY.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.ejx.setVisibility(0);
                    this.cAk.startLoading();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAs, 60000L);
                } else if (i == 3) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aeY);
                    this.cAl.setVisibility(8);
                    this.ejx.setVisibility(8);
                    this.cAk.bTO();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    if (this.XR != null && this.XR.Zi() != null) {
                        this.ehR.a(this.XR.getTid(), this.XR.Zi().video_length.intValue(), this.XR.Zi().video_duration.intValue(), "frs", this.TC);
                    }
                } else if (i == 4) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aeY);
                    this.cAl.setVisibility(8);
                    this.cAk.bTP();
                    this.cAj.setVisibility(0);
                    this.cAi.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAr, 2000L);
                } else {
                    this.cAh.setVisibility(0);
                    this.ejx.setVisibility(0);
                    this.aeY.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.cAk.bTP();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                }
            }
        }
    }

    private void S(final bg bgVar) {
        if (this.ekb != null) {
            if (bgVar == null) {
                this.ekb.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDu)) {
                if (this.fiz != null && this.fiz.bjn() && (this.ekb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ekb.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), d.e.tbds106);
                    this.ekb.setLayoutParams(layoutParams);
                }
                this.ekb.setVisibility(0);
                this.ekb.setImageDrawable(null);
                this.ekb.startLoad(bgVar.bDu, 10, false);
                this.ekb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bgVar.bDv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ekb.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.XR == null || this.XR.YR() == null) {
            this.dqx.setVisibility(8);
            return;
        }
        this.dqx.setVisibility(0);
        this.dqx.setOnClickListener(this);
        aQw();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCE)) {
            this.XR.bt(this.mUrl, this.bCE);
        }
        this.XR.k(false, true);
        SpannableStringBuilder Zx = this.XR.Zx();
        if (this.XR.ZE() && !StringUtils.isNull(this.XR.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.XR.getTid();
            Zx.append((CharSequence) this.XR.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0236d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
        this.mTextTitle.setText(Zx);
        this.fiz.an(this.XR);
        S(this.XR);
        this.dqy.setData(this.XR);
        if (this.dqy.getHeaderImg() != null) {
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehO.setVisibility(8);
            } else if (this.XR.YR() == null || this.XR.YR().getPendantData() == null || StringUtils.isNull(this.XR.YR().getPendantData().Xn())) {
                this.ehO.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(this.XR);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehO.setVisibility(0);
                this.ehO.setData(this.XR);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dqz.setLayoutParams(layoutParams);
        this.dqy.setUserAfterClickListener(this.ZF);
        mF(lt(1));
        this.cAf.setText(ap.hz(this.XR.Zi().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.XR.Zi().play_count.intValue())));
        this.ehN.setData(this.XR.aap());
        this.ehN.onChangeSkinType();
        if (com.baidu.tieba.card.n.tD(this.XR.getId())) {
            al.d(this.mTextTitle, d.C0236d.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.ehN.getGodReplyContent(), this.XR.getId(), d.C0236d.cp_cont_f, d.C0236d.cp_cont_d);
        } else {
            al.d(this.mTextTitle, d.C0236d.cp_cont_b, 1);
        }
        if (this.XR == null || this.XR.Zi() == null) {
            z = false;
        } else {
            z = this.XR.Zi().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehZ.setVisibility(0);
        } else {
            this.ehZ.setVisibility(8);
        }
        if (this.dqz.isInFrsAllThread() && com.baidu.tieba.frs.a.bbG().bbH()) {
            this.mMaskView.setVisibility(0);
            if (this.XR.aaA() || this.XR.aaB()) {
                al.l(this.mMaskView, d.C0236d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(d.C0236d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQv() {
        this.eia.removeMessages(202);
        this.eia.removeMessages(203);
    }

    private void ase() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
    }

    private void aQw() {
        ase();
        aQv();
        if (this.cAg != null && this.cAe != null && this.TC != null) {
            if (i.Wy().WC() && this.XR != null && this.XR.Zi() != null) {
                this.cAe.setVisibility(0);
                this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAg.startLoad(this.XR.Zi().thumbnail_url, 10, false);
                stopPlay();
                this.bNk = this.XR.Zi().video_url;
                if (StringUtils.isNull(this.bNk)) {
                    i(true, 4);
                    TiebaStatic.log(new am("c12026").bJ("tid", this.XR.getId()));
                }
                if (this.ekN != null && this.ekN.bTx() != null) {
                    this.ekN.bTx().g(this.XR.Zi());
                }
                this.TC.dE(this.bNk, this.XR.tid);
                return;
            }
            this.cAe.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqx, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            al.j(this.cAi, d.C0236d.cp_btn_a);
            al.j(this.cAf, d.C0236d.cp_btn_a);
            al.j(this.cAm, d.C0236d.cp_btn_a);
            al.l(this.cAj, d.C0236d.common_color_10014);
            al.l(this.cKN, d.C0236d.cp_bg_line_e);
            if (this.cAi != null) {
                this.cAi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dro != null && this.dro.getVisibility() == 0) {
                this.dro.onChangeSkinType();
            }
            this.dqz.onChangeSkinType();
            this.mSkinType = i;
            this.dqy.onChangeSkinType();
            if (this.ehO != null && this.ehO.getHeadView() != null && (this.ehO.getHeadView() instanceof TbImageView)) {
                this.ehO.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            }
            this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.fiz.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.currentPageType = i;
        if (this.dqz != null) {
            this.dqz.bSG = i;
            if (i == 15) {
                this.dqz.setFrom(10);
            } else {
                this.dqz.setFrom(2);
                this.dqz.setDisPraiseFrom(2);
            }
        }
        if (this.dqy != null) {
            if (i == 15) {
                this.dqy.setFrom(5);
            } else {
                this.dqy.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.ehU;
    }

    public boolean isPlaying() {
        if (this.TC == null) {
            return false;
        }
        return this.TC.isPlaying();
    }

    public void startPlay() {
        if (!this.ehU && this.XR != null && this.XR.Zi() != null && this.TC != null) {
            this.TC.stopPlayback();
            if (ad.aqw()) {
                if (this.fiA || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.ehR.bEB();
                    i(true, 2);
                    if (StringUtils.isNull(this.bNk)) {
                        TiebaStatic.log(new am("c12619").bJ("obj_locate", "frs").bJ("tid", this.XR.getId()));
                        this.bNk = this.XR.Zi().video_url;
                    }
                    this.ehU = true;
                    this.TC.setVideoPath(this.bNk, this.XR.getId());
                    if (this.dbh != null) {
                        this.dbh.start();
                    }
                    aQp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQp() {
        if (this.XR != null && this.XR.Zi() != null) {
            String str = this.XR.ZS() ? "floor5" : "frs";
            if (this.XR.YV()) {
                str = "frs_mcn";
            }
            if (this.fiB == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.ctx = this.XR.getTid();
            zVar.ele = this.XR.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.XR.mRecomSource;
            zVar.hYR = this.XR.mRecomAbTag;
            zVar.hYS = this.XR.mRecomWeight;
            zVar.hYT = "";
            zVar.hYV = this.XR.Zi().video_md5;
            com.baidu.tieba.play.l.a(this.XR.Zi().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        ase();
        aQv();
        i(true, 1);
        if (this.TC != null) {
            this.TC.stopPlayback();
            if (this.dbh != null) {
                this.dbh.stop();
            }
        }
        this.ehU = false;
    }

    public View getVideoContainer() {
        return this.cAe;
    }

    public String getPlayUrl() {
        return this.bNk;
    }

    public int getCurrentPosition() {
        if (this.TC == null) {
            return 0;
        }
        return this.TC.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.ekN != null) {
            this.ekN.setVideoStatsData(zVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqz != null && this.dqy != null) {
            this.dqy.setPageUniqueId(bdUniqueId);
        }
    }

    public void mF(int i) {
        if (this.XR != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setData(this.XR);
                this.dqA.setVisibility(8);
                return;
            }
            this.dqz.setData(this.XR);
            this.dqA.setVisibility(8);
            this.dro.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awl().ak(this.Yz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAg.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAg.setOnDrawListener(null);
        }
    }
}
