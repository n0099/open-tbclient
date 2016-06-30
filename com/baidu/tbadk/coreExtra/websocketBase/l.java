package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i aob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aob = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bm(boolean z) {
        List list;
        c.Af().dU(z ? 2 : 1);
        if (z) {
            this.aob.ann = a.zX().Aa();
            list = this.aob.ann;
            if (list != null) {
                this.aob.eY("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zX().a(new m(this));
                return;
            }
        }
        this.aob.anZ = false;
        this.aob.As();
    }
}
