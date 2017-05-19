package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ci implements Runnable {
    final /* synthetic */ ch bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.bRq = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRq.hideTip();
    }
}
