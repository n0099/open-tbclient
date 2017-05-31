package com.baidu.tieba.frs;

import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements by {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(r rVar) {
        this.bVb = rVar;
    }

    @Override // com.baidu.tieba.frs.by
    public void a(bz bzVar) {
    }

    @Override // com.baidu.tieba.frs.by
    public void a(int i, int i2, ce ceVar) {
        if (i != 1) {
            cf.Uw().dt(false);
        }
        if (i == 1) {
            this.bVb.bUa.ee(true);
            this.bVb.bUa.ed(false);
        } else {
            this.bVb.bUa.ef(true);
            this.bVb.bUa.ed(true);
        }
        this.bVb.aas();
        this.bVb.bUj.a(i, i2, ceVar);
    }

    @Override // com.baidu.tieba.frs.by
    public void init() {
    }

    @Override // com.baidu.tieba.frs.by
    public void MT() {
    }
}
