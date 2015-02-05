package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q Wq;
    private final /* synthetic */ String Wr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.Wq = qVar;
        this.Wr = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void ua() {
        List list;
        this.Wq.currentIndex = 0;
        this.Wq.VE = a.tU().tX();
        list = this.Wq.VE;
        if (list == null) {
            this.Wq.Wo = false;
        } else {
            this.Wq.dM(this.Wr);
        }
    }
}
