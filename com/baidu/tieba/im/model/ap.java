package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.a.d {
    private static final String a = ap.class.getName();
    private aq b;

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public final void a(String str, long j) {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.b = new aq(this, str, j);
        this.b.execute(new Object[0]);
    }
}
