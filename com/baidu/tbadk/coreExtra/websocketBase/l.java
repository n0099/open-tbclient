package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i awF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.awF = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void bt(boolean z) {
        List list;
        c.BG().eh(z ? 2 : 1);
        if (z) {
            this.awF.avS = a.By().BB();
            list = this.awF.avS;
            if (list != null) {
                this.awF.eM("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.By().a(new m(this));
                return;
            }
        }
        this.awF.awD = false;
        this.awF.BT();
    }
}
