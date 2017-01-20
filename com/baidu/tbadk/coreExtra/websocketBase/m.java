package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0039a {
    final /* synthetic */ l arm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.arm = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bl() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.arm.ark;
        iVar.currentIndex = 0;
        iVar2 = this.arm.ark;
        iVar2.aqx = a.Bf().Bi();
        iVar3 = this.arm.ark;
        list = iVar3.aqx;
        if (list != null) {
            iVar5 = this.arm.ark;
            iVar5.eX("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.arm.ark;
        iVar4.ari = false;
    }
}
