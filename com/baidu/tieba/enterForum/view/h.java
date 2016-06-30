package com.baidu.tieba.enterForum.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e buE;
    private final /* synthetic */ int buF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.buE = eVar;
        this.buF = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.buE.gS(this.buF);
        com.baidu.adp.lib.h.h.dM().post(new i(this));
    }
}
