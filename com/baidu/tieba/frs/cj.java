package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cj implements Runnable {
    final /* synthetic */ ci bXg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar) {
        this.bXg = ciVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bXg.hideTip();
    }
}
