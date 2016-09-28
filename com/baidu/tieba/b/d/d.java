package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b aXN;
    private final /* synthetic */ f aXO;
    private final /* synthetic */ int aXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, int i, f fVar) {
        this.aXN = bVar;
        this.aXP = i;
        this.aXO = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.aXN.aXM;
        if (aVar != null && this.aXP != 0) {
            aVar2 = this.aXN.aXM;
            aVar2.l(this.aXP, false);
        }
        this.aXN.a(this.aXO, true);
        this.aXO.NC();
    }
}
