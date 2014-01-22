package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends SingleRunnable<Void> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, String str, String str2) {
        this.c = tVar;
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        this.c.b(this.a, this.b);
        return null;
    }
}
