package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0039a {
    final /* synthetic */ i aoQ;
    private final /* synthetic */ String aoR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.aoQ = iVar;
        this.aoR = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Ad() {
        List list;
        this.aoQ.currentIndex = 0;
        this.aoQ.aoc = a.zX().Aa();
        list = this.aoQ.aoc;
        if (list == null) {
            this.aoQ.aoO = false;
        } else {
            this.aoQ.eW(this.aoR);
        }
    }
}
