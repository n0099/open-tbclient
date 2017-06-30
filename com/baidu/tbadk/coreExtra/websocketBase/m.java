package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0043a {
    final /* synthetic */ l axR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.axR = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0043a
    public void BB() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.axR.axP;
        iVar.currentIndex = 0;
        iVar2 = this.axR.axP;
        iVar2.axb = a.Bv().By();
        iVar3 = this.axR.axP;
        list = iVar3.axb;
        if (list != null) {
            iVar5 = this.axR.axP;
            iVar5.fj("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.axR.axP;
        iVar4.axN = false;
    }
}
