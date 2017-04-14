package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0037a {
    final /* synthetic */ l awX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.awX = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0037a
    public void Cc() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.awX.awV;
        iVar.currentIndex = 0;
        iVar2 = this.awX.awV;
        iVar2.awi = a.BW().BZ();
        iVar3 = this.awX.awV;
        list = iVar3.awi;
        if (list != null) {
            iVar5 = this.awX.awV;
            iVar5.eS("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.awX.awV;
        iVar4.awT = false;
    }
}
