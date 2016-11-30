package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ b baW;
    private final /* synthetic */ f baX;
    private final /* synthetic */ int baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, int i, f fVar) {
        this.baW = bVar;
        this.baY = i;
        this.baX = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.baW.baV;
        if (aVar != null && this.baY != 0) {
            aVar2 = this.baW.baV;
            aVar2.l(this.baY, false);
        }
        this.baW.a(this.baX, true);
        this.baX.OG();
    }
}
