package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements g.a {
    final /* synthetic */ d bsN;
    private final /* synthetic */ h bsO;
    private final /* synthetic */ int bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, h hVar, int i) {
        this.bsN = dVar;
        this.bsO = hVar;
        this.bsP = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cR(boolean z) {
        d.a aVar;
        d.a aVar2;
        if (z) {
            this.bsO.setVisibility(8);
            this.bsO.setClickable(false);
            return;
        }
        this.bsO.setVisibility(0);
        this.bsO.setClickable(true);
        aVar = this.bsN.bsM;
        if (aVar != null) {
            aVar2 = this.bsN.bsM;
            aVar2.k(this.bsP, true);
        }
    }
}
