package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0038a {
    final /* synthetic */ l anx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.anx = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0038a
    public void zX() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.anx.anv;
        iVar.currentIndex = 0;
        iVar2 = this.anx.anv;
        iVar2.amH = a.zR().zU();
        iVar3 = this.anx.anv;
        list = iVar3.amH;
        if (list != null) {
            iVar5 = this.anx.anv;
            iVar5.eU("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.anx.anv;
        iVar4.ant = false;
    }
}
