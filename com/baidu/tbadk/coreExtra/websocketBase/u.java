package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t agG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.agG = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void xx() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.agG.agE;
        qVar.currentIndex = 0;
        qVar2 = this.agG.agE;
        qVar2.afS = a.xr().xu();
        qVar3 = this.agG.agE;
        list = qVar3.afS;
        if (list != null) {
            qVar5 = this.agG.agE;
            qVar5.dY("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.agG.agE;
        qVar4.agC = false;
    }
}
