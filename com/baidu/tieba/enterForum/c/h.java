package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e bFP;
    private final /* synthetic */ int bFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.bFP = eVar;
        this.bFQ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bFP.hu(this.bFQ);
        com.baidu.adp.lib.g.h.fR().post(new i(this));
    }
}
