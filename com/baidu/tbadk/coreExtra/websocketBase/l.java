package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i awX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.awX = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bv(boolean z) {
        List list;
        c.Ce().ek(z ? 2 : 1);
        if (z) {
            this.awX.awk = a.BW().BZ();
            list = this.awX.awk;
            if (list != null) {
                this.awX.eS("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.BW().a(new m(this));
                return;
            }
        }
        this.awX.awV = false;
        this.awX.Cr();
    }
}
