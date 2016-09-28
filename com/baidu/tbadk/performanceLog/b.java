package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aAU = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aAU.bc()) {
            bVar = this.aAU.aAS;
            bVar.invalidate();
            bVar2 = this.aAU.aAS;
            bVar2.post(this);
        }
    }
}
