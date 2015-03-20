package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ com.baidu.tieba.im.data.b axV;
    final /* synthetic */ NewFriendsActivity ayz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.ayz = newFriendsActivity;
        this.axV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(ba.EX().I(this.axV.getId()));
    }
}
