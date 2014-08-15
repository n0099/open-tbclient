package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, long j) {
        this.a = pVar;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (0 != this.b) {
            com.baidu.tieba.im.db.m.a().a(this.b);
            com.baidu.tieba.im.db.o.c().e(String.valueOf(this.b));
        }
        return null;
    }
}
