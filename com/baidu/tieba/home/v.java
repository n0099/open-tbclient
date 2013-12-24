package com.baidu.tieba.home;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.a.d {
    private t b;
    private w a = null;
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
        if (this.a != null) {
            return false;
        }
        this.a = new w(this);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return false;
    }
}
