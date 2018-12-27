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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.j.k;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.play.z;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private String aEO;
    private bb aFg;
    private final View.OnClickListener aIy;
    private final View.OnClickListener aKC;
    private String auJ;
    private Animation bOg;
    private com.baidu.tieba.play.j bOr;
    public FrameLayout boN;
    private TextView boO;
    private TbImageView boP;
    private ImageView boQ;
    private QuickVideoView boR;
    private TextView boS;
    private View boT;
    private x boU;
    private View boV;
    private TextView boW;
    private int boX;
    private TbImageView.a boY;
    private g.b boZ;
    private ViewTreeObserver.OnGlobalLayoutListener bpa;
    private Runnable bpb;
    private Runnable bpc;
    private QuickVideoView.b bpd;
    private g.a bxL;
    private g.f bxM;
    private g.e bxO;
    private View byS;
    private ThreadGodReplyLayout cVg;
    private VideoLoadingProgressView.a cXA;
    private j.a cXE;
    private Animation.AnimationListener cXF;
    private View.OnClickListener cXm;
    private com.baidu.tieba.play.g cXo;
    private k cXq;
    private int cXs;
    private boolean cXt;
    private TextView cXy;
    private Handler cXz;
    private LinearLayout cYV;
    private TbImageView cZy;
    private RelativeLayout caK;
    public ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    public View caN;
    private String caz;
    public LinearLayout cbK;
    public ThreadSkinView cbL;
    private HeadPendantClickableView cbw;
    protected ThreadSourceShareAndPraiseLayout cbz;
    public TextView dTY;
    public LinearLayout dTZ;
    private com.baidu.tieba.frs.vc.g dUa;
    public boolean dUb;
    public int dUc;
    private n dam;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aqa() {
        if (this.cXo != null && this.cXt) {
            try {
                this.boR.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cXz.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cXs = 0;
        this.boX = 1;
        this.cXt = false;
        this.cXz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aqe();
                        return;
                    case 203:
                        a.this.aqf();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cXo = gVar;
                if (a.this.cXo != null) {
                    a.this.cXo.setVolume(0.0f, 0.0f);
                }
                a.this.cXq.bdy();
                a.this.aqa();
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.e(false, 3);
                }
                return false;
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                a.this.boR.start();
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.apu();
                a.this.e(true, 4);
                a.this.cXt = false;
                return true;
            }
        };
        this.cXA = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aqa();
            }
        };
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && a.this.boP != null) {
                    a.this.boP.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpa = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.boN != null && a.this.boN.getLayoutParams() != null && a.this.boN.getVisibility() != 8) {
                    a.this.boN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.boN.getLayoutParams();
                    if (a.this.boN.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.boN.getWidth() * 0.5625d);
                        a.this.boN.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bpb = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.boR != null && !a.this.boR.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bpc = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.apu();
                a.this.e(true, 4);
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cXm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFg != null && !StringUtils.isNull(a.this.aFg.zM())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.aFg.zM(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aIy != null) {
                        a.this.aIy.onClick(view);
                    }
                }
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.aFg);
                }
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFg != null && a.this.apS() != null) {
                    a.this.apS().a(view, a.this.aFg);
                }
            }
        };
        this.cXE = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void aqi() {
                a.this.aqb();
            }
        };
        this.cXF = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.boX == 3 && a.this.boP != null) {
                    a.this.boP.setVisibility(8);
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
        this.byS = view.findViewById(e.g.divider_line);
        this.caK = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cZy = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.dTZ = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.caK.setOnClickListener(this);
        this.cbw = (HeadPendantClickableView) this.caK.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.dTY = (TextView) view.findViewById(e.g.thread_info_bar_name);
        this.dTY.setVisibility(8);
        this.dTY.setOnClickListener(this.cXm);
        this.boU = new x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.boU.setLoadingAnimationListener(this.cXA);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.caM.setForumAfterClickListener(this.aIy);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.caL.setFrom(3);
        this.caN = view.findViewById(e.g.divider_below_reply_number_layout);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setIsBarViewVisible(false);
        this.caM.setShareVisible(true);
        this.caM.setShareReportFrom(1);
        this.caM.setStType("frs_page");
        this.caM.setFrom(2);
        this.caM.setDisPraiseFrom(2);
        this.caM.avM = 3;
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.cbz.aKk.setOnClickListener(this);
        this.cbz.setFrom(2);
        this.cbz.setShareReportFrom(1);
        this.cbz.setSourceFromForPb(3);
        this.cbz.setStType("frs_page");
        this.cbz.setHideBarName(true);
        this.boN = (FrameLayout) view.findViewById(e.g.frame_video);
        this.boN.setOnClickListener(this);
        this.boN.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.boN != null) {
                    a.this.boN.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bpa);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.boN != null) {
                    a.this.boN.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bpa);
                }
            }
        });
        this.boP = (TbImageView) view.findViewById(e.g.image_video);
        this.boP.setPageId(getTag());
        this.boP.setDefaultErrorResource(0);
        this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boP.setEvent(this.boY);
        this.boP.setGifIconSupport(false);
        this.boQ = (ImageView) view.findViewById(e.g.image_video_play);
        this.boR = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.dam = new n(this.mContext.getPageActivity());
        this.boR.setPlayerReuseEnable(true);
        this.boR.setContinuePlayEnable(true);
        this.boR.setBusiness(this.dam);
        this.boR.setOnPreparedListener(this.bxM);
        this.boR.setOnCompletionListener(this.bxL);
        this.boR.setOnErrorListener(this.boZ);
        this.boR.setOnOutInfoListener(this.bxO);
        this.boR.setOnSurfaceDestroyedListener(this.bpd);
        this.bOr = new com.baidu.tieba.play.j();
        this.bOr.setPlayer(this.boR);
        this.bOr.a(this.cXE);
        this.boV = view.findViewById(e.g.auto_video_black_mask);
        this.boS = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.boT = view.findViewById(e.g.auto_video_error_background);
        this.cbK = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.cbL = (ThreadSkinView) view.findViewById(e.g.frs_thread_skin);
        this.bOg = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.fade_out_video_cover);
        this.bOg.setAnimationListener(this.cXF);
        this.boO = (TextView) view.findViewById(e.g.text_video_duration);
        this.boW = (TextView) view.findViewById(e.g.text_video_play_count);
        this.cYV = (LinearLayout) view.findViewById(e.g.duration_container);
        this.dUa = new com.baidu.tieba.frs.vc.g(tbPageContext, this.caK);
        this.dUa.setUniqueId(getTag());
        this.cVg = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cVg.setOnClickListener(this);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.caM != null) {
                    a.this.caM.changeSelectStatus();
                }
            }
        });
        this.caM.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bJ(boolean z) {
                if (a.this.mMaskView != null) {
                    al.j(a.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            }
        });
        this.cXy = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cXq = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.caK || view == this.caM.getCommentNumView() || view == this.dTZ) {
            aF(this.caK);
        } else if (view == this.boN) {
            if (this.aFg != null && this.aFg.zY() != null) {
                z = this.aFg.zY().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aQ(this.boN);
            } else {
                aF(this.boN);
            }
        } else if (view == this.cVg) {
            aF(this.cVg);
        }
        if (this.aFg != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFg));
        }
    }

    private void aD(View view) {
        if (apS() != null) {
            apS().a(view, this.aFg);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqc();
        }
    }

    private void aqc() {
        if (this.aFg != null) {
            String str = "frs";
            if (this.dUc == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aFg);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void aQ(View view) {
        if (this.aFg != null) {
            am amVar = new am("c11100");
            amVar.aA("tid", this.aFg.getId());
            amVar.aA(ImageViewerConfig.FORUM_ID, this.aFg.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (apS() != null) {
            apS().a(view, this.aFg);
        }
        if (view == this.boN) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
            } else {
                aqd();
            }
        }
    }

    private void aqd() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aFg);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.cbK.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.cbK.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.dUc == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.aFg.getTid(), o.zu(), "", videoSerializeVideoThreadInfo)));
    }

    private void aF(View view) {
        String str;
        String str2;
        if (this.aFg != null) {
            if (this.aFg.Az()) {
                TiebaStatic.log(new am("c10242").aA(ImageViewerConfig.FORUM_ID, String.valueOf(this.aFg.getFid())).x("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.aA("tid", this.aFg.getId());
                amVar.aA(ImageViewerConfig.FORUM_ID, this.aFg.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.aFg.zG() != null && this.aFg.zG().getGodUserData() != null && this.aFg.zG().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").x("obj_locate", 3).aA("tid", this.aFg.getId()));
            }
        }
        if (apS() != null) {
            apS().a(view, this.aFg);
        }
        if (this.aFg != null) {
            o.mG(this.aFg.getId());
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            v.iL(this.aFg.getId());
            String valueOf = String.valueOf(this.aFg.getFid());
            if (this.aFg.avC == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aFg.avC.id;
                str2 = valueOf;
            }
            if (this.aFg.Ad() > 0 && com.baidu.tieba.tbadkCore.util.e.bFi()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.aFg.getTid(), String.valueOf(this.aFg.Ad()), false, true, "frs_page");
                String str3 = "frs";
                if (this.dUc == 501) {
                    str3 = "frs_tab";
                } else if (this.aFg.Az()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aFg.AI());
                createHistoryCfg.setSmartFrsPosition(this.aFg.AP());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cVg) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.aFg, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.dUc == 501) {
                str4 = "frs_tab";
            } else if (this.aFg.Az()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aFg.AI());
            createFromThreadCfg.setSmartFrsPosition(this.aFg.AP());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cVg) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        this.aFg = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        this.cXz.removeMessages(202);
        if (this.boR.getCurrentPosition() > 0) {
            e(false, 3);
            this.cXz.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cXz.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqf() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cXz.removeMessages(203);
        int currentPosition = this.boR.getCurrentPosition();
        if (currentPosition != this.cXs) {
            this.cXs = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cXz.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.boQ != null && this.boP != null && this.boV != null && this.boU != null && this.boT != null && this.boS != null) {
            if (z || this.boX != i) {
                this.boX = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpc);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpb);
                if (i == 2) {
                    this.boQ.setVisibility(8);
                    this.bOg.cancel();
                    this.boP.clearAnimation();
                    this.boP.setVisibility(0);
                    this.boV.setVisibility(0);
                    this.cYV.setVisibility(0);
                    this.boU.startLoading();
                    this.boT.setVisibility(8);
                    this.boS.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpc, 60000L);
                } else if (i == 3) {
                    this.boQ.setVisibility(8);
                    this.boP.startAnimation(this.bOg);
                    this.boV.setVisibility(8);
                    this.cYV.setVisibility(8);
                    this.boU.bsJ();
                    this.boT.setVisibility(8);
                    this.boS.setVisibility(8);
                    if (this.aFg != null && this.aFg.zY() != null) {
                        this.cXq.a(this.aFg.getTid(), this.aFg.zY().video_length.intValue(), this.aFg.zY().video_duration.intValue(), "frs", this.boR);
                    }
                } else if (i == 4) {
                    this.boQ.setVisibility(8);
                    this.boP.startAnimation(this.bOg);
                    this.boV.setVisibility(8);
                    this.boU.bsK();
                    this.boT.setVisibility(0);
                    this.boS.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.bpb, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.boQ.setVisibility(0);
                    this.cYV.setVisibility(0);
                    this.bOg.cancel();
                    this.boP.clearAnimation();
                    this.boP.setVisibility(0);
                    this.boV.setVisibility(0);
                    this.boU.bsK();
                    this.boT.setVisibility(8);
                    this.boS.setVisibility(8);
                }
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cZy != null) {
            if (bbVar == null) {
                this.cZy.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu)) {
                if (this.dUa != null && this.dUa.aIh() && (this.cZy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cZy.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), e.C0210e.tbds106);
                    this.cZy.setLayoutParams(layoutParams);
                }
                this.cZy.setVisibility(0);
                this.cZy.setImageDrawable(null);
                this.cZy.startLoad(bbVar.avu, 10, false);
                this.cZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cZy.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aFg == null || this.aFg.zG() == null) {
            this.caK.setVisibility(8);
            return;
        }
        this.caK.setVisibility(0);
        this.caK.setOnClickListener(this);
        aqg();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.auJ)) {
            this.aFg.al(this.mUrl, this.auJ);
        }
        this.aFg.g(false, true);
        SpannableStringBuilder Ag = this.aFg.Ag();
        if (this.aFg.An() && !StringUtils.isNull(this.aFg.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aFg.getTid();
            Ag.append((CharSequence) this.aFg.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(Ag));
        this.mTextTitle.setText(Ag);
        this.dUa.af(this.aFg);
        N(this.aFg);
        this.caL.setData(this.aFg);
        if (this.caL.getHeaderImg() != null) {
            if (this.caL.getIsSimpleThread()) {
                this.caL.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (this.aFg.zG() == null || this.aFg.zG().getPendantData() == null || StringUtils.isNull(this.aFg.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.caL.getHeaderImg().setVisibility(0);
                this.caL.getHeaderImg().setData(this.aFg);
            } else {
                this.caL.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(this.aFg);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.caM.setLayoutParams(layoutParams);
        this.caL.setUserAfterClickListener(this.aKC);
        iM(hD(1));
        this.boO.setText(ao.dV(this.aFg.zY().video_duration.intValue() * 1000));
        this.boW.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.aFg.zY().play_count.intValue())));
        this.cVg.setData(this.aFg.AX());
        this.cVg.onChangeSkinType();
        if (o.mH(this.aFg.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            o.a(this.cVg.getGodReplyContent(), this.aFg.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.aFg == null || this.aFg.zY() == null) {
            z = false;
        } else {
            z = this.aFg.zY().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cXy.setVisibility(0);
        } else {
            this.cXy.setVisibility(8);
        }
        if (this.caM.isInFrsAllThread() && com.baidu.tieba.frs.a.aAJ().aAK()) {
            this.mMaskView.setVisibility(0);
            if (this.aFg.Bh() || this.aFg.Bi()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apu() {
        this.cXz.removeMessages(202);
        this.cXz.removeMessages(203);
    }

    private void RM() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpb);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpc);
    }

    private void aqg() {
        RM();
        apu();
        if (this.boP != null && this.boN != null && this.boR != null) {
            if (com.baidu.tbadk.core.i.xE().xI() && this.aFg != null && this.aFg.zY() != null) {
                this.boN.setVisibility(0);
                this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boP.startLoad(this.aFg.zY().thumbnail_url, 10, false);
                stopPlay();
                this.aEO = this.aFg.zY().video_url;
                if (StringUtils.isNull(this.aEO)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").aA("tid", this.aFg.getId()));
                }
                if (this.dam != null && this.dam.bss() != null) {
                    this.dam.bss().g(this.aFg.zY());
                }
                this.boR.ct(this.aEO, this.aFg.tid);
                return;
            }
            this.boN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.caK, e.f.addresslist_item_bg);
            al.c(this.boQ, e.f.btn_icon_play_video_n);
            al.h(this.boS, e.d.cp_cont_i);
            al.h(this.boO, e.d.cp_cont_i);
            al.h(this.boW, e.d.cp_cont_i);
            al.j(this.boT, e.d.common_color_10014);
            al.j(this.byS, e.d.cp_bg_line_e);
            if (this.boS != null) {
                this.boS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.cbz != null && this.cbz.getVisibility() == 0) {
                this.cbz.onChangeSkinType();
            }
            this.caM.onChangeSkinType();
            this.mSkinType = i;
            this.caL.onChangeSkinType();
            this.dUa.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.currentPageType = i;
        if (this.caM != null) {
            this.caM.avM = i;
            if (i == 15) {
                this.caM.setFrom(10);
            } else {
                this.caM.setFrom(2);
                this.caM.setDisPraiseFrom(2);
            }
        }
        if (this.caL != null) {
            if (i == 15) {
                this.caL.setFrom(5);
            } else {
                this.caL.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cXt;
    }

    public boolean isPlaying() {
        if (this.boR == null) {
            return false;
        }
        return this.boR.isPlaying();
    }

    public void startPlay() {
        if (!this.cXt && this.aFg != null && this.aFg.zY() != null && this.boR != null) {
            this.boR.stopPlayback();
            if (aa.Qp()) {
                if (this.dUb || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.cXq.bdx();
                    e(true, 2);
                    if (StringUtils.isNull(this.aEO)) {
                        TiebaStatic.log(new am("c12619").aA("obj_locate", "frs").aA("tid", this.aFg.getId()));
                        this.aEO = this.aFg.zY().video_url;
                    }
                    this.cXt = true;
                    this.boR.setVideoPath(this.aEO, this.aFg.getId());
                    if (this.bOr != null) {
                        this.bOr.start();
                    }
                    aqb();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqb() {
        if (this.aFg != null && this.aFg.zY() != null) {
            String str = this.aFg.Az() ? "floor5" : "frs";
            if (this.aFg.zL()) {
                str = "frs_mcn";
            }
            if (this.dUc == 501) {
                str = "frs_tab";
            }
            z zVar = new z();
            zVar.mLocate = str;
            zVar.biz = this.aFg.getTid();
            zVar.daG = this.aFg.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.aFg.mRecomSource;
            zVar.gHE = this.aFg.mRecomAbTag;
            zVar.gHF = this.aFg.mRecomWeight;
            zVar.gHG = "";
            zVar.gHI = this.aFg.zY().video_md5;
            com.baidu.tieba.play.l.a(this.aFg.zY().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        RM();
        apu();
        e(true, 1);
        if (this.boR != null) {
            this.boR.stopPlayback();
            if (this.bOr != null) {
                this.bOr.stop();
            }
        }
        this.cXt = false;
    }

    public ThreadCommentAndPraiseInfoLayout acq() {
        return this.caM;
    }

    public ThreadCommentAndPraiseInfoLayout acr() {
        return this.cbz.aKk;
    }

    public View getVideoContainer() {
        return this.boN;
    }

    public String getPlayUrl() {
        return this.aEO;
    }

    public int getCurrentPosition() {
        if (this.boR == null) {
            return 0;
        }
        return this.boR.getCurrentPosition();
    }

    public void setVideoStatsData(z zVar) {
        if (this.dam != null) {
            this.dam.setVideoStatsData(zVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caM != null && this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
    }

    public void iM(int i) {
        if (this.aFg != null) {
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setData(this.aFg);
                this.caN.setVisibility(8);
                return;
            }
            this.caM.setData(this.aFg);
            this.caN.setVisibility(8);
            this.cbz.setVisibility(8);
        }
    }

    public void al(String str, String str2) {
        this.mUrl = str;
        this.auJ = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.boP.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.boP.setOnDrawListener(null);
        }
    }
}
