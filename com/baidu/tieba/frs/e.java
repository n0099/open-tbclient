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
    final /* synthetic */ FrsActivity bQa;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void hT(int i) {
        this.startTime = System.nanoTime();
        if (this.bQa.bOU != null) {
            switch (i) {
                case 1:
                case 2:
                    this.bQa.bOU.aaW();
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
        z2 = this.bQa.bAq;
        if (z2) {
            this.bQa.bAq = false;
            com.baidu.tieba.frs.f.s.a(this.bQa.bOU, this.bQa.bOV, this.bQa.getForumId(), false, null);
        }
        if (this.bQa.bOU.aaP() != null) {
            z5 = this.bQa.mIsLogin;
            if (z5) {
                this.bQa.bOU.aaP().setVisibility(0);
            }
        }
        adVar = this.bQa.bPi;
        if (adVar != null) {
            z4 = this.bQa.mIsLogin;
            if (z4) {
                adVar2 = this.bQa.bPi;
                adVar2.ej(true);
            }
        }
        this.bQa.aae();
        this.bQa.bPa = true;
        if (aVar != null && aVar.isSuccess) {
            this.bQa.bOU.abf().ef(com.baidu.tbadk.core.util.av.wa().wc());
            FrsActivity.bOX = 0L;
            FrsActivity.bOY = 0L;
            FrsActivity.bOZ = 0;
        } else {
            FrsActivity.bOZ = 1;
        }
        if (!this.bQa.bPf.adX() && (i == 3 || i == 6)) {
            hVar2 = this.bQa.bPw;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bQa.bPf.adz() != null) {
            this.bQa.bOV = this.bQa.bPf.adz();
        }
        if (i != 7) {
            if (this.bQa.bOV.rr() != null) {
                this.bQa.setHasMore(this.bQa.bOV.rr().rn());
            }
            this.bQa.aaf();
            this.bQa.bOU.abs();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bQa.bOU.aaW();
                        break;
                    case 2:
                        this.bQa.bOU.aaW();
                        break;
                    case 3:
                    case 6:
                        if (this.bQa.bOV != null) {
                            this.bQa.bOV.bic();
                        }
                        if (this.bQa.bPA != null) {
                            this.bQa.bPA.refresh();
                            break;
                        }
                        break;
                }
                this.bQa.aag();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bQa.bOV != null) {
                        this.bQa.bOU.hW(i);
                        this.bQa.m(false, i == 5);
                        FrsActivity.bOX = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            FrsActivity.bOY = aVar.fvk;
                        }
                    } else {
                        return;
                    }
                } else if (this.bQa.bOV == null || com.baidu.tbadk.core.util.x.q(this.bQa.bOV.getThreadList())) {
                    this.bQa.a(aVar, false);
                } else if (aVar.fvj) {
                    this.bQa.showToast(this.bQa.getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bQa.bOV.bho() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11384"));
                }
                if (this.bQa.bGX > -1) {
                    com.baidu.tieba.frs.f.s.a(this.bQa.bPf, this.bQa.bGX);
                    this.bQa.bGX = -1L;
                }
                z3 = this.bQa.bOR;
                if (z3) {
                    dVar = this.bQa.bPk;
                    if (dVar instanceof a) {
                        dVar2 = this.bQa.bPk;
                        if (((a) dVar2).acM() != null) {
                            dVar3 = this.bQa.bPk;
                            ((a) dVar3).acM().iC(49);
                            this.bQa.bOR = false;
                        }
                    }
                }
                this.bQa.aGG = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bQa.bPf.adX() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bQa.bPf.adM() == 1) {
                this.bQa.bOV.g(this.bQa);
            }
            hVar = this.bQa.bPw;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bQa.bOV.getThreadList();
            eVar = this.bQa.bOQ;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, eVar);
            if (a != null) {
                this.bQa.bOV.ax(a);
                this.bQa.bOV.bie();
                this.bQa.bOU.a(a, this.bQa.bOV);
            }
            if (this.bQa.bPf != null) {
                b.a(this.bQa.bOV, this.bQa.bPf.adS(), 2);
                return;
            }
            return;
        }
        this.bQa.hR(this.bQa.bOV.bhJ());
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null) {
            if (!"normal_page".equals(this.bQa.bPf.adI()) && !"frs_page".equals(this.bQa.bPf.adI()) && !"book_page".equals(this.bQa.bPf.adI())) {
                return;
            }
            this.bQa.a(lVar);
        }
    }
}
