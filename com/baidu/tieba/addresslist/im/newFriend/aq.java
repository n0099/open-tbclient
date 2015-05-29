package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ NewFriendsActivity aAs;
    private final /* synthetic */ com.baidu.tieba.im.data.b azO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.aAs = newFriendsActivity;
        this.azO = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        bb bbVar;
        if (bool.booleanValue()) {
            bbVar = this.aAs.aAl;
            bbVar.a(this.azO);
        }
    }
}
