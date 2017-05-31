package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements g.a {
    final /* synthetic */ d btV;
    private final /* synthetic */ h btW;
    private final /* synthetic */ int btX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, h hVar, int i) {
        this.btV = dVar;
        this.btW = hVar;
        this.btX = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cX(boolean z) {
        d.a aVar;
        d.a aVar2;
        if (z) {
            this.btW.setVisibility(8);
            this.btW.setClickable(false);
            return;
        }
        this.btW.setVisibility(0);
        this.btW.setClickable(true);
        aVar = this.btV.btU;
        if (aVar != null) {
            aVar2 = this.btV.btU;
            aVar2.k(this.btX, true);
        }
    }
}
