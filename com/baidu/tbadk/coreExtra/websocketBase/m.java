package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0044a {
    final /* synthetic */ l anh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.anh = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zy() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.anh.anf;
        iVar.currentIndex = 0;
        iVar2 = this.anh.anf;
        iVar2.amt = a.zs().zv();
        iVar3 = this.anh.anf;
        list = iVar3.amt;
        if (list != null) {
            iVar5 = this.anh.anf;
            iVar5.eE("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.anh.anf;
        iVar4.and = false;
    }
}
