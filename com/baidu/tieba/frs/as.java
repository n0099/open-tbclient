package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
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
    final /* synthetic */ FrsActivity bDB;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void hm(int i) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        this.startTime = System.nanoTime();
        bqVar = this.bDB.bCD;
        if (bqVar != null) {
            switch (i) {
                case 1:
                    bqVar3 = this.bDB.bCD;
                    bqVar3.Wl();
                    return;
                case 2:
                    bqVar2 = this.bDB.bCD;
                    bqVar2.Wl();
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

    /* JADX WARN: Code restructure failed: missing block: B:41:0x019e, code lost:
        if (r1.bas().size() == 0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0858  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0905  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0922  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x028e  */
    @Override // com.baidu.tieba.tbadkCore.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e.a aVar) {
        bq bqVar;
        com.baidu.tieba.frs.i.y yVar;
        bq bqVar2;
        bq bqVar3;
        a aVar2;
        bq bqVar4;
        com.baidu.tieba.tbadkCore.p pVar;
        int i2;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        bq bqVar8;
        bq bqVar9;
        com.baidu.tieba.tbadkCore.p pVar4;
        bq bqVar10;
        boolean z2;
        bq bqVar11;
        bq bqVar12;
        bq bqVar13;
        bq bqVar14;
        com.baidu.tieba.tbadkCore.p pVar5;
        bq bqVar15;
        com.baidu.tieba.tbadkCore.p pVar6;
        boolean z3;
        com.baidu.tieba.tbadkCore.p pVar7;
        com.baidu.tieba.tbadkCore.p pVar8;
        b bVar;
        com.baidu.tieba.tbadkCore.p pVar9;
        com.baidu.tieba.tbadkCore.p pVar10;
        com.baidu.tieba.frs.i.aa aaVar;
        com.baidu.tieba.tbadkCore.p pVar11;
        com.baidu.tieba.tbadkCore.p pVar12;
        com.baidu.tieba.tbadkCore.data.f fVar;
        bq bqVar16;
        com.baidu.tieba.frs.i.a aVar3;
        com.baidu.tieba.frs.i.a aVar4;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        int i3;
        com.baidu.tieba.tbadkCore.p pVar13;
        com.baidu.tieba.tbadkCore.p pVar14;
        com.baidu.tieba.tbadkCore.p pVar15;
        com.baidu.tieba.frs.i.aa aaVar2;
        com.baidu.tieba.frs.i.aa aaVar3;
        com.baidu.tieba.tbadkCore.p pVar16;
        a aVar5;
        com.baidu.tieba.tbadkCore.p pVar17;
        com.baidu.tieba.tbadkCore.p pVar18;
        com.baidu.tieba.frs.i.aa aaVar4;
        com.baidu.tieba.frs.i.aa aaVar5;
        com.baidu.tieba.tbadkCore.p pVar19;
        com.baidu.tieba.tbadkCore.p pVar20;
        com.baidu.tieba.tbadkCore.p pVar21;
        com.baidu.tieba.frs.i.aa aaVar6;
        com.baidu.tieba.tbadkCore.p pVar22;
        com.baidu.tieba.tbadkCore.p pVar23;
        int i4;
        int i5;
        b bVar2;
        com.baidu.tieba.frs.i.p pVar24;
        com.baidu.tieba.tbadkCore.p pVar25;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        bq bqVar17;
        com.baidu.tieba.tbadkCore.p pVar26;
        com.baidu.tieba.tbadkCore.p pVar27;
        com.baidu.tieba.tbadkCore.p pVar28;
        com.baidu.tieba.tbadkCore.p pVar29;
        com.baidu.tieba.tbadkCore.p pVar30;
        com.baidu.tieba.tbadkCore.p pVar31;
        com.baidu.tieba.tbadkCore.p pVar32;
        bq bqVar18;
        com.baidu.tieba.tbadkCore.p pVar33;
        bq bqVar19;
        com.baidu.tieba.tbadkCore.p pVar34;
        com.baidu.tieba.tbadkCore.p pVar35;
        com.baidu.tieba.tbadkCore.p pVar36;
        com.baidu.tieba.tbadkCore.p pVar37;
        com.baidu.tieba.tbadkCore.p pVar38;
        com.baidu.tieba.tbadkCore.p pVar39;
        com.baidu.tieba.tbadkCore.p pVar40;
        com.baidu.tieba.tbadkCore.p pVar41;
        com.baidu.tieba.tbadkCore.p pVar42;
        com.baidu.tieba.tbadkCore.p pVar43;
        com.baidu.tieba.tbadkCore.p pVar44;
        com.baidu.tieba.frs.i.p pVar45;
        com.baidu.tieba.tbadkCore.p pVar46;
        com.baidu.tieba.tbadkCore.p pVar47;
        bq bqVar20;
        com.baidu.tieba.tbadkCore.p pVar48;
        com.baidu.tieba.tbadkCore.p pVar49;
        bq bqVar21;
        com.baidu.tieba.tbadkCore.p pVar50;
        a aVar6;
        com.baidu.tieba.tbadkCore.p pVar51;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        com.baidu.tieba.tbadkCore.p pVar52;
        com.baidu.tieba.tbadkCore.p pVar53;
        bq bqVar22;
        int i6;
        com.baidu.tieba.tbadkCore.p pVar54;
        int i7;
        com.baidu.tieba.tbadkCore.p pVar55;
        com.baidu.tieba.tbadkCore.p pVar56;
        com.baidu.tieba.tbadkCore.p pVar57;
        bq bqVar23;
        com.baidu.tieba.tbadkCore.p pVar58;
        bq bqVar24;
        int i8;
        com.baidu.tieba.tbadkCore.p pVar59;
        int i9;
        bq bqVar25;
        com.baidu.tieba.tbadkCore.p pVar60;
        com.baidu.tieba.tbadkCore.p pVar61;
        bq bqVar26;
        bq bqVar27;
        bq bqVar28;
        bq bqVar29;
        t.b bVar3;
        bq bqVar30;
        t.d dVar3;
        bq bqVar31;
        t.a aVar7;
        boolean z4;
        com.baidu.tieba.frs.i.y yVar2;
        boolean z5;
        bq bqVar32;
        bqVar = this.bDB.bCD;
        if (bqVar.Wh() != null) {
            z5 = this.bDB.mIsLogin;
            if (z5) {
                bqVar32 = this.bDB.bCD;
                bqVar32.Wh().setVisibility(0);
            }
        }
        yVar = this.bDB.bCT;
        if (yVar != null) {
            z4 = this.bDB.mIsLogin;
            if (z4) {
                yVar2 = this.bDB.bCT;
                yVar2.dC(true);
            }
        }
        if (com.baidu.tieba.frs.i.p.h(this.bDB.VG().YO())) {
            bqVar28 = this.bDB.bCD;
            bqVar28.WJ();
            bqVar29 = this.bDB.bCD;
            bVar3 = this.bDB.acD;
            bqVar29.a(bVar3);
            bqVar30 = this.bDB.bCD;
            dVar3 = this.bDB.acG;
            bqVar30.a(dVar3);
            bqVar31 = this.bDB.bCD;
            aVar7 = this.bDB.acF;
            bqVar31.a(aVar7);
        }
        bqVar2 = this.bDB.bCD;
        if (bqVar2.Wa() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar27 = this.bDB.bCD;
            ((com.baidu.tieba.frs.tab.h) bqVar27.Wa()).US();
        }
        bqVar3 = this.bDB.bCD;
        bqVar3.Wr();
        this.bDB.bDk = true;
        if (aVar != null && aVar.isSuccess) {
            bqVar26 = this.bDB.bCD;
            bqVar26.Ww().db(com.baidu.tbadk.core.util.bb.uf().uh());
            FrsActivity.bCJ = 0L;
            FrsActivity.bCK = 0L;
            FrsActivity.bCL = 0;
        } else {
            FrsActivity.bCL = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bDB.bCZ;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bDB.VG().YO() != null) {
            this.bDB.bCF = this.bDB.VG().YO();
        }
        if (i != 7) {
            bqVar4 = this.bDB.bCD;
            bqVar4.dm(false);
            FrsActivity frsActivity = this.bDB;
            pVar = this.bDB.bCF;
            frsActivity.bDa = pVar.getPage().pE();
            i2 = this.bDB.bDa;
            if (i2 == 0) {
                pVar56 = this.bDB.bCF;
                if (pVar56.bas() != null) {
                    pVar60 = this.bDB.bCF;
                }
                pVar57 = this.bDB.bCF;
                if (pVar57.getThreadList() != null) {
                    pVar58 = this.bDB.bCF;
                    if (pVar58.getThreadList().size() != 0) {
                        bqVar24 = this.bDB.bCD;
                        i8 = FrsActivity.bCl;
                        pVar59 = this.bDB.bCF;
                        int size = pVar59.getThreadList().size();
                        i9 = FrsActivity.bCm;
                        bqVar24.hp(i8 - (size * i9));
                        bqVar25 = this.bDB.bCD;
                        bqVar25.WB();
                        if (i != 4) {
                            switch (i) {
                                case 1:
                                    bqVar7 = this.bDB.bCD;
                                    bqVar7.Wl();
                                    break;
                                case 2:
                                    bqVar6 = this.bDB.bCD;
                                    bqVar6.Wl();
                                    break;
                                case 3:
                                case 6:
                                    pVar2 = this.bDB.bCF;
                                    if (pVar2 != null) {
                                        pVar3 = this.bDB.bCF;
                                        pVar3.baU();
                                        break;
                                    }
                                    break;
                            }
                            FrsActivity frsActivity2 = this.bDB;
                            bqVar8 = this.bDB.bCD;
                            frsActivity2.hideLoadingView(bqVar8.getRootView());
                            bqVar9 = this.bDB.bCD;
                            bqVar9.dn(false);
                            pVar4 = this.bDB.bCF;
                            if (pVar4 == null) {
                                bqVar10 = this.bDB.bCD;
                                bqVar10.Wv();
                            } else {
                                pVar47 = this.bDB.bCF;
                                if (pVar47.aDN() != null) {
                                    pVar48 = this.bDB.bCF;
                                    if (pVar48.aDN().getYuleData() != null) {
                                        pVar49 = this.bDB.bCF;
                                        if (pVar49.aDN().getYuleData().rL()) {
                                            TiebaStatic.log("c10852");
                                            bqVar21 = this.bDB.bCD;
                                            pVar50 = this.bDB.bCF;
                                            bqVar21.a(pVar50.aDN().getYuleData().rM());
                                        }
                                    }
                                }
                                bqVar20 = this.bDB.bCD;
                                bqVar20.Wv();
                            }
                            if (z || (aVar != null && aVar.errorCode != 0)) {
                                z2 = this.bDB.bCo;
                                if (!z2) {
                                    if (aVar != null) {
                                        if (aVar.eUM) {
                                            if (340001 == aVar.errorCode) {
                                                FrsActivity frsActivity3 = this.bDB;
                                                bqVar14 = this.bDB.bCD;
                                                frsActivity3.showNetRefreshViewNoClick(bqVar14.getRootView(), this.bDB.getPageContext().getResources().getString(u.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                            } else {
                                                FrsActivity frsActivity4 = this.bDB;
                                                bqVar13 = this.bDB.bCD;
                                                frsActivity4.showNetRefreshView(bqVar13.getRootView(), this.bDB.getPageContext().getResources().getString(u.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                            }
                                        } else if (340001 == aVar.errorCode) {
                                            FrsActivity frsActivity5 = this.bDB;
                                            bqVar12 = this.bDB.bCD;
                                            frsActivity5.showNetRefreshViewNoClick(bqVar12.getRootView(), aVar.errorMsg, true);
                                        } else {
                                            FrsActivity frsActivity6 = this.bDB;
                                            bqVar11 = this.bDB.bCD;
                                            frsActivity6.showNetRefreshView(bqVar11.getRootView(), aVar.errorMsg, true);
                                        }
                                        this.bDB.setNetRefreshViewEmotionDefMarginTop();
                                    }
                                } else if (aVar != null && aVar.eUM) {
                                    this.bDB.showToast(this.bDB.getPageContext().getResources().getString(u.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                                }
                            } else {
                                this.bDB.bCo = true;
                                this.bDB.bCC = true;
                                pVar6 = this.bDB.bCF;
                                if (pVar6 != null) {
                                    FrsActivity frsActivity7 = this.bDB;
                                    pVar42 = this.bDB.bCF;
                                    frsActivity7.bCu = pVar42.aDN().getName();
                                    FrsActivity frsActivity8 = this.bDB;
                                    pVar43 = this.bDB.bCF;
                                    frsActivity8.forumId = pVar43.aDN().getId();
                                    pVar44 = this.bDB.bCF;
                                    if (pVar44.aDN().getFrsBannerData().getType() == 2) {
                                        pVar45 = this.bDB.bCR;
                                        pVar46 = this.bDB.bCF;
                                        pVar45.hV(pVar46.getUserData().getIsMem());
                                    }
                                }
                                z3 = this.bDB.bCP;
                                if (z3) {
                                    pVar31 = this.bDB.bCF;
                                    if (pVar31 != null && this.bDB.bCQ.ZF() == 1) {
                                        pVar32 = this.bDB.bCF;
                                        pVar32.baX();
                                        bqVar18 = this.bDB.bCD;
                                        if (bqVar18.Ww().k(com.baidu.tieba.tbadkCore.am.eWB)) {
                                            pVar41 = this.bDB.bCF;
                                            pVar41.baY();
                                        }
                                        pVar33 = this.bDB.bCF;
                                        pVar33.bbe();
                                        if (!this.bDB.VG().ZC()) {
                                            if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                                pVar38 = this.bDB.bCF;
                                                pVar38.bbd();
                                                pVar39 = this.bDB.bCF;
                                                pVar39.bbc();
                                                pVar40 = this.bDB.bCF;
                                                pVar40.bba();
                                            }
                                            pVar37 = this.bDB.bCF;
                                            pVar37.bbb();
                                        }
                                        boolean z6 = false;
                                        bqVar19 = this.bDB.bCD;
                                        if (bqVar19.Ww().k(com.baidu.tieba.card.a.q.aVI)) {
                                            pVar36 = this.bDB.bCF;
                                            z6 = pVar36.bbh();
                                        }
                                        if (!z6) {
                                            pVar35 = this.bDB.bCF;
                                            pVar35.bbg();
                                        }
                                        if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                                            pVar34 = this.bDB.bCF;
                                            pVar34.aS(this.bDB.getPageContext().getPageActivity());
                                        }
                                    }
                                }
                                pVar7 = this.bDB.bCF;
                                if (pVar7 != null) {
                                    pVar27 = this.bDB.bCF;
                                    pVar27.baW();
                                    pVar28 = this.bDB.bCF;
                                    com.baidu.tbadk.core.data.bc top_notice_data = pVar28.aDN().getTop_notice_data();
                                    if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                        com.baidu.tbadk.core.data.az azVar = new com.baidu.tbadk.core.data.az();
                                        azVar.setTitle(top_notice_data.getTitle());
                                        azVar.bI(2);
                                        azVar.cr(top_notice_data.rF());
                                        azVar.parser_title();
                                        pVar30 = this.bDB.bCF;
                                        pVar30.t(azVar);
                                    }
                                    pVar29 = this.bDB.bCF;
                                    pVar29.bbi();
                                }
                                this.bDB.Vl();
                                pVar8 = this.bDB.bCF;
                                if (pVar8.bbk()) {
                                    dVar2 = this.bDB.bCV;
                                    bqVar17 = this.bDB.bCD;
                                    BdTypeListView listView = bqVar17.getListView();
                                    pVar26 = this.bDB.bCF;
                                    dVar2.a(listView, pVar26, this.bDB.bCQ.ZK());
                                }
                                bVar = this.bDB.bDb;
                                if (bVar != null) {
                                    bVar2 = this.bDB.bDb;
                                    pVar24 = this.bDB.bCR;
                                    pVar25 = this.bDB.bCF;
                                    bVar2.a(pVar24, pVar25);
                                }
                                FrsActivity.bCJ = (System.nanoTime() - this.startTime) / 1000000;
                                if (aVar != null) {
                                    FrsActivity.bCK = aVar.eUN;
                                }
                                pVar9 = this.bDB.bCF;
                                if (pVar9 != null) {
                                    pVar22 = this.bDB.bCF;
                                    if (pVar22.getThreadList() != null) {
                                        pVar23 = this.bDB.bCF;
                                        if (pVar23.getThreadList().size() == 0 && this.bDB.VG().getType() == 4) {
                                            this.bDB.showToast(this.bDB.getPageContext().getString(u.j.no_more_to_load));
                                            i4 = this.bDB.mPn;
                                            if (i4 > 1) {
                                                FrsActivity frsActivity9 = this.bDB;
                                                i5 = frsActivity9.mPn;
                                                frsActivity9.mPn = i5 - 1;
                                            }
                                            if (this.bDB.btl > -1) {
                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bDB.btl, this.bDB.VG().St() - this.bDB.btl, this.bDB.VG().Sr(), this.bDB.VG().Ss(), currentTimeMillis2 - this.bDB.VG().Sq());
                                                this.bDB.btl = -1L;
                                            }
                                            this.bDB.ayu = System.currentTimeMillis() - currentTimeMillis;
                                            return;
                                        }
                                    }
                                }
                                pVar10 = this.bDB.bCF;
                                if (pVar10 != null) {
                                    pVar20 = this.bDB.bCF;
                                    if (pVar20.getUserData() != null) {
                                        pVar21 = this.bDB.bCF;
                                        if (pVar21.getUserData().isBawu()) {
                                            aaVar6 = this.bDB.bCS;
                                            aaVar6.setIsManager(true);
                                            pVar11 = this.bDB.bCF;
                                            if (pVar11 != null) {
                                                pVar14 = this.bDB.bCF;
                                                if (pVar14.aDN() != null) {
                                                    aaVar5 = this.bDB.bCS;
                                                    pVar19 = this.bDB.bCF;
                                                    aaVar5.dL(pVar19.aDN().isLike() == 1);
                                                }
                                                pVar15 = this.bDB.bCF;
                                                if (pVar15.aDN().isIs_forbidden() == 1) {
                                                    aaVar4 = this.bDB.bCS;
                                                    aaVar4.dN(false);
                                                } else {
                                                    aaVar2 = this.bDB.bCS;
                                                    aaVar2.dN(true);
                                                }
                                                aaVar3 = this.bDB.bCS;
                                                pVar16 = this.bDB.bCF;
                                                aaVar3.dM(pVar16.bal() == 1);
                                                aVar5 = this.bDB.bCZ;
                                                pVar17 = this.bDB.bCF;
                                                ArrayList<com.baidu.adp.widget.ListView.v> a = aVar5.a(true, pVar17.getThreadList());
                                                if (a != null) {
                                                    pVar18 = this.bDB.bCF;
                                                    pVar18.ay(a);
                                                }
                                            }
                                            if (this.bDB.bCQ.ZF() == 1) {
                                                this.bDB.Vt();
                                            }
                                            pVar12 = this.bDB.bCF;
                                            if (pVar12 != null) {
                                                FrsActivity frsActivity10 = this.bDB;
                                                pVar13 = this.bDB.bCF;
                                                frsActivity10.bCx = pVar13.ZG();
                                            }
                                            fVar = this.bDB.bCz;
                                            if (fVar != null) {
                                                this.bDB.bCy = false;
                                                fVar2 = this.bDB.bCz;
                                                i3 = this.bDB.bCx;
                                                fVar2.qy(i3);
                                            }
                                            bqVar16 = this.bDB.bCD;
                                            bqVar16.hq(i);
                                            aVar3 = this.bDB.bDe;
                                            if (aVar3 != null) {
                                                aVar4 = this.bDB.bDe;
                                                dVar = this.bDB.bCV;
                                                aVar4.ak(dVar.Yc());
                                            }
                                        }
                                    }
                                }
                                aaVar = this.bDB.bCS;
                                aaVar.setIsManager(false);
                                pVar11 = this.bDB.bCF;
                                if (pVar11 != null) {
                                }
                                if (this.bDB.bCQ.ZF() == 1) {
                                }
                                pVar12 = this.bDB.bCF;
                                if (pVar12 != null) {
                                }
                                fVar = this.bDB.bCz;
                                if (fVar != null) {
                                }
                                bqVar16 = this.bDB.bCD;
                                bqVar16.hq(i);
                                aVar3 = this.bDB.bDe;
                                if (aVar3 != null) {
                                }
                            }
                            pVar5 = this.bDB.bCF;
                            if (pVar5.bam() == 1) {
                                bqVar15 = this.bDB.bCD;
                                bqVar15.WK();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11384"));
                            }
                            if (this.bDB.btl > -1) {
                                long currentTimeMillis3 = System.currentTimeMillis();
                                TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bDB.btl, this.bDB.VG().St() - this.bDB.btl, this.bDB.VG().Sr(), this.bDB.VG().Ss(), currentTimeMillis3 - this.bDB.VG().Sq());
                                this.bDB.btl = -1L;
                            }
                            this.bDB.ayu = System.currentTimeMillis() - currentTimeMillis;
                            System.gc();
                            return;
                        }
                        if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                            pVar55 = this.bDB.bCF;
                            pVar55.aS(this.bDB.getPageContext().getPageActivity());
                        }
                        aVar6 = this.bDB.bCZ;
                        pVar51 = this.bDB.bCF;
                        ArrayList<com.baidu.adp.widget.ListView.v> threadList = pVar51.getThreadList();
                        fVar3 = this.bDB.bCz;
                        ArrayList<com.baidu.adp.widget.ListView.v> a2 = aVar6.a(false, threadList, fVar3);
                        if (a2 != null) {
                            pVar52 = this.bDB.bCF;
                            pVar52.ay(a2);
                            pVar53 = this.bDB.bCF;
                            pVar53.baW();
                            bqVar22 = this.bDB.bCD;
                            i6 = this.bDB.mPn;
                            pVar54 = this.bDB.bCF;
                            i7 = this.bDB.bDa;
                            bqVar22.a(a2, i6, pVar54, i7);
                            return;
                        }
                        return;
                    }
                }
                bqVar23 = this.bDB.bCD;
                bqVar23.WC();
                if (i != 4) {
                }
            }
            bqVar5 = this.bDB.bCD;
            bqVar5.WA();
            if (i != 4) {
            }
        } else {
            pVar61 = this.bDB.bCF;
            this.bDB.hj(pVar61.baH());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if (!"normal_page".equals(this.bDB.VG().KQ()) && !"frs_page".equals(this.bDB.VG().KQ())) {
                return;
            }
            this.bDB.a(nVar);
        }
    }
}
