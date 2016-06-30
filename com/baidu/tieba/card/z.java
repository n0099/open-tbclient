package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class z extends a<com.baidu.tieba.card.a.o> {
    private TbPageContext<?> Dp;
    private String aJM;
    private boolean aJY;
    public ClickableHeaderImageView aSY;
    public ThreadCommentAndPraiseInfoLayout aSZ;
    public FrameLayout aTa;
    public UserIconLayout aTb;
    protected LinearLayout aTc;
    private RelativeLayout aTd;
    private View aTe;
    private TbImageView aTf;
    private ImageView aTg;
    private TextureVideoView aTh;
    private TextView aTi;
    private View aTj;
    private AudioAnimationView aTk;
    private ProgressBar aTl;
    private ImageView aTm;
    private com.baidu.tieba.card.a.o aTn;
    private View aTo;
    private int aTp;
    private int aTq;
    private boolean aTr;
    private Handler aTs;
    private TbImageView.a aTt;
    private Runnable aTu;
    private Runnable aTv;
    private CustomMessageListener aTw;
    private CustomMessageListener aTx;
    private final View.OnClickListener adL;
    private MediaPlayer.OnPreparedListener adf;
    private MediaPlayer.OnErrorListener adh;
    private TextureVideoView.b adn;
    private final View.OnClickListener aei;
    private int mSkinType;
    private TextView mTextTitle;

    public z(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTp = 0;
        this.aTq = 1;
        this.aJY = false;
        this.aTr = false;
        this.aTs = new aa(this, Looper.getMainLooper());
        this.adf = new ad(this);
        this.adh = new ae(this);
        this.aTt = new af(this);
        this.aTu = new ag(this);
        this.aTv = new ah(this);
        this.adn = new ai(this);
        this.aei = new aj(this);
        this.aTw = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aTx = new ab(this, CmdConfigCustom.CMD_CURRENT_PAGE_FINISH_REFRESH);
        this.adL = new ac(this);
        this.Dp = tbPageContext;
        View view = getView();
        this.aTd = (RelativeLayout) view.findViewById(u.g.layout_root);
        this.aTe = view.findViewById(u.g.divider);
        this.aSY = (ClickableHeaderImageView) view.findViewById(u.g.image_user);
        this.aSY.setDefaultResource(17170445);
        this.aSY.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aSY.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aSY.setRadius(com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds70));
        this.aTb = (UserIconLayout) view.findViewById(u.g.text_user_name);
        this.aTl = (ProgressBar) view.findViewById(u.g.auto_video_loading_progress);
        this.aTm = (ImageView) view.findViewById(u.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(u.g.text_title);
        this.aSZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.text_bottom);
        this.aTa = (FrameLayout) view.findViewById(u.g.frame_video);
        this.aTf = (TbImageView) view.findViewById(u.g.image_video);
        this.aTf.setDefaultErrorResource(0);
        this.aTf.setDefaultBgResource(u.f.pic_bg_video_frs);
        this.aTf.setEvent(this.aTt);
        this.aTg = (ImageView) view.findViewById(u.g.image_video_play);
        this.aTk = (AudioAnimationView) view.findViewById(u.g.auto_video_play_state);
        this.aTk.setCertainColumnCount(4);
        this.aTk.setColumnColor(u.d.cp_cont_i);
        this.aTd.setOnClickListener(this);
        this.aTa.setOnClickListener(this);
        this.aTh = (TextureVideoView) view.findViewById(u.g.texture_video_view);
        this.aTh.setEnableRefresh(true);
        this.aTh.setOnPreparedListener(this.adf);
        this.aTh.setOnErrorListener(this.adh);
        this.aTh.setOnSurfaceDestroyedListener(this.adn);
        this.aTo = view.findViewById(u.g.auto_video_black_mask);
        this.aTi = (TextView) view.findViewById(u.g.auto_video_error_tips);
        this.aTj = view.findViewById(u.g.auto_video_error_background);
        this.aTc = (LinearLayout) view.findViewById(u.g.video_card_content_layout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aTd) {
            U(view);
        } else if (view == this.aTa) {
            V(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aSZ != null) {
            this.aSZ.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (KO() != null) {
            KO().a(view, this.aTn);
        }
        if (this.aTn != null && this.aTn.aVc != null) {
            if (!KU()) {
                at.hb(this.aTn.aVc.getId());
            }
            this.Dp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Dp.getPageActivity()).createFromThreadCfg(this.aTn.aVc, null, at.Lb(), 18003, true, false, false).addLocateParam(this.aTn.Li())));
        }
    }

    private boolean KU() {
        return this.aTn.aVu && !this.aTn.aVG;
    }

    private void V(View view) {
        if (this.aTn != null && this.aTn.aVc != null && this.aTn.aVc.qW() != null) {
            bx<com.baidu.tieba.card.a.o> KO = KO();
            if (KO != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                KO.a(view, this.aTn);
            }
            if (!com.baidu.adp.lib.util.i.fr()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(u.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Dp.getPageActivity()).createNormalCfg(String.valueOf(this.aTn.aVc.getFid()), this.aTn.aVc.getTid(), "index")));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_auto_video_view;
    }

    public void a(com.baidu.tieba.card.a.o oVar) {
        this.aTn = oVar;
        KX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        this.aTs.removeMessages(202);
        if (this.aTh.getCurrentPosition() > 0) {
            d(true, 3);
            this.aTs.sendEmptyMessageDelayed(203, 1000L);
            return;
        }
        this.aTs.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTs.removeMessages(203);
        int currentPosition = this.aTh.getCurrentPosition();
        if (currentPosition != this.aTp) {
            this.aTp = currentPosition;
            d(false, 3);
        } else {
            d(false, 2);
        }
        this.aTs.sendEmptyMessageDelayed(203, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i) {
        if (this.aTg != null && this.aTf != null && this.aTo != null && this.aTk != null && this.aTl != null && this.aTm != null && this.aTj != null && this.aTi != null) {
            if (z || this.aTq != i) {
                this.aTq = i;
                com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aTv);
                com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aTu);
                if (i == 2) {
                    this.aTg.setVisibility(8);
                    this.aTf.setVisibility(0);
                    this.aTo.setVisibility(0);
                    this.aTl.setVisibility(0);
                    this.aTm.setVisibility(0);
                    this.aTj.setVisibility(8);
                    this.aTi.setVisibility(8);
                    this.aTk.setVisibility(8);
                    this.aTk.bjm();
                    com.baidu.adp.lib.h.h.dM().postDelayed(this.aTv, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.aTg.setVisibility(8);
                    this.aTf.setVisibility(8);
                    this.aTo.setVisibility(8);
                    this.aTl.setVisibility(8);
                    this.aTm.setVisibility(8);
                    this.aTj.setVisibility(8);
                    this.aTi.setVisibility(8);
                    this.aTk.setVisibility(0);
                    this.aTk.start();
                } else if (i == 4) {
                    this.aTg.setVisibility(8);
                    this.aTf.setVisibility(8);
                    this.aTo.setVisibility(8);
                    this.aTl.setVisibility(8);
                    this.aTm.setVisibility(8);
                    this.aTj.setVisibility(0);
                    this.aTi.setVisibility(0);
                    this.aTk.setVisibility(8);
                    this.aTk.bjm();
                    com.baidu.adp.lib.h.h.dM().postDelayed(this.aTu, 2000L);
                } else {
                    this.aTg.setVisibility(0);
                    this.aTf.setVisibility(0);
                    this.aTo.setVisibility(0);
                    this.aTl.setVisibility(8);
                    this.aTm.setVisibility(8);
                    this.aTj.setVisibility(8);
                    this.aTi.setVisibility(8);
                    this.aTk.setVisibility(8);
                    this.aTk.bjm();
                }
            }
        }
    }

    private void KX() {
        if (this.aTn == null || this.aTn.aVc == null || this.aTn.aVc.getAuthor() == null) {
            this.aTd.setVisibility(8);
            return;
        }
        this.aTd.setVisibility(0);
        KZ();
        if (this.aTn.aVu) {
            this.aSY.setVisibility(8);
            this.aTb.setVisibility(8);
        } else {
            this.aTb.setVisibility(0);
            this.aSY.setVisibility(0);
            this.aSY.setData(this.aTn.aVc);
            this.aSY.setAfterClickListener(this.aei);
        }
        this.aTb.setData(this.aTn.aVc);
        this.aTb.setUserAfterClickListener(this.aei);
        this.mTextTitle.setText(this.aTn.aVc.getTitle());
        this.aSZ.setData(this.aTn.aVc);
        this.aSZ.setStType(at.Lb());
        this.aSZ.setYuelaouLocate("feed#" + this.aTn.Lh());
        this.aSZ.setForumAfterClickListener(this.adL);
        d(this.Dp, TbadkCoreApplication.m9getInst().getSkinType());
        if (at.hc(this.aTn.aVc.getId())) {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, u.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.av.c(this.mTextTitle, u.d.cp_cont_c, 1);
        }
        if (this.aTn.aVG) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
    }

    private void KY() {
        this.aTs.removeMessages(202);
        this.aTs.removeMessages(203);
    }

    private void Kz() {
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aTu);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aTv);
    }

    private void KZ() {
        Kz();
        KY();
        if (this.aTf != null && this.aTa != null && this.aTh != null) {
            if (com.baidu.tbadk.core.l.nW().oc() && this.aTn != null && this.aTn.aVc != null && this.aTn.aVc.qW() != null) {
                this.aTf.setDefaultBgResource(u.f.pic_bg_video_frs);
                this.aTf.c(this.aTn.aVc.qW().thumbnail_url, 10, false);
                this.aTa.setVisibility(0);
                stopPlay();
                this.aJM = this.aTn.aVc.qW().video_url;
                if (StringUtils.isNull(this.aTn.aVc.qW().video_url)) {
                    d(true, 4);
                }
            } else {
                this.aTa.setVisibility(8);
            }
            this.aTa.setClickable(true);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.aTd, u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.c(this.aTg, u.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.av.j((View) this.mTextTitle, u.d.cp_cont_c);
            com.baidu.tbadk.core.util.av.j((View) this.aTi, u.d.cp_cont_i);
            com.baidu.tbadk.core.util.av.l(this.aTe, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.aTj, u.d.common_color_10014);
            com.baidu.tbadk.core.util.av.l(this.aTa, u.d.cp_bg_line_k);
            com.baidu.tbadk.core.util.av.l(this.aTo, u.d.cp_bg_line_k);
            if (this.aTi != null) {
                this.aTi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.aTb.se();
            this.aSZ.se();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSZ != null && this.aTw != null) {
            this.aSZ.h(bdUniqueId);
            this.aTw.setTag(bdUniqueId);
            this.aTx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
            MessageManager.getInstance().registerListener(this.aTx);
        }
    }

    public boolean IB() {
        return this.aJY;
    }

    public boolean isPlaying() {
        if (this.aTh == null) {
            return false;
        }
        return this.aTh.isPlaying();
    }

    public void IA() {
        if (!this.aJY && this.aTn != null && this.aTn.aVc != null && this.aTn.aVc.qW() != null && this.aTh != null && com.baidu.tbadk.util.w.eX(1)) {
            d(true, 2);
            this.aTh.u(this.aJM, this.aTn.aVc.qW().video_duration.intValue());
            this.aTh.start();
            this.aJY = true;
            com.baidu.tieba.play.e.k(this.aTn.aVc.qW().video_md5, this.aTn.aVc.getTid(), new StringBuilder(String.valueOf(this.aTn.aVc.getFid())).toString(), "index");
        }
    }

    public void stopPlay() {
        Kz();
        KY();
        d(true, 1);
        if (this.aTh != null) {
            this.aTh.vr();
        }
        this.aJY = false;
    }

    public View getVideoContainer() {
        return this.aTa;
    }

    public String getPlayUrl() {
        return this.aJM;
    }

    public int getCurrentPosition() {
        if (this.aTh == null) {
            return 0;
        }
        return this.aTh.getCurrentPosition();
    }
}
