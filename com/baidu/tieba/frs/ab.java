package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ab implements cd {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        if (i != 1) {
            com.baidu.tieba.card.bz.OH().cz(false);
        }
        this.bzl.byg.XA();
        if (i == 1 || i == 2) {
            this.bzl.byg.dx(true);
            this.bzl.byg.dv(false);
        } else {
            this.bzl.byg.dy(true);
            this.bzl.byg.dv(true);
        }
        this.bzl.WD();
        this.bzl.byr.a(i, i2, clVar);
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void VI() {
    }
}
