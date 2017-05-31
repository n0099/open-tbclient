package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bZs = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZs.Sm();
        this.bZs.f(true, 4);
    }
}
