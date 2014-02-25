package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
class o extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ m a;
    private final /* synthetic */ com.baidu.tieba.im.message.w c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, com.baidu.tieba.im.message.w wVar) {
        this.a = mVar;
        this.c = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.q.a().a(this.c.m(), this.c.c(), String.valueOf(this.c.j()), String.valueOf(this.c.l()), 2));
    }
}
