package com.baidu.tieba.im.b;

import java.util.List;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.net.c {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tieba.im.net.c
    public void a() {
        a aVar;
        a aVar2;
        List list;
        a aVar3;
        a aVar4;
        aVar = this.a.a;
        aVar.s = com.baidu.tieba.im.net.b.a().d();
        aVar2 = this.a.a;
        list = aVar2.s;
        if (list != null) {
            aVar4 = this.a.a;
            aVar4.a("change ip to reconnect with DNS' failed.", 0);
            return;
        }
        aVar3 = this.a.a;
        aVar3.p = false;
    }
}
