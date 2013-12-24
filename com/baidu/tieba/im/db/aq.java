package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.br;
/* loaded from: classes.dex */
class aq extends SingleRunnable<Void> {
    final /* synthetic */ br a;
    final /* synthetic */ ap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar, br brVar) {
        this.b = apVar;
        this.a = brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        t.a().b(this.a.a(), true);
        return null;
    }
}
