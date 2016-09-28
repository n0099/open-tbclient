package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0039a {
    final /* synthetic */ i arI;
    private final /* synthetic */ String arJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.arI = iVar;
        this.arJ = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bw() {
        List list;
        this.arI.currentIndex = 0;
        this.arI.aqU = a.Bq().Bt();
        list = this.arI.aqU;
        if (list == null) {
            this.arI.arG = false;
        } else {
            this.arI.fc(this.arJ);
        }
    }
}
