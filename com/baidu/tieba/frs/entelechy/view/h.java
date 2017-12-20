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
    private int axK;
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private int axP;
    private int axQ;
    private int axR;
    private int axS;
    private int axT;
    private int axU;
    private int axy;
    private ArrayList<Integer> axz;
    private com.baidu.tieba.frs.g.g cOS;
    private ar cPn;
    public a cPo;
    private View.OnClickListener caY;
    private View.OnClickListener caZ;
    private CustomMessageListener caf;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.axz = new ArrayList<>();
        this.axy = 0;
        this.caY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.abt() != null) {
                    h.this.abt().a(view, h.this.cPn);
                }
            }
        };
        this.caZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.abt() != null) {
                    h.this.abt().a(view, h.this.cPn);
                }
            }
        };
        this.caf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.cPn != null && h.this.cPn != null && h.this.cPn.getTid() != null && h.this.cPo != null && h.this.cPo.bZU != null && h.this.cPo.cPv != null && ((String) customResponsedMessage.getData()).equals(h.this.cPn.getTid())) {
                    com.baidu.tieba.card.k.a(h.this.cPo.bZU, h.this.cPn.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
                    com.baidu.tieba.card.k.a(h.this.cPo.cPv, h.this.cPn.getId(), d.C0096d.cp_cont_j, d.C0096d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.axK = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.axL = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.axM = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.axN = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.axO = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.axP = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.axQ = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.axR = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.axS = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.axT = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.axU = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        ab(getView());
        initUI();
    }

    private void ab(View view) {
        this.cPo = new a();
        this.cPo.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.cPo.cPq = view.findViewById(d.g.top_line);
        this.cPo.cPr = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.cPo.cPt = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.cPo.cPs = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.cPo.aoa = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.cPo.bvL = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.cPo.cPd = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.cPo.bZU = (TextView) view.findViewById(d.g.thread_title);
        this.cPo.cPu = (TextView) view.findViewById(d.g.thread_context);
        this.cPo.cPv = (TextView) view.findViewById(d.g.fans_num);
        this.cPo.cbc = (TbImageView) view.findViewById(d.g.thread_image);
        this.cPo.cbc.setPageId(getTag());
        this.cPo.cPw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.cPo.cbe = view.findViewById(d.g.divider_below_reply_number_layout);
        this.cPo.cPx = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.cPo.cPy = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.cPo.cPz = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.cPo.ccH = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.cPo.ccH.setPageId(getTag());
        this.cPo.bvM = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.cPo.bZN = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.cPo.bZN.setTitleClickListener(this);
        this.cOS = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cPo.mRootView);
        this.cOS.setUniqueId(getTag());
    }

    private void initUI() {
        this.cPo.cPt.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cPo.cPt.setDefaultResource(17170445);
        this.cPo.cPt.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPo.cPt.setDefaultBgResource(d.C0096d.cp_bg_line_e);
        this.cPo.cPs.wi();
        this.cPo.cPs.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.cPo.cPs.getHeadView().setDefaultResource(17170445);
        this.cPo.cPs.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPo.cPs.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
        this.cPo.cPs.getHeadView().setIsRound(true);
        this.cPo.cPs.getHeadView().setDrawBorder(false);
        this.cPo.cPs.getPendantView().setIsRound(true);
        this.cPo.cPs.getPendantView().setDrawBorder(false);
        this.cPo.cPw.setShowPraiseNum(false);
        this.cPo.cPw.setFrom(2);
        this.cPo.cbc.setDrawBorder(true);
        this.cPo.cbc.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.cPn = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.cPn == null) {
            this.cPo.mRootView.setVisibility(8);
            return;
        }
        if (this.cPn.rv() == null || this.cPn.rv().getPendantData() == null || StringUtils.isNull(this.cPn.rv().getPendantData().pR())) {
            if (this.cPn.rv() != null && this.cPn.rv().getGodUserData() != null && this.cPn.rv().getGodUserData().getType() == 2) {
                this.cPo.cPt.setGodIconMargin(0);
            } else {
                this.cPo.cPt.setIsGod(false);
            }
            UserTbVipInfoData rw = this.cPn.rw();
            if (rw != null && rw.getvipV_url() != null) {
                if (this.cPo.aoa != null) {
                    if (this.cPo.aob == null) {
                        this.cPo.aoa.inflate();
                        this.cPo.aob = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.cPo.aob.setPageId(getTag());
                    this.cPo.aob.setVisibility(0);
                    this.cPo.aob.startLoad(rw.getvipV_url(), 10, false);
                    this.cPo.cPt.setIsBigV(true);
                }
            } else {
                this.cPo.cPt.setIsBigV(false);
                if (this.cPo.aob != null) {
                    this.cPo.aob.setVisibility(8);
                }
            }
            this.cPo.cPt.setData(this.cPn);
            this.cPo.cPt.setAfterClickListener(this.caY);
            this.cPo.cPt.setVisibility(0);
            this.cPo.cPs.setVisibility(8);
        } else {
            this.cPo.cPt.setIsGod(false);
            this.cPo.cPt.setIsBigV(false);
            if (this.cPo.aob != null) {
                this.cPo.aob.setVisibility(8);
            }
            this.cPo.cPt.setVisibility(4);
            this.cPo.cPs.setVisibility(0);
            this.cPo.cPs.setData(this.cPn);
        }
        if (this.cPn.rv() != null && !StringUtils.isNull(this.cPn.rv().getSealPrefix())) {
            this.cPo.cPd.aM(true);
        }
        this.cPo.cPd.setData(this.cPn);
        this.cPo.cPd.setUserNameTextSizeRid(d.e.fontsize24);
        this.cPo.cPd.setUserAfterClickListener(this.caY);
        this.cPo.cPd.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.cPn.getTitle())) {
            int length = this.cPn.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.cPn.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.cPo.bZU.setSingleLine(true);
        } else {
            this.cPo.bZU.setMaxLines(2);
        }
        this.cPn.e(false, true);
        this.cPo.bZU.setText(this.cPn.rV());
        String fansNickName = this.cPn.rv().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.cPo.cPv.setText(fansNickName + ": " + am.u(this.cPn.rv().getFansNum()));
        if (this.cPo.cPw.setData(this.cPn)) {
            this.cPo.cbe.setVisibility(8);
        } else {
            this.cPo.cbe.setVisibility(0);
        }
        this.cPo.cPw.setForumAfterClickListener(this.caZ);
        this.cPo.cPw.setStType("frs_page");
        D(this.cPn);
        this.cOS.U(this.cPn);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.h.oY().pe() && this.cPn.getPhotoLiveCover() != null && this.cPn.getPhotoLiveCover().length() != 0) {
            this.cPo.cbc.setVisibility(0);
            this.cPo.cPu.setVisibility(8);
            this.cPo.cbc.startLoad(this.cPn.getPhotoLiveCover(), 10, false);
            b(this.cPn);
        } else {
            this.cPo.cbc.setVisibility(8);
            this.cPo.cPx.setVisibility(8);
            this.cPo.cPy.setVisibility(8);
            this.cPo.cPz.setVisibility(8);
            String str = this.cPn.getAbstract();
            this.cPo.cPu.setText(str);
            this.cPo.cPu.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.cPn, this.cPo.bZN);
        aj.c(this.cPo.cPv, d.C0096d.cp_cont_d, 1);
        if (com.baidu.tieba.card.k.jP(this.cPn.getTid())) {
            aj.c(this.cPo.bZU, d.C0096d.cp_cont_d, 1);
            aj.c(this.cPo.cPu, d.C0096d.cp_cont_d, 1);
            return;
        }
        aj.c(this.cPo.bZU, d.C0096d.cp_cont_b, 1);
        aj.c(this.cPo.cPu, d.C0096d.cp_cont_j, 1);
    }

    private void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            SkinInfo rR = bdVar.rR();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPo.cPt.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cPo.bvL.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cPo.ccH.setVisibility(8);
                if (this.cPo.bvM != null) {
                    if (rR != null) {
                        this.cPo.bvM.a(this.mPageContext, rR, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.rB(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.cPo.bvM.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.cPo.ccH.setVisibility(0);
                this.cPo.ccH.setImageBitmap(null);
                this.cPo.ccH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.cPo.ccH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.cPo.bvM.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.cPo.cPt.setLayoutParams(layoutParams);
            this.cPo.bvL.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cPo != null) {
            if (view == this.cPo.mRootView || view == this.cPo.cPw.getCommentNumView() || view == this.cPo.bZN) {
                if (abt() != null) {
                    abt().a(this.cPo.mRootView, this.cPn);
                }
                abO();
            }
        }
    }

    private void abO() {
        PhotoLiveActivityConfig pn;
        if (this.cPn != null) {
            com.baidu.tieba.card.k.jO(this.cPn.getTid());
            if (!abP()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.cPn.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxU()) {
                pn = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cPn.getTid()).cz("from_frs").bD(18003).cx(String.valueOf(this.cPn.rS())).pn();
            } else {
                pn = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.cPn.getTid()).cz("from_frs").bD(18003).pn();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, pn));
            jQ(this.cPn.getTid());
        }
    }

    public void jQ(final String str) {
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
            com.baidu.tbadk.n.a.a(tbPageContext, this.cPo.mRootView);
            this.cPo.cPd.onChangeSkinType();
            this.cPo.cPw.onChangeSkinType();
            aj.k(this.cPo.cPq, d.C0096d.cp_bg_line_c);
            aj.j(this.cPo.mRootView, d.f.addresslist_item_bg);
            if (this.cPo.bZN != null) {
                this.cPo.bZN.onChangeSkinType();
            }
            this.cOS.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean abP() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.caf != null) {
            this.caf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caf);
        }
    }

    private void b(ar arVar) {
        this.axz.clear();
        Bv();
        if (arVar != null && arVar.rP() != null) {
            int size = arVar.rP().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = arVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, arVar.rP(), i);
                }
            }
            Bu();
        }
    }

    private void Bv() {
        this.cPo.cPx.setText("");
        this.cPo.cPy.setText("");
        this.cPo.cPz.setText("");
        if (this.cPo.cPx.getVisibility() == 8) {
            this.cPo.cPx.setVisibility(0);
        }
        if (this.cPo.cPy.getVisibility() == 8) {
            this.cPo.cPy.setVisibility(0);
        }
        if (this.cPo.cPz.getVisibility() == 8) {
            this.cPo.cPz.setVisibility(0);
        }
        this.axz.add(Integer.valueOf(this.cPo.cPx.getId()));
        this.axz.add(Integer.valueOf(this.cPo.cPy.getId()));
        this.axz.add(Integer.valueOf(this.cPo.cPz.getId()));
    }

    private void Bu() {
        if (this.axz.size() != 0) {
            int size = this.axz.size();
            for (int i = 0; i < size; i++) {
                if (this.axz.get(i).intValue() == this.cPo.cPx.getId()) {
                    this.cPo.cPx.setVisibility(8);
                } else if (this.axz.get(i).intValue() == this.cPo.cPy.getId()) {
                    this.cPo.cPy.setVisibility(8);
                } else if (this.axz.get(i).intValue() == this.cPo.cPz.getId()) {
                    this.cPo.cPz.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axy) {
                case 0:
                    a(this.axK, this.axL, this.cPo.cPx);
                    a(this.axM, this.axN, this.cPo.cPy);
                    a(this.axO, this.axP, this.cPo.cPz);
                    break;
                case 1:
                    a(this.axP, this.axQ, this.cPo.cPx);
                    a(this.axR, this.axP, this.cPo.cPy);
                    a(this.axS, this.axN, this.cPo.cPz);
                    break;
                case 2:
                    a(this.axP, this.axT, this.cPo.cPx);
                    a(this.axU, this.axP, this.cPo.cPy);
                    a(this.axS, this.axN, this.cPo.cPz);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.cPo.cPx);
            } else if (i == 1) {
                a(arrayList.get(i2), this.cPo.cPy);
            } else if (i == 2) {
                a(arrayList.get(i2), this.cPo.cPz);
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
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bh())));
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
        if (this.axz.size() != 0) {
            int size = this.axz.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axz.get(i2).intValue() == i) {
                    this.axz.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aoa;
        public TbImageView aob;
        public CardGroupDividerView bZN;
        public TextView bZU;
        public LinearLayout bvL;
        public ThreadSkinView bvM;
        public UserIconLayout cPd;
        public View cPq;
        public RelativeLayout cPr;
        public HeadPendantClickableView cPs;
        public ClickableHeaderImageView cPt;
        public TextView cPu;
        public TextView cPv;
        public ThreadCommentAndPraiseInfoLayout cPw;
        public TextView cPx;
        public TextView cPy;
        public TextView cPz;
        public TbImageView cbc;
        public View cbe;
        public TbImageView ccH;
        public ViewGroup mRootView;

        public a() {
        }
    }
}
