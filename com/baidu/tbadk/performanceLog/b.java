package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a avm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.avm = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.avm.dO()) {
            bVar = this.avm.avk;
            bVar.invalidate();
            bVar2 = this.avm.avk;
            bVar2.post(this);
        }
    }
}
