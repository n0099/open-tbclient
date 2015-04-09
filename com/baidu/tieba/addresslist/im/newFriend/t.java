package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ p ayh;
    private final /* synthetic */ long ayj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, long j) {
        this.ayh = pVar;
        this.ayj = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.ayj, "", "", "", ""));
    }
}
