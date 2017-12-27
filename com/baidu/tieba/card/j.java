package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.y;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class j extends a<n> implements View.OnClickListener {
    private TbPageContext<?> aQq;
    private g.f bNf;
    private g.b bNg;
    private View bOc;
    private String bOw;
    private com.baidu.tieba.play.j bYB;
    private com.baidu.tieba.play.n bYC;
    private QuickVideoView.b bYH;
    private ImageView bYm;
    private Animation bYq;
    private final View.OnClickListener bbR;
    private HeadPendantClickableView cNO;
    public ThreadGodReplyLayout cNP;
    private TbImageView cOK;
    private TextView cOL;
    private View cOM;
    public FrameLayout cOR;
    private QuickVideoView cOS;
    private com.baidu.tieba.play.g cOT;
    private TextView cOU;
    private LinearLayout cOV;
    private TextView cOW;
    private View cOX;
    private y cOY;
    private n cOZ;
    private View cPa;
    private int cPb;
    private int cPc;
    private boolean cPd;
    private boolean cPe;
    private boolean cPf;
    private TextView cPg;
    private Handler cPh;
    private VideoLoadingProgressView.a cPi;
    private TbImageView.a cPj;
    private Runnable cPk;
    private Runnable cPl;
    private final View.OnClickListener cPm;
    private final View.OnClickListener cPn;
    private CustomMessageListener cPo;
    private j.a cPp;
    private Animation.AnimationListener cPq;
    private RelativeLayout ciC;
    public ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    private com.baidu.tieba.NEGFeedBack.c ciP;
    protected LinearLayout cjA;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void ajg() {
        if (this.cOT != null) {
            try {
                this.cOS.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        if (this.cOZ != null && this.cOZ.bWT != null) {
            aa aaVar = new aa();
            aaVar.mLocate = this.cOZ.sourceType == 0 ? "index" : "hot_juhe";
            aaVar.bAK = this.cOZ.bWT.getTid();
            aaVar.cSk = this.cOZ.bWT.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.cOZ.bWT.mRecomSource;
            aaVar.gEO = this.cOZ.bWT.mRecomAbTag;
            aaVar.gEP = this.cOZ.bWT.mRecomWeight;
            aaVar.gEQ = "";
            aaVar.aLg = this.cOZ.getExtra();
            if (this.cOZ.bWT.zp() != null) {
                aaVar.gES = this.cOZ.bWT.zp().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cOZ.bWT.zp().video_md5, "", "1", aaVar);
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciP = null;
        this.mSkinType = 3;
        this.cPb = 0;
        this.cPc = 1;
        this.cPd = false;
        this.cPe = true;
        this.cPf = false;
        this.cPh = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case HttpStatus.SC_ACCEPTED /* 202 */:
                        j.this.ajj();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        j.this.ajk();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bNf = new g.f() { // from class: com.baidu.tieba.card.j.9
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                j.this.cOT = gVar;
                if (j.this.cOT != null) {
                    j.this.cOT.setVolume(0.0f, 0.0f);
                }
                j.this.cOY.bri();
            }
        };
        this.bNg = new g.b() { // from class: com.baidu.tieba.card.j.10
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                j.this.i(true, 4);
                return true;
            }
        };
        this.cPi = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                j.this.ajg();
            }
        };
        this.cPj = new TbImageView.a() { // from class: com.baidu.tieba.card.j.12
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && j.this.cOK != null) {
                    j.this.cOK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cPk = new Runnable() { // from class: com.baidu.tieba.card.j.15
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.cOS != null && !j.this.cOS.isPlaying()) {
                    j.this.i(true, 1);
                }
            }
        };
        this.cPl = new Runnable() { // from class: com.baidu.tieba.card.j.16
            @Override // java.lang.Runnable
            public void run() {
                j.this.i(true, 4);
            }
        };
        this.bYH = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.2
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.cPm = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aiY() != null) {
                    j.this.aiY().a(view, j.this.cOZ);
                }
            }
        };
        this.cPn = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aiY() != null) {
                    j.this.aiY().a(view, j.this.cOZ);
                }
            }
        };
        this.cPo = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.cPf = false;
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.cOZ != null) {
                    if (j.this.aiY() != null) {
                        j.this.aiY().a(view, j.this.cOZ);
                    }
                    if (j.this.cOZ.bWT != null) {
                        k.jT(j.this.cOZ.bWT.getId());
                        if (!j.this.ajc()) {
                            k.a(j.this.mTextTitle, j.this.cOZ.bWT.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                            k.a(j.this.cNP.getGodReplyContent(), j.this.cOZ.VW().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cPp = new j.a() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.j.a
            public void ajo() {
                if (j.this.cOZ != null && j.this.cOZ.bWT != null && j.this.cOZ.bWT.zp() != null) {
                    j.this.ajh();
                }
            }
        };
        this.cPq = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.cOK != null) {
                    j.this.cOK.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aQq = tbPageContext;
        View view = getView();
        this.ciC = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cNO = (HeadPendantClickableView) this.ciC.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.ds70));
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.cOY = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cOY.setLoadingAnimationListener(this.cPi);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.ciP = new com.baidu.tieba.NEGFeedBack.c(aiX());
        int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds16);
        this.ciP.a(this.ciC, s, 0);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.setShareReportFrom(3);
        this.ciE.setForumAfterClickListener(this.bbR);
        this.ciE.setFrom(1);
        this.cOM = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cOR = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cOR.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ao(this.aQq.getPageActivity()) - com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cOR.setLayoutParams(layoutParams2);
        this.cOK = (TbImageView) view.findViewById(d.g.image_video);
        this.cOK.setDefaultErrorResource(0);
        this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cOK.setGifIconSupport(false);
        this.cOK.setEvent(this.cPj);
        this.bYm = (ImageView) view.findViewById(d.g.image_video_play);
        this.ciC.setOnClickListener(this);
        this.cOS = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.bYC = new com.baidu.tieba.play.n(this.aQq.getPageActivity());
        this.cOS.setBusiness(this.bYC);
        this.cOS.setOnPreparedListener(this.bNf);
        this.cOS.setOnErrorListener(this.bNg);
        this.cOS.setOnSurfaceDestroyedListener(this.bYH);
        this.bYB = new com.baidu.tieba.play.j();
        this.bYB.setPlayer(this.cOS);
        this.bYB.a(this.cPp);
        this.cOU = (TextView) view.findViewById(d.g.text_video_duration);
        this.cOV = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cOL = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cPa = view.findViewById(d.g.auto_video_black_mask);
        this.cOW = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cOX = view.findViewById(d.g.auto_video_error_background);
        this.cjA = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.bYq = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bYq.setAnimationListener(this.cPq);
        this.cNP = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cNP.setOnClickListener(this);
        this.bOc = view.findViewById(d.g.divider_line);
        this.cPg = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.cOS.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cOZ != null && this.cOZ.bWT != null && this.cOZ.bWT.aOZ > 0) {
            if (aiY() != null) {
                aiY().a(view, this.cOZ);
            }
            this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(this.aQq.getPageActivity(), this.cOZ.bWT.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, k.yN(), this.cOZ.ajL())));
            return;
        }
        if (view == this.ciC || view == this.cNP) {
            bB(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cOS) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bA(getView());
            } else {
                bB(getView());
            }
        }
    }

    private void bA(View view) {
        if (aiY() != null) {
            aiY().a(view, this.cOZ);
        }
        if (!com.baidu.adp.lib.util.j.oI()) {
            com.baidu.adp.lib.util.l.showToast(this.aQq.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQq.getPageActivity());
            aVar.cZ(this.aQq.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.j.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    j.this.aji();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.j.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aV(true);
            aVar.b(this.mTbPageContext).AI();
        } else {
            aji();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aji() {
        if (this.cOZ != null && this.cOZ.bWT != null && this.cOZ.bWT.getId() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aQq.getPageActivity(), "index", this.cOZ.bWT.getTid(), k.yN(), this.cOZ.ajL())));
        }
    }

    private void bB(View view) {
        if (aiY() != null) {
            aiY().a(view, this.cOZ);
        }
        if (this.cOZ != null && this.cOZ.bWT != null) {
            if (!ajc()) {
                k.jT(this.cOZ.bWT.getId());
                k.a(this.mTextTitle, this.cOZ.bWT.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aQq.getPageActivity()).createFromThreadCfg(this.cOZ.bWT, null, k.yN(), 18003, true, false, false).addLocateParam(this.cOZ.ajL());
            addLocateParam.setVideo_source(this.cOZ.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cOZ.bWT.getFid()));
            addLocateParam.setForumName(this.cOZ.bWT.zd());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cNP) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aQq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajc() {
        return this.cOZ.cSB && !this.cOZ.cSP;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.cOZ = nVar;
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajj() {
        this.cPh.removeMessages(HttpStatus.SC_ACCEPTED);
        if (this.cOS.getCurrentPosition() > 0) {
            i(true, 3);
            this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_ACCEPTED, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajk() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cPh.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cOS.getCurrentPosition();
        if (currentPosition != this.cPb) {
            this.cPb = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cPh.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bYm != null && this.cOK != null && this.cPa != null && this.cOY != null && this.cOX != null && this.cOW != null) {
            if (z || this.cPc != i) {
                this.cPc = i;
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPl);
                com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPk);
                if (i == 2) {
                    this.bYm.setVisibility(8);
                    this.bYq.cancel();
                    this.cOK.clearAnimation();
                    this.cOK.setVisibility(0);
                    this.cPa.setVisibility(0);
                    this.cOV.setVisibility(0);
                    this.cPg.setVisibility(8);
                    this.cOY.startLoading();
                    this.cOX.setVisibility(8);
                    this.cOW.setVisibility(8);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cPl, 60000L);
                } else if (i == 3) {
                    this.bYm.setVisibility(8);
                    this.cOK.startAnimation(this.bYq);
                    this.cPa.setVisibility(8);
                    this.cOV.setVisibility(8);
                    if (this.cOZ != null && this.cOZ.VW() != null && this.cOZ.VW().aOZ > 0) {
                        this.cPg.setVisibility(0);
                    }
                    this.cOY.brj();
                    this.cOX.setVisibility(8);
                    this.cOW.setVisibility(8);
                } else if (i == 4) {
                    this.bYm.setVisibility(8);
                    this.cOK.startAnimation(this.bYq);
                    this.cPa.setVisibility(8);
                    this.cOY.brk();
                    this.cOX.setVisibility(0);
                    this.cOW.setVisibility(0);
                    com.baidu.adp.lib.g.e.nr().postDelayed(this.cPk, 2000L);
                } else {
                    this.bYm.setVisibility(0);
                    this.bYq.cancel();
                    this.cOK.clearAnimation();
                    this.cOK.setVisibility(0);
                    this.cPa.setVisibility(0);
                    this.cOV.setVisibility(0);
                    this.cOY.brk();
                    this.cOX.setVisibility(8);
                    this.cOW.setVisibility(8);
                }
                if (this.cOZ != null && this.cOZ.VW() != null && this.cOZ.VW().aOZ > 0) {
                    this.cOV.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cOZ == null || this.cOZ.bWT == null || this.cOZ.bWT.yX() == null) {
            this.ciC.setVisibility(8);
            return;
        }
        this.ciC.setVisibility(0);
        ajn();
        if (!ajc() && k.jU(this.cOZ.bWT.getId())) {
            k.a(this.mTextTitle, this.cOZ.bWT.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cNP.getGodReplyContent(), this.cOZ.VW().getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.cOZ.VW().zF();
        this.mTextTitle.setText(new SpannableStringBuilder(this.cOZ.VW().zx()));
        this.ciD.setData(this.cOZ.VW());
        this.ciD.setUserAfterClickListener(this.cPm);
        if (this.ciD.getHeaderImg() != null) {
            this.ciD.getHeaderImg().setAfterClickListener(this.cPn);
            if (this.ciD.getIsSimpleThread()) {
                this.ciD.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (this.cOZ.VW() == null || this.cOZ.VW().yX() == null || this.cOZ.VW().yX().getPendantData() == null || StringUtils.isNull(this.cOZ.VW().yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.ciD.getHeaderImg().setVisibility(0);
                if (this.cOZ.VW().aOZ > 0 && this.cOZ.VW().aPa == 0) {
                    this.cOZ.VW().yX().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.ciD.getHeaderImg().a(this.cOZ.VW(), false);
                } else {
                    this.ciD.getHeaderImg().setData(this.cOZ.VW());
                    this.ciD.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.ciD.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(this.cOZ.VW());
            }
        }
        if (this.cOZ.bWT.aOZ > 0) {
            this.ciE.setShowPraiseNum(false);
            this.ciE.setShareVisible(false);
            this.cPg.setText(am.I(this.cOZ.bWT.aOZ));
            this.cPg.setVisibility(0);
        } else {
            this.ciE.setShowPraiseNum(true);
            this.ciE.setShareVisible(true);
            this.cPg.setVisibility(8);
        }
        if (this.ciE.setData(this.cOZ.bWT)) {
            this.cOM.setVisibility(8);
        } else {
            this.cOM.setVisibility(0);
        }
        this.cOU.setText(am.fX(this.cOZ.bWT.zp().video_duration.intValue() * 1000));
        this.cOL.setText(String.format(this.aQq.getResources().getString(d.j.play_count), am.I(this.cOZ.bWT.zp().play_count.intValue())));
        if (this.ciP != null && this.cOZ.VW() != null) {
            ai aiVar = new ai();
            aiVar.cK(this.cOZ.VW().getTid());
            aiVar.setFid(this.cOZ.VW().getFid());
            aiVar.a(this.cOZ.aLZ);
            this.ciP.setData(aiVar);
            this.ciP.setFirstRowSingleColumn(true);
            this.ciP.setVisibility(this.cPe ? 0 : 8);
        }
        this.cNP.setData(this.cOZ.VW().Ao());
        this.cNP.onChangeSkinType();
        d(this.aQq, TbadkCoreApplication.getInst().getSkinType());
        if (k.jU(this.cOZ.bWT.getId())) {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0108d.cp_cont_b, 1);
        }
    }

    private void ajl() {
        this.cPh.removeMessages(HttpStatus.SC_ACCEPTED);
        this.cPh.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void ajm() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPk);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.cPl);
    }

    private void ajn() {
        ajm();
        ajl();
        if (this.cOK != null && this.cOR != null && this.cOS != null) {
            if (com.baidu.tbadk.core.i.wB().wH() && this.cOZ != null && this.cOZ.bWT != null && this.cOZ.bWT.zp() != null) {
                this.cOK.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cOK.startLoad(this.cOZ.bWT.zp().thumbnail_url, 10, false);
                this.cOR.setVisibility(0);
                stopPlay();
                this.bOw = this.cOZ.bWT.zp().video_url;
                if (StringUtils.isNull(this.cOZ.bWT.zp().video_url)) {
                    i(true, 4);
                }
                if (this.bYC != null && this.bYC.bqS() != null) {
                    this.bYC.bqS().d(this.cOZ.bWT.zp());
                    return;
                }
                return;
            }
            this.cOR.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.ciC, d.f.addresslist_item_bg);
            aj.c(this.bYm, d.f.btn_icon_play_video_n);
            aj.r(this.cOW, d.C0108d.cp_cont_i);
            aj.r(this.cOU, d.C0108d.cp_cont_i);
            aj.r(this.cOL, d.C0108d.cp_cont_i);
            aj.r(this.cPg, d.C0108d.cp_cont_i);
            aj.t(this.cOX, d.C0108d.common_color_10014);
            aj.t(this.bOc, d.C0108d.cp_bg_line_e);
            if (this.cOW != null) {
                this.cOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.ciP != null) {
                this.ciP.onChangeSkinType();
            }
            this.ciD.onChangeSkinType();
            this.ciE.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cPo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cPo);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciD != null) {
            this.ciD.setPageUniqueId(bdUniqueId);
        }
        if (this.cOK != null) {
            this.cOK.setPageId(bdUniqueId);
        }
        if (this.ciP != null) {
            this.ciP.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cPd;
    }

    public boolean isPlaying() {
        if (this.cOS == null) {
            return false;
        }
        return this.cOS.isPlaying();
    }

    public void startPlay() {
        if (!this.cPd && this.cOZ != null && this.cOZ.bWT != null && this.cOZ.bWT.zp() != null && this.cOS != null && com.baidu.tbadk.util.y.p(1, this.bOw)) {
            i(true, 2);
            if (StringUtils.isNull(this.bOw)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "index").ab("tid", this.cOZ.tid));
                this.bOw = this.cOZ.bWT.zp().video_url;
            }
            this.cOS.bS(this.bOw, this.cOZ.tid);
            this.cOS.setLooping(true);
            if (this.bYB != null) {
                this.bYB.start();
            }
            this.cPd = true;
            ajh();
        }
    }

    public void stopPlay() {
        ajm();
        ajl();
        i(true, 1);
        if (this.cOS != null) {
            this.cOS.stopPlayback();
            if (this.bYB != null) {
                this.bYB.stop();
            }
        }
        this.cPd = false;
    }

    public View getVideoContainer() {
        return this.cOR;
    }

    public String getPlayUrl() {
        return this.bOw;
    }

    public int getCurrentPosition() {
        if (this.cOS == null) {
            return 0;
        }
        return this.cOS.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.bYC != null) {
            this.bYC.setVideoStatsData(aaVar);
        }
    }

    public void a(c.a aVar) {
        if (this.ciP != null) {
            this.ciP.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciD != null) {
            return this.ciD.bbZ;
        }
        return null;
    }

    public View ajb() {
        if (this.ciD != null) {
            return this.ciD.bca;
        }
        return null;
    }

    public void ew(boolean z) {
        this.cPe = z;
    }
}
