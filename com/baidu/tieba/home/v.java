package com.baidu.tieba.home;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.a.d {
    private t b;

    /* renamed from: a  reason: collision with root package name */
    private w f1507a = null;
    private x c = null;

    public v() {
        this.b = null;
        this.b = new t();
    }

    public void a(x xVar) {
        this.c = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.f1507a != null) {
            return false;
        }
        this.f1507a = new w(this);
        this.f1507a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f1507a != null) {
            this.f1507a.cancel();
            return true;
        }
        return false;
    }
}
