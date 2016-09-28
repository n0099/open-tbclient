package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e bIi;
    private final /* synthetic */ int bIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.bIi = eVar;
        this.bIj = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIi.hy(this.bIj);
        com.baidu.adp.lib.h.h.eG().post(new i(this));
    }
}
