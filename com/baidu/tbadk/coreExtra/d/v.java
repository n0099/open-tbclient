package com.baidu.tbadk.coreExtra.d;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements k {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.a = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.d.k
    public final void a(boolean z) {
        e eVar;
        a aVar;
        List list;
        a aVar2;
        eVar = f.a;
        eVar.a(z ? 2 : 1);
        if (!z) {
            this.a.h = false;
            this.a.c();
            return;
        }
        q qVar = this.a;
        aVar = d.a;
        qVar.g = aVar.a();
        list = this.a.g;
        if (list == null) {
            aVar2 = d.a;
            aVar2.a(new w(this));
            return;
        }
        this.a.a("change ip to reconnect with DNS' failed.", 0);
    }
}
