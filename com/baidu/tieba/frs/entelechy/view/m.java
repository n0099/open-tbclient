package com.baidu.tieba.frs.entelechy.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.cax = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cax.Pc();
        this.cax.e(true, 4);
    }
}
