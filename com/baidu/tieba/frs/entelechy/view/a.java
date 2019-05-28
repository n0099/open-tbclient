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
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
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
    private QuickVideoView Rp;
    private bg VK;
    private String Wt;
    private final View.OnClickListener XA;
    private Animation afl;
    private String bKa;
    private String bUZ;
    private final View.OnClickListener bZt;
    private Runnable cIA;
    private QuickVideoView.b cIB;
    public FrameLayout cIm;
    private TextView cIn;
    private TbImageView cIo;
    private ImageView cIp;
    private TextView cIq;
    private View cIr;
    private x cIs;
    private View cIt;
    private TextView cIu;
    private int cIv;
    private TbImageView.a cIw;
    private g.b cIx;
    private ViewTreeObserver.OnGlobalLayoutListener cIy;
    private Runnable cIz;
    private g.a cRS;
    private g.f cRT;
    private g.e cRV;
    private View cSZ;
    protected ThreadSourceShareAndPraiseLayout dBT;
    private RelativeLayout dBd;
    public ThreadUserInfoLayout dBe;
    public ThreadCommentAndPraiseInfoLayout dBf;
    public View dBg;
    public LinearLayout dCe;
    public ThreadSkinView dCf;
    private g deC;
    private j dlN;
    private n eAl;
    private j.a exD;
    private Animation.AnimationListener exE;
    private ThreadGodReplyLayout exk;
    private HeadPendantClickableView exl;
    private k exn;
    private int exp;
    private boolean exq;
    private TextView exw;
    private Handler exx;
    private VideoLoadingProgressView.a exy;
    private LinearLayout eyV;
    private TbImageView ezz;
    public TextView fyE;
    public LinearLayout fyF;
    private com.baidu.tieba.frs.vc.g fyG;
    public boolean fyH;
    public int fyI;
    private View.OnClickListener fyJ;
    private TbPageContext<?> mContext;
    protected String mForumName;
    private View mMaskView;
    private int mSkinType;
    private TextView mTextTitle;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.deC != null && this.exq) {
            try {
                this.Rp.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.exx.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.exp = 0;
        this.cIv = 1;
        this.exq = false;
        this.exx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.aXC();
                        return;
                    case 203:
                        a.this.aXD();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cRT = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                a.this.deC = gVar;
                if (a.this.deC != null) {
                    a.this.deC.setVolume(0.0f, 0.0f);
                }
                a.this.exn.bMm();
                a.this.aXx();
            }
        };
        this.cRV = new g.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                if (i == 3) {
                    a.this.i(false, 3);
                }
                return false;
            }
        };
        this.cRS = new g.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                a.this.Rp.start();
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                a.this.aXE();
                a.this.i(true, 4);
                a.this.exq = false;
                return true;
            }
        };
        this.exy = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.aXx();
            }
        };
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && a.this.cIo != null) {
                    a.this.cIo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cIy = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cIm != null && a.this.cIm.getLayoutParams() != null && a.this.cIm.getVisibility() != 8) {
                    a.this.cIm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cIm.getLayoutParams();
                    if (a.this.cIm.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cIm.getWidth() * 0.5625d);
                        a.this.cIm.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.Rp != null && !a.this.Rp.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cIA = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.aXE();
                a.this.i(true, 4);
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.fyJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.VK != null && !StringUtils.isNull(a.this.VK.adA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.mContext.getPageActivity()).createNormalCfg(a.this.VK.adA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bZt != null) {
                        a.this.bZt.onClick(view);
                    }
                }
            }
        };
        this.XA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.VK);
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.VK != null && a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.VK);
                }
            }
        };
        this.exD = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.j.a
            public void pz() {
                a.this.aXy();
            }
        };
        this.exE = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cIv == 3 && a.this.cIo != null) {
                    a.this.cIo.setVisibility(8);
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
        this.cSZ = view.findViewById(R.id.divider_line);
        this.dBd = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.ezz = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.fyF = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dBd.setOnClickListener(this);
        this.exl = (HeadPendantClickableView) this.dBd.findViewById(R.id.card_home_page_video_user_pendant_header);
        if (this.exl.getHeadView() != null) {
            this.exl.getHeadView().setIsRound(true);
            this.exl.getHeadView().setDrawBorder(false);
            this.exl.getHeadView().setDefaultResource(17170445);
            this.exl.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exl.getHeadView().setRadius(l.g(this.mContext.getPageActivity(), R.dimen.ds70));
        }
        this.exl.setHasPendantStyle();
        if (this.exl.getPendantView() != null) {
            this.exl.getPendantView().setIsRound(true);
            this.exl.getPendantView().setDrawBorder(false);
        }
        this.fyE = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fyE.setVisibility(8);
        this.fyE.setOnClickListener(this.fyJ);
        this.cIs = new x((ViewGroup) view.findViewById(R.id.auto_video_loading_container));
        this.cIs.setLoadingAnimationListener(this.exy);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        this.dBf.setForumAfterClickListener(this.bZt);
        this.dBe = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.dBe.setFrom(3);
        this.dBg = view.findViewById(R.id.divider_below_reply_number_layout);
        if (this.dBf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBf.setLayoutParams(layoutParams);
        }
        this.dBf.setOnClickListener(this);
        this.dBf.setReplyTimeVisible(false);
        this.dBf.setShowPraiseNum(true);
        this.dBf.setNeedAddPraiseIcon(true);
        this.dBf.setNeedAddReplyIcon(true);
        this.dBf.setIsBarViewVisible(false);
        this.dBf.setShareVisible(true);
        this.dBf.setShareReportFrom(1);
        this.dBf.setStType("frs_page");
        this.dBf.setFrom(2);
        this.dBf.setDisPraiseFrom(2);
        this.dBf.caC = 3;
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_threaad);
        this.dBT.cbw.setOnClickListener(this);
        this.dBT.setFrom(2);
        this.dBT.setShareReportFrom(1);
        this.dBT.setSourceFromForPb(3);
        this.dBT.setStType("frs_page");
        this.dBT.setHideBarName(true);
        this.cIm = (FrameLayout) view.findViewById(R.id.frame_video);
        this.cIm.setOnClickListener(this);
        this.cIm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.20
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cIm != null) {
                    a.this.cIm.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cIy);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cIm != null) {
                    a.this.cIm.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cIy);
                }
            }
        });
        this.cIo = (TbImageView) view.findViewById(R.id.image_video);
        this.cIo.setPageId(getTag());
        this.cIo.setDefaultErrorResource(0);
        this.cIo.setDrawCorner(true);
        this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.cIo.setEvent(this.cIw);
        this.cIo.setGifIconSupport(false);
        this.cIp = (ImageView) view.findViewById(R.id.image_video_play);
        this.Rp = (QuickVideoView) view.findViewById(R.id.texture_video_view);
        this.eAl = new n(this.mContext.getPageActivity());
        this.Rp.setPlayerReuseEnable(true);
        this.Rp.setContinuePlayEnable(true);
        this.Rp.setBusiness(this.eAl);
        this.Rp.setOnPreparedListener(this.cRT);
        this.Rp.setOnCompletionListener(this.cRS);
        this.Rp.setOnErrorListener(this.cIx);
        this.Rp.setOnOutInfoListener(this.cRV);
        this.Rp.setOnSurfaceDestroyedListener(this.cIB);
        this.dlN = new j();
        this.dlN.setPlayer(this.Rp);
        this.dlN.a(this.exD);
        this.cIt = view.findViewById(R.id.auto_video_black_mask);
        this.cIq = (TextView) view.findViewById(R.id.auto_video_error_tips);
        this.cIr = view.findViewById(R.id.auto_video_error_background);
        this.dCe = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.dCf = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.afl = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.fade_out_video_cover);
        this.afl.setAnimationListener(this.exE);
        this.cIn = (TextView) view.findViewById(R.id.text_video_duration);
        this.cIu = (TextView) view.findViewById(R.id.text_video_play_count);
        this.eyV = (LinearLayout) view.findViewById(R.id.duration_container);
        this.fyG = new com.baidu.tieba.frs.vc.g(tbPageContext, this.dBd);
        this.fyG.setUniqueId(getTag());
        this.exk = (ThreadGodReplyLayout) view.findViewById(R.id.card_god_reply_layout);
        this.exk.setOnClickListener(this);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dBf != null) {
                    a.this.dBf.changeSelectStatus();
                }
            }
        });
        this.dBf.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.22
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eq(boolean z) {
                if (a.this.mMaskView != null) {
                    al.l(a.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
                }
            }
        });
        this.exw = (TextView) view.findViewById(R.id.nani_video_icon);
        this.exn = new k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dBd || view == this.dBf.getCommentNumView() || view == this.fyF) {
            bG(this.dBd);
        } else if (view == this.cIm) {
            if (this.VK != null && this.VK.adM() != null) {
                z = this.VK.adM().is_vertical.intValue() == 1;
            }
            if (z) {
                bE(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bQ(this.cIm);
            } else {
                bG(this.cIm);
            }
        } else if (view == this.exk) {
            bG(this.exk);
        }
        if (this.VK != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.VK));
        }
    }

    private void bE(View view) {
        if (aXr() != null) {
            aXr().a(view, this.VK);
        }
        if (!com.baidu.adp.lib.util.j.jS()) {
            l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXz();
        }
    }

    private void aXz() {
        if (this.VK != null) {
            String str = "frs";
            if (this.fyI == 501) {
                str = "frs_tab";
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.VK);
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str)));
        }
    }

    private void bQ(View view) {
        if (this.VK != null) {
            am amVar = new am("c11100");
            amVar.bT("tid", this.VK.getId());
            amVar.bT("fid", this.VK.getFid() + "");
            TiebaStatic.log(amVar);
        }
        if (aXr() != null) {
            aXr().a(view, this.VK);
        }
        if (view == this.cIm) {
            if (!com.baidu.adp.lib.util.j.jS()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.no_network_guide);
            } else {
                aXA();
            }
        }
    }

    private void aXA() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.VK);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.dCe.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.dCe.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        String str = "frs";
        if (this.fyI == 501) {
            str = "frs_tab";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mContext.getPageActivity(), str, this.VK.getTid(), com.baidu.tieba.card.n.adi(), "", videoSerializeVideoThreadInfo)));
    }

    private void bG(View view) {
        String str;
        String str2;
        if (this.VK != null) {
            if (this.VK.aew()) {
                TiebaStatic.log(new am("c10242").bT("fid", String.valueOf(this.VK.getFid())).P("obj_type", 2));
            } else {
                am amVar = new am("c11100");
                amVar.bT("tid", this.VK.getId());
                amVar.bT("fid", this.VK.getFid() + "");
                TiebaStatic.log(amVar);
            }
            if (this.VK.adv() != null && this.VK.adv().getGodUserData() != null && this.VK.adv().getGodUserData().getType() == 2) {
                TiebaStatic.log(new am("c10806").P("obj_locate", 3).bT("tid", this.VK.getId()));
            }
        }
        if (aXr() != null) {
            aXr().a(view, this.VK);
        }
        if (this.VK != null) {
            com.baidu.tieba.card.n.uS(this.VK.getId());
            al.f(this.mTextTitle, R.color.cp_cont_d, 1);
            y.qV(this.VK.getId());
            String valueOf = String.valueOf(this.VK.getFid());
            if (this.VK.bKZ == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = this.VK.bKZ.id;
                str2 = valueOf;
            }
            if (this.VK.adR() > 0 && com.baidu.tieba.tbadkCore.util.e.cnv()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mContext.getPageActivity()).createHistoryCfg(this.VK.getTid(), String.valueOf(this.VK.adR()), false, true, "frs_page");
                String str3 = "frs";
                if (this.fyI == 501) {
                    str3 = "frs_tab";
                } else if (this.VK.aew()) {
                    str3 = "floor5";
                }
                createHistoryCfg.setVideo_source(str3);
                createHistoryCfg.setFromSmartFrs(this.VK.aeE());
                createHistoryCfg.setSmartFrsPosition(this.VK.aeL());
                createHistoryCfg.setForumId(str);
                createHistoryCfg.setFromForumId(str2);
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.exk) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.mContext.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.VK, this.mForumName, "frs_page", 18003, true, false, false);
            String str4 = "frs";
            if (this.fyI == 501) {
                str4 = "frs_tab";
            } else if (this.VK.aew()) {
                str4 = "floor5";
            }
            createFromThreadCfg.setVideo_source(str4);
            createFromThreadCfg.setFromSmartFrs(this.VK.aeE());
            createFromThreadCfg.setSmartFrsPosition(this.VK.aeL());
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.exk) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.mContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        this.VK = bgVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXC() {
        this.exx.removeMessages(202);
        if (this.Rp.getCurrentPosition() > 0) {
            i(false, 3);
            this.exx.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.exx.sendEmptyMessageDelayed(202, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXD() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.exx.removeMessages(203);
        int currentPosition = this.Rp.getCurrentPosition();
        if (currentPosition != this.exp) {
            this.exp = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.exx.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cIp != null && this.cIo != null && this.cIt != null && this.cIs != null && this.cIr != null && this.cIq != null) {
            if (z || this.cIv != i) {
                this.cIv = i;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIz);
                if (i == 2) {
                    this.cIp.setVisibility(8);
                    this.afl.cancel();
                    this.cIo.clearAnimation();
                    this.cIo.setVisibility(0);
                    this.cIt.setVisibility(0);
                    this.eyV.setVisibility(0);
                    this.cIs.startLoading();
                    this.cIr.setVisibility(8);
                    this.cIq.setVisibility(8);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.cIA, 60000L);
                } else if (i == 3) {
                    this.cIp.setVisibility(8);
                    this.cIo.startAnimation(this.afl);
                    this.cIt.setVisibility(8);
                    this.eyV.setVisibility(8);
                    this.cIs.cbQ();
                    this.cIr.setVisibility(8);
                    this.cIq.setVisibility(8);
                    if (this.VK != null && this.VK.adM() != null) {
                        this.exn.a(this.VK.getTid(), this.VK.adM().video_length.intValue(), this.VK.adM().video_duration.intValue(), "frs", this.Rp);
                    }
                } else if (i == 4) {
                    this.cIp.setVisibility(8);
                    this.cIo.startAnimation(this.afl);
                    this.cIt.setVisibility(8);
                    this.cIs.cbR();
                    this.cIr.setVisibility(0);
                    this.cIq.setVisibility(0);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.cIz, 2000L);
                } else {
                    this.cIp.setVisibility(0);
                    this.eyV.setVisibility(0);
                    this.afl.cancel();
                    this.cIo.clearAnimation();
                    this.cIo.setVisibility(0);
                    this.cIt.setVisibility(0);
                    this.cIs.cbR();
                    this.cIr.setVisibility(8);
                    this.cIq.setVisibility(8);
                }
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.ezz != null) {
            if (bgVar == null) {
                this.ezz.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bKQ)) {
                if (this.fyG != null && this.fyG.bqF() && (this.ezz.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ezz.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mContext.getContext(), R.dimen.tbds106);
                    this.ezz.setLayoutParams(layoutParams);
                }
                this.ezz.setVisibility(0);
                this.ezz.setImageDrawable(null);
                this.ezz.startLoad(bgVar.bKQ, 10, false);
                this.ezz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.mContext != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bgVar.bKR, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ezz.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        boolean z;
        if (this.VK == null || this.VK.adv() == null) {
            this.dBd.setVisibility(8);
            return;
        }
        this.dBd.setVisibility(0);
        this.dBd.setOnClickListener(this);
        aXF();
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bKa)) {
            this.VK.bC(this.mUrl, this.bKa);
        }
        this.VK.k(false, true);
        SpannableStringBuilder aeb = this.VK.aeb();
        if (this.VK.aei() && !StringUtils.isNull(this.VK.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.VK.getTid();
            aeb.append((CharSequence) this.VK.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(aeb));
        this.mTextTitle.setText(aeb);
        this.fyG.am(this.VK);
        R(this.VK);
        this.dBe.setData(this.VK);
        if (this.dBe.getHeaderImg() != null) {
            if (this.dBe.getIsSimpleThread()) {
                this.dBe.getHeaderImg().setVisibility(8);
                this.exl.setVisibility(8);
            } else if (this.VK.adv() == null || this.VK.adv().getPendantData() == null || StringUtils.isNull(this.VK.adv().getPendantData().abS())) {
                this.exl.setVisibility(8);
                this.dBe.getHeaderImg().setVisibility(0);
                this.dBe.getHeaderImg().setData(this.VK);
            } else {
                this.dBe.getHeaderImg().setVisibility(4);
                this.exl.setVisibility(0);
                this.exl.setData(this.VK);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBf.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.dBf.setLayoutParams(layoutParams);
        this.dBe.setUserAfterClickListener(this.XA);
        nv(mh(1));
        this.cIn.setText(ap.im(this.VK.adM().video_duration.intValue() * 1000));
        this.cIu.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.VK.adM().play_count.intValue())));
        this.exk.setData(this.VK.aeT());
        this.exk.onChangeSkinType();
        if (com.baidu.tieba.card.n.uT(this.VK.getId())) {
            al.f(this.mTextTitle, R.color.cp_cont_d, 1);
            com.baidu.tieba.card.n.a(this.exk.getGodReplyContent(), this.VK.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        } else {
            al.f(this.mTextTitle, R.color.cp_cont_b, 1);
        }
        if (this.VK == null || this.VK.adM() == null) {
            z = false;
        } else {
            z = this.VK.adM().is_vertical.intValue() == 1;
        }
        if (z) {
            this.exw.setVisibility(0);
        } else {
            this.exw.setVisibility(8);
        }
        if (this.dBf.isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.mMaskView.setVisibility(0);
            if (this.VK.afe() || this.VK.aff()) {
                al.l(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXE() {
        this.exx.removeMessages(202);
        this.exx.removeMessages(203);
    }

    private void axg() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIz);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
    }

    private void aXF() {
        axg();
        aXE();
        if (this.cIo != null && this.cIm != null && this.Rp != null) {
            if (i.abb().abf() && this.VK != null && this.VK.adM() != null) {
                this.cIm.setVisibility(0);
                this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
                this.cIo.startLoad(this.VK.adM().thumbnail_url, 10, false);
                stopPlay();
                this.bUZ = this.VK.adM().video_url;
                if (StringUtils.isNull(this.bUZ)) {
                    i(true, 4);
                    TiebaStatic.log(new am("c12026").bT("tid", this.VK.getId()));
                }
                if (this.eAl != null && this.eAl.cbz() != null) {
                    this.eAl.cbz().g(this.VK.adM());
                }
                this.Rp.dR(this.bUZ, this.VK.tid);
                return;
            }
            this.cIm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.dBd, R.drawable.addresslist_item_bg);
            al.c(this.cIp, (int) R.drawable.btn_icon_play_video_n);
            al.j(this.cIq, R.color.cp_btn_a);
            al.j(this.cIn, R.color.cp_btn_a);
            al.j(this.cIu, R.color.cp_btn_a);
            al.l(this.cIr, R.color.common_color_10014);
            al.l(this.cSZ, R.color.cp_bg_line_e);
            if (this.cIq != null) {
                this.cIq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.dBT != null && this.dBT.getVisibility() == 0) {
                this.dBT.onChangeSkinType();
            }
            this.dBf.onChangeSkinType();
            this.mSkinType = i;
            this.dBe.onChangeSkinType();
            if (this.exl != null && this.exl.getHeadView() != null && (this.exl.getHeadView() instanceof TbImageView)) {
                this.exl.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            }
            this.cIo.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.fyG.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.currentPageType = i;
        if (this.dBf != null) {
            this.dBf.caC = i;
            if (i == 15) {
                this.dBf.setFrom(10);
            } else {
                this.dBf.setFrom(2);
                this.dBf.setDisPraiseFrom(2);
            }
        }
        if (this.dBe != null) {
            if (i == 15) {
                this.dBe.setFrom(5);
            } else {
                this.dBe.setFrom(3);
            }
        }
    }

    public boolean isPlayStarted() {
        return this.exq;
    }

    public boolean isPlaying() {
        if (this.Rp == null) {
            return false;
        }
        return this.Rp.isPlaying();
    }

    public void startPlay() {
        if (!this.exq && this.VK != null && this.VK.adM() != null && this.Rp != null) {
            this.Rp.stopPlayback();
            if (ad.avy()) {
                if (this.fyH || com.baidu.tbadk.core.sharedPref.b.agM().getInt("auto_play_video_frs", 0) == 1) {
                    this.exn.bMl();
                    i(true, 2);
                    if (StringUtils.isNull(this.bUZ)) {
                        TiebaStatic.log(new am("c12619").bT("obj_locate", "frs").bT("tid", this.VK.getId()));
                        this.bUZ = this.VK.adM().video_url;
                    }
                    this.exq = true;
                    this.Rp.setVideoPath(this.bUZ, this.VK.getId());
                    if (this.dlN != null) {
                        this.dlN.start();
                    }
                    aXy();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.VK != null && this.VK.adM() != null) {
            String str = this.VK.aew() ? "floor5" : "frs";
            if (this.VK.adz()) {
                str = "frs_mcn";
            }
            if (this.fyI == 501) {
                str = "frs_tab";
            }
            com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = str;
            zVar.bVL = this.VK.getTid();
            zVar.eAC = this.VK.getFid() + "";
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mSource = this.VK.mRecomSource;
            zVar.irh = this.VK.mRecomAbTag;
            zVar.iri = this.VK.mRecomWeight;
            zVar.irj = "";
            zVar.irl = this.VK.adM().video_md5;
            com.baidu.tieba.play.l.a(this.VK.adM().video_md5, "", "1", zVar);
        }
    }

    public void stopPlay() {
        axg();
        aXE();
        i(true, 1);
        if (this.Rp != null) {
            this.Rp.stopPlayback();
            if (this.dlN != null) {
                this.dlN.stop();
            }
        }
        this.exq = false;
    }

    public View getVideoContainer() {
        return this.cIm;
    }

    public String getPlayUrl() {
        return this.bUZ;
    }

    public int getCurrentPosition() {
        if (this.Rp == null) {
            return 0;
        }
        return this.Rp.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.z zVar) {
        if (this.eAl != null) {
            this.eAl.setVideoStatsData(zVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dBf != null && this.dBe != null) {
            this.dBe.setPageUniqueId(bdUniqueId);
        }
    }

    public void nv(int i) {
        if (this.VK != null) {
            if (i == 1) {
                this.dBf.setVisibility(8);
                this.dBT.setData(this.VK);
                this.dBg.setVisibility(8);
                return;
            }
            this.dBf.setData(this.VK);
            this.dBg.setVisibility(8);
            this.dBT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Wt, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(final com.baidu.adp.widget.a.b bVar) {
        if (bVar != null) {
            this.cIo.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void a(TbImageView tbImageView, Canvas canvas) {
                    bVar.j(1, tbImageView.getWidth(), tbImageView.getHeight());
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void b(TbImageView tbImageView, Canvas canvas) {
                }
            });
        } else {
            this.cIo.setOnDrawListener(null);
        }
    }
}
