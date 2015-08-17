package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i amL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.amL = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void aU(boolean z) {
        List list;
        c.zw().dx(z ? 2 : 1);
        if (z) {
            this.amL.alZ = a.zo().zr();
            list = this.amL.alZ;
            if (list != null) {
                this.amL.es("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zo().a(new m(this));
                return;
            }
        }
        this.amL.amJ = false;
        this.amL.zJ();
    }
}
