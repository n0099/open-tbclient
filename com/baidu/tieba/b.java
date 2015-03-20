package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a atq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.atq = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.atq.atn;
        if (dVar != null) {
            dVar2 = this.atq.atn;
            obj = this.atq.ato;
            dVar2.C(obj);
        }
    }
}
