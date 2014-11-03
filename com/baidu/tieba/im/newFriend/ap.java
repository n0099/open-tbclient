package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ com.baidu.tieba.im.data.e bgM;
    final /* synthetic */ NewFriendsActivity bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.e eVar) {
        this.bhm = newFriendsActivity;
        this.bgM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        az azVar;
        if (bool.booleanValue()) {
            azVar = this.bhm.bhg;
            azVar.c(this.bgM);
        }
    }
}
