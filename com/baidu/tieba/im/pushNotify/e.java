package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1686a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(boolean z) {
        this.f1686a = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        a.a(this.f1686a);
        return null;
    }
}
