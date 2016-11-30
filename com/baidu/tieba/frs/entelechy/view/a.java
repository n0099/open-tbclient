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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.w;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bk> implements ba {
    private TbPageContext<?> Gf;
    private t.d aMo;
    private t.b aMp;
    private boolean aNR;
    private com.baidu.tieba.play.w aNS;
    private w.a aNV;
    private com.baidu.tieba.play.ah aOP;
    private int aOU;
    private TbImageView.a aOV;
    private QuickVideoView.b aOX;
    private Runnable aOY;
    private String aPS;
    private Handler aPa;
    private Animation aRa;
    private bk aeu;
    private final View.OnClickListener ahD;
    private final View.OnClickListener ahZ;
    public ThreadSkinView bUJ;
    public TbImageView bUs;
    public ViewStub bbQ;
    public TbImageView bbR;
    public ClickableHeaderImageView bcF;
    public ThreadCommentAndPraiseInfoLayout bcG;
    public View bcH;
    public FrameLayout bcI;
    public UserIconLayout bcJ;
    public LinearLayout bcK;
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
    private View bcX;
    private int bcY;
    private Runnable bda;
    private CustomMessageListener bdb;
    private Animation.AnimationListener bdd;
    public HeadPendantClickableView cas;
    private GuessYourLikeHeaderView cat;
    private View cau;
    public RelativeLayout cav;
    private ViewTreeObserver.OnGlobalLayoutListener caw;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aOU = 0;
        this.bcY = 1;
        this.aNR = false;
        this.aPa = new b(this, Looper.getMainLooper());
        this.aMo = new h(this);
        this.aMp = new i(this);
        this.aOV = new j(this);
        this.caw = new k(this);
        this.aOY = new l(this);
        this.bda = new m(this);
        this.aOX = new n(this);
        this.ahZ = new o(this);
        this.bdb = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahD = new d(this);
        this.aNV = new e(this);
        this.bdd = new f(this);
        this.Gf = tbPageContext;
        View view = getView();
        this.bcM = (RelativeLayout) view.findViewById(r.g.layout_root);
        this.cav = (RelativeLayout) view.findViewById(r.g.video_card_content_root);
        this.cav.setOnClickListener(this);
        this.bcN = view.findViewById(r.g.divider);
        this.bcF = (ClickableHeaderImageView) view.findViewById(r.g.image_user);
        this.bcF.setDefaultResource(17170445);
        this.bcF.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bcF.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bcF.setRadius(com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds70));
        this.cas = (HeadPendantClickableView) view.findViewById(r.g.pendant_image_user);
        this.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        if (this.cas.getHeadView() != null) {
            this.cas.getHeadView().setDefaultResource(17170445);
            this.cas.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.cas.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.cas.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds70));
            this.cas.getHeadView().setIsRound(true);
            this.cas.getHeadView().setDrawBorder(false);
        }
        this.cas.wo();
        if (this.cas.getPendantView() != null) {
            this.cas.getPendantView().setIsRound(true);
            this.cas.getPendantView().setDrawBorder(false);
        }
        this.bcJ = (UserIconLayout) view.findViewById(r.g.text_user_name);
        this.bcJ.ahY = true;
        this.bcJ.setEntelechyEnabled(true);
        this.bcU = (ProgressBar) view.findViewById(r.g.auto_video_loading_progress);
        this.bcV = (ImageView) view.findViewById(r.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.g.text_title);
        this.bUs = (TbImageView) view.findViewById(r.g.frs_video_item_theme_card);
        this.bcG = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.text_bottom);
        this.bcH = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bcG.setLocationEnabled(true);
        this.bcG.setCommentNumClickListener(this);
        this.bcI = (FrameLayout) view.findViewById(r.g.frame_video);
        this.bcI.getViewTreeObserver().addOnGlobalLayoutListener(this.caw);
        this.bcO = (TbImageView) view.findViewById(r.g.image_video);
        this.bcO.setDefaultErrorResource(0);
        this.bcO.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.bcO.setEvent(this.aOV);
        this.bcP = (ImageView) view.findViewById(r.g.image_video_play);
        this.bcT = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.bcT.setCertainColumnCount(4);
        this.bcT.setColumnColor(r.d.cp_cont_i);
        this.bcI.setOnClickListener(this);
        this.bcQ = (QuickVideoView) view.findViewById(r.g.texture_video_view);
        this.aOP = new com.baidu.tieba.play.ah(this.Gf.getPageActivity());
        this.bcQ.setBusiness(this.aOP);
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
        this.bUJ = (ThreadSkinView) view.findViewById(r.g.frs_thread_skin);
        this.cat = (GuessYourLikeHeaderView) view.findViewById(r.g.guess_your_like_header);
        this.cau = view.findViewById(r.g.guess_your_like_bottom_line);
        this.aRa = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.fade_out_video_cover);
        this.aRa.setAnimationListener(this.bdd);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcM || view == this.bcG.getCommentNumView() || view == this.cav) {
            U(this.bcM);
        } else if (view == this.bcI) {
            V(view);
        }
        if (this.aeu != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aeu));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bcG != null) {
            this.bcG.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (this.aeu != null) {
            if (this.aeu.sI()) {
                TiebaStatic.log(new av("c10242").ab("fid", String.valueOf(this.aeu.getFid())).s("obj_type", 2));
            } else {
                av avVar = new av("c11100");
                avVar.ab("tid", this.aeu.getId());
                avVar.ab("fid", new StringBuilder(String.valueOf(this.aeu.getFid())).toString());
                TiebaStatic.log(avVar);
            }
            if (this.aeu.getAuthor() != null && this.aeu.getAuthor().getGodUserData() != null && this.aeu.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new av("c10806").s("obj_locate", 3).ab("tid", this.aeu.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aeu);
        }
        if (this.aeu != null) {
            com.baidu.tieba.card.an.hR(this.aeu.getId());
            com.baidu.tbadk.util.r.gC(this.aeu.getId());
            if (this.aeu.sj() > 0 && com.baidu.tieba.tbadkCore.util.s.bng()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.Gf.getPageActivity()).createHistoryCfg(this.aeu.getTid(), String.valueOf(this.aeu.sj()), false, true, com.baidu.tieba.card.an.Pf());
                createHistoryCfg.setVideo_source(this.aeu.sI() ? "floor5" : "frs");
                this.Gf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.Gf.getPageActivity()).createFromThreadCfg(this.aeu, this.mForumName, com.baidu.tieba.card.an.Pf(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aeu.sI() ? "floor5" : "frs");
            this.Gf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void V(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aeu);
        }
        if (this.aeu != null && this.aeu.sf() != null) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(r.j.neterror));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoListActivityConfig(this.Gf.getPageActivity()).createNormalCfg(String.valueOf(this.aeu.getFid()), this.aeu.getTid(), this.aeu.sI() ? "floor5" : "frs")));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: j */
    public void onBindDataToView(bk bkVar) {
        this.aeu = bkVar;
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
        this.aPa.sendEmptyMessageDelayed(202, 0L);
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
        if (this.aeu == null || this.aeu.getAuthor() == null) {
            this.bcM.setVisibility(8);
            return;
        }
        this.bcM.setVisibility(0);
        Pd();
        this.bcJ.setVisibility(0);
        if (this.aeu.getAuthor() == null || this.aeu.getAuthor().getPendantData() == null || StringUtils.isNull(this.aeu.getAuthor().getPendantData().pR())) {
            UserTbVipInfoData rQ = this.aeu.rQ();
            if (rQ != null && rQ.getvipV_url() != null) {
                if (this.bbQ != null) {
                    if (this.bbR == null) {
                        this.bbQ.inflate();
                        this.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.bbR.setVisibility(0);
                    this.bbR.c(rQ.getvipV_url(), 10, false);
                    this.bcF.setIsBigV(true);
                }
            } else {
                this.bcF.setIsBigV(false);
                if (this.bbR != null) {
                    this.bbR.setVisibility(8);
                }
            }
            this.bcF.setVisibility(0);
            this.cas.setVisibility(8);
            this.bcF.setData(this.aeu);
            this.bcF.setAfterClickListener(this.ahZ);
        } else {
            this.bcF.setIsBigV(false);
            if (this.bbR != null) {
                this.bbR.setVisibility(8);
            }
            this.bcF.setVisibility(4);
            this.cas.setVisibility(0);
            this.cas.setData(this.aeu);
            this.cas.setAfterClickListener(this.ahZ);
        }
        if (this.aeu.getAuthor() != null && !StringUtils.isNull(this.aeu.getAuthor().getSealPrefix())) {
            this.bcJ.aN(true);
        }
        this.bcJ.setData(this.aeu);
        this.bcJ.setUserAfterClickListener(this.ahZ);
        this.aeu.sw();
        SpannableStringBuilder so = this.aeu.so();
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.x(so));
        this.mTextTitle.setText(so);
        if (this.bcG.a(this.aeu)) {
            this.bcH.setVisibility(8);
        } else {
            this.bcH.setVisibility(0);
        }
        this.bcG.setStType(com.baidu.tieba.card.an.Pf());
        this.bcG.setForumAfterClickListener(this.ahD);
        this.bcG.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.an.hS(this.aeu.getId())) {
            com.baidu.tbadk.core.util.at.c(this.mTextTitle, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.at.c(this.mTextTitle, r.d.cp_cont_c, 1);
        }
        setBarNameClickEnabled(true);
        k(this.aeu);
        if (this.cat != null) {
            if ((this.aeu.sm() || this.aeu.sn()) && com.baidu.tieba.tbadkCore.util.s.bng()) {
                this.cat.setTitleText(StringUtils.isNull(this.aeu.sl()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : this.aeu.sl());
                this.cat.show();
                this.bcN.setVisibility(8);
                if (this.cau != null) {
                    this.cau.setVisibility(0);
                }
                if (this.aeu.needTopMargin) {
                    this.cat.btl();
                } else {
                    this.cat.btk();
                    if (this.aeu.isFirstFloor) {
                        this.bcN.setVisibility(0);
                    }
                }
            } else {
                this.cat.hide();
                this.bcN.setVisibility(0);
                if (this.cau != null) {
                    this.cau.setVisibility(8);
                }
            }
        }
        onChangeSkinType(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void k(bk bkVar) {
        MetaData author;
        if (bkVar != null && (author = bkVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo si = bkVar.si();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcF.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bcK.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bUs.setVisibility(8);
                if (this.bUJ != null) {
                    if (si != null) {
                        this.bUJ.a(this.Gf, si, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bkVar.getFid()), bkVar.getForum_name(), bkVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds16);
                    } else {
                        this.bUJ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bUs.setVisibility(0);
                this.bUs.setImageBitmap(null);
                this.bUs.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bUs.setOnClickListener(new g(this, themeCard));
                this.bUJ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds30);
            }
            this.bcF.setLayoutParams(layoutParams);
            this.bcK.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc() {
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
            if (com.baidu.tbadk.core.l.oJ().oP() && this.aeu != null && this.aeu.sf() != null) {
                this.bcO.setDefaultBgResource(r.f.pic_bg_video_frs);
                this.bcO.c(this.aeu.sf().thumbnail_url, 10, false);
                this.bcI.setVisibility(0);
                stopPlay();
                this.aPS = this.aeu.sf().video_url;
                if (StringUtils.isNull(this.aPS)) {
                    e(true, 4);
                }
                if (this.aOP != null && this.aOP.bcT() != null) {
                    this.aOP.bcT().c(this.aeu.sf());
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
            com.baidu.tbadk.core.util.at.l(this.bcM, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.k(this.cav, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.c(this.bcP, r.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.at.j((View) this.mTextTitle, r.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.j((View) this.bcR, r.d.cp_cont_i);
            if (this.aeu != null && this.aeu.needTopMargin) {
                com.baidu.tbadk.core.util.at.l(this.bcN, r.d.cp_bg_line_c);
            } else {
                com.baidu.tbadk.core.util.at.l(this.bcN, r.d.cp_bg_line_b);
            }
            com.baidu.tbadk.core.util.at.l(this.bcS, r.d.common_color_10014);
            if (this.bcR != null) {
                this.bcR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.cat != null) {
                this.cat.tB();
            }
            com.baidu.tbadk.core.util.at.l(this.cau, r.d.cp_bg_line_c);
            this.bcJ.tB();
            this.bcG.tB();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bcG != null && this.bdb != null) {
            this.bcG.h(bdUniqueId);
            this.bdb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.mForumName = str;
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
        if (!this.aNR && this.aeu != null && this.aeu.sf() != null && this.bcQ != null && com.baidu.tbadk.util.w.p(2, this.aPS)) {
            e(true, 2);
            this.bcQ.setVideoPath(this.aPS);
            this.bcQ.start();
            this.bcQ.setLooping(true);
            if (this.aNS != null) {
                this.aNS.start();
            }
            this.aNR = true;
            JU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        if (this.aeu != null && this.aeu.sf() != null) {
            com.baidu.tieba.play.z.a(this.aeu.sf().video_md5, this.aeu.getTid(), new StringBuilder(String.valueOf(this.aeu.getFid())).toString(), this.aeu.sI() ? "floor5" : "frs", "", "", "1");
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

    public void a(ax axVar) {
        if (this.aOP != null) {
            this.aOP.a(axVar);
        }
    }
}
