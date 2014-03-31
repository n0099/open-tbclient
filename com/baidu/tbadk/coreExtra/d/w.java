package com.baidu.tbadk.coreExtra.d;

import java.util.List;
/* loaded from: classes.dex */
final class w implements b {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.a = vVar;
    }

    @Override // com.baidu.tbadk.coreExtra.d.b
    public final void a() {
        a aVar;
        List list;
        q qVar = this.a.a;
        aVar = d.a;
        qVar.g = aVar.a();
        list = this.a.a.g;
        if (list == null) {
            this.a.a.h = false;
        } else {
            this.a.a.a("change ip to reconnect with DNS' failed.", 0);
        }
    }
}
