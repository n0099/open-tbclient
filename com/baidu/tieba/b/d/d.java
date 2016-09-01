package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b aXj;
    private final /* synthetic */ f aXk;
    private final /* synthetic */ int aXl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, int i, f fVar) {
        this.aXj = bVar;
        this.aXl = i;
        this.aXk = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a aVar;
        b.a aVar2;
        aVar = this.aXj.aXi;
        if (aVar != null && this.aXl != 0) {
            aVar2 = this.aXj.aXi;
            aVar2.l(this.aXl, false);
        }
        this.aXj.a(this.aXk, true);
        this.aXk.Nb();
    }
}
