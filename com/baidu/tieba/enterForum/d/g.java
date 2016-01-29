package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aYv;
    private final /* synthetic */ int aYw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aYv = eVar;
        this.aYw = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aYv.fX(this.aYw);
        com.baidu.adp.lib.h.h.hr().post(new h(this));
    }
}
