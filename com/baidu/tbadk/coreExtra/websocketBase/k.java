package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0041a {
    final /* synthetic */ i axc;
    private final /* synthetic */ String axd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.axc = iVar;
        this.axd = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0041a
    public void Bn() {
        List list;
        this.axc.currentIndex = 0;
        this.axc.awo = a.Bh().Bk();
        list = this.axc.awo;
        if (list == null) {
            this.axc.axa = false;
        } else {
            this.axc.eR(this.axd);
        }
    }
}
