package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t Ws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.Ws = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void ua() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.Ws.Wq;
        qVar.currentIndex = 0;
        qVar2 = this.Ws.Wq;
        qVar2.VE = a.tU().tX();
        qVar3 = this.Ws.Wq;
        list = qVar3.VE;
        if (list != null) {
            qVar5 = this.Ws.Wq;
            qVar5.dM("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.Ws.Wq;
        qVar4.Wo = false;
    }
}
