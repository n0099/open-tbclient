package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bc implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ com.baidu.tieba.im.message.b b;
    final /* synthetic */ bb c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, int i, com.baidu.tieba.im.message.b bVar) {
        this.c = bbVar;
        this.a = i;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bs bsVar;
        bsVar = this.c.a.g;
        bsVar.a(this.a, this.b);
    }
}
