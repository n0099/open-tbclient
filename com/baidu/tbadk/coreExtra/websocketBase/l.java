package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aoT = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bb(boolean z) {
        List list;
        c.Aw().dV(z ? 2 : 1);
        if (z) {
            this.aoT.aog = a.Ao().Ar();
            list = this.aoT.aog;
            if (list != null) {
                this.aoT.eO("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Ao().a(new m(this));
                return;
            }
        }
        this.aoT.aoR = false;
        this.aoT.AJ();
    }
}
