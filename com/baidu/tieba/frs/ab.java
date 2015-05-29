package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.tbadkCore.aa {
    final /* synthetic */ FrsActivity aLX;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aa
    public void eU(int i) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                bfVar3 = this.aLX.aLi;
                bfVar3.bZ(true);
                bfVar4 = this.aLX.aLi;
                bfVar4.Ln();
                return;
            case 2:
                bfVar = this.aLX.aLi;
                bfVar.ca(true);
                bfVar2 = this.aLX.aLi;
                bfVar2.Ln();
                return;
            case 3:
                bfVar5 = this.aLX.aLi;
                bfVar5.bY(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b2, code lost:
        if (r1.amt().size() == 0) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x014b  */
    @Override // com.baidu.tieba.tbadkCore.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, com.baidu.tieba.tbadkCore.h hVar) {
        bf bfVar;
        com.baidu.tieba.tbadkCore.w wVar;
        int i2;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        bf bfVar7;
        bf bfVar8;
        boolean z2;
        bf bfVar9;
        bf bfVar10;
        bf bfVar11;
        bf bfVar12;
        bf bfVar13;
        bf bfVar14;
        com.baidu.tieba.frs.c.k kVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        bf bfVar15;
        com.baidu.tieba.tbadkCore.w wVar6;
        boolean z3;
        com.baidu.tieba.tbadkCore.w wVar7;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.w wVar8;
        com.baidu.tieba.tbadkCore.w wVar9;
        com.baidu.tieba.tbadkCore.w wVar10;
        com.baidu.tieba.frs.c.k kVar2;
        com.baidu.tieba.tbadkCore.w wVar11;
        com.baidu.tieba.frs.loadmore.a aVar2;
        com.baidu.tieba.tbadkCore.w wVar12;
        ArrayList<com.baidu.adp.widget.ListView.ai> a;
        com.baidu.tieba.frs.c.a aVar3;
        com.baidu.tieba.tbadkCore.w wVar13;
        com.baidu.tieba.frs.c.a aVar4;
        bf bfVar16;
        com.baidu.tieba.tbadkCore.w wVar14;
        com.baidu.tieba.tbadkCore.w wVar15;
        com.baidu.tieba.frs.c.k kVar3;
        com.baidu.tieba.tbadkCore.w wVar16;
        com.baidu.tieba.tbadkCore.w wVar17;
        com.baidu.tieba.tbadkCore.w wVar18;
        com.baidu.tieba.frs.c.k kVar4;
        com.baidu.tieba.tbadkCore.w wVar19;
        com.baidu.tieba.tbadkCore.w wVar20;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.w wVar21;
        com.baidu.tieba.tbadkCore.w wVar22;
        com.baidu.tieba.tbadkCore.w wVar23;
        com.baidu.tieba.tbadkCore.w wVar24;
        bf bfVar17;
        com.baidu.tieba.tbadkCore.w wVar25;
        com.baidu.tieba.tbadkCore.w wVar26;
        com.baidu.tieba.tbadkCore.w wVar27;
        com.baidu.tieba.tbadkCore.w wVar28;
        com.baidu.tieba.tbadkCore.w wVar29;
        com.baidu.tieba.tbadkCore.w wVar30;
        bf bfVar18;
        com.baidu.tieba.tbadkCore.w wVar31;
        com.baidu.tieba.tbadkCore.w wVar32;
        com.baidu.tieba.frs.c.a aVar5;
        com.baidu.tieba.tbadkCore.w wVar33;
        com.baidu.tieba.frs.loadmore.a aVar6;
        com.baidu.tieba.tbadkCore.w wVar34;
        com.baidu.tieba.tbadkCore.w wVar35;
        bf bfVar19;
        int i5;
        com.baidu.tieba.tbadkCore.w wVar36;
        int i6;
        com.baidu.tieba.tbadkCore.w wVar37;
        com.baidu.tieba.tbadkCore.w wVar38;
        bf bfVar20;
        com.baidu.tieba.tbadkCore.w wVar39;
        bf bfVar21;
        com.baidu.tieba.tbadkCore.w wVar40;
        com.baidu.tieba.frs.loadmore.a aVar7;
        bf bfVar22;
        if (hVar != null && hVar.isSuccess) {
            bfVar22 = this.aLX.aLi;
            bfVar22.Lw().bP(com.baidu.tbadk.core.util.bc.tB().tD());
            FrsActivity.aLr = 0L;
            FrsActivity.aLs = 0L;
            FrsActivity.aLt = 0;
        } else {
            FrsActivity.aLt = 1;
        }
        this.aLX.aKW = false;
        if (i == 3) {
            aVar7 = this.aLX.aLC;
            aVar7.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bfVar = this.aLX.aLi;
        bfVar.bY(false);
        if (this.aLX.oy().LX() != null) {
            this.aLX.aLl = this.aLX.oy().LX();
        }
        FrsActivity frsActivity = this.aLX;
        wVar = this.aLX.aLl;
        frsActivity.aLD = wVar.Zp().qR();
        i2 = this.aLX.aLD;
        if (i2 == 0) {
            wVar37 = this.aLX.aLl;
            if (wVar37.amt() != null) {
                wVar40 = this.aLX.aLl;
            }
            wVar38 = this.aLX.aLl;
            if (wVar38.getThreadList() != null) {
                wVar39 = this.aLX.aLl;
                if (wVar39.getThreadList().size() != 0) {
                    bfVar21 = this.aLX.aLi;
                    bfVar21.LC();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                bfVar5 = this.aLX.aLi;
                                bfVar5.bZ(false);
                                bfVar6 = this.aLX.aLi;
                                bfVar6.Ln();
                                break;
                            case 2:
                                bfVar3 = this.aLX.aLi;
                                bfVar3.ca(false);
                                bfVar4 = this.aLX.aLi;
                                bfVar4.Ln();
                                break;
                        }
                        FrsActivity frsActivity2 = this.aLX;
                        bfVar7 = this.aLX.aLi;
                        frsActivity2.hideLoadingView(bfVar7.getRootView());
                        bfVar8 = this.aLX.aLi;
                        bfVar8.Lu();
                        if (z || (hVar != null && hVar.errorCode != 0)) {
                            z2 = this.aLX.aKY;
                            if (!z2) {
                                if (hVar != null) {
                                    if (hVar.coH) {
                                        if (340001 == hVar.errorCode) {
                                            FrsActivity frsActivity3 = this.aLX;
                                            bfVar14 = this.aLX.aLi;
                                            frsActivity3.showNetRefreshViewNoClick(bfVar14.getRootView(), this.aLX.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), true);
                                        } else {
                                            FrsActivity frsActivity4 = this.aLX;
                                            bfVar13 = this.aLX.aLi;
                                            frsActivity4.showNetRefreshView(bfVar13.getRootView(), this.aLX.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), true);
                                        }
                                    } else if (340001 == hVar.errorCode) {
                                        FrsActivity frsActivity5 = this.aLX;
                                        bfVar11 = this.aLX.aLi;
                                        frsActivity5.showNetRefreshViewNoClick(bfVar11.getRootView(), hVar.errorMsg, true);
                                    } else {
                                        FrsActivity frsActivity6 = this.aLX;
                                        bfVar10 = this.aLX.aLi;
                                        frsActivity6.showNetRefreshView(bfVar10.getRootView(), hVar.errorMsg, true);
                                    }
                                    bfVar12 = this.aLX.aLi;
                                    bfVar12.fd(8);
                                }
                            } else if (hVar != null && hVar.coH) {
                                bfVar9 = this.aLX.aLi;
                                bfVar9.fd(0);
                                this.aLX.showToast(this.aLX.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)));
                            }
                        } else {
                            this.aLX.aKY = true;
                            this.aLX.aLh = true;
                            bfVar15 = this.aLX.aLi;
                            bfVar15.fd(0);
                            wVar6 = this.aLX.aLl;
                            if (wVar6 != null) {
                                FrsActivity frsActivity7 = this.aLX;
                                wVar28 = this.aLX.aLl;
                                frsActivity7.aLb = wVar28.aar().getName();
                                FrsActivity frsActivity8 = this.aLX;
                                wVar29 = this.aLX.aLl;
                                frsActivity8.forumId = wVar29.aar().getId();
                                wVar30 = this.aLX.aLl;
                                if (wVar30.aar().getFrsBannerData().getType() == 2) {
                                    aVar5 = this.aLX.aLA;
                                    wVar33 = this.aLX.aLl;
                                    aVar5.fg(wVar33.getUserData().getIsMem());
                                    this.aLX.aLk = true;
                                }
                                bfVar18 = this.aLX.aLi;
                                wVar31 = this.aLX.aLl;
                                ForumData aar = wVar31.aar();
                                wVar32 = this.aLX.aLl;
                                bfVar18.a(aar, wVar32.getUserData());
                            }
                            z3 = this.aLX.aLx;
                            if (z3) {
                                wVar22 = this.aLX.aLl;
                                if (wVar22 != null) {
                                    wVar23 = this.aLX.aLl;
                                    wVar23.amJ();
                                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                        wVar27 = this.aLX.aLl;
                                        wVar27.aG(this.aLX.getPageContext().getPageActivity());
                                    }
                                    wVar24 = this.aLX.aLl;
                                    wVar24.amL();
                                    if (!this.aLX.oy().LW()) {
                                        wVar26 = this.aLX.aLl;
                                        wVar26.amK();
                                    }
                                    bfVar17 = this.aLX.aLi;
                                    wVar25 = this.aLX.aLl;
                                    bfVar17.b(wVar25);
                                }
                            }
                            wVar7 = this.aLX.aLl;
                            com.baidu.tbadk.core.data.y top_notice_data = wVar7.aar().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.w wVar41 = new com.baidu.tbadk.core.data.w();
                                wVar41.setTitle(top_notice_data.getTitle());
                                wVar41.bq(2);
                                wVar41.ch(top_notice_data.rE());
                                wVar41.parser_title();
                                wVar21 = this.aLX.aLl;
                                wVar21.e(wVar41);
                            }
                            aVar = this.aLX.aLA;
                            String LV = this.aLX.oy().LV();
                            wVar8 = this.aLX.aLl;
                            aVar.a(LV, wVar8);
                            FrsActivity.aLr = (System.nanoTime() - this.startTime) / 1000000;
                            if (hVar != null) {
                                FrsActivity.aLs = hVar.coI;
                            }
                            wVar9 = this.aLX.aLl;
                            if (wVar9 != null) {
                                wVar19 = this.aLX.aLl;
                                if (wVar19.getThreadList() != null) {
                                    wVar20 = this.aLX.aLl;
                                    if (wVar20.getThreadList().size() == 0 && this.aLX.oy().getType() == 4) {
                                        this.aLX.showToast(this.aLX.getPageContext().getString(com.baidu.tieba.t.no_more_to_load));
                                        i3 = this.aLX.aLd;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.aLX;
                                            i4 = frsActivity9.aLd;
                                            frsActivity9.aLd = i4 - 1;
                                        }
                                        if (this.aLX.aEP > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aLX.aEP, this.aLX.oy().Ic() - this.aLX.aEP, this.aLX.oy().Ia(), this.aLX.oy().Ib(), currentTimeMillis2 - this.aLX.oy().HZ());
                                            this.aLX.aEP = -1L;
                                        }
                                        this.aLX.aqD = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            wVar10 = this.aLX.aLl;
                            if (wVar10 != null) {
                                wVar17 = this.aLX.aLl;
                                if (wVar17.getUserData() != null) {
                                    wVar18 = this.aLX.aLl;
                                    if (wVar18.getUserData().isBawu()) {
                                        kVar4 = this.aLX.aLB;
                                        kVar4.setIsManager(true);
                                        wVar11 = this.aLX.aLl;
                                        if (wVar11 != null) {
                                            wVar15 = this.aLX.aLl;
                                            if (wVar15.aar() != null) {
                                                kVar3 = this.aLX.aLB;
                                                wVar16 = this.aLX.aLl;
                                                kVar3.cg(wVar16.aar().isLike() == 1);
                                            }
                                        }
                                        aVar2 = this.aLX.aLC;
                                        wVar12 = this.aLX.aLl;
                                        a = aVar2.a(true, wVar12.getThreadList());
                                        if (a != null) {
                                            wVar14 = this.aLX.aLl;
                                            wVar14.R(a);
                                        }
                                        this.aLX.KA();
                                        aVar3 = this.aLX.aLA;
                                        wVar13 = this.aLX.aLl;
                                        aVar3.cf(wVar13.amq());
                                        aVar4 = this.aLX.aLA;
                                        bfVar16 = this.aLX.aLi;
                                        aVar4.b(bfVar16.getNavigationBar());
                                    }
                                }
                            }
                            kVar2 = this.aLX.aLB;
                            kVar2.setIsManager(false);
                            wVar11 = this.aLX.aLl;
                            if (wVar11 != null) {
                            }
                            aVar2 = this.aLX.aLC;
                            wVar12 = this.aLX.aLl;
                            a = aVar2.a(true, wVar12.getThreadList());
                            if (a != null) {
                            }
                            this.aLX.KA();
                            aVar3 = this.aLX.aLA;
                            wVar13 = this.aLX.aLl;
                            aVar3.cf(wVar13.amq());
                            aVar4 = this.aLX.aLA;
                            bfVar16 = this.aLX.aLi;
                            aVar4.b(bfVar16.getNavigationBar());
                        }
                        if (this.aLX.aEP > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aLX.aEP, this.aLX.oy().Ic() - this.aLX.aEP, this.aLX.oy().Ia(), this.aLX.oy().Ib(), currentTimeMillis3 - this.aLX.oy().HZ());
                            this.aLX.aEP = -1L;
                        }
                        kVar = this.aLX.aLB;
                        wVar2 = this.aLX.aLl;
                        kVar.e(wVar2);
                        wVar3 = this.aLX.aLl;
                        if (wVar3 != null) {
                            wVar4 = this.aLX.aLl;
                            if (wVar4.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                wVar5 = this.aLX.aLl;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(wVar5.getUserData().getIsMem())));
                            }
                        }
                        this.aLX.aqD = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar6 = this.aLX.aLC;
                    wVar34 = this.aLX.aLl;
                    ArrayList<com.baidu.adp.widget.ListView.ai> a2 = aVar6.a(false, wVar34.getThreadList());
                    if (a2 != null) {
                        wVar35 = this.aLX.aLl;
                        wVar35.R(a2);
                        bfVar19 = this.aLX.aLi;
                        i5 = this.aLX.aLd;
                        wVar36 = this.aLX.aLl;
                        i6 = this.aLX.aLD;
                        bfVar19.a(a2, i5, wVar36, i6);
                        return;
                    }
                    return;
                }
            }
            bfVar20 = this.aLX.aLi;
            bfVar20.LD();
            if (i != 4) {
            }
        }
        bfVar2 = this.aLX.aLi;
        bfVar2.LB();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aa
    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            if (!"normal_page".equals(this.aLX.oy().LV()) && !"frs_page".equals(this.aLX.oy().LV())) {
                return;
            }
            this.aLX.a(uVar);
        }
    }
}
