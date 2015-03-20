package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.tbadkCore.aa {
    final /* synthetic */ FrsActivity aJG;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aa
    public void eG(int i) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                bfVar3 = this.aJG.aIS;
                bfVar3.bS(true);
                bfVar4 = this.aJG.aIS;
                bfVar4.Kb();
                return;
            case 2:
                bfVar = this.aJG.aIS;
                bfVar.bT(true);
                bfVar2 = this.aJG.aIS;
                bfVar2.Kb();
                return;
            case 3:
                bfVar5 = this.aJG.aIS;
                bfVar5.bR(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0543  */
    @Override // com.baidu.tieba.tbadkCore.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, com.baidu.tieba.tbadkCore.h hVar) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        bf bfVar7;
        boolean z2;
        bf bfVar8;
        bf bfVar9;
        bf bfVar10;
        bf bfVar11;
        bf bfVar12;
        bf bfVar13;
        com.baidu.tieba.frs.c.k kVar;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        bf bfVar14;
        com.baidu.tieba.tbadkCore.w wVar5;
        boolean z3;
        com.baidu.tieba.tbadkCore.w wVar6;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.w wVar7;
        com.baidu.tieba.tbadkCore.w wVar8;
        com.baidu.tieba.tbadkCore.w wVar9;
        com.baidu.tieba.frs.c.k kVar2;
        com.baidu.tieba.tbadkCore.w wVar10;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.tbadkCore.w wVar11;
        com.baidu.tieba.frs.c.a aVar3;
        bf bfVar15;
        com.baidu.tieba.tbadkCore.w wVar12;
        com.baidu.tieba.frs.c.k kVar3;
        com.baidu.tieba.tbadkCore.w wVar13;
        com.baidu.tieba.tbadkCore.w wVar14;
        com.baidu.tieba.tbadkCore.w wVar15;
        com.baidu.tieba.frs.c.k kVar4;
        com.baidu.tieba.tbadkCore.w wVar16;
        com.baidu.tieba.tbadkCore.w wVar17;
        int i2;
        int i3;
        com.baidu.tieba.tbadkCore.w wVar18;
        com.baidu.tieba.tbadkCore.w wVar19;
        com.baidu.tieba.tbadkCore.w wVar20;
        com.baidu.tieba.tbadkCore.w wVar21;
        bf bfVar16;
        com.baidu.tieba.tbadkCore.w wVar22;
        com.baidu.tieba.tbadkCore.w wVar23;
        com.baidu.tieba.tbadkCore.w wVar24;
        com.baidu.tieba.tbadkCore.w wVar25;
        com.baidu.tieba.tbadkCore.w wVar26;
        com.baidu.tieba.tbadkCore.w wVar27;
        bf bfVar17;
        com.baidu.tieba.tbadkCore.w wVar28;
        com.baidu.tieba.tbadkCore.w wVar29;
        com.baidu.tieba.frs.c.a aVar4;
        com.baidu.tieba.tbadkCore.w wVar30;
        bf bfVar18;
        if (hVar != null && hVar.isSuccess) {
            bfVar18 = this.aJG.aIS;
            bfVar18.Kk().bG(com.baidu.tbadk.core.util.be.sY().ta());
            FrsActivity.aJb = 0L;
            FrsActivity.aJc = 0L;
            FrsActivity.aJd = 0;
        } else {
            FrsActivity.aJd = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bfVar = this.aJG.aIS;
        bfVar.bR(false);
        switch (i) {
            case 1:
                bfVar4 = this.aJG.aIS;
                bfVar4.bS(false);
                bfVar5 = this.aJG.aIS;
                bfVar5.Kb();
                break;
            case 2:
                bfVar2 = this.aJG.aIS;
                bfVar2.bT(false);
                bfVar3 = this.aJG.aIS;
                bfVar3.Kb();
                break;
        }
        if (this.aJG.oi().KG() != null) {
            this.aJG.aIV = this.aJG.oi().KG();
        }
        FrsActivity frsActivity = this.aJG;
        bfVar6 = this.aJG.aIS;
        frsActivity.hideLoadingView(bfVar6.getRootView());
        bfVar7 = this.aJG.aIS;
        bfVar7.Ki();
        if (z || (hVar != null && hVar.errorCode != 0)) {
            z2 = this.aJG.aII;
            if (!z2) {
                if (hVar != null) {
                    if (hVar.ckr) {
                        if (340001 == hVar.errorCode) {
                            FrsActivity frsActivity2 = this.aJG;
                            bfVar13 = this.aJG.aIS;
                            frsActivity2.showNetRefreshViewNoClick(bfVar13.Kl(), this.aJG.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), false);
                        } else {
                            FrsActivity frsActivity3 = this.aJG;
                            bfVar12 = this.aJG.aIS;
                            frsActivity3.showNetRefreshView(bfVar12.Kl(), this.aJG.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), false);
                        }
                    } else if (340001 == hVar.errorCode) {
                        FrsActivity frsActivity4 = this.aJG;
                        bfVar10 = this.aJG.aIS;
                        frsActivity4.showNetRefreshViewNoClick(bfVar10.Kl(), hVar.errorMsg, false);
                    } else {
                        FrsActivity frsActivity5 = this.aJG;
                        bfVar9 = this.aJG.aIS;
                        frsActivity5.showNetRefreshView(bfVar9.Kl(), hVar.errorMsg, false);
                    }
                    bfVar11 = this.aJG.aIS;
                    bfVar11.eP(8);
                }
            } else if (hVar != null && hVar.ckr) {
                bfVar8 = this.aJG.aIS;
                bfVar8.eP(0);
                this.aJG.showToast(this.aJG.getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)));
            }
        } else {
            this.aJG.aII = true;
            this.aJG.aIR = true;
            bfVar14 = this.aJG.aIS;
            bfVar14.eP(0);
            wVar5 = this.aJG.aIV;
            if (wVar5 != null) {
                FrsActivity frsActivity6 = this.aJG;
                wVar25 = this.aJG.aIV;
                frsActivity6.aIK = wVar25.YO().getName();
                FrsActivity frsActivity7 = this.aJG;
                wVar26 = this.aJG.aIV;
                frsActivity7.forumId = wVar26.YO().getId();
                wVar27 = this.aJG.aIV;
                if (wVar27.YO().getFrsBannerData().getType() == 2) {
                    aVar4 = this.aJG.aJl;
                    wVar30 = this.aJG.aIV;
                    aVar4.eR(wVar30.getUserData().getIsMem());
                    this.aJG.aIU = true;
                }
                bfVar17 = this.aJG.aIS;
                wVar28 = this.aJG.aIV;
                ForumData YO = wVar28.YO();
                wVar29 = this.aJG.aIV;
                bfVar17.a(YO, wVar29.getUserData());
            }
            z3 = this.aJG.aJh;
            if (z3) {
                wVar19 = this.aJG.aIV;
                if (wVar19 != null) {
                    wVar20 = this.aJG.aIV;
                    wVar20.akJ();
                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                        wVar24 = this.aJG.aIV;
                        wVar24.aB(this.aJG.getPageContext().getPageActivity());
                    }
                    wVar21 = this.aJG.aIV;
                    wVar21.akL();
                    if (!this.aJG.oi().KF()) {
                        wVar23 = this.aJG.aIV;
                        wVar23.akK();
                    }
                    bfVar16 = this.aJG.aIS;
                    wVar22 = this.aJG.aIV;
                    bfVar16.b(wVar22);
                }
            }
            wVar6 = this.aJG.aIV;
            com.baidu.tbadk.core.data.y top_notice_data = wVar6.YO().getTop_notice_data();
            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                com.baidu.tbadk.core.data.w wVar31 = new com.baidu.tbadk.core.data.w();
                wVar31.setTitle(top_notice_data.getTitle());
                wVar31.bt(2);
                wVar31.bU(top_notice_data.qY());
                wVar31.parser_title();
                wVar18 = this.aJG.aIV;
                wVar18.e(wVar31);
            }
            aVar = this.aJG.aJl;
            String KE = this.aJG.oi().KE();
            wVar7 = this.aJG.aIV;
            aVar.a(KE, wVar7);
            FrsActivity.aJb = (System.nanoTime() - this.startTime) / 1000000;
            if (hVar != null) {
                FrsActivity.aJc = hVar.cks;
            }
            wVar8 = this.aJG.aIV;
            if (wVar8 != null) {
                wVar16 = this.aJG.aIV;
                if (wVar16.akp() != null) {
                    wVar17 = this.aJG.aIV;
                    if (wVar17.akp().size() == 0 && this.aJG.oi().getType() == 1) {
                        this.aJG.showToast(this.aJG.getPageContext().getString(com.baidu.tieba.y.no_more_to_load));
                        i2 = this.aJG.aIM;
                        if (i2 > 1) {
                            FrsActivity frsActivity8 = this.aJG;
                            i3 = frsActivity8.aIM;
                            frsActivity8.aIM = i3 - 1;
                        }
                        if (this.aJG.aCG > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aJG.aCG, this.aJG.oi().GU() - this.aJG.aCG, this.aJG.oi().GS(), this.aJG.oi().GT(), currentTimeMillis2 - this.aJG.oi().GR());
                            this.aJG.aCG = -1L;
                        }
                        this.aJG.apt = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
            }
            wVar9 = this.aJG.aIV;
            if (wVar9 != null) {
                wVar14 = this.aJG.aIV;
                if (wVar14.getUserData() != null) {
                    wVar15 = this.aJG.aIV;
                    if (wVar15.getUserData().isBawu()) {
                        kVar4 = this.aJG.aJm;
                        kVar4.setIsManager(true);
                        wVar10 = this.aJG.aIV;
                        if (wVar10 != null) {
                            wVar12 = this.aJG.aIV;
                            if (wVar12.YO() != null) {
                                kVar3 = this.aJG.aJm;
                                wVar13 = this.aJG.aIV;
                                kVar3.bZ(wVar13.YO().isLike() == 1);
                            }
                        }
                        this.aJG.Jq();
                        aVar2 = this.aJG.aJl;
                        wVar11 = this.aJG.aIV;
                        aVar2.bY(wVar11.akr());
                        aVar3 = this.aJG.aJl;
                        bfVar15 = this.aJG.aIS;
                        aVar3.b(bfVar15.getNavigationBar());
                        this.aJG.ok().Ko();
                    }
                }
            }
            kVar2 = this.aJG.aJm;
            kVar2.setIsManager(false);
            wVar10 = this.aJG.aIV;
            if (wVar10 != null) {
            }
            this.aJG.Jq();
            aVar2 = this.aJG.aJl;
            wVar11 = this.aJG.aIV;
            aVar2.bY(wVar11.akr());
            aVar3 = this.aJG.aJl;
            bfVar15 = this.aJG.aIS;
            aVar3.b(bfVar15.getNavigationBar());
            this.aJG.ok().Ko();
        }
        if (this.aJG.aCG > -1) {
            long currentTimeMillis3 = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aJG.aCG, this.aJG.oi().GU() - this.aJG.aCG, this.aJG.oi().GS(), this.aJG.oi().GT(), currentTimeMillis3 - this.aJG.oi().GR());
            this.aJG.aCG = -1L;
        }
        kVar = this.aJG.aJm;
        wVar = this.aJG.aIV;
        kVar.e(wVar);
        wVar2 = this.aJG.aIV;
        if (wVar2 != null) {
            wVar3 = this.aJG.aIV;
            if (wVar3.getUserData() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                wVar4 = this.aJG.aIV;
                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(wVar4.getUserData().getIsMem())));
            }
        }
        this.aJG.apt = System.currentTimeMillis() - currentTimeMillis;
        System.gc();
    }

    @Override // com.baidu.tieba.tbadkCore.aa
    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            if (!"normal_page".equals(this.aJG.oi().KE()) && !"frs_page".equals(this.aJG.oi().KE())) {
                return;
            }
            this.aJG.a(uVar);
        }
    }
}
