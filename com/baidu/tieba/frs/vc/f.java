package com.baidu.tieba.frs.vc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel aLP;
    private FrsHeaderViewContainer dNM;
    private final View.OnClickListener dNr;
    private FrsFragment edm;
    private com.baidu.tieba.frs.view.b egE;
    private int egF;
    private int egG;
    private String egH;
    private Runnable egI;
    private int egJ;
    private boolean egK;
    private w egL;
    private boolean egM;
    private com.baidu.tieba.frs.entelechy.b.a egN;
    private boolean egO;
    private com.baidu.tieba.f.a egP;
    private boolean egQ;
    private com.baidu.tieba.frs.c.a.a egR;
    private com.baidu.tieba.frs.c.a.a egS;
    private BdUniqueId egT;
    private FrsTabViewController egU;
    private AntiHelper.a egV;
    private CustomMessageListener egW;
    private Runnable egX;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dNM = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.egH = null;
        this.egK = false;
        this.aLP = null;
        this.egL = null;
        this.egM = false;
        this.egQ = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDr));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDr));
            }
        };
        this.egV = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDt));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDt));
            }
        };
        this.egW = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l aCl;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.edm != null && (customResponsedMessage instanceof SignMessage) && (aCl = f.this.edm.aCl()) != null && aCl.bhx() != null && (name = aCl.bhx().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.egT) {
                    TiebaStatic.eventStat(f.this.edm.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = aCl.bhx().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.al(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aH(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDr));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(aCl.bhx().getId())) {
                            f.this.ph(name2);
                            aCl.d(signData2);
                            signData2.forumId = aCl.bhx().getId();
                            signData2.forumName = aCl.bhx().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = aCl.bhx().getUser_level();
                        if (f.this.aIA()) {
                            i = aCl.bhx().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.edm.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aIy()) {
                            f.this.edm.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.edm.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.edm.aBU() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.Jh().a(f.this.edm.getTbPageContext(), f.this.edm.aBU().aDc());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.nK(1);
                    }
                    f.this.edm.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.egX = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dNM != null) {
                    int childCount = f.this.dNM.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dNM.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.dNr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l aCl = f.this.edm.aCl();
                if (aCl != null && aCl.bhx() != null && f.this.egE != null && (view == f.this.egE.aJh() || view == f.this.egE.aJi() || view == f.this.egE.aJj())) {
                    if (f.this.edm != null && aCl.bhx() != null) {
                        TiebaStatic.log(new am("c12046").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()).y("obj_locate", f.this.edm.aCn() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), aCl.bhx().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.edm.aCm()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.edm.showToast(e.j.neterror);
                        } else if (!ba.bJ(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").y("obj_locate", 1).aB(ImageViewerConfig.FORUM_ID, f.this.edm.getForumId()));
                        } else {
                            f.this.hv(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.aB(ImageViewerConfig.FORUM_ID, f.this.edm.getForumId());
                                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.edm.aCm()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.edm.showToast(e.j.neterror);
                        } else if (ba.bJ(f.this.mContext.getPageActivity())) {
                            if (!f.this.aIz()) {
                                f.this.aIC();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.edm.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.edm.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bJ(f.this.mContext.getPageActivity()) && aCl != null && aCl.bDa() != null) {
                        ay.Es().a((TbPageContext) f.this.getPageContext(), new String[]{aCl.bDa()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (aCl != null && aCl.getUserData() != null && aCl.getUserData().isBawu()) {
                        String bDe = aCl.bDe();
                        if (!ao.isEmpty(bDe)) {
                            com.baidu.tbadk.browser.a.ad(f.this.getPageContext().getPageActivity(), bDe);
                            if (aCl.bhx() != null) {
                                TiebaStatic.log(new am("c10502").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()).aB("uid", aCl.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.edm.aCm() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.egE != null) {
                        f.this.egE.h(view, false);
                    }
                }
            }
        };
        this.edm = frsFragment;
        this.egN = aVar;
        this.dNM = frsHeaderViewContainer;
        this.egR = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.egS = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.egT = BdUniqueId.gen();
        this.egP = new com.baidu.tieba.f.a();
        this.egP.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void at(int i, int i2) {
            }
        });
    }

    public void t(Bundle bundle) {
        this.edm.registerListener(this.egW);
        abi();
        aID();
        this.egK = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.egE != null) {
            this.egE.onDestory();
        }
        if (this.aLP != null) {
            this.aLP.bEh();
        }
        if (this.egI != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egI);
        }
    }

    public void onActivityStop() {
        if (this.egE != null) {
            this.egE.onStop();
        }
        if (this.dNM != null) {
            this.dNM.removeCallbacks(this.egX);
        }
    }

    public void gA(boolean z) {
        if (this.egE != null) {
            this.egE.gA(z);
        }
    }

    public boolean nG(int i) {
        this.mSkinType = i;
        if (this.egE != null) {
            this.egE.changeSkinType(i);
        }
        if (this.egR != null) {
            this.egR.onChangeSkinType(i);
        }
        if (this.egS != null) {
            this.egS.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void hu(boolean z) {
        if (z) {
            if (this.egE != null) {
                this.dNM.removeHeaderView(this.egE.aJg());
                this.egM = false;
            }
        } else if (this.egE != null && this.egE.aJg() != null && !this.egM) {
            this.dNM.addHeaderView(this.egE.aJg(), this.dNM.getHeaderViewsCount());
            this.egM = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bCS() != null && lVar.bCS().yw() != null && lVar.bCS().yw().size() >= 1) {
                a(lVar.bCS().yw().get(0), false, lVar);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bCR() != null && !StringUtils.isNull(lVar.bCR().bDG())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bCR().bDG());
                a(qVar, true, lVar);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bCS() != null && lVar.bCS().yw() != null && lVar.bCS().yw().size() >= 1) {
                v(str, lVar.getUserData().getIsMem(), lVar.bhx().isLike());
                h(lVar);
            } else {
                this.egQ = false;
                if (this.dNM != null && this.egR != null && this.egR.getHeaderView() != null) {
                    this.dNM.removeHeaderView(this.egR.getHeaderView());
                }
                if (this.dNM != null && this.egS != null && this.egS.getHeaderView() != null) {
                    this.dNM.removeHeaderView(this.egS.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bhx() != null && !"brand_page".equals(str)) {
                u(str, lVar.getUserData().getIsMem(), lVar.bhx().isLike());
            }
        }
    }

    public boolean aIr() {
        return this.egQ;
    }

    private void a(q qVar, boolean z, l lVar) {
        if (qVar == null) {
            this.egQ = false;
        } else if (this.dNM == null || this.egR == null || this.egR.getHeaderView() == null) {
            this.egQ = false;
        } else {
            this.egQ = true;
            this.dNM.removeHeaderView(this.egR.getHeaderView());
            this.dNM.addHeaderView(this.egR.getHeaderView());
            this.egR.a(lVar, qVar.getImageUrl());
            this.egR.setTitle(qVar.getTitle());
            this.egR.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.egR.hideTitle();
            }
        }
        if (lVar != null && lVar.bhx() != null && !TextUtils.isEmpty(lVar.bhx().getId()) && lVar.bCS() != null && !TextUtils.isEmpty(lVar.bCS().yx())) {
            am amVar = new am("c13326");
            amVar.aB(ImageViewerConfig.FORUM_ID, lVar.bhx().getId());
            amVar.aB(VideoPlayActivityConfig.OBJ_ID, lVar.bCS().yx());
            TiebaStatic.log(amVar);
        }
    }

    private void h(l lVar) {
        if (lVar == null || lVar.bCS() == null || v.I(lVar.bCS().yw()) || this.dNM == null || this.egE == null || this.egE.getView() == null || this.egS == null || this.egS.getHeaderView() == null) {
            this.egQ = false;
            return;
        }
        q qVar = lVar.bCS().yw().get(0);
        if (qVar == null) {
            this.egQ = false;
            return;
        }
        this.egQ = true;
        this.egE.getView().setBackgroundColor(0);
        this.egS.aHf().removeView(this.egE.getView());
        this.egS.aHf().addView(this.egE.getView());
        this.dNM.removeHeaderView(this.egS.getHeaderView());
        this.dNM.addHeaderView(this.egS.getHeaderView());
        this.egS.a(lVar, qVar.getImageUrl());
        this.egS.setSchemaUrl(qVar.getLinkUrl());
        this.egS.setTitle(qVar.getTitle());
        if (this.egS instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.egS).bO(lVar.hnP);
        }
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.egH, str);
        this.egJ = i2;
        this.egH = str;
        aIt();
        if (this.egE == null || z) {
            this.egE = this.egN.a(str, this.edm, i);
            this.egE.changeSkinType(this.mSkinType);
            this.egE.s(this.dNr);
        }
        this.dNM.addHeaderView(this.egE.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44);
        this.egE.q(0, h, 0, h);
        aIu();
        if (this.egU != null) {
            this.egU.aW(this.egE.aED());
        }
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.egH, str);
        this.egJ = i2;
        this.egH = str;
        aIt();
        if (this.egE == null || z) {
            this.egE = this.egN.a(str, this.edm, i);
            this.egE.changeSkinType(this.mSkinType);
            this.egE.s(this.dNr);
            this.egE.aEI();
        }
        this.egE.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44));
        aIu();
        if (this.egU != null) {
            this.egU.aW(this.egE.aED());
        }
    }

    public void aIs() {
        if (!this.egM && this.egE != null) {
            this.dNM.addHeaderView(this.egE.aJg());
            if (this.egE.aED() != null && this.edm.FI() != null) {
                this.edm.FI().addHeaderView(this.egE.aED(), 0);
            }
            this.egM = true;
        }
    }

    private void aIt() {
        if (("normal_page".equals(this.egH) || "frs_page".equals(this.egH) || "book_page".equals(this.egH) || "brand_page".equals(this.egH)) && this.egE != null) {
            this.dNM.removeHeaderView(this.egE.getView());
            this.dNM.removeHeaderView(this.egE.aJg());
            if (this.egE.aED() != null && this.edm.FI() != null) {
                this.edm.FI().removeHeaderView(this.egE.aED());
            }
        }
        this.egM = false;
    }

    private void aIu() {
        if (this.egI == null) {
            this.egI = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.edm.aBU() == null || !f.this.edm.aBU().aCm()) && f.this.dNM.isShown() && f.this.edm.isPrimary() && !f.this.egK && f.this.egJ == 1 && f.this.edm.aBU() != null && f.this.edm.aBU().aCL() != null && !f.this.edm.aBU().aCL().aFo() && f.this.edm.aCq()) {
                            if (("frs_page".equals(f.this.egH) || "normal_page".equals(f.this.egH) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.egH)) && f.this.egE != null && f.this.egE.aJf()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aEQ();
                                f.this.edm.dLn = true;
                                f.this.egK = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.egI, 4000L);
    }

    public void i(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.bhx(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.egE.aEJ();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.egE != null) {
                this.egE.a(forumData, lVar);
                this.egE.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.egE.ob(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.egE.hB(false);
                        return;
                    }
                    this.egE.hB(true);
                    this.egE.ob(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.egF = forumData.getLevelupScore();
        this.egG = forumData.getCurScore();
        if (this.egF > 0) {
            return this.egG / this.egF;
        }
        return 0.0f;
    }

    public void nH(int i) {
        if (i > 1) {
            if (this.egE != null) {
                this.egE.hC(false);
            }
        } else if (this.egE != null) {
            this.egE.hC(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aIv() {
        if (this.dNM != null) {
            this.dNM.removeCallbacks(this.egX);
            this.dNM.postDelayed(this.egX, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aIw();
        }
    }

    public void setIsMem(int i) {
        if (this.egE != null) {
            this.egE.setMemberType(i);
        }
    }

    public void aEQ() {
        if (("normal_page".equals(this.egH) || "frs_page".equals(this.egH) || "book_page".equals(this.egH) || "brand_page".equals(this.mPageType)) && this.egE != null) {
            this.egE.aEQ();
        }
    }

    public void aIw() {
        if (this.egE != null) {
            this.egE.aES();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.bhx(), lVar, z);
            }
        }
    }

    public void aIx() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nJ(0);
        }
    }

    public void nI(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nJ(i);
        }
    }

    public void nJ(int i) {
        if (this.egE != null) {
            this.egE.oa(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.egE != null) {
            this.egE.a(forumData, lVar);
            if (forumData != null) {
                this.egE.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.egE.hB(false);
                }
            }
        }
    }

    public boolean aIy() {
        if (("normal_page".equals(this.egH) || "frs_page".equals(this.egH) || "book_page".equals(this.egH) || "brand_page".equals(this.mPageType)) && this.egE != null) {
            return this.egE.aJe();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.egF - this.egG) {
                z = true;
                this.egF = signData.levelup_score;
            }
            this.egG = i + this.egG;
            if (this.egG > this.egF) {
                this.egG = this.egF;
            }
            if (this.egF != 0) {
                f = this.egG / this.egF;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void nK(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.egE != null) {
            this.egE.ob(i);
        }
    }

    public void j(l lVar) {
        SignData signData;
        ForumData bhx;
        if (lVar != null && lVar.bhx() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.egE != null && (signData = lVar.bhx().getSignData()) != null && (bhx = lVar.bhx()) != null) {
                this.egE.a(bhx, lVar);
                this.egE.ob(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.egE.aJe()) {
                    a(this.egE, signData);
                    bhx.setCurScore(this.egG);
                    bhx.setLevelupScore(this.egF);
                    this.egE.a(bhx, lVar);
                }
            }
        }
    }

    public boolean aIz() {
        if (("normal_page".equals(this.egH) || "frs_page".equals(this.egH) || "book_page".equals(this.egH) || "brand_page".equals(this.mPageType)) && this.egE != null) {
            return this.egE.aIz();
        }
        return false;
    }

    public boolean aIA() {
        if (("normal_page".equals(this.egH) || "frs_page".equals(this.egH) || "book_page".equals(this.egH) || "brand_page".equals(this.mPageType)) && this.egE != null) {
            return this.egE.aIA();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void hv(boolean z) {
        if (this.edm != null) {
            l aCl = this.edm.aCl();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.edm.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (aCl != null && aCl.bhx() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.edm.getFrom())) {
                    TiebaStatic.log(new am("c10356").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.edm.getFrom())) {
                    TiebaStatic.log(new am("c10590").y("obj_type", 2).aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.edm.getFrom())) {
                    TiebaStatic.log(new am("c10587").y("obj_type", 2).aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.edm.getFrom())) {
                    TiebaStatic.log(new am("c10578").y("obj_type", 2).aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                }
                this.aLP.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.edm.getFrom())) {
                    TiebaStatic.eventStat(this.edm.getPageContext().getPageActivity(), "square_frs_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.edm.getFrom())) {
                    TiebaStatic.log(new am("c10359").aB(ImageViewerConfig.FORUM_ID, aCl.bhx().getId()));
                }
                this.aLP.Q(aCl.bhx().getName(), aCl.bhx().getId(), "FRS");
                this.egO = z;
            }
        }
    }

    public void aIB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.edm.aCl() != null && this.edm.aCl().bhx() != null && this.edm.aCl().bhx().getName() != null) {
            str = this.edm.aCl().bhx().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.eK(String.format(getPageContext().getString(e.j.attention_cancel_dialog_content), str));
        } else {
            aVar.eK(getPageContext().getString(e.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(e.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l aCl = f.this.edm.aCl();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.edm.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (aCl != null && aCl.bhx() != null) {
                    f.this.egL.w(aCl.bhx().getName(), com.baidu.adp.lib.g.b.d(aCl.bhx().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(e.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).BS();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aIC() {
        l aCl = this.edm.aCl();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.edm.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (aCl != null && aCl.bhx() != null) {
            FrsActivityStatic.forumName = aCl.bhx().getName() == null ? "" : aCl.bhx().getName();
            CustomMessage customMessage = new CustomMessage(2001425, aCl.bhx());
            customMessage.setTag(this.egT);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(String str) {
        if (this.edm.aBP() != null && this.edm.aBP().aHu() != null) {
            com.baidu.tieba.tbadkCore.c.bCD().ac(com.baidu.tieba.tbadkCore.c.bCD().d(str, this.edm.aBP().aHu().acy(), this.edm.aBP().aHu().getIsGood(), this.edm.aBP().aHu().getCategoryId()), false);
        }
    }

    private void abi() {
        this.aLP = new LikeModel(this.edm.getPageContext());
        this.aLP.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                l aCl = f.this.edm.aCl();
                if (aCl != null && aCl.bhx() != null && obj != null) {
                    if (AntiHelper.al(f.this.aLP.getErrorCode(), f.this.aLP.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aLP.getBlockPopInfoData(), f.this.egV) != null) {
                            TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDt));
                            return;
                        }
                        return;
                    }
                    String name = aCl.bhx().getName();
                    String id = aCl.bhx().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.aLP.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).Ca();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.aLP.getErrorCode() == 22) {
                            f.this.edm.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.edm.showToast(f.this.aLP.getErrorString());
                        }
                    } else {
                        f.this.ph(name);
                        rVar.setLike(1);
                        aCl.c(rVar);
                        aCl.dJ(rVar.bCK());
                        f.this.a(aCl, f.this.egO);
                        f.this.egO = true;
                        f.this.edm.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.g(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.edm.ad(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aID() {
        this.egL = new w();
        this.egL.setFrom("from_frs");
        this.egL.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                l aCl = f.this.edm.aCl();
                if (aCl != null && aCl.bhx() != null) {
                    String name = aCl.bhx().getName();
                    String id = aCl.bhx().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.ph(str);
                        aCl.bhx().setLike(0);
                        f.this.nI(0);
                        f.this.edm.ac(true);
                        f.this.g(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        r rVar = new r();
                        rVar.setLike(0);
                        rVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void q(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aVx().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void F(int i, int i2, int i3) {
        l aCl;
        if (i > 0 && i2 > 0 && (aCl = this.edm.aCl()) != null && aCl.bhx() != null && aCl.getSignData() != null) {
            ForumData bhx = aCl.bhx();
            SignData signData = aCl.getSignData();
            signData.levelup_score = bhx.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aCl.d(signData);
            signData.forumId = bhx.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aIA()) {
                i4 = bhx.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bhx.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void aEy() {
        if (this.egE != null) {
            this.egE.aEy();
        }
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return (lVar.bDi() == null || StringUtils.isNull(lVar.bDi().yy(), true) || lVar.bDi().yy().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(l lVar) {
        if (lVar != null) {
            return ((lVar.bCR() == null || lVar.bCR().bDC() != 1) && lVar.bDh() == null && (lVar.bCS() == null || v.I(lVar.bCS().yw())) && ((lVar.bhx() == null || lVar.bhx().getFrsBannerData() == null || lVar.bhx().getFrsBannerData().getType() != 2) && (lVar.bDj() == null || StringUtils.isNull(lVar.bDj().yF(), true)))) ? false : true;
        }
        return false;
    }

    public void nL(int i) {
        View findViewById;
        if (this.egE != null && this.egE.aJg() != null && (findViewById = this.egE.aJg().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.egP != null) {
            this.egP.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.egU = frsTabViewController;
    }
}
