package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bXm = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bXm.Nz();
        this.bXm.d(true, 4);
    }
}
