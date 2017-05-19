package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bTA = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bTA.Sa();
        this.bTA.f(true, 4);
    }
}
