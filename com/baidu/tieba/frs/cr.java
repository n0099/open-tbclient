package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class cr implements Runnable {
    final /* synthetic */ cq bSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cq cqVar) {
        this.bSX = cqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bSX.hideTip();
    }
}
