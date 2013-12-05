package com.baidu.tieba.data.chat;

import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class d extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1243a;
    final /* synthetic */ int b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, int i) {
        this.c = cVar;
        this.f1243a = str;
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        this.c.a(this.f1243a, this.b);
        return null;
    }
}
