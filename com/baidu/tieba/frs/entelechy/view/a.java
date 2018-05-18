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
    private g.f aZp;
    private g.b aZq;
    private String abd;
    private bd alf;
    private final View.OnClickListener aoY;
    private final View.OnClickListener apj;
    private String baJ;
    private View ban;
    private ImageView bkP;
    private Animation bkT;
    private com.baidu.tieba.play.j blf;
    private QuickVideoView.b bln;
    private String bwO;
    private RelativeLayout bwZ;
    private HeadPendantClickableView bxM;
    protected ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    public View bxc;
    public LinearLayout byb;
    public ThreadSkinView byc;
    private ThreadGodReplyLayout cnh;
    private View cpA;
    private w cpB;
    private View cpD;
    private int cpE;
    private int cpF;
    private boolean cpG;
    private Handler cpL;
    private VideoLoadingProgressView.a cpM;
    private TbImageView.a cpN;
    private Runnable cpO;
    private Runnable cpP;
    private j.a cpT;
    private Animation.AnimationListener cpU;
    private TbImageView cpm;
    private TextView cpn;
    private View.OnClickListener cpr;
    public FrameLayout cpt;
    private QuickVideoView cpv;
    private com.baidu.tieba.play.g cpw;
    private TextView cpx;
    private TextView cpz;
    private TbImageView crN;
    private LinearLayout crl;
    private n csy;
    public TextView dfK;
    public LinearLayout dfL;
    private com.baidu.tieba.frs.vc.g dfM;
    private ViewTreeObserver.OnGlobalLayoutListener dfN;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (this.cpw != null) {
            try {
                this.cpv.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cpL.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cpE = 0;
        this.cpF = 1;
        this.cpG = false;
        this.cpL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
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
        this.aZp = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cpw = gVar;
                if (a.this.cpw != null) {
                    a.this.cpw.setVolume(0.0f, 0.0f);
                }
                a.this.cpB.bgV();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.aeJ();
                a.this.e(true, 4);
                return true;
            }
        };
        this.cpM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.afh();
            }
        };
        this.cpN = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && a.this.cpm != null) {
                    a.this.cpm.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dfN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cpt != null && a.this.cpt.getLayoutParams() != null && a.this.cpt.getVisibility() != 8) {
                    a.this.cpt.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cpt.getLayoutParams();
                    if (a.this.cpt.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cpt.getWidth() * 0.5625d);
                        a.this.cpt.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cpO = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cpv != null && !a.this.cpv.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.cpP = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.aeJ();
                a.this.e(true, 4);
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cpr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.alf != null && !StringUtils.isNull(a.this.alf.rU())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.alf.rU(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
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
        this.cpT = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // com.baidu.tieba.play.j.a
            public void afo() {
                a.this.afi();
            }
        };
        this.cpU = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cpF == 3 && a.this.cpm != null) {
                    a.this.cpm.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mContext = tbPageContext;
        View view2 = getView();
        this.ban = view2.findViewById(d.g.divider_line);
        this.bwZ = (RelativeLayout) view2.findViewById(d.g.layout_root);
        this.crN = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
        this.dfL = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bwZ.setOnClickListener(this);
        this.bxM = (HeadPendantClickableView) this.bwZ.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.dfK = (TextView) view2.findViewById(d.g.thread_info_bar_name);
        this.dfK.setVisibility(8);
        this.dfK.setOnClickListener(this.cpr);
        this.cpB = new w((ViewGroup) view2.findViewById(d.g.auto_video_loading_container));
        this.cpB.setLoadingAnimationListener(this.cpM);
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        this.bxb.setForumAfterClickListener(this.aoY);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bxa.setFrom(3);
        this.bxc = view2.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setShareVisible(true);
        this.bxb.setShareReportFrom(1);
        this.bxb.setStType("frs_page");
        this.bxb.setFrom(2);
        this.bxb.abW = 3;
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.text_bottom_threaad);
        this.bxQ.apG.setOnClickListener(this);
        this.bxQ.setFrom(2);
        this.bxQ.setShareReportFrom(1);
        this.bxQ.setSourceFromForPb(3);
        this.bxQ.setStType("frs_page");
        this.bxQ.setHideBarName(true);
        this.cpt = (FrameLayout) view2.findViewById(d.g.frame_video);
        this.cpt.setOnClickListener(this);
        this.cpt.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view3) {
                if (a.this.cpt != null) {
                    a.this.cpt.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dfN);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view3) {
                if (a.this.cpt != null) {
                    a.this.cpt.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dfN);
                }
            }
        });
        this.cpm = (TbImageView) view2.findViewById(d.g.image_video);
        this.cpm.setPageId(getTag());
        this.cpm.setDefaultErrorResource(0);
        this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cpm.setEvent(this.cpN);
        this.cpm.setGifIconSupport(false);
        this.bkP = (ImageView) view2.findViewById(d.g.image_video_play);
        this.cpv = (QuickVideoView) view2.findViewById(d.g.texture_video_view);
        this.csy = new n(this.mContext.getPageActivity());
        this.cpv.setBusiness(this.csy);
        this.cpv.setOnPreparedListener(this.aZp);
        this.cpv.setOnErrorListener(this.aZq);
        this.cpv.setOnSurfaceDestroyedListener(this.bln);
        this.blf = new com.baidu.tieba.play.j();
        this.blf.setPlayer(this.cpv);
        this.blf.a(this.cpT);
        this.cpD = view2.findViewById(d.g.auto_video_black_mask);
        this.cpz = (TextView) view2.findViewById(d.g.auto_video_error_tips);
        this.cpA = view2.findViewById(d.g.auto_video_error_background);
        this.byb = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.byc = (ThreadSkinView) view2.findViewById(d.g.frs_thread_skin);
        this.bkT = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.bkT.setAnimationListener(this.cpU);
        this.cpx = (TextView) view2.findViewById(d.g.text_video_duration);
        this.cpn = (TextView) view2.findViewById(d.g.text_video_play_count);
        this.crl = (LinearLayout) view2.findViewById(d.g.duration_container);
        this.dfM = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bwZ);
        this.dfM.setUniqueId(getTag());
        this.cnh = (ThreadGodReplyLayout) view2.findViewById(d.g.card_god_reply_layout);
        this.cnh.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.bwZ || view2 == this.bxb.getCommentNumView() || view2 == this.dfL) {
            ah(this.bwZ);
        } else if (view2 == this.cpt) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                as(this.cpt);
            } else {
                ah(this.cpt);
            }
        } else if (view2 == this.cnh) {
            ah(this.cnh);
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
        if (view2 == this.cpt) {
            if (!com.baidu.adp.lib.util.j.gP()) {
                l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.gQ() && !com.baidu.tieba.video.f.bvU().bvV()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        com.baidu.tbadk.browser.a.a(true, (Context) a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
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
                aVar.b(this.mTbPageContext).tC();
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
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.byb.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.byb.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "frs", this.alf.getTid(), o.rF(), "", videoSerializeVideoThreadInfo)));
    }

    private void ah(View view2) {
        if (this.alf != null) {
            if (this.alf.sF()) {
                TiebaStatic.log(new al("c10242").ac(ImageViewerConfig.FORUM_ID, String.valueOf(this.alf.getFid())).r("obj_type", 2));
            } else {
                al alVar = new al("c11100");
                alVar.ac("tid", this.alf.getId());
                alVar.ac(ImageViewerConfig.FORUM_ID, this.alf.getFid() + "");
                TiebaStatic.log(alVar);
            }
            if (this.alf.rP() != null && this.alf.rP().getGodUserData() != null && this.alf.rP().getGodUserData().getType() == 2) {
                TiebaStatic.log(new al("c10806").r("obj_locate", 3).ac("tid", this.alf.getId()));
            }
        }
        if (aeZ() != null) {
            aeZ().a(view2, this.alf);
        }
        if (this.alf != null) {
            o.ky(this.alf.getId());
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
            t.hk(this.alf.getId());
            if (this.alf.sk() > 0 && com.baidu.tieba.tbadkCore.util.e.bsV()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.alf.getTid(), String.valueOf(this.alf.sk()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.alf.sF() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.alf.sO());
                createHistoryCfg.setSmartFrsPosition(this.alf.sV());
                createHistoryCfg.setForumId(String.valueOf(this.alf.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view2 == this.cnh) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.alf, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.alf.sF() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.alf.sO());
            createFromThreadCfg.setSmartFrsPosition(this.alf.sV());
            createFromThreadCfg.setForumId(String.valueOf(this.alf.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view2 == this.cnh) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
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
        this.cpL.removeMessages(202);
        if (this.cpv.getCurrentPosition() > 0) {
            e(true, 3);
            this.cpL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cpL.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cpL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cpv.getCurrentPosition();
        if (currentPosition != this.cpE) {
            this.cpE = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cpL.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bkP != null && this.cpm != null && this.cpD != null && this.cpB != null && this.cpA != null && this.cpz != null) {
            if (z || this.cpF != i) {
                this.cpF = i;
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpP);
                com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpO);
                if (i == 2) {
                    this.bkP.setVisibility(8);
                    this.bkT.cancel();
                    this.cpm.clearAnimation();
                    this.cpm.setVisibility(0);
                    this.cpD.setVisibility(0);
                    this.crl.setVisibility(0);
                    this.cpB.startLoading();
                    this.cpA.setVisibility(8);
                    this.cpz.setVisibility(8);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.cpP, 60000L);
                } else if (i == 3) {
                    this.bkP.setVisibility(8);
                    this.cpm.startAnimation(this.bkT);
                    this.cpD.setVisibility(8);
                    this.crl.setVisibility(8);
                    this.cpB.bgW();
                    this.cpA.setVisibility(8);
                    this.cpz.setVisibility(8);
                } else if (i == 4) {
                    this.bkP.setVisibility(8);
                    this.cpm.startAnimation(this.bkT);
                    this.cpD.setVisibility(8);
                    this.cpB.bgX();
                    this.cpA.setVisibility(0);
                    this.cpz.setVisibility(0);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.cpO, 2000L);
                } else {
                    this.bkP.setVisibility(0);
                    this.crl.setVisibility(0);
                    this.bkT.cancel();
                    this.cpm.clearAnimation();
                    this.cpm.setVisibility(0);
                    this.cpD.setVisibility(0);
                    this.cpB.bgX();
                    this.cpA.setVisibility(8);
                    this.cpz.setVisibility(8);
                }
            }
        }
    }

    private void I(final bd bdVar) {
        if (this.crN != null) {
            if (bdVar == null) {
                this.crN.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abN)) {
                if (this.dfM != null && this.dfM.avq() && (this.crN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.crN.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mContext.getContext(), d.e.tbds106);
                    this.crN.setLayoutParams(layoutParams);
                }
                this.crN.setVisibility(0);
                this.crN.setImageDrawable(null);
                this.crN.startLoad(bdVar.abN, 10, false);
                this.crN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bdVar.abO, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.crN.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        if (this.alf == null || this.alf.rP() == null) {
            this.bwZ.setVisibility(8);
            return;
        }
        this.bwZ.setVisibility(0);
        afn();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.abd)) {
            this.alf.M(this.mUrl, this.abd);
        }
        this.alf.e(false, true);
        SpannableStringBuilder sn = this.alf.sn();
        if (this.alf.st() && !StringUtils.isNull(this.alf.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.alf.getTid();
            sn.append((CharSequence) this.alf.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.4
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
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.j(sn));
        this.mTextTitle.setText(sn);
        this.dfM.X(this.alf);
        I(this.alf);
        this.bxa.setData(this.alf);
        if (this.bxa.getHeaderImg() != null) {
            if (this.bxa.getIsSimpleThread()) {
                this.bxa.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (this.alf.rP() == null || this.alf.rP().getPendantData() == null || StringUtils.isNull(this.alf.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.bxa.getHeaderImg().setVisibility(0);
                this.bxa.getHeaderImg().setData(this.alf);
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(this.alf);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bxb.setLayoutParams(layoutParams);
        this.bxa.setUserAfterClickListener(this.apj);
        hc(gn(1));
        this.cpx.setText(an.cV(this.alf.sg().video_duration.intValue() * 1000));
        this.cpn.setText(String.format(this.mContext.getResources().getString(d.k.play_count), an.B(this.alf.sg().play_count.intValue())));
        this.cnh.setData(this.alf.tb());
        this.cnh.onChangeSkinType();
        if (o.kz(this.alf.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
            o.a(this.cnh.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeJ() {
        this.cpL.removeMessages(202);
        this.cpL.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aeP() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpO);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.cpP);
    }

    private void afn() {
        aeP();
        aeJ();
        if (this.cpm != null && this.cpt != null && this.cpv != null) {
            if (com.baidu.tbadk.core.i.pX().qd() && this.alf != null && this.alf.sg() != null) {
                this.cpt.setVisibility(0);
                this.cpm.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cpm.startLoad(this.alf.sg().thumbnail_url, 10, false);
                stopPlay();
                this.baJ = this.alf.sg().video_url;
                if (StringUtils.isNull(this.baJ)) {
                    e(true, 4);
                    TiebaStatic.log(new al("c12026").ac("tid", this.alf.getId()));
                }
                if (this.csy != null && this.csy.bgF() != null) {
                    this.csy.bgF().d(this.alf.sg());
                    return;
                }
                return;
            }
            this.cpt.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.bwZ, d.f.addresslist_item_bg);
            ak.c(this.bkP, d.f.btn_icon_play_video_n);
            ak.h(this.cpz, d.C0126d.cp_cont_i);
            ak.h(this.cpx, d.C0126d.cp_cont_i);
            ak.h(this.cpn, d.C0126d.cp_cont_i);
            ak.j(this.cpA, d.C0126d.common_color_10014);
            ak.j(this.ban, d.C0126d.cp_bg_line_e);
            if (this.cpz != null) {
                this.cpz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bxQ != null && this.bxQ.getVisibility() == 0) {
                this.bxQ.onChangeSkinType();
            }
            this.bxb.onChangeSkinType();
            this.mSkinType = i;
            this.bxa.onChangeSkinType();
            this.dfM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cpG;
    }

    public boolean isPlaying() {
        if (this.cpv == null) {
            return false;
        }
        return this.cpv.isPlaying();
    }

    public void startPlay() {
        if (!this.cpG && this.alf != null && this.alf.sg() != null && this.cpv != null && y.o(2, this.baJ)) {
            e(true, 2);
            if (StringUtils.isNull(this.baJ)) {
                TiebaStatic.log(new al("c12619").ac("obj_locate", "frs").ac("tid", this.alf.getId()));
                this.baJ = this.alf.sg().video_url;
            }
            this.cpv.setVideoPath(this.baJ, this.alf.getId());
            this.cpv.setLooping(true);
            if (this.blf != null) {
                this.blf.start();
            }
            this.cpG = true;
            afi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.alf != null && this.alf.sg() != null) {
            String str = this.alf.sF() ? "floor5" : "frs";
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.aNv = this.alf.getTid();
            yVar.csP = this.alf.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.alf.mRecomSource;
            yVar.fRP = this.alf.mRecomAbTag;
            yVar.fRQ = this.alf.mRecomWeight;
            yVar.fRR = "";
            yVar.fRT = this.alf.sg().video_md5;
            com.baidu.tieba.play.l.a(this.alf.sg().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aeP();
        aeJ();
        e(true, 1);
        if (this.cpv != null) {
            this.cpv.stopPlayback();
            if (this.blf != null) {
                this.blf.stop();
            }
        }
        this.cpG = false;
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bxb;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        return this.bxQ.apG;
    }

    public View getVideoContainer() {
        return this.cpt;
    }

    public String getPlayUrl() {
        return this.baJ;
    }

    public int getCurrentPosition() {
        if (this.cpv == null) {
            return 0;
        }
        return this.cpv.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.csy != null) {
            this.csy.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bxb != null && this.bxa != null) {
            this.bxa.setPageUniqueId(bdUniqueId);
        }
    }

    public void hc(int i) {
        if (this.alf != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setData(this.alf);
                this.bxc.setVisibility(8);
                return;
            }
            this.bxc.setVisibility(this.bxb.setData(this.alf) ? 0 : 8);
            this.bxQ.setVisibility(8);
        }
    }

    public void M(String str, String str2) {
        this.mUrl = str;
        this.abd = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
