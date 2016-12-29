package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b aZJ;
    private final /* synthetic */ f aZK;
    private final /* synthetic */ int aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, int i, f fVar) {
        this.aZJ = bVar;
        this.aZL = i;
        this.aZK = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.aZJ.aZI;
        if (aVar != null && this.aZL != 0) {
            aVar2 = this.aZJ.aZI;
            aVar2.l(this.aZL, false);
        }
        this.aZJ.a(this.aZK, true);
        this.aZK.NR();
    }
}
