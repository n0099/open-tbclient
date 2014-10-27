package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class am implements Runnable {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bu buVar;
        buVar = this.aBk.aAv;
        buVar.Gi();
    }
}
