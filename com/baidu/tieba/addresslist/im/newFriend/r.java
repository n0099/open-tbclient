package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.util.d<Void> {
    private final /* synthetic */ long aIu;
    final /* synthetic */ p aIw;
    private final /* synthetic */ RequestAddFriendMessage aIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
        this.aIw = pVar;
        this.aIu = j;
        this.aIx = requestAddFriendMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.aIu, "", "", "", "");
        responseNewFriendUpdateUiMsg.setContent(this.aIx.getMessage());
        MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
    }
}
