package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1624a;
    final /* synthetic */ String b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, String str, String str2) {
        this.c = nVar;
        this.f1624a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        this.c.b(this.f1624a, this.b);
        return null;
    }
}
