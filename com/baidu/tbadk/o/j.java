package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mq() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int mr() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 10;
    }

    public boolean nu() {
        return com.baidu.adp.lib.b.d.mz().an(getName()) == mr();
    }
}
