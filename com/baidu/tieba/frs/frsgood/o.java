package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsGoodActivity aZI;
    private long startTime = 0;
    private long aUS = 0;
    private long aUT = 0;
    private long aZK = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void fo(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.aZI.aZC.cg(true);
                this.aZI.aZC.LR();
                return;
            case 2:
                this.aZI.aZC.ch(true);
                this.aZI.aZC.LR();
                return;
            case 3:
                this.aZI.aZC.cf(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.atd().size() == 0) goto L15;
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
            this.aZK = 1L;
        } else if (aVar.isSuccess) {
            this.aZI.aZC.MO().bY(ar.uK().uM());
            this.aUS = 0L;
            this.aUT = 0L;
            this.aZK = 0L;
        } else {
            this.aZK = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            vVar3 = this.aZI.aZF;
            vVar3.resetData();
        }
        this.aZI.aZC.cf(false);
        if (this.aZI.MM().MS() != null) {
            this.aZI.aUN = this.aZI.MM().MS();
        }
        FrsGoodActivity frsGoodActivity = this.aZI;
        oVar = this.aZI.aUN;
        frsGoodActivity.aVe = oVar.getPage().rQ();
        i2 = this.aZI.aVe;
        if (i2 == 0) {
            oVar23 = this.aZI.aUN;
            if (oVar23.atd() != null) {
                oVar26 = this.aZI.aUN;
            }
            oVar24 = this.aZI.aUN;
            if (oVar24.getThreadList() != null) {
                oVar25 = this.aZI.aUN;
                if (oVar25.getThreadList().size() != 0) {
                    this.aZI.aZC.Mg();
                    if (i == 4) {
                        vVar2 = this.aZI.aZF;
                        oVar20 = this.aZI.aUN;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = vVar2.a(false, oVar20.getThreadList());
                        if (a != null) {
                            oVar21 = this.aZI.aUN;
                            oVar21.ad(a);
                            x xVar = this.aZI.aZC;
                            i5 = this.aZI.mPn;
                            oVar22 = this.aZI.aUN;
                            i6 = this.aZI.aVe;
                            xVar.a(a, i5, oVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.aZI.aZC.cg(false);
                            this.aZI.aZC.LR();
                            break;
                        case 2:
                            this.aZI.aZC.ch(false);
                            this.aZI.aZC.LR();
                            break;
                    }
                    z2 = this.aZI.aUK;
                    if (!z2) {
                        this.aZI.MH();
                    } else {
                        this.aZI.MJ();
                    }
                    if (this.aZK != 0) {
                        z4 = this.aZI.aUK;
                        if (!z4) {
                            this.aZI.a(aVar);
                        } else {
                            this.aZI.b(aVar);
                        }
                    } else {
                        this.aZI.aUK = true;
                        oVar2 = this.aZI.aUN;
                        if (oVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.aZI;
                            oVar16 = this.aZI.aUN;
                            frsGoodActivity2.aUF = oVar16.acP().getName();
                            FrsGoodActivity frsGoodActivity3 = this.aZI;
                            oVar17 = this.aZI.aUN;
                            frsGoodActivity3.forumId = oVar17.acP().getId();
                            x xVar2 = this.aZI.aZC;
                            oVar18 = this.aZI.aUN;
                            ForumData acP = oVar18.acP();
                            oVar19 = this.aZI.aUN;
                            xVar2.b(acP, oVar19.getUserData());
                        }
                        z3 = this.aZI.aUY;
                        if (z3) {
                            oVar13 = this.aZI.aUN;
                            if (oVar13 != null) {
                                oVar14 = this.aZI.aUN;
                                oVar14.atv();
                                oVar15 = this.aZI.aUN;
                                oVar15.atz();
                            }
                        }
                        oVar3 = this.aZI.aUN;
                        if (oVar3 != null) {
                            oVar11 = this.aZI.aUN;
                            com.baidu.tbadk.core.data.z top_notice_data = oVar11.acP().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.x xVar3 = new com.baidu.tbadk.core.data.x();
                                xVar3.setTitle(top_notice_data.getTitle());
                                xVar3.bA(2);
                                xVar3.cm(top_notice_data.sN());
                                xVar3.parser_title();
                                oVar12 = this.aZI.aUN;
                                oVar12.f(xVar3);
                            }
                        }
                        afVar = this.aZI.aZE;
                        oVar4 = this.aZI.aUN;
                        afVar.b(oVar4);
                        this.aUS = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.aUT = aVar.cPe;
                        }
                        oVar5 = this.aZI.aUN;
                        if (oVar5 != null) {
                            oVar9 = this.aZI.aUN;
                            if (oVar9.getThreadList() != null) {
                                oVar10 = this.aZI.aUN;
                                if (oVar10.getThreadList().size() == 0 && this.aZI.MM().getType() == 4) {
                                    this.aZI.showToast(this.aZI.getPageContext().getString(i.h.no_more_to_load));
                                    i3 = this.aZI.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.aZI;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.aZI.aMD > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aZI.aMD, this.aZI.MM().IE() - this.aZI.aMD, this.aZI.MM().IC(), this.aZI.MM().ID(), currentTimeMillis2 - this.aZI.MM().IB());
                                        this.aZI.aMD = -1L;
                                    }
                                    this.aZI.ayY = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        oVar6 = this.aZI.aUN;
                        if (oVar6 != null) {
                            vVar = this.aZI.aZF;
                            oVar7 = this.aZI.aUN;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = vVar.a(true, oVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                oVar8 = this.aZI.aUN;
                                oVar8.ad(a2);
                            }
                        }
                        this.aZI.Le();
                    }
                    if (this.aZI.aMD > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aZI.aMD, this.aZI.MM().IE() - this.aZI.aMD, this.aZI.MM().IC(), this.aZI.MM().ID(), currentTimeMillis3 - this.aZI.MM().IB());
                        this.aZI.aMD = -1L;
                    }
                    this.aZI.ayY = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.aZI.aZC.Mh();
            if (i == 4) {
            }
        }
        this.aZI.aZC.Mf();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
    }
}
