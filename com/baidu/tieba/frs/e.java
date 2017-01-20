package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.e.b;
import com.baidu.tieba.frs.entelechy.c.a;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class e implements com.baidu.tieba.tbadkCore.p {
    final /* synthetic */ FrsActivity bGL;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void hO(int i) {
        this.startTime = System.nanoTime();
        if (this.bGL.bFF != null) {
            switch (i) {
                case 1:
                case 2:
                    this.bGL.bFF.Yy();
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

    @Override // com.baidu.tieba.tbadkCore.p
    public void a(int i, boolean z, d.a aVar) {
        boolean z2;
        com.baidu.tieba.frs.f.ad adVar;
        boolean z3;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar3;
        com.baidu.tieba.frs.mc.h hVar;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.frs.mc.h hVar2;
        boolean z4;
        com.baidu.tieba.frs.f.ad adVar2;
        boolean z5;
        z2 = this.bGL.brg;
        if (z2) {
            this.bGL.brg = false;
            com.baidu.tieba.frs.utils.s.a(this.bGL.bFF, this.bGL.bFG, this.bGL.getForumId(), false, null);
        }
        if (this.bGL.bFF.Yr() != null) {
            z5 = this.bGL.mIsLogin;
            if (z5) {
                this.bGL.bFF.Yr().setVisibility(0);
            }
        }
        adVar = this.bGL.bFT;
        if (adVar != null) {
            z4 = this.bGL.mIsLogin;
            if (z4) {
                adVar2 = this.bGL.bFT;
                adVar2.dX(true);
            }
        }
        this.bGL.XI();
        this.bGL.bFL = true;
        if (aVar != null && aVar.isSuccess) {
            this.bGL.bFF.YH().dT(com.baidu.tbadk.core.util.au.vg().vi());
            FrsActivity.bFI = 0L;
            FrsActivity.bFJ = 0L;
            FrsActivity.bFK = 0;
        } else {
            FrsActivity.bFK = 1;
        }
        if (!this.bGL.bFQ.acf() && (i == 3 || i == 6)) {
            hVar2 = this.bGL.bGi;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bGL.bFQ.abf() != null) {
            this.bGL.bFG = this.bGL.bFQ.abf();
        }
        if (i != 7) {
            if (this.bGL.bFG.getPage() != null) {
                this.bGL.setHasMore(this.bGL.bFG.getPage().qx());
            }
            this.bGL.XJ();
            this.bGL.bFF.YU();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bGL.bFF.Yy();
                        break;
                    case 2:
                        this.bGL.bFF.Yy();
                        break;
                    case 3:
                    case 6:
                        if (this.bGL.bFG != null) {
                            this.bGL.bFG.bgB();
                        }
                        if (this.bGL.bGm != null) {
                            this.bGL.bGm.refresh();
                            break;
                        }
                        break;
                }
                this.bGL.XK();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bGL.bFG != null) {
                        this.bGL.bFF.hR(i);
                        this.bGL.n(false, i == 5);
                        FrsActivity.bFI = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            FrsActivity.bFJ = aVar.fmK;
                        }
                    } else {
                        return;
                    }
                } else if (this.bGL.bFG == null || com.baidu.tbadk.core.util.w.s(this.bGL.bFG.getThreadList())) {
                    this.bGL.a(aVar, false);
                } else if (aVar.fmJ) {
                    this.bGL.showToast(this.bGL.getPageContext().getResources().getString(r.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bGL.bFG.bfL() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11384"));
                }
                if (this.bGL.bxH > -1) {
                    com.baidu.tieba.frs.utils.s.a(this.bGL.bFQ, this.bGL.bxH);
                    this.bGL.bxH = -1L;
                }
                z3 = this.bGL.bFC;
                if (z3) {
                    dVar = this.bGL.bFV;
                    if (dVar instanceof a) {
                        dVar2 = this.bGL.bFV;
                        if (((a) dVar2).aar() != null) {
                            dVar3 = this.bGL.bFV;
                            ((a) dVar3).aar().iz(49);
                            this.bGL.bFC = false;
                        }
                    }
                }
                this.bGL.aAX = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bGL.bFQ.acf() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bGL.bFQ.abU() == 1) {
                this.bGL.bFG.g(this.bGL);
            }
            hVar = this.bGL.bGi;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bGL.bFG.getThreadList();
            eVar = this.bGL.bFB;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, eVar);
            if (a != null) {
                this.bGL.bFG.ax(a);
                this.bGL.bFG.bgD();
                this.bGL.bFF.a(a, this.bGL.bFG);
            }
            if (this.bGL.bFQ != null) {
                b.a(this.bGL.bFG, this.bGL.bFQ.aca(), 2);
                return;
            }
            return;
        }
        this.bGL.hM(this.bGL.bFG.bgh());
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.bGL.bFQ.abQ()) && !"frs_page".equals(this.bGL.bFQ.abQ()) && !"book_page".equals(this.bGL.bFQ.abQ())) {
                return;
            }
            this.bGL.a(lVar);
        }
    }
}
