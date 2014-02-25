package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ long c;
    private final /* synthetic */ long d;
    private final /* synthetic */ com.baidu.tieba.im.message.bs e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, long j, long j2, com.baidu.tieba.im.message.bs bsVar) {
        this.a = qVar;
        this.c = j;
        this.d = j2;
        this.e = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.q.a().a(this.c, this.d, String.valueOf(this.e.b()), String.valueOf(this.e.a()), 3));
    }
}
