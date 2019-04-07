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
    private final View.OnClickListener ZH;
    private Animation afe;
    private String bCJ;
    private String bNn;
    private final View.OnClickListener bRB;
    public FrameLayout cAd;
    private TextView cAe;
    private TbImageView cAf;
    private ImageView cAg;
    private TextView cAh;
    private View cAi;
    private x cAj;
    private View cAk;
    private TextView cAl;
    private int cAm;
    private TbImageView.a cAn;
    private g.b cAo;
    private ViewTreeObserver.OnGlobalLayoutListener cAp;
    private Runnable cAq;
    private Runnable cAr;
    private QuickVideoView.b cAs;
    private g.a cJH;
    private g.f cJI;
    private g.e cJK;
    private View cKM;
    private j dbg;
    private RelativeLayout dqw;
    public ThreadUserInfoLayout dqx;
    public ThreadCommentAndPraiseInfoLayout dqy;
    public View dqz;
    protected ThreadSourceShareAndPraiseLayout drn;
    public LinearLayout dry;
    public ThreadSkinView drz;
    private int ehB;
    private boolean ehC;
    private TextView ehH;
    private Handler ehI;
    private VideoLoadingProgressView.a ehJ;
    private j.a ehO;
    private Animation.AnimationListener ehP;
    private ThreadGodReplyLayout ehv;
    private HeadPendantClickableView ehw;
    private g ehx;
    private k ehz;
    private TbImageView ejJ;
    private LinearLayout ejf;
    private n ekv;
    public TextView fih;
    public LinearLayout fii;
    private com.baidu.tieba.frs.vc.g fij;
    public boolean fik;
    public int fil;
    private View.OnClickListener fim;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aQl() {
        if (this.ehx != null && this.ehC) {
            try {
                this.TD.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ehI.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehB = 0;
        this.cAm = 1;
        this.ehC = false;
        this.ehI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aQq();
                        return;
                    case 203:
                        a.this.aQr();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.ehx = gVar;
                if (a.this.ehx != null) {
                    a.this.ehx.setVolume(0.0f, 0.0f);
                }
                a.this.ehz.bEy();
                a.this.aQl();
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.i(false, 3);
                }
                return false;
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.TD.start();
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.aQs();
                a.this.i(true, 4);
                a.this.ehC = false;
                return true;
            }
        };
        this.ehJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aQl();
            }
        };
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && a.this.cAf != null) {
                    a.this.cAf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAp = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cAd != null && a.this.cAd.getLayoutParams() != null && a.this.cAd.getVisibility() != 8) {
                    a.this.cAd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cAd.getLayoutParams();
                    if (a.this.cAd.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cAd.getWidth() * 0.5625d);
                        a.this.cAd.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cAq = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.TD != null && !a.this.TD.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aQs();
                a.this.i(true, 4);
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fim = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XS != null && !StringUtils.isNull(a.this.XS.YT())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.XS.YT(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bRB != null) {
                        a.this.bRB.onClick(view);
                    }
                }
            }
        };
        this.ZH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.XS);
                }
            }
        };
        this.bRB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XS != null && a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.XS);
                }
            }
        };
        this.ehO = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                a.this.aQm();
            }
        };
        this.ehP = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cAm == 3 && a.this.cAf != null) {
                    a.this.cAf.setVisibility(8);
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
        this.cKM = view.findViewById(d.g.divider_line);
        this.dqw = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.ejJ = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.fii = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqw.setOnClickListener(this);
        this.ehw = (HeadPendantClickableView) this.dqw.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehw.getHeadView() != null) {
            this.ehw.getHeadView().setIsRound(true);
            this.ehw.getHeadView().setDrawBorder(false);
            this.ehw.getHeadView().setDefaultResource(17170445);
            this.ehw.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehw.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehw.setHasPendantStyle();
        if (this.ehw.getPendantView() != null) {
            this.ehw.getPendantView().setIsRound(true);
            this.ehw.getPendantView().setDrawBorder(false);
        }
        this.fih = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.fih.setVisibility(8);
        this.fih.setOnClickListener(this.fim);
        this.cAj = new x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAj.setLoadingAnimationListener(this.ehJ);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.dqy.setForumAfterClickListener(this.bRB);
        this.dqx = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.dqx.setFrom(3);
        this.dqz = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.dqy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqy.setLayoutParams(layoutParams);
        }
        this.dqy.setOnClickListener(this);
        this.dqy.setReplyTimeVisible(false);
        this.dqy.setShowPraiseNum(true);
        this.dqy.setNeedAddPraiseIcon(true);
        this.dqy.setNeedAddReplyIcon(true);
        this.dqy.setIsBarViewVisible(false);
        this.dqy.setShareVisible(true);
        this.dqy.setShareReportFrom(1);
        this.dqy.setStType("frs_page");
        this.dqy.setFrom(2);
        this.dqy.setDisPraiseFrom(2);
        this.dqy.bSJ = 3;
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.drn.bTB.setOnClickListener(this);
        this.drn.setFrom(2);
        this.drn.setShareReportFrom(1);
        this.drn.setSourceFromForPb(3);
        this.drn.setStType("frs_page");
        this.drn.setHideBarName(true);
        this.cAd = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cAd.setOnClickListener(this);
        this.cAd.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cAd != null) {
                    a.this.cAd.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cAp);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cAd != null) {
                    a.this.cAd.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cAp);
                }
            }
        });
        this.cAf = (TbImageView) view.findViewById(d.g.image_video);
        this.cAf.setPageId(getTag());
        this.cAf.setDefaultErrorResource(0);
        this.cAf.setDrawCorner(true);
        this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cAf.setEvent(this.cAn);
        this.cAf.setGifIconSupport(false);
        this.cAg = (ImageView) view.findViewById(d.g.image_video_play);
        this.TD = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.ekv = new n(this.mContext.getPageActivity());
        this.TD.setPlayerReuseEnable(true);
        this.TD.setContinuePlayEnable(true);
        this.TD.setBusiness(this.ekv);
        this.TD.setOnPreparedListener(this.cJI);
        this.TD.setOnCompletionListener(this.cJH);
        this.TD.setOnErrorListener(this.cAo);
        this.TD.setOnOutInfoListener(this.cJK);
        this.TD.setOnSurfaceDestroyedListener(this.cAs);
        this.dbg = new j();
        this.dbg.setPlayer(this.TD);
        this.dbg.a(this.ehO);
        this.cAk = view.findViewById(d.g.auto_video_black_mask);
        this.cAh = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAi = view.findViewById(d.g.auto_video_error_background);
        this.dry = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.drz = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.afe = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.afe.setAnimationListener(this.ehP);
        this.cAe = (TextView) view.findViewById(d.g.text_video_duration);
        this.cAl = (TextView) view.findViewById(d.g.text_video_play_count);
        this.ejf = (LinearLayout) view.findViewById(d.g.duration_container);
        this.fij = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dqw);
        this.fij.setUniqueId(getTag());
        this.ehv = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehv.setOnClickListener(this);
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dqy != null) {
                    a.this.dqy.changeSelectStatus();
                }
            }
        });
        this.dqy.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                if (a.this.mMaskView != null) {
                    al.l(a.this.mMaskView, z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
                }
            }
        });
        this.ehH = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehz = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqw || view == this.dqy.getCommentNumView() || view == this.fii) {
            bz(this.dqw);
        } else if (view == this.cAd) {
            if (this.XS != null && this.XS.Zf() != null) {
                z = this.XS.Zf().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bI(this.cAd);
            } else {
                bz(this.cAd);
            }
        } else if (view == this.ehv) {
            bz(this.ehv);
        }
        if (this.XS != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.XS));
        }
    }

    private void bx(View view) {
        if (aQf() != null) {
            aQf().a(view, this.XS);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void aQn() {
        if (this.XS != null) {
            String str = "frs";
            if (this.fil == 501) {
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
        if (aQf() != null) {
            aQf().a(view, this.XS);
        }
        if (view == this.cAd) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
            } else {
                aQo();
            }
        }
    }

    private void aQo() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.XS);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.dry.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.dry.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fil == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.XS.getTid(), com.baidu.tieba.card.n.YB(), "", videoSerializeVideoThreadInfo)));
    }

    private void bz(View view) {
        String str;
        String str2;
        if (this.XS != null) {
            if (this.XS.ZP()) {
                TiebaStatic.log(new am("c10242").bJ(ImageViewerConfig.FORUM_ID, String.valueOf(this.XS.getFid())).T("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.bJ("tid", this.XS.getId());
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.XS.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.XS.YO() != null && this.XS.YO().getGodUserData() != null && this.XS.YO().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").T("obj_locate", 3).bJ("tid", this.XS.getId()));
            }
        }
        if (aQf() != null) {
            aQf().a(view, this.XS);
        }
        if (this.XS != null) {
            com.baidu.tieba.card.n.tz(this.XS.getId());
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
            y.pM(this.XS.getId());
            String valueOf = String.valueOf(this.XS.getFid());
            if (this.XS.bDH == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.XS.bDH.id;
                str2 = valueOf;
            }
            if (this.XS.Zk() > 0 && com.baidu.tieba.tbadkCore.util.e.cfp()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.XS.getTid(), String.valueOf(this.XS.Zk()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fil == 501) {
                    str3 = "frs_tab";
                } else if (this.XS.ZP()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.XS.ZX());
                createHistoryCfg.setSmartFrsPosition(this.XS.aae());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.ehv) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.XS, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fil == 501) {
                str4 = "frs_tab";
            } else if (this.XS.ZP()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.XS.ZX());
            createFromThreadCfg.setSmartFrsPosition(this.XS.aae());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.ehv) {
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
    public void aQq() {
        this.ehI.removeMessages(202);
        if (this.TD.getCurrentPosition() > 0) {
            i(false, 3);
            this.ehI.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.ehI.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQr() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ehI.removeMessages(203);
        int currentPosition = this.TD.getCurrentPosition();
        if (currentPosition != this.ehB) {
            this.ehB = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.ehI.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cAg != null && this.cAf != null && this.cAk != null && this.cAj != null && this.cAi != null && this.cAh != null) {
            if (z || this.cAm != i) {
                this.cAm = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAq);
                if (i == 2) {
                    this.cAg.setVisibility(8);
                    this.afe.cancel();
                    this.cAf.clearAnimation();
                    this.cAf.setVisibility(0);
                    this.cAk.setVisibility(0);
                    this.ejf.setVisibility(0);
                    this.cAj.startLoading();
                    this.cAi.setVisibility(8);
                    this.cAh.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAr, 60000L);
                } else if (i == 3) {
                    this.cAg.setVisibility(8);
                    this.cAf.startAnimation(this.afe);
                    this.cAk.setVisibility(8);
                    this.ejf.setVisibility(8);
                    this.cAj.bTM();
                    this.cAi.setVisibility(8);
                    this.cAh.setVisibility(8);
                    if (this.XS != null && this.XS.Zf() != null) {
                        this.ehz.a(this.XS.getTid(), this.XS.Zf().video_length.intValue(), this.XS.Zf().video_duration.intValue(), "frs", this.TD);
                    }
                } else if (i == 4) {
                    this.cAg.setVisibility(8);
                    this.cAf.startAnimation(this.afe);
                    this.cAk.setVisibility(8);
                    this.cAj.bTN();
                    this.cAi.setVisibility(0);
                    this.cAh.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAq, 2000L);
                } else {
                    this.cAg.setVisibility(0);
                    this.ejf.setVisibility(0);
                    this.afe.cancel();
                    this.cAf.clearAnimation();
                    this.cAf.setVisibility(0);
                    this.cAk.setVisibility(0);
                    this.cAj.bTN();
                    this.cAi.setVisibility(8);
                    this.cAh.setVisibility(8);
                }
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.ejJ != null) {
            if (bgVar == null) {
                this.ejJ.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDz)) {
                if (this.fij != null && this.fij.bjk() && (this.ejJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejJ.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), d.e.tbds106);
                    this.ejJ.setLayoutParams(layoutParams);
                }
                this.ejJ.setVisibility(0);
                this.ejJ.setImageDrawable(null);
                this.ejJ.startLoad(bgVar.bDz, 10, false);
                this.ejJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bgVar.bDA, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejJ.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.XS == null || this.XS.YO() == null) {
            this.dqw.setVisibility(8);
            return;
        }
        this.dqw.setVisibility(0);
        this.dqw.setOnClickListener(this);
        aQt();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCJ)) {
            this.XS.bt(this.mUrl, this.bCJ);
        }
        this.XS.k(false, true);
        SpannableStringBuilder Zu = this.XS.Zu();
        if (this.XS.ZB() && !StringUtils.isNull(this.XS.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.XS.getTid();
            Zu.append((CharSequence) this.XS.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(Zu));
        this.mTextTitle.setText(Zu);
        this.fij.am(this.XS);
        R(this.XS);
        this.dqx.setData(this.XS);
        if (this.dqx.getHeaderImg() != null) {
            if (this.dqx.getIsSimpleThread()) {
                this.dqx.getHeaderImg().setVisibility(8);
                this.ehw.setVisibility(8);
            } else if (this.XS.YO() == null || this.XS.YO().getPendantData() == null || StringUtils.isNull(this.XS.YO().getPendantData().Xk())) {
                this.ehw.setVisibility(8);
                this.dqx.getHeaderImg().setVisibility(0);
                this.dqx.getHeaderImg().setData(this.XS);
            } else {
                this.dqx.getHeaderImg().setVisibility(4);
                this.ehw.setVisibility(0);
                this.ehw.setData(this.XS);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqy.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dqy.setLayoutParams(layoutParams);
        this.dqx.setUserAfterClickListener(this.ZH);
        mE(ls(1));
        this.cAe.setText(ap.hy(this.XS.Zf().video_duration.intValue() * 1000));
        this.cAl.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.XS.Zf().play_count.intValue())));
        this.ehv.setData(this.XS.aam());
        this.ehv.onChangeSkinType();
        if (com.baidu.tieba.card.n.tA(this.XS.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.ehv.getGodReplyContent(), this.XS.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        if (this.XS == null || this.XS.Zf() == null) {
            z = false;
        } else {
            z = this.XS.Zf().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehH.setVisibility(0);
        } else {
            this.ehH.setVisibility(8);
        }
        if (this.dqy.isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.mMaskView.setVisibility(0);
            if (this.XS.aax() || this.XS.aay()) {
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
    public void aQs() {
        this.ehI.removeMessages(202);
        this.ehI.removeMessages(203);
    }

    private void asa() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAq);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
    }

    private void aQt() {
        asa();
        aQs();
        if (this.cAf != null && this.cAd != null && this.TD != null) {
            if (i.Wv().Wz() && this.XS != null && this.XS.Zf() != null) {
                this.cAd.setVisibility(0);
                this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAf.startLoad(this.XS.Zf().thumbnail_url, 10, false);
                stopPlay();
                this.bNn = this.XS.Zf().video_url;
                if (StringUtils.isNull(this.bNn)) {
                    i(true, 4);
                    TiebaStatic.log(new am("c12026").bJ("tid", this.XS.getId()));
                }
                if (this.ekv != null && this.ekv.bTv() != null) {
                    this.ekv.bTv().g(this.XS.Zf());
                }
                this.TD.dF(this.bNn, this.XS.tid);
                return;
            }
            this.cAd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dqw, d.f.addresslist_item_bg);
            al.c(this.cAg, d.f.btn_icon_play_video_n);
            al.j(this.cAh, d.C0277d.cp_btn_a);
            al.j(this.cAe, d.C0277d.cp_btn_a);
            al.j(this.cAl, d.C0277d.cp_btn_a);
            al.l(this.cAi, d.C0277d.common_color_10014);
            al.l(this.cKM, d.C0277d.cp_bg_line_e);
            if (this.cAh != null) {
                this.cAh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.drn != null && this.drn.getVisibility() == 0) {
                this.drn.onChangeSkinType();
            }
            this.dqy.onChangeSkinType();
            this.mSkinType = i;
            this.dqx.onChangeSkinType();
            if (this.ehw != null && this.ehw.getHeadView() != null && (this.ehw.getHeadView() instanceof TbImageView)) {
                this.ehw.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            }
            this.cAf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.fij.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mC(int i) {
        this.currentPageType = i;
        if (this.dqy != null) {
            this.dqy.bSJ = i;
            if (i == 15) {
                this.dqy.setFrom(10);
            } else {
                this.dqy.setFrom(2);
                this.dqy.setDisPraiseFrom(2);
            }
        }
        if (this.dqx != null) {
            if (i == 15) {
                this.dqx.setFrom(5);
            } else {
                this.dqx.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.ehC;
    }

    public boolean isPlaying() {
        if (this.TD == null) {
            return false;
        }
        return this.TD.isPlaying();
    }

    public void startPlay() {
        if (!this.ehC && this.XS != null && this.XS.Zf() != null && this.TD != null) {
            this.TD.stopPlayback();
            if (ad.aqs()) {
                if (this.fik || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.ehz.bEx();
                    i(true, 2);
                    if (StringUtils.isNull(this.bNn)) {
                        TiebaStatic.log(new am("c12619").bJ("obj_locate", "frs").bJ("tid", this.XS.getId()));
                        this.bNn = this.XS.Zf().video_url;
                    }
                    this.ehC = true;
                    this.TD.setVideoPath(this.bNn, this.XS.getId());
                    if (this.dbg != null) {
                        this.dbg.start();
                    }
                    aQm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.XS != null && this.XS.Zf() != null) {
            String str = this.XS.ZP() ? "floor5" : "frs";
            if (this.XS.YS()) {
                str = "frs_mcn";
            }
            if (this.fil == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.ctw = this.XS.getTid();
            zVar.ekM = this.XS.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.XS.mRecomSource;
            zVar.hYx = this.XS.mRecomAbTag;
            zVar.hYy = this.XS.mRecomWeight;
            zVar.hYz = "";
            zVar.hYB = this.XS.Zf().video_md5;
            com.baidu.tieba.play.l.a(this.XS.Zf().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        asa();
        aQs();
        i(true, 1);
        if (this.TD != null) {
            this.TD.stopPlayback();
            if (this.dbg != null) {
                this.dbg.stop();
            }
        }
        this.ehC = false;
    }

    public View getVideoContainer() {
        return this.cAd;
    }

    public String getPlayUrl() {
        return this.bNn;
    }

    public int getCurrentPosition() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.ekv != null) {
            this.ekv.setVideoStatsData(zVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqy != null && this.dqx != null) {
            this.dqx.setPageUniqueId(bdUniqueId);
        }
    }

    public void mE(int i) {
        if (this.XS != null) {
            if (i == 1) {
                this.dqy.setVisibility(8);
                this.drn.setData(this.XS);
                this.dqz.setVisibility(8);
                return;
            }
            this.dqy.setData(this.XS);
            this.dqz.setVisibility(8);
            this.drn.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cAf.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cAf.setOnDrawListener(null);
        }
    }
}
