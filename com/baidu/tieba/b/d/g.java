package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ d bqg;
    private final /* synthetic */ h bqh;
    private final /* synthetic */ int bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, int i, h hVar) {
        this.bqg = dVar;
        this.bqi = i;
        this.bqh = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a aVar;
        d.a aVar2;
        aVar = this.bqg.bqf;
        if (aVar != null && this.bqi != 0) {
            aVar2 = this.bqg.bqf;
            aVar2.k(this.bqi, false);
        }
        this.bqg.a(this.bqh, true);
        this.bqh.RD();
    }
}
