package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements Runnable {
    final /* synthetic */ cv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cv cvVar) {
        this.a = cvVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c();
    }
}
