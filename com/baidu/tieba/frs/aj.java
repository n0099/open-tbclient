package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aj implements Runnable {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bp bpVar;
        bpVar = this.aDT.aCV;
        bpVar.GF();
    }
}
