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
    private FrsFragment dSf;
    private Runnable dVA;
    private int dVB;
    private boolean dVC;
    private w dVD;
    private boolean dVE;
    private com.baidu.tieba.frs.entelechy.b.a dVF;
    private boolean dVG;
    private com.baidu.tieba.f.a dVH;
    private boolean dVI;
    private com.baidu.tieba.frs.c.a.a dVJ;
    private com.baidu.tieba.frs.c.a.a dVK;
    private BdUniqueId dVL;
    private FrsTabViewController dVM;
    private AntiHelper.a dVN;
    private CustomMessageListener dVO;
    private Runnable dVP;
    private com.baidu.tieba.frs.view.b dVw;
    private int dVx;
    private int dVy;
    private String dVz;
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
        this.dVz = null;
        this.dVC = false;
        this.aGV = null;
        this.dVD = null;
        this.dVE = false;
        this.dVI = false;
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
        this.dVN = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayD));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayD));
            }
        };
        this.dVO = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l azR;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.dSf != null && (customResponsedMessage instanceof SignMessage) && (azR = f.this.dSf.azR()) != null && azR.beT() != null && (name = azR.beT().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.dVL) {
                    TiebaStatic.eventStat(f.this.dSf.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = azR.beT().getName();
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
                        if (signData2.forumId != null && signData2.forumId.equals(azR.beT().getId())) {
                            f.this.oo(name2);
                            azR.d(signData2);
                            signData2.forumId = azR.beT().getId();
                            signData2.forumName = azR.beT().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = azR.beT().getUser_level();
                        if (f.this.aGg()) {
                            i = azR.beT().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.dSf.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aGe()) {
                            f.this.dSf.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.dSf.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.dSf.azA() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.HB().a(f.this.dSf.getTbPageContext(), f.this.dSf.azA().aAI());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.mO(1);
                    }
                    f.this.dSf.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dVP = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
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
                l azR = f.this.dSf.azR();
                if (azR != null && azR.beT() != null && f.this.dVw != null && (view == f.this.dVw.aGK() || view == f.this.dVw.aGL() || view == f.this.dVw.aGM())) {
                    if (f.this.dSf != null && azR.beT() != null) {
                        TiebaStatic.log(new am("c12046").ax(ImageViewerConfig.FORUM_ID, azR.beT().getId()).x("obj_locate", f.this.dSf.azT() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), azR.beT().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.dSf.azS()) {
                        if (!com.baidu.adp.lib.util.j.kX()) {
                            f.this.dSf.showToast(e.j.neterror);
                        } else if (!ba.bI(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").x("obj_locate", 1).ax(ImageViewerConfig.FORUM_ID, f.this.dSf.getForumId()));
                        } else {
                            f.this.hd(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.ax(ImageViewerConfig.FORUM_ID, f.this.dSf.getForumId());
                                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.dSf.azS()) {
                        if (!com.baidu.adp.lib.util.j.kX()) {
                            f.this.dSf.showToast(e.j.neterror);
                        } else if (ba.bI(f.this.mContext.getPageActivity())) {
                            if (!f.this.aGf()) {
                                f.this.aGi();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dSf.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.dSf.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bI(f.this.mContext.getPageActivity()) && azR != null && azR.bAk() != null) {
                        ay.CU().a((TbPageContext) f.this.getPageContext(), new String[]{azR.bAk()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (azR != null && azR.getUserData() != null && azR.getUserData().isBawu()) {
                        String bAo = azR.bAo();
                        if (!ao.isEmpty(bAo)) {
                            com.baidu.tbadk.browser.a.ae(f.this.getPageContext().getPageActivity(), bAo);
                            if (azR.beT() != null) {
                                TiebaStatic.log(new am("c10502").ax(ImageViewerConfig.FORUM_ID, azR.beT().getId()).ax("uid", azR.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.dSf.azS() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.dVw != null) {
                        f.this.dVw.i(view, false);
                    }
                }
            }
        };
        this.dSf = frsFragment;
        this.dVF = aVar;
        this.dCA = frsHeaderViewContainer;
        this.dVJ = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.dVK = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.dVL = BdUniqueId.gen();
        this.dVH = new com.baidu.tieba.f.a();
        this.dVH.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.frs.vc.f.6
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
        this.dSf.registerListener(this.dVO);
        Zs();
        aGj();
        this.dVC = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dVw != null) {
            this.dVw.onDestory();
        }
        if (this.aGV != null) {
            this.aGV.bBq();
        }
        if (this.dVA != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dVA);
        }
    }

    public void onActivityStop() {
        if (this.dVw != null) {
            this.dVw.onStop();
        }
        if (this.dCA != null) {
            this.dCA.removeCallbacks(this.dVP);
        }
    }

    public void gj(boolean z) {
        if (this.dVw != null) {
            this.dVw.gj(z);
        }
    }

    public boolean mK(int i) {
        this.mSkinType = i;
        if (this.dVw != null) {
            this.dVw.changeSkinType(i);
        }
        if (this.dVJ != null) {
            this.dVJ.onChangeSkinType(i);
        }
        if (this.dVK != null) {
            this.dVK.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void hc(boolean z) {
        if (z) {
            if (this.dVw != null) {
                this.dCA.removeHeaderView(this.dVw.aGJ());
                this.dVE = false;
            }
        } else if (this.dVw != null && this.dVw.aGJ() != null && !this.dVE) {
            this.dCA.addHeaderView(this.dVw.aGJ(), this.dCA.getHeaderViewsCount());
            this.dVE = true;
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
                this.dVI = false;
                if (this.dCA != null && this.dVJ != null && this.dVJ.getHeaderView() != null) {
                    this.dCA.removeHeaderView(this.dVJ.getHeaderView());
                }
                if (this.dCA != null && this.dVK != null && this.dVK.getHeaderView() != null) {
                    this.dCA.removeHeaderView(this.dVK.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.beT() != null && !"brand_page".equals(str)) {
                s(str, lVar.getUserData().getIsMem(), lVar.beT().isLike());
            }
        }
    }

    public boolean aFX() {
        return this.dVI;
    }

    private void a(q qVar, boolean z) {
        if (qVar == null) {
            this.dVI = false;
        } else if (this.dCA == null || this.dVJ == null || this.dVJ.getHeaderView() == null) {
            this.dVI = false;
        } else {
            this.dVI = true;
            this.dCA.removeHeaderView(this.dVJ.getHeaderView());
            this.dCA.addHeaderView(this.dVJ.getHeaderView());
            this.dVJ.iG(qVar.getImageUrl());
            this.dVJ.setTitle(qVar.getTitle());
            this.dVJ.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.dVJ.hideTitle();
            }
        }
    }

    private void g(l lVar) {
        if (lVar == null || lVar.bAc() == null || v.J(lVar.bAc().wX()) || this.dCA == null || this.dVw == null || this.dVw.getView() == null || this.dVK == null || this.dVK.getHeaderView() == null) {
            this.dVI = false;
            return;
        }
        q qVar = lVar.bAc().wX().get(0);
        if (qVar == null) {
            this.dVI = false;
            return;
        }
        this.dVI = true;
        this.dVw.getView().setBackgroundColor(0);
        this.dVK.aEL().removeView(this.dVw.getView());
        this.dVK.aEL().addView(this.dVw.getView());
        this.dCA.removeHeaderView(this.dVK.getHeaderView());
        this.dCA.addHeaderView(this.dVK.getHeaderView());
        this.dVK.iG(qVar.getImageUrl());
        this.dVK.setSchemaUrl(qVar.getLinkUrl());
        this.dVK.setTitle(qVar.getTitle());
        if (this.dVK instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.dVK).bM(lVar.hbi);
        }
    }

    private void s(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dVz, str);
        this.dVB = i2;
        this.dVz = str;
        aFZ();
        if (this.dVw == null || z) {
            this.dVw = this.dVF.a(str, this.dSf, i);
            this.dVw.changeSkinType(this.mSkinType);
            this.dVw.q(this.dCe);
        }
        this.dCA.addHeaderView(this.dVw.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds44);
        this.dVw.q(0, h, 0, h);
        aGa();
        if (this.dVM != null) {
            this.dVM.aR(this.dVw.aCk());
        }
    }

    private void t(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dVz, str);
        this.dVB = i2;
        this.dVz = str;
        aFZ();
        if (this.dVw == null || z) {
            this.dVw = this.dVF.a(str, this.dSf, i);
            this.dVw.changeSkinType(this.mSkinType);
            this.dVw.q(this.dCe);
            this.dVw.aCp();
        }
        this.dVw.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds44));
        aGa();
        if (this.dVM != null) {
            this.dVM.aR(this.dVw.aCk());
        }
    }

    public void aFY() {
        if (!this.dVE && this.dVw != null) {
            this.dCA.addHeaderView(this.dVw.aGJ());
            if (this.dVw.aCk() != null && this.dSf.Eg() != null) {
                this.dSf.Eg().addHeaderView(this.dVw.aCk(), 0);
            }
            this.dVE = true;
        }
    }

    private void aFZ() {
        if (("normal_page".equals(this.dVz) || "frs_page".equals(this.dVz) || "book_page".equals(this.dVz) || "brand_page".equals(this.dVz)) && this.dVw != null) {
            this.dCA.removeHeaderView(this.dVw.getView());
            this.dCA.removeHeaderView(this.dVw.aGJ());
            if (this.dVw.aCk() != null && this.dSf.Eg() != null) {
                this.dSf.Eg().removeHeaderView(this.dVw.aCk());
            }
        }
        this.dVE = false;
    }

    private void aGa() {
        if (this.dVA == null) {
            this.dVA = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dSf.azA() == null || !f.this.dSf.azA().azS()) && f.this.dCA.isShown() && f.this.dSf.isPrimary() && !f.this.dVC && f.this.dVB == 1 && f.this.dSf.azA() != null && f.this.dSf.azA().aAr() != null && !f.this.dSf.azA().aAr().aCV() && f.this.dSf.azW()) {
                            if (("frs_page".equals(f.this.dVz) || "normal_page".equals(f.this.dVz) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.dVz)) && f.this.dVw != null && f.this.dVw.aGI()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aCx();
                                f.this.dSf.dAa = true;
                                f.this.dVC = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jI().postDelayed(this.dVA, 4000L);
    }

    public void h(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.beT(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.dVw.aCq();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dVw != null) {
                this.dVw.a(forumData, lVar);
                this.dVw.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dVw.nf(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dVw.hm(false);
                        return;
                    }
                    this.dVw.hm(true);
                    this.dVw.nf(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dVx = forumData.getLevelupScore();
        this.dVy = forumData.getCurScore();
        if (this.dVx > 0) {
            return this.dVy / this.dVx;
        }
        return 0.0f;
    }

    public void mL(int i) {
        if (i > 1) {
            if (this.dVw != null) {
                this.dVw.hn(false);
            }
        } else if (this.dVw != null) {
            this.dVw.hn(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aGb() {
        if (this.dCA != null) {
            this.dCA.removeCallbacks(this.dVP);
            this.dCA.postDelayed(this.dVP, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aGc();
        }
    }

    public void setIsMem(int i) {
        if (this.dVw != null) {
            this.dVw.setMemberType(i);
        }
    }

    public void aCx() {
        if (("normal_page".equals(this.dVz) || "frs_page".equals(this.dVz) || "book_page".equals(this.dVz) || "brand_page".equals(this.mPageType)) && this.dVw != null) {
            this.dVw.aCx();
        }
    }

    public void aGc() {
        if (this.dVw != null) {
            this.dVw.aCz();
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
        if (this.dVw != null) {
            this.dVw.ne(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dVw != null) {
            this.dVw.a(forumData, lVar);
            if (forumData != null) {
                this.dVw.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dVw.hm(false);
                }
            }
        }
    }

    public boolean aGe() {
        if (("normal_page".equals(this.dVz) || "frs_page".equals(this.dVz) || "book_page".equals(this.dVz) || "brand_page".equals(this.mPageType)) && this.dVw != null) {
            return this.dVw.aGH();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dVx - this.dVy) {
                z = true;
                this.dVx = signData.levelup_score;
            }
            this.dVy = i + this.dVy;
            if (this.dVy > this.dVx) {
                this.dVy = this.dVx;
            }
            if (this.dVx != 0) {
                f = this.dVy / this.dVx;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void mO(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dVw != null) {
            this.dVw.nf(i);
        }
    }

    public void i(l lVar) {
        SignData signData;
        ForumData beT;
        if (lVar != null && lVar.beT() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dVw != null && (signData = lVar.beT().getSignData()) != null && (beT = lVar.beT()) != null) {
                this.dVw.a(beT, lVar);
                this.dVw.nf(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dVw.aGH()) {
                    a(this.dVw, signData);
                    beT.setCurScore(this.dVy);
                    beT.setLevelupScore(this.dVx);
                    this.dVw.a(beT, lVar);
                }
            }
        }
    }

    public boolean aGf() {
        if (("normal_page".equals(this.dVz) || "frs_page".equals(this.dVz) || "book_page".equals(this.dVz) || "brand_page".equals(this.mPageType)) && this.dVw != null) {
            return this.dVw.aGf();
        }
        return false;
    }

    public boolean aGg() {
        if (("normal_page".equals(this.dVz) || "frs_page".equals(this.dVz) || "book_page".equals(this.dVz) || "brand_page".equals(this.mPageType)) && this.dVw != null) {
            return this.dVw.aGg();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void hd(boolean z) {
        if (this.dSf != null) {
            l azR = this.dSf.azR();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dSf.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (azR != null && azR.beT() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dSf.getFrom())) {
                    TiebaStatic.log(new am("c10356").ax(ImageViewerConfig.FORUM_ID, azR.beT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dSf.getFrom())) {
                    TiebaStatic.log(new am("c10590").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azR.beT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dSf.getFrom())) {
                    TiebaStatic.log(new am("c10587").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azR.beT().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dSf.getFrom())) {
                    TiebaStatic.log(new am("c10578").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azR.beT().getId()));
                }
                this.aGV.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dSf.getFrom())) {
                    TiebaStatic.eventStat(this.dSf.getPageContext().getPageActivity(), "square_frs_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dSf.getFrom())) {
                    TiebaStatic.log(new am("c10359").ax(ImageViewerConfig.FORUM_ID, azR.beT().getId()));
                }
                this.aGV.P(azR.beT().getName(), azR.beT().getId(), "FRS");
                this.dVG = z;
            }
        }
    }

    public void aGh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dSf.azR() != null && this.dSf.azR().beT() != null && this.dSf.azR().beT().getName() != null) {
            str = this.dSf.azR().beT().getName();
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
                l azR = f.this.dSf.azR();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dSf.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (azR != null && azR.beT() != null) {
                    f.this.dVD.w(azR.beT().getName(), com.baidu.adp.lib.g.b.d(azR.beT().getId(), 0L));
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
        l azR = this.dSf.azR();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dSf.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (azR != null && azR.beT() != null) {
            FrsActivityStatic.forumName = azR.beT().getName() == null ? "" : azR.beT().getName();
            CustomMessage customMessage = new CustomMessage(2001425, azR.beT());
            customMessage.setTag(this.dVL);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(String str) {
        if (this.dSf.azv() != null && this.dSf.azv().aFa() != null) {
            com.baidu.tieba.tbadkCore.c.bzN().ab(com.baidu.tieba.tbadkCore.c.bzN().d(str, this.dSf.azv().aFa().aaI(), this.dSf.azv().aFa().getIsGood(), this.dSf.azv().aFa().getCategoryId()), false);
        }
    }

    private void Zs() {
        this.aGV = new LikeModel(this.dSf.getPageContext());
        this.aGV.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                l azR = f.this.dSf.azR();
                if (azR != null && azR.beT() != null && obj != null) {
                    if (AntiHelper.am(f.this.aGV.getErrorCode(), f.this.aGV.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aGV.getBlockPopInfoData(), f.this.dVN) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayD));
                            return;
                        }
                        return;
                    }
                    String name = azR.beT().getName();
                    String id = azR.beT().getId();
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
                            f.this.dSf.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.dSf.showToast(f.this.aGV.getErrorString());
                        }
                    } else {
                        f.this.oo(name);
                        rVar.setLike(1);
                        azR.c(rVar);
                        azR.dF(rVar.bzU());
                        f.this.a(azR, f.this.dVG);
                        f.this.dVG = true;
                        f.this.dSf.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.h(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dSf.ae(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aGj() {
        this.dVD = new w();
        this.dVD.setFrom("from_frs");
        this.dVD.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                l azR = f.this.dSf.azR();
                if (azR != null && azR.beT() != null) {
                    String name = azR.beT().getName();
                    String id = azR.beT().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.oo(str);
                        azR.beT().setLike(0);
                        f.this.mM(0);
                        f.this.dSf.ad(true);
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
        l azR;
        if (i > 0 && i2 > 0 && (azR = this.dSf.azR()) != null && azR.beT() != null && azR.getSignData() != null) {
            ForumData beT = azR.beT();
            SignData signData = azR.getSignData();
            signData.levelup_score = beT.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            azR.d(signData);
            signData.forumId = beT.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aGg()) {
                i4 = beT.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(beT.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void aCh() {
        if (this.dVw != null) {
            this.dVw.aCh();
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
        if (this.dVw != null && this.dVw.aGJ() != null && (findViewById = this.dVw.aGJ().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dVH != null) {
            this.dVH.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dVM = frsTabViewController;
    }
}
