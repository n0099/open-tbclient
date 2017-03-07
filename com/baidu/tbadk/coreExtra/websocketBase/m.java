package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0038a {
    final /* synthetic */ l awH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.awH = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0038a
    public void BE() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.awH.awF;
        iVar.currentIndex = 0;
        iVar2 = this.awH.awF;
        iVar2.avS = a.By().BB();
        iVar3 = this.awH.awF;
        list = iVar3.avS;
        if (list != null) {
            iVar5 = this.awH.awF;
            iVar5.eM("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.awH.awF;
        iVar4.awD = false;
    }
}
