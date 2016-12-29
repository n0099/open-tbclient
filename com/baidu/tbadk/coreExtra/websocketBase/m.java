package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0039a {
    final /* synthetic */ l ash;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.ash = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bq() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.ash.asf;
        iVar.currentIndex = 0;
        iVar2 = this.ash.asf;
        iVar2.arr = a.Bk().Bn();
        iVar3 = this.ash.asf;
        list = iVar3.arr;
        if (list != null) {
            iVar5 = this.ash.asf;
            iVar5.fa("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.ash.asf;
        iVar4.asd = false;
    }
}
