package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ c bND;
    private final /* synthetic */ int bNE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, int i) {
        this.bND = cVar;
        this.bNE = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bND.hQ(this.bNE);
        com.baidu.adp.lib.g.h.fS().post(new h(this));
    }
}
