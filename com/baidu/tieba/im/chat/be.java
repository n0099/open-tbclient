package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class be implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ com.baidu.tieba.im.message.b b;
    final /* synthetic */ bd c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, int i, com.baidu.tieba.im.message.b bVar) {
        this.c = bdVar;
        this.a = i;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bu buVar;
        buVar = this.c.a.g;
        buVar.a(this.a, this.b);
    }
}
