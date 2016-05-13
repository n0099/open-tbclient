package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i anv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.anv = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bp(boolean z) {
        List list;
        c.Aa().dS(z ? 2 : 1);
        if (z) {
            this.anv.amH = a.zS().zV();
            list = this.anv.amH;
            if (list != null) {
                this.anv.eU("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.zS().a(new m(this));
                return;
            }
        }
        this.anv.ant = false;
        this.anv.An();
    }
}
