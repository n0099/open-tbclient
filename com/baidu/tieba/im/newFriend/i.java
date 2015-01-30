package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bla;
    private final /* synthetic */ com.baidu.tieba.im.data.b blb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.bla = newFriendDbManagerStatic;
        this.blb = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.Ne().b(this.blb);
        return null;
    }
}
