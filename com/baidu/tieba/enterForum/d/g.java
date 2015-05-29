package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aFZ;
    private final /* synthetic */ int aGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aFZ = eVar;
        this.aGa = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aFZ.eJ(this.aGa);
        com.baidu.adp.lib.g.i.hs().post(new h(this));
    }
}
