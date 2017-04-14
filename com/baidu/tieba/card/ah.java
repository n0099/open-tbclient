package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ x bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(x xVar) {
        this.bsX = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bsX.e(true, 4);
    }
}
