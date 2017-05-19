package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements by {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(r rVar) {
        this.bPn = rVar;
    }

    @Override // com.baidu.tieba.frs.by
    public void a(int i, int i2, cg cgVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        by byVar;
        by byVar2;
        com.baidu.tieba.frs.e.u uVar;
        b bVar2;
        this.bPn.Zc();
        bVar = this.bPn.bOG;
        if (bVar != null) {
            uVar = this.bPn.bOx;
            bVar2 = this.bPn.bOG;
            uVar.ei(bVar2.hV(i));
        }
        d.a aVar = new d.a();
        if (cgVar != null) {
            aVar.isSuccess = cgVar.errCode == 0;
            aVar.errorCode = cgVar.errCode;
            aVar.errorMsg = cgVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.x.r(arrayList)) {
                    this.bPn.bOn.UA();
                } else if (cgVar.hasMore) {
                    this.bPn.bOn.ZS();
                } else if (cgVar.bRk) {
                    this.bPn.bOn.JO();
                } else {
                    this.bPn.bOn.UA();
                }
            }
        } else {
            cgVar = new cg();
            cgVar.pn = 1;
            cgVar.hasMore = false;
            cgVar.bRk = false;
        }
        if (i == 1) {
            this.bPn.bOv = true;
            this.bPn.bPb.a(this.bPn.bOw.getType(), false, aVar);
        } else {
            this.bPn.a(aVar, true);
            if (this.bPn.bOw.abG() != null) {
                this.bPn.bNT = this.bPn.bOw.abG();
            }
            this.bPn.Zk();
        }
        byVar = this.bPn.bPm;
        if (byVar == null) {
            return;
        }
        byVar2 = this.bPn.bPm;
        byVar2.a(i, i2, cgVar, arrayList);
    }
}
