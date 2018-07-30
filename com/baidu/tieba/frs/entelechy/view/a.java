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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
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
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.j.k;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.play.x;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private String aiZ;
    private bb atD;
    private View axE;
    private final View.OnClickListener axO;
    private final View.OnClickListener axz;
    private String bHB;
    private RelativeLayout bHM;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public View bHP;
    protected ThreadSourceShareAndPraiseLayout bIC;
    public LinearLayout bIN;
    public ThreadSkinView bIO;
    private HeadPendantClickableView bIz;
    public FrameLayout bcQ;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private QuickVideoView bcU;
    private TextView bcV;
    private View bcW;
    private w bcX;
    private View bcY;
    private TextView bcZ;
    private int bda;
    private String bdb;
    private TbImageView.a bdc;
    private g.b bdd;
    private ViewTreeObserver.OnGlobalLayoutListener bde;
    private Runnable bdf;
    private Runnable bdg;
    private QuickVideoView.b bdh;
    private g.a bjG;
    private g.f bjH;
    private View bkE;
    private Animation bve;
    private com.baidu.tieba.play.j bvq;
    private TbImageView cAM;
    private LinearLayout cAj;
    private n cBA;
    private ThreadGodReplyLayout cwv;
    private View.OnClickListener cyC;
    private com.baidu.tieba.play.g cyE;
    private k cyG;
    private int cyI;
    private boolean cyJ;
    private TextView cyN;
    private Handler cyO;
    private VideoLoadingProgressView.a cyP;
    private j.a cyT;
    private Animation.AnimationListener cyU;
    public TextView duV;
    public LinearLayout duW;
    private com.baidu.tieba.frs.vc.g duX;
    public boolean duY;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.cyE != null) {
            try {
                this.bcU.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int se = x.bkW().se(this.bdb);
            if (se != 0) {
                if (this.bcU != null) {
                    this.bcU.rH(se);
                } else {
                    this.cyE.seekTo(se);
                }
            }
            this.cyO.sendEmptyMessageDelayed(202, 40L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cyI = 0;
        this.bda = 1;
        this.cyJ = false;
        this.cyO = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aiL();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.aiM();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bjH = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cyE = gVar;
                if (a.this.cyE != null) {
                    a.this.cyE.setVolume(0.0f, 0.0f);
                }
                a.this.cyG.aVZ();
                a.this.aiH();
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                x.bkW().remove(a.this.bdb);
                a.this.bcU.start();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ahY();
                a.this.e(true, 4);
                return true;
            }
        };
        this.cyP = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aiH();
            }
        };
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.23
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && a.this.bcS != null) {
                    a.this.bcS.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bde = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bcQ != null && a.this.bcQ.getLayoutParams() != null && a.this.bcQ.getVisibility() != 8) {
                    a.this.bcQ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bcQ.getLayoutParams();
                    if (a.this.bcQ.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bcQ.getWidth() * 0.5625d);
                        a.this.bcQ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bcU != null && !a.this.bcU.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bdg = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // java.lang.Runnable
            public void run() {
                a.this.ahY();
                a.this.e(true, 4);
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cyC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atD != null && !StringUtils.isNull(a.this.atD.vq())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.atD.vq(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.axz != null) {
                        a.this.axz.onClick(view);
                    }
                }
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.atD);
                }
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.atD != null && a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.atD);
                }
            }
        };
        this.cyT = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // com.baidu.tieba.play.j.a
            public void aiO() {
                a.this.aiI();
            }
        };
        this.cyU = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bda == 3 && a.this.bcS != null) {
                    a.this.bcS.setVisibility(8);
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
        this.bkE = view.findViewById(d.g.divider_line);
        this.bHM = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cAM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.duW = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bHM.setOnClickListener(this);
        this.bIz = (HeadPendantClickableView) this.bHM.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mContext.getPageActivity(), d.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.duV = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.duV.setVisibility(8);
        this.duV.setOnClickListener(this.cyC);
        this.bcX = new w((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.bcX.setLoadingAnimationListener(this.cyP);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.bHO.setForumAfterClickListener(this.axz);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bHN.setFrom(3);
        this.bHP = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShareVisible(true);
        this.bHO.setShareReportFrom(1);
        this.bHO.setStType("frs_page");
        this.bHO.setFrom(2);
        this.bHO.ajY = 3;
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.bIC.ayr.setOnClickListener(this);
        this.bIC.setFrom(2);
        this.bIC.setShareReportFrom(1);
        this.bIC.setSourceFromForPb(3);
        this.bIC.setStType("frs_page");
        this.bIC.setHideBarName(true);
        this.bcQ = (FrameLayout) view.findViewById(d.g.frame_video);
        this.bcQ.setOnClickListener(this);
        this.bcQ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bcQ != null) {
                    a.this.bcQ.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bde);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bcQ != null) {
                    a.this.bcQ.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bde);
                }
            }
        });
        this.bcS = (TbImageView) view.findViewById(d.g.image_video);
        this.bcS.setPageId(getTag());
        this.bcS.setDefaultErrorResource(0);
        this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcS.setEvent(this.bdc);
        this.bcS.setGifIconSupport(false);
        this.bcT = (ImageView) view.findViewById(d.g.image_video_play);
        this.bcU = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cBA = new n(this.mContext.getPageActivity());
        this.bcU.setBusiness(this.cBA);
        this.bcU.setOnPreparedListener(this.bjH);
        this.bcU.setOnCompletionListener(this.bjG);
        this.bcU.setOnErrorListener(this.bdd);
        this.bcU.setOnSurfaceDestroyedListener(this.bdh);
        this.bvq = new com.baidu.tieba.play.j();
        this.bvq.setPlayer(this.bcU);
        this.bvq.a(this.cyT);
        this.bcY = view.findViewById(d.g.auto_video_black_mask);
        this.bcV = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bcW = view.findViewById(d.g.auto_video_error_background);
        this.bIN = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bIO = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.bve = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.fade_out_video_cover);
        this.bve.setAnimationListener(this.cyU);
        this.bcR = (TextView) view.findViewById(d.g.text_video_duration);
        this.bcZ = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cAj = (LinearLayout) view.findViewById(d.g.duration_container);
        this.duX = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bHM);
        this.duX.setUniqueId(getTag());
        this.cwv = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cwv.setOnClickListener(this);
        this.axE = view.findViewById(d.g.thread_multi_del_mask_view);
        this.axE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bHO != null) {
                    a.this.bHO.changeSelectStatus();
                }
            }
        });
        this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aU(boolean z) {
                if (a.this.axE != null) {
                    am.j(a.this.axE, z ? d.C0140d.cp_bg_line_d : d.C0140d.transparent);
                }
            }
        });
        this.cyN = (TextView) view.findViewById(d.g.nani_video_icon);
        this.cyG = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bHM || view == this.bHO.getCommentNumView() || view == this.duW) {
            am(this.bHM);
        } else if (view == this.bcQ) {
            if (this.atD != null && this.atD.vC() != null) {
                z = this.atD.vC().is_vertical.intValue() == 1;
            }
            if (z) {
                ak(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ax(this.bcQ);
            } else {
                am(this.bcQ);
            }
        } else if (view == this.cwv) {
            am(this.cwv);
        }
        if (this.atD != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atD));
        }
    }

    private void ak(View view) {
        if (aiz() != null) {
            aiz().a(view, this.atD);
        }
        if (!com.baidu.adp.lib.util.j.jE()) {
            l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aiJ();
        }
    }

    private void aiJ() {
        if (this.atD != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.atD);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs")));
        }
    }

    private void ax(View view) {
        if (this.atD != null) {
            an anVar = new an("c11100");
            anVar.af("tid", this.atD.getId());
            anVar.af(ImageViewerConfig.FORUM_ID, this.atD.getFid() + "");
            TiebaStatic.log(anVar);
        }
        if (aiz() != null) {
            aiz().a(view, this.atD);
        }
        if (view == this.bcQ) {
            if (!com.baidu.adp.lib.util.j.jE()) {
                l.showToast(this.mContext.getPageActivity(), d.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.jF() && !com.baidu.tieba.video.g.bAi().bAj()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
                ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
                ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
                ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.tbadk.browser.a.a(true, (Context) a.this.mContext.getPageActivity(), a.this.mContext.getPageActivity().getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    }
                });
                aVar.w(inflate);
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.aiK();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.ch(1);
                aVar.cg(d.C0140d.cp_cont_b);
                aVar.au(true);
                aVar.b(this.mTbPageContext).xf();
            } else {
                aiK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.atD);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bIN.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bIN.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "frs", this.atD.getTid(), o.uY(), "", videoSerializeVideoThreadInfo)));
    }

    private void am(View view) {
        String str;
        String str2;
        if (this.atD != null) {
            if (this.atD.wb()) {
                TiebaStatic.log(new an("c10242").af(ImageViewerConfig.FORUM_ID, String.valueOf(this.atD.getFid())).r("obj_type", 2));
            } else {
                an anVar = new an("c11100");
                anVar.af("tid", this.atD.getId());
                anVar.af(ImageViewerConfig.FORUM_ID, this.atD.getFid() + "");
                TiebaStatic.log(anVar);
            }
            if (this.atD.vk() != null && this.atD.vk().getGodUserData() != null && this.atD.vk().getGodUserData().getType() == 2) {
                TiebaStatic.log(new an("c10806").r("obj_locate", 3).af("tid", this.atD.getId()));
            }
        }
        if (aiz() != null) {
            aiz().a(view, this.atD);
        }
        if (this.atD != null) {
            o.kW(this.atD.getId());
            am.c(this.mTextTitle, d.C0140d.cp_cont_d, 1);
            t.hG(this.atD.getId());
            String valueOf = String.valueOf(this.atD.getFid());
            if (this.atD.ajQ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.atD.ajQ.id;
                str2 = valueOf;
            }
            if (this.atD.vG() > 0 && com.baidu.tieba.tbadkCore.util.e.bxh()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.atD.getTid(), String.valueOf(this.atD.vG()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.atD.wb() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.atD.wk());
                createHistoryCfg.setSmartFrsPosition(this.atD.wr());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cwv) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.atD, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.atD.wb() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.atD.wk());
            createFromThreadCfg.setSmartFrsPosition(this.atD.wr());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cwv) {
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
    /* renamed from: E */
    public void a(bb bbVar) {
        this.atD = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiL() {
        this.cyO.removeMessages(202);
        if (this.bcU.getCurrentPosition() > 0) {
            e(true, 3);
            this.cyO.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            if (this.atD != null && this.atD.vC() != null) {
                this.cyG.a(this.atD.getTid(), this.atD.vC().video_length.intValue(), this.atD.vC().video_duration.intValue(), "frs");
                return;
            }
            return;
        }
        this.cyO.sendEmptyMessageDelayed(202, 40L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiM() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cyO.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bcU.getCurrentPosition();
        if (currentPosition != this.cyI) {
            this.cyI = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cyO.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bcT != null && this.bcS != null && this.bcY != null && this.bcX != null && this.bcW != null && this.bcV != null) {
            if (z || this.bda != i) {
                this.bda = i;
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
                if (i == 2) {
                    this.bcT.setVisibility(8);
                    this.bve.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.cAj.setVisibility(0);
                    this.bcX.startLoading();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdg, 60000L);
                } else if (i == 3) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bve);
                    this.bcY.setVisibility(8);
                    this.cAj.setVisibility(8);
                    this.bcX.bkR();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                } else if (i == 4) {
                    this.bcT.setVisibility(8);
                    this.bcS.startAnimation(this.bve);
                    this.bcY.setVisibility(8);
                    this.bcX.bkS();
                    this.bcW.setVisibility(0);
                    this.bcV.setVisibility(0);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.bdf, 2000L);
                } else {
                    this.bcT.setVisibility(0);
                    this.cAj.setVisibility(0);
                    this.bve.cancel();
                    this.bcS.clearAnimation();
                    this.bcS.setVisibility(0);
                    this.bcY.setVisibility(0);
                    this.bcX.bkS();
                    this.bcW.setVisibility(8);
                    this.bcV.setVisibility(8);
                }
            }
        }
    }

    private void M(final bb bbVar) {
        if (this.cAM != null) {
            if (bbVar == null) {
                this.cAM.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI)) {
                if (this.duX != null && this.duX.aAM() && (this.cAM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAM.getLayoutParams();
                    layoutParams.rightMargin = l.f(this.mContext.getContext(), d.e.tbds106);
                    this.cAM.setLayoutParams(layoutParams);
                }
                this.cAM.setVisibility(0);
                this.cAM.setImageDrawable(null);
                this.cAM.startLoad(bbVar.ajI, 10, false);
                this.cAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAM.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.atD == null || this.atD.vk() == null) {
            this.bHM.setVisibility(8);
            return;
        }
        this.bHM.setVisibility(0);
        this.bHM.setOnClickListener(this);
        aiN();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.aiZ)) {
            this.atD.O(this.mUrl, this.aiZ);
        }
        this.atD.e(false, true);
        SpannableStringBuilder vJ = this.atD.vJ();
        if (this.atD.vP() && !StringUtils.isNull(this.atD.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.atD.getTid();
            vJ.append((CharSequence) this.atD.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.7
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(vJ));
        this.mTextTitle.setText(vJ);
        this.duX.ae(this.atD);
        M(this.atD);
        this.bHN.setData(this.atD);
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (this.atD.vk() == null || this.atD.vk().getPendantData() == null || StringUtils.isNull(this.atD.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(this.atD);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(this.atD);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bHO.setLayoutParams(layoutParams);
        this.bHN.setUserAfterClickListener(this.axO);
        hn(gu(1));
        this.bcR.setText(ap.da(this.atD.vC().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.H(this.atD.vC().play_count.intValue())));
        this.cwv.setData(this.atD.wx());
        this.cwv.onChangeSkinType();
        if (o.kX(this.atD.getId())) {
            am.c(this.mTextTitle, d.C0140d.cp_cont_d, 1);
            o.a(this.cwv.getGodReplyContent(), this.atD.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        } else {
            am.c(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
        if (this.atD == null || this.atD.vC() == null) {
            z = false;
        } else {
            z = this.atD.vC().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cyN.setVisibility(0);
        } else {
            this.cyN.setVisibility(8);
        }
        if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atD().atE()) {
            this.axE.setVisibility(0);
            if (this.atD.wH() || this.atD.wI()) {
                am.j(this.axE, d.C0140d.cp_bg_line_d);
            } else {
                this.axE.setBackgroundResource(d.C0140d.transparent);
            }
        } else {
            this.axE.setVisibility(8);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahY() {
        this.cyO.removeMessages(202);
        this.cyO.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Nc() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
    }

    private void aiN() {
        Nc();
        ahY();
        if (this.bcS != null && this.bcQ != null && this.bcU != null) {
            if (com.baidu.tbadk.core.i.te().tk() && this.atD != null && this.atD.vC() != null) {
                this.bcQ.setVisibility(0);
                this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcS.startLoad(this.atD.vC().thumbnail_url, 10, false);
                stopPlay();
                this.bdb = this.atD.vC().video_url;
                if (StringUtils.isNull(this.bdb)) {
                    e(true, 4);
                    TiebaStatic.log(new an("c12026").af("tid", this.atD.getId()));
                }
                if (this.cBA != null && this.cBA.bkA() != null) {
                    this.cBA.bkA().g(this.atD.vC());
                    return;
                }
                return;
            }
            this.bcQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.bHM, d.f.addresslist_item_bg);
            am.c(this.bcT, d.f.btn_icon_play_video_n);
            am.h(this.bcV, d.C0140d.cp_cont_i);
            am.h(this.bcR, d.C0140d.cp_cont_i);
            am.h(this.bcZ, d.C0140d.cp_cont_i);
            am.j(this.bcW, d.C0140d.common_color_10014);
            am.j(this.bkE, d.C0140d.cp_bg_line_e);
            if (this.bcV != null) {
                this.bcV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bIC != null && this.bIC.getVisibility() == 0) {
                this.bIC.onChangeSkinType();
            }
            this.bHO.onChangeSkinType();
            this.mSkinType = i;
            this.bHN.onChangeSkinType();
            this.duX.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.currentPageType = i;
        if (this.bHO != null) {
            this.bHO.ajY = i;
            if (i == 15) {
                this.bHO.setFrom(10);
            } else {
                this.bHO.setFrom(2);
            }
        }
        if (this.bHN != null) {
            if (i == 15) {
                this.bHN.setFrom(5);
            } else {
                this.bHN.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cyJ;
    }

    public boolean isPlaying() {
        if (this.bcU == null) {
            return false;
        }
        return this.bcU.isPlaying();
    }

    public void startPlay() {
        if (!this.cyJ && this.atD != null && this.atD.vC() != null && this.bcU != null && y.LE()) {
            if (this.duY || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                this.cyG.aVY();
                e(true, 2);
                if (StringUtils.isNull(this.bdb)) {
                    TiebaStatic.log(new an("c12619").af("obj_locate", "frs").af("tid", this.atD.getId()));
                    this.bdb = this.atD.vC().video_url;
                }
                this.bcU.setVideoPath(this.bdb, this.atD.getId());
                if (this.bvq != null) {
                    this.bvq.start();
                }
                this.cyJ = true;
                aiI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        if (this.atD != null && this.atD.vC() != null) {
            String str = this.atD.wb() ? "floor5" : "frs";
            if (this.atD.vp()) {
                str = "frs_mcn";
            }
            com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = str;
            yVar.aWq = this.atD.getTid();
            yVar.cBU = this.atD.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.atD.mRecomSource;
            yVar.ghC = this.atD.mRecomAbTag;
            yVar.ghD = this.atD.mRecomWeight;
            yVar.ghE = "";
            yVar.ghG = this.atD.vC().video_md5;
            com.baidu.tieba.play.l.a(this.atD.vC().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        Nc();
        ahY();
        e(true, 1);
        if (this.bcU != null) {
            if (this.bcU.isPlaying()) {
                x.bkW().aD(this.bdb, this.bcU.getCurrentPosition());
            }
            this.bcU.stopPlayback();
            if (this.bvq != null) {
                this.bvq.stop();
            }
        }
        this.cyJ = false;
    }

    public ThreadCommentAndPraiseInfoLayout VA() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VB() {
        return this.bIC.ayr;
    }

    public View getVideoContainer() {
        return this.bcQ;
    }

    public String getPlayUrl() {
        return this.bdb;
    }

    public int getCurrentPosition() {
        if (this.bcU == null) {
            return 0;
        }
        return this.bcU.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.y yVar) {
        if (this.cBA != null) {
            this.cBA.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHO != null && this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
    }

    public void hn(int i) {
        if (this.atD != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.atD);
                this.bHP.setVisibility(8);
                return;
            }
            this.bHP.setVisibility(this.bHO.setData(this.atD) ? 0 : 8);
            this.bIC.setVisibility(8);
        }
    }

    public void O(String str, String str2) {
        this.mUrl = str;
        this.aiZ = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
