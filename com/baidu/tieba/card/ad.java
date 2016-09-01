package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(t tVar) {
        this.aZF = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aZF.d(true, 4);
    }
}
