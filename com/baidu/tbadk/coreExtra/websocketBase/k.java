package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0044a {
    final /* synthetic */ i ana;
    private final /* synthetic */ String anb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.ana = iVar;
        this.anb = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zt() {
        List list;
        this.ana.currentIndex = 0;
        this.ana.amo = a.zn().zq();
        list = this.ana.amo;
        if (list == null) {
            this.ana.amY = false;
        } else {
            this.ana.eE(this.anb);
        }
    }
}
