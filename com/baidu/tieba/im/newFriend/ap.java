package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ NewFriendsActivity blB;
    private final /* synthetic */ com.baidu.tieba.im.data.b blb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.blB = newFriendsActivity;
        this.blb = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        az azVar;
        if (bool.booleanValue()) {
            azVar = this.blB.blv;
            azVar.d(this.blb);
        }
    }
}
