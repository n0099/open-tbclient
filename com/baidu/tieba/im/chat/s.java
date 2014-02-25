package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.g c;
    private final /* synthetic */ com.baidu.tieba.im.message.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, com.baidu.tieba.im.message.g gVar, com.baidu.tieba.im.message.b bVar) {
        this.a = qVar;
        this.c = gVar;
        this.d = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().b(this.c.u(), String.valueOf(this.d.j()), String.valueOf(this.d.l()), 2));
    }
}
