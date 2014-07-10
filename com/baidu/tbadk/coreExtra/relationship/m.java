package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                b bVar = new b();
                bVar.d(responseNewFriendUpdateUiMsg.getKey());
                bVar.c(responseNewFriendUpdateUiMsg.getQuanping());
                bVar.a(responseNewFriendUpdateUiMsg.getFriendId());
                bVar.a(responseNewFriendUpdateUiMsg.getName());
                bVar.b(responseNewFriendUpdateUiMsg.getPortrait());
                MessageManager.getInstance().sendMessage(new CustomMessage(2001183, bVar));
            } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                b bVar2 = new b();
                bVar2.a(responseNewFriendUpdateUiMsg.getFriendId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2001184, bVar2));
            }
        }
    }
}
