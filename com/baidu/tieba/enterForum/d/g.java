package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aMH;
    private final /* synthetic */ int aMI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aMH = eVar;
        this.aMI = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aMH.fb(this.aMI);
        com.baidu.adp.lib.g.h.hg().post(new h(this));
    }
}
