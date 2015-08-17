package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0044a {
    final /* synthetic */ l amN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.amN = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zu() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.amN.amL;
        iVar.currentIndex = 0;
        iVar2 = this.amN.amL;
        iVar2.alZ = a.zo().zr();
        iVar3 = this.amN.amL;
        list = iVar3.alZ;
        if (list != null) {
            iVar5 = this.amN.amL;
            iVar5.es("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.amN.amL;
        iVar4.amJ = false;
    }
}
