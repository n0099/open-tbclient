package com.baidu.tieba.im.b;

import java.util.List;
/* loaded from: classes.dex */
final class f implements com.baidu.tieba.im.net.c {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tieba.im.net.c
    public final void a() {
        List list;
        this.a.a.t = com.baidu.tieba.im.net.b.a().c();
        list = this.a.a.t;
        if (list == null) {
            this.a.a.p = false;
        } else {
            this.a.a.a("change ip to reconnect with DNS' failed.", 0);
        }
    }
}
