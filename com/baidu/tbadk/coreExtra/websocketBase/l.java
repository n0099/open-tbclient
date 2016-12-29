package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i asf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.asf = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bu(boolean z) {
        List list;
        c.Bs().el(z ? 2 : 1);
        if (z) {
            this.asf.arr = a.Bk().Bn();
            list = this.asf.arr;
            if (list != null) {
                this.asf.fa("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bk().a(new m(this));
                return;
            }
        }
        this.asf.asd = false;
        this.asf.BF();
    }
}
