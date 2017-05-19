package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
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
public class u extends a<com.baidu.tieba.card.data.n> {
    private v.d aRd;
    private v.b aRe;
    private boolean aSK;
    private com.baidu.tieba.play.y aSL;
    private com.baidu.tieba.play.aj aSM;
    private y.a aSO;
    private int aTN;
    private TbImageView.a aTO;
    private QuickVideoView.b aTQ;
    private Runnable aTR;
    private Handler aTT;
    private TbPageContext<?> aat;
    private final View.OnClickListener alY;
    private View baV;
    private RelativeLayout bcf;
    public ThreadUserInfoLayout bcp;
    public ThreadCommentAndPraiseInfoLayout bcq;
    protected LinearLayout bcs;
    public FrameLayout buO;
    private TbImageView buP;
    private ImageView buQ;
    private View buR;
    private com.baidu.tbadk.core.view.o buS;
    private HeadPendantClickableView buV;
    private QuickVideoView buW;
    private TextView buX;
    private TextView buY;
    private View buZ;
    private AudioAnimationView bva;
    private ProgressBar bvb;
    private ImageView bvc;
    private com.baidu.tieba.card.data.n bvd;
    private View bve;
    private int bvf;
    private boolean bvg;
    private Animation bvh;
    private Runnable bvi;
    private final View.OnClickListener bvj;
    private final View.OnClickListener bvk;
    private CustomMessageListener bvl;
    private Animation.AnimationListener bvm;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.buS = null;
        this.mSkinType = 3;
        this.aTN = 0;
        this.bvf = 1;
        this.aSK = false;
        this.bvg = false;
        this.aTT = new v(this, Looper.getMainLooper());
        this.aRd = new aa(this);
        this.aRe = new ab(this);
        this.aTO = new ac(this);
        this.aTR = new ad(this);
        this.bvi = new ae(this);
        this.aTQ = new af(this);
        this.bvj = new ag(this);
        this.bvk = new ah(this);
        this.bvl = new w(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.alY = new x(this);
        this.aSO = new y(this);
        this.bvm = new z(this);
        this.aat = tbPageContext;
        View view = getView();
        this.bcf = (RelativeLayout) view.findViewById(w.h.layout_root);
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
        this.bvb = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bvc = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bcp = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_auto_video_user_info_layout);
        this.buS = new com.baidu.tbadk.core.view.o(this.aat);
        this.buS.wd();
        this.buS.setLeftPadding((int) getContext().getResources().getDimension(w.f.ds60));
        this.bcp.addView(this.buS);
        this.bcq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
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
        this.bcq.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bcq.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bcq.setForumAfterClickListener(this.alY);
        this.buR = view.findViewById(w.h.divider_below_reply_number_layout);
        this.buO = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.buO.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.k.af(this.aat.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aat.getPageActivity(), w.f.ds80);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.buO.setLayoutParams(layoutParams2);
        this.buP = (TbImageView) view.findViewById(w.h.image_video);
        this.buP.setDefaultErrorResource(0);
        this.buP.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.buP.setGifIconSupport(false);
        this.buP.setEvent(this.aTO);
        this.buQ = (ImageView) view.findViewById(w.h.image_video_play);
        this.bva = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bva.setCertainColumnCount(4);
        this.bva.setColumnColor(w.e.cp_cont_i);
        this.bcf.setOnClickListener(this);
        this.buW = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aSM = new com.baidu.tieba.play.aj(this.aat.getPageActivity());
        this.buW.setBusiness(this.aSM);
        this.buW.setOnPreparedListener(this.aRd);
        this.buW.setOnErrorListener(this.aRe);
        this.buW.setOnSurfaceDestroyedListener(this.aTQ);
        this.aSL = new com.baidu.tieba.play.y();
        this.aSL.setPlayer(this.buW);
        this.aSL.a(this.aSO);
        this.buX = (TextView) view.findViewById(w.h.text_video_duration);
        this.bve = view.findViewById(w.h.auto_video_black_mask);
        this.buY = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.buZ = view.findViewById(w.h.auto_video_error_background);
        this.bcs = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bvh = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bvh.setAnimationListener(this.bvm);
        this.baV = view.findViewById(w.h.divider_line);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcf) {
            M(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    private void M(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bvd);
        }
        if (this.bvd != null && this.bvd.bcB != null) {
            if (!Te()) {
                ap.hY(this.bvd.bcB.getId());
                ap.a(this.mTextTitle, this.bvd.bcB.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aat.getPageActivity()).createFromThreadCfg(this.bvd.bcB, null, ap.rp(), 18003, true, false, false).addLocateParam(this.bvd.Tr());
            addLocateParam.setVideo_source(this.bvd.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe");
            addLocateParam.setForumId(String.valueOf(this.bvd.bcB.getFid()));
            if (this.bvd.bxe == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bvd.bxe);
            }
            this.aat.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Te() {
        return this.bvd.bxx && !this.bvd.bxL;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        this.bvd = nVar;
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
        this.aTT.sendEmptyMessageDelayed(202, 300L);
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
                    this.bvh.cancel();
                    this.buP.clearAnimation();
                    this.buP.setVisibility(0);
                    this.bve.setVisibility(0);
                    this.buX.setVisibility(0);
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
        if (this.bvd == null || this.bvd.bcB == null || this.bvd.bcB.getAuthor() == null) {
            this.bcf.setVisibility(8);
            return;
        }
        this.bcf.setVisibility(0);
        Tf();
        if (!Te() && ap.hZ(this.bvd.bcB.getId())) {
            ap.a(this.mTextTitle, this.bvd.bcB.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
        if (this.bvd.bcB.sC() != null && this.bvd.bcB.sC().channelId > 0) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aat.getResources().getString(w.l.frs_channel_tip)) + this.bvd.bcB.getTitle());
        } else if (this.bvd.bcB.getThreadType() == 50) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aat.getResources().getString(w.l.ala_record_title_prefix)) + this.bvd.bcB.getTitle());
        } else {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aat.getResources().getString(w.l.video_title_prefix)) + this.bvd.bcB.getTitle());
        }
        this.mTextTitle.setText(spannableStringBuilder);
        this.bcp.a(this.bvd.JB());
        this.bcp.setUserAfterClickListener(this.bvj);
        if (this.bcp.getHeaderImg() != null) {
            this.bcp.getHeaderImg().setAfterClickListener(this.bvk);
            if (this.bcp.getIsSimpleThread()) {
                this.bcp.getHeaderImg().setVisibility(8);
                this.buV.setVisibility(8);
            } else if (this.bvd.JB() == null || this.bvd.JB().getAuthor() == null || this.bvd.JB().getAuthor().getPendantData() == null || StringUtils.isNull(this.bvd.JB().getAuthor().getPendantData().pT())) {
                this.buV.setVisibility(8);
                this.bcp.getHeaderImg().setVisibility(0);
                this.bcp.getHeaderImg().setData(this.bvd.JB());
            } else {
                this.bcp.getHeaderImg().setVisibility(4);
                this.buV.setVisibility(0);
                this.buV.setData(this.bvd.JB());
            }
        }
        if (this.bcq.a(this.bvd.bcB)) {
            this.buR.setVisibility(8);
        } else {
            this.buR.setVisibility(0);
        }
        this.buX.setText(com.baidu.tbadk.core.util.au.cS(this.bvd.bcB.rP().video_duration.intValue() * 1000));
        if (this.buS != null && this.bvd.JB() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.cp(this.bvd.JB().getTid());
            amVar.setFid(this.bvd.JB().getFid());
            amVar.a(this.bvd.Wm);
            this.buS.setData(amVar);
        }
        onChangeSkinType(this.aat, TbadkCoreApplication.m9getInst().getSkinType());
        if (ap.hZ(this.bvd.bcB.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
    }

    private void Sa() {
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
            if (com.baidu.tbadk.core.r.oV().pb() && this.bvd != null && this.bvd.bcB != null && this.bvd.bcB.rP() != null) {
                this.buP.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.buP.c(this.bvd.bcB.rP().thumbnail_url, 10, false);
                this.buO.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bvd.bcB.rP().video_url;
                if (StringUtils.isNull(this.bvd.bcB.rP().video_url)) {
                    f(true, 4);
                }
                if (this.aSM != null && this.aSM.aWB() != null) {
                    this.aSM.aWB().c(this.bvd.bcB.rP());
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
            com.baidu.tbadk.core.util.aq.c(this.buQ, w.g.home_ic_video);
            com.baidu.tbadk.core.util.aq.i(this.buY, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.buX, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.k(this.buZ, w.e.common_color_10014);
            if (this.buY != null) {
                this.buY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            com.baidu.tbadk.core.util.aq.j(this.baV, w.e.cp_bg_line_c);
            if (this.buS != null) {
                this.buS.onChangeSkinType();
            }
            this.bcp.onChangeSkinType();
            this.bcq.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bvl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bvl);
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bcp != null) {
            this.bcp.setPageUniqueId(bdUniqueId);
        }
        if (this.buP != null) {
            this.buP.setPageId(bdUniqueId);
        }
        if (this.buS != null) {
            this.buS.setUniqueId(bdUniqueId);
        }
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
        if (!this.aSK && this.bvd != null && this.bvd.bcB != null && this.bvd.bcB.rP() != null && this.buW != null && com.baidu.tbadk.util.z.r(1, this.mVideoUrl)) {
            f(true, 2);
            this.buW.setVideoPath(this.mVideoUrl);
            this.buW.start();
            this.buW.setLooping(true);
            if (this.aSL != null) {
                this.aSL.start();
            }
            this.aSK = true;
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = this.bvd.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
            bbVar.bti = this.bvd.bcB.getTid();
            bbVar.btj = new StringBuilder(String.valueOf(this.bvd.bcB.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.bvd.bcB.YQ;
            bbVar.eTt = this.bvd.bcB.YS;
            bbVar.eTu = this.bvd.bcB.YR;
            bbVar.eTv = "";
            if (this.bvd.bcB.sC() != null && this.bvd.bcB.sC().channelId > 0) {
                bbVar.Vk = new StringBuilder(String.valueOf(this.bvd.bcB.sC().channelId)).toString();
            } else {
                bbVar.Vk = "0";
            }
            com.baidu.tieba.play.ab.a(this.bvd.bcB.rP().video_md5, "", "1", bbVar);
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

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aSM != null) {
            this.aSM.a(bbVar);
        }
    }

    public void a(o.a aVar) {
        if (this.buS != null) {
            this.buS.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bcp != null) {
            return this.bcp.amf;
        }
        return null;
    }

    public View Tg() {
        if (this.bcp != null) {
            return this.bcp.amg;
        }
        return null;
    }
}
