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
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<bh> implements cd {
    private TbPageContext<?> Fp;
    private v.d aKH;
    private v.b aKI;
    private boolean aMk;
    private com.baidu.tieba.play.y aMl;
    private y.a aMo;
    private com.baidu.tieba.play.aj aNj;
    private int aNo;
    private TbImageView.a aNp;
    private QuickVideoView.b aNr;
    private Runnable aNs;
    private Handler aNu;
    private String aOm;
    private RelativeLayout aUI;
    public HeadPendantClickableView aUS;
    public ClickableHeaderImageView aUT;
    public ViewStub aUU;
    public TbImageView aUV;
    public ThreadCommentAndPraiseInfoLayout aUW;
    public UserIconLayout aUX;
    public LinearLayout aUY;
    public ThreadSkinView aUZ;
    public RelativeLayout aVa;
    private bh acX;
    private final View.OnClickListener agO;
    private final View.OnClickListener agt;
    public TbImageView bHZ;
    private ViewTreeObserver.OnGlobalLayoutListener bMt;
    public FrameLayout blN;
    private TbImageView blO;
    private ImageView blQ;
    private CustomMessageListener blR;
    public View blT;
    private QuickVideoView blV;
    private TextView blW;
    private TextView blX;
    private TextView blY;
    private View blZ;
    private CardGroupDividerView blz;
    private AudioAnimationView bma;
    private ProgressBar bmb;
    private ImageView bmc;
    private View bme;
    private int bmf;
    private Animation bmh;
    private Runnable bmi;
    private Animation.AnimationListener bmk;
    protected String mForumName;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aNo = 0;
        this.bmf = 1;
        this.aMk = false;
        this.aNu = new b(this, Looper.getMainLooper());
        this.aKH = new h(this);
        this.aKI = new i(this);
        this.aNp = new j(this);
        this.bMt = new k(this);
        this.aNs = new l(this);
        this.bmi = new m(this);
        this.aNr = new n(this);
        this.agO = new o(this);
        this.blR = new c(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.agt = new d(this);
        this.aMo = new e(this);
        this.bmk = new f(this);
        this.Fp = tbPageContext;
        View view = getView();
        this.aUI = (RelativeLayout) view.findViewById(r.h.layout_root);
        this.aVa = (RelativeLayout) view.findViewById(r.h.video_card_content_root);
        this.aVa.setOnClickListener(this);
        this.aUT = (ClickableHeaderImageView) view.findViewById(r.h.image_user);
        this.aUT.setDefaultResource(17170445);
        this.aUT.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.aUT.setDefaultBgResource(r.e.cp_bg_line_e);
        this.aUT.setRadius(com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds70));
        this.aUS = (HeadPendantClickableView) view.findViewById(r.h.pendant_image_user);
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        if (this.aUS.getHeadView() != null) {
            this.aUS.getHeadView().setDefaultResource(17170445);
            this.aUS.getHeadView().setDefaultErrorResource(r.g.icon_default_avatar100);
            this.aUS.getHeadView().setDefaultBgResource(r.e.cp_bg_line_e);
            this.aUS.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds70));
            this.aUS.getHeadView().setIsRound(true);
            this.aUS.getHeadView().setDrawBorder(false);
        }
        this.aUS.vS();
        if (this.aUS.getPendantView() != null) {
            this.aUS.getPendantView().setIsRound(true);
            this.aUS.getPendantView().setDrawBorder(false);
        }
        this.aUX = (UserIconLayout) view.findViewById(r.h.text_user_name);
        this.aUX.agN = true;
        this.aUX.setEntelechyEnabled(true);
        this.bmb = (ProgressBar) view.findViewById(r.h.auto_video_loading_progress);
        this.bmc = (ImageView) view.findViewById(r.h.auto_video_loading_image);
        this.mTextTitle = (TextView) view.findViewById(r.h.text_title);
        this.bHZ = (TbImageView) view.findViewById(r.h.frs_video_item_theme_card);
        this.aUW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.text_bottom);
        this.blT = view.findViewById(r.h.divider_below_reply_number_layout);
        this.aUW.setLocationEnabled(true);
        this.aUW.setViewNumEnabled(true);
        this.aUW.setCommentNumClickListener(this);
        this.blN = (FrameLayout) view.findViewById(r.h.frame_video);
        this.blN.getViewTreeObserver().addOnGlobalLayoutListener(this.bMt);
        this.blO = (TbImageView) view.findViewById(r.h.image_video);
        this.blO.setDefaultErrorResource(0);
        this.blO.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.blO.setEvent(this.aNp);
        this.blQ = (ImageView) view.findViewById(r.h.image_video_play);
        this.bma = (AudioAnimationView) view.findViewById(r.h.auto_video_play_state);
        this.bma.setCertainColumnCount(4);
        this.bma.setColumnColor(r.e.cp_cont_i);
        this.blV = (QuickVideoView) view.findViewById(r.h.texture_video_view);
        this.aNj = new com.baidu.tieba.play.aj(this.Fp.getPageActivity());
        this.blV.setBusiness(this.aNj);
        this.blV.setOnPreparedListener(this.aKH);
        this.blV.setOnErrorListener(this.aKI);
        this.blV.setOnSurfaceDestroyedListener(this.aNr);
        this.aMl = new com.baidu.tieba.play.y();
        this.aMl.setPlayer(this.blV);
        this.aMl.a(this.aMo);
        this.bme = view.findViewById(r.h.auto_video_black_mask);
        this.blY = (TextView) view.findViewById(r.h.auto_video_error_tips);
        this.blZ = view.findViewById(r.h.auto_video_error_background);
        this.aUY = (LinearLayout) view.findViewById(r.h.video_card_content_layout);
        this.aUZ = (ThreadSkinView) view.findViewById(r.h.frs_thread_skin);
        this.blz = (CardGroupDividerView) view.findViewById(r.h.header_divider);
        this.bmh = AnimationUtils.loadAnimation(this.Fp.getPageActivity(), r.a.fade_out_video_cover);
        this.bmh.setAnimationListener(this.bmk);
        this.blz.setTitleClickListener(this);
        this.blW = (TextView) view.findViewById(r.h.text_video_duration);
        this.blX = (TextView) view.findViewById(r.h.text_play_count);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUI || view == this.aUW.getCommentNumView() || view == this.aVa || view == this.blz) {
            P(this.aUI);
        }
        if (this.acX != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED, this.acX));
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.aUW != null) {
            this.aUW.setBarNameClickEnabled(z);
        }
    }

    private void P(View view) {
        if (this.acX != null) {
            if (this.acX.sp()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10242").ab("fid", String.valueOf(this.acX.getFid())).s("obj_type", 2));
            } else {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11100");
                arVar.ab("tid", this.acX.getId());
                arVar.ab("fid", new StringBuilder(String.valueOf(this.acX.getFid())).toString());
                TiebaStatic.log(arVar);
            }
            if (this.acX.getAuthor() != null && this.acX.getAuthor().getGodUserData() != null && this.acX.getAuthor().getGodUserData().getType() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10806").s("obj_locate", 3).ab("tid", this.acX.getId()));
            }
        }
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.acX);
        }
        if (this.acX != null) {
            com.baidu.tieba.card.at.ie(this.acX.getId());
            com.baidu.tbadk.util.r.gu(this.acX.getId());
            if (this.acX.rS() > 0 && com.baidu.tieba.tbadkCore.util.s.biL()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.Fp.getPageActivity()).createHistoryCfg(this.acX.getTid(), String.valueOf(this.acX.rS()), false, true, com.baidu.tieba.card.at.Mt());
                createHistoryCfg.setVideo_source(this.acX.sp() ? "floor5" : "frs");
                createHistoryCfg.setFromSmartFrs(this.acX.sy());
                this.Fp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.Fp.getPageActivity()).createFromThreadCfg(this.acX, this.mForumName, com.baidu.tieba.card.at.Mt(), 18003, true, false, false);
            createFromThreadCfg.setVideo_source(this.acX.sp() ? "floor5" : "frs");
            createFromThreadCfg.setFromSmartFrs(this.acX.sy());
            this.Fp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_auto_video_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public void onBindDataToView(bh bhVar) {
        this.acX = bhVar;
        Mf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke() {
        this.aNu.removeMessages(202);
        if (this.blV.getCurrentPosition() > 0) {
            e(true, 3);
            this.aNu.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.aNu.sendEmptyMessageDelayed(202, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        if (getView().getParent() == null) {
            stopPlay();
            return;
        }
        this.aNu.removeMessages(203);
        int currentPosition = this.blV.getCurrentPosition();
        if (currentPosition != this.aNo) {
            this.aNo = currentPosition;
            e(false, 3);
        } else {
            e(false, 2);
        }
        this.aNu.sendEmptyMessageDelayed(203, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.blQ != null && this.blO != null && this.bme != null && this.bma != null && this.bmb != null && this.bmc != null && this.blZ != null && this.blY != null) {
            if (z || this.bmf != i) {
                this.bmf = i;
                com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bmi);
                com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aNs);
                if (i == 2) {
                    this.blQ.setVisibility(8);
                    this.bmh.cancel();
                    this.blO.clearAnimation();
                    this.blO.setVisibility(0);
                    this.bme.setVisibility(0);
                    this.blW.setVisibility(0);
                    this.blX.setVisibility(0);
                    this.bmb.setVisibility(0);
                    this.bmc.setVisibility(0);
                    this.blZ.setVisibility(8);
                    this.blY.setVisibility(8);
                    this.bma.setVisibility(8);
                    this.bma.blL();
                    com.baidu.adp.lib.g.h.eE().postDelayed(this.bmi, TbConfig.USE_TIME_INTERVAL);
                } else if (i == 3) {
                    this.blQ.setVisibility(8);
                    this.blO.startAnimation(this.bmh);
                    this.bme.setVisibility(8);
                    this.blW.setVisibility(8);
                    this.blX.setVisibility(8);
                    this.bmb.setVisibility(8);
                    this.bmc.setVisibility(8);
                    this.blZ.setVisibility(8);
                    this.blY.setVisibility(8);
                    this.bma.setVisibility(0);
                    this.bma.start();
                } else if (i == 4) {
                    this.blQ.setVisibility(8);
                    this.blO.startAnimation(this.bmh);
                    this.bme.setVisibility(8);
                    this.bmb.setVisibility(8);
                    this.bmc.setVisibility(8);
                    this.blZ.setVisibility(0);
                    this.blY.setVisibility(0);
                    this.bma.setVisibility(8);
                    this.bma.blL();
                    com.baidu.adp.lib.g.h.eE().postDelayed(this.aNs, 2000L);
                } else {
                    this.blQ.setVisibility(0);
                    this.blW.setVisibility(0);
                    this.blX.setVisibility(0);
                    this.bmh.cancel();
                    this.blO.clearAnimation();
                    this.blO.setVisibility(0);
                    this.bme.setVisibility(0);
                    this.bmb.setVisibility(8);
                    this.bmc.setVisibility(8);
                    this.blZ.setVisibility(8);
                    this.blY.setVisibility(8);
                    this.bma.setVisibility(8);
                    this.bma.blL();
                }
            }
        }
    }

    private void Mf() {
        SpannableStringBuilder spannableStringBuilder;
        if (this.acX == null || this.acX.getAuthor() == null) {
            this.aUI.setVisibility(8);
            return;
        }
        this.aUI.setVisibility(0);
        Rq();
        this.aUX.setVisibility(0);
        if (this.acX.getAuthor() == null || this.acX.getAuthor().getPendantData() == null || StringUtils.isNull(this.acX.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData rx = this.acX.rx();
            if (rx != null && rx.getvipV_url() != null) {
                if (this.aUU != null) {
                    if (this.aUV == null) {
                        this.aUU.inflate();
                        this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                    }
                    this.aUV.setVisibility(0);
                    this.aUV.c(rx.getvipV_url(), 10, false);
                    this.aUT.setIsBigV(true);
                }
            } else {
                this.aUT.setIsBigV(false);
                if (this.aUV != null) {
                    this.aUV.setVisibility(8);
                }
            }
            this.aUT.setVisibility(0);
            this.aUS.setVisibility(8);
            this.aUT.setData(this.acX);
            this.aUT.setAfterClickListener(this.agO);
        } else {
            this.aUT.setIsBigV(false);
            if (this.aUV != null) {
                this.aUV.setVisibility(8);
            }
            this.aUT.setVisibility(4);
            this.aUS.setVisibility(0);
            this.aUS.setData(this.acX);
            this.aUS.setAfterClickListener(this.agO);
        }
        if (this.acX.getAuthor() != null && !StringUtils.isNull(this.acX.getAuthor().getSealPrefix())) {
            this.aUX.aO(true);
        }
        this.aUX.setData(this.acX);
        this.aUX.setUserAfterClickListener(this.agO);
        this.acX.sd();
        if (this.acX.getThreadType() == 50) {
            spannableStringBuilder = new SpannableStringBuilder(String.valueOf(this.Fp.getResources().getString(r.l.frs_live_play_backs)) + this.acX.rV().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.Fp.getResources().getColor(r.e.cp_link_tip_a)), 0, 6, 34);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(this.acX.rV().toString());
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.x(spannableStringBuilder));
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.aUW.a(this.acX)) {
            this.blT.setVisibility(8);
        } else {
            this.blT.setVisibility(0);
        }
        this.blW.setText(com.baidu.tbadk.core.util.at.cX(this.acX.rN().video_duration.intValue() * 1000));
        this.blX.setText(this.Fp.getPageActivity().getString(r.l.play_count, new Object[]{com.baidu.tbadk.core.util.at.u(this.acX.rN().play_count.intValue())}));
        this.aUW.setStType(com.baidu.tieba.card.at.Mt());
        this.aUW.setForumAfterClickListener(this.agt);
        this.aUW.setCommentNumClickListener(this);
        if (com.baidu.tieba.card.at.m13if(this.acX.getId())) {
            com.baidu.tbadk.core.util.ap.c(this.mTextTitle, r.e.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.ap.c(this.mTextTitle, r.e.cp_cont_b, 1);
        }
        setBarNameClickEnabled(true);
        s(this.acX);
        p.a(this.acX, this.blz);
        onChangeSkinType(this.Fp, TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void s(bh bhVar) {
        MetaData author;
        if (bhVar != null && (author = bhVar.getAuthor()) != null) {
            if (bhVar.sz() != null && bhVar.sz().channelId > 0) {
                this.bHZ.setVisibility(8);
                return;
            }
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rR = bhVar.rR();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aUT.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aUY.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bHZ.setVisibility(8);
                if (this.aUZ != null) {
                    if (rR != null) {
                        this.aUZ.a(this.Fp, rR, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bhVar.getFid()), bhVar.rB(), bhVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds16);
                    } else {
                        this.aUZ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds30);
                    }
                }
            } else {
                this.bHZ.setVisibility(0);
                this.bHZ.setImageBitmap(null);
                this.bHZ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bHZ.setOnClickListener(new g(this, themeCard));
                this.aUZ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds30);
            }
            this.aUT.setLayoutParams(layoutParams);
            this.aUY.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qm() {
        this.aNu.removeMessages(202);
        this.aNu.removeMessages(203);
    }

    private void QJ() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aNs);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bmi);
    }

    private void Rq() {
        QJ();
        Qm();
        if (this.blO != null && this.blN != null && this.blV != null) {
            if (com.baidu.tbadk.core.l.oC().oI() && this.acX != null && this.acX.rN() != null) {
                this.blN.setVisibility(0);
                this.blO.setDefaultBgResource(r.g.pic_bg_video_frs);
                this.blO.c(this.acX.rN().thumbnail_url, 10, false);
                stopPlay();
                this.aOm = this.acX.rN().video_url;
                if (StringUtils.isNull(this.aOm)) {
                    e(true, 4);
                }
                if (this.aNj != null && this.aNj.aYn() != null) {
                    this.aNj.aYn().c(this.acX.rN());
                    return;
                }
                return;
            }
            this.blN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.k(this.aUI, r.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.j(this.aVa, r.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.ap.c(this.blQ, r.g.btn_icon_play_video_n);
            com.baidu.tbadk.core.util.ap.i((View) this.blY, r.e.cp_cont_i);
            com.baidu.tbadk.core.util.ap.i((View) this.blW, r.e.cp_cont_g);
            com.baidu.tbadk.core.util.ap.i((View) this.blX, r.e.cp_cont_g);
            com.baidu.tbadk.core.util.ap.k(this.blZ, r.e.common_color_10014);
            if (this.blY != null) {
                this.blY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            if (this.blz != null) {
                this.blz.tg();
            }
            this.aUX.tg();
            this.aUW.tg();
            this.mSkinType = i;
            this.aUT.invalidate();
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aUW != null && this.blR != null) {
            this.aUW.h(bdUniqueId);
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public boolean isPlayStarted() {
        return this.aMk;
    }

    public boolean isPlaying() {
        if (this.blV == null) {
            return false;
        }
        return this.blV.isPlaying();
    }

    public void startPlay() {
        if (!this.aMk && this.acX != null && this.acX.rN() != null && this.blV != null && com.baidu.tbadk.util.w.p(2, this.aOm)) {
            e(true, 2);
            this.blV.setVideoPath(this.aOm);
            this.blV.start();
            this.blV.setLooping(true);
            if (this.aMl != null) {
                this.aMl.start();
            }
            this.aMk = true;
            JB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB() {
        if (this.acX != null && this.acX.rN() != null) {
            String str = this.acX.sp() ? "floor5" : "frs";
            com.baidu.tieba.play.bb bbVar = new com.baidu.tieba.play.bb();
            bbVar.mLocate = str;
            bbVar.bjS = this.acX.getTid();
            bbVar.bjT = new StringBuilder(String.valueOf(this.acX.getFid())).toString();
            bbVar.mUid = TbadkCoreApplication.getCurrentAccount();
            bbVar.mSource = this.acX.TW;
            bbVar.eTy = this.acX.TY;
            bbVar.eTz = this.acX.TX;
            bbVar.eTA = "";
            if (this.acX.sz() != null && this.acX.sz().channelId > 0) {
                bbVar.Ql = new StringBuilder(String.valueOf(this.acX.sz().channelId)).toString();
            } else {
                bbVar.Ql = "0";
            }
            com.baidu.tieba.play.ab.a(this.acX.rN().video_md5, "", "1", bbVar);
        }
    }

    public void stopPlay() {
        QJ();
        Qm();
        e(true, 1);
        if (this.blV != null) {
            this.blV.stopPlayback();
            if (this.aMl != null) {
                this.aMl.stop();
            }
        }
        this.aMk = false;
    }

    public View getVideoContainer() {
        return this.blN;
    }

    public String getPlayUrl() {
        return this.aOm;
    }

    public int getCurrentPosition() {
        if (this.blV == null) {
            return 0;
        }
        return this.blV.getCurrentPosition();
    }

    public void a(com.baidu.tieba.play.bb bbVar) {
        if (this.aNj != null) {
            this.aNj.a(bbVar);
        }
    }
}
