package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsGoodActivity bsj;
    private long startTime = 0;
    private long bku = 0;
    private long bkv = 0;
    private long bsl = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void gG(int i) {
        this.startTime = System.nanoTime();
        switch (i) {
            case 1:
                this.bsj.bsd.cF(true);
                this.bsj.bsd.RP();
                return;
            case 2:
                this.bsj.bsd.cG(true);
                this.bsj.bsd.RP();
                return;
            case 3:
                this.bsj.bsd.cE(true);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
        if (r1.aRJ().size() == 0) goto L15;
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
            this.bsl = 1L;
        } else if (aVar.isSuccess) {
            this.bsj.bsd.SM().cw(az.wz().wB());
            this.bku = 0L;
            this.bkv = 0L;
            this.bsl = 0L;
        } else {
            this.bsl = 1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 3) {
            wVar3 = this.bsj.bsg;
            wVar3.resetData();
        }
        this.bsj.bsd.cE(false);
        if (this.bsj.SJ().SP() != null) {
            this.bsj.bkq = this.bsj.SJ().SP();
        }
        FrsGoodActivity frsGoodActivity = this.bsj;
        oVar = this.bsj.bkq;
        frsGoodActivity.bkH = oVar.getPage().sq();
        i2 = this.bsj.bkH;
        if (i2 == 0) {
            oVar23 = this.bsj.bkq;
            if (oVar23.aRJ() != null) {
                oVar26 = this.bsj.bkq;
            }
            oVar24 = this.bsj.bkq;
            if (oVar24.getThreadList() != null) {
                oVar25 = this.bsj.bkq;
                if (oVar25.getThreadList().size() != 0) {
                    this.bsj.bsd.Sh();
                    if (i == 4) {
                        wVar2 = this.bsj.bsg;
                        oVar20 = this.bsj.bkq;
                        ArrayList<com.baidu.adp.widget.ListView.u> a = wVar2.a(false, oVar20.getThreadList());
                        if (a != null) {
                            oVar21 = this.bsj.bkq;
                            oVar21.ao(a);
                            y yVar = this.bsj.bsd;
                            i5 = this.bsj.mPn;
                            oVar22 = this.bsj.bkq;
                            i6 = this.bsj.bkH;
                            yVar.a(a, i5, oVar22, i6);
                            return;
                        }
                        return;
                    }
                    switch (i) {
                        case 1:
                            this.bsj.bsd.cF(false);
                            this.bsj.bsd.RP();
                            break;
                        case 2:
                            this.bsj.bsd.cG(false);
                            this.bsj.bsd.RP();
                            break;
                    }
                    z2 = this.bsj.bkn;
                    if (!z2) {
                        this.bsj.SE();
                    } else {
                        this.bsj.SG();
                    }
                    if (this.bsl != 0) {
                        z4 = this.bsj.bkn;
                        if (!z4) {
                            this.bsj.a(aVar);
                        } else {
                            this.bsj.b(aVar);
                        }
                    } else {
                        this.bsj.bkn = true;
                        oVar2 = this.bsj.bkq;
                        if (oVar2 != null) {
                            FrsGoodActivity frsGoodActivity2 = this.bsj;
                            oVar16 = this.bsj.bkq;
                            frsGoodActivity2.bkf = oVar16.avu().getName();
                            FrsGoodActivity frsGoodActivity3 = this.bsj;
                            oVar17 = this.bsj.bkq;
                            frsGoodActivity3.forumId = oVar17.avu().getId();
                            y yVar2 = this.bsj.bsd;
                            oVar18 = this.bsj.bkq;
                            ForumData avu = oVar18.avu();
                            oVar19 = this.bsj.bkq;
                            yVar2.b(avu, oVar19.getUserData());
                        }
                        z3 = this.bsj.bkA;
                        if (z3) {
                            oVar13 = this.bsj.bkq;
                            if (oVar13 != null) {
                                oVar14 = this.bsj.bkq;
                                oVar14.aSk();
                                oVar15 = this.bsj.bkq;
                                oVar15.aSq();
                            }
                        }
                        oVar3 = this.bsj.bkq;
                        if (oVar3 != null) {
                            oVar11 = this.bsj.bkq;
                            au top_notice_data = oVar11.avu().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                as asVar = new as();
                                asVar.setTitle(top_notice_data.getTitle());
                                asVar.bW(2);
                                asVar.cu(top_notice_data.uc());
                                asVar.parser_title();
                                oVar12 = this.bsj.bkq;
                                oVar12.k(asVar);
                            }
                        }
                        agVar = this.bsj.bsf;
                        oVar4 = this.bsj.bkq;
                        agVar.c(oVar4);
                        this.bku = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            this.bkv = aVar.emP;
                        }
                        oVar5 = this.bsj.bkq;
                        if (oVar5 != null) {
                            oVar9 = this.bsj.bkq;
                            if (oVar9.getThreadList() != null) {
                                oVar10 = this.bsj.bkq;
                                if (oVar10.getThreadList().size() == 0 && this.bsj.SJ().getType() == 4) {
                                    this.bsj.showToast(this.bsj.getPageContext().getString(t.j.no_more_to_load));
                                    i3 = this.bsj.mPn;
                                    if (i3 > 1) {
                                        FrsGoodActivity frsGoodActivity4 = this.bsj;
                                        i4 = frsGoodActivity4.mPn;
                                        frsGoodActivity4.mPn = i4 - 1;
                                    }
                                    if (this.bsj.bbg > -1) {
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bsj.bbg, this.bsj.SJ().Oc() - this.bsj.bbg, this.bsj.SJ().Oa(), this.bsj.SJ().Ob(), currentTimeMillis2 - this.bsj.SJ().NZ());
                                        this.bsj.bbg = -1L;
                                    }
                                    this.bsj.aBB = System.currentTimeMillis() - currentTimeMillis;
                                    return;
                                }
                            }
                        }
                        oVar6 = this.bsj.bkq;
                        if (oVar6 != null) {
                            wVar = this.bsj.bsg;
                            oVar7 = this.bsj.bkq;
                            ArrayList<com.baidu.adp.widget.ListView.u> a2 = wVar.a(true, oVar7.getThreadList());
                            if (a2 != null && a2.size() > 0) {
                                oVar8 = this.bsj.bkq;
                                oVar8.ao(a2);
                            }
                        }
                        this.bsj.QP();
                    }
                    if (this.bsj.bbg > -1) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bsj.bbg, this.bsj.SJ().Oc() - this.bsj.bbg, this.bsj.SJ().Oa(), this.bsj.SJ().Ob(), currentTimeMillis3 - this.bsj.SJ().NZ());
                        this.bsj.bbg = -1L;
                    }
                    this.bsj.aBB = System.currentTimeMillis() - currentTimeMillis;
                    System.gc();
                    return;
                }
            }
            this.bsj.bsd.Si();
            if (i == 4) {
            }
        }
        this.bsj.bsd.Sg();
        if (i == 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
    }
}
