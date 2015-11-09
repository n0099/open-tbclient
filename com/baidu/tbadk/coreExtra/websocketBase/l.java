package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i anf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.anf = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void aW(boolean z) {
        List list;
        c.zA().dG(z ? 2 : 1);
        if (z) {
            this.anf.amt = a.zs().zv();
            list = this.anf.amt;
            if (list != null) {
                this.anf.eE("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zs().a(new m(this));
                return;
            }
        }
        this.anf.and = false;
        this.anf.zN();
    }
}
