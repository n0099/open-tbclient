package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a azX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.azX = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.azX.bc()) {
            bVar = this.azX.azV;
            bVar.invalidate();
            bVar2 = this.azX.azV;
            bVar2.post(this);
        }
    }
}
