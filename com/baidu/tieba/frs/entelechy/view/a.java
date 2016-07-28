package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStub;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.u;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<be> implements aw {
    private TbPageContext<?> DQ;
    private String aKF;
    private boolean aKR;
    public ViewStub aSW;
    public TbImageView aSX;
    public ClickableHeaderImageView aTU;
    public ThreadCommentAndPraiseInfoLayout aTV;
    public FrameLayout aTW;
    public UserIconLayout aTX;
    public LinearLayout aTY;
    private RelativeLayout aTZ;
    private View aUa;
    private TbImageView aUb;
    private ImageView aUc;
    private TextureVideoView aUd;
    private TextView aUe;
    private View aUf;
    private AudioAnimationView aUg;
    private ProgressBar aUh;
    private ImageView aUi;
    private View aUk;
    private int aUl;
    private int aUm;
    private Handler aUo;
    private TbImageView.a aUp;
    private Runnable aUq;
    private Runnable aUr;
    private CustomMessageListener aUs;
    private be abb;
    private MediaPlayer.OnPreparedListener adP;
    private MediaPlayer.OnErrorListener adR;
    private TextureVideoView.b adX;
    private final View.OnClickListener aeW;
    private final View.OnClickListener aez;
    public TbImageView bHg;
    public ThreadSkinView bHx;
    private GuessYourLikeHeaderView bLR;
    private View bLS;
    public RelativeLayout bLT;
    private ViewTreeObserver.OnGlobalLayoutListener bLU;
    private String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aUl = 0;
        this.aUm = 1;
        this.aKR = false;
        this.aUo = new b(this, Looper.getMainLooper());
        this.adP = new f(this);
        this.adR = new g(this);
        this.aUp = new h(this);
        this.bLU = new i(this);
        this.aUq = new j(this);
        this.aUr = new k(this);
        this.adX = new l(this);
        this.aeW = new m(this);
        this.aUs = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aez = new d(this);
        this.DQ = tbPageContext;
        View view = getView();
        this.aTZ = (RelativeLayout) view.findViewById(u.g.layout_root);
        this.bLT = (RelativeLayout) view.findViewById(u.g.video_card_content_root);
        this.bLT.setOnClickListener(this);
        this.aUa = view.findViewById(u.g.divider);
        this.aTU = (ClickableHeaderImageView) view.findViewById(u.g.image_user);
        this.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aTU.setDefaultResource(17170445);
        this.aTU.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aTU.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aTU.setRadius(com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds70));
        this.aTX = (UserIconLayout) view.findViewById(u.g.text_user_name);
        this.aTX.aeV = true;
        this.aTX.setEntelechyEnabled(true);
        this.aUh = (ProgressBar) view.findViewById(u.g.auto_video_loading_progress);
        this.aUi = (ImageView) view.findViewById(u.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(u.g.text_title);
        this.bHg = (TbImageView) view.findViewById(u.g.frs_video_item_theme_card);
        this.aTV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.text_bottom);
        this.aTV.setLocationEnabled(true);
        this.aTV.setCommentNumClickListener(this);
        this.aTW = (FrameLayout) view.findViewById(u.g.frame_video);
        this.aTW.getViewTreeObserver().addOnGlobalLayoutListener(this.bLU);
        this.aUb = (TbImageView) view.findViewById(u.g.image_video);
        this.aUb.setDefaultErrorResource(0);
        this.aUb.setDefaultBgResource(u.f.pic_bg_video_frs);
        this.aUb.setEvent(this.aUp);
        this.aUc = (ImageView) view.findViewById(u.g.image_video_play);
        this.aUg = (AudioAnimationView) view.findViewById(u.g.auto_video_play_state);
        this.aUg.setCertainColumnCount(4);
        this.aUg.setColumnColor(u.d.cp_cont_i);
        this.aTW.setOnClickListener(this);
        this.aUd = (TextureVideoView) view.findViewById(u.g.texture_video_view);
        this.aUd.setEnableRefresh(true);
        this.aUd.setOnPreparedListener(this.adP);
        this.aUd.setOnErrorListener(this.adR);
        this.aUd.setOnSurfaceDestroyedListener(this.adX);
        this.aUk = view.findViewById(u.g.auto_video_black_mask);
        this.aUe = (TextView) view.findViewById(u.g.auto_video_error_tips);
        this.aUf = view.findViewById(u.g.auto_video_error_background);
        this.aTY = (LinearLayout) view.findViewById(u.g.video_card_content_layout);
        this.bHx = (ThreadSkinView) view.findViewById(u.g.frs_thread_skin);
        this.bLR = (GuessYourLikeHeaderView) view.findViewById(u.g.guess_your_like_header);
        this.bLS = view.findViewById(u.g.guess_your_like_bottom_line);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aTZ || view == this.aTV.getCommentNumView() || view == this.bLT) {
            U(this.aTZ);
        } else if (view == this.aTW) {
            V(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aTV != null) {
            this.aTV.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (this.abb != null) {
            if (this.abb.rp()) {
                TiebaStatic.log(new ay("c10242").ab("fid", String.valueOf(this.abb.getFid())).s("obj_type", 2));
            } else {
                ay ayVar = new ay("c11100");
                ayVar.ab("tid", this.abb.getId());
                ayVar.ab("fid", new StringBuilder(String.valueOf(this.abb.getFid())).toString());
                TiebaStatic.log(ayVar);
            }
            if (this.abb.getAuthor() != null && this.abb.getAuthor().getGodUserData() != null && this.abb.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ay("c10806").s("obj_locate", 3).ab("tid", this.abb.getId()));
            }
        }
        if (KN() != null) {
            KN().a(view, this.abb);
        }
        if (this.abb != null) {
            at.hb(this.abb.getId());
            com.baidu.tbadk.util.s.gv(this.abb.getId());
            if (this.abb.qQ() > 0 && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.DQ.getPageActivity()).createHistoryCfg(this.abb.getTid(), String.valueOf(this.abb.qQ()), false, true, at.La());
                createHistoryCfg.setVideo_source(this.abb.rp() ? "floor5" : "frs");
                this.DQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.DQ.getPageActivity()).createFromThreadCfg(this.abb, this.mForumName, at.La(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.abb.rp() ? "floor5" : "frs");
            this.DQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void V(View view) {
        if (KN() != null) {
            KN().a(view, this.abb);
        }
        if (this.abb != null && this.abb != null && this.abb.qM() != null) {
            if (!com.baidu.adp.lib.util.i.fq()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(u.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.DQ.getPageActivity()).createNormalCfg(String.valueOf(this.abb.getFid()), this.abb.getTid(), this.abb.rp() ? "floor5" : "frs")));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_auto_video_view;
    }

    public void i(be beVar) {
        this.abb = beVar;
        KW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        this.aUo.removeMessages(202);
        if (this.aUd.getCurrentPosition() > 0) {
            e(true, 3);
            this.aUo.sendEmptyMessageDelayed(203, 1000L);
            return;
        }
        this.aUo.sendEmptyMessageDelayed(202, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aUo.removeMessages(203);
        int currentPosition = this.aUd.getCurrentPosition();
        if (currentPosition != this.aUl) {
            this.aUl = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aUo.sendEmptyMessageDelayed(203, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.aUc != null && this.aUb != null && this.aUk != null && this.aUg != null && this.aUh != null && this.aUi != null && this.aUf != null && this.aUe != null) {
            if (z || this.aUm != i) {
                this.aUm = i;
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUr);
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUq);
                if (i == 2) {
                    this.aUc.setVisibility(8);
                    this.aUb.setVisibility(0);
                    this.aUk.setVisibility(0);
                    this.aUh.setVisibility(0);
                    this.aUi.setVisibility(0);
                    this.aUf.setVisibility(8);
                    this.aUe.setVisibility(8);
                    this.aUg.setVisibility(8);
                    this.aUg.bmz();
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.aUr, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.aUc.setVisibility(8);
                    this.aUb.setVisibility(8);
                    this.aUk.setVisibility(8);
                    this.aUh.setVisibility(8);
                    this.aUi.setVisibility(8);
                    this.aUf.setVisibility(8);
                    this.aUe.setVisibility(8);
                    this.aUg.setVisibility(0);
                    this.aUg.start();
                } else if (i == 4) {
                    this.aUc.setVisibility(8);
                    this.aUb.setVisibility(8);
                    this.aUk.setVisibility(8);
                    this.aUh.setVisibility(8);
                    this.aUi.setVisibility(8);
                    this.aUf.setVisibility(0);
                    this.aUe.setVisibility(0);
                    this.aUg.setVisibility(8);
                    this.aUg.bmz();
                    com.baidu.adp.lib.h.h.dL().postDelayed(this.aUq, 2000L);
                } else {
                    this.aUc.setVisibility(0);
                    this.aUb.setVisibility(0);
                    this.aUk.setVisibility(0);
                    this.aUh.setVisibility(8);
                    this.aUi.setVisibility(8);
                    this.aUf.setVisibility(8);
                    this.aUe.setVisibility(8);
                    this.aUg.setVisibility(8);
                    this.aUg.bmz();
                }
            }
        }
    }

    private void KW() {
        if (this.abb == null || this.abb == null || this.abb.getAuthor() == null) {
            this.aTZ.setVisibility(8);
            return;
        }
        this.aTZ.setVisibility(0);
        KY();
        this.aTX.setVisibility(0);
        this.aTU.setVisibility(0);
        UserTbVipInfoData qx = this.abb.qx();
        if (qx != null && qx.getvipV_url() != null) {
            if (this.aSW != null) {
                if (this.aSX == null) {
                    this.aSW.inflate();
                    this.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.aSX.setVisibility(0);
                this.aSX.c(qx.getvipV_url(), 10, false);
                this.aTU.setIsBigV(true);
            }
        } else {
            this.aTU.setIsBigV(false);
            if (this.aSX != null) {
                this.aSX.setVisibility(8);
            }
        }
        this.aTU.setData(this.abb);
        this.aTU.setAfterClickListener(this.aeW);
        this.aTX.setData(this.abb);
        this.aTX.setUserAfterClickListener(this.aeW);
        this.mTextTitle.setText(this.abb.getTitle());
        this.aTV.setData(this.abb);
        this.aTV.setStType(at.La());
        this.aTV.setForumAfterClickListener(this.aez);
        this.aTV.setCommentNumClickListener(this);
        if (at.hc(this.abb.getId())) {
            av.c(this.mTextTitle, u.d.cp_cont_d, 1);
        } else {
            av.c(this.mTextTitle, u.d.cp_cont_c, 1);
        }
        setBarNameClickEnabled(true);
        j(this.abb);
        if (this.bLR != null) {
            if ((this.abb.qT() || this.abb.qU()) && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                this.bLR.setTitleText(StringUtils.isNull(this.abb.qS()) ? getContext().getResources().getString(u.j.group_fourm_recommend_title) : this.abb.qS());
                this.bLR.show();
                this.aUa.setVisibility(8);
                if (this.bLS != null) {
                    this.bLS.setVisibility(0);
                }
                if (this.abb.aVQ) {
                    this.bLR.bmD();
                } else {
                    this.bLR.bmC();
                    if (this.abb.aVR) {
                        this.aUa.setVisibility(0);
                    }
                }
            } else {
                this.bLR.hide();
                this.aUa.setVisibility(0);
                if (this.bLS != null) {
                    this.bLS.setVisibility(8);
                }
            }
        }
        d(this.DQ, TbadkCoreApplication.m10getInst().getSkinType());
    }

    private void j(be beVar) {
        MetaData author;
        if (beVar != null && (author = beVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo qP = beVar.qP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aTU.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aTY.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bHg.setVisibility(8);
                this.bLT.setPadding(this.bLT.getPaddingLeft(), 0, this.bLT.getPaddingRight(), this.bLT.getPaddingBottom());
                if (this.bHx != null) {
                    if (qP != null) {
                        this.bHx.a(this.DQ, qP, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(beVar.getFid()), beVar.getForum_name(), beVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds16);
                    } else {
                        this.bHx.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds30);
                    }
                }
            } else {
                this.bHg.setVisibility(0);
                this.bHg.setImageBitmap(null);
                this.bHg.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bHg.setOnClickListener(new e(this, themeCard));
                this.aTY.setPadding(this.aTY.getPaddingLeft(), com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds14), this.aTY.getPaddingRight(), this.aTY.getPaddingBottom());
                this.bHx.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds40);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds30);
            }
            this.aTU.setLayoutParams(layoutParams);
            this.aTY.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX() {
        this.aUo.removeMessages(202);
        this.aUo.removeMessages(203);
    }

    private void Ky() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUq);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aUr);
    }

    private void KY() {
        Ky();
        KX();
        if (this.aUb != null && this.aTW != null && this.aUd != null) {
            if (com.baidu.tbadk.core.l.nL().nR() && this.abb != null && this.abb.qM() != null) {
                this.aUb.setDefaultBgResource(u.f.pic_bg_video_frs);
                this.aUb.c(this.abb.qM().thumbnail_url, 10, false);
                this.aTW.setVisibility(0);
                stopPlay();
                this.aKF = this.abb.qM().video_url;
                if (StringUtils.isNull(this.aKF)) {
                    e(true, 4);
                }
            } else {
                this.aTW.setVisibility(8);
            }
            this.aTW.setClickable(true);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.l(this.aTZ, u.d.cp_bg_line_d);
            av.k(this.bLT, u.f.addresslist_item_bg);
            av.c(this.aUc, u.f.btn_icon_play_video_n);
            av.j((View) this.mTextTitle, u.d.cp_cont_c);
            av.j((View) this.aUe, u.d.cp_cont_i);
            if (this.abb != null && this.abb.aVQ) {
                av.l(this.aUa, u.d.cp_bg_line_c);
            } else {
                av.l(this.aUa, u.d.cp_bg_line_b);
            }
            av.l(this.aUf, u.d.common_color_10014);
            av.l(this.aTW, u.d.cp_bg_line_k);
            av.l(this.aUk, u.d.cp_bg_line_k);
            if (this.aUe != null) {
                this.aUe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(u.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bLR != null) {
                this.bLR.sd();
            }
            av.l(this.bLS, u.d.cp_bg_line_c);
            this.aTX.sd();
            this.aTV.sd();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTV != null && this.aUs != null) {
            this.aTV.h(bdUniqueId);
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aw
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean IA() {
        return this.aKR;
    }

    public boolean isPlaying() {
        if (this.aUd == null) {
            return false;
        }
        return this.aUd.isPlaying();
    }

    public void Iz() {
        if (!this.aKR && this.abb != null && this.abb.qM() != null && this.aUd != null && com.baidu.tbadk.util.x.eX(2)) {
            e(true, 2);
            this.aUd.u(this.aKF, this.abb.qM().video_duration.intValue());
            this.aUd.start();
            this.aKR = true;
            com.baidu.tieba.play.e.k(this.abb.qM().video_md5, this.abb.getTid(), new StringBuilder(String.valueOf(this.abb.getFid())).toString(), this.abb.rp() ? "floor5" : "frs");
        }
    }

    public void stopPlay() {
        Ky();
        KX();
        e(true, 1);
        if (this.aUd != null) {
            this.aUd.vr();
        }
        this.aKR = false;
    }

    public View getVideoContainer() {
        return this.aTW;
    }

    public String getPlayUrl() {
        return this.aKF;
    }

    public int getCurrentPosition() {
        if (this.aUd == null) {
            return 0;
        }
        return this.aUd.getCurrentPosition();
    }

    public void setVideoStatsData(TextureVideoView.c cVar) {
        if (this.aUd != null) {
            this.aUd.setVideoStatsData(cVar);
        }
    }
}
