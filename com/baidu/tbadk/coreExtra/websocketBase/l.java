package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i arI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.arI = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bq(boolean z) {
        List list;
        c.By().ei(z ? 2 : 1);
        if (z) {
            this.arI.aqU = a.Bq().Bt();
            list = this.arI.aqU;
            if (list != null) {
                this.arI.fc("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bq().a(new m(this));
                return;
            }
        }
        this.arI.arG = false;
        this.arI.BL();
    }
}
