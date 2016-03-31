package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aAB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aAB.dR()) {
            bVar = this.aAB.aAz;
            bVar.invalidate();
            bVar2 = this.aAB.aAz;
            bVar2.post(this);
        }
    }
}
