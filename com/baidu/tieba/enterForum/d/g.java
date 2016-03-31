package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e bdf;
    private final /* synthetic */ int bdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.bdf = eVar;
        this.bdg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bdf.gn(this.bdg);
        com.baidu.adp.lib.h.h.hx().post(new h(this));
    }
}
