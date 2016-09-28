package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g.a {
    final /* synthetic */ b aXN;
    private final /* synthetic */ f aXO;
    private final /* synthetic */ int aXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, f fVar, int i) {
        this.aXN = bVar;
        this.aXO = fVar;
        this.aXP = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cn(boolean z) {
        b.a aVar;
        b.a aVar2;
        if (z) {
            this.aXO.setVisibility(8);
            this.aXO.setClickable(false);
            return;
        }
        this.aXO.setVisibility(0);
        this.aXO.setClickable(true);
        aVar = this.aXN.aXM;
        if (aVar != null) {
            aVar2 = this.aXN.aXM;
            aVar2.l(this.aXP, true);
        }
    }
}
