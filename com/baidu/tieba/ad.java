package com.baidu.tieba;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ SnowView alx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SnowView snowView) {
        this.alx = snowView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.alx.invalidate();
    }
}
