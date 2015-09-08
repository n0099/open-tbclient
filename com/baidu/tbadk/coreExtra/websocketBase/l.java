package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i aox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aox = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bb(boolean z) {
        List list;
        c.zJ().dF(z ? 2 : 1);
        if (z) {
            this.aox.anL = a.zB().zE();
            list = this.aox.anL;
            if (list != null) {
                this.aox.eA("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zB().a(new m(this));
                return;
            }
        }
        this.aox.aov = false;
        this.aox.zW();
    }
}
