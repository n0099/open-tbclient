package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ c bHP;
    private final /* synthetic */ int bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, int i) {
        this.bHP = cVar;
        this.bHQ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bHP.hs(this.bHQ);
        com.baidu.adp.lib.g.h.fS().post(new h(this));
    }
}
