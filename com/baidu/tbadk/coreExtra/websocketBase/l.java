package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i asC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.asC = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bu(boolean z) {
        List list;
        c.BF().ek(z ? 2 : 1);
        if (z) {
            this.asC.arO = a.Bx().BA();
            list = this.asC.arO;
            if (list != null) {
                this.asC.fe("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bx().a(new m(this));
                return;
            }
        }
        this.asC.asA = false;
        this.asC.BS();
    }
}
