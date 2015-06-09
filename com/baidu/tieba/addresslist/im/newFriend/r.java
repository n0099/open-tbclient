package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long azR;
    final /* synthetic */ p azT;
    private final /* synthetic */ RequestAddFriendMessage azU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
        this.azT = pVar;
        this.azR = j;
        this.azU = requestAddFriendMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.azR, "", "", "", "");
        responseNewFriendUpdateUiMsg.setContent(this.azU.getMessage());
        MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
    }
}
