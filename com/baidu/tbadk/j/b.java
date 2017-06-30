package com.baidu.tbadk.j;

import com.baidu.tbadk.j.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aGM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aGM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b bVar;
        a.b bVar2;
        if (this.aGM.ck()) {
            bVar = this.aGM.aGK;
            bVar.invalidate();
            bVar2 = this.aGM.aGK;
            bVar2.post(this);
        }
    }
}
