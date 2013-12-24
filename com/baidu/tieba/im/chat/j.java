package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.data.c a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, com.baidu.tieba.im.data.c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.b.b = true;
        }
        com.baidu.tieba.im.c.m.a().a(this.b.b);
        this.b.d(this.a);
    }
}
