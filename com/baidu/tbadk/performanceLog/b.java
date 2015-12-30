package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a ayV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ayV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.ayV.dO()) {
            bVar = this.ayV.ayT;
            bVar.invalidate();
            bVar2 = this.ayV.ayT;
            bVar2.post(this);
        }
    }
}
