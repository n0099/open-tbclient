package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bGf = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bGf.Oy();
        this.bGf.e(true, 4);
    }
}
