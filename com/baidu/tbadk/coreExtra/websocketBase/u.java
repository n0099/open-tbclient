package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t Wv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.Wv = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void ug() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.Wv.Wt;
        qVar.currentIndex = 0;
        qVar2 = this.Wv.Wt;
        qVar2.VH = a.ua().ud();
        qVar3 = this.Wv.Wt;
        list = qVar3.VH;
        if (list != null) {
            qVar5 = this.Wv.Wt;
            qVar5.dP("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.Wv.Wt;
        qVar4.Wr = false;
    }
}
