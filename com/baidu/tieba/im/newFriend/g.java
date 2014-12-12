package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bjD;
    private final /* synthetic */ com.baidu.tieba.im.data.b bjE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.bjD = newFriendDbManagerStatic;
        this.bjE = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MI().b(this.bjE);
        return null;
    }
}
