package com.baidu.tieba.im.b;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements com.baidu.tieba.im.net.j {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.im.net.j
    public final void a(boolean z) {
        List list;
        com.baidu.tieba.im.net.f.a().a(z ? 2 : 1);
        if (!z) {
            this.a.p = false;
            this.a.j();
            return;
        }
        this.a.t = com.baidu.tieba.im.net.b.a().c();
        list = this.a.t;
        if (list == null) {
            com.baidu.tieba.im.net.b.a().a(new f(this));
        } else {
            this.a.a("change ip to reconnect with DNS' failed.", 0);
        }
    }
}
