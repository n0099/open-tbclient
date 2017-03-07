package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cp implements Runnable {
    final /* synthetic */ co bQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.bQR = coVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bQR.hideTip();
    }
}
