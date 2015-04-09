package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic ayc;
    private final /* synthetic */ com.baidu.tieba.im.data.b ayd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar) {
        this.ayc = newFriendDbManagerStatic;
        this.ayd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        ba.Fd().g(this.ayd);
        return null;
    }
}
