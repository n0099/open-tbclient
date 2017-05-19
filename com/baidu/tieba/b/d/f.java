package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ d bsN;
    private final /* synthetic */ h bsO;
    private final /* synthetic */ int bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, int i, h hVar) {
        this.bsN = dVar;
        this.bsP = i;
        this.bsO = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.a aVar;
        d.a aVar2;
        aVar = this.bsN.bsM;
        if (aVar != null && this.bsP != 0) {
            aVar2 = this.bsN.bsM;
            aVar2.k(this.bsP, false);
        }
        this.bsN.a(this.bsO, true);
        this.bsO.Sx();
    }
}
