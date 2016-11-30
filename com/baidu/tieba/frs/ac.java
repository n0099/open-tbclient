package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.h.b;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ac implements com.baidu.tieba.tbadkCore.r {
    final /* synthetic */ FrsActivity bTa;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void hS(int i) {
        this.startTime = System.nanoTime();
        if (this.bTa.bRW != null) {
            switch (i) {
                case 1:
                    this.bTa.bRW.acT();
                    return;
                case 2:
                    this.bTa.bRW.acT();
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

    @Override // com.baidu.tieba.tbadkCore.r
    public void a(int i, boolean z, e.a aVar) {
        boolean z2;
        com.baidu.tieba.frs.j.w wVar;
        com.baidu.tieba.frs.e.h hVar;
        com.baidu.tieba.tbadkCore.data.f fVar;
        com.baidu.tieba.frs.e.h hVar2;
        boolean z3;
        com.baidu.tieba.frs.j.w wVar2;
        boolean z4;
        z2 = this.bTa.bSt;
        if (z2) {
            this.bTa.bSt = false;
            com.baidu.tieba.frs.utils.t.a(this.bTa.bRW, this.bTa.bRX, this.bTa.getForumId(), false, (com.baidu.tbadk.core.data.bk) null);
        }
        if (this.bTa.bRW.acP() != null) {
            z4 = this.bTa.mIsLogin;
            if (z4) {
                this.bTa.bRW.acP().setVisibility(0);
            }
        }
        wVar = this.bTa.bSk;
        if (wVar != null) {
            z3 = this.bTa.mIsLogin;
            if (z3) {
                wVar2 = this.bTa.bSk;
                wVar2.ei(true);
            }
        }
        this.bTa.acd();
        this.bTa.bSc = true;
        if (aVar != null && aVar.isSuccess) {
            this.bTa.bRW.ade().ee(com.baidu.tbadk.core.util.ay.vC().vE());
            FrsActivity.bRZ = 0L;
            FrsActivity.bSa = 0L;
            FrsActivity.bSb = 0;
        } else {
            FrsActivity.bSb = 1;
        }
        if (!this.bTa.bSh.agD() && (i == 3 || i == 6)) {
            hVar2 = this.bTa.bSC;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bTa.bSh.afE() != null) {
            this.bTa.bRX = this.bTa.bSh.afE();
        }
        if (i != 7) {
            if (this.bTa.bRX.getPage() != null) {
                this.bTa.setHasMore(this.bTa.bRX.getPage().qD());
            }
            this.bTa.ace();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bTa.bRW.acT();
                        break;
                    case 2:
                        this.bTa.bRW.acT();
                        break;
                    case 3:
                    case 6:
                        if (this.bTa.bRX != null) {
                            this.bTa.bRX.bkW();
                            break;
                        }
                        break;
                }
                this.bTa.acf();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bTa.bRX != null) {
                        this.bTa.bRW.hV(i);
                        this.bTa.m(false, i == 5);
                        FrsActivity.bRZ = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            FrsActivity.bSa = aVar.fzo;
                        }
                    } else {
                        return;
                    }
                } else if (this.bTa.bRX == null || com.baidu.tbadk.core.util.x.t(this.bTa.bRX.getThreadList())) {
                    this.bTa.a(aVar, false);
                } else if (aVar.fzn) {
                    this.bTa.showToast(this.bTa.getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bTa.bRX.bkh() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11384"));
                }
                if (this.bTa.bJR > -1) {
                    com.baidu.tieba.frs.utils.t.a(this.bTa.bSh, this.bTa.bJR);
                    this.bTa.bJR = -1L;
                }
                this.bTa.aCL = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bTa.bSh.agD() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bTa.bSh.ags() == 1) {
                this.bTa.bRX.bq(this.bTa.getPageContext().getPageActivity());
            }
            hVar = this.bTa.bSC;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bTa.bRX.getThreadList();
            fVar = this.bTa.bRS;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, fVar);
            if (a != null) {
                this.bTa.bRX.aD(a);
                this.bTa.bRX.bkY();
                this.bTa.bRW.a(a, this.bTa.bRX);
            }
            if (this.bTa.bSh != null) {
                b.a(this.bTa.bRX, this.bTa.bSh.agx(), 2);
                return;
            }
            return;
        }
        this.bTa.hQ(this.bTa.bRX.bkD());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if (!"normal_page".equals(this.bTa.bSh.ago()) && !"frs_page".equals(this.bTa.bSh.ago()) && !"book_page".equals(this.bTa.bSh.ago())) {
                return;
            }
            this.bTa.a(nVar);
        }
    }
}
