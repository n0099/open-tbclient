package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.u;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<az> implements au {
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
    private View aTo;
    private int aTp;
    private int aTq;
    private Handler aTs;
    private TbImageView.a aTt;
    private Runnable aTu;
    private Runnable aTv;
    private CustomMessageListener aTw;
    private az aas;
    private final View.OnClickListener adL;
    private MediaPlayer.OnPreparedListener adf;
    private MediaPlayer.OnErrorListener adh;
    private TextureVideoView.b adn;
    private final View.OnClickListener aei;
    public ThreadSkinView bGc;
    private ViewTreeObserver.OnGlobalLayoutListener bKm;
    private String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTp = 0;
        this.aTq = 1;
        this.aJY = false;
        this.aTs = new b(this, Looper.getMainLooper());
        this.adf = new e(this);
        this.adh = new f(this);
        this.aTt = new g(this);
        this.bKm = new h(this);
        this.aTu = new i(this);
        this.aTv = new j(this);
        this.adn = new k(this);
        this.aei = new l(this);
        this.aTw = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.adL = new d(this);
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
        this.aTb.aeh = true;
        this.aTb.setEntelechyEnabled(true);
        this.aTl = (ProgressBar) view.findViewById(u.g.auto_video_loading_progress);
        this.aTm = (ImageView) view.findViewById(u.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(u.g.text_title);
        this.aSZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.text_bottom);
        this.aSZ.setLocationEnabled(true);
        this.aSZ.setCommentNumClickListener(this);
        this.aTa = (FrameLayout) view.findViewById(u.g.frame_video);
        this.aTa.getViewTreeObserver().addOnGlobalLayoutListener(this.bKm);
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
        this.bGc = (ThreadSkinView) view.findViewById(u.g.frs_thread_skin);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aTd || view == this.aSZ.getCommentNumView()) {
            U(this.aTd);
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
        if (this.aas != null) {
            if (this.aas.rq()) {
                TiebaStatic.log(new ay("c10242").ab("fid", String.valueOf(this.aas.getFid())).s("obj_type", 2));
            } else {
                ay ayVar = new ay("c11100");
                ayVar.ab("tid", this.aas.getId());
                ayVar.ab("fid", new StringBuilder(String.valueOf(this.aas.getFid())).toString());
                TiebaStatic.log(ayVar);
            }
            if (this.aas.getAuthor() != null && this.aas.getAuthor().getGodUserData() != null && this.aas.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ay("c10806").s("obj_locate", 3).ab("tid", this.aas.getId()));
            }
        }
        if (KO() != null) {
            KO().a(view, this.aas);
        }
        if (this.aas != null) {
            at.hb(this.aas.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.Dp.getPageActivity()).createFromThreadCfg(this.aas, this.mForumName, at.Lb(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aas.rq() ? "floor5" : "frs");
            this.Dp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void V(View view) {
        if (this.aas != null && this.aas != null && this.aas.qW() != null) {
            if (!com.baidu.adp.lib.util.i.fr()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(u.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Dp.getPageActivity()).createNormalCfg(String.valueOf(this.aas.getFid()), this.aas.getTid(), this.aas.rq() ? "floor5" : "frs")));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_auto_video_view;
    }

    public void h(az azVar) {
        this.aas = azVar;
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
        if (this.aas == null || this.aas == null || this.aas.getAuthor() == null) {
            this.aTd.setVisibility(8);
            return;
        }
        this.aTd.setVisibility(0);
        KZ();
        this.aTb.setVisibility(0);
        this.aSY.setVisibility(0);
        this.aSY.setData(this.aas);
        this.aSY.setAfterClickListener(this.aei);
        this.aTb.setData(this.aas);
        this.aTb.setUserAfterClickListener(this.aei);
        this.mTextTitle.setText(this.aas.getTitle());
        this.aSZ.setData(this.aas);
        this.aSZ.setStType(at.Lb());
        this.aSZ.setForumAfterClickListener(this.adL);
        this.aSZ.setCommentNumClickListener(this);
        if (at.hc(this.aas.getId())) {
            av.c(this.mTextTitle, u.d.cp_cont_d, 1);
        } else {
            av.c(this.mTextTitle, u.d.cp_cont_c, 1);
        }
        setBarNameClickEnabled(true);
        SkinInfo qZ = this.aas.qZ();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aSY.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aTc.getLayoutParams();
        if (qZ != null) {
            this.bGc.a(this.Dp, qZ, com.baidu.tieba.tbadkCore.d.a.a("FRS", "c0131", String.valueOf(this.aas.getFid()), this.aas.getForum_name(), this.aas.getTid(), null));
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds16);
            layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds16);
        } else {
            this.bGc.setVisibility(8);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds32);
            layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds32);
        }
        this.aSY.setLayoutParams(layoutParams);
        this.aTc.setLayoutParams(layoutParams2);
        d(this.Dp, TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KY() {
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
            if (com.baidu.tbadk.core.l.nW().oc() && this.aas != null && this.aas.qW() != null) {
                this.aTf.setDefaultBgResource(u.f.pic_bg_video_frs);
                this.aTf.c(this.aas.qW().thumbnail_url, 10, false);
                this.aTa.setVisibility(0);
                stopPlay();
                this.aJM = this.aas.qW().video_url;
                if (StringUtils.isNull(this.aJM)) {
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
            av.k(this.aTd, u.f.addresslist_item_bg);
            av.c(this.aTg, u.f.btn_icon_play_video_n);
            av.j((View) this.mTextTitle, u.d.cp_cont_c);
            av.j((View) this.aTi, u.d.cp_cont_i);
            av.l(this.aTe, u.d.cp_bg_line_c);
            av.l(this.aTj, u.d.common_color_10014);
            av.l(this.aTa, u.d.cp_bg_line_k);
            av.l(this.aTo, u.d.cp_bg_line_k);
            if (this.aTi != null) {
                this.aTi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.au
    public void setForumName(String str) {
        this.mForumName = str;
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
        if (!this.aJY && this.aas != null && this.aas.qW() != null && this.aTh != null && com.baidu.tbadk.util.w.eX(2)) {
            d(true, 2);
            this.aTh.u(this.aJM, this.aas.qW().video_duration.intValue());
            this.aTh.start();
            this.aJY = true;
            com.baidu.tieba.play.e.k(this.aas.qW().video_md5, this.aas.getTid(), new StringBuilder(String.valueOf(this.aas.getFid())).toString(), this.aas.rq() ? "floor5" : "frs");
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
