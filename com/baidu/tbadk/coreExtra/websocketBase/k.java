package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0039a {
    final /* synthetic */ i asC;
    private final /* synthetic */ String asD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.asC = iVar;
        this.asD = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void BD() {
        List list;
        this.asC.currentIndex = 0;
        this.asC.arO = a.Bx().BA();
        list = this.asC.arO;
        if (list == null) {
            this.asC.asA = false;
        } else {
            this.asC.fe(this.asD);
        }
    }
}
