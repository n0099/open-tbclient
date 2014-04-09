package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.p;
import com.baidu.tieba.im.r;
/* loaded from: classes.dex */
final class h implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.a = fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Integer num) {
        p.b();
        r.b();
        com.baidu.tieba.im.db.o.d().c();
        com.baidu.tieba.im.db.n.d().c();
    }
}
