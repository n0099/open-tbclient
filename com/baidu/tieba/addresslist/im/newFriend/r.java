package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long axX;
    final /* synthetic */ p axZ;
    private final /* synthetic */ RequestAddFriendMessage aya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
        this.axZ = pVar;
        this.axX = j;
        this.aya = requestAddFriendMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.axX, "", "", "", "");
        responseNewFriendUpdateUiMsg.setContent(this.aya.getMessage());
        MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
    }
}
