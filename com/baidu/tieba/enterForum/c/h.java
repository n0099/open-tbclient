package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e byQ;
    private final /* synthetic */ int byR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.byQ = eVar;
        this.byR = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.byQ.hv(this.byR);
        com.baidu.adp.lib.g.h.eE().post(new i(this));
    }
}
