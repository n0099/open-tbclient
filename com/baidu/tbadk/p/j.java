package com.baidu.tbadk.p;
/* loaded from: classes.dex */
public abstract class j extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.b.a
    protected void aa(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eY() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eZ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fa() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fb() {
        return 10;
    }

    public boolean ge() {
        return com.baidu.adp.lib.b.d.fh().al(getName()) == eZ();
    }
}
