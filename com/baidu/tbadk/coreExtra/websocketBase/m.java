package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0047a {
    final /* synthetic */ l ars;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.ars = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0047a
    public void BA() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.ars.arq;
        iVar.currentIndex = 0;
        iVar2 = this.ars.arq;
        iVar2.aqC = a.Bu().Bx();
        iVar3 = this.ars.arq;
        list = iVar3.aqC;
        if (list != null) {
            iVar5 = this.ars.arq;
            iVar5.eQ("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.ars.arq;
        iVar4.aro = false;
    }
}
