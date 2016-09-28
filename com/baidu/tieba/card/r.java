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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.h;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class r extends a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> Gd;
    private boolean aLX;
    private com.baidu.tieba.play.h aLY;
    private com.baidu.tieba.play.s aLZ;
    private e.d aLr;
    private e.b aLs;
    private TbImageView.a aMQ;
    private QuickVideoView.b aMS;
    private Runnable aMT;
    private h.a aMa;
    private String aNM;
    private Animation aOU;
    public ViewStub aYH;
    public TbImageView aYI;
    protected LinearLayout aZA;
    private com.baidu.tbadk.core.view.o aZB;
    private RelativeLayout aZC;
    private View aZD;
    private TbImageView aZE;
    private ImageView aZF;
    private QuickVideoView aZG;
    private TextView aZH;
    private View aZI;
    private AudioAnimationView aZJ;
    private ProgressBar aZK;
    private ImageView aZL;
    private com.baidu.tieba.card.data.o aZM;
    private View aZN;
    private int aZO;
    private int aZP;
    private boolean aZQ;
    private Handler aZR;
    private Runnable aZS;
    private CustomMessageListener aZT;
    private CustomMessageListener aZU;
    private Animation.AnimationListener aZV;
    public ClickableHeaderImageView aZw;
    public ThreadCommentAndPraiseInfoLayout aZx;
    public FrameLayout aZy;
    public UserIconLayout aZz;
    private final View.OnClickListener ahd;
    private final View.OnClickListener ahz;
    private int mSkinType;
    private TextView mTextTitle;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aZB = null;
        this.mSkinType = 3;
        this.aZO = 0;
        this.aZP = 1;
        this.aLX = false;
        this.aZQ = false;
        this.aZR = new s(this, Looper.getMainLooper());
        this.aLr = new x(this);
        this.aLs = new y(this);
        this.aMQ = new z(this);
        this.aMT = new aa(this);
        this.aZS = new ab(this);
        this.aMS = new ac(this);
        this.ahz = new ad(this);
        this.aZT = new ae(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aZU = new t(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.ahd = new u(this);
        this.aMa = new v(this);
        this.aZV = new w(this);
        this.Gd = tbPageContext;
        View view = getView();
        this.aZC = (RelativeLayout) view.findViewById(r.g.layout_root);
        this.aZD = view.findViewById(r.g.divider);
        this.aZw = (ClickableHeaderImageView) view.findViewById(r.g.image_user);
        this.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.aZw.setDefaultResource(17170445);
        this.aZw.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.aZw.setDefaultBgResource(r.d.cp_bg_line_e);
        this.aZw.setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds70));
        this.aZz = (UserIconLayout) view.findViewById(r.g.text_user_name);
        this.aZK = (ProgressBar) view.findViewById(r.g.auto_video_loading_progress);
        this.aZL = (ImageView) view.findViewById(r.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.g.text_title);
        this.aZx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.text_bottom);
        this.aZB = new com.baidu.tbadk.core.view.o(tbPageContext.getPageActivity());
        this.aZB.wp();
        this.aZx.addView(this.aZB);
        this.aZy = (FrameLayout) view.findViewById(r.g.frame_video);
        this.aZE = (TbImageView) view.findViewById(r.g.image_video);
        this.aZE.setDefaultErrorResource(0);
        this.aZE.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.aZE.setEvent(this.aMQ);
        this.aZF = (ImageView) view.findViewById(r.g.image_video_play);
        this.aZJ = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.aZJ.setCertainColumnCount(4);
        this.aZJ.setColumnColor(r.d.cp_cont_i);
        this.aZC.setOnClickListener(this);
        this.aZy.setOnClickListener(this);
        this.aZG = (QuickVideoView) view.findViewById(r.g.texture_video_view);
        this.aLZ = new com.baidu.tieba.play.s(this.Gd.getPageActivity());
        this.aZG.setBusiness(this.aLZ);
        this.aZG.setOnPreparedListener(this.aLr);
        this.aZG.setOnErrorListener(this.aLs);
        this.aZG.setOnSurfaceDestroyedListener(this.aMS);
        this.aLY = new com.baidu.tieba.play.h();
        this.aLY.setPlayer(this.aZG);
        this.aLY.a(this.aMa);
        this.aZN = view.findViewById(r.g.auto_video_black_mask);
        this.aZH = (TextView) view.findViewById(r.g.auto_video_error_tips);
        this.aZI = view.findViewById(r.g.auto_video_error_background);
        this.aZA = (LinearLayout) view.findViewById(r.g.video_card_content_layout);
        this.aOU = AnimationUtils.loadAnimation(this.Gd.getPageActivity(), r.a.fade_out_video_cover);
        this.aOU.setAnimationListener(this.aZV);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZC) {
            T(view);
        } else if (view == this.aZy) {
            U(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aZx != null) {
            this.aZx.setBarNameClickEnabled(z);
        }
    }

    private void T(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aZM);
        }
        if (this.aZM != null && this.aZM.bbU != null) {
            if (!NW()) {
                an.hN(this.aZM.bbU.getId());
            }
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Gd.getPageActivity()).createFromThreadCfg(this.aZM.bbU, null, an.Od(), 18003, true, false, false).addLocateParam(this.aZM.Ol())));
        }
    }

    private boolean NW() {
        return this.aZM.bcm && !this.aZM.bcy;
    }

    private void U(View view) {
        if (this.aZM != null && this.aZM.bbU != null && this.aZM.bbU.sd() != null) {
            cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = getOnSubCardOnClickListenner();
            if (onSubCardOnClickListenner != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                onSubCardOnClickListenner.a(view, this.aZM);
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(r.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Gd.getPageActivity()).createNormalCfg(String.valueOf(this.aZM.bbU.getFid()), this.aZM.bbU.getTid(), ImageViewerConfig.INDEX)));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.aZM = oVar;
        NZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NX() {
        this.aZR.removeMessages(202);
        if (this.aZG.getCurrentPosition() > 0) {
            e(true, 3);
            this.aZR.sendEmptyMessageDelayed(203, 1000L);
            return;
        }
        this.aZR.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NY() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aZR.removeMessages(203);
        int currentPosition = this.aZG.getCurrentPosition();
        if (currentPosition != this.aZO) {
            this.aZO = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aZR.sendEmptyMessageDelayed(203, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.aZF != null && this.aZE != null && this.aZN != null && this.aZJ != null && this.aZK != null && this.aZL != null && this.aZI != null && this.aZH != null) {
            if (z || this.aZP != i) {
                this.aZP = i;
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aZS);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aMT);
                if (i == 2) {
                    this.aZF.setVisibility(8);
                    this.aOU.cancel();
                    this.aZE.clearAnimation();
                    this.aZE.setVisibility(0);
                    this.aZN.setVisibility(0);
                    this.aZK.setVisibility(0);
                    this.aZL.setVisibility(0);
                    this.aZI.setVisibility(8);
                    this.aZH.setVisibility(8);
                    this.aZJ.setVisibility(8);
                    this.aZJ.bqM();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aZS, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.aZF.setVisibility(8);
                    this.aZE.startAnimation(this.aOU);
                    this.aZN.setVisibility(8);
                    this.aZK.setVisibility(8);
                    this.aZL.setVisibility(8);
                    this.aZI.setVisibility(8);
                    this.aZH.setVisibility(8);
                    this.aZJ.setVisibility(0);
                    this.aZJ.start();
                } else if (i == 4) {
                    this.aZF.setVisibility(8);
                    this.aZE.startAnimation(this.aOU);
                    this.aZN.setVisibility(8);
                    this.aZK.setVisibility(8);
                    this.aZL.setVisibility(8);
                    this.aZI.setVisibility(0);
                    this.aZH.setVisibility(0);
                    this.aZJ.setVisibility(8);
                    this.aZJ.bqM();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aMT, 2000L);
                } else {
                    this.aZF.setVisibility(0);
                    this.aOU.cancel();
                    this.aZE.clearAnimation();
                    this.aZE.setVisibility(0);
                    this.aZN.setVisibility(0);
                    this.aZK.setVisibility(8);
                    this.aZL.setVisibility(8);
                    this.aZI.setVisibility(8);
                    this.aZH.setVisibility(8);
                    this.aZJ.setVisibility(8);
                    this.aZJ.bqM();
                }
            }
        }
    }

    private void NZ() {
        if (this.aZM == null || this.aZM.bbU == null || this.aZM.bbU.getAuthor() == null) {
            this.aZC.setVisibility(8);
            return;
        }
        this.aZC.setVisibility(0);
        Ob();
        if (this.aZM.bcm) {
            this.aZw.setVisibility(8);
            this.aZz.setVisibility(8);
        } else {
            this.aZz.setVisibility(0);
            this.aZw.setVisibility(0);
            this.aZw.setData(this.aZM.bbU);
            this.aZw.setAfterClickListener(this.ahz);
            UserTbVipInfoData rO = this.aZM.Jv().rO();
            if (rO != null && rO.getvipV_url() != null && this.aYH != null) {
                if (this.aYI == null) {
                    this.aYH.inflate();
                    this.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.aYI.c(rO.getvipV_url(), 10, false);
                this.aZw.setIsBigV(true);
            }
        }
        this.aZz.setData(this.aZM.bbU);
        this.aZz.setUserAfterClickListener(this.ahz);
        this.mTextTitle.setText(this.aZM.bbU.getTitle());
        this.aZx.setData(this.aZM.bbU);
        this.aZx.setStType(an.Od());
        this.aZx.setYuelaouLocate("feed#" + this.aZM.Ok());
        this.aZx.setForumAfterClickListener(this.ahd);
        if (this.aZB != null) {
            this.aZB.setData(this.aZM);
        }
        onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
        if (an.hO(this.aZM.bbU.getId())) {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, r.d.cp_cont_c, 1);
        }
        if (this.aZM.bcy) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void Oa() {
        this.aZR.removeMessages(202);
        this.aZR.removeMessages(203);
    }

    private void NB() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aMT);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aZS);
    }

    private void Ob() {
        NB();
        Oa();
        if (this.aZE != null && this.aZy != null && this.aZG != null) {
            if (com.baidu.tbadk.core.l.oH().oN() && this.aZM != null && this.aZM.bbU != null && this.aZM.bbU.sd() != null) {
                this.aZE.setDefaultBgResource(r.f.pic_bg_video_frs);
                this.aZE.c(this.aZM.bbU.sd().thumbnail_url, 10, false);
                this.aZy.setVisibility(0);
                stopPlay();
                this.aNM = this.aZM.bbU.sd().video_url;
                if (StringUtils.isNull(this.aZM.bbU.sd().video_url)) {
                    e(true, 4);
                }
                if (this.aLZ != null && this.aLZ.bav() != null) {
                    this.aLZ.bav().c(this.aZM.bbU.sd());
                }
            } else {
                this.aZy.setVisibility(8);
            }
            this.aZy.setClickable(true);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.aZC, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(this.aZF, r.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.av.j((View) this.mTextTitle, r.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.j((View) this.aZH, r.d.cp_cont_i);
            com.baidu.tbadk.core.util.av.l(this.aZD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.aZI, r.d.common_color_10014);
            com.baidu.tbadk.core.util.av.l(this.aZy, r.d.cp_bg_line_k);
            com.baidu.tbadk.core.util.av.l(this.aZN, r.d.cp_bg_line_k);
            if (this.aZH != null) {
                this.aZH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.aZB != null) {
                this.aZB.tx();
            }
            this.aZz.tx();
            this.aZx.tx();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aZx != null && this.aZT != null) {
            this.aZx.h(bdUniqueId);
            this.aZT.setTag(bdUniqueId);
            this.aZU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
            MessageManager.getInstance().registerListener(this.aZU);
        }
    }

    public boolean Jr() {
        return this.aLX;
    }

    public boolean isPlaying() {
        if (this.aZG == null) {
            return false;
        }
        return this.aZG.isPlaying();
    }

    public void Js() {
        if (!this.aLX && this.aZM != null && this.aZM.bbU != null && this.aZM.bbU.sd() != null && this.aZG != null && com.baidu.tbadk.util.x.q(1, this.aNM)) {
            e(true, 2);
            this.aZG.setVideoPath(this.aNM);
            this.aZG.start();
            if (this.aLY != null) {
                this.aLY.start();
            }
            this.aLX = true;
            com.baidu.tieba.play.j.a(this.aZM.bbU.sd().video_md5, this.aZM.bbU.getTid(), new StringBuilder(String.valueOf(this.aZM.bbU.getFid())).toString(), ImageViewerConfig.INDEX, "", "", "1");
        }
    }

    public void stopPlay() {
        NB();
        Oa();
        e(true, 1);
        if (this.aZG != null) {
            this.aZG.stopPlayback();
            if (this.aLY != null) {
                this.aLY.stop();
            }
        }
        this.aLX = false;
    }

    public View getVideoContainer() {
        return this.aZy;
    }

    public String getPlayUrl() {
        return this.aNM;
    }

    public int getCurrentPosition() {
        if (this.aZG == null) {
            return 0;
        }
        return this.aZG.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.ad adVar) {
        if (this.aLZ != null) {
            this.aLZ.a(adVar);
        }
    }
}
