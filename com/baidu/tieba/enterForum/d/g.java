package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aNa;
    private final /* synthetic */ int aNb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aNa = eVar;
        this.aNb = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aNa.fj(this.aNb);
        com.baidu.adp.lib.g.h.hh().post(new h(this));
    }
}
