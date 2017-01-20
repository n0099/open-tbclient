package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ d bjx;
    private final /* synthetic */ h bjy;
    private final /* synthetic */ int bjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, int i, h hVar) {
        this.bjx = dVar;
        this.bjz = i;
        this.bjy = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a aVar;
        d.a aVar2;
        aVar = this.bjx.bjw;
        if (aVar != null && this.bjz != 0) {
            aVar2 = this.bjx.bjw;
            aVar2.k(this.bjz, false);
        }
        this.bjx.a(this.bjy, true);
        this.bjy.QL();
    }
}
