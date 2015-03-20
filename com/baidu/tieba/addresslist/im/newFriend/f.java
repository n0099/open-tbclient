package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic axU;
    private final /* synthetic */ long axX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.axU = newFriendDbManagerStatic;
        this.axX = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        ba.EX().I(this.axX);
        return null;
    }
}
