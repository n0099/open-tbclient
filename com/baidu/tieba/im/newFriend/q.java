package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.g<Void> {
    private final /* synthetic */ long bhG;
    final /* synthetic */ o bjH;
    private final /* synthetic */ RequestAddFriendMessage bjI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
        this.bjH = oVar;
        this.bhG = j;
        this.bjI = requestAddFriendMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.bhG, "", "", "", "");
        responseNewFriendUpdateUiMsg.setContent(this.bjI.getMessage());
        MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
    }
}
