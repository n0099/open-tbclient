package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0044a {
    final /* synthetic */ l aoz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aoz = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zH() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.aoz.aox;
        iVar.currentIndex = 0;
        iVar2 = this.aoz.aox;
        iVar2.anL = a.zB().zE();
        iVar3 = this.aoz.aox;
        list = iVar3.anL;
        if (list != null) {
            iVar5 = this.aoz.aox;
            iVar5.eA("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.aoz.aox;
        iVar4.aov = false;
    }
}
