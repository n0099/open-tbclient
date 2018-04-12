package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bd> implements com.baidu.tieba.a.e, aa {
    private g.f aZo;
    private g.b aZp;
    private String abb;
    private TbPageContext<?> adf;
    private bd alf;
    private final View.OnClickListener aoY;
    private final View.OnClickListener apj;
    private String baI;
    private View bam;
    private ImageView bkA;
    private Animation bkE;
    private com.baidu.tieba.play.j bkQ;
    private QuickVideoView.b bkY;
    private String bvX;
    private HeadPendantClickableView bwV;
    protected ThreadSourceShareAndPraiseLayout bwZ;
    private RelativeLayout bwi;
    public ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    public View bwl;
    public LinearLayout bxk;
    public ThreadSkinView bxl;
    private ThreadGodReplyLayout cma;
    private Handler coE;
    private VideoLoadingProgressView.a coF;
    private TbImageView.a coG;
    private Runnable coH;
    private Runnable coI;
    private j.a coM;
    private Animation.AnimationListener coN;
    private TbImageView cog;
    private TextView coh;
    private View.OnClickListener col;
    public FrameLayout con;
    private QuickVideoView coo;
    private com.baidu.tieba.play.g cop;
    private TextView coq;
    private TextView cos;
    private View cot;
    private w cou;
    private View cow;
    private int cox;
    private int coy;
    private boolean coz;
    private TbImageView cqG;
    private LinearLayout cqe;
    private n crs;
    public TextView deG;
    public LinearLayout deH;
    private com.baidu.tieba.frs.vc.g deI;
    private ViewTreeObserver.OnGlobalLayoutListener deJ;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.cop != null) {
            try {
                this.coo.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.coE.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cox = 0;
        this.coy = 1;
        this.coz = false;
        this.coE = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.afl();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.afm();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZo = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cop = gVar;
                if (a.this.cop != null) {
                    a.this.cop.setVolume(0.0f, 0.0f);
                }
                a.this.cou.bgV();
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.aeJ();
                a.this.e(true, 4);
                return true;
            }
        };
        this.coF = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.afh();
            }
        };
        this.coG = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && a.this.cog != null) {
                    a.this.cog.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.deJ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.con != null && a.this.con.getLayoutParams() != null && a.this.con.getVisibility() != 8) {
                    a.this.con.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.con.getLayoutParams();
                    if (a.this.con.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.con.getWidth() * 0.5625d);
                        a.this.con.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.coH = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.coo != null && !a.this.coo.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.coI = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.aeJ();
                a.this.e(true, 4);
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.col = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.alf != null && !StringUtils.isNull(a.this.alf.rV())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.adf.getPageActivity()).createNormalCfg(a.this.alf.rV(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aoY != null) {
                        a.this.aoY.onClick(view2);
                    }
                }
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.alf);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.alf != null && a.this.aeZ() != null) {
                    a.this.aeZ().a(view2, a.this.alf);
                }
            }
        };
        this.coM = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // com.baidu.tieba.play.j.a
            public void afo() {
                a.this.afi();
            }
        };
        this.coN = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.coy == 3 && a.this.cog != null) {
                    a.this.cog.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.adf = tbPageContext;
        View view2 = getView();
        this.bam = view2.findViewById(d.g.divider_line);
        this.bwi = (RelativeLayout) view2.findViewById(d.g.layout_root);
        this.cqG = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
        this.deH = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bwi.setOnClickListener(this);
        this.bwV = (HeadPendantClickableView) this.bwi.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(l.e(this.adf.getPageActivity(), d.e.ds70));
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.deG = (TextView) view2.findViewById(d.g.thread_info_bar_name);
        this.deG.setVisibility(8);
        this.deG.setOnClickListener(this.col);
        this.cou = new w((ViewGroup) view2.findViewById(d.g.auto_video_loading_container));
        this.cou.setLoadingAnimationListener(this.coF);
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        this.bwk.setForumAfterClickListener(this.aoY);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bwj.setFrom(3);
        this.bwl = view2.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setShareVisible(true);
        this.bwk.setShareReportFrom(1);
        this.bwk.setStType("frs_page");
        this.bwk.setFrom(2);
        this.bwk.abV = 3;
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.text_bottom_threaad);
        this.bwZ.apG.setOnClickListener(this);
        this.bwZ.setFrom(2);
        this.bwZ.setShareReportFrom(1);
        this.bwZ.setSourceFromForPb(3);
        this.bwZ.setStType("frs_page");
        this.bwZ.setHideBarName(true);
        this.con = (FrameLayout) view2.findViewById(d.g.frame_video);
        this.con.setOnClickListener(this);
        this.con.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view3) {
                if (a.this.con != null) {
                    a.this.con.getViewTreeObserver().addOnGlobalLayoutListener(a.this.deJ);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view3) {
                if (a.this.con != null) {
                    a.this.con.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.deJ);
                }
            }
        });
        this.cog = (TbImageView) view2.findViewById(d.g.image_video);
        this.cog.setPageId(getTag());
        this.cog.setDefaultErrorResource(0);
        this.cog.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cog.setEvent(this.coG);
        this.cog.setGifIconSupport(false);
        this.bkA = (ImageView) view2.findViewById(d.g.image_video_play);
        this.coo = (QuickVideoView) view2.findViewById(d.g.texture_video_view);
        this.crs = new n(this.adf.getPageActivity());
        this.coo.setBusiness(this.crs);
        this.coo.setOnPreparedListener(this.aZo);
        this.coo.setOnErrorListener(this.aZp);
        this.coo.setOnSurfaceDestroyedListener(this.bkY);
        this.bkQ = new com.baidu.tieba.play.j();
        this.bkQ.setPlayer(this.coo);
        this.bkQ.a(this.coM);
        this.cow = view2.findViewById(d.g.auto_video_black_mask);
        this.cos = (TextView) view2.findViewById(d.g.auto_video_error_tips);
        this.cot = view2.findViewById(d.g.auto_video_error_background);
        this.bxk = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bxl = (ThreadSkinView) view2.findViewById(d.g.frs_thread_skin);
        this.bkE = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.fade_out_video_cover);
        this.bkE.setAnimationListener(this.coN);
        this.coq = (TextView) view2.findViewById(d.g.text_video_duration);
        this.coh = (TextView) view2.findViewById(d.g.text_video_play_count);
        this.cqe = (LinearLayout) view2.findViewById(d.g.duration_container);
        this.deI = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bwi);
        this.deI.setUniqueId(getTag());
        this.cma = (ThreadGodReplyLayout) view2.findViewById(d.g.card_god_reply_layout);
        this.cma.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.bwi || view2 == this.bwk.getCommentNumView() || view2 == this.deH) {
            ah(this.bwi);
        } else if (view2 == this.con) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                as(this.con);
            } else {
                ah(this.con);
            }
        } else if (view2 == this.cma) {
            ah(this.cma);
        }
        if (this.alf != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.alf));
        }
    }

    private void as(View view2) {
        if (this.alf != null) {
            al alVar = new al("c11100");
            alVar.ac("tid", this.alf.getId());
            alVar.ac(ImageViewerConfig.FORUM_ID, this.alf.getFid() + "");
            TiebaStatic.log(alVar);
        }
        if (aeZ() != null) {
            aeZ().a(view2, this.alf);
        }
        if (view2 == this.con) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                l.showToast(this.adf.getPageActivity(), d.k.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.gQ() && !com.baidu.tieba.video.f.bvW().bvX()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
                View inflate = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        com.baidu.tbadk.browser.a.a(true, (Context) a.this.adf.getPageActivity(), a.this.adf.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                aVar.w(inflate);
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.afk();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.cc(1);
                aVar.cb(d.C0126d.cp_cont_b);
                aVar.ar(true);
                aVar.b(this.mTbPageContext).tD();
            } else {
                afk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.alf);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bxk.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bxk.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.adf.getPageActivity(), "frs", this.alf.getTid(), o.rG(), "", videoSerializeVideoThreadInfo)));
    }

    private void ah(View view2) {
        if (this.alf != null) {
            if (this.alf.sG()) {
                TiebaStatic.log(new al("c10242").ac(ImageViewerConfig.FORUM_ID, String.valueOf(this.alf.getFid())).r("obj_type", 2));
            } else {
                al alVar = new al("c11100");
                alVar.ac("tid", this.alf.getId());
                alVar.ac(ImageViewerConfig.FORUM_ID, this.alf.getFid() + "");
                TiebaStatic.log(alVar);
            }
            if (this.alf.rQ() != null && this.alf.rQ().getGodUserData() != null && this.alf.rQ().getGodUserData().getType() == 2) {
                TiebaStatic.log(new al("c10806").r("obj_locate", 3).ac("tid", this.alf.getId()));
            }
        }
        if (aeZ() != null) {
            aeZ().a(view2, this.alf);
        }
        if (this.alf != null) {
            o.kv(this.alf.getId());
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
            t.hj(this.alf.getId());
            if (this.alf.sl() > 0 && com.baidu.tieba.tbadkCore.util.f.bsX()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.adf.getPageActivity()).createHistoryCfg(this.alf.getTid(), String.valueOf(this.alf.sl()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.alf.sG() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.alf.sP());
                createHistoryCfg.setSmartFrsPosition(this.alf.sW());
                createHistoryCfg.setForumId(String.valueOf(this.alf.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view2 == this.cma) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.adf.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.adf.getPageActivity()).createFromThreadCfg(this.alf, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.alf.sG() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.alf.sP());
            createFromThreadCfg.setSmartFrsPosition(this.alf.sW());
            createFromThreadCfg.setForumId(String.valueOf(this.alf.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view2 == this.cma) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.adf.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        this.alf = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        this.coE.removeMessages(202);
        if (this.coo.getCurrentPosition() > 0) {
            e(true, 3);
            this.coE.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.coE.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.coE.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.coo.getCurrentPosition();
        if (currentPosition != this.cox) {
            this.cox = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.coE.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bkA != null && this.cog != null && this.cow != null && this.cou != null && this.cot != null && this.cos != null) {
            if (z || this.coy != i) {
                this.coy = i;
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coI);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coH);
                if (i == 2) {
                    this.bkA.setVisibility(8);
                    this.bkE.cancel();
                    this.cog.clearAnimation();
                    this.cog.setVisibility(0);
                    this.cow.setVisibility(0);
                    this.cqe.setVisibility(0);
                    this.cou.startLoading();
                    this.cot.setVisibility(8);
                    this.cos.setVisibility(8);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.coI, 60000L);
                } else if (i == 3) {
                    this.bkA.setVisibility(8);
                    this.cog.startAnimation(this.bkE);
                    this.cow.setVisibility(8);
                    this.cqe.setVisibility(8);
                    this.cou.bgW();
                    this.cot.setVisibility(8);
                    this.cos.setVisibility(8);
                } else if (i == 4) {
                    this.bkA.setVisibility(8);
                    this.cog.startAnimation(this.bkE);
                    this.cow.setVisibility(8);
                    this.cou.bgX();
                    this.cot.setVisibility(0);
                    this.cos.setVisibility(0);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.coH, 2000L);
                } else {
                    this.bkA.setVisibility(0);
                    this.cqe.setVisibility(0);
                    this.bkE.cancel();
                    this.cog.clearAnimation();
                    this.cog.setVisibility(0);
                    this.cow.setVisibility(0);
                    this.cou.bgX();
                    this.cot.setVisibility(8);
                    this.cos.setVisibility(8);
                }
            }
        }
    }

    private void I(final bd bdVar) {
        if (this.cqG != null) {
            if (bdVar == null) {
                this.cqG.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abM)) {
                if (this.deI != null && this.deI.avr() && (this.cqG.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqG.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.adf.getContext(), d.e.tbds106);
                    this.cqG.setLayoutParams(layoutParams);
                }
                this.cqG.setVisibility(0);
                this.cqG.setImageDrawable(null);
                this.cqG.startLoad(bdVar.abM, 10, false);
                this.cqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.adf != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bdVar.abN, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.cqG.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        if (this.alf == null || this.alf.rQ() == null) {
            this.bwi.setVisibility(8);
            return;
        }
        this.bwi.setVisibility(0);
        afn();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.abb)) {
            this.alf.M(this.mUrl, this.abb);
        }
        this.alf.e(false, true);
        SpannableStringBuilder so = this.alf.so();
        if (this.alf.su() && !StringUtils.isNull(this.alf.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.alf.getTid();
            so.append((CharSequence) this.alf.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new al("c12841").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0126d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.j(so));
        this.mTextTitle.setText(so);
        this.deI.X(this.alf);
        I(this.alf);
        this.bwj.setData(this.alf);
        if (this.bwj.getHeaderImg() != null) {
            if (this.bwj.getIsSimpleThread()) {
                this.bwj.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (this.alf.rQ() == null || this.alf.rQ().getPendantData() == null || StringUtils.isNull(this.alf.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.bwj.getHeaderImg().setVisibility(0);
                this.bwj.getHeaderImg().setData(this.alf);
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(this.alf);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bwk.setLayoutParams(layoutParams);
        this.bwj.setUserAfterClickListener(this.apj);
        hc(gn(1));
        this.coq.setText(an.cV(this.alf.sh().video_duration.intValue() * 1000));
        this.coh.setText(String.format(this.adf.getResources().getString(d.k.play_count), an.B(this.alf.sh().play_count.intValue())));
        this.cma.setData(this.alf.tc());
        this.cma.onChangeSkinType();
        if (o.kw(this.alf.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
            o.a(this.cma.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        d(this.adf, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeJ() {
        this.coE.removeMessages(202);
        this.coE.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aeP() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coH);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coI);
    }

    private void afn() {
        aeP();
        aeJ();
        if (this.cog != null && this.con != null && this.coo != null) {
            if (com.baidu.tbadk.core.i.pY().qe() && this.alf != null && this.alf.sh() != null) {
                this.con.setVisibility(0);
                this.cog.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cog.startLoad(this.alf.sh().thumbnail_url, 10, false);
                stopPlay();
                this.baI = this.alf.sh().video_url;
                if (StringUtils.isNull(this.baI)) {
                    e(true, 4);
                    TiebaStatic.log(new al("c12026").ac("tid", this.alf.getId()));
                }
                if (this.crs != null && this.crs.bgF() != null) {
                    this.crs.bgF().d(this.alf.sh());
                    return;
                }
                return;
            }
            this.con.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.bwi, d.f.addresslist_item_bg);
            ak.c(this.bkA, d.f.btn_icon_play_video_n);
            ak.h(this.cos, d.C0126d.cp_cont_i);
            ak.h(this.coq, d.C0126d.cp_cont_i);
            ak.h(this.coh, d.C0126d.cp_cont_i);
            ak.j(this.cot, d.C0126d.common_color_10014);
            ak.j(this.bam, d.C0126d.cp_bg_line_e);
            if (this.cos != null) {
                this.cos.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bwZ != null && this.bwZ.getVisibility() == 0) {
                this.bwZ.onChangeSkinType();
            }
            this.bwk.onChangeSkinType();
            this.mSkinType = i;
            this.bwj.onChangeSkinType();
            this.deI.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.coz;
    }

    public boolean isPlaying() {
        if (this.coo == null) {
            return false;
        }
        return this.coo.isPlaying();
    }

    public void startPlay() {
        if (!this.coz && this.alf != null && this.alf.sh() != null && this.coo != null && y.o(2, this.baI)) {
            e(true, 2);
            if (StringUtils.isNull(this.baI)) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "frs").ac("tid", this.alf.getId()));
                this.baI = this.alf.sh().video_url;
            }
            this.coo.setVideoPath(this.baI, this.alf.getId());
            this.coo.setLooping(true);
            if (this.bkQ != null) {
                this.bkQ.start();
            }
            this.coz = true;
            afi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.alf != null && this.alf.sh() != null) {
            String str = this.alf.sG() ? "floor5" : "frs";
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.aNu = this.alf.getTid();
            yVar.crJ = this.alf.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.alf.mRecomSource;
            yVar.fQM = this.alf.mRecomAbTag;
            yVar.fQN = this.alf.mRecomWeight;
            yVar.fQO = "";
            yVar.fQQ = this.alf.sh().video_md5;
            com.baidu.tieba.play.l.a(this.alf.sh().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aeP();
        aeJ();
        e(true, 1);
        if (this.coo != null) {
            this.coo.stopPlayback();
            if (this.bkQ != null) {
                this.bkQ.stop();
            }
        }
        this.coz = false;
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bwk;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        return this.bwZ.apG;
    }

    public View getVideoContainer() {
        return this.con;
    }

    public String getPlayUrl() {
        return this.baI;
    }

    public int getCurrentPosition() {
        if (this.coo == null) {
            return 0;
        }
        return this.coo.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.crs != null) {
            this.crs.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bwk != null && this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
    }

    public void hc(int i) {
        if (this.alf != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setData(this.alf);
                this.bwl.setVisibility(8);
                return;
            }
            this.bwl.setVisibility(this.bwk.setData(this.alf) ? 0 : 8);
            this.bwZ.setVisibility(8);
        }
    }

    public void M(String str, String str2) {
        this.mUrl = str;
        this.abb = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
