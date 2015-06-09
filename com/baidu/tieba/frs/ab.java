package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.tbadkCore.aa {
    final /* synthetic */ FrsActivity aLY;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aLY = frsActivity;
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
                bfVar3 = this.aLY.aLj;
                bfVar3.bZ(true);
                bfVar4 = this.aLY.aLj;
                bfVar4.Lo();
                return;
            case 2:
                bfVar = this.aLY.aLj;
                bfVar.ca(true);
                bfVar2 = this.aLY.aLj;
                bfVar2.Lo();
                return;
            case 3:
                bfVar5 = this.aLY.aLj;
                bfVar5.bY(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b2, code lost:
        if (r1.amu().size() == 0) goto L17;
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
            bfVar22 = this.aLY.aLj;
            bfVar22.Lx().bP(com.baidu.tbadk.core.util.bc.tB().tD());
            FrsActivity.aLs = 0L;
            FrsActivity.aLt = 0L;
            FrsActivity.aLu = 0;
        } else {
            FrsActivity.aLu = 1;
        }
        this.aLY.aKX = false;
        if (i == 3) {
            aVar7 = this.aLY.aLD;
            aVar7.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        bfVar = this.aLY.aLj;
        bfVar.bY(false);
        if (this.aLY.oy().LY() != null) {
            this.aLY.aLm = this.aLY.oy().LY();
        }
        FrsActivity frsActivity = this.aLY;
        wVar = this.aLY.aLm;
        frsActivity.aLE = wVar.Zq().qR();
        i2 = this.aLY.aLE;
        if (i2 == 0) {
            wVar37 = this.aLY.aLm;
            if (wVar37.amu() != null) {
                wVar40 = this.aLY.aLm;
            }
            wVar38 = this.aLY.aLm;
            if (wVar38.getThreadList() != null) {
                wVar39 = this.aLY.aLm;
                if (wVar39.getThreadList().size() != 0) {
                    bfVar21 = this.aLY.aLj;
                    bfVar21.LD();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                bfVar5 = this.aLY.aLj;
                                bfVar5.bZ(false);
                                bfVar6 = this.aLY.aLj;
                                bfVar6.Lo();
                                break;
                            case 2:
                                bfVar3 = this.aLY.aLj;
                                bfVar3.ca(false);
                                bfVar4 = this.aLY.aLj;
                                bfVar4.Lo();
                                break;
                        }
                        FrsActivity frsActivity2 = this.aLY;
                        bfVar7 = this.aLY.aLj;
                        frsActivity2.hideLoadingView(bfVar7.getRootView());
                        bfVar8 = this.aLY.aLj;
                        bfVar8.Lv();
                        if (z || (hVar != null && hVar.errorCode != 0)) {
                            z2 = this.aLY.aKZ;
                            if (!z2) {
                                if (hVar != null) {
                                    if (hVar.coI) {
                                        if (340001 == hVar.errorCode) {
                                            FrsActivity frsActivity3 = this.aLY;
                                            bfVar14 = this.aLY.aLj;
                                            frsActivity3.showNetRefreshViewNoClick(bfVar14.getRootView(), this.aLY.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), true);
                                        } else {
                                            FrsActivity frsActivity4 = this.aLY;
                                            bfVar13 = this.aLY.aLj;
                                            frsActivity4.showNetRefreshView(bfVar13.getRootView(), this.aLY.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)), true);
                                        }
                                    } else if (340001 == hVar.errorCode) {
                                        FrsActivity frsActivity5 = this.aLY;
                                        bfVar11 = this.aLY.aLj;
                                        frsActivity5.showNetRefreshViewNoClick(bfVar11.getRootView(), hVar.errorMsg, true);
                                    } else {
                                        FrsActivity frsActivity6 = this.aLY;
                                        bfVar10 = this.aLY.aLj;
                                        frsActivity6.showNetRefreshView(bfVar10.getRootView(), hVar.errorMsg, true);
                                    }
                                    bfVar12 = this.aLY.aLj;
                                    bfVar12.fd(8);
                                }
                            } else if (hVar != null && hVar.coI) {
                                bfVar9 = this.aLY.aLj;
                                bfVar9.fd(0);
                                this.aLY.showToast(this.aLY.getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, hVar.errorMsg, Integer.valueOf(hVar.errorCode)));
                            }
                        } else {
                            this.aLY.aKZ = true;
                            this.aLY.aLi = true;
                            bfVar15 = this.aLY.aLj;
                            bfVar15.fd(0);
                            wVar6 = this.aLY.aLm;
                            if (wVar6 != null) {
                                FrsActivity frsActivity7 = this.aLY;
                                wVar28 = this.aLY.aLm;
                                frsActivity7.aLc = wVar28.aas().getName();
                                FrsActivity frsActivity8 = this.aLY;
                                wVar29 = this.aLY.aLm;
                                frsActivity8.forumId = wVar29.aas().getId();
                                wVar30 = this.aLY.aLm;
                                if (wVar30.aas().getFrsBannerData().getType() == 2) {
                                    aVar5 = this.aLY.aLB;
                                    wVar33 = this.aLY.aLm;
                                    aVar5.fg(wVar33.getUserData().getIsMem());
                                    this.aLY.aLl = true;
                                }
                                bfVar18 = this.aLY.aLj;
                                wVar31 = this.aLY.aLm;
                                ForumData aas = wVar31.aas();
                                wVar32 = this.aLY.aLm;
                                bfVar18.a(aas, wVar32.getUserData());
                            }
                            z3 = this.aLY.aLy;
                            if (z3) {
                                wVar22 = this.aLY.aLm;
                                if (wVar22 != null) {
                                    wVar23 = this.aLY.aLm;
                                    wVar23.amK();
                                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                        wVar27 = this.aLY.aLm;
                                        wVar27.aG(this.aLY.getPageContext().getPageActivity());
                                    }
                                    wVar24 = this.aLY.aLm;
                                    wVar24.amM();
                                    if (!this.aLY.oy().LX()) {
                                        wVar26 = this.aLY.aLm;
                                        wVar26.amL();
                                    }
                                    bfVar17 = this.aLY.aLj;
                                    wVar25 = this.aLY.aLm;
                                    bfVar17.b(wVar25);
                                }
                            }
                            wVar7 = this.aLY.aLm;
                            com.baidu.tbadk.core.data.y top_notice_data = wVar7.aas().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.w wVar41 = new com.baidu.tbadk.core.data.w();
                                wVar41.setTitle(top_notice_data.getTitle());
                                wVar41.bq(2);
                                wVar41.ch(top_notice_data.rE());
                                wVar41.parser_title();
                                wVar21 = this.aLY.aLm;
                                wVar21.e(wVar41);
                            }
                            aVar = this.aLY.aLB;
                            String LW = this.aLY.oy().LW();
                            wVar8 = this.aLY.aLm;
                            aVar.a(LW, wVar8);
                            FrsActivity.aLs = (System.nanoTime() - this.startTime) / 1000000;
                            if (hVar != null) {
                                FrsActivity.aLt = hVar.coJ;
                            }
                            wVar9 = this.aLY.aLm;
                            if (wVar9 != null) {
                                wVar19 = this.aLY.aLm;
                                if (wVar19.getThreadList() != null) {
                                    wVar20 = this.aLY.aLm;
                                    if (wVar20.getThreadList().size() == 0 && this.aLY.oy().getType() == 4) {
                                        this.aLY.showToast(this.aLY.getPageContext().getString(com.baidu.tieba.t.no_more_to_load));
                                        i3 = this.aLY.aLe;
                                        if (i3 > 1) {
                                            FrsActivity frsActivity9 = this.aLY;
                                            i4 = frsActivity9.aLe;
                                            frsActivity9.aLe = i4 - 1;
                                        }
                                        if (this.aLY.aEQ > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aLY.aEQ, this.aLY.oy().Id() - this.aLY.aEQ, this.aLY.oy().Ib(), this.aLY.oy().Ic(), currentTimeMillis2 - this.aLY.oy().Ia());
                                            this.aLY.aEQ = -1L;
                                        }
                                        this.aLY.aqD = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            wVar10 = this.aLY.aLm;
                            if (wVar10 != null) {
                                wVar17 = this.aLY.aLm;
                                if (wVar17.getUserData() != null) {
                                    wVar18 = this.aLY.aLm;
                                    if (wVar18.getUserData().isBawu()) {
                                        kVar4 = this.aLY.aLC;
                                        kVar4.setIsManager(true);
                                        wVar11 = this.aLY.aLm;
                                        if (wVar11 != null) {
                                            wVar15 = this.aLY.aLm;
                                            if (wVar15.aas() != null) {
                                                kVar3 = this.aLY.aLC;
                                                wVar16 = this.aLY.aLm;
                                                kVar3.cg(wVar16.aas().isLike() == 1);
                                            }
                                        }
                                        aVar2 = this.aLY.aLD;
                                        wVar12 = this.aLY.aLm;
                                        a = aVar2.a(true, wVar12.getThreadList());
                                        if (a != null) {
                                            wVar14 = this.aLY.aLm;
                                            wVar14.R(a);
                                        }
                                        this.aLY.KB();
                                        aVar3 = this.aLY.aLB;
                                        wVar13 = this.aLY.aLm;
                                        aVar3.cf(wVar13.amr());
                                        aVar4 = this.aLY.aLB;
                                        bfVar16 = this.aLY.aLj;
                                        aVar4.b(bfVar16.getNavigationBar());
                                    }
                                }
                            }
                            kVar2 = this.aLY.aLC;
                            kVar2.setIsManager(false);
                            wVar11 = this.aLY.aLm;
                            if (wVar11 != null) {
                            }
                            aVar2 = this.aLY.aLD;
                            wVar12 = this.aLY.aLm;
                            a = aVar2.a(true, wVar12.getThreadList());
                            if (a != null) {
                            }
                            this.aLY.KB();
                            aVar3 = this.aLY.aLB;
                            wVar13 = this.aLY.aLm;
                            aVar3.cf(wVar13.amr());
                            aVar4 = this.aLY.aLB;
                            bfVar16 = this.aLY.aLj;
                            aVar4.b(bfVar16.getNavigationBar());
                        }
                        if (this.aLY.aEQ > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aLY.aEQ, this.aLY.oy().Id() - this.aLY.aEQ, this.aLY.oy().Ib(), this.aLY.oy().Ic(), currentTimeMillis3 - this.aLY.oy().Ia());
                            this.aLY.aEQ = -1L;
                        }
                        kVar = this.aLY.aLC;
                        wVar2 = this.aLY.aLm;
                        kVar.e(wVar2);
                        wVar3 = this.aLY.aLm;
                        if (wVar3 != null) {
                            wVar4 = this.aLY.aLm;
                            if (wVar4.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                wVar5 = this.aLY.aLm;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(wVar5.getUserData().getIsMem())));
                            }
                        }
                        this.aLY.aqD = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    aVar6 = this.aLY.aLD;
                    wVar34 = this.aLY.aLm;
                    ArrayList<com.baidu.adp.widget.ListView.ai> a2 = aVar6.a(false, wVar34.getThreadList());
                    if (a2 != null) {
                        wVar35 = this.aLY.aLm;
                        wVar35.R(a2);
                        bfVar19 = this.aLY.aLj;
                        i5 = this.aLY.aLe;
                        wVar36 = this.aLY.aLm;
                        i6 = this.aLY.aLE;
                        bfVar19.a(a2, i5, wVar36, i6);
                        return;
                    }
                    return;
                }
            }
            bfVar20 = this.aLY.aLj;
            bfVar20.LE();
            if (i != 4) {
            }
        }
        bfVar2 = this.aLY.aLj;
        bfVar2.LC();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aa
    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            if (!"normal_page".equals(this.aLY.oy().LW()) && !"frs_page".equals(this.aLY.oy().LW())) {
                return;
            }
            this.aLY.a(uVar);
        }
    }
}
