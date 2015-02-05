package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q Wq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.Wq = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void aD(boolean z) {
        List list;
        f.uc().db(z ? 2 : 1);
        if (z) {
            this.Wq.VE = a.tU().tX();
            list = this.Wq.VE;
            if (list != null) {
                this.Wq.dM("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.tU().a(new u(this));
                return;
            }
        }
        this.Wq.Wo = false;
        this.Wq.uo();
    }
}
