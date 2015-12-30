package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aWh;
    private final /* synthetic */ int aWi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aWh = eVar;
        this.aWi = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aWh.fy(this.aWi);
        com.baidu.adp.lib.h.h.hj().post(new h(this));
    }
}
