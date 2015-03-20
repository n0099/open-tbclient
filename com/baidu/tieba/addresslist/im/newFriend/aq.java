package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tieba.im.g<Boolean> {
    private final /* synthetic */ com.baidu.tieba.im.data.b axV;
    final /* synthetic */ NewFriendsActivity ayz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.b bVar) {
        this.ayz = newFriendsActivity;
        this.axV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        bb bbVar;
        if (bool.booleanValue()) {
            bbVar = this.ayz.ays;
            bbVar.a(this.axV);
        }
    }
}
