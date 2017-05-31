package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.bc;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bl> implements cg {
    private View aRT;
    private v.d aRe;
    private v.b aRf;
    private TbPageContext<?> aas;
    private bl ahM;
    private final View.OnClickListener alO;
    private View.OnClickListener alR;
    private final View.OnClickListener ama;
    private QuickVideoView bAC;
    private TextView bAE;
    private TextView bAF;
    private View bAG;
    private AudioAnimationView bAH;
    private ProgressBar bAI;
    private ImageView bAJ;
    private View bAL;
    private int bAM;
    private int bAN;
    private boolean bAO;
    private com.baidu.tieba.play.y bAQ;
    private Animation bAR;
    private Handler bAS;
    private Runnable bAT;
    private Runnable bAU;
    private QuickVideoView.b bAV;
    private y.a bAZ;
    private Animation.AnimationListener bBa;
    private com.baidu.tieba.play.ak bCP;
    public TextView bZo;
    public LinearLayout bZp;
    private com.baidu.tieba.frs.f.ae bZq;
    private ViewTreeObserver.OnGlobalLayoutListener bZr;
    private View bck;
    public ThreadUserInfoLayout bdH;
    public ThreadCommentAndPraiseInfoLayout bdI;
    public View bdJ;
    public LinearLayout bdK;
    public ThreadSkinView bdL;
    private RelativeLayout bdw;
    public FrameLayout bvY;
    private TbImageView bvZ;
    private ImageView bwa;
    private TbImageView.a bwc;
    private HeadPendantClickableView bzC;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bAM = 0;
        this.bAN = 1;
        this.bAO = false;
        this.bAS = new b(this, Looper.getMainLooper());
        this.aRe = new h(this);
        this.aRf = new i(this);
        this.bwc = new j(this);
        this.bZr = new k(this);
        this.bAT = new l(this);
        this.bAU = new m(this);
        this.bAV = new n(this);
        this.alR = new o(this);
        this.ama = new c(this);
        this.alO = new d(this);
        this.bAZ = new e(this);
        this.bBa = new f(this);
        setTag(bdUniqueId);
        this.aas = tbPageContext;
        View view = getView();
        this.aRT = view.findViewById(w.h.divider_line);
        this.bdw = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bZp = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bdw.setOnClickListener(this);
        this.bzC = (HeadPendantClickableView) this.bdw.findViewById(w.h.card_home_page_video_user_pendant_header);
        if (this.bzC.getHeadView() != null) {
            this.bzC.getHeadView().setIsRound(true);
            this.bzC.getHeadView().setDrawBorder(false);
            this.bzC.getHeadView().setDefaultResource(17170445);
            this.bzC.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bzC.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bzC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aas.getPageActivity(), w.f.ds70));
        }
        this.bzC.vV();
        if (this.bzC.getPendantView() != null) {
            this.bzC.getPendantView().setIsRound(true);
            this.bzC.getPendantView().setDrawBorder(false);
        }
        this.bZo = (TextView) view.findViewById(w.h.thread_info_bar_name);
        this.bZo.setVisibility(8);
        this.bZo.setOnClickListener(this.alR);
        this.bAI = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bAJ = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bdI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bdH = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_auto_video_user_info_layout);
        this.bdJ = view.findViewById(w.h.divider_below_reply_number_layout);
        if (this.bdI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bdI.setLayoutParams(layoutParams);
        }
        this.bdI.setOnClickListener(this);
        this.bdI.setReplyTimeVisible(false);
        this.bdI.setShowPraiseNum(true);
        this.bdI.setNeedAddPraiseIcon(true);
        this.bdI.setNeedAddReplyIcon(true);
        this.bdI.setIsBarViewVisible(false);
        this.bdI.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bdI.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bvY = (FrameLayout) view.findViewById(w.h.frame_video);
        this.bvY.setOnClickListener(this);
        this.bvY.addOnAttachStateChangeListener(new g(this));
        this.bvZ = (TbImageView) view.findViewById(w.h.image_video);
        this.bvZ.setPageId(getTag());
        this.bvZ.setDefaultErrorResource(0);
        this.bvZ.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bvZ.setEvent(this.bwc);
        this.bvZ.setGifIconSupport(false);
        this.bwa = (ImageView) view.findViewById(w.h.image_video_play);
        this.bAH = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bAH.setCertainColumnCount(4);
        this.bAH.setColumnColor(w.e.cp_cont_i);
        this.bAC = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.bCP = new com.baidu.tieba.play.ak(this.aas.getPageActivity());
        this.bAC.setBusiness(this.bCP);
        this.bAC.setOnPreparedListener(this.aRe);
        this.bAC.setOnErrorListener(this.aRf);
        this.bAC.setOnSurfaceDestroyedListener(this.bAV);
        this.bAQ = new com.baidu.tieba.play.y();
        this.bAQ.setPlayer(this.bAC);
        this.bAQ.a(this.bAZ);
        this.bAL = view.findViewById(w.h.auto_video_black_mask);
        this.bAF = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bAG = view.findViewById(w.h.auto_video_error_background);
        this.bdK = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bdL = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bAR = AnimationUtils.loadAnimation(this.aas.getPageActivity(), w.a.fade_out_video_cover);
        this.bAR.setAnimationListener(this.bBa);
        this.bAE = (TextView) view.findViewById(w.h.text_video_duration);
        this.bZq = new com.baidu.tieba.frs.f.ae(tbPageContext, this.bdH);
        this.bZq.setUniqueId(getTag());
        this.bck = view.findViewById(w.h.divider_line);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdw || view == this.bdI.getCommentNumView() || view == this.bZp) {
            W(this.bdw);
        } else if (view == this.bvY) {
            W(this.bvY);
        }
        if (this.ahM != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ahM));
        }
    }

    private void W(View view) {
        if (this.ahM != null) {
            if (this.ahM.so()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10242").Z("fid", String.valueOf(this.ahM.getFid())).r("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11100");
                asVar.Z("tid", this.ahM.getId());
                asVar.Z("fid", new StringBuilder(String.valueOf(this.ahM.getFid())).toString());
                TiebaStatic.log(asVar);
            }
            if (this.ahM.getAuthor() != null && this.ahM.getAuthor().getGodUserData() != null && this.ahM.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10806").r("obj_locate", 3).Z("tid", this.ahM.getId()));
            }
        }
        if (Ud() != null) {
            Ud().a(view, this.ahM);
        }
        if (this.ahM != null) {
            com.baidu.tieba.card.at.ib(this.ahM.getId());
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
            com.baidu.tbadk.util.u.gm(this.ahM.getId());
            if (this.ahM.rQ() > 0 && com.baidu.tieba.tbadkCore.util.s.bje()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aas.getPageActivity()).createHistoryCfg(this.ahM.getTid(), String.valueOf(this.ahM.rQ()), false, true, com.baidu.tieba.card.at.rl());
                createHistoryCfg.setVideo_source(this.ahM.so() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ahM.sw());
                createHistoryCfg.setSmartFrsPosition(this.ahM.sC());
                createHistoryCfg.setForumId(String.valueOf(this.ahM.getFid()));
                createHistoryCfg.setStartFrom(1);
                this.aas.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aas.getPageActivity()).createFromThreadCfg(this.ahM, this.mForumName, com.baidu.tieba.card.at.rl(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ahM.so() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ahM.sw());
            createFromThreadCfg.setSmartFrsPosition(this.ahM.sC());
            createFromThreadCfg.setForumId(String.valueOf(this.ahM.getFid()));
            createFromThreadCfg.setStartFrom(1);
            this.aas.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: r */
    public void a(bl blVar) {
        this.ahM = blVar;
        MU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul() {
        this.bAS.removeMessages(202);
        if (this.bAC.getCurrentPosition() > 0) {
            f(true, 3);
            this.bAS.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bAS.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Um() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bAS.removeMessages(203);
        int currentPosition = this.bAC.getCurrentPosition();
        if (currentPosition != this.bAM) {
            this.bAM = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bAS.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.bwa != null && this.bvZ != null && this.bAL != null && this.bAH != null && this.bAI != null && this.bAJ != null && this.bAG != null && this.bAF != null) {
            if (z || this.bAN != i) {
                this.bAN = i;
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bAU);
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bAT);
                if (i == 2) {
                    this.bwa.setVisibility(8);
                    this.bAR.cancel();
                    this.bvZ.clearAnimation();
                    this.bvZ.setVisibility(0);
                    this.bAL.setVisibility(0);
                    this.bAE.setVisibility(0);
                    this.bAI.setVisibility(0);
                    this.bAJ.setVisibility(0);
                    this.bAG.setVisibility(8);
                    this.bAF.setVisibility(8);
                    this.bAH.setVisibility(8);
                    this.bAH.bmp();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.bAU, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bwa.setVisibility(8);
                    this.bvZ.startAnimation(this.bAR);
                    this.bAL.setVisibility(8);
                    this.bAE.setVisibility(8);
                    this.bAI.setVisibility(8);
                    this.bAJ.setVisibility(8);
                    this.bAG.setVisibility(8);
                    this.bAF.setVisibility(8);
                    this.bAH.setVisibility(0);
                    this.bAH.start();
                } else if (i == 4) {
                    this.bwa.setVisibility(8);
                    this.bvZ.startAnimation(this.bAR);
                    this.bAL.setVisibility(8);
                    this.bAI.setVisibility(8);
                    this.bAJ.setVisibility(8);
                    this.bAG.setVisibility(0);
                    this.bAF.setVisibility(0);
                    this.bAH.setVisibility(8);
                    this.bAH.bmp();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.bAT, 2000L);
                } else {
                    this.bwa.setVisibility(0);
                    this.bAE.setVisibility(0);
                    this.bAR.cancel();
                    this.bvZ.clearAnimation();
                    this.bvZ.setVisibility(0);
                    this.bAL.setVisibility(0);
                    this.bAI.setVisibility(8);
                    this.bAJ.setVisibility(8);
                    this.bAG.setVisibility(8);
                    this.bAF.setVisibility(8);
                    this.bAH.setVisibility(8);
                    this.bAH.bmp();
                }
            }
        }
    }

    private void MU() {
        if (this.ahM == null || this.ahM.getAuthor() == null) {
            this.bdw.setVisibility(8);
            return;
        }
        this.bdw.setVisibility(0);
        Un();
        this.ahM.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.aa(this.ahM.rU()));
        this.mTextTitle.setText(this.ahM.rU());
        this.bZq.K(this.ahM);
        this.bdH.a(this.ahM);
        if (this.bdH.getHeaderImg() != null) {
            if (this.bdH.getIsSimpleThread()) {
                this.bdH.getHeaderImg().setVisibility(8);
                this.bzC.setVisibility(8);
            } else if (this.ahM.getAuthor() == null || this.ahM.getAuthor().getPendantData() == null || StringUtils.isNull(this.ahM.getAuthor().getPendantData().pL())) {
                this.bzC.setVisibility(8);
                this.bdH.getHeaderImg().setVisibility(0);
                this.bdH.getHeaderImg().setData(this.ahM);
            } else {
                this.bdH.getHeaderImg().setVisibility(4);
                this.bzC.setVisibility(0);
                this.bzC.setData(this.ahM);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdI.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bdI.setLayoutParams(layoutParams);
        this.bdH.setUserAfterClickListener(this.ama);
        if (this.bdI.a(this.ahM)) {
            this.bdJ.setVisibility(8);
        } else {
            this.bdJ.setVisibility(0);
        }
        this.bAE.setText(com.baidu.tbadk.core.util.au.cT(this.ahM.rL().video_duration.intValue() * 1000));
        this.bdI.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.at.ic(this.ahM.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        d(this.aas, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sm() {
        this.bAS.removeMessages(202);
        this.bAS.removeMessages(203);
    }

    private void SI() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bAT);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bAU);
    }

    private void Un() {
        SI();
        Sm();
        if (this.bvZ != null && this.bvY != null && this.bAC != null) {
            if (com.baidu.tbadk.core.r.oN().oT() && this.ahM != null && this.ahM.rL() != null) {
                this.bvY.setVisibility(0);
                this.bvZ.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.bvZ.c(this.ahM.rL().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.ahM.rL().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.bCP != null && this.bCP.aXS() != null) {
                    this.bCP.aXS().d(this.ahM.rL());
                    return;
                }
                return;
            }
            this.bvY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bdw, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.bwa, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i(this.bAF, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.bAE, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.k(this.bAG, w.e.common_color_10014);
            com.baidu.tbadk.core.util.aq.k(this.aRT, w.e.cp_bg_line_c);
            if (this.bAF != null) {
                this.bAF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bdI.onChangeSkinType();
            this.mSkinType = i;
            this.bdH.onChangeSkinType();
            this.bZq.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.bAO;
    }

    public boolean isPlaying() {
        if (this.bAC == null) {
            return false;
        }
        return this.bAC.isPlaying();
    }

    public void startPlay() {
        if (!this.bAO && this.ahM != null && this.ahM.rL() != null && this.bAC != null && com.baidu.tbadk.util.z.r(2, this.mVideoUrl)) {
            f(true, 2);
            this.bAC.setVideoPath(this.mVideoUrl);
            this.bAC.start();
            this.bAC.setLooping(true);
            if (this.bAQ != null) {
                this.bAQ.start();
            }
            this.bAO = true;
            UA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        if (this.ahM != null && this.ahM.rL() != null) {
            String str = this.ahM.so() ? "floor5" : "frs";
            bc bcVar = new bc();
            bcVar.mLocate = str;
            bcVar.buq = this.ahM.getTid();
            bcVar.bur = new StringBuilder(String.valueOf(this.ahM.getFid())).toString();
            bcVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bcVar.mSource = this.ahM.YM;
            bcVar.fcg = this.ahM.YO;
            bcVar.fch = this.ahM.YN;
            bcVar.fci = "";
            if (this.ahM.sx() != null && this.ahM.sx().channelId > 0) {
                bcVar.UX = new StringBuilder(String.valueOf(this.ahM.sx().channelId)).toString();
            } else {
                bcVar.UX = "0";
            }
            com.baidu.tieba.play.ab.a(this.ahM.rL().video_md5, "", "1", bcVar);
        }
    }

    public void stopPlay() {
        SI();
        Sm();
        f(true, 1);
        if (this.bAC != null) {
            this.bAC.stopPlayback();
            if (this.bAQ != null) {
                this.bAQ.stop();
            }
        }
        this.bAO = false;
    }

    public View getVideoContainer() {
        return this.bvY;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bAC == null) {
            return 0;
        }
        return this.bAC.getCurrentPosition();
    }

    public void a(bc bcVar) {
        if (this.bCP != null) {
            this.bCP.a(bcVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdI != null && this.bdH != null) {
            this.bdH.setPageUniqueId(bdUniqueId);
        }
    }
}
