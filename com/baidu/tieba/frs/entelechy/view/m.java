package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.chB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.chB.VC();
        this.chB.f(true, 4);
    }
}
