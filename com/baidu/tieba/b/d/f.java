package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ d bpZ;
    private final /* synthetic */ h bqa;
    private final /* synthetic */ int bqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, int i, h hVar) {
        this.bpZ = dVar;
        this.bqb = i;
        this.bqa = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a aVar;
        d.a aVar2;
        aVar = this.bpZ.bpY;
        if (aVar != null && this.bqb != 0) {
            aVar2 = this.bpZ.bpY;
            aVar2.k(this.bqb, false);
        }
        this.bpZ.a(this.bqa, true);
        this.bqa.Sa();
    }
}
