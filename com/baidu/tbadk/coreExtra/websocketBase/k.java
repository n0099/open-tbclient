package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0038a {
    final /* synthetic */ i aob;
    private final /* synthetic */ String aoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.aob = iVar;
        this.aoc = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0038a
    public void Ad() {
        List list;
        this.aob.currentIndex = 0;
        this.aob.ann = a.zX().Aa();
        list = this.aob.ann;
        if (list == null) {
            this.aob.anZ = false;
        } else {
            this.aob.eY(this.aoc);
        }
    }
}
