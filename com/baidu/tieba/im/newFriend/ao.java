package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ com.baidu.tieba.im.data.b bjE;
    final /* synthetic */ NewFriendsActivity bke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.bke = newFriendsActivity;
        this.bjE = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.MI().V(this.bjE.getId()));
    }
}
