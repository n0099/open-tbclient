package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.performanceLog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a ayk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ayk = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.ayk.ah()) {
            bVar = this.ayk.ayi;
            bVar.invalidate();
            bVar2 = this.ayk.ayi;
            bVar2.post(this);
        }
    }
}
