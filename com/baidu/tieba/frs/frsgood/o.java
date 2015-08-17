package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.tbadkCore.q {
    final /* synthetic */ FrsGoodActivity aZp;
    private long startTime = 0;
    private long aUD = 0;
    private long aUE = 0;
    private long aZr = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void fg(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.aZp.aZj.cb(true);
                this.aZp.aZj.Ma();
                return;
            case 2:
                this.aZp.aZj.cc(true);
                this.aZp.aZj.Ma();
                return;
            case 3:
                this.aZp.aZj.ca(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.aoW().size() == 0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014b  */
    @Override // com.baidu.tieba.tbadkCore.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, d.a aVar) {
        com.baidu.tieba.tbadkCore.n nVar;
        int i2;
        boolean z2;
        com.baidu.tieba.tbadkCore.n nVar2;
        boolean z3;
        com.baidu.tieba.tbadkCore.n nVar3;
        af afVar;
        com.baidu.tieba.tbadkCore.n nVar4;
        com.baidu.tieba.tbadkCore.n nVar5;
        com.baidu.tieba.tbadkCore.n nVar6;
        v vVar;
        com.baidu.tieba.tbadkCore.n nVar7;
        com.baidu.tieba.tbadkCore.n nVar8;
        com.baidu.tieba.tbadkCore.n nVar9;
        com.baidu.tieba.tbadkCore.n nVar10;
        int i3;
        int i4;
        com.baidu.tieba.tbadkCore.n nVar11;
        com.baidu.tieba.tbadkCore.n nVar12;
        com.baidu.tieba.tbadkCore.n nVar13;
        com.baidu.tieba.tbadkCore.n nVar14;
        com.baidu.tieba.tbadkCore.n nVar15;
        com.baidu.tieba.tbadkCore.n nVar16;
        com.baidu.tieba.tbadkCore.n nVar17;
        com.baidu.tieba.tbadkCore.n nVar18;
        com.baidu.tieba.tbadkCore.n nVar19;
        boolean z4;
        v vVar2;
        com.baidu.tieba.tbadkCore.n nVar20;
        com.baidu.tieba.tbadkCore.n nVar21;
        int i5;
        com.baidu.tieba.tbadkCore.n nVar22;
        int i6;
        com.baidu.tieba.tbadkCore.n nVar23;
        com.baidu.tieba.tbadkCore.n nVar24;
        com.baidu.tieba.tbadkCore.n nVar25;
        com.baidu.tieba.tbadkCore.n nVar26;
        v vVar3;
        if (aVar == null) {
            this.aZr = 1L;
        } else if (aVar.isSuccess) {
            this.aZp.aZj.MO().bT(ar.uE().uG());
            this.aUD = 0L;
            this.aUE = 0L;
            this.aZr = 0L;
        } else {
            this.aZr = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            vVar3 = this.aZp.aZm;
            vVar3.resetData();
        }
        this.aZp.aZj.ca(false);
        if (this.aZp.MM().MS() != null) {
            this.aZp.aUy = this.aZp.MM().MS();
        }
        FrsGoodActivity frsGoodActivity = this.aZp;
        nVar = this.aZp.aUy;
        frsGoodActivity.aUP = nVar.getPage().rT();
        i2 = this.aZp.aUP;
        if (i2 == 0) {
            nVar23 = this.aZp.aUy;
            if (nVar23.aoW() != null) {
                nVar26 = this.aZp.aUy;
            }
            nVar24 = this.aZp.aUy;
            if (nVar24.getThreadList() != null) {
                nVar25 = this.aZp.aUy;
                if (nVar25.getThreadList().size() != 0) {
                    this.aZp.aZj.Mp();
                    if (i == 4) {
                        vVar2 = this.aZp.aZm;
                        nVar20 = this.aZp.aUy;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = vVar2.a(false, nVar20.getThreadList());
                        if (a != null) {
                            nVar21 = this.aZp.aUy;
                            nVar21.X(a);
                            x xVar = this.aZp.aZj;
                            i5 = this.aZp.mPn;
                            nVar22 = this.aZp.aUy;
                            i6 = this.aZp.aUP;
                            xVar.a(a, i5, nVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.aZp.aZj.cb(false);
                            this.aZp.aZj.Ma();
                            break;
                        case 2:
                            this.aZp.aZj.cc(false);
                            this.aZp.aZj.Ma();
                            break;
                    }
                    z2 = this.aZp.aUv;
                    if (!z2) {
                        this.aZp.MH();
                    } else {
                        this.aZp.MJ();
                    }
                    if (this.aZr != 0) {
                        z4 = this.aZp.aUv;
                        if (!z4) {
                            this.aZp.a(aVar);
                        } else {
                            this.aZp.b(aVar);
                        }
                    } else {
                        this.aZp.aUv = true;
                        nVar2 = this.aZp.aUy;
                        if (nVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.aZp;
                            nVar16 = this.aZp.aUy;
                            frsGoodActivity2.aUq = nVar16.acG().getName();
                            FrsGoodActivity frsGoodActivity3 = this.aZp;
                            nVar17 = this.aZp.aUy;
                            frsGoodActivity3.forumId = nVar17.acG().getId();
                            x xVar2 = this.aZp.aZj;
                            nVar18 = this.aZp.aUy;
                            ForumData acG = nVar18.acG();
                            nVar19 = this.aZp.aUy;
                            xVar2.b(acG, nVar19.getUserData());
                        }
                        z3 = this.aZp.aUJ;
                        if (z3) {
                            nVar13 = this.aZp.aUy;
                            if (nVar13 != null) {
                                nVar14 = this.aZp.aUy;
                                nVar14.apk();
                                nVar15 = this.aZp.aUy;
                                nVar15.apm();
                            }
                        }
                        nVar3 = this.aZp.aUy;
                        if (nVar3 != null) {
                            nVar11 = this.aZp.aUy;
                            com.baidu.tbadk.core.data.x top_notice_data = nVar11.acG().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.v vVar4 = new com.baidu.tbadk.core.data.v();
                                vVar4.setTitle(top_notice_data.getTitle());
                                vVar4.bz(2);
                                vVar4.ch(top_notice_data.sI());
                                vVar4.parser_title();
                                nVar12 = this.aZp.aUy;
                                nVar12.e(vVar4);
                            }
                        }
                        afVar = this.aZp.aZl;
                        nVar4 = this.aZp.aUy;
                        afVar.c(nVar4);
                        this.aUD = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.aUE = aVar.cGG;
                        }
                        nVar5 = this.aZp.aUy;
                        if (nVar5 != null) {
                            nVar9 = this.aZp.aUy;
                            if (nVar9.getThreadList() != null) {
                                nVar10 = this.aZp.aUy;
                                if (nVar10.getThreadList().size() == 0 && this.aZp.MM().getType() == 4) {
                                    this.aZp.showToast(this.aZp.getPageContext().getString(i.C0057i.no_more_to_load));
                                    i3 = this.aZp.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.aZp;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.aZp.aMq > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.aZp.aMq, this.aZp.MM().IQ() - this.aZp.aMq, this.aZp.MM().IO(), this.aZp.MM().IP(), currentTimeMillis2 - this.aZp.MM().IN());
                                        this.aZp.aMq = -1L;
                                    }
                                    this.aZp.axq = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        nVar6 = this.aZp.aUy;
                        if (nVar6 != null) {
                            vVar = this.aZp.aZm;
                            nVar7 = this.aZp.aUy;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = vVar.a(true, nVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                nVar8 = this.aZp.aUy;
                                nVar8.X(a2);
                            }
                        }
                        this.aZp.Lp();
                    }
                    if (this.aZp.aMq > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.aZp.aMq, this.aZp.MM().IQ() - this.aZp.aMq, this.aZp.MM().IO(), this.aZp.MM().IP(), currentTimeMillis3 - this.aZp.MM().IN());
                        this.aZp.aMq = -1L;
                    }
                    this.aZp.axq = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.aZp.aZj.Mq();
            if (i == 4) {
            }
        }
        this.aZp.aZj.Mo();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
    }
}
