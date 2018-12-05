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
    private String aEN;
    private bb aFf;
    private final View.OnClickListener aIx;
    private final View.OnClickListener aKA;
    private String auJ;
    private Animation bOd;
    private com.baidu.tieba.play.j bOo;
    public FrameLayout boK;
    private TextView boL;
    private TbImageView boM;
    private ImageView boN;
    private QuickVideoView boO;
    private TextView boP;
    private View boQ;
    private x boR;
    private View boS;
    private TextView boT;
    private int boU;
    private TbImageView.a boV;
    private g.b boW;
    private ViewTreeObserver.OnGlobalLayoutListener boX;
    private Runnable boY;
    private Runnable boZ;
    private QuickVideoView.b bpa;
    private g.a bxI;
    private g.f bxJ;
    private g.e bxL;
    private View byP;
    private ThreadGodReplyLayout cSq;
    private k cUA;
    private int cUC;
    private boolean cUD;
    private TextView cUI;
    private Handler cUJ;
    private VideoLoadingProgressView.a cUK;
    private j.a cUO;
    private Animation.AnimationListener cUP;
    private View.OnClickListener cUw;
    private com.baidu.tieba.play.g cUy;
    private TbImageView cWI;
    private LinearLayout cWf;
    private n cXw;
    private RelativeLayout caH;
    public ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    public View caK;
    private String caw;
    public LinearLayout cbH;
    public ThreadSkinView cbI;
    private HeadPendantClickableView cbt;
    protected ThreadSourceShareAndPraiseLayout cbw;
    public TextView dRh;
    public LinearLayout dRi;
    private com.baidu.tieba.frs.vc.g dRj;
    public boolean dRk;
    public int dRl;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void apl() {
        if (this.cUy != null && this.cUD) {
            try {
                this.boO.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cUJ.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cUC = 0;
        this.boU = 1;
        this.cUD = false;
        this.cUJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.app();
                        return;
                    case 203:
                        a.this.apq();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxJ = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cUy = gVar;
                if (a.this.cUy != null) {
                    a.this.cUy.setVolume(0.0f, 0.0f);
                }
                a.this.cUA.bcL();
                a.this.apl();
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.e(false, 3);
                }
                return false;
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                a.this.boO.start();
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.aoE();
                a.this.e(true, 4);
                a.this.cUD = false;
                return true;
            }
        };
        this.cUK = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.apl();
            }
        };
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && a.this.boM != null) {
                    a.this.boM.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.boX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.boK != null && a.this.boK.getLayoutParams() != null && a.this.boK.getVisibility() != 8) {
                    a.this.boK.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.boK.getLayoutParams();
                    if (a.this.boK.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.boK.getWidth() * 0.5625d);
                        a.this.boK.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.boY = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.boO != null && !a.this.boO.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.boZ = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aoE();
                a.this.e(true, 4);
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cUw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFf != null && !StringUtils.isNull(a.this.aFf.zM())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.aFf.zM(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aIx != null) {
                        a.this.aIx.onClick(view);
                    }
                }
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.aFf);
                }
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aFf != null && a.this.apc() != null) {
                    a.this.apc().a(view, a.this.aFf);
                }
            }
        };
        this.cUO = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void apt() {
                a.this.apm();
            }
        };
        this.cUP = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.boU == 3 && a.this.boM != null) {
                    a.this.boM.setVisibility(8);
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
        this.byP = view.findViewById(e.g.divider_line);
        this.caH = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cWI = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.dRi = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.caH.setOnClickListener(this);
        this.cbt = (HeadPendantClickableView) this.caH.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.dRh = (TextView) view.findViewById(e.g.thread_info_bar_name);
        this.dRh.setVisibility(8);
        this.dRh.setOnClickListener(this.cUw);
        this.boR = new x((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.boR.setLoadingAnimationListener(this.cUK);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.caJ.setForumAfterClickListener(this.aIx);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.caI.setFrom(3);
        this.caK = view.findViewById(e.g.divider_below_reply_number_layout);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setShareVisible(true);
        this.caJ.setShareReportFrom(1);
        this.caJ.setStType("frs_page");
        this.caJ.setFrom(2);
        this.caJ.setDisPraiseFrom(2);
        this.caJ.avL = 3;
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.cbw.aKi.setOnClickListener(this);
        this.cbw.setFrom(2);
        this.cbw.setShareReportFrom(1);
        this.cbw.setSourceFromForPb(3);
        this.cbw.setStType("frs_page");
        this.cbw.setHideBarName(true);
        this.boK = (FrameLayout) view.findViewById(e.g.frame_video);
        this.boK.setOnClickListener(this);
        this.boK.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.boK != null) {
                    a.this.boK.getViewTreeObserver().addOnGlobalLayoutListener(a.this.boX);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.boK != null) {
                    a.this.boK.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.boX);
                }
            }
        });
        this.boM = (TbImageView) view.findViewById(e.g.image_video);
        this.boM.setPageId(getTag());
        this.boM.setDefaultErrorResource(0);
        this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boM.setEvent(this.boV);
        this.boM.setGifIconSupport(false);
        this.boN = (ImageView) view.findViewById(e.g.image_video_play);
        this.boO = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.cXw = new n(this.mContext.getPageActivity());
        this.boO.setPlayerReuseEnable(true);
        this.boO.setContinuePlayEnable(true);
        this.boO.setBusiness(this.cXw);
        this.boO.setOnPreparedListener(this.bxJ);
        this.boO.setOnCompletionListener(this.bxI);
        this.boO.setOnErrorListener(this.boW);
        this.boO.setOnOutInfoListener(this.bxL);
        this.boO.setOnSurfaceDestroyedListener(this.bpa);
        this.bOo = new com.baidu.tieba.play.j();
        this.bOo.setPlayer(this.boO);
        this.bOo.a(this.cUO);
        this.boS = view.findViewById(e.g.auto_video_black_mask);
        this.boP = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.boQ = view.findViewById(e.g.auto_video_error_background);
        this.cbH = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.cbI = (ThreadSkinView) view.findViewById(e.g.frs_thread_skin);
        this.bOd = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.fade_out_video_cover);
        this.bOd.setAnimationListener(this.cUP);
        this.boL = (TextView) view.findViewById(e.g.text_video_duration);
        this.boT = (TextView) view.findViewById(e.g.text_video_play_count);
        this.cWf = (LinearLayout) view.findViewById(e.g.duration_container);
        this.dRj = new com.baidu.tieba.frs.vc.g(tbPageContext, this.caH);
        this.dRj.setUniqueId(getTag());
        this.cSq = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cSq.setOnClickListener(this);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.caJ != null) {
                    a.this.caJ.changeSelectStatus();
                }
            }
        });
        this.caJ.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bJ(boolean z) {
                if (a.this.mMaskView != null) {
                    al.j(a.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            }
        });
        this.cUI = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cUA = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.caH || view == this.caJ.getCommentNumView() || view == this.dRi) {
            aC(this.caH);
        } else if (view == this.boK) {
            if (this.aFf != null && this.aFf.zY() != null) {
                z = this.aFf.zY().is_vertical.intValue() == 1;
            }
            if (z) {
                aA(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aN(this.boK);
            } else {
                aC(this.boK);
            }
        } else if (view == this.cSq) {
            aC(this.cSq);
        }
        if (this.aFf != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFf));
        }
    }

    private void aA(View view) {
        if (apc() != null) {
            apc().a(view, this.aFf);
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            apn();
        }
    }

    private void apn() {
        if (this.aFf != null) {
            String str = "frs";
            if (this.dRl == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.aFf);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void aN(View view) {
        if (this.aFf != null) {
            am amVar = new am("c11100");
            amVar.aA("tid", this.aFf.getId());
            amVar.aA(ImageViewerConfig.FORUM_ID, this.aFf.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (apc() != null) {
            apc().a(view, this.aFf);
        }
        if (view == this.boK) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
            } else {
                apo();
            }
        }
    }

    private void apo() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aFf);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.cbH.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.cbH.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.dRl == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.aFf.getTid(), o.zu(), "", videoSerializeVideoThreadInfo)));
    }

    private void aC(View view) {
        String str;
        String str2;
        if (this.aFf != null) {
            if (this.aFf.Az()) {
                TiebaStatic.log(new am("c10242").aA(ImageViewerConfig.FORUM_ID, String.valueOf(this.aFf.getFid())).x("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.aA("tid", this.aFf.getId());
                amVar.aA(ImageViewerConfig.FORUM_ID, this.aFf.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.aFf.zG() != null && this.aFf.zG().getGodUserData() != null && this.aFf.zG().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").x("obj_locate", 3).aA("tid", this.aFf.getId()));
            }
        }
        if (apc() != null) {
            apc().a(view, this.aFf);
        }
        if (this.aFf != null) {
            o.mD(this.aFf.getId());
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            v.iK(this.aFf.getId());
            String valueOf = String.valueOf(this.aFf.getFid());
            if (this.aFf.avC == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.aFf.avC.id;
                str2 = valueOf;
            }
            if (this.aFf.Ad() > 0 && com.baidu.tieba.tbadkCore.util.e.bEr()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.aFf.getTid(), String.valueOf(this.aFf.Ad()), false, true, "frs_page");
                String str3 = "frs";
                if (this.dRl == 501) {
                    str3 = "frs_tab";
                } else if (this.aFf.Az()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.aFf.AI());
                createHistoryCfg.setSmartFrsPosition(this.aFf.AP());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cSq) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.aFf, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.dRl == 501) {
                str4 = "frs_tab";
            } else if (this.aFf.Az()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.aFf.AI());
            createFromThreadCfg.setSmartFrsPosition(this.aFf.AP());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cSq) {
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
        this.aFf = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void app() {
        this.cUJ.removeMessages(202);
        if (this.boO.getCurrentPosition() > 0) {
            e(false, 3);
            this.cUJ.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.cUJ.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cUJ.removeMessages(203);
        int currentPosition = this.boO.getCurrentPosition();
        if (currentPosition != this.cUC) {
            this.cUC = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cUJ.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.boN != null && this.boM != null && this.boS != null && this.boR != null && this.boQ != null && this.boP != null) {
            if (z || this.boU != i) {
                this.boU = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boZ);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boY);
                if (i == 2) {
                    this.boN.setVisibility(8);
                    this.bOd.cancel();
                    this.boM.clearAnimation();
                    this.boM.setVisibility(0);
                    this.boS.setVisibility(0);
                    this.cWf.setVisibility(0);
                    this.boR.startLoading();
                    this.boQ.setVisibility(8);
                    this.boP.setVisibility(8);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.boZ, 60000L);
                } else if (i == 3) {
                    this.boN.setVisibility(8);
                    this.boM.startAnimation(this.bOd);
                    this.boS.setVisibility(8);
                    this.cWf.setVisibility(8);
                    this.boR.brY();
                    this.boQ.setVisibility(8);
                    this.boP.setVisibility(8);
                    if (this.aFf != null && this.aFf.zY() != null) {
                        this.cUA.a(this.aFf.getTid(), this.aFf.zY().video_length.intValue(), this.aFf.zY().video_duration.intValue(), "frs", this.boO);
                    }
                } else if (i == 4) {
                    this.boN.setVisibility(8);
                    this.boM.startAnimation(this.bOd);
                    this.boS.setVisibility(8);
                    this.boR.brZ();
                    this.boQ.setVisibility(0);
                    this.boP.setVisibility(0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.boY, SystemScreenshotManager.DELAY_TIME);
                } else {
                    this.boN.setVisibility(0);
                    this.cWf.setVisibility(0);
                    this.bOd.cancel();
                    this.boM.clearAnimation();
                    this.boM.setVisibility(0);
                    this.boS.setVisibility(0);
                    this.boR.brZ();
                    this.boQ.setVisibility(8);
                    this.boP.setVisibility(8);
                }
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cWI != null) {
            if (bbVar == null) {
                this.cWI.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu)) {
                if (this.dRj != null && this.dRj.aHs() && (this.cWI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWI.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), e.C0210e.tbds106);
                    this.cWI.setLayoutParams(layoutParams);
                }
                this.cWI.setVisibility(0);
                this.cWI.setImageDrawable(null);
                this.cWI.startLoad(bbVar.avu, 10, false);
                this.cWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cWI.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.aFf == null || this.aFf.zG() == null) {
            this.caH.setVisibility(8);
            return;
        }
        this.caH.setVisibility(0);
        this.caH.setOnClickListener(this);
        apr();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.auJ)) {
            this.aFf.al(this.mUrl, this.auJ);
        }
        this.aFf.g(false, true);
        SpannableStringBuilder Ag = this.aFf.Ag();
        if (this.aFf.An() && !StringUtils.isNull(this.aFf.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aFf.getTid();
            Ag.append((CharSequence) this.aFf.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
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
        this.dRj.af(this.aFf);
        N(this.aFf);
        this.caI.setData(this.aFf);
        if (this.caI.getHeaderImg() != null) {
            if (this.caI.getIsSimpleThread()) {
                this.caI.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (this.aFf.zG() == null || this.aFf.zG().getPendantData() == null || StringUtils.isNull(this.aFf.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.caI.getHeaderImg().setVisibility(0);
                this.caI.getHeaderImg().setData(this.aFf);
            } else {
                this.caI.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(this.aFf);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.caJ.setLayoutParams(layoutParams);
        this.caI.setUserAfterClickListener(this.aKA);
        iL(hC(1));
        this.boL.setText(ao.dV(this.aFf.zY().video_duration.intValue() * 1000));
        this.boT.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.W(this.aFf.zY().play_count.intValue())));
        this.cSq.setData(this.aFf.AX());
        this.cSq.onChangeSkinType();
        if (o.mE(this.aFf.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            o.a(this.cSq.getGodReplyContent(), this.aFf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.aFf == null || this.aFf.zY() == null) {
            z = false;
        } else {
            z = this.aFf.zY().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cUI.setVisibility(0);
        } else {
            this.cUI.setVisibility(8);
        }
        if (this.caJ.isInFrsAllThread() && com.baidu.tieba.frs.a.azU().azV()) {
            this.mMaskView.setVisibility(0);
            if (this.aFf.Bh() || this.aFf.Bi()) {
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
    public void aoE() {
        this.cUJ.removeMessages(202);
        this.cUJ.removeMessages(203);
    }

    private void RK() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boY);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boZ);
    }

    private void apr() {
        RK();
        aoE();
        if (this.boM != null && this.boK != null && this.boO != null) {
            if (com.baidu.tbadk.core.i.xE().xI() && this.aFf != null && this.aFf.zY() != null) {
                this.boK.setVisibility(0);
                this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boM.startLoad(this.aFf.zY().thumbnail_url, 10, false);
                stopPlay();
                this.aEN = this.aFf.zY().video_url;
                if (StringUtils.isNull(this.aEN)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").aA("tid", this.aFf.getId()));
                }
                if (this.cXw != null && this.cXw.brH() != null) {
                    this.cXw.brH().g(this.aFf.zY());
                }
                this.boO.ct(this.aEN, this.aFf.tid);
                return;
            }
            this.boK.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.caH, e.f.addresslist_item_bg);
            al.c(this.boN, e.f.btn_icon_play_video_n);
            al.h(this.boP, e.d.cp_cont_i);
            al.h(this.boL, e.d.cp_cont_i);
            al.h(this.boT, e.d.cp_cont_i);
            al.j(this.boQ, e.d.common_color_10014);
            al.j(this.byP, e.d.cp_bg_line_e);
            if (this.boP != null) {
                this.boP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.cbw != null && this.cbw.getVisibility() == 0) {
                this.cbw.onChangeSkinType();
            }
            this.caJ.onChangeSkinType();
            this.mSkinType = i;
            this.caI.onChangeSkinType();
            this.dRj.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.currentPageType = i;
        if (this.caJ != null) {
            this.caJ.avL = i;
            if (i == 15) {
                this.caJ.setFrom(10);
            } else {
                this.caJ.setFrom(2);
                this.caJ.setDisPraiseFrom(2);
            }
        }
        if (this.caI != null) {
            if (i == 15) {
                this.caI.setFrom(5);
            } else {
                this.caI.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cUD;
    }

    public boolean isPlaying() {
        if (this.boO == null) {
            return false;
        }
        return this.boO.isPlaying();
    }

    public void startPlay() {
        if (!this.cUD && this.aFf != null && this.aFf.zY() != null && this.boO != null) {
            this.boO.stopPlayback();
            if (aa.Qn()) {
                if (this.dRk || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.cUA.bcK();
                    e(true, 2);
                    if (StringUtils.isNull(this.aEN)) {
                        TiebaStatic.log(new am("c12619").aA("obj_locate", "frs").aA("tid", this.aFf.getId()));
                        this.aEN = this.aFf.zY().video_url;
                    }
                    this.cUD = true;
                    this.boO.setVideoPath(this.aEN, this.aFf.getId());
                    if (this.bOo != null) {
                        this.bOo.start();
                    }
                    apm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apm() {
        if (this.aFf != null && this.aFf.zY() != null) {
            String str = this.aFf.Az() ? "floor5" : "frs";
            if (this.aFf.zL()) {
                str = "frs_mcn";
            }
            if (this.dRl == 501) {
                str = "frs_tab";
            }
            z zVar = new z();
            zVar.mLocate = str;
            zVar.biw = this.aFf.getTid();
            zVar.cXO = this.aFf.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.aFf.mRecomSource;
            zVar.gEN = this.aFf.mRecomAbTag;
            zVar.gEO = this.aFf.mRecomWeight;
            zVar.gEP = "";
            zVar.gER = this.aFf.zY().video_md5;
            com.baidu.tieba.play.l.a(this.aFf.zY().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        RK();
        aoE();
        e(true, 1);
        if (this.boO != null) {
            this.boO.stopPlayback();
            if (this.bOo != null) {
                this.bOo.stop();
            }
        }
        this.cUD = false;
    }

    public ThreadCommentAndPraiseInfoLayout aco() {
        return this.caJ;
    }

    public ThreadCommentAndPraiseInfoLayout acp() {
        return this.cbw.aKi;
    }

    public View getVideoContainer() {
        return this.boK;
    }

    public String getPlayUrl() {
        return this.aEN;
    }

    public int getCurrentPosition() {
        if (this.boO == null) {
            return 0;
        }
        return this.boO.getCurrentPosition();
    }

    public void setVideoStatsData(z zVar) {
        if (this.cXw != null) {
            this.cXw.setVideoStatsData(zVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caJ != null && this.caI != null) {
            this.caI.setPageUniqueId(bdUniqueId);
        }
    }

    public void iL(int i) {
        if (this.aFf != null) {
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setData(this.aFf);
                this.caK.setVisibility(8);
                return;
            }
            this.caJ.setData(this.aFf);
            this.caK.setVisibility(8);
            this.cbw.setVisibility(8);
        }
    }

    public void al(String str, String str2) {
        this.mUrl = str;
        this.auJ = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.boM.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.boM.setOnDrawListener(null);
        }
    }
}
