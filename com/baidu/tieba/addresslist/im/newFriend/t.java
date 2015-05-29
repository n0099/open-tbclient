package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ p azS;
    private final /* synthetic */ long azU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, long j) {
        this.azS = pVar;
        this.azU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.azU, "", "", "", ""));
    }
}
