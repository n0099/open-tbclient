package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0037a {
    final /* synthetic */ l awZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.awZ = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0037a
    public void Cc() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.awZ.awX;
        iVar.currentIndex = 0;
        iVar2 = this.awZ.awX;
        iVar2.awk = a.BW().BZ();
        iVar3 = this.awZ.awX;
        list = iVar3.awk;
        if (list != null) {
            iVar5 = this.awZ.awX;
            iVar5.eS("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.awZ.awX;
        iVar4.awV = false;
    }
}
