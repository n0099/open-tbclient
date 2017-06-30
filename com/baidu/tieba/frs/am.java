package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements bz {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(r rVar) {
        this.cdl = rVar;
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(ca caVar) {
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(int i, int i2, cf cfVar) {
        if (i != 1) {
            com.baidu.tieba.card.cf.VN().dv(false);
        }
        if (i == 1) {
            this.cdl.ccj.ew(true);
            this.cdl.ccj.ev(false);
        } else {
            this.cdl.ccj.ex(true);
            this.cdl.ccj.ev(true);
        }
        this.cdl.aei();
        this.cdl.ccs.a(i, i2, cfVar);
    }

    @Override // com.baidu.tieba.frs.bz
    public void init() {
    }

    @Override // com.baidu.tieba.frs.bz
    public void Og() {
    }
}
