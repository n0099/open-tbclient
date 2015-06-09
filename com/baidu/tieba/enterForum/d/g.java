package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aGa;
    private final /* synthetic */ int aGb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aGa = eVar;
        this.aGb = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aGa.eJ(this.aGb);
        com.baidu.adp.lib.g.i.hs().post(new h(this));
    }
}
