package com.baidu.tieba.frs.entelechy.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bj> implements cd {
    private v.d aQs;
    private v.b aQt;
    private boolean aRX;
    private com.baidu.tieba.play.y aRY;
    private com.baidu.tieba.play.aj aSW;
    private y.a aSb;
    private String aTZ;
    private int aTb;
    private TbImageView.a aTc;
    private QuickVideoView.b aTe;
    private Runnable aTf;
    private Handler aTh;
    private TbPageContext<?> aaI;
    private bj ain;
    private final View.OnClickListener alM;
    private final View.OnClickListener amj;
    public TbImageView bPi;
    private ViewTreeObserver.OnGlobalLayoutListener bTA;
    private com.baidu.tieba.frs.f.af bTz;
    private RelativeLayout baV;
    public HeadPendantClickableView bbf;
    public ClickableHeaderImageView bbg;
    public ViewStub bbh;
    public TbImageView bbi;
    public ThreadCommentAndPraiseInfoLayout bbj;
    public UserIconLayout bbk;
    public LinearLayout bbl;
    public ThreadSkinView bbm;
    public RelativeLayout bbn;
    public FrameLayout bsG;
    private TbImageView bsH;
    private ImageView bsJ;
    private CustomMessageListener bsL;
    public View bsN;
    private QuickVideoView bsP;
    private TextView bsQ;
    private TextView bsR;
    private TextView bsS;
    private View bsT;
    private AudioAnimationView bsU;
    private ProgressBar bsV;
    private ImageView bsW;
    private View bsY;
    private int bsZ;
    private CardGroupDividerView bss;
    private Animation btb;
    private Runnable btc;
    private Animation.AnimationListener bte;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTb = 0;
        this.bsZ = 1;
        this.aRX = false;
        this.aTh = new b(this, Looper.getMainLooper());
        this.aQs = new h(this);
        this.aQt = new i(this);
        this.aTc = new j(this);
        this.bTA = new k(this);
        this.aTf = new l(this);
        this.btc = new m(this);
        this.aTe = new n(this);
        this.amj = new o(this);
        this.bsL = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.alM = new d(this);
        this.aSb = new e(this);
        this.bte = new f(this);
        this.aaI = tbPageContext;
        View view = getView();
        this.baV = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bbn = (RelativeLayout) view.findViewById(w.h.video_card_content_root);
        this.bbn.setOnClickListener(this);
        this.bbg = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.bbg.setDefaultResource(17170445);
        this.bbg.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbg.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbg.setRadius(com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds70));
        this.bbf = (HeadPendantClickableView) view.findViewById(w.h.pendant_image_user);
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.bbf.getHeadView() != null) {
            this.bbf.getHeadView().setDefaultResource(17170445);
            this.bbf.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bbf.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bbf.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds70));
            this.bbf.getHeadView().setIsRound(true);
            this.bbf.getHeadView().setDrawBorder(false);
        }
        this.bbf.wp();
        if (this.bbf.getPendantView() != null) {
            this.bbf.getPendantView().setIsRound(true);
            this.bbf.getPendantView().setDrawBorder(false);
        }
        this.bbk = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.bbk.amh = true;
        this.bbk.ami = true;
        this.bbk.setEntelechyEnabled(true);
        this.bsV = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bsW = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bPi = (TbImageView) view.findViewById(w.h.frs_video_item_theme_card);
        this.bbj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bsN = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bbj.setLocationEnabled(true);
        this.bbj.setViewNumEnabled(true);
        this.bbj.setCommentNumClickListener(this);
        this.bsG = (FrameLayout) view.findViewById(w.h.frame_video);
        this.bsG.getViewTreeObserver().addOnGlobalLayoutListener(this.bTA);
        this.bsH = (TbImageView) view.findViewById(w.h.image_video);
        this.bsH.setDefaultErrorResource(0);
        this.bsH.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bsH.setEvent(this.aTc);
        this.bsJ = (ImageView) view.findViewById(w.h.image_video_play);
        this.bsU = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bsU.setCertainColumnCount(4);
        this.bsU.setColumnColor(w.e.cp_cont_i);
        this.bsP = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aSW = new com.baidu.tieba.play.aj(this.aaI.getPageActivity());
        this.bsP.setBusiness(this.aSW);
        this.bsP.setOnPreparedListener(this.aQs);
        this.bsP.setOnErrorListener(this.aQt);
        this.bsP.setOnSurfaceDestroyedListener(this.aTe);
        this.aRY = new com.baidu.tieba.play.y();
        this.aRY.setPlayer(this.bsP);
        this.aRY.a(this.aSb);
        this.bsY = view.findViewById(w.h.auto_video_black_mask);
        this.bsS = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bsT = view.findViewById(w.h.auto_video_error_background);
        this.bbl = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bbm = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bss = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.btb = AnimationUtils.loadAnimation(this.aaI.getPageActivity(), w.a.fade_out_video_cover);
        this.btb.setAnimationListener(this.bte);
        this.bss.setTitleClickListener(this);
        this.bsQ = (TextView) view.findViewById(w.h.text_video_duration);
        this.bsR = (TextView) view.findViewById(w.h.text_play_count);
        this.bTz = new com.baidu.tieba.frs.f.af(tbPageContext, this.bbj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baV || view == this.bbj.getCommentNumView() || view == this.bbn || view == this.bss) {
            N(this.baV);
        }
        if (this.ain != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.ain));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbj != null) {
            this.bbj.setBarNameClickEnabled(z);
        }
    }

    private void N(View view) {
        if (this.ain != null) {
            if (this.ain.sK()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10242").Z("fid", String.valueOf(this.ain.getFid())).s("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11100");
                asVar.Z("tid", this.ain.getId());
                asVar.Z("fid", new StringBuilder(String.valueOf(this.ain.getFid())).toString());
                TiebaStatic.log(asVar);
            }
            if (this.ain.getAuthor() != null && this.ain.getAuthor().getGodUserData() != null && this.ain.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10806").s("obj_locate", 3).Z("tid", this.ain.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.ain);
        }
        if (this.ain != null) {
            com.baidu.tieba.card.at.hU(this.ain.getId());
            com.baidu.tbadk.util.r.gj(this.ain.getId());
            if (this.ain.sm() > 0 && com.baidu.tieba.tbadkCore.util.s.biB()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aaI.getPageActivity()).createHistoryCfg(this.ain.getTid(), String.valueOf(this.ain.sm()), false, true, com.baidu.tieba.card.at.rH());
                createHistoryCfg.setVideo_source(this.ain.sK() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.ain.sT());
                createHistoryCfg.setSmartFrsPosition(this.ain.sW());
                this.aaI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aaI.getPageActivity()).createFromThreadCfg(this.ain, this.mForumName, com.baidu.tieba.card.at.rH(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.ain.sK() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.ain.sT());
            createFromThreadCfg.setSmartFrsPosition(this.ain.sW());
            this.aaI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public void onBindDataToView(bj bjVar) {
        this.ain = bjVar;
        MR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KJ() {
        this.aTh.removeMessages(202);
        if (this.bsP.getCurrentPosition() > 0) {
            e(true, 3);
            this.aTh.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aTh.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KK() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTh.removeMessages(203);
        int currentPosition = this.bsP.getCurrentPosition();
        if (currentPosition != this.aTb) {
            this.aTb = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aTh.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bsJ != null && this.bsH != null && this.bsY != null && this.bsU != null && this.bsV != null && this.bsW != null && this.bsT != null && this.bsS != null) {
            if (z || this.bsZ != i) {
                this.bsZ = i;
                com.baidu.adp.lib.g.h.fM().removeCallbacks(this.btc);
                com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aTf);
                if (i == 2) {
                    this.bsJ.setVisibility(8);
                    this.btb.cancel();
                    this.bsH.clearAnimation();
                    this.bsH.setVisibility(0);
                    this.bsY.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsR.setVisibility(0);
                    this.bsV.setVisibility(0);
                    this.bsW.setVisibility(0);
                    this.bsT.setVisibility(8);
                    this.bsS.setVisibility(8);
                    this.bsU.setVisibility(8);
                    this.bsU.blA();
                    com.baidu.adp.lib.g.h.fM().postDelayed(this.btc, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bsJ.setVisibility(8);
                    this.bsH.startAnimation(this.btb);
                    this.bsY.setVisibility(8);
                    this.bsQ.setVisibility(8);
                    this.bsR.setVisibility(8);
                    this.bsV.setVisibility(8);
                    this.bsW.setVisibility(8);
                    this.bsT.setVisibility(8);
                    this.bsS.setVisibility(8);
                    this.bsU.setVisibility(0);
                    this.bsU.start();
                } else if (i == 4) {
                    this.bsJ.setVisibility(8);
                    this.bsH.startAnimation(this.btb);
                    this.bsY.setVisibility(8);
                    this.bsV.setVisibility(8);
                    this.bsW.setVisibility(8);
                    this.bsT.setVisibility(0);
                    this.bsS.setVisibility(0);
                    this.bsU.setVisibility(8);
                    this.bsU.blA();
                    com.baidu.adp.lib.g.h.fM().postDelayed(this.aTf, 2000L);
                } else {
                    this.bsJ.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsR.setVisibility(0);
                    this.btb.cancel();
                    this.bsH.clearAnimation();
                    this.bsH.setVisibility(0);
                    this.bsY.setVisibility(0);
                    this.bsV.setVisibility(8);
                    this.bsW.setVisibility(8);
                    this.bsT.setVisibility(8);
                    this.bsS.setVisibility(8);
                    this.bsU.setVisibility(8);
                    this.bsU.blA();
                }
            }
        }
    }

    private void MR() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.ain == null || this.ain.getAuthor() == null) {
            this.baV.setVisibility(8);
            return;
        }
        this.baV.setVisibility(0);
        So();
        this.bbk.setVisibility(0);
        if (this.ain.getAuthor() == null || this.ain.getAuthor().getPendantData() == null || StringUtils.isNull(this.ain.getAuthor().getPendantData().qd())) {
            UserTbVipInfoData rR = this.ain.rR();
            if (rR != null && rR.getvipV_url() != null) {
                if (this.bbh != null) {
                    if (this.bbi == null) {
                        this.bbh.inflate();
                        this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbi.setVisibility(0);
                    this.bbi.c(rR.getvipV_url(), 10, false);
                    this.bbg.setIsBigV(true);
                }
            } else {
                this.bbg.setIsBigV(false);
                if (this.bbi != null) {
                    this.bbi.setVisibility(8);
                }
            }
            this.bbg.setVisibility(0);
            this.bbf.setVisibility(8);
            this.bbg.setData(this.ain);
            this.bbg.setAfterClickListener(this.amj);
        } else {
            this.bbg.setIsBigV(false);
            if (this.bbi != null) {
                this.bbi.setVisibility(8);
            }
            this.bbg.setVisibility(4);
            this.bbf.setVisibility(0);
            this.bbf.setData(this.ain);
            this.bbf.setAfterClickListener(this.amj);
        }
        if (this.ain.getAuthor() != null && !StringUtils.isNull(this.ain.getAuthor().getSealPrefix())) {
            this.bbk.aN(true);
        }
        this.bbk.setData(this.ain);
        this.bbk.setUserAfterClickListener(this.amj);
        this.ain.sy();
        if (this.ain.getThreadType() == 50) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aaI.getResources().getString(w.l.frs_live_play_backs)) + this.ain.sq().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aaI.getResources().getColor(w.e.cp_link_tip_a)), 0, 6, 34);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.ain.sq().toString());
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.x(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bbj.a(this.ain)) {
            this.bsN.setVisibility(8);
        } else {
            this.bsN.setVisibility(0);
        }
        this.bsQ.setText(com.baidu.tbadk.core.util.au.cT(this.ain.sh().video_duration.intValue() * 1000));
        this.bsR.setText(this.aaI.getPageActivity().getString(w.l.play_count, new Object[]{com.baidu.tbadk.core.util.au.t(this.ain.sh().play_count.intValue())}));
        this.bbj.setStType(com.baidu.tieba.card.at.rH());
        this.bbj.setForumAfterClickListener(this.alM);
        this.bbj.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.at.hV(this.ain.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        setBarNameClickEnabled(true);
        s(this.ain);
        this.bTz.D(this.ain);
        p.a(this.ain, this.bss);
        onChangeSkinType(this.aaI, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void s(bj bjVar) {
        MetaData author;
        if (bjVar != null && (author = bjVar.getAuthor()) != null) {
            if (bjVar.sU() != null && bjVar.sU().channelId > 0) {
                this.bPi.setVisibility(8);
                return;
            }
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sl = bjVar.sl();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbg.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bbl.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bPi.setVisibility(8);
                if (this.bbm != null) {
                    if (sl != null) {
                        this.bbm.a(this.aaI, sl, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bjVar.getFid()), bjVar.rV(), bjVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds16);
                    } else {
                        this.bbm.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bPi.setVisibility(0);
                this.bPi.setImageBitmap(null);
                this.bPi.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bPi.setOnClickListener(new g(this, themeCard));
                this.bbm.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds30);
            }
            this.bbg.setLayoutParams(layoutParams);
            this.bbl.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rf() {
        this.aTh.removeMessages(202);
        this.aTh.removeMessages(203);
    }

    private void RB() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aTf);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.btc);
    }

    private void So() {
        RB();
        Rf();
        if (this.bsH != null && this.bsG != null && this.bsP != null) {
            if (com.baidu.tbadk.core.l.oQ().oW() && this.ain != null && this.ain.sh() != null) {
                this.bsG.setVisibility(0);
                this.bsH.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.bsH.c(this.ain.sh().thumbnail_url, 10, false);
                stopPlay();
                this.aTZ = this.ain.sh().video_url;
                if (StringUtils.isNull(this.aTZ)) {
                    e(true, 4);
                }
                if (this.aSW != null && this.aSW.aXS() != null) {
                    this.aSW.aXS().c(this.ain.sh());
                    return;
                }
                return;
            }
            this.bsG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.baV, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bbn, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.bsJ, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i((View) this.bsS, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i((View) this.bsQ, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i((View) this.bsR, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.k(this.bsT, w.e.common_color_10014);
            if (this.bsS != null) {
                this.bsS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bss != null) {
                this.bss.tD();
            }
            this.bbk.tD();
            this.bbj.tD();
            this.mSkinType = i;
            this.bbg.invalidate();
            this.bTz.tD();
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbj != null && this.bsL != null) {
            this.bbj.h(bdUniqueId);
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.aRX;
    }

    public boolean isPlaying() {
        if (this.bsP == null) {
            return false;
        }
        return this.bsP.isPlaying();
    }

    public void startPlay() {
        if (!this.aRX && this.ain != null && this.ain.sh() != null && this.bsP != null && com.baidu.tbadk.util.w.q(2, this.aTZ)) {
            e(true, 2);
            this.bsP.setVideoPath(this.aTZ);
            this.bsP.start();
            this.bsP.setLooping(true);
            if (this.aRY != null) {
                this.aRY.start();
            }
            this.aRX = true;
            Kg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg() {
        if (this.ain != null && this.ain.sh() != null) {
            String str = this.ain.sK() ? "floor5" : "frs";
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = str;
            bbVar.bqB = this.ain.getTid();
            bbVar.bqC = new StringBuilder(String.valueOf(this.ain.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.ain.Zh;
            bbVar.eXe = this.ain.Zj;
            bbVar.eXf = this.ain.Zi;
            bbVar.eXg = "";
            if (this.ain.sU() != null && this.ain.sU().channelId > 0) {
                bbVar.Vy = new StringBuilder(String.valueOf(this.ain.sU().channelId)).toString();
            } else {
                bbVar.Vy = "0";
            }
            com.baidu.tieba.play.ab.a(this.ain.sh().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        RB();
        Rf();
        e(true, 1);
        if (this.bsP != null) {
            this.bsP.stopPlayback();
            if (this.aRY != null) {
                this.aRY.stop();
            }
        }
        this.aRX = false;
    }

    public View getVideoContainer() {
        return this.bsG;
    }

    public String getPlayUrl() {
        return this.aTZ;
    }

    public int getCurrentPosition() {
        if (this.bsP == null) {
            return 0;
        }
        return this.bsP.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aSW != null) {
            this.aSW.a(bbVar);
        }
    }
}
