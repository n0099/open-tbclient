package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements ca {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(r rVar) {
        this.cdl = rVar;
    }

    @Override // com.baidu.tieba.frs.ca
    public void a(int i, int i2, ci ciVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        ca caVar;
        ca caVar2;
        com.baidu.tieba.frs.f.m mVar;
        b bVar2;
        this.cdl.adX();
        bVar = this.cdl.ccB;
        if (bVar != null) {
            mVar = this.cdl.cct;
            bVar2 = this.cdl.ccB;
            mVar.eP(bVar2.iF(i));
        }
        d.a aVar = new d.a();
        if (ciVar != null) {
            aVar.isSuccess = ciVar.errCode == 0;
            aVar.errorCode = ciVar.errCode;
            aVar.errorMsg = ciVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.z.t(arrayList)) {
                    this.cdl.ccj.WU();
                } else if (ciVar.hasMore) {
                    this.cdl.ccj.Vl();
                } else if (ciVar.cfj) {
                    this.cdl.ccj.Vn();
                } else {
                    this.cdl.ccj.WU();
                }
            }
        } else {
            ciVar = new ci();
            ciVar.pn = 1;
            ciVar.hasMore = false;
            ciVar.cfj = false;
        }
        if (i == 1) {
            this.cdl.ccr = true;
            this.cdl.ccY.a(this.cdl.ccs.getType(), false, aVar);
        } else {
            this.cdl.a(aVar, true);
            if (this.cdl.ccs.agC() != null) {
                this.cdl.cbN = this.cdl.ccs.agC();
            }
            this.cdl.aef();
        }
        caVar = this.cdl.cdj;
        if (caVar == null) {
            return;
        }
        caVar2 = this.cdl.cdj;
        caVar2.a(i, i2, ciVar, arrayList);
    }
}
