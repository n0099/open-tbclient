package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0038a {
    final /* synthetic */ i awF;
    private final /* synthetic */ String awG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.awF = iVar;
        this.awG = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0038a
    public void BE() {
        List list;
        this.awF.currentIndex = 0;
        this.awF.avS = a.By().BB();
        list = this.awF.avS;
        if (list == null) {
            this.awF.awD = false;
        } else {
            this.awF.eM(this.awG);
        }
    }
}
