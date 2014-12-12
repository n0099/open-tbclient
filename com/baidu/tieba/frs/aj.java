package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class aj implements Runnable {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bqVar = this.aCV.aBX;
        bqVar.Go();
    }
}
