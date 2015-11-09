package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsGoodActivity baf;
    private long startTime = 0;
    private long aUj = 0;
    private long aUk = 0;
    private long bah = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void fB(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.baf.aZZ.cf(true);
                this.baf.aZZ.Mc();
                return;
            case 2:
                this.baf.aZZ.cg(true);
                this.baf.aZZ.Mc();
                return;
            case 3:
                this.baf.aZZ.ce(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.awc().size() == 0) goto L15;
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
            this.bah = 1L;
        } else if (aVar.isSuccess) {
            this.baf.aZZ.Nb().bX(at.uK().uM());
            this.aUj = 0L;
            this.aUk = 0L;
            this.bah = 0L;
        } else {
            this.bah = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            vVar3 = this.baf.bac;
            vVar3.resetData();
        }
        this.baf.aZZ.ce(false);
        if (this.baf.MY().Nf() != null) {
            this.baf.aUe = this.baf.MY().Nf();
        }
        FrsGoodActivity frsGoodActivity = this.baf;
        oVar = this.baf.aUe;
        frsGoodActivity.aUv = oVar.getPage().rK();
        i2 = this.baf.aUv;
        if (i2 == 0) {
            oVar23 = this.baf.aUe;
            if (oVar23.awc() != null) {
                oVar26 = this.baf.aUe;
            }
            oVar24 = this.baf.aUe;
            if (oVar24.getThreadList() != null) {
                oVar25 = this.baf.aUe;
                if (oVar25.getThreadList().size() != 0) {
                    this.baf.aZZ.Mr();
                    if (i == 4) {
                        vVar2 = this.baf.bac;
                        oVar20 = this.baf.aUe;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = vVar2.a(false, oVar20.getThreadList());
                        if (a != null) {
                            oVar21 = this.baf.aUe;
                            oVar21.af(a);
                            x xVar = this.baf.aZZ;
                            i5 = this.baf.mPn;
                            oVar22 = this.baf.aUe;
                            i6 = this.baf.aUv;
                            xVar.a(a, i5, oVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.baf.aZZ.cf(false);
                            this.baf.aZZ.Mc();
                            break;
                        case 2:
                            this.baf.aZZ.cg(false);
                            this.baf.aZZ.Mc();
                            break;
                    }
                    z2 = this.baf.aUb;
                    if (!z2) {
                        this.baf.MT();
                    } else {
                        this.baf.MV();
                    }
                    if (this.bah != 0) {
                        z4 = this.baf.aUb;
                        if (!z4) {
                            this.baf.a(aVar);
                        } else {
                            this.baf.b(aVar);
                        }
                    } else {
                        this.baf.aUb = true;
                        oVar2 = this.baf.aUe;
                        if (oVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.baf;
                            oVar16 = this.baf.aUe;
                            frsGoodActivity2.aTU = oVar16.afg().getName();
                            FrsGoodActivity frsGoodActivity3 = this.baf;
                            oVar17 = this.baf.aUe;
                            frsGoodActivity3.forumId = oVar17.afg().getId();
                            x xVar2 = this.baf.aZZ;
                            oVar18 = this.baf.aUe;
                            ForumData afg = oVar18.afg();
                            oVar19 = this.baf.aUe;
                            xVar2.b(afg, oVar19.getUserData());
                        }
                        z3 = this.baf.aUp;
                        if (z3) {
                            oVar13 = this.baf.aUe;
                            if (oVar13 != null) {
                                oVar14 = this.baf.aUe;
                                oVar14.awx();
                                oVar15 = this.baf.aUe;
                                oVar15.awB();
                            }
                        }
                        oVar3 = this.baf.aUe;
                        if (oVar3 != null) {
                            oVar11 = this.baf.aUe;
                            com.baidu.tbadk.core.data.y top_notice_data = oVar11.afg().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                                wVar.setTitle(top_notice_data.getTitle());
                                wVar.bA(2);
                                wVar.cm(top_notice_data.sK());
                                wVar.parser_title();
                                oVar12 = this.baf.aUe;
                                oVar12.f(wVar);
                            }
                        }
                        afVar = this.baf.bab;
                        oVar4 = this.baf.aUe;
                        afVar.b(oVar4);
                        this.aUj = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.aUk = aVar.cYq;
                        }
                        oVar5 = this.baf.aUe;
                        if (oVar5 != null) {
                            oVar9 = this.baf.aUe;
                            if (oVar9.getThreadList() != null) {
                                oVar10 = this.baf.aUe;
                                if (oVar10.getThreadList().size() == 0 && this.baf.MY().getType() == 4) {
                                    this.baf.showToast(this.baf.getPageContext().getString(i.h.no_more_to_load));
                                    i3 = this.baf.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.baf;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.baf.aLR > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.baf.aLR, this.baf.MY().IM() - this.baf.aLR, this.baf.MY().IK(), this.baf.MY().IL(), currentTimeMillis2 - this.baf.MY().IJ());
                                        this.baf.aLR = -1L;
                                    }
                                    this.baf.awn = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        oVar6 = this.baf.aUe;
                        if (oVar6 != null) {
                            vVar = this.baf.bac;
                            oVar7 = this.baf.aUe;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = vVar.a(true, oVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                oVar8 = this.baf.aUe;
                                oVar8.af(a2);
                            }
                        }
                        this.baf.Lm();
                    }
                    if (this.baf.aLR > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.baf.aLR, this.baf.MY().IM() - this.baf.aLR, this.baf.MY().IK(), this.baf.MY().IL(), currentTimeMillis3 - this.baf.MY().IJ());
                        this.baf.aLR = -1L;
                    }
                    this.baf.awn = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.baf.aZZ.Ms();
            if (i == 4) {
            }
        }
        this.baf.aZZ.Mq();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
    }
}
