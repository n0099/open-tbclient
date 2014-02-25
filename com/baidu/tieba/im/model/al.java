package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ba;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.a.d {
    private int a;
    private int b;
    private ba c;

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

    private ba c() {
        ba baVar = new ba();
        baVar.a(this.a);
        baVar.b(this.b);
        return baVar;
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
