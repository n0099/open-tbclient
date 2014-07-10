package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar;
        d dVar2;
        Object obj;
        dVar = this.a.a;
        if (dVar != null) {
            dVar2 = this.a.a;
            obj = this.a.c;
            dVar2.a(obj);
        }
    }
}
