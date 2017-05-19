package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0041a {
    final /* synthetic */ l axe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.axe = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0041a
    public void Bn() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.axe.axc;
        iVar.currentIndex = 0;
        iVar2 = this.axe.axc;
        iVar2.awo = a.Bh().Bk();
        iVar3 = this.axe.axc;
        list = iVar3.awo;
        if (list != null) {
            iVar5 = this.axe.axc;
            iVar5.eR("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.axe.axc;
        iVar4.axa = false;
    }
}
