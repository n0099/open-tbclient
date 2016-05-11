package com.baidu.tieba.enterForum.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aYM;
    private final /* synthetic */ int aYN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aYM = eVar;
        this.aYN = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aYM.fT(this.aYN);
        com.baidu.adp.lib.h.h.dL().post(new h(this));
    }
}
