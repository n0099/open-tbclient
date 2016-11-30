package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g.a {
    final /* synthetic */ b baW;
    private final /* synthetic */ f baX;
    private final /* synthetic */ int baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, f fVar, int i) {
        this.baW = bVar;
        this.baX = fVar;
        this.baY = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cs(boolean z) {
        b.a aVar;
        b.a aVar2;
        if (z) {
            this.baX.setVisibility(8);
            this.baX.setClickable(false);
            return;
        }
        this.baX.setVisibility(0);
        this.baX.setClickable(true);
        aVar = this.baW.baV;
        if (aVar != null) {
            aVar2 = this.baW.baV;
            aVar2.l(this.baY, true);
        }
    }
}
