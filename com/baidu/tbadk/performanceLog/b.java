package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a awq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.awq = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.awq.dO()) {
            bVar = this.awq.awo;
            bVar.invalidate();
            bVar2 = this.awq.awo;
            bVar2.post(this);
        }
    }
}
