package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.n> implements View.OnClickListener {
    private g.InterfaceC0121g aWb;
    private g.b aWc;
    private View aXa;
    private String aXu;
    private TbPageContext<?> abI;
    private final View.OnClickListener anA;
    private HeadPendantClickableView bQP;
    public ThreadGodReplyLayout bQQ;
    private com.baidu.tieba.NEGFeedBack.c bQR;
    private TbImageView bRN;
    private ImageView bRO;
    private TextView bRP;
    private View bRQ;
    public FrameLayout bRV;
    private QuickVideoView bRW;
    private com.baidu.tieba.play.n bRX;
    private TextView bRY;
    private LinearLayout bRZ;
    private TextView bSa;
    private View bSb;
    private ProgressBar bSc;
    private ImageView bSd;
    private com.baidu.tieba.card.data.n bSe;
    private View bSf;
    private int bSg;
    private int bSh;
    private boolean bSi;
    private boolean bSj;
    private com.baidu.tieba.play.j bSk;
    private Animation bSl;
    private TextView bSm;
    private Handler bSn;
    private TbImageView.a bSo;
    private Runnable bSp;
    private Runnable bSq;
    private QuickVideoView.b bSr;
    private final View.OnClickListener bSs;
    private final View.OnClickListener bSt;
    private CustomMessageListener bSu;
    private j.a bSv;
    private Animation.AnimationListener bSw;
    public ThreadCommentAndPraiseInfoLayout boD;
    protected LinearLayout boH;
    private RelativeLayout boq;
    public ThreadUserInfoLayout boz;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void ZF() {
        if (this.bSe != null && this.bSe.beV != null) {
            com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = this.bSe.sourceType == 0 ? "index" : "hot_juhe";
            xVar.aMi = this.bSe.beV.getTid();
            xVar.azE = this.bSe.beV.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.bSe.beV.ZQ;
            xVar.fGE = this.bSe.beV.ZS;
            xVar.fGF = this.bSe.beV.ZR;
            xVar.fGG = "";
            xVar.Wo = this.bSe.getExtra();
            if (this.bSe.beV.rL() != null) {
                xVar.fGI = this.bSe.beV.rL().video_md5;
            }
            com.baidu.tieba.play.l.a(this.bSe.beV.rL().video_md5, "", "1", xVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bQR = null;
        this.mSkinType = 3;
        this.bSg = 0;
        this.bSh = 1;
        this.bSi = false;
        this.bSj = false;
        this.bSn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.ZG();
                        return;
                    case 203:
                        j.this.ZH();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aWb = new g.InterfaceC0121g() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bSn.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aWc = new g.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.bSo = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && j.this.bRN != null) {
                    j.this.bRN.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bSp = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bRW != null && !j.this.bRW.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.bSq = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.bSr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bSs = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Zx() != null) {
                    j.this.Zx().a(view, j.this.bSe);
                }
            }
        };
        this.bSt = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.Zx() != null) {
                    j.this.Zx().a(view, j.this.bSe);
                }
            }
        };
        this.bSu = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bSj = false;
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bSe != null && j.this.Zx() != null) {
                    j.this.Zx().a(view, j.this.bSe);
                }
            }
        };
        this.bSv = new j.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.j.a
            public void ZL() {
                if (j.this.bSe != null && j.this.bSe.beV != null && j.this.bSe.beV.rL() != null) {
                    j.this.ZF();
                }
            }
        };
        this.bSw = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bRN != null) {
                    j.this.bRN.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.abI = tbPageContext;
        View view = getView();
        this.boq = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bQP = (HeadPendantClickableView) this.boq.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds70));
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.bSc = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.bSd = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.boz = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bQR = new com.baidu.tieba.NEGFeedBack.c(this.abI);
        this.bQR.Ku();
        this.bQR.setLeftPadding((int) getContext().getResources().getDimension(d.e.ds60));
        this.boz.addView(this.bQR);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setShareVisible(true);
        this.boD.setShareReportFrom(3);
        this.boD.setForumAfterClickListener(this.anA);
        this.boD.setFrom(1);
        this.bRQ = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bRV = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bRV.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bRV.setLayoutParams(layoutParams2);
        this.bRN = (TbImageView) view.findViewById(d.g.image_video);
        this.bRN.setDefaultErrorResource(0);
        this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bRN.setGifIconSupport(false);
        this.bRN.setEvent(this.bSo);
        this.bRO = (ImageView) view.findViewById(d.g.image_video_play);
        this.boq.setOnClickListener(this);
        this.bRW = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bRX = new com.baidu.tieba.play.n(this.abI.getPageActivity());
        this.bRW.setBusiness(this.bRX);
        this.bRW.setOnPreparedListener(this.aWb);
        this.bRW.setOnErrorListener(this.aWc);
        this.bRW.setOnSurfaceDestroyedListener(this.bSr);
        this.bSk = new com.baidu.tieba.play.j();
        this.bSk.setPlayer(this.bRW);
        this.bSk.a(this.bSv);
        this.bRY = (TextView) view.findViewById(d.g.text_video_duration);
        this.bRZ = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bRP = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bSf = view.findViewById(d.g.auto_video_black_mask);
        this.bSa = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bSb = view.findViewById(d.g.auto_video_error_background);
        this.boH = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bSl = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bSl.setAnimationListener(this.bSw);
        this.bQQ = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bQQ.setOnClickListener(this);
        this.aXa = view.findViewById(d.g.divider_line);
        this.bSm = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bSe != null && this.bSe.beV != null && this.bSe.beV.aao > 0) {
            if (Zx() != null) {
                Zx().a(view, this.bSe);
            }
            this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.abI.getPageActivity(), this.bSe.beV.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.rj(), this.bSe.aab())));
        } else if (view == this.boq || view == this.bQQ) {
            ag(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void ag(View view) {
        if (Zx() != null) {
            Zx().a(view, this.bSe);
        }
        if (this.bSe != null && this.bSe.beV != null) {
            if (!ZB()) {
                m.jK(this.bSe.beV.getId());
                m.a(this.mTextTitle, this.bSe.beV.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abI.getPageActivity()).createFromThreadCfg(this.bSe.beV, null, m.rj(), 18003, true, false, false).addLocateParam(this.bSe.aab());
            addLocateParam.setVideo_source(this.bSe.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bSe.beV.getFid()));
            addLocateParam.setForumName(this.bSe.beV.rz());
            if (this.bSe.bUF == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bSe.bUF);
            }
            if (view == this.bQQ) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZB() {
        return this.bSe.bUY && !this.bSe.bVm;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bSe = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZG() {
        this.bSn.removeMessages(202);
        if (this.bRW.getCurrentPosition() > 0) {
            f(true, 3);
            this.bSn.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bSn.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZH() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bSn.removeMessages(203);
        int currentPosition = this.bRW.getCurrentPosition();
        if (currentPosition != this.bSg) {
            this.bSg = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bSn.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bRO != null && this.bRN != null && this.bSf != null && this.bSc != null && this.bSd != null && this.bSb != null && this.bSa != null) {
            if (z || this.bSh != i) {
                this.bSh = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSq);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSp);
                if (i == 2) {
                    this.bRO.setVisibility(8);
                    this.bSl.cancel();
                    this.bRN.clearAnimation();
                    this.bRN.setVisibility(0);
                    this.bSf.setVisibility(0);
                    this.bRZ.setVisibility(0);
                    this.bSm.setVisibility(8);
                    this.bSc.setVisibility(0);
                    this.bSd.setVisibility(0);
                    this.bSb.setVisibility(8);
                    this.bSa.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSq, 60000L);
                } else if (i == 3) {
                    this.bRO.setVisibility(8);
                    this.bRN.startAnimation(this.bSl);
                    this.bSf.setVisibility(8);
                    this.bRZ.setVisibility(8);
                    if (this.bSe != null && this.bSe.Np() != null && this.bSe.Np().aao > 0) {
                        this.bSm.setVisibility(0);
                    }
                    this.bSc.setVisibility(8);
                    this.bSd.setVisibility(8);
                    this.bSb.setVisibility(8);
                    this.bSa.setVisibility(8);
                } else if (i == 4) {
                    this.bRO.setVisibility(8);
                    this.bRN.startAnimation(this.bSl);
                    this.bSf.setVisibility(8);
                    this.bSc.setVisibility(8);
                    this.bSd.setVisibility(8);
                    this.bSb.setVisibility(0);
                    this.bSa.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSp, 2000L);
                } else {
                    this.bRO.setVisibility(0);
                    this.bSl.cancel();
                    this.bRN.clearAnimation();
                    this.bRN.setVisibility(0);
                    this.bSf.setVisibility(0);
                    this.bRZ.setVisibility(0);
                    this.bSc.setVisibility(8);
                    this.bSd.setVisibility(8);
                    this.bSb.setVisibility(8);
                    this.bSa.setVisibility(8);
                }
                if (this.bSe != null && this.bSe.Np() != null && this.bSe.Np().aao > 0) {
                    this.bRZ.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.bSe == null || this.bSe.beV == null || this.bSe.beV.rt() == null) {
            this.boq.setVisibility(8);
            return;
        }
        this.boq.setVisibility(0);
        ZK();
        if (!ZB() && m.jL(this.bSe.beV.getId())) {
            m.a(this.mTextTitle, this.bSe.beV.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bQQ.getGodReplyContent(), this.bSe.Np().getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.bSe.Np().sc();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bSe.Np().rU()));
        this.boz.setData(this.bSe.Np());
        this.boz.setUserAfterClickListener(this.bSs);
        if (this.boz.getHeaderImg() != null) {
            this.boz.getHeaderImg().setAfterClickListener(this.bSt);
            if (this.boz.getIsSimpleThread()) {
                this.boz.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (this.bSe.Np() == null || this.bSe.Np().rt() == null || this.bSe.Np().rt().getPendantData() == null || StringUtils.isNull(this.bSe.Np().rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.boz.getHeaderImg().setVisibility(0);
                if (this.bSe.Np().aao > 0 && this.bSe.Np().aap == 0) {
                    this.bSe.Np().rt().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.boz.getHeaderImg().a(this.bSe.Np(), false);
                } else {
                    this.boz.getHeaderImg().setData(this.bSe.Np());
                    this.boz.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.boz.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(this.bSe.Np());
            }
        }
        if (this.bSe.beV.aao > 0) {
            this.boD.setCommentNumEnable(false);
            this.boD.setShowPraiseNum(false);
            this.boD.setShareVisible(false);
            this.bSm.setText(am.A(this.bSe.beV.aao));
            this.bSm.setVisibility(0);
        } else {
            this.boD.setCommentNumEnable(true);
            this.boD.setShowPraiseNum(true);
            this.boD.setShareVisible(true);
            this.bSm.setVisibility(8);
        }
        if (this.boD.setData(this.bSe.beV)) {
            this.bRQ.setVisibility(8);
        } else {
            this.bRQ.setVisibility(0);
        }
        this.bRY.setText(am.cY(this.bSe.beV.rL().video_duration.intValue() * 1000));
        this.bRP.setText(String.format(this.abI.getResources().getString(d.j.play_count), am.A(this.bSe.beV.rL().play_count.intValue())));
        if (this.bQR != null && this.bSe.Np() != null) {
            al alVar = new al();
            alVar.cD(this.bSe.Np().getTid());
            alVar.setFid(this.bSe.Np().getFid());
            alVar.a(this.bSe.Xm);
            this.bQR.setData(alVar);
            this.bQR.setFirstRowSingleColumn(true);
        }
        this.bQQ.setData(this.bSe.Np().sL());
        this.bQQ.onChangeSkinType();
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
        if (m.jL(this.bSe.beV.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
    }

    private void ZI() {
        this.bSn.removeMessages(202);
        this.bSn.removeMessages(203);
    }

    private void ZJ() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSp);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSq);
    }

    private void ZK() {
        ZJ();
        ZI();
        if (this.bRN != null && this.bRV != null && this.bRW != null) {
            if (com.baidu.tbadk.core.h.oT().oZ() && this.bSe != null && this.bSe.beV != null && this.bSe.beV.rL() != null) {
                this.bRN.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bRN.startLoad(this.bSe.beV.rL().thumbnail_url, 10, false);
                this.bRV.setVisibility(0);
                stopPlay();
                this.aXu = this.bSe.beV.rL().video_url;
                if (StringUtils.isNull(this.bSe.beV.rL().video_url)) {
                    f(true, 4);
                }
                if (this.bRX != null && this.bRX.bhy() != null) {
                    this.bRX.bhy().d(this.bSe.beV.rL());
                    return;
                }
                return;
            }
            this.bRV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.boq, d.f.addresslist_item_bg);
            aj.c(this.bRO, d.f.btn_icon_play_video_n);
            aj.i(this.bSa, d.C0080d.cp_cont_i);
            aj.i(this.bRY, d.C0080d.cp_cont_i);
            aj.i(this.bRP, d.C0080d.cp_cont_i);
            aj.i(this.bSm, d.C0080d.cp_cont_i);
            aj.k(this.bSb, d.C0080d.common_color_10014);
            aj.k(this.aXa, d.C0080d.cp_bg_line_e);
            if (this.bSa != null) {
                this.bSa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bQR != null) {
                this.bQR.onChangeSkinType();
            }
            this.boz.onChangeSkinType();
            this.boD.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bSu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSu);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.boz != null) {
            this.boz.setPageUniqueId(bdUniqueId);
        }
        if (this.bRN != null) {
            this.bRN.setPageId(bdUniqueId);
        }
        if (this.bQR != null) {
            this.bQR.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bSi;
    }

    public boolean isPlaying() {
        if (this.bRW == null) {
            return false;
        }
        return this.bRW.isPlaying();
    }

    public void startPlay() {
        if (!this.bSi && this.bSe != null && this.bSe.beV != null && this.bSe.beV.rL() != null && this.bRW != null && y.q(1, this.aXu)) {
            f(true, 2);
            this.bRW.bL(this.aXu, this.bSe.Xl);
            this.bRW.start();
            this.bRW.setLooping(true);
            if (this.bSk != null) {
                this.bSk.start();
            }
            this.bSi = true;
            ZF();
        }
    }

    public void stopPlay() {
        ZJ();
        ZI();
        f(true, 1);
        if (this.bRW != null) {
            this.bRW.stopPlayback();
            if (this.bSk != null) {
                this.bSk.stop();
            }
        }
        this.bSi = false;
    }

    public View getVideoContainer() {
        return this.bRV;
    }

    public String getPlayUrl() {
        return this.aXu;
    }

    public int getCurrentPosition() {
        if (this.bRW == null) {
            return 0;
        }
        return this.bRW.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.x xVar) {
        if (this.bRX != null) {
            this.bRX.setVideoStatsData(xVar);
        }
    }

    public void a(c.a aVar) {
        if (this.bQR != null) {
            this.bQR.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.boz != null) {
            return this.boz.anN;
        }
        return null;
    }

    public View ZA() {
        if (this.boz != null) {
            return this.boz.anO;
        }
        return null;
    }
}
