package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a afY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        if (this.afY.an()) {
            dVar = this.afY.afW;
            dVar.invalidate();
            dVar2 = this.afY.afW;
            dVar2.post(this);
        }
    }
}
