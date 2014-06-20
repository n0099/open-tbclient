package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class v implements b {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void a() {
        r rVar;
        r rVar2;
        r rVar3;
        List list;
        r rVar4;
        r rVar5;
        rVar = this.a.a;
        rVar.c = 0;
        rVar2 = this.a.a;
        rVar2.f = a.a().d();
        rVar3 = this.a.a;
        list = rVar3.f;
        if (list != null) {
            rVar5 = this.a.a;
            rVar5.b("change ip to reconnect with DNS' failed.");
            return;
        }
        rVar4 = this.a.a;
        rVar4.g = false;
    }
}
