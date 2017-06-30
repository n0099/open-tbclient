package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ c bUy;
    private final /* synthetic */ int bUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, int i) {
        this.bUy = cVar;
        this.bUz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bUy.ia(this.bUz);
        com.baidu.adp.lib.g.h.fR().post(new g(this));
    }
}
