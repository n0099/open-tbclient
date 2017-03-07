package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements cc {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cc
    public void a(int i, int i2, cm cmVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        cc ccVar;
        cc ccVar2;
        com.baidu.tieba.frs.f.u uVar;
        b bVar2;
        this.bNU.YH();
        bVar = this.bNU.bNl;
        if (bVar != null) {
            uVar = this.bNU.bMZ;
            bVar2 = this.bNU.bNl;
            uVar.ek(bVar2.hW(i));
        }
        d.a aVar = new d.a();
        if (cmVar != null) {
            aVar.isSuccess = cmVar.errCode == 0;
            aVar.errorCode = cmVar.errCode;
            aVar.errorMsg = cmVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.x.q(arrayList)) {
                    this.bNU.bMN.TI();
                } else if (cmVar.hasMore) {
                    this.bNU.bMN.ZK();
                } else if (cmVar.bQu) {
                    this.bNU.bMN.Ka();
                } else {
                    this.bNU.bMN.TI();
                }
            }
        } else {
            cmVar = new cm();
            cmVar.pn = 1;
            cmVar.hasMore = false;
            cmVar.bQu = false;
        }
        if (i == 1) {
            this.bNU.bMX = true;
            this.bNU.bNF.a(this.bNU.bMY.getType(), false, aVar);
        } else {
            this.bNU.a(aVar, true);
            if (this.bNU.bMY.acc() != null) {
                this.bNU.bMO = this.bNU.bMY.acc();
            }
            this.bNU.YO();
        }
        ccVar = this.bNU.bNT;
        if (ccVar == null) {
            return;
        }
        ccVar2 = this.bNU.bNT;
        ccVar2.a(i, i2, cmVar, arrayList);
    }
}
