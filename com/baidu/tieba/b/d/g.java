package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ d btV;
    private final /* synthetic */ h btW;
    private final /* synthetic */ int btX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, int i, h hVar) {
        this.btV = dVar;
        this.btX = i;
        this.btW = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a aVar;
        d.a aVar2;
        aVar = this.btV.btU;
        if (aVar != null && this.btX != 0) {
            aVar2 = this.btV.btU;
            aVar2.k(this.btX, false);
        }
        this.btV.a(this.btW, true);
        this.btW.SK();
    }
}
