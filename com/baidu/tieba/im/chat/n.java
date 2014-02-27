package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class n implements Runnable {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        aVar = this.a.a;
        a.h(aVar);
    }
}
