package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g.a {
    final /* synthetic */ b aRL;
    private final /* synthetic */ f aRM;
    private final /* synthetic */ int aRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, f fVar, int i) {
        this.aRL = bVar;
        this.aRM = fVar;
        this.aRN = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void ch(boolean z) {
        b.a aVar;
        b.a aVar2;
        if (z) {
            this.aRM.setVisibility(8);
            this.aRM.setClickable(false);
            return;
        }
        this.aRM.setVisibility(0);
        this.aRM.setClickable(true);
        aVar = this.aRL.aRK;
        if (aVar != null) {
            aVar2 = this.aRL.aRK;
            aVar2.l(this.aRN, true);
        }
    }
}
