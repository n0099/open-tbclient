package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class bo extends com.baidu.adp.a.e {
    private int a;
    private int b;
    private com.baidu.tieba.im.message.aw c;

    public final void a(int i) {
        this.a = i;
    }

    public final void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a() {
        com.baidu.tieba.im.message.aw awVar = new com.baidu.tieba.im.message.aw();
        awVar.d(this.a);
        awVar.e(this.b);
        this.c = awVar;
        super.sendMessage(this.c);
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        super.cancelMessage();
        this.c = null;
    }
}
