package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class o implements cc {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cc
    public void a(int i, int i2, cm cmVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        cc ccVar;
        cc ccVar2;
        com.baidu.tieba.frs.f.u uVar;
        b bVar2;
        this.bGL.XI();
        bVar = this.bGL.bGd;
        if (bVar != null) {
            uVar = this.bGL.bFR;
            bVar2 = this.bGL.bGd;
            uVar.ek(bVar2.ia(i));
        }
        d.a aVar = new d.a();
        if (cmVar != null) {
            aVar.isSuccess = cmVar.errCode == 0;
            aVar.errorCode = cmVar.errCode;
            aVar.errorMsg = cmVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.w.s(arrayList)) {
                    this.bGL.bFF.SI();
                } else if (cmVar.hasMore) {
                    this.bGL.bFF.YL();
                } else if (cmVar.bJl) {
                    this.bGL.bFF.Jv();
                } else {
                    this.bGL.bFF.SI();
                }
            }
        } else {
            cmVar = new cm();
            cmVar.pn = 1;
            cmVar.hasMore = false;
            cmVar.bJl = false;
        }
        if (i == 1) {
            this.bGL.bFP = true;
            this.bGL.bGw.a(this.bGL.bFQ.getType(), false, aVar);
        } else {
            this.bGL.a(aVar, true);
            if (this.bGL.bFQ.abf() != null) {
                this.bGL.bFG = this.bGL.bFQ.abf();
            }
            this.bGL.XP();
        }
        ccVar = this.bGL.bGK;
        if (ccVar == null) {
            return;
        }
        ccVar2 = this.bGL.bGK;
        ccVar2.a(i, i2, cmVar, arrayList);
    }
}
