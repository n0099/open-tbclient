package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a akT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.akT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.akT.akQ;
        if (dVar != null) {
            dVar2 = this.akT.akQ;
            obj = this.akT.akR;
            dVar2.A(obj);
        }
    }
}
