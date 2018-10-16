package com.baidu.tbadk.p;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iH() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int iI() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iK() {
        return 10;
    }

    public boolean jL() {
        return com.baidu.adp.lib.b.d.iR().aO(getName()) == iI();
    }
}
