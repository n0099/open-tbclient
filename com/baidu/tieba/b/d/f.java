package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ d bsq;
    private final /* synthetic */ h bsr;
    private final /* synthetic */ int bss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, int i, h hVar) {
        this.bsq = dVar;
        this.bss = i;
        this.bsr = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a aVar;
        d.a aVar2;
        aVar = this.bsq.bsp;
        if (aVar != null && this.bss != 0) {
            aVar2 = this.bsq.bsp;
            aVar2.k(this.bss, false);
        }
        this.bsq.a(this.bsr, true);
        this.bsr.Tc();
    }
}
