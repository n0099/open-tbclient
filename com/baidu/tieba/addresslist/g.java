package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d agH;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar) {
        super(2001178);
        this.agH = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.c.a aVar;
        com.baidu.tieba.addresslist.c.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            if (customResponsedMessage.getError() != 0) {
                this.agH.showToast(customResponsedMessage.getErrorString());
                return;
            }
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                if (!StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) && !StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar.cE(responseNewFriendUpdateUiMsg.getKey());
                    bVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                    bVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                    bVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                    bVar.cD(responseNewFriendUpdateUiMsg.getPortrait());
                    aVar2 = this.agH.agu;
                    aVar2.c(bVar);
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                aVar = this.agH.agu;
                aVar.w(responseNewFriendUpdateUiMsg.getFriendId());
            }
        }
    }
}
