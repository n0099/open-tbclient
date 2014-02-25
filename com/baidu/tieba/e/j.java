package com.baidu.tieba.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.a.o;
        if (z) {
            this.a.l();
        }
    }
}
