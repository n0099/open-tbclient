package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class x extends a<com.baidu.tieba.card.data.p> {
    private TbPageContext<?> Fp;
    private v.d aKH;
    private v.b aKI;
    private boolean aMk;
    private com.baidu.tieba.play.y aMl;
    private com.baidu.tieba.play.aj aMm;
    private y.a aMo;
    private int aNo;
    private TbImageView.a aNp;
    private QuickVideoView.b aNr;
    private Runnable aNs;
    private Handler aNu;
    private String aOm;
    private RelativeLayout aUI;
    public ClickableHeaderImageView aUT;
    public ViewStub aUU;
    public TbImageView aUV;
    public ThreadCommentAndPraiseInfoLayout aUW;
    public UserIconLayout aUX;
    protected LinearLayout aUY;
    private final View.OnClickListener agO;
    private final View.OnClickListener agt;
    public FrameLayout blN;
    private TbImageView blO;
    private ImageView blQ;
    private CustomMessageListener blR;
    public View blT;
    private com.baidu.tbadk.core.view.o blU;
    private QuickVideoView blV;
    private TextView blW;
    private TextView blX;
    private TextView blY;
    private View blZ;
    private CardGroupDividerView blz;
    private AudioAnimationView bma;
    private ProgressBar bmb;
    private ImageView bmc;
    private com.baidu.tieba.card.data.p bmd;
    private View bme;
    private int bmf;
    private boolean bmg;
    private Animation bmh;
    private Runnable bmi;
    private CustomMessageListener bmj;
    private Animation.AnimationListener bmk;
    private int mSkinType;
    private TextView mTextTitle;

    public void Ro() {
        if (this.blU == null) {
            this.blU = new com.baidu.tbadk.core.view.o(this.Fp);
            this.blU.vX();
            this.aUW.addView(this.blU);
            this.blU.vY();
        }
    }

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.blU = null;
        this.mSkinType = 3;
        this.aNo = 0;
        this.bmf = 1;
        this.aMk = false;
        this.bmg = false;
        this.aNu = new y(this, Looper.getMainLooper());
        this.aKH = new ad(this);
        this.aKI = new ae(this);
        this.aNp = new af(this);
        this.aNs = new ag(this);
        this.bmi = new ah(this);
        this.aNr = new ai(this);
        this.agO = new aj(this);
        this.blR = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bmj = new z(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.agt = new aa(this);
        this.aMo = new ab(this);
        this.bmk = new ac(this);
        this.Fp = tbPageContext;
        View view = getView();
        this.aUI = (RelativeLayout) view.findViewById(r.h.layout_root);
        this.aUT = (ClickableHeaderImageView) view.findViewById(r.h.image_user);
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.aUT.setDefaultResource(17170445);
        this.aUT.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.aUT.setDefaultBgResource(r.e.cp_bg_line_e);
        this.aUT.setRadius(com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds70));
        this.aUX = (UserIconLayout) view.findViewById(r.h.text_user_name);
        this.bmb = (ProgressBar) view.findViewById(r.h.auto_video_loading_progress);
        this.bmc = (ImageView) view.findViewById(r.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.h.text_title);
        this.aUW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.text_bottom);
        this.blT = view.findViewById(r.h.divider_below_reply_number_layout);
        this.blN = (FrameLayout) view.findViewById(r.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blN.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.I(this.Fp.getPageActivity()) - com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds144);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.blN.setLayoutParams(layoutParams);
        this.blO = (TbImageView) view.findViewById(r.h.image_video);
        this.blO.setDefaultErrorResource(0);
        this.blO.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.blO.setEvent(this.aNp);
        this.blQ = (ImageView) view.findViewById(r.h.image_video_play);
        this.bma = (AudioAnimationView) view.findViewById(r.h.auto_video_play_state);
        this.bma.setCertainColumnCount(4);
        this.bma.setColumnColor(r.e.cp_cont_i);
        this.aUI.setOnClickListener(this);
        this.blV = (QuickVideoView) view.findViewById(r.h.texture_video_view);
        this.aMm = new com.baidu.tieba.play.aj(this.Fp.getPageActivity());
        this.blV.setBusiness(this.aMm);
        this.blV.setOnPreparedListener(this.aKH);
        this.blV.setOnErrorListener(this.aKI);
        this.blV.setOnSurfaceDestroyedListener(this.aNr);
        this.aMl = new com.baidu.tieba.play.y();
        this.aMl.setPlayer(this.blV);
        this.aMl.a(this.aMo);
        this.blW = (TextView) view.findViewById(r.h.text_video_duration);
        this.blX = (TextView) view.findViewById(r.h.text_play_count);
        this.bme = view.findViewById(r.h.auto_video_black_mask);
        this.blY = (TextView) view.findViewById(r.h.auto_video_error_tips);
        this.blZ = view.findViewById(r.h.auto_video_error_background);
        this.aUY = (LinearLayout) view.findViewById(r.h.video_card_content_layout);
        this.bmh = AnimationUtils.loadAnimation(this.Fp.getPageActivity(), r.a.fade_out_video_cover);
        this.bmh.setAnimationListener(this.bmk);
        this.blz = (CardGroupDividerView) view.findViewById(r.h.header_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUI) {
            P(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aUW != null) {
            this.aUW.setBarNameClickEnabled(z);
        }
    }

    private void P(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bmd);
        }
        if (this.bmd != null && this.bmd.aVi != null) {
            if (!Rp()) {
                at.ie(this.bmd.aVi.getId());
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.Fp.getPageActivity()).createFromThreadCfg(this.bmd.aVi, null, at.Mt(), 18003, true, false, false).addLocateParam(this.bmd.RA());
            addLocateParam.setVideo_source(this.bmd.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe");
            this.Fp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Rp() {
        return this.bmd.bou && !this.bmd.boI;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.p pVar) {
        this.bmd = pVar;
        Mf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke() {
        this.aNu.removeMessages(202);
        if (this.blV.getCurrentPosition() > 0) {
            e(true, 3);
            this.aNu.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aNu.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aNu.removeMessages(203);
        int currentPosition = this.blV.getCurrentPosition();
        if (currentPosition != this.aNo) {
            this.aNo = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aNu.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.blQ != null && this.blO != null && this.bme != null && this.bma != null && this.bmb != null && this.bmc != null && this.blZ != null && this.blY != null) {
            if (z || this.bmf != i) {
                this.bmf = i;
                com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bmi);
                com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aNs);
                if (i == 2) {
                    this.blQ.setVisibility(8);
                    this.bmh.cancel();
                    this.blO.clearAnimation();
                    this.blO.setVisibility(0);
                    this.bme.setVisibility(0);
                    this.blW.setVisibility(0);
                    this.blX.setVisibility(0);
                    this.bmb.setVisibility(0);
                    this.bmc.setVisibility(0);
                    this.blZ.setVisibility(8);
                    this.blY.setVisibility(8);
                    this.bma.setVisibility(8);
                    this.bma.blL();
                    com.baidu.adp.lib.g.h.eE().postDelayed(this.bmi, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.blQ.setVisibility(8);
                    this.blO.startAnimation(this.bmh);
                    this.bme.setVisibility(8);
                    this.blW.setVisibility(8);
                    this.blX.setVisibility(8);
                    this.bmb.setVisibility(8);
                    this.bmc.setVisibility(8);
                    this.blZ.setVisibility(8);
                    this.blY.setVisibility(8);
                    this.bma.setVisibility(0);
                    this.bma.start();
                } else if (i == 4) {
                    this.blQ.setVisibility(8);
                    this.blO.startAnimation(this.bmh);
                    this.bme.setVisibility(8);
                    this.bmb.setVisibility(8);
                    this.bmc.setVisibility(8);
                    this.blZ.setVisibility(0);
                    this.blY.setVisibility(0);
                    this.bma.setVisibility(8);
                    this.bma.blL();
                    com.baidu.adp.lib.g.h.eE().postDelayed(this.aNs, 2000L);
                } else {
                    this.blQ.setVisibility(0);
                    this.bmh.cancel();
                    this.blO.clearAnimation();
                    this.blO.setVisibility(0);
                    this.bme.setVisibility(0);
                    this.blW.setVisibility(0);
                    this.blX.setVisibility(0);
                    this.bmb.setVisibility(8);
                    this.bmc.setVisibility(8);
                    this.blZ.setVisibility(8);
                    this.blY.setVisibility(8);
                    this.bma.setVisibility(8);
                    this.bma.blL();
                }
            }
        }
    }

    private void Mf() {
        if (this.bmd == null || this.bmd.aVi == null || this.bmd.aVi.getAuthor() == null) {
            this.aUI.setVisibility(8);
            return;
        }
        this.aUI.setVisibility(0);
        Rq();
        if (this.bmd.bou) {
            this.aUT.setVisibility(8);
            this.aUX.setVisibility(8);
        } else {
            this.aUX.setVisibility(0);
            this.aUT.setVisibility(0);
            this.aUT.setData(this.bmd.aVi);
            this.aUT.setAfterClickListener(this.agO);
            UserTbVipInfoData rx = this.bmd.Ji().rx();
            if (rx != null && rx.getvipV_url() != null && this.aUU != null) {
                if (this.aUV == null) {
                    this.aUU.inflate();
                    this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                }
                this.aUV.c(rx.getvipV_url(), 10, false);
                this.aUT.setIsBigV(true);
            }
        }
        this.aUX.setData(this.bmd.aVi);
        this.aUX.setUserAfterClickListener(this.agO);
        this.mTextTitle.setText(this.bmd.aVi.getTitle());
        if (this.aUW.a(this.bmd.aVi)) {
            this.blT.setVisibility(8);
        } else {
            this.blT.setVisibility(0);
        }
        this.blW.setText(com.baidu.tbadk.core.util.at.cX(this.bmd.aVi.rN().video_duration.intValue() * 1000));
        this.blX.setText(this.Fp.getPageActivity().getString(r.l.play_count, new Object[]{com.baidu.tbadk.core.util.at.u(this.bmd.aVi.rN().play_count.intValue())}));
        this.aUW.setStType(at.Mt());
        this.aUW.setYuelaouLocate("feed#" + this.bmd.Rz());
        this.aUW.setForumAfterClickListener(this.agt);
        if (this.blU != null) {
            this.blU.setData(this.bmd);
        }
        onChangeSkinType(this.Fp, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.m13if(this.bmd.aVi.getId())) {
            com.baidu.tbadk.core.util.ap.c(this.mTextTitle, r.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.ap.c(this.mTextTitle, r.e.cp_cont_b, 1);
        }
        if (this.bmd.boI) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void Qm() {
        this.aNu.removeMessages(202);
        this.aNu.removeMessages(203);
    }

    private void QJ() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aNs);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bmi);
    }

    private void Rq() {
        QJ();
        Qm();
        if (this.blO != null && this.blN != null && this.blV != null) {
            if (com.baidu.tbadk.core.l.oC().oI() && this.bmd != null && this.bmd.aVi != null && this.bmd.aVi.rN() != null) {
                this.blO.setDefaultBgResource(r.g.pic_bg_video_frs);
                this.blO.c(this.bmd.aVi.rN().thumbnail_url, 10, false);
                this.blN.setVisibility(0);
                stopPlay();
                this.aOm = this.bmd.aVi.rN().video_url;
                if (StringUtils.isNull(this.bmd.aVi.rN().video_url)) {
                    e(true, 4);
                }
                if (this.aMm != null && this.aMm.aYn() != null) {
                    this.aMm.aYn().c(this.bmd.aVi.rN());
                    return;
                }
                return;
            }
            this.blN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(this.aUI, r.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.ap.c(this.blQ, r.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.ap.i((View) this.blY, r.e.cp_cont_i);
            com.baidu.tbadk.core.util.ap.i((View) this.blW, r.e.cp_cont_g);
            com.baidu.tbadk.core.util.ap.i((View) this.blX, r.e.cp_cont_g);
            com.baidu.tbadk.core.util.ap.k(this.blZ, r.e.common_color_10014);
            if (this.blY != null) {
                this.blY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.blU != null) {
                this.blU.tg();
            }
            if (this.blz != null) {
                this.blz.tg();
            }
            this.aUX.tg();
            this.aUW.tg();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aUW != null && this.blR != null) {
            this.aUW.h(bdUniqueId);
            this.blR.setTag(bdUniqueId);
            this.bmj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
            MessageManager.getInstance().registerListener(this.bmj);
        }
    }

    public boolean isPlayStarted() {
        return this.aMk;
    }

    public boolean isPlaying() {
        if (this.blV == null) {
            return false;
        }
        return this.blV.isPlaying();
    }

    public void startPlay() {
        if (!this.aMk && this.bmd != null && this.bmd.aVi != null && this.bmd.aVi.rN() != null && this.blV != null && com.baidu.tbadk.util.w.p(1, this.aOm)) {
            e(true, 2);
            this.blV.setVideoPath(this.aOm);
            this.blV.start();
            this.blV.setLooping(true);
            if (this.aMl != null) {
                this.aMl.start();
            }
            this.aMk = true;
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = this.bmd.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe";
            bbVar.bjS = this.bmd.aVi.getTid();
            bbVar.bjT = new StringBuilder(String.valueOf(this.bmd.aVi.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.bmd.aVi.TW;
            bbVar.eTy = this.bmd.aVi.TY;
            bbVar.eTz = this.bmd.aVi.TX;
            bbVar.eTA = "";
            if (this.bmd.aVi.sz() != null && this.bmd.aVi.sz().channelId > 0) {
                bbVar.Ql = new StringBuilder(String.valueOf(this.bmd.aVi.sz().channelId)).toString();
            } else {
                bbVar.Ql = "0";
            }
            com.baidu.tieba.play.ab.a(this.bmd.aVi.rN().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        QJ();
        Qm();
        e(true, 1);
        if (this.blV != null) {
            this.blV.stopPlayback();
            if (this.aMl != null) {
                this.aMl.stop();
            }
        }
        this.aMk = false;
    }

    public View getVideoContainer() {
        return this.blN;
    }

    public String getPlayUrl() {
        return this.aOm;
    }

    public int getCurrentPosition() {
        if (this.blV == null) {
            return 0;
        }
        return this.blV.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aMm != null) {
            this.aMm.a(bbVar);
        }
    }

    public void a(o.a aVar) {
        if (this.blU != null) {
            this.blU.setEventCallback(aVar);
        }
    }
}
