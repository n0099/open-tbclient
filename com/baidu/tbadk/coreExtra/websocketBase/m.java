package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0044a {
    final /* synthetic */ l anc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.anc = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zw() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.anc.ana;
        iVar.currentIndex = 0;
        iVar2 = this.anc.ana;
        iVar2.amo = a.zq().zt();
        iVar3 = this.anc.ana;
        list = iVar3.amo;
        if (list != null) {
            iVar5 = this.anc.ana;
            iVar5.eE("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.anc.ana;
        iVar4.amY = false;
    }
}
