package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ x btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(x xVar) {
        this.btf = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.btf.e(true, 4);
    }
}
