package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.base.d {
    private static final String a = by.class.getName();
    private bz b;

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str, long j) {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.b = new bz(this, str, j);
        this.b.execute(new Object[0]);
    }
}
