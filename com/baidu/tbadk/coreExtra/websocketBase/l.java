package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i amZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.amZ = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void aW(boolean z) {
        List list;
        c.zy().dG(z ? 2 : 1);
        if (z) {
            this.amZ.amn = a.zq().zt();
            list = this.amZ.amn;
            if (list != null) {
                this.amZ.eE("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zq().a(new m(this));
                return;
            }
        }
        this.amZ.amX = false;
        this.amZ.zL();
    }
}
