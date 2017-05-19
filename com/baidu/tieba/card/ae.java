package com.baidu.tieba.card;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(u uVar) {
        this.bvn = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bvn.f(true, 4);
    }
}
