package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g.a {
    final /* synthetic */ b aQR;
    private final /* synthetic */ f aQS;
    private final /* synthetic */ int aQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, f fVar, int i) {
        this.aQR = bVar;
        this.aQS = fVar;
        this.aQT = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cf(boolean z) {
        b.a aVar;
        b.a aVar2;
        if (z) {
            this.aQS.setVisibility(8);
            this.aQS.setClickable(false);
            return;
        }
        this.aQS.setVisibility(0);
        this.aQS.setClickable(true);
        aVar = this.aQR.aQQ;
        if (aVar != null) {
            aVar2 = this.aQR.aQQ;
            aVar2.k(this.aQT, true);
        }
    }
}
