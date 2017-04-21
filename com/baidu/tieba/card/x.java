package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
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
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class x extends a<com.baidu.tieba.card.data.p> {
    private v.d aQK;
    private v.b aQL;
    private boolean aSp;
    private com.baidu.tieba.play.y aSq;
    private com.baidu.tieba.play.aj aSr;
    private y.a aSt;
    private int aTs;
    private TbImageView.a aTt;
    private QuickVideoView.b aTv;
    private Runnable aTw;
    private Handler aTy;
    private TbPageContext<?> aaY;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    private RelativeLayout bbK;
    public ClickableHeaderImageView bbV;
    public ViewStub bbW;
    public TbImageView bbX;
    public ThreadCommentAndPraiseInfoLayout bbY;
    public UserIconLayout bbZ;
    protected LinearLayout bca;
    private CardGroupDividerView buD;
    public FrameLayout buR;
    private TbImageView buS;
    private ImageView buU;
    private com.baidu.tbadk.core.view.o buV;
    private CustomMessageListener buW;
    public View buY;
    public TextView buZ;
    private QuickVideoView bva;
    private TextView bvb;
    private TextView bvc;
    private TextView bvd;
    private View bve;
    private AudioAnimationView bvf;
    private ProgressBar bvg;
    private ImageView bvh;
    private com.baidu.tieba.card.data.p bvi;
    private View bvj;
    private int bvk;
    private boolean bvl;
    private Animation bvm;
    private Runnable bvn;
    private CustomMessageListener bvo;
    private Animation.AnimationListener bvp;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public void TK() {
        if (this.buV == null) {
            this.buV = new com.baidu.tbadk.core.view.o(this.aaY);
            this.buV.wQ();
            this.bbY.addView(this.buV);
            if (this.bbY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbY.getLayoutParams();
                layoutParams.rightMargin = 0;
                this.bbY.setLayoutParams(layoutParams);
            }
        }
    }

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.buV = null;
        this.mSkinType = 3;
        this.aTs = 0;
        this.bvk = 1;
        this.aSp = false;
        this.bvl = false;
        this.aTy = new y(this, Looper.getMainLooper());
        this.aQK = new ad(this);
        this.aQL = new ae(this);
        this.aTt = new af(this);
        this.aTw = new ag(this);
        this.bvn = new ah(this);
        this.aTv = new ai(this);
        this.amx = new aj(this);
        this.buW = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bvo = new z(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.ama = new aa(this);
        this.aSt = new ab(this);
        this.bvp = new ac(this);
        this.aaY = tbPageContext;
        View view = getView();
        this.bbK = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bbV = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bbV.setDefaultResource(17170445);
        this.bbV.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbV.setRadius(com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds70));
        this.bbZ = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.bvg = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bvh = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bbY = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.buY = view.findViewById(w.h.divider_below_reply_number_layout);
        this.buR = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.buR.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.af(this.aaY.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds144);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.buR.setLayoutParams(layoutParams);
        this.buS = (TbImageView) view.findViewById(w.h.image_video);
        this.buS.setDefaultErrorResource(0);
        this.buS.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.buS.setEvent(this.aTt);
        this.buU = (ImageView) view.findViewById(w.h.image_video_play);
        this.bvf = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bvf.setCertainColumnCount(4);
        this.bvf.setColumnColor(w.e.cp_cont_i);
        this.bbK.setOnClickListener(this);
        this.bva = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aSr = new com.baidu.tieba.play.aj(this.aaY.getPageActivity());
        this.bva.setBusiness(this.aSr);
        this.bva.setOnPreparedListener(this.aQK);
        this.bva.setOnErrorListener(this.aQL);
        this.bva.setOnSurfaceDestroyedListener(this.aTv);
        this.aSq = new com.baidu.tieba.play.y();
        this.aSq.setPlayer(this.bva);
        this.aSq.a(this.aSt);
        this.bvb = (TextView) view.findViewById(w.h.text_video_duration);
        this.bvc = (TextView) view.findViewById(w.h.text_play_count);
        this.bvj = view.findViewById(w.h.auto_video_black_mask);
        this.bvd = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bve = view.findViewById(w.h.auto_video_error_background);
        this.bca = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bvm = AnimationUtils.loadAnimation(this.aaY.getPageActivity(), w.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bvm.setAnimationListener(this.bvp);
        this.buD = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bbK) {
            N(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbY != null) {
            this.bbY.setBarNameClickEnabled(z);
        }
    }

    private void N(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bvi);
        }
        if (this.bvi != null && this.bvi.bck != null) {
            if (!TN()) {
                at.hZ(this.bvi.bck.getId());
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aaY.getPageActivity()).createFromThreadCfg(this.bvi.bck, null, at.sf(), 18003, true, false, false).addLocateParam(this.bvi.TY());
            addLocateParam.setVideo_source(this.bvi.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe");
            this.aaY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    public void TM() {
        if (this.buZ == null) {
            this.buZ = new TextView(this.aaY.getPageActivity());
            this.buZ.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
            this.buZ.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds20);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds2);
            this.buZ.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.i(this.buZ, w.e.cp_cont_b);
            this.bbZ.addView(this.buZ);
        }
    }

    private boolean TN() {
        return this.bvi.bxz && !this.bvi.bxN;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.p pVar) {
        this.bvi = pVar;
        Ny();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        this.aTy.removeMessages(202);
        if (this.bva.getCurrentPosition() > 0) {
            f(true, 3);
            this.aTy.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aTy.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTy.removeMessages(203);
        int currentPosition = this.bva.getCurrentPosition();
        if (currentPosition != this.aTs) {
            this.aTs = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.aTy.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.buU != null && this.buS != null && this.bvj != null && this.bvf != null && this.bvg != null && this.bvh != null && this.bve != null && this.bvd != null) {
            if (z || this.bvk != i) {
                this.bvk = i;
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bvn);
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTw);
                if (i == 2) {
                    this.buU.setVisibility(8);
                    this.bvm.cancel();
                    this.buS.clearAnimation();
                    this.buS.setVisibility(0);
                    this.bvj.setVisibility(0);
                    this.bvb.setVisibility(0);
                    this.bvc.setVisibility(0);
                    this.bvg.setVisibility(0);
                    this.bvh.setVisibility(0);
                    this.bve.setVisibility(8);
                    this.bvd.setVisibility(8);
                    this.bvf.setVisibility(8);
                    this.bvf.bnl();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.bvn, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.buU.setVisibility(8);
                    this.buS.startAnimation(this.bvm);
                    this.bvj.setVisibility(8);
                    this.bvb.setVisibility(8);
                    this.bvc.setVisibility(8);
                    this.bvg.setVisibility(8);
                    this.bvh.setVisibility(8);
                    this.bve.setVisibility(8);
                    this.bvd.setVisibility(8);
                    this.bvf.setVisibility(0);
                    this.bvf.start();
                } else if (i == 4) {
                    this.buU.setVisibility(8);
                    this.buS.startAnimation(this.bvm);
                    this.bvj.setVisibility(8);
                    this.bvg.setVisibility(8);
                    this.bvh.setVisibility(8);
                    this.bve.setVisibility(0);
                    this.bvd.setVisibility(0);
                    this.bvf.setVisibility(8);
                    this.bvf.bnl();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.aTw, 2000L);
                } else {
                    this.buU.setVisibility(0);
                    this.bvm.cancel();
                    this.buS.clearAnimation();
                    this.buS.setVisibility(0);
                    this.bvj.setVisibility(0);
                    this.bvb.setVisibility(0);
                    this.bvc.setVisibility(0);
                    this.bvg.setVisibility(8);
                    this.bvh.setVisibility(8);
                    this.bve.setVisibility(8);
                    this.bvd.setVisibility(8);
                    this.bvf.setVisibility(8);
                    this.bvf.bnl();
                }
            }
        }
    }

    private void Ny() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.bvi == null || this.bvi.bck == null || this.bvi.bck.getAuthor() == null) {
            this.bbK.setVisibility(8);
            return;
        }
        this.bbK.setVisibility(0);
        TO();
        if (this.bvi.bxz) {
            this.bbV.setVisibility(8);
            this.bbZ.setVisibility(8);
        } else {
            this.bbZ.setVisibility(0);
            this.bbV.setVisibility(0);
            this.bbV.setData(this.bvi.bck);
            this.bbV.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.bvi.Kn().sp();
            if (sp != null && sp.getvipV_url() != null && this.bbW != null) {
                if (this.bbX == null) {
                    this.bbW.inflate();
                    this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbX.c(sp.getvipV_url(), 10, false);
                this.bbV.setIsBigV(true);
            }
        }
        this.bbZ.setData(this.bvi.bck);
        this.bbZ.setUserAfterClickListener(this.amx);
        if (this.bvi.bck.ts() != null && this.bvi.bck.ts().channelId > 0) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aaY.getResources().getString(w.l.frs_channel_tip)) + this.bvi.bck.getTitle());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aaY.getResources().getColor(w.e.cp_link_tip_a)), 0, 4, 34);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.bvi.bck.getTitle());
        }
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bbY.a(this.bvi.bck)) {
            this.buY.setVisibility(8);
        } else {
            this.buY.setVisibility(0);
        }
        if (this.buZ != null) {
            if (this.bvi.bck.sj() <= 0) {
                this.buZ.setVisibility(8);
            } else {
                this.buZ.setVisibility(0);
                this.buZ.setText(com.baidu.tbadk.core.util.au.r(this.bvi.bck.sj() * 1000));
            }
        }
        this.bvb.setText(com.baidu.tbadk.core.util.au.cW(this.bvi.bck.sF().video_duration.intValue() * 1000));
        this.bvc.setText(this.aaY.getPageActivity().getString(w.l.play_count, new Object[]{com.baidu.tbadk.core.util.au.t(this.bvi.bck.sF().play_count.intValue())}));
        this.bbY.setStType(at.sf());
        this.bbY.setYuelaouLocate("feed#" + this.bvi.TX());
        this.bbY.setForumAfterClickListener(this.ama);
        if (this.buV != null && this.bvi.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.bvi.Kn().getTid());
            alVar.setFid(this.bvi.Kn().getFid());
            alVar.a(this.bvi.WU);
            this.buV.setData(alVar);
        }
        onChangeSkinType(this.aaY, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.ia(this.bvi.bck.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        if (this.bvi.bxN) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void SF() {
        this.aTy.removeMessages(202);
        this.aTy.removeMessages(203);
    }

    private void Tb() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTw);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bvn);
    }

    private void TO() {
        Tb();
        SF();
        if (this.buS != null && this.buR != null && this.bva != null) {
            if (com.baidu.tbadk.core.q.po().pu() && this.bvi != null && this.bvi.bck != null && this.bvi.bck.sF() != null) {
                this.buS.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.buS.c(this.bvi.bck.sF().thumbnail_url, 10, false);
                this.buR.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bvi.bck.sF().video_url;
                if (StringUtils.isNull(this.bvi.bck.sF().video_url)) {
                    f(true, 4);
                }
                if (this.aSr != null && this.aSr.aZc() != null) {
                    this.aSr.aZc().c(this.bvi.bck.sF());
                    return;
                }
                return;
            }
            this.buR.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bbK, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.buU, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i(this.bvd, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.bvb, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i(this.bvc, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i(this.buZ, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.k(this.bve, w.e.common_color_10014);
            if (this.bvd != null) {
                this.bvd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.buV != null) {
                this.buV.onChangeSkinType();
            }
            if (this.buD != null) {
                this.buD.onChangeSkinType();
            }
            this.bbZ.onChangeSkinType();
            this.bbY.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbY != null && this.buW != null) {
            this.bbY.h(bdUniqueId);
            this.buW.setTag(bdUniqueId);
            this.bvo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
            MessageManager.getInstance().registerListener(this.bvo);
        }
    }

    public boolean isPlayStarted() {
        return this.aSp;
    }

    public boolean isPlaying() {
        if (this.bva == null) {
            return false;
        }
        return this.bva.isPlaying();
    }

    public void startPlay() {
        if (!this.aSp && this.bvi != null && this.bvi.bck != null && this.bvi.bck.sF() != null && this.bva != null && com.baidu.tbadk.util.w.q(1, this.mVideoUrl)) {
            f(true, 2);
            this.bva.setVideoPath(this.mVideoUrl);
            this.bva.start();
            this.bva.setLooping(true);
            if (this.aSq != null) {
                this.aSq.start();
            }
            this.aSp = true;
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = this.bvi.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
            bbVar.bsL = this.bvi.bck.getTid();
            bbVar.bsM = new StringBuilder(String.valueOf(this.bvi.bck.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.bvi.bck.Zy;
            bbVar.eXt = this.bvi.bck.ZA;
            bbVar.eXu = this.bvi.bck.Zz;
            bbVar.eXv = "";
            if (this.bvi.bck.ts() != null && this.bvi.bck.ts().channelId > 0) {
                bbVar.VR = new StringBuilder(String.valueOf(this.bvi.bck.ts().channelId)).toString();
            } else {
                bbVar.VR = "0";
            }
            com.baidu.tieba.play.ab.a(this.bvi.bck.sF().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        Tb();
        SF();
        f(true, 1);
        if (this.bva != null) {
            this.bva.stopPlayback();
            if (this.aSq != null) {
                this.aSq.stop();
            }
        }
        this.aSp = false;
    }

    public View getVideoContainer() {
        return this.buR;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bva == null) {
            return 0;
        }
        return this.bva.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aSr != null) {
            this.aSr.a(bbVar);
        }
    }

    public void a(o.a aVar) {
        if (this.buV != null) {
            this.buV.setEventCallback(aVar);
        }
    }
}
