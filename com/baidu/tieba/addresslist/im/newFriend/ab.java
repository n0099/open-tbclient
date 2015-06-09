package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long azV;
    final /* synthetic */ x azX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, long j) {
        this.azX = xVar;
        this.azV = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.azV, "", "", "", ""));
    }
}
