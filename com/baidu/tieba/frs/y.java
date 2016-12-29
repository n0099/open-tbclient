package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x bzn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bzn = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bzn.bzl;
        if (frsActivity.byg != null) {
            frsActivity2 = this.bzn.bzl;
            if (frsActivity2.byg.XB()) {
                frsActivity3 = this.bzn.bzl;
                frsActivity3.WJ();
            }
        }
    }
}
