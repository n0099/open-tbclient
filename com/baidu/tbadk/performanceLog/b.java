package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a afV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        if (this.afV.an()) {
            dVar = this.afV.afT;
            dVar.invalidate();
            dVar2 = this.afV.afT;
            dVar2.post(this);
        }
    }
}
