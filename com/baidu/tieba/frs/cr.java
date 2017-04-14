package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cr implements Runnable {
    final /* synthetic */ cq bQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cq cqVar) {
        this.bQG = cqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bQG.hideTip();
    }
}
