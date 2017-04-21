package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements g.a {
    final /* synthetic */ d bsq;
    private final /* synthetic */ h bsr;
    private final /* synthetic */ int bss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, h hVar, int i) {
        this.bsq = dVar;
        this.bsr = hVar;
        this.bss = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cP(boolean z) {
        d.a aVar;
        d.a aVar2;
        if (z) {
            this.bsr.setVisibility(8);
            this.bsr.setClickable(false);
            return;
        }
        this.bsr.setVisibility(0);
        this.bsr.setClickable(true);
        aVar = this.bsq.bsp;
        if (aVar != null) {
            aVar2 = this.bsq.bsp;
            aVar2.k(this.bss, true);
        }
    }
}
