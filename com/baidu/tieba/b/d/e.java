package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements g.a {
    final /* synthetic */ d bjx;
    private final /* synthetic */ h bjy;
    private final /* synthetic */ int bjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, h hVar, int i) {
        this.bjx = dVar;
        this.bjy = hVar;
        this.bjz = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cE(boolean z) {
        d.a aVar;
        d.a aVar2;
        if (z) {
            this.bjy.setVisibility(8);
            this.bjy.setClickable(false);
            return;
        }
        this.bjy.setVisibility(0);
        this.bjy.setClickable(true);
        aVar = this.bjx.bjw;
        if (aVar != null) {
            aVar2 = this.bjx.bjw;
            aVar2.k(this.bjz, true);
        }
    }
}
