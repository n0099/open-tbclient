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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
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
public class a extends com.baidu.tieba.card.a<bm> implements cg {
    private v.d aSx;
    private v.b aSy;
    private View aTm;
    private TbPageContext<?> aat;
    private bm aiu;
    private final View.OnClickListener amF;
    private View.OnClickListener amJ;
    private final View.OnClickListener amS;
    private HeadPendantClickableView bAv;
    private ThreadGodReplyLayout bAw;
    private AudioAnimationView bBA;
    private ProgressBar bBB;
    private ImageView bBC;
    private View bBE;
    private int bBF;
    private int bBG;
    private boolean bBH;
    private com.baidu.tieba.play.y bBJ;
    private Animation bBK;
    private Handler bBL;
    private Runnable bBM;
    private Runnable bBN;
    private QuickVideoView.b bBO;
    private y.a bBS;
    private Animation.AnimationListener bBT;
    private QuickVideoView bBv;
    private TextView bBx;
    private TextView bBy;
    private View bBz;
    private com.baidu.tieba.play.ak bDI;
    private View ben;
    public ThreadUserInfoLayout bgE;
    public ThreadCommentAndPraiseInfoLayout bgF;
    public View bgG;
    public LinearLayout bgH;
    public ThreadSkinView bgI;
    private RelativeLayout bgt;
    public FrameLayout byJ;
    private TbImageView byK;
    private ImageView byL;
    private TbImageView.a byN;
    private ViewTreeObserver.OnGlobalLayoutListener chA;
    public TextView chx;
    public LinearLayout chy;
    private com.baidu.tieba.frs.f.v chz;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bBF = 0;
        this.bBG = 1;
        this.bBH = false;
        this.bBL = new b(this, Looper.getMainLooper());
        this.aSx = new h(this);
        this.aSy = new i(this);
        this.byN = new j(this);
        this.chA = new k(this);
        this.bBM = new l(this);
        this.bBN = new m(this);
        this.bBO = new n(this);
        this.amJ = new o(this);
        this.amS = new c(this);
        this.amF = new d(this);
        this.bBS = new e(this);
        this.bBT = new f(this);
        setTag(bdUniqueId);
        this.aat = tbPageContext;
        View view = getView();
        this.aTm = view.findViewById(w.h.divider_line);
        this.bgt = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.chy = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bgt.setOnClickListener(this);
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
        this.chx = (TextView) view.findViewById(w.h.thread_info_bar_name);
        this.chx.setVisibility(8);
        this.chx.setOnClickListener(this.amJ);
        this.bBB = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bBC = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bgF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bgE = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_auto_video_user_info_layout);
        this.bgE.setFrom(3);
        this.bgG = view.findViewById(w.h.divider_below_reply_number_layout);
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
        this.bgF.setIsBarViewVisible(false);
        this.bgF.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bgF.setPraiseIcon(w.g.icon_home_card_like_n);
        this.byJ = (FrameLayout) view.findViewById(w.h.frame_video);
        this.byJ.setOnClickListener(this);
        this.byJ.addOnAttachStateChangeListener(new g(this));
        this.byK = (TbImageView) view.findViewById(w.h.image_video);
        this.byK.setPageId(getTag());
        this.byK.setDefaultErrorResource(0);
        this.byK.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.byK.setEvent(this.byN);
        this.byK.setGifIconSupport(false);
        this.byL = (ImageView) view.findViewById(w.h.image_video_play);
        this.bBA = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bBA.setCertainColumnCount(4);
        this.bBA.setColumnColor(w.e.cp_cont_i);
        this.bBv = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.bDI = new com.baidu.tieba.play.ak(this.aat.getPageActivity());
        this.bBv.setBusiness(this.bDI);
        this.bBv.setOnPreparedListener(this.aSx);
        this.bBv.setOnErrorListener(this.aSy);
        this.bBv.setOnSurfaceDestroyedListener(this.bBO);
        this.bBJ = new com.baidu.tieba.play.y();
        this.bBJ.setPlayer(this.bBv);
        this.bBJ.a(this.bBS);
        this.bBE = view.findViewById(w.h.auto_video_black_mask);
        this.bBy = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bBz = view.findViewById(w.h.auto_video_error_background);
        this.bgH = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bgI = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bBK = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.fade_out_video_cover);
        this.bBK.setAnimationListener(this.bBT);
        this.bBx = (TextView) view.findViewById(w.h.text_video_duration);
        this.chz = new com.baidu.tieba.frs.f.v(tbPageContext, this.bgE);
        this.chz.setUniqueId(getTag());
        this.ben = view.findViewById(w.h.divider_line);
        this.bAw = (ThreadGodReplyLayout) view.findViewById(w.h.card_god_reply_layout);
        this.bAw.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bgt || view == this.bgF.getCommentNumView() || view == this.chy) {
            X(this.bgt);
        } else if (view == this.byJ) {
            X(this.byJ);
        } else if (view == this.bAw) {
            X(this.bAw);
        }
        if (this.aiu != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiu));
        }
    }

    private void X(View view) {
        if (this.aiu != null) {
            if (this.aiu.sl()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10242").Z("fid", String.valueOf(this.aiu.getFid())).r("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c11100");
                auVar.Z("tid", this.aiu.getId());
                auVar.Z("fid", new StringBuilder(String.valueOf(this.aiu.getFid())).toString());
                TiebaStatic.log(auVar);
            }
            if (this.aiu.getAuthor() != null && this.aiu.getAuthor().getGodUserData() != null && this.aiu.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10806").r("obj_locate", 3).Z("tid", this.aiu.getId()));
            }
        }
        if (Vs() != null) {
            Vs().a(view, this.aiu);
        }
        if (this.aiu != null) {
            com.baidu.tieba.card.at.iI(this.aiu.getId());
            com.baidu.tbadk.core.util.as.c(this.mTextTitle, w.e.cp_cont_d, 1);
            com.baidu.tbadk.util.v.gH(this.aiu.getId());
            if (this.aiu.rN() > 0 && com.baidu.tieba.tbadkCore.util.s.bns()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aat.getPageActivity()).createHistoryCfg(this.aiu.getTid(), String.valueOf(this.aiu.rN()), false, true, com.baidu.tieba.card.at.ri());
                createHistoryCfg.setVideo_source(this.aiu.sl() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aiu.su());
                createHistoryCfg.setSmartFrsPosition(this.aiu.sA());
                createHistoryCfg.setForumId(String.valueOf(this.aiu.getFid()));
                createHistoryCfg.setStartFrom(1);
                if (view == this.bAw) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.aat.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aat.getPageActivity()).createFromThreadCfg(this.aiu, this.mForumName, com.baidu.tieba.card.at.ri(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aiu.sl() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aiu.su());
            createFromThreadCfg.setSmartFrsPosition(this.aiu.sA());
            createFromThreadCfg.setForumId(String.valueOf(this.aiu.getFid()));
            createFromThreadCfg.setStartFrom(1);
            if (view == this.bAw) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.aat.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: t */
    public void a(bm bmVar) {
        this.aiu = bmVar;
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
        this.bBL.sendEmptyMessageDelayed(202, 0L);
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
                    this.bBx.setVisibility(0);
                    this.bBK.cancel();
                    this.byK.clearAnimation();
                    this.byK.setVisibility(0);
                    this.bBE.setVisibility(0);
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
        if (this.aiu == null || this.aiu.getAuthor() == null) {
            this.bgt.setVisibility(8);
            return;
        }
        this.bgt.setVisibility(0);
        VE();
        this.aiu.e(false, true);
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.aa(this.aiu.rR()));
        this.mTextTitle.setText(this.aiu.rR());
        this.chz.L(this.aiu);
        this.bgE.a(this.aiu);
        if (this.bgE.getHeaderImg() != null) {
            if (this.bgE.getIsSimpleThread()) {
                this.bgE.getHeaderImg().setVisibility(8);
                this.bAv.setVisibility(8);
            } else if (this.aiu.getAuthor() == null || this.aiu.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiu.getAuthor().getPendantData().pI())) {
                this.bAv.setVisibility(8);
                this.bgE.getHeaderImg().setVisibility(0);
                this.bgE.getHeaderImg().setData(this.aiu);
            } else {
                this.bgE.getHeaderImg().setVisibility(4);
                this.bAv.setVisibility(0);
                this.bAv.setData(this.aiu);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bgF.setLayoutParams(layoutParams);
        this.bgE.setUserAfterClickListener(this.amS);
        if (this.bgF.a(this.aiu)) {
            this.bgG.setVisibility(8);
        } else {
            this.bgG.setVisibility(0);
        }
        this.bBx.setText(com.baidu.tbadk.core.util.aw.cV(this.aiu.rI().video_duration.intValue() * 1000));
        this.bgF.setCommentNumClickListener(this);
        this.bAw.setData(this.aiu.sE());
        this.bAw.onChangeSkinType();
        if (com.baidu.tieba.card.at.iJ(this.aiu.getId())) {
            com.baidu.tbadk.core.util.as.c(this.mTextTitle, w.e.cp_cont_d, 1);
            com.baidu.tieba.card.at.a(this.bAw.getGodReplyContent(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bAw.getPraiseNum(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.as.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        d(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VC() {
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
            if (com.baidu.tbadk.core.r.oK().oQ() && this.aiu != null && this.aiu.rI() != null) {
                this.byJ.setVisibility(0);
                this.byK.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.byK.c(this.aiu.rI().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aiu.rI().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.bDI != null && this.bDI.bcd() != null) {
                    this.bDI.bcd().d(this.aiu.rI());
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
            com.baidu.tbadk.core.util.as.c(this.byL, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.as.i(this.bBy, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.as.i(this.bBx, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.as.k(this.bBz, w.e.common_color_10014);
            com.baidu.tbadk.core.util.as.k(this.aTm, w.e.cp_bg_line_c);
            if (this.bBy != null) {
                this.bBy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bgF.onChangeSkinType();
            this.mSkinType = i;
            this.bgE.onChangeSkinType();
            this.chz.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
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
        if (!this.bBH && this.aiu != null && this.aiu.rI() != null && this.bBv != null && com.baidu.tbadk.util.aa.r(2, this.mVideoUrl)) {
            f(true, 2);
            this.bBv.setVideoPath(this.mVideoUrl);
            this.bBv.start();
            this.bBv.setLooping(true);
            if (this.bBJ != null) {
                this.bBJ.start();
            }
            this.bBH = true;
            VR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.aiu != null && this.aiu.rI() != null) {
            String str = this.aiu.sl() ? "floor5" : "frs";
            bc bcVar = new bc();
            bcVar.mLocate = str;
            bcVar.bxL = this.aiu.getTid();
            bcVar.bxM = new StringBuilder(String.valueOf(this.aiu.getFid())).toString();
            bcVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bcVar.mSource = this.aiu.YN;
            bcVar.fmw = this.aiu.YP;
            bcVar.fmx = this.aiu.YO;
            bcVar.fmy = "";
            if (this.aiu.sv() != null && this.aiu.sv().channelId > 0) {
                bcVar.UW = new StringBuilder(String.valueOf(this.aiu.sv().channelId)).toString();
            } else {
                bcVar.UW = "0";
            }
            com.baidu.tieba.play.ab.a(this.aiu.rI().video_md5, "", "1", bcVar);
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

    public void a(bc bcVar) {
        if (this.bDI != null) {
            this.bDI.a(bcVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bgF != null && this.bgE != null) {
            this.bgE.setPageUniqueId(bdUniqueId);
        }
    }
}
