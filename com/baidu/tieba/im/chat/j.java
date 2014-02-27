package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class j implements Runnable {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        aVar = this.a.a;
        aVar.T();
    }
}
