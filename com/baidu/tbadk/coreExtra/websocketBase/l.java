package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements e.b {
    final /* synthetic */ i arX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.arX = iVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.e.b
    public void br(boolean z) {
        List list;
        c.Bu().ei(z ? 2 : 1);
        if (z) {
            this.arX.arj = a.Bm().Bp();
            list = this.arX.arj;
            if (list != null) {
                this.arX.eZ("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.Bm().a(new m(this));
                return;
            }
        }
        this.arX.arV = false;
        this.arX.BH();
    }
}
