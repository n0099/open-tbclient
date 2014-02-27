package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.a.d {
    private int c = 3;
    private l a = null;
    private k b = null;

    public final void a(String str) {
        if (this.a == null) {
            this.a = new l(this, (byte) 0);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public final void b(String str) {
        if (this.b == null) {
            this.b = new k(this, (byte) 0);
            this.b.setPriority(3);
            this.b.execute(str);
        }
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
