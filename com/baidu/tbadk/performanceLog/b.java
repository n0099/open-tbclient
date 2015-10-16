package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a awy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.awy = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.awy.dO()) {
            bVar = this.awy.aww;
            bVar.invalidate();
            bVar2 = this.awy.aww;
            bVar2.post(this);
        }
    }
}
