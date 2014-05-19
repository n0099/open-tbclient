package com.baidu.tbadk.coreExtra.d;

import java.util.List;
/* loaded from: classes.dex */
class w implements b {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // com.baidu.tbadk.coreExtra.d.b
    public void a() {
        q qVar;
        q qVar2;
        List list;
        q qVar3;
        q qVar4;
        qVar = this.a.a;
        qVar.g = a.a().b();
        qVar2 = this.a.a;
        list = qVar2.g;
        if (list != null) {
            qVar4 = this.a.a;
            qVar4.a("change ip to reconnect with DNS' failed.", 0);
            return;
        }
        qVar3 = this.a.a;
        qVar3.h = false;
    }
}
