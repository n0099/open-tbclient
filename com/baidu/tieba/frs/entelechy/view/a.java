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
    private TbPageContext<?> aRG;
    private bd aZA;
    private g.f bPq;
    private g.b bPr;
    private String bQI;
    private View bQn;
    private final View.OnClickListener bdE;
    private final View.OnClickListener bdQ;
    private ThreadGodReplyLayout cVu;
    private Handler cWA;
    private VideoLoadingProgressView.a cWB;
    private TbImageView.a cWC;
    private Runnable cWD;
    private Runnable cWE;
    private j.a cWI;
    private Animation.AnimationListener cWJ;
    private TbImageView cWd;
    private TextView cWe;
    private View.OnClickListener cWi;
    public FrameLayout cWk;
    private QuickVideoView cWl;
    private com.baidu.tieba.play.g cWm;
    private TextView cWn;
    private TextView cWp;
    private View cWq;
    private y cWr;
    private View cWt;
    private int cWu;
    private int cWv;
    private boolean cWw;
    private TbImageView cYM;
    private LinearLayout cYk;
    private com.baidu.tieba.play.n cZr;
    private Animation caB;
    private com.baidu.tieba.play.j caN;
    private QuickVideoView.b caV;
    private ImageView cax;
    private RelativeLayout clV;
    public ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    public View clY;
    private HeadPendantClickableView cmI;
    protected ThreadSourceShareAndPraiseLayout cmL;
    public LinearLayout cmX;
    public ThreadSkinView cmY;
    public TextView dLv;
    public LinearLayout dLw;
    private com.baidu.tieba.frs.g.g dLx;
    private ViewTreeObserver.OnGlobalLayoutListener dLy;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akW() {
        if (this.cWm != null) {
            try {
                this.cWl.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cWA.sendEmptyMessageDelayed(202, 0L);
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWu = 0;
        this.cWv = 1;
        this.cWw = false;
        this.cWA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.akZ();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        a.this.ala();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPq = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                a.this.cWm = gVar;
                a.this.cWm.setVolume(0.0f, 0.0f);
                a.this.cWr.blO();
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.alb();
                a.this.i(true, 4);
                return true;
            }
        };
        this.cWB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                a.this.akW();
            }
        };
        this.cWC = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.16
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && a.this.cWd != null) {
                    a.this.cWd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dLy = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.17
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.cWk != null && a.this.cWk.getLayoutParams() != null && a.this.cWk.getVisibility() != 8) {
                    a.this.cWk.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.cWk.getLayoutParams();
                    if (a.this.cWk.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.cWk.getWidth() * 0.5625d);
                        a.this.cWk.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cWD = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cWl != null && !a.this.cWl.isPlaying()) {
                    a.this.i(true, 1);
                }
            }
        };
        this.cWE = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.alb();
                a.this.i(true, 4);
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.cWi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZA != null && !StringUtils.isNull(a.this.aZA.zt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.aRG.getPageActivity()).createNormalCfg(a.this.aZA.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.bdE != null) {
                        a.this.bdE.onClick(view);
                    }
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akO() != null) {
                    a.this.akO().a(view, a.this.aZA);
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZA != null && a.this.akO() != null) {
                    a.this.akO().a(view, a.this.aZA);
                }
            }
        };
        this.cWI = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tieba.play.j.a
            public void ale() {
                a.this.akX();
            }
        };
        this.cWJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.cWv == 3 && a.this.cWd != null) {
                    a.this.cWd.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.aRG = tbPageContext;
        View view = getView();
        this.bQn = view.findViewById(d.g.divider_line);
        this.clV = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cYM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.dLw = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.clV.setOnClickListener(this);
        this.cmI = (HeadPendantClickableView) this.clV.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.ds70));
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.dLv = (TextView) view.findViewById(d.g.thread_info_bar_name);
        this.dLv.setVisibility(8);
        this.dLv.setOnClickListener(this.cWi);
        this.cWr = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cWr.setLoadingAnimationListener(this.cWB);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        this.clX.setForumAfterClickListener(this.bdE);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.clW.setFrom(3);
        this.clY = view.findViewById(d.g.divider_below_reply_number_layout);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setIsBarViewVisible(false);
        this.clX.setShareVisible(true);
        this.clX.setShareReportFrom(1);
        this.clX.setStType("frs_page");
        this.clX.setFrom(2);
        this.clX.aQt = 3;
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cmL.bem.setOnClickListener(this);
        this.cmL.setFrom(2);
        this.cmL.setShareReportFrom(1);
        this.cmL.setSourceFromForPb(3);
        this.cmL.setStType("frs_page");
        this.cmL.setHideBarName(true);
        this.cWk = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cWk.setOnClickListener(this);
        this.cWk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.15
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.cWk != null) {
                    a.this.cWk.getViewTreeObserver().addOnGlobalLayoutListener(a.this.dLy);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.cWk != null) {
                    a.this.cWk.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.dLy);
                }
            }
        });
        this.cWd = (TbImageView) view.findViewById(d.g.image_video);
        this.cWd.setPageId(getTag());
        this.cWd.setDefaultErrorResource(0);
        this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWd.setEvent(this.cWC);
        this.cWd.setGifIconSupport(false);
        this.cax = (ImageView) view.findViewById(d.g.image_video_play);
        this.cWl = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cZr = new com.baidu.tieba.play.n(this.aRG.getPageActivity());
        this.cWl.setBusiness(this.cZr);
        this.cWl.setOnPreparedListener(this.bPq);
        this.cWl.setOnErrorListener(this.bPr);
        this.cWl.setOnSurfaceDestroyedListener(this.caV);
        this.caN = new com.baidu.tieba.play.j();
        this.caN.setPlayer(this.cWl);
        this.caN.a(this.cWI);
        this.cWt = view.findViewById(d.g.auto_video_black_mask);
        this.cWp = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cWq = view.findViewById(d.g.auto_video_error_background);
        this.cmX = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.cmY = (ThreadSkinView) view.findViewById(d.g.frs_thread_skin);
        this.caB = AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.fade_out_video_cover);
        this.caB.setAnimationListener(this.cWJ);
        this.cWn = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWe = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cYk = (LinearLayout) view.findViewById(d.g.duration_container);
        this.dLx = new com.baidu.tieba.frs.g.g(tbPageContext, this.clV);
        this.dLx.setUniqueId(getTag());
        this.cVu = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVu.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.clV || view == this.clX.getCommentNumView() || view == this.dLw) {
            bC(this.clV);
        } else if (view == this.cWk) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bN(this.cWk);
            } else {
                bC(this.cWk);
            }
        } else if (view == this.cVu) {
            bC(this.cVu);
        }
        if (this.aZA != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aZA));
        }
    }

    private void bN(View view) {
        if (this.aZA != null) {
            ak akVar = new ak("c11100");
            akVar.ab("tid", this.aZA.getId());
            akVar.ab(ImageViewerConfig.FORUM_ID, this.aZA.getFid() + "");
            TiebaStatic.log(akVar);
        }
        if (akO() != null) {
            akO().a(view, this.aZA);
        }
        if (view == this.cWk) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                com.baidu.adp.lib.util.l.showToast(this.aRG.getPageActivity(), d.j.no_network_guide);
            } else if (!com.baidu.adp.lib.util.j.oK()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
                aVar.dk(this.aRG.getString(d.j.enter_video_center_page_no_wifi_tip));
                aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.18
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a.this.akY();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.aZ(true);
                aVar.b(this.mTbPageContext).AU();
            } else {
                akY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.aZA);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (getView().getX() + getVideoContainer().getX() + this.cmX.getX());
        videoCardViewInfo.cardViewY = (int) (getView().getY() + getVideoContainer().getY() + this.cmX.getY());
        videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
        videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRG.getPageActivity(), "frs", this.aZA.getTid(), com.baidu.tieba.card.j.zd(), "", videoSerializeVideoThreadInfo)));
    }

    private void bC(View view) {
        if (this.aZA != null) {
            if (this.aZA.Ae()) {
                TiebaStatic.log(new ak("c10242").ab(ImageViewerConfig.FORUM_ID, String.valueOf(this.aZA.getFid())).s("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ab("tid", this.aZA.getId());
                akVar.ab(ImageViewerConfig.FORUM_ID, this.aZA.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.aZA.zn() != null && this.aZA.zn().getGodUserData() != null && this.aZA.zn().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", this.aZA.getId()));
            }
        }
        if (akO() != null) {
            akO().a(view, this.aZA);
        }
        if (this.aZA != null) {
            com.baidu.tieba.card.j.kr(this.aZA.getId());
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
            com.baidu.tbadk.util.t.hr(this.aZA.getId());
            if (this.aZA.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxS()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aRG.getPageActivity()).createHistoryCfg(this.aZA.getTid(), String.valueOf(this.aZA.zK()), false, true, "frs_page");
                createHistoryCfg.setVideo_source(this.aZA.Ae() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aZA.An());
                createHistoryCfg.setSmartFrsPosition(this.aZA.Au());
                createHistoryCfg.setForumId(String.valueOf(this.aZA.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                if (view == this.cVu) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aRG.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aRG.getPageActivity()).createFromThreadCfg(this.aZA, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aZA.Ae() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aZA.An());
            createFromThreadCfg.setSmartFrsPosition(this.aZA.Au());
            createFromThreadCfg.setForumId(String.valueOf(this.aZA.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            if (view == this.cVu) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aRG.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
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
        this.aZA = bdVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        this.cWA.removeMessages(202);
        if (this.cWl.getCurrentPosition() > 0) {
            i(true, 3);
            this.cWA.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cWA.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cWA.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cWl.getCurrentPosition();
        if (currentPosition != this.cWu) {
            this.cWu = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cWA.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cax != null && this.cWd != null && this.cWt != null && this.cWr != null && this.cWq != null && this.cWp != null) {
            if (z || this.cWv != i) {
                this.cWv = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWE);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWD);
                if (i == 2) {
                    this.cax.setVisibility(8);
                    this.caB.cancel();
                    this.cWd.clearAnimation();
                    this.cWd.setVisibility(0);
                    this.cWt.setVisibility(0);
                    this.cYk.setVisibility(0);
                    this.cWr.startLoading();
                    this.cWq.setVisibility(8);
                    this.cWp.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWE, 60000L);
                } else if (i == 3) {
                    this.cax.setVisibility(8);
                    this.cWd.startAnimation(this.caB);
                    this.cWt.setVisibility(8);
                    this.cYk.setVisibility(8);
                    this.cWr.blP();
                    this.cWq.setVisibility(8);
                    this.cWp.setVisibility(8);
                } else if (i == 4) {
                    this.cax.setVisibility(8);
                    this.cWd.startAnimation(this.caB);
                    this.cWt.setVisibility(8);
                    this.cWr.blQ();
                    this.cWq.setVisibility(0);
                    this.cWp.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWD, 2000L);
                } else {
                    this.cax.setVisibility(0);
                    this.cYk.setVisibility(0);
                    this.caB.cancel();
                    this.cWd.clearAnimation();
                    this.cWd.setVisibility(0);
                    this.cWt.setVisibility(0);
                    this.cWr.blQ();
                    this.cWq.setVisibility(8);
                    this.cWp.setVisibility(8);
                }
            }
        }
    }

    private void H(final bd bdVar) {
        if (this.cYM != null) {
            if (bdVar == null) {
                this.cYM.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQm)) {
                if (this.dLx != null && this.dLx.aAt() && (this.cYM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYM.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.aRG.getContext(), d.e.tbds106);
                    this.cYM.setLayoutParams(layoutParams);
                }
                this.cYM.setVisibility(0);
                this.cYM.setImageDrawable(null);
                this.cYM.startLoad(bdVar.aQm, 10, false);
                this.cYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.aRG != null) {
                            a.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.mTbPageContext.getContext(), "", bdVar.aQn, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYM.setVisibility(8);
            }
        }
    }

    private void refreshView() {
        if (this.aZA == null || this.aZA.zn() == null) {
            this.clV.setVisibility(8);
            return;
        }
        this.clV.setVisibility(0);
        ald();
        this.aZA.h(false, true);
        SpannableStringBuilder zN = this.aZA.zN();
        if (this.aZA.zT() && !StringUtils.isNull(this.aZA.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.aZA.getTid();
            zN.append((CharSequence) this.aZA.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.frs.entelechy.view.a.3
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
        this.dLx.W(this.aZA);
        H(this.aZA);
        this.clW.setData(this.aZA);
        if (this.clW.getHeaderImg() != null) {
            if (this.clW.getIsSimpleThread()) {
                this.clW.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (this.aZA.zn() == null || this.aZA.zn().getPendantData() == null || StringUtils.isNull(this.aZA.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.clW.getHeaderImg().setVisibility(0);
                this.clW.getHeaderImg().setData(this.aZA);
            } else {
                this.clW.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(this.aZA);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.clX.setLayoutParams(layoutParams);
        this.clW.setUserAfterClickListener(this.bdQ);
        jX(this.aZA.aQo);
        this.cWn.setText(am.fV(this.aZA.zF().video_duration.intValue() * 1000));
        this.cWe.setText(String.format(this.aRG.getResources().getString(d.j.play_count), am.J(this.aZA.zF().play_count.intValue())));
        this.cVu.setData(this.aZA.AA());
        this.cVu.onChangeSkinType();
        if (com.baidu.tieba.card.j.ks(this.aZA.getId())) {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_d, 1);
            com.baidu.tieba.card.j.a(this.cVu.getGodReplyContent(), this.aZA.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        } else {
            aj.e(this.mTextTitle, d.C0141d.cp_cont_b, 1);
        }
        d(this.aRG, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        this.cWA.removeMessages(202);
        this.cWA.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void alc() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWD);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWE);
    }

    private void ald() {
        alc();
        alb();
        if (this.cWd != null && this.cWk != null && this.cWl != null) {
            if (com.baidu.tbadk.core.i.xo().xu() && this.aZA != null && this.aZA.zF() != null) {
                this.cWk.setVisibility(0);
                this.cWd.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWd.startLoad(this.aZA.zF().thumbnail_url, 10, false);
                stopPlay();
                this.bQI = this.aZA.zF().video_url;
                if (StringUtils.isNull(this.bQI)) {
                    i(true, 4);
                    TiebaStatic.log(new ak("c12026").ab("tid", this.aZA.getId()));
                }
                if (this.cZr != null && this.cZr.bly() != null) {
                    this.cZr.bly().d(this.aZA.zF());
                    return;
                }
                return;
            }
            this.cWk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.clV, d.f.addresslist_item_bg);
            aj.c(this.cax, d.f.btn_icon_play_video_n);
            aj.r(this.cWp, d.C0141d.cp_cont_i);
            aj.r(this.cWn, d.C0141d.cp_cont_i);
            aj.r(this.cWe, d.C0141d.cp_cont_i);
            aj.t(this.cWq, d.C0141d.common_color_10014);
            aj.t(this.bQn, d.C0141d.cp_bg_line_e);
            if (this.cWp != null) {
                this.cWp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.cmL != null && this.cmL.getVisibility() == 0) {
                this.cmL.onChangeSkinType();
            }
            this.clX.onChangeSkinType();
            this.mSkinType = i;
            this.clW.onChangeSkinType();
            this.dLx.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.cWw;
    }

    public boolean isPlaying() {
        if (this.cWl == null) {
            return false;
        }
        return this.cWl.isPlaying();
    }

    public void startPlay() {
        if (!this.cWw && this.aZA != null && this.aZA.zF() != null && this.cWl != null && com.baidu.tbadk.util.y.p(2, this.bQI)) {
            i(true, 2);
            if (StringUtils.isNull(this.bQI)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "frs").ab("tid", this.aZA.getId()));
                this.bQI = this.aZA.zF().video_url;
            }
            this.cWl.bN(this.bQI, this.aZA.getId());
            this.cWl.setLooping(true);
            if (this.caN != null) {
                this.caN.start();
            }
            this.cWw = true;
            akX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.aZA != null && this.aZA.zF() != null) {
            String str = this.aZA.Ae() ? "floor5" : "frs";
            aa aaVar = new aa();
            aaVar.mLocate = str;
            aaVar.bCS = this.aZA.getTid();
            aaVar.cZI = this.aZA.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.aZA.mRecomSource;
            aaVar.gvL = this.aZA.mRecomAbTag;
            aaVar.gvM = this.aZA.mRecomWeight;
            aaVar.gvN = "";
            aaVar.gvP = this.aZA.zF().video_md5;
            com.baidu.tieba.play.l.a(this.aZA.zF().video_md5, "", "1", aaVar);
        }
    }

    public void stopPlay() {
        alc();
        alb();
        i(true, 1);
        if (this.cWl != null) {
            this.cWl.stopPlayback();
            if (this.caN != null) {
                this.caN.stop();
            }
        }
        this.cWw = false;
    }

    public ThreadCommentAndPraiseInfoLayout alt() {
        return this.clX;
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmL.bem;
    }

    public View getVideoContainer() {
        return this.cWk;
    }

    public String getPlayUrl() {
        return this.bQI;
    }

    public int getCurrentPosition() {
        if (this.cWl == null) {
            return 0;
        }
        return this.cWl.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cZr != null) {
            this.cZr.setVideoStatsData(aaVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.clX != null && this.clW != null) {
            this.clW.setPageUniqueId(bdUniqueId);
        }
    }

    public void jX(int i) {
        if (this.aZA != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setData(this.aZA);
                this.clY.setVisibility(8);
                return;
            }
            this.clY.setVisibility(this.clX.setData(this.aZA) ? 0 : 8);
            this.cmL.setVisibility(8);
        }
    }
}
