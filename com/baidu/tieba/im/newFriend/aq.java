package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class aq extends CustomMessageListener {
    final /* synthetic */ NewFriendsActivity bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(NewFriendsActivity newFriendsActivity, int i) {
        super(i);
        this.bhm = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                this.bhm.Rj();
            } else {
                this.bhm.Rl();
            }
        }
    }
}
