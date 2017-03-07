package com.baidu.tieba.enterForum.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e bFW;
    private final /* synthetic */ int bFX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.bFW = eVar;
        this.bFX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bFW.hr(this.bFX);
        com.baidu.adp.lib.g.h.fM().post(new i(this));
    }
}
