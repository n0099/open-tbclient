package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t agy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.agy = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void xr() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.agy.agw;
        qVar.currentIndex = 0;
        qVar2 = this.agy.agw;
        qVar2.afK = a.xl().xo();
        qVar3 = this.agy.agw;
        list = qVar3.afK;
        if (list != null) {
            qVar5 = this.agy.agw;
            qVar5.dV("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.agy.agw;
        qVar4.agu = false;
    }
}
