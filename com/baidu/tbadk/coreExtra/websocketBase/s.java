package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q agw;
    private final /* synthetic */ String agx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.agw = qVar;
        this.agx = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void xr() {
        List list;
        this.agw.currentIndex = 0;
        this.agw.afK = a.xl().xo();
        list = this.agw.afK;
        if (list == null) {
            this.agw.agu = false;
        } else {
            this.agw.dV(this.agx);
        }
    }
}
