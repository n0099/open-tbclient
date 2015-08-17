package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aNA;
    private final /* synthetic */ int aNB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aNA = eVar;
        this.aNB = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aNA.eP(this.aNB);
        com.baidu.adp.lib.g.h.hi().post(new h(this));
    }
}
