package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t VQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.VQ = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void tP() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.VQ.VO;
        qVar.currentIndex = 0;
        qVar2 = this.VQ.VO;
        qVar2.Vc = a.tJ().tM();
        qVar3 = this.VQ.VO;
        list = qVar3.Vc;
        if (list != null) {
            qVar5 = this.VQ.VO;
            qVar5.dQ("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.VQ.VO;
        qVar4.VM = false;
    }
}
