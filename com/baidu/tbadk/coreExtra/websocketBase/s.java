package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q Wt;
    private final /* synthetic */ String Wu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.Wt = qVar;
        this.Wu = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void ug() {
        List list;
        this.Wt.currentIndex = 0;
        this.Wt.VH = a.ua().ud();
        list = this.Wt.VH;
        if (list == null) {
            this.Wt.Wr = false;
        } else {
            this.Wt.dP(this.Wu);
        }
    }
}
