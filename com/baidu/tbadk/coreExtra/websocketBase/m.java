package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0046a {
    final /* synthetic */ l aoV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aoV = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0046a
    public void Au() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.aoV.aoT;
        iVar.currentIndex = 0;
        iVar2 = this.aoV.aoT;
        iVar2.aog = a.Ao().Ar();
        iVar3 = this.aoV.aoT;
        list = iVar3.aog;
        if (list != null) {
            iVar5 = this.aoV.aoT;
            iVar5.eO("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.aoV.aoT;
        iVar4.aoR = false;
    }
}
