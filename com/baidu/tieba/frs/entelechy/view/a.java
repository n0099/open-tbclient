package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.i;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.w;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bj> implements v {
    private f.e aUt;
    private f.b aUu;
    private String aVD;
    private View aVj;
    private TbPageContext<?> aby;
    private bj ajE;
    private final View.OnClickListener aoc;
    private final View.OnClickListener aou;
    public FrameLayout bIu;
    private TbImageView bIv;
    private ImageView bIw;
    private TbImageView.a bIy;
    private HeadPendantClickableView bKh;
    private ThreadGodReplyLayout bKi;
    private QuickVideoView.b bLA;
    private i.a bLE;
    private Animation.AnimationListener bLF;
    private View.OnClickListener bLf;
    private QuickVideoView bLh;
    private TextView bLj;
    private TextView bLk;
    private View bLl;
    private AudioAnimationView bLm;
    private ProgressBar bLn;
    private ImageView bLo;
    private View bLq;
    private int bLr;
    private int bLs;
    private boolean bLt;
    private com.baidu.tieba.play.i bLv;
    private Animation bLw;
    private Handler bLx;
    private Runnable bLy;
    private Runnable bLz;
    private m bNw;
    private View bhm;
    public LinearLayout blC;
    public ThreadSkinView blD;
    private RelativeLayout bll;
    public ThreadUserInfoLayout blu;
    public ThreadCommentAndPraiseInfoLayout bly;
    public View blz;
    public TextView cwL;
    public LinearLayout cwM;
    private com.baidu.tieba.frs.h.g cwN;
    private ViewTreeObserver.OnGlobalLayoutListener cwO;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bLr = 0;
        this.bLs = 1;
        this.bLt = false;
        this.bLx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.XU();
                        return;
                    case 203:
                        a.this.XV();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUt = new f.e() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bLx.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aUu = new f.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                a.this.XW();
                a.this.g(true, 4);
                return true;
            }
        };
        this.bIy = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && a.this.bIv != null) {
                    a.this.bIv.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cwO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bIu != null && a.this.bIu.getLayoutParams() != null && a.this.bIu.getVisibility() != 8) {
                    a.this.bIu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bIu.getLayoutParams();
                    if (a.this.bIu.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bIu.getWidth() * 0.5625d);
                        a.this.bIu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bLy = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bLh != null && !a.this.bLh.isPlaying()) {
                    a.this.g(true, 1);
                }
            }
        };
        this.bLz = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.XW();
                a.this.g(true, 4);
            }
        };
        this.bLA = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.bLf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajE != null && !StringUtils.isNull(a.this.ajE.rG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.aby.getPageActivity()).createNormalCfg(a.this.ajE.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.aoc != null) {
                        a.this.aoc.onClick(view);
                    }
                }
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.XL() != null) {
                    a.this.XL().a(view, a.this.ajE);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ajE != null && a.this.XL() != null) {
                    a.this.XL().a(view, a.this.ajE);
                }
            }
        };
        this.bLE = new i.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.i.a
            public void XZ() {
                a.this.XT();
            }
        };
        this.bLF = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bLs == 3 && a.this.bIv != null) {
                    a.this.bIv.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.aby = tbPageContext;
        View view = getView();
        this.aVj = view.findViewById(d.h.divider_line);
        this.bll = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.cwM = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bll.setOnClickListener(this);
        this.bKh = (HeadPendantClickableView) this.bll.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bKh.getHeadView() != null) {
            this.bKh.getHeadView().setIsRound(true);
            this.bKh.getHeadView().setDrawBorder(false);
            this.bKh.getHeadView().setDefaultResource(17170445);
            this.bKh.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bKh.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bKh.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.aby.getPageActivity(), d.f.ds70));
        }
        this.bKh.wB();
        if (this.bKh.getPendantView() != null) {
            this.bKh.getPendantView().setIsRound(true);
            this.bKh.getPendantView().setDrawBorder(false);
        }
        this.cwL = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.cwL.setVisibility(8);
        this.cwL.setOnClickListener(this.bLf);
        this.bLn = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bLo = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.blu = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.blu.setFrom(3);
        this.blz = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setIsBarViewVisible(false);
        this.bly.setShareVisible(true);
        this.bly.setShareReportFrom(1);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setFrom(2);
        this.bIu = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bIu.setOnClickListener(this);
        this.bIu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bIu != null) {
                    a.this.bIu.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cwO);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bIu != null) {
                    a.this.bIu.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cwO);
                }
            }
        });
        this.bIv = (TbImageView) view.findViewById(d.h.image_video);
        this.bIv.setPageId(getTag());
        this.bIv.setDefaultErrorResource(0);
        this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bIv.setEvent(this.bIy);
        this.bIv.setGifIconSupport(false);
        this.bIw = (ImageView) view.findViewById(d.h.image_video_play);
        this.bLm = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bLm.setCertainColumnCount(4);
        this.bLm.setColumnColor(d.e.cp_cont_i);
        this.bLh = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bNw = new m(this.aby.getPageActivity());
        this.bLh.setBusiness(this.bNw);
        this.bLh.setOnPreparedListener(this.aUt);
        this.bLh.setOnErrorListener(this.aUu);
        this.bLh.setOnSurfaceDestroyedListener(this.bLA);
        this.bLv = new com.baidu.tieba.play.i();
        this.bLv.setPlayer(this.bLh);
        this.bLv.a(this.bLE);
        this.bLq = view.findViewById(d.h.auto_video_black_mask);
        this.bLk = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bLl = view.findViewById(d.h.auto_video_error_background);
        this.blC = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.blD = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bLw = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.fade_out_video_cover);
        this.bLw.setAnimationListener(this.bLF);
        this.bLj = (TextView) view.findViewById(d.h.text_video_duration);
        this.cwN = new com.baidu.tieba.frs.h.g(tbPageContext, this.blu);
        this.cwN.setUniqueId(getTag());
        this.bhm = view.findViewById(d.h.divider_line);
        this.bKi = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bKi.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bll || view == this.bly.getCommentNumView() || view == this.cwM) {
            ae(this.bll);
        } else if (view == this.bIu) {
            ae(this.bIu);
        } else if (view == this.bKi) {
            ae(this.bKi);
        }
        if (this.ajE != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ajE));
        }
    }

    private void ae(View view) {
        if (this.ajE != null) {
            if (this.ajE.sv()) {
                TiebaStatic.log(new ak("c10242").ad("fid", String.valueOf(this.ajE.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ad("tid", this.ajE.getId());
                akVar.ad("fid", this.ajE.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.ajE.getAuthor() != null && this.ajE.getAuthor().getGodUserData() != null && this.ajE.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", this.ajE.getId()));
            }
        }
        if (XL() != null) {
            XL().a(view, this.ajE);
        }
        if (this.ajE != null) {
            com.baidu.tieba.card.m.ju(this.ajE.getId());
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            s.gR(this.ajE.getId());
            if (this.ajE.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btx()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aby.getPageActivity()).createHistoryCfg(this.ajE.getTid(), String.valueOf(this.ajE.rX()), false, true, com.baidu.tieba.card.m.rs());
                createHistoryCfg.setVideo_source(this.ajE.sv() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ajE.sE());
                createHistoryCfg.setSmartFrsPosition(this.ajE.sL());
                createHistoryCfg.setForumId(String.valueOf(this.ajE.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bKi) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aby.getPageActivity()).createFromThreadCfg(this.ajE, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ajE.sv() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ajE.sE());
            createFromThreadCfg.setSmartFrsPosition(this.ajE.sL());
            createFromThreadCfg.setForumId(String.valueOf(this.ajE.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bKi) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aby.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bj bjVar) {
        this.ajE = bjVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XU() {
        this.bLx.removeMessages(202);
        if (this.bLh.getCurrentPosition() > 0) {
            g(true, 3);
            this.bLx.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bLx.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XV() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bLx.removeMessages(203);
        int currentPosition = this.bLh.getCurrentPosition();
        if (currentPosition != this.bLr) {
            this.bLr = currentPosition;
            g(false, 3);
        } else {
            g(false, 2);
        }
        this.bLx.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bIw != null && this.bIv != null && this.bLq != null && this.bLm != null && this.bLn != null && this.bLo != null && this.bLl != null && this.bLk != null) {
            if (z || this.bLs != i) {
                this.bLs = i;
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLz);
                com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLy);
                if (i == 2) {
                    this.bIw.setVisibility(8);
                    this.bLw.cancel();
                    this.bIv.clearAnimation();
                    this.bIv.setVisibility(0);
                    this.bLq.setVisibility(0);
                    this.bLj.setVisibility(0);
                    this.bLn.setVisibility(0);
                    this.bLo.setVisibility(0);
                    this.bLl.setVisibility(8);
                    this.bLk.setVisibility(8);
                    this.bLm.setVisibility(8);
                    this.bLm.bwE();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bLz, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bIw.setVisibility(8);
                    this.bIv.startAnimation(this.bLw);
                    this.bLq.setVisibility(8);
                    this.bLj.setVisibility(8);
                    this.bLn.setVisibility(8);
                    this.bLo.setVisibility(8);
                    this.bLl.setVisibility(8);
                    this.bLk.setVisibility(8);
                    this.bLm.setVisibility(0);
                    this.bLm.start();
                } else if (i == 4) {
                    this.bIw.setVisibility(8);
                    this.bIv.startAnimation(this.bLw);
                    this.bLq.setVisibility(8);
                    this.bLn.setVisibility(8);
                    this.bLo.setVisibility(8);
                    this.bLl.setVisibility(0);
                    this.bLk.setVisibility(0);
                    this.bLm.setVisibility(8);
                    this.bLm.bwE();
                    com.baidu.adp.lib.g.e.fQ().postDelayed(this.bLy, 2000L);
                } else {
                    this.bIw.setVisibility(0);
                    this.bLj.setVisibility(0);
                    this.bLw.cancel();
                    this.bIv.clearAnimation();
                    this.bIv.setVisibility(0);
                    this.bLq.setVisibility(0);
                    this.bLn.setVisibility(8);
                    this.bLo.setVisibility(8);
                    this.bLl.setVisibility(8);
                    this.bLk.setVisibility(8);
                    this.bLm.setVisibility(8);
                    this.bLm.bwE();
                }
            }
        }
    }

    private void refreshView() {
        if (this.ajE == null || this.ajE.getAuthor() == null) {
            this.bll.setVisibility(8);
            return;
        }
        this.bll.setVisibility(0);
        XY();
        this.ajE.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(this.ajE.sb()));
        this.mTextTitle.setText(this.ajE.sb());
        this.cwN.T(this.ajE);
        this.blu.c(this.ajE);
        if (this.blu.getHeaderImg() != null) {
            if (this.blu.getIsSimpleThread()) {
                this.blu.getHeaderImg().setVisibility(8);
                this.bKh.setVisibility(8);
            } else if (this.ajE.getAuthor() == null || this.ajE.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajE.getAuthor().getPendantData().pR())) {
                this.bKh.setVisibility(8);
                this.blu.getHeaderImg().setVisibility(0);
                this.blu.getHeaderImg().setData(this.ajE);
            } else {
                this.blu.getHeaderImg().setVisibility(4);
                this.bKh.setVisibility(0);
                this.bKh.setData(this.ajE);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bly.setLayoutParams(layoutParams);
        this.blu.setUserAfterClickListener(this.aou);
        if (this.bly.c(this.ajE)) {
            this.blz.setVisibility(8);
        } else {
            this.blz.setVisibility(0);
        }
        this.bLj.setText(am.da(this.ajE.rS().video_duration.intValue() * 1000));
        this.bly.setCommentNumClickListener(this);
        this.bKi.setData(this.ajE.sR());
        this.bKi.onChangeSkinType();
        if (this.bKi.getVisibility() == 0) {
            this.blz.setVisibility(0);
        }
        if (com.baidu.tieba.card.m.jv(this.ajE.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            com.baidu.tieba.card.m.a(this.bKi.getGodReplyContent(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            com.baidu.tieba.card.m.a(this.bKi.getPraiseNum(), this.ajE.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XW() {
        this.bLx.removeMessages(202);
        this.bLx.removeMessages(203);
    }

    private void XX() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLy);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.bLz);
    }

    private void XY() {
        XX();
        XW();
        if (this.bIv != null && this.bIu != null && this.bLh != null) {
            if (com.baidu.tbadk.core.h.oS().oY() && this.ajE != null && this.ajE.rS() != null) {
                this.bIu.setVisibility(0);
                this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bIv.c(this.ajE.rS().thumbnail_url, 10, false);
                stopPlay();
                this.aVD = this.ajE.rS().video_url;
                if (StringUtils.isNull(this.aVD)) {
                    g(true, 4);
                }
                if (this.bNw != null && this.bNw.bfQ() != null) {
                    this.bNw.bfQ().d(this.ajE.rS());
                    return;
                }
                return;
            }
            this.bIu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bll, d.g.addresslist_item_bg);
            aj.c(this.bIw, d.g.btn_icon_play_video_n);
            aj.i(this.bLk, d.e.cp_cont_i);
            aj.i(this.bLj, d.e.cp_cont_g);
            aj.k(this.bLl, d.e.common_color_10014);
            aj.k(this.aVj, d.e.cp_bg_line_c);
            if (this.bLk != null) {
                this.bLk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bly.onChangeSkinType();
            this.mSkinType = i;
            this.blu.onChangeSkinType();
            this.cwN.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bLt;
    }

    public boolean isPlaying() {
        if (this.bLh == null) {
            return false;
        }
        return this.bLh.isPlaying();
    }

    public void startPlay() {
        if (!this.bLt && this.ajE != null && this.ajE.rS() != null && this.bLh != null && x.q(2, this.aVD)) {
            g(true, 2);
            this.bLh.setVideoPath(this.aVD);
            this.bLh.start();
            this.bLh.setLooping(true);
            if (this.bLv != null) {
                this.bLv.start();
            }
            this.bLt = true;
            XT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XT() {
        if (this.ajE != null && this.ajE.rS() != null) {
            String str = this.ajE.sv() ? "floor5" : "frs";
            w wVar = new w();
            wVar.mLocate = str;
            wVar.bHy = this.ajE.getTid();
            wVar.azL = this.ajE.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.ajE.ZH;
            wVar.fBN = this.ajE.ZJ;
            wVar.fBO = this.ajE.ZI;
            wVar.fBP = "";
            wVar.fBR = this.ajE.rS().video_md5;
            if (this.ajE.sF() != null && this.ajE.sF().channelId > 0) {
                wVar.VU = this.ajE.sF().channelId + "";
            } else {
                wVar.VU = "0";
            }
            com.baidu.tieba.play.k.a(this.ajE.rS().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        XX();
        XW();
        g(true, 1);
        if (this.bLh != null) {
            this.bLh.stopPlayback();
            if (this.bLv != null) {
                this.bLv.stop();
            }
        }
        this.bLt = false;
    }

    public View getVideoContainer() {
        return this.bIu;
    }

    public String getPlayUrl() {
        return this.aVD;
    }

    public int getCurrentPosition() {
        if (this.bLh == null) {
            return 0;
        }
        return this.bLh.getCurrentPosition();
    }

    public void setVideoStatsData(w wVar) {
        if (this.bNw != null) {
            this.bNw.setVideoStatsData(wVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bly != null && this.blu != null) {
            this.blu.setPageUniqueId(bdUniqueId);
        }
    }
}
