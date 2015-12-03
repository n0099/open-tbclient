package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ NewFriendsActivity aIX;
    private final /* synthetic */ com.baidu.tieba.im.data.b aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.aIX = newFriendsActivity;
        this.aIs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(aw.Hr().ai(this.aIs.getId()));
    }
}
