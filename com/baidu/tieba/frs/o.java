package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements ce {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        ce ceVar;
        ce ceVar2;
        com.baidu.tieba.frs.g.u uVar;
        b bVar2;
        this.bQa.aae();
        bVar = this.bQa.bPr;
        if (bVar != null) {
            uVar = this.bQa.bPg;
            bVar2 = this.bQa.bPr;
            uVar.eu(bVar2.mo19if(i));
        }
        d.a aVar = new d.a();
        if (coVar != null) {
            aVar.isSuccess = coVar.errCode == 0;
            aVar.errorCode = coVar.errCode;
            aVar.errorMsg = coVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.x.q(arrayList)) {
                    this.bQa.bOU.Vh();
                } else if (coVar.hasMore) {
                    this.bQa.bOU.abj();
                } else if (coVar.bSA) {
                    this.bQa.bOU.KA();
                } else {
                    this.bQa.bOU.Vh();
                }
            }
        } else {
            coVar = new co();
            coVar.pn = 1;
            coVar.hasMore = false;
            coVar.bSA = false;
        }
        if (i == 1) {
            this.bQa.bPe = true;
            this.bQa.bPL.a(this.bQa.bPf.getType(), false, aVar);
        } else {
            this.bQa.a(aVar, true);
            if (this.bQa.bPf.adz() != null) {
                this.bQa.bOV = this.bQa.bPf.adz();
            }
            this.bQa.aal();
        }
        ceVar = this.bQa.bPZ;
        if (ceVar == null) {
            return;
        }
        ceVar2 = this.bQa.bPZ;
        ceVar2.a(i, i2, coVar, arrayList);
    }
}
