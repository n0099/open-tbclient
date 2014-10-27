package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q PZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.PZ = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void an(boolean z) {
        List list;
        f.qw().cv(z ? 2 : 1);
        if (z) {
            this.PZ.Pm = a.qo().qr();
            list = this.PZ.Pm;
            if (list != null) {
                this.PZ.cU("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.qo().a(new u(this));
                return;
            }
        }
        this.PZ.PX = false;
        this.PZ.qJ();
    }
}
