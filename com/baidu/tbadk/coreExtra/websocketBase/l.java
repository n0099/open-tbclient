package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i axc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.axc = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bv(boolean z) {
        List list;
        c.Bp().ei(z ? 2 : 1);
        if (z) {
            this.axc.awo = a.Bh().Bk();
            list = this.axc.awo;
            if (list != null) {
                this.axc.eR("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bh().a(new m(this));
                return;
            }
        }
        this.axc.axa = false;
        this.axc.BC();
    }
}
