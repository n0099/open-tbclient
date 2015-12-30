package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0046a {
    final /* synthetic */ l aqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aqz = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0046a
    public void Ak() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.aqz.aqx;
        iVar.currentIndex = 0;
        iVar2 = this.aqz.aqx;
        iVar2.apK = a.Ae().Ah();
        iVar3 = this.aqz.aqx;
        list = iVar3.apK;
        if (list != null) {
            iVar5 = this.aqz.aqx;
            iVar5.eR("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.aqz.aqx;
        iVar4.aqv = false;
    }
}
