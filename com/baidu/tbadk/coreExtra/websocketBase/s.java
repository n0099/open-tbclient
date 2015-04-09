package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ q agE;
    private final /* synthetic */ String agF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str) {
        this.agE = qVar;
        this.agF = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void xx() {
        List list;
        this.agE.currentIndex = 0;
        this.agE.afS = a.xr().xu();
        list = this.agE.afS;
        if (list == null) {
            this.agE.agC = false;
        } else {
            this.agE.dY(this.agF);
        }
    }
}
