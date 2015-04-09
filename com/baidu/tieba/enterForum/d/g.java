package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aDX = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aDX.Hw();
        com.baidu.adp.lib.g.i.hI().post(new h(this));
    }
}
