package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0039a {
    final /* synthetic */ l aoS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aoS = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Ad() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.aoS.aoQ;
        iVar.currentIndex = 0;
        iVar2 = this.aoS.aoQ;
        iVar2.aoc = a.zX().Aa();
        iVar3 = this.aoS.aoQ;
        list = iVar3.aoc;
        if (list != null) {
            iVar5 = this.aoS.aoQ;
            iVar5.eW("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.aoS.aoQ;
        iVar4.aoO = false;
    }
}
