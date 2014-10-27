package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements Runnable {
    final /* synthetic */ cj aDA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cj cjVar) {
        this.aDA = cjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aDA.ayT = System.currentTimeMillis();
    }
}
