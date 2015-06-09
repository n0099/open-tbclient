package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t ahH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.ahH = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void yl() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.ahH.ahF;
        qVar.currentIndex = 0;
        qVar2 = this.ahH.ahF;
        qVar2.agT = a.yf().yi();
        qVar3 = this.ahH.ahF;
        list = qVar3.agT;
        if (list != null) {
            qVar5 = this.ahH.ahF;
            qVar5.ep("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.ahH.ahF;
        qVar4.ahD = false;
    }
}
