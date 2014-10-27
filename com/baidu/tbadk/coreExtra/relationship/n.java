package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                b bVar = new b();
                bVar.cE(responseNewFriendUpdateUiMsg.getKey());
                bVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                bVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                bVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                bVar.cD(responseNewFriendUpdateUiMsg.getPortrait());
                MessageManager.getInstance().sendMessage(new CustomMessage(2001183, bVar));
            } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                b bVar2 = new b();
                bVar2.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2001184, bVar2));
            }
        }
    }
}
