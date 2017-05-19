package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aFL = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aFL.ck()) {
            bVar = this.aFL.aFJ;
            bVar.invalidate();
            bVar2 = this.aFL.aFJ;
            bVar2.post(this);
        }
    }
}
