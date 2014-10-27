package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ NewFriendsActivity bgY;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.e eVar) {
        this.bgY = newFriendsActivity;
        this.bgy = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        az azVar;
        if (bool.booleanValue()) {
            azVar = this.bgY.bgS;
            azVar.c(this.bgy);
        }
    }
}
