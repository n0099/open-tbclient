package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aoy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aoy = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        if (this.aoy.dL()) {
            dVar = this.aoy.aow;
            dVar.invalidate();
            dVar2 = this.aoy.aow;
            dVar2.post(this);
        }
    }
}
