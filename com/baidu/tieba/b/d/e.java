package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ b aRL;
    private final /* synthetic */ f aRM;
    private final /* synthetic */ int aRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, int i, f fVar) {
        this.aRL = bVar;
        this.aRN = i;
        this.aRM = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.aRL.aRK;
        if (aVar != null && this.aRN != 0) {
            aVar2 = this.aRL.aRK;
            aVar2.l(this.aRN, false);
        }
        this.aRL.a(this.aRM, true);
        this.aRM.KA();
    }
}
