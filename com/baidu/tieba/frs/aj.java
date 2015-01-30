package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aj implements Runnable {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bp bpVar;
        bpVar = this.aDW.aCY;
        bpVar.GL();
    }
}
