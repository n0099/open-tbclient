package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0039a {
    final /* synthetic */ i arX;
    private final /* synthetic */ String arY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.arX = iVar;
        this.arY = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bs() {
        List list;
        this.arX.currentIndex = 0;
        this.arX.arj = a.Bm().Bp();
        list = this.arX.arj;
        if (list == null) {
            this.arX.arV = false;
        } else {
            this.arX.eZ(this.arY);
        }
    }
}
