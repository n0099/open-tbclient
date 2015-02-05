package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bkZ;
    private final /* synthetic */ com.baidu.tieba.im.data.b bla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.bkZ = newFriendDbManagerStatic;
        this.bla = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MZ().b(this.bla);
        return null;
    }
}
