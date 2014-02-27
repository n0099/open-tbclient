package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ba;
/* loaded from: classes.dex */
public final class al extends com.baidu.adp.a.d {
    private int a;
    private int b;
    private ba c;

    public final void a(int i) {
        this.a = i;
    }

    public final void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a() {
        ba baVar = new ba();
        baVar.a(this.a);
        baVar.b(this.b);
        this.c = baVar;
        com.baidu.tieba.im.messageCenter.d.a().a(this.c);
    }

    public final void b() {
        if (this.c != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.c);
            this.c = null;
        }
    }
}
