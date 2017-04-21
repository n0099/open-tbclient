package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aFH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aFH.ck()) {
            bVar = this.aFH.aFF;
            bVar.invalidate();
            bVar2 = this.aFH.aFF;
            bVar2.post(this);
        }
    }
}
