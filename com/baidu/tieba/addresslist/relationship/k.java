package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                aVar.ew(responseNewFriendUpdateUiMsg.getKey());
                aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                aVar.ev(responseNewFriendUpdateUiMsg.getPortrait());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_INSERT_CONTACT, aVar));
            } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                aVar2.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_CONTACT, aVar2));
            }
        }
    }
}
