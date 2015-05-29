package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic azN;
    private final /* synthetic */ com.baidu.tieba.im.data.b azO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.azN = newFriendDbManagerStatic;
        this.azO = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        ba.FW().g(this.azO);
        return null;
    }
}
