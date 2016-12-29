package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e brf;
    private final /* synthetic */ int brg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.brf = eVar;
        this.brg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.brf.gJ(this.brg);
        com.baidu.adp.lib.h.h.eG().post(new i(this));
    }
}
