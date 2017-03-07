package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.e.b;
import com.baidu.tieba.frs.entelechy.c.a;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
class e implements com.baidu.tieba.tbadkCore.p {
    final /* synthetic */ FrsActivity bNU;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void hK(int i) {
        this.startTime = System.nanoTime();
        if (this.bNU.bMN != null) {
            switch (i) {
                case 1:
                case 2:
                    this.bNU.bMN.Zx();
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
        z2 = this.bNU.byg;
        if (z2) {
            this.bNU.byg = false;
            com.baidu.tieba.frs.utils.s.a(this.bNU.bMN, this.bNU.bMO, this.bNU.getForumId(), false, null);
        }
        if (this.bNU.bMN.Zq() != null) {
            z5 = this.bNU.mIsLogin;
            if (z5) {
                this.bNU.bMN.Zq().setVisibility(0);
            }
        }
        adVar = this.bNU.bNb;
        if (adVar != null) {
            z4 = this.bNU.mIsLogin;
            if (z4) {
                adVar2 = this.bNU.bNb;
                adVar2.dX(true);
            }
        }
        this.bNU.YH();
        this.bNU.bMT = true;
        if (aVar != null && aVar.isSuccess) {
            this.bNU.bMN.ZG().dT(com.baidu.tbadk.core.util.av.vD().vF());
            FrsActivity.bMQ = 0L;
            FrsActivity.bMR = 0L;
            FrsActivity.bMS = 0;
        } else {
            FrsActivity.bMS = 1;
        }
        if (!this.bNU.bMY.adc() && (i == 3 || i == 6)) {
            hVar2 = this.bNU.bNq;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bNU.bMY.acc() != null) {
            this.bNU.bMO = this.bNU.bMY.acc();
        }
        if (i != 7) {
            if (this.bNU.bMO.getPage() != null) {
                this.bNU.setHasMore(this.bNU.bMO.getPage().qQ());
            }
            this.bNU.YI();
            this.bNU.bMN.ZT();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bNU.bMN.Zx();
                        break;
                    case 2:
                        this.bNU.bMN.Zx();
                        break;
                    case 3:
                    case 6:
                        if (this.bNU.bMO != null) {
                            this.bNU.bMO.bgo();
                        }
                        if (this.bNU.bNu != null) {
                            this.bNU.bNu.refresh();
                            break;
                        }
                        break;
                }
                this.bNU.YJ();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bNU.bMO != null) {
                        this.bNU.bMN.hN(i);
                        this.bNU.m(false, i == 5);
                        FrsActivity.bMQ = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            FrsActivity.bMR = aVar.frh;
                        }
                    } else {
                        return;
                    }
                } else if (this.bNU.bMO == null || com.baidu.tbadk.core.util.x.q(this.bNU.bMO.getThreadList())) {
                    this.bNU.a(aVar, false);
                } else if (aVar.frg) {
                    this.bNU.showToast(this.bNU.getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bNU.bMO.bfy() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11384"));
                }
                if (this.bNU.bEN > -1) {
                    com.baidu.tieba.frs.utils.s.a(this.bNU.bMY, this.bNU.bEN);
                    this.bNU.bEN = -1L;
                }
                z3 = this.bNU.bMK;
                if (z3) {
                    dVar = this.bNU.bNd;
                    if (dVar instanceof a) {
                        dVar2 = this.bNU.bNd;
                        if (((a) dVar2).abo() != null) {
                            dVar3 = this.bNU.bNd;
                            ((a) dVar3).abo().iv(49);
                            this.bNU.bMK = false;
                        }
                    }
                }
                this.bNU.aGp = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bNU.bMY.adc() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bNU.bMY.acR() == 1) {
                this.bNU.bMO.g(this.bNU);
            }
            hVar = this.bNU.bNq;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bNU.bMO.getThreadList();
            eVar = this.bNU.bMJ;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, eVar);
            if (a != null) {
                this.bNU.bMO.ax(a);
                this.bNU.bMO.bgq();
                this.bNU.bMN.a(a, this.bNU.bMO);
            }
            if (this.bNU.bMY != null) {
                b.a(this.bNU.bMO, this.bNU.bMY.acX(), 2);
                return;
            }
            return;
        }
        this.bNU.hI(this.bNU.bMO.bfU());
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.bNU.bMY.acN()) && !"frs_page".equals(this.bNU.bMY.acN()) && !"book_page".equals(this.bNU.bMY.acN())) {
                return;
            }
            this.bNU.a(lVar);
        }
    }
}
