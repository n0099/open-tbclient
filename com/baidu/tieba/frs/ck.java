package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ck implements Runnable {
    final /* synthetic */ cj cfp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar) {
        this.cfp = cjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cfp.hideTip();
    }
}
