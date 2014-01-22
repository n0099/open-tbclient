package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.cg;
/* loaded from: classes.dex */
class at extends SingleRunnable<Void> {
    final /* synthetic */ cg a;
    final /* synthetic */ as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, cg cgVar) {
        this.b = asVar;
        this.a = cgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        t.a().b(this.a.a(), true);
        return null;
    }
}
