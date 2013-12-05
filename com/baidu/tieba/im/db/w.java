package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1684a;
    final /* synthetic */ String b;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, String str, String str2) {
        this.c = tVar;
        this.f1684a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        this.c.b(this.f1684a, this.b);
        return null;
    }
}
