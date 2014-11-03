package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q Qd;
    private final /* synthetic */ String Qe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.Qd = qVar;
        this.Qe = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void qw() {
        List list;
        this.Qd.currentIndex = 0;
        this.Qd.Pq = a.qq().qt();
        list = this.Qd.Pq;
        if (list == null) {
            this.Qd.Qb = false;
        } else {
            this.Qd.cU(this.Qe);
        }
    }
}
