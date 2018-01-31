package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mr() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int ms() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mu() {
        return 10;
    }

    public boolean nv() {
        return com.baidu.adp.lib.b.d.mA().an(getName()) == ms();
    }
}
