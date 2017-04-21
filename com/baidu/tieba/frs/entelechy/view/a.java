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
import com.baidu.tbadk.core.data.bi;
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
public class a extends com.baidu.tieba.card.a<bi> implements cd {
    private v.d aQK;
    private v.b aQL;
    private boolean aSp;
    private com.baidu.tieba.play.y aSq;
    private y.a aSt;
    private com.baidu.tieba.play.aj aTn;
    private int aTs;
    private TbImageView.a aTt;
    private QuickVideoView.b aTv;
    private Runnable aTw;
    private Handler aTy;
    private TbPageContext<?> aaY;
    private bi aiC;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    public TbImageView bRo;
    private com.baidu.tieba.frs.g.af bVE;
    private ViewTreeObserver.OnGlobalLayoutListener bVF;
    private RelativeLayout bbK;
    public HeadPendantClickableView bbU;
    public ClickableHeaderImageView bbV;
    public ViewStub bbW;
    public TbImageView bbX;
    public ThreadCommentAndPraiseInfoLayout bbY;
    public UserIconLayout bbZ;
    public LinearLayout bca;
    public ThreadSkinView bcb;
    public RelativeLayout bcc;
    private CardGroupDividerView buD;
    public FrameLayout buR;
    private TbImageView buS;
    private ImageView buU;
    private CustomMessageListener buW;
    public View buY;
    private QuickVideoView bva;
    private TextView bvb;
    private TextView bvc;
    private TextView bvd;
    private View bve;
    private AudioAnimationView bvf;
    private ProgressBar bvg;
    private ImageView bvh;
    private View bvj;
    private int bvk;
    private Animation bvm;
    private Runnable bvn;
    private Animation.AnimationListener bvp;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTs = 0;
        this.bvk = 1;
        this.aSp = false;
        this.aTy = new b(this, Looper.getMainLooper());
        this.aQK = new h(this);
        this.aQL = new i(this);
        this.aTt = new j(this);
        this.bVF = new k(this);
        this.aTw = new l(this);
        this.bvn = new m(this);
        this.aTv = new n(this);
        this.amx = new o(this);
        this.buW = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ama = new d(this);
        this.aSt = new e(this);
        this.bvp = new f(this);
        this.aaY = tbPageContext;
        View view = getView();
        this.bbK = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bcc = (RelativeLayout) view.findViewById(w.h.video_card_content_root);
        this.bcc.setOnClickListener(this);
        this.bbV = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.bbV.setDefaultResource(17170445);
        this.bbV.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bbV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bbV.setRadius(com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds70));
        this.bbU = (HeadPendantClickableView) view.findViewById(w.h.pendant_image_user);
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.bbU.getHeadView() != null) {
            this.bbU.getHeadView().setDefaultResource(17170445);
            this.bbU.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bbU.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bbU.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds70));
            this.bbU.getHeadView().setIsRound(true);
            this.bbU.getHeadView().setDrawBorder(false);
        }
        this.bbU.wL();
        if (this.bbU.getPendantView() != null) {
            this.bbU.getPendantView().setIsRound(true);
            this.bbU.getPendantView().setDrawBorder(false);
        }
        this.bbZ = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.bbZ.amv = true;
        this.bbZ.amw = true;
        this.bbZ.setEntelechyEnabled(true);
        this.bvg = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bvh = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bRo = (TbImageView) view.findViewById(w.h.frs_video_item_theme_card);
        this.bbY = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.buY = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bbY.setLocationEnabled(true);
        this.bbY.setViewNumEnabled(true);
        this.bbY.setCommentNumClickListener(this);
        this.buR = (FrameLayout) view.findViewById(w.h.frame_video);
        this.buR.getViewTreeObserver().addOnGlobalLayoutListener(this.bVF);
        this.buS = (TbImageView) view.findViewById(w.h.image_video);
        this.buS.setDefaultErrorResource(0);
        this.buS.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.buS.setEvent(this.aTt);
        this.buU = (ImageView) view.findViewById(w.h.image_video_play);
        this.bvf = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bvf.setCertainColumnCount(4);
        this.bvf.setColumnColor(w.e.cp_cont_i);
        this.bva = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aTn = new com.baidu.tieba.play.aj(this.aaY.getPageActivity());
        this.bva.setBusiness(this.aTn);
        this.bva.setOnPreparedListener(this.aQK);
        this.bva.setOnErrorListener(this.aQL);
        this.bva.setOnSurfaceDestroyedListener(this.aTv);
        this.aSq = new com.baidu.tieba.play.y();
        this.aSq.setPlayer(this.bva);
        this.aSq.a(this.aSt);
        this.bvj = view.findViewById(w.h.auto_video_black_mask);
        this.bvd = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bve = view.findViewById(w.h.auto_video_error_background);
        this.bca = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bcb = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.buD = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bvm = AnimationUtils.loadAnimation(this.aaY.getPageActivity(), w.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bvm.setAnimationListener(this.bvp);
        this.buD.setTitleClickListener(this);
        this.bvb = (TextView) view.findViewById(w.h.text_video_duration);
        this.bvc = (TextView) view.findViewById(w.h.text_play_count);
        this.bVE = new com.baidu.tieba.frs.g.af(tbPageContext, this.bbY);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bbK || view == this.bbY.getCommentNumView() || view == this.bcc || view == this.buD) {
            N(this.bbK);
        }
        if (this.aiC != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiC));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbY != null) {
            this.bbY.setBarNameClickEnabled(z);
        }
    }

    private void N(View view) {
        if (this.aiC != null) {
            if (this.aiC.ti()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10242").aa("fid", String.valueOf(this.aiC.getFid())).s("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11100");
                asVar.aa("tid", this.aiC.getId());
                asVar.aa("fid", new StringBuilder(String.valueOf(this.aiC.getFid())).toString());
                TiebaStatic.log(asVar);
            }
            if (this.aiC.getAuthor() != null && this.aiC.getAuthor().getGodUserData() != null && this.aiC.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10806").s("obj_locate", 3).aa("tid", this.aiC.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aiC);
        }
        if (this.aiC != null) {
            com.baidu.tieba.card.at.hZ(this.aiC.getId());
            com.baidu.tbadk.util.r.gp(this.aiC.getId());
            if (this.aiC.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bkn()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aaY.getPageActivity()).createHistoryCfg(this.aiC.getTid(), String.valueOf(this.aiC.sK()), false, true, com.baidu.tieba.card.at.sf());
                createHistoryCfg.setVideo_source(this.aiC.ti() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aiC.tr());
                createHistoryCfg.setSmartFrsPosition(this.aiC.tu());
                this.aaY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aaY.getPageActivity()).createFromThreadCfg(this.aiC, this.mForumName, com.baidu.tieba.card.at.sf(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aiC.ti() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aiC.tr());
            createFromThreadCfg.setSmartFrsPosition(this.aiC.tu());
            this.aaY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public void onBindDataToView(bi biVar) {
        this.aiC = biVar;
        Ny();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        this.aTy.removeMessages(202);
        if (this.bva.getCurrentPosition() > 0) {
            f(true, 3);
            this.aTy.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aTy.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTy.removeMessages(203);
        int currentPosition = this.bva.getCurrentPosition();
        if (currentPosition != this.aTs) {
            this.aTs = currentPosition;
            f(false, 3);
        } else {
            f(false, 2);
        }
        this.aTy.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.buU != null && this.buS != null && this.bvj != null && this.bvf != null && this.bvg != null && this.bvh != null && this.bve != null && this.bvd != null) {
            if (z || this.bvk != i) {
                this.bvk = i;
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bvn);
                com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTw);
                if (i == 2) {
                    this.buU.setVisibility(8);
                    this.bvm.cancel();
                    this.buS.clearAnimation();
                    this.buS.setVisibility(0);
                    this.bvj.setVisibility(0);
                    this.bvb.setVisibility(0);
                    this.bvc.setVisibility(0);
                    this.bvg.setVisibility(0);
                    this.bvh.setVisibility(0);
                    this.bve.setVisibility(8);
                    this.bvd.setVisibility(8);
                    this.bvf.setVisibility(8);
                    this.bvf.bnl();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.bvn, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.buU.setVisibility(8);
                    this.buS.startAnimation(this.bvm);
                    this.bvj.setVisibility(8);
                    this.bvb.setVisibility(8);
                    this.bvc.setVisibility(8);
                    this.bvg.setVisibility(8);
                    this.bvh.setVisibility(8);
                    this.bve.setVisibility(8);
                    this.bvd.setVisibility(8);
                    this.bvf.setVisibility(0);
                    this.bvf.start();
                } else if (i == 4) {
                    this.buU.setVisibility(8);
                    this.buS.startAnimation(this.bvm);
                    this.bvj.setVisibility(8);
                    this.bvg.setVisibility(8);
                    this.bvh.setVisibility(8);
                    this.bve.setVisibility(0);
                    this.bvd.setVisibility(0);
                    this.bvf.setVisibility(8);
                    this.bvf.bnl();
                    com.baidu.adp.lib.g.h.fS().postDelayed(this.aTw, 2000L);
                } else {
                    this.buU.setVisibility(0);
                    this.bvb.setVisibility(0);
                    this.bvc.setVisibility(0);
                    this.bvm.cancel();
                    this.buS.clearAnimation();
                    this.buS.setVisibility(0);
                    this.bvj.setVisibility(0);
                    this.bvg.setVisibility(8);
                    this.bvh.setVisibility(8);
                    this.bve.setVisibility(8);
                    this.bvd.setVisibility(8);
                    this.bvf.setVisibility(8);
                    this.bvf.bnl();
                }
            }
        }
    }

    private void Ny() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.aiC == null || this.aiC.getAuthor() == null) {
            this.bbK.setVisibility(8);
            return;
        }
        this.bbK.setVisibility(0);
        TO();
        this.bbZ.setVisibility(0);
        if (this.aiC.getAuthor() == null || this.aiC.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiC.getAuthor().getPendantData().qB())) {
            UserTbVipInfoData sp = this.aiC.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bbW != null) {
                    if (this.bbX == null) {
                        this.bbW.inflate();
                        this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbX.setVisibility(0);
                    this.bbX.c(sp.getvipV_url(), 10, false);
                    this.bbV.setIsBigV(true);
                }
            } else {
                this.bbV.setIsBigV(false);
                if (this.bbX != null) {
                    this.bbX.setVisibility(8);
                }
            }
            this.bbV.setVisibility(0);
            this.bbU.setVisibility(8);
            this.bbV.setData(this.aiC);
            this.bbV.setAfterClickListener(this.amx);
        } else {
            this.bbV.setIsBigV(false);
            if (this.bbX != null) {
                this.bbX.setVisibility(8);
            }
            this.bbV.setVisibility(4);
            this.bbU.setVisibility(0);
            this.bbU.setData(this.aiC);
            this.bbU.setAfterClickListener(this.amx);
        }
        if (this.aiC.getAuthor() != null && !StringUtils.isNull(this.aiC.getAuthor().getSealPrefix())) {
            this.bbZ.aP(true);
        }
        this.bbZ.setData(this.aiC);
        this.bbZ.setUserAfterClickListener(this.amx);
        this.aiC.sW();
        if (this.aiC.getThreadType() == 50) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aaY.getResources().getString(w.l.frs_live_play_backs)) + this.aiC.sO().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aaY.getResources().getColor(w.e.cp_link_tip_a)), 0, 6, 34);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.aiC.sO().toString());
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.x(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bbY.a(this.aiC)) {
            this.buY.setVisibility(8);
        } else {
            this.buY.setVisibility(0);
        }
        this.bvb.setText(com.baidu.tbadk.core.util.au.cW(this.aiC.sF().video_duration.intValue() * 1000));
        this.bvc.setText(this.aaY.getPageActivity().getString(w.l.play_count, new Object[]{com.baidu.tbadk.core.util.au.t(this.aiC.sF().play_count.intValue())}));
        this.bbY.setStType(com.baidu.tieba.card.at.sf());
        this.bbY.setForumAfterClickListener(this.ama);
        this.bbY.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.at.ia(this.aiC.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        setBarNameClickEnabled(true);
        s(this.aiC);
        this.bVE.A(this.aiC);
        p.a(this.aiC, this.buD);
        onChangeSkinType(this.aaY, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void s(bi biVar) {
        MetaData author;
        if (biVar != null && (author = biVar.getAuthor()) != null) {
            if (biVar.ts() != null && biVar.ts().channelId > 0) {
                this.bRo.setVisibility(8);
                return;
            }
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sJ = biVar.sJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbV.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bca.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bRo.setVisibility(8);
                if (this.bcb != null) {
                    if (sJ != null) {
                        this.bcb.a(this.aaY, sJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.st(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds16);
                    } else {
                        this.bcb.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bRo.setVisibility(0);
                this.bRo.setImageBitmap(null);
                this.bRo.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bRo.setOnClickListener(new g(this, themeCard));
                this.bcb.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds30);
            }
            this.bbV.setLayoutParams(layoutParams);
            this.bca.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SF() {
        this.aTy.removeMessages(202);
        this.aTy.removeMessages(203);
    }

    private void Tb() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTw);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bvn);
    }

    private void TO() {
        Tb();
        SF();
        if (this.buS != null && this.buR != null && this.bva != null) {
            if (com.baidu.tbadk.core.q.po().pu() && this.aiC != null && this.aiC.sF() != null) {
                this.buR.setVisibility(0);
                this.buS.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.buS.c(this.aiC.sF().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aiC.sF().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    f(true, 4);
                }
                if (this.aTn != null && this.aTn.aZc() != null) {
                    this.aTn.aZc().c(this.aiC.sF());
                    return;
                }
                return;
            }
            this.buR.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.bbK, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bcc, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.buU, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i(this.bvd, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.bvb, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i(this.bvc, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.k(this.bve, w.e.common_color_10014);
            if (this.bvd != null) {
                this.bvd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.buD != null) {
                this.buD.onChangeSkinType();
            }
            this.bbZ.onChangeSkinType();
            this.bbY.onChangeSkinType();
            this.mSkinType = i;
            this.bbV.invalidate();
            this.bVE.onChangeSkinType();
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbY != null && this.buW != null) {
            this.bbY.h(bdUniqueId);
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.aSp;
    }

    public boolean isPlaying() {
        if (this.bva == null) {
            return false;
        }
        return this.bva.isPlaying();
    }

    public void startPlay() {
        if (!this.aSp && this.aiC != null && this.aiC.sF() != null && this.bva != null && com.baidu.tbadk.util.w.q(2, this.mVideoUrl)) {
            f(true, 2);
            this.bva.setVideoPath(this.mVideoUrl);
            this.bva.start();
            this.bva.setLooping(true);
            if (this.aSq != null) {
                this.aSq.start();
            }
            this.aSp = true;
            KG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.aiC != null && this.aiC.sF() != null) {
            String str = this.aiC.ti() ? "floor5" : "frs";
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = str;
            bbVar.bsL = this.aiC.getTid();
            bbVar.bsM = new StringBuilder(String.valueOf(this.aiC.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.aiC.Zy;
            bbVar.eXt = this.aiC.ZA;
            bbVar.eXu = this.aiC.Zz;
            bbVar.eXv = "";
            if (this.aiC.ts() != null && this.aiC.ts().channelId > 0) {
                bbVar.VR = new StringBuilder(String.valueOf(this.aiC.ts().channelId)).toString();
            } else {
                bbVar.VR = "0";
            }
            com.baidu.tieba.play.ab.a(this.aiC.sF().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        Tb();
        SF();
        f(true, 1);
        if (this.bva != null) {
            this.bva.stopPlayback();
            if (this.aSq != null) {
                this.aSq.stop();
            }
        }
        this.aSp = false;
    }

    public View getVideoContainer() {
        return this.buR;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bva == null) {
            return 0;
        }
        return this.bva.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aTn != null) {
            this.aTn.a(bbVar);
        }
    }
}
