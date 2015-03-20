package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ NewFriendDbManagerStatic axU;
    private final /* synthetic */ long axX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.axU = newFriendDbManagerStatic;
        this.axX = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.axX, "", "", "", ""));
    }
}
