package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q Qd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.Qd = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void an(boolean z) {
        List list;
        f.qy().cv(z ? 2 : 1);
        if (z) {
            this.Qd.Pq = a.qq().qt();
            list = this.Qd.Pq;
            if (list != null) {
                this.Qd.cU("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.qq().a(new u(this));
                return;
            }
        }
        this.Qd.Qb = false;
        this.Qd.qL();
    }
}
