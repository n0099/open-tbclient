package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aSf;
    private final /* synthetic */ int aSg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aSf = eVar;
        this.aSg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aSf.fD(this.aSg);
        com.baidu.adp.lib.h.h.hj().post(new h(this));
    }
}
