package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t Qb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.Qb = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void qu() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.Qb.PZ;
        qVar.currentIndex = 0;
        qVar2 = this.Qb.PZ;
        qVar2.Pm = a.qo().qr();
        qVar3 = this.Qb.PZ;
        list = qVar3.Pm;
        if (list != null) {
            qVar5 = this.Qb.PZ;
            qVar5.cU("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.Qb.PZ;
        qVar4.PX = false;
    }
}
