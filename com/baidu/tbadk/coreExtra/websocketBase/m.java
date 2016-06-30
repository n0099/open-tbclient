package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0038a {
    final /* synthetic */ l aod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aod = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0038a
    public void Ad() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.aod.aob;
        iVar.currentIndex = 0;
        iVar2 = this.aod.aob;
        iVar2.ann = a.zX().Aa();
        iVar3 = this.aod.aob;
        list = iVar3.ann;
        if (list != null) {
            iVar5 = this.aod.aob;
            iVar5.eY("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.aod.aob;
        iVar4.anZ = false;
    }
}
