package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0038a {
    final /* synthetic */ i anv;
    private final /* synthetic */ String anw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.anv = iVar;
        this.anw = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0038a
    public void zY() {
        List list;
        this.anv.currentIndex = 0;
        this.anv.amH = a.zS().zV();
        list = this.anv.amH;
        if (list == null) {
            this.anv.ant = false;
        } else {
            this.anv.eU(this.anw);
        }
    }
}
