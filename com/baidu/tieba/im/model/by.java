package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.base.e {
    private bz a;

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str, long j) {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
        this.a = new bz(this, str, j);
        this.a.execute(new Object[0]);
    }
}
