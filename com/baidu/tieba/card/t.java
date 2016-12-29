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
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.w;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> Gf;
    private t.d aLF;
    private t.b aLG;
    private boolean aNi;
    private com.baidu.tieba.play.w aNj;
    private com.baidu.tieba.play.ah aNk;
    private w.a aNm;
    private int aOl;
    private TbImageView.a aOm;
    private QuickVideoView.b aOo;
    private Runnable aOp;
    private Handler aOr;
    private String aPj;
    private Animation aQr;
    private final View.OnClickListener ahA;
    private final View.OnClickListener ahg;
    public ViewStub baW;
    public TbImageView baX;
    private CardGroupDividerView bbM;
    public ClickableHeaderImageView bbY;
    public ThreadCommentAndPraiseInfoLayout bbZ;
    public View bca;
    public FrameLayout bcb;
    public UserIconLayout bcc;
    protected LinearLayout bcd;
    private com.baidu.tbadk.core.view.o bce;
    private RelativeLayout bcf;
    private TbImageView bcg;
    private ImageView bch;
    private QuickVideoView bci;
    private TextView bcj;
    private View bck;
    private AudioAnimationView bcl;
    private ProgressBar bcm;
    private ImageView bcn;
    private com.baidu.tieba.card.data.o bco;
    private View bcp;
    private int bcq;
    private boolean bcr;
    private Runnable bcs;
    private CustomMessageListener bct;
    private CustomMessageListener bcu;
    private Animation.AnimationListener bcv;
    private int mSkinType;
    private TextView mTextTitle;

    public void Ov() {
        if (this.bce == null) {
            this.bce = new com.baidu.tbadk.core.view.o(this.Gf.getPageActivity());
            this.bce.wd();
            this.bbZ.addView(this.bce);
        }
    }

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bce = null;
        this.mSkinType = 3;
        this.aOl = 0;
        this.bcq = 1;
        this.aNi = false;
        this.bcr = false;
        this.aOr = new u(this, Looper.getMainLooper());
        this.aLF = new z(this);
        this.aLG = new aa(this);
        this.aOm = new ab(this);
        this.aOp = new ac(this);
        this.bcs = new ad(this);
        this.aOo = new ae(this);
        this.ahA = new af(this);
        this.bct = new ag(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bcu = new v(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.ahg = new w(this);
        this.aNm = new x(this);
        this.bcv = new y(this);
        this.Gf = tbPageContext;
        View view = getView();
        this.bcf = (RelativeLayout) view.findViewById(r.g.layout_root);
        this.bbY = (ClickableHeaderImageView) view.findViewById(r.g.image_user);
        this.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bbY.setDefaultResource(17170445);
        this.bbY.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bbY.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bbY.setRadius(com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds70));
        this.bcc = (UserIconLayout) view.findViewById(r.g.text_user_name);
        this.bcm = (ProgressBar) view.findViewById(r.g.auto_video_loading_progress);
        this.bcn = (ImageView) view.findViewById(r.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.g.text_title);
        this.bbZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.text_bottom);
        this.bca = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bcb = (FrameLayout) view.findViewById(r.g.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcb.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.I(this.Gf.getPageActivity()) - com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds144);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bcb.setLayoutParams(layoutParams);
        this.bcg = (TbImageView) view.findViewById(r.g.image_video);
        this.bcg.setDefaultErrorResource(0);
        this.bcg.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.bcg.setEvent(this.aOm);
        this.bch = (ImageView) view.findViewById(r.g.image_video_play);
        this.bcl = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.bcl.setCertainColumnCount(4);
        this.bcl.setColumnColor(r.d.cp_cont_i);
        this.bcf.setOnClickListener(this);
        this.bcb.setOnClickListener(this);
        this.bci = (QuickVideoView) view.findViewById(r.g.texture_video_view);
        this.aNk = new com.baidu.tieba.play.ah(this.Gf.getPageActivity());
        this.bci.setBusiness(this.aNk);
        this.bci.setOnPreparedListener(this.aLF);
        this.bci.setOnErrorListener(this.aLG);
        this.bci.setOnSurfaceDestroyedListener(this.aOo);
        this.aNj = new com.baidu.tieba.play.w();
        this.aNj.setPlayer(this.bci);
        this.aNj.a(this.aNm);
        this.bcp = view.findViewById(r.g.auto_video_black_mask);
        this.bcj = (TextView) view.findViewById(r.g.auto_video_error_tips);
        this.bck = view.findViewById(r.g.auto_video_error_background);
        this.bcd = (LinearLayout) view.findViewById(r.g.video_card_content_layout);
        this.aQr = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.fade_out_video_cover);
        this.aQr.setAnimationListener(this.bcv);
        this.bbM = (CardGroupDividerView) view.findViewById(r.g.header_divider);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcf) {
            U(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        } else if (view == this.bcb) {
            V(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbZ != null) {
            this.bbZ.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.bco);
        }
        if (this.bco != null && this.bco.beB != null) {
            if (!Ow()) {
                ap.hL(this.bco.beB.getId());
            }
            this.Gf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Gf.getPageActivity()).createFromThreadCfg(this.bco.beB, null, ap.OB(), 18003, true, false, false).addLocateParam(this.bco.OK())));
        }
    }

    private boolean Ow() {
        return this.bco.beA && !this.bco.beN;
    }

    private void V(View view) {
        if (this.bco != null && this.bco.beB != null && this.bco.beB.rW() != null) {
            cb<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = getOnSubCardOnClickListenner();
            if (onSubCardOnClickListenner != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                onSubCardOnClickListenner.a(view, this.bco);
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(r.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Gf.getPageActivity()).createNormalCfg(String.valueOf(this.bco.beB.getFid()), this.bco.beB.getTid(), ImageViewerConfig.INDEX)));
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
        this.bco = oVar;
        Ox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP() {
        this.aOr.removeMessages(202);
        if (this.bci.getCurrentPosition() > 0) {
            e(true, 3);
            this.aOr.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aOr.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JQ() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aOr.removeMessages(203);
        int currentPosition = this.bci.getCurrentPosition();
        if (currentPosition != this.aOl) {
            this.aOl = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aOr.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bch != null && this.bcg != null && this.bcp != null && this.bcl != null && this.bcm != null && this.bcn != null && this.bck != null && this.bcj != null) {
            if (z || this.bcq != i) {
                this.bcq = i;
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bcs);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aOp);
                if (i == 2) {
                    this.bch.setVisibility(8);
                    this.aQr.cancel();
                    this.bcg.clearAnimation();
                    this.bcg.setVisibility(0);
                    this.bcp.setVisibility(0);
                    this.bcm.setVisibility(0);
                    this.bcn.setVisibility(0);
                    this.bck.setVisibility(8);
                    this.bcj.setVisibility(8);
                    this.bcl.setVisibility(8);
                    this.bcl.bkg();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.bcs, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bch.setVisibility(8);
                    this.bcg.startAnimation(this.aQr);
                    this.bcp.setVisibility(8);
                    this.bcm.setVisibility(8);
                    this.bcn.setVisibility(8);
                    this.bck.setVisibility(8);
                    this.bcj.setVisibility(8);
                    this.bcl.setVisibility(0);
                    this.bcl.start();
                } else if (i == 4) {
                    this.bch.setVisibility(8);
                    this.bcg.startAnimation(this.aQr);
                    this.bcp.setVisibility(8);
                    this.bcm.setVisibility(8);
                    this.bcn.setVisibility(8);
                    this.bck.setVisibility(0);
                    this.bcj.setVisibility(0);
                    this.bcl.setVisibility(8);
                    this.bcl.bkg();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aOp, 2000L);
                } else {
                    this.bch.setVisibility(0);
                    this.aQr.cancel();
                    this.bcg.clearAnimation();
                    this.bcg.setVisibility(0);
                    this.bcp.setVisibility(0);
                    this.bcm.setVisibility(8);
                    this.bcn.setVisibility(8);
                    this.bck.setVisibility(8);
                    this.bcj.setVisibility(8);
                    this.bcl.setVisibility(8);
                    this.bcl.bkg();
                }
            }
        }
    }

    private void Ox() {
        if (this.bco == null || this.bco.beB == null || this.bco.beB.getAuthor() == null) {
            this.bcf.setVisibility(8);
            return;
        }
        this.bcf.setVisibility(0);
        Oz();
        if (this.bco.beA) {
            this.bbY.setVisibility(8);
            this.bcc.setVisibility(8);
        } else {
            this.bcc.setVisibility(0);
            this.bbY.setVisibility(0);
            this.bbY.setData(this.bco.beB);
            this.bbY.setAfterClickListener(this.ahA);
            UserTbVipInfoData rF = this.bco.IU().rF();
            if (rF != null && rF.getvipV_url() != null && this.baW != null) {
                if (this.baX == null) {
                    this.baW.inflate();
                    this.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.baX.c(rF.getvipV_url(), 10, false);
                this.bbY.setIsBigV(true);
            }
        }
        this.bcc.setData(this.bco.beB);
        this.bcc.setUserAfterClickListener(this.ahA);
        this.mTextTitle.setText(this.bco.beB.getTitle());
        if (this.bbZ.a(this.bco.beB)) {
            this.bca.setVisibility(8);
        } else {
            this.bca.setVisibility(0);
        }
        this.bbZ.setStType(ap.OB());
        this.bbZ.setYuelaouLocate("feed#" + this.bco.OJ());
        this.bbZ.setForumAfterClickListener(this.ahg);
        if (this.bce != null) {
            this.bce.setData(this.bco);
        }
        onChangeSkinType(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
        if (ap.hM(this.bco.beB.getId())) {
            com.baidu.tbadk.core.util.ar.c(this.mTextTitle, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.ar.c(this.mTextTitle, r.d.cp_cont_c, 1);
        }
        if (this.bco.beN) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void Oy() {
        this.aOr.removeMessages(202);
        this.aOr.removeMessages(203);
    }

    private void NQ() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aOp);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bcs);
    }

    private void Oz() {
        NQ();
        Oy();
        if (this.bcg != null && this.bcb != null && this.bci != null) {
            if (com.baidu.tbadk.core.l.oJ().oP() && this.bco != null && this.bco.beB != null && this.bco.beB.rW() != null) {
                this.bcg.setDefaultBgResource(r.f.pic_bg_video_frs);
                this.bcg.c(this.bco.beB.rW().thumbnail_url, 10, false);
                this.bcb.setVisibility(0);
                stopPlay();
                this.aPj = this.bco.beB.rW().video_url;
                if (StringUtils.isNull(this.bco.beB.rW().video_url)) {
                    e(true, 4);
                }
                if (this.aNk != null && this.aNk.aWA() != null) {
                    this.aNk.aWA().c(this.bco.beB.rW());
                }
            } else {
                this.bcb.setVisibility(8);
            }
            this.bcb.setClickable(true);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(this.bcf, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.c(this.bch, r.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.ar.j((View) this.mTextTitle, r.d.cp_cont_c);
            com.baidu.tbadk.core.util.ar.j((View) this.bcj, r.d.cp_cont_i);
            com.baidu.tbadk.core.util.ar.l(this.bck, r.d.common_color_10014);
            if (this.bcj != null) {
                this.bcj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bce != null) {
                this.bce.tm();
            }
            if (this.bbM != null) {
                this.bbM.tm();
            }
            this.bcc.tm();
            this.bbZ.tm();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbZ != null && this.bct != null) {
            this.bbZ.h(bdUniqueId);
            this.bct.setTag(bdUniqueId);
            this.bcu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
            MessageManager.getInstance().registerListener(this.bcu);
        }
    }

    public boolean isPlayStarted() {
        return this.aNi;
    }

    public boolean isPlaying() {
        if (this.bci == null) {
            return false;
        }
        return this.bci.isPlaying();
    }

    public void startPlay() {
        if (!this.aNi && this.bco != null && this.bco.beB != null && this.bco.beB.rW() != null && this.bci != null && com.baidu.tbadk.util.w.p(1, this.aPj)) {
            e(true, 2);
            this.bci.setVideoPath(this.aPj);
            this.bci.start();
            this.bci.setLooping(true);
            if (this.aNj != null) {
                this.aNj.start();
            }
            this.aNi = true;
            com.baidu.tieba.play.z.a(this.bco.beB.rW().video_md5, this.bco.beB.getTid(), new StringBuilder(String.valueOf(this.bco.beB.getFid())).toString(), this.bco.sourceType == 0 ? ImageViewerConfig.INDEX : "hot_juhe", "", "", "1");
        }
    }

    public void stopPlay() {
        NQ();
        Oy();
        e(true, 1);
        if (this.bci != null) {
            this.bci.stopPlayback();
            if (this.aNj != null) {
                this.aNj.stop();
            }
        }
        this.aNi = false;
    }

    public View getVideoContainer() {
        return this.bcb;
    }

    public String getPlayUrl() {
        return this.aPj;
    }

    public int getCurrentPosition() {
        if (this.bci == null) {
            return 0;
        }
        return this.bci.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.ax axVar) {
        if (this.aNk != null) {
            this.aNk.a(axVar);
        }
    }

    public void a(o.a aVar) {
        if (this.bce != null) {
            this.bce.setEventCallback(aVar);
        }
    }
}
