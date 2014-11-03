package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t Qf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.Qf = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void qw() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.Qf.Qd;
        qVar.currentIndex = 0;
        qVar2 = this.Qf.Qd;
        qVar2.Pq = a.qq().qt();
        qVar3 = this.Qf.Qd;
        list = qVar3.Pq;
        if (list != null) {
            qVar5 = this.Qf.Qd;
            qVar5.cU("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.Qf.Qd;
        qVar4.Qb = false;
    }
}
