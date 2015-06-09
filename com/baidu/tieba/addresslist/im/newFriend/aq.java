package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ NewFriendsActivity aAt;
    private final /* synthetic */ com.baidu.tieba.im.data.b azP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.aAt = newFriendsActivity;
        this.azP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        bb bbVar;
        if (bool.booleanValue()) {
            bbVar = this.aAt.aAm;
            bbVar.a(this.azP);
        }
    }
}
