package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.d {
    private int c = 3;
    private l a = null;
    private k b = null;

    public void a(String str) {
        if (this.a == null) {
            this.a = new l(this, null);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public void b(String str) {
        if (this.b == null) {
            this.b = new k(this, null);
            this.b.setPriority(3);
            this.b.execute(str);
        }
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
