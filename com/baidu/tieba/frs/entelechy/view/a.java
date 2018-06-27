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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
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
public class a extends com.baidu.tieba.card.a<bc> implements com.baidu.tieba.a.e, ab {
    private String ajC;
    private bc atZ;
    private final View.OnClickListener axT;
    private View axY;
    private final View.OnClickListener ayi;
    private String bGM;
    private RelativeLayout bGX;
    public ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    protected ThreadSourceShareAndPraiseLayout bHN;
    public LinearLayout bHY;
    public ThreadSkinView bHZ;
    public View bHa;
    public FrameLayout bcH;
    private TextView bcI;
    private TbImageView bcJ;
    private ImageView bcK;
    private QuickVideoView bcL;
    private TextView bcM;
    private View bcN;
    private w bcO;
    private View bcP;
    private TextView bcQ;
    private int bcR;
    private String bcS;
    private TbImageView.a bcT;
    private g.b bcU;
    private ViewTreeObserver.OnGlobalLayoutListener bcV;
    private Runnable bcW;
    private Runnable bcX;
    private QuickVideoView.b bcY;
    private View bjZ;
    private g.f bjc;
    private com.baidu.tieba.play.j buK;
    private Animation buy;
    private ThreadGodReplyLayout ctS;
    private View.OnClickListener cwa;
    private com.baidu.tieba.play.g cwc;
    private int cwf;
    private boolean cwg;
    private Handler cwl;
    private VideoLoadingProgressView.a cwm;
    private j.a cwq;
    private Animation.AnimationListener cwr;
    private LinearLayout cxG;
    private n cyV;
    private TbImageView cyj;
    public TextView dsi;
    public LinearLayout dsj;
    private com.baidu.tieba.frs.vc.g dsk;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aii() {
        if (this.cwc != null) {
            try {
                this.bcL.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cwl.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cwf = 0;
        this.bcR = 1;
        this.cwg = false;
        this.cwl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aim();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.ain();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bjc = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cwc = gVar;
                if (a.this.cwc != null) {
                    a.this.cwc.setVolume(0.0f, 0.0f);
                }
                a.this.bcO.bmx();
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ahz();
                a.this.e(true, 4);
                return true;
            }
        };
        this.cwm = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aii();
            }
        };
        this.bcT = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && a.this.bcJ != null) {
                    a.this.bcJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bcV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bcH != null && a.this.bcH.getLayoutParams() != null && a.this.bcH.getVisibility() != 8) {
                    a.this.bcH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bcH.getLayoutParams();
                    if (a.this.bcH.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bcH.getWidth() * 0.5625d);
                        a.this.bcH.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bcW = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bcL != null && !a.this.bcL.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bcX = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.ahz();
                a.this.e(true, 4);
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cwa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atZ != null && !StringUtils.isNull(a.this.atZ.vB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.atZ.vB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.axT != null) {
                        a.this.axT.onClick(view);
                    }
                }
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aia() != null) {
                    a.this.aia().a(view, a.this.atZ);
                }
            }
        };
        this.axT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atZ != null && a.this.aia() != null) {
                    a.this.aia().a(view, a.this.atZ);
                }
            }
        };
        this.cwq = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.j.a
            public void aip() {
                a.this.aij();
            }
        };
        this.cwr = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bcR == 3 && a.this.bcJ != null) {
                    a.this.bcJ.setVisibility(8);
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
        this.bjZ = view.findViewById(d.g.divider_line);
        this.bGX = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cyj = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.dsj = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bGX.setOnClickListener(this);
        this.bHK = (HeadPendantClickableView) this.bGX.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(l.e(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bHK.setHasPendantStyle();
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.dsi = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.dsi.setVisibility(8);
        this.dsi.setOnClickListener(this.cwa);
        this.bcO = new w((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.bcO.setLoadingAnimationListener(this.cwm);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bGZ.setForumAfterClickListener(this.axT);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bGY.setFrom(3);
        this.bHa = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setShareVisible(true);
        this.bGZ.setShareReportFrom(1);
        this.bGZ.setStType("frs_page");
        this.bGZ.setFrom(2);
        this.bGZ.akz = 3;
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.bHN.ayE.setOnClickListener(this);
        this.bHN.setFrom(2);
        this.bHN.setShareReportFrom(1);
        this.bHN.setSourceFromForPb(3);
        this.bHN.setStType("frs_page");
        this.bHN.setHideBarName(true);
        this.bcH = (FrameLayout) view.findViewById(d.g.frame_video);
        this.bcH.setOnClickListener(this);
        this.bcH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bcH != null) {
                    a.this.bcH.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bcV);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bcH != null) {
                    a.this.bcH.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bcV);
                }
            }
        });
        this.bcJ = (TbImageView) view.findViewById(d.g.image_video);
        this.bcJ.setPageId(getTag());
        this.bcJ.setDefaultErrorResource(0);
        this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcJ.setEvent(this.bcT);
        this.bcJ.setGifIconSupport(false);
        this.bcK = (ImageView) view.findViewById(d.g.image_video_play);
        this.bcL = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cyV = new n(this.mContext.getPageActivity());
        this.bcL.setBusiness(this.cyV);
        this.bcL.setOnPreparedListener(this.bjc);
        this.bcL.setOnErrorListener(this.bcU);
        this.bcL.setOnSurfaceDestroyedListener(this.bcY);
        this.buK = new com.baidu.tieba.play.j();
        this.buK.setPlayer(this.bcL);
        this.buK.a(this.cwq);
        this.bcP = view.findViewById(d.g.auto_video_black_mask);
        this.bcM = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bcN = view.findViewById(d.g.auto_video_error_background);
        this.bHY = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bHZ = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.buy = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.buy.setAnimationListener(this.cwr);
        this.bcI = (TextView) view.findViewById(d.g.text_video_duration);
        this.bcQ = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cxG = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dsk = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bGX);
        this.dsk.setUniqueId(getTag());
        this.ctS = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.ctS.setOnClickListener(this);
        this.axY = view.findViewById(d.g.thread_multi_del_mask_view);
        this.axY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bGZ != null) {
                    a.this.bGZ.changeSelectStatus();
                }
            }
        });
        this.bGZ.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aW(boolean z) {
                if (a.this.axY != null) {
                    am.j(a.this.axY, z ? d.C0142d.cp_bg_line_d : d.C0142d.transparent);
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGX || view == this.bGZ.getCommentNumView() || view == this.dsj) {
            aj(this.bGX);
        } else if (view == this.bcH) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                au(this.bcH);
            } else {
                aj(this.bcH);
            }
        } else if (view == this.ctS) {
            aj(this.ctS);
        }
        if (this.atZ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atZ));
        }
    }

    private void au(View view) {
        if (this.atZ != null) {
            an anVar = new an("c11100");
            anVar.ah("tid", this.atZ.getId());
            anVar.ah(ImageViewerConfig.FORUM_ID, this.atZ.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aia() != null) {
            aia().a(view, this.atZ);
        }
        if (view == this.bcH) {
            if (!com.baidu.adp.lib.util.j.jD()) {
                l.showToast(this.mContext.getPageActivity(), d.k.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.jE() && !com.baidu.tieba.video.f.bBB().bBC()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.tbadk.browser.a.a(true, (Context) a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                aVar.w(inflate);
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.ail();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.cf(1);
                aVar.ce(d.C0142d.cp_cont_b);
                aVar.aw(true);
                aVar.b(this.mTbPageContext).xn();
            } else {
                ail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ail() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.atZ);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bHY.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bHY.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "frs", this.atZ.getTid(), o.vk(), "", videoSerializeVideoThreadInfo)));
    }

    private void aj(View view) {
        String str;
        String str2;
        if (this.atZ != null) {
            if (this.atZ.wm()) {
                TiebaStatic.log(new an("c10242").ah(ImageViewerConfig.FORUM_ID, String.valueOf(this.atZ.getFid())).r("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.ah("tid", this.atZ.getId());
                anVar.ah(ImageViewerConfig.FORUM_ID, this.atZ.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.atZ.vw() != null && this.atZ.vw().getGodUserData() != null && this.atZ.vw().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").r("obj_locate", 3).ah("tid", this.atZ.getId()));
            }
        }
        if (aia() != null) {
            aia().a(view, this.atZ);
        }
        if (this.atZ != null) {
            o.kY(this.atZ.getId());
            am.c(this.mTextTitle, d.C0142d.cp_cont_d, 1);
            u.hJ(this.atZ.getId());
            String valueOf = String.valueOf(this.atZ.getFid());
            if (this.atZ.akt == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.atZ.akt.id;
                str2 = valueOf;
            }
            if (this.atZ.vR() > 0 && com.baidu.tieba.tbadkCore.util.e.byE()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.atZ.getTid(), String.valueOf(this.atZ.vR()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.atZ.wm() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.atZ.wv());
                createHistoryCfg.setSmartFrsPosition(this.atZ.wC());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.ctS) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.atZ, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.atZ.wm() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.atZ.wv());
            createFromThreadCfg.setSmartFrsPosition(this.atZ.wC());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.ctS) {
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
    /* renamed from: C */
    public void a(bc bcVar) {
        this.atZ = bcVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aim() {
        this.cwl.removeMessages(202);
        if (this.bcL.getCurrentPosition() > 0) {
            e(true, 3);
            this.cwl.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cwl.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ain() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cwl.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bcL.getCurrentPosition();
        if (currentPosition != this.cwf) {
            this.cwf = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cwl.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bcK != null && this.bcJ != null && this.bcP != null && this.bcO != null && this.bcN != null && this.bcM != null) {
            if (z || this.bcR != i) {
                this.bcR = i;
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcX);
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcW);
                if (i == 2) {
                    this.bcK.setVisibility(8);
                    this.buy.cancel();
                    this.bcJ.clearAnimation();
                    this.bcJ.setVisibility(0);
                    this.bcP.setVisibility(0);
                    this.cxG.setVisibility(0);
                    this.bcO.startLoading();
                    this.bcN.setVisibility(8);
                    this.bcM.setVisibility(8);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.bcX, 60000L);
                } else if (i == 3) {
                    this.bcK.setVisibility(8);
                    this.bcJ.startAnimation(this.buy);
                    this.bcP.setVisibility(8);
                    this.cxG.setVisibility(8);
                    this.bcO.bmy();
                    this.bcN.setVisibility(8);
                    this.bcM.setVisibility(8);
                } else if (i == 4) {
                    this.bcK.setVisibility(8);
                    this.bcJ.startAnimation(this.buy);
                    this.bcP.setVisibility(8);
                    this.bcO.bmz();
                    this.bcN.setVisibility(0);
                    this.bcM.setVisibility(0);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.bcW, 2000L);
                } else {
                    this.bcK.setVisibility(0);
                    this.cxG.setVisibility(0);
                    this.buy.cancel();
                    this.bcJ.clearAnimation();
                    this.bcJ.setVisibility(0);
                    this.bcP.setVisibility(0);
                    this.bcO.bmz();
                    this.bcN.setVisibility(8);
                    this.bcM.setVisibility(8);
                }
            }
        }
    }

    private void K(final bc bcVar) {
        if (this.cyj != null) {
            if (bcVar == null) {
                this.cyj.setVisibility(8);
            } else if (!StringUtils.isNull(bcVar.akl)) {
                if (this.dsk != null && this.dsk.aAf() && (this.cyj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cyj.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mContext.getContext(), d.e.tbds106);
                    this.cyj.setLayoutParams(layoutParams);
                }
                this.cyj.setVisibility(0);
                this.cyj.setImageDrawable(null);
                this.cyj.startLoad(bcVar.akl, 10, false);
                this.cyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bcVar.akm, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cyj.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        if (this.atZ == null || this.atZ.vw() == null) {
            this.bGX.setVisibility(8);
            return;
        }
        this.bGX.setVisibility(0);
        this.bGX.setOnClickListener(this);
        aio();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ajC)) {
            this.atZ.P(this.mUrl, this.ajC);
        }
        this.atZ.e(false, true);
        SpannableStringBuilder vU = this.atZ.vU();
        if (this.atZ.wa() && !StringUtils.isNull(this.atZ.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.atZ.getTid();
            vU.append((CharSequence) this.atZ.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.6
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0142d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new k(vU));
        this.mTextTitle.setText(vU);
        this.dsk.ac(this.atZ);
        K(this.atZ);
        this.bGY.setData(this.atZ);
        if (this.bGY.getHeaderImg() != null) {
            if (this.bGY.getIsSimpleThread()) {
                this.bGY.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (this.atZ.vw() == null || this.atZ.vw().getPendantData() == null || StringUtils.isNull(this.atZ.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.bGY.getHeaderImg().setVisibility(0);
                this.bGY.getHeaderImg().setData(this.atZ);
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(this.atZ);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bGZ.setLayoutParams(layoutParams);
        this.bGY.setUserAfterClickListener(this.ayi);
        hh(gp(1));
        this.bcI.setText(ap.cY(this.atZ.vN().video_duration.intValue() * 1000));
        this.bcQ.setText(String.format(this.mContext.getResources().getString(d.k.play_count), ap.F(this.atZ.vN().play_count.intValue())));
        this.ctS.setData(this.atZ.wI());
        this.ctS.onChangeSkinType();
        if (o.kZ(this.atZ.getId())) {
            am.c(this.mTextTitle, d.C0142d.cp_cont_d, 1);
            o.a(this.ctS.getGodReplyContent(), this.atZ.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
        } else {
            am.c(this.mTextTitle, d.C0142d.cp_cont_b, 1);
        }
        if (this.bGZ.isInFrsAllThread() && com.baidu.tieba.frs.a.asZ().ata()) {
            this.axY.setVisibility(0);
            if (this.atZ.wS() || this.atZ.wT()) {
                am.j(this.axY, d.C0142d.cp_bg_line_d);
            } else {
                this.axY.setBackgroundResource(d.C0142d.transparent);
            }
        } else {
            this.axY.setVisibility(8);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahz() {
        this.cwl.removeMessages(202);
        this.cwl.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Ng() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcW);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcX);
    }

    private void aio() {
        Ng();
        ahz();
        if (this.bcJ != null && this.bcH != null && this.bcL != null) {
            if (com.baidu.tbadk.core.i.tt().tz() && this.atZ != null && this.atZ.vN() != null) {
                this.bcH.setVisibility(0);
                this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcJ.startLoad(this.atZ.vN().thumbnail_url, 10, false);
                stopPlay();
                this.bcS = this.atZ.vN().video_url;
                if (StringUtils.isNull(this.bcS)) {
                    e(true, 4);
                    TiebaStatic.log(new an("c12026").ah("tid", this.atZ.getId()));
                }
                if (this.cyV != null && this.cyV.bmh() != null) {
                    this.cyV.bmh().g(this.atZ.vN());
                    return;
                }
                return;
            }
            this.bcH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bGX, d.f.addresslist_item_bg);
            am.c(this.bcK, d.f.btn_icon_play_video_n);
            am.h(this.bcM, d.C0142d.cp_cont_i);
            am.h(this.bcI, d.C0142d.cp_cont_i);
            am.h(this.bcQ, d.C0142d.cp_cont_i);
            am.j(this.bcN, d.C0142d.common_color_10014);
            am.j(this.bjZ, d.C0142d.cp_bg_line_e);
            if (this.bcM != null) {
                this.bcM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bHN != null && this.bHN.getVisibility() == 0) {
                this.bHN.onChangeSkinType();
            }
            this.bGZ.onChangeSkinType();
            this.mSkinType = i;
            this.bGY.onChangeSkinType();
            this.dsk.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.currentPageType = i;
        if (this.bGZ != null) {
            this.bGZ.akz = i;
            if (i == 15) {
                this.bGZ.setFrom(10);
            } else {
                this.bGZ.setFrom(2);
            }
        }
        if (this.bGY != null) {
            if (i == 15) {
                this.bGY.setFrom(5);
            } else {
                this.bGY.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cwg;
    }

    public boolean isPlaying() {
        if (this.bcL == null) {
            return false;
        }
        return this.bcL.isPlaying();
    }

    public void startPlay() {
        if (!this.cwg && this.atZ != null && this.atZ.vN() != null && this.bcL != null && z.o(2, this.bcS)) {
            e(true, 2);
            if (StringUtils.isNull(this.bcS)) {
                TiebaStatic.log(new an("c12619").ah("obj_locate", "frs").ah("tid", this.atZ.getId()));
                this.bcS = this.atZ.vN().video_url;
            }
            this.bcL.setVideoPath(this.bcS, this.atZ.getId());
            this.bcL.setLooping(true);
            if (this.buK != null) {
                this.buK.start();
            }
            this.cwg = true;
            aij();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (this.atZ != null && this.atZ.vN() != null) {
            String str = this.atZ.wm() ? "floor5" : "frs";
            y yVar = new y();
            yVar.mLocate = str;
            yVar.aWo = this.atZ.getTid();
            yVar.czo = this.atZ.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.atZ.mRecomSource;
            yVar.ghc = this.atZ.mRecomAbTag;
            yVar.ghd = this.atZ.mRecomWeight;
            yVar.ghe = "";
            yVar.ghg = this.atZ.vN().video_md5;
            com.baidu.tieba.play.l.a(this.atZ.vN().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        Ng();
        ahz();
        e(true, 1);
        if (this.bcL != null) {
            this.bcL.stopPlayback();
            if (this.buK != null) {
                this.buK.stop();
            }
        }
        this.cwg = false;
    }

    public ThreadCommentAndPraiseInfoLayout Vr() {
        return this.bGZ;
    }

    public ThreadCommentAndPraiseInfoLayout Vs() {
        return this.bHN.ayE;
    }

    public View getVideoContainer() {
        return this.bcH;
    }

    public String getPlayUrl() {
        return this.bcS;
    }

    public int getCurrentPosition() {
        if (this.bcL == null) {
            return 0;
        }
        return this.bcL.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.cyV != null) {
            this.cyV.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bGZ != null && this.bGY != null) {
            this.bGY.setPageUniqueId(bdUniqueId);
        }
    }

    public void hh(int i) {
        if (this.atZ != null) {
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setData(this.atZ);
                this.bHa.setVisibility(8);
                return;
            }
            this.bHa.setVisibility(this.bGZ.setData(this.atZ) ? 0 : 8);
            this.bHN.setVisibility(8);
        }
    }

    public void P(String str, String str2) {
        this.mUrl = str;
        this.ajC = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
