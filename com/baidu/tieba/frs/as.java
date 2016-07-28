package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.frs.loadmore.a;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
class as implements com.baidu.tieba.tbadkCore.s {
    final /* synthetic */ FrsActivity bEL;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void hm(int i) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        this.startTime = System.nanoTime();
        bqVar = this.bEL.bDK;
        if (bqVar != null) {
            switch (i) {
                case 1:
                    bqVar3 = this.bEL.bDK;
                    bqVar3.WC();
                    return;
                case 2:
                    bqVar2 = this.bEL.bDK;
                    bqVar2.WC();
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

    @Override // com.baidu.tieba.tbadkCore.s
    public void a(int i, boolean z, e.a aVar) {
        bq bqVar;
        com.baidu.tieba.frs.j.y yVar;
        bq bqVar2;
        bq bqVar3;
        a aVar2;
        bq bqVar4;
        int i2;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        bq bqVar10;
        boolean z2;
        bq bqVar11;
        bq bqVar12;
        bq bqVar13;
        bq bqVar14;
        bq bqVar15;
        boolean z3;
        b bVar;
        com.baidu.tieba.frs.j.aa aaVar;
        com.baidu.tieba.tbadkCore.data.f fVar;
        bq bqVar16;
        com.baidu.tieba.frs.j.a aVar3;
        com.baidu.tieba.frs.j.a aVar4;
        com.baidu.tieba.frs.j.a aVar5;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        int i3;
        com.baidu.tieba.frs.j.aa aaVar2;
        com.baidu.tieba.frs.j.aa aaVar3;
        a aVar6;
        com.baidu.tieba.frs.j.aa aaVar4;
        com.baidu.tieba.frs.j.aa aaVar5;
        com.baidu.tieba.frs.j.aa aaVar6;
        int i4;
        int i5;
        b bVar2;
        com.baidu.tieba.frs.j.p pVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        bq bqVar17;
        bq bqVar18;
        bq bqVar19;
        com.baidu.tieba.frs.j.p pVar2;
        bq bqVar20;
        bq bqVar21;
        a aVar7;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        bq bqVar22;
        int i6;
        int i7;
        bq bqVar23;
        bq bqVar24;
        bq bqVar25;
        bq bqVar26;
        bq bqVar27;
        bq bqVar28;
        t.b bVar3;
        bq bqVar29;
        t.d dVar3;
        bq bqVar30;
        t.a aVar8;
        boolean z4;
        com.baidu.tieba.frs.j.y yVar2;
        boolean z5;
        bq bqVar31;
        bqVar = this.bEL.bDK;
        if (bqVar.Wy() != null) {
            z5 = this.bEL.mIsLogin;
            if (z5) {
                bqVar31 = this.bEL.bDK;
                bqVar31.Wy().setVisibility(0);
            }
        }
        yVar = this.bEL.bEa;
        if (yVar != null) {
            z4 = this.bEL.mIsLogin;
            if (z4) {
                yVar2 = this.bEL.bEa;
                yVar2.dA(true);
            }
        }
        if (com.baidu.tieba.frs.j.p.h(this.bEL.VY().Zj())) {
            bqVar27 = this.bEL.bDK;
            bqVar27.Xb();
            bqVar28 = this.bEL.bDK;
            bVar3 = this.bEL.ado;
            bqVar28.a(bVar3);
            bqVar29 = this.bEL.bDK;
            dVar3 = this.bEL.adr;
            bqVar29.a(dVar3);
            bqVar30 = this.bEL.bDK;
            aVar8 = this.bEL.adq;
            bqVar30.a(aVar8);
        }
        bqVar2 = this.bEL.bDK;
        if (bqVar2.Wr() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar26 = this.bEL.bDK;
            ((com.baidu.tieba.frs.tab.h) bqVar26.Wr()).aap();
        }
        bqVar3 = this.bEL.bDK;
        bqVar3.WI();
        this.bEL.bEr = true;
        if (aVar != null && aVar.isSuccess) {
            bqVar25 = this.bEL.bDK;
            bqVar25.WN().dx(com.baidu.tbadk.core.util.bb.ue().ug());
            FrsActivity.bDQ = 0L;
            FrsActivity.bDR = 0L;
            FrsActivity.bDS = 0;
        } else {
            FrsActivity.bDS = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bEL.bEg;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bEL.VY().Zj() != null) {
            this.bEL.bDM = this.bEL.VY().Zj();
        }
        if (i != 7) {
            bqVar4 = this.bEL.bDK;
            bqVar4.dj(false);
            this.bEL.bEh = this.bEL.bDM.getPage().pn();
            i2 = this.bEL.bEh;
            if (i2 != 0 || (this.bEL.bDM.bdG() != null && this.bEL.bDM.bdG().size() != 0)) {
                bqVar5 = this.bEL.bDK;
                bqVar5.WR();
            } else if (this.bEL.bDM.getThreadList() == null || this.bEL.bDM.getThreadList().size() == 0) {
                bqVar23 = this.bEL.bDK;
                bqVar23.WT();
            } else {
                bqVar24 = this.bEL.bDK;
                bqVar24.WS();
            }
            if (i != 4) {
                switch (i) {
                    case 1:
                        bqVar7 = this.bEL.bDK;
                        bqVar7.WC();
                        break;
                    case 2:
                        bqVar6 = this.bEL.bDK;
                        bqVar6.WC();
                        break;
                    case 3:
                    case 6:
                        if (this.bEL.bDM != null) {
                            this.bEL.bDM.bei();
                            break;
                        }
                        break;
                }
                FrsActivity frsActivity = this.bEL;
                bqVar8 = this.bEL.bDK;
                frsActivity.hideLoadingView(bqVar8.getRootView());
                bqVar9 = this.bEL.bDK;
                bqVar9.dk(false);
                if (this.bEL.bDM == null) {
                    bqVar10 = this.bEL.bDK;
                    bqVar10.WM();
                } else if (this.bEL.bDM.aGX() == null || this.bEL.bDM.aGX().getYuleData() == null || !this.bEL.bDM.aGX().getYuleData().rK()) {
                    bqVar20 = this.bEL.bDK;
                    bqVar20.WM();
                } else {
                    TiebaStatic.log("c10852");
                    bqVar21 = this.bEL.bDK;
                    bqVar21.a(this.bEL.bDM.aGX().getYuleData().rL());
                }
                if (z || (aVar != null && aVar.errorCode != 0)) {
                    z2 = this.bEL.bDv;
                    if (!z2) {
                        if (aVar != null) {
                            if (aVar.fhI) {
                                if (340001 == aVar.errorCode) {
                                    FrsActivity frsActivity2 = this.bEL;
                                    bqVar14 = this.bEL.bDK;
                                    frsActivity2.showNetRefreshViewNoClick(bqVar14.getRootView(), this.bEL.getPageContext().getResources().getString(u.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                } else {
                                    FrsActivity frsActivity3 = this.bEL;
                                    bqVar13 = this.bEL.bDK;
                                    frsActivity3.showNetRefreshView(bqVar13.getRootView(), this.bEL.getPageContext().getResources().getString(u.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                }
                            } else if (340001 == aVar.errorCode) {
                                FrsActivity frsActivity4 = this.bEL;
                                bqVar12 = this.bEL.bDK;
                                frsActivity4.showNetRefreshViewNoClick(bqVar12.getRootView(), aVar.errorMsg, true);
                            } else {
                                FrsActivity frsActivity5 = this.bEL;
                                bqVar11 = this.bEL.bDK;
                                frsActivity5.showNetRefreshView(bqVar11.getRootView(), aVar.errorMsg, true);
                            }
                            this.bEL.setNetRefreshViewEmotionDefMarginTop();
                        }
                    } else if (aVar != null && aVar.fhI) {
                        this.bEL.showToast(this.bEL.getPageContext().getResources().getString(u.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                    }
                } else {
                    this.bEL.bDv = true;
                    this.bEL.bDJ = true;
                    if (this.bEL.bDM != null) {
                        this.bEL.bDB = this.bEL.bDM.aGX().getName();
                        this.bEL.forumId = this.bEL.bDM.aGX().getId();
                        if (this.bEL.bDM.aGX().getFrsBannerData().getType() == 2) {
                            pVar2 = this.bEL.bDY;
                            pVar2.hW(this.bEL.bDM.getUserData().getIsMem());
                        }
                    }
                    z3 = this.bEL.bDW;
                    if (z3 && this.bEL.bDM != null && this.bEL.bDX.aab() == 1) {
                        this.bEL.bDM.bel();
                        bqVar18 = this.bEL.bDK;
                        if (bqVar18.WN().k(com.baidu.tieba.tbadkCore.am.fjD)) {
                            this.bEL.bDM.bem();
                        }
                        if (!this.bEL.bDX.aah()) {
                            this.bEL.bDM.bes();
                        }
                        if (!this.bEL.VY().ZY()) {
                            if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && !this.bEL.bDX.aah()) {
                                this.bEL.bDM.ber();
                                this.bEL.bDM.beq();
                                this.bEL.bDM.beo();
                            }
                            if (!this.bEL.bDX.aah()) {
                                this.bEL.bDM.bep();
                            }
                        }
                        boolean z6 = false;
                        bqVar19 = this.bEL.bDK;
                        if (bqVar19.WN().k(com.baidu.tieba.card.a.q.aWG) && !this.bEL.bDX.aah()) {
                            z6 = this.bEL.bDM.bev();
                        }
                        if (!z6 && !this.bEL.bDX.aah()) {
                            this.bEL.bDM.beu();
                        }
                        if (TbadkCoreApplication.m10getInst().isRecAppExist()) {
                            this.bEL.bDM.aS(this.bEL.getPageContext().getPageActivity());
                        }
                    }
                    if (this.bEL.bDM != null) {
                        this.bEL.bDM.bek();
                        com.baidu.tbadk.core.data.bh top_notice_data = this.bEL.bDM.aGX().getTop_notice_data();
                        if (top_notice_data != null && top_notice_data.getTitle() != null) {
                            com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                            beVar.setTitle(top_notice_data.getTitle());
                            beVar.bI(2);
                            beVar.cr(top_notice_data.rE());
                            beVar.rd();
                            this.bEL.bDM.v(beVar);
                        }
                        this.bEL.bDM.bew();
                    }
                    this.bEL.VB();
                    if (this.bEL.bDM.bey()) {
                        dVar2 = this.bEL.bEc;
                        bqVar17 = this.bEL.bDK;
                        dVar2.a(bqVar17.getListView(), this.bEL.bDM, this.bEL.bDX.aaj());
                    }
                    bVar = this.bEL.bEi;
                    if (bVar != null) {
                        bVar2 = this.bEL.bEi;
                        pVar = this.bEL.bDY;
                        bVar2.a(pVar, this.bEL.bDM);
                    }
                    FrsActivity.bDQ = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsActivity.bDR = aVar.fhJ;
                    }
                    if (this.bEL.bDM == null || this.bEL.bDM.getThreadList() == null || this.bEL.bDM.getThreadList().size() != 0 || this.bEL.VY().getType() != 4) {
                        if (this.bEL.bDM == null || this.bEL.bDM.getUserData() == null || !this.bEL.bDM.getUserData().isBawu()) {
                            aaVar = this.bEL.bDZ;
                            aaVar.setIsManager(false);
                        } else {
                            aaVar6 = this.bEL.bDZ;
                            aaVar6.setIsManager(true);
                        }
                        if (this.bEL.bDM != null) {
                            if (this.bEL.bDM.aGX() != null) {
                                aaVar5 = this.bEL.bDZ;
                                aaVar5.dL(this.bEL.bDM.aGX().isLike() == 1);
                            }
                            if (this.bEL.bDM.aGX().isIs_forbidden() == 1) {
                                aaVar4 = this.bEL.bDZ;
                                aaVar4.dN(false);
                            } else {
                                aaVar2 = this.bEL.bDZ;
                                aaVar2.dN(true);
                            }
                            aaVar3 = this.bEL.bDZ;
                            aaVar3.dM(this.bEL.bDM.bdz() == 1);
                            aVar6 = this.bEL.bEg;
                            ArrayList<com.baidu.adp.widget.ListView.v> a = aVar6.a(true, this.bEL.bDM.getThreadList());
                            if (a != null) {
                                this.bEL.bDM.aB(a);
                            }
                        }
                        if (this.bEL.bDX.aab() == 1) {
                            this.bEL.VK();
                        }
                        if (this.bEL.bDM != null) {
                            this.bEL.bDE = this.bEL.bDM.aad();
                        }
                        fVar = this.bEL.bDG;
                        if (fVar != null) {
                            this.bEL.bDF = false;
                            fVar2 = this.bEL.bDG;
                            i3 = this.bEL.bDE;
                            fVar2.qT(i3);
                        }
                        bqVar16 = this.bEL.bDK;
                        bqVar16.hp(i);
                        aVar3 = this.bEL.bEl;
                        if (aVar3 != null) {
                            aVar4 = this.bEL.bEl;
                            aVar4.dJ(this.bEL.bDX.aah());
                            aVar5 = this.bEL.bEl;
                            dVar = this.bEL.bEc;
                            aVar5.ai(dVar.Yw());
                        }
                    } else {
                        this.bEL.showToast(this.bEL.getPageContext().getString(u.j.no_more_to_load));
                        i4 = this.bEL.mPn;
                        if (i4 > 1) {
                            FrsActivity frsActivity6 = this.bEL;
                            i5 = frsActivity6.mPn;
                            frsActivity6.mPn = i5 - 1;
                        }
                        if (this.bEL.bvA > -1) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bEL.bvA, this.bEL.VY().Tb() - this.bEL.bvA, this.bEL.VY().SZ(), this.bEL.VY().Ta(), currentTimeMillis2 - this.bEL.VY().SY());
                            this.bEL.bvA = -1L;
                        }
                        this.bEL.azk = System.currentTimeMillis() - currentTimeMillis;
                        return;
                    }
                }
                if (this.bEL.bDM.bdA() == 1) {
                    if (!this.bEL.bDX.aah()) {
                        bqVar15 = this.bEL.bDK;
                        bqVar15.Xc();
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11384"));
                }
                if (this.bEL.bvA > -1) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bEL.bvA, this.bEL.VY().Tb() - this.bEL.bvA, this.bEL.VY().SZ(), this.bEL.VY().Ta(), currentTimeMillis3 - this.bEL.VY().SY());
                    this.bEL.bvA = -1L;
                }
                this.bEL.azk = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (TbadkCoreApplication.m10getInst().isRecAppExist()) {
                this.bEL.bDM.aS(this.bEL.getPageContext().getPageActivity());
            }
            aVar7 = this.bEL.bEg;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bEL.bDM.getThreadList();
            fVar3 = this.bEL.bDG;
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = aVar7.a(false, threadList, fVar3);
            if (a2 != null) {
                this.bEL.bDM.aB(a2);
                this.bEL.bDM.bek();
                bqVar22 = this.bEL.bDK;
                i6 = this.bEL.mPn;
                com.baidu.tieba.tbadkCore.p pVar3 = this.bEL.bDM;
                i7 = this.bEL.bEh;
                bqVar22.a(a2, i6, pVar3, i7);
            }
            if (this.bEL.VY() != null) {
                com.baidu.tieba.frs.h.b.a(this.bEL.bDM, this.bEL.VY().Xi(), 2);
                return;
            }
            return;
        }
        this.bEL.hi(this.bEL.bDM.bdV());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if (!"normal_page".equals(this.bEL.VY().KP()) && !"frs_page".equals(this.bEL.VY().KP())) {
                return;
            }
            this.bEL.a(nVar);
        }
    }
}
