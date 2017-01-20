package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cp implements Runnable {
    final /* synthetic */ co bJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.bJL = coVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bJL.hideTip();
    }
}
