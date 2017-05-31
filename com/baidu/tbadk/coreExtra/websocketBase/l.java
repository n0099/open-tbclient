package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i awM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.awM = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bs(boolean z) {
        List list;
        c.Bi().ej(z ? 2 : 1);
        if (z) {
            this.awM.avY = a.Ba().Bd();
            list = this.awM.avY;
            if (list != null) {
                this.awM.eP("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Ba().a(new m(this));
                return;
            }
        }
        this.awM.awK = false;
        this.awM.Bv();
    }
}
