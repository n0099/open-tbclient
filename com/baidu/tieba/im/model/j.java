package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.a.e {
    private int a;
    private com.baidu.tieba.im.message.ae b;

    public final int a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(long j) {
        com.baidu.tieba.im.message.ae aeVar = new com.baidu.tieba.im.message.ae();
        aeVar.b(j);
        this.b = aeVar;
        super.sendMessage(this.b);
    }

    @Override // com.baidu.adp.a.e
    public final void registerListener(com.baidu.adp.framework.c.c<?> cVar) {
        super.registerListener(106101, cVar);
    }
}
