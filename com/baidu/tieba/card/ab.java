package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.bde = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bde.e(true, 4);
    }
}
