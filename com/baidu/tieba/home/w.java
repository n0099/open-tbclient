package com.baidu.tieba.home;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.a.d {
    private u b;
    private x a = null;
    private y c = null;

    public w() {
        this.b = null;
        this.b = new u();
    }

    public void a(y yVar) {
        this.c = yVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.a != null) {
            return false;
        }
        this.a = new x(this);
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
