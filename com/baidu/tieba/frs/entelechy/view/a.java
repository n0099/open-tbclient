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
    private v.d aQI;
    private v.b aQJ;
    private boolean aSn;
    private com.baidu.tieba.play.y aSo;
    private y.a aSr;
    private com.baidu.tieba.play.aj aTl;
    private int aTq;
    private TbImageView.a aTr;
    private QuickVideoView.b aTt;
    private Runnable aTu;
    private Handler aTw;
    private TbPageContext<?> aaX;
    private bi aiB;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    public TbImageView bOX;
    private com.baidu.tieba.frs.g.af bTn;
    private ViewTreeObserver.OnGlobalLayoutListener bTo;
    private RelativeLayout baO;
    public HeadPendantClickableView baY;
    public ClickableHeaderImageView baZ;
    public ViewStub bba;
    public TbImageView bbb;
    public ThreadCommentAndPraiseInfoLayout bbc;
    public UserIconLayout bbd;
    public LinearLayout bbe;
    public ThreadSkinView bbf;
    public RelativeLayout bbg;
    private ImageView bsB;
    private CustomMessageListener bsD;
    public View bsF;
    private QuickVideoView bsH;
    private TextView bsI;
    private TextView bsJ;
    private TextView bsK;
    private View bsL;
    private AudioAnimationView bsM;
    private ProgressBar bsN;
    private ImageView bsO;
    private View bsQ;
    private int bsR;
    private Animation bsT;
    private Runnable bsU;
    private Animation.AnimationListener bsW;
    private CardGroupDividerView bsk;
    public FrameLayout bsy;
    private TbImageView bsz;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;
    private String mVideoUrl;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aTq = 0;
        this.bsR = 1;
        this.aSn = false;
        this.aTw = new b(this, Looper.getMainLooper());
        this.aQI = new h(this);
        this.aQJ = new i(this);
        this.aTr = new j(this);
        this.bTo = new k(this);
        this.aTu = new l(this);
        this.bsU = new m(this);
        this.aTt = new n(this);
        this.amx = new o(this);
        this.bsD = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ama = new d(this);
        this.aSr = new e(this);
        this.bsW = new f(this);
        this.aaX = tbPageContext;
        View view = getView();
        this.baO = (RelativeLayout) view.findViewById(w.h.layout_root);
        this.bbg = (RelativeLayout) view.findViewById(w.h.video_card_content_root);
        this.bbg.setOnClickListener(this);
        this.baZ = (ClickableHeaderImageView) view.findViewById(w.h.image_user);
        this.baZ.setDefaultResource(17170445);
        this.baZ.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.baZ.setDefaultBgResource(w.e.cp_bg_line_e);
        this.baZ.setRadius(com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds70));
        this.baY = (HeadPendantClickableView) view.findViewById(w.h.pendant_image_user);
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        if (this.baY.getHeadView() != null) {
            this.baY.getHeadView().setDefaultResource(17170445);
            this.baY.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.baY.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.baY.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds70));
            this.baY.getHeadView().setIsRound(true);
            this.baY.getHeadView().setDrawBorder(false);
        }
        this.baY.wL();
        if (this.baY.getPendantView() != null) {
            this.baY.getPendantView().setIsRound(true);
            this.baY.getPendantView().setDrawBorder(false);
        }
        this.bbd = (UserIconLayout) view.findViewById(w.h.text_user_name);
        this.bbd.amv = true;
        this.bbd.amw = true;
        this.bbd.setEntelechyEnabled(true);
        this.bsN = (ProgressBar) view.findViewById(w.h.auto_video_loading_progress);
        this.bsO = (ImageView) view.findViewById(w.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(w.h.text_title);
        this.bOX = (TbImageView) view.findViewById(w.h.frs_video_item_theme_card);
        this.bbc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.text_bottom);
        this.bsF = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bbc.setLocationEnabled(true);
        this.bbc.setViewNumEnabled(true);
        this.bbc.setCommentNumClickListener(this);
        this.bsy = (FrameLayout) view.findViewById(w.h.frame_video);
        this.bsy.getViewTreeObserver().addOnGlobalLayoutListener(this.bTo);
        this.bsz = (TbImageView) view.findViewById(w.h.image_video);
        this.bsz.setDefaultErrorResource(0);
        this.bsz.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bsz.setEvent(this.aTr);
        this.bsB = (ImageView) view.findViewById(w.h.image_video_play);
        this.bsM = (AudioAnimationView) view.findViewById(w.h.auto_video_play_state);
        this.bsM.setCertainColumnCount(4);
        this.bsM.setColumnColor(w.e.cp_cont_i);
        this.bsH = (QuickVideoView) view.findViewById(w.h.texture_video_view);
        this.aTl = new com.baidu.tieba.play.aj(this.aaX.getPageActivity());
        this.bsH.setBusiness(this.aTl);
        this.bsH.setOnPreparedListener(this.aQI);
        this.bsH.setOnErrorListener(this.aQJ);
        this.bsH.setOnSurfaceDestroyedListener(this.aTt);
        this.aSo = new com.baidu.tieba.play.y();
        this.aSo.setPlayer(this.bsH);
        this.aSo.a(this.aSr);
        this.bsQ = view.findViewById(w.h.auto_video_black_mask);
        this.bsK = (TextView) view.findViewById(w.h.auto_video_error_tips);
        this.bsL = view.findViewById(w.h.auto_video_error_background);
        this.bbe = (LinearLayout) view.findViewById(w.h.video_card_content_layout);
        this.bbf = (ThreadSkinView) view.findViewById(w.h.frs_thread_skin);
        this.bsk = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bsT = AnimationUtils.loadAnimation(this.aaX.getPageActivity(), w.a.anim_alpha_1_to_0_duration_500_accelerate);
        this.bsT.setAnimationListener(this.bsW);
        this.bsk.setTitleClickListener(this);
        this.bsI = (TextView) view.findViewById(w.h.text_video_duration);
        this.bsJ = (TextView) view.findViewById(w.h.text_play_count);
        this.bTn = new com.baidu.tieba.frs.g.af(tbPageContext, this.bbc);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baO || view == this.bbc.getCommentNumView() || view == this.bbg || view == this.bsk) {
            N(this.baO);
        }
        if (this.aiB != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.aiB));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.bbc != null) {
            this.bbc.setBarNameClickEnabled(z);
        }
    }

    private void N(View view) {
        if (this.aiB != null) {
            if (this.aiB.ti()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10242").aa("fid", String.valueOf(this.aiB.getFid())).s("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11100");
                asVar.aa("tid", this.aiB.getId());
                asVar.aa("fid", new StringBuilder(String.valueOf(this.aiB.getFid())).toString());
                TiebaStatic.log(asVar);
            }
            if (this.aiB.getAuthor() != null && this.aiB.getAuthor().getGodUserData() != null && this.aiB.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10806").s("obj_locate", 3).aa("tid", this.aiB.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aiB);
        }
        if (this.aiB != null) {
            com.baidu.tieba.card.at.hY(this.aiB.getId());
            com.baidu.tbadk.util.r.gp(this.aiB.getId());
            if (this.aiB.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bjm()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.aaX.getPageActivity()).createHistoryCfg(this.aiB.getTid(), String.valueOf(this.aiB.sK()), false, true, com.baidu.tieba.card.at.sf());
                createHistoryCfg.setVideo_source(this.aiB.ti() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.aiB.tr());
                createHistoryCfg.setSmartFrsPosition(this.aiB.tu());
                this.aaX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.aaX.getPageActivity()).createFromThreadCfg(this.aiB, this.mForumName, com.baidu.tieba.card.at.sf(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.aiB.ti() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.aiB.tr());
            createFromThreadCfg.setSmartFrsPosition(this.aiB.tu());
            this.aaX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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
        this.aiB = biVar;
        Nq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        this.aTw.removeMessages(202);
        if (this.bsH.getCurrentPosition() > 0) {
            e(true, 3);
            this.aTw.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aTw.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aTw.removeMessages(203);
        int currentPosition = this.bsH.getCurrentPosition();
        if (currentPosition != this.aTq) {
            this.aTq = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aTw.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bsB != null && this.bsz != null && this.bsQ != null && this.bsM != null && this.bsN != null && this.bsO != null && this.bsL != null && this.bsK != null) {
            if (z || this.bsR != i) {
                this.bsR = i;
                com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bsU);
                com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aTu);
                if (i == 2) {
                    this.bsB.setVisibility(8);
                    this.bsT.cancel();
                    this.bsz.clearAnimation();
                    this.bsz.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsI.setVisibility(0);
                    this.bsJ.setVisibility(0);
                    this.bsN.setVisibility(0);
                    this.bsO.setVisibility(0);
                    this.bsL.setVisibility(8);
                    this.bsK.setVisibility(8);
                    this.bsM.setVisibility(8);
                    this.bsM.bmk();
                    com.baidu.adp.lib.g.h.fR().postDelayed(this.bsU, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.bsB.setVisibility(8);
                    this.bsz.startAnimation(this.bsT);
                    this.bsQ.setVisibility(8);
                    this.bsI.setVisibility(8);
                    this.bsJ.setVisibility(8);
                    this.bsN.setVisibility(8);
                    this.bsO.setVisibility(8);
                    this.bsL.setVisibility(8);
                    this.bsK.setVisibility(8);
                    this.bsM.setVisibility(0);
                    this.bsM.start();
                } else if (i == 4) {
                    this.bsB.setVisibility(8);
                    this.bsz.startAnimation(this.bsT);
                    this.bsQ.setVisibility(8);
                    this.bsN.setVisibility(8);
                    this.bsO.setVisibility(8);
                    this.bsL.setVisibility(0);
                    this.bsK.setVisibility(0);
                    this.bsM.setVisibility(8);
                    this.bsM.bmk();
                    com.baidu.adp.lib.g.h.fR().postDelayed(this.aTu, 2000L);
                } else {
                    this.bsB.setVisibility(0);
                    this.bsI.setVisibility(0);
                    this.bsJ.setVisibility(0);
                    this.bsT.cancel();
                    this.bsz.clearAnimation();
                    this.bsz.setVisibility(0);
                    this.bsQ.setVisibility(0);
                    this.bsN.setVisibility(8);
                    this.bsO.setVisibility(8);
                    this.bsL.setVisibility(8);
                    this.bsK.setVisibility(8);
                    this.bsM.setVisibility(8);
                    this.bsM.bmk();
                }
            }
        }
    }

    private void Nq() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.aiB == null || this.aiB.getAuthor() == null) {
            this.baO.setVisibility(8);
            return;
        }
        this.baO.setVisibility(0);
        SM();
        this.bbd.setVisibility(0);
        if (this.aiB.getAuthor() == null || this.aiB.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiB.getAuthor().getPendantData().qB())) {
            UserTbVipInfoData sp = this.aiB.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bba != null) {
                    if (this.bbb == null) {
                        this.bba.inflate();
                        this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbb.setVisibility(0);
                    this.bbb.c(sp.getvipV_url(), 10, false);
                    this.baZ.setIsBigV(true);
                }
            } else {
                this.baZ.setIsBigV(false);
                if (this.bbb != null) {
                    this.bbb.setVisibility(8);
                }
            }
            this.baZ.setVisibility(0);
            this.baY.setVisibility(8);
            this.baZ.setData(this.aiB);
            this.baZ.setAfterClickListener(this.amx);
        } else {
            this.baZ.setIsBigV(false);
            if (this.bbb != null) {
                this.bbb.setVisibility(8);
            }
            this.baZ.setVisibility(4);
            this.baY.setVisibility(0);
            this.baY.setData(this.aiB);
            this.baY.setAfterClickListener(this.amx);
        }
        if (this.aiB.getAuthor() != null && !StringUtils.isNull(this.aiB.getAuthor().getSealPrefix())) {
            this.bbd.aP(true);
        }
        this.bbd.setData(this.aiB);
        this.bbd.setUserAfterClickListener(this.amx);
        this.aiB.sW();
        if (this.aiB.getThreadType() == 50) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.aaX.getResources().getString(w.l.frs_live_play_backs)) + this.aiB.sO().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.aaX.getResources().getColor(w.e.cp_link_tip_a)), 0, 6, 34);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.aiB.sO().toString());
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.x(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bbc.a(this.aiB)) {
            this.bsF.setVisibility(8);
        } else {
            this.bsF.setVisibility(0);
        }
        this.bsI.setText(com.baidu.tbadk.core.util.au.cW(this.aiB.sF().video_duration.intValue() * 1000));
        this.bsJ.setText(this.aaX.getPageActivity().getString(w.l.play_count, new Object[]{com.baidu.tbadk.core.util.au.t(this.aiB.sF().play_count.intValue())}));
        this.bbc.setStType(com.baidu.tieba.card.at.sf());
        this.bbc.setForumAfterClickListener(this.ama);
        this.bbc.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.at.hZ(this.aiB.getId())) {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.mTextTitle, w.e.cp_cont_b, 1);
        }
        setBarNameClickEnabled(true);
        s(this.aiB);
        this.bTn.A(this.aiB);
        p.a(this.aiB, this.bsk);
        onChangeSkinType(this.aaX, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void s(bi biVar) {
        MetaData author;
        if (biVar != null && (author = biVar.getAuthor()) != null) {
            if (biVar.ts() != null && biVar.ts().channelId > 0) {
                this.bOX.setVisibility(8);
                return;
            }
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sJ = biVar.sJ();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.baZ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bbe.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bOX.setVisibility(8);
                if (this.bbf != null) {
                    if (sJ != null) {
                        this.bbf.a(this.aaX, sJ, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(biVar.getFid()), biVar.st(), biVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds16);
                    } else {
                        this.bbf.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bOX.setVisibility(0);
                this.bOX.setImageBitmap(null);
                this.bOX.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bOX.setOnClickListener(new g(this, themeCard));
                this.bbf.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds30);
            }
            this.baZ.setLayoutParams(layoutParams);
            this.bbe.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RD() {
        this.aTw.removeMessages(202);
        this.aTw.removeMessages(203);
    }

    private void RZ() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aTu);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bsU);
    }

    private void SM() {
        RZ();
        RD();
        if (this.bsz != null && this.bsy != null && this.bsH != null) {
            if (com.baidu.tbadk.core.q.po().pu() && this.aiB != null && this.aiB.sF() != null) {
                this.bsy.setVisibility(0);
                this.bsz.setDefaultBgResource(w.g.pic_bg_video_frs);
                this.bsz.c(this.aiB.sF().thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = this.aiB.sF().video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    e(true, 4);
                }
                if (this.aTl != null && this.aTl.aYb() != null) {
                    this.aTl.aYb().c(this.aiB.sF());
                    return;
                }
                return;
            }
            this.bsy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.baO, w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.j(this.bbg, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.c(this.bsB, w.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.aq.i(this.bsK, w.e.cp_cont_i);
            com.baidu.tbadk.core.util.aq.i(this.bsI, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.i(this.bsJ, w.e.cp_cont_g);
            com.baidu.tbadk.core.util.aq.k(this.bsL, w.e.common_color_10014);
            if (this.bsK != null) {
                this.bsK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.bsk != null) {
                this.bsk.onChangeSkinType();
            }
            this.bbd.onChangeSkinType();
            this.bbc.onChangeSkinType();
            this.mSkinType = i;
            this.baZ.invalidate();
            this.bTn.onChangeSkinType();
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbc != null && this.bsD != null) {
            this.bbc.h(bdUniqueId);
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.aSn;
    }

    public boolean isPlaying() {
        if (this.bsH == null) {
            return false;
        }
        return this.bsH.isPlaying();
    }

    public void startPlay() {
        if (!this.aSn && this.aiB != null && this.aiB.sF() != null && this.bsH != null && com.baidu.tbadk.util.w.q(2, this.mVideoUrl)) {
            e(true, 2);
            this.bsH.setVideoPath(this.mVideoUrl);
            this.bsH.start();
            this.bsH.setLooping(true);
            if (this.aSo != null) {
                this.aSo.start();
            }
            this.aSn = true;
            KG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.aiB != null && this.aiB.sF() != null) {
            String str = this.aiB.ti() ? "floor5" : "frs";
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = str;
            bbVar.bqu = this.aiB.getTid();
            bbVar.bqv = new StringBuilder(String.valueOf(this.aiB.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.aiB.Zx;
            bbVar.eVd = this.aiB.Zz;
            bbVar.eVe = this.aiB.Zy;
            bbVar.eVf = "";
            if (this.aiB.ts() != null && this.aiB.ts().channelId > 0) {
                bbVar.VP = new StringBuilder(String.valueOf(this.aiB.ts().channelId)).toString();
            } else {
                bbVar.VP = "0";
            }
            com.baidu.tieba.play.ab.a(this.aiB.sF().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        RZ();
        RD();
        e(true, 1);
        if (this.bsH != null) {
            this.bsH.stopPlayback();
            if (this.aSo != null) {
                this.aSo.stop();
            }
        }
        this.aSn = false;
    }

    public View getVideoContainer() {
        return this.bsy;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.bsH == null) {
            return 0;
        }
        return this.bsH.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aTl != null) {
            this.aTl.a(bbVar);
        }
    }
}
