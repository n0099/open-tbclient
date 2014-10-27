package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q PZ;
    private final /* synthetic */ String Qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.PZ = qVar;
        this.Qa = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void qu() {
        List list;
        this.PZ.currentIndex = 0;
        this.PZ.Pm = a.qo().qr();
        list = this.PZ.Pm;
        if (list == null) {
            this.PZ.PX = false;
        } else {
            this.PZ.cU(this.Qa);
        }
    }
}
