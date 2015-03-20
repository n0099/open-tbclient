package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic axU;
    private final /* synthetic */ com.baidu.tieba.im.data.b axV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.axU = newFriendDbManagerStatic;
        this.axV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        ba.EX().g(this.axV);
        return null;
    }
}
