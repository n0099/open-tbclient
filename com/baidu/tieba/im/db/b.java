package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends SingleRunnable<c> {
    final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public c b() {
        return a.a(this.a);
    }
}
