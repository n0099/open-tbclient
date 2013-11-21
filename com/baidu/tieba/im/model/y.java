package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1755a = y.class.getName();
    private z b;

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str, long j) {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.b = new z(this, str, j);
        this.b.execute(new Object[0]);
    }
}
