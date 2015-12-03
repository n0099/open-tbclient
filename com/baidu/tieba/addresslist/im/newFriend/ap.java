package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class ap extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NewFriendsActivity aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(NewFriendsActivity newFriendsActivity, int i) {
        super(i);
        this.aIX = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponsePassFriendMessage responsePassFriendMessage;
        int error;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
            this.aIX.showToast(n.i.neterror);
        } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
            this.aIX.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? this.aIX.getResources().getString(n.i.neterror) : responsePassFriendMessage.getErrorString());
        }
    }
}
