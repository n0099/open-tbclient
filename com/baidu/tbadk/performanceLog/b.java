package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a awx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.awx = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.awx.dO()) {
            bVar = this.awx.awv;
            bVar.invalidate();
            bVar2 = this.awx.awv;
            bVar2.post(this);
        }
    }
}
