package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aBL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aBL = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aBL.bc()) {
            bVar = this.aBL.aBJ;
            bVar.invalidate();
            bVar2 = this.aBL.aBJ;
            bVar2.post(this);
        }
    }
}
