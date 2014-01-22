package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends SingleRunnable<Void> {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.a = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        t.a().a(this.a.b, false);
        return null;
    }
}
