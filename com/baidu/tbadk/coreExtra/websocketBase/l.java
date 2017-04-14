package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.awV = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bv(boolean z) {
        List list;
        c.Ce().ek(z ? 2 : 1);
        if (z) {
            this.awV.awi = a.BW().BZ();
            list = this.awV.awi;
            if (list != null) {
                this.awV.eS("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.BW().a(new m(this));
                return;
            }
        }
        this.awV.awT = false;
        this.awV.Cr();
    }
}
