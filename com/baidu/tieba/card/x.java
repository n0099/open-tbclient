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
    private v.d aQs;
    private v.b aQt;
    private boolean aRX;
    private com.baidu.tieba.play.y aRY;
    private com.baidu.tieba.play.aj aRZ;
    private y.a aSb;
    private String aTZ;
    private int aTb;
    private TbImageView.a aTc;
    private QuickVideoView.b aTe;
    private Runnable aTf;
    private Handler aTh;
    private TbPageContext<?> aaI;
    private final View.OnClickListener alM;
    private final View.OnClickListener amj;
    private RelativeLayout baV;
    public ClickableHeaderImageView bbg;
    public ViewStub bbh;
    public TbImageView bbi;
    public ThreadCommentAndPraiseInfoLayout bbj;
    public UserIconLayout bbk;
    protected LinearLayout bbl;
    public FrameLayout bsG;
    private TbImageView bsH;
    private ImageView bsJ;
    private com.baidu.tbadk.core.view.o bsK;
    private CustomMessageListener bsL;
    public View bsN;
    public TextView bsO;
    private QuickVideoView bsP;
    private TextView bsQ;
    private TextView bsR;
    private TextView bsS;
    private View bsT;
    private AudioAnimationView bsU;
    private ProgressBar bsV;
    private ImageView bsW;
    private com.baidu.tieba.card.data.p bsX;
    private View bsY;
    private int bsZ;
    private CardGroupDividerView bss;
    private boolean bta;
    private Animation btb;
    private Runnable btc;
    private CustomMessageListener btd;
    private Animation.AnimationListener bte;
    private int mSkinType;
    private TextView mTextTitle;

    public void Sk() {
        if (this.bsK == null) {
            this.bsK = new com.baidu.tbadk.core.view.o(this.aaI);
            this.bsK.wu();
            this.bbj.addView(this.bsK);
            if (this.bbj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbj.getLayoutParams();
                layoutParams.rightMargin = 0;
                this.bbj.setLayoutParams(layoutParams);
            }
        }
    }

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bsK = null;
        this.mSkinType = 3;
        this.aTb = 0;
        this.bsZ = 1;
        this.aRX = false;
        this.bta = false;
        this.aTh = new y(this, Looper.getMainLooper());
        this.aQs = new ad(this);
        this.aQt = new ae(this);
        this.aTc = new af(this);
        this.aTf = new ag(this);
        this.btc = new ah(this);
        this.aTe = new ai(this);
        this.amj = new aj(this);
        this.bsL = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.btd = new z(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.alM = new aa(this);
        this.aSb = new ab(this);
        this.bte = new ac(this);
        this.aaI = tbPageContext;
        View view = getView();
        this.baV = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bbg = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bbg.setDefaultResource(17170445);
        this.bbg.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbg.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbg.setRadius(com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds70));
        this.bbk = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.bsV = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bsW = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bbj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bsN = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bsG = (FrameLayout) view.findViewById(w.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bsG.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.ag(this.aaI.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds144);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bsG.setLayoutParams(layoutParams);
        this.bsH = (TbImageView) view.findViewById(w.h.image_video);
        this.bsH.setDefaultErrorResource(0);
        this.bsH.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bsH.setEvent(this.aTc);
        this.bsJ = (ImageView) view.findViewById(w.h.image_video_play);
        this.bsU = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bsU.setCertainColumnCount(4);
        this.bsU.setColumnColor(w.e.cp_cont_i);
        this.baV.setOnClickListener(this);
        this.bsP = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aRZ = new com.baidu.tieba.play.aj(this.aaI.getPageActivity());
        this.bsP.setBusiness(this.aRZ);
        this.bsP.setOnPreparedListener(this.aQs);
        this.bsP.setOnErrorListener(this.aQt);
        this.bsP.setOnSurfaceDestroyedListener(this.aTe);
        this.aRY = new com.baidu.tieba.play.y();
        this.aRY.setPlayer(this.bsP);
        this.aRY.a(this.aSb);
        this.bsQ = (TextView) view.findViewById(w.h.text_video_duration);
        this.bsR = (TextView) view.findViewById(w.h.text_play_count);
        this.bsY = view.findViewById(w.h.auto_video_black_mask);
        this.bsS = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bsT = view.findViewById(w.h.auto_video_error_background);
        this.bbl = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.btb = AnimationUtils.loadAnimation(this.aaI.getPageActivity(), w.a.fade_out_video_cover);
        this.btb.setAnimationListener(this.bte);
        this.bss = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baV) {
            N(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbj != null) {
            this.bbj.setBarNameClickEnabled(z);
        }
    }

    private void N(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bsX);
        }
        if (this.bsX != null && this.bsX.bbv != null) {
            if (!Sn()) {
                at.hU(this.bsX.bbv.getId());
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aaI.getPageActivity()).createFromThreadCfg(this.bsX.bbv, null, at.rH(), 18003, true, false, false).addLocateParam(this.bsX.Sy());
            addLocateParam.setVideo_source(this.bsX.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe");
            this.aaI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    public void Sm() {
        if (this.bsO == null) {
            this.bsO = new TextView(this.aaI.getPageActivity());
            this.bsO.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
            this.bsO.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds20);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds2);
            this.bsO.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.i((View) this.bsO, w.e.cp_cont_b);
            this.bbk.addView(this.bsO);
        }
    }

    private boolean Sn() {
        return this.bsX.bvp && !this.bsX.bvD;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.p pVar) {
        this.bsX = pVar;
        MR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KJ() {
        this.aTh.removeMessages(202);
        if (this.bsP.getCurrentPosition() > 0) {
            e(true, 3);
            this.aTh.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aTh.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KK() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTh.removeMessages(203);
        int currentPosition = this.bsP.getCurrentPosition();
        if (currentPosition != this.aTb) {
            this.aTb = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aTh.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bsJ != null && this.bsH != null && this.bsY != null && this.bsU != null && this.bsV != null && this.bsW != null && this.bsT != null && this.bsS != null) {
            if (z || this.bsZ != i) {
                this.bsZ = i;
                com.baidu.adp.lib.g.h.fM().removeCallbacks(this.btc);
                com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aTf);
                if (i == 2) {
                    this.bsJ.setVisibility(8);
                    this.btb.cancel();
                    this.bsH.clearAnimation();
                    this.bsH.setVisibility(0);
                    this.bsY.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsR.setVisibility(0);
                    this.bsV.setVisibility(0);
                    this.bsW.setVisibility(0);
                    this.bsT.setVisibility(8);
                    this.bsS.setVisibility(8);
                    this.bsU.setVisibility(8);
                    this.bsU.blA();
                    com.baidu.adp.lib.g.h.fM().postDelayed(this.btc, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bsJ.setVisibility(8);
                    this.bsH.startAnimation(this.btb);
                    this.bsY.setVisibility(8);
                    this.bsQ.setVisibility(8);
                    this.bsR.setVisibility(8);
                    this.bsV.setVisibility(8);
                    this.bsW.setVisibility(8);
                    this.bsT.setVisibility(8);
                    this.bsS.setVisibility(8);
                    this.bsU.setVisibility(0);
                    this.bsU.start();
                } else if (i == 4) {
                    this.bsJ.setVisibility(8);
                    this.bsH.startAnimation(this.btb);
                    this.bsY.setVisibility(8);
                    this.bsV.setVisibility(8);
                    this.bsW.setVisibility(8);
                    this.bsT.setVisibility(0);
                    this.bsS.setVisibility(0);
                    this.bsU.setVisibility(8);
                    this.bsU.blA();
                    com.baidu.adp.lib.g.h.fM().postDelayed(this.aTf, 2000L);
                } else {
                    this.bsJ.setVisibility(0);
                    this.btb.cancel();
                    this.bsH.clearAnimation();
                    this.bsH.setVisibility(0);
                    this.bsY.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsR.setVisibility(0);
                    this.bsV.setVisibility(8);
                    this.bsW.setVisibility(8);
                    this.bsT.setVisibility(8);
                    this.bsS.setVisibility(8);
                    this.bsU.setVisibility(8);
                    this.bsU.blA();
                }
            }
        }
    }

    private void MR() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.bsX == null || this.bsX.bbv == null || this.bsX.bbv.getAuthor() == null) {
            this.baV.setVisibility(8);
            return;
        }
        this.baV.setVisibility(0);
        So();
        if (this.bsX.bvp) {
            this.bbg.setVisibility(8);
            this.bbk.setVisibility(8);
        } else {
            this.bbk.setVisibility(0);
            this.bbg.setVisibility(0);
            this.bbg.setData(this.bsX.bbv);
            this.bbg.setAfterClickListener(this.amj);
            UserTbVipInfoData rR = this.bsX.JN().rR();
            if (rR != null && rR.getvipV_url() != null && this.bbh != null) {
                if (this.bbi == null) {
                    this.bbh.inflate();
                    this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbi.c(rR.getvipV_url(), 10, false);
                this.bbg.setIsBigV(true);
            }
        }
        this.bbk.setData(this.bsX.bbv);
        this.bbk.setUserAfterClickListener(this.amj);
        if (this.bsX.bbv.sU() != null && this.bsX.bbv.sU().channelId > 0) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aaI.getResources().getString(w.l.frs_channel_tip)) + this.bsX.bbv.getTitle());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aaI.getResources().getColor(w.e.cp_link_tip_a)), 0, 4, 34);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.bsX.bbv.getTitle());
        }
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bbj.a(this.bsX.bbv)) {
            this.bsN.setVisibility(8);
        } else {
            this.bsN.setVisibility(0);
        }
        if (this.bsO != null) {
            if (this.bsX.bbv.rL() <= 0) {
                this.bsO.setVisibility(8);
            } else {
                this.bsO.setVisibility(0);
                this.bsO.setText(com.baidu.tbadk.core.util.au.r(this.bsX.bbv.rL() * 1000));
            }
        }
        this.bsQ.setText(com.baidu.tbadk.core.util.au.cT(this.bsX.bbv.sh().video_duration.intValue() * 1000));
        this.bsR.setText(this.aaI.getPageActivity().getString(w.l.play_count, new Object[]{com.baidu.tbadk.core.util.au.t(this.bsX.bbv.sh().play_count.intValue())}));
        this.bbj.setStType(at.rH());
        this.bbj.setYuelaouLocate("feed#" + this.bsX.Sx());
        this.bbj.setForumAfterClickListener(this.alM);
        if (this.bsK != null && this.bsX.JN() != null) {
            com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
            amVar.ci(this.bsX.JN().getTid());
            amVar.setFid(this.bsX.JN().getFid());
            amVar.a(this.bsX.WE);
            this.bsK.setData(amVar);
        }
        onChangeSkinType(this.aaI, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.hV(this.bsX.bbv.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        if (this.bsX.bvD) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void Rf() {
        this.aTh.removeMessages(202);
        this.aTh.removeMessages(203);
    }

    private void RB() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aTf);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.btc);
    }

    private void So() {
        RB();
        Rf();
        if (this.bsH != null && this.bsG != null && this.bsP != null) {
            if (com.baidu.tbadk.core.l.oQ().oW() && this.bsX != null && this.bsX.bbv != null && this.bsX.bbv.sh() != null) {
                this.bsH.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.bsH.c(this.bsX.bbv.sh().thumbnail_url, 10, false);
                this.bsG.setVisibility(0);
                stopPlay();
                this.aTZ = this.bsX.bbv.sh().video_url;
                if (StringUtils.isNull(this.bsX.bbv.sh().video_url)) {
                    e(true, 4);
                }
                if (this.aRZ != null && this.aRZ.aXS() != null) {
                    this.aRZ.aXS().c(this.bsX.bbv.sh());
                    return;
                }
                return;
            }
            this.bsG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.baV, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.bsJ, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i((View) this.bsS, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i((View) this.bsQ, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i((View) this.bsR, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i((View) this.bsO, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.k(this.bsT, w.e.common_color_10014);
            if (this.bsS != null) {
                this.bsS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bsK != null) {
                this.bsK.tD();
            }
            if (this.bss != null) {
                this.bss.tD();
            }
            this.bbk.tD();
            this.bbj.tD();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbj != null && this.bsL != null) {
            this.bbj.h(bdUniqueId);
            this.bsL.setTag(bdUniqueId);
            this.btd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
            MessageManager.getInstance().registerListener(this.btd);
        }
    }

    public boolean isPlayStarted() {
        return this.aRX;
    }

    public boolean isPlaying() {
        if (this.bsP == null) {
            return false;
        }
        return this.bsP.isPlaying();
    }

    public void startPlay() {
        if (!this.aRX && this.bsX != null && this.bsX.bbv != null && this.bsX.bbv.sh() != null && this.bsP != null && com.baidu.tbadk.util.w.q(1, this.aTZ)) {
            e(true, 2);
            this.bsP.setVideoPath(this.aTZ);
            this.bsP.start();
            this.bsP.setLooping(true);
            if (this.aRY != null) {
                this.aRY.start();
            }
            this.aRX = true;
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = this.bsX.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
            bbVar.bqB = this.bsX.bbv.getTid();
            bbVar.bqC = new StringBuilder(String.valueOf(this.bsX.bbv.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.bsX.bbv.Zh;
            bbVar.eXe = this.bsX.bbv.Zj;
            bbVar.eXf = this.bsX.bbv.Zi;
            bbVar.eXg = "";
            if (this.bsX.bbv.sU() != null && this.bsX.bbv.sU().channelId > 0) {
                bbVar.Vy = new StringBuilder(String.valueOf(this.bsX.bbv.sU().channelId)).toString();
            } else {
                bbVar.Vy = "0";
            }
            com.baidu.tieba.play.ab.a(this.bsX.bbv.sh().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        RB();
        Rf();
        e(true, 1);
        if (this.bsP != null) {
            this.bsP.stopPlayback();
            if (this.aRY != null) {
                this.aRY.stop();
            }
        }
        this.aRX = false;
    }

    public View getVideoContainer() {
        return this.bsG;
    }

    public String getPlayUrl() {
        return this.aTZ;
    }

    public int getCurrentPosition() {
        if (this.bsP == null) {
            return 0;
        }
        return this.bsP.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aRZ != null) {
            this.aRZ.a(bbVar);
        }
    }

    public void a(o.a aVar) {
        if (this.bsK != null) {
            this.bsK.setEventCallback(aVar);
        }
    }
}
