package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0044a {
    final /* synthetic */ i aox;
    private final /* synthetic */ String aoy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.aox = iVar;
        this.aoy = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zH() {
        List list;
        this.aox.currentIndex = 0;
        this.aox.anL = a.zB().zE();
        list = this.aox.anL;
        if (list == null) {
            this.aox.aov = false;
        } else {
            this.aox.eA(this.aoy);
        }
    }
}
