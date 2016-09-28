package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.h;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bi> implements az {
    private TbPageContext<?> Gd;
    private boolean aLX;
    private com.baidu.tieba.play.h aLY;
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
    public LinearLayout aZA;
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
    private View aZN;
    private int aZO;
    private int aZP;
    private Handler aZR;
    private Runnable aZS;
    private CustomMessageListener aZT;
    private Animation.AnimationListener aZV;
    public ClickableHeaderImageView aZw;
    public ThreadCommentAndPraiseInfoLayout aZx;
    public FrameLayout aZy;
    public UserIconLayout aZz;
    private bi adW;
    private final View.OnClickListener ahd;
    private final View.OnClickListener ahz;
    public TbImageView bSf;
    public ThreadSkinView bSw;
    public HeadPendantClickableView bXb;
    private GuessYourLikeHeaderView bXc;
    private View bXd;
    public RelativeLayout bXe;
    private com.baidu.tieba.play.s bXf;
    private ViewTreeObserver.OnGlobalLayoutListener bXg;
    private String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aZO = 0;
        this.aZP = 1;
        this.aLX = false;
        this.aZR = new b(this, Looper.getMainLooper());
        this.aLr = new h(this);
        this.aLs = new i(this);
        this.aMQ = new j(this);
        this.bXg = new k(this);
        this.aMT = new l(this);
        this.aZS = new m(this);
        this.aMS = new n(this);
        this.ahz = new o(this);
        this.aZT = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahd = new d(this);
        this.aMa = new e(this);
        this.aZV = new f(this);
        this.Gd = tbPageContext;
        View view = getView();
        this.aZC = (RelativeLayout) view.findViewById(r.g.layout_root);
        this.bXe = (RelativeLayout) view.findViewById(r.g.video_card_content_root);
        this.bXe.setOnClickListener(this);
        this.aZD = view.findViewById(r.g.divider);
        this.aZw = (ClickableHeaderImageView) view.findViewById(r.g.image_user);
        this.aZw.setDefaultResource(17170445);
        this.aZw.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.aZw.setDefaultBgResource(r.d.cp_bg_line_e);
        this.aZw.setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds70));
        this.bXb = (HeadPendantClickableView) view.findViewById(r.g.pendant_image_user);
        this.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        if (this.bXb.getHeadView() != null) {
            this.bXb.getHeadView().setDefaultResource(17170445);
            this.bXb.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bXb.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bXb.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds70));
            this.bXb.getHeadView().setIsRound(true);
            this.bXb.getHeadView().setDrawBorder(false);
        }
        this.bXb.wk();
        if (this.bXb.getPendantView() != null) {
            this.bXb.getPendantView().setIsRound(true);
            this.bXb.getPendantView().setDrawBorder(false);
        }
        this.aZz = (UserIconLayout) view.findViewById(r.g.text_user_name);
        this.aZz.ahy = true;
        this.aZz.setEntelechyEnabled(true);
        this.aZK = (ProgressBar) view.findViewById(r.g.auto_video_loading_progress);
        this.aZL = (ImageView) view.findViewById(r.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.g.text_title);
        this.bSf = (TbImageView) view.findViewById(r.g.frs_video_item_theme_card);
        this.aZx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.text_bottom);
        this.aZx.setLocationEnabled(true);
        this.aZx.setCommentNumClickListener(this);
        this.aZy = (FrameLayout) view.findViewById(r.g.frame_video);
        this.aZy.getViewTreeObserver().addOnGlobalLayoutListener(this.bXg);
        this.aZE = (TbImageView) view.findViewById(r.g.image_video);
        this.aZE.setDefaultErrorResource(0);
        this.aZE.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.aZE.setEvent(this.aMQ);
        this.aZF = (ImageView) view.findViewById(r.g.image_video_play);
        this.aZJ = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.aZJ.setCertainColumnCount(4);
        this.aZJ.setColumnColor(r.d.cp_cont_i);
        this.aZy.setOnClickListener(this);
        this.aZG = (QuickVideoView) view.findViewById(r.g.texture_video_view);
        this.bXf = new com.baidu.tieba.play.s(this.Gd.getPageActivity());
        this.aZG.setBusiness(this.bXf);
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
        this.bSw = (ThreadSkinView) view.findViewById(r.g.frs_thread_skin);
        this.bXc = (GuessYourLikeHeaderView) view.findViewById(r.g.guess_your_like_header);
        this.bXd = view.findViewById(r.g.guess_your_like_bottom_line);
        this.aOU = AnimationUtils.loadAnimation(this.Gd.getPageActivity(), r.a.fade_out_video_cover);
        this.aOU.setAnimationListener(this.aZV);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZC || view == this.aZx.getCommentNumView() || view == this.bXe) {
            T(this.aZC);
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
        if (this.adW != null) {
            if (this.adW.sG()) {
                TiebaStatic.log(new ax("c10242").ab("fid", String.valueOf(this.adW.getFid())).s("obj_type", 2));
            } else {
                ax axVar = new ax("c11100");
                axVar.ab("tid", this.adW.getId());
                axVar.ab("fid", new StringBuilder(String.valueOf(this.adW.getFid())).toString());
                TiebaStatic.log(axVar);
            }
            if (this.adW.getAuthor() != null && this.adW.getAuthor().getGodUserData() != null && this.adW.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new ax("c10806").s("obj_locate", 3).ab("tid", this.adW.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.adW);
        }
        if (this.adW != null) {
            com.baidu.tieba.card.an.hN(this.adW.getId());
            com.baidu.tbadk.util.s.gC(this.adW.getId());
            if (this.adW.sh() > 0 && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.Gd.getPageActivity()).createHistoryCfg(this.adW.getTid(), String.valueOf(this.adW.sh()), false, true, com.baidu.tieba.card.an.Od());
                createHistoryCfg.setVideo_source(this.adW.sG() ? "floor5" : "frs");
                this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.Gd.getPageActivity()).createFromThreadCfg(this.adW, this.mForumName, com.baidu.tieba.card.an.Od(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.adW.sG() ? "floor5" : "frs");
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void U(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.adW);
        }
        if (this.adW != null && this.adW.sd() != null) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(r.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Gd.getPageActivity()).createNormalCfg(String.valueOf(this.adW.getFid()), this.adW.getTid(), this.adW.sG() ? "floor5" : "frs")));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public void onBindDataToView(bi biVar) {
        this.adW = biVar;
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
        this.aZR.sendEmptyMessageDelayed(202, 0L);
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
        if (this.adW == null || this.adW.getAuthor() == null) {
            this.aZC.setVisibility(8);
            return;
        }
        this.aZC.setVisibility(0);
        Ob();
        this.aZz.setVisibility(0);
        if (this.adW.getAuthor() == null || this.adW.getAuthor().getPendantData() == null || StringUtils.isNull(this.adW.getAuthor().getPendantData().pO())) {
            UserTbVipInfoData rO = this.adW.rO();
            if (rO != null && rO.getvipV_url() != null) {
                if (this.aYH != null) {
                    if (this.aYI == null) {
                        this.aYH.inflate();
                        this.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.aYI.setVisibility(0);
                    this.aYI.c(rO.getvipV_url(), 10, false);
                    this.aZw.setIsBigV(true);
                }
            } else {
                this.aZw.setIsBigV(false);
                if (this.aYI != null) {
                    this.aYI.setVisibility(8);
                }
            }
            this.aZw.setVisibility(0);
            this.bXb.setVisibility(8);
            this.aZw.setData(this.adW);
            this.aZw.setAfterClickListener(this.ahz);
        } else {
            this.aZw.setIsBigV(false);
            if (this.aYI != null) {
                this.aYI.setVisibility(8);
            }
            this.aZw.setVisibility(4);
            this.bXb.setVisibility(0);
            this.bXb.setData(this.adW);
        }
        this.aZz.setData(this.adW);
        this.aZz.setUserAfterClickListener(this.ahz);
        this.adW.su();
        SpannableStringBuilder sm = this.adW.sm();
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.y(sm));
        this.mTextTitle.setText(sm);
        this.aZx.setData(this.adW);
        this.aZx.setStType(com.baidu.tieba.card.an.Od());
        this.aZx.setForumAfterClickListener(this.ahd);
        this.aZx.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.an.hO(this.adW.getId())) {
            av.c(this.mTextTitle, r.d.cp_cont_d, 1);
        } else {
            av.c(this.mTextTitle, r.d.cp_cont_c, 1);
        }
        setBarNameClickEnabled(true);
        l(this.adW);
        if (this.bXc != null) {
            if ((this.adW.sk() || this.adW.sl()) && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                this.bXc.setTitleText(StringUtils.isNull(this.adW.sj()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : this.adW.sj());
                this.bXc.show();
                this.aZD.setVisibility(8);
                if (this.bXd != null) {
                    this.bXd.setVisibility(0);
                }
                if (this.adW.bbL) {
                    this.bXc.bqS();
                } else {
                    this.bXc.bqR();
                    if (this.adW.bbM) {
                        this.aZD.setVisibility(0);
                    }
                }
            } else {
                this.bXc.hide();
                this.aZD.setVisibility(0);
                if (this.bXd != null) {
                    this.bXd.setVisibility(8);
                }
            }
        }
        onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void l(bi biVar) {
        MetaData author;
        if (biVar != null && (author = biVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sg = biVar.sg();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aZw.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aZA.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bSf.setVisibility(8);
                if (this.bSw != null) {
                    if (sg != null) {
                        this.bSw.a(this.Gd, sg, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.getForum_name(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds16);
                    } else {
                        this.bSw.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bSf.setVisibility(0);
                this.bSf.setImageBitmap(null);
                this.bSf.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bSf.setOnClickListener(new g(this, themeCard));
                this.bSw.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds30);
            }
            this.aZw.setLayoutParams(layoutParams);
            this.aZA.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
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
            if (com.baidu.tbadk.core.l.oH().oN() && this.adW != null && this.adW.sd() != null) {
                this.aZE.setDefaultBgResource(r.f.pic_bg_video_frs);
                this.aZE.c(this.adW.sd().thumbnail_url, 10, false);
                this.aZy.setVisibility(0);
                stopPlay();
                this.aNM = this.adW.sd().video_url;
                if (StringUtils.isNull(this.aNM)) {
                    e(true, 4);
                }
                if (this.bXf != null && this.bXf.bav() != null) {
                    this.bXf.bav().c(this.adW.sd());
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
            av.l(this.aZC, r.d.cp_bg_line_d);
            av.k(this.bXe, r.f.addresslist_item_bg);
            av.c(this.aZF, r.f.btn_icon_play_video_n);
            av.j((View) this.mTextTitle, r.d.cp_cont_c);
            av.j((View) this.aZH, r.d.cp_cont_i);
            if (this.adW != null && this.adW.bbL) {
                av.l(this.aZD, r.d.cp_bg_line_c);
            } else {
                av.l(this.aZD, r.d.cp_bg_line_b);
            }
            av.l(this.aZI, r.d.common_color_10014);
            av.l(this.aZy, r.d.cp_bg_line_k);
            av.l(this.aZN, r.d.cp_bg_line_k);
            if (this.aZH != null) {
                this.aZH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bXc != null) {
                this.bXc.tx();
            }
            av.l(this.bXd, r.d.cp_bg_line_c);
            this.aZz.tx();
            this.aZx.tx();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aZx != null && this.aZT != null) {
            this.aZx.h(bdUniqueId);
            this.aZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
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
        if (!this.aLX && this.adW != null && this.adW.sd() != null && this.aZG != null && com.baidu.tbadk.util.x.q(2, this.aNM)) {
            e(true, 2);
            this.aZG.setVideoPath(this.aNM);
            this.aZG.start();
            if (this.aLY != null) {
                this.aLY.start();
            }
            this.aLX = true;
            Jt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        if (this.adW != null && this.adW.sd() != null) {
            com.baidu.tieba.play.j.a(this.adW.sd().video_md5, this.adW.getTid(), new StringBuilder(String.valueOf(this.adW.getFid())).toString(), this.adW.sG() ? "floor5" : "frs", "", "", "1");
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
        if (this.bXf != null) {
            this.bXf.a(adVar);
        }
    }
}
