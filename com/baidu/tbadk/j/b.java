package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aFy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFy = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aFy.ck()) {
            bVar = this.aFy.aFw;
            bVar.invalidate();
            bVar2 = this.aFy.aFw;
            bVar2.post(this);
        }
    }
}
