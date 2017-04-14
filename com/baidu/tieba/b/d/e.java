package com.baidu.tieba.b.d;

import com.baidu.tieba.b.b.g;
import com.baidu.tieba.b.d.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements g.a {
    final /* synthetic */ d bpZ;
    private final /* synthetic */ h bqa;
    private final /* synthetic */ int bqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, h hVar, int i) {
        this.bpZ = dVar;
        this.bqa = hVar;
        this.bqb = i;
    }

    @Override // com.baidu.tieba.b.b.g.a
    public void cF(boolean z) {
        d.a aVar;
        d.a aVar2;
        if (z) {
            this.bqa.setVisibility(8);
            this.bqa.setClickable(false);
            return;
        }
        this.bqa.setVisibility(0);
        this.bqa.setClickable(true);
        aVar = this.bpZ.bpY;
        if (aVar != null) {
            aVar2 = this.bpZ.bpY;
            aVar2.k(this.bqb, true);
        }
    }
}
