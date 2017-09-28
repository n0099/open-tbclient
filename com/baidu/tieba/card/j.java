package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.n> {
    private View aWX;
    private g.f aWe;
    private g.b aWf;
    private String aXr;
    private TbPageContext<?> abz;
    private final View.OnClickListener anr;
    private HeadPendantClickableView bJv;
    private ThreadGodReplyLayout bJw;
    private com.baidu.tieba.NEGFeedBack.c bJx;
    public FrameLayout bKB;
    private QuickVideoView bKC;
    private com.baidu.tieba.play.n bKD;
    private TextView bKE;
    private LinearLayout bKF;
    private TextView bKG;
    private View bKH;
    private ProgressBar bKI;
    private ImageView bKJ;
    private com.baidu.tieba.card.data.n bKK;
    private View bKL;
    private int bKM;
    private int bKN;
    private boolean bKO;
    private boolean bKP;
    private com.baidu.tieba.play.j bKQ;
    private Animation bKR;
    private Handler bKS;
    private TbImageView.a bKT;
    private Runnable bKU;
    private Runnable bKV;
    private QuickVideoView.b bKW;
    private final View.OnClickListener bKX;
    private final View.OnClickListener bKY;
    private CustomMessageListener bKZ;
    private TbImageView bKt;
    private ImageView bKu;
    private TextView bKv;
    private View bKw;
    private j.a bLa;
    private Animation.AnimationListener bLb;
    private RelativeLayout bmW;
    public ThreadUserInfoLayout bnf;
    public ThreadCommentAndPraiseInfoLayout bnj;
    protected LinearLayout bnn;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void Xz() {
        if (this.bKK != null && this.bKK.bes != null) {
            com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = this.bKK.sourceType == 0 ? "index" : "hot_juhe";
            xVar.cyX = this.bKK.bes.getTid();
            xVar.azf = this.bKK.bes.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.bKK.bes.ZH;
            xVar.fyc = this.bKK.bes.ZJ;
            xVar.fyd = this.bKK.bes.ZI;
            xVar.fye = "";
            xVar.Wi = this.bKK.getExtra();
            if (this.bKK.bes.rM() != null) {
                xVar.fyg = this.bKK.bes.rM().video_md5;
            }
            com.baidu.tieba.play.l.a(this.bKK.bes.rM().video_md5, "", "1", xVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJx = null;
        this.mSkinType = 3;
        this.bKM = 0;
        this.bKN = 1;
        this.bKO = false;
        this.bKP = false;
        this.bKS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.XA();
                        return;
                    case 203:
                        j.this.XB();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aWe = new g.f() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bKS.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aWf = new g.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.g(true, 4);
                return true;
            }
        };
        this.bKT = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && j.this.bKt != null) {
                    j.this.bKt.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bKU = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bKC != null && !j.this.bKC.isPlaying()) {
                    j.this.g(true, 1);
                }
            }
        };
        this.bKV = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.g(true, 4);
            }
        };
        this.bKW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bKX = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xr() != null) {
                    j.this.Xr().a(view, j.this.bKK);
                }
            }
        };
        this.bKY = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Xr() != null) {
                    j.this.Xr().a(view, j.this.bKK);
                }
            }
        };
        this.bKZ = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bKP = false;
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bKK != null && j.this.Xr() != null) {
                    j.this.Xr().a(view, j.this.bKK);
                }
            }
        };
        this.bLa = new j.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.j.a
            public void XF() {
                if (j.this.bKK != null && j.this.bKK.bes != null && j.this.bKK.bes.rM() != null) {
                    j.this.Xz();
                }
            }
        };
        this.bLb = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bKt != null) {
                    j.this.bKt.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.abz = tbPageContext;
        View view = getView();
        this.bmW = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bJv = (HeadPendantClickableView) this.bmW.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bJv.getHeadView() != null) {
            this.bJv.getHeadView().setIsRound(true);
            this.bJv.getHeadView().setDrawBorder(false);
            this.bJv.getHeadView().setDefaultResource(17170445);
            this.bJv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJv.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abz.getPageActivity(), d.f.ds70));
        }
        this.bJv.wg();
        if (this.bJv.getPendantView() != null) {
            this.bJv.getPendantView().setIsRound(true);
            this.bJv.getPendantView().setDrawBorder(false);
        }
        this.bKI = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bKJ = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bnf = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bJx = new com.baidu.tieba.NEGFeedBack.c(this.abz);
        this.bJx.Kr();
        this.bJx.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bnf.addView(this.bJx);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bnj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bnj.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bnj.setLayoutParams(layoutParams);
        }
        this.bnj.setOnClickListener(this);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setNeedAddReplyIcon(true);
        this.bnj.setShareVisible(true);
        this.bnj.setShareReportFrom(3);
        this.bnj.setForumAfterClickListener(this.anr);
        this.bnj.setFrom(1);
        this.bKw = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bKB = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bKB.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ad(this.abz.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abz.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bKB.setLayoutParams(layoutParams2);
        this.bKt = (TbImageView) view.findViewById(d.h.image_video);
        this.bKt.setDefaultErrorResource(0);
        this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKt.setGifIconSupport(false);
        this.bKt.setEvent(this.bKT);
        this.bKu = (ImageView) view.findViewById(d.h.image_video_play);
        this.bmW.setOnClickListener(this);
        this.bKC = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bKD = new com.baidu.tieba.play.n(this.abz.getPageActivity());
        this.bKC.setBusiness(this.bKD);
        this.bKC.setOnPreparedListener(this.aWe);
        this.bKC.setOnErrorListener(this.aWf);
        this.bKC.setOnSurfaceDestroyedListener(this.bKW);
        this.bKQ = new com.baidu.tieba.play.j();
        this.bKQ.setPlayer(this.bKC);
        this.bKQ.a(this.bLa);
        this.bKE = (TextView) view.findViewById(d.h.text_video_duration);
        this.bKF = (LinearLayout) view.findViewById(d.h.duration_container);
        this.bKv = (TextView) view.findViewById(d.h.text_video_play_count);
        this.bKL = view.findViewById(d.h.auto_video_black_mask);
        this.bKG = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bKH = view.findViewById(d.h.auto_video_error_background);
        this.bnn = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bKR = AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bKR.setAnimationListener(this.bLb);
        this.bJw = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bJw.setOnClickListener(this);
        this.aWX = view.findViewById(d.h.divider_line);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmW || view == this.bJw) {
            ad(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void ad(View view) {
        if (Xr() != null) {
            Xr().a(view, this.bKK);
        }
        if (this.bKK != null && this.bKK.bes != null) {
            if (!Xv()) {
                m.jn(this.bKK.bes.getId());
                m.a(this.mTextTitle, this.bKK.bes.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abz.getPageActivity()).createFromThreadCfg(this.bKK.bes, null, m.rm(), 18003, true, false, false).addLocateParam(this.bKK.XV());
            addLocateParam.setVideo_source(this.bKK.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bKK.bes.getFid()));
            addLocateParam.setForumName(this.bKK.bes.rA());
            if (this.bKK.bNn == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKK.bNn);
            }
            if (view == this.bJw) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xv() {
        return this.bKK.bNG && !this.bKK.bNU;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bKK = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XA() {
        this.bKS.removeMessages(202);
        if (this.bKC.getCurrentPosition() > 0) {
            g(true, 3);
            this.bKS.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bKS.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XB() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bKS.removeMessages(203);
        int currentPosition = this.bKC.getCurrentPosition();
        if (currentPosition != this.bKM) {
            this.bKM = currentPosition;
            g(false, 3);
        } else {
            g(false, 2);
        }
        this.bKS.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bKu != null && this.bKt != null && this.bKL != null && this.bKI != null && this.bKJ != null && this.bKH != null && this.bKG != null) {
            if (z || this.bKN != i) {
                this.bKN = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKV);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKU);
                if (i == 2) {
                    this.bKu.setVisibility(8);
                    this.bKR.cancel();
                    this.bKt.clearAnimation();
                    this.bKt.setVisibility(0);
                    this.bKL.setVisibility(0);
                    this.bKF.setVisibility(0);
                    this.bKI.setVisibility(0);
                    this.bKJ.setVisibility(0);
                    this.bKH.setVisibility(8);
                    this.bKG.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKV, 60000L);
                } else if (i == 3) {
                    this.bKu.setVisibility(8);
                    this.bKt.startAnimation(this.bKR);
                    this.bKL.setVisibility(8);
                    this.bKF.setVisibility(8);
                    this.bKI.setVisibility(8);
                    this.bKJ.setVisibility(8);
                    this.bKH.setVisibility(8);
                    this.bKG.setVisibility(8);
                } else if (i == 4) {
                    this.bKu.setVisibility(8);
                    this.bKt.startAnimation(this.bKR);
                    this.bKL.setVisibility(8);
                    this.bKI.setVisibility(8);
                    this.bKJ.setVisibility(8);
                    this.bKH.setVisibility(0);
                    this.bKG.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bKU, 2000L);
                } else {
                    this.bKu.setVisibility(0);
                    this.bKR.cancel();
                    this.bKt.clearAnimation();
                    this.bKt.setVisibility(0);
                    this.bKL.setVisibility(0);
                    this.bKF.setVisibility(0);
                    this.bKI.setVisibility(8);
                    this.bKJ.setVisibility(8);
                    this.bKH.setVisibility(8);
                    this.bKG.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.bKK == null || this.bKK.bes == null || this.bKK.bes.getAuthor() == null) {
            this.bmW.setVisibility(8);
            return;
        }
        this.bmW.setVisibility(0);
        XE();
        if (!Xv() && m.jo(this.bKK.bes.getId())) {
            m.a(this.mTextTitle, this.bKK.bes.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bJw.getGodReplyContent(), this.bKK.Nj().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bKK.Nj().sd();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bKK.Nj().rV()));
        this.bnf.setData(this.bKK.Nj());
        this.bnf.setUserAfterClickListener(this.bKX);
        if (this.bnf.getHeaderImg() != null) {
            this.bnf.getHeaderImg().setAfterClickListener(this.bKY);
            if (this.bnf.getIsSimpleThread()) {
                this.bnf.getHeaderImg().setVisibility(8);
                this.bJv.setVisibility(8);
            } else if (this.bKK.Nj() == null || this.bKK.Nj().getAuthor() == null || this.bKK.Nj().getAuthor().getPendantData() == null || StringUtils.isNull(this.bKK.Nj().getAuthor().getPendantData().pS())) {
                this.bJv.setVisibility(8);
                this.bnf.getHeaderImg().setVisibility(0);
                this.bnf.getHeaderImg().setData(this.bKK.Nj());
            } else {
                this.bnf.getHeaderImg().setVisibility(4);
                this.bJv.setVisibility(0);
                this.bJv.setData(this.bKK.Nj());
            }
        }
        if (this.bnj.setData(this.bKK.bes)) {
            this.bKw.setVisibility(8);
        } else {
            this.bKw.setVisibility(0);
        }
        this.bKE.setText(am.cY(this.bKK.bes.rM().video_duration.intValue() * 1000));
        this.bKv.setText(String.format(this.abz.getResources().getString(d.l.play_count), am.z(this.bKK.bes.rM().play_count.intValue())));
        if (this.bJx != null && this.bKK.Nj() != null) {
            al alVar = new al();
            alVar.cy(this.bKK.Nj().getTid());
            alVar.setFid(this.bKK.Nj().getFid());
            alVar.a(this.bKK.Xg);
            this.bJx.setData(alVar);
            this.bJx.setFirstRowSingleColumn(true);
        }
        this.bJw.setData(this.bKK.Nj().sL());
        this.bJw.onChangeSkinType();
        d(this.abz, TbadkCoreApplication.getInst().getSkinType());
        if (m.jo(this.bKK.bes.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void XC() {
        this.bKS.removeMessages(202);
        this.bKS.removeMessages(203);
    }

    private void XD() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bKV);
    }

    private void XE() {
        XD();
        XC();
        if (this.bKt != null && this.bKB != null && this.bKC != null) {
            if (com.baidu.tbadk.core.h.oT().oZ() && this.bKK != null && this.bKK.bes != null && this.bKK.bes.rM() != null) {
                this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bKt.c(this.bKK.bes.rM().thumbnail_url, 10, false);
                this.bKB.setVisibility(0);
                stopPlay();
                this.aXr = this.bKK.bes.rM().video_url;
                if (StringUtils.isNull(this.bKK.bes.rM().video_url)) {
                    g(true, 4);
                }
                if (this.bKD != null && this.bKD.bet() != null) {
                    this.bKD.bet().d(this.bKK.bes.rM());
                    return;
                }
                return;
            }
            this.bKB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bmW, d.g.addresslist_item_bg);
            aj.c(this.bKu, d.g.btn_icon_play_video_n);
            aj.i(this.bKG, d.e.cp_cont_i);
            aj.i(this.bKE, d.e.cp_cont_i);
            aj.i(this.bKv, d.e.cp_cont_i);
            aj.k(this.bKH, d.e.common_color_10014);
            aj.k(this.aWX, d.e.cp_bg_line_e);
            if (this.bKG != null) {
                this.bKG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bJx != null) {
                this.bJx.onChangeSkinType();
            }
            this.bnf.onChangeSkinType();
            this.bnj.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bKZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKZ);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bnf != null) {
            this.bnf.setPageUniqueId(bdUniqueId);
        }
        if (this.bKt != null) {
            this.bKt.setPageId(bdUniqueId);
        }
        if (this.bJx != null) {
            this.bJx.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bKO;
    }

    public boolean isPlaying() {
        if (this.bKC == null) {
            return false;
        }
        return this.bKC.isPlaying();
    }

    public void startPlay() {
        if (!this.bKO && this.bKK != null && this.bKK.bes != null && this.bKK.bes.rM() != null && this.bKC != null && com.baidu.tbadk.util.w.q(1, this.aXr)) {
            g(true, 2);
            if (TextUtils.isEmpty(this.aXr)) {
                TiebaStatic.log(new ak("c12026").ad("tid", this.bKK.Xf));
            }
            this.bKC.setVideoPath(this.aXr);
            this.bKC.start();
            this.bKC.setLooping(true);
            if (this.bKQ != null) {
                this.bKQ.start();
            }
            this.bKO = true;
            Xz();
        }
    }

    public void stopPlay() {
        XD();
        XC();
        g(true, 1);
        if (this.bKC != null) {
            this.bKC.stopPlayback();
            if (this.bKQ != null) {
                this.bKQ.stop();
            }
        }
        this.bKO = false;
    }

    public View getVideoContainer() {
        return this.bKB;
    }

    public String getPlayUrl() {
        return this.aXr;
    }

    public int getCurrentPosition() {
        if (this.bKC == null) {
            return 0;
        }
        return this.bKC.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.x xVar) {
        if (this.bKD != null) {
            this.bKD.setVideoStatsData(xVar);
        }
    }

    public void a(c.a aVar) {
        if (this.bJx != null) {
            this.bJx.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bnf != null) {
            return this.bnf.anE;
        }
        return null;
    }

    public View Xu() {
        if (this.bnf != null) {
            return this.bnf.anF;
        }
        return null;
    }
}
