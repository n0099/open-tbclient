package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0037a {
    final /* synthetic */ i awX;
    private final /* synthetic */ String awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.awX = iVar;
        this.awY = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0037a
    public void Cc() {
        List list;
        this.awX.currentIndex = 0;
        this.awX.awk = a.BW().BZ();
        list = this.awX.awk;
        if (list == null) {
            this.awX.awV = false;
        } else {
            this.awX.eS(this.awY);
        }
    }
}
