package com.baidu.tieba.frs.h;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bup = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bup.btZ != null) {
            this.bup.btZ.JD();
        }
    }
}
