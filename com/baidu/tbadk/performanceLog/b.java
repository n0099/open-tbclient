package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aoq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aoq = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        if (this.aoq.dL()) {
            dVar = this.aoq.aoo;
            dVar.invalidate();
            dVar2 = this.aoq.aoo;
            dVar2.post(this);
        }
    }
}
