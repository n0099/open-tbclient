package com.baidu.tieba.frs.entelechy.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.bpG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bpG.SL();
        this.bpG.e(true, 4);
    }
}
