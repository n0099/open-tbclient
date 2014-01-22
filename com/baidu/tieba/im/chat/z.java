package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.data.c a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(q qVar, com.baidu.tieba.im.data.c cVar) {
        this.b = qVar;
        this.a = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.c.m.a().a(bool.booleanValue());
        this.b.d(this.a);
    }
}
