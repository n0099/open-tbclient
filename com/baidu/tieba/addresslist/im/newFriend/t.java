package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ p azT;
    private final /* synthetic */ long azV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, long j) {
        this.azT = pVar;
        this.azV = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.azV, "", "", "", ""));
    }
}
