package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* loaded from: classes.dex */
class as extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NewFriendsActivity aAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(NewFriendsActivity newFriendsActivity, int i) {
        super(i);
        this.aAs = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ResponsePassFriendMessage responsePassFriendMessage;
        int error;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
            this.aAs.showToast(com.baidu.tieba.t.neterror);
        } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
            this.aAs.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? this.aAs.getResources().getString(com.baidu.tieba.t.neterror) : responsePassFriendMessage.getErrorString());
        }
    }
}
