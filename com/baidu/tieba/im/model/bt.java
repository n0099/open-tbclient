package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.a.e {
    private static final String a = bt.class.getName();
    private bu b;

    @Override // com.baidu.adp.a.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public boolean cancelLoadData() {
        return false;
    }

    public final void a(String str, long j) {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.b = new bu(this, str, j);
        this.b.execute(new Object[0]);
    }
}
