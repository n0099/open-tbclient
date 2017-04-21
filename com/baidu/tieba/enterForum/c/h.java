package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e bIg;
    private final /* synthetic */ int bIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.bIg = eVar;
        this.bIh = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIg.hA(this.bIh);
        com.baidu.adp.lib.g.h.fS().post(new i(this));
    }
}
