package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.d {
    private int c = 3;
    private m a = null;
    private l b = null;

    public void a(String str) {
        if (this.a == null) {
            this.a = new m(this);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public void b(String str) {
        if (this.b == null) {
            this.b = new l(this);
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
