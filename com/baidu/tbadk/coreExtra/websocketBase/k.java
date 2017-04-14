package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0037a {
    final /* synthetic */ i awV;
    private final /* synthetic */ String awW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.awV = iVar;
        this.awW = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0037a
    public void Cc() {
        List list;
        this.awV.currentIndex = 0;
        this.awV.awi = a.BW().BZ();
        list = this.awV.awi;
        if (list == null) {
            this.awV.awT = false;
        } else {
            this.awV.eS(this.awW);
        }
    }
}
