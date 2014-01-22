package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cs implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ com.baidu.tieba.im.message.b b;
    final /* synthetic */ cr c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar, int i, com.baidu.tieba.im.message.b bVar) {
        this.c = crVar;
        this.a = i;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a.d.a(this.a, this.b);
    }
}
