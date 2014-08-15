package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.o;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ d a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, boolean z) {
        this.a = dVar;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Integer num) {
        com.baidu.tieba.im.live.d.b().a();
        if (!this.b) {
            com.baidu.tieba.im.c.a(null, null);
            com.baidu.tieba.im.e.a();
            o.c().b();
            n.c().b();
        }
    }
}
