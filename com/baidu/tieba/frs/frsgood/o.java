package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsGoodActivity aZB;
    private long startTime = 0;
    private long aTQ = 0;
    private long aTR = 0;
    private long aZD = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsGoodActivity frsGoodActivity) {
        this.aZB = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void ft(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.aZB.aZv.cd(true);
                this.aZB.aZv.LQ();
                return;
            case 2:
                this.aZB.aZv.ce(true);
                this.aZB.aZv.LQ();
                return;
            case 3:
                this.aZB.aZv.cc(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.avt().size() == 0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014b  */
    @Override // com.baidu.tieba.tbadkCore.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e.a aVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        int i2;
        boolean z2;
        com.baidu.tieba.tbadkCore.o oVar2;
        boolean z3;
        com.baidu.tieba.tbadkCore.o oVar3;
        af afVar;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.o oVar6;
        v vVar;
        com.baidu.tieba.tbadkCore.o oVar7;
        com.baidu.tieba.tbadkCore.o oVar8;
        com.baidu.tieba.tbadkCore.o oVar9;
        com.baidu.tieba.tbadkCore.o oVar10;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.o oVar11;
        com.baidu.tieba.tbadkCore.o oVar12;
        com.baidu.tieba.tbadkCore.o oVar13;
        com.baidu.tieba.tbadkCore.o oVar14;
        com.baidu.tieba.tbadkCore.o oVar15;
        com.baidu.tieba.tbadkCore.o oVar16;
        com.baidu.tieba.tbadkCore.o oVar17;
        com.baidu.tieba.tbadkCore.o oVar18;
        com.baidu.tieba.tbadkCore.o oVar19;
        boolean z4;
        v vVar2;
        com.baidu.tieba.tbadkCore.o oVar20;
        com.baidu.tieba.tbadkCore.o oVar21;
        int i5;
        com.baidu.tieba.tbadkCore.o oVar22;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar23;
        com.baidu.tieba.tbadkCore.o oVar24;
        com.baidu.tieba.tbadkCore.o oVar25;
        com.baidu.tieba.tbadkCore.o oVar26;
        v vVar3;
        if (aVar == null) {
            this.aZD = 1L;
        } else if (aVar.isSuccess) {
            this.aZB.aZv.MN().bV(as.uI().uK());
            this.aTQ = 0L;
            this.aTR = 0L;
            this.aZD = 0L;
        } else {
            this.aZD = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            vVar3 = this.aZB.aZy;
            vVar3.resetData();
        }
        this.aZB.aZv.cc(false);
        if (this.aZB.ML().MR() != null) {
            this.aZB.aTL = this.aZB.ML().MR();
        }
        FrsGoodActivity frsGoodActivity = this.aZB;
        oVar = this.aZB.aTL;
        frsGoodActivity.aUc = oVar.getPage().rL();
        i2 = this.aZB.aUc;
        if (i2 == 0) {
            oVar23 = this.aZB.aTL;
            if (oVar23.avt() != null) {
                oVar26 = this.aZB.aTL;
            }
            oVar24 = this.aZB.aTL;
            if (oVar24.getThreadList() != null) {
                oVar25 = this.aZB.aTL;
                if (oVar25.getThreadList().size() != 0) {
                    this.aZB.aZv.Mf();
                    if (i == 4) {
                        vVar2 = this.aZB.aZy;
                        oVar20 = this.aZB.aTL;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = vVar2.a(false, oVar20.getThreadList());
                        if (a != null) {
                            oVar21 = this.aZB.aTL;
                            oVar21.af(a);
                            x xVar = this.aZB.aZv;
                            i5 = this.aZB.mPn;
                            oVar22 = this.aZB.aTL;
                            i6 = this.aZB.aUc;
                            xVar.a(a, i5, oVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.aZB.aZv.cd(false);
                            this.aZB.aZv.LQ();
                            break;
                        case 2:
                            this.aZB.aZv.ce(false);
                            this.aZB.aZv.LQ();
                            break;
                    }
                    z2 = this.aZB.aTI;
                    if (!z2) {
                        this.aZB.MG();
                    } else {
                        this.aZB.MI();
                    }
                    if (this.aZD != 0) {
                        z4 = this.aZB.aTI;
                        if (!z4) {
                            this.aZB.a(aVar);
                        } else {
                            this.aZB.b(aVar);
                        }
                    } else {
                        this.aZB.aTI = true;
                        oVar2 = this.aZB.aTL;
                        if (oVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.aZB;
                            oVar16 = this.aZB.aTL;
                            frsGoodActivity2.aTB = oVar16.aeN().getName();
                            FrsGoodActivity frsGoodActivity3 = this.aZB;
                            oVar17 = this.aZB.aTL;
                            frsGoodActivity3.forumId = oVar17.aeN().getId();
                            x xVar2 = this.aZB.aZv;
                            oVar18 = this.aZB.aTL;
                            ForumData aeN = oVar18.aeN();
                            oVar19 = this.aZB.aTL;
                            xVar2.b(aeN, oVar19.getUserData());
                        }
                        z3 = this.aZB.aTW;
                        if (z3) {
                            oVar13 = this.aZB.aTL;
                            if (oVar13 != null) {
                                oVar14 = this.aZB.aTL;
                                oVar14.avL();
                                oVar15 = this.aZB.aTL;
                                oVar15.avP();
                            }
                        }
                        oVar3 = this.aZB.aTL;
                        if (oVar3 != null) {
                            oVar11 = this.aZB.aTL;
                            com.baidu.tbadk.core.data.x top_notice_data = oVar11.aeN().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.v vVar4 = new com.baidu.tbadk.core.data.v();
                                vVar4.setTitle(top_notice_data.getTitle());
                                vVar4.bA(2);
                                vVar4.cm(top_notice_data.sK());
                                vVar4.parser_title();
                                oVar12 = this.aZB.aTL;
                                oVar12.f(vVar4);
                            }
                        }
                        afVar = this.aZB.aZx;
                        oVar4 = this.aZB.aTL;
                        afVar.b(oVar4);
                        this.aTQ = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.aTR = aVar.cWv;
                        }
                        oVar5 = this.aZB.aTL;
                        if (oVar5 != null) {
                            oVar9 = this.aZB.aTL;
                            if (oVar9.getThreadList() != null) {
                                oVar10 = this.aZB.aTL;
                                if (oVar10.getThreadList().size() == 0 && this.aZB.ML().getType() == 4) {
                                    this.aZB.showToast(this.aZB.getPageContext().getString(i.h.no_more_to_load));
                                    i3 = this.aZB.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.aZB;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.aZB.aLy > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aZB.aLy, this.aZB.ML().IA() - this.aZB.aLy, this.aZB.ML().Iy(), this.aZB.ML().Iz(), currentTimeMillis2 - this.aZB.ML().Ix());
                                        this.aZB.aLy = -1L;
                                    }
                                    this.aZB.axx = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        oVar6 = this.aZB.aTL;
                        if (oVar6 != null) {
                            vVar = this.aZB.aZy;
                            oVar7 = this.aZB.aTL;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = vVar.a(true, oVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                oVar8 = this.aZB.aTL;
                                oVar8.af(a2);
                            }
                        }
                        this.aZB.La();
                    }
                    if (this.aZB.aLy > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aZB.aLy, this.aZB.ML().IA() - this.aZB.aLy, this.aZB.ML().Iy(), this.aZB.ML().Iz(), currentTimeMillis3 - this.aZB.ML().Ix());
                        this.aZB.aLy = -1L;
                    }
                    this.aZB.axx = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.aZB.aZv.Mg();
            if (i == 4) {
            }
        }
        this.aZB.aZv.Me();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
    }
}
