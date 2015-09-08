package com.baidu.tieba.enterForum.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e aNN;
    private final /* synthetic */ int aNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.aNN = eVar;
        this.aNO = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aNN.eW(this.aNO);
        com.baidu.adp.lib.g.h.hf().post(new h(this));
    }
}
