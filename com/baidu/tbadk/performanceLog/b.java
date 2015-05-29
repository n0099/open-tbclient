package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a apD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.apD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        if (this.apD.dN()) {
            dVar = this.apD.apB;
            dVar.invalidate();
            dVar2 = this.apD.apB;
            dVar2.post(this);
        }
    }
}
