package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0046a {
    final /* synthetic */ i aoT;
    private final /* synthetic */ String aoU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.aoT = iVar;
        this.aoU = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0046a
    public void Au() {
        List list;
        this.aoT.currentIndex = 0;
        this.aoT.aog = a.Ao().Ar();
        list = this.aoT.aog;
        if (list == null) {
            this.aoT.aoR = false;
        } else {
            this.aoT.eO(this.aoU);
        }
    }
}
