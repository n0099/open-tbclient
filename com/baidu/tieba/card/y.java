package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends a<com.baidu.tieba.card.data.n> {
    private v.d aRe;
    private v.b aRf;
    private TbPageContext<?> aas;
    private final View.OnClickListener alO;
    private QuickVideoView bAC;
    private com.baidu.tieba.play.ak bAD;
    private TextView bAE;
    private TextView bAF;
    private View bAG;
    private AudioAnimationView bAH;
    private ProgressBar bAI;
    private ImageView bAJ;
    private com.baidu.tieba.card.data.n bAK;
    private View bAL;
    private int bAM;
    private int bAN;
    private boolean bAO;
    private boolean bAP;
    private com.baidu.tieba.play.y bAQ;
    private Animation bAR;
    private Handler bAS;
    private Runnable bAT;
    private Runnable bAU;
    private QuickVideoView.b bAV;
    private final View.OnClickListener bAW;
    private final View.OnClickListener bAX;
    private CustomMessageListener bAY;
    private y.a bAZ;
    private Animation.AnimationListener bBa;
    private View bck;
    public ThreadUserInfoLayout bdH;
    public ThreadCommentAndPraiseInfoLayout bdI;
    protected LinearLayout bdK;
    private RelativeLayout bdw;
    public FrameLayout bvY;
    private TbImageView bvZ;
    private ImageView bwa;
    private TbImageView.a bwc;
    private HeadPendantClickableView bzC;
    private View bzE;
    private com.baidu.tbadk.core.view.o bzF;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bzF = null;
        this.mSkinType = 3;
        this.bAM = 0;
        this.bAN = 1;
        this.bAO = false;
        this.bAP = false;
        this.bAS = new z(this, Looper.getMainLooper());
        this.aRe = new ae(this);
        this.aRf = new af(this);
        this.bwc = new ag(this);
        this.bAT = new ah(this);
        this.bAU = new ai(this);
        this.bAV = new aj(this);
        this.bAW = new ak(this);
        this.bAX = new al(this);
        this.bAY = new aa(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.alO = new ab(this);
        this.bAZ = new ac(this);
        this.bBa = new ad(this);
        this.aas = tbPageContext;
        View view = getView();
        this.bdw = (RelativeLayout) view.findViewById(w.h.layout_root);
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
        this.bAI = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bAJ = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bdH = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_auto_video_user_info_layout);
        this.bzF = new com.baidu.tbadk.core.view.o(this.aas);
        this.bzF.wa();
        this.bzF.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bdH.addView(this.bzF);
        this.bdI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
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
        this.bdI.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bdI.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bdI.setForumAfterClickListener(this.alO);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bvY = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bvY.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.af(this.aas.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aas.getPageActivity(), w.f.ds80);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.bvY.setLayoutParams(layoutParams2);
        this.bvZ = (TbImageView) view.findViewById(w.h.image_video);
        this.bvZ.setDefaultErrorResource(0);
        this.bvZ.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bvZ.setGifIconSupport(false);
        this.bvZ.setEvent(this.bwc);
        this.bwa = (ImageView) view.findViewById(w.h.image_video_play);
        this.bAH = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bAH.setCertainColumnCount(4);
        this.bAH.setColumnColor(w.e.cp_cont_i);
        this.bdw.setOnClickListener(this);
        this.bAC = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.bAD = new com.baidu.tieba.play.ak(this.aas.getPageActivity());
        this.bAC.setBusiness(this.bAD);
        this.bAC.setOnPreparedListener(this.aRe);
        this.bAC.setOnErrorListener(this.aRf);
        this.bAC.setOnSurfaceDestroyedListener(this.bAV);
        this.bAQ = new com.baidu.tieba.play.y();
        this.bAQ.setPlayer(this.bAC);
        this.bAQ.a(this.bAZ);
        this.bAE = (TextView) view.findViewById(w.h.text_video_duration);
        this.bAL = view.findViewById(w.h.auto_video_black_mask);
        this.bAF = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bAG = view.findViewById(w.h.auto_video_error_background);
        this.bdK = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bAR = AnimationUtils.loadAnimation(this.aas.getPageActivity(), w.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bAR.setAnimationListener(this.bBa);
        this.bck = view.findViewById(w.h.divider_line);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdw) {
            W(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void W(View view) {
        if (Ud() != null) {
            Ud().a(view, this.bAK);
        }
        if (this.bAK != null && this.bAK.aYA != null) {
            if (!Uh()) {
                at.ib(this.bAK.aYA.getId());
                at.a(this.mTextTitle, this.bAK.aYA.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aas.getPageActivity()).createFromThreadCfg(this.bAK.aYA, null, at.rl(), 18003, true, false, false).addLocateParam(this.bAK.UC());
            addLocateParam.setVideo_source(this.bAK.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bAK.aYA.getFid()));
            addLocateParam.setForumName(this.bAK.aYA.rz());
            if (this.bAK.bDb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bAK.bDb);
            }
            this.aas.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Uh() {
        return this.bAK.bDt && !this.bAK.bDH;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bAK = nVar;
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
        this.bAS.sendEmptyMessageDelayed(202, 300L);
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
                    this.bAR.cancel();
                    this.bvZ.clearAnimation();
                    this.bvZ.setVisibility(0);
                    this.bAL.setVisibility(0);
                    this.bAE.setVisibility(0);
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
        String string;
        if (this.bAK == null || this.bAK.aYA == null || this.bAK.aYA.getAuthor() == null) {
            this.bdw.setVisibility(8);
            return;
        }
        this.bdw.setVisibility(0);
        Un();
        if (!Uh() && at.ic(this.bAK.aYA.getId())) {
            at.a(this.mTextTitle, this.bAK.aYA.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
        this.bAK.LH().sc();
        if (this.bAK.aYA.sx() != null && this.bAK.aYA.sx().channelId > 0) {
            string = this.aas.getResources().getString(w.l.channel_title_prefix);
        } else if (this.bAK.aYA.getThreadType() == 50) {
            string = this.aas.getResources().getString(w.l.ala_record_title_prefix);
        } else {
            string = this.aas.getResources().getString(w.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + ((Object) this.bAK.LH().rU()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.bdH.a(this.bAK.LH());
        this.bdH.setUserAfterClickListener(this.bAW);
        if (this.bdH.getHeaderImg() != null) {
            this.bdH.getHeaderImg().setAfterClickListener(this.bAX);
            if (this.bdH.getIsSimpleThread()) {
                this.bdH.getHeaderImg().setVisibility(8);
                this.bzC.setVisibility(8);
            } else if (this.bAK.LH() == null || this.bAK.LH().getAuthor() == null || this.bAK.LH().getAuthor().getPendantData() == null || StringUtils.isNull(this.bAK.LH().getAuthor().getPendantData().pL())) {
                this.bzC.setVisibility(8);
                this.bdH.getHeaderImg().setVisibility(0);
                this.bdH.getHeaderImg().setData(this.bAK.LH());
            } else {
                this.bdH.getHeaderImg().setVisibility(4);
                this.bzC.setVisibility(0);
                this.bzC.setData(this.bAK.LH());
            }
        }
        if (this.bdI.a(this.bAK.aYA)) {
            this.bzE.setVisibility(8);
        } else {
            this.bzE.setVisibility(0);
        }
        this.bAE.setText(com.baidu.tbadk.core.util.au.cT(this.bAK.aYA.rL().video_duration.intValue() * 1000));
        if (this.bzF != null && this.bAK.LH() != null) {
            com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
            anVar.co(this.bAK.LH().getTid());
            anVar.setFid(this.bAK.LH().getFid());
            anVar.a(this.bAK.Wh);
            this.bzF.setData(anVar);
        }
        d(this.aas, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.ic(this.bAK.aYA.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
    }

    private void Sm() {
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
            if (com.baidu.tbadk.core.r.oN().oT() && this.bAK != null && this.bAK.aYA != null && this.bAK.aYA.rL() != null) {
                this.bvZ.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.bvZ.c(this.bAK.aYA.rL().thumbnail_url, 10, false);
                this.bvY.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bAK.aYA.rL().video_url;
                if (StringUtils.isNull(this.bAK.aYA.rL().video_url)) {
                    f(true, 4);
                }
                if (this.bAD != null && this.bAD.aXS() != null) {
                    this.bAD.aXS().d(this.bAK.aYA.rL());
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
            com.baidu.tbadk.core.util.aq.c(this.bwa, w.g.home_ic_video);
            com.baidu.tbadk.core.util.aq.i(this.bAF, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.bAE, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.k(this.bAG, w.e.common_color_10014);
            if (this.bAF != null) {
                this.bAF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            com.baidu.tbadk.core.util.aq.j(this.bck, w.e.cp_bg_line_c);
            if (this.bzF != null) {
                this.bzF.onChangeSkinType();
            }
            this.bdH.onChangeSkinType();
            this.bdI.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bAY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bAY);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdH != null) {
            this.bdH.setPageUniqueId(bdUniqueId);
        }
        if (this.bvZ != null) {
            this.bvZ.setPageId(bdUniqueId);
        }
        if (this.bzF != null) {
            this.bzF.setUniqueId(bdUniqueId);
        }
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
        if (!this.bAO && this.bAK != null && this.bAK.aYA != null && this.bAK.aYA.rL() != null && this.bAC != null && com.baidu.tbadk.util.z.r(1, this.mVideoUrl)) {
            f(true, 2);
            this.bAC.setVideoPath(this.mVideoUrl);
            this.bAC.start();
            this.bAC.setLooping(true);
            if (this.bAQ != null) {
                this.bAQ.start();
            }
            this.bAO = true;
            com.baidu.tieba.play.bc bcVar = new com.baidu.tieba.play.bc();
            bcVar.mLocate = this.bAK.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
            bcVar.buq = this.bAK.aYA.getTid();
            bcVar.bur = new StringBuilder(String.valueOf(this.bAK.aYA.getFid())).toString();
            bcVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bcVar.mSource = this.bAK.aYA.YM;
            bcVar.fcg = this.bAK.aYA.YO;
            bcVar.fch = this.bAK.aYA.YN;
            bcVar.fci = "";
            if (this.bAK.aYA.sx() != null && this.bAK.aYA.sx().channelId > 0) {
                bcVar.UX = new StringBuilder(String.valueOf(this.bAK.aYA.sx().channelId)).toString();
            } else {
                bcVar.UX = "0";
            }
            com.baidu.tieba.play.ab.a(this.bAK.aYA.rL().video_md5, "", "1", bcVar);
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

    public void a(com.baidu.tieba.play.bc bcVar) {
        if (this.bAD != null) {
            this.bAD.a(bcVar);
        }
    }

    public void a(o.a aVar) {
        if (this.bzF != null) {
            this.bzF.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bdH != null) {
            return this.bdH.alV;
        }
        return null;
    }

    public View Ug() {
        if (this.bdH != null) {
            return this.bdH.alW;
        }
        return null;
    }
}
