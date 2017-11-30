package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void X(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eM() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int eN() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eO() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eP() {
        return 10;
    }

    public boolean fS() {
        return com.baidu.adp.lib.b.d.eV().af(getName()) == eN();
    }
}
