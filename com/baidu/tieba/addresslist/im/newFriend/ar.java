package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    final /* synthetic */ NewFriendsActivity aAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(NewFriendsActivity newFriendsActivity, int i) {
        super(i);
        this.aAs = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                this.aAs.FS();
            } else {
                this.aAs.FU();
            }
        }
    }
}
