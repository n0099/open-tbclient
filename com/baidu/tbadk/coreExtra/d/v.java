package com.baidu.tbadk.coreExtra.d;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements k {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.a = qVar;
    }

    @Override // com.baidu.tbadk.coreExtra.d.k
    public void a(boolean z) {
        List list;
        e.a().a(z ? 2 : 1);
        if (z) {
            this.a.g = a.a().b();
            list = this.a.g;
            if (list != null) {
                this.a.a("change ip to reconnect with DNS' failed.", 0);
                return;
            } else {
                a.a().a(new w(this));
                return;
            }
        }
        this.a.h = false;
        this.a.e();
    }
}
