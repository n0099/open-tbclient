package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.b {
    private int c = 3;
    private ac a = null;
    private ab b = null;

    public void a(String str) {
        if (this.a == null) {
            this.a = new ac(this, null);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public void b(String str) {
        if (this.b == null) {
            this.b = new ab(this, null);
            this.b.setPriority(3);
            this.b.execute(str);
        }
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
