package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0044a {
    final /* synthetic */ i amL;
    private final /* synthetic */ String amM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.amL = iVar;
        this.amM = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0044a
    public void zu() {
        List list;
        this.amL.currentIndex = 0;
        this.amL.alZ = a.zo().zr();
        list = this.amL.alZ;
        if (list == null) {
            this.amL.amJ = false;
        } else {
            this.amL.es(this.amM);
        }
    }
}
