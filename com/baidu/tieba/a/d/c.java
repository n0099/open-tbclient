package com.baidu.tieba.a.d;

import com.baidu.tieba.a.b.g;
import com.baidu.tieba.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g.a {
    private final /* synthetic */ int aNA;
    final /* synthetic */ b aNy;
    private final /* synthetic */ f aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, f fVar, int i) {
        this.aNy = bVar;
        this.aNz = fVar;
        this.aNA = i;
    }

    @Override // com.baidu.tieba.a.b.g.a
    public void cc(boolean z) {
        b.a aVar;
        b.a aVar2;
        if (z) {
            this.aNz.setVisibility(8);
            return;
        }
        this.aNz.setVisibility(0);
        aVar = this.aNy.aNx;
        if (aVar != null) {
            aVar2 = this.aNy.aNx;
            aVar2.j(this.aNA, true);
        }
    }
}
