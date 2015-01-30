package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long bjb;
    final /* synthetic */ o ble;
    private final /* synthetic */ RequestAddFriendMessage blf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
        this.ble = oVar;
        this.bjb = j;
        this.blf = requestAddFriendMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.bjb, "", "", "", "");
        responseNewFriendUpdateUiMsg.setContent(this.blf.getMessage());
        MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
    }
}
