package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aFF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFF = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aFF.ck()) {
            bVar = this.aFF.aFD;
            bVar.invalidate();
            bVar2 = this.aFF.aFD;
            bVar2.post(this);
        }
    }
}
