package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(y yVar) {
        this.bBb = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bBb.f(true, 4);
    }
}
