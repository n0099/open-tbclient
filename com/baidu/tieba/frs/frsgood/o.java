package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.s {
    final /* synthetic */ FrsGoodActivity bgy;
    private long startTime = 0;
    private long aZw = 0;
    private long aZx = 0;
    private long bgA = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void fX(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.bgy.bgr.cs(true);
                this.bgy.bgr.ND();
                return;
            case 2:
                this.bgy.bgr.ct(true);
                this.bgy.bgr.ND();
                return;
            case 3:
                this.bgy.bgr.cr(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.aBH().size() == 0) goto L15;
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
            this.bgA = 1L;
        } else if (aVar.isSuccess) {
            this.bgy.bgr.OD().ck(ay.vq().vs());
            this.aZw = 0L;
            this.aZx = 0L;
            this.bgA = 0L;
        } else {
            this.bgA = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            vVar3 = this.bgy.bgv;
            vVar3.resetData();
        }
        this.bgy.bgr.cr(false);
        if (this.bgy.OA().OH() != null) {
            this.bgy.aZs = this.bgy.OA().OH();
        }
        FrsGoodActivity frsGoodActivity = this.bgy;
        pVar = this.bgy.aZs;
        frsGoodActivity.aZI = pVar.getPage().sf();
        i2 = this.bgy.aZI;
        if (i2 == 0) {
            pVar23 = this.bgy.aZs;
            if (pVar23.aBH() != null) {
                pVar26 = this.bgy.aZs;
            }
            pVar24 = this.bgy.aZs;
            if (pVar24.getThreadList() != null) {
                pVar25 = this.bgy.aZs;
                if (pVar25.getThreadList().size() != 0) {
                    this.bgy.bgr.NS();
                    if (i == 4) {
                        vVar2 = this.bgy.bgv;
                        pVar20 = this.bgy.aZs;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = vVar2.a(false, pVar20.getThreadList());
                        if (a != null) {
                            pVar21 = this.bgy.aZs;
                            pVar21.am(a);
                            x xVar = this.bgy.bgr;
                            i5 = this.bgy.mPn;
                            pVar22 = this.bgy.aZs;
                            i6 = this.bgy.aZI;
                            xVar.a(a, i5, pVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.bgy.bgr.cs(false);
                            this.bgy.bgr.ND();
                            break;
                        case 2:
                            this.bgy.bgr.ct(false);
                            this.bgy.bgr.ND();
                            break;
                    }
                    z2 = this.bgy.aZp;
                    if (!z2) {
                        this.bgy.Ov();
                    } else {
                        this.bgy.Ox();
                    }
                    if (this.bgA != 0) {
                        z4 = this.bgy.aZp;
                        if (!z4) {
                            this.bgy.a(aVar);
                        } else {
                            this.bgy.b(aVar);
                        }
                    } else {
                        this.bgy.aZp = true;
                        pVar2 = this.bgy.aZs;
                        if (pVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.bgy;
                            pVar16 = this.bgy.aZs;
                            frsGoodActivity2.aZi = pVar16.ajy().getName();
                            FrsGoodActivity frsGoodActivity3 = this.bgy;
                            pVar17 = this.bgy.aZs;
                            frsGoodActivity3.forumId = pVar17.ajy().getId();
                            x xVar2 = this.bgy.bgr;
                            pVar18 = this.bgy.aZs;
                            ForumData ajy = pVar18.ajy();
                            pVar19 = this.bgy.aZs;
                            xVar2.b(ajy, pVar19.getUserData());
                        }
                        z3 = this.bgy.aZC;
                        if (z3) {
                            pVar13 = this.bgy.aZs;
                            if (pVar13 != null) {
                                pVar14 = this.bgy.aZs;
                                pVar14.aCf();
                                pVar15 = this.bgy.aZs;
                                pVar15.aCk();
                            }
                        }
                        pVar3 = this.bgy.aZs;
                        if (pVar3 != null) {
                            pVar11 = this.bgy.aZs;
                            com.baidu.tbadk.core.data.ab top_notice_data = pVar11.ajy().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                                zVar.setTitle(top_notice_data.getTitle());
                                zVar.bJ(2);
                                zVar.cu(top_notice_data.to());
                                zVar.parser_title();
                                pVar12 = this.bgy.aZs;
                                pVar12.f(zVar);
                            }
                        }
                        afVar = this.bgy.bgu;
                        pVar4 = this.bgy.aZs;
                        afVar.c(pVar4);
                        this.aZw = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.aZx = aVar.dwU;
                        }
                        pVar5 = this.bgy.aZs;
                        if (pVar5 != null) {
                            pVar9 = this.bgy.aZs;
                            if (pVar9.getThreadList() != null) {
                                pVar10 = this.bgy.aZs;
                                if (pVar10.getThreadList().size() == 0 && this.bgy.OA().getType() == 4) {
                                    this.bgy.showToast(this.bgy.getPageContext().getString(n.i.no_more_to_load));
                                    i3 = this.bgy.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.bgy;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.bgy.aQy > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bgy.aQy, this.bgy.OA().Ke() - this.bgy.aQy, this.bgy.OA().Kc(), this.bgy.OA().Kd(), currentTimeMillis2 - this.bgy.OA().Kb());
                                        this.bgy.aQy = -1L;
                                    }
                                    this.bgy.ays = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        pVar6 = this.bgy.aZs;
                        if (pVar6 != null) {
                            vVar = this.bgy.bgv;
                            pVar7 = this.bgy.aZs;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = vVar.a(true, pVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                pVar8 = this.bgy.aZs;
                                pVar8.am(a2);
                            }
                        }
                        this.bgy.MM();
                    }
                    if (this.bgy.aQy > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bgy.aQy, this.bgy.OA().Ke() - this.bgy.aQy, this.bgy.OA().Kc(), this.bgy.OA().Kd(), currentTimeMillis3 - this.bgy.OA().Kb());
                        this.bgy.aQy = -1L;
                    }
                    this.bgy.ays = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.bgy.bgr.NT();
            if (i == 4) {
            }
        }
        this.bgy.bgr.NR();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
    }
}
