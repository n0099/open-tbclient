package com.baidu.tieba.chat;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.a.e f981a = null;
    private aa b = null;
    private ab c = null;
    private com.baidu.tieba.data.a.f d;

    public z() {
        this.d = null;
        this.d = com.baidu.tieba.data.a.f.a();
    }

    public void a(ab abVar) {
        this.c = abVar;
    }

    public void a(com.baidu.tieba.data.a.e eVar) {
        this.f981a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.c
    public boolean LoadData() {
        if (this.f981a != null && this.b == null) {
            this.b = new aa(this);
            this.b.execute(new Object[0]);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }
}
