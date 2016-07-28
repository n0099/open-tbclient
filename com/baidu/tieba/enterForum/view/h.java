package com.baidu.tieba.enterForum.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e bwS;
    private final /* synthetic */ int bwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.bwS = eVar;
        this.bwT = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bwS.gS(this.bwT);
        com.baidu.adp.lib.h.h.dL().post(new i(this));
    }
}
