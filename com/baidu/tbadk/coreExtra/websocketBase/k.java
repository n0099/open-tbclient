package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0047a {
    final /* synthetic */ i arq;
    private final /* synthetic */ String arr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.arq = iVar;
        this.arr = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0047a
    public void BA() {
        List list;
        this.arq.currentIndex = 0;
        this.arq.aqC = a.Bu().Bx();
        list = this.arq.aqC;
        if (list == null) {
            this.arq.aro = false;
        } else {
            this.arq.eQ(this.arr);
        }
    }
}
