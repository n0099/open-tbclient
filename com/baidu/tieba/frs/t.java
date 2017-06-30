package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.d.b;
import com.baidu.tieba.frs.entelechy.c.a;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.tbadkCore.p {
    final /* synthetic */ r cdl;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cdl = rVar;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void iu(int i) {
        this.startTime = System.nanoTime();
        if (this.cdl.ccj != null) {
            switch (i) {
                case 1:
                case 2:
                    this.cdl.ccj.aey();
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
        boolean z3;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar3;
        com.baidu.tieba.frs.mc.h hVar;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.frs.mc.h hVar2;
        z2 = this.cdl.bHe;
        if (z2) {
            this.cdl.bHe = false;
            com.baidu.tieba.frs.e.o.a(this.cdl.ccj, this.cdl.cbN, this.cdl.getForumId(), false, null);
        }
        this.cdl.adX();
        this.cdl.ccn = true;
        if (aVar != null && aVar.isSuccess) {
            this.cdl.ccj.aeI().eE(com.baidu.tbadk.core.util.ax.vA().vC());
            r.cck = 0L;
            r.ccl = 0L;
            r.ccm = 0;
        } else {
            r.ccm = 1;
        }
        if (!this.cdl.ccs.agY() && (i == 3 || i == 6)) {
            hVar2 = this.cdl.ccF;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cdl.ccs.agC() != null) {
            this.cdl.cbN = this.cdl.ccs.agC();
        }
        if (i != 7) {
            if (this.cdl.cbN.qu() != null) {
                this.cdl.setHasMore(this.cdl.cbN.qu().qq());
            }
            this.cdl.adY();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.cdl.ccj.aey();
                        break;
                    case 2:
                        this.cdl.ccj.aey();
                        break;
                    case 3:
                    case 6:
                        if (this.cdl.cbN != null) {
                            this.cdl.cbN.blm();
                        }
                        if (this.cdl.ccJ != null) {
                            this.cdl.ccJ.refresh();
                            break;
                        }
                        break;
                }
                this.cdl.adZ();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.cdl.cbN != null) {
                        this.cdl.ccj.iw(i);
                        this.cdl.q(false, i == 5);
                        r.cck = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            r.ccl = aVar.fJi;
                        }
                    } else {
                        return;
                    }
                } else if (this.cdl.cbN == null || com.baidu.tbadk.core.util.z.t(this.cdl.cbN.getThreadList())) {
                    this.cdl.a(aVar, false);
                } else if (aVar.fJh) {
                    this.cdl.showToast(this.cdl.getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.cdl.cbN.bkz() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11384"));
                }
                if (this.cdl.bTh > -1) {
                    com.baidu.tieba.frs.e.o.a(this.cdl.ccs, this.cdl.bTh);
                    this.cdl.bTh = -1L;
                }
                z3 = this.cdl.ccg;
                if (z3) {
                    dVar = this.cdl.ccu;
                    if (dVar instanceof a) {
                        dVar2 = this.cdl.ccu;
                        if (((a) dVar2).afP() != null) {
                            dVar3 = this.cdl.ccu;
                            ((a) dVar3).afP().je(49);
                            this.cdl.ccg = false;
                        }
                    }
                }
                this.cdl.aHL = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.cdl.ccs.agY() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.cdl.ccs.agN() == 1) {
                this.cdl.cbN.a(this.cdl);
            }
            hVar = this.cdl.ccF;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.cdl.cbN.getThreadList();
            eVar = this.cdl.ccf;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, eVar);
            if (a != null) {
                this.cdl.cbN.az(a);
                this.cdl.cbN.blo();
                this.cdl.ccj.a(a, this.cdl.cbN);
            }
            if (this.cdl.ccs != null) {
                b.a(this.cdl.cbN, this.cdl.ccs.agT(), 2);
                return;
            }
            return;
        }
        this.cdl.is(this.cdl.cbN.bkU());
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.cdl.ccs.agJ()) && !"frs_page".equals(this.cdl.ccs.agJ()) && !"book_page".equals(this.cdl.ccs.agJ())) {
                return;
            }
            this.cdl.a(lVar);
        }
    }
}
