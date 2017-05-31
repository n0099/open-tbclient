package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0041a {
    final /* synthetic */ l awO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.awO = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0041a
    public void Bg() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.awO.awM;
        iVar.currentIndex = 0;
        iVar2 = this.awO.awM;
        iVar2.avY = a.Ba().Bd();
        iVar3 = this.awO.awM;
        list = iVar3.avY;
        if (list != null) {
            iVar5 = this.awO.awM;
            iVar5.eP("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.awO.awM;
        iVar4.awK = false;
    }
}
