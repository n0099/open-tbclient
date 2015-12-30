package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.s {
    final /* synthetic */ FrsGoodActivity bkp;
    private long startTime = 0;
    private long bds = 0;
    private long bdt = 0;
    private long bkr = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void fS(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.bkp.bkj.ct(true);
                this.bkp.bkj.NW();
                return;
            case 2:
                this.bkp.bkj.cu(true);
                this.bkp.bkj.NW();
                return;
            case 3:
                this.bkp.bkj.cs(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.aDP().size() == 0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014b  */
    @Override // com.baidu.tieba.tbadkCore.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e.a aVar) {
        com.baidu.tieba.tbadkCore.p pVar;
        int i2;
        boolean z2;
        com.baidu.tieba.tbadkCore.p pVar2;
        boolean z3;
        com.baidu.tieba.tbadkCore.p pVar3;
        af afVar;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.tbadkCore.p pVar5;
        com.baidu.tieba.tbadkCore.p pVar6;
        v vVar;
        com.baidu.tieba.tbadkCore.p pVar7;
        com.baidu.tieba.tbadkCore.p pVar8;
        com.baidu.tieba.tbadkCore.p pVar9;
        com.baidu.tieba.tbadkCore.p pVar10;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.p pVar11;
        com.baidu.tieba.tbadkCore.p pVar12;
        com.baidu.tieba.tbadkCore.p pVar13;
        com.baidu.tieba.tbadkCore.p pVar14;
        com.baidu.tieba.tbadkCore.p pVar15;
        com.baidu.tieba.tbadkCore.p pVar16;
        com.baidu.tieba.tbadkCore.p pVar17;
        com.baidu.tieba.tbadkCore.p pVar18;
        com.baidu.tieba.tbadkCore.p pVar19;
        boolean z4;
        v vVar2;
        com.baidu.tieba.tbadkCore.p pVar20;
        com.baidu.tieba.tbadkCore.p pVar21;
        int i5;
        com.baidu.tieba.tbadkCore.p pVar22;
        int i6;
        com.baidu.tieba.tbadkCore.p pVar23;
        com.baidu.tieba.tbadkCore.p pVar24;
        com.baidu.tieba.tbadkCore.p pVar25;
        com.baidu.tieba.tbadkCore.p pVar26;
        v vVar3;
        if (aVar == null) {
            this.bkr = 1L;
        } else if (aVar.isSuccess) {
            this.bkp.bkj.OV().cl(ay.va().vc());
            this.bds = 0L;
            this.bdt = 0L;
            this.bkr = 0L;
        } else {
            this.bkr = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            vVar3 = this.bkp.bkm;
            vVar3.resetData();
        }
        this.bkp.bkj.cs(false);
        if (this.bkp.OS().OZ() != null) {
            this.bkp.bdo = this.bkp.OS().OZ();
        }
        FrsGoodActivity frsGoodActivity = this.bkp;
        pVar = this.bkp.bdo;
        frsGoodActivity.bdE = pVar.getPage().rO();
        i2 = this.bkp.bdE;
        if (i2 == 0) {
            pVar23 = this.bkp.bdo;
            if (pVar23.aDP() != null) {
                pVar26 = this.bkp.bdo;
            }
            pVar24 = this.bkp.bdo;
            if (pVar24.getThreadList() != null) {
                pVar25 = this.bkp.bdo;
                if (pVar25.getThreadList().size() != 0) {
                    this.bkp.bkj.Ol();
                    if (i == 4) {
                        vVar2 = this.bkp.bkm;
                        pVar20 = this.bkp.bdo;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = vVar2.a(false, pVar20.getThreadList());
                        if (a != null) {
                            pVar21 = this.bkp.bdo;
                            pVar21.am(a);
                            x xVar = this.bkp.bkj;
                            i5 = this.bkp.mPn;
                            pVar22 = this.bkp.bdo;
                            i6 = this.bkp.bdE;
                            xVar.a(a, i5, pVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.bkp.bkj.ct(false);
                            this.bkp.bkj.NW();
                            break;
                        case 2:
                            this.bkp.bkj.cu(false);
                            this.bkp.bkj.NW();
                            break;
                    }
                    z2 = this.bkp.bdl;
                    if (!z2) {
                        this.bkp.ON();
                    } else {
                        this.bkp.OP();
                    }
                    if (this.bkr != 0) {
                        z4 = this.bkp.bdl;
                        if (!z4) {
                            this.bkp.a(aVar);
                        } else {
                            this.bkp.b(aVar);
                        }
                    } else {
                        this.bkp.bdl = true;
                        pVar2 = this.bkp.bdo;
                        if (pVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.bkp;
                            pVar16 = this.bkp.bdo;
                            frsGoodActivity2.bde = pVar16.akG().getName();
                            FrsGoodActivity frsGoodActivity3 = this.bkp;
                            pVar17 = this.bkp.bdo;
                            frsGoodActivity3.forumId = pVar17.akG().getId();
                            x xVar2 = this.bkp.bkj;
                            pVar18 = this.bkp.bdo;
                            ForumData akG = pVar18.akG();
                            pVar19 = this.bkp.bdo;
                            xVar2.b(akG, pVar19.getUserData());
                        }
                        z3 = this.bkp.bdy;
                        if (z3) {
                            pVar13 = this.bkp.bdo;
                            if (pVar13 != null) {
                                pVar14 = this.bkp.bdo;
                                pVar14.aEn();
                                pVar15 = this.bkp.bdo;
                                pVar15.aEs();
                            }
                        }
                        pVar3 = this.bkp.bdo;
                        if (pVar3 != null) {
                            pVar11 = this.bkp.bdo;
                            com.baidu.tbadk.core.data.ab top_notice_data = pVar11.akG().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                                zVar.setTitle(top_notice_data.getTitle());
                                zVar.bC(2);
                                zVar.cx(top_notice_data.sY());
                                zVar.parser_title();
                                pVar12 = this.bkp.bdo;
                                pVar12.i(zVar);
                            }
                        }
                        afVar = this.bkp.bkl;
                        pVar4 = this.bkp.bdo;
                        afVar.c(pVar4);
                        this.bds = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.bdt = aVar.dEu;
                        }
                        pVar5 = this.bkp.bdo;
                        if (pVar5 != null) {
                            pVar9 = this.bkp.bdo;
                            if (pVar9.getThreadList() != null) {
                                pVar10 = this.bkp.bdo;
                                if (pVar10.getThreadList().size() == 0 && this.bkp.OS().getType() == 4) {
                                    this.bkp.showToast(this.bkp.getPageContext().getString(n.j.no_more_to_load));
                                    i3 = this.bkp.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.bkp;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.bkp.aUp > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bkp.aUp, this.bkp.OS().Kx() - this.bkp.aUp, this.bkp.OS().Kv(), this.bkp.OS().Kw(), currentTimeMillis2 - this.bkp.OS().Ku());
                                        this.bkp.aUp = -1L;
                                    }
                                    this.bkp.azV = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        pVar6 = this.bkp.bdo;
                        if (pVar6 != null) {
                            vVar = this.bkp.bkm;
                            pVar7 = this.bkp.bdo;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = vVar.a(true, pVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                pVar8 = this.bkp.bdo;
                                pVar8.am(a2);
                            }
                        }
                        this.bkp.Ng();
                    }
                    if (this.bkp.aUp > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bkp.aUp, this.bkp.OS().Kx() - this.bkp.aUp, this.bkp.OS().Kv(), this.bkp.OS().Kw(), currentTimeMillis3 - this.bkp.OS().Ku());
                        this.bkp.aUp = -1L;
                    }
                    this.bkp.azV = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.bkp.bkj.Om();
            if (i == 4) {
            }
        }
        this.bkp.bkj.Ok();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
    }
}
