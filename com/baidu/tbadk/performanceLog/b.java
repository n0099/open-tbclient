package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a axu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.axu = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.axu.ah()) {
            bVar = this.axu.axs;
            bVar.invalidate();
            bVar2 = this.axu.axs;
            bVar2.post(this);
        }
    }
}
