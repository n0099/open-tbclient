package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
public final class x extends com.baidu.adp.a.e {
    private int c = 3;
    private z a = null;
    private y b = null;

    public final void a(String str) {
        if (this.a == null) {
            this.a = new z(this, (byte) 0);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public final void b(String str) {
        if (this.b == null) {
            this.b = new y(this, (byte) 0);
            this.b.setPriority(3);
            this.b.execute(str);
        }
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
