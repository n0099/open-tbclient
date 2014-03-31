package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class bn extends com.baidu.adp.a.e {
    private int a;
    private int b;
    private com.baidu.tieba.im.message.ax c;

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
        com.baidu.tieba.im.message.ax axVar = new com.baidu.tieba.im.message.ax();
        axVar.d(this.a);
        axVar.e(this.b);
        this.c = axVar;
        super.sendMessage(this.c);
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        super.cancelMessage();
        this.c = null;
    }
}
