package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.frs.loadmore.a;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
class aw implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity bhl;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void gm(int i) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        this.startTime = System.nanoTime();
        cnVar = this.bhl.bgo;
        if (cnVar != null) {
            switch (i) {
                case 1:
                    cnVar3 = this.bhl.bgo;
                    cnVar3.QO();
                    return;
                case 2:
                    cnVar2 = this.bhl.bgo;
                    cnVar2.QO();
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0100, code lost:
        if (r1.aSf().size() == 0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0778  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0808  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0229  */
    @Override // com.baidu.tieba.tbadkCore.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, d.a aVar) {
        cn cnVar;
        cn cnVar2;
        a aVar2;
        cn cnVar3;
        com.baidu.tieba.tbadkCore.o oVar;
        int i2;
        cn cnVar4;
        cn cnVar5;
        cn cnVar6;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        cn cnVar7;
        cn cnVar8;
        com.baidu.tieba.tbadkCore.o oVar4;
        cn cnVar9;
        boolean z2;
        cn cnVar10;
        cn cnVar11;
        cn cnVar12;
        cn cnVar13;
        cn cnVar14;
        com.baidu.tieba.tbadkCore.o oVar5;
        boolean z3;
        com.baidu.tieba.tbadkCore.o oVar6;
        com.baidu.tieba.tbadkCore.o oVar7;
        b bVar;
        com.baidu.tieba.tbadkCore.o oVar8;
        com.baidu.tieba.tbadkCore.o oVar9;
        com.baidu.tieba.frs.h.y yVar;
        com.baidu.tieba.tbadkCore.o oVar10;
        com.baidu.tieba.tbadkCore.o oVar11;
        com.baidu.tieba.tbadkCore.data.f fVar;
        com.baidu.tieba.frs.h.m mVar;
        com.baidu.tieba.tbadkCore.o oVar12;
        boolean z4;
        cn cnVar15;
        com.baidu.tieba.tbadkCore.o oVar13;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        int i3;
        com.baidu.tieba.tbadkCore.o oVar14;
        com.baidu.tieba.tbadkCore.o oVar15;
        a aVar3;
        com.baidu.tieba.tbadkCore.o oVar16;
        com.baidu.tieba.tbadkCore.o oVar17;
        com.baidu.tieba.frs.h.y yVar2;
        com.baidu.tieba.tbadkCore.o oVar18;
        com.baidu.tieba.tbadkCore.o oVar19;
        com.baidu.tieba.tbadkCore.o oVar20;
        com.baidu.tieba.frs.h.y yVar3;
        com.baidu.tieba.tbadkCore.o oVar21;
        com.baidu.tieba.tbadkCore.o oVar22;
        int i4;
        int i5;
        b bVar2;
        com.baidu.tieba.frs.h.m mVar2;
        com.baidu.tieba.tbadkCore.o oVar23;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        cn cnVar16;
        com.baidu.tieba.tbadkCore.o oVar24;
        com.baidu.tieba.tbadkCore.o oVar25;
        com.baidu.tieba.tbadkCore.o oVar26;
        com.baidu.tieba.tbadkCore.o oVar27;
        com.baidu.tieba.tbadkCore.o oVar28;
        com.baidu.tieba.tbadkCore.o oVar29;
        com.baidu.tieba.tbadkCore.o oVar30;
        com.baidu.tieba.tbadkCore.o oVar31;
        com.baidu.tieba.tbadkCore.o oVar32;
        com.baidu.tieba.tbadkCore.o oVar33;
        com.baidu.tieba.tbadkCore.o oVar34;
        com.baidu.tieba.tbadkCore.o oVar35;
        com.baidu.tieba.tbadkCore.o oVar36;
        com.baidu.tieba.tbadkCore.o oVar37;
        com.baidu.tieba.tbadkCore.o oVar38;
        com.baidu.tieba.tbadkCore.o oVar39;
        com.baidu.tieba.frs.h.m mVar3;
        com.baidu.tieba.tbadkCore.o oVar40;
        com.baidu.tieba.tbadkCore.o oVar41;
        cn cnVar17;
        com.baidu.tieba.tbadkCore.o oVar42;
        com.baidu.tieba.tbadkCore.o oVar43;
        cn cnVar18;
        com.baidu.tieba.tbadkCore.o oVar44;
        a aVar4;
        com.baidu.tieba.tbadkCore.o oVar45;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        com.baidu.tieba.tbadkCore.o oVar46;
        com.baidu.tieba.tbadkCore.o oVar47;
        cn cnVar19;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar48;
        int i7;
        com.baidu.tieba.tbadkCore.o oVar49;
        com.baidu.tieba.tbadkCore.o oVar50;
        String str;
        com.baidu.tieba.tbadkCore.o oVar51;
        com.baidu.tieba.tbadkCore.o oVar52;
        com.baidu.tieba.tbadkCore.o oVar53;
        com.baidu.tieba.tbadkCore.o oVar54;
        cn cnVar20;
        com.baidu.tieba.tbadkCore.o oVar55;
        cn cnVar21;
        int i8;
        com.baidu.tieba.tbadkCore.o oVar56;
        int i9;
        cn cnVar22;
        com.baidu.tieba.tbadkCore.o oVar57;
        com.baidu.tieba.tbadkCore.o oVar58;
        cn cnVar23;
        cn cnVar24;
        cnVar = this.bhl.bgo;
        if (cnVar.QC() instanceof com.baidu.tieba.frs.tab.h) {
            cnVar24 = this.bhl.bgo;
            ((com.baidu.tieba.frs.tab.h) cnVar24.QC()).Pl();
        }
        cnVar2 = this.bhl.bgo;
        cnVar2.QV();
        this.bhl.bgT = true;
        if (aVar != null && aVar.isSuccess) {
            cnVar23 = this.bhl.bgo;
            cnVar23.Ra().cG(com.baidu.tbadk.core.util.az.uf().uh());
            FrsActivity.bgv = 0L;
            FrsActivity.bgw = 0L;
            FrsActivity.bgx = 0;
        } else {
            FrsActivity.bgx = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bhl.bgL;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bhl.Qd().Tb() != null) {
            this.bhl.bgq = this.bhl.Qd().Tb();
        }
        if (i != 7) {
            cnVar3 = this.bhl.bgo;
            cnVar3.cQ(false);
            FrsActivity frsActivity = this.bhl;
            oVar = this.bhl.bgq;
            frsActivity.bgM = oVar.getPage().pK();
            i2 = this.bhl.bgM;
            if (i2 == 0) {
                oVar53 = this.bhl.bgq;
                if (oVar53.aSf() != null) {
                    oVar57 = this.bhl.bgq;
                }
                oVar54 = this.bhl.bgq;
                if (oVar54.getThreadList() != null) {
                    oVar55 = this.bhl.bgq;
                    if (oVar55.getThreadList().size() != 0) {
                        cnVar21 = this.bhl.bgo;
                        i8 = FrsActivity.bfW;
                        oVar56 = this.bhl.bgq;
                        int size = oVar56.getThreadList().size();
                        i9 = FrsActivity.bfX;
                        cnVar21.gr(i8 - (size * i9));
                        cnVar22 = this.bhl.bgo;
                        cnVar22.Rh();
                        if (i != 4) {
                            switch (i) {
                                case 1:
                                    cnVar6 = this.bhl.bgo;
                                    cnVar6.QO();
                                    break;
                                case 2:
                                    cnVar5 = this.bhl.bgo;
                                    cnVar5.QO();
                                    break;
                                case 3:
                                case 6:
                                    oVar2 = this.bhl.bgq;
                                    if (oVar2 != null) {
                                        oVar3 = this.bhl.bgq;
                                        oVar3.aSF();
                                        break;
                                    }
                                    break;
                            }
                            FrsActivity frsActivity2 = this.bhl;
                            cnVar7 = this.bhl.bgo;
                            frsActivity2.hideLoadingView(cnVar7.getRootView());
                            cnVar8 = this.bhl.bgo;
                            cnVar8.cS(false);
                            oVar4 = this.bhl.bgq;
                            if (oVar4 == null) {
                                cnVar9 = this.bhl.bgo;
                                cnVar9.QZ();
                            } else {
                                oVar41 = this.bhl.bgq;
                                if (oVar41.avA() != null) {
                                    oVar42 = this.bhl.bgq;
                                    if (oVar42.avA().getYuleData() != null) {
                                        oVar43 = this.bhl.bgq;
                                        if (oVar43.avA().getYuleData().rN()) {
                                            TiebaStatic.log("c10852");
                                            cnVar18 = this.bhl.bgo;
                                            oVar44 = this.bhl.bgq;
                                            cnVar18.a(oVar44.avA().getYuleData().rO());
                                        }
                                    }
                                }
                                cnVar17 = this.bhl.bgo;
                                cnVar17.QZ();
                            }
                            if (z || (aVar != null && aVar.errorCode != 0)) {
                                z2 = this.bhl.bfZ;
                                if (!z2) {
                                    if (aVar != null) {
                                        if (aVar.eqd) {
                                            if (340001 == aVar.errorCode) {
                                                FrsActivity frsActivity3 = this.bhl;
                                                cnVar13 = this.bhl.bgo;
                                                frsActivity3.showNetRefreshViewNoClick(cnVar13.getRootView(), this.bhl.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                            } else {
                                                FrsActivity frsActivity4 = this.bhl;
                                                cnVar12 = this.bhl.bgo;
                                                frsActivity4.showNetRefreshView(cnVar12.getRootView(), this.bhl.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                            }
                                        } else if (340001 == aVar.errorCode) {
                                            FrsActivity frsActivity5 = this.bhl;
                                            cnVar11 = this.bhl.bgo;
                                            frsActivity5.showNetRefreshViewNoClick(cnVar11.getRootView(), aVar.errorMsg, true);
                                        } else {
                                            FrsActivity frsActivity6 = this.bhl;
                                            cnVar10 = this.bhl.bgo;
                                            frsActivity6.showNetRefreshView(cnVar10.getRootView(), aVar.errorMsg, true);
                                        }
                                    }
                                } else if (aVar != null && aVar.eqd) {
                                    this.bhl.showToast(this.bhl.getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                                }
                            } else {
                                this.bhl.bfZ = true;
                                this.bhl.bgn = true;
                                cnVar14 = this.bhl.bgo;
                                cnVar14.gq(0);
                                oVar5 = this.bhl.bgq;
                                if (oVar5 != null) {
                                    FrsActivity frsActivity7 = this.bhl;
                                    oVar37 = this.bhl.bgq;
                                    frsActivity7.bgf = oVar37.avA().getName();
                                    FrsActivity frsActivity8 = this.bhl;
                                    oVar38 = this.bhl.bgq;
                                    frsActivity8.forumId = oVar38.avA().getId();
                                    oVar39 = this.bhl.bgq;
                                    if (oVar39.avA().getFrsBannerData().getType() == 2) {
                                        mVar3 = this.bhl.bgE;
                                        oVar40 = this.bhl.bgq;
                                        mVar3.gQ(oVar40.getUserData().getIsMem());
                                    }
                                }
                                z3 = this.bhl.bgB;
                                if (z3) {
                                    oVar29 = this.bhl.bgq;
                                    if (oVar29 != null && this.bhl.bgC.Tr() == 1) {
                                        oVar30 = this.bhl.bgq;
                                        oVar30.aSI();
                                        oVar31 = this.bhl.bgq;
                                        oVar31.aSJ();
                                        oVar32 = this.bhl.bgq;
                                        oVar32.aSM();
                                        oVar33 = this.bhl.bgq;
                                        if (!oVar33.aSP()) {
                                            oVar36 = this.bhl.bgq;
                                            oVar36.aSO();
                                        }
                                        if (TbadkCoreApplication.m11getInst().isRecAppExist()) {
                                            oVar34 = this.bhl.bgq;
                                            oVar34.aQ(this.bhl.getPageContext().getPageActivity());
                                            oVar35 = this.bhl.bgq;
                                            oVar35.N(this.bhl.getPageContext().getPageActivity(), this.bhl.forumId);
                                        }
                                    }
                                }
                                oVar6 = this.bhl.bgq;
                                if (oVar6 != null) {
                                    oVar25 = this.bhl.bgq;
                                    oVar25.aSH();
                                    oVar26 = this.bhl.bgq;
                                    com.baidu.tbadk.core.data.ba top_notice_data = oVar26.avA().getTop_notice_data();
                                    if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                        com.baidu.tbadk.core.data.ax axVar = new com.baidu.tbadk.core.data.ax();
                                        axVar.setTitle(top_notice_data.getTitle());
                                        axVar.bI(2);
                                        axVar.cr(top_notice_data.rH());
                                        axVar.parser_title();
                                        oVar28 = this.bhl.bgq;
                                        oVar28.p(axVar);
                                    }
                                    oVar27 = this.bhl.bgq;
                                    oVar27.aSQ();
                                }
                                this.bhl.PD();
                                oVar7 = this.bhl.bgq;
                                if (oVar7.aSS()) {
                                    dVar = this.bhl.bgI;
                                    cnVar16 = this.bhl.bgo;
                                    BdExpandListView QR = cnVar16.QR();
                                    oVar24 = this.bhl.bgq;
                                    dVar.a(QR, oVar24);
                                }
                                bVar = this.bhl.bgN;
                                if (bVar != null) {
                                    bVar2 = this.bhl.bgN;
                                    mVar2 = this.bhl.bgE;
                                    oVar23 = this.bhl.bgq;
                                    bVar2.a(mVar2, oVar23);
                                }
                                FrsActivity.bgv = (System.nanoTime() - this.startTime) / 1000000;
                                if (aVar != null) {
                                    FrsActivity.bgw = aVar.eqe;
                                }
                                oVar8 = this.bhl.bgq;
                                if (oVar8 != null) {
                                    oVar21 = this.bhl.bgq;
                                    if (oVar21.getThreadList() != null) {
                                        oVar22 = this.bhl.bgq;
                                        if (oVar22.getThreadList().size() == 0 && this.bhl.Qd().getType() == 4) {
                                            this.bhl.showToast(this.bhl.getPageContext().getString(t.j.no_more_to_load));
                                            i4 = this.bhl.mPn;
                                            if (i4 > 1) {
                                                FrsActivity frsActivity9 = this.bhl;
                                                i5 = frsActivity9.mPn;
                                                frsActivity9.mPn = i5 - 1;
                                            }
                                            if (this.bhl.aXp > -1) {
                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bhl.aXp, this.bhl.Qd().MP() - this.bhl.aXp, this.bhl.Qd().MN(), this.bhl.Qd().MO(), currentTimeMillis2 - this.bhl.Qd().MM());
                                                this.bhl.aXp = -1L;
                                            }
                                            this.bhl.axE = System.currentTimeMillis() - currentTimeMillis;
                                            return;
                                        }
                                    }
                                }
                                oVar9 = this.bhl.bgq;
                                if (oVar9 != null) {
                                    oVar19 = this.bhl.bgq;
                                    if (oVar19.getUserData() != null) {
                                        oVar20 = this.bhl.bgq;
                                        if (oVar20.getUserData().isBawu()) {
                                            yVar3 = this.bhl.bgF;
                                            yVar3.setIsManager(true);
                                            oVar10 = this.bhl.bgq;
                                            if (oVar10 != null) {
                                                oVar15 = this.bhl.bgq;
                                                if (oVar15.avA() != null) {
                                                    yVar2 = this.bhl.bgF;
                                                    oVar18 = this.bhl.bgq;
                                                    yVar2.dn(oVar18.avA().isLike() == 1);
                                                }
                                                aVar3 = this.bhl.bgL;
                                                oVar16 = this.bhl.bgq;
                                                ArrayList<com.baidu.adp.widget.ListView.v> a = aVar3.a(true, oVar16.getThreadList());
                                                if (a != null) {
                                                    oVar17 = this.bhl.bgq;
                                                    oVar17.an(a);
                                                }
                                            }
                                            if (this.bhl.bgC.Tr() == 1) {
                                                this.bhl.PN();
                                            }
                                            oVar11 = this.bhl.bgq;
                                            if (oVar11 != null) {
                                                FrsActivity frsActivity10 = this.bhl;
                                                oVar14 = this.bhl.bgq;
                                                frsActivity10.bgj = oVar14.Ts();
                                            }
                                            fVar = this.bhl.bgl;
                                            if (fVar != null) {
                                                this.bhl.bgk = false;
                                                fVar2 = this.bhl.bgl;
                                                i3 = this.bhl.bgj;
                                                fVar2.pj(i3);
                                            }
                                            mVar = this.bhl.bgE;
                                            oVar12 = this.bhl.bgq;
                                            if (oVar12 != null) {
                                                oVar13 = this.bhl.bgq;
                                                if (oVar13.aSc()) {
                                                    z4 = true;
                                                    mVar.dm(z4);
                                                    cnVar15 = this.bhl.bgo;
                                                    cnVar15.gs(i);
                                                }
                                            }
                                            z4 = false;
                                            mVar.dm(z4);
                                            cnVar15 = this.bhl.bgo;
                                            cnVar15.gs(i);
                                        }
                                    }
                                }
                                yVar = this.bhl.bgF;
                                yVar.setIsManager(false);
                                oVar10 = this.bhl.bgq;
                                if (oVar10 != null) {
                                }
                                if (this.bhl.bgC.Tr() == 1) {
                                }
                                oVar11 = this.bhl.bgq;
                                if (oVar11 != null) {
                                }
                                fVar = this.bhl.bgl;
                                if (fVar != null) {
                                }
                                mVar = this.bhl.bgE;
                                oVar12 = this.bhl.bgq;
                                if (oVar12 != null) {
                                }
                                z4 = false;
                                mVar.dm(z4);
                                cnVar15 = this.bhl.bgo;
                                cnVar15.gs(i);
                            }
                            if (this.bhl.aXp > -1) {
                                long currentTimeMillis3 = System.currentTimeMillis();
                                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bhl.aXp, this.bhl.Qd().MP() - this.bhl.aXp, this.bhl.Qd().MN(), this.bhl.Qd().MO(), currentTimeMillis3 - this.bhl.Qd().MM());
                                this.bhl.aXp = -1L;
                            }
                            this.bhl.axE = System.currentTimeMillis() - currentTimeMillis;
                            System.gc();
                            return;
                        }
                        if (TbadkCoreApplication.m11getInst().isRecAppExist()) {
                            oVar49 = this.bhl.bgq;
                            oVar49.aQ(this.bhl.getPageContext().getPageActivity());
                            oVar50 = this.bhl.bgq;
                            if (oVar50.avA() != null) {
                                oVar52 = this.bhl.bgq;
                                str = oVar52.avA().getId();
                            } else {
                                str = "";
                            }
                            oVar51 = this.bhl.bgq;
                            oVar51.N(this.bhl.getPageContext().getPageActivity(), str);
                        }
                        aVar4 = this.bhl.bgL;
                        oVar45 = this.bhl.bgq;
                        ArrayList<com.baidu.adp.widget.ListView.v> threadList = oVar45.getThreadList();
                        fVar3 = this.bhl.bgl;
                        ArrayList<com.baidu.adp.widget.ListView.v> a2 = aVar4.a(false, threadList, fVar3);
                        if (a2 != null) {
                            oVar46 = this.bhl.bgq;
                            oVar46.an(a2);
                            oVar47 = this.bhl.bgq;
                            oVar47.aSH();
                            cnVar19 = this.bhl.bgo;
                            i6 = this.bhl.mPn;
                            oVar48 = this.bhl.bgq;
                            i7 = this.bhl.bgM;
                            cnVar19.a(a2, i6, oVar48, i7);
                            return;
                        }
                        return;
                    }
                }
                cnVar20 = this.bhl.bgo;
                cnVar20.Ri();
                if (i != 4) {
                }
            }
            cnVar4 = this.bhl.bgo;
            cnVar4.Rg();
            if (i != 4) {
            }
        } else {
            oVar58 = this.bhl.bgq;
            this.bhl.gi(oVar58.aSu());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.bhl.Qd().JP()) && !"frs_page".equals(this.bhl.Qd().JP())) {
                return;
            }
            this.bhl.a(mVar);
        }
    }
}
