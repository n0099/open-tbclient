package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a acz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.acz = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.acz.acv;
        if (dVar != null) {
            dVar2 = this.acz.acv;
            obj = this.acz.acw;
            dVar2.t(obj);
        }
    }
}
