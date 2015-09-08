package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a axY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.axY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.axY.dO()) {
            bVar = this.axY.axW;
            bVar.invalidate();
            bVar2 = this.axY.axW;
            bVar2.post(this);
        }
    }
}
