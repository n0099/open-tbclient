package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ NewFriendsActivity aIX;
    private final /* synthetic */ com.baidu.tieba.im.data.b aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.aIX = newFriendsActivity;
        this.aIs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        ax axVar;
        if (bool.booleanValue()) {
            axVar = this.aIX.aIQ;
            axVar.a(this.aIs);
        }
    }
}
