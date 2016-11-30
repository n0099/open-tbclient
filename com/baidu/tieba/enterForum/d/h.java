package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e bLb;
    private final /* synthetic */ int bLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.bLb = eVar;
        this.bLc = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bLb.hz(this.bLc);
        com.baidu.adp.lib.h.h.eG().post(new i(this));
    }
}
