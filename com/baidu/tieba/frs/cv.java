package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements Runnable {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cu cuVar) {
        this.a = cuVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c();
    }
}
