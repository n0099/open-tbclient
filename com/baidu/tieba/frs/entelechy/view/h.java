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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<ax> {
    private int ayA;
    private int ayB;
    private int ayC;
    private int ayg;
    private ArrayList<Integer> ayh;
    private int ays;
    private int ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;
    private int ayy;
    private int ayz;
    private CustomMessageListener bHt;
    private View.OnClickListener bIA;
    private View.OnClickListener bIB;
    private ax cpD;
    public a cpE;
    private com.baidu.tieba.frs.g.g cpp;
    private TbPageContext<?> oV;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ayh = new ArrayList<>();
        this.ayg = 0;
        this.bIA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.WA() != null) {
                    h.this.WA().a(view, h.this.cpD);
                }
            }
        };
        this.bIB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.WA() != null) {
                    h.this.WA().a(view, h.this.cpD);
                }
            }
        };
        this.bHt = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cpD != null && h.this.cpD != null && h.this.cpD.getTid() != null && h.this.cpE != null && h.this.cpE.bGg != null && h.this.cpE.cpL != null && ((String) customResponsedMessage.getData()).equals(h.this.cpD.getTid())) {
                    m.a(h.this.cpE.bGg, h.this.cpD.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                    m.a(h.this.cpE.cpL, h.this.cpD.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.oV = tbPageContext;
        this.ays = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        this.ayt = (int) tbPageContext.getResources().getDimension(d.f.ds280);
        this.ayu = (int) tbPageContext.getResources().getDimension(d.f.ds170);
        this.ayv = (int) tbPageContext.getResources().getDimension(d.f.ds320);
        this.ayw = (int) tbPageContext.getResources().getDimension(d.f.ds200);
        this.ayx = (int) tbPageContext.getResources().getDimension(d.f.ds60);
        this.ayy = (int) tbPageContext.getResources().getDimension(d.f.ds120);
        this.ayz = (int) tbPageContext.getResources().getDimension(d.f.ds160);
        this.ayA = (int) tbPageContext.getResources().getDimension(d.f.ds220);
        this.ayB = (int) tbPageContext.getResources().getDimension(d.f.ds240);
        this.ayC = (int) tbPageContext.getResources().getDimension(d.f.ds180);
        P(getView());
        initUI();
    }

    private void P(View view) {
        this.cpE = new a();
        this.cpE.mRootView = view.findViewById(d.h.card_root_view);
        this.cpE.cpG = view.findViewById(d.h.top_line);
        this.cpE.cpH = (RelativeLayout) view.findViewById(d.h.live_card_content_root);
        this.cpE.cpJ = (ClickableHeaderImageView) view.findViewById(d.h.avatar);
        this.cpE.cpI = (HeadPendantClickableView) view.findViewById(d.h.pendant_avatar);
        this.cpE.aoU = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.cpE.blh = (LinearLayout) view.findViewById(d.h.live_card_content_layout);
        this.cpE.bIt = (UserIconLayout) view.findViewById(d.h.user_icon);
        this.cpE.bGg = (TextView) view.findViewById(d.h.thread_title);
        this.cpE.cpK = (TextView) view.findViewById(d.h.thread_context);
        this.cpE.cpL = (TextView) view.findViewById(d.h.fans_num);
        this.cpE.bIE = (TbImageView) view.findViewById(d.h.thread_image);
        this.cpE.bIE.setPageId(getTag());
        this.cpE.cpM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.thread_more_info);
        this.cpE.bIG = view.findViewById(d.h.divider_below_reply_number_layout);
        this.cpE.cpN = (TextView) view.findViewById(d.h.first_style_first_expression);
        this.cpE.cpO = (TextView) view.findViewById(d.h.first_style_second_expression);
        this.cpE.cpP = (TextView) view.findViewById(d.h.first_style_third_expression);
        this.cpE.clJ = (TbImageView) view.findViewById(d.h.frs_live_item_theme_card);
        this.cpE.clJ.setPageId(getTag());
        this.cpE.bli = (ThreadSkinView) view.findViewById(d.h.frs_live_skin);
        this.cpE.cpM.setCommentNumClickListener(this);
        this.cpE.bHg = (CardGroupDividerView) view.findViewById(d.h.header_divider);
        this.cpE.bHg.setTitleClickListener(this);
        this.cpE.cpM.setViewNumEnabled(true);
        this.cpp = new com.baidu.tieba.frs.g.g(this.oV, this.cpE.cpM);
        this.cpp.setUniqueId(getTag());
    }

    private void initUI() {
        this.cpE.cpJ.setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        this.cpE.cpJ.setDefaultResource(17170445);
        this.cpE.cpJ.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cpE.cpJ.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cpE.cpI.wD();
        this.cpE.cpI.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        this.cpE.cpI.getHeadView().setDefaultResource(17170445);
        this.cpE.cpI.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cpE.cpI.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        this.cpE.cpI.getHeadView().setIsRound(true);
        this.cpE.cpI.getHeadView().setDrawBorder(false);
        this.cpE.cpI.getPendantView().setIsRound(true);
        this.cpE.cpI.getPendantView().setDrawBorder(false);
        this.cpE.cpM.setShowPraiseNum(false);
        this.cpE.bIE.setDrawBorder(true);
        this.cpE.bIE.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ax axVar) {
        this.cpD = axVar;
        Oy();
    }

    private void Oy() {
        boolean z;
        if (this.cpD == null) {
            this.cpE.mRootView.setVisibility(8);
            return;
        }
        if (this.cpD.getAuthor() == null || this.cpD.getAuthor().getPendantData() == null || StringUtils.isNull(this.cpD.getAuthor().getPendantData().pV())) {
            if (this.cpD.getAuthor() != null && this.cpD.getAuthor().getGodUserData() != null && this.cpD.getAuthor().getGodUserData().getType() == 2) {
                this.cpE.cpJ.setGodIconMargin(0);
            } else {
                this.cpE.cpJ.setIsGod(false);
            }
            UserTbVipInfoData rF = this.cpD.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.cpE.aoU != null) {
                    if (this.cpE.aoV == null) {
                        this.cpE.aoU.inflate();
                        this.cpE.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.cpE.aoV.setPageId(getTag());
                    this.cpE.aoV.setVisibility(0);
                    this.cpE.aoV.c(rF.getvipV_url(), 10, false);
                    this.cpE.cpJ.setIsBigV(true);
                }
            } else {
                this.cpE.cpJ.setIsBigV(false);
                if (this.cpE.aoV != null) {
                    this.cpE.aoV.setVisibility(8);
                }
            }
            this.cpE.cpJ.setData(this.cpD);
            this.cpE.cpJ.setAfterClickListener(this.bIA);
            this.cpE.cpJ.setVisibility(0);
            this.cpE.cpI.setVisibility(8);
        } else {
            this.cpE.cpJ.setIsGod(false);
            this.cpE.cpJ.setIsBigV(false);
            if (this.cpE.aoV != null) {
                this.cpE.aoV.setVisibility(8);
            }
            this.cpE.cpJ.setVisibility(4);
            this.cpE.cpI.setVisibility(0);
            this.cpE.cpI.setData(this.cpD);
        }
        if (this.cpD.getAuthor() != null && !StringUtils.isNull(this.cpD.getAuthor().getSealPrefix())) {
            this.cpE.bIt.aP(true);
        }
        this.cpE.bIt.setData(this.cpD);
        this.cpE.bIt.setUserNameTextSizeRid(d.f.fontsize24);
        this.cpE.bIt.setUserAfterClickListener(this.bIA);
        this.cpE.bIt.setPageName(1);
        Resources resources = this.oV.getResources();
        if (!StringUtils.isNull(this.cpD.getTitle())) {
            int length = this.cpD.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cpD.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cpE.bGg.setSingleLine(true);
        } else {
            this.cpE.bGg.setMaxLines(2);
        }
        this.cpD.e(false, true);
        this.cpE.bGg.setText(this.cpD.sf());
        String fansNickName = this.cpD.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.l.fans_default_name);
        }
        this.cpE.cpL.setText(fansNickName + ": " + al.u(this.cpD.getAuthor().getFansNum()));
        if (this.cpE.cpM.a(this.cpD)) {
            this.cpE.bIG.setVisibility(8);
        } else {
            this.cpE.bIG.setVisibility(0);
        }
        this.cpE.cpM.setForumAfterClickListener(this.bIB);
        this.cpE.cpM.setStType(m.rw());
        G(this.cpD);
        this.cpp.P(this.cpD);
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oX().pd() && this.cpD.getPhotoLiveCover() != null && this.cpD.getPhotoLiveCover().length() != 0) {
            this.cpE.bIE.setVisibility(0);
            this.cpE.cpK.setVisibility(8);
            this.cpE.bIE.c(this.cpD.getPhotoLiveCover(), 10, false);
            b(this.cpD);
        } else {
            this.cpE.bIE.setVisibility(8);
            this.cpE.cpN.setVisibility(8);
            this.cpE.cpO.setVisibility(8);
            this.cpE.cpP.setVisibility(8);
            String rN = this.cpD.rN();
            this.cpE.cpK.setText(rN);
            this.cpE.cpK.setVisibility(StringUtils.isNull(rN) ? 8 : 0);
        }
        b.a(this.cpD, this.cpE.bHg);
        ai.c(this.cpE.cpL, d.e.cp_cont_d, 1);
        if (m.jf(this.cpD.getTid())) {
            ai.c(this.cpE.bGg, d.e.cp_cont_d, 1);
            ai.c(this.cpE.cpK, d.e.cp_cont_d, 1);
            return;
        }
        ai.c(this.cpE.bGg, d.e.cp_cont_b, 1);
        ai.c(this.cpE.cpK, d.e.cp_cont_j, 1);
    }

    private void G(bl blVar) {
        MetaData author;
        if (blVar != null && (author = blVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo sa = blVar.sa();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cpE.cpJ.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cpE.blh.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cpE.clJ.setVisibility(8);
                if (this.cpE.bli != null) {
                    if (sa != null) {
                        this.cpE.bli.a(this.oV, sa, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(blVar.getFid()), blVar.rK(), blVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds16);
                    } else {
                        this.cpE.bli.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds30);
                    }
                }
            } else {
                this.cpE.clJ.setVisibility(0);
                this.cpE.clJ.setImageBitmap(null);
                this.cpE.clJ.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cpE.clJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.oV.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cpE.bli.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds30);
            }
            this.cpE.cpJ.setLayoutParams(layoutParams);
            this.cpE.blh.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cpE != null) {
            if (view == this.cpE.mRootView || view == this.cpE.cpM.getCommentNumView() || view == this.cpE.bHg) {
                if (WA() != null) {
                    WA().a(this.cpE.mRootView, this.cpD);
                }
                WS();
            }
        }
    }

    private void WS() {
        PhotoLiveActivityConfig pn;
        if (this.cpD != null) {
            m.je(this.cpD.getTid());
            if (!WT()) {
                UtilHelper.showToast(this.oV.getPageActivity(), d.l.plugin_config_not_found);
                return;
            }
            if (this.cpD.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.bue()) {
                pn = new PhotoLiveActivityConfig.a(this.oV.getPageActivity(), this.cpD.getTid()).cB("from_frs").bB(18003).cz(String.valueOf(this.cpD.sb())).pn();
            } else {
                pn = new PhotoLiveActivityConfig.a(this.oV.getPageActivity(), this.cpD.getTid()).cB("from_frs").bB(18003).pn();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pn));
            jg(this.cpD.getTid());
        }
    }

    public void jg(final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, str));
            }
        }, 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.o.a.a(tbPageContext, this.cpE.mRootView);
            this.cpE.bIt.onChangeSkinType();
            this.cpE.cpM.onChangeSkinType();
            ai.k(this.cpE.cpG, d.e.cp_bg_line_c);
            ai.j(this.cpE.mRootView, d.g.addresslist_item_bg);
            if (this.cpE.bHg != null) {
                this.cpE.bHg.onChangeSkinType();
            }
            this.cpp.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean WT() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bHt != null) {
            this.bHt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHt);
        }
    }

    private void b(ax axVar) {
        this.ayh.clear();
        BC();
        if (axVar != null && axVar.rY() != null) {
            int size = axVar.rY().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = axVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, axVar.rY(), i);
                }
            }
            BB();
        }
    }

    private void BC() {
        this.cpE.cpN.setText("");
        this.cpE.cpO.setText("");
        this.cpE.cpP.setText("");
        if (this.cpE.cpN.getVisibility() == 8) {
            this.cpE.cpN.setVisibility(0);
        }
        if (this.cpE.cpO.getVisibility() == 8) {
            this.cpE.cpO.setVisibility(0);
        }
        if (this.cpE.cpP.getVisibility() == 8) {
            this.cpE.cpP.setVisibility(0);
        }
        this.ayh.add(Integer.valueOf(this.cpE.cpN.getId()));
        this.ayh.add(Integer.valueOf(this.cpE.cpO.getId()));
        this.ayh.add(Integer.valueOf(this.cpE.cpP.getId()));
    }

    private void BB() {
        if (this.ayh.size() != 0) {
            int size = this.ayh.size();
            for (int i = 0; i < size; i++) {
                if (this.ayh.get(i).intValue() == this.cpE.cpN.getId()) {
                    this.cpE.cpN.setVisibility(8);
                } else if (this.ayh.get(i).intValue() == this.cpE.cpO.getId()) {
                    this.cpE.cpO.setVisibility(8);
                } else if (this.ayh.get(i).intValue() == this.cpE.cpP.getId()) {
                    this.cpE.cpP.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.ayg) {
                case 0:
                    a(this.ays, this.ayt, this.cpE.cpN);
                    a(this.ayu, this.ayv, this.cpE.cpO);
                    a(this.ayw, this.ayx, this.cpE.cpP);
                    break;
                case 1:
                    a(this.ayx, this.ayy, this.cpE.cpN);
                    a(this.ayz, this.ayx, this.cpE.cpO);
                    a(this.ayA, this.ayv, this.cpE.cpP);
                    break;
                case 2:
                    a(this.ayx, this.ayB, this.cpE.cpN);
                    a(this.ayC, this.ayx, this.cpE.cpO);
                    a(this.ayA, this.ayv, this.cpE.cpP);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cpE.cpN);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cpE.cpO);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cpE.cpP);
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.view.e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ai(eVar.getLabelName(), String.valueOf(eVar.Bo())));
            en(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private boolean a(com.baidu.tbadk.coreExtra.view.e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void en(int i) {
        if (this.ayh.size() != 0) {
            int size = this.ayh.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayh.get(i2).intValue() == i) {
                    this.ayh.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aoU;
        public TbImageView aoV;
        public TextView bGg;
        public CardGroupDividerView bHg;
        public TbImageView bIE;
        public View bIG;
        public UserIconLayout bIt;
        public LinearLayout blh;
        public ThreadSkinView bli;
        public TbImageView clJ;
        public View cpG;
        public RelativeLayout cpH;
        public HeadPendantClickableView cpI;
        public ClickableHeaderImageView cpJ;
        public TextView cpK;
        public TextView cpL;
        public ThreadCommentAndPraiseInfoLayout cpM;
        public TextView cpN;
        public TextView cpO;
        public TextView cpP;
        public View mRootView;

        public a() {
        }
    }
}
