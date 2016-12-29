package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.coreExtra.websocketBase.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0039a {
    final /* synthetic */ i asf;
    private final /* synthetic */ String asg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str) {
        this.asf = iVar;
        this.asg = str;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0039a
    public void Bq() {
        List list;
        this.asf.currentIndex = 0;
        this.asf.arr = a.Bk().Bn();
        list = this.asf.arr;
        if (list == null) {
            this.asf.asd = false;
        } else {
            this.asf.fa(this.asg);
        }
    }
}
