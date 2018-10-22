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
    private LikeModel aGV;
    private FrsHeaderViewContainer dCA;
    private final View.OnClickListener dCe;
    private FrsFragment dSg;
    private String dVA;
    private Runnable dVB;
    private int dVC;
    private boolean dVD;
    private w dVE;
    private boolean dVF;
    private com.baidu.tieba.frs.entelechy.b.a dVG;
    private boolean dVH;
    private com.baidu.tieba.f.a dVI;
    private boolean dVJ;
    private com.baidu.tieba.frs.c.a.a dVK;
    private com.baidu.tieba.frs.c.a.a dVL;
    private BdUniqueId dVM;
    private FrsTabViewController dVN;
    private AntiHelper.a dVO;
    private CustomMessageListener dVP;
    private Runnable dVQ;
    private com.baidu.tieba.frs.view.b dVx;
    private int dVy;
    private int dVz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dCA = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dVA = null;
        this.dVD = false;
        this.aGV = null;
        this.dVE = null;
        this.dVF = false;
        this.dVJ = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayB));
            }
        };
        this.dVO = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayD));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayD));
            }
        };
        this.dVP = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l azS;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.dSg != null && (customResponsedMessage instanceof SignMessage) && (azS = f.this.dSg.azS()) != null && azS.beT() != null && (name = azS.beT().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.dVM) {
                    TiebaStatic.eventStat(f.this.dSg.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = azS.beT().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.am(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aI(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayB));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(azS.beT().getId())) {
                            f.this.oo(name2);
                            azS.d(signData2);
                            signData2.forumId = azS.beT().getId();
                            signData2.forumName = azS.beT().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = azS.beT().getUser_level();
                        if (f.this.aGg()) {
                            i = azS.beT().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.dSg.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aGe()) {
                            f.this.dSg.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.dSg.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.dSg.azB() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.HB().a(f.this.dSg.getTbPageContext(), f.this.dSg.azB().aAJ());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.mO(1);
                    }
                    f.this.dSg.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dVQ = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dCA != null) {
                    int childCount = f.this.dCA.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dCA.getChildAt(i));
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
        this.dCe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l azS = f.this.dSg.azS();
                if (azS != null && azS.beT() != null && f.this.dVx != null && (view == f.this.dVx.aGK() || view == f.this.dVx.aGL() || view == f.this.dVx.aGM())) {
                    if (f.this.dSg != null && azS.beT() != null) {
                        TiebaStatic.log(new am("c12046").ax(ImageViewerConfig.FORUM_ID, azS.beT().getId()).x("obj_locate", f.this.dSg.azU() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), azS.beT().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.dSg.azT()) {
                        if (!com.baidu.adp.lib.util.j.kX()) {
                            f.this.dSg.showToast(e.j.neterror);
                        } else if (!ba.bI(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").x("obj_locate", 1).ax(ImageViewerConfig.FORUM_ID, f.this.dSg.getForumId()));
                        } else {
                            f.this.hd(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.ax(ImageViewerConfig.FORUM_ID, f.this.dSg.getForumId());
                                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.dSg.azT()) {
                        if (!com.baidu.adp.lib.util.j.kX()) {
                            f.this.dSg.showToast(e.j.neterror);
                        } else if (ba.bI(f.this.mContext.getPageActivity())) {
                            if (!f.this.aGf()) {
                                f.this.aGi();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dSg.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.dSg.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bI(f.this.mContext.getPageActivity()) && azS != null && azS.bAk() != null) {
                        ay.CU().a((TbPageContext) f.this.getPageContext(), new String[]{azS.bAk()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (azS != null && azS.getUserData() != null && azS.getUserData().isBawu()) {
                        String bAo = azS.bAo();
                        if (!ao.isEmpty(bAo)) {
                            com.baidu.tbadk.browser.a.ae(f.this.getPageContext().getPageActivity(), bAo);
                            if (azS.beT() != null) {
                                TiebaStatic.log(new am("c10502").ax(ImageViewerConfig.FORUM_ID, azS.beT().getId()).ax("uid", azS.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.dSg.azT() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.dVx != null) {
                        f.this.dVx.i(view, false);
                    }
                }
            }
        };
        this.dSg = frsFragment;
        this.dVG = aVar;
        this.dCA = frsHeaderViewContainer;
        this.dVK = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.dVL = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.dVM = BdUniqueId.gen();
        this.dVI = new com.baidu.tieba.f.a();
        this.dVI.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void af(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void ag(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0179a
            public void ah(int i, int i2) {
            }
        });
    }

    public void n(Bundle bundle) {
        this.dSg.registerListener(this.dVP);
        Zt();
        aGj();
        this.dVD = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dVx != null) {
            this.dVx.onDestory();
        }
        if (this.aGV != null) {
            this.aGV.bBq();
        }
        if (this.dVB != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dVB);
        }
    }

    public void onActivityStop() {
        if (this.dVx != null) {
            this.dVx.onStop();
        }
        if (this.dCA != null) {
            this.dCA.removeCallbacks(this.dVQ);
        }
    }

    public void gj(boolean z) {
        if (this.dVx != null) {
            this.dVx.gj(z);
        }
    }

    public boolean mK(int i) {
        this.mSkinType = i;
        if (this.dVx != null) {
            this.dVx.changeSkinType(i);
        }
        if (this.dVK != null) {
            this.dVK.onChangeSkinType(i);
        }
        if (this.dVL != null) {
            this.dVL.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void hc(boolean z) {
        if (z) {
            if (this.dVx != null) {
                this.dCA.removeHeaderView(this.dVx.aGJ());
                this.dVF = false;
            }
        } else if (this.dVx != null && this.dVx.aGJ() != null && !this.dVF) {
            this.dCA.addHeaderView(this.dVx.aGJ(), this.dCA.getHeaderViewsCount());
            this.dVF = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bAc() != null && lVar.bAc().wX() != null && lVar.bAc().wX().size() >= 1) {
                a(lVar.bAc().wX().get(0), false);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bAb() != null && !StringUtils.isNull(lVar.bAb().bAQ())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bAb().bAQ());
                a(qVar, true);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bAc() != null && lVar.bAc().wX() != null && lVar.bAc().wX().size() >= 1) {
                t(str, lVar.getUserData().getIsMem(), lVar.beT().isLike());
                g(lVar);
            } else {
                this.dVJ = false;
                if (this.dCA != null && this.dVK != null && this.dVK.getHeaderView() != null) {
                    this.dCA.removeHeaderView(this.dVK.getHeaderView());
                }
                if (this.dCA != null && this.dVL != null && this.dVL.getHeaderView() != null) {
                    this.dCA.removeHeaderView(this.dVL.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.beT() != null && !"brand_page".equals(str)) {
                s(str, lVar.getUserData().getIsMem(), lVar.beT().isLike());
            }
        }
    }

    public boolean aFX() {
        return this.dVJ;
    }

    private void a(q qVar, boolean z) {
        if (qVar == null) {
            this.dVJ = false;
        } else if (this.dCA == null || this.dVK == null || this.dVK.getHeaderView() == null) {
            this.dVJ = false;
        } else {
            this.dVJ = true;
            this.dCA.removeHeaderView(this.dVK.getHeaderView());
            this.dCA.addHeaderView(this.dVK.getHeaderView());
            this.dVK.iG(qVar.getImageUrl());
            this.dVK.setTitle(qVar.getTitle());
            this.dVK.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.dVK.hideTitle();
            }
        }
    }

    private void g(l lVar) {
        if (lVar == null || lVar.bAc() == null || v.J(lVar.bAc().wX()) || this.dCA == null || this.dVx == null || this.dVx.getView() == null || this.dVL == null || this.dVL.getHeaderView() == null) {
            this.dVJ = false;
            return;
        }
        q qVar = lVar.bAc().wX().get(0);
        if (qVar == null) {
            this.dVJ = false;
            return;
        }
        this.dVJ = true;
        this.dVx.getView().setBackgroundColor(0);
        this.dVL.aEL().removeView(this.dVx.getView());
        this.dVL.aEL().addView(this.dVx.getView());
        this.dCA.removeHeaderView(this.dVL.getHeaderView());
        this.dCA.addHeaderView(this.dVL.getHeaderView());
        this.dVL.iG(qVar.getImageUrl());
        this.dVL.setSchemaUrl(qVar.getLinkUrl());
        this.dVL.setTitle(qVar.getTitle());
        if (this.dVL instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.dVL).bM(lVar.hbj);
        }
    }

    private void s(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dVA, str);
        this.dVC = i2;
        this.dVA = str;
        aFZ();
        if (this.dVx == null || z) {
            this.dVx = this.dVG.a(str, this.dSg, i);
            this.dVx.changeSkinType(this.mSkinType);
            this.dVx.q(this.dCe);
        }
        this.dCA.addHeaderView(this.dVx.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds44);
        this.dVx.q(0, h, 0, h);
        aGa();
        if (this.dVN != null) {
            this.dVN.aR(this.dVx.aCl());
        }
    }

    private void t(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dVA, str);
        this.dVC = i2;
        this.dVA = str;
        aFZ();
        if (this.dVx == null || z) {
            this.dVx = this.dVG.a(str, this.dSg, i);
            this.dVx.changeSkinType(this.mSkinType);
            this.dVx.q(this.dCe);
            this.dVx.aCq();
        }
        this.dVx.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds44));
        aGa();
        if (this.dVN != null) {
            this.dVN.aR(this.dVx.aCl());
        }
    }

    public void aFY() {
        if (!this.dVF && this.dVx != null) {
            this.dCA.addHeaderView(this.dVx.aGJ());
            if (this.dVx.aCl() != null && this.dSg.Eg() != null) {
                this.dSg.Eg().addHeaderView(this.dVx.aCl(), 0);
            }
            this.dVF = true;
        }
    }

    private void aFZ() {
        if (("normal_page".equals(this.dVA) || "frs_page".equals(this.dVA) || "book_page".equals(this.dVA) || "brand_page".equals(this.dVA)) && this.dVx != null) {
            this.dCA.removeHeaderView(this.dVx.getView());
            this.dCA.removeHeaderView(this.dVx.aGJ());
            if (this.dVx.aCl() != null && this.dSg.Eg() != null) {
                this.dSg.Eg().removeHeaderView(this.dVx.aCl());
            }
        }
        this.dVF = false;
    }

    private void aGa() {
        if (this.dVB == null) {
            this.dVB = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dSg.azB() == null || !f.this.dSg.azB().azT()) && f.this.dCA.isShown() && f.this.dSg.isPrimary() && !f.this.dVD && f.this.dVC == 1 && f.this.dSg.azB() != null && f.this.dSg.azB().aAs() != null && !f.this.dSg.azB().aAs().aCW() && f.this.dSg.azX()) {
                            if (("frs_page".equals(f.this.dVA) || "normal_page".equals(f.this.dVA) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.dVA)) && f.this.dVx != null && f.this.dVx.aGI()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aCy();
                                f.this.dSg.dAa = true;
                                f.this.dVD = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jI().postDelayed(this.dVB, 4000L);
    }

    public void h(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.beT(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.dVx.aCr();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dVx != null) {
                this.dVx.a(forumData, lVar);
                this.dVx.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dVx.nf(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dVx.hm(false);
                        return;
                    }
                    this.dVx.hm(true);
                    this.dVx.nf(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dVy = forumData.getLevelupScore();
        this.dVz = forumData.getCurScore();
        if (this.dVy > 0) {
            return this.dVz / this.dVy;
        }
        return 0.0f;
    }

    public void mL(int i) {
        if (i > 1) {
            if (this.dVx != null) {
                this.dVx.hn(false);
            }
        } else if (this.dVx != null) {
            this.dVx.hn(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aGb() {
        if (this.dCA != null) {
            this.dCA.removeCallbacks(this.dVQ);
            this.dCA.postDelayed(this.dVQ, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aGc();
        }
    }

    public void setIsMem(int i) {
        if (this.dVx != null) {
            this.dVx.setMemberType(i);
        }
    }

    public void aCy() {
        if (("normal_page".equals(this.dVA) || "frs_page".equals(this.dVA) || "book_page".equals(this.dVA) || "brand_page".equals(this.mPageType)) && this.dVx != null) {
            this.dVx.aCy();
        }
    }

    public void aGc() {
        if (this.dVx != null) {
            this.dVx.aCA();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.beT(), lVar, z);
            }
        }
    }

    public void aGd() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            mN(0);
        }
    }

    public void mM(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            mN(i);
        }
    }

    public void mN(int i) {
        if (this.dVx != null) {
            this.dVx.ne(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dVx != null) {
            this.dVx.a(forumData, lVar);
            if (forumData != null) {
                this.dVx.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dVx.hm(false);
                }
            }
        }
    }

    public boolean aGe() {
        if (("normal_page".equals(this.dVA) || "frs_page".equals(this.dVA) || "book_page".equals(this.dVA) || "brand_page".equals(this.mPageType)) && this.dVx != null) {
            return this.dVx.aGH();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dVy - this.dVz) {
                z = true;
                this.dVy = signData.levelup_score;
            }
            this.dVz = i + this.dVz;
            if (this.dVz > this.dVy) {
                this.dVz = this.dVy;
            }
            if (this.dVy != 0) {
                f = this.dVz / this.dVy;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void mO(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dVx != null) {
            this.dVx.nf(i);
        }
    }

    public void i(l lVar) {
        SignData signData;
        ForumData beT;
        if (lVar != null && lVar.beT() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dVx != null && (signData = lVar.beT().getSignData()) != null && (beT = lVar.beT()) != null) {
                this.dVx.a(beT, lVar);
                this.dVx.nf(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dVx.aGH()) {
                    a(this.dVx, signData);
                    beT.setCurScore(this.dVz);
                    beT.setLevelupScore(this.dVy);
                    this.dVx.a(beT, lVar);
                }
            }
        }
    }

    public boolean aGf() {
        if (("normal_page".equals(this.dVA) || "frs_page".equals(this.dVA) || "book_page".equals(this.dVA) || "brand_page".equals(this.mPageType)) && this.dVx != null) {
            return this.dVx.aGf();
        }
        return false;
    }

    public boolean aGg() {
        if (("normal_page".equals(this.dVA) || "frs_page".equals(this.dVA) || "book_page".equals(this.dVA) || "brand_page".equals(this.mPageType)) && this.dVx != null) {
            return this.dVx.aGg();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void hd(boolean z) {
        if (this.dSg != null) {
            l azS = this.dSg.azS();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dSg.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (azS != null && azS.beT() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dSg.getFrom())) {
                    TiebaStatic.log(new am("c10356").ax(ImageViewerConfig.FORUM_ID, azS.beT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dSg.getFrom())) {
                    TiebaStatic.log(new am("c10590").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azS.beT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dSg.getFrom())) {
                    TiebaStatic.log(new am("c10587").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azS.beT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dSg.getFrom())) {
                    TiebaStatic.log(new am("c10578").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azS.beT().getId()));
                }
                this.aGV.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dSg.getFrom())) {
                    TiebaStatic.eventStat(this.dSg.getPageContext().getPageActivity(), "square_frs_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dSg.getFrom())) {
                    TiebaStatic.log(new am("c10359").ax(ImageViewerConfig.FORUM_ID, azS.beT().getId()));
                }
                this.aGV.P(azS.beT().getName(), azS.beT().getId(), "FRS");
                this.dVH = z;
            }
        }
    }

    public void aGh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dSg.azS() != null && this.dSg.azS().beT() != null && this.dSg.azS().beT().getName() != null) {
            str = this.dSg.azS().beT().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.ej(String.format(getPageContext().getString(e.j.attention_cancel_dialog_content), str));
        } else {
            aVar.ej(getPageContext().getString(e.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(e.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l azS = f.this.dSg.azS();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dSg.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (azS != null && azS.beT() != null) {
                    f.this.dVE.w(azS.beT().getName(), com.baidu.adp.lib.g.b.d(azS.beT().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(e.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).Au();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aGi() {
        l azS = this.dSg.azS();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dSg.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (azS != null && azS.beT() != null) {
            FrsActivityStatic.forumName = azS.beT().getName() == null ? "" : azS.beT().getName();
            CustomMessage customMessage = new CustomMessage(2001425, azS.beT());
            customMessage.setTag(this.dVM);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(String str) {
        if (this.dSg.azw() != null && this.dSg.azw().aFa() != null) {
            com.baidu.tieba.tbadkCore.c.bzN().ab(com.baidu.tieba.tbadkCore.c.bzN().d(str, this.dSg.azw().aFa().aaJ(), this.dSg.azw().aFa().getIsGood(), this.dSg.azw().aFa().getCategoryId()), false);
        }
    }

    private void Zt() {
        this.aGV = new LikeModel(this.dSg.getPageContext());
        this.aGV.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                l azS = f.this.dSg.azS();
                if (azS != null && azS.beT() != null && obj != null) {
                    if (AntiHelper.am(f.this.aGV.getErrorCode(), f.this.aGV.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aGV.getBlockPopInfoData(), f.this.dVO) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayD));
                            return;
                        }
                        return;
                    }
                    String name = azS.beT().getName();
                    String id = azS.beT().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.aGV.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).AC();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.aGV.getErrorCode() == 22) {
                            f.this.dSg.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.dSg.showToast(f.this.aGV.getErrorString());
                        }
                    } else {
                        f.this.oo(name);
                        rVar.setLike(1);
                        azS.c(rVar);
                        azS.dF(rVar.bzU());
                        f.this.a(azS, f.this.dVH);
                        f.this.dVH = true;
                        f.this.dSg.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.h(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dSg.ae(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aGj() {
        this.dVE = new w();
        this.dVE.setFrom("from_frs");
        this.dVE.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                l azS = f.this.dSg.azS();
                if (azS != null && azS.beT() != null) {
                    String name = azS.beT().getName();
                    String id = azS.beT().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.oo(str);
                        azS.beT().setLike(0);
                        f.this.mM(0);
                        f.this.dSg.ad(true);
                        f.this.h(false, id);
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
    public void h(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aSV().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void F(int i, int i2, int i3) {
        l azS;
        if (i > 0 && i2 > 0 && (azS = this.dSg.azS()) != null && azS.beT() != null && azS.getSignData() != null) {
            ForumData beT = azS.beT();
            SignData signData = azS.getSignData();
            signData.levelup_score = beT.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            azS.d(signData);
            signData.forumId = beT.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aGg()) {
                i4 = beT.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(beT.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void aCi() {
        if (this.dVx != null) {
            this.dVx.aCi();
        }
    }

    public static boolean j(l lVar) {
        if (lVar != null) {
            return (lVar.bAs() == null || StringUtils.isNull(lVar.bAs().wY(), true) || lVar.bAs().wY().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return ((lVar.bAb() == null || lVar.bAb().bAM() != 1) && lVar.bAr() == null && (lVar.bAc() == null || v.J(lVar.bAc().wX())) && ((lVar.beT() == null || lVar.beT().getFrsBannerData() == null || lVar.beT().getFrsBannerData().getType() != 2) && (lVar.bAt() == null || StringUtils.isNull(lVar.bAt().xf(), true)))) ? false : true;
        }
        return false;
    }

    public void mP(int i) {
        View findViewById;
        if (this.dVx != null && this.dVx.aGJ() != null && (findViewById = this.dVx.aGJ().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dVI != null) {
            this.dVI.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dVN = frsTabViewController;
    }
}
