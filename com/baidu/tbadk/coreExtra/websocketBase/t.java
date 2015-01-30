package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q Wt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.Wt = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void aD(boolean z) {
        List list;
        f.ui().db(z ? 2 : 1);
        if (z) {
            this.Wt.VH = a.ua().ud();
            list = this.Wt.VH;
            if (list != null) {
                this.Wt.dP("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.ua().a(new u(this));
                return;
            }
        }
        this.Wt.Wr = false;
        this.Wt.uu();
    }
}
