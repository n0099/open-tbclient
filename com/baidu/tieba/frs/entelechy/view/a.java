package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bg> implements az {
    private TbPageContext<?> Gd;
    private String aMC;
    private Animation aNL;
    private boolean aPv;
    public ViewStub aYe;
    public TbImageView aYf;
    private Runnable aZA;
    private CustomMessageListener aZB;
    private f.a aZD;
    private Animation.AnimationListener aZE;
    public ClickableHeaderImageView aZc;
    public ThreadCommentAndPraiseInfoLayout aZd;
    public FrameLayout aZe;
    public UserIconLayout aZf;
    public LinearLayout aZg;
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
    private View aZs;
    private int aZt;
    private int aZu;
    private com.baidu.tieba.play.f aZw;
    private Handler aZx;
    private TbImageView.a aZy;
    private Runnable aZz;
    private bg adL;
    private MediaPlayer.OnPreparedListener agG;
    private MediaPlayer.OnErrorListener agI;
    private TextureVideoView.b agO;
    private final View.OnClickListener ahR;
    private final View.OnClickListener ahu;
    public ThreadSkinView bSD;
    public TbImageView bSm;
    public HeadPendantClickableView bXh;
    private GuessYourLikeHeaderView bXi;
    private View bXj;
    public RelativeLayout bXk;
    private ViewTreeObserver.OnGlobalLayoutListener bXl;
    private String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aZt = 0;
        this.aZu = 1;
        this.aPv = false;
        this.aZx = new b(this, Looper.getMainLooper());
        this.agG = new h(this);
        this.agI = new i(this);
        this.aZy = new j(this);
        this.bXl = new k(this);
        this.aZz = new l(this);
        this.aZA = new m(this);
        this.agO = new n(this);
        this.ahR = new o(this);
        this.aZB = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahu = new d(this);
        this.aZD = new e(this);
        this.aZE = new f(this);
        this.Gd = tbPageContext;
        View view = getView();
        this.aZh = (RelativeLayout) view.findViewById(t.g.layout_root);
        this.bXk = (RelativeLayout) view.findViewById(t.g.video_card_content_root);
        this.bXk.setOnClickListener(this);
        this.aZi = view.findViewById(t.g.divider);
        this.aZc = (ClickableHeaderImageView) view.findViewById(t.g.image_user);
        this.aZc.setDefaultResource(17170445);
        this.aZc.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aZc.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aZc.setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds70));
        this.bXh = (HeadPendantClickableView) view.findViewById(t.g.pendant_image_user);
        this.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        if (this.bXh.getHeadView() != null) {
            this.bXh.getHeadView().setDefaultResource(17170445);
            this.bXh.getHeadView().setDefaultErrorResource(t.f.icon_default_avatar100);
            this.bXh.getHeadView().setDefaultBgResource(t.d.cp_bg_line_e);
            this.bXh.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds70));
            this.bXh.getHeadView().setIsRound(true);
            this.bXh.getHeadView().setDrawBorder(false);
        }
        this.bXh.vW();
        if (this.bXh.getPendantView() != null) {
            this.bXh.getPendantView().setIsRound(true);
            this.bXh.getPendantView().setDrawBorder(false);
        }
        this.aZf = (UserIconLayout) view.findViewById(t.g.text_user_name);
        this.aZf.ahQ = true;
        this.aZf.setEntelechyEnabled(true);
        this.aZp = (ProgressBar) view.findViewById(t.g.auto_video_loading_progress);
        this.aZq = (ImageView) view.findViewById(t.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(t.g.text_title);
        this.bSm = (TbImageView) view.findViewById(t.g.frs_video_item_theme_card);
        this.aZd = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.text_bottom);
        this.aZd.setLocationEnabled(true);
        this.aZd.setCommentNumClickListener(this);
        this.aZe = (FrameLayout) view.findViewById(t.g.frame_video);
        this.aZe.getViewTreeObserver().addOnGlobalLayoutListener(this.bXl);
        this.aZj = (TbImageView) view.findViewById(t.g.image_video);
        this.aZj.setDefaultErrorResource(0);
        this.aZj.setDefaultBgResource(t.f.pic_bg_video_frs);
        this.aZj.setEvent(this.aZy);
        this.aZk = (ImageView) view.findViewById(t.g.image_video_play);
        this.aZo = (AudioAnimationView) view.findViewById(t.g.auto_video_play_state);
        this.aZo.setCertainColumnCount(4);
        this.aZo.setColumnColor(t.d.cp_cont_i);
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
        this.bSD = (ThreadSkinView) view.findViewById(t.g.frs_thread_skin);
        this.bXi = (GuessYourLikeHeaderView) view.findViewById(t.g.guess_your_like_header);
        this.bXj = view.findViewById(t.g.guess_your_like_bottom_line);
        this.aNL = AnimationUtils.loadAnimation(this.Gd.getPageActivity(), t.a.fade_out_video_cover);
        this.aNL.setAnimationListener(this.aZE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZh || view == this.aZd.getCommentNumView() || view == this.bXk) {
            T(this.aZh);
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
        if (this.adL != null) {
            if (this.adL.su()) {
                TiebaStatic.log(new ay("c10242").ab("fid", String.valueOf(this.adL.getFid())).s("obj_type", 2));
            } else {
                ay ayVar = new ay("c11100");
                ayVar.ab("tid", this.adL.getId());
                ayVar.ab("fid", new StringBuilder(String.valueOf(this.adL.getFid())).toString());
                TiebaStatic.log(ayVar);
            }
            if (this.adL.getAuthor() != null && this.adL.getAuthor().getGodUserData() != null && this.adL.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ay("c10806").s("obj_locate", 3).ab("tid", this.adL.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.adL);
        }
        if (this.adL != null) {
            com.baidu.tieba.card.ap.hG(this.adL.getId());
            com.baidu.tbadk.util.s.gy(this.adL.getId());
            if (this.adL.rV() > 0 && com.baidu.tieba.tbadkCore.util.t.bke()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.Gd.getPageActivity()).createHistoryCfg(this.adL.getTid(), String.valueOf(this.adL.rV()), false, true, com.baidu.tieba.card.ap.ND());
                createHistoryCfg.setVideo_source(this.adL.su() ? "floor5" : "frs");
                this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.Gd.getPageActivity()).createFromThreadCfg(this.adL, this.mForumName, com.baidu.tieba.card.ap.ND(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.adL.su() ? "floor5" : "frs");
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void U(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.adL);
        }
        if (this.adL != null && this.adL != null && this.adL.rR() != null) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(t.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Gd.getPageActivity()).createNormalCfg(String.valueOf(this.adL.getFid()), this.adL.getTid(), this.adL.su() ? "floor5" : "frs")));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: i */
    public void onBindDataToView(bg bgVar) {
        this.adL = bgVar;
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
        if (this.adL == null || this.adL == null || this.adL.getAuthor() == null) {
            this.aZh.setVisibility(8);
            return;
        }
        this.aZh.setVisibility(0);
        NA();
        this.aZf.setVisibility(0);
        if (this.adL.getAuthor() == null || this.adL.getAuthor().getPendantData() == null || StringUtils.isNull(this.adL.getAuthor().getPendantData().rc())) {
            UserTbVipInfoData rC = this.adL.rC();
            if (rC != null && rC.getvipV_url() != null) {
                if (this.aYe != null) {
                    if (this.aYf == null) {
                        this.aYe.inflate();
                        this.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                    }
                    this.aYf.setVisibility(0);
                    this.aYf.c(rC.getvipV_url(), 10, false);
                    this.aZc.setIsBigV(true);
                }
            } else {
                this.aZc.setIsBigV(false);
                if (this.aYf != null) {
                    this.aYf.setVisibility(8);
                }
            }
            this.aZc.setVisibility(0);
            this.bXh.setVisibility(8);
            this.aZc.setData(this.adL);
            this.aZc.setAfterClickListener(this.ahR);
        } else {
            this.aZc.setIsBigV(false);
            if (this.aYf != null) {
                this.aYf.setVisibility(8);
            }
            this.aZc.setVisibility(4);
            this.bXh.setVisibility(0);
            this.bXh.setData(this.adL);
        }
        this.aZf.setData(this.adL);
        this.aZf.setUserAfterClickListener(this.ahR);
        this.adL.si();
        SpannableStringBuilder sa = this.adL.sa();
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.y(sa));
        this.mTextTitle.setText(sa);
        this.aZd.setData(this.adL);
        this.aZd.setStType(com.baidu.tieba.card.ap.ND());
        this.aZd.setForumAfterClickListener(this.ahu);
        this.aZd.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.ap.hH(this.adL.getId())) {
            av.c(this.mTextTitle, t.d.cp_cont_d, 1);
        } else {
            av.c(this.mTextTitle, t.d.cp_cont_c, 1);
        }
        setBarNameClickEnabled(true);
        j(this.adL);
        if (this.bXi != null) {
            if ((this.adL.rY() || this.adL.rZ()) && com.baidu.tieba.tbadkCore.util.t.bke()) {
                this.bXi.setTitleText(StringUtils.isNull(this.adL.rX()) ? getContext().getResources().getString(t.j.group_fourm_recommend_title) : this.adL.rX());
                this.bXi.show();
                this.aZi.setVisibility(8);
                if (this.bXj != null) {
                    this.bXj.setVisibility(0);
                }
                if (this.adL.bbt) {
                    this.bXi.bqo();
                } else {
                    this.bXi.bqn();
                    if (this.adL.bbu) {
                        this.aZi.setVisibility(0);
                    }
                }
            } else {
                this.bXi.hide();
                this.aZi.setVisibility(0);
                if (this.bXj != null) {
                    this.bXj.setVisibility(8);
                }
            }
        }
        onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void j(bg bgVar) {
        MetaData author;
        if (bgVar != null && (author = bgVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rU = bgVar.rU();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aZc.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aZg.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bSm.setVisibility(8);
                if (this.bSD != null) {
                    if (rU != null) {
                        this.bSD.a(this.Gd, rU, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bgVar.getFid()), bgVar.getForum_name(), bgVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds16);
                    } else {
                        this.bSD.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds30);
                    }
                }
            } else {
                this.bSm.setVisibility(0);
                this.bSm.setImageBitmap(null);
                this.bSm.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bSm.setOnClickListener(new g(this, themeCard));
                this.bSD.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds30);
            }
            this.aZc.setLayoutParams(layoutParams);
            this.aZg.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nz() {
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
            if (com.baidu.tbadk.core.l.oG().oM() && this.adL != null && this.adL.rR() != null) {
                this.aZj.setDefaultBgResource(t.f.pic_bg_video_frs);
                this.aZj.c(this.adL.rR().thumbnail_url, 10, false);
                this.aZe.setVisibility(0);
                stopPlay();
                this.aMC = this.adL.rR().video_url;
                if (StringUtils.isNull(this.aMC)) {
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
            av.l(this.aZh, t.d.cp_bg_line_d);
            av.k(this.bXk, t.f.addresslist_item_bg);
            av.c(this.aZk, t.f.btn_icon_play_video_n);
            av.j((View) this.mTextTitle, t.d.cp_cont_c);
            av.j((View) this.aZm, t.d.cp_cont_i);
            if (this.adL != null && this.adL.bbt) {
                av.l(this.aZi, t.d.cp_bg_line_c);
            } else {
                av.l(this.aZi, t.d.cp_bg_line_b);
            }
            av.l(this.aZn, t.d.common_color_10014);
            av.l(this.aZe, t.d.cp_bg_line_k);
            av.l(this.aZs, t.d.cp_bg_line_k);
            if (this.aZm != null) {
                this.aZm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(t.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bXi != null) {
                this.bXi.ti();
            }
            av.l(this.bXj, t.d.cp_bg_line_c);
            this.aZf.ti();
            this.aZd.ti();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aZd != null && this.aZB != null) {
            this.aZd.h(bdUniqueId);
            this.aZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
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
        if (!this.aPv && this.adL != null && this.adL.rR() != null && this.aZl != null && com.baidu.tbadk.util.x.q(2, this.aMC)) {
            d(true, 2);
            this.aZl.u(this.aMC, this.adL.rR().video_duration.intValue());
            this.aZl.start();
            if (this.aZw != null) {
                this.aZw.start();
            }
            this.aPv = true;
            com.baidu.tieba.play.h.l(this.adL.rR().video_md5, this.adL.getTid(), new StringBuilder(String.valueOf(this.adL.getFid())).toString(), this.adL.su() ? "floor5" : "frs");
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
