package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ar implements com.baidu.tieba.tbadkCore.s {
    final /* synthetic */ FrsActivity bed;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void fS(int i) {
        this.startTime = System.nanoTime();
        if (this.bed.bdm != null) {
            switch (i) {
                case 1:
                    this.bed.bdm.ct(true);
                    this.bed.bdm.NW();
                    return;
                case 2:
                    this.bed.bdm.cu(true);
                    this.bed.bdm.NW();
                    return;
                case 3:
                case 6:
                    this.bed.bdm.cs(true);
                    return;
                case 4:
                case 5:
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b7, code lost:
        if (r1.aDP().size() == 0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x066e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a0  */
    @Override // com.baidu.tieba.tbadkCore.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e.a aVar) {
        com.baidu.tieba.frs.loadmore.a aVar2;
        com.baidu.tieba.tbadkCore.p pVar;
        int i2;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        boolean z2;
        com.baidu.tieba.tbadkCore.p pVar4;
        boolean z3;
        com.baidu.tieba.tbadkCore.p pVar5;
        com.baidu.tieba.frs.b.a aVar3;
        com.baidu.tieba.tbadkCore.p pVar6;
        com.baidu.tieba.tbadkCore.p pVar7;
        com.baidu.tieba.tbadkCore.p pVar8;
        com.baidu.tieba.frs.b.l lVar;
        com.baidu.tieba.tbadkCore.p pVar9;
        com.baidu.tieba.frs.loadmore.a aVar4;
        com.baidu.tieba.tbadkCore.p pVar10;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.tbadkCore.p pVar11;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.frs.b.a aVar5;
        com.baidu.tieba.tbadkCore.p pVar12;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        int i3;
        com.baidu.tieba.tbadkCore.p pVar13;
        com.baidu.tieba.tbadkCore.p pVar14;
        com.baidu.tieba.frs.b.l lVar2;
        com.baidu.tieba.tbadkCore.p pVar15;
        com.baidu.tieba.tbadkCore.p pVar16;
        com.baidu.tieba.tbadkCore.p pVar17;
        com.baidu.tieba.frs.b.l lVar3;
        com.baidu.tieba.tbadkCore.p pVar18;
        com.baidu.tieba.tbadkCore.p pVar19;
        com.baidu.tieba.tbadkCore.p pVar20;
        com.baidu.tieba.tbadkCore.p pVar21;
        com.baidu.tieba.tbadkCore.p pVar22;
        com.baidu.tieba.tbadkCore.p pVar23;
        com.baidu.tieba.tbadkCore.p pVar24;
        com.baidu.tieba.tbadkCore.p pVar25;
        com.baidu.tieba.tbadkCore.p pVar26;
        com.baidu.tieba.tbadkCore.p pVar27;
        com.baidu.tieba.tbadkCore.p pVar28;
        com.baidu.tieba.tbadkCore.p pVar29;
        com.baidu.tieba.tbadkCore.p pVar30;
        com.baidu.tieba.tbadkCore.p pVar31;
        com.baidu.tieba.tbadkCore.p pVar32;
        com.baidu.tieba.tbadkCore.p pVar33;
        com.baidu.tieba.frs.b.a aVar6;
        com.baidu.tieba.tbadkCore.p pVar34;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.p pVar35;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        com.baidu.tieba.tbadkCore.p pVar36;
        com.baidu.tieba.tbadkCore.p pVar37;
        int i4;
        com.baidu.tieba.tbadkCore.p pVar38;
        com.baidu.tieba.tbadkCore.p pVar39;
        com.baidu.tieba.tbadkCore.p pVar40;
        com.baidu.tieba.tbadkCore.p pVar41;
        int i5;
        com.baidu.tieba.tbadkCore.p pVar42;
        int i6;
        com.baidu.tieba.tbadkCore.p pVar43;
        this.bed.bdK = true;
        if (aVar != null && aVar.isSuccess) {
            this.bed.bdm.Of().cl(com.baidu.tbadk.core.util.ay.va().vc());
            FrsActivity.bds = 0L;
            FrsActivity.bdt = 0L;
            FrsActivity.bdu = 0;
        } else {
            FrsActivity.bdu = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bed.bdD;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.bed.bdm.cs(false);
        if (this.bed.Nr().OZ() != null) {
            this.bed.bdo = this.bed.Nr().OZ();
        }
        FrsActivity frsActivity = this.bed;
        pVar = this.bed.bdo;
        frsActivity.bdE = pVar.getPage().rO();
        i2 = this.bed.bdE;
        if (i2 == 0) {
            pVar39 = this.bed.bdo;
            if (pVar39.aDP() != null) {
                pVar43 = this.bed.bdo;
            }
            pVar40 = this.bed.bdo;
            if (pVar40.getThreadList() != null) {
                pVar41 = this.bed.bdo;
                if (pVar41.getThreadList().size() != 0) {
                    cg cgVar = this.bed.bdm;
                    i5 = FrsActivity.bcW;
                    pVar42 = this.bed.bdo;
                    int size = pVar42.getThreadList().size();
                    i6 = FrsActivity.bcX;
                    cgVar.gb(i5 - (size * i6));
                    this.bed.bdm.Ol();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                this.bed.bdm.ct(false);
                                this.bed.bdm.NW();
                                break;
                            case 2:
                                this.bed.bdm.cu(false);
                                this.bed.bdm.NW();
                                break;
                            case 3:
                            case 6:
                                pVar2 = this.bed.bdo;
                                if (pVar2 != null) {
                                    pVar3 = this.bed.bdo;
                                    pVar3.aEk();
                                    break;
                                }
                                break;
                        }
                        this.bed.hideLoadingView(this.bed.bdm.getRootView());
                        this.bed.bdm.Od();
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.bed.bcZ;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.dEt) {
                                        if (340001 == aVar.errorCode) {
                                            this.bed.showNetRefreshViewNoClick(this.bed.bdm.getRootView(), this.bed.getPageContext().getResources().getString(n.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            this.bed.showNetRefreshView(this.bed.bdm.getRootView(), this.bed.getPageContext().getResources().getString(n.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        this.bed.showNetRefreshViewNoClick(this.bed.bdm.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        this.bed.showNetRefreshView(this.bed.bdm.getRootView(), aVar.errorMsg, true);
                                    }
                                    this.bed.bdm.ga(8);
                                }
                            } else if (aVar != null && aVar.dEt) {
                                this.bed.bdm.ga(0);
                                this.bed.showToast(this.bed.getPageContext().getResources().getString(n.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.bed.bcZ = true;
                            this.bed.bdl = true;
                            this.bed.bdm.ga(0);
                            pVar4 = this.bed.bdo;
                            if (pVar4 != null) {
                                FrsActivity frsActivity2 = this.bed;
                                pVar29 = this.bed.bdo;
                                frsActivity2.bde = pVar29.akG().getName();
                                FrsActivity frsActivity3 = this.bed;
                                pVar30 = this.bed.bdo;
                                frsActivity3.forumId = pVar30.akG().getId();
                                pVar31 = this.bed.bdo;
                                if (pVar31.akG().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.bed.bdB;
                                    pVar34 = this.bed.bdo;
                                    aVar6.gu(pVar34.getUserData().getIsMem());
                                }
                                cg cgVar2 = this.bed.bdm;
                                pVar32 = this.bed.bdo;
                                ForumData akG = pVar32.akG();
                                pVar33 = this.bed.bdo;
                                cgVar2.a(akG, pVar33.getUserData(), 1);
                            }
                            z3 = this.bed.bdy;
                            if (z3) {
                                pVar21 = this.bed.bdo;
                                if (pVar21 != null && this.bed.bdz.Pt() == 1) {
                                    pVar22 = this.bed.bdo;
                                    pVar22.aEn();
                                    pVar23 = this.bed.bdo;
                                    pVar23.aEs();
                                    if (!this.bed.Nr().Pp() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                        pVar26 = this.bed.bdo;
                                        pVar26.aEr();
                                        pVar27 = this.bed.bdo;
                                        pVar27.aEq();
                                        pVar28 = this.bed.bdo;
                                        pVar28.aEp();
                                    }
                                    pVar24 = this.bed.bdo;
                                    pVar24.aEu();
                                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                        pVar25 = this.bed.bdo;
                                        pVar25.aO(this.bed.getPageContext().getPageActivity());
                                    }
                                }
                            }
                            pVar5 = this.bed.bdo;
                            com.baidu.tbadk.core.data.ab top_notice_data = pVar5.akG().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                                zVar.setTitle(top_notice_data.getTitle());
                                zVar.bC(2);
                                zVar.cx(top_notice_data.sY());
                                zVar.parser_title();
                                pVar20 = this.bed.bdo;
                                pVar20.i(zVar);
                            }
                            aVar3 = this.bed.bdB;
                            String Po = this.bed.Nr().Po();
                            pVar6 = this.bed.bdo;
                            aVar3.a(Po, pVar6);
                            FrsActivity.bds = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.bdt = aVar.dEu;
                            }
                            pVar7 = this.bed.bdo;
                            if (pVar7 != null) {
                                pVar18 = this.bed.bdo;
                                if (pVar18.getThreadList() != null) {
                                    pVar19 = this.bed.bdo;
                                    if (pVar19.getThreadList().size() == 0 && this.bed.Nr().getType() == 4) {
                                        this.bed.showToast(this.bed.getPageContext().getString(n.j.no_more_to_load));
                                        if (this.bed.mPn > 1) {
                                            FrsActivity frsActivity4 = this.bed;
                                            frsActivity4.mPn--;
                                        }
                                        if (this.bed.aUp > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bed.aUp, this.bed.Nr().Kx() - this.bed.aUp, this.bed.Nr().Kv(), this.bed.Nr().Kw(), currentTimeMillis2 - this.bed.Nr().Ku());
                                            this.bed.aUp = -1L;
                                        }
                                        this.bed.azV = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            pVar8 = this.bed.bdo;
                            if (pVar8 != null) {
                                pVar16 = this.bed.bdo;
                                if (pVar16.getUserData() != null) {
                                    pVar17 = this.bed.bdo;
                                    if (pVar17.getUserData().isBawu()) {
                                        lVar3 = this.bed.bdC;
                                        lVar3.setIsManager(true);
                                        pVar9 = this.bed.bdo;
                                        if (pVar9 != null) {
                                            pVar14 = this.bed.bdo;
                                            if (pVar14.akG() != null) {
                                                lVar2 = this.bed.bdC;
                                                pVar15 = this.bed.bdo;
                                                lVar2.cB(pVar15.akG().isLike() == 1);
                                            }
                                        }
                                        aVar4 = this.bed.bdD;
                                        pVar10 = this.bed.bdo;
                                        a = aVar4.a(true, pVar10.getThreadList());
                                        if (a != null) {
                                            pVar13 = this.bed.bdo;
                                            pVar13.am(a);
                                        }
                                        this.bed.Ng();
                                        FrsActivity frsActivity5 = this.bed;
                                        pVar11 = this.bed.bdo;
                                        frsActivity5.bdi = pVar11.Pw();
                                        eVar = this.bed.bdj;
                                        if (eVar != null) {
                                            eVar2 = this.bed.bdj;
                                            i3 = this.bed.bdi;
                                            eVar2.mU(i3);
                                        }
                                        aVar5 = this.bed.bdB;
                                        pVar12 = this.bed.bdo;
                                        aVar5.cz(pVar12.aDM());
                                    }
                                }
                            }
                            lVar = this.bed.bdC;
                            lVar.setIsManager(false);
                            pVar9 = this.bed.bdo;
                            if (pVar9 != null) {
                            }
                            aVar4 = this.bed.bdD;
                            pVar10 = this.bed.bdo;
                            a = aVar4.a(true, pVar10.getThreadList());
                            if (a != null) {
                            }
                            this.bed.Ng();
                            FrsActivity frsActivity52 = this.bed;
                            pVar11 = this.bed.bdo;
                            frsActivity52.bdi = pVar11.Pw();
                            eVar = this.bed.bdj;
                            if (eVar != null) {
                            }
                            aVar5 = this.bed.bdB;
                            pVar12 = this.bed.bdo;
                            aVar5.cz(pVar12.aDM());
                        }
                        if (this.bed.aUp > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bed.aUp, this.bed.Nr().Kx() - this.bed.aUp, this.bed.Nr().Kv(), this.bed.Nr().Kw(), currentTimeMillis3 - this.bed.Nr().Ku());
                            this.bed.aUp = -1L;
                        }
                        this.bed.azV = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                        pVar38 = this.bed.bdo;
                        pVar38.aO(this.bed.getPageContext().getPageActivity());
                    }
                    aVar7 = this.bed.bdD;
                    pVar35 = this.bed.bdo;
                    ArrayList<com.baidu.adp.widget.ListView.u> threadList = pVar35.getThreadList();
                    eVar3 = this.bed.bdj;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, threadList, eVar3);
                    if (a2 != null) {
                        pVar36 = this.bed.bdo;
                        pVar36.am(a2);
                        cg cgVar3 = this.bed.bdm;
                        int i7 = this.bed.mPn;
                        pVar37 = this.bed.bdo;
                        i4 = this.bed.bdE;
                        cgVar3.a(a2, i7, pVar37, i4);
                        return;
                    }
                    return;
                }
            }
            this.bed.bdm.Om();
            if (i != 4) {
            }
        }
        this.bed.bdm.Ok();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if (!"normal_page".equals(this.bed.Nr().Po()) && !"frs_page".equals(this.bed.Nr().Po())) {
                return;
            }
            this.bed.a(nVar);
        }
    }
}
