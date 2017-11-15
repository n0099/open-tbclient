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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
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
    private g.InterfaceC0124g aWj;
    private g.b aWk;
    private String aXD;
    private View aXj;
    private TbPageContext<?> abI;
    private final View.OnClickListener anz;
    private HeadPendantClickableView bRc;
    public ThreadGodReplyLayout bRd;
    private com.baidu.tieba.NEGFeedBack.c bRe;
    private Handler bSA;
    private TbImageView.a bSB;
    private Runnable bSC;
    private Runnable bSD;
    private QuickVideoView.b bSE;
    private final View.OnClickListener bSF;
    private final View.OnClickListener bSG;
    private CustomMessageListener bSH;
    private j.a bSI;
    private Animation.AnimationListener bSJ;
    private TbImageView bSa;
    private ImageView bSb;
    private TextView bSc;
    private View bSd;
    public FrameLayout bSi;
    private QuickVideoView bSj;
    private com.baidu.tieba.play.n bSk;
    private TextView bSl;
    private LinearLayout bSm;
    private TextView bSn;
    private View bSo;
    private ProgressBar bSp;
    private ImageView bSq;
    private com.baidu.tieba.card.data.n bSr;
    private View bSs;
    private int bSt;
    private int bSu;
    private boolean bSv;
    private boolean bSw;
    private com.baidu.tieba.play.j bSx;
    private Animation bSy;
    private TextView bSz;
    public ThreadUserInfoLayout boI;
    public ThreadCommentAndPraiseInfoLayout boM;
    protected LinearLayout boQ;
    private RelativeLayout boz;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void ZR() {
        if (this.bSr != null && this.bSr.bff != null) {
            com.baidu.tieba.play.x xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = this.bSr.sourceType == 0 ? "index" : "hot_juhe";
            xVar.aMq = this.bSr.bff.getTid();
            xVar.azM = this.bSr.bff.getFid() + "";
            xVar.mUid = TbadkCoreApplication.getCurrentAccount();
            xVar.mSource = this.bSr.bff.ZQ;
            xVar.fHj = this.bSr.bff.ZS;
            xVar.fHk = this.bSr.bff.ZR;
            xVar.fHl = "";
            xVar.Wo = this.bSr.getExtra();
            if (this.bSr.bff.rL() != null) {
                xVar.fHn = this.bSr.bff.rL().video_md5;
            }
            com.baidu.tieba.play.l.a(this.bSr.bff.rL().video_md5, "", "1", xVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bRe = null;
        this.mSkinType = 3;
        this.bSt = 0;
        this.bSu = 1;
        this.bSv = false;
        this.bSw = false;
        this.bSA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.ZS();
                        return;
                    case 203:
                        j.this.ZT();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aWj = new g.InterfaceC0124g() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                if (gVar != null) {
                    try {
                        gVar.setVolume(0.0f, 0.0f);
                        gVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bSA.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aWk = new g.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.bSB = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && j.this.bSa != null) {
                    j.this.bSa.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bSC = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bSj != null && !j.this.bSj.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.bSD = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.bSE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bSF = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.ZJ() != null) {
                    j.this.ZJ().a(view, j.this.bSr);
                }
            }
        };
        this.bSG = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.ZJ() != null) {
                    j.this.ZJ().a(view, j.this.bSr);
                }
            }
        };
        this.bSH = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bSw = false;
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bSr != null && j.this.ZJ() != null) {
                    j.this.ZJ().a(view, j.this.bSr);
                }
            }
        };
        this.bSI = new j.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.j.a
            public void ZX() {
                if (j.this.bSr != null && j.this.bSr.bff != null && j.this.bSr.bff.rL() != null) {
                    j.this.ZR();
                }
            }
        };
        this.bSJ = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bSa != null) {
                    j.this.bSa.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.abI = tbPageContext;
        View view = getView();
        this.boz = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bRc = (HeadPendantClickableView) this.boz.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds70));
        }
        this.bRc.wg();
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.bSp = (ProgressBar) view.findViewById(d.g.auto_video_loading_progress);
        this.bSq = (ImageView) view.findViewById(d.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.boI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.bRe = new com.baidu.tieba.NEGFeedBack.c(this.abI);
        this.bRe.KF();
        this.bRe.setLeftPadding((int) getContext().getResources().getDimension(d.e.ds60));
        this.boI.addView(this.bRe);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this);
        this.boM.setReplyTimeVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setShareVisible(true);
        this.boM.setShareReportFrom(3);
        this.boM.setForumAfterClickListener(this.anz);
        this.boM.setFrom(1);
        this.bSd = view.findViewById(d.g.divider_below_reply_number_layout);
        this.bSi = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bSi.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ac(this.abI.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bSi.setLayoutParams(layoutParams2);
        this.bSa = (TbImageView) view.findViewById(d.g.image_video);
        this.bSa.setDefaultErrorResource(0);
        this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bSa.setGifIconSupport(false);
        this.bSa.setEvent(this.bSB);
        this.bSb = (ImageView) view.findViewById(d.g.image_video_play);
        this.boz.setOnClickListener(this);
        this.bSj = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bSk = new com.baidu.tieba.play.n(this.abI.getPageActivity());
        this.bSj.setBusiness(this.bSk);
        this.bSj.setOnPreparedListener(this.aWj);
        this.bSj.setOnErrorListener(this.aWk);
        this.bSj.setOnSurfaceDestroyedListener(this.bSE);
        this.bSx = new com.baidu.tieba.play.j();
        this.bSx.setPlayer(this.bSj);
        this.bSx.a(this.bSI);
        this.bSl = (TextView) view.findViewById(d.g.text_video_duration);
        this.bSm = (LinearLayout) view.findViewById(d.g.duration_container);
        this.bSc = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bSs = view.findViewById(d.g.auto_video_black_mask);
        this.bSn = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.bSo = view.findViewById(d.g.auto_video_error_background);
        this.boQ = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bSy = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bSy.setAnimationListener(this.bSJ);
        this.bRd = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bRd.setOnClickListener(this);
        this.aXj = view.findViewById(d.g.divider_line);
        this.bSz = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bSr != null && this.bSr.bff != null && this.bSr.bff.aao > 0) {
            if (ZJ() != null) {
                ZJ().a(view, this.bSr);
            }
            this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.abI.getPageActivity(), this.bSr.bff.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, m.rj(), this.bSr.aan())));
        } else if (view == this.boz || view == this.bRd) {
            ag(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void ag(View view) {
        if (ZJ() != null) {
            ZJ().a(view, this.bSr);
        }
        if (this.bSr != null && this.bSr.bff != null) {
            if (!ZN()) {
                m.jL(this.bSr.bff.getId());
                m.a(this.mTextTitle, this.bSr.bff.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abI.getPageActivity()).createFromThreadCfg(this.bSr.bff, null, m.rj(), 18003, true, false, false).addLocateParam(this.bSr.aan());
            addLocateParam.setVideo_source(this.bSr.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bSr.bff.getFid()));
            addLocateParam.setForumName(this.bSr.bff.rz());
            if (this.bSr.bUS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bSr.bUS);
            }
            if (view == this.bRd) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZN() {
        return this.bSr.bVl && !this.bSr.bVz;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bSr = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZS() {
        this.bSA.removeMessages(202);
        if (this.bSj.getCurrentPosition() > 0) {
            f(true, 3);
            this.bSA.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bSA.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZT() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bSA.removeMessages(203);
        int currentPosition = this.bSj.getCurrentPosition();
        if (currentPosition != this.bSt) {
            this.bSt = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bSA.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bSb != null && this.bSa != null && this.bSs != null && this.bSp != null && this.bSq != null && this.bSo != null && this.bSn != null) {
            if (z || this.bSu != i) {
                this.bSu = i;
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSD);
                com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSC);
                if (i == 2) {
                    this.bSb.setVisibility(8);
                    this.bSy.cancel();
                    this.bSa.clearAnimation();
                    this.bSa.setVisibility(0);
                    this.bSs.setVisibility(0);
                    this.bSm.setVisibility(0);
                    this.bSz.setVisibility(8);
                    this.bSp.setVisibility(0);
                    this.bSq.setVisibility(0);
                    this.bSo.setVisibility(8);
                    this.bSn.setVisibility(8);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSD, 60000L);
                } else if (i == 3) {
                    this.bSb.setVisibility(8);
                    this.bSa.startAnimation(this.bSy);
                    this.bSs.setVisibility(8);
                    this.bSm.setVisibility(8);
                    if (this.bSr != null && this.bSr.NA() != null && this.bSr.NA().aao > 0) {
                        this.bSz.setVisibility(0);
                    }
                    this.bSp.setVisibility(8);
                    this.bSq.setVisibility(8);
                    this.bSo.setVisibility(8);
                    this.bSn.setVisibility(8);
                } else if (i == 4) {
                    this.bSb.setVisibility(8);
                    this.bSa.startAnimation(this.bSy);
                    this.bSs.setVisibility(8);
                    this.bSp.setVisibility(8);
                    this.bSq.setVisibility(8);
                    this.bSo.setVisibility(0);
                    this.bSn.setVisibility(0);
                    com.baidu.adp.lib.g.e.fP().postDelayed(this.bSC, 2000L);
                } else {
                    this.bSb.setVisibility(0);
                    this.bSy.cancel();
                    this.bSa.clearAnimation();
                    this.bSa.setVisibility(0);
                    this.bSs.setVisibility(0);
                    this.bSm.setVisibility(0);
                    this.bSp.setVisibility(8);
                    this.bSq.setVisibility(8);
                    this.bSo.setVisibility(8);
                    this.bSn.setVisibility(8);
                }
                if (this.bSr != null && this.bSr.NA() != null && this.bSr.NA().aao > 0) {
                    this.bSm.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.bSr == null || this.bSr.bff == null || this.bSr.bff.rt() == null) {
            this.boz.setVisibility(8);
            return;
        }
        this.boz.setVisibility(0);
        ZW();
        if (!ZN() && m.jM(this.bSr.bff.getId())) {
            m.a(this.mTextTitle, this.bSr.bff.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bRd.getGodReplyContent(), this.bSr.NA().getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.bSr.NA().sc();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bSr.NA().rU()));
        this.boI.setData(this.bSr.NA());
        this.boI.setUserAfterClickListener(this.bSF);
        if (this.boI.getHeaderImg() != null) {
            this.boI.getHeaderImg().setAfterClickListener(this.bSG);
            if (this.boI.getIsSimpleThread()) {
                this.boI.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (this.bSr.NA() == null || this.bSr.NA().rt() == null || this.bSr.NA().rt().getPendantData() == null || StringUtils.isNull(this.bSr.NA().rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.boI.getHeaderImg().setVisibility(0);
                if (this.bSr.NA().aao > 0 && this.bSr.NA().aap == 0) {
                    this.bSr.NA().rt().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.boI.getHeaderImg().a(this.bSr.NA(), false);
                } else {
                    this.boI.getHeaderImg().setData(this.bSr.NA());
                    this.boI.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.boI.getHeaderImg().setVisibility(4);
                this.bRc.setVisibility(0);
                this.bRc.setData(this.bSr.NA());
            }
        }
        if (this.bSr.bff.aao > 0) {
            this.boM.setCommentNumEnable(false);
            this.boM.setShowPraiseNum(false);
            this.boM.setShareVisible(false);
            this.bSz.setText(am.A(this.bSr.bff.aao));
            this.bSz.setVisibility(0);
        } else {
            this.boM.setCommentNumEnable(true);
            this.boM.setShowPraiseNum(true);
            this.boM.setShareVisible(true);
            this.bSz.setVisibility(8);
        }
        if (this.boM.setData(this.bSr.bff)) {
            this.bSd.setVisibility(8);
        } else {
            this.bSd.setVisibility(0);
        }
        this.bSl.setText(am.cX(this.bSr.bff.rL().video_duration.intValue() * 1000));
        this.bSc.setText(String.format(this.abI.getResources().getString(d.j.play_count), am.A(this.bSr.bff.rL().play_count.intValue())));
        if (this.bRe != null && this.bSr.NA() != null) {
            al alVar = new al();
            alVar.cD(this.bSr.NA().getTid());
            alVar.setFid(this.bSr.NA().getFid());
            alVar.a(this.bSr.Xm);
            this.bRe.setData(alVar);
            this.bRe.setFirstRowSingleColumn(true);
        }
        this.bRd.setData(this.bSr.NA().sL());
        this.bRd.onChangeSkinType();
        d(this.abI, TbadkCoreApplication.getInst().getSkinType());
        if (m.jM(this.bSr.bff.getId())) {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0080d.cp_cont_b, 1);
        }
    }

    private void ZU() {
        this.bSA.removeMessages(202);
        this.bSA.removeMessages(203);
    }

    private void ZV() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSC);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.bSD);
    }

    private void ZW() {
        ZV();
        ZU();
        if (this.bSa != null && this.bSi != null && this.bSj != null) {
            if (com.baidu.tbadk.core.h.oT().oZ() && this.bSr != null && this.bSr.bff != null && this.bSr.bff.rL() != null) {
                this.bSa.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bSa.startLoad(this.bSr.bff.rL().thumbnail_url, 10, false);
                this.bSi.setVisibility(0);
                stopPlay();
                this.aXD = this.bSr.bff.rL().video_url;
                if (StringUtils.isNull(this.bSr.bff.rL().video_url)) {
                    f(true, 4);
                }
                if (this.bSk != null && this.bSk.bhG() != null) {
                    this.bSk.bhG().d(this.bSr.bff.rL());
                    return;
                }
                return;
            }
            this.bSi.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.boz, d.f.addresslist_item_bg);
            aj.c(this.bSb, d.f.btn_icon_play_video_n);
            aj.i(this.bSn, d.C0080d.cp_cont_i);
            aj.i(this.bSl, d.C0080d.cp_cont_i);
            aj.i(this.bSc, d.C0080d.cp_cont_i);
            aj.i(this.bSz, d.C0080d.cp_cont_i);
            aj.k(this.bSo, d.C0080d.common_color_10014);
            aj.k(this.aXj, d.C0080d.cp_bg_line_e);
            if (this.bSn != null) {
                this.bSn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bRe != null) {
                this.bRe.onChangeSkinType();
            }
            this.boI.onChangeSkinType();
            this.boM.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bSH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSH);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.boI != null) {
            this.boI.setPageUniqueId(bdUniqueId);
        }
        if (this.bSa != null) {
            this.bSa.setPageId(bdUniqueId);
        }
        if (this.bRe != null) {
            this.bRe.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bSv;
    }

    public boolean isPlaying() {
        if (this.bSj == null) {
            return false;
        }
        return this.bSj.isPlaying();
    }

    public void startPlay() {
        if (!this.bSv && this.bSr != null && this.bSr.bff != null && this.bSr.bff.rL() != null && this.bSj != null && y.q(1, this.aXD)) {
            f(true, 2);
            if (StringUtils.isNull(this.aXD)) {
                TiebaStatic.log(new ak("c12619").ac("obj_locate", "index").ac("tid", this.bSr.Xl));
                this.aXD = this.bSr.bff.rL().video_url;
            }
            this.bSj.bM(this.aXD, this.bSr.Xl);
            this.bSj.start();
            this.bSj.setLooping(true);
            if (this.bSx != null) {
                this.bSx.start();
            }
            this.bSv = true;
            ZR();
        }
    }

    public void stopPlay() {
        ZV();
        ZU();
        f(true, 1);
        if (this.bSj != null) {
            this.bSj.stopPlayback();
            if (this.bSx != null) {
                this.bSx.stop();
            }
        }
        this.bSv = false;
    }

    public View getVideoContainer() {
        return this.bSi;
    }

    public String getPlayUrl() {
        return this.aXD;
    }

    public int getCurrentPosition() {
        if (this.bSj == null) {
            return 0;
        }
        return this.bSj.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.x xVar) {
        if (this.bSk != null) {
            this.bSk.setVideoStatsData(xVar);
        }
    }

    public void a(c.a aVar) {
        if (this.bRe != null) {
            this.bRe.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.boI != null) {
            return this.boI.anM;
        }
        return null;
    }

    public View ZM() {
        if (this.boI != null) {
            return this.boI.anN;
        }
        return null;
    }
}
