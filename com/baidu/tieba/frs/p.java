package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class p implements cf {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cf
    public void a(int i, int i2, cp cpVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        cf cfVar;
        cf cfVar2;
        com.baidu.tieba.frs.j.n nVar;
        b bVar2;
        this.bTa.acd();
        bVar = this.bTa.bSu;
        if (bVar != null) {
            nVar = this.bTa.bSi;
            bVar2 = this.bTa.bSu;
            nVar.ev(bVar2.ie(i));
        }
        e.a aVar = new e.a();
        if (cpVar != null) {
            aVar.isSuccess = cpVar.errCode == 0;
            aVar.errorCode = cpVar.errCode;
            aVar.errorMsg = cpVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.x.t(arrayList)) {
                    this.bTa.bRW.adj();
                } else if (cpVar.hasMore) {
                    this.bTa.bRW.adi();
                } else if (cpVar.bVL) {
                    this.bTa.bRW.JM();
                } else {
                    this.bTa.bRW.adj();
                }
            }
        } else {
            cpVar = new cp();
            cpVar.pn = 1;
            cpVar.hasMore = false;
            cpVar.bVL = false;
        }
        if (i == 1) {
            this.bTa.bSg = true;
            this.bTa.bSM.a(this.bTa.bSh.getType(), false, aVar);
        } else {
            this.bTa.a(aVar, true);
            if (this.bTa.bSh.afE() != null) {
                this.bTa.bRX = this.bTa.bSh.afE();
            }
            this.bTa.ack();
        }
        cfVar = this.bTa.bSZ;
        if (cfVar == null) {
            return;
        }
        cfVar2 = this.bTa.bSZ;
        cfVar2.a(i, i2, cpVar, arrayList);
    }
}
