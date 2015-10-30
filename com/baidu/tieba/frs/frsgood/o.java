package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsGoodActivity aZM;
    private long startTime = 0;
    private long aUb = 0;
    private long aUc = 0;
    private long aZO = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void ft(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.aZM.aZG.cd(true);
                this.aZM.aZG.LM();
                return;
            case 2:
                this.aZM.aZG.ce(true);
                this.aZM.aZG.LM();
                return;
            case 3:
                this.aZM.aZG.cc(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.avv().size() == 0) goto L15;
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
            this.aZO = 1L;
        } else if (aVar.isSuccess) {
            this.aZM.aZG.MJ().bV(at.uG().uI());
            this.aUb = 0L;
            this.aUc = 0L;
            this.aZO = 0L;
        } else {
            this.aZO = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            vVar3 = this.aZM.aZJ;
            vVar3.resetData();
        }
        this.aZM.aZG.cc(false);
        if (this.aZM.MH().MN() != null) {
            this.aZM.aTW = this.aZM.MH().MN();
        }
        FrsGoodActivity frsGoodActivity = this.aZM;
        oVar = this.aZM.aTW;
        frsGoodActivity.aUn = oVar.getPage().rI();
        i2 = this.aZM.aUn;
        if (i2 == 0) {
            oVar23 = this.aZM.aTW;
            if (oVar23.avv() != null) {
                oVar26 = this.aZM.aTW;
            }
            oVar24 = this.aZM.aTW;
            if (oVar24.getThreadList() != null) {
                oVar25 = this.aZM.aTW;
                if (oVar25.getThreadList().size() != 0) {
                    this.aZM.aZG.Mb();
                    if (i == 4) {
                        vVar2 = this.aZM.aZJ;
                        oVar20 = this.aZM.aTW;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = vVar2.a(false, oVar20.getThreadList());
                        if (a != null) {
                            oVar21 = this.aZM.aTW;
                            oVar21.af(a);
                            x xVar = this.aZM.aZG;
                            i5 = this.aZM.mPn;
                            oVar22 = this.aZM.aTW;
                            i6 = this.aZM.aUn;
                            xVar.a(a, i5, oVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.aZM.aZG.cd(false);
                            this.aZM.aZG.LM();
                            break;
                        case 2:
                            this.aZM.aZG.ce(false);
                            this.aZM.aZG.LM();
                            break;
                    }
                    z2 = this.aZM.aTT;
                    if (!z2) {
                        this.aZM.MC();
                    } else {
                        this.aZM.ME();
                    }
                    if (this.aZO != 0) {
                        z4 = this.aZM.aTT;
                        if (!z4) {
                            this.aZM.a(aVar);
                        } else {
                            this.aZM.b(aVar);
                        }
                    } else {
                        this.aZM.aTT = true;
                        oVar2 = this.aZM.aTW;
                        if (oVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.aZM;
                            oVar16 = this.aZM.aTW;
                            frsGoodActivity2.aTM = oVar16.aeJ().getName();
                            FrsGoodActivity frsGoodActivity3 = this.aZM;
                            oVar17 = this.aZM.aTW;
                            frsGoodActivity3.forumId = oVar17.aeJ().getId();
                            x xVar2 = this.aZM.aZG;
                            oVar18 = this.aZM.aTW;
                            ForumData aeJ = oVar18.aeJ();
                            oVar19 = this.aZM.aTW;
                            xVar2.b(aeJ, oVar19.getUserData());
                        }
                        z3 = this.aZM.aUh;
                        if (z3) {
                            oVar13 = this.aZM.aTW;
                            if (oVar13 != null) {
                                oVar14 = this.aZM.aTW;
                                oVar14.avP();
                                oVar15 = this.aZM.aTW;
                                oVar15.avT();
                            }
                        }
                        oVar3 = this.aZM.aTW;
                        if (oVar3 != null) {
                            oVar11 = this.aZM.aTW;
                            com.baidu.tbadk.core.data.y top_notice_data = oVar11.aeJ().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                                wVar.setTitle(top_notice_data.getTitle());
                                wVar.bA(2);
                                wVar.cn(top_notice_data.sH());
                                wVar.parser_title();
                                oVar12 = this.aZM.aTW;
                                oVar12.f(wVar);
                            }
                        }
                        afVar = this.aZM.aZI;
                        oVar4 = this.aZM.aTW;
                        afVar.b(oVar4);
                        this.aUb = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.aUc = aVar.cWU;
                        }
                        oVar5 = this.aZM.aTW;
                        if (oVar5 != null) {
                            oVar9 = this.aZM.aTW;
                            if (oVar9.getThreadList() != null) {
                                oVar10 = this.aZM.aTW;
                                if (oVar10.getThreadList().size() == 0 && this.aZM.MH().getType() == 4) {
                                    this.aZM.showToast(this.aZM.getPageContext().getString(i.h.no_more_to_load));
                                    i3 = this.aZM.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.aZM;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.aZM.aLJ > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aZM.aLJ, this.aZM.MH().Iw() - this.aZM.aLJ, this.aZM.MH().Iu(), this.aZM.MH().Iv(), currentTimeMillis2 - this.aZM.MH().It());
                                        this.aZM.aLJ = -1L;
                                    }
                                    this.aZM.axy = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        oVar6 = this.aZM.aTW;
                        if (oVar6 != null) {
                            vVar = this.aZM.aZJ;
                            oVar7 = this.aZM.aTW;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = vVar.a(true, oVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                oVar8 = this.aZM.aTW;
                                oVar8.af(a2);
                            }
                        }
                        this.aZM.KW();
                    }
                    if (this.aZM.aLJ > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aZM.aLJ, this.aZM.MH().Iw() - this.aZM.aLJ, this.aZM.MH().Iu(), this.aZM.MH().Iv(), currentTimeMillis3 - this.aZM.MH().It());
                        this.aZM.aLJ = -1L;
                    }
                    this.aZM.axy = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.aZM.aZG.Mc();
            if (i == 4) {
            }
        }
        this.aZM.aZG.Ma();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
    }
}
