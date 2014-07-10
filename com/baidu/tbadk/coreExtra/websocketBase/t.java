package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements l {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.a = qVar;
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
                a.a().a(new u(this));
                return;
            }
        }
        this.a.g = false;
        this.a.d();
    }
}
