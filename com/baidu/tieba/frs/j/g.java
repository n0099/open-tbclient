package com.baidu.tieba.frs.j;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f cjT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.cjT = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cjT.cjB != null) {
            this.cjT.cjB.OI();
        }
    }
}
