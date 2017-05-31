package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0041a {
    final /* synthetic */ i awM;
    private final /* synthetic */ String awN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.awM = iVar;
        this.awN = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0041a
    public void Bg() {
        List list;
        this.awM.currentIndex = 0;
        this.awM.avY = a.Ba().Bd();
        list = this.awM.avY;
        if (list == null) {
            this.awM.awK = false;
        } else {
            this.awM.eP(this.awN);
        }
    }
}
