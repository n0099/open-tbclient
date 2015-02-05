package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a akQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.akQ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.akQ.akN;
        if (dVar != null) {
            dVar2 = this.akQ.akN;
            obj = this.akQ.akO;
            dVar2.A(obj);
        }
    }
}
