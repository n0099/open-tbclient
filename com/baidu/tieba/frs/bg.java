package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements Runnable {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ba baVar) {
        this.a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.n = System.currentTimeMillis();
    }
}
