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
    private LikeModel aHL;
    private FrsHeaderViewContainer dDQ;
    private final View.OnClickListener dDv;
    private FrsFragment dTm;
    private com.baidu.tieba.frs.view.b dWD;
    private int dWE;
    private int dWF;
    private String dWG;
    private Runnable dWH;
    private int dWI;
    private boolean dWJ;
    private w dWK;
    private boolean dWL;
    private com.baidu.tieba.frs.entelechy.b.a dWM;
    private boolean dWN;
    private com.baidu.tieba.f.a dWO;
    private boolean dWP;
    private com.baidu.tieba.frs.c.a.a dWQ;
    private com.baidu.tieba.frs.c.a.a dWR;
    private BdUniqueId dWS;
    private FrsTabViewController dWT;
    private AntiHelper.a dWU;
    private CustomMessageListener dWV;
    private Runnable dWW;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dDQ = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dWG = null;
        this.dWJ = false;
        this.aHL = null;
        this.dWK = null;
        this.dWL = false;
        this.dWP = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azo));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azo));
            }
        };
        this.dWU = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azq));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azq));
            }
        };
        this.dWV = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l azp;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.dTm != null && (customResponsedMessage instanceof SignMessage) && (azp = f.this.dTm.azp()) != null && azp.ber() != null && (name = azp.ber().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.dWS) {
                    TiebaStatic.eventStat(f.this.dTm.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = azp.ber().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.ai(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aG(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azo));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(azp.ber().getId())) {
                            f.this.op(name2);
                            azp.d(signData2);
                            signData2.forumId = azp.ber().getId();
                            signData2.forumName = azp.ber().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = azp.ber().getUser_level();
                        if (f.this.aFC()) {
                            i = azp.ber().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.dTm.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aFA()) {
                            f.this.dTm.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.dTm.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.dTm.ayY() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.HN().a(f.this.dTm.getTbPageContext(), f.this.dTm.ayY().aAg());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.ng(1);
                    }
                    f.this.dTm.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dWW = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dDQ != null) {
                    int childCount = f.this.dDQ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dDQ.getChildAt(i));
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
        this.dDv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l azp = f.this.dTm.azp();
                if (azp != null && azp.ber() != null && f.this.dWD != null && (view == f.this.dWD.aGi() || view == f.this.dWD.aGj() || view == f.this.dWD.aGk())) {
                    if (f.this.dTm != null && azp.ber() != null) {
                        TiebaStatic.log(new am("c12046").ax(ImageViewerConfig.FORUM_ID, azp.ber().getId()).x("obj_locate", f.this.dTm.azr() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), azp.ber().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.dTm.azq()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.dTm.showToast(e.j.neterror);
                        } else if (!ba.bG(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").x("obj_locate", 1).ax(ImageViewerConfig.FORUM_ID, f.this.dTm.getForumId()));
                        } else {
                            f.this.hn(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.ax(ImageViewerConfig.FORUM_ID, f.this.dTm.getForumId());
                                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.dTm.azq()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.dTm.showToast(e.j.neterror);
                        } else if (ba.bG(f.this.mContext.getPageActivity())) {
                            if (!f.this.aFB()) {
                                f.this.aFE();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dTm.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.dTm.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bG(f.this.mContext.getPageActivity()) && azp != null && azp.bzG() != null) {
                        ay.Db().a((TbPageContext) f.this.getPageContext(), new String[]{azp.bzG()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (azp != null && azp.getUserData() != null && azp.getUserData().isBawu()) {
                        String bzK = azp.bzK();
                        if (!ao.isEmpty(bzK)) {
                            com.baidu.tbadk.browser.a.ac(f.this.getPageContext().getPageActivity(), bzK);
                            if (azp.ber() != null) {
                                TiebaStatic.log(new am("c10502").ax(ImageViewerConfig.FORUM_ID, azp.ber().getId()).ax("uid", azp.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.dTm.azq() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.dWD != null) {
                        f.this.dWD.h(view, false);
                    }
                }
            }
        };
        this.dTm = frsFragment;
        this.dWM = aVar;
        this.dDQ = frsHeaderViewContainer;
        this.dWQ = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.dWR = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.dWS = BdUniqueId.gen();
        this.dWO = new com.baidu.tieba.f.a();
        this.dWO.a(new a.InterfaceC0204a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void ap(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void aq(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void ar(int i, int i2) {
            }
        });
    }

    public void q(Bundle bundle) {
        this.dTm.registerListener(this.dWV);
        ZD();
        aFF();
        this.dWJ = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dWD != null) {
            this.dWD.onDestory();
        }
        if (this.aHL != null) {
            this.aHL.bAM();
        }
        if (this.dWH != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dWH);
        }
    }

    public void onActivityStop() {
        if (this.dWD != null) {
            this.dWD.onStop();
        }
        if (this.dDQ != null) {
            this.dDQ.removeCallbacks(this.dWW);
        }
    }

    public void gt(boolean z) {
        if (this.dWD != null) {
            this.dWD.gt(z);
        }
    }

    public boolean nc(int i) {
        this.mSkinType = i;
        if (this.dWD != null) {
            this.dWD.changeSkinType(i);
        }
        if (this.dWQ != null) {
            this.dWQ.onChangeSkinType(i);
        }
        if (this.dWR != null) {
            this.dWR.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void hm(boolean z) {
        if (z) {
            if (this.dWD != null) {
                this.dDQ.removeHeaderView(this.dWD.aGh());
                this.dWL = false;
            }
        } else if (this.dWD != null && this.dWD.aGh() != null && !this.dWL) {
            this.dDQ.addHeaderView(this.dWD.aGh(), this.dDQ.getHeaderViewsCount());
            this.dWL = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bzy() != null && lVar.bzy().xf() != null && lVar.bzy().xf().size() >= 1) {
                a(lVar.bzy().xf().get(0), false);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bzx() != null && !StringUtils.isNull(lVar.bzx().bAm())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bzx().bAm());
                a(qVar, true);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bzy() != null && lVar.bzy().xf() != null && lVar.bzy().xf().size() >= 1) {
                t(str, lVar.getUserData().getIsMem(), lVar.ber().isLike());
                g(lVar);
            } else {
                this.dWP = false;
                if (this.dDQ != null && this.dWQ != null && this.dWQ.getHeaderView() != null) {
                    this.dDQ.removeHeaderView(this.dWQ.getHeaderView());
                }
                if (this.dDQ != null && this.dWR != null && this.dWR.getHeaderView() != null) {
                    this.dDQ.removeHeaderView(this.dWR.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.ber() != null && !"brand_page".equals(str)) {
                s(str, lVar.getUserData().getIsMem(), lVar.ber().isLike());
            }
        }
    }

    public boolean aFt() {
        return this.dWP;
    }

    private void a(q qVar, boolean z) {
        if (qVar == null) {
            this.dWP = false;
        } else if (this.dDQ == null || this.dWQ == null || this.dWQ.getHeaderView() == null) {
            this.dWP = false;
        } else {
            this.dWP = true;
            this.dDQ.removeHeaderView(this.dWQ.getHeaderView());
            this.dDQ.addHeaderView(this.dWQ.getHeaderView());
            this.dWQ.iI(qVar.getImageUrl());
            this.dWQ.setTitle(qVar.getTitle());
            this.dWQ.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.dWQ.hideTitle();
            }
        }
    }

    private void g(l lVar) {
        if (lVar == null || lVar.bzy() == null || v.I(lVar.bzy().xf()) || this.dDQ == null || this.dWD == null || this.dWD.getView() == null || this.dWR == null || this.dWR.getHeaderView() == null) {
            this.dWP = false;
            return;
        }
        q qVar = lVar.bzy().xf().get(0);
        if (qVar == null) {
            this.dWP = false;
            return;
        }
        this.dWP = true;
        this.dWD.getView().setBackgroundColor(0);
        this.dWR.aEh().removeView(this.dWD.getView());
        this.dWR.aEh().addView(this.dWD.getView());
        this.dDQ.removeHeaderView(this.dWR.getHeaderView());
        this.dDQ.addHeaderView(this.dWR.getHeaderView());
        this.dWR.iI(qVar.getImageUrl());
        this.dWR.setSchemaUrl(qVar.getLinkUrl());
        this.dWR.setTitle(qVar.getTitle());
        if (this.dWR instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.dWR).bK(lVar.hcG);
        }
    }

    private void s(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dWG, str);
        this.dWI = i2;
        this.dWG = str;
        aFv();
        if (this.dWD == null || z) {
            this.dWD = this.dWM.a(str, this.dTm, i);
            this.dWD.changeSkinType(this.mSkinType);
            this.dWD.s(this.dDv);
        }
        this.dDQ.addHeaderView(this.dWD.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds44);
        this.dWD.q(0, h, 0, h);
        aFw();
        if (this.dWT != null) {
            this.dWT.aT(this.dWD.aBF());
        }
    }

    private void t(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dWG, str);
        this.dWI = i2;
        this.dWG = str;
        aFv();
        if (this.dWD == null || z) {
            this.dWD = this.dWM.a(str, this.dTm, i);
            this.dWD.changeSkinType(this.mSkinType);
            this.dWD.s(this.dDv);
            this.dWD.aBK();
        }
        this.dWD.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds44));
        aFw();
        if (this.dWT != null) {
            this.dWT.aT(this.dWD.aBF());
        }
    }

    public void aFu() {
        if (!this.dWL && this.dWD != null) {
            this.dDQ.addHeaderView(this.dWD.aGh());
            if (this.dWD.aBF() != null && this.dTm.Eq() != null) {
                this.dTm.Eq().addHeaderView(this.dWD.aBF(), 0);
            }
            this.dWL = true;
        }
    }

    private void aFv() {
        if (("normal_page".equals(this.dWG) || "frs_page".equals(this.dWG) || "book_page".equals(this.dWG) || "brand_page".equals(this.dWG)) && this.dWD != null) {
            this.dDQ.removeHeaderView(this.dWD.getView());
            this.dDQ.removeHeaderView(this.dWD.aGh());
            if (this.dWD.aBF() != null && this.dTm.Eq() != null) {
                this.dTm.Eq().removeHeaderView(this.dWD.aBF());
            }
        }
        this.dWL = false;
    }

    private void aFw() {
        if (this.dWH == null) {
            this.dWH = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dTm.ayY() == null || !f.this.dTm.ayY().azq()) && f.this.dDQ.isShown() && f.this.dTm.isPrimary() && !f.this.dWJ && f.this.dWI == 1 && f.this.dTm.ayY() != null && f.this.dTm.ayY().azP() != null && !f.this.dTm.ayY().azP().aCq() && f.this.dTm.azu()) {
                            if (("frs_page".equals(f.this.dWG) || "normal_page".equals(f.this.dWG) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.dWG)) && f.this.dWD != null && f.this.dWD.aGg()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aBS();
                                f.this.dTm.dBr = true;
                                f.this.dWJ = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.dWH, 4000L);
    }

    public void h(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.ber(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.dWD.aBL();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.dWD != null) {
                this.dWD.a(forumData, lVar);
                this.dWD.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.dWD.nx(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dWD.hw(false);
                        return;
                    }
                    this.dWD.hw(true);
                    this.dWD.nx(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dWE = forumData.getLevelupScore();
        this.dWF = forumData.getCurScore();
        if (this.dWE > 0) {
            return this.dWF / this.dWE;
        }
        return 0.0f;
    }

    public void nd(int i) {
        if (i > 1) {
            if (this.dWD != null) {
                this.dWD.hx(false);
            }
        } else if (this.dWD != null) {
            this.dWD.hx(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aFx() {
        if (this.dDQ != null) {
            this.dDQ.removeCallbacks(this.dWW);
            this.dDQ.postDelayed(this.dWW, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aFy();
        }
    }

    public void setIsMem(int i) {
        if (this.dWD != null) {
            this.dWD.setMemberType(i);
        }
    }

    public void aBS() {
        if (("normal_page".equals(this.dWG) || "frs_page".equals(this.dWG) || "book_page".equals(this.dWG) || "brand_page".equals(this.mPageType)) && this.dWD != null) {
            this.dWD.aBS();
        }
    }

    public void aFy() {
        if (this.dWD != null) {
            this.dWD.aBU();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.ber(), lVar, z);
            }
        }
    }

    public void aFz() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nf(0);
        }
    }

    public void ne(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nf(i);
        }
    }

    public void nf(int i) {
        if (this.dWD != null) {
            this.dWD.nw(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dWD != null) {
            this.dWD.a(forumData, lVar);
            if (forumData != null) {
                this.dWD.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dWD.hw(false);
                }
            }
        }
    }

    public boolean aFA() {
        if (("normal_page".equals(this.dWG) || "frs_page".equals(this.dWG) || "book_page".equals(this.dWG) || "brand_page".equals(this.mPageType)) && this.dWD != null) {
            return this.dWD.aGf();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dWE - this.dWF) {
                z = true;
                this.dWE = signData.levelup_score;
            }
            this.dWF = i + this.dWF;
            if (this.dWF > this.dWE) {
                this.dWF = this.dWE;
            }
            if (this.dWE != 0) {
                f = this.dWF / this.dWE;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void ng(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dWD != null) {
            this.dWD.nx(i);
        }
    }

    public void i(l lVar) {
        SignData signData;
        ForumData ber;
        if (lVar != null && lVar.ber() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.dWD != null && (signData = lVar.ber().getSignData()) != null && (ber = lVar.ber()) != null) {
                this.dWD.a(ber, lVar);
                this.dWD.nx(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dWD.aGf()) {
                    a(this.dWD, signData);
                    ber.setCurScore(this.dWF);
                    ber.setLevelupScore(this.dWE);
                    this.dWD.a(ber, lVar);
                }
            }
        }
    }

    public boolean aFB() {
        if (("normal_page".equals(this.dWG) || "frs_page".equals(this.dWG) || "book_page".equals(this.dWG) || "brand_page".equals(this.mPageType)) && this.dWD != null) {
            return this.dWD.aFB();
        }
        return false;
    }

    public boolean aFC() {
        if (("normal_page".equals(this.dWG) || "frs_page".equals(this.dWG) || "book_page".equals(this.dWG) || "brand_page".equals(this.mPageType)) && this.dWD != null) {
            return this.dWD.aFC();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void hn(boolean z) {
        if (this.dTm != null) {
            l azp = this.dTm.azp();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dTm.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (azp != null && azp.ber() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dTm.getFrom())) {
                    TiebaStatic.log(new am("c10356").ax(ImageViewerConfig.FORUM_ID, azp.ber().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dTm.getFrom())) {
                    TiebaStatic.log(new am("c10590").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azp.ber().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dTm.getFrom())) {
                    TiebaStatic.log(new am("c10587").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azp.ber().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dTm.getFrom())) {
                    TiebaStatic.log(new am("c10578").x("obj_type", 2).ax(ImageViewerConfig.FORUM_ID, azp.ber().getId()));
                }
                this.aHL.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dTm.getFrom())) {
                    TiebaStatic.eventStat(this.dTm.getPageContext().getPageActivity(), "square_frs_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dTm.getFrom())) {
                    TiebaStatic.log(new am("c10359").ax(ImageViewerConfig.FORUM_ID, azp.ber().getId()));
                }
                this.aHL.P(azp.ber().getName(), azp.ber().getId(), "FRS");
                this.dWN = z;
            }
        }
    }

    public void aFD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dTm.azp() != null && this.dTm.azp().ber() != null && this.dTm.azp().ber().getName() != null) {
            str = this.dTm.azp().ber().getName();
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
                l azp = f.this.dTm.azp();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dTm.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (azp != null && azp.ber() != null) {
                    f.this.dWK.v(azp.ber().getName(), com.baidu.adp.lib.g.b.d(azp.ber().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(e.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AB();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aFE() {
        l azp = this.dTm.azp();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dTm.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (azp != null && azp.ber() != null) {
            FrsActivityStatic.forumName = azp.ber().getName() == null ? "" : azp.ber().getName();
            CustomMessage customMessage = new CustomMessage(2001425, azp.ber());
            customMessage.setTag(this.dWS);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(String str) {
        if (this.dTm.ayT() != null && this.dTm.ayT().aEw() != null) {
            com.baidu.tieba.tbadkCore.c.bzj().ab(com.baidu.tieba.tbadkCore.c.bzj().d(str, this.dTm.ayT().aEw().aaT(), this.dTm.ayT().aEw().getIsGood(), this.dTm.ayT().aEw().getCategoryId()), false);
        }
    }

    private void ZD() {
        this.aHL = new LikeModel(this.dTm.getPageContext());
        this.aHL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                l azp = f.this.dTm.azp();
                if (azp != null && azp.ber() != null && obj != null) {
                    if (AntiHelper.ai(f.this.aHL.getErrorCode(), f.this.aHL.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aHL.getBlockPopInfoData(), f.this.dWU) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azq));
                            return;
                        }
                        return;
                    }
                    String name = azp.ber().getName();
                    String id = azp.ber().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.aHL.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).AJ();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.aHL.getErrorCode() == 22) {
                            f.this.dTm.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.dTm.showToast(f.this.aHL.getErrorString());
                        }
                    } else {
                        f.this.op(name);
                        rVar.setLike(1);
                        azp.c(rVar);
                        azp.dD(rVar.bzq());
                        f.this.a(azp, f.this.dWN);
                        f.this.dWN = true;
                        f.this.dTm.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.g(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dTm.ad(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aFF() {
        this.dWK = new w();
        this.dWK.setFrom("from_frs");
        this.dWK.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void o(String str, long j) {
                l azp = f.this.dTm.azp();
                if (azp != null && azp.ber() != null) {
                    String name = azp.ber().getName();
                    String id = azp.ber().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.op(str);
                        azp.ber().setLike(0);
                        f.this.ne(0);
                        f.this.dTm.ac(true);
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
            public void p(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aSs().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void F(int i, int i2, int i3) {
        l azp;
        if (i > 0 && i2 > 0 && (azp = this.dTm.azp()) != null && azp.ber() != null && azp.getSignData() != null) {
            ForumData ber = azp.ber();
            SignData signData = azp.getSignData();
            signData.levelup_score = ber.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            azp.d(signData);
            signData.forumId = ber.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aFC()) {
                i4 = ber.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(ber.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void aBC() {
        if (this.dWD != null) {
            this.dWD.aBC();
        }
    }

    public static boolean j(l lVar) {
        if (lVar != null) {
            return (lVar.bzO() == null || StringUtils.isNull(lVar.bzO().xg(), true) || lVar.bzO().xg().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return ((lVar.bzx() == null || lVar.bzx().bAi() != 1) && lVar.bzN() == null && (lVar.bzy() == null || v.I(lVar.bzy().xf())) && ((lVar.ber() == null || lVar.ber().getFrsBannerData() == null || lVar.ber().getFrsBannerData().getType() != 2) && (lVar.bzP() == null || StringUtils.isNull(lVar.bzP().xn(), true)))) ? false : true;
        }
        return false;
    }

    public void nh(int i) {
        View findViewById;
        if (this.dWD != null && this.dWD.aGh() != null && (findViewById = this.dWD.aGh().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dWO != null) {
            this.dWO.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.dWT = frsTabViewController;
    }
}
