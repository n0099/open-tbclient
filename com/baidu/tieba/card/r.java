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
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.w;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class r extends a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> Gf;
    private t.d aMo;
    private t.b aMp;
    private boolean aNR;
    private com.baidu.tieba.play.w aNS;
    private com.baidu.tieba.play.ah aNT;
    private w.a aNV;
    private int aOU;
    private TbImageView.a aOV;
    private QuickVideoView.b aOX;
    private Runnable aOY;
    private String aPS;
    private Handler aPa;
    private Animation aRa;
    private final View.OnClickListener ahD;
    private final View.OnClickListener ahZ;
    public ViewStub bbQ;
    public TbImageView bbR;
    public ClickableHeaderImageView bcF;
    public ThreadCommentAndPraiseInfoLayout bcG;
    public View bcH;
    public FrameLayout bcI;
    public UserIconLayout bcJ;
    protected LinearLayout bcK;
    private com.baidu.tbadk.core.view.o bcL;
    private RelativeLayout bcM;
    private View bcN;
    private TbImageView bcO;
    private ImageView bcP;
    private QuickVideoView bcQ;
    private TextView bcR;
    private View bcS;
    private AudioAnimationView bcT;
    private ProgressBar bcU;
    private ImageView bcV;
    private com.baidu.tieba.card.data.o bcW;
    private View bcX;
    private int bcY;
    private boolean bcZ;
    private Runnable bda;
    private CustomMessageListener bdb;
    private CustomMessageListener bdc;
    private Animation.AnimationListener bdd;
    private int mSkinType;
    private TextView mTextTitle;

    public void OZ() {
        if (this.bcL == null) {
            this.bcL = new com.baidu.tbadk.core.view.o(this.Gf.getPageActivity());
            this.bcL.wt();
            this.bcG.addView(this.bcL);
        }
    }

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bcL = null;
        this.mSkinType = 3;
        this.aOU = 0;
        this.bcY = 1;
        this.aNR = false;
        this.bcZ = false;
        this.aPa = new s(this, Looper.getMainLooper());
        this.aMo = new x(this);
        this.aMp = new y(this);
        this.aOV = new z(this);
        this.aOY = new aa(this);
        this.bda = new ab(this);
        this.aOX = new ac(this);
        this.ahZ = new ad(this);
        this.bdb = new ae(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bdc = new t(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.ahD = new u(this);
        this.aNV = new v(this);
        this.bdd = new w(this);
        this.Gf = tbPageContext;
        View view = getView();
        this.bcM = (RelativeLayout) view.findViewById(r.g.layout_root);
        this.bcN = view.findViewById(r.g.divider);
        this.bcF = (ClickableHeaderImageView) view.findViewById(r.g.image_user);
        this.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bcF.setDefaultResource(17170445);
        this.bcF.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bcF.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bcF.setRadius(com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds70));
        this.bcJ = (UserIconLayout) view.findViewById(r.g.text_user_name);
        this.bcU = (ProgressBar) view.findViewById(r.g.auto_video_loading_progress);
        this.bcV = (ImageView) view.findViewById(r.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.g.text_title);
        this.bcG = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.text_bottom);
        this.bcH = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bcI = (FrameLayout) view.findViewById(r.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcI.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.K(this.Gf.getPageActivity()) - com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds144);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bcI.setLayoutParams(layoutParams);
        this.bcO = (TbImageView) view.findViewById(r.g.image_video);
        this.bcO.setDefaultErrorResource(0);
        this.bcO.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.bcO.setEvent(this.aOV);
        this.bcP = (ImageView) view.findViewById(r.g.image_video_play);
        this.bcT = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.bcT.setCertainColumnCount(4);
        this.bcT.setColumnColor(r.d.cp_cont_i);
        this.bcM.setOnClickListener(this);
        this.bcI.setOnClickListener(this);
        this.bcQ = (QuickVideoView) view.findViewById(r.g.texture_video_view);
        this.aNT = new com.baidu.tieba.play.ah(this.Gf.getPageActivity());
        this.bcQ.setBusiness(this.aNT);
        this.bcQ.setOnPreparedListener(this.aMo);
        this.bcQ.setOnErrorListener(this.aMp);
        this.bcQ.setOnSurfaceDestroyedListener(this.aOX);
        this.aNS = new com.baidu.tieba.play.w();
        this.aNS.setPlayer(this.bcQ);
        this.aNS.a(this.aNV);
        this.bcX = view.findViewById(r.g.auto_video_black_mask);
        this.bcR = (TextView) view.findViewById(r.g.auto_video_error_tips);
        this.bcS = view.findViewById(r.g.auto_video_error_background);
        this.bcK = (LinearLayout) view.findViewById(r.g.video_card_content_layout);
        this.aRa = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.fade_out_video_cover);
        this.aRa.setAnimationListener(this.bdd);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcM) {
            U(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        } else if (view == this.bcI) {
            V(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bcG != null) {
            this.bcG.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bcW);
        }
        if (this.bcW != null && this.bcW.beS != null) {
            if (!Pa()) {
                an.hR(this.bcW.beS.getId());
            }
            this.Gf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Gf.getPageActivity()).createFromThreadCfg(this.bcW.beS, null, an.Pf(), 18003, true, false, false).addLocateParam(this.bcW.Po())));
        }
    }

    private boolean Pa() {
        return this.bcW.bfl && !this.bcW.bfx;
    }

    private void V(View view) {
        if (this.bcW != null && this.bcW.beS != null && this.bcW.beS.sf() != null) {
            bz<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = getOnSubCardOnClickListenner();
            if (onSubCardOnClickListenner != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                onSubCardOnClickListenner.a(view, this.bcW);
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(r.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Gf.getPageActivity()).createNormalCfg(String.valueOf(this.bcW.beS.getFid()), this.bcW.beS.getTid(), ImageViewerConfig.INDEX)));
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
        this.bcW = oVar;
        Pb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kw() {
        this.aPa.removeMessages(202);
        if (this.bcQ.getCurrentPosition() > 0) {
            e(true, 3);
            this.aPa.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aPa.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kx() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aPa.removeMessages(203);
        int currentPosition = this.bcQ.getCurrentPosition();
        if (currentPosition != this.aOU) {
            this.aOU = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aPa.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bcP != null && this.bcO != null && this.bcX != null && this.bcT != null && this.bcU != null && this.bcV != null && this.bcS != null && this.bcR != null) {
            if (z || this.bcY != i) {
                this.bcY = i;
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bda);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aOY);
                if (i == 2) {
                    this.bcP.setVisibility(8);
                    this.aRa.cancel();
                    this.bcO.clearAnimation();
                    this.bcO.setVisibility(0);
                    this.bcX.setVisibility(0);
                    this.bcU.setVisibility(0);
                    this.bcV.setVisibility(0);
                    this.bcS.setVisibility(8);
                    this.bcR.setVisibility(8);
                    this.bcT.setVisibility(8);
                    this.bcT.btg();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.bda, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bcP.setVisibility(8);
                    this.bcO.startAnimation(this.aRa);
                    this.bcX.setVisibility(8);
                    this.bcU.setVisibility(8);
                    this.bcV.setVisibility(8);
                    this.bcS.setVisibility(8);
                    this.bcR.setVisibility(8);
                    this.bcT.setVisibility(0);
                    this.bcT.start();
                } else if (i == 4) {
                    this.bcP.setVisibility(8);
                    this.bcO.startAnimation(this.aRa);
                    this.bcX.setVisibility(8);
                    this.bcU.setVisibility(8);
                    this.bcV.setVisibility(8);
                    this.bcS.setVisibility(0);
                    this.bcR.setVisibility(0);
                    this.bcT.setVisibility(8);
                    this.bcT.btg();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aOY, 2000L);
                } else {
                    this.bcP.setVisibility(0);
                    this.aRa.cancel();
                    this.bcO.clearAnimation();
                    this.bcO.setVisibility(0);
                    this.bcX.setVisibility(0);
                    this.bcU.setVisibility(8);
                    this.bcV.setVisibility(8);
                    this.bcS.setVisibility(8);
                    this.bcR.setVisibility(8);
                    this.bcT.setVisibility(8);
                    this.bcT.btg();
                }
            }
        }
    }

    private void Pb() {
        if (this.bcW == null || this.bcW.beS == null || this.bcW.beS.getAuthor() == null) {
            this.bcM.setVisibility(8);
            return;
        }
        this.bcM.setVisibility(0);
        Pd();
        if (this.bcW.bfl) {
            this.bcF.setVisibility(8);
            this.bcJ.setVisibility(8);
        } else {
            this.bcJ.setVisibility(0);
            this.bcF.setVisibility(0);
            this.bcF.setData(this.bcW.beS);
            this.bcF.setAfterClickListener(this.ahZ);
            UserTbVipInfoData rQ = this.bcW.Jz().rQ();
            if (rQ != null && rQ.getvipV_url() != null && this.bbQ != null) {
                if (this.bbR == null) {
                    this.bbQ.inflate();
                    this.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.bbR.c(rQ.getvipV_url(), 10, false);
                this.bcF.setIsBigV(true);
            }
        }
        this.bcJ.setData(this.bcW.beS);
        this.bcJ.setUserAfterClickListener(this.ahZ);
        this.mTextTitle.setText(this.bcW.beS.getTitle());
        if (this.bcG.a(this.bcW.beS)) {
            this.bcH.setVisibility(8);
        } else {
            this.bcH.setVisibility(0);
        }
        this.bcG.setStType(an.Pf());
        this.bcG.setYuelaouLocate("feed#" + this.bcW.Pn());
        this.bcG.setForumAfterClickListener(this.ahD);
        if (this.bcL != null) {
            this.bcL.setData(this.bcW);
        }
        onChangeSkinType(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
        if (an.hS(this.bcW.beS.getId())) {
            com.baidu.tbadk.core.util.at.c(this.mTextTitle, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.at.c(this.mTextTitle, r.d.cp_cont_c, 1);
        }
        if (this.bcW.bfx) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void Pc() {
        this.aPa.removeMessages(202);
        this.aPa.removeMessages(203);
    }

    private void OE() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aOY);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bda);
    }

    private void Pd() {
        OE();
        Pc();
        if (this.bcO != null && this.bcI != null && this.bcQ != null) {
            if (com.baidu.tbadk.core.l.oJ().oP() && this.bcW != null && this.bcW.beS != null && this.bcW.beS.sf() != null) {
                this.bcO.setDefaultBgResource(r.f.pic_bg_video_frs);
                this.bcO.c(this.bcW.beS.sf().thumbnail_url, 10, false);
                this.bcI.setVisibility(0);
                stopPlay();
                this.aPS = this.bcW.beS.sf().video_url;
                if (StringUtils.isNull(this.bcW.beS.sf().video_url)) {
                    e(true, 4);
                }
                if (this.aNT != null && this.aNT.bcT() != null) {
                    this.aNT.bcT().c(this.bcW.beS.sf());
                }
            } else {
                this.bcI.setVisibility(8);
            }
            this.bcI.setClickable(true);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.bcM, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.c(this.bcP, r.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.at.j((View) this.mTextTitle, r.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.j((View) this.bcR, r.d.cp_cont_i);
            com.baidu.tbadk.core.util.at.l(this.bcN, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(this.bcS, r.d.common_color_10014);
            if (this.bcR != null) {
                this.bcR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bcL != null) {
                this.bcL.tB();
            }
            this.bcJ.tB();
            this.bcG.tB();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bcG != null && this.bdb != null) {
            this.bcG.h(bdUniqueId);
            this.bdb.setTag(bdUniqueId);
            this.bdc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
            MessageManager.getInstance().registerListener(this.bdc);
        }
    }

    public boolean JS() {
        return this.aNR;
    }

    public boolean isPlaying() {
        if (this.bcQ == null) {
            return false;
        }
        return this.bcQ.isPlaying();
    }

    public void JT() {
        if (!this.aNR && this.bcW != null && this.bcW.beS != null && this.bcW.beS.sf() != null && this.bcQ != null && com.baidu.tbadk.util.w.p(1, this.aPS)) {
            e(true, 2);
            this.bcQ.setVideoPath(this.aPS);
            this.bcQ.start();
            this.bcQ.setLooping(true);
            if (this.aNS != null) {
                this.aNS.start();
            }
            this.aNR = true;
            com.baidu.tieba.play.z.a(this.bcW.beS.sf().video_md5, this.bcW.beS.getTid(), new StringBuilder(String.valueOf(this.bcW.beS.getFid())).toString(), this.bcW.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe", "", "", "1");
        }
    }

    public void stopPlay() {
        OE();
        Pc();
        e(true, 1);
        if (this.bcQ != null) {
            this.bcQ.stopPlayback();
            if (this.aNS != null) {
                this.aNS.stop();
            }
        }
        this.aNR = false;
    }

    public View getVideoContainer() {
        return this.bcI;
    }

    public String getPlayUrl() {
        return this.aPS;
    }

    public int getCurrentPosition() {
        if (this.bcQ == null) {
            return 0;
        }
        return this.bcQ.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.ax axVar) {
        if (this.aNT != null) {
            this.aNT.a(axVar);
        }
    }

    public void a(o.a aVar) {
        if (this.bcL != null) {
            this.bcL.setEventCallback(aVar);
        }
    }
}
