package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.play.y;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.m> implements View.OnClickListener {
    private TbPageContext<?> aRR;
    private g.f bPD;
    private g.b bPE;
    private View bQA;
    private String bQV;
    private final View.OnClickListener bdQ;
    public ThreadGodReplyLayout cVG;
    private LinearLayout cWA;
    private TextView cWB;
    private View cWC;
    private y cWD;
    private com.baidu.tieba.card.data.m cWE;
    private View cWF;
    private int cWG;
    private int cWH;
    private boolean cWI;
    private boolean cWJ;
    private boolean cWK;
    private TextView cWL;
    private Handler cWM;
    private VideoLoadingProgressView.a cWN;
    private TbImageView.a cWO;
    private Runnable cWP;
    private Runnable cWQ;
    private final View.OnClickListener cWR;
    private final View.OnClickListener cWS;
    private CustomMessageListener cWT;
    private j.a cWU;
    private Animation.AnimationListener cWV;
    private TbImageView cWp;
    private TextView cWq;
    private View cWr;
    public FrameLayout cWw;
    private QuickVideoView cWx;
    private com.baidu.tieba.play.g cWy;
    private TextView cWz;
    private ImageView caJ;
    private Animation caN;
    private com.baidu.tieba.play.j caZ;
    private com.baidu.tieba.play.n cba;
    private QuickVideoView.b cbh;
    private HeadPendantClickableView cmU;
    public ThreadSourceShareAndPraiseLayout cmX;
    private RelativeLayout cmi;
    public ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    private com.baidu.tieba.NEGFeedBack.c cmv;
    protected LinearLayout cnj;
    private int mSkinType;
    private TextView mTextTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.cWy != null) {
            try {
                this.cWx.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cWM.sendEmptyMessageDelayed(202, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.cWE != null && this.cWE.bZr != null) {
            aa aaVar = new aa();
            aaVar.mLocate = this.cWE.sourceType == 0 ? "index" : "hot_juhe";
            aaVar.bDf = this.cWE.bZr.getTid();
            aaVar.cZU = this.cWE.bZr.getFid() + "";
            aaVar.mUid = TbadkCoreApplication.getCurrentAccount();
            aaVar.mSource = this.cWE.bZr.mRecomSource;
            aaVar.gvW = this.cWE.bZr.mRecomAbTag;
            aaVar.gvX = this.cWE.bZr.mRecomWeight;
            aaVar.gvY = "";
            aaVar.aMB = this.cWE.getExtra();
            if (this.cWE.bZr.zF() != null) {
                aaVar.gwa = this.cWE.bZr.zF().video_md5;
            }
            com.baidu.tieba.play.l.a(this.cWE.bZr.zF().video_md5, "", "1", aaVar);
        }
    }

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmv = null;
        this.mSkinType = 3;
        this.cWG = 0;
        this.cWH = 1;
        this.cWI = false;
        this.cWJ = true;
        this.cWK = false;
        this.cWM = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.card.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        i.this.ala();
                        return;
                    case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
                        i.this.alb();
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPD = new g.f() { // from class: com.baidu.tieba.card.i.10
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(com.baidu.tieba.play.g gVar) {
                i.this.cWy = gVar;
                if (i.this.cWy != null) {
                    i.this.cWy.setVolume(0.0f, 0.0f);
                }
                i.this.cWD.blP();
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.card.i.11
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(com.baidu.tieba.play.g gVar, int i, int i2) {
                i.this.i(true, 4);
                return true;
            }
        };
        this.cWN = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.card.i.12
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                i.this.akX();
            }
        };
        this.cWO = new TbImageView.a() { // from class: com.baidu.tieba.card.i.13
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && i.this.cWp != null) {
                    i.this.cWp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cWP = new Runnable() { // from class: com.baidu.tieba.card.i.17
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.cWx != null && !i.this.cWx.isPlaying()) {
                    i.this.i(true, 1);
                }
            }
        };
        this.cWQ = new Runnable() { // from class: com.baidu.tieba.card.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.i(true, 4);
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.i.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                i.this.stopPlay();
            }
        };
        this.cWR = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.cWE);
                }
            }
        };
        this.cWS = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.cWE);
                }
            }
        };
        this.cWT = new CustomMessageListener(2016477) { // from class: com.baidu.tieba.card.i.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                    i.this.cWK = false;
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.cWE != null) {
                    if (i.this.akP() != null) {
                        i.this.akP().a(view, i.this.cWE);
                    }
                    if (i.this.cWE.bZr != null && view != i.this.cmX.bey) {
                        j.kr(i.this.cWE.bZr.getId());
                        if (!i.this.akT()) {
                            j.a(i.this.mTextTitle, i.this.cWE.bZr.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                            j.a(i.this.cVG.getGodReplyContent(), i.this.cWE.WE().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                        }
                    }
                }
            }
        };
        this.cWU = new j.a() { // from class: com.baidu.tieba.card.i.8
            @Override // com.baidu.tieba.play.j.a
            public void alf() {
                if (i.this.cWE != null && i.this.cWE.bZr != null && i.this.cWE.bZr.zF() != null) {
                    i.this.akY();
                }
            }
        };
        this.cWV = new Animation.AnimationListener() { // from class: com.baidu.tieba.card.i.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (i.this.cWp != null) {
                    i.this.cWp.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.aRR = tbPageContext;
        View view = getView();
        this.cmi = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.cmU = (HeadPendantClickableView) this.cmi.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.ds70));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.cWD = new y((ViewGroup) view.findViewById(d.g.auto_video_loading_container));
        this.cWD.setLoadingAnimationListener(this.cWN);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_auto_video_user_info_layout);
        this.cmv = new com.baidu.tieba.NEGFeedBack.c(akO());
        int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds120);
        com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16);
        this.cmv.a(this.cmi, t, 0);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.setShareReportFrom(3);
        this.cmk.setForumAfterClickListener(this.bdQ);
        this.cmk.setFrom(1);
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.text_bottom_threaad);
        this.cmX.bez.setOnClickListener(this);
        this.cmX.setFrom(1);
        this.cmX.setShareReportFrom(3);
        this.cmX.setForumAfterClickListener(this.bdQ);
        this.cWr = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cWw = (FrameLayout) view.findViewById(d.g.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWw.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.ao(this.aRR.getPageActivity()) - com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cWw.setLayoutParams(layoutParams2);
        this.cWp = (TbImageView) view.findViewById(d.g.image_video);
        this.cWp.setDefaultErrorResource(0);
        this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWp.setGifIconSupport(false);
        this.cWp.setEvent(this.cWO);
        this.caJ = (ImageView) view.findViewById(d.g.image_video_play);
        this.cmi.setOnClickListener(this);
        this.cWx = (QuickVideoView) view.findViewById(d.g.texture_video_view);
        this.cba = new com.baidu.tieba.play.n(this.aRR.getPageActivity());
        this.cWx.setBusiness(this.cba);
        this.cWx.setOnPreparedListener(this.bPD);
        this.cWx.setOnErrorListener(this.bPE);
        this.cWx.setOnSurfaceDestroyedListener(this.cbh);
        this.caZ = new com.baidu.tieba.play.j();
        this.caZ.setPlayer(this.cWx);
        this.caZ.a(this.cWU);
        this.cWz = (TextView) view.findViewById(d.g.text_video_duration);
        this.cWA = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cWq = (TextView) view.findViewById(d.g.text_video_play_count);
        this.cWF = view.findViewById(d.g.auto_video_black_mask);
        this.cWB = (TextView) view.findViewById(d.g.auto_video_error_tips);
        this.cWC = view.findViewById(d.g.auto_video_error_background);
        this.cnj = (LinearLayout) view.findViewById(d.g.video_card_content_layout);
        this.caN = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.caN.setAnimationListener(this.cWV);
        this.cVG = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.cVG.setOnClickListener(this);
        this.bQA = view.findViewById(d.g.divider_line);
        this.cWL = (TextView) view.findViewById(d.g.txt_video_num_during_playing);
        this.cWx.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cWE != null && this.cWE.bZr != null && this.cWE.bZr.aQu > 0) {
            if (akP() != null) {
                akP().a(view, this.cWE);
            }
            this.aRR.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.aRR.getPageActivity(), this.cWE.bZr.getTid(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, j.zd(), this.cWE.alC())));
            return;
        }
        if (view == this.cmi || view == this.cVG) {
            bC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cWx) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                bB(getView());
            } else {
                bC(getView());
            }
        }
    }

    private void bB(View view) {
        if (akP() != null) {
            akP().a(view, this.cWE);
        }
        if (!com.baidu.adp.lib.util.j.oJ()) {
            com.baidu.adp.lib.util.l.showToast(this.aRR.getPageActivity(), d.j.no_network_guide);
        } else if (!com.baidu.adp.lib.util.j.oK()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
            aVar.dk(this.aRR.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.card.i.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    i.this.akZ();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.card.i.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.aZ(true);
            aVar.b(this.mTbPageContext).AU();
        } else {
            akZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        if (this.cWE != null && this.cWE.bZr != null && this.cWE.bZr.getId() != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cWE.bZr);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (this.cnj.getX() + getVideoContainer().getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cnj.getY() + getVideoContainer().getY());
            videoCardViewInfo.cardViewWidth = getVideoContainer().getWidth();
            videoCardViewInfo.cardViewHeight = getVideoContainer().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.aRR.getPageActivity(), "index", this.cWE.bZr.getTid(), j.zd(), this.cWE.alC(), videoSerializeVideoThreadInfo)));
        }
    }

    private void bC(View view) {
        if (akP() != null) {
            akP().a(view, this.cWE);
        }
        if (this.cWE != null && this.cWE.bZr != null) {
            if (!akT()) {
                j.kr(this.cWE.bZr.getId());
                j.a(this.mTextTitle, this.cWE.bZr.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aRR.getPageActivity()).createFromThreadCfg(this.cWE.bZr, null, j.zd(), 18003, true, false, false).addLocateParam(this.cWE.alC());
            addLocateParam.setVideo_source(this.cWE.sourceType == 0 ? "index" : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.cWE.bZr.getFid()));
            addLocateParam.setForumName(this.cWE.bZr.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.cVG) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aRR.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akT() {
        return this.cWE.dal && !this.cWE.daB;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.m mVar) {
        this.cWE = mVar;
        refreshView();
        if (mVar != null && mVar.bZr != null) {
            int i = mVar.bZr.aQz;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        this.cWM.removeMessages(202);
        if (this.cWx.getCurrentPosition() > 0) {
            i(true, 3);
            this.cWM.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
            return;
        }
        this.cWM.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.cWM.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        int currentPosition = this.cWx.getCurrentPosition();
        if (currentPosition != this.cWG) {
            this.cWG = currentPosition;
            i(false, 3);
        } else {
            i(false, 2);
        }
        this.cWM.sendEmptyMessageDelayed(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.caJ != null && this.cWp != null && this.cWF != null && this.cWD != null && this.cWC != null && this.cWB != null) {
            if (z || this.cWH != i) {
                this.cWH = i;
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWQ);
                com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWP);
                if (i == 2) {
                    this.caJ.setVisibility(8);
                    this.caN.cancel();
                    this.cWp.clearAnimation();
                    this.cWp.setVisibility(0);
                    this.cWF.setVisibility(0);
                    this.cWA.setVisibility(0);
                    this.cWL.setVisibility(8);
                    this.cWD.startLoading();
                    this.cWC.setVisibility(8);
                    this.cWB.setVisibility(8);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWQ, 60000L);
                } else if (i == 3) {
                    this.caJ.setVisibility(8);
                    this.cWp.startAnimation(this.caN);
                    this.cWF.setVisibility(8);
                    this.cWA.setVisibility(8);
                    if (this.cWE != null && this.cWE.WE() != null && this.cWE.WE().aQu > 0) {
                        this.cWL.setVisibility(0);
                    }
                    this.cWD.blQ();
                    this.cWC.setVisibility(8);
                    this.cWB.setVisibility(8);
                } else if (i == 4) {
                    this.caJ.setVisibility(8);
                    this.cWp.startAnimation(this.caN);
                    this.cWF.setVisibility(8);
                    this.cWD.blR();
                    this.cWC.setVisibility(0);
                    this.cWB.setVisibility(0);
                    com.baidu.adp.lib.g.e.ns().postDelayed(this.cWP, 2000L);
                } else {
                    this.caJ.setVisibility(0);
                    this.caN.cancel();
                    this.cWp.clearAnimation();
                    this.cWp.setVisibility(0);
                    this.cWF.setVisibility(0);
                    this.cWA.setVisibility(0);
                    this.cWD.blR();
                    this.cWC.setVisibility(8);
                    this.cWB.setVisibility(8);
                }
                if (this.cWE != null && this.cWE.WE() != null && this.cWE.WE().aQu > 0) {
                    this.cWA.setVisibility(8);
                }
            }
        }
    }

    private void refreshView() {
        if (this.cWE == null || this.cWE.bZr == null || this.cWE.bZr.zn() == null) {
            this.cmi.setVisibility(8);
            return;
        }
        this.cmi.setVisibility(0);
        ale();
        if (!akT() && j.ks(this.cWE.bZr.getId())) {
            j.a(this.mTextTitle, this.cWE.bZr.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            j.a(this.cVG.getGodReplyContent(), this.cWE.WE().getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        this.cWE.WE().zW();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cWE.WE().zN());
        if (this.cWE.WE().zT() && !StringUtils.isNull(this.cWE.WE().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cWE.WE().getTid();
            spannableStringBuilder.append((CharSequence) this.cWE.WE().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.card.i.16
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.b.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new ak("c12841").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.m(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.cmj.setData(this.cWE.WE());
        this.cmj.setUserAfterClickListener(this.cWR);
        if (this.cmj.getHeaderImg() != null) {
            this.cmj.getHeaderImg().setAfterClickListener(this.cWS);
            if (this.cmj.getIsSimpleThread()) {
                this.cmj.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (this.cWE.WE() == null || this.cWE.WE().zn() == null || this.cWE.WE().zn().getPendantData() == null || StringUtils.isNull(this.cWE.WE().zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.cmj.getHeaderImg().setVisibility(0);
                if (this.cWE.WE().aQu > 0 && this.cWE.WE().aQv == 0) {
                    this.cWE.WE().zn().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                    this.cmj.getHeaderImg().a(this.cWE.WE(), false);
                } else {
                    this.cmj.getHeaderImg().setData(this.cWE.WE());
                    this.cmj.getHeaderImg().setOnInterceptClickEventListener(null);
                }
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(this.cWE.WE());
            }
        }
        this.cWz.setText(am.fV(this.cWE.bZr.zF().video_duration.intValue() * 1000));
        this.cWq.setText(String.format(this.aRR.getResources().getString(d.j.play_count), am.J(this.cWE.bZr.zF().play_count.intValue())));
        if (this.cmv != null && this.cWE.WE() != null) {
            ah ahVar = new ah();
            ahVar.cV(this.cWE.WE().getTid());
            ahVar.setFid(this.cWE.WE().getFid());
            ahVar.a(this.cWE.aNr);
            this.cmv.setData(ahVar);
            this.cmv.setFirstRowSingleColumn(true);
            this.cmv.setVisibility(this.cWJ ? 0 : 8);
        }
        this.cVG.setData(this.cWE.WE().AA());
        jX(this.cWE.WE().aQz);
        d(this.aRR, TbadkCoreApplication.getInst().getSkinType());
        if (j.ks(this.cWE.bZr.getId())) {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_d, 1);
        } else {
            aj.e(this.mTextTitle, d.C0140d.cp_cont_b, 1);
        }
    }

    private void alc() {
        this.cWM.removeMessages(202);
        this.cWM.removeMessages(HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
    }

    private void ald() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWP);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.cWQ);
    }

    private void ale() {
        ald();
        alc();
        if (this.cWp != null && this.cWw != null && this.cWx != null) {
            if (com.baidu.tbadk.core.i.xo().xu() && this.cWE != null && this.cWE.bZr != null && this.cWE.bZr.zF() != null) {
                this.cWp.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cWp.startLoad(this.cWE.bZr.zF().thumbnail_url, 10, false);
                this.cWw.setVisibility(0);
                stopPlay();
                this.bQV = this.cWE.bZr.zF().video_url;
                if (StringUtils.isNull(this.cWE.bZr.zF().video_url)) {
                    i(true, 4);
                }
                if (this.cba != null && this.cba.blz() != null) {
                    this.cba.blz().d(this.cWE.bZr.zF());
                    return;
                }
                return;
            }
            this.cWw.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.cmi, d.f.addresslist_item_bg);
            aj.c(this.caJ, d.f.btn_icon_play_video_n);
            aj.r(this.cWB, d.C0140d.cp_cont_i);
            aj.r(this.cWz, d.C0140d.cp_cont_i);
            aj.r(this.cWq, d.C0140d.cp_cont_i);
            aj.r(this.cWL, d.C0140d.cp_cont_i);
            aj.t(this.cWC, d.C0140d.common_color_10014);
            aj.t(this.bQA, d.C0140d.cp_bg_line_e);
            if (this.cWB != null) {
                this.cWB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.cVG.onChangeSkinType();
            if (this.cmv != null) {
                this.cmv.onChangeSkinType();
            }
            this.cmj.onChangeSkinType();
            this.cmk.onChangeSkinType();
            this.cmX.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cWT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWT);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cmj != null) {
            this.cmj.setPageUniqueId(bdUniqueId);
        }
        if (this.cWp != null) {
            this.cWp.setPageId(bdUniqueId);
        }
        if (this.cmv != null) {
            this.cmv.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.cWI;
    }

    public boolean isPlaying() {
        if (this.cWx == null) {
            return false;
        }
        return this.cWx.isPlaying();
    }

    public void startPlay() {
        if (!this.cWI && this.cWE != null && this.cWE.bZr != null && this.cWE.bZr.zF() != null && this.cWx != null && com.baidu.tbadk.util.y.p(1, this.bQV)) {
            i(true, 2);
            if (StringUtils.isNull(this.bQV)) {
                TiebaStatic.log(new ak("c12619").ab("obj_locate", "index").ab("tid", this.cWE.tid));
                this.bQV = this.cWE.bZr.zF().video_url;
            }
            this.cWx.bN(this.bQV, this.cWE.tid);
            this.cWx.setLooping(true);
            if (this.caZ != null) {
                this.caZ.start();
            }
            this.cWI = true;
            akY();
        }
    }

    public void stopPlay() {
        ald();
        alc();
        i(true, 1);
        if (this.cWx != null) {
            this.cWx.stopPlayback();
            if (this.caZ != null) {
                this.caZ.stop();
            }
        }
        this.cWI = false;
    }

    public View getVideoContainer() {
        return this.cWw;
    }

    public String getPlayUrl() {
        return this.bQV;
    }

    public int getCurrentPosition() {
        if (this.cWx == null) {
            return 0;
        }
        return this.cWx.getCurrentPosition();
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cba != null) {
            this.cba.setVideoStatsData(aaVar);
        }
    }

    public void a(c.a aVar) {
        if (this.cmv != null) {
            this.cmv.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cmj != null) {
            return this.cmj.bdX;
        }
        return null;
    }

    public View akS() {
        if (this.cmj != null) {
            return this.cmj.bdY;
        }
        return null;
    }

    public void eJ(boolean z) {
        this.cWJ = z;
    }

    public void jX(int i) {
        if (this.cWE != null && this.cWE.bZr != null) {
            if (i == 1) {
                if (this.cWE.bZr.aQu > 0) {
                    this.cmX.bez.setShowPraiseNum(false);
                    this.cmX.bez.setShareVisible(false);
                    this.cWL.setText(am.J(this.cWE.bZr.aQu));
                    this.cWL.setVisibility(0);
                } else {
                    this.cmX.bez.setShowPraiseNum(true);
                    this.cmX.bez.setShareVisible(true);
                    this.cWL.setVisibility(8);
                }
                this.cmX.setData(this.cWE.bZr);
                this.cmk.setVisibility(8);
                this.cmj.showForumNameView(false);
                return;
            }
            this.cmX.setVisibility(8);
            this.cmj.showForumNameView(true);
            if (this.cWE.bZr.aQu > 0) {
                this.cmk.setShowPraiseNum(false);
                this.cmk.setShareVisible(false);
                this.cWL.setText(am.J(this.cWE.bZr.aQu));
                this.cWL.setVisibility(0);
            } else {
                this.cmk.setShowPraiseNum(true);
                this.cmk.setShareVisible(true);
                this.cWL.setVisibility(8);
            }
            if (this.cmk.setData(this.cWE.bZr)) {
                this.cWr.setVisibility(8);
            } else {
                this.cWr.setVisibility(0);
            }
        }
    }
}
