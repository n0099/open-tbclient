package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aFp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aFp.cl()) {
            bVar = this.aFp.aFn;
            bVar.invalidate();
            bVar2 = this.aFp.aFn;
            bVar2.post(this);
        }
    }
}
