package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0039a {
    final /* synthetic */ i ark;
    private final /* synthetic */ String arl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.ark = iVar;
        this.arl = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bl() {
        List list;
        this.ark.currentIndex = 0;
        this.ark.aqx = a.Bf().Bi();
        list = this.ark.aqx;
        if (list == null) {
            this.ark.ari = false;
        } else {
            this.ark.eX(this.arl);
        }
    }
}
