package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a akp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.akp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.akp.akm;
        if (dVar != null) {
            dVar2 = this.akp.akm;
            obj = this.akp.akn;
            dVar2.A(obj);
        }
    }
}
