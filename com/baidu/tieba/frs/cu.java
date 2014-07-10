package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cu implements Runnable {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ct ctVar) {
        this.a = ctVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c();
    }
}
