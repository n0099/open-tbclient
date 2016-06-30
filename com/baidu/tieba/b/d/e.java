package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ b aQR;
    private final /* synthetic */ f aQS;
    private final /* synthetic */ int aQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, int i, f fVar) {
        this.aQR = bVar;
        this.aQT = i;
        this.aQS = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.aQR.aQQ;
        if (aVar != null && this.aQT != 0) {
            aVar2 = this.aQR.aQQ;
            aVar2.k(this.aQT, false);
        }
        this.aQR.a(this.aQS, true);
        this.aQS.KB();
    }
}
