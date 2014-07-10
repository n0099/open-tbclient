package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.e {
    private int c = 3;
    private ab a = null;
    private aa b = null;

    public void a(String str) {
        if (this.a == null) {
            this.a = new ab(this, null);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public void b(String str) {
        if (this.b == null) {
            this.b = new aa(this, null);
            this.b.setPriority(3);
            this.b.execute(str);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
