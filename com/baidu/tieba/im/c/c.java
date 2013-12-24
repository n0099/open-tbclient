package com.baidu.tieba.im.c;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends SingleRunnable<Void> {
    final /* synthetic */ boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z) {
        this.a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        a.a(this.a);
        return null;
    }
}
