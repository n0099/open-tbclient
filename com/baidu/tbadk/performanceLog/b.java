package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBf = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aBf.bc()) {
            bVar = this.aBf.aBd;
            bVar.invalidate();
            bVar2 = this.aBf.aBd;
            bVar2.post(this);
        }
    }
}
