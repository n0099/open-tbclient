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
    final /* synthetic */ r bVb;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.bVb = rVar;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void ii(int i) {
        this.startTime = System.nanoTime();
        if (this.bVb.bUa != null) {
            switch (i) {
                case 1:
                case 2:
                    this.bVb.bUa.aaH();
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
        z2 = this.bVb.bwA;
        if (z2) {
            this.bVb.bwA = false;
            com.baidu.tieba.frs.e.o.a(this.bVb.bUa, this.bVb.bTF, this.bVb.getForumId(), false, null);
        }
        this.bVb.aag();
        this.bVb.bUe = true;
        if (aVar != null && aVar.isSuccess) {
            this.bVb.bUa.aaR().em(com.baidu.tbadk.core.util.av.vl().vn());
            r.bUb = 0L;
            r.bUc = 0L;
            r.bUd = 0;
        } else {
            r.bUd = 1;
        }
        if (!this.bVb.bUj.adf() && (i == 3 || i == 6)) {
            hVar2 = this.bVb.bUx;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bVb.bUj.acK() != null) {
            this.bVb.bTF = this.bVb.bUj.acK();
        }
        if (i != 7) {
            if (this.bVb.bTF.qx() != null) {
                this.bVb.setHasMore(this.bVb.bTF.qx().qt());
            }
            this.bVb.aah();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bVb.bUa.aaH();
                        break;
                    case 2:
                        this.bVb.bUa.aaH();
                        break;
                    case 3:
                    case 6:
                        if (this.bVb.bTF != null) {
                            this.bVb.bTF.bgY();
                        }
                        if (this.bVb.bUB != null) {
                            this.bVb.bUB.refresh();
                            break;
                        }
                        break;
                }
                this.bVb.aai();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bVb.bTF != null) {
                        this.bVb.bUa.ik(i);
                        this.bVb.p(false, i == 5);
                        r.bUb = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            r.bUc = aVar.fze;
                        }
                    } else {
                        return;
                    }
                } else if (this.bVb.bTF == null || com.baidu.tbadk.core.util.x.r(this.bVb.bTF.getThreadList())) {
                    this.bVb.a(aVar, false);
                } else if (aVar.fzd) {
                    this.bVb.showToast(this.bVb.getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bVb.bTF.bgl() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11384"));
                }
                if (this.bVb.bMF > -1) {
                    com.baidu.tieba.frs.e.o.a(this.bVb.bUj, this.bVb.bMF);
                    this.bVb.bMF = -1L;
                }
                z3 = this.bVb.bTX;
                if (z3) {
                    dVar = this.bVb.bUm;
                    if (dVar instanceof a) {
                        dVar2 = this.bVb.bUm;
                        if (((a) dVar2).abX() != null) {
                            dVar3 = this.bVb.bUm;
                            ((a) dVar3).abX().iS(49);
                            this.bVb.bTX = false;
                        }
                    }
                }
                this.bVb.aGx = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bVb.bUj.adf() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bVb.bUj.acU() == 1) {
                this.bVb.bTF.a(this.bVb);
            }
            hVar = this.bVb.bUx;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bVb.bTF.getThreadList();
            eVar = this.bVb.bTW;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, eVar);
            if (a != null) {
                this.bVb.bTF.ay(a);
                this.bVb.bTF.bha();
                this.bVb.bUa.a(a, this.bVb.bTF);
            }
            if (this.bVb.bUj != null) {
                b.a(this.bVb.bTF, this.bVb.bUj.ada(), 2);
                return;
            }
            return;
        }
        this.bVb.ig(this.bVb.bTF.bgG());
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.bVb.bUj.acQ()) && !"frs_page".equals(this.bVb.bUj.acQ()) && !"book_page".equals(this.bVb.bUj.acQ())) {
                return;
            }
            this.bVb.a(lVar);
        }
    }
}
