package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int ew() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }

    public boolean fz() {
        return com.baidu.adp.lib.b.d.eE().ak(getName()) == ew();
    }
}
