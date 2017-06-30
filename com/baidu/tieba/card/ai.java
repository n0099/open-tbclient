package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ y bBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(y yVar) {
        this.bBU = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bBU.f(true, 4);
    }
}
