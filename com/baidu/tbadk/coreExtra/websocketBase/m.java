package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0039a {
    final /* synthetic */ l arK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.arK = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bw() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.arK.arI;
        iVar.currentIndex = 0;
        iVar2 = this.arK.arI;
        iVar2.aqU = a.Bq().Bt();
        iVar3 = this.arK.arI;
        list = iVar3.aqU;
        if (list != null) {
            iVar5 = this.arK.arI;
            iVar5.fc("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.arK.arI;
        iVar4.arG = false;
    }
}
