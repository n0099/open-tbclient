package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0046a {
    final /* synthetic */ i aqx;
    private final /* synthetic */ String aqy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.aqx = iVar;
        this.aqy = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0046a
    public void Ak() {
        List list;
        this.aqx.currentIndex = 0;
        this.aqx.apK = a.Ae().Ah();
        list = this.aqx.apK;
        if (list == null) {
            this.aqx.aqv = false;
        } else {
            this.aqx.eR(this.aqy);
        }
    }
}
