package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i arq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.arq = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bc(boolean z) {
        List list;
        c.BC().ek(z ? 2 : 1);
        if (z) {
            this.arq.aqC = a.Bu().Bx();
            list = this.arq.aqC;
            if (list != null) {
                this.arq.eQ("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bu().a(new m(this));
                return;
            }
        }
        this.arq.aro = false;
        this.arq.BP();
    }
}
