package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends SingleRunnable<c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        this.f1664a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public c b() {
        return a.a(this.f1664a);
    }
}
