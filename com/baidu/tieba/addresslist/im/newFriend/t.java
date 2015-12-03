package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ p aIw;
    private final /* synthetic */ long aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, long j) {
        this.aIw = pVar;
        this.aIy = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.aIy, "", "", "", ""));
    }
}
