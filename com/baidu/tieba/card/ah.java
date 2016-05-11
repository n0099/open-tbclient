package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(z zVar) {
        this.aQe = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQe.e(true, 4);
    }
}
