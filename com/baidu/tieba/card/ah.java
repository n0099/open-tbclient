package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ z aUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(z zVar) {
        this.aUu = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aUu.e(true, 4);
    }
}
