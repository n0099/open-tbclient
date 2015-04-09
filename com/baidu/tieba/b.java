package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aty = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.aty.atv;
        if (dVar != null) {
            dVar2 = this.aty.atv;
            obj = this.aty.atw;
            dVar2.C(obj);
        }
    }
}
