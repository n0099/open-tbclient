package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* loaded from: classes.dex */
class m implements a.InterfaceC0047a {
    final /* synthetic */ l arJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.arJ = lVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0047a
    public void Cd() {
        i iVar;
        i iVar2;
        i iVar3;
        List list;
        i iVar4;
        i iVar5;
        iVar = this.arJ.arH;
        iVar.currentIndex = 0;
        iVar2 = this.arJ.arH;
        iVar2.aqT = a.BX().Ca();
        iVar3 = this.arJ.arH;
        list = iVar3.aqT;
        if (list != null) {
            iVar5 = this.arJ.arH;
            iVar5.eX("change ip to reconnect with DNS' failed.");
            return;
        }
        iVar4 = this.arJ.arH;
        iVar4.arF = false;
    }
}
