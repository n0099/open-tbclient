package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0044a {
    final /* synthetic */ i amZ;
    private final /* synthetic */ String ana;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.amZ = iVar;
        this.ana = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zw() {
        List list;
        this.amZ.currentIndex = 0;
        this.amZ.amn = a.zq().zt();
        list = this.amZ.amn;
        if (list == null) {
            this.amZ.amX = false;
        } else {
            this.amZ.eE(this.ana);
        }
    }
}
