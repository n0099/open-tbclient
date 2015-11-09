package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0044a {
    final /* synthetic */ i anf;
    private final /* synthetic */ String ang;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.anf = iVar;
        this.ang = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zy() {
        List list;
        this.anf.currentIndex = 0;
        this.anf.amt = a.zs().zv();
        list = this.anf.amt;
        if (list == null) {
            this.anf.and = false;
        } else {
            this.anf.eE(this.ang);
        }
    }
}
