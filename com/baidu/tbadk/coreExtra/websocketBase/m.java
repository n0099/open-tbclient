package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0039a {
    final /* synthetic */ l asE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.asE = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void BD() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.asE.asC;
        iVar.currentIndex = 0;
        iVar2 = this.asE.asC;
        iVar2.arO = a.Bx().BA();
        iVar3 = this.asE.asC;
        list = iVar3.arO;
        if (list != null) {
            iVar5 = this.asE.asC;
            iVar5.fe("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.asE.asC;
        iVar4.asA = false;
    }
}
