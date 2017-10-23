package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bh> implements v {
    private g.f aVR;
    private g.b aVS;
    private View aWK;
    private String aXe;
    private TbPageContext<?> abm;
    private bh aiU;
    private final View.OnClickListener anf;
    private final View.OnClickListener anx;
    private HeadPendantClickableView bJj;
    private ThreadGodReplyLayout bJk;
    private int bKA;
    private int bKB;
    private boolean bKC;
    private com.baidu.tieba.play.j bKE;
    private Animation bKF;
    private Handler bKG;
    private TbImageView.a bKH;
    private Runnable bKI;
    private Runnable bKJ;
    private QuickVideoView.b bKK;
    private j.a bKO;
    private Animation.AnimationListener bKP;
    private TbImageView bKh;
    private ImageView bKi;
    private TextView bKj;
    private View.OnClickListener bKn;
    public FrameLayout bKp;
    private QuickVideoView bKq;
    private TextView bKs;
    private TextView bKu;
    private View bKv;
    private ProgressBar bKw;
    private ImageView bKx;
    private View bKz;
    private n bMN;
    private LinearLayout bMi;
    private RelativeLayout bmI;
    public ThreadUserInfoLayout bmR;
    public ThreadCommentAndPraiseInfoLayout bmV;
    public View bmW;
    public LinearLayout bmZ;
    public ThreadSkinView bna;
    public TextView cxp;
    public LinearLayout cxq;
    private com.baidu.tieba.frs.h.g cxr;
    private ViewTreeObserver.OnGlobalLayoutListener cxs;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bKA = 0;
        this.bKB = 1;
        this.bKC = false;
        this.bKG = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.frs.entelechy.view.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        a.this.Xw();
                        return;
                    case 203:
                        a.this.Xx();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aVR = new g.f() { // from class: com.baidu.tieba.frs.entelechy.view.a.7
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.bKG.sendEmptyMessageDelayed(202, 0L);
                }
            }
        };
        this.aVS = new g.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.8
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                a.this.Xy();
                a.this.g(true, 4);
                return true;
            }
        };
        this.bKH = new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.10
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && a.this.bKh != null) {
                    a.this.bKh.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cxs = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (a.this.bKp != null && a.this.bKp.getLayoutParams() != null && a.this.bKp.getVisibility() != 8) {
                    a.this.bKp.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = a.this.bKp.getLayoutParams();
                    if (a.this.bKp.getWidth() > 0) {
                        layoutParams.height = (int) (a.this.bKp.getWidth() * 0.5625d);
                        a.this.bKp.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bKI = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bKq != null && !a.this.bKq.isPlaying()) {
                    a.this.g(true, 1);
                }
            }
        };
        this.bKJ = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.a.13
            @Override // java.lang.Runnable
            public void run() {
                a.this.Xy();
                a.this.g(true, 4);
            }
        };
        this.bKK = new QuickVideoView.b() { // from class: com.baidu.tieba.frs.entelechy.view.a.14
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                a.this.stopPlay();
            }
        };
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiU != null && !StringUtils.isNull(a.this.aiU.rt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.abm.getPageActivity()).createNormalCfg(a.this.aiU.rt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (a.this.anf != null) {
                        a.this.anf.onClick(view);
                    }
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Xn() != null) {
                    a.this.Xn().a(view, a.this.aiU);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiU != null && a.this.Xn() != null) {
                    a.this.Xn().a(view, a.this.aiU);
                }
            }
        };
        this.bKO = new j.a() { // from class: com.baidu.tieba.frs.entelechy.view.a.5
            @Override // com.baidu.tieba.play.j.a
            public void XB() {
                a.this.Xv();
            }
        };
        this.bKP = new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.bKB == 3 && a.this.bKh != null) {
                    a.this.bKh.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        setTag(bdUniqueId);
        this.abm = tbPageContext;
        View view = getView();
        this.aWK = view.findViewById(d.h.divider_line);
        this.bmI = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.cxq = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bmI.setOnClickListener(this);
        this.bJj = (HeadPendantClickableView) this.bmI.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abm.getPageActivity(), d.f.ds70));
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.cxp = (TextView) view.findViewById(d.h.thread_info_bar_name);
        this.cxp.setVisibility(8);
        this.cxp.setOnClickListener(this.bKn);
        this.bKw = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bKx = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bmR = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bmR.setFrom(3);
        this.bmW = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setShareVisible(true);
        this.bmV.setShareReportFrom(1);
        this.bmV.setFrom(2);
        this.bKp = (FrameLayout) view.findViewById(d.h.frame_video);
        this.bKp.setOnClickListener(this);
        this.bKp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.frs.entelechy.view.a.9
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                if (a.this.bKp != null) {
                    a.this.bKp.getViewTreeObserver().addOnGlobalLayoutListener(a.this.cxs);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (a.this.bKp != null) {
                    a.this.bKp.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.cxs);
                }
            }
        });
        this.bKh = (TbImageView) view.findViewById(d.h.image_video);
        this.bKh.setPageId(getTag());
        this.bKh.setDefaultErrorResource(0);
        this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKh.setEvent(this.bKH);
        this.bKh.setGifIconSupport(false);
        this.bKi = (ImageView) view.findViewById(d.h.image_video_play);
        this.bKq = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bMN = new n(this.abm.getPageActivity());
        this.bKq.setBusiness(this.bMN);
        this.bKq.setOnPreparedListener(this.aVR);
        this.bKq.setOnErrorListener(this.aVS);
        this.bKq.setOnSurfaceDestroyedListener(this.bKK);
        this.bKE = new com.baidu.tieba.play.j();
        this.bKE.setPlayer(this.bKq);
        this.bKE.a(this.bKO);
        this.bKz = view.findViewById(d.h.auto_video_black_mask);
        this.bKu = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bKv = view.findViewById(d.h.auto_video_error_background);
        this.bmZ = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bna = (ThreadSkinView) view.findViewById(d.h.frs_thread_skin);
        this.bKF = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.fade_out_video_cover);
        this.bKF.setAnimationListener(this.bKP);
        this.bKs = (TextView) view.findViewById(d.h.text_video_duration);
        this.bKj = (TextView) view.findViewById(d.h.text_video_play_count);
        this.bMi = (LinearLayout) view.findViewById(d.h.duration_container);
        this.cxr = new com.baidu.tieba.frs.h.g(tbPageContext, this.bmR);
        this.cxr.setUniqueId(getTag());
        this.bJk = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJk.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmI || view == this.bmV.getCommentNumView() || view == this.cxq) {
            ad(this.bmI);
        } else if (view == this.bKp) {
            ad(this.bKp);
        } else if (view == this.bJk) {
            ad(this.bJk);
        }
        if (this.aiU != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiU));
        }
    }

    private void ad(View view) {
        if (this.aiU != null) {
            if (this.aiU.si()) {
                TiebaStatic.log(new ak("c10242").ac("fid", String.valueOf(this.aiU.getFid())).r("obj_type", 2));
            } else {
                ak akVar = new ak("c11100");
                akVar.ac("tid", this.aiU.getId());
                akVar.ac("fid", this.aiU.getFid() + "");
                TiebaStatic.log(akVar);
            }
            if (this.aiU.getAuthor() != null && this.aiU.getAuthor().getGodUserData() != null && this.aiU.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", this.aiU.getId()));
            }
        }
        if (Xn() != null) {
            Xn().a(view, this.aiU);
        }
        if (this.aiU != null) {
            m.jl(this.aiU.getId());
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            r.gN(this.aiU.getId());
            if (this.aiU.rK() > 0 && com.baidu.tieba.tbadkCore.util.f.bso()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.abm.getPageActivity()).createHistoryCfg(this.aiU.getTid(), String.valueOf(this.aiU.rK()), false, true, m.rf());
                createHistoryCfg.setVideo_source(this.aiU.si() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aiU.sr());
                createHistoryCfg.setSmartFrsPosition(this.aiU.sy());
                createHistoryCfg.setForumId(String.valueOf(this.aiU.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bJk) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.abm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.abm.getPageActivity()).createFromThreadCfg(this.aiU, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aiU.si() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aiU.sr());
            createFromThreadCfg.setSmartFrsPosition(this.aiU.sy());
            createFromThreadCfg.setForumId(String.valueOf(this.aiU.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bJk) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.abm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(bh bhVar) {
        this.aiU = bhVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xw() {
        this.bKG.removeMessages(202);
        if (this.bKq.getCurrentPosition() > 0) {
            g(true, 3);
            this.bKG.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bKG.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xx() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bKG.removeMessages(203);
        int currentPosition = this.bKq.getCurrentPosition();
        if (currentPosition != this.bKA) {
            this.bKA = currentPosition;
            g(false, 3);
        } else {
            g(false, 2);
        }
        this.bKG.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bKi != null && this.bKh != null && this.bKz != null && this.bKw != null && this.bKx != null && this.bKv != null && this.bKu != null) {
            if (z || this.bKB != i) {
                this.bKB = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKJ);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKI);
                if (i == 2) {
                    this.bKi.setVisibility(8);
                    this.bKF.cancel();
                    this.bKh.clearAnimation();
                    this.bKh.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bMi.setVisibility(0);
                    this.bKw.setVisibility(0);
                    this.bKx.setVisibility(0);
                    this.bKv.setVisibility(8);
                    this.bKu.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKJ, 60000L);
                } else if (i == 3) {
                    this.bKi.setVisibility(8);
                    this.bKh.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bMi.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKu.setVisibility(8);
                } else if (i == 4) {
                    this.bKi.setVisibility(8);
                    this.bKh.startAnimation(this.bKF);
                    this.bKz.setVisibility(8);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKv.setVisibility(0);
                    this.bKu.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKI, 2000L);
                } else {
                    this.bKi.setVisibility(0);
                    this.bMi.setVisibility(0);
                    this.bKF.cancel();
                    this.bKh.clearAnimation();
                    this.bKh.setVisibility(0);
                    this.bKz.setVisibility(0);
                    this.bKw.setVisibility(8);
                    this.bKx.setVisibility(8);
                    this.bKv.setVisibility(8);
                    this.bKu.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.aiU == null || this.aiU.getAuthor() == null) {
            this.bmI.setVisibility(8);
            return;
        }
        this.bmI.setVisibility(0);
        XA();
        this.aiU.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.k(this.aiU.rO()));
        this.mTextTitle.setText(this.aiU.rO());
        this.cxr.O(this.aiU);
        this.bmR.setData(this.aiU);
        if (this.bmR.getHeaderImg() != null) {
            if (this.bmR.getIsSimpleThread()) {
                this.bmR.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (this.aiU.getAuthor() == null || this.aiU.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiU.getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.bmR.getHeaderImg().setVisibility(0);
                this.bmR.getHeaderImg().setData(this.aiU);
            } else {
                this.bmR.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(this.aiU);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bmV.setLayoutParams(layoutParams);
        this.bmR.setUserAfterClickListener(this.anx);
        if (this.bmV.setData(this.aiU)) {
            this.bmW.setVisibility(8);
        } else {
            this.bmW.setVisibility(0);
        }
        this.bKs.setText(am.cX(this.aiU.rF().video_duration.intValue() * 1000));
        this.bKj.setText(String.format(this.abm.getResources().getString(d.l.play_count), am.A(this.aiU.rF().play_count.intValue())));
        this.bmV.setCommentNumClickListener(this);
        this.bJk.setData(this.aiU.sE());
        this.bJk.onChangeSkinType();
        if (m.jm(this.aiU.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
            m.a(this.bJk.getGodReplyContent(), this.aiU.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        d(this.abm, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xy() {
        this.bKG.removeMessages(202);
        this.bKG.removeMessages(203);
    }

    private void Xz() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKI);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKJ);
    }

    private void XA() {
        Xz();
        Xy();
        if (this.bKh != null && this.bKp != null && this.bKq != null) {
            if (com.baidu.tbadk.core.h.oM().oS() && this.aiU != null && this.aiU.rF() != null) {
                this.bKp.setVisibility(0);
                this.bKh.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bKh.c(this.aiU.rF().thumbnail_url, 10, false);
                stopPlay();
                this.aXe = this.aiU.rF().video_url;
                if (StringUtils.isNull(this.aXe)) {
                    g(true, 4);
                    TiebaStatic.log(new ak("c12026").ac("tid", this.aiU.getId()));
                }
                if (this.bMN != null && this.bMN.ben() != null) {
                    this.bMN.ben().d(this.aiU.rF());
                    return;
                }
                return;
            }
            this.bKp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bmI, d.g.addresslist_item_bg);
            aj.c(this.bKi, d.g.btn_icon_play_video_n);
            aj.i(this.bKu, d.e.cp_cont_i);
            aj.i(this.bKs, d.e.cp_cont_i);
            aj.i(this.bKj, d.e.cp_cont_i);
            aj.k(this.bKv, d.e.common_color_10014);
            aj.k(this.aWK, d.e.cp_bg_line_e);
            if (this.bKu != null) {
                this.bKu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bmV.onChangeSkinType();
            this.mSkinType = i;
            this.bmR.onChangeSkinType();
            this.cxr.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bKC;
    }

    public boolean isPlaying() {
        if (this.bKq == null) {
            return false;
        }
        return this.bKq.isPlaying();
    }

    public void startPlay() {
        if (!this.bKC && this.aiU != null && this.aiU.rF() != null && this.bKq != null && w.q(2, this.aXe)) {
            g(true, 2);
            if (TextUtils.isEmpty(this.aXe)) {
                TiebaStatic.log(new ak("c12026").ac("tid", this.aiU.getTid()));
            }
            this.bKq.setVideoPath(this.aXe);
            this.bKq.start();
            this.bKq.setLooping(true);
            if (this.bKE != null) {
                this.bKE.start();
            }
            this.bKC = true;
            Xv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xv() {
        if (this.aiU != null && this.aiU.rF() != null) {
            String str = this.aiU.si() ? "floor5" : "frs";
            x xVar = new x();
            xVar.mLocate = str;
            xVar.cyL = this.aiU.getTid();
            xVar.ayT = this.aiU.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.aiU.Zv;
            xVar.fxN = this.aiU.Zx;
            xVar.fxO = this.aiU.Zw;
            xVar.fxP = "";
            xVar.fxR = this.aiU.rF().video_md5;
            com.baidu.tieba.play.l.a(this.aiU.rF().video_md5, "", "1", xVar);
        }
    }

    public void stopPlay() {
        Xz();
        Xy();
        g(true, 1);
        if (this.bKq != null) {
            this.bKq.stopPlayback();
            if (this.bKE != null) {
                this.bKE.stop();
            }
        }
        this.bKC = false;
    }

    public View getVideoContainer() {
        return this.bKp;
    }

    public String getPlayUrl() {
        return this.aXe;
    }

    public int getCurrentPosition() {
        if (this.bKq == null) {
            return 0;
        }
        return this.bKq.getCurrentPosition();
    }

    public void setVideoStatsData(x xVar) {
        if (this.bMN != null) {
            this.bMN.setVideoStatsData(xVar);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bmV != null && this.bmR != null) {
            this.bmR.setPageUniqueId(bdUniqueId);
        }
    }
}
