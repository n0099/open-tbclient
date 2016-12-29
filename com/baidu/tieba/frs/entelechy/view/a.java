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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ax;
import com.baidu.tieba.play.t;
import com.baidu.tieba.play.w;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bg> implements bb {
    private TbPageContext<?> Gf;
    private t.d aLF;
    private t.b aLG;
    private boolean aNi;
    private com.baidu.tieba.play.w aNj;
    private w.a aNm;
    private com.baidu.tieba.play.ah aOg;
    private int aOl;
    private TbImageView.a aOm;
    private QuickVideoView.b aOo;
    private Runnable aOp;
    private Handler aOr;
    private String aPj;
    private Animation aQr;
    private bg adN;
    private final View.OnClickListener ahA;
    private final View.OnClickListener ahg;
    public TbImageView bAE;
    public ThreadSkinView bAV;
    public HeadPendantClickableView bGc;
    public RelativeLayout bGd;
    private ViewTreeObserver.OnGlobalLayoutListener bGe;
    public ViewStub baW;
    public TbImageView baX;
    private CardGroupDividerView bbM;
    public ClickableHeaderImageView bbY;
    public ThreadCommentAndPraiseInfoLayout bbZ;
    public View bca;
    public FrameLayout bcb;
    public UserIconLayout bcc;
    public LinearLayout bcd;
    private RelativeLayout bcf;
    private TbImageView bcg;
    private ImageView bch;
    private QuickVideoView bci;
    private TextView bcj;
    private View bck;
    private AudioAnimationView bcl;
    private ProgressBar bcm;
    private ImageView bcn;
    private View bcp;
    private int bcq;
    private Runnable bcs;
    private CustomMessageListener bct;
    private Animation.AnimationListener bcv;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aOl = 0;
        this.bcq = 1;
        this.aNi = false;
        this.aOr = new b(this, Looper.getMainLooper());
        this.aLF = new h(this);
        this.aLG = new i(this);
        this.aOm = new j(this);
        this.bGe = new k(this);
        this.aOp = new l(this);
        this.bcs = new m(this);
        this.aOo = new n(this);
        this.ahA = new o(this);
        this.bct = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahg = new d(this);
        this.aNm = new e(this);
        this.bcv = new f(this);
        this.Gf = tbPageContext;
        View view = getView();
        this.bcf = (RelativeLayout) view.findViewById(r.g.layout_root);
        this.bGd = (RelativeLayout) view.findViewById(r.g.video_card_content_root);
        this.bGd.setOnClickListener(this);
        this.bbY = (ClickableHeaderImageView) view.findViewById(r.g.image_user);
        this.bbY.setDefaultResource(17170445);
        this.bbY.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bbY.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bbY.setRadius(com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds70));
        this.bGc = (HeadPendantClickableView) view.findViewById(r.g.pendant_image_user);
        this.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        if (this.bGc.getHeadView() != null) {
            this.bGc.getHeadView().setDefaultResource(17170445);
            this.bGc.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bGc.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bGc.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds70));
            this.bGc.getHeadView().setIsRound(true);
            this.bGc.getHeadView().setDrawBorder(false);
        }
        this.bGc.vY();
        if (this.bGc.getPendantView() != null) {
            this.bGc.getPendantView().setIsRound(true);
            this.bGc.getPendantView().setDrawBorder(false);
        }
        this.bcc = (UserIconLayout) view.findViewById(r.g.text_user_name);
        this.bcc.ahz = true;
        this.bcc.setEntelechyEnabled(true);
        this.bcm = (ProgressBar) view.findViewById(r.g.auto_video_loading_progress);
        this.bcn = (ImageView) view.findViewById(r.g.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.g.text_title);
        this.bAE = (TbImageView) view.findViewById(r.g.frs_video_item_theme_card);
        this.bbZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.text_bottom);
        this.bca = view.findViewById(r.g.divider_below_reply_number_layout);
        this.bbZ.setLocationEnabled(true);
        this.bbZ.setViewNumEnabled(true);
        this.bbZ.setCommentNumClickListener(this);
        this.bcb = (FrameLayout) view.findViewById(r.g.frame_video);
        this.bcb.getViewTreeObserver().addOnGlobalLayoutListener(this.bGe);
        this.bcg = (TbImageView) view.findViewById(r.g.image_video);
        this.bcg.setDefaultErrorResource(0);
        this.bcg.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.bcg.setEvent(this.aOm);
        this.bch = (ImageView) view.findViewById(r.g.image_video_play);
        this.bcl = (AudioAnimationView) view.findViewById(r.g.auto_video_play_state);
        this.bcl.setCertainColumnCount(4);
        this.bcl.setColumnColor(r.d.cp_cont_i);
        this.bcb.setOnClickListener(this);
        this.bci = (QuickVideoView) view.findViewById(r.g.texture_video_view);
        this.aOg = new com.baidu.tieba.play.ah(this.Gf.getPageActivity());
        this.bci.setBusiness(this.aOg);
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
        this.bAV = (ThreadSkinView) view.findViewById(r.g.frs_thread_skin);
        this.bbM = (CardGroupDividerView) view.findViewById(r.g.header_divider);
        this.aQr = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.fade_out_video_cover);
        this.aQr.setAnimationListener(this.bcv);
        this.bbM.setTitleClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcf || view == this.bbZ.getCommentNumView() || view == this.bGd || view == this.bbM) {
            U(this.bcf);
        } else if (view == this.bcb) {
            V(view);
        }
        if (this.adN != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.adN));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbZ != null) {
            this.bbZ.setBarNameClickEnabled(z);
        }
    }

    private void U(View view) {
        if (this.adN != null) {
            if (this.adN.sx()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10242").ab("fid", String.valueOf(this.adN.getFid())).s("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c11100");
                atVar.ab("tid", this.adN.getId());
                atVar.ab("fid", new StringBuilder(String.valueOf(this.adN.getFid())).toString());
                TiebaStatic.log(atVar);
            }
            if (this.adN.getAuthor() != null && this.adN.getAuthor().getGodUserData() != null && this.adN.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.at("c10806").s("obj_locate", 3).ab("tid", this.adN.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.adN);
        }
        if (this.adN != null) {
            com.baidu.tieba.card.ap.hL(this.adN.getId());
            com.baidu.tbadk.util.r.gx(this.adN.getId());
            if (this.adN.sa() > 0 && com.baidu.tieba.tbadkCore.util.s.bha()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.Gf.getPageActivity()).createHistoryCfg(this.adN.getTid(), String.valueOf(this.adN.sa()), false, true, com.baidu.tieba.card.ap.OB());
                createHistoryCfg.setVideo_source(this.adN.sx() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.adN.sG());
                this.Gf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.Gf.getPageActivity()).createFromThreadCfg(this.adN, this.mForumName, com.baidu.tieba.card.ap.OB(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.adN.sx() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.adN.sG());
            this.Gf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void V(View view) {
        String str;
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.adN);
        }
        if (this.adN != null && this.adN.rW() != null) {
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(r.j.neterror));
                return;
            }
            boolean sx = this.adN.sx();
            VideoListActivityConfig videoListActivityConfig = new VideoListActivityConfig(this.Gf.getPageActivity());
            String valueOf = String.valueOf(this.adN.getFid());
            String tid = this.adN.getTid();
            if (sx) {
                str = "floor5";
            } else {
                str = "frs";
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoListActivityConfig.createNormalCfg(valueOf, tid, str)));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: o */
    public void onBindDataToView(bg bgVar) {
        this.adN = bgVar;
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
        this.aOr.sendEmptyMessageDelayed(202, 0L);
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
        if (this.adN == null || this.adN.getAuthor() == null) {
            this.bcf.setVisibility(8);
            return;
        }
        this.bcf.setVisibility(0);
        Oz();
        this.bcc.setVisibility(0);
        if (this.adN.getAuthor() == null || this.adN.getAuthor().getPendantData() == null || StringUtils.isNull(this.adN.getAuthor().getPendantData().pS())) {
            UserTbVipInfoData rF = this.adN.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.baW != null) {
                    if (this.baX == null) {
                        this.baW.inflate();
                        this.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.baX.setVisibility(0);
                    this.baX.c(rF.getvipV_url(), 10, false);
                    this.bbY.setIsBigV(true);
                }
            } else {
                this.bbY.setIsBigV(false);
                if (this.baX != null) {
                    this.baX.setVisibility(8);
                }
            }
            this.bbY.setVisibility(0);
            this.bGc.setVisibility(8);
            this.bbY.setData(this.adN);
            this.bbY.setAfterClickListener(this.ahA);
        } else {
            this.bbY.setIsBigV(false);
            if (this.baX != null) {
                this.baX.setVisibility(8);
            }
            this.bbY.setVisibility(4);
            this.bGc.setVisibility(0);
            this.bGc.setData(this.adN);
            this.bGc.setAfterClickListener(this.ahA);
        }
        if (this.adN.getAuthor() != null && !StringUtils.isNull(this.adN.getAuthor().getSealPrefix())) {
            this.bcc.aO(true);
        }
        this.bcc.setData(this.adN);
        this.bcc.setUserAfterClickListener(this.ahA);
        this.adN.sl();
        SpannableStringBuilder sd = this.adN.sd();
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.x(sd));
        this.mTextTitle.setText(sd);
        if (this.bbZ.a(this.adN)) {
            this.bca.setVisibility(8);
        } else {
            this.bca.setVisibility(0);
        }
        this.bbZ.setStType(com.baidu.tieba.card.ap.OB());
        this.bbZ.setForumAfterClickListener(this.ahg);
        this.bbZ.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.ap.hM(this.adN.getId())) {
            com.baidu.tbadk.core.util.ar.c(this.mTextTitle, r.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.ar.c(this.mTextTitle, r.d.cp_cont_c, 1);
        }
        setBarNameClickEnabled(true);
        p(this.adN);
        p.a(this.adN, this.bbM);
        onChangeSkinType(this.Gf, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void p(bg bgVar) {
        MetaData author;
        if (bgVar != null && (author = bgVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rZ = bgVar.rZ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbY.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bcd.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bAE.setVisibility(8);
                if (this.bAV != null) {
                    if (rZ != null) {
                        this.bAV.a(this.Gf, rZ, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bgVar.getFid()), bgVar.rK(), bgVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds16);
                    } else {
                        this.bAV.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.bAE.setVisibility(0);
                this.bAE.setImageBitmap(null);
                this.bAE.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bAE.setOnClickListener(new g(this, themeCard));
                this.bAV.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds30);
            }
            this.bbY.setLayoutParams(layoutParams);
            this.bcd.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
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
            if (com.baidu.tbadk.core.l.oJ().oP() && this.adN != null && this.adN.rW() != null) {
                this.bcb.setVisibility(0);
                this.bcg.setDefaultBgResource(r.f.pic_bg_video_frs);
                this.bcg.c(this.adN.rW().thumbnail_url, 10, false);
                stopPlay();
                this.aPj = this.adN.rW().video_url;
                if (StringUtils.isNull(this.aPj)) {
                    e(true, 4);
                }
                if (this.aOg != null && this.aOg.aWA() != null) {
                    this.aOg.aWA().c(this.adN.rW());
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
            com.baidu.tbadk.core.util.ar.l(this.bcf, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.k(this.bGd, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.c(this.bch, r.f.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.ar.j((View) this.mTextTitle, r.d.cp_cont_c);
            com.baidu.tbadk.core.util.ar.j((View) this.bcj, r.d.cp_cont_i);
            com.baidu.tbadk.core.util.ar.l(this.bck, r.d.common_color_10014);
            if (this.bcj != null) {
                this.bcj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
            MessageManager.getInstance().registerListener(this.bct);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.mForumName = str;
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
        if (!this.aNi && this.adN != null && this.adN.rW() != null && this.bci != null && com.baidu.tbadk.util.w.p(2, this.aPj)) {
            e(true, 2);
            this.bci.setVideoPath(this.aPj);
            this.bci.start();
            this.bci.setLooping(true);
            if (this.aNj != null) {
                this.aNj.start();
            }
            this.aNi = true;
            Jn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jn() {
        if (this.adN != null && this.adN.rW() != null) {
            com.baidu.tieba.play.z.a(this.adN.rW().video_md5, this.adN.getTid(), new StringBuilder(String.valueOf(this.adN.getFid())).toString(), this.adN.sx() ? "floor5" : "frs", "", "", "1");
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

    public void a(ax axVar) {
        if (this.aOg != null) {
            this.aOg.a(axVar);
        }
    }
}
