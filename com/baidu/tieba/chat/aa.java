package com.baidu.tieba.chat;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.c {
    private com.baidu.tieba.data.a.e a = null;
    private ab b = null;
    private ac c = null;
    private com.baidu.tieba.data.a.f d;

    public aa() {
        this.d = null;
        this.d = com.baidu.tieba.data.a.f.a();
    }

    public void a(ac acVar) {
        this.c = acVar;
    }

    public void a(com.baidu.tieba.data.a.e eVar) {
        this.a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.c
    public boolean LoadData() {
        if (this.a != null && this.b == null) {
            this.b = new ab(this);
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
