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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.z;
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
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.k;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bd> implements com.baidu.tieba.a.e, aa {
    private String ajh;
    private bd atn;
    private final View.OnClickListener axg;
    private final View.OnClickListener axr;
    private String bER;
    private HeadPendantClickableView bFP;
    protected ThreadSourceShareAndPraiseLayout bFT;
    private RelativeLayout bFc;
    public ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    public View bFf;
    public LinearLayout bGe;
    public ThreadSkinView bGf;
    private g.b bhA;
    private g.f bhz;
    private String biU;
    private View biz;
    private ImageView bsT;
    private Animation bsX;
    private com.baidu.tieba.play.j btj;
    private QuickVideoView.b bts;
    private TbImageView cAq;
    private n cBb;
    private ThreadGodReplyLayout cvM;
    private TbImageView cxQ;
    private TextView cxR;
    private View.OnClickListener cxV;
    public FrameLayout cxX;
    private QuickVideoView cxY;
    private com.baidu.tieba.play.g cxZ;
    private TextView cya;
    private TextView cyc;
    private View cyd;
    private w cye;
    private View cyg;
    private int cyh;
    private int cyi;
    private boolean cyj;
    private Handler cyo;
    private VideoLoadingProgressView.a cyp;
    private TbImageView.a cyq;
    private Runnable cyr;
    private Runnable cys;
    private j.a cyw;
    private Animation.AnimationListener cyx;
    private LinearLayout czN;
    public TextView doZ;
    public LinearLayout dpa;
    private com.baidu.tieba.frs.vc.g dpb;
    private ViewTreeObserver.OnGlobalLayoutListener dpc;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        if (this.cxZ != null) {
            try {
                this.cxY.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cyo.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cyh = 0;
        this.cyi = 1;
        this.cyj = false;
        this.cyo = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aiU();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.aiV();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bhz = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cxZ = gVar;
                if (a.this.cxZ != null) {
                    a.this.cxZ.setVolume(0.0f, 0.0f);
                }
                a.this.cye.blT();
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.aig();
                a.this.e(true, 4);
                return true;
            }
        };
        this.cyp = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aiQ();
            }
        };
        this.cyq = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && a.this.cxQ != null) {
                    a.this.cxQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dpc = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cxX != null && a.this.cxX.getLayoutParams() != null && a.this.cxX.getVisibility() != 8) {
                    a.this.cxX.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cxX.getLayoutParams();
                    if (a.this.cxX.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cxX.getWidth() * 0.5625d);
                        a.this.cxX.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cyr = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cxY != null && !a.this.cxY.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.cys = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.aig();
                a.this.e(true, 4);
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atn != null && !StringUtils.isNull(a.this.atn.vr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.atn.vr(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.axg != null) {
                        a.this.axg.onClick(view);
                    }
                }
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiI() != null) {
                    a.this.aiI().a(view, a.this.atn);
                }
            }
        };
        this.axg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atn != null && a.this.aiI() != null) {
                    a.this.aiI().a(view, a.this.atn);
                }
            }
        };
        this.cyw = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // com.baidu.tieba.play.j.a
            public void aiX() {
                a.this.aiR();
            }
        };
        this.cyx = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cyi == 3 && a.this.cxQ != null) {
                    a.this.cxQ.setVisibility(8);
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
        this.biz = view.findViewById(d.g.divider_line);
        this.bFc = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cAq = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.dpa = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bFc.setOnClickListener(this);
        this.bFP = (HeadPendantClickableView) this.bFc.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.doZ = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.doZ.setVisibility(8);
        this.doZ.setOnClickListener(this.cxV);
        this.cye = new w((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cye.setLoadingAnimationListener(this.cyp);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bFe.setForumAfterClickListener(this.axg);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bFd.setFrom(3);
        this.bFf = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setShareVisible(true);
        this.bFe.setShareReportFrom(1);
        this.bFe.setStType("frs_page");
        this.bFe.setFrom(2);
        this.bFe.aka = 3;
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.bFT.axN.setOnClickListener(this);
        this.bFT.setFrom(2);
        this.bFT.setShareReportFrom(1);
        this.bFT.setSourceFromForPb(3);
        this.bFT.setStType("frs_page");
        this.bFT.setHideBarName(true);
        this.cxX = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cxX.setOnClickListener(this);
        this.cxX.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cxX != null) {
                    a.this.cxX.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dpc);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cxX != null) {
                    a.this.cxX.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dpc);
                }
            }
        });
        this.cxQ = (TbImageView) view.findViewById(d.g.image_video);
        this.cxQ.setPageId(getTag());
        this.cxQ.setDefaultErrorResource(0);
        this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cxQ.setEvent(this.cyq);
        this.cxQ.setGifIconSupport(false);
        this.bsT = (ImageView) view.findViewById(d.g.image_video_play);
        this.cxY = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cBb = new n(this.mContext.getPageActivity());
        this.cxY.setBusiness(this.cBb);
        this.cxY.setOnPreparedListener(this.bhz);
        this.cxY.setOnErrorListener(this.bhA);
        this.cxY.setOnSurfaceDestroyedListener(this.bts);
        this.btj = new com.baidu.tieba.play.j();
        this.btj.setPlayer(this.cxY);
        this.btj.a(this.cyw);
        this.cyg = view.findViewById(d.g.auto_video_black_mask);
        this.cyc = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cyd = view.findViewById(d.g.auto_video_error_background);
        this.bGe = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bGf = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bsX = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.bsX.setAnimationListener(this.cyx);
        this.cya = (TextView) view.findViewById(d.g.text_video_duration);
        this.cxR = (TextView) view.findViewById(d.g.text_video_play_count);
        this.czN = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dpb = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bFc);
        this.dpb.setUniqueId(getTag());
        this.cvM = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cvM.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFc || view == this.bFe.getCommentNumView() || view == this.dpa) {
            ah(this.bFc);
        } else if (view == this.cxX) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                as(this.cxX);
            } else {
                ah(this.cxX);
            }
        } else if (view == this.cvM) {
            ah(this.cvM);
        }
        if (this.atn != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atn));
        }
    }

    private void as(View view) {
        if (this.atn != null) {
            am amVar = new am("c11100");
            amVar.ah("tid", this.atn.getId());
            amVar.ah(ImageViewerConfig.FORUM_ID, this.atn.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (aiI() != null) {
            aiI().a(view, this.atn);
        }
        if (view == this.cxX) {
            if (!com.baidu.adp.lib.util.j.jD()) {
                l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.jE() && !com.baidu.tieba.video.f.bBb().bBc()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.tbadk.browser.a.a(true, (Context) a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                aVar.w(inflate);
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.aiT();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.ce(1);
                aVar.cd(d.C0141d.cp_cont_b);
                aVar.au(true);
                aVar.b(this.mTbPageContext).xa();
            } else {
                aiT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiT() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.atn);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bGe.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bGe.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "frs", this.atn.getTid(), o.vb(), "", videoSerializeVideoThreadInfo)));
    }

    private void ah(View view) {
        if (this.atn != null) {
            if (this.atn.wc()) {
                TiebaStatic.log(new am("c10242").ah(ImageViewerConfig.FORUM_ID, String.valueOf(this.atn.getFid())).r("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.ah("tid", this.atn.getId());
                amVar.ah(ImageViewerConfig.FORUM_ID, this.atn.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.atn.vm() != null && this.atn.vm().getGodUserData() != null && this.atn.vm().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").r("obj_locate", 3).ah("tid", this.atn.getId()));
            }
        }
        if (aiI() != null) {
            aiI().a(view, this.atn);
        }
        if (this.atn != null) {
            o.lb(this.atn.getId());
            al.c(this.mTextTitle, d.C0141d.cp_cont_d, 1);
            u.hF(this.atn.getId());
            if (this.atn.vH() > 0 && com.baidu.tieba.tbadkCore.util.e.bya()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.atn.getTid(), String.valueOf(this.atn.vH()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.atn.wc() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.atn.wl());
                createHistoryCfg.setSmartFrsPosition(this.atn.ws());
                createHistoryCfg.setForumId(String.valueOf(this.atn.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cvM) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.atn, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.atn.wc() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.atn.wl());
            createFromThreadCfg.setSmartFrsPosition(this.atn.ws());
            createFromThreadCfg.setForumId(String.valueOf(this.atn.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cvM) {
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
        this.atn = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiU() {
        this.cyo.removeMessages(202);
        if (this.cxY.getCurrentPosition() > 0) {
            e(true, 3);
            this.cyo.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cyo.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiV() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cyo.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cxY.getCurrentPosition();
        if (currentPosition != this.cyh) {
            this.cyh = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cyo.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bsT != null && this.cxQ != null && this.cyg != null && this.cye != null && this.cyd != null && this.cyc != null) {
            if (z || this.cyi != i) {
                this.cyi = i;
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.cys);
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.cyr);
                if (i == 2) {
                    this.bsT.setVisibility(8);
                    this.bsX.cancel();
                    this.cxQ.clearAnimation();
                    this.cxQ.setVisibility(0);
                    this.cyg.setVisibility(0);
                    this.czN.setVisibility(0);
                    this.cye.startLoading();
                    this.cyd.setVisibility(8);
                    this.cyc.setVisibility(8);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.cys, 60000L);
                } else if (i == 3) {
                    this.bsT.setVisibility(8);
                    this.cxQ.startAnimation(this.bsX);
                    this.cyg.setVisibility(8);
                    this.czN.setVisibility(8);
                    this.cye.blU();
                    this.cyd.setVisibility(8);
                    this.cyc.setVisibility(8);
                } else if (i == 4) {
                    this.bsT.setVisibility(8);
                    this.cxQ.startAnimation(this.bsX);
                    this.cyg.setVisibility(8);
                    this.cye.blV();
                    this.cyd.setVisibility(0);
                    this.cyc.setVisibility(0);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.cyr, 2000L);
                } else {
                    this.bsT.setVisibility(0);
                    this.czN.setVisibility(0);
                    this.bsX.cancel();
                    this.cxQ.clearAnimation();
                    this.cxQ.setVisibility(0);
                    this.cyg.setVisibility(0);
                    this.cye.blV();
                    this.cyd.setVisibility(8);
                    this.cyc.setVisibility(8);
                }
            }
        }
    }

    private void I(final bd bdVar) {
        if (this.cAq != null) {
            if (bdVar == null) {
                this.cAq.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.ajQ)) {
                if (this.dpb != null && this.dpb.azz() && (this.cAq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAq.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mContext.getContext(), d.e.tbds106);
                    this.cAq.setLayoutParams(layoutParams);
                }
                this.cAq.setVisibility(0);
                this.cAq.setImageDrawable(null);
                this.cAq.startLoad(bdVar.ajQ, 10, false);
                this.cAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bdVar.ajR, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cAq.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        if (this.atn == null || this.atn.vm() == null) {
            this.bFc.setVisibility(8);
            return;
        }
        this.bFc.setVisibility(0);
        this.bFc.setOnClickListener(this);
        aiW();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ajh)) {
            this.atn.P(this.mUrl, this.ajh);
        }
        this.atn.e(false, true);
        SpannableStringBuilder vK = this.atn.vK();
        if (this.atn.vQ() && !StringUtils.isNull(this.atn.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.atn.getTid();
            vK.append((CharSequence) this.atn.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(vK));
        this.mTextTitle.setText(vK);
        this.dpb.X(this.atn);
        I(this.atn);
        this.bFd.setData(this.atn);
        if (this.bFd.getHeaderImg() != null) {
            if (this.bFd.getIsSimpleThread()) {
                this.bFd.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (this.atn.vm() == null || this.atn.vm().getPendantData() == null || StringUtils.isNull(this.atn.vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.bFd.getHeaderImg().setVisibility(0);
                this.bFd.getHeaderImg().setData(this.atn);
            } else {
                this.bFd.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(this.atn);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bFe.setLayoutParams(layoutParams);
        this.bFd.setUserAfterClickListener(this.axr);
        hd(go(1));
        this.cya.setText(ao.cX(this.atn.vD().video_duration.intValue() * 1000));
        this.cxR.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ao.E(this.atn.vD().play_count.intValue())));
        this.cvM.setData(this.atn.wy());
        this.cvM.onChangeSkinType();
        if (o.lc(this.atn.getId())) {
            al.c(this.mTextTitle, d.C0141d.cp_cont_d, 1);
            o.a(this.cvM.getGodReplyContent(), this.atn.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aig() {
        this.cyo.removeMessages(202);
        this.cyo.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void aiA() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cyr);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cys);
    }

    private void aiW() {
        aiA();
        aig();
        if (this.cxQ != null && this.cxX != null && this.cxY != null) {
            if (com.baidu.tbadk.core.i.tt().tz() && this.atn != null && this.atn.vD() != null) {
                this.cxX.setVisibility(0);
                this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cxQ.startLoad(this.atn.vD().thumbnail_url, 10, false);
                stopPlay();
                this.biU = this.atn.vD().video_url;
                if (StringUtils.isNull(this.biU)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").ah("tid", this.atn.getId()));
                }
                if (this.cBb != null && this.cBb.blD() != null) {
                    this.cBb.blD().d(this.atn.vD());
                    return;
                }
                return;
            }
            this.cxX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bFc, d.f.addresslist_item_bg);
            al.c(this.bsT, d.f.btn_icon_play_video_n);
            al.h(this.cyc, d.C0141d.cp_cont_i);
            al.h(this.cya, d.C0141d.cp_cont_i);
            al.h(this.cxR, d.C0141d.cp_cont_i);
            al.j(this.cyd, d.C0141d.common_color_10014);
            al.j(this.biz, d.C0141d.cp_bg_line_e);
            if (this.cyc != null) {
                this.cyc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bFT != null && this.bFT.getVisibility() == 0) {
                this.bFT.onChangeSkinType();
            }
            this.bFe.onChangeSkinType();
            this.mSkinType = i;
            this.bFd.onChangeSkinType();
            this.dpb.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cyj;
    }

    public boolean isPlaying() {
        if (this.cxY == null) {
            return false;
        }
        return this.cxY.isPlaying();
    }

    public void startPlay() {
        if (!this.cyj && this.atn != null && this.atn.vD() != null && this.cxY != null && z.o(2, this.biU)) {
            e(true, 2);
            if (StringUtils.isNull(this.biU)) {
                TiebaStatic.log(new am("c12619").ah("obj_locate", "frs").ah("tid", this.atn.getId()));
                this.biU = this.atn.vD().video_url;
            }
            this.cxY.setVideoPath(this.biU, this.atn.getId());
            this.cxY.setLooping(true);
            if (this.btj != null) {
                this.btj.start();
            }
            this.cyj = true;
            aiR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiR() {
        if (this.atn != null && this.atn.vD() != null) {
            String str = this.atn.wc() ? "floor5" : "frs";
            y yVar = new y();
            yVar.mLocate = str;
            yVar.aVt = this.atn.getTid();
            yVar.cBu = this.atn.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.atn.mRecomSource;
            yVar.gdb = this.atn.mRecomAbTag;
            yVar.gdc = this.atn.mRecomWeight;
            yVar.gdd = "";
            yVar.gdf = this.atn.vD().video_md5;
            com.baidu.tieba.play.l.a(this.atn.vD().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        aiA();
        aig();
        e(true, 1);
        if (this.cxY != null) {
            this.cxY.stopPlayback();
            if (this.btj != null) {
                this.btj.stop();
            }
        }
        this.cyj = false;
    }

    public ThreadCommentAndPraiseInfoLayout UW() {
        return this.bFe;
    }

    public ThreadCommentAndPraiseInfoLayout UX() {
        return this.bFT.axN;
    }

    public View getVideoContainer() {
        return this.cxX;
    }

    public String getPlayUrl() {
        return this.biU;
    }

    public int getCurrentPosition() {
        if (this.cxY == null) {
            return 0;
        }
        return this.cxY.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.cBb != null) {
            this.cBb.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bFe != null && this.bFd != null) {
            this.bFd.setPageUniqueId(bdUniqueId);
        }
    }

    public void hd(int i) {
        if (this.atn != null) {
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setData(this.atn);
                this.bFf.setVisibility(8);
                return;
            }
            this.bFf.setVisibility(this.bFe.setData(this.atn) ? 0 : 8);
            this.bFT.setVisibility(8);
        }
    }

    public void P(String str, String str2) {
        this.mUrl = str;
        this.ajh = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
