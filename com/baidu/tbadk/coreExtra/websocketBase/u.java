package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* loaded from: classes.dex */
class u implements b {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.b
    public void a() {
        q qVar;
        q qVar2;
        q qVar3;
        List list;
        q qVar4;
        q qVar5;
        qVar = this.a.a;
        qVar.c = 0;
        qVar2 = this.a.a;
        qVar2.f = a.a().d();
        qVar3 = this.a.a;
        list = qVar3.f;
        if (list != null) {
            qVar5 = this.a.a;
            qVar5.b("change ip to reconnect with DNS' failed.");
            return;
        }
        qVar4 = this.a.a;
        qVar4.g = false;
    }
}
