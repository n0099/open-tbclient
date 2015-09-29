package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0044a {
    final /* synthetic */ l anb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.anb = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zw() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.anb.amZ;
        iVar.currentIndex = 0;
        iVar2 = this.anb.amZ;
        iVar2.amn = a.zq().zt();
        iVar3 = this.anb.amZ;
        list = iVar3.amn;
        if (list != null) {
            iVar5 = this.anb.amZ;
            iVar5.eE("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.anb.amZ;
        iVar4.amX = false;
    }
}
