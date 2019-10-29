package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public abstract class k extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int fj() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fk() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fl() {
        return 10;
    }

    public boolean isOn() {
        return com.baidu.adp.lib.b.d.ft().af(getName()) == fj();
    }
}
