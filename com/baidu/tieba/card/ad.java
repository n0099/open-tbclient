package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(t tVar) {
        this.bcw = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bcw.e(true, 4);
    }
}
