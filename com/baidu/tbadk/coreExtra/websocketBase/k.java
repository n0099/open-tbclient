package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0047a {
    final /* synthetic */ i arH;
    private final /* synthetic */ String arI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.arH = iVar;
        this.arI = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0047a
    public void Cd() {
        List list;
        this.arH.currentIndex = 0;
        this.arH.aqT = a.BX().Ca();
        list = this.arH.aqT;
        if (list == null) {
            this.arH.arF = false;
        } else {
            this.arH.eX(this.arI);
        }
    }
}
