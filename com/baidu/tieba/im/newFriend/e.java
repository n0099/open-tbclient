package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.a = newFriendDbManagerStatic;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.m.a().a(this.b);
        return null;
    }
}
