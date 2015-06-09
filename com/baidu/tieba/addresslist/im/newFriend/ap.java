package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ NewFriendsActivity aAt;
    private final /* synthetic */ com.baidu.tieba.im.data.b azP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.aAt = newFriendsActivity;
        this.azP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(ba.FX().H(this.azP.getId()));
    }
}
