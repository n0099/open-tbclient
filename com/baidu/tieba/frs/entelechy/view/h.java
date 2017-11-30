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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<ar> {
    private int axF;
    private int axG;
    private int axH;
    private int axI;
    private int axJ;
    private int axK;
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private int axP;
    private int axt;
    private ArrayList<Integer> axu;
    private com.baidu.tieba.frs.g.g cOH;
    private ar cPc;
    public a cPd;
    private View.OnClickListener caU;
    private View.OnClickListener caV;
    private CustomMessageListener cab;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.axu = new ArrayList<>();
        this.axt = 0;
        this.caU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.abs() != null) {
                    h.this.abs().a(view, h.this.cPc);
                }
            }
        };
        this.caV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.abs() != null) {
                    h.this.abs().a(view, h.this.cPc);
                }
            }
        };
        this.cab = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cPc != null && h.this.cPc != null && h.this.cPc.getTid() != null && h.this.cPd != null && h.this.cPd.bZQ != null && h.this.cPd.cPk != null && ((String) customResponsedMessage.getData()).equals(h.this.cPc.getTid())) {
                    com.baidu.tieba.card.k.a(h.this.cPd.bZQ, h.this.cPc.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
                    com.baidu.tieba.card.k.a(h.this.cPd.cPk, h.this.cPc.getId(), d.C0082d.cp_cont_j, d.C0082d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.axF = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.axG = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.axH = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.axI = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.axJ = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.axK = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.axL = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.axM = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.axN = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.axO = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.axP = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        aa(getView());
        initUI();
    }

    private void aa(View view) {
        this.cPd = new a();
        this.cPd.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.cPd.cPf = view.findViewById(d.g.top_line);
        this.cPd.cPg = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.cPd.cPi = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.cPd.cPh = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.cPd.anY = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.cPd.bvK = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.cPd.cOS = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.cPd.bZQ = (TextView) view.findViewById(d.g.thread_title);
        this.cPd.cPj = (TextView) view.findViewById(d.g.thread_context);
        this.cPd.cPk = (TextView) view.findViewById(d.g.fans_num);
        this.cPd.caY = (TbImageView) view.findViewById(d.g.thread_image);
        this.cPd.caY.setPageId(getTag());
        this.cPd.cPl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.cPd.cba = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cPd.cPm = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.cPd.cPn = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.cPd.cPo = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.cPd.ccC = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.cPd.ccC.setPageId(getTag());
        this.cPd.bvL = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.cPd.bZJ = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cPd.bZJ.setTitleClickListener(this);
        this.cOH = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cPd.mRootView);
        this.cOH.setUniqueId(getTag());
    }

    private void initUI() {
        this.cPd.cPi.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cPd.cPi.setDefaultResource(17170445);
        this.cPd.cPi.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPd.cPi.setDefaultBgResource(d.C0082d.cp_bg_line_e);
        this.cPd.cPh.wk();
        this.cPd.cPh.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cPd.cPh.getHeadView().setDefaultResource(17170445);
        this.cPd.cPh.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPd.cPh.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
        this.cPd.cPh.getHeadView().setIsRound(true);
        this.cPd.cPh.getHeadView().setDrawBorder(false);
        this.cPd.cPh.getPendantView().setIsRound(true);
        this.cPd.cPh.getPendantView().setDrawBorder(false);
        this.cPd.cPl.setShowPraiseNum(false);
        this.cPd.cPl.setFrom(2);
        this.cPd.caY.setDrawBorder(true);
        this.cPd.caY.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.cPc = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cPc == null) {
            this.cPd.mRootView.setVisibility(8);
            return;
        }
        if (this.cPc.rx() == null || this.cPc.rx().getPendantData() == null || StringUtils.isNull(this.cPc.rx().getPendantData().pT())) {
            if (this.cPc.rx() != null && this.cPc.rx().getGodUserData() != null && this.cPc.rx().getGodUserData().getType() == 2) {
                this.cPd.cPi.setGodIconMargin(0);
            } else {
                this.cPd.cPi.setIsGod(false);
            }
            UserTbVipInfoData ry = this.cPc.ry();
            if (ry != null && ry.getvipV_url() != null) {
                if (this.cPd.anY != null) {
                    if (this.cPd.anZ == null) {
                        this.cPd.anY.inflate();
                        this.cPd.anZ = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.cPd.anZ.setPageId(getTag());
                    this.cPd.anZ.setVisibility(0);
                    this.cPd.anZ.startLoad(ry.getvipV_url(), 10, false);
                    this.cPd.cPi.setIsBigV(true);
                }
            } else {
                this.cPd.cPi.setIsBigV(false);
                if (this.cPd.anZ != null) {
                    this.cPd.anZ.setVisibility(8);
                }
            }
            this.cPd.cPi.setData(this.cPc);
            this.cPd.cPi.setAfterClickListener(this.caU);
            this.cPd.cPi.setVisibility(0);
            this.cPd.cPh.setVisibility(8);
        } else {
            this.cPd.cPi.setIsGod(false);
            this.cPd.cPi.setIsBigV(false);
            if (this.cPd.anZ != null) {
                this.cPd.anZ.setVisibility(8);
            }
            this.cPd.cPi.setVisibility(4);
            this.cPd.cPh.setVisibility(0);
            this.cPd.cPh.setData(this.cPc);
        }
        if (this.cPc.rx() != null && !StringUtils.isNull(this.cPc.rx().getSealPrefix())) {
            this.cPd.cOS.aL(true);
        }
        this.cPd.cOS.setData(this.cPc);
        this.cPd.cOS.setUserNameTextSizeRid(d.e.fontsize24);
        this.cPd.cOS.setUserAfterClickListener(this.caU);
        this.cPd.cOS.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.cPc.getTitle())) {
            int length = this.cPc.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cPc.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cPd.bZQ.setSingleLine(true);
        } else {
            this.cPd.bZQ.setMaxLines(2);
        }
        this.cPc.e(false, true);
        this.cPd.bZQ.setText(this.cPc.rX());
        String fansNickName = this.cPc.rx().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.cPd.cPk.setText(fansNickName + ": " + am.u(this.cPc.rx().getFansNum()));
        if (this.cPd.cPl.setData(this.cPc)) {
            this.cPd.cba.setVisibility(8);
        } else {
            this.cPd.cba.setVisibility(0);
        }
        this.cPd.cPl.setForumAfterClickListener(this.caV);
        this.cPd.cPl.setStType("frs_page");
        B(this.cPc);
        this.cOH.S(this.cPc);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.pa().pg() && this.cPc.getPhotoLiveCover() != null && this.cPc.getPhotoLiveCover().length() != 0) {
            this.cPd.caY.setVisibility(0);
            this.cPd.cPj.setVisibility(8);
            this.cPd.caY.startLoad(this.cPc.getPhotoLiveCover(), 10, false);
            b(this.cPc);
        } else {
            this.cPd.caY.setVisibility(8);
            this.cPd.cPm.setVisibility(8);
            this.cPd.cPn.setVisibility(8);
            this.cPd.cPo.setVisibility(8);
            String str = this.cPc.getAbstract();
            this.cPd.cPj.setText(str);
            this.cPd.cPj.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.cPc, this.cPd.bZJ);
        aj.c(this.cPd.cPk, d.C0082d.cp_cont_d, 1);
        if (com.baidu.tieba.card.k.jR(this.cPc.getTid())) {
            aj.c(this.cPd.bZQ, d.C0082d.cp_cont_d, 1);
            aj.c(this.cPd.cPj, d.C0082d.cp_cont_d, 1);
            return;
        }
        aj.c(this.cPd.bZQ, d.C0082d.cp_cont_b, 1);
        aj.c(this.cPd.cPj, d.C0082d.cp_cont_j, 1);
    }

    private void B(bd bdVar) {
        MetaData rx;
        if (bdVar != null && (rx = bdVar.rx()) != null) {
            final ThemeCardInUserData themeCard = rx.getThemeCard();
            SkinInfo rT = bdVar.rT();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPd.cPi.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cPd.bvK.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cPd.ccC.setVisibility(8);
                if (this.cPd.bvL != null) {
                    if (rT != null) {
                        this.cPd.bvL.a(this.mPageContext, rT, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.rD(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cPd.bvL.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cPd.ccC.setVisibility(0);
                this.cPd.ccC.setImageBitmap(null);
                this.cPd.ccC.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cPd.ccC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cPd.bvL.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.cPd.cPi.setLayoutParams(layoutParams);
            this.cPd.bvK.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cPd != null) {
            if (view == this.cPd.mRootView || view == this.cPd.cPl.getCommentNumView() || view == this.cPd.bZJ) {
                if (abs() != null) {
                    abs().a(this.cPd.mRootView, this.cPc);
                }
                abM();
            }
        }
    }

    private void abM() {
        PhotoLiveActivityConfig pp;
        if (this.cPc != null) {
            com.baidu.tieba.card.k.jQ(this.cPc.getTid());
            if (!abN()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.cPc.rU() > 0 && com.baidu.tieba.tbadkCore.util.f.bxo()) {
                pp = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cPc.getTid()).cz("from_frs").bD(18003).cx(String.valueOf(this.cPc.rU())).pp();
            } else {
                pp = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cPc.getTid()).cz("from_frs").bD(18003).pp();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pp));
            jS(this.cPc.getTid());
        }
    }

    public void jS(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cPd.mRootView);
            this.cPd.cOS.onChangeSkinType();
            this.cPd.cPl.onChangeSkinType();
            aj.k(this.cPd.cPf, d.C0082d.cp_bg_line_c);
            aj.j(this.cPd.mRootView, d.f.addresslist_item_bg);
            if (this.cPd.bZJ != null) {
                this.cPd.bZJ.onChangeSkinType();
            }
            this.cOH.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean abN() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cab != null) {
            this.cab.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cab);
        }
    }

    private void b(ar arVar) {
        this.axu.clear();
        Bu();
        if (arVar != null && arVar.rR() != null) {
            int size = arVar.rR().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = arVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, arVar.rR(), i);
                }
            }
            Bt();
        }
    }

    private void Bu() {
        this.cPd.cPm.setText("");
        this.cPd.cPn.setText("");
        this.cPd.cPo.setText("");
        if (this.cPd.cPm.getVisibility() == 8) {
            this.cPd.cPm.setVisibility(0);
        }
        if (this.cPd.cPn.getVisibility() == 8) {
            this.cPd.cPn.setVisibility(0);
        }
        if (this.cPd.cPo.getVisibility() == 8) {
            this.cPd.cPo.setVisibility(0);
        }
        this.axu.add(Integer.valueOf(this.cPd.cPm.getId()));
        this.axu.add(Integer.valueOf(this.cPd.cPn.getId()));
        this.axu.add(Integer.valueOf(this.cPd.cPo.getId()));
    }

    private void Bt() {
        if (this.axu.size() != 0) {
            int size = this.axu.size();
            for (int i = 0; i < size; i++) {
                if (this.axu.get(i).intValue() == this.cPd.cPm.getId()) {
                    this.cPd.cPm.setVisibility(8);
                } else if (this.axu.get(i).intValue() == this.cPd.cPn.getId()) {
                    this.cPd.cPn.setVisibility(8);
                } else if (this.axu.get(i).intValue() == this.cPd.cPo.getId()) {
                    this.cPd.cPo.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axt) {
                case 0:
                    a(this.axF, this.axG, this.cPd.cPm);
                    a(this.axH, this.axI, this.cPd.cPn);
                    a(this.axJ, this.axK, this.cPd.cPo);
                    break;
                case 1:
                    a(this.axK, this.axL, this.cPd.cPm);
                    a(this.axM, this.axK, this.cPd.cPn);
                    a(this.axN, this.axI, this.cPd.cPo);
                    break;
                case 2:
                    a(this.axK, this.axO, this.cPd.cPm);
                    a(this.axP, this.axK, this.cPd.cPn);
                    a(this.axN, this.axI, this.cPd.cPo);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cPd.cPm);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cPd.cPn);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cPd.cPo);
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
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bg())));
            ex(textView.getId());
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

    private void ex(int i) {
        if (this.axu.size() != 0) {
            int size = this.axu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axu.get(i2).intValue() == i) {
                    this.axu.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub anY;
        public TbImageView anZ;
        public CardGroupDividerView bZJ;
        public TextView bZQ;
        public LinearLayout bvK;
        public ThreadSkinView bvL;
        public UserIconLayout cOS;
        public View cPf;
        public RelativeLayout cPg;
        public HeadPendantClickableView cPh;
        public ClickableHeaderImageView cPi;
        public TextView cPj;
        public TextView cPk;
        public ThreadCommentAndPraiseInfoLayout cPl;
        public TextView cPm;
        public TextView cPn;
        public TextView cPo;
        public TbImageView caY;
        public View cba;
        public TbImageView ccC;
        public ViewGroup mRootView;

        public a() {
        }
    }
}
