package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ z aTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(z zVar) {
        this.aTy = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aTy.d(true, 4);
    }
}
