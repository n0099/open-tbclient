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
    private QuickVideoView TD;
    private bg XS;
    private String YA;
    private final View.OnClickListener ZG;
    private Animation aeZ;
    private String bCG;
    private String bNl;
    private final View.OnClickListener bRz;
    public FrameLayout cAb;
    private TextView cAc;
    private TbImageView cAd;
    private ImageView cAe;
    private TextView cAf;
    private View cAg;
    private x cAh;
    private View cAi;
    private TextView cAj;
    private int cAk;
    private TbImageView.a cAl;
    private g.b cAm;
    private ViewTreeObserver.OnGlobalLayoutListener cAn;
    private Runnable cAo;
    private Runnable cAp;
    private QuickVideoView.b cAq;
    private g.a cJF;
    private g.f cJG;
    private g.e cJI;
    private View cKK;
    private j dbd;
    private RelativeLayout dqt;
    public ThreadUserInfoLayout dqu;
    public ThreadCommentAndPraiseInfoLayout dqv;
    public View dqw;
    protected ThreadSourceShareAndPraiseLayout drk;
    public LinearLayout drv;
    public ThreadSkinView drw;
    private ThreadGodReplyLayout ehJ;
    private HeadPendantClickableView ehK;
    private g ehL;
    private k ehN;
    private int ehP;
    private boolean ehQ;
    private TextView ehV;
    private Handler ehW;
    private VideoLoadingProgressView.a ehX;
    private j.a eic;
    private Animation.AnimationListener eid;
    private TbImageView ejX;
    private LinearLayout ejt;
    private n ekJ;
    public int fiA;
    private View.OnClickListener fiB;
    public TextView fiv;
    public LinearLayout fiw;
    private com.baidu.tieba.frs.vc.g fiy;
    public boolean fiz;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aQn() {
        if (this.ehL != null && this.ehQ) {
            try {
                this.TD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ehW.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehP = 0;
        this.cAk = 1;
        this.ehQ = false;
        this.ehW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aQs();
                        return;
                    case 203:
                        a.this.aQt();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJG = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.ehL = gVar;
                if (a.this.ehL != null) {
                    a.this.ehL.setVolume(0.0f, 0.0f);
                }
                a.this.ehN.bEB();
                a.this.aQn();
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.i(false, 3);
                }
                return false;
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.TD.start();
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.aQu();
                a.this.i(true, 4);
                a.this.ehQ = false;
                return true;
            }
        };
        this.ehX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aQn();
            }
        };
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && a.this.cAd != null) {
                    a.this.cAd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAn = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cAb != null && a.this.cAb.getLayoutParams() != null && a.this.cAb.getVisibility() != 8) {
                    a.this.cAb.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cAb.getLayoutParams();
                    if (a.this.cAb.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cAb.getWidth() * 0.5625d);
                        a.this.cAb.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cAo = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.TD != null && !a.this.TD.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cAp = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aQu();
                a.this.i(true, 4);
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fiB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XS != null && !StringUtils.isNull(a.this.XS.YW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.XS.YW(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bRz != null) {
                        a.this.bRz.onClick(view);
                    }
                }
            }
        };
        this.ZG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.XS);
                }
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XS != null && a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.XS);
                }
            }
        };
        this.eic = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                a.this.aQo();
            }
        };
        this.eid = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cAk == 3 && a.this.cAd != null) {
                    a.this.cAd.setVisibility(8);
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
        this.cKK = view.findViewById(d.g.divider_line);
        this.dqt = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ejX = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.fiw = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqt.setOnClickListener(this);
        this.ehK = (HeadPendantClickableView) this.dqt.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehK.getHeadView() != null) {
            this.ehK.getHeadView().setIsRound(true);
            this.ehK.getHeadView().setDrawBorder(false);
            this.ehK.getHeadView().setDefaultResource(17170445);
            this.ehK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehK.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehK.setHasPendantStyle();
        if (this.ehK.getPendantView() != null) {
            this.ehK.getPendantView().setIsRound(true);
            this.ehK.getPendantView().setDrawBorder(false);
        }
        this.fiv = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.fiv.setVisibility(8);
        this.fiv.setOnClickListener(this.fiB);
        this.cAh = new x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAh.setLoadingAnimationListener(this.ehX);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.dqv.setForumAfterClickListener(this.bRz);
        this.dqu = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.dqu.setFrom(3);
        this.dqw = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.dqv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqv.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqv.setLayoutParams(layoutParams);
        }
        this.dqv.setOnClickListener(this);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setIsBarViewVisible(false);
        this.dqv.setShareVisible(true);
        this.dqv.setShareReportFrom(1);
        this.dqv.setStType("frs_page");
        this.dqv.setFrom(2);
        this.dqv.setDisPraiseFrom(2);
        this.dqv.bSH = 3;
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.drk.bTz.setOnClickListener(this);
        this.drk.setFrom(2);
        this.drk.setShareReportFrom(1);
        this.drk.setSourceFromForPb(3);
        this.drk.setStType("frs_page");
        this.drk.setHideBarName(true);
        this.cAb = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cAb.setOnClickListener(this);
        this.cAb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cAb != null) {
                    a.this.cAb.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cAn);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cAb != null) {
                    a.this.cAb.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cAn);
                }
            }
        });
        this.cAd = (TbImageView) view.findViewById(d.g.image_video);
        this.cAd.setPageId(getTag());
        this.cAd.setDefaultErrorResource(0);
        this.cAd.setDrawCorner(true);
        this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAd.setEvent(this.cAl);
        this.cAd.setGifIconSupport(false);
        this.cAe = (ImageView) view.findViewById(d.g.image_video_play);
        this.TD = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.ekJ = new n(this.mContext.getPageActivity());
        this.TD.setPlayerReuseEnable(true);
        this.TD.setContinuePlayEnable(true);
        this.TD.setBusiness(this.ekJ);
        this.TD.setOnPreparedListener(this.cJG);
        this.TD.setOnCompletionListener(this.cJF);
        this.TD.setOnErrorListener(this.cAm);
        this.TD.setOnOutInfoListener(this.cJI);
        this.TD.setOnSurfaceDestroyedListener(this.cAq);
        this.dbd = new j();
        this.dbd.setPlayer(this.TD);
        this.dbd.a(this.eic);
        this.cAi = view.findViewById(d.g.auto_video_black_mask);
        this.cAf = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAg = view.findViewById(d.g.auto_video_error_background);
        this.drv = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.drw = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.aeZ = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.aeZ.setAnimationListener(this.eid);
        this.cAc = (TextView) view.findViewById(d.g.text_video_duration);
        this.cAj = (TextView) view.findViewById(d.g.text_video_play_count);
        this.ejt = (LinearLayout) view.findViewById(d.g.duration_container);
        this.fiy = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dqt);
        this.fiy.setUniqueId(getTag());
        this.ehJ = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehJ.setOnClickListener(this);
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dqv != null) {
                    a.this.dqv.changeSelectStatus();
                }
            }
        });
        this.dqv.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                if (a.this.mMaskView != null) {
                    al.l(a.this.mMaskView, z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
                }
            }
        });
        this.ehV = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehN = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqt || view == this.dqv.getCommentNumView() || view == this.fiw) {
            bz(this.dqt);
        } else if (view == this.cAb) {
            if (this.XS != null && this.XS.Zi() != null) {
                z = this.XS.Zi().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bI(this.cAb);
            } else {
                bz(this.cAb);
            }
        } else if (view == this.ehJ) {
            bz(this.ehJ);
        }
        if (this.XS != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.XS));
        }
    }

    private void bx(View view) {
        if (aQh() != null) {
            aQh().a(view, this.XS);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQp();
        }
    }

    private void aQp() {
        if (this.XS != null) {
            String str = "frs";
            if (this.fiA == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.XS);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bI(View view) {
        if (this.XS != null) {
            am amVar = new am("c11100");
            amVar.bJ("tid", this.XS.getId());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.XS.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (aQh() != null) {
            aQh().a(view, this.XS);
        }
        if (view == this.cAb) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
            } else {
                aQq();
            }
        }
    }

    private void aQq() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.XS);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.drv.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.drv.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fiA == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.XS.getTid(), com.baidu.tieba.card.n.YE(), "", videoSerializeVideoThreadInfo)));
    }

    private void bz(View view) {
        String str;
        String str2;
        if (this.XS != null) {
            if (this.XS.ZS()) {
                TiebaStatic.log(new am("c10242").bJ(ImageViewerConfig.FORUM_ID, String.valueOf(this.XS.getFid())).T("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.bJ("tid", this.XS.getId());
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.XS.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.XS.YR() != null && this.XS.YR().getGodUserData() != null && this.XS.YR().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").T("obj_locate", 3).bJ("tid", this.XS.getId()));
            }
        }
        if (aQh() != null) {
            aQh().a(view, this.XS);
        }
        if (this.XS != null) {
            com.baidu.tieba.card.n.tA(this.XS.getId());
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
            y.pL(this.XS.getId());
            String valueOf = String.valueOf(this.XS.getFid());
            if (this.XS.bDE == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.XS.bDE.id;
                str2 = valueOf;
            }
            if (this.XS.Zn() > 0 && com.baidu.tieba.tbadkCore.util.e.cft()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.XS.getTid(), String.valueOf(this.XS.Zn()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fiA == 501) {
                    str3 = "frs_tab";
                } else if (this.XS.ZS()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.XS.aaa());
                createHistoryCfg.setSmartFrsPosition(this.XS.aah());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.ehJ) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.XS, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fiA == 501) {
                str4 = "frs_tab";
            } else if (this.XS.ZS()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.XS.aaa());
            createFromThreadCfg.setSmartFrsPosition(this.XS.aah());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.ehJ) {
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
        this.XS = bgVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQs() {
        this.ehW.removeMessages(202);
        if (this.TD.getCurrentPosition() > 0) {
            i(false, 3);
            this.ehW.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.ehW.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQt() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ehW.removeMessages(203);
        int currentPosition = this.TD.getCurrentPosition();
        if (currentPosition != this.ehP) {
            this.ehP = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.ehW.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cAe != null && this.cAd != null && this.cAi != null && this.cAh != null && this.cAg != null && this.cAf != null) {
            if (z || this.cAk != i) {
                this.cAk = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAp);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAo);
                if (i == 2) {
                    this.cAe.setVisibility(8);
                    this.aeZ.cancel();
                    this.cAd.clearAnimation();
                    this.cAd.setVisibility(0);
                    this.cAi.setVisibility(0);
                    this.ejt.setVisibility(0);
                    this.cAh.startLoading();
                    this.cAg.setVisibility(8);
                    this.cAf.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAp, 60000L);
                } else if (i == 3) {
                    this.cAe.setVisibility(8);
                    this.cAd.startAnimation(this.aeZ);
                    this.cAi.setVisibility(8);
                    this.ejt.setVisibility(8);
                    this.cAh.bTQ();
                    this.cAg.setVisibility(8);
                    this.cAf.setVisibility(8);
                    if (this.XS != null && this.XS.Zi() != null) {
                        this.ehN.a(this.XS.getTid(), this.XS.Zi().video_length.intValue(), this.XS.Zi().video_duration.intValue(), "frs", this.TD);
                    }
                } else if (i == 4) {
                    this.cAe.setVisibility(8);
                    this.cAd.startAnimation(this.aeZ);
                    this.cAi.setVisibility(8);
                    this.cAh.bTR();
                    this.cAg.setVisibility(0);
                    this.cAf.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAo, 2000L);
                } else {
                    this.cAe.setVisibility(0);
                    this.ejt.setVisibility(0);
                    this.aeZ.cancel();
                    this.cAd.clearAnimation();
                    this.cAd.setVisibility(0);
                    this.cAi.setVisibility(0);
                    this.cAh.bTR();
                    this.cAg.setVisibility(8);
                    this.cAf.setVisibility(8);
                }
            }
        }
    }

    private void S(final bg bgVar) {
        if (this.ejX != null) {
            if (bgVar == null) {
                this.ejX.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDw)) {
                if (this.fiy != null && this.fiy.bjm() && (this.ejX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejX.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), d.e.tbds106);
                    this.ejX.setLayoutParams(layoutParams);
                }
                this.ejX.setVisibility(0);
                this.ejX.setImageDrawable(null);
                this.ejX.startLoad(bgVar.bDw, 10, false);
                this.ejX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bgVar.bDx, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejX.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.XS == null || this.XS.YR() == null) {
            this.dqt.setVisibility(8);
            return;
        }
        this.dqt.setVisibility(0);
        this.dqt.setOnClickListener(this);
        aQv();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCG)) {
            this.XS.bt(this.mUrl, this.bCG);
        }
        this.XS.k(false, true);
        SpannableStringBuilder Zx = this.XS.Zx();
        if (this.XS.ZE() && !StringUtils.isNull(this.XS.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.XS.getTid();
            Zx.append((CharSequence) this.XS.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(Zx));
        this.mTextTitle.setText(Zx);
        this.fiy.an(this.XS);
        S(this.XS);
        this.dqu.setData(this.XS);
        if (this.dqu.getHeaderImg() != null) {
            if (this.dqu.getIsSimpleThread()) {
                this.dqu.getHeaderImg().setVisibility(8);
                this.ehK.setVisibility(8);
            } else if (this.XS.YR() == null || this.XS.YR().getPendantData() == null || StringUtils.isNull(this.XS.YR().getPendantData().Xn())) {
                this.ehK.setVisibility(8);
                this.dqu.getHeaderImg().setVisibility(0);
                this.dqu.getHeaderImg().setData(this.XS);
            } else {
                this.dqu.getHeaderImg().setVisibility(4);
                this.ehK.setVisibility(0);
                this.ehK.setData(this.XS);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqv.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dqv.setLayoutParams(layoutParams);
        this.dqu.setUserAfterClickListener(this.ZG);
        mF(lt(1));
        this.cAc.setText(ap.hz(this.XS.Zi().video_duration.intValue() * 1000));
        this.cAj.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.XS.Zi().play_count.intValue())));
        this.ehJ.setData(this.XS.aap());
        this.ehJ.onChangeSkinType();
        if (com.baidu.tieba.card.n.tB(this.XS.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.ehJ.getGodReplyContent(), this.XS.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        if (this.XS == null || this.XS.Zi() == null) {
            z = false;
        } else {
            z = this.XS.Zi().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehV.setVisibility(0);
        } else {
            this.ehV.setVisibility(8);
        }
        if (this.dqv.isInFrsAllThread() && com.baidu.tieba.frs.a.bbF().bbG()) {
            this.mMaskView.setVisibility(0);
            if (this.XS.aaA() || this.XS.aaB()) {
                al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(d.C0277d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQu() {
        this.ehW.removeMessages(202);
        this.ehW.removeMessages(203);
    }

    private void asd() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAo);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAp);
    }

    private void aQv() {
        asd();
        aQu();
        if (this.cAd != null && this.cAb != null && this.TD != null) {
            if (i.Wy().WC() && this.XS != null && this.XS.Zi() != null) {
                this.cAb.setVisibility(0);
                this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAd.startLoad(this.XS.Zi().thumbnail_url, 10, false);
                stopPlay();
                this.bNl = this.XS.Zi().video_url;
                if (StringUtils.isNull(this.bNl)) {
                    i(true, 4);
                    TiebaStatic.log(new am("c12026").bJ("tid", this.XS.getId()));
                }
                if (this.ekJ != null && this.ekJ.bTz() != null) {
                    this.ekJ.bTz().g(this.XS.Zi());
                }
                this.TD.dE(this.bNl, this.XS.tid);
                return;
            }
            this.cAb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqt, d.f.addresslist_item_bg);
            al.c(this.cAe, d.f.btn_icon_play_video_n);
            al.j(this.cAf, d.C0277d.cp_btn_a);
            al.j(this.cAc, d.C0277d.cp_btn_a);
            al.j(this.cAj, d.C0277d.cp_btn_a);
            al.l(this.cAg, d.C0277d.common_color_10014);
            al.l(this.cKK, d.C0277d.cp_bg_line_e);
            if (this.cAf != null) {
                this.cAf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.drk != null && this.drk.getVisibility() == 0) {
                this.drk.onChangeSkinType();
            }
            this.dqv.onChangeSkinType();
            this.mSkinType = i;
            this.dqu.onChangeSkinType();
            if (this.ehK != null && this.ehK.getHeadView() != null && (this.ehK.getHeadView() instanceof TbImageView)) {
                this.ehK.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            }
            this.cAd.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.fiy.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.currentPageType = i;
        if (this.dqv != null) {
            this.dqv.bSH = i;
            if (i == 15) {
                this.dqv.setFrom(10);
            } else {
                this.dqv.setFrom(2);
                this.dqv.setDisPraiseFrom(2);
            }
        }
        if (this.dqu != null) {
            if (i == 15) {
                this.dqu.setFrom(5);
            } else {
                this.dqu.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.ehQ;
    }

    public boolean isPlaying() {
        if (this.TD == null) {
            return false;
        }
        return this.TD.isPlaying();
    }

    public void startPlay() {
        if (!this.ehQ && this.XS != null && this.XS.Zi() != null && this.TD != null) {
            this.TD.stopPlayback();
            if (ad.aqv()) {
                if (this.fiz || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.ehN.bEA();
                    i(true, 2);
                    if (StringUtils.isNull(this.bNl)) {
                        TiebaStatic.log(new am("c12619").bJ("obj_locate", "frs").bJ("tid", this.XS.getId()));
                        this.bNl = this.XS.Zi().video_url;
                    }
                    this.ehQ = true;
                    this.TD.setVideoPath(this.bNl, this.XS.getId());
                    if (this.dbd != null) {
                        this.dbd.start();
                    }
                    aQo();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.XS != null && this.XS.Zi() != null) {
            String str = this.XS.ZS() ? "floor5" : "frs";
            if (this.XS.YV()) {
                str = "frs_mcn";
            }
            if (this.fiA == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.ctu = this.XS.getTid();
            zVar.ela = this.XS.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.XS.mRecomSource;
            zVar.hYL = this.XS.mRecomAbTag;
            zVar.hYM = this.XS.mRecomWeight;
            zVar.hYN = "";
            zVar.hYP = this.XS.Zi().video_md5;
            com.baidu.tieba.play.l.a(this.XS.Zi().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        asd();
        aQu();
        i(true, 1);
        if (this.TD != null) {
            this.TD.stopPlayback();
            if (this.dbd != null) {
                this.dbd.stop();
            }
        }
        this.ehQ = false;
    }

    public View getVideoContainer() {
        return this.cAb;
    }

    public String getPlayUrl() {
        return this.bNl;
    }

    public int getCurrentPosition() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.ekJ != null) {
            this.ekJ.setVideoStatsData(zVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqv != null && this.dqu != null) {
            this.dqu.setPageUniqueId(bdUniqueId);
        }
    }

    public void mF(int i) {
        if (this.XS != null) {
            if (i == 1) {
                this.dqv.setVisibility(8);
                this.drk.setData(this.XS);
                this.dqw.setVisibility(8);
                return;
            }
            this.dqv.setData(this.XS);
            this.dqw.setVisibility(8);
            this.drk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAd.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAd.setOnDrawListener(null);
        }
    }
}
