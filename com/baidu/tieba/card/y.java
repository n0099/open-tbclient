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
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
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
    private v.d aSx;
    private v.b aSy;
    private TbPageContext<?> aat;
    private final View.OnClickListener amF;
    private HeadPendantClickableView bAv;
    private ThreadGodReplyLayout bAw;
    private View bAx;
    private com.baidu.tbadk.core.view.o bAy;
    private AudioAnimationView bBA;
    private ProgressBar bBB;
    private ImageView bBC;
    private com.baidu.tieba.card.data.n bBD;
    private View bBE;
    private int bBF;
    private int bBG;
    private boolean bBH;
    private boolean bBI;
    private com.baidu.tieba.play.y bBJ;
    private Animation bBK;
    private Handler bBL;
    private Runnable bBM;
    private Runnable bBN;
    private QuickVideoView.b bBO;
    private final View.OnClickListener bBP;
    private final View.OnClickListener bBQ;
    private CustomMessageListener bBR;
    private y.a bBS;
    private Animation.AnimationListener bBT;
    private QuickVideoView bBv;
    private com.baidu.tieba.play.ak bBw;
    private TextView bBx;
    private TextView bBy;
    private View bBz;
    private View ben;
    public ThreadUserInfoLayout bgE;
    public ThreadCommentAndPraiseInfoLayout bgF;
    protected LinearLayout bgH;
    private RelativeLayout bgt;
    public FrameLayout byJ;
    private TbImageView byK;
    private ImageView byL;
    private TbImageView.a byN;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bAy = null;
        this.mSkinType = 3;
        this.bBF = 0;
        this.bBG = 1;
        this.bBH = false;
        this.bBI = false;
        this.bBL = new z(this, Looper.getMainLooper());
        this.aSx = new ae(this);
        this.aSy = new af(this);
        this.byN = new ag(this);
        this.bBM = new ah(this);
        this.bBN = new ai(this);
        this.bBO = new aj(this);
        this.bBP = new ak(this);
        this.bBQ = new al(this);
        this.bBR = new aa(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.amF = new ab(this);
        this.bBS = new ac(this);
        this.bBT = new ad(this);
        this.aat = tbPageContext;
        View view = getView();
        this.bgt = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bAv = (HeadPendantClickableView) this.bgt.findViewById(w.h.card_home_page_video_user_pendant_header);
        if (this.bAv.getHeadView() != null) {
            this.bAv.getHeadView().setIsRound(true);
            this.bAv.getHeadView().setDrawBorder(false);
            this.bAv.getHeadView().setDefaultResource(17170445);
            this.bAv.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bAv.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bAv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds70));
        }
        this.bAv.wm();
        if (this.bAv.getPendantView() != null) {
            this.bAv.getPendantView().setIsRound(true);
            this.bAv.getPendantView().setDrawBorder(false);
        }
        this.bBB = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bBC = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bgE = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_auto_video_user_info_layout);
        this.bAy = new com.baidu.tbadk.core.view.o(this.aat);
        this.bAy.wr();
        this.bAy.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bgE.addView(this.bAy);
        this.bgF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        if (this.bgF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bgF.setLayoutParams(layoutParams);
        }
        this.bgF.setOnClickListener(this);
        this.bgF.setReplyTimeVisible(false);
        this.bgF.setShowPraiseNum(true);
        this.bgF.setNeedAddPraiseIcon(true);
        this.bgF.setNeedAddReplyIcon(true);
        this.bgF.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bgF.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bgF.setForumAfterClickListener(this.amF);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
        this.byJ = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.byJ.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds80);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.byJ.setLayoutParams(layoutParams2);
        this.byK = (TbImageView) view.findViewById(w.h.image_video);
        this.byK.setDefaultErrorResource(0);
        this.byK.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.byK.setGifIconSupport(false);
        this.byK.setEvent(this.byN);
        this.byL = (ImageView) view.findViewById(w.h.image_video_play);
        this.bBA = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bBA.setCertainColumnCount(4);
        this.bBA.setColumnColor(w.e.cp_cont_i);
        this.bgt.setOnClickListener(this);
        this.bBv = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.bBw = new com.baidu.tieba.play.ak(this.aat.getPageActivity());
        this.bBv.setBusiness(this.bBw);
        this.bBv.setOnPreparedListener(this.aSx);
        this.bBv.setOnErrorListener(this.aSy);
        this.bBv.setOnSurfaceDestroyedListener(this.bBO);
        this.bBJ = new com.baidu.tieba.play.y();
        this.bBJ.setPlayer(this.bBv);
        this.bBJ.a(this.bBS);
        this.bBx = (TextView) view.findViewById(w.h.text_video_duration);
        this.bBE = view.findViewById(w.h.auto_video_black_mask);
        this.bBy = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bBz = view.findViewById(w.h.auto_video_error_background);
        this.bgH = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bBK = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bBK.setAnimationListener(this.bBT);
        this.ben = view.findViewById(w.h.divider_line);
        this.bAw = (ThreadGodReplyLayout) view.findViewById(w.h.card_god_reply_layout);
        this.bAw.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bgt || view == this.bAw) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void X(View view) {
        if (Vs() != null) {
            Vs().a(view, this.bBD);
        }
        if (this.bBD != null && this.bBD.bai != null) {
            if (!Vw()) {
                at.iI(this.bBD.bai.getId());
                at.a(this.mTextTitle, this.bBD.bai.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aat.getPageActivity()).createFromThreadCfg(this.bBD.bai, null, at.ri(), 18003, true, false, false).addLocateParam(this.bBD.VT());
            addLocateParam.setVideo_source(this.bBD.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bBD.bai.getFid()));
            addLocateParam.setForumName(this.bBD.bai.rw());
            if (this.bBD.bDU == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bBD.bDU);
            }
            if (view == this.bAw) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aat.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Vw() {
        return this.bBD.bEm && !this.bBD.bEA;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        this.bBD = nVar;
        Oh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        this.bBL.removeMessages(202);
        if (this.bBv.getCurrentPosition() > 0) {
            f(true, 3);
            this.bBL.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.bBL.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.bBL.removeMessages(203);
        int currentPosition = this.bBv.getCurrentPosition();
        if (currentPosition != this.bBF) {
            this.bBF = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.bBL.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.byL != null && this.byK != null && this.bBE != null && this.bBA != null && this.bBB != null && this.bBC != null && this.bBz != null && this.bBy != null) {
            if (z || this.bBG != i) {
                this.bBG = i;
                com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bBN);
                com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bBM);
                if (i == 2) {
                    this.byL.setVisibility(8);
                    this.bBK.cancel();
                    this.byK.clearAnimation();
                    this.byK.setVisibility(0);
                    this.bBE.setVisibility(0);
                    this.bBx.setVisibility(0);
                    this.bBB.setVisibility(0);
                    this.bBC.setVisibility(0);
                    this.bBz.setVisibility(8);
                    this.bBy.setVisibility(8);
                    this.bBA.setVisibility(8);
                    this.bBA.bqz();
                    com.baidu.adp.lib.g.h.fR().postDelayed(this.bBN, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.byL.setVisibility(8);
                    this.byK.startAnimation(this.bBK);
                    this.bBE.setVisibility(8);
                    this.bBx.setVisibility(8);
                    this.bBB.setVisibility(8);
                    this.bBC.setVisibility(8);
                    this.bBz.setVisibility(8);
                    this.bBy.setVisibility(8);
                    this.bBA.setVisibility(0);
                    this.bBA.start();
                } else if (i == 4) {
                    this.byL.setVisibility(8);
                    this.byK.startAnimation(this.bBK);
                    this.bBE.setVisibility(8);
                    this.bBB.setVisibility(8);
                    this.bBC.setVisibility(8);
                    this.bBz.setVisibility(0);
                    this.bBy.setVisibility(0);
                    this.bBA.setVisibility(8);
                    this.bBA.bqz();
                    com.baidu.adp.lib.g.h.fR().postDelayed(this.bBM, 2000L);
                } else {
                    this.byL.setVisibility(0);
                    this.bBK.cancel();
                    this.byK.clearAnimation();
                    this.byK.setVisibility(0);
                    this.bBE.setVisibility(0);
                    this.bBx.setVisibility(0);
                    this.bBB.setVisibility(8);
                    this.bBC.setVisibility(8);
                    this.bBz.setVisibility(8);
                    this.bBy.setVisibility(8);
                    this.bBA.setVisibility(8);
                    this.bBA.bqz();
                }
            }
        }
    }

    private void Oh() {
        String string;
        if (this.bBD == null || this.bBD.bai == null || this.bBD.bai.getAuthor() == null) {
            this.bgt.setVisibility(8);
            return;
        }
        this.bgt.setVisibility(0);
        VE();
        if (!Vw() && at.iJ(this.bBD.bai.getId())) {
            at.a(this.mTextTitle, this.bBD.bai.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            at.a(this.bAw.getGodReplyContent(), this.bBD.Mv().getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            at.a(this.bAw.getPraiseNum(), this.bBD.Mv().getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        }
        this.bBD.Mv().rZ();
        if (this.bBD.bai.sv() != null && this.bBD.bai.sv().channelId > 0) {
            string = this.aat.getResources().getString(w.l.channel_title_prefix);
        } else if (this.bBD.bai.getThreadType() == 50) {
            string = this.aat.getResources().getString(w.l.ala_record_title_prefix);
        } else {
            string = this.aat.getResources().getString(w.l.video_title_prefix);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + ((Object) this.bBD.Mv().rR()));
        if (!TextUtils.isEmpty(string)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c)), 0, string.length(), 33);
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.bgE.a(this.bBD.Mv());
        this.bgE.setUserAfterClickListener(this.bBP);
        if (this.bgE.getHeaderImg() != null) {
            this.bgE.getHeaderImg().setAfterClickListener(this.bBQ);
            if (this.bgE.getIsSimpleThread()) {
                this.bgE.getHeaderImg().setVisibility(8);
                this.bAv.setVisibility(8);
            } else if (this.bBD.Mv() == null || this.bBD.Mv().getAuthor() == null || this.bBD.Mv().getAuthor().getPendantData() == null || StringUtils.isNull(this.bBD.Mv().getAuthor().getPendantData().pI())) {
                this.bAv.setVisibility(8);
                this.bgE.getHeaderImg().setVisibility(0);
                this.bgE.getHeaderImg().setData(this.bBD.Mv());
            } else {
                this.bgE.getHeaderImg().setVisibility(4);
                this.bAv.setVisibility(0);
                this.bAv.setData(this.bBD.Mv());
            }
        }
        if (this.bgF.a(this.bBD.bai)) {
            this.bAx.setVisibility(8);
        } else {
            this.bAx.setVisibility(0);
        }
        this.bBx.setText(com.baidu.tbadk.core.util.aw.cV(this.bBD.bai.rI().video_duration.intValue() * 1000));
        if (this.bAy != null && this.bBD.Mv() != null) {
            com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
            aoVar.cu(this.bBD.Mv().getTid());
            aoVar.setFid(this.bBD.Mv().getFid());
            aoVar.a(this.bBD.Wh);
            this.bAy.setData(aoVar);
        }
        this.bAw.setData(this.bBD.Mv().sE());
        this.bAw.onChangeSkinType();
        d(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.iJ(this.bBD.bai.getId())) {
            com.baidu.tbadk.core.util.as.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.as.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
    }

    private void VC() {
        this.bBL.removeMessages(202);
        this.bBL.removeMessages(203);
    }

    private void VD() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bBM);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bBN);
    }

    private void VE() {
        VD();
        VC();
        if (this.byK != null && this.byJ != null && this.bBv != null) {
            if (com.baidu.tbadk.core.r.oK().oQ() && this.bBD != null && this.bBD.bai != null && this.bBD.bai.rI() != null) {
                this.byK.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.byK.c(this.bBD.bai.rI().thumbnail_url, 10, false);
                this.byJ.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bBD.bai.rI().video_url;
                if (StringUtils.isNull(this.bBD.bai.rI().video_url)) {
                    f(true, 4);
                }
                if (this.bBw != null && this.bBw.bcd() != null) {
                    this.bBw.bcd().d(this.bBD.bai.rI());
                    return;
                }
                return;
            }
            this.byJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(this.bgt, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.as.c(this.byL, w.g.home_ic_video);
            com.baidu.tbadk.core.util.as.i(this.bBy, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.as.i(this.bBx, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.as.k(this.bBz, w.e.common_color_10014);
            if (this.bBy != null) {
                this.bBy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            com.baidu.tbadk.core.util.as.j(this.ben, w.e.cp_bg_line_c);
            if (this.bAy != null) {
                this.bAy.onChangeSkinType();
            }
            this.bgE.onChangeSkinType();
            this.bgF.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bBR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bBR);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bgE != null) {
            this.bgE.setPageUniqueId(bdUniqueId);
        }
        if (this.byK != null) {
            this.byK.setPageId(bdUniqueId);
        }
        if (this.bAy != null) {
            this.bAy.setUniqueId(bdUniqueId);
        }
    }

    public boolean isPlayStarted() {
        return this.bBH;
    }

    public boolean isPlaying() {
        if (this.bBv == null) {
            return false;
        }
        return this.bBv.isPlaying();
    }

    public void startPlay() {
        if (!this.bBH && this.bBD != null && this.bBD.bai != null && this.bBD.bai.rI() != null && this.bBv != null && com.baidu.tbadk.util.aa.r(1, this.mVideoUrl)) {
            f(true, 2);
            this.bBv.setVideoPath(this.mVideoUrl);
            this.bBv.start();
            this.bBv.setLooping(true);
            if (this.bBJ != null) {
                this.bBJ.start();
            }
            this.bBH = true;
            com.baidu.tieba.play.bc bcVar = new com.baidu.tieba.play.bc();
            bcVar.mLocate = this.bBD.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
            bcVar.bxL = this.bBD.bai.getTid();
            bcVar.bxM = new StringBuilder(String.valueOf(this.bBD.bai.getFid())).toString();
            bcVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bcVar.mSource = this.bBD.bai.YN;
            bcVar.fmw = this.bBD.bai.YP;
            bcVar.fmx = this.bBD.bai.YO;
            bcVar.fmy = "";
            if (this.bBD.bai.sv() != null && this.bBD.bai.sv().channelId > 0) {
                bcVar.UW = new StringBuilder(String.valueOf(this.bBD.bai.sv().channelId)).toString();
            } else {
                bcVar.UW = "0";
            }
            com.baidu.tieba.play.ab.a(this.bBD.bai.rI().video_md5, "", "1", bcVar);
        }
    }

    public void stopPlay() {
        VD();
        VC();
        f(true, 1);
        if (this.bBv != null) {
            this.bBv.stopPlayback();
            if (this.bBJ != null) {
                this.bBJ.stop();
            }
        }
        this.bBH = false;
    }

    public View getVideoContainer() {
        return this.byJ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bBv == null) {
            return 0;
        }
        return this.bBv.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bc bcVar) {
        if (this.bBw != null) {
            this.bBw.a(bcVar);
        }
    }

    public void a(o.a aVar) {
        if (this.bAy != null) {
            this.bAy.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bgE != null) {
            return this.bgE.amN;
        }
        return null;
    }

    public View Vv() {
        if (this.bgE != null) {
            return this.bgE.amO;
        }
        return null;
    }
}
