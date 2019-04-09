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
    private QuickVideoView TF;
    private bg XT;
    private String YB;
    private final View.OnClickListener ZI;
    private Animation aff;
    private String bCK;
    private String bNo;
    private final View.OnClickListener bRC;
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
    private k ehA;
    private int ehC;
    private boolean ehD;
    private TextView ehI;
    private Handler ehJ;
    private VideoLoadingProgressView.a ehK;
    private j.a ehP;
    private Animation.AnimationListener ehQ;
    private ThreadGodReplyLayout ehw;
    private HeadPendantClickableView ehx;
    private g ehy;
    private TbImageView ejK;
    private LinearLayout ejg;
    private n ekw;
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
        if (this.ehy != null && this.ehD) {
            try {
                this.TF.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ehJ.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehC = 0;
        this.cAn = 1;
        this.ehD = false;
        this.ehJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.ehy = gVar;
                if (a.this.ehy != null) {
                    a.this.ehy.setVolume(0.0f, 0.0f);
                }
                a.this.ehA.bEy();
                a.this.aQl();
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
                a.this.TF.start();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.aQs();
                a.this.i(true, 4);
                a.this.ehD = false;
                return true;
            }
        };
        this.ehK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aQl();
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
                if (a.this.TF != null && !a.this.TF.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cAs = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aQs();
                a.this.i(true, 4);
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fim = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XT != null && !StringUtils.isNull(a.this.XT.YT())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.XT.YT(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bRC != null) {
                        a.this.bRC.onClick(view);
                    }
                }
            }
        };
        this.ZI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.XT);
                }
            }
        };
        this.bRC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XT != null && a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.XT);
                }
            }
        };
        this.ehP = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void qE() {
                a.this.aQm();
            }
        };
        this.ehQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
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
        this.ejK = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.fii = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.dqx.setOnClickListener(this);
        this.ehx = (HeadPendantClickableView) this.dqx.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.ehx.getHeadView() != null) {
            this.ehx.getHeadView().setIsRound(true);
            this.ehx.getHeadView().setDrawBorder(false);
            this.ehx.getHeadView().setDefaultResource(17170445);
            this.ehx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehx.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.ehx.setHasPendantStyle();
        if (this.ehx.getPendantView() != null) {
            this.ehx.getPendantView().setIsRound(true);
            this.ehx.getPendantView().setDrawBorder(false);
        }
        this.fih = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.fih.setVisibility(8);
        this.fih.setOnClickListener(this.fim);
        this.cAk = new x((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cAk.setLoadingAnimationListener(this.ehK);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.dqz.setForumAfterClickListener(this.bRC);
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
        this.dqz.bSK = 3;
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.dro.bTC.setOnClickListener(this);
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
        this.TF = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.ekw = new n(this.mContext.getPageActivity());
        this.TF.setPlayerReuseEnable(true);
        this.TF.setContinuePlayEnable(true);
        this.TF.setBusiness(this.ekw);
        this.TF.setOnPreparedListener(this.cJJ);
        this.TF.setOnCompletionListener(this.cJI);
        this.TF.setOnErrorListener(this.cAp);
        this.TF.setOnOutInfoListener(this.cJL);
        this.TF.setOnSurfaceDestroyedListener(this.cAt);
        this.dbh = new j();
        this.dbh.setPlayer(this.TF);
        this.dbh.a(this.ehP);
        this.cAl = view.findViewById(d.g.auto_video_black_mask);
        this.cAi = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cAj = view.findViewById(d.g.auto_video_error_background);
        this.drz = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.drA = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.aff = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.aff.setAnimationListener(this.ehQ);
        this.cAf = (TextView) view.findViewById(d.g.text_video_duration);
        this.cAm = (TextView) view.findViewById(d.g.text_video_play_count);
        this.ejg = (LinearLayout) view.findViewById(d.g.duration_container);
        this.fij = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dqx);
        this.fij.setUniqueId(getTag());
        this.ehw = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ehw.setOnClickListener(this);
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
                    al.l(a.this.mMaskView, z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent);
                }
            }
        });
        this.ehI = (TextView) view.findViewById(d.g.nani_video_icon);
        this.ehA = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dqx || view == this.dqz.getCommentNumView() || view == this.fii) {
            bz(this.dqx);
        } else if (view == this.cAe) {
            if (this.XT != null && this.XT.Zf() != null) {
                z = this.XT.Zf().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bI(this.cAe);
            } else {
                bz(this.cAe);
            }
        } else if (view == this.ehw) {
            bz(this.ehw);
        }
        if (this.XT != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.XT));
        }
    }

    private void bx(View view) {
        if (aQf() != null) {
            aQf().a(view, this.XT);
        }
        if (!com.baidu.adp.lib.util.j.kY()) {
            l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void aQn() {
        if (this.XT != null) {
            String str = "frs";
            if (this.fil == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.XT);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bI(View view) {
        if (this.XT != null) {
            am amVar = new am("c11100");
            amVar.bJ("tid", this.XT.getId());
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.XT.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (aQf() != null) {
            aQf().a(view, this.XT);
        }
        if (view == this.cAe) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
            } else {
                aQo();
            }
        }
    }

    private void aQo() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.XT);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.drz.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.drz.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fil == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.XT.getTid(), com.baidu.tieba.card.n.YB(), "", videoSerializeVideoThreadInfo)));
    }

    private void bz(View view) {
        String str;
        String str2;
        if (this.XT != null) {
            if (this.XT.ZP()) {
                TiebaStatic.log(new am("c10242").bJ(ImageViewerConfig.FORUM_ID, String.valueOf(this.XT.getFid())).T("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.bJ("tid", this.XT.getId());
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.XT.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.XT.YO() != null && this.XT.YO().getGodUserData() != null && this.XT.YO().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").T("obj_locate", 3).bJ("tid", this.XT.getId()));
            }
        }
        if (aQf() != null) {
            aQf().a(view, this.XT);
        }
        if (this.XT != null) {
            com.baidu.tieba.card.n.tz(this.XT.getId());
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
            y.pM(this.XT.getId());
            String valueOf = String.valueOf(this.XT.getFid());
            if (this.XT.bDI == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.XT.bDI.id;
                str2 = valueOf;
            }
            if (this.XT.Zk() > 0 && com.baidu.tieba.tbadkCore.util.e.cfp()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.XT.getTid(), String.valueOf(this.XT.Zk()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fil == 501) {
                    str3 = "frs_tab";
                } else if (this.XT.ZP()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.XT.ZX());
                createHistoryCfg.setSmartFrsPosition(this.XT.aae());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.ehw) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.XT, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fil == 501) {
                str4 = "frs_tab";
            } else if (this.XT.ZP()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.XT.ZX());
            createFromThreadCfg.setSmartFrsPosition(this.XT.aae());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.ehw) {
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
        this.XT = bgVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        this.ehJ.removeMessages(202);
        if (this.TF.getCurrentPosition() > 0) {
            i(false, 3);
            this.ehJ.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.ehJ.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQr() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.ehJ.removeMessages(203);
        int currentPosition = this.TF.getCurrentPosition();
        if (currentPosition != this.ehC) {
            this.ehC = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.ehJ.sendEmptyMessageDelayed(203, 3000L);
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
                    this.aff.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.ejg.setVisibility(0);
                    this.cAk.startLoading();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAs, 60000L);
                } else if (i == 3) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aff);
                    this.cAl.setVisibility(8);
                    this.ejg.setVisibility(8);
                    this.cAk.bTM();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                    if (this.XT != null && this.XT.Zf() != null) {
                        this.ehA.a(this.XT.getTid(), this.XT.Zf().video_length.intValue(), this.XT.Zf().video_duration.intValue(), "frs", this.TF);
                    }
                } else if (i == 4) {
                    this.cAh.setVisibility(8);
                    this.cAg.startAnimation(this.aff);
                    this.cAl.setVisibility(8);
                    this.cAk.bTN();
                    this.cAj.setVisibility(0);
                    this.cAi.setVisibility(0);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.cAr, 2000L);
                } else {
                    this.cAh.setVisibility(0);
                    this.ejg.setVisibility(0);
                    this.aff.cancel();
                    this.cAg.clearAnimation();
                    this.cAg.setVisibility(0);
                    this.cAl.setVisibility(0);
                    this.cAk.bTN();
                    this.cAj.setVisibility(8);
                    this.cAi.setVisibility(8);
                }
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.ejK != null) {
            if (bgVar == null) {
                this.ejK.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDA)) {
                if (this.fij != null && this.fij.bjk() && (this.ejK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejK.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), d.e.tbds106);
                    this.ejK.setLayoutParams(layoutParams);
                }
                this.ejK.setVisibility(0);
                this.ejK.setImageDrawable(null);
                this.ejK.startLoad(bgVar.bDA, 10, false);
                this.ejK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bgVar.bDB, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejK.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.XT == null || this.XT.YO() == null) {
            this.dqx.setVisibility(8);
            return;
        }
        this.dqx.setVisibility(0);
        this.dqx.setOnClickListener(this);
        aQt();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCK)) {
            this.XT.bt(this.mUrl, this.bCK);
        }
        this.XT.k(false, true);
        SpannableStringBuilder Zu = this.XT.Zu();
        if (this.XT.ZB() && !StringUtils.isNull(this.XT.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.XT.getTid();
            Zu.append((CharSequence) this.XT.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.fij.am(this.XT);
        R(this.XT);
        this.dqy.setData(this.XT);
        if (this.dqy.getHeaderImg() != null) {
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehx.setVisibility(8);
            } else if (this.XT.YO() == null || this.XT.YO().getPendantData() == null || StringUtils.isNull(this.XT.YO().getPendantData().Xk())) {
                this.ehx.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(this.XT);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehx.setVisibility(0);
                this.ehx.setData(this.XT);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dqz.setLayoutParams(layoutParams);
        this.dqy.setUserAfterClickListener(this.ZI);
        mE(ls(1));
        this.cAf.setText(ap.hy(this.XT.Zf().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.XT.Zf().play_count.intValue())));
        this.ehw.setData(this.XT.aam());
        this.ehw.onChangeSkinType();
        if (com.baidu.tieba.card.n.tA(this.XT.getId())) {
            al.d(this.mTextTitle, d.C0277d.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.ehw.getGodReplyContent(), this.XT.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        } else {
            al.d(this.mTextTitle, d.C0277d.cp_cont_b, 1);
        }
        if (this.XT == null || this.XT.Zf() == null) {
            z = false;
        } else {
            z = this.XT.Zf().is_vertical.intValue() == 1;
        }
        if (z) {
            this.ehI.setVisibility(0);
        } else {
            this.ehI.setVisibility(8);
        }
        if (this.dqz.isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.mMaskView.setVisibility(0);
            if (this.XT.aax() || this.XT.aay()) {
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
        this.ehJ.removeMessages(202);
        this.ehJ.removeMessages(203);
    }

    private void asa() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
    }

    private void aQt() {
        asa();
        aQs();
        if (this.cAg != null && this.cAe != null && this.TF != null) {
            if (i.Wv().Wz() && this.XT != null && this.XT.Zf() != null) {
                this.cAe.setVisibility(0);
                this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cAg.startLoad(this.XT.Zf().thumbnail_url, 10, false);
                stopPlay();
                this.bNo = this.XT.Zf().video_url;
                if (StringUtils.isNull(this.bNo)) {
                    i(true, 4);
                    TiebaStatic.log(new am("c12026").bJ("tid", this.XT.getId()));
                }
                if (this.ekw != null && this.ekw.bTv() != null) {
                    this.ekw.bTv().g(this.XT.Zf());
                }
                this.TF.dF(this.bNo, this.XT.tid);
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
            al.j(this.cAi, d.C0277d.cp_btn_a);
            al.j(this.cAf, d.C0277d.cp_btn_a);
            al.j(this.cAm, d.C0277d.cp_btn_a);
            al.l(this.cAj, d.C0277d.common_color_10014);
            al.l(this.cKN, d.C0277d.cp_bg_line_e);
            if (this.cAi != null) {
                this.cAi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dro != null && this.dro.getVisibility() == 0) {
                this.dro.onChangeSkinType();
            }
            this.dqz.onChangeSkinType();
            this.mSkinType = i;
            this.dqy.onChangeSkinType();
            if (this.ehx != null && this.ehx.getHeadView() != null && (this.ehx.getHeadView() instanceof TbImageView)) {
                this.ehx.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            }
            this.cAg.setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        if (this.dqz != null) {
            this.dqz.bSK = i;
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
        return this.ehD;
    }

    public boolean isPlaying() {
        if (this.TF == null) {
            return false;
        }
        return this.TF.isPlaying();
    }

    public void startPlay() {
        if (!this.ehD && this.XT != null && this.XT.Zf() != null && this.TF != null) {
            this.TF.stopPlayback();
            if (ad.aqs()) {
                if (this.fik || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.ehA.bEx();
                    i(true, 2);
                    if (StringUtils.isNull(this.bNo)) {
                        TiebaStatic.log(new am("c12619").bJ("obj_locate", "frs").bJ("tid", this.XT.getId()));
                        this.bNo = this.XT.Zf().video_url;
                    }
                    this.ehD = true;
                    this.TF.setVideoPath(this.bNo, this.XT.getId());
                    if (this.dbh != null) {
                        this.dbh.start();
                    }
                    aQm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.XT != null && this.XT.Zf() != null) {
            String str = this.XT.ZP() ? "floor5" : "frs";
            if (this.XT.YS()) {
                str = "frs_mcn";
            }
            if (this.fil == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.ctx = this.XT.getTid();
            zVar.ekN = this.XT.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.XT.mRecomSource;
            zVar.hYy = this.XT.mRecomAbTag;
            zVar.hYz = this.XT.mRecomWeight;
            zVar.hYA = "";
            zVar.hYC = this.XT.Zf().video_md5;
            com.baidu.tieba.play.l.a(this.XT.Zf().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        asa();
        aQs();
        i(true, 1);
        if (this.TF != null) {
            this.TF.stopPlayback();
            if (this.dbh != null) {
                this.dbh.stop();
            }
        }
        this.ehD = false;
    }

    public View getVideoContainer() {
        return this.cAe;
    }

    public String getPlayUrl() {
        return this.bNo;
    }

    public int getCurrentPosition() {
        if (this.TF == null) {
            return 0;
        }
        return this.TF.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.ekw != null) {
            this.ekw.setVideoStatsData(zVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqz != null && this.dqy != null) {
            this.dqy.setPageUniqueId(bdUniqueId);
        }
    }

    public void mE(int i) {
        if (this.XT != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setData(this.XT);
                this.dqA.setVisibility(8);
                return;
            }
            this.dqz.setData(this.XT);
            this.dqA.setVisibility(8);
            this.dro.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
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
