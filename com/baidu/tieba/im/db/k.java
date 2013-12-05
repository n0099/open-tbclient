package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1673a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, String str) {
        this.b = dVar;
        this.f1673a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(this.b.e(this.f1673a));
    }
}
