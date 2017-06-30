package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0043a {
    final /* synthetic */ i axP;
    private final /* synthetic */ String axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.axP = iVar;
        this.axQ = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0043a
    public void BB() {
        List list;
        this.axP.currentIndex = 0;
        this.axP.axb = a.Bv().By();
        list = this.axP.axb;
        if (list == null) {
            this.axP.axN = false;
        } else {
            this.axP.fj(this.axQ);
        }
    }
}
