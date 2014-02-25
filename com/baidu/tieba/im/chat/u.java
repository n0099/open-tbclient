package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.w c;
    private final /* synthetic */ com.baidu.tieba.im.message.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, com.baidu.tieba.im.message.w wVar, com.baidu.tieba.im.message.b bVar) {
        this.a = qVar;
        this.c = wVar;
        this.d = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.q.a().a(this.c.m(), this.c.c(), String.valueOf(this.d.j()), String.valueOf(this.d.l()), 2));
    }
}
