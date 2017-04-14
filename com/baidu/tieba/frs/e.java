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
    final /* synthetic */ FrsActivity bNJ;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void hN(int i) {
        this.startTime = System.nanoTime();
        if (this.bNJ.bMD != null) {
            switch (i) {
                case 1:
                case 2:
                    this.bNJ.bMD.ZV();
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
        com.baidu.tieba.frs.g.ad adVar;
        boolean z3;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar3;
        com.baidu.tieba.frs.mc.h hVar;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.frs.mc.h hVar2;
        boolean z4;
        com.baidu.tieba.frs.g.ad adVar2;
        boolean z5;
        z2 = this.bNJ.bxZ;
        if (z2) {
            this.bNJ.bxZ = false;
            com.baidu.tieba.frs.f.s.a(this.bNJ.bMD, this.bNJ.bME, this.bNJ.getForumId(), false, null);
        }
        if (this.bNJ.bMD.ZO() != null) {
            z5 = this.bNJ.mIsLogin;
            if (z5) {
                this.bNJ.bMD.ZO().setVisibility(0);
            }
        }
        adVar = this.bNJ.bMR;
        if (adVar != null) {
            z4 = this.bNJ.mIsLogin;
            if (z4) {
                adVar2 = this.bNJ.bMR;
                adVar2.dZ(true);
            }
        }
        this.bNJ.Zd();
        this.bNJ.bMJ = true;
        if (aVar != null && aVar.isSuccess) {
            this.bNJ.bMD.aae().dV(com.baidu.tbadk.core.util.av.wa().wc());
            FrsActivity.bMG = 0L;
            FrsActivity.bMH = 0L;
            FrsActivity.bMI = 0;
        } else {
            FrsActivity.bMI = 1;
        }
        if (!this.bNJ.bMO.acW() && (i == 3 || i == 6)) {
            hVar2 = this.bNJ.bNf;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bNJ.bMO.acy() != null) {
            this.bNJ.bME = this.bNJ.bMO.acy();
        }
        if (i != 7) {
            if (this.bNJ.bME.rr() != null) {
                this.bNJ.setHasMore(this.bNJ.bME.rr().rn());
            }
            this.bNJ.Ze();
            this.bNJ.bMD.aar();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bNJ.bMD.ZV();
                        break;
                    case 2:
                        this.bNJ.bMD.ZV();
                        break;
                    case 3:
                    case 6:
                        if (this.bNJ.bME != null) {
                            this.bNJ.bME.bhb();
                        }
                        if (this.bNJ.bNj != null) {
                            this.bNJ.bNj.refresh();
                            break;
                        }
                        break;
                }
                this.bNJ.Zf();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bNJ.bME != null) {
                        this.bNJ.bMD.hQ(i);
                        this.bNJ.m(false, i == 5);
                        FrsActivity.bMG = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            FrsActivity.bMH = aVar.fsT;
                        }
                    } else {
                        return;
                    }
                } else if (this.bNJ.bME == null || com.baidu.tbadk.core.util.x.q(this.bNJ.bME.getThreadList())) {
                    this.bNJ.a(aVar, false);
                } else if (aVar.fsS) {
                    this.bNJ.showToast(this.bNJ.getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bNJ.bME.bgm() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11384"));
                }
                if (this.bNJ.bEG > -1) {
                    com.baidu.tieba.frs.f.s.a(this.bNJ.bMO, this.bNJ.bEG);
                    this.bNJ.bEG = -1L;
                }
                z3 = this.bNJ.bMA;
                if (z3) {
                    dVar = this.bNJ.bMT;
                    if (dVar instanceof a) {
                        dVar2 = this.bNJ.bMT;
                        if (((a) dVar2).abL() != null) {
                            dVar3 = this.bNJ.bMT;
                            ((a) dVar3).abL().iw(49);
                            this.bNJ.bMA = false;
                        }
                    }
                }
                this.bNJ.aGE = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bNJ.bMO.acW() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bNJ.bMO.acL() == 1) {
                this.bNJ.bME.g(this.bNJ);
            }
            hVar = this.bNJ.bNf;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bNJ.bME.getThreadList();
            eVar = this.bNJ.bMz;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, eVar);
            if (a != null) {
                this.bNJ.bME.ax(a);
                this.bNJ.bME.bhd();
                this.bNJ.bMD.a(a, this.bNJ.bME);
            }
            if (this.bNJ.bMO != null) {
                b.a(this.bNJ.bME, this.bNJ.bMO.acR(), 2);
                return;
            }
            return;
        }
        this.bNJ.hL(this.bNJ.bME.bgH());
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.bNJ.bMO.acH()) && !"frs_page".equals(this.bNJ.bMO.acH()) && !"book_page".equals(this.bNJ.bMO.acH())) {
                return;
            }
            this.bNJ.a(lVar);
        }
    }
}
