package com.baidu.tieba.a.d;

import com.baidu.tieba.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    private final /* synthetic */ int aNA;
    final /* synthetic */ b aNy;
    private final /* synthetic */ f aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, int i, f fVar) {
        this.aNy = bVar;
        this.aNA = i;
        this.aNz = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.aNy.aNx;
        if (aVar != null && this.aNA != 0) {
            aVar2 = this.aNy.aNx;
            aVar2.j(this.aNA, false);
        }
        this.aNy.a(this.aNz, true);
        this.aNz.JD();
    }
}
