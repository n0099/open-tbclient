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
    private v.d aQI;
    private v.b aQJ;
    private boolean aSn;
    private com.baidu.tieba.play.y aSo;
    private com.baidu.tieba.play.aj aSp;
    private y.a aSr;
    private int aTq;
    private TbImageView.a aTr;
    private QuickVideoView.b aTt;
    private Runnable aTu;
    private Handler aTw;
    private TbPageContext<?> aaX;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    private RelativeLayout baO;
    public ClickableHeaderImageView baZ;
    public ViewStub bba;
    public TbImageView bbb;
    public ThreadCommentAndPraiseInfoLayout bbc;
    public UserIconLayout bbd;
    protected LinearLayout bbe;
    private ImageView bsB;
    private com.baidu.tbadk.core.view.o bsC;
    private CustomMessageListener bsD;
    public View bsF;
    public TextView bsG;
    private QuickVideoView bsH;
    private TextView bsI;
    private TextView bsJ;
    private TextView bsK;
    private View bsL;
    private AudioAnimationView bsM;
    private ProgressBar bsN;
    private ImageView bsO;
    private com.baidu.tieba.card.data.p bsP;
    private View bsQ;
    private int bsR;
    private boolean bsS;
    private Animation bsT;
    private Runnable bsU;
    private CustomMessageListener bsV;
    private Animation.AnimationListener bsW;
    private CardGroupDividerView bsk;
    public FrameLayout bsy;
    private TbImageView bsz;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public void SI() {
        if (this.bsC == null) {
            this.bsC = new com.baidu.tbadk.core.view.o(this.aaX);
            this.bsC.wQ();
            this.bbc.addView(this.bsC);
            if (this.bbc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbc.getLayoutParams();
                layoutParams.rightMargin = 0;
                this.bbc.setLayoutParams(layoutParams);
            }
        }
    }

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bsC = null;
        this.mSkinType = 3;
        this.aTq = 0;
        this.bsR = 1;
        this.aSn = false;
        this.bsS = false;
        this.aTw = new y(this, Looper.getMainLooper());
        this.aQI = new ad(this);
        this.aQJ = new ae(this);
        this.aTr = new af(this);
        this.aTu = new ag(this);
        this.bsU = new ah(this);
        this.aTt = new ai(this);
        this.amx = new aj(this);
        this.bsD = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bsV = new z(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.ama = new aa(this);
        this.aSr = new ab(this);
        this.bsW = new ac(this);
        this.aaX = tbPageContext;
        View view = getView();
        this.baO = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.baZ = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.baZ.setDefaultResource(17170445);
        this.baZ.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.baZ.setDefaultBgResource(w.e.cp_bg_line_e);
        this.baZ.setRadius(com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds70));
        this.bbd = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.bsN = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bsO = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bbc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bsF = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bsy = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bsy.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.af(this.aaX.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds144);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bsy.setLayoutParams(layoutParams);
        this.bsz = (TbImageView) view.findViewById(w.h.image_video);
        this.bsz.setDefaultErrorResource(0);
        this.bsz.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bsz.setEvent(this.aTr);
        this.bsB = (ImageView) view.findViewById(w.h.image_video_play);
        this.bsM = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bsM.setCertainColumnCount(4);
        this.bsM.setColumnColor(w.e.cp_cont_i);
        this.baO.setOnClickListener(this);
        this.bsH = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aSp = new com.baidu.tieba.play.aj(this.aaX.getPageActivity());
        this.bsH.setBusiness(this.aSp);
        this.bsH.setOnPreparedListener(this.aQI);
        this.bsH.setOnErrorListener(this.aQJ);
        this.bsH.setOnSurfaceDestroyedListener(this.aTt);
        this.aSo = new com.baidu.tieba.play.y();
        this.aSo.setPlayer(this.bsH);
        this.aSo.a(this.aSr);
        this.bsI = (TextView) view.findViewById(w.h.text_video_duration);
        this.bsJ = (TextView) view.findViewById(w.h.text_play_count);
        this.bsQ = view.findViewById(w.h.auto_video_black_mask);
        this.bsK = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bsL = view.findViewById(w.h.auto_video_error_background);
        this.bbe = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bsT = AnimationUtils.loadAnimation(this.aaX.getPageActivity(), w.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bsT.setAnimationListener(this.bsW);
        this.bsk = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baO) {
            N(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbc != null) {
            this.bbc.setBarNameClickEnabled(z);
        }
    }

    private void N(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bsP);
        }
        if (this.bsP != null && this.bsP.bbo != null) {
            if (!SL()) {
                at.hY(this.bsP.bbo.getId());
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aaX.getPageActivity()).createFromThreadCfg(this.bsP.bbo, null, at.sf(), 18003, true, false, false).addLocateParam(this.bsP.SW());
            addLocateParam.setVideo_source(this.bsP.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe");
            this.aaX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    public void SK() {
        if (this.bsG == null) {
            this.bsG = new TextView(this.aaX.getPageActivity());
            this.bsG.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
            this.bsG.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds20);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds2);
            this.bsG.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.i(this.bsG, w.e.cp_cont_b);
            this.bbd.addView(this.bsG);
        }
    }

    private boolean SL() {
        return this.bsP.bvi && !this.bsP.bvw;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.p pVar) {
        this.bsP = pVar;
        Nq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        this.aTw.removeMessages(202);
        if (this.bsH.getCurrentPosition() > 0) {
            e(true, 3);
            this.aTw.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aTw.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTw.removeMessages(203);
        int currentPosition = this.bsH.getCurrentPosition();
        if (currentPosition != this.aTq) {
            this.aTq = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aTw.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bsB != null && this.bsz != null && this.bsQ != null && this.bsM != null && this.bsN != null && this.bsO != null && this.bsL != null && this.bsK != null) {
            if (z || this.bsR != i) {
                this.bsR = i;
                com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bsU);
                com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aTu);
                if (i == 2) {
                    this.bsB.setVisibility(8);
                    this.bsT.cancel();
                    this.bsz.clearAnimation();
                    this.bsz.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsI.setVisibility(0);
                    this.bsJ.setVisibility(0);
                    this.bsN.setVisibility(0);
                    this.bsO.setVisibility(0);
                    this.bsL.setVisibility(8);
                    this.bsK.setVisibility(8);
                    this.bsM.setVisibility(8);
                    this.bsM.bmk();
                    com.baidu.adp.lib.g.h.fR().postDelayed(this.bsU, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bsB.setVisibility(8);
                    this.bsz.startAnimation(this.bsT);
                    this.bsQ.setVisibility(8);
                    this.bsI.setVisibility(8);
                    this.bsJ.setVisibility(8);
                    this.bsN.setVisibility(8);
                    this.bsO.setVisibility(8);
                    this.bsL.setVisibility(8);
                    this.bsK.setVisibility(8);
                    this.bsM.setVisibility(0);
                    this.bsM.start();
                } else if (i == 4) {
                    this.bsB.setVisibility(8);
                    this.bsz.startAnimation(this.bsT);
                    this.bsQ.setVisibility(8);
                    this.bsN.setVisibility(8);
                    this.bsO.setVisibility(8);
                    this.bsL.setVisibility(0);
                    this.bsK.setVisibility(0);
                    this.bsM.setVisibility(8);
                    this.bsM.bmk();
                    com.baidu.adp.lib.g.h.fR().postDelayed(this.aTu, 2000L);
                } else {
                    this.bsB.setVisibility(0);
                    this.bsT.cancel();
                    this.bsz.clearAnimation();
                    this.bsz.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsI.setVisibility(0);
                    this.bsJ.setVisibility(0);
                    this.bsN.setVisibility(8);
                    this.bsO.setVisibility(8);
                    this.bsL.setVisibility(8);
                    this.bsK.setVisibility(8);
                    this.bsM.setVisibility(8);
                    this.bsM.bmk();
                }
            }
        }
    }

    private void Nq() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.bsP == null || this.bsP.bbo == null || this.bsP.bbo.getAuthor() == null) {
            this.baO.setVisibility(8);
            return;
        }
        this.baO.setVisibility(0);
        SM();
        if (this.bsP.bvi) {
            this.baZ.setVisibility(8);
            this.bbd.setVisibility(8);
        } else {
            this.bbd.setVisibility(0);
            this.baZ.setVisibility(0);
            this.baZ.setData(this.bsP.bbo);
            this.baZ.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.bsP.Kn().sp();
            if (sp != null && sp.getvipV_url() != null && this.bba != null) {
                if (this.bbb == null) {
                    this.bba.inflate();
                    this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbb.c(sp.getvipV_url(), 10, false);
                this.baZ.setIsBigV(true);
            }
        }
        this.bbd.setData(this.bsP.bbo);
        this.bbd.setUserAfterClickListener(this.amx);
        if (this.bsP.bbo.ts() != null && this.bsP.bbo.ts().channelId > 0) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aaX.getResources().getString(w.l.frs_channel_tip)) + this.bsP.bbo.getTitle());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aaX.getResources().getColor(w.e.cp_link_tip_a)), 0, 4, 34);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.bsP.bbo.getTitle());
        }
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bbc.a(this.bsP.bbo)) {
            this.bsF.setVisibility(8);
        } else {
            this.bsF.setVisibility(0);
        }
        if (this.bsG != null) {
            if (this.bsP.bbo.sj() <= 0) {
                this.bsG.setVisibility(8);
            } else {
                this.bsG.setVisibility(0);
                this.bsG.setText(com.baidu.tbadk.core.util.au.r(this.bsP.bbo.sj() * 1000));
            }
        }
        this.bsI.setText(com.baidu.tbadk.core.util.au.cW(this.bsP.bbo.sF().video_duration.intValue() * 1000));
        this.bsJ.setText(this.aaX.getPageActivity().getString(w.l.play_count, new Object[]{com.baidu.tbadk.core.util.au.t(this.bsP.bbo.sF().play_count.intValue())}));
        this.bbc.setStType(at.sf());
        this.bbc.setYuelaouLocate("feed#" + this.bsP.SV());
        this.bbc.setForumAfterClickListener(this.ama);
        if (this.bsC != null && this.bsP.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.bsP.Kn().getTid());
            alVar.setFid(this.bsP.Kn().getFid());
            alVar.a(this.bsP.WT);
            this.bsC.setData(alVar);
        }
        onChangeSkinType(this.aaX, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.hZ(this.bsP.bbo.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        if (this.bsP.bvw) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void RD() {
        this.aTw.removeMessages(202);
        this.aTw.removeMessages(203);
    }

    private void RZ() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aTu);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bsU);
    }

    private void SM() {
        RZ();
        RD();
        if (this.bsz != null && this.bsy != null && this.bsH != null) {
            if (com.baidu.tbadk.core.q.po().pu() && this.bsP != null && this.bsP.bbo != null && this.bsP.bbo.sF() != null) {
                this.bsz.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.bsz.c(this.bsP.bbo.sF().thumbnail_url, 10, false);
                this.bsy.setVisibility(0);
                stopPlay();
                this.mVideoUrl = this.bsP.bbo.sF().video_url;
                if (StringUtils.isNull(this.bsP.bbo.sF().video_url)) {
                    e(true, 4);
                }
                if (this.aSp != null && this.aSp.aYb() != null) {
                    this.aSp.aYb().c(this.bsP.bbo.sF());
                    return;
                }
                return;
            }
            this.bsy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.baO, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.bsB, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i(this.bsK, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.bsI, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i(this.bsJ, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i(this.bsG, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.k(this.bsL, w.e.common_color_10014);
            if (this.bsK != null) {
                this.bsK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bsC != null) {
                this.bsC.onChangeSkinType();
            }
            if (this.bsk != null) {
                this.bsk.onChangeSkinType();
            }
            this.bbd.onChangeSkinType();
            this.bbc.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbc != null && this.bsD != null) {
            this.bbc.h(bdUniqueId);
            this.bsD.setTag(bdUniqueId);
            this.bsV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
            MessageManager.getInstance().registerListener(this.bsV);
        }
    }

    public boolean isPlayStarted() {
        return this.aSn;
    }

    public boolean isPlaying() {
        if (this.bsH == null) {
            return false;
        }
        return this.bsH.isPlaying();
    }

    public void startPlay() {
        if (!this.aSn && this.bsP != null && this.bsP.bbo != null && this.bsP.bbo.sF() != null && this.bsH != null && com.baidu.tbadk.util.w.q(1, this.mVideoUrl)) {
            e(true, 2);
            this.bsH.setVideoPath(this.mVideoUrl);
            this.bsH.start();
            this.bsH.setLooping(true);
            if (this.aSo != null) {
                this.aSo.start();
            }
            this.aSn = true;
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = this.bsP.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
            bbVar.bqu = this.bsP.bbo.getTid();
            bbVar.bqv = new StringBuilder(String.valueOf(this.bsP.bbo.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.bsP.bbo.Zx;
            bbVar.eVd = this.bsP.bbo.Zz;
            bbVar.eVe = this.bsP.bbo.Zy;
            bbVar.eVf = "";
            if (this.bsP.bbo.ts() != null && this.bsP.bbo.ts().channelId > 0) {
                bbVar.VP = new StringBuilder(String.valueOf(this.bsP.bbo.ts().channelId)).toString();
            } else {
                bbVar.VP = "0";
            }
            com.baidu.tieba.play.ab.a(this.bsP.bbo.sF().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        RZ();
        RD();
        e(true, 1);
        if (this.bsH != null) {
            this.bsH.stopPlayback();
            if (this.aSo != null) {
                this.aSo.stop();
            }
        }
        this.aSn = false;
    }

    public View getVideoContainer() {
        return this.bsy;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bsH == null) {
            return 0;
        }
        return this.bsH.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aSp != null) {
            this.aSp.a(bbVar);
        }
    }

    public void a(o.a aVar) {
        if (this.bsC != null) {
            this.bsC.setEventCallback(aVar);
        }
    }
}
