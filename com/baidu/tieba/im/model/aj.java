package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.a.d {
    private int a;
    private int b;
    private com.baidu.tieba.im.message.ao c;

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private com.baidu.tieba.im.message.ao c() {
        com.baidu.tieba.im.message.ao aoVar = new com.baidu.tieba.im.message.ao();
        aoVar.a(this.a);
        aoVar.b(this.b);
        return aoVar;
    }

    public void a() {
        this.c = c();
        com.baidu.tieba.im.messageCenter.e.a().a(this.c);
    }

    public void b() {
        if (this.c != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.c);
            this.c = null;
        }
    }
}
