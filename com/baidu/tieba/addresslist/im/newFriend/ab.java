package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long ayj;
    final /* synthetic */ x ayl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, long j) {
        this.ayl = xVar;
        this.ayj = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.ayj, "", "", "", ""));
    }
}
