package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class k extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, String str) {
        this.b = dVar;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(this.b.e(this.a));
    }
}
