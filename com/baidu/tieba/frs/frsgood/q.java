package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsGoodActivity bnm;
    private long startTime = 0;
    private long bfJ = 0;
    private long bfK = 0;
    private long bno = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void gp(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.bnm.bng.ct(true);
                this.bnm.bng.PW();
                return;
            case 2:
                this.bnm.bng.cu(true);
                this.bnm.bng.PW();
                return;
            case 3:
                this.bnm.bng.cs(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.aKU().size() == 0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014b  */
    @Override // com.baidu.tieba.tbadkCore.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, d.a aVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        int i2;
        boolean z2;
        com.baidu.tieba.tbadkCore.o oVar2;
        boolean z3;
        com.baidu.tieba.tbadkCore.o oVar3;
        ag agVar;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.o oVar6;
        w wVar;
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
        w wVar2;
        com.baidu.tieba.tbadkCore.o oVar20;
        com.baidu.tieba.tbadkCore.o oVar21;
        int i5;
        com.baidu.tieba.tbadkCore.o oVar22;
        int i6;
        com.baidu.tieba.tbadkCore.o oVar23;
        com.baidu.tieba.tbadkCore.o oVar24;
        com.baidu.tieba.tbadkCore.o oVar25;
        com.baidu.tieba.tbadkCore.o oVar26;
        w wVar3;
        if (aVar == null) {
            this.bno = 1L;
        } else if (aVar.isSuccess) {
            this.bnm.bng.QY().ck(ax.wg().wi());
            this.bfJ = 0L;
            this.bfK = 0L;
            this.bno = 0L;
        } else {
            this.bno = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            wVar3 = this.bnm.bnj;
            wVar3.resetData();
        }
        this.bnm.bng.cs(false);
        if (this.bnm.QV().Rc() != null) {
            this.bnm.bfF = this.bnm.QV().Rc();
        }
        FrsGoodActivity frsGoodActivity = this.bnm;
        oVar = this.bnm.bfF;
        frsGoodActivity.bfW = oVar.getPage().sv();
        i2 = this.bnm.bfW;
        if (i2 == 0) {
            oVar23 = this.bnm.bfF;
            if (oVar23.aKU() != null) {
                oVar26 = this.bnm.bfF;
            }
            oVar24 = this.bnm.bfF;
            if (oVar24.getThreadList() != null) {
                oVar25 = this.bnm.bfF;
                if (oVar25.getThreadList().size() != 0) {
                    this.bnm.bng.Qo();
                    if (i == 4) {
                        wVar2 = this.bnm.bnj;
                        oVar20 = this.bnm.bfF;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = wVar2.a(false, oVar20.getThreadList());
                        if (a != null) {
                            oVar21 = this.bnm.bfF;
                            oVar21.an(a);
                            y yVar = this.bnm.bng;
                            i5 = this.bnm.mPn;
                            oVar22 = this.bnm.bfF;
                            i6 = this.bnm.bfW;
                            yVar.a(a, i5, oVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.bnm.bng.ct(false);
                            this.bnm.bng.PW();
                            break;
                        case 2:
                            this.bnm.bng.cu(false);
                            this.bnm.bng.PW();
                            break;
                    }
                    z2 = this.bnm.bfC;
                    if (!z2) {
                        this.bnm.QQ();
                    } else {
                        this.bnm.QS();
                    }
                    if (this.bno != 0) {
                        z4 = this.bnm.bfC;
                        if (!z4) {
                            this.bnm.a(aVar);
                        } else {
                            this.bnm.b(aVar);
                        }
                    } else {
                        this.bnm.bfC = true;
                        oVar2 = this.bnm.bfF;
                        if (oVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.bnm;
                            oVar16 = this.bnm.bfF;
                            frsGoodActivity2.bfv = oVar16.aoE().getName();
                            FrsGoodActivity frsGoodActivity3 = this.bnm;
                            oVar17 = this.bnm.bfF;
                            frsGoodActivity3.forumId = oVar17.aoE().getId();
                            y yVar2 = this.bnm.bng;
                            oVar18 = this.bnm.bfF;
                            ForumData aoE = oVar18.aoE();
                            oVar19 = this.bnm.bfF;
                            yVar2.b(aoE, oVar19.getUserData());
                        }
                        z3 = this.bnm.bfP;
                        if (z3) {
                            oVar13 = this.bnm.bfF;
                            if (oVar13 != null) {
                                oVar14 = this.bnm.bfF;
                                oVar14.aLs();
                                oVar15 = this.bnm.bfF;
                                oVar15.aLx();
                            }
                        }
                        oVar3 = this.bnm.bfF;
                        if (oVar3 != null) {
                            oVar11 = this.bnm.bfF;
                            aj top_notice_data = oVar11.aoE().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                                ahVar.setTitle(top_notice_data.getTitle());
                                ahVar.bU(2);
                                ahVar.cw(top_notice_data.tW());
                                ahVar.parser_title();
                                oVar12 = this.bnm.bfF;
                                oVar12.j(ahVar);
                            }
                        }
                        agVar = this.bnm.bni;
                        oVar4 = this.bnm.bfF;
                        agVar.c(oVar4);
                        this.bfJ = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.bfK = aVar.dUp;
                        }
                        oVar5 = this.bnm.bfF;
                        if (oVar5 != null) {
                            oVar9 = this.bnm.bfF;
                            if (oVar9.getThreadList() != null) {
                                oVar10 = this.bnm.bfF;
                                if (oVar10.getThreadList().size() == 0 && this.bnm.QV().getType() == 4) {
                                    this.bnm.showToast(this.bnm.getPageContext().getString(t.j.no_more_to_load));
                                    i3 = this.bnm.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.bnm;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.bnm.aWx > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bnm.aWx, this.bnm.QV().Mo() - this.bnm.aWx, this.bnm.QV().Mm(), this.bnm.QV().Mn(), currentTimeMillis2 - this.bnm.QV().Ml());
                                        this.bnm.aWx = -1L;
                                    }
                                    this.bnm.aAK = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        oVar6 = this.bnm.bfF;
                        if (oVar6 != null) {
                            wVar = this.bnm.bnj;
                            oVar7 = this.bnm.bfF;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = wVar.a(true, oVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                oVar8 = this.bnm.bfF;
                                oVar8.an(a2);
                            }
                        }
                        this.bnm.Pa();
                    }
                    if (this.bnm.aWx > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bnm.aWx, this.bnm.QV().Mo() - this.bnm.aWx, this.bnm.QV().Mm(), this.bnm.QV().Mn(), currentTimeMillis3 - this.bnm.QV().Ml());
                        this.bnm.aWx = -1L;
                    }
                    this.bnm.aAK = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.bnm.bng.Qp();
            if (i == 4) {
            }
        }
        this.bnm.bng.Qn();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
    }
}
