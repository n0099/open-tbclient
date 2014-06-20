package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements l {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.tbadk.coreExtra.websocketBase.l
    public void a(boolean z) {
        List list;
        f.a().a(z ? 2 : 1);
        if (z) {
            this.a.f = a.a().d();
            list = this.a.f;
            if (list != null) {
                this.a.b("change ip to reconnect with DNS' failed.");
                return;
            } else {
                a.a().a(new v(this));
                return;
            }
        }
        this.a.g = false;
        this.a.d();
    }
}
