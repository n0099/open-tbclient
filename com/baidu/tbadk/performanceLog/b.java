package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBr = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aBr.bc()) {
            bVar = this.aBr.aBp;
            bVar.invalidate();
            bVar2 = this.aBr.aBp;
            bVar2.post(this);
        }
    }
}
