package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.c.b;
import com.baidu.tieba.frs.entelechy.c.a;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.tbadkCore.p {
    final /* synthetic */ r bPn;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(r rVar) {
        this.bPn = rVar;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void hK(int i) {
        this.startTime = System.nanoTime();
        if (this.bPn.bOn != null) {
            switch (i) {
                case 1:
                case 2:
                    this.bPn.bOn.ZE();
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
        z2 = this.bPn.bAr;
        if (z2) {
            this.bPn.bAr = false;
            com.baidu.tieba.frs.d.o.a(this.bPn.bOn, this.bPn.bNT, this.bPn.getForumId(), false, null);
        }
        this.bPn.Zc();
        this.bPn.bOr = true;
        if (aVar != null && aVar.isSuccess) {
            this.bPn.bOn.ZO().dW(com.baidu.tbadk.core.util.av.vo().vq());
            r.bOo = 0L;
            r.bOp = 0L;
            r.bOq = 0;
        } else {
            r.bOq = 1;
        }
        if (!this.bPn.bOw.acb() && (i == 3 || i == 6)) {
            hVar2 = this.bPn.bOK;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bPn.bOw.abG() != null) {
            this.bPn.bNT = this.bPn.bOw.abG();
        }
        if (i != 7) {
            if (this.bPn.bNT.qB() != null) {
                this.bPn.setHasMore(this.bPn.bNT.qB().qx());
            }
            this.bPn.Zd();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bPn.bOn.ZE();
                        break;
                    case 2:
                        this.bPn.bOn.ZE();
                        break;
                    case 3:
                    case 6:
                        if (this.bPn.bNT != null) {
                            this.bPn.bNT.bfC();
                        }
                        if (this.bPn.bOO != null) {
                            this.bPn.bOO.refresh();
                            break;
                        }
                        break;
                }
                this.bPn.Ze();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bPn.bNT != null) {
                        this.bPn.bOn.hM(i);
                        this.bPn.m(false, i == 5);
                        r.bOo = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            r.bOp = aVar.frn;
                        }
                    } else {
                        return;
                    }
                } else if (this.bPn.bNT == null || com.baidu.tbadk.core.util.x.r(this.bPn.bNT.getThreadList())) {
                    this.bPn.a(aVar, false);
                } else if (aVar.frm) {
                    this.bPn.showToast(this.bPn.getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bPn.bNT.beQ() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11384"));
                }
                if (this.bPn.bGR > -1) {
                    com.baidu.tieba.frs.d.o.a(this.bPn.bOw, this.bPn.bGR);
                    this.bPn.bGR = -1L;
                }
                z3 = this.bPn.bOk;
                if (z3) {
                    dVar = this.bPn.bOz;
                    if (dVar instanceof a) {
                        dVar2 = this.bPn.bOz;
                        if (((a) dVar2).aaT() != null) {
                            dVar3 = this.bPn.bOz;
                            ((a) dVar3).aaT().iu(49);
                            this.bPn.bOk = false;
                        }
                    }
                }
                this.bPn.aGK = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bPn.bOw.acb() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bPn.bOw.abQ() == 1) {
                this.bPn.bNT.D(this.bPn.getPageContext());
            }
            hVar = this.bPn.bOK;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPn.bNT.getThreadList();
            eVar = this.bPn.bOj;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, eVar);
            if (a != null) {
                this.bPn.bNT.ay(a);
                this.bPn.bNT.bfE();
                this.bPn.bOn.a(a, this.bPn.bNT);
            }
            if (this.bPn.bOw != null) {
                b.a(this.bPn.bNT, this.bPn.bOw.abW(), 2);
                return;
            }
            return;
        }
        this.bPn.hI(this.bPn.bNT.bfl());
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.bPn.bOw.abM()) && !"frs_page".equals(this.bPn.bOw.abM()) && !"book_page".equals(this.bPn.bOw.abM())) {
                return;
            }
            this.bPn.a(lVar);
        }
    }
}
