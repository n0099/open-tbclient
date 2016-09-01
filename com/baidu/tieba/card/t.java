package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class t extends a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> Gd;
    private String aMC;
    private Animation aNL;
    private boolean aPv;
    public ViewStub aYe;
    public TbImageView aYf;
    private Runnable aZA;
    private CustomMessageListener aZB;
    private CustomMessageListener aZC;
    private f.a aZD;
    private Animation.AnimationListener aZE;
    public ClickableHeaderImageView aZc;
    public ThreadCommentAndPraiseInfoLayout aZd;
    public FrameLayout aZe;
    public UserIconLayout aZf;
    protected LinearLayout aZg;
    private RelativeLayout aZh;
    private View aZi;
    private TbImageView aZj;
    private ImageView aZk;
    private TextureVideoView aZl;
    private TextView aZm;
    private View aZn;
    private AudioAnimationView aZo;
    private ProgressBar aZp;
    private ImageView aZq;
    private com.baidu.tieba.card.data.o aZr;
    private View aZs;
    private int aZt;
    private int aZu;
    private boolean aZv;
    private com.baidu.tieba.play.f aZw;
    private Handler aZx;
    private TbImageView.a aZy;
    private Runnable aZz;
    private MediaPlayer.OnPreparedListener agG;
    private MediaPlayer.OnErrorListener agI;
    private TextureVideoView.b agO;
    private final View.OnClickListener ahR;
    private final View.OnClickListener ahu;
    private int mSkinType;
    private TextView mTextTitle;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aZt = 0;
        this.aZu = 1;
        this.aPv = false;
        this.aZv = false;
        this.aZx = new u(this, Looper.getMainLooper());
        this.agG = new z(this);
        this.agI = new aa(this);
        this.aZy = new ab(this);
        this.aZz = new ac(this);
        this.aZA = new ad(this);
        this.agO = new ae(this);
        this.ahR = new af(this);
        this.aZB = new ag(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aZC = new v(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.ahu = new w(this);
        this.aZD = new x(this);
        this.aZE = new y(this);
        this.Gd = tbPageContext;
        View view = getView();
        this.aZh = (RelativeLayout) view.findViewById(t.g.layout_root);
        this.aZi = view.findViewById(t.g.divider);
        this.aZc = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        this.aZc.setDefaultResource(17170445);
        this.aZc.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aZc.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aZc.setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds70));
        this.aZf = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.aZp = (ProgressBar) view.findViewById(t.g.auto_video_loading_progress);
        this.aZq = (ImageView) view.findViewById(t.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.aZd = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.aZe = (FrameLayout) view.findViewById(t.g.frame_video);
        this.aZj = (TbImageView) view.findViewById(t.g.image_video);
        this.aZj.setDefaultErrorResource(0);
        this.aZj.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aZj.setEvent(this.aZy);
        this.aZk = (ImageView) view.findViewById(t.g.image_video_play);
        this.aZo = (AudioAnimationView) view.findViewById(t.g.auto_video_play_state);
        this.aZo.setCertainColumnCount(4);
        this.aZo.setColumnColor(t.d.cp_cont_i);
        this.aZh.setOnClickListener(this);
        this.aZe.setOnClickListener(this);
        this.aZl = (TextureVideoView) view.findViewById(t.g.texture_video_view);
        this.aZl.setEnableRefresh(true);
        this.aZl.setOnPreparedListener(this.agG);
        this.aZl.setOnErrorListener(this.agI);
        this.aZl.setOnSurfaceDestroyedListener(this.agO);
        this.aZw = new com.baidu.tieba.play.f(this.Gd.getPageActivity());
        this.aZw.setPlayer(this.aZl);
        this.aZw.a(this.aZD);
        this.aZs = view.findViewById(t.g.auto_video_black_mask);
        this.aZm = (TextView) view.findViewById(t.g.auto_video_error_tips);
        this.aZn = view.findViewById(t.g.auto_video_error_background);
        this.aZg = (LinearLayout) view.findViewById(t.g.video_card_content_layout);
        this.aNL = AnimationUtils.loadAnimation(this.Gd.getPageActivity(), t.a.fade_out_video_cover);
        this.aNL.setAnimationListener(this.aZE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZh) {
            T(view);
        } else if (view == this.aZe) {
            U(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aZd != null) {
            this.aZd.setBarNameClickEnabled(z);
        }
    }

    private void T(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aZr);
        }
        if (this.aZr != null && this.aZr.bbC != null) {
            if (!Nv()) {
                ap.hG(this.aZr.bbC.getId());
            }
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Gd.getPageActivity()).createFromThreadCfg(this.aZr.bbC, null, ap.ND(), 18003, true, false, false).addLocateParam(this.aZr.NK())));
        }
    }

    private boolean Nv() {
        return this.aZr.bbU && !this.aZr.bcg;
    }

    private void U(View view) {
        if (this.aZr != null && this.aZr.bbC != null && this.aZr.bbC.rR() != null) {
            cf<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = getOnSubCardOnClickListenner();
            if (onSubCardOnClickListenner != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                onSubCardOnClickListenner.a(view, this.aZr);
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(t.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Gd.getPageActivity()).createNormalCfg(String.valueOf(this.aZr.bbC.getFid()), this.aZr.bbC.getTid(), ImageViewerConfig.INDEX)));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.aZr = oVar;
        Ny();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nw() {
        this.aZx.removeMessages(202);
        if (this.aZl.getCurrentPosition() > 0) {
            d(true, 3);
            this.aZx.sendEmptyMessageDelayed(203, 1000L);
            return;
        }
        this.aZx.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nx() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aZx.removeMessages(203);
        int currentPosition = this.aZl.getCurrentPosition();
        if (currentPosition != this.aZt) {
            this.aZt = currentPosition;
            d(false, 3);
        } else {
            d(false, 2);
        }
        this.aZx.sendEmptyMessageDelayed(203, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i) {
        if (this.aZk != null && this.aZj != null && this.aZs != null && this.aZo != null && this.aZp != null && this.aZq != null && this.aZn != null && this.aZm != null) {
            if (z || this.aZu != i) {
                this.aZu = i;
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aZA);
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aZz);
                if (i == 2) {
                    this.aZk.setVisibility(8);
                    this.aNL.cancel();
                    this.aZj.clearAnimation();
                    this.aZj.setVisibility(0);
                    this.aZs.setVisibility(0);
                    this.aZp.setVisibility(0);
                    this.aZq.setVisibility(0);
                    this.aZn.setVisibility(8);
                    this.aZm.setVisibility(8);
                    this.aZo.setVisibility(8);
                    this.aZo.bqi();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aZA, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.aZk.setVisibility(8);
                    this.aZj.startAnimation(this.aNL);
                    this.aZs.setVisibility(8);
                    this.aZp.setVisibility(8);
                    this.aZq.setVisibility(8);
                    this.aZn.setVisibility(8);
                    this.aZm.setVisibility(8);
                    this.aZo.setVisibility(0);
                    this.aZo.start();
                } else if (i == 4) {
                    this.aZk.setVisibility(8);
                    this.aZj.startAnimation(this.aNL);
                    this.aZs.setVisibility(8);
                    this.aZp.setVisibility(8);
                    this.aZq.setVisibility(8);
                    this.aZn.setVisibility(0);
                    this.aZm.setVisibility(0);
                    this.aZo.setVisibility(8);
                    this.aZo.bqi();
                    com.baidu.adp.lib.h.h.eG().postDelayed(this.aZz, 2000L);
                } else {
                    this.aZk.setVisibility(0);
                    this.aNL.cancel();
                    this.aZj.clearAnimation();
                    this.aZj.setVisibility(0);
                    this.aZs.setVisibility(0);
                    this.aZp.setVisibility(8);
                    this.aZq.setVisibility(8);
                    this.aZn.setVisibility(8);
                    this.aZm.setVisibility(8);
                    this.aZo.setVisibility(8);
                    this.aZo.bqi();
                }
            }
        }
    }

    private void Ny() {
        if (this.aZr == null || this.aZr.bbC == null || this.aZr.bbC.getAuthor() == null) {
            this.aZh.setVisibility(8);
            return;
        }
        this.aZh.setVisibility(0);
        NA();
        if (this.aZr.bbU) {
            this.aZc.setVisibility(8);
            this.aZf.setVisibility(8);
        } else {
            this.aZf.setVisibility(0);
            this.aZc.setVisibility(0);
            this.aZc.setData(this.aZr.bbC);
            this.aZc.setAfterClickListener(this.ahR);
            UserTbVipInfoData rC = this.aZr.Kw().rC();
            if (rC != null && rC.getvipV_url() != null && this.aYe != null) {
                if (this.aYf == null) {
                    this.aYe.inflate();
                    this.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                }
                this.aYf.c(rC.getvipV_url(), 10, false);
                this.aZc.setIsBigV(true);
            }
        }
        this.aZf.setData(this.aZr.bbC);
        this.aZf.setUserAfterClickListener(this.ahR);
        this.mTextTitle.setText(this.aZr.bbC.getTitle());
        this.aZd.setData(this.aZr.bbC);
        this.aZd.setStType(ap.ND());
        this.aZd.setYuelaouLocate("feed#" + this.aZr.NJ());
        this.aZd.setForumAfterClickListener(this.ahu);
        onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
        if (ap.hH(this.aZr.bbC.getId())) {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, t.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, t.d.cp_cont_c, 1);
        }
        if (this.aZr.bcg) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void Nz() {
        this.aZx.removeMessages(202);
        this.aZx.removeMessages(203);
    }

    private void Na() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aZz);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aZA);
    }

    private void NA() {
        Na();
        Nz();
        if (this.aZj != null && this.aZe != null && this.aZl != null) {
            if (com.baidu.tbadk.core.l.oG().oM() && this.aZr != null && this.aZr.bbC != null && this.aZr.bbC.rR() != null) {
                this.aZj.setDefaultBgResource(t.f.pic_bg_video_frs);
                this.aZj.c(this.aZr.bbC.rR().thumbnail_url, 10, false);
                this.aZe.setVisibility(0);
                stopPlay();
                this.aMC = this.aZr.bbC.rR().video_url;
                if (StringUtils.isNull(this.aZr.bbC.rR().video_url)) {
                    d(true, 4);
                }
            } else {
                this.aZe.setVisibility(8);
            }
            this.aZe.setClickable(true);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.aZh, t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(this.aZk, t.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.av.j((View) this.mTextTitle, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.j((View) this.aZm, t.d.cp_cont_i);
            com.baidu.tbadk.core.util.av.l(this.aZi, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.aZn, t.d.common_color_10014);
            com.baidu.tbadk.core.util.av.l(this.aZe, t.d.cp_bg_line_k);
            com.baidu.tbadk.core.util.av.l(this.aZs, t.d.cp_bg_line_k);
            if (this.aZm != null) {
                this.aZm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.aZf.ti();
            this.aZd.ti();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aZd != null && this.aZB != null) {
            this.aZd.h(bdUniqueId);
            this.aZB.setTag(bdUniqueId);
            this.aZC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
            MessageManager.getInstance().registerListener(this.aZC);
        }
    }

    public boolean KA() {
        return this.aPv;
    }

    public boolean isPlaying() {
        if (this.aZl == null) {
            return false;
        }
        return this.aZl.isPlaying();
    }

    public void Kz() {
        if (!this.aPv && this.aZr != null && this.aZr.bbC != null && this.aZr.bbC.rR() != null && this.aZl != null && com.baidu.tbadk.util.x.q(1, this.aMC)) {
            d(true, 2);
            this.aZl.u(this.aMC, this.aZr.bbC.rR().video_duration.intValue());
            this.aZl.start();
            if (this.aZw != null) {
                this.aZw.start();
            }
            this.aPv = true;
            com.baidu.tieba.play.h.l(this.aZr.bbC.rR().video_md5, this.aZr.bbC.getTid(), new StringBuilder(String.valueOf(this.aZr.bbC.getFid())).toString(), ImageViewerConfig.INDEX);
        }
    }

    public void stopPlay() {
        Na();
        Nz();
        d(true, 1);
        if (this.aZl != null) {
            this.aZl.wv();
            if (this.aZw != null) {
                this.aZw.stop();
            }
        }
        this.aPv = false;
    }

    public View getVideoContainer() {
        return this.aZe;
    }

    public String getPlayUrl() {
        return this.aMC;
    }

    public int getCurrentPosition() {
        if (this.aZl == null) {
            return 0;
        }
        return this.aZl.getCurrentPosition();
    }

    public void setVideoStatsData(TextureVideoView.c cVar) {
        if (this.aZl != null) {
            this.aZl.setVideoStatsData(cVar);
        }
    }
}
