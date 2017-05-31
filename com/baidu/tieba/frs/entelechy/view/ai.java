package com.baidu.tieba.frs.entelechy.view;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.ax> {
    private TbPageContext<?> ajh;
    private int auT;
    private ArrayList<Integer> auU;
    private int avf;
    private int avg;
    private int avh;
    private int avi;
    private int avj;
    private int avk;
    private int avl;
    private int avm;
    private int avn;
    private int avo;
    private int avp;
    private CustomMessageListener bAA;
    private View.OnClickListener bBH;
    private View.OnClickListener bBI;
    private com.baidu.tbadk.core.data.ax bZE;
    public a bZF;
    private com.baidu.tieba.frs.f.ae bZq;

    public ai(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.auU = new ArrayList<>();
        this.auT = 0;
        this.bBH = new aj(this);
        this.bBI = new ak(this);
        this.bAA = new al(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        setTag(bdUniqueId);
        this.ajh = tbPageContext;
        this.avf = (int) tbPageContext.getResources().getDimension(w.f.ds80);
        this.avg = (int) tbPageContext.getResources().getDimension(w.f.ds280);
        this.avh = (int) tbPageContext.getResources().getDimension(w.f.ds170);
        this.avi = (int) tbPageContext.getResources().getDimension(w.f.ds320);
        this.avj = (int) tbPageContext.getResources().getDimension(w.f.ds200);
        this.avk = (int) tbPageContext.getResources().getDimension(w.f.ds60);
        this.avl = (int) tbPageContext.getResources().getDimension(w.f.ds120);
        this.avm = (int) tbPageContext.getResources().getDimension(w.f.ds160);
        this.avn = (int) tbPageContext.getResources().getDimension(w.f.ds220);
        this.avo = (int) tbPageContext.getResources().getDimension(w.f.ds240);
        this.avp = (int) tbPageContext.getResources().getDimension(w.f.ds180);
        N(getView());
        initUI();
    }

    private void N(View view) {
        this.bZF = new a();
        this.bZF.mRootView = view.findViewById(w.h.card_root_view);
        this.bZF.bZH = view.findViewById(w.h.top_line);
        this.bZF.bZI = (RelativeLayout) view.findViewById(w.h.live_card_content_root);
        this.bZF.bZK = (ClickableHeaderImageView) view.findViewById(w.h.avatar);
        this.bZF.bZJ = (HeadPendantClickableView) view.findViewById(w.h.pendant_avatar);
        this.bZF.alX = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bZF.bdK = (LinearLayout) view.findViewById(w.h.live_card_content_layout);
        this.bZF.bBA = (UserIconLayout) view.findViewById(w.h.user_icon);
        this.bZF.bzn = (TextView) view.findViewById(w.h.thread_title);
        this.bZF.bZL = (TextView) view.findViewById(w.h.thread_context);
        this.bZF.bZM = (TextView) view.findViewById(w.h.fans_num);
        this.bZF.bBL = (TbImageView) view.findViewById(w.h.thread_image);
        this.bZF.bBL.setPageId(getTag());
        this.bZF.bZN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.thread_more_info);
        this.bZF.bBN = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bZF.bZO = (TextView) view.findViewById(w.h.first_style_first_expression);
        this.bZF.bZP = (TextView) view.findViewById(w.h.first_style_second_expression);
        this.bZF.bZQ = (TextView) view.findViewById(w.h.first_style_third_expression);
        this.bZF.bVW = (TbImageView) view.findViewById(w.h.frs_live_item_theme_card);
        this.bZF.bVW.setPageId(getTag());
        this.bZF.bdL = (ThreadSkinView) view.findViewById(w.h.frs_live_skin);
        this.bZF.bZN.setCommentNumClickListener(this);
        this.bZF.bAn = (CardGroupDividerView) view.findViewById(w.h.header_divider);
        this.bZF.bAn.setTitleClickListener(this);
        this.bZF.bZN.setViewNumEnabled(true);
        this.bZq = new com.baidu.tieba.frs.f.ae(this.ajh, this.bZF.bZN);
        this.bZq.setUniqueId(getTag());
    }

    private void initUI() {
        this.bZF.bZK.setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        this.bZF.bZK.setDefaultResource(17170445);
        this.bZF.bZK.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bZF.bZK.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bZF.bZJ.vV();
        this.bZF.bZJ.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        this.bZF.bZJ.getHeadView().setDefaultResource(17170445);
        this.bZF.bZJ.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bZF.bZJ.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        this.bZF.bZJ.getHeadView().setIsRound(true);
        this.bZF.bZJ.getHeadView().setDrawBorder(false);
        this.bZF.bZJ.getPendantView().setIsRound(true);
        this.bZF.bZJ.getPendantView().setDrawBorder(false);
        this.bZF.bZN.setShowPraiseNum(false);
        this.bZF.bBL.setDrawBorder(true);
        this.bZF.bBL.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tbadk.core.data.ax axVar) {
        this.bZE = axVar;
        MU();
    }

    private void MU() {
        boolean z;
        if (this.bZE == null) {
            this.bZF.mRootView.setVisibility(8);
            return;
        }
        if (this.bZE.getAuthor() == null || this.bZE.getAuthor().getPendantData() == null || StringUtils.isNull(this.bZE.getAuthor().getPendantData().pL())) {
            if (this.bZE.getAuthor() != null && this.bZE.getAuthor().getGodUserData() != null && this.bZE.getAuthor().getGodUserData().getType() == 2) {
                this.bZF.bZK.setGodIconMargin(0);
            } else {
                this.bZF.bZK.setIsGod(false);
            }
            UserTbVipInfoData rv = this.bZE.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.bZF.alX != null) {
                    if (this.bZF.alY == null) {
                        this.bZF.alX.inflate();
                        this.bZF.alY = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bZF.alY.setPageId(getTag());
                    this.bZF.alY.setVisibility(0);
                    this.bZF.alY.c(rv.getvipV_url(), 10, false);
                    this.bZF.bZK.setIsBigV(true);
                }
            } else {
                this.bZF.bZK.setIsBigV(false);
                if (this.bZF.alY != null) {
                    this.bZF.alY.setVisibility(8);
                }
            }
            this.bZF.bZK.setData(this.bZE);
            this.bZF.bZK.setAfterClickListener(this.bBH);
            this.bZF.bZK.setVisibility(0);
            this.bZF.bZJ.setVisibility(8);
        } else {
            this.bZF.bZK.setIsGod(false);
            this.bZF.bZK.setIsBigV(false);
            if (this.bZF.alY != null) {
                this.bZF.alY.setVisibility(8);
            }
            this.bZF.bZK.setVisibility(4);
            this.bZF.bZJ.setVisibility(0);
            this.bZF.bZJ.setData(this.bZE);
        }
        if (this.bZE.getAuthor() != null && !StringUtils.isNull(this.bZE.getAuthor().getSealPrefix())) {
            this.bZF.bBA.aN(true);
        }
        this.bZF.bBA.setData(this.bZE);
        this.bZF.bBA.setUserNameTextSizeRid(w.f.fontsize24);
        this.bZF.bBA.setUserAfterClickListener(this.bBH);
        this.bZF.bBA.setPageName(1);
        Resources resources = this.ajh.getResources();
        if (!StringUtils.isNull(this.bZE.getTitle())) {
            int length = this.bZE.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bZE.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bZF.bzn.setSingleLine(true);
        } else {
            this.bZF.bzn.setMaxLines(2);
        }
        this.bZE.e(false, true);
        this.bZF.bzn.setText(this.bZE.rU());
        String fansNickName = this.bZE.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(w.l.fans_default_name);
        }
        this.bZF.bZM.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.au.t(this.bZE.getAuthor().getFansNum()));
        if (this.bZF.bZN.a(this.bZE)) {
            this.bZF.bBN.setVisibility(8);
        } else {
            this.bZF.bBN.setVisibility(0);
        }
        this.bZF.bZN.setForumAfterClickListener(this.bBI);
        this.bZF.bZN.setStType(com.baidu.tieba.card.at.rl());
        B(this.bZE);
        this.bZq.K(this.bZE);
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.r.oN().oT() && this.bZE.getPhotoLiveCover() != null && this.bZE.getPhotoLiveCover().length() != 0) {
            this.bZF.bBL.setVisibility(0);
            this.bZF.bZL.setVisibility(8);
            this.bZF.bBL.c(this.bZE.getPhotoLiveCover(), 10, false);
            b(this.bZE);
        } else {
            this.bZF.bBL.setVisibility(8);
            this.bZF.bZO.setVisibility(8);
            this.bZF.bZP.setVisibility(8);
            this.bZF.bZQ.setVisibility(8);
            String rC = this.bZE.rC();
            this.bZF.bZL.setText(rC);
            this.bZF.bZL.setVisibility(StringUtils.isNull(rC) ? 8 : 0);
        }
        p.a(this.bZE, this.bZF.bAn);
        com.baidu.tbadk.core.util.aq.c(this.bZF.bZM, w.e.cp_cont_d, 1);
        if (com.baidu.tieba.card.at.ic(this.bZE.getTid())) {
            com.baidu.tbadk.core.util.aq.c(this.bZF.bzn, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.bZF.bZL, w.e.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.aq.c(this.bZF.bzn, w.e.cp_cont_b, 1);
        com.baidu.tbadk.core.util.aq.c(this.bZF.bZL, w.e.cp_cont_j, 1);
    }

    private void B(bl blVar) {
        MetaData author;
        if (blVar != null && (author = blVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rP = blVar.rP();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bZF.bZK.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bZF.bdK.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bZF.bVW.setVisibility(8);
                if (this.bZF.bdL != null) {
                    if (rP != null) {
                        this.bZF.bdL.a(this.ajh, rP, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rz(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds16);
                    } else {
                        this.bZF.bdL.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds30);
                    }
                }
            } else {
                this.bZF.bVW.setVisibility(0);
                this.bZF.bVW.setImageBitmap(null);
                this.bZF.bVW.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bZF.bVW.setOnClickListener(new am(this, themeCard));
                this.bZF.bdL.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds30);
            }
            this.bZF.bZK.setLayoutParams(layoutParams);
            this.bZF.bdK.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bZF != null) {
            if (view == this.bZF.mRootView || view == this.bZF.bZN.getCommentNumView() || view == this.bZF.bAn) {
                if (Ud() != null) {
                    Ud().a(this.bZF.mRootView, this.bZE);
                }
                Ut();
            }
        }
    }

    private void Ut() {
        PhotoLiveActivityConfig pd;
        if (this.bZE != null) {
            com.baidu.tieba.card.at.ib(this.bZE.getTid());
            if (!Uu()) {
                UtilHelper.showToast(this.ajh.getPageActivity(), w.l.plugin_config_not_found);
                return;
            }
            if (this.bZE.rQ() > 0 && com.baidu.tieba.tbadkCore.util.s.bje()) {
                pd = new PhotoLiveActivityConfig.a(this.ajh.getPageActivity(), this.bZE.getTid()).ck("from_frs").bA(18003).ci(String.valueOf(this.bZE.rQ())).pd();
            } else {
                pd = new PhotoLiveActivityConfig.a(this.ajh.getPageActivity(), this.bZE.getTid()).ck("from_frs").bA(18003).pd();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pd));
            id(this.bZE.getTid());
        }
    }

    public void id(String str) {
        new Handler().postDelayed(new an(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, this.bZF.mRootView);
            this.bZF.bBA.onChangeSkinType();
            this.bZF.bZN.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.k(this.bZF.bZH, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.j(this.bZF.mRootView, w.g.addresslist_item_bg);
            if (this.bZF.bAn != null) {
                this.bZF.bAn.onChangeSkinType();
            }
            this.bZq.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean Uu() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bAA != null) {
            this.bAA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bAA);
        }
    }

    private void b(com.baidu.tbadk.core.data.ax axVar) {
        this.auU.clear();
        AO();
        if (axVar != null && axVar.rN() != null) {
            int size = axVar.rN().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = axVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, axVar.rN(), i);
                }
            }
            AN();
        }
    }

    private void AO() {
        this.bZF.bZO.setText("");
        this.bZF.bZP.setText("");
        this.bZF.bZQ.setText("");
        if (this.bZF.bZO.getVisibility() == 8) {
            this.bZF.bZO.setVisibility(0);
        }
        if (this.bZF.bZP.getVisibility() == 8) {
            this.bZF.bZP.setVisibility(0);
        }
        if (this.bZF.bZQ.getVisibility() == 8) {
            this.bZF.bZQ.setVisibility(0);
        }
        this.auU.add(Integer.valueOf(this.bZF.bZO.getId()));
        this.auU.add(Integer.valueOf(this.bZF.bZP.getId()));
        this.auU.add(Integer.valueOf(this.bZF.bZQ.getId()));
    }

    private void AN() {
        if (this.auU.size() != 0) {
            int size = this.auU.size();
            for (int i = 0; i < size; i++) {
                if (this.auU.get(i).intValue() == this.bZF.bZO.getId()) {
                    this.bZF.bZO.setVisibility(8);
                } else if (this.auU.get(i).intValue() == this.bZF.bZP.getId()) {
                    this.bZF.bZP.setVisibility(8);
                } else if (this.auU.get(i).intValue() == this.bZF.bZQ.getId()) {
                    this.bZF.bZQ.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.auT) {
                case 0:
                    a(this.avf, this.avg, this.bZF.bZO);
                    a(this.avh, this.avi, this.bZF.bZP);
                    a(this.avj, this.avk, this.bZF.bZQ);
                    break;
                case 1:
                    a(this.avk, this.avl, this.bZF.bZO);
                    a(this.avm, this.avk, this.bZF.bZP);
                    a(this.avn, this.avi, this.bZF.bZQ);
                    break;
                case 2:
                    a(this.avk, this.avo, this.bZF.bZO);
                    a(this.avp, this.avk, this.bZF.bZP);
                    a(this.avn, this.avi, this.bZF.bZQ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bZF.bZO);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bZF.bZP);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bZF.bZQ);
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.view.n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AA())));
            eh(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private boolean a(com.baidu.tbadk.coreExtra.view.n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void eh(int i) {
        if (this.auU.size() != 0) {
            int size = this.auU.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.auU.get(i2).intValue() == i) {
                    this.auU.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub alX;
        public TbImageView alY;
        public CardGroupDividerView bAn;
        public UserIconLayout bBA;
        public TbImageView bBL;
        public View bBN;
        public TbImageView bVW;
        public View bZH;
        public RelativeLayout bZI;
        public HeadPendantClickableView bZJ;
        public ClickableHeaderImageView bZK;
        public TextView bZL;
        public TextView bZM;
        public ThreadCommentAndPraiseInfoLayout bZN;
        public TextView bZO;
        public TextView bZP;
        public TextView bZQ;
        public LinearLayout bdK;
        public ThreadSkinView bdL;
        public TextView bzn;
        public View mRootView;

        public a() {
        }
    }
}
