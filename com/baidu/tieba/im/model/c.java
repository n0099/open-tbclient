package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.d {
    private int a;
    private com.baidu.tieba.im.message.ak b;

    public int a() {
        return this.a;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private com.baidu.tieba.im.message.ak b(long j) {
        com.baidu.tieba.im.message.ak akVar = new com.baidu.tieba.im.message.ak();
        akVar.a(j);
        return akVar;
    }

    public void a(long j) {
        this.b = b(j);
        com.baidu.tieba.im.messageCenter.e.a().a(this.b);
    }

    public void b() {
        com.baidu.tieba.im.messageCenter.e.a().b(this.b);
    }

    public void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(106101, gVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
    }
}
