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
import com.baidu.tieba.play.w;
import com.baidu.tieba.play.x;
import com.baidu.tieba.play.y;
import com.baidu.tieba.video.VideoItemData;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private View aAH;
    private final View.OnClickListener aBE;
    private String alB;
    private String avN;
    private bb awf;
    private final View.OnClickListener azz;
    private Animation bAV;
    private com.baidu.tieba.play.j bBh;
    private RelativeLayout bNB;
    public ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    public View bNE;
    private String bNq;
    public LinearLayout bOC;
    public ThreadSkinView bOD;
    private HeadPendantClickableView bOo;
    protected ThreadSourceShareAndPraiseLayout bOr;
    private Runnable bgA;
    private Runnable bgB;
    private QuickVideoView.b bgC;
    public FrameLayout bgl;
    private TextView bgm;
    private TbImageView bgn;
    private ImageView bgo;
    private QuickVideoView bgp;
    private TextView bgq;
    private View bgr;
    private w bgt;
    private View bgu;
    private TextView bgv;
    private int bgw;
    private TbImageView.a bgx;
    private g.b bgy;
    private ViewTreeObserver.OnGlobalLayoutListener bgz;
    private g.e bpA;
    private g.a bpx;
    private g.f bpy;
    private View bqy;
    private ThreadGodReplyLayout cCi;
    private TextView cEB;
    private Handler cEC;
    private VideoLoadingProgressView.a cED;
    private j.a cEH;
    private Animation.AnimationListener cEI;
    private View.OnClickListener cEp;
    private com.baidu.tieba.play.g cEr;
    private k cEt;
    private int cEv;
    private boolean cEw;
    private LinearLayout cFY;
    private TbImageView cGB;
    private n cHp;
    public TextView dBA;
    public LinearLayout dBB;
    private com.baidu.tieba.frs.vc.g dBC;
    public boolean dBD;
    public int dBE;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aku() {
        if (this.cEr != null && this.cEw) {
            try {
                this.bgp.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cEC.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cEv = 0;
        this.bgw = 1;
        this.cEw = false;
        this.cEC = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aky();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.akz();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bpy = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cEr = gVar;
                if (a.this.cEr != null) {
                    a.this.cEr.setVolume(0.0f, 0.0f);
                }
                a.this.cEt.aYj();
                a.this.aku();
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(com.baidu.tieba.play.g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.e(false, 3);
                }
                return false;
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(com.baidu.tieba.play.g gVar) {
                x.bnz().remove(a.this.avN);
                a.this.bgp.start();
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.ajN();
                a.this.e(true, 4);
                a.this.cEw = false;
                return true;
            }
        };
        this.cED = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aku();
            }
        };
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && a.this.bgn != null) {
                    a.this.bgn.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bgz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bgl != null && a.this.bgl.getLayoutParams() != null && a.this.bgl.getVisibility() != 8) {
                    a.this.bgl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bgl.getLayoutParams();
                    if (a.this.bgl.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bgl.getWidth() * 0.5625d);
                        a.this.bgl.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bgA = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bgp != null && !a.this.bgp.isPlaying()) {
                    a.this.e(true, 1);
                }
            }
        };
        this.bgB = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.ajN();
                a.this.e(true, 4);
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cEp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.awf != null && !StringUtils.isNull(a.this.awf.ws())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.awf.ws(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.azz != null) {
                        a.this.azz.onClick(view);
                    }
                }
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.awf);
                }
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.awf != null && a.this.akm() != null) {
                    a.this.akm().a(view, a.this.awf);
                }
            }
        };
        this.cEH = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void akC() {
                a.this.akv();
            }
        };
        this.cEI = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bgw == 3 && a.this.bgn != null) {
                    a.this.bgn.setVisibility(8);
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
        this.bqy = view.findViewById(e.g.divider_line);
        this.bNB = (RelativeLayout) view.findViewById(e.g.layout_root);
        this.cGB = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.dBB = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bNB.setOnClickListener(this);
        this.bOo = (HeadPendantClickableView) this.bNB.findViewById(e.g.card_home_page_video_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(l.h(this.mContext.getPageActivity(), e.C0141e.ds70));
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.dBA = (TextView) view.findViewById(e.g.thread_info_bar_name);
        this.dBA.setVisibility(8);
        this.dBA.setOnClickListener(this.cEp);
        this.bgt = new w((ViewGroup) view.findViewById(e.g.auto_video_loading_container));
        this.bgt.setLoadingAnimationListener(this.cED);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.text_bottom);
        this.bND.setForumAfterClickListener(this.azz);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_auto_video_user_info_layout);
        this.bNC.setFrom(3);
        this.bNE = view.findViewById(e.g.divider_below_reply_number_layout);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setIsBarViewVisible(false);
        this.bND.setShareVisible(true);
        this.bND.setShareReportFrom(1);
        this.bND.setStType("frs_page");
        this.bND.setFrom(2);
        this.bND.setDisPraiseFrom(2);
        this.bND.amD = 3;
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.text_bottom_threaad);
        this.bOr.aBl.setOnClickListener(this);
        this.bOr.setFrom(2);
        this.bOr.setShareReportFrom(1);
        this.bOr.setSourceFromForPb(3);
        this.bOr.setStType("frs_page");
        this.bOr.setHideBarName(true);
        this.bgl = (FrameLayout) view.findViewById(e.g.frame_video);
        this.bgl.setOnClickListener(this);
        this.bgl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bgl != null) {
                    a.this.bgl.getViewTreeObserver().addOnGlobalLayoutListener(a.this.bgz);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bgl != null) {
                    a.this.bgl.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.bgz);
                }
            }
        });
        this.bgn = (TbImageView) view.findViewById(e.g.image_video);
        this.bgn.setPageId(getTag());
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bgn.setEvent(this.bgx);
        this.bgn.setGifIconSupport(false);
        this.bgo = (ImageView) view.findViewById(e.g.image_video_play);
        this.bgp = (QuickVideoView) view.findViewById(e.g.texture_video_view);
        this.cHp = new n(this.mContext.getPageActivity());
        this.bgp.setPlayerReuseEnable(true);
        this.bgp.setContinuePlayEnable(true);
        this.bgp.setBusiness(this.cHp);
        this.bgp.setOnPreparedListener(this.bpy);
        this.bgp.setOnCompletionListener(this.bpx);
        this.bgp.setOnErrorListener(this.bgy);
        this.bgp.setOnOutInfoListener(this.bpA);
        this.bgp.setOnSurfaceDestroyedListener(this.bgC);
        this.bBh = new com.baidu.tieba.play.j();
        this.bBh.setPlayer(this.bgp);
        this.bBh.a(this.cEH);
        this.bgu = view.findViewById(e.g.auto_video_black_mask);
        this.bgq = (TextView) view.findViewById(e.g.auto_video_error_tips);
        this.bgr = view.findViewById(e.g.auto_video_error_background);
        this.bOC = (LinearLayout) view.findViewById(e.g.video_card_content_layout);
        this.bOD = (ThreadSkinView) view.findViewById(e.g.frs_thread_skin);
        this.bAV = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.fade_out_video_cover);
        this.bAV.setAnimationListener(this.cEI);
        this.bgm = (TextView) view.findViewById(e.g.text_video_duration);
        this.bgv = (TextView) view.findViewById(e.g.text_video_play_count);
        this.cFY = (LinearLayout) view.findViewById(e.g.duration_container);
        this.dBC = new com.baidu.tieba.frs.vc.g(tbPageContext, this.bNB);
        this.dBC.setUniqueId(getTag());
        this.cCi = (ThreadGodReplyLayout) view.findViewById(e.g.card_god_reply_layout);
        this.cCi.setOnClickListener(this);
        this.aAH = view.findViewById(e.g.thread_multi_del_mask_view);
        this.aAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bND != null) {
                    a.this.bND.changeSelectStatus();
                }
            }
        });
        this.bND.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bh(boolean z) {
                if (a.this.aAH != null) {
                    al.j(a.this.aAH, z ? e.d.cp_bg_line_d : e.d.transparent);
                }
            }
        });
        this.cEB = (TextView) view.findViewById(e.g.nani_video_icon);
        this.cEt = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.bNB || view == this.bND.getCommentNumView() || view == this.dBB) {
            aA(this.bNB);
        } else if (view == this.bgl) {
            if (this.awf != null && this.awf.wE() != null) {
                z = this.awf.wE().is_vertical.intValue() == 1;
            }
            if (z) {
                ay(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aL(this.bgl);
            } else {
                aA(this.bgl);
            }
        } else if (view == this.cCi) {
            aA(this.cCi);
        }
        if (this.awf != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.awf));
        }
    }

    private void ay(View view) {
        if (akm() != null) {
            akm().a(view, this.awf);
        }
        if (!com.baidu.adp.lib.util.j.kK()) {
            l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
        } else {
            akw();
        }
    }

    private void akw() {
        if (this.awf != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.awf);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs")));
        }
    }

    private void aL(View view) {
        if (this.awf != null) {
            am amVar = new am("c11100");
            amVar.al("tid", this.awf.getId());
            amVar.al(ImageViewerConfig.FORUM_ID, this.awf.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (akm() != null) {
            akm().a(view, this.awf);
        }
        if (view == this.bgl) {
            if (!com.baidu.adp.lib.util.j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.no_network_guide);
            } else {
                akx();
            }
        }
    }

    private void akx() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.awf);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.bOC.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.bOC.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), "frs", this.awf.getTid(), o.wa(), "", videoSerializeVideoThreadInfo)));
    }

    private void aA(View view) {
        String str;
        String str2;
        if (this.awf != null) {
            if (this.awf.xf()) {
                TiebaStatic.log(new am("c10242").al(ImageViewerConfig.FORUM_ID, String.valueOf(this.awf.getFid())).w("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.al("tid", this.awf.getId());
                amVar.al(ImageViewerConfig.FORUM_ID, this.awf.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.awf.wm() != null && this.awf.wm().getGodUserData() != null && this.awf.wm().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").w("obj_locate", 3).al("tid", this.awf.getId()));
            }
        }
        if (akm() != null) {
            akm().a(view, this.awf);
        }
        if (this.awf != null) {
            o.lA(this.awf.getId());
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            v.ie(this.awf.getId());
            String valueOf = String.valueOf(this.awf.getFid());
            if (this.awf.amu == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.awf.amu.id;
                str2 = valueOf;
            }
            if (this.awf.wJ() > 0 && com.baidu.tieba.tbadkCore.util.e.bzM()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.awf.getTid(), String.valueOf(this.awf.wJ()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.awf.xf() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.awf.xo());
                createHistoryCfg.setSmartFrsPosition(this.awf.xv());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cCi) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.awf, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.awf.xf() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.awf.xo());
            createFromThreadCfg.setSmartFrsPosition(this.awf.xv());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cCi) {
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
        this.awf = bbVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        this.cEC.removeMessages(202);
        if (this.bgp.getCurrentPosition() > 0) {
            e(false, 3);
            this.cEC.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cEC.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akz() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cEC.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.bgp.getCurrentPosition();
        if (currentPosition != this.cEv) {
            this.cEv = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.cEC.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bgo != null && this.bgn != null && this.bgu != null && this.bgt != null && this.bgr != null && this.bgq != null) {
            if (z || this.bgw != i) {
                this.bgw = i;
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgB);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgA);
                if (i == 2) {
                    this.bgo.setVisibility(8);
                    this.bAV.cancel();
                    this.bgn.clearAnimation();
                    this.bgn.setVisibility(0);
                    this.bgu.setVisibility(0);
                    this.cFY.setVisibility(0);
                    this.bgt.startLoading();
                    this.bgr.setVisibility(8);
                    this.bgq.setVisibility(8);
                    com.baidu.adp.lib.g.e.jt().postDelayed(this.bgB, 60000L);
                } else if (i == 3) {
                    this.bgo.setVisibility(8);
                    this.bgn.startAnimation(this.bAV);
                    this.bgu.setVisibility(8);
                    this.cFY.setVisibility(8);
                    this.bgt.bnu();
                    this.bgr.setVisibility(8);
                    this.bgq.setVisibility(8);
                    if (this.awf != null && this.awf.wE() != null) {
                        this.cEt.a(this.awf.getTid(), this.awf.wE().video_length.intValue(), this.awf.wE().video_duration.intValue(), "frs");
                    }
                } else if (i == 4) {
                    this.bgo.setVisibility(8);
                    this.bgn.startAnimation(this.bAV);
                    this.bgu.setVisibility(8);
                    this.bgt.bnv();
                    this.bgr.setVisibility(0);
                    this.bgq.setVisibility(0);
                    com.baidu.adp.lib.g.e.jt().postDelayed(this.bgA, 2000L);
                } else {
                    this.bgo.setVisibility(0);
                    this.cFY.setVisibility(0);
                    this.bAV.cancel();
                    this.bgn.clearAnimation();
                    this.bgn.setVisibility(0);
                    this.bgu.setVisibility(0);
                    this.bgt.bnv();
                    this.bgr.setVisibility(8);
                    this.bgq.setVisibility(8);
                }
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cGB != null) {
            if (bbVar == null) {
                this.cGB.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.amm)) {
                if (this.dBC != null && this.dBC.aCS() && (this.cGB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGB.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mContext.getContext(), e.C0141e.tbds106);
                    this.cGB.setLayoutParams(layoutParams);
                }
                this.cGB.setVisibility(0);
                this.cGB.setImageDrawable(null);
                this.cGB.startLoad(bbVar.amm, 10, false);
                this.cGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bbVar.amn, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cGB.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.awf == null || this.awf.wm() == null) {
            this.bNB.setVisibility(8);
            return;
        }
        this.bNB.setVisibility(0);
        this.bNB.setOnClickListener(this);
        akA();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.alB)) {
            this.awf.V(this.mUrl, this.alB);
        }
        this.awf.g(false, true);
        SpannableStringBuilder wM = this.awf.wM();
        if (this.awf.wT() && !StringUtils.isNull(this.awf.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.awf.getTid();
            wM.append((CharSequence) this.awf.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(wM));
        this.mTextTitle.setText(wM);
        this.dBC.af(this.awf);
        N(this.awf);
        this.bNC.setData(this.awf);
        if (this.bNC.getHeaderImg() != null) {
            if (this.bNC.getIsSimpleThread()) {
                this.bNC.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (this.awf.wm() == null || this.awf.wm().getPendantData() == null || StringUtils.isNull(this.awf.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.bNC.getHeaderImg().setVisibility(0);
                this.bNC.getHeaderImg().setData(this.awf);
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(this.awf);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bND.setLayoutParams(layoutParams);
        this.bNC.setUserAfterClickListener(this.aBE);
        hM(gT(1));
        this.bgm.setText(ao.dj(this.awf.wE().video_duration.intValue() * 1000));
        this.bgv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.L(this.awf.wE().play_count.intValue())));
        this.cCi.setData(this.awf.xD());
        this.cCi.onChangeSkinType();
        if (o.lB(this.awf.getId())) {
            al.c(this.mTextTitle, e.d.cp_cont_d, 1);
            o.a(this.cCi.getGodReplyContent(), this.awf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        } else {
            al.c(this.mTextTitle, e.d.cp_cont_b, 1);
        }
        if (this.awf == null || this.awf.wE() == null) {
            z = false;
        } else {
            z = this.awf.wE().is_vertical.intValue() == 1;
        }
        if (z) {
            this.cEB.setVisibility(0);
        } else {
            this.cEB.setVisibility(8);
        }
        if (this.bND.isInFrsAllThread() && com.baidu.tieba.frs.a.avq().avr()) {
            this.aAH.setVisibility(0);
            if (this.awf.xN() || this.awf.xO()) {
                al.j(this.aAH, e.d.cp_bg_line_d);
            } else {
                this.aAH.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.aAH.setVisibility(8);
        }
        d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajN() {
        this.cEC.removeMessages(202);
        this.cEC.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void Oz() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgA);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgB);
    }

    private void akA() {
        Oz();
        ajN();
        if (this.bgn != null && this.bgl != null && this.bgp != null) {
            if (com.baidu.tbadk.core.i.uj().un() && this.awf != null && this.awf.wE() != null) {
                this.bgl.setVisibility(0);
                this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bgn.startLoad(this.awf.wE().thumbnail_url, 10, false);
                stopPlay();
                this.avN = this.awf.wE().video_url;
                if (StringUtils.isNull(this.avN)) {
                    e(true, 4);
                    TiebaStatic.log(new am("c12026").al("tid", this.awf.getId()));
                }
                if (this.cHp != null && this.cHp.bnd() != null) {
                    this.cHp.bnd().g(this.awf.wE());
                }
                this.bgp.cd(this.avN, this.awf.tid);
                return;
            }
            this.bgl.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.bNB, e.f.addresslist_item_bg);
            al.c(this.bgo, e.f.btn_icon_play_video_n);
            al.h(this.bgq, e.d.cp_cont_i);
            al.h(this.bgm, e.d.cp_cont_i);
            al.h(this.bgv, e.d.cp_cont_i);
            al.j(this.bgr, e.d.common_color_10014);
            al.j(this.bqy, e.d.cp_bg_line_e);
            if (this.bgq != null) {
                this.bgq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bOr != null && this.bOr.getVisibility() == 0) {
                this.bOr.onChangeSkinType();
            }
            this.bND.onChangeSkinType();
            this.mSkinType = i;
            this.bNC.onChangeSkinType();
            this.dBC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.currentPageType = i;
        if (this.bND != null) {
            this.bND.amD = i;
            if (i == 15) {
                this.bND.setFrom(10);
            } else {
                this.bND.setFrom(2);
                this.bND.setDisPraiseFrom(2);
            }
        }
        if (this.bNC != null) {
            if (i == 15) {
                this.bNC.setFrom(5);
            } else {
                this.bNC.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.cEw;
    }

    public boolean isPlaying() {
        if (this.bgp == null) {
            return false;
        }
        return this.bgp.isPlaying();
    }

    public void startPlay() {
        if (!this.cEw && this.awf != null && this.awf.wE() != null && this.bgp != null) {
            this.bgp.stopPlayback();
            if (aa.Na()) {
                if (this.dBD || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1) {
                    this.cEt.aYi();
                    e(true, 2);
                    if (StringUtils.isNull(this.avN)) {
                        TiebaStatic.log(new am("c12619").al("obj_locate", "frs").al("tid", this.awf.getId()));
                        this.avN = this.awf.wE().video_url;
                    }
                    this.cEw = true;
                    this.bgp.setVideoPath(this.avN, this.awf.getId());
                    if (this.bBh != null) {
                        this.bBh.start();
                    }
                    akv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.awf != null && this.awf.wE() != null) {
            String str = this.awf.xf() ? "floor5" : "frs";
            if (this.awf.wr()) {
                str = "frs_mcn";
            }
            if (this.dBE == 501) {
                str = "frs_tab";
            }
            y yVar = new y();
            yVar.mLocate = str;
            yVar.aZG = this.awf.getTid();
            yVar.cHI = this.awf.getFid() + "";
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mSource = this.awf.mRecomSource;
            yVar.goU = this.awf.mRecomAbTag;
            yVar.goV = this.awf.mRecomWeight;
            yVar.goW = "";
            yVar.goY = this.awf.wE().video_md5;
            com.baidu.tieba.play.l.a(this.awf.wE().video_md5, "", "1", yVar);
        }
    }

    public void stopPlay() {
        Oz();
        ajN();
        e(true, 1);
        if (this.bgp != null) {
            this.bgp.stopPlayback();
            if (this.bBh != null) {
                this.bBh.stop();
            }
        }
        this.cEw = false;
    }

    public ThreadCommentAndPraiseInfoLayout Xq() {
        return this.bND;
    }

    public ThreadCommentAndPraiseInfoLayout Xr() {
        return this.bOr.aBl;
    }

    public View getVideoContainer() {
        return this.bgl;
    }

    public String getPlayUrl() {
        return this.avN;
    }

    public int getCurrentPosition() {
        if (this.bgp == null) {
            return 0;
        }
        return this.bgp.getCurrentPosition();
    }

    public void setVideoStatsData(y yVar) {
        if (this.cHp != null) {
            this.cHp.setVideoStatsData(yVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bND != null && this.bNC != null) {
            this.bNC.setPageUniqueId(bdUniqueId);
        }
    }

    public void hM(int i) {
        if (this.awf != null) {
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setData(this.awf);
                this.bNE.setVisibility(8);
                return;
            }
            this.bNE.setVisibility(this.bND.setData(this.awf) ? 0 : 8);
            this.bOr.setVisibility(8);
        }
    }

    public void V(String str, String str2) {
        this.mUrl = str;
        this.alB = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.bgn.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.k(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.bgn.setOnDrawListener(null);
        }
    }
}
