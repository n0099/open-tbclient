package com.baidu.tbadk.p;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ir() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int is() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int it() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iu() {
        return 10;
    }

    public boolean jw() {
        return com.baidu.adp.lib.b.d.iB().aO(getName()) == is();
    }
}
