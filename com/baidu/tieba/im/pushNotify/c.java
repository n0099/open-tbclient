package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z) {
        this.f1860a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        a.a(this.f1860a);
        return null;
    }
}
