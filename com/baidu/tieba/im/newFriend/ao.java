package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ao extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ com.baidu.tieba.im.data.e bgM;
    final /* synthetic */ NewFriendsActivity bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.e eVar) {
        this.bhm = newFriendsActivity;
        this.bgM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.MO().O(this.bgM.getId()));
    }
}
