package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aMS;
    private final /* synthetic */ int aMT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aMS = eVar;
        this.aMT = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aMS.fb(this.aMT);
        com.baidu.adp.lib.g.h.hg().post(new h(this));
    }
}
