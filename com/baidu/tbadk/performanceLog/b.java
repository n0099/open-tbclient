package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a azM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.azM.dR()) {
            bVar = this.azM.azK;
            bVar.invalidate();
            bVar2 = this.azM.azK;
            bVar2.post(this);
        }
    }
}
