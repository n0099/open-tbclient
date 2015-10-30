package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i ana;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.ana = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void aW(boolean z) {
        List list;
        c.zv().dG(z ? 2 : 1);
        if (z) {
            this.ana.amo = a.zn().zq();
            list = this.ana.amo;
            if (list != null) {
                this.ana.eE("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zn().a(new m(this));
                return;
            }
        }
        this.ana.amY = false;
        this.ana.zI();
    }
}
