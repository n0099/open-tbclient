package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.i;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class j extends a<com.baidu.tieba.card.data.n> {
    private f.d aUM;
    private f.b aUN;
    private TbPageContext<?> acp;
    private final View.OnClickListener aoG;
    public FrameLayout bDZ;
    private TbImageView bEa;
    private ImageView bEb;
    private TbImageView.a bEd;
    private HeadPendantClickableView bFM;
    private ThreadGodReplyLayout bFN;
    private View bFO;
    private com.baidu.tbadk.core.view.h bFP;
    private QuickVideoView bGM;
    private com.baidu.tieba.play.m bGN;
    private TextView bGO;
    private TextView bGP;
    private View bGQ;
    private AudioAnimationView bGR;
    private ProgressBar bGS;
    private ImageView bGT;
    private com.baidu.tieba.card.data.n bGU;
    private View bGV;
    private int bGW;
    private int bGX;
    private boolean bGY;
    private boolean bGZ;
    private com.baidu.tieba.play.i bHa;
    private Animation bHb;
    private Handler bHc;
    private Runnable bHd;
    private Runnable bHe;
    private QuickVideoView.b bHf;
    private final View.OnClickListener bHg;
    private final View.OnClickListener bHh;
    private CustomMessageListener bHi;
    private i.a bHj;
    private Animation.AnimationListener bHk;
    private View bhj;
    private RelativeLayout bkM;
    public ThreadUserInfoLayout bkV;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    protected LinearLayout bld;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFP = null;
        this.mSkinType = 3;
        this.bGW = 0;
        this.bGX = 1;
        this.bGY = false;
        this.bGZ = false;
        this.bHc = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        j.this.Wm();
                        return;
                    case 203:
                        j.this.Wn();
                        return;
                    default:
                        return;
                }
            }
        };
        this.aUM = new f.d() { // from class: com.baidu.tieba.card.j.6
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(com.baidu.tieba.play.f fVar) {
                if (fVar != null) {
                    try {
                        fVar.setVolume(0.0f, 0.0f);
                        fVar.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j.this.bHc.sendEmptyMessageDelayed(202, 300L);
                }
            }
        };
        this.aUN = new f.b() { // from class: com.baidu.tieba.card.j.7
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(com.baidu.tieba.play.f fVar, int i, int i2) {
                j.this.f(true, 4);
                return true;
            }
        };
        this.bEd = new TbImageView.a() { // from class: com.baidu.tieba.card.j.8
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && j.this.bEa != null) {
                    j.this.bEa.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bHd = new Runnable() { // from class: com.baidu.tieba.card.j.9
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.bGM != null && !j.this.bGM.isPlaying()) {
                    j.this.f(true, 1);
                }
            }
        };
        this.bHe = new Runnable() { // from class: com.baidu.tieba.card.j.10
            @Override // java.lang.Runnable
            public void run() {
                j.this.f(true, 4);
            }
        };
        this.bHf = new QuickVideoView.b() { // from class: com.baidu.tieba.card.j.11
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                j.this.stopPlay();
            }
        };
        this.bHg = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.We() != null) {
                    j.this.We().a(view, j.this.bGU);
                }
            }
        };
        this.bHh = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.We() != null) {
                    j.this.We().a(view, j.this.bGU);
                }
            }
        };
        this.bHi = new CustomMessageListener(CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    j.this.bGZ = false;
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.bGU != null && j.this.We() != null) {
                    j.this.We().a(view, j.this.bGU);
                }
            }
        };
        this.bHj = new i.a() { // from class: com.baidu.tieba.card.j.4
            @Override // com.baidu.tieba.play.i.a
            public void Wr() {
                if (j.this.bGU != null && j.this.bGU.bcL != null && j.this.bGU.bcL.rW() != null) {
                    com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
                    wVar.mLocate = j.this.bGU.sourceType == 0 ? "index" : "hot_juhe";
                    wVar.bDd = j.this.bGU.bcL.getTid();
                    wVar.aAB = j.this.bGU.bcL.getFid() + "";
                    wVar.mUid = TbadkCoreApplication.getCurrentAccount();
                    wVar.mSource = j.this.bGU.bcL.aaA;
                    wVar.fAx = j.this.bGU.bcL.aaC;
                    wVar.fAy = j.this.bGU.bcL.aaB;
                    wVar.fAz = "";
                    if (j.this.bGU.bcL.sJ() != null && j.this.bGU.bcL.sJ().channelId > 0) {
                        wVar.WI = j.this.bGU.bcL.sJ().channelId + "";
                    } else {
                        wVar.WI = "0";
                    }
                    com.baidu.tieba.play.k.a(j.this.bGU.bcL.rW().video_md5, "", "1", wVar);
                }
            }
        };
        this.bHk = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.j.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (j.this.bEa != null) {
                    j.this.bEa.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.acp = tbPageContext;
        View view = getView();
        this.bkM = (RelativeLayout) view.findViewById(d.h.layout_root);
        this.bFM = (HeadPendantClickableView) this.bkM.findViewById(d.h.card_home_page_video_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.acp.getPageActivity(), d.f.ds70));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.bGS = (ProgressBar) view.findViewById(d.h.auto_video_loading_progress);
        this.bGT = (ImageView) view.findViewById(d.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bkV = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_auto_video_user_info_layout);
        this.bFP = new com.baidu.tbadk.core.view.h(this.acp);
        this.bFP.wK();
        this.bFP.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bkV.addView(this.bFP);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bkZ.setForumAfterClickListener(this.aoG);
        this.bkZ.setFrom(1);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bDZ = (FrameLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bDZ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.ag(this.acp.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.acp.getPageActivity(), d.f.ds68);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bDZ.setLayoutParams(layoutParams2);
        this.bEa = (TbImageView) view.findViewById(d.h.image_video);
        this.bEa.setDefaultErrorResource(0);
        this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEa.setGifIconSupport(false);
        this.bEa.setEvent(this.bEd);
        this.bEb = (ImageView) view.findViewById(d.h.image_video_play);
        this.bGR = (AudioAnimationView) view.findViewById(d.h.auto_video_play_state);
        this.bGR.setCertainColumnCount(4);
        this.bGR.setColumnColor(d.e.cp_cont_i);
        this.bkM.setOnClickListener(this);
        this.bGM = (QuickVideoView) view.findViewById(d.h.texture_video_view);
        this.bGN = new com.baidu.tieba.play.m(this.acp.getPageActivity());
        this.bGM.setBusiness(this.bGN);
        this.bGM.setOnPreparedListener(this.aUM);
        this.bGM.setOnErrorListener(this.aUN);
        this.bGM.setOnSurfaceDestroyedListener(this.bHf);
        this.bHa = new com.baidu.tieba.play.i();
        this.bHa.setPlayer(this.bGM);
        this.bHa.a(this.bHj);
        this.bGO = (TextView) view.findViewById(d.h.text_video_duration);
        this.bGV = view.findViewById(d.h.auto_video_black_mask);
        this.bGP = (TextView) view.findViewById(d.h.auto_video_error_tips);
        this.bGQ = view.findViewById(d.h.auto_video_error_background);
        this.bld = (LinearLayout) view.findViewById(d.h.video_card_content_layout);
        this.bHb = AnimationUtils.loadAnimation(this.acp.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bHb.setAnimationListener(this.bHk);
        this.bhj = view.findViewById(d.h.divider_line);
        this.bFN = (ThreadGodReplyLayout) view.findViewById(d.h.card_god_reply_layout);
        this.bFN.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bkM || view == this.bFN) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void X(View view) {
        if (We() != null) {
            We().a(view, this.bGU);
        }
        if (this.bGU != null && this.bGU.bcL != null) {
            if (!Wi()) {
                m.jd(this.bGU.bcL.getId());
                m.a(this.mTextTitle, this.bGU.bcL.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.acp.getPageActivity()).createFromThreadCfg(this.bGU.bcL, null, m.rw(), 18003, true, false, false).addLocateParam(this.bGU.WG());
            addLocateParam.setVideo_source(this.bGU.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bGU.bcL.getFid()));
            addLocateParam.setForumName(this.bGU.bcL.rK());
            if (this.bGU.bJq == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bGU.bJq);
            }
            if (view == this.bFN) {
                addLocateParam.setJumpGodReply(true);
            }
            this.acp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wi() {
        return this.bGU.bJI && !this.bGU.bJW;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bGU = nVar;
        Oy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wm() {
        this.bHc.removeMessages(202);
        if (this.bGM.getCurrentPosition() > 0) {
            f(true, 3);
            this.bHc.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bHc.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wn() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bHc.removeMessages(203);
        int currentPosition = this.bGM.getCurrentPosition();
        if (currentPosition != this.bGW) {
            this.bGW = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bHc.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bEb != null && this.bEa != null && this.bGV != null && this.bGR != null && this.bGS != null && this.bGT != null && this.bGQ != null && this.bGP != null) {
            if (z || this.bGX != i) {
                this.bGX = i;
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHe);
                com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHd);
                if (i == 2) {
                    this.bEb.setVisibility(8);
                    this.bHb.cancel();
                    this.bEa.clearAnimation();
                    this.bEa.setVisibility(0);
                    this.bGV.setVisibility(0);
                    this.bGO.setVisibility(0);
                    this.bGS.setVisibility(0);
                    this.bGT.setVisibility(0);
                    this.bGQ.setVisibility(8);
                    this.bGP.setVisibility(8);
                    this.bGR.setVisibility(8);
                    this.bGR.bwC();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHe, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bEb.setVisibility(8);
                    this.bEa.startAnimation(this.bHb);
                    this.bGV.setVisibility(8);
                    this.bGO.setVisibility(8);
                    this.bGS.setVisibility(8);
                    this.bGT.setVisibility(8);
                    this.bGQ.setVisibility(8);
                    this.bGP.setVisibility(8);
                    this.bGR.setVisibility(0);
                    this.bGR.start();
                } else if (i == 4) {
                    this.bEb.setVisibility(8);
                    this.bEa.startAnimation(this.bHb);
                    this.bGV.setVisibility(8);
                    this.bGS.setVisibility(8);
                    this.bGT.setVisibility(8);
                    this.bGQ.setVisibility(0);
                    this.bGP.setVisibility(0);
                    this.bGR.setVisibility(8);
                    this.bGR.bwC();
                    com.baidu.adp.lib.g.e.ga().postDelayed(this.bHd, 2000L);
                } else {
                    this.bEb.setVisibility(0);
                    this.bHb.cancel();
                    this.bEa.clearAnimation();
                    this.bEa.setVisibility(0);
                    this.bGV.setVisibility(0);
                    this.bGO.setVisibility(0);
                    this.bGS.setVisibility(8);
                    this.bGT.setVisibility(8);
                    this.bGQ.setVisibility(8);
                    this.bGP.setVisibility(8);
                    this.bGR.setVisibility(8);
                    this.bGR.bwC();
                }
            }
        }
    }

    private void Oy() {
        String string;
        if (this.bGU == null || this.bGU.bcL == null || this.bGU.bcL.getAuthor() == null) {
            this.bkM.setVisibility(8);
            return;
        }
        this.bkM.setVisibility(0);
        Wq();
        if (!Wi() && m.je(this.bGU.bcL.getId())) {
            m.a(this.mTextTitle, this.bGU.bcL.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bFN.getGodReplyContent(), this.bGU.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getPraiseNum(), this.bGU.MF().getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bGU.MF().sn();
        if (this.bGU.bcL.sJ() != null && this.bGU.bcL.sJ().channelId > 0) {
            string = this.acp.getResources().getString(d.l.channel_title_prefix);
        } else if (this.bGU.bcL.getThreadType() == 50) {
            string = this.acp.getResources().getString(d.l.ala_record_title_prefix);
        } else {
            string = this.acp.getResources().getString(d.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bGU.MF().sf()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.bkV.a(this.bGU.MF());
        this.bkV.setUserAfterClickListener(this.bHg);
        if (this.bkV.getHeaderImg() != null) {
            this.bkV.getHeaderImg().setAfterClickListener(this.bHh);
            if (this.bkV.getIsSimpleThread()) {
                this.bkV.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (this.bGU.MF() == null || this.bGU.MF().getAuthor() == null || this.bGU.MF().getAuthor().getPendantData() == null || StringUtils.isNull(this.bGU.MF().getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.bkV.getHeaderImg().setVisibility(0);
                this.bkV.getHeaderImg().setData(this.bGU.MF());
            } else {
                this.bkV.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(this.bGU.MF());
            }
        }
        if (this.bkZ.a(this.bGU.bcL)) {
            this.bFO.setVisibility(8);
        } else {
            this.bFO.setVisibility(0);
        }
        this.bGO.setText(al.cZ(this.bGU.bcL.rW().video_duration.intValue() * 1000));
        if (this.bFP != null && this.bGU.MF() != null) {
            an anVar = new an();
            anVar.cF(this.bGU.MF().getTid());
            anVar.setFid(this.bGU.MF().getFid());
            anVar.a(this.bGU.XT);
            this.bFP.setData(anVar);
            this.bFP.setFirstRowSingleColumn(true);
        }
        this.bFN.setData(this.bGU.MF().sU());
        this.bFN.onChangeSkinType();
        if (this.bFN.getVisibility() == 0) {
            this.bFO.setVisibility(0);
        }
        d(this.acp, TbadkCoreApplication.getInst().getSkinType());
        if (m.je(this.bGU.bcL.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
    }

    private void Wo() {
        this.bHc.removeMessages(202);
        this.bHc.removeMessages(203);
    }

    private void Wp() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHd);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.bHe);
    }

    private void Wq() {
        Wp();
        Wo();
        if (this.bEa != null && this.bDZ != null && this.bGM != null) {
            if (com.baidu.tbadk.core.h.oX().pd() && this.bGU != null && this.bGU.bcL != null && this.bGU.bcL.rW() != null) {
                this.bEa.setDefaultBgResource(d.g.pic_bg_video_frs);
                this.bEa.c(this.bGU.bcL.rW().thumbnail_url, 10, false);
                this.bDZ.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bGU.bcL.rW().video_url;
                if (StringUtils.isNull(this.bGU.bcL.rW().video_url)) {
                    f(true, 4);
                }
                if (this.bGN != null && this.bGN.bfO() != null) {
                    this.bGN.bfO().d(this.bGU.bcL.rW());
                    return;
                }
                return;
            }
            this.bDZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bkM, d.g.addresslist_item_bg);
            ai.c(this.bEb, d.g.home_ic_video);
            ai.i(this.bGP, d.e.cp_cont_i);
            ai.i(this.bGO, d.e.cp_cont_i);
            ai.k(this.bGQ, d.e.common_color_10014);
            if (this.bGP != null) {
                this.bGP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            ai.j(this.bhj, d.e.cp_bg_line_c);
            if (this.bFP != null) {
                this.bFP.onChangeSkinType();
            }
            this.bkV.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bHi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHi);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bkV != null) {
            this.bkV.setPageUniqueId(bdUniqueId);
        }
        if (this.bEa != null) {
            this.bEa.setPageId(bdUniqueId);
        }
        if (this.bFP != null) {
            this.bFP.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bGY;
    }

    public boolean isPlaying() {
        if (this.bGM == null) {
            return false;
        }
        return this.bGM.isPlaying();
    }

    public void startPlay() {
        if (!this.bGY && this.bGU != null && this.bGU.bcL != null && this.bGU.bcL.rW() != null && this.bGM != null && com.baidu.tbadk.util.x.r(1, this.mVideoUrl)) {
            f(true, 2);
            this.bGM.setVideoPath(this.mVideoUrl);
            this.bGM.start();
            this.bGM.setLooping(true);
            if (this.bHa != null) {
                this.bHa.start();
            }
            this.bGY = true;
            com.baidu.tieba.play.w wVar = new com.baidu.tieba.play.w();
            wVar.mLocate = this.bGU.sourceType == 0 ? "index" : "hot_juhe";
            wVar.bDd = this.bGU.bcL.getTid();
            wVar.aAB = this.bGU.bcL.getFid() + "";
            wVar.mUid = TbadkCoreApplication.getCurrentAccount();
            wVar.mSource = this.bGU.bcL.aaA;
            wVar.fAx = this.bGU.bcL.aaC;
            wVar.fAy = this.bGU.bcL.aaB;
            wVar.fAz = "";
            if (this.bGU.bcL.sJ() != null && this.bGU.bcL.sJ().channelId > 0) {
                wVar.WI = this.bGU.bcL.sJ().channelId + "";
            } else {
                wVar.WI = "0";
            }
            com.baidu.tieba.play.k.a(this.bGU.bcL.rW().video_md5, "", "1", wVar);
        }
    }

    public void stopPlay() {
        Wp();
        Wo();
        f(true, 1);
        if (this.bGM != null) {
            this.bGM.stopPlayback();
            if (this.bHa != null) {
                this.bHa.stop();
            }
        }
        this.bGY = false;
    }

    public View getVideoContainer() {
        return this.bDZ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bGM == null) {
            return 0;
        }
        return this.bGM.getCurrentPosition();
    }

    public void setVideoStatsData(com.baidu.tieba.play.w wVar) {
        if (this.bGN != null) {
            this.bGN.setVideoStatsData(wVar);
        }
    }

    public void a(h.a aVar) {
        if (this.bFP != null) {
            this.bFP.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bkV != null) {
            return this.bkV.aoR;
        }
        return null;
    }

    public View Wh() {
        if (this.bkV != null) {
            return this.bkV.aoS;
        }
        return null;
    }
}
