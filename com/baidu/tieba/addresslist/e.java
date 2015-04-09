package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ AddressListActivity axz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AddressListActivity addressListActivity) {
        super(2001178);
        this.axz = addressListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.c.a aVar;
        com.baidu.tieba.addresslist.c.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            if (customResponsedMessage.getError() != 0) {
                this.axz.showToast(customResponsedMessage.getErrorString());
                return;
            }
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                if (!StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) && !StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.dJ(responseNewFriendUpdateUiMsg.getKey());
                    aVar3.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                    aVar3.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                    aVar3.setUserName(responseNewFriendUpdateUiMsg.getName());
                    aVar3.dI(responseNewFriendUpdateUiMsg.getPortrait());
                    aVar2 = this.axz.axl;
                    aVar2.a(aVar3);
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                aVar = this.axz.axl;
                aVar.G(responseNewFriendUpdateUiMsg.getFriendId());
            }
        }
    }
}
