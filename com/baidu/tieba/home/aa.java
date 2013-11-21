package com.baidu.tieba.home;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.d {
    private y b;

    /* renamed from: a  reason: collision with root package name */
    private ab f1387a = null;
    private ac c = null;

    public aa() {
        this.b = null;
        this.b = new y();
    }

    public void a(ac acVar) {
        this.c = acVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.f1387a != null) {
            return false;
        }
        this.f1387a = new ab(this);
        this.f1387a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f1387a != null) {
            this.f1387a.cancel();
            return true;
        }
        return false;
    }
}
