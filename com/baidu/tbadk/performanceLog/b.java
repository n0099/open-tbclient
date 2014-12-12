package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a afB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        if (this.afB.an()) {
            dVar = this.afB.afz;
            dVar.invalidate();
            dVar2 = this.afB.afz;
            dVar2.post(this);
        }
    }
}
