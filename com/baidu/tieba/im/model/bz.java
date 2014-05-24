package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class bz extends com.baidu.adp.base.b {
    private static final String a = bz.class.getName();
    private ca b;

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str, long j) {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.b = new ca(this, str, j);
        this.b.execute(new Object[0]);
    }
}
