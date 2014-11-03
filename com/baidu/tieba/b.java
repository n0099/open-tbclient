package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a acE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.acE = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.acE.acA;
        if (dVar != null) {
            dVar2 = this.acE.acA;
            obj = this.acE.acB;
            dVar2.t(obj);
        }
    }
}
