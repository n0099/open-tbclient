package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.frs.loadmore.a;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class as implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity bQi;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void hT(int i) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        this.startTime = System.nanoTime();
        bmVar = this.bQi.bPi;
        if (bmVar != null) {
            switch (i) {
                case 1:
                    bmVar3 = this.bQi.bPi;
                    bmVar3.abK();
                    return;
                case 2:
                    bmVar2 = this.bQi.bPi;
                    bmVar2.abK();
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

    @Override // com.baidu.tieba.tbadkCore.r
    public void a(int i, boolean z, e.a aVar) {
        boolean z2;
        bm bmVar;
        com.baidu.tieba.frs.i.y yVar;
        bm bmVar2;
        bm bmVar3;
        a aVar2;
        bm bmVar4;
        int i2;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        bm bmVar9;
        bm bmVar10;
        boolean z3;
        bm bmVar11;
        bm bmVar12;
        bm bmVar13;
        bm bmVar14;
        bm bmVar15;
        boolean z4;
        b bVar;
        com.baidu.tieba.tbadkCore.data.f fVar;
        bm bmVar16;
        com.baidu.tieba.frs.i.a aVar3;
        com.baidu.tieba.frs.i.a aVar4;
        com.baidu.tieba.frs.i.a aVar5;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        int i3;
        com.baidu.tieba.frs.i.aa aaVar;
        com.baidu.tieba.frs.i.aa aaVar2;
        a aVar6;
        com.baidu.tieba.frs.i.aa aaVar3;
        com.baidu.tieba.frs.i.aa aaVar4;
        int i4;
        int i5;
        b bVar2;
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        bm bmVar17;
        bm bmVar18;
        bm bmVar19;
        bm bmVar20;
        bm bmVar21;
        a aVar7;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        bm bmVar22;
        int i6;
        int i7;
        bm bmVar23;
        bm bmVar24;
        bm bmVar25;
        bm bmVar26;
        boolean z5;
        com.baidu.tieba.frs.i.y yVar2;
        boolean z6;
        bm bmVar27;
        z2 = this.bQi.bPE;
        if (z2) {
            this.bQi.bPE = false;
            this.bQi.aaQ();
        }
        bmVar = this.bQi.bPi;
        if (bmVar.abG() != null) {
            z6 = this.bQi.mIsLogin;
            if (z6) {
                bmVar27 = this.bQi.bPi;
                bmVar27.abG().setVisibility(0);
            }
        }
        yVar = this.bQi.bPw;
        if (yVar != null) {
            z5 = this.bQi.mIsLogin;
            if (z5) {
                yVar2 = this.bQi.bPw;
                yVar2.dX(true);
            }
        }
        bmVar2 = this.bQi.bPi;
        if (bmVar2.abA() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar26 = this.bQi.bPi;
            ((com.baidu.tieba.frs.tab.h) bmVar26.abA()).afo();
        }
        bmVar3 = this.bQi.bPi;
        bmVar3.abR();
        this.bQi.bPO = true;
        if (aVar != null && aVar.isSuccess) {
            bmVar25 = this.bQi.bPi;
            bmVar25.abW().dU(com.baidu.tbadk.core.util.ba.vy().vA());
            FrsActivity.bPm = 0L;
            FrsActivity.bPn = 0L;
            FrsActivity.bPo = 0;
        } else {
            FrsActivity.bPo = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bQi.bPC;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bQi.abi().aek() != null) {
            this.bQi.bPk = this.bQi.abi().aek();
        }
        if (i != 7) {
            bmVar4 = this.bQi.bPi;
            bmVar4.dI(false);
            this.bQi.bPD = this.bQi.bPk.getPage().qB();
            i2 = this.bQi.bPD;
            if (i2 != 0 || (this.bQi.bPk.bhS() != null && this.bQi.bPk.bhS().size() != 0)) {
                bmVar5 = this.bQi.bPi;
                bmVar5.aca();
            } else if (this.bQi.bPk.getThreadList() == null || this.bQi.bPk.getThreadList().size() == 0) {
                bmVar23 = this.bQi.bPi;
                bmVar23.acc();
            } else {
                bmVar24 = this.bQi.bPi;
                bmVar24.acb();
            }
            if (i != 4) {
                switch (i) {
                    case 1:
                        bmVar7 = this.bQi.bPi;
                        bmVar7.abK();
                        break;
                    case 2:
                        bmVar6 = this.bQi.bPi;
                        bmVar6.abK();
                        break;
                    case 3:
                    case 6:
                        if (this.bQi.bPk != null) {
                            this.bQi.bPk.biy();
                            break;
                        }
                        break;
                }
                FrsActivity frsActivity = this.bQi;
                bmVar8 = this.bQi.bPi;
                frsActivity.hideLoadingView(bmVar8.getRootView());
                bmVar9 = this.bQi.bPi;
                bmVar9.dJ(false);
                if (this.bQi.bPk == null) {
                    bmVar10 = this.bQi.bPi;
                    bmVar10.abV();
                } else if (this.bQi.bPk.aMr() == null || this.bQi.bPk.aMr().getYuleData() == null || !this.bQi.bPk.aMr().getYuleData().te()) {
                    bmVar20 = this.bQi.bPi;
                    bmVar20.abV();
                } else {
                    TiebaStatic.log("c10852");
                    bmVar21 = this.bQi.bPi;
                    bmVar21.a(this.bQi.bPk.aMr().getYuleData().tf());
                }
                if (z || (aVar != null && aVar.errorCode != 0)) {
                    z3 = this.bQi.bOT;
                    if (!z3) {
                        if (aVar != null) {
                            if (aVar.fsg) {
                                if (340001 == aVar.errorCode) {
                                    FrsActivity frsActivity2 = this.bQi;
                                    bmVar14 = this.bQi.bPi;
                                    frsActivity2.showNetRefreshViewNoClick(bmVar14.getRootView(), this.bQi.getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                } else {
                                    FrsActivity frsActivity3 = this.bQi;
                                    bmVar13 = this.bQi.bPi;
                                    frsActivity3.showNetRefreshView(bmVar13.getRootView(), this.bQi.getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                }
                            } else if (340001 == aVar.errorCode) {
                                FrsActivity frsActivity4 = this.bQi;
                                bmVar12 = this.bQi.bPi;
                                frsActivity4.showNetRefreshViewNoClick(bmVar12.getRootView(), aVar.errorMsg, true);
                            } else {
                                FrsActivity frsActivity5 = this.bQi;
                                bmVar11 = this.bQi.bPi;
                                frsActivity5.showNetRefreshView(bmVar11.getRootView(), aVar.errorMsg, true);
                            }
                            this.bQi.setNetRefreshViewEmotionDefMarginTop();
                        }
                    } else if (aVar != null && aVar.fsg) {
                        this.bQi.showToast(this.bQi.getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                    }
                } else {
                    this.bQi.bOT = true;
                    this.bQi.bPh = true;
                    if (this.bQi.bPk != null) {
                        this.bQi.bOZ = this.bQi.bPk.aMr().getName();
                        this.bQi.forumId = this.bQi.bPk.aMr().getId();
                    }
                    z4 = this.bQi.bPs;
                    if (z4 && this.bQi.bPk != null && this.bQi.bPt.afa() == 1) {
                        this.bQi.bPk.biB();
                        bmVar18 = this.bQi.bPi;
                        if (bmVar18.abW().k(com.baidu.tieba.tbadkCore.al.fud)) {
                            this.bQi.bPk.biC();
                        }
                        if (!this.bQi.bPt.afg()) {
                            this.bQi.bPk.biI();
                        }
                        if (!this.bQi.abi().aeX()) {
                            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && !this.bQi.bPt.afg()) {
                                this.bQi.bPk.biH();
                                this.bQi.bPk.biG();
                                this.bQi.bPk.biE();
                            }
                            if (!this.bQi.bPt.afg()) {
                                this.bQi.bPk.biF();
                            }
                        }
                        boolean z7 = false;
                        bmVar19 = this.bQi.bPi;
                        if (bmVar19.abW().k(com.baidu.tieba.card.data.q.bcA) && !this.bQi.bPt.afg()) {
                            z7 = this.bQi.bPk.biL();
                        }
                        if (!z7 && !this.bQi.bPt.afg()) {
                            this.bQi.bPk.biK();
                        }
                        if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                            this.bQi.bPk.bc(this.bQi.getPageContext().getPageActivity());
                        }
                    }
                    if (this.bQi.bPk != null) {
                        this.bQi.bPk.biA();
                        com.baidu.tbadk.core.data.bn top_notice_data = this.bQi.bPk.aMr().getTop_notice_data();
                        if (top_notice_data != null && top_notice_data.getTitle() != null) {
                            com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
                            biVar.setTitle(top_notice_data.getTitle());
                            biVar.bV(2);
                            biVar.cu(top_notice_data.sY());
                            biVar.su();
                            this.bQi.bPk.v(biVar);
                        }
                        this.bQi.bPk.biM();
                        this.bQi.bPk.biN();
                    }
                    this.bQi.aaK();
                    if (this.bQi.bPk.biP()) {
                        dVar2 = this.bQi.bPy;
                        bmVar17 = this.bQi.bPi;
                        dVar2.a(bmVar17.abN(), this.bQi.bPk, this.bQi.bPt.afi());
                    }
                    bVar = this.bQi.bPF;
                    if (bVar != null) {
                        bVar2 = this.bQi.bPF;
                        pVar = this.bQi.bPu;
                        bVar2.a(pVar, this.bQi.bPk);
                    }
                    FrsActivity.bPm = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsActivity.bPn = aVar.fsh;
                    }
                    if (this.bQi.bPk == null || this.bQi.bPk.getThreadList() == null || this.bQi.bPk.getThreadList().size() != 0 || this.bQi.abi().getType() != 4) {
                        if (this.bQi.bPk != null) {
                            if (this.bQi.bPk.aMr() != null) {
                                aaVar4 = this.bQi.bPv;
                                aaVar4.ei(this.bQi.bPk.aMr().isLike() == 1);
                            }
                            if (this.bQi.bPk.aMr().isIs_forbidden() == 1) {
                                aaVar3 = this.bQi.bPv;
                                aaVar3.ek(false);
                            } else {
                                aaVar = this.bQi.bPv;
                                aaVar.ek(true);
                            }
                            aaVar2 = this.bQi.bPv;
                            aaVar2.ej(this.bQi.bPk.bhL() == 1);
                            aVar6 = this.bQi.bPC;
                            ArrayList<com.baidu.adp.widget.ListView.v> a = aVar6.a(true, this.bQi.bPk.getThreadList());
                            if (a != null) {
                                this.bQi.bPk.aA(a);
                            }
                        }
                        if (this.bQi.bPt.afa() == 1) {
                            this.bQi.aaT();
                        }
                        if (this.bQi.bPk != null) {
                            this.bQi.bPc = this.bQi.bPk.afc();
                        }
                        fVar = this.bQi.bPe;
                        if (fVar != null) {
                            this.bQi.bPd = false;
                            fVar2 = this.bQi.bPe;
                            i3 = this.bQi.bPc;
                            fVar2.rI(i3);
                        }
                        bmVar16 = this.bQi.bPi;
                        bmVar16.hW(i);
                        aVar3 = this.bQi.bPI;
                        if (aVar3 != null) {
                            aVar4 = this.bQi.bPI;
                            aVar4.eg(this.bQi.bPt.afg());
                            aVar5 = this.bQi.bPI;
                            dVar = this.bQi.bPy;
                            aVar5.ah(dVar.adw());
                        }
                    } else {
                        this.bQi.showToast(this.bQi.getPageContext().getString(r.j.no_more_to_load));
                        i4 = this.bQi.mPn;
                        if (i4 > 1) {
                            FrsActivity frsActivity6 = this.bQi;
                            i5 = frsActivity6.mPn;
                            frsActivity6.mPn = i5 - 1;
                        }
                        if (this.bQi.bGX > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bQi.bGX, this.bQi.abi().Yf() - this.bQi.bGX, this.bQi.abi().Yd(), this.bQi.abi().Ye(), currentTimeMillis2 - this.bQi.abi().Yc());
                            this.bQi.bGX = -1L;
                        }
                        this.bQi.aBU = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.bQi.bPk.bhM() == 1) {
                    if (!this.bQi.bPt.afg()) {
                        bmVar15 = this.bQi.bPi;
                        bmVar15.acm();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11384"));
                }
                if (this.bQi.bGX > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bQi.bGX, this.bQi.abi().Yf() - this.bQi.bGX, this.bQi.abi().Yd(), this.bQi.abi().Ye(), currentTimeMillis3 - this.bQi.abi().Yc());
                    this.bQi.bGX = -1L;
                }
                this.bQi.aBU = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                this.bQi.bPk.bc(this.bQi.getPageContext().getPageActivity());
            }
            aVar7 = this.bQi.bPC;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bQi.bPk.getThreadList();
            fVar3 = this.bQi.bPe;
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = aVar7.a(false, threadList, fVar3);
            if (a2 != null) {
                this.bQi.bPk.aA(a2);
                this.bQi.bPk.biA();
                bmVar22 = this.bQi.bPi;
                i6 = this.bQi.mPn;
                com.baidu.tieba.tbadkCore.p pVar2 = this.bQi.bPk;
                i7 = this.bQi.bPD;
                bmVar22.a(a2, i6, pVar2, i7);
            }
            if (this.bQi.abi() != null) {
                com.baidu.tieba.frs.g.b.a(this.bQi.bPk, this.bQi.abi().acs(), 2);
                return;
            }
            return;
        }
        this.bQi.hP(this.bQi.bPk.bii());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if (!"normal_page".equals(this.bQi.abi().aeV()) && !"frs_page".equals(this.bQi.abi().aeV()) && !"book_page".equals(this.bQi.abi().aeV())) {
                return;
            }
            this.bQi.a(nVar);
        }
    }
}
