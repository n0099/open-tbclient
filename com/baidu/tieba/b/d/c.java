package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g.a {
    final /* synthetic */ b aZJ;
    private final /* synthetic */ f aZK;
    private final /* synthetic */ int aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, f fVar, int i) {
        this.aZJ = bVar;
        this.aZK = fVar;
        this.aZL = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cr(boolean z) {
        b.a aVar;
        b.a aVar2;
        if (z) {
            this.aZK.setVisibility(8);
            this.aZK.setClickable(false);
            return;
        }
        this.aZK.setVisibility(0);
        this.aZK.setClickable(true);
        aVar = this.aZJ.aZI;
        if (aVar != null) {
            aVar2 = this.aZJ.aZI;
            aVar2.l(this.aZL, true);
        }
    }
}
