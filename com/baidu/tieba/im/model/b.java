package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.a.e {
    private com.baidu.tbadk.core.message.c a;
    private com.baidu.tbadk.core.message.d b;
    private int c = 2;

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public final void a() {
        this.a = new com.baidu.tbadk.core.message.c();
        this.a.d(10);
        super.sendMessage(this.a);
    }

    public final void a(long j) {
        this.b = new com.baidu.tbadk.core.message.d();
        this.b.e(1);
        this.b.d(10);
        this.b.a(String.valueOf(j));
        super.sendMessage(this.b);
    }

    public final void b(long j) {
        this.b = new com.baidu.tbadk.core.message.d();
        this.b.e(0);
        this.b.d(10);
        this.b.a(String.valueOf(j));
        super.sendMessage(this.b);
    }
}
