package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements ce {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        ce ceVar;
        ce ceVar2;
        com.baidu.tieba.frs.g.u uVar;
        b bVar2;
        this.bNJ.Zd();
        bVar = this.bNJ.bNa;
        if (bVar != null) {
            uVar = this.bNJ.bMP;
            bVar2 = this.bNJ.bNa;
            uVar.ek(bVar2.hZ(i));
        }
        d.a aVar = new d.a();
        if (coVar != null) {
            aVar.isSuccess = coVar.errCode == 0;
            aVar.errorCode = coVar.errCode;
            aVar.errorMsg = coVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.x.q(arrayList)) {
                    this.bNJ.bMD.Ug();
                } else if (coVar.hasMore) {
                    this.bNJ.bMD.aai();
                } else if (coVar.bQj) {
                    this.bNJ.bMD.KA();
                } else {
                    this.bNJ.bMD.Ug();
                }
            }
        } else {
            coVar = new co();
            coVar.pn = 1;
            coVar.hasMore = false;
            coVar.bQj = false;
        }
        if (i == 1) {
            this.bNJ.bMN = true;
            this.bNJ.bNu.a(this.bNJ.bMO.getType(), false, aVar);
        } else {
            this.bNJ.a(aVar, true);
            if (this.bNJ.bMO.acy() != null) {
                this.bNJ.bME = this.bNJ.bMO.acy();
            }
            this.bNJ.Zk();
        }
        ceVar = this.bNJ.bNI;
        if (ceVar == null) {
            return;
        }
        ceVar2 = this.bNJ.bNI;
        ceVar2.a(i, i2, coVar, arrayList);
    }
}
