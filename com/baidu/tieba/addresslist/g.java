package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d agQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar) {
        super(2001178);
        this.agQ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.c.a aVar;
        com.baidu.tieba.addresslist.c.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            if (customResponsedMessage.getError() != 0) {
                this.agQ.showToast(customResponsedMessage.getErrorString());
                return;
            }
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                if (!StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) && !StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar.cF(responseNewFriendUpdateUiMsg.getKey());
                    bVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                    bVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                    bVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                    bVar.cE(responseNewFriendUpdateUiMsg.getPortrait());
                    aVar2 = this.agQ.agC;
                    aVar2.c(bVar);
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                aVar = this.agQ.agC;
                aVar.w(responseNewFriendUpdateUiMsg.getFriendId());
            }
        }
    }
}
