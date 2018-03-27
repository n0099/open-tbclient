package com.baidu.tieba.frs.entelechy.view;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.y;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bd> implements t {
    private TbPageContext<?> aRI;
    private bd aZC;
    private g.f bPt;
    private g.b bPu;
    private String bQL;
    private View bQq;
    private final View.OnClickListener bdG;
    private final View.OnClickListener bdT;
    private ThreadGodReplyLayout cVx;
    private Handler cWD;
    private VideoLoadingProgressView.a cWE;
    private TbImageView.a cWF;
    private Runnable cWG;
    private Runnable cWH;
    private j.a cWL;
    private Animation.AnimationListener cWM;
    private TbImageView cWg;
    private TextView cWh;
    private View.OnClickListener cWl;
    public FrameLayout cWn;
    private QuickVideoView cWo;
    private com.baidu.tieba.play.g cWp;
    private TextView cWq;
    private TextView cWs;
    private View cWt;
    private y cWu;
    private View cWw;
    private int cWx;
    private int cWy;
    private boolean cWz;
    private TbImageView cYP;
    private LinearLayout cYn;
    private com.baidu.tieba.play.n cZu;
    private ImageView caA;
    private Animation caE;
    private com.baidu.tieba.play.j caQ;
    private QuickVideoView.b caY;
    private RelativeLayout clY;
    public ThreadUserInfoLayout clZ;
    private HeadPendantClickableView cmL;
    protected ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    public View cmb;
    public LinearLayout cna;
    public ThreadSkinView cnb;
    public TextView dLA;
    public LinearLayout dLB;
    private com.baidu.tieba.frs.g.g dLC;
    private ViewTreeObserver.OnGlobalLayoutListener dLD;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.cWp != null) {
            try {
                this.cWo.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cWD.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWx = 0;
        this.cWy = 1;
        this.cWz = false;
        this.cWD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.ala();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.alb();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cWp = gVar;
                a.this.cWp.setVolume(0.0f, 0.0f);
                a.this.cWu.blP();
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.alc();
                a.this.i(true, 4);
                return true;
            }
        };
        this.cWE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.akX();
            }
        };
        this.cWF = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && a.this.cWg != null) {
                    a.this.cWg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dLD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cWn != null && a.this.cWn.getLayoutParams() != null && a.this.cWn.getVisibility() != 8) {
                    a.this.cWn.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cWn.getLayoutParams();
                    if (a.this.cWn.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cWn.getWidth() * 0.5625d);
                        a.this.cWn.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cWG = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cWo != null && !a.this.cWo.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cWH = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.alc();
                a.this.i(true, 4);
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cWl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZC != null && !StringUtils.isNull(a.this.aZC.zt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.aRI.getPageActivity()).createNormalCfg(a.this.aZC.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bdG != null) {
                        a.this.bdG.onClick(view);
                    }
                }
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akP() != null) {
                    a.this.akP().a(view, a.this.aZC);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZC != null && a.this.akP() != null) {
                    a.this.akP().a(view, a.this.aZC);
                }
            }
        };
        this.cWL = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.j.a
            public void alf() {
                a.this.akY();
            }
        };
        this.cWM = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cWy == 3 && a.this.cWg != null) {
                    a.this.cWg.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.aRI = tbPageContext;
        View view = getView();
        this.bQq = view.findViewById(d.g.divider_line);
        this.clY = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cYP = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.dLB = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.clY.setOnClickListener(this);
        this.cmL = (HeadPendantClickableView) this.clY.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.ds70));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.dLA = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.dLA.setVisibility(8);
        this.dLA.setOnClickListener(this.cWl);
        this.cWu = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cWu.setLoadingAnimationListener(this.cWE);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.cma.setForumAfterClickListener(this.bdG);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.clZ.setFrom(3);
        this.cmb = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setIsBarViewVisible(false);
        this.cma.setShareVisible(true);
        this.cma.setShareReportFrom(1);
        this.cma.setStType("frs_page");
        this.cma.setFrom(2);
        this.cma.aQv = 3;
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cmO.bep.setOnClickListener(this);
        this.cmO.setFrom(2);
        this.cmO.setShareReportFrom(1);
        this.cmO.setSourceFromForPb(3);
        this.cmO.setStType("frs_page");
        this.cmO.setHideBarName(true);
        this.cWn = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cWn.setOnClickListener(this);
        this.cWn.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cWn != null) {
                    a.this.cWn.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dLD);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cWn != null) {
                    a.this.cWn.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dLD);
                }
            }
        });
        this.cWg = (TbImageView) view.findViewById(d.g.image_video);
        this.cWg.setPageId(getTag());
        this.cWg.setDefaultErrorResource(0);
        this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWg.setEvent(this.cWF);
        this.cWg.setGifIconSupport(false);
        this.caA = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWo = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cZu = new com.baidu.tieba.play.n(this.aRI.getPageActivity());
        this.cWo.setBusiness(this.cZu);
        this.cWo.setOnPreparedListener(this.bPt);
        this.cWo.setOnErrorListener(this.bPu);
        this.cWo.setOnSurfaceDestroyedListener(this.caY);
        this.caQ = new com.baidu.tieba.play.j();
        this.caQ.setPlayer(this.cWo);
        this.caQ.a(this.cWL);
        this.cWw = view.findViewById(d.g.auto_video_black_mask);
        this.cWs = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cWt = view.findViewById(d.g.auto_video_error_background);
        this.cna = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cnb = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.caE = AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.fade_out_video_cover);
        this.caE.setAnimationListener(this.cWM);
        this.cWq = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWh = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cYn = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dLC = new com.baidu.tieba.frs.g.g(tbPageContext, this.clY);
        this.dLC.setUniqueId(getTag());
        this.cVx = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVx.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.clY || view == this.cma.getCommentNumView() || view == this.dLB) {
            bC(this.clY);
        } else if (view == this.cWn) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bN(this.cWn);
            } else {
                bC(this.cWn);
            }
        } else if (view == this.cVx) {
            bC(this.cVx);
        }
        if (this.aZC != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aZC));
        }
    }

    private void bN(View view) {
        if (this.aZC != null) {
            ak akVar = new ak("c11100");
            akVar.ab("tid", this.aZC.getId());
            akVar.ab(ImageViewerConfig.FORUM_ID, this.aZC.getFid() + "");
            TiebaStatic.log(akVar);
        }
        if (akP() != null) {
            akP().a(view, this.aZC);
        }
        if (view == this.cWn) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.aRI.getPageActivity(), d.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.oK()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
                aVar.dk(this.aRI.getString(d.j.enter_video_center_page_no_wifi_tip));
                aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.akZ();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.aZ(true);
                aVar.b(this.mTbPageContext).AV();
            } else {
                akZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aZC);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.cna.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.cna.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRI.getPageActivity(), "frs", this.aZC.getTid(), com.baidu.tieba.card.j.zd(), "", videoSerializeVideoThreadInfo)));
    }

    private void bC(View view) {
        if (this.aZC != null) {
            if (this.aZC.Ae()) {
                TiebaStatic.log(new ak("c10242").ab(ImageViewerConfig.FORUM_ID, String.valueOf(this.aZC.getFid())).s("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ab("tid", this.aZC.getId());
                akVar.ab(ImageViewerConfig.FORUM_ID, this.aZC.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.aZC.zn() != null && this.aZC.zn().getGodUserData() != null && this.aZC.zn().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", this.aZC.getId()));
            }
        }
        if (akP() != null) {
            akP().a(view, this.aZC);
        }
        if (this.aZC != null) {
            com.baidu.tieba.card.j.kr(this.aZC.getId());
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.util.t.hr(this.aZC.getId());
            if (this.aZC.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxX()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aRI.getPageActivity()).createHistoryCfg(this.aZC.getTid(), String.valueOf(this.aZC.zK()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.aZC.Ae() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aZC.An());
                createHistoryCfg.setSmartFrsPosition(this.aZC.Au());
                createHistoryCfg.setForumId(String.valueOf(this.aZC.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cVx) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aRI.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aRI.getPageActivity()).createFromThreadCfg(this.aZC, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aZC.Ae() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aZC.An());
            createFromThreadCfg.setSmartFrsPosition(this.aZC.Au());
            createFromThreadCfg.setForumId(String.valueOf(this.aZC.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cVx) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aRI.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public void a(bd bdVar) {
        this.aZC = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        this.cWD.removeMessages(202);
        if (this.cWo.getCurrentPosition() > 0) {
            i(true, 3);
            this.cWD.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cWD.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cWD.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cWo.getCurrentPosition();
        if (currentPosition != this.cWx) {
            this.cWx = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cWD.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.caA != null && this.cWg != null && this.cWw != null && this.cWu != null && this.cWt != null && this.cWs != null) {
            if (z || this.cWy != i) {
                this.cWy = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWH);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWG);
                if (i == 2) {
                    this.caA.setVisibility(8);
                    this.caE.cancel();
                    this.cWg.clearAnimation();
                    this.cWg.setVisibility(0);
                    this.cWw.setVisibility(0);
                    this.cYn.setVisibility(0);
                    this.cWu.startLoading();
                    this.cWt.setVisibility(8);
                    this.cWs.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWH, 60000L);
                } else if (i == 3) {
                    this.caA.setVisibility(8);
                    this.cWg.startAnimation(this.caE);
                    this.cWw.setVisibility(8);
                    this.cYn.setVisibility(8);
                    this.cWu.blQ();
                    this.cWt.setVisibility(8);
                    this.cWs.setVisibility(8);
                } else if (i == 4) {
                    this.caA.setVisibility(8);
                    this.cWg.startAnimation(this.caE);
                    this.cWw.setVisibility(8);
                    this.cWu.blR();
                    this.cWt.setVisibility(0);
                    this.cWs.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWG, 2000L);
                } else {
                    this.caA.setVisibility(0);
                    this.cYn.setVisibility(0);
                    this.caE.cancel();
                    this.cWg.clearAnimation();
                    this.cWg.setVisibility(0);
                    this.cWw.setVisibility(0);
                    this.cWu.blR();
                    this.cWt.setVisibility(8);
                    this.cWs.setVisibility(8);
                }
            }
        }
    }

    private void H(final bd bdVar) {
        if (this.cYP != null) {
            if (bdVar == null) {
                this.cYP.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQn)) {
                if (this.dLC != null && this.dLC.aAv() && (this.cYP.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYP.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.aRI.getContext(), d.e.tbds106);
                    this.cYP.setLayoutParams(layoutParams);
                }
                this.cYP.changeGrayScaleMode(bdVar.AC());
                this.cYP.setVisibility(0);
                this.cYP.setImageDrawable(null);
                this.cYP.startLoad(bdVar.aQn, 10, false);
                this.cYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.aRI != null && !StringUtils.isNull(bdVar.aQo)) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bdVar.aQo, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYP.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        if (this.aZC == null || this.aZC.zn() == null) {
            this.clY.setVisibility(8);
            return;
        }
        this.clY.setVisibility(0);
        ale();
        this.aZC.h(false, true);
        SpannableStringBuilder zN = this.aZC.zN();
        if (this.aZC.zT() && !StringUtils.isNull(this.aZC.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aZC.getTid();
            zN.append((CharSequence) this.aZC.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.3
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.b.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "2"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(zN));
        this.mTextTitle.setText(zN);
        this.dLC.W(this.aZC);
        H(this.aZC);
        this.clZ.setData(this.aZC);
        if (this.clZ.getHeaderImg() != null) {
            if (this.clZ.getIsSimpleThread()) {
                this.clZ.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (this.aZC.zn() == null || this.aZC.zn().getPendantData() == null || StringUtils.isNull(this.aZC.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.clZ.getHeaderImg().setVisibility(0);
                this.clZ.getHeaderImg().setData(this.aZC);
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(this.aZC);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.cma.setLayoutParams(layoutParams);
        this.clZ.setUserAfterClickListener(this.bdT);
        jX(this.aZC.aQp);
        this.cWq.setText(am.fV(this.aZC.zF().video_duration.intValue() * 1000));
        this.cWh.setText(String.format(this.aRI.getResources().getString(d.j.play_count), am.J(this.aZC.zF().play_count.intValue())));
        this.cVx.setGrayScaleMode(this.aZC.AC());
        this.cVx.setData(this.aZC.AA());
        this.cVx.onChangeSkinType();
        if (com.baidu.tieba.card.j.ks(this.aZC.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
            com.baidu.tieba.card.j.a(this.cVx.getGodReplyContent(), this.aZC.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        d(this.aRI, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alc() {
        this.cWD.removeMessages(202);
        this.cWD.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void ald() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWG);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWH);
    }

    private void ale() {
        ald();
        alc();
        if (this.cWg != null && this.cWn != null && this.cWo != null) {
            if (com.baidu.tbadk.core.i.xo().xu() && this.aZC != null && this.aZC.zF() != null) {
                this.cWn.setVisibility(0);
                this.cWg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWg.changeGrayScaleMode(this.aZC.AC());
                this.cWg.startLoad(this.aZC.zF().thumbnail_url, 10, false);
                stopPlay();
                this.bQL = this.aZC.zF().video_url;
                if (StringUtils.isNull(this.bQL)) {
                    i(true, 4);
                    TiebaStatic.log(new ak("c12026").ab("tid", this.aZC.getId()));
                }
                if (this.cZu != null && this.cZu.blz() != null) {
                    this.cZu.blz().d(this.aZC.zF());
                    return;
                }
                return;
            }
            this.cWn.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.clY, d.f.addresslist_item_bg);
            aj.c(this.caA, d.f.btn_icon_play_video_n);
            aj.r(this.cWs, d.C0141d.cp_cont_i);
            aj.r(this.cWq, d.C0141d.cp_cont_i);
            aj.r(this.cWh, d.C0141d.cp_cont_i);
            aj.t(this.cWt, d.C0141d.common_color_10014);
            aj.t(this.bQq, d.C0141d.cp_bg_line_e);
            if (this.cWs != null) {
                this.cWs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.cmO != null && this.cmO.getVisibility() == 0) {
                this.cmO.onChangeSkinType();
            }
            this.cma.onChangeSkinType();
            this.mSkinType = i;
            this.clZ.onChangeSkinType();
            this.dLC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cWz;
    }

    public boolean isPlaying() {
        if (this.cWo == null) {
            return false;
        }
        return this.cWo.isPlaying();
    }

    public void startPlay() {
        if (!this.cWz && this.aZC != null && this.aZC.zF() != null && this.cWo != null && com.baidu.tbadk.util.y.p(2, this.bQL)) {
            i(true, 2);
            if (StringUtils.isNull(this.bQL)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "frs").ab("tid", this.aZC.getId()));
                this.bQL = this.aZC.zF().video_url;
            }
            this.cWo.bN(this.bQL, this.aZC.getId());
            this.cWo.setLooping(true);
            if (this.caQ != null) {
                this.caQ.start();
            }
            this.cWz = true;
            akY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.aZC != null && this.aZC.zF() != null) {
            String str = this.aZC.Ae() ? "floor5" : "frs";
            aa aaVar = new aa();
            aaVar.mLocate = str;
            aaVar.bCV = this.aZC.getTid();
            aaVar.cZL = this.aZC.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.aZC.mRecomSource;
            aaVar.gwb = this.aZC.mRecomAbTag;
            aaVar.gwc = this.aZC.mRecomWeight;
            aaVar.gwd = "";
            aaVar.gwf = this.aZC.zF().video_md5;
            com.baidu.tieba.play.l.a(this.aZC.zF().video_md5, "", "1", aaVar);
        }
    }

    public void stopPlay() {
        ald();
        alc();
        i(true, 1);
        if (this.cWo != null) {
            this.cWo.stopPlayback();
            if (this.caQ != null) {
                this.caQ.stop();
            }
        }
        this.cWz = false;
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cma;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmO.bep;
    }

    public View getVideoContainer() {
        return this.cWn;
    }

    public String getPlayUrl() {
        return this.bQL;
    }

    public int getCurrentPosition() {
        if (this.cWo == null) {
            return 0;
        }
        return this.cWo.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cZu != null) {
            this.cZu.setVideoStatsData(aaVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cma != null && this.clZ != null) {
            this.clZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void jX(int i) {
        if (this.aZC != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setData(this.aZC);
                this.cmb.setVisibility(8);
                return;
            }
            this.cmb.setVisibility(this.cma.setData(this.aZC) ? 0 : 8);
            this.cmO.setVisibility(8);
        }
    }
}
