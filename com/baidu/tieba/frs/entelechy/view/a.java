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
    private ThreadGodReplyLayout clX;
    private Handler coB;
    private VideoLoadingProgressView.a coC;
    private TbImageView.a coD;
    private Runnable coE;
    private Runnable coF;
    private j.a coJ;
    private Animation.AnimationListener coK;
    private TbImageView cod;
    private TextView coe;
    private View.OnClickListener coi;
    public FrameLayout cok;
    private QuickVideoView col;

    /* renamed from: com  reason: collision with root package name */
    private com.baidu.tieba.play.g f12com;
    private TextView con;
    private TextView cop;
    private View coq;
    private w cor;
    private View cot;
    private int cou;
    private int cov;
    private boolean cow;
    private TbImageView cqD;
    private LinearLayout cqb;
    private n crp;
    public TextView deD;
    public LinearLayout deE;
    private com.baidu.tieba.frs.vc.g deF;
    private ViewTreeObserver.OnGlobalLayoutListener deG;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.f12com != null) {
            try {
                this.col.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.coB.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cou = 0;
        this.cov = 1;
        this.cow = false;
        this.coB = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
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
                a.this.f12com = gVar;
                if (a.this.f12com != null) {
                    a.this.f12com.setVolume(0.0f, 0.0f);
                }
                a.this.cor.bgV();
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
        this.coC = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.afh();
            }
        };
        this.coD = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && a.this.cod != null) {
                    a.this.cod.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.deG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cok != null && a.this.cok.getLayoutParams() != null && a.this.cok.getVisibility() != 8) {
                    a.this.cok.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cok.getLayoutParams();
                    if (a.this.cok.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cok.getWidth() * 0.5625d);
                        a.this.cok.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.coE = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.col != null && !a.this.col.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.coF = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
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
        this.coi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
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
        this.coJ = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // com.baidu.tieba.play.j.a
            public void afo() {
                a.this.afi();
            }
        };
        this.coK = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cov == 3 && a.this.cod != null) {
                    a.this.cod.setVisibility(8);
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
        this.cqD = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
        this.deE = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
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
        this.deD = (TextView) view2.findViewById(d.g.thread_info_bar_name);
        this.deD.setVisibility(8);
        this.deD.setOnClickListener(this.coi);
        this.cor = new w((ViewGroup) view2.findViewById(d.g.auto_video_loading_container));
        this.cor.setLoadingAnimationListener(this.coC);
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
        this.cok = (FrameLayout) view2.findViewById(d.g.frame_video);
        this.cok.setOnClickListener(this);
        this.cok.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view3) {
                if (a.this.cok != null) {
                    a.this.cok.getViewTreeObserver().addOnGlobalLayoutListener(a.this.deG);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view3) {
                if (a.this.cok != null) {
                    a.this.cok.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.deG);
                }
            }
        });
        this.cod = (TbImageView) view2.findViewById(d.g.image_video);
        this.cod.setPageId(getTag());
        this.cod.setDefaultErrorResource(0);
        this.cod.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cod.setEvent(this.coD);
        this.cod.setGifIconSupport(false);
        this.bkA = (ImageView) view2.findViewById(d.g.image_video_play);
        this.col = (QuickVideoView) view2.findViewById(d.g.texture_video_view);
        this.crp = new n(this.adf.getPageActivity());
        this.col.setBusiness(this.crp);
        this.col.setOnPreparedListener(this.aZo);
        this.col.setOnErrorListener(this.aZp);
        this.col.setOnSurfaceDestroyedListener(this.bkY);
        this.bkQ = new com.baidu.tieba.play.j();
        this.bkQ.setPlayer(this.col);
        this.bkQ.a(this.coJ);
        this.cot = view2.findViewById(d.g.auto_video_black_mask);
        this.cop = (TextView) view2.findViewById(d.g.auto_video_error_tips);
        this.coq = view2.findViewById(d.g.auto_video_error_background);
        this.bxk = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bxl = (ThreadSkinView) view2.findViewById(d.g.frs_thread_skin);
        this.bkE = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.fade_out_video_cover);
        this.bkE.setAnimationListener(this.coK);
        this.con = (TextView) view2.findViewById(d.g.text_video_duration);
        this.coe = (TextView) view2.findViewById(d.g.text_video_play_count);
        this.cqb = (LinearLayout) view2.findViewById(d.g.duration_container);
        this.deF = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bwi);
        this.deF.setUniqueId(getTag());
        this.clX = (ThreadGodReplyLayout) view2.findViewById(d.g.card_god_reply_layout);
        this.clX.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.bwi || view2 == this.bwk.getCommentNumView() || view2 == this.deE) {
            ah(this.bwi);
        } else if (view2 == this.cok) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                as(this.cok);
            } else {
                ah(this.cok);
            }
        } else if (view2 == this.clX) {
            ah(this.clX);
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
        if (view2 == this.cok) {
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
                aVar.cb(1);
                aVar.ca(d.C0126d.cp_cont_b);
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
                if (view2 == this.clX) {
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
            if (view2 == this.clX) {
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
        this.coB.removeMessages(202);
        if (this.col.getCurrentPosition() > 0) {
            e(true, 3);
            this.coB.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.coB.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.coB.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.col.getCurrentPosition();
        if (currentPosition != this.cou) {
            this.cou = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.coB.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bkA != null && this.cod != null && this.cot != null && this.cor != null && this.coq != null && this.cop != null) {
            if (z || this.cov != i) {
                this.cov = i;
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coF);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coE);
                if (i == 2) {
                    this.bkA.setVisibility(8);
                    this.bkE.cancel();
                    this.cod.clearAnimation();
                    this.cod.setVisibility(0);
                    this.cot.setVisibility(0);
                    this.cqb.setVisibility(0);
                    this.cor.startLoading();
                    this.coq.setVisibility(8);
                    this.cop.setVisibility(8);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.coF, 60000L);
                } else if (i == 3) {
                    this.bkA.setVisibility(8);
                    this.cod.startAnimation(this.bkE);
                    this.cot.setVisibility(8);
                    this.cqb.setVisibility(8);
                    this.cor.bgW();
                    this.coq.setVisibility(8);
                    this.cop.setVisibility(8);
                } else if (i == 4) {
                    this.bkA.setVisibility(8);
                    this.cod.startAnimation(this.bkE);
                    this.cot.setVisibility(8);
                    this.cor.bgX();
                    this.coq.setVisibility(0);
                    this.cop.setVisibility(0);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.coE, 2000L);
                } else {
                    this.bkA.setVisibility(0);
                    this.cqb.setVisibility(0);
                    this.bkE.cancel();
                    this.cod.clearAnimation();
                    this.cod.setVisibility(0);
                    this.cot.setVisibility(0);
                    this.cor.bgX();
                    this.coq.setVisibility(8);
                    this.cop.setVisibility(8);
                }
            }
        }
    }

    private void I(final bd bdVar) {
        if (this.cqD != null) {
            if (bdVar == null) {
                this.cqD.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abM)) {
                if (this.deF != null && this.deF.avr() && (this.cqD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqD.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.adf.getContext(), d.e.tbds106);
                    this.cqD.setLayoutParams(layoutParams);
                }
                this.cqD.setVisibility(0);
                this.cqD.setImageDrawable(null);
                this.cqD.startLoad(bdVar.abM, 10, false);
                this.cqD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.adf != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bdVar.abN, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.cqD.setVisibility(8);
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
        this.deF.X(this.alf);
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
        hb(gm(1));
        this.con.setText(an.cU(this.alf.sh().video_duration.intValue() * 1000));
        this.coe.setText(String.format(this.adf.getResources().getString(d.k.play_count), an.B(this.alf.sh().play_count.intValue())));
        this.clX.setData(this.alf.tc());
        this.clX.onChangeSkinType();
        if (o.kw(this.alf.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
            o.a(this.clX.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        d(this.adf, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeJ() {
        this.coB.removeMessages(202);
        this.coB.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aeP() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coE);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.coF);
    }

    private void afn() {
        aeP();
        aeJ();
        if (this.cod != null && this.cok != null && this.col != null) {
            if (com.baidu.tbadk.core.i.pY().qe() && this.alf != null && this.alf.sh() != null) {
                this.cok.setVisibility(0);
                this.cod.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cod.startLoad(this.alf.sh().thumbnail_url, 10, false);
                stopPlay();
                this.baI = this.alf.sh().video_url;
                if (StringUtils.isNull(this.baI)) {
                    e(true, 4);
                    TiebaStatic.log(new al("c12026").ac("tid", this.alf.getId()));
                }
                if (this.crp != null && this.crp.bgF() != null) {
                    this.crp.bgF().d(this.alf.sh());
                    return;
                }
                return;
            }
            this.cok.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.bwi, d.f.addresslist_item_bg);
            ak.c(this.bkA, d.f.btn_icon_play_video_n);
            ak.h(this.cop, d.C0126d.cp_cont_i);
            ak.h(this.con, d.C0126d.cp_cont_i);
            ak.h(this.coe, d.C0126d.cp_cont_i);
            ak.j(this.coq, d.C0126d.common_color_10014);
            ak.j(this.bam, d.C0126d.cp_bg_line_e);
            if (this.cop != null) {
                this.cop.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bwZ != null && this.bwZ.getVisibility() == 0) {
                this.bwZ.onChangeSkinType();
            }
            this.bwk.onChangeSkinType();
            this.mSkinType = i;
            this.bwj.onChangeSkinType();
            this.deF.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cow;
    }

    public boolean isPlaying() {
        if (this.col == null) {
            return false;
        }
        return this.col.isPlaying();
    }

    public void startPlay() {
        if (!this.cow && this.alf != null && this.alf.sh() != null && this.col != null && y.o(2, this.baI)) {
            e(true, 2);
            if (StringUtils.isNull(this.baI)) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "frs").ac("tid", this.alf.getId()));
                this.baI = this.alf.sh().video_url;
            }
            this.col.setVideoPath(this.baI, this.alf.getId());
            this.col.setLooping(true);
            if (this.bkQ != null) {
                this.bkQ.start();
            }
            this.cow = true;
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
            yVar.crG = this.alf.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.alf.mRecomSource;
            yVar.fQJ = this.alf.mRecomAbTag;
            yVar.fQK = this.alf.mRecomWeight;
            yVar.fQL = "";
            yVar.fQN = this.alf.sh().video_md5;
            com.baidu.tieba.play.l.a(this.alf.sh().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aeP();
        aeJ();
        e(true, 1);
        if (this.col != null) {
            this.col.stopPlayback();
            if (this.bkQ != null) {
                this.bkQ.stop();
            }
        }
        this.cow = false;
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bwk;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        return this.bwZ.apG;
    }

    public View getVideoContainer() {
        return this.cok;
    }

    public String getPlayUrl() {
        return this.baI;
    }

    public int getCurrentPosition() {
        if (this.col == null) {
            return 0;
        }
        return this.col.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.crp != null) {
            this.crp.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bwk != null && this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
    }

    public void hb(int i) {
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

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
