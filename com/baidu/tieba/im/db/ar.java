package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.bu;
/* loaded from: classes.dex */
class ar extends SingleRunnable<Void> {
    final /* synthetic */ bu a;
    final /* synthetic */ aq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, bu buVar) {
        this.b = aqVar;
        this.a = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        t.a().b(this.a.a(), true);
        return null;
    }
}
