package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic azO;
    private final /* synthetic */ com.baidu.tieba.im.data.b azP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.azO = newFriendDbManagerStatic;
        this.azP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        ba.FX().g(this.azP);
        return null;
    }
}
