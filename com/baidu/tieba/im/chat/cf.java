package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cf implements Runnable {
    final /* synthetic */ ce a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar) {
        this.a = ceVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.V();
    }
}
