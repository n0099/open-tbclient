package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.bb;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bk> implements cb {
    private v.d aRd;
    private v.b aRe;
    private boolean aSK;
    private com.baidu.tieba.play.y aSL;
    private y.a aSO;
    private com.baidu.tieba.play.aj aTI;
    private int aTN;
    private TbImageView.a aTO;
    private QuickVideoView.b aTQ;
    private Runnable aTR;
    private Handler aTT;
    private View aUr;
    private TbPageContext<?> aat;
    private bk ahV;
    private final View.OnClickListener alY;
    private View.OnClickListener amb;
    private final View.OnClickListener amk;
    public TextView bTw;
    public LinearLayout bTx;
    private com.baidu.tieba.frs.e.ae bTy;
    private ViewTreeObserver.OnGlobalLayoutListener bTz;
    private View baV;
    private RelativeLayout bcf;
    public ThreadUserInfoLayout bcp;
    public ThreadCommentAndPraiseInfoLayout bcq;
    public View bcr;
    public LinearLayout bcs;
    public ThreadSkinView bct;
    public FrameLayout buO;
    private TbImageView buP;
    private ImageView buQ;
    private HeadPendantClickableView buV;
    private QuickVideoView buW;
    private TextView buX;
    private TextView buY;
    private View buZ;
    private AudioAnimationView bva;
    private ProgressBar bvb;
    private ImageView bvc;
    private View bve;
    private int bvf;
    private Animation bvh;
    private Runnable bvi;
    private Animation.AnimationListener bvm;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTN = 0;
        this.bvf = 1;
        this.aSK = false;
        this.aTT = new b(this, Looper.getMainLooper());
        this.aRd = new h(this);
        this.aRe = new i(this);
        this.aTO = new j(this);
        this.bTz = new k(this);
        this.aTR = new l(this);
        this.bvi = new m(this);
        this.aTQ = new n(this);
        this.amb = new o(this);
        this.amk = new c(this);
        this.alY = new d(this);
        this.aSO = new e(this);
        this.bvm = new f(this);
        setTag(bdUniqueId);
        this.aat = tbPageContext;
        View view = getView();
        this.aUr = view.findViewById(w.h.divider_line);
        this.bcf = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bTx = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bcf.setOnClickListener(this);
        this.buV = (HeadPendantClickableView) this.bcf.findViewById(w.h.card_home_page_video_user_pendant_header);
        if (this.buV.getHeadView() != null) {
            this.buV.getHeadView().setIsRound(true);
            this.buV.getHeadView().setDrawBorder(false);
            this.buV.getHeadView().setDefaultResource(17170445);
            this.buV.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.buV.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.buV.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds70));
        }
        this.buV.vY();
        if (this.buV.getPendantView() != null) {
            this.buV.getPendantView().setIsRound(true);
            this.buV.getPendantView().setDrawBorder(false);
        }
        this.bTw = (TextView) view.findViewById(w.h.thread_info_bar_name);
        this.bTw.setVisibility(8);
        this.bTw.setOnClickListener(this.amb);
        this.bvb = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bvc = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bcq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bcp = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_auto_video_user_info_layout);
        this.bcr = view.findViewById(w.h.divider_below_reply_number_layout);
        if (this.bcq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcq.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bcq.setLayoutParams(layoutParams);
        }
        this.bcq.setOnClickListener(this);
        this.bcq.setReplyTimeVisible(false);
        this.bcq.setShowPraiseNum(true);
        this.bcq.setNeedAddPraiseIcon(true);
        this.bcq.setNeedAddReplyIcon(true);
        this.bcq.setIsBarViewVisible(false);
        this.bcq.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bcq.setPraiseIcon(w.g.icon_home_card_like_n);
        this.buO = (FrameLayout) view.findViewById(w.h.frame_video);
        this.buO.addOnAttachStateChangeListener(new g(this));
        this.buP = (TbImageView) view.findViewById(w.h.image_video);
        this.buP.setPageId(getTag());
        this.buP.setDefaultErrorResource(0);
        this.buP.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.buP.setEvent(this.aTO);
        this.buP.setGifIconSupport(false);
        this.buQ = (ImageView) view.findViewById(w.h.image_video_play);
        this.bva = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bva.setCertainColumnCount(4);
        this.bva.setColumnColor(w.e.cp_cont_i);
        this.buW = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aTI = new com.baidu.tieba.play.aj(this.aat.getPageActivity());
        this.buW.setBusiness(this.aTI);
        this.buW.setOnPreparedListener(this.aRd);
        this.buW.setOnErrorListener(this.aRe);
        this.buW.setOnSurfaceDestroyedListener(this.aTQ);
        this.aSL = new com.baidu.tieba.play.y();
        this.aSL.setPlayer(this.buW);
        this.aSL.a(this.aSO);
        this.bve = view.findViewById(w.h.auto_video_black_mask);
        this.buY = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.buZ = view.findViewById(w.h.auto_video_error_background);
        this.bcs = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bct = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bvh = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.fade_out_video_cover);
        this.bvh.setAnimationListener(this.bvm);
        this.buX = (TextView) view.findViewById(w.h.text_video_duration);
        this.bTy = new com.baidu.tieba.frs.e.ae(tbPageContext, this.bcp);
        this.bTy.setUniqueId(getTag());
        this.baV = view.findViewById(w.h.divider_line);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcf || view == this.bcq.getCommentNumView() || view == this.bTx) {
            M(this.bcf);
        }
        if (this.ahV != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ahV));
        }
    }

    private void M(View view) {
        if (this.ahV != null) {
            if (this.ahV.ss()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10242").aa("fid", String.valueOf(this.ahV.getFid())).s("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11100");
                asVar.aa("tid", this.ahV.getId());
                asVar.aa("fid", new StringBuilder(String.valueOf(this.ahV.getFid())).toString());
                TiebaStatic.log(asVar);
            }
            if (this.ahV.getAuthor() != null && this.ahV.getAuthor().getGodUserData() != null && this.ahV.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10806").s("obj_locate", 3).aa("tid", this.ahV.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.ahV);
        }
        if (this.ahV != null) {
            com.baidu.tieba.card.ap.hY(this.ahV.getId());
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
            com.baidu.tbadk.util.u.gn(this.ahV.getId());
            if (this.ahV.rU() > 0 && com.baidu.tieba.tbadkCore.util.s.bhK()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aat.getPageActivity()).createHistoryCfg(this.ahV.getTid(), String.valueOf(this.ahV.rU()), false, true, com.baidu.tieba.card.ap.rp());
                createHistoryCfg.setVideo_source(this.ahV.ss() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ahV.sB());
                createHistoryCfg.setSmartFrsPosition(this.ahV.sE());
                createHistoryCfg.setForumId(String.valueOf(this.ahV.getFid()));
                createHistoryCfg.setStartFrom(1);
                this.aat.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aat.getPageActivity()).createFromThreadCfg(this.ahV, this.mForumName, com.baidu.tieba.card.ap.rp(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ahV.ss() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ahV.sB());
            createFromThreadCfg.setSmartFrsPosition(this.ahV.sE());
            createFromThreadCfg.setForumId(String.valueOf(this.ahV.getFid()));
            createFromThreadCfg.setStartFrom(1);
            this.aat.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: p */
    public void onBindDataToView(bk bkVar) {
        this.ahV = bkVar;
        MM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kx() {
        this.aTT.removeMessages(202);
        if (this.buW.getCurrentPosition() > 0) {
            f(true, 3);
            this.aTT.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aTT.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ky() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTT.removeMessages(203);
        int currentPosition = this.buW.getCurrentPosition();
        if (currentPosition != this.aTN) {
            this.aTN = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.aTT.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.buQ != null && this.buP != null && this.bve != null && this.bva != null && this.bvb != null && this.bvc != null && this.buZ != null && this.buY != null) {
            if (z || this.bvf != i) {
                this.bvf = i;
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bvi);
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTR);
                if (i == 2) {
                    this.buQ.setVisibility(8);
                    this.bvh.cancel();
                    this.buP.clearAnimation();
                    this.buP.setVisibility(0);
                    this.bve.setVisibility(0);
                    this.buX.setVisibility(0);
                    this.bvb.setVisibility(0);
                    this.bvc.setVisibility(0);
                    this.buZ.setVisibility(8);
                    this.buY.setVisibility(8);
                    this.bva.setVisibility(8);
                    this.bva.bkR();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.bvi, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.buQ.setVisibility(8);
                    this.buP.startAnimation(this.bvh);
                    this.bve.setVisibility(8);
                    this.buX.setVisibility(8);
                    this.bvb.setVisibility(8);
                    this.bvc.setVisibility(8);
                    this.buZ.setVisibility(8);
                    this.buY.setVisibility(8);
                    this.bva.setVisibility(0);
                    this.bva.start();
                } else if (i == 4) {
                    this.buQ.setVisibility(8);
                    this.buP.startAnimation(this.bvh);
                    this.bve.setVisibility(8);
                    this.bvb.setVisibility(8);
                    this.bvc.setVisibility(8);
                    this.buZ.setVisibility(0);
                    this.buY.setVisibility(0);
                    this.bva.setVisibility(8);
                    this.bva.bkR();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.aTR, 2000L);
                } else {
                    this.buQ.setVisibility(0);
                    this.buX.setVisibility(0);
                    this.bvh.cancel();
                    this.buP.clearAnimation();
                    this.buP.setVisibility(0);
                    this.bve.setVisibility(0);
                    this.bvb.setVisibility(8);
                    this.bvc.setVisibility(8);
                    this.buZ.setVisibility(8);
                    this.buY.setVisibility(8);
                    this.bva.setVisibility(8);
                    this.bva.bkR();
                }
            }
        }
    }

    private void MM() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.ahV == null || this.ahV.getAuthor() == null) {
            this.bcf.setVisibility(8);
            return;
        }
        this.bcf.setVisibility(0);
        Tf();
        this.ahV.sg();
        if (this.ahV.getThreadType() == 50) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aat.getResources().getString(w.l.frs_live_play_backs)) + this.ahV.rY().toString());
        } else {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aat.getResources().getString(w.l.video_title_prefix)) + this.ahV.rY().toString());
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.aa(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        this.bTy.F(this.ahV);
        this.bcp.a(this.ahV);
        if (this.bcp.getHeaderImg() != null) {
            if (this.bcp.getIsSimpleThread()) {
                this.bcp.getHeaderImg().setVisibility(8);
                this.buV.setVisibility(8);
            } else if (this.ahV.getAuthor() == null || this.ahV.getAuthor().getPendantData() == null || StringUtils.isNull(this.ahV.getAuthor().getPendantData().pT())) {
                this.buV.setVisibility(8);
                this.bcp.getHeaderImg().setVisibility(0);
                this.bcp.getHeaderImg().setData(this.ahV);
            } else {
                this.bcp.getHeaderImg().setVisibility(4);
                this.buV.setVisibility(0);
                this.buV.setData(this.ahV);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcq.getLayoutParams();
        layoutParams.rightMargin = 0;
        this.bcq.setLayoutParams(layoutParams);
        this.bcp.setUserAfterClickListener(this.amk);
        if (this.bcq.a(this.ahV)) {
            this.bcr.setVisibility(8);
        } else {
            this.bcr.setVisibility(0);
        }
        this.buX.setText(com.baidu.tbadk.core.util.au.cS(this.ahV.rP().video_duration.intValue() * 1000));
        this.bcq.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.ap.hZ(this.ahV.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        onChangeSkinType(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sa() {
        this.aTT.removeMessages(202);
        this.aTT.removeMessages(203);
    }

    private void Sw() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTR);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bvi);
    }

    private void Tf() {
        Sw();
        Sa();
        if (this.buP != null && this.buO != null && this.buW != null) {
            if (com.baidu.tbadk.core.r.oV().pb() && this.ahV != null && this.ahV.rP() != null) {
                this.buO.setVisibility(0);
                this.buP.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.buP.c(this.ahV.rP().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.ahV.rP().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.aTI != null && this.aTI.aWB() != null) {
                    this.aTI.aWB().c(this.ahV.rP());
                    return;
                }
                return;
            }
            this.buO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bcf, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.buQ, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i(this.buY, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.buX, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.k(this.buZ, w.e.common_color_10014);
            com.baidu.tbadk.core.util.aq.k(this.aUr, w.e.cp_bg_line_c);
            if (this.buY != null) {
                this.buY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.bcq.onChangeSkinType();
            this.mSkinType = i;
            this.bcp.onChangeSkinType();
            this.bTy.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.aSK;
    }

    public boolean isPlaying() {
        if (this.buW == null) {
            return false;
        }
        return this.buW.isPlaying();
    }

    public void startPlay() {
        if (!this.aSK && this.ahV != null && this.ahV.rP() != null && this.buW != null && com.baidu.tbadk.util.z.r(2, this.mVideoUrl)) {
            f(true, 2);
            this.buW.setVideoPath(this.mVideoUrl);
            this.buW.start();
            this.buW.setLooping(true);
            if (this.aSL != null) {
                this.aSL.start();
            }
            this.aSK = true;
            JU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        if (this.ahV != null && this.ahV.rP() != null) {
            String str = this.ahV.ss() ? "floor5" : "frs";
            bb bbVar = new bb();
            bbVar.mLocate = str;
            bbVar.bti = this.ahV.getTid();
            bbVar.btj = new StringBuilder(String.valueOf(this.ahV.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.ahV.YQ;
            bbVar.eTt = this.ahV.YS;
            bbVar.eTu = this.ahV.YR;
            bbVar.eTv = "";
            if (this.ahV.sC() != null && this.ahV.sC().channelId > 0) {
                bbVar.Vk = new StringBuilder(String.valueOf(this.ahV.sC().channelId)).toString();
            } else {
                bbVar.Vk = "0";
            }
            com.baidu.tieba.play.ab.a(this.ahV.rP().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        Sw();
        Sa();
        f(true, 1);
        if (this.buW != null) {
            this.buW.stopPlayback();
            if (this.aSL != null) {
                this.aSL.stop();
            }
        }
        this.aSK = false;
    }

    public View getVideoContainer() {
        return this.buO;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.buW == null) {
            return 0;
        }
        return this.buW.getCurrentPosition();
    }

    public void a(bb bbVar) {
        if (this.aTI != null) {
            this.aTI.a(bbVar);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bcq != null && this.bcp != null) {
            this.bcp.setPageUniqueId(bdUniqueId);
        }
    }
}
