package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hm() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public int hn() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hp() {
        return 10;
    }

    public boolean ip() {
        return com.baidu.adp.lib.b.d.hv().aw(getName()) == hn();
    }
}
