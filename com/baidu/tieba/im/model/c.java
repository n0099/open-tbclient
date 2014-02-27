package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class c extends com.baidu.adp.a.d {
    private int a;
    private com.baidu.tieba.im.message.ak b;

    public final int a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(long j) {
        com.baidu.tieba.im.message.ak akVar = new com.baidu.tieba.im.message.ak();
        akVar.a(j);
        this.b = akVar;
        com.baidu.tieba.im.messageCenter.d.a().a(this.b);
    }

    public final void b() {
        com.baidu.tieba.im.messageCenter.d.a().b(this.b);
    }

    public static void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.d.a().a(106101, gVar);
    }
}
