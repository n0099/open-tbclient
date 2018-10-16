package com.baidu.tbadk.p;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void iM() {
        com.baidu.adp.lib.b.b bVar = new com.baidu.adp.lib.b.b(this.mName, this.Bl, this.Bo);
        bVar.a(this.Bn, this.Bk, this.Bm);
        bVar.h(iL());
        bVar.K(true);
        com.baidu.adp.lib.b.d.iR().a(bVar);
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_new_keep_alive";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iH() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iK() {
        return 10;
    }
}
