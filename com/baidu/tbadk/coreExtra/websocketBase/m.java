package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0039a {
    final /* synthetic */ l arZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.arZ = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bs() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.arZ.arX;
        iVar.currentIndex = 0;
        iVar2 = this.arZ.arX;
        iVar2.arj = a.Bm().Bp();
        iVar3 = this.arZ.arX;
        list = iVar3.arj;
        if (list != null) {
            iVar5 = this.arZ.arX;
            iVar5.eZ("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.arZ.arX;
        iVar4.arV = false;
    }
}
