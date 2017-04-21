package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bVG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bVG.SF();
        this.bVG.f(true, 4);
    }
}
