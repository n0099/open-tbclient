package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.aZW = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aZW.e(true, 4);
    }
}
