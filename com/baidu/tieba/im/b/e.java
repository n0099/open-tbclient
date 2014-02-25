package com.baidu.tieba.im.b;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.net.j {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.im.net.j
    public void a(boolean z) {
        List list;
        com.baidu.tieba.im.net.f.a().a("ping is succ? " + z + " to: www.baidu.com time: " + System.currentTimeMillis());
        if (!z) {
            this.a.p = false;
            com.baidu.tieba.im.net.f.a().c();
            this.a.l();
            return;
        }
        this.a.s = com.baidu.tieba.im.net.b.a().d();
        list = this.a.s;
        if (list == null) {
            com.baidu.tieba.im.net.b.a().a(new f(this));
        } else {
            this.a.a("change ip to reconnect with DNS' failed.", 0);
        }
    }
}
