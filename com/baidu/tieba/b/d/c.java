package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g.a {
    final /* synthetic */ b aXj;
    private final /* synthetic */ f aXk;
    private final /* synthetic */ int aXl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, f fVar, int i) {
        this.aXj = bVar;
        this.aXk = fVar;
        this.aXl = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cn(boolean z) {
        b.a aVar;
        b.a aVar2;
        if (z) {
            this.aXk.setVisibility(8);
            this.aXk.setClickable(false);
            return;
        }
        this.aXk.setVisibility(0);
        this.aXk.setClickable(true);
        aVar = this.aXj.aXi;
        if (aVar != null) {
            aVar2 = this.aXj.aXi;
            aVar2.l(this.aXl, true);
        }
    }
}
